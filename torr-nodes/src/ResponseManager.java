import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tools.ant.DirectoryScanner;

import com.google.protobuf.ByteString;

import config.ServerConfiguration;
import entities.ChunkInfo;
import entities.FileInfo;
import entities.FileInfo.Builder;
import entities.LocalSearchRequest;
import entities.LocalSearchResponse;
import entities.LocalSearchResponseOrBuilder;
import entities.Message;
import entities.Message.Type;
import entities.Status;
import entities.UploadRequest;
import entities.UploadResponse;

public class ResponseManager {
	private Socket clientSocket;
	private Message msg;

    public ResponseManager(Message msg) {
    	this.msg = msg;
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
            	System.out.println("//TODO");
            }
            if (msg.hasDownloadRequest()) {
            	System.out.println("//TODO");
            }
            if (msg.hasReplicateRequest()) {
            	System.out.println("//TODO");
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
    	DirectoryScanner scanner = new DirectoryScanner();
    	scanner.setIncludes(new String[]{lsr.getRegex()});
    	scanner.setBasedir("uploads");
    	scanner.setCaseSensitive(false);
    	scanner.scan();
    	String[] files = scanner.getIncludedFiles();
    	LocalSearchResponse.Builder b = LocalSearchResponse.newBuilder();
    	
    	if (files.length > 0) {
    		for (int i = 0; i < files.length; i++) {
        		FileInfo fi = computeFileInfo(files[i]);
        		b.setFileInfo(i, fi);
        	}
    	}
    	b.setStatus(Status.SUCCESS);
    	Message m = Message.newBuilder()
    			.setType(Type.LOCAL_SEARCH_RESPONSE)
    			.setLocalSearchResponse(b.build())
    			.build();
    	return m;
    }
    
    private FileInfo computeFileInfo(String filename) throws IOException {
    	int index = 0;
    	FileInfo.Builder fi = FileInfo.newBuilder();
    	ChunkInfo ci = computeChunk(filename, index); 
    	while (ci != null) {
    		fi.setChunks(index, ci);    		
    		index += 1;
    	}
    	Path fileLocation = Paths.get(filename);
    	byte[] data = Files.readAllBytes(fileLocation);
    	fi.setHash(ByteString.copyFrom(DigestUtils.md5(data)));
    	fi.setSize(data.length);
    	fi.setFilename(filename);
    	return fi.build();
	}
    
    private ChunkInfo computeChunk(String filename, int page) {
    	ChunkInfo ci = null;
    	try {
    	    File file = new File(filename);
    	    FileInputStream is = new FileInputStream(file);
    	    byte[] chunk = new byte[ServerConfiguration.DATA_CHUNK_SIZE];
    	    int chunkLen;
    	    
    	    if ((chunkLen = is.read(chunk, page * ServerConfiguration.DATA_CHUNK_SIZE, ServerConfiguration.DATA_CHUNK_SIZE)) != -1) {
    	        ci = ChunkInfo.newBuilder()
    	        		.setHash(ByteString.copyFrom(chunk))
    	        		.setSize(chunkLen)
    	        		.build();
    	    }
    	} catch (FileNotFoundException fnfE) {
    	    fnfE.printStackTrace();
    	} catch (IOException ioE) {
    	    ioE.printStackTrace();
    	}
    	return ci;
    }
    
    public Message processUploadRequest(UploadRequest ur) throws FileNotFoundException, IOException {
    	System.out.println("IN process upload");
    	String filename = ur.getFilename();
    	byte[] data = ur.getData().toByteArray();
    	try (FileOutputStream fos = new FileOutputStream("uploads/" + filename)) {
		   fos.write(data);
		   fos.close();
		   FileInfo fi = FileInfo.newBuilder()
				   .setFilename(filename)
				   .setSize(data.length)
				   .build();
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
    }
}

