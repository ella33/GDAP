import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entities.ChunkInfo;
import entities.FileInfo;

public class ResourceManager {
	private static List<ChunkInfo> chunks = new ArrayList<ChunkInfo>();
	private static List<FileInfo> fileInfos = new ArrayList<FileInfo>();
	private static Map<String, byte[]> files = new HashMap<String, byte[]>();
	
	public static void addChunk(ChunkInfo ci) {
		ResourceManager.chunks.add(ci);
	}
	
	public static void addFileInfo(FileInfo fi) {
		ResourceManager.fileInfos.add(fi);
	}
	
	public static void addFile(String hash, byte[] data) {
		ResourceManager.files.put(hash, data);
	}
	
	public static List<ChunkInfo> getChunks() {
		return ResourceManager.getChunks();
	}
	
	public static List<FileInfo> getFileInfos() {
		return ResourceManager.fileInfos;
	}
	
	public static Map<String, byte[]> getFiles() {
		return ResourceManager.files;
	}
	
}