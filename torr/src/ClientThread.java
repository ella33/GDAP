import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import config.ServerConfiguration;

public class ClientThread extends Thread {
	private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
    	DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            byte[] dataBytes = new byte[ServerConfiguration.DATA_CHUNK_SIZE];
            in.read(dataBytes);
            System.out.println("CLIENT has sent " + dataBytes);
            //Message msg = Message.parseFrom(new byte[] {});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {}
            try {
                clientSocket.close();
            } catch (IOException e) {}
        }
    }
}
