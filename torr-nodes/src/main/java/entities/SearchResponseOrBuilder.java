// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package main.java.entities;

public interface SearchResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:SearchResponse)
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
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  java.util.List<main.java.entities.NodeSearchResult> 
      getResultsList();
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  main.java.entities.NodeSearchResult getResults(int index);
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  int getResultsCount();
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  java.util.List<? extends main.java.entities.NodeSearchResultOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  main.java.entities.NodeSearchResultOrBuilder getResultsOrBuilder(
      int index);
}