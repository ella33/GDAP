package main.java;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import main.java.config.ServerConfiguration;
import main.java.entities.Node;
import main.java.entities.Message;

public class NodeBL {
    private ServerSocket listeningSocket;
    private volatile boolean run = true;

    public NodeBL(String hostSuffix, int portOffset) throws IOException {
    	addShutdownHook();
        listenForRequests(hostSuffix, portOffset);
    }

    private void listenForRequests(String hs, int po) {
    	try {
    		final String ip = ServerConfiguration.HOST + hs;
    		final int port = ServerConfiguration.PORT_BASE + po;
            listeningSocket = new ServerSocket(port, 100, InetAddress.getByName(ip));
            System.out.println("Will listen to host " + ip + " and port " + port);

            while (run) {
            	final Socket acceptedConnection = listeningSocket.accept();

            	new Thread() {
            		public void run() {
            			DataInputStream din;
						try {
							din = new DataInputStream(acceptedConnection.getInputStream());
							int len = din.readInt();
	                        byte[] data = new byte[len];
	                        din.readFully(data);
	                        Message message = Message.parseFrom(data);
	                        Node node = Node.newBuilder()
	                        		.setHost(ip)
	                        		.setPort(port)
	                        		.build();

	                        ResponseManager rm = new ResponseManager(message, node);
	                        Message response = rm.process();
	                        System.out.println(response);

	                        byte[] m = response.toByteArray();
	                        int mLen = m.length;
	                        
	                        System.out.println("res mlen " +mLen);
	                        System.out.println("res m " +m);
	                        DataOutputStream dout = new DataOutputStream(acceptedConnection.getOutputStream());
	                        dout.writeInt(mLen);
	                        dout.write(m);
	                        
	                        dout.flush();
	                        dout.close();
	                        din.close();
	                        acceptedConnection.close();

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}.start();
            	
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
		String hostSuffix = "";
		int portOffset = 0;
		
		if (args.length == 0) {
			System.out.println("Run with argument ip_suffix:port_offset (eg. 1:3)");
			return;
		}
		String[] runArgs = args[0].split(":");
		if (runArgs.length < 2) {
			System.out.println("Run with argument ip_suffix:port_offset (eg. 1:3)");
			return;
		}
		hostSuffix = runArgs[0];
		portOffset = Integer.parseInt(runArgs[1]);
		
		new NodeBL(hostSuffix, portOffset);
	}
}
