// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package entities;

public interface DownloadResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DownloadResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Status status = 1;</code>
   */
  int getStatusValue();
  /**
   * <code>.Status status = 1;</code>
   */
  entities.Status getStatus();

  /**
   * <code>bytes data = 2;</code>
   */
  com.google.protobuf.ByteString getData();
}