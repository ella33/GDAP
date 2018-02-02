package main.java;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import main.java.entities.Message;

public class Helper {
	public static void writeMessage(OutputStream out, Message m) {
		byte[] data = m.toByteArray();
        ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(data.length);
        byte[] size = buffer.array();
        
        try {
			out.write(size);
			out.write(data);
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Message readMessage(InputStream in) {
		int len;
		Message m = null;
		DataInputStream din = new DataInputStream(in);
		try {
			len = din.readInt();
			byte[] data = new byte[len];
	        din.readFully(data);
	        m = Message.parseFrom(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
}