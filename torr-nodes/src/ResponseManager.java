import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import com.google.protobuf.ByteString;
import config.ServerConfiguration;
import entities.ChunkInfo;
import entities.ChunkRequest;
import entities.ChunkResponse;
import entities.FileInfo;
import entities.LocalSearchRequest;
import entities.LocalSearchResponse;
import entities.Message;
import entities.Message.Type;
import entities.Node;
import entities.NodeReplicationStatus;
import entities.ReplicateRequest;
import entities.ReplicateResponse;
import entities.Status;
import entities.UploadRequest;
import entities.UploadResponse;

public class ResponseManager {
	private Message msg;
	private Node node;

    public ResponseManager(Message msg, Node n) {
    	this.msg = msg;
    	this.node = n;
    }
    
    public Message process() {
    	Message result = null;
        try {
            System.out.println("In run");
            if (msg.hasLocalSearchRequest()) {
            	result = processLocalSearchRequest(msg.getLocalSearchRequest());
            }
            if (msg.hasUploadRequest()) {
            	result = processUploadRequest(msg.getUploadRequest());
            }
            if (msg.hasChunkRequest()) {
            	result = processChunkRequest(msg.getChunkRequest());
            }
            if (msg.hasDownloadRequest()) {
            	System.out.println("//TODO");
            }
            if (msg.hasReplicateRequest()) {
            	result = processReplicateRequest(msg.getReplicateRequest());
            }
            if (msg.hasSearchRequest()) {
            	System.out.println("//TODO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
    }
    
    public Message processLocalSearchRequest(LocalSearchRequest lsr) throws IOException {
    	String fileRegex = lsr.getRegex();
    	String filename;
    	int index = 0;
    	LocalSearchResponse.Builder builder = LocalSearchResponse.newBuilder();
    	List<FileInfo> files = ResourceManager.getFileInfos();
    	
    	for (FileInfo fi : files) {
    		filename = fi.getFilename();
    		if (filename.matches(fileRegex)) {
    			builder.setFileInfo(index, fi);
    			index += 1;
    		}
    	}
    	
    	builder.setStatus(Status.SUCCESS);
    	Message m = Message.newBuilder()
    			.setType(Type.LOCAL_SEARCH_RESPONSE)
    			.setLocalSearchResponse(builder.build())
    			.build();
    	return m;
    }
    
    private FileInfo computeFileInfo(byte[] data, String filename) {
    	int index = 0;
    	FileInfo.Builder builder = FileInfo.newBuilder();
    	FileInfo fi;
    	ChunkInfo ci;
    	int len = data.length;
    	byte[] chunk;
    	
    	for (int i = 0; i < len - ServerConfiguration.DATA_CHUNK_SIZE + 1; i += ServerConfiguration.DATA_CHUNK_SIZE) {
    	    chunk = Arrays.copyOfRange(data, i, i + ServerConfiguration.DATA_CHUNK_SIZE);
    	    ci = ChunkInfo.newBuilder()
    	    		.setIndex(index)
	        		.setSize(ServerConfiguration.DATA_CHUNK_SIZE)
	        		.setHash(ByteString.copyFrom(DigestUtils.md5(chunk)))
	        		.build();
    	    ResourceManager.addChunk(ci);
    	    builder.addChunks(index, ci);
    	    index += 1;
    	}

    	if (len % ServerConfiguration.DATA_CHUNK_SIZE != 0) {
    	    chunk = Arrays.copyOfRange(data, len - len % (ServerConfiguration.DATA_CHUNK_SIZE), len);
    	    ci = ChunkInfo.newBuilder()
    	    		.setIndex(index)
	        		.setSize(chunk.length)
	        		.setHash(ByteString.copyFrom(DigestUtils.md5(chunk)))
	        		.build();
    	    ResourceManager.addChunk(ci);
    	    builder.addChunks(index, ci);
    	}
    	
    	String fileHash = DigestUtils.md5(data).toString();
    	builder.setHash(ByteString.copyFrom(DigestUtils.md5(data)));
    	builder.setSize(data.length);
    	builder.setFilename(filename);
    	fi = builder.build();
    	ResourceManager.addFileInfo(fi);
    	ResourceManager.addFile(fileHash, data);
    	return fi;
	}

    public Message processUploadRequest(UploadRequest ur) {
    	System.out.println("IN process upload");
    	String filename = ur.getFilename();
    	byte[] data = ur.getData().toByteArray();
    	
    	FileInfo fi = computeFileInfo(data, filename);
		UploadResponse uploadResponse = UploadResponse.newBuilder()
		   .setStatus(Status.SUCCESS)
		   .setFileInfo(fi)
		   .build();
		Message m = Message.newBuilder()
		   .setType(Type.UPLOAD_RESPONSE)
		   .setUploadResponse(uploadResponse)
		   .build();
		System.out.println(filename);
		return m;
	}
    
    public Message processReplicateRequest(ReplicateRequest rr) {
    	System.out.println("IN process replicate");
    	ReplicateResponse.Builder builder = ReplicateResponse.newBuilder();
    	NodeReplicationStatus nrs;
    	List<FileInfo> files = ResourceManager.getFileInfos();
    	String rrHash = rr.getFileInfo().getHash().toString();
    	boolean found = false;
    	int index = 0;
    	for (FileInfo fi : files) {
    		if (fi.getHash().toString().equals(rrHash)) {
    			found = true;
    			List<ChunkInfo> chunks = fi.getChunksList();
    			for (ChunkInfo ci : chunks) {
    				nrs = NodeReplicationStatus.newBuilder()
    						.setNode(this.node)
    						.setChunkIndex(ci.getIndex())
    						.setStatus(Status.SUCCESS)
    						.build();
    				builder.addNodeStatusList(index, nrs);
    				index += 1;
    			}
    			builder.setStatus(Status.SUCCESS);
    		}
    		if (found) break;
    	}
    	
    	//Query other nodes for file
    	if (!found) {
    		 
    	}
    	
    	return null;
    }
    
    public Message processChunkRequest(ChunkRequest cr) {
    	String crHash = cr.getFileHash().toString();
    	ChunkResponse.Builder builder = ChunkResponse.newBuilder();
    	
    	if ((crHash.length() != 16) || (cr.getChunkIndex() < 0)) {
    		builder.setStatus(Status.MESSAGE_ERROR);
    	} else if (ResourceManager.getFiles().containsKey(crHash)) {
    		byte[] fileData = ResourceManager.getFiles().get(crHash);
    		byte[] chunkData;
    		//if we have a full page to copy
    		if ((cr.getChunkIndex() + 1) * ServerConfiguration.DATA_CHUNK_SIZE <= fileData.length) {
    			chunkData = Arrays.copyOfRange(fileData, cr.getChunkIndex() * ServerConfiguration.DATA_CHUNK_SIZE, (cr.getChunkIndex() + 1) * ServerConfiguration.DATA_CHUNK_SIZE);
    		} else {
    			chunkData = Arrays.copyOfRange(fileData, cr.getChunkIndex() * ServerConfiguration.DATA_CHUNK_SIZE, fileData.length);
    		}
    		builder.setData(ByteString.copyFrom(chunkData));
    		builder.setStatus(Status.SUCCESS);
    	} else {
    		builder.setStatus(Status.UNABLE_TO_COMPLETE);
    	}
    	return Message.newBuilder()
    			.setType(Type.CHUNK_RESPONSE)
    			.setChunkResponse(builder.build())
    			.build();
    }
}


