// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package main.java.entities;

public interface ChunkResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ChunkResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Status status = 1;</code>
   */
  int getStatusValue();
  /**
   * <code>.Status status = 1;</code>
   */
  main.java.entities.Status getStatus();

  /**
   * <code>string errorMessage = 2;</code>
   */
  java.lang.String getErrorMessage();
  /**
   * <code>string errorMessage = 2;</code>
   */
  com.google.protobuf.ByteString
      getErrorMessageBytes();

  /**
   * <pre>
   * Chunk content (1024 bytes or less)
   * </pre>
   *
   * <code>bytes data = 3;</code>
   */
  com.google.protobuf.ByteString getData();
}
