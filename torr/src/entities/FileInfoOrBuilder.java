// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package entities;

public interface FileInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FileInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes hash = 1;</code>
   */
  com.google.protobuf.ByteString getHash();

  /**
   * <code>uint32 size = 2;</code>
   */
  int getSize();

  /**
   * <code>string filename = 3;</code>
   */
  java.lang.String getFilename();
  /**
   * <code>string filename = 3;</code>
   */
  com.google.protobuf.ByteString
      getFilenameBytes();

  /**
   * <code>repeated .ChunkInfo chunks = 4;</code>
   */
  java.util.List<entities.ChunkInfo> 
      getChunksList();
  /**
   * <code>repeated .ChunkInfo chunks = 4;</code>
   */
  entities.ChunkInfo getChunks(int index);
  /**
   * <code>repeated .ChunkInfo chunks = 4;</code>
   */
  int getChunksCount();
  /**
   * <code>repeated .ChunkInfo chunks = 4;</code>
   */
  java.util.List<? extends entities.ChunkInfoOrBuilder> 
      getChunksOrBuilderList();
  /**
   * <code>repeated .ChunkInfo chunks = 4;</code>
   */
  entities.ChunkInfoOrBuilder getChunksOrBuilder(
      int index);
}