package main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import main.java.entities.ChunkResponse;
import main.java.entities.Message;

public class NodeConnection implements Runnable {
	private InetAddress addr;
	private int port;
	private byte[] requestData;
	private volatile ChunkResponse cres;
	
	public NodeConnection(InetAddress addr, int port, byte[] requestData) {
		this.addr = addr;
		this.port = port;
		this.requestData = requestData;
	}

	@Override
	public void run() {
		Socket nodeConnection;
		DataOutputStream dout;
		try {
			nodeConnection = new Socket(this.addr, this.port);
			dout = new DataOutputStream(nodeConnection.getOutputStream());
	        dout.writeInt(requestData.length);
	        dout.write(requestData);
	        

	        DataInputStream din = new DataInputStream(nodeConnection.getInputStream());
	        int len = din.readInt();
	        byte[] data = new byte[len];
	        din.readFully(data);
	        Message res = Message.parseFrom(data);
	        this.cres = res.getChunkResponse();
	        dout.close();
	        din.close();
	        nodeConnection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ChunkResponse getChunkResponse() {
		return this.cres;
	}
	
}
