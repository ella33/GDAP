package config;

public final class ServerConfiguration {
	public static final String HOST = "127.0.0."; 
	
	public static final int PORT_BASE = 5000;
	
	public static final int[] IP_SUFFIXES = new int[] {2, 3, 4, 5, 6, 7, 8, 9};
	
	public static final int[] HOST_OFFSETS = new int[] {1, 2, 3};
	
	public static final int DATA_CHUNK_SIZE = 1024;
}
