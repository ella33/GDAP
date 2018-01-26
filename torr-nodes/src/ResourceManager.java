import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.ByteString;

import entities.ChunkInfo;
import entities.FileInfo;

public class ResourceManager {
	private static List<ChunkInfo> chunks = new ArrayList<ChunkInfo>();
	private static List<FileInfo> fileInfos = new ArrayList<FileInfo>();
	private static List<byte[]> files = new ArrayList<byte[]>();
	
	public static void addChunk(ChunkInfo ci) {
		ResourceManager.chunks.add(ci);
	}
	
	public static void addFileInfo(FileInfo fi) {
		ResourceManager.fileInfos.add(fi);
	}
	
	public static void addFile(byte[] data) {
		ResourceManager.files.add(data);
	}
	
	public static List<ChunkInfo> getChunks() {
		return ResourceManager.getChunks();
	}
	
	public static List<FileInfo> getFileInfos() {
		return ResourceManager.fileInfos;
	}
	
	public static List<byte[]> getFiles() {
		return ResourceManager.files;
	}
	
}