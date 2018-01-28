package main.java;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import com.google.protobuf.ByteString;
import main.java.config.ServerConfiguration;
import main.java.entities.ChunkInfo;
import main.java.entities.ChunkRequest;
import main.java.entities.ChunkResponse;
import main.java.entities.DownloadRequest;
import main.java.entities.DownloadResponse;
import main.java.entities.FileInfo;
import main.java.entities.LocalSearchRequest;
import main.java.entities.LocalSearchResponse;
import main.java.entities.Message;
import main.java.entities.Message.Type;
import main.java.entities.Node;
import main.java.entities.NodeReplicationStatus;
import main.java.entities.NodeSearchResult;
import main.java.entities.ReplicateRequest;
import main.java.entities.ReplicateResponse;
import main.java.entities.SearchRequest;
import main.java.entities.SearchResponse;
import main.java.entities.Status;
import main.java.entities.UploadRequest;
import main.java.entities.UploadResponse;

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
            	result = processDownloadRequest(msg.getDownloadRequest());
            }
            if (msg.hasReplicateRequest()) {
            	result = processReplicateRequest(msg.getReplicateRequest());
            }
            if (msg.hasSearchRequest()) {
            	result = processSearchRequest(msg.getSearchRequest());
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
    			builder.addFileInfo(index, fi);
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

    	builder.setHash(ByteString.copyFrom(DigestUtils.md5(data)));
    	builder.setSize(data.length);
    	builder.setFilename(filename);
    	fi = builder.build();
    	ResourceManager.addFileInfo(fi);
    	ResourceManager.addFile(data);
    	return fi;
	}

    public Message processUploadRequest(UploadRequest ur) {
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
    	ReplicateResponse.Builder builder = ReplicateResponse.newBuilder();
    	NodeReplicationStatus nrs;
    	List<FileInfo> files = ResourceManager.getFileInfos();
    	boolean found = false;
    	int index = 0;
    	for (FileInfo fi : files) {
    		if (fi.getHash().equals(rr.getFileInfo().getHash())) {
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
    	
    	byte[] fileData = new byte[] {};
    	//Query other nodes for file
    	if (!found) {
           Node node;
           String othersIp;
           int othersPort;
           byte[] requestData;
    	   int[] ipSuffixes  = ServerConfiguration.IP_SUFFIXES;
           int[] hostOffsets = ServerConfiguration.HOST_OFFSETS;
           List<ChunkInfo> chunks = rr.getFileInfo().getChunksList();
           boolean foundChunk;

           for (ChunkInfo ci : chunks) {
                ChunkRequest chr = ChunkRequest.newBuilder()
                    .setFileHash(rr.getFileInfo().getHash())
                    .setChunkIndex(ci.getIndex())
                    .build();
                Message m = Message.newBuilder()
                    .setType(Type.CHUNK_REQUEST)
                    .setChunkRequest(chr)
                    .build();
                requestData = m.toByteArray();
                foundChunk = false;

                for (int is : ipSuffixes) {
                    for (int ho : hostOffsets) {
                        othersIp = ServerConfiguration.HOST + is;
                        othersPort = ServerConfiguration.PORT_BASE + ho;
                        if (this.node.getHost().equals(othersIp) && (this.node.getPort() == othersPort)) {
                        	continue;
                        }
                    	node = Node.newBuilder()
                                .setHost(othersIp)
                                .setPort(othersPort)
                                .build();
                        try {
                        	Socket nodeConnection;
                        	DataOutputStream dout;
                        	
                            nodeConnection = new Socket(InetAddress.getByName(ServerConfiguration.HOST + is), ServerConfiguration.PORT_BASE + ho);
                            dout = new DataOutputStream(nodeConnection.getOutputStream());
                            dout.writeInt(requestData.length);
                            dout.write(requestData);

                            DataInputStream din = new DataInputStream(nodeConnection.getInputStream());
                            int len = din.readInt();
                            byte[] data = new byte[len];
                            din.readFully(data);
                            Message res = Message.parseFrom(data);
                            ChunkResponse cres = res.getChunkResponse();
                            din.close();
                            dout.flush();  
                            nodeConnection.close();

                            //Found chunk
                            if (cres.getStatus().equals(Status.SUCCESS)) {
                                nrs = NodeReplicationStatus.newBuilder()
                                    .setNode(node)
                                    .setChunkIndex(ci.getIndex())
                                    .setStatus(Status.SUCCESS)
                                    .build();
                                builder.addNodeStatusList(index, nrs);
                                index += 1;
                                foundChunk = true;
                                byte[] cresData = cres.getData().toByteArray();
                                byte[] destination = new byte[fileData.length + cresData.length];
                                System.arraycopy(fileData, 0, destination, 0, fileData.length);
                                System.arraycopy(cresData, 0, destination, fileData.length, cresData.length);
                                fileData = destination;
                            }
                            if (foundChunk) break;
                        }
                        catch (IOException e) {
                        	System.out.println("can not connect to " +node);
                            nrs = NodeReplicationStatus.newBuilder()
                                .setNode(node)
                                .setStatus(Status.NETWORK_ERROR)
                                .build();
                            builder.addNodeStatusList(index, nrs);
                            index += 1;
                        }
                    }
                    if (foundChunk) {
                        break;
                    }
                }
            }
    	}
    	
    	if (fileData.length > 0) {
    		ResourceManager.addFile(fileData);
    		ResourceManager.addFileInfo(rr.getFileInfo());
    	}
    	builder.setStatus(Status.SUCCESS);
    	return Message.newBuilder()
            .setType(Type.REPLICATE_RESPONSE)
            .setReplicateResponse(builder.build())
            .build();
    }

    public Message processChunkRequest(ChunkRequest cr) {
    	ChunkResponse.Builder builder = ChunkResponse.newBuilder();
        byte[] fileData = this.findFileDataByHash(cr.getFileHash());
    	if ((cr.getChunkIndex() < 0)) {
    		builder.setStatus(Status.MESSAGE_ERROR);
    	} else if (fileData != null) {
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
    
    private byte[] findFileDataByHash(ByteString hash) {
    	List<byte[]> files = ResourceManager.getFiles();
    	for (byte[] f : files) {
    		ByteString bh = ByteString.copyFrom(DigestUtils.md5(f));
    		if (bh.toStringUtf8().equals(hash.toStringUtf8())) {
    			return f;
    		}
    	}
    	return null;
    }

    public Message processSearchRequest(SearchRequest sr) throws IOException {
        Message response;
        int index = 0;
        SearchResponse.Builder builder = SearchResponse.newBuilder();
        Socket nodeConnection;
        Node node;
        DataOutputStream dout;
        byte[] requestData;
        int[] ipSuffixes  = ServerConfiguration.IP_SUFFIXES;
        int[] hostOffsets = ServerConfiguration.HOST_OFFSETS;
        LocalSearchRequest lsr = LocalSearchRequest.newBuilder()
            .setRegex(sr.getRegex())
            .build();
        Message m = Message.newBuilder()
            .setType(Type.LOCAL_SEARCH_REQUEST)
            .setLocalSearchRequest(lsr)
            .build();
        requestData = m.toByteArray();
        NodeSearchResult nsr;
        boolean othersResponded = false;

        for (int is : ipSuffixes) {
            for (int ho : hostOffsets) {
                try {
                    nodeConnection = new Socket(InetAddress.getByName(ServerConfiguration.HOST + is), ServerConfiguration.PORT_BASE + ho);
                    dout = new DataOutputStream(nodeConnection.getOutputStream());
                    dout.writeInt(requestData.length);
                    dout.write(requestData);

                    DataInputStream din = new DataInputStream(nodeConnection.getInputStream());
                    int len = din.readInt();
                    byte[] data = new byte[len];
                    din.readFully(data);
                    dout.flush();
                    din.close();                    
                    nodeConnection.close();
                    Message res = Message.parseFrom(data);
                    LocalSearchResponse lsres = res.getLocalSearchResponse();
                    node = Node.newBuilder()
                        .setHost(ServerConfiguration.HOST + is)
                        .setPort(ServerConfiguration.PORT_BASE + ho)
                        .build();
                    NodeSearchResult.Builder nsrb = NodeSearchResult.newBuilder();
                    nsrb.setNode(node)
                    	.addAllFiles(lsres.getFileInfoList())
                    	.setStatus(lsres.getStatus());
                    nsr = nsrb.build();
                    builder.addResults(index, nsr);
                    index += 1;
                    othersResponded = true;
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        if (!othersResponded) {
            response = processLocalSearchRequest(lsr);
            NodeSearchResult.Builder nsrb = NodeSearchResult.newBuilder();
            nsrb.setNode(this.node)
            	.addAllFiles(response.getLocalSearchResponse().getFileInfoList())
            	.setStatus(response.getLocalSearchResponse().getStatus());
            nsr = nsrb.build();
            builder.addResults(index, nsr);
        }
        return Message.newBuilder()
        		.setType(Type.SEARCH_RESPONSE)
        		.setSearchResponse(builder.build())
        		.build();
    }

    public Message processDownloadRequest(DownloadRequest dr) {
        String drHash = dr.getFileHash().toString();
        DownloadResponse dres = null;
        byte[] fileData = this.findFileDataByHash(dr.getFileHash());
        if (drHash.length() < 16) {
        	dres = DownloadResponse.newBuilder()
                    .setStatus(Status.MESSAGE_ERROR)
                    .build();
            
        } else if (fileData != null) {
            dres = DownloadResponse.newBuilder()
	                .setStatus(Status.SUCCESS)
	                .setData(ByteString.copyFrom(fileData))
	                .build();            
        } else {
        	dres = DownloadResponse.newBuilder()
                    .setStatus(Status.UNABLE_TO_COMPLETE)
                    .build();            
        }
        
        if (dres == null) {
        	dres = DownloadResponse.newBuilder()
                    .setStatus(Status.PROCESSING_ERROR)
                    .build();
        }
        
        return Message.newBuilder()
                .setType(Type.DOWNLOAD_RESPONSE)
                .setDownloadResponse(dres)
                .build();
    }
}


