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
import java.util.ArrayList;

import org.apache.tools.ant.DirectoryScanner;

import com.google.protobuf.ByteString;

import config.ServerConfiguration;
import entities.ChunkInfo;
import entities.FileInfo;
import entities.FileInfo.Builder;
import entities.LocalSearchRequest;
import entities.Message;
import entities.Message.Type;
import entities.Status;
import entities.UploadRequest;
import entities.UploadResponse;

public class ClientThread extends Thread {
	private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        try {
            Message msg = Message.parseFrom(clientSocket.getInputStream());
            System.out.println("IN run");
            if (msg.hasLocalSearchRequest()) {
            	processLocalSearchRequest(msg.getLocalSearchRequest());
            }
            if (msg.hasUploadRequest()) {
            	processUploadRequest(msg.getUploadRequest());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public void processLocalSearchRequest(LocalSearchRequest lsr) {
    	DirectoryScanner scanner = new DirectoryScanner();
    	scanner.setIncludes(new String[]{lsr.getRegex()});
    	scanner.setBasedir("uploads");
    	scanner.setCaseSensitive(false);
    	scanner.scan();
    	String[] files = scanner.getIncludedFiles();

    	for (String file : files) {
    		FileInfo fi = computeFileInfo(file); 
    	}
    }
    
    private FileInfo computeFileInfo(String filename) {
    	int index = 0;
    	Builder fi = FileInfo.newBuilder();
    	ChunkInfo ci = computeChunk(filename); 
    	while (ci != null) {
    		fi.setChunks(index, ci);    		
    	}
    	return null;
	}
    
    private ChunkInfo computeChunk(String filename) {
    	ChunkInfo ci = null;
    	try {
    	    File file = new File(filename);
    	    FileInputStream is = new FileInputStream(file);
    	    byte[] chunk = new byte[ServerConfiguration.DATA_CHUNK_SIZE];
    	    int chunkLen = 0;
    	    
    	    if ((chunkLen = is.read(chunk)) != -1) {
    	        ci = ChunkInfo.newBuilder()
    	        		.setHash(ByteString.copyFrom(chunk))
    	        		.setSize(chunkLen)
    	        		.build();
    	    }
    	} catch (FileNotFoundException fnfE) {
    	    // file not found, handle case
    	} catch (IOException ioE) {
    	    // problem reading, handle case
    	}
    	return ci;
    }
    
    public void processUploadRequest(UploadRequest ur) throws FileNotFoundException, IOException {
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
//		   m.writeTo(clientSocket.getOutputStream());
		}
    	System.out.println(filename);
    }
}

