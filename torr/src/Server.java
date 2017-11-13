import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import config.ServerConfiguration;
import entities.Node;

public class Server {
    private ServerSocket listeningSocket;
    private volatile boolean run = true;
    
    public Server(int socketPort) throws IOException {
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
                        new ClientThread(acceptedConnection).start();
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
		
		new Server(ServerConfiguration.PORT_BASE);
		
		Socket socket = new Socket(ServerConfiguration.HOST + '1', ServerConfiguration.PORT_BASE);
		OutputStream out = socket.getOutputStream();
		out.write("ABC\n".getBytes(), 0, 4);
		out.close();
		socket.close();
	}
}
