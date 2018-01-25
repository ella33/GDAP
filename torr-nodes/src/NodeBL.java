import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
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
    
    public NodeBL(String hostSuffix, int portOffset) throws IOException {
    	addShutdownHook();
        listenForRequests(hostSuffix, portOffset);
    }
    
    private void listenForRequests(String hs, int po) {
    	try {
    		String ip = ServerConfiguration.HOST + hs;
    		int port = ServerConfiguration.PORT_BASE + po;
            listeningSocket = new ServerSocket(port, 100, InetAddress.getByName(ip));
            System.out.println("Will listen to host " + ip + " and port " + port);
            int n = 0;
            while (run) {
                Socket acceptedConnection = listeningSocket.accept();
                
                DataInputStream din = new DataInputStream(acceptedConnection.getInputStream());
                int len = din.readInt();
                System.out.println("length " + len); 
                byte[] data = new byte[len];
                din.readFully(data);
                Message request = Message.parseFrom(data);
                
                ResponseManager rm = new ResponseManager(request);
                Message response = rm.process();
                System.out.println(response);
                
                byte[] m = response.toByteArray();
                int l = m.length;
                
                DataOutputStream dout = new DataOutputStream(acceptedConnection.getOutputStream());
                dout.writeInt(l);
                dout.write(m);
                
                acceptedConnection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
		String hostSuffix = "1";
		int portOffset = 5;
		if ((args.length > 0) && (args[1].equals("-hs"))) {
			hostSuffix = args[2];
		}
		if ((args.length > 0) && (args[3].equals("-po"))) {
			portOffset = Integer.parseInt(args[4]);
		}
		new NodeBL(hostSuffix, portOffset);
		
//		Socket socket = new Socket(ServerConfiguration.HOST + '1', ServerConfiguration.PORT_BASE);
//		msg.writeTo(socket.getOutputStream());
//		socket.close();
	}
}
