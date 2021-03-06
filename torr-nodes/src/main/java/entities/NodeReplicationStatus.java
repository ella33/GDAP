// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package main.java.entities;

/**
 * Protobuf type {@code NodeReplicationStatus}
 */
public  final class NodeReplicationStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:NodeReplicationStatus)
    NodeReplicationStatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeReplicationStatus.newBuilder() to construct.
  private NodeReplicationStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeReplicationStatus() {
    chunkIndex_ = 0;
    status_ = 0;
    errorMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeReplicationStatus(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            main.java.entities.Node.Builder subBuilder = null;
            if (node_ != null) {
              subBuilder = node_.toBuilder();
            }
            node_ = input.readMessage(main.java.entities.Node.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(node_);
              node_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            chunkIndex_ = input.readUInt32();
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            errorMessage_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return main.java.entities.Torr.internal_static_NodeReplicationStatus_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.entities.Torr.internal_static_NodeReplicationStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.entities.NodeReplicationStatus.class, main.java.entities.NodeReplicationStatus.Builder.class);
  }

  public static final int NODE_FIELD_NUMBER = 1;
  private main.java.entities.Node node_;
  /**
   * <code>.Node node = 1;</code>
   */
  public boolean hasNode() {
    return node_ != null;
  }
  /**
   * <code>.Node node = 1;</code>
   */
  public main.java.entities.Node getNode() {
    return node_ == null ? main.java.entities.Node.getDefaultInstance() : node_;
  }
  /**
   * <code>.Node node = 1;</code>
   */
  public main.java.entities.NodeOrBuilder getNodeOrBuilder() {
    return getNode();
  }

  public static final int CHUNKINDEX_FIELD_NUMBER = 2;
  private int chunkIndex_;
  /**
   * <code>uint32 chunkIndex = 2;</code>
   */
  public int getChunkIndex() {
    return chunkIndex_;
  }

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_;
  /**
   * <code>.Status status = 3;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.Status status = 3;</code>
   */
  public main.java.entities.Status getStatus() {
    main.java.entities.Status result = main.java.entities.Status.valueOf(status_);
    return result == null ? main.java.entities.Status.UNRECOGNIZED : result;
  }

  public static final int ERRORMESSAGE_FIELD_NUMBER = 4;
  private volatile java.lang.Object errorMessage_;
  /**
   * <code>string errorMessage = 4;</code>
   */
  public java.lang.String getErrorMessage() {
    java.lang.Object ref = errorMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      errorMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string errorMessage = 4;</code>
   */
  public com.google.protobuf.ByteString
      getErrorMessageBytes() {
    java.lang.Object ref = errorMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      errorMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (node_ != null) {
      output.writeMessage(1, getNode());
    }
    if (chunkIndex_ != 0) {
      output.writeUInt32(2, chunkIndex_);
    }
    if (status_ != main.java.entities.Status.SUCCESS.getNumber()) {
      output.writeEnum(3, status_);
    }
    if (!getErrorMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, errorMessage_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (node_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getNode());
    }
    if (chunkIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, chunkIndex_);
    }
    if (status_ != main.java.entities.Status.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, status_);
    }
    if (!getErrorMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, errorMessage_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof main.java.entities.NodeReplicationStatus)) {
      return super.equals(obj);
    }
    main.java.entities.NodeReplicationStatus other = (main.java.entities.NodeReplicationStatus) obj;

    boolean result = true;
    result = result && (hasNode() == other.hasNode());
    if (hasNode()) {
      result = result && getNode()
          .equals(other.getNode());
    }
    result = result && (getChunkIndex()
        == other.getChunkIndex());
    result = result && status_ == other.status_;
    result = result && getErrorMessage()
        .equals(other.getErrorMessage());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasNode()) {
      hash = (37 * hash) + NODE_FIELD_NUMBER;
      hash = (53 * hash) + getNode().hashCode();
    }
    hash = (37 * hash) + CHUNKINDEX_FIELD_NUMBER;
    hash = (53 * hash) + getChunkIndex();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + ERRORMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getErrorMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.entities.NodeReplicationStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.NodeReplicationStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.entities.NodeReplicationStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.NodeReplicationStatus parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(main.java.entities.NodeReplicationStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code NodeReplicationStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:NodeReplicationStatus)
      main.java.entities.NodeReplicationStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.entities.Torr.internal_static_NodeReplicationStatus_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.entities.Torr.internal_static_NodeReplicationStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.entities.NodeReplicationStatus.class, main.java.entities.NodeReplicationStatus.Builder.class);
    }

    // Construct using main.java.entities.NodeReplicationStatus.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (nodeBuilder_ == null) {
        node_ = null;
      } else {
        node_ = null;
        nodeBuilder_ = null;
      }
      chunkIndex_ = 0;

      status_ = 0;

      errorMessage_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.entities.Torr.internal_static_NodeReplicationStatus_descriptor;
    }

    public main.java.entities.NodeReplicationStatus getDefaultInstanceForType() {
      return main.java.entities.NodeReplicationStatus.getDefaultInstance();
    }

    public main.java.entities.NodeReplicationStatus build() {
      main.java.entities.NodeReplicationStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public main.java.entities.NodeReplicationStatus buildPartial() {
      main.java.entities.NodeReplicationStatus result = new main.java.entities.NodeReplicationStatus(this);
      if (nodeBuilder_ == null) {
        result.node_ = node_;
      } else {
        result.node_ = nodeBuilder_.build();
      }
      result.chunkIndex_ = chunkIndex_;
      result.status_ = status_;
      result.errorMessage_ = errorMessage_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof main.java.entities.NodeReplicationStatus) {
        return mergeFrom((main.java.entities.NodeReplicationStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.entities.NodeReplicationStatus other) {
      if (other == main.java.entities.NodeReplicationStatus.getDefaultInstance()) return this;
      if (other.hasNode()) {
        mergeNode(other.getNode());
      }
      if (other.getChunkIndex() != 0) {
        setChunkIndex(other.getChunkIndex());
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (!other.getErrorMessage().isEmpty()) {
        errorMessage_ = other.errorMessage_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      main.java.entities.NodeReplicationStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.entities.NodeReplicationStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private main.java.entities.Node node_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.entities.Node, main.java.entities.Node.Builder, main.java.entities.NodeOrBuilder> nodeBuilder_;
    /**
     * <code>.Node node = 1;</code>
     */
    public boolean hasNode() {
      return nodeBuilder_ != null || node_ != null;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public main.java.entities.Node getNode() {
      if (nodeBuilder_ == null) {
        return node_ == null ? main.java.entities.Node.getDefaultInstance() : node_;
      } else {
        return nodeBuilder_.getMessage();
      }
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public Builder setNode(main.java.entities.Node value) {
      if (nodeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        node_ = value;
        onChanged();
      } else {
        nodeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public Builder setNode(
        main.java.entities.Node.Builder builderForValue) {
      if (nodeBuilder_ == null) {
        node_ = builderForValue.build();
        onChanged();
      } else {
        nodeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public Builder mergeNode(main.java.entities.Node value) {
      if (nodeBuilder_ == null) {
        if (node_ != null) {
          node_ =
            main.java.entities.Node.newBuilder(node_).mergeFrom(value).buildPartial();
        } else {
          node_ = value;
        }
        onChanged();
      } else {
        nodeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public Builder clearNode() {
      if (nodeBuilder_ == null) {
        node_ = null;
        onChanged();
      } else {
        node_ = null;
        nodeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public main.java.entities.Node.Builder getNodeBuilder() {
      
      onChanged();
      return getNodeFieldBuilder().getBuilder();
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public main.java.entities.NodeOrBuilder getNodeOrBuilder() {
      if (nodeBuilder_ != null) {
        return nodeBuilder_.getMessageOrBuilder();
      } else {
        return node_ == null ?
            main.java.entities.Node.getDefaultInstance() : node_;
      }
    }
    /**
     * <code>.Node node = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.entities.Node, main.java.entities.Node.Builder, main.java.entities.NodeOrBuilder> 
        getNodeFieldBuilder() {
      if (nodeBuilder_ == null) {
        nodeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            main.java.entities.Node, main.java.entities.Node.Builder, main.java.entities.NodeOrBuilder>(
                getNode(),
                getParentForChildren(),
                isClean());
        node_ = null;
      }
      return nodeBuilder_;
    }

    private int chunkIndex_ ;
    /**
     * <code>uint32 chunkIndex = 2;</code>
     */
    public int getChunkIndex() {
      return chunkIndex_;
    }
    /**
     * <code>uint32 chunkIndex = 2;</code>
     */
    public Builder setChunkIndex(int value) {
      
      chunkIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 chunkIndex = 2;</code>
     */
    public Builder clearChunkIndex() {
      
      chunkIndex_ = 0;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.Status status = 3;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.Status status = 3;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Status status = 3;</code>
     */
    public main.java.entities.Status getStatus() {
      main.java.entities.Status result = main.java.entities.Status.valueOf(status_);
      return result == null ? main.java.entities.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.Status status = 3;</code>
     */
    public Builder setStatus(main.java.entities.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Status status = 3;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object errorMessage_ = "";
    /**
     * <code>string errorMessage = 4;</code>
     */
    public java.lang.String getErrorMessage() {
      java.lang.Object ref = errorMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        errorMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string errorMessage = 4;</code>
     */
    public com.google.protobuf.ByteString
        getErrorMessageBytes() {
      java.lang.Object ref = errorMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        errorMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string errorMessage = 4;</code>
     */
    public Builder setErrorMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      errorMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string errorMessage = 4;</code>
     */
    public Builder clearErrorMessage() {
      
      errorMessage_ = getDefaultInstance().getErrorMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string errorMessage = 4;</code>
     */
    public Builder setErrorMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      errorMessage_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:NodeReplicationStatus)
  }

  // @@protoc_insertion_point(class_scope:NodeReplicationStatus)
  private static final main.java.entities.NodeReplicationStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.entities.NodeReplicationStatus();
  }

  public static main.java.entities.NodeReplicationStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeReplicationStatus>
      PARSER = new com.google.protobuf.AbstractParser<NodeReplicationStatus>() {
    public NodeReplicationStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NodeReplicationStatus(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeReplicationStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NodeReplicationStatus> getParserForType() {
    return PARSER;
  }

  public main.java.entities.NodeReplicationStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

