import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.protobuf.ByteString;

import config.ServerConfiguration;
import entities.Node;
import entities.UploadRequest;
import entities.Message;

public class NodeBL {
    private ServerSocket listeningSocket;
    private volatile boolean run = true;
    
    public NodeBL(int socketPort) throws IOException {
    	addShutdownHook();
        listenForRequests(socketPort);
    }
    
    private void listenForRequests(final int selfPort) {
        new Thread() {
            @Override
            public void run() {
                try {
                    listeningSocket = new ServerSocket(selfPort);
                    while (run) {
                        Socket acceptedConnection = listeningSocket.accept();
                        // create thread to deal with client
                        ClientThread ct = new ClientThread(acceptedConnection);
                        ct.start();
                        //ct.join();
                        //Message response = Message.parseFrom(acceptedConnection.getInputStream());
                        //System.out.println("here" + response.getUploadResponse().getFileInfo().getFilename());
                        //acceptedConnection.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    
    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                run = false;
                try {
                    if (listeningSocket != null) listeningSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
	public static void main(String[] args) throws UnknownHostException, IOException {
		Node n = Node.newBuilder().setHost("127.0.0").setPort(5000).build(); 
		System.out.println("Node: " + n.getHost() + n.getPort());
		
		byte[] data = Files.readAllBytes(new File("test.txt").toPath());
		
		UploadRequest ur = UploadRequest.newBuilder()
				.setFilename("test.txt")
				.setData(ByteString.copyFrom(data)).build();
		Message msg = Message.newBuilder()
                 .setType(Message.Type.UPLOAD_REQUEST)
                 .setUploadRequest(ur)
                 .build();
		
		new NodeBL(ServerConfiguration.PORT_BASE);
		
		Socket socket = new Socket(ServerConfiguration.HOST + '1', ServerConfiguration.PORT_BASE);
		msg.writeTo(socket.getOutputStream());
		socket.close();
	}
}
