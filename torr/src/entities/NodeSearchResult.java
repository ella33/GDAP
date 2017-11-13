// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package entities;

/**
 * Protobuf type {@code NodeSearchResult}
 */
public  final class NodeSearchResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:NodeSearchResult)
    NodeSearchResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeSearchResult.newBuilder() to construct.
  private NodeSearchResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeSearchResult() {
    status_ = 0;
    files_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeSearchResult(
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
            entities.Node.Builder subBuilder = null;
            if (node_ != null) {
              subBuilder = node_.toBuilder();
            }
            node_ = input.readMessage(entities.Node.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(node_);
              node_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              files_ = new java.util.ArrayList<entities.FileInfo>();
              mutable_bitField0_ |= 0x00000004;
            }
            files_.add(
                input.readMessage(entities.FileInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        files_ = java.util.Collections.unmodifiableList(files_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return entities.Torr.internal_static_NodeSearchResult_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return entities.Torr.internal_static_NodeSearchResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            entities.NodeSearchResult.class, entities.NodeSearchResult.Builder.class);
  }

  private int bitField0_;
  public static final int NODE_FIELD_NUMBER = 1;
  private entities.Node node_;
  /**
   * <code>.Node node = 1;</code>
   */
  public boolean hasNode() {
    return node_ != null;
  }
  /**
   * <code>.Node node = 1;</code>
   */
  public entities.Node getNode() {
    return node_ == null ? entities.Node.getDefaultInstance() : node_;
  }
  /**
   * <code>.Node node = 1;</code>
   */
  public entities.NodeOrBuilder getNodeOrBuilder() {
    return getNode();
  }

  public static final int STATUS_FIELD_NUMBER = 2;
  private int status_;
  /**
   * <code>.Status status = 2;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.Status status = 2;</code>
   */
  public entities.Status getStatus() {
    entities.Status result = entities.Status.valueOf(status_);
    return result == null ? entities.Status.UNRECOGNIZED : result;
  }

  public static final int FILES_FIELD_NUMBER = 3;
  private java.util.List<entities.FileInfo> files_;
  /**
   * <code>repeated .FileInfo files = 3;</code>
   */
  public java.util.List<entities.FileInfo> getFilesList() {
    return files_;
  }
  /**
   * <code>repeated .FileInfo files = 3;</code>
   */
  public java.util.List<? extends entities.FileInfoOrBuilder> 
      getFilesOrBuilderList() {
    return files_;
  }
  /**
   * <code>repeated .FileInfo files = 3;</code>
   */
  public int getFilesCount() {
    return files_.size();
  }
  /**
   * <code>repeated .FileInfo files = 3;</code>
   */
  public entities.FileInfo getFiles(int index) {
    return files_.get(index);
  }
  /**
   * <code>repeated .FileInfo files = 3;</code>
   */
  public entities.FileInfoOrBuilder getFilesOrBuilder(
      int index) {
    return files_.get(index);
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
    if (status_ != entities.Status.SUCCESS.getNumber()) {
      output.writeEnum(2, status_);
    }
    for (int i = 0; i < files_.size(); i++) {
      output.writeMessage(3, files_.get(i));
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
    if (status_ != entities.Status.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, status_);
    }
    for (int i = 0; i < files_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, files_.get(i));
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
    if (!(obj instanceof entities.NodeSearchResult)) {
      return super.equals(obj);
    }
    entities.NodeSearchResult other = (entities.NodeSearchResult) obj;

    boolean result = true;
    result = result && (hasNode() == other.hasNode());
    if (hasNode()) {
      result = result && getNode()
          .equals(other.getNode());
    }
    result = result && status_ == other.status_;
    result = result && getFilesList()
        .equals(other.getFilesList());
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
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    if (getFilesCount() > 0) {
      hash = (37 * hash) + FILES_FIELD_NUMBER;
      hash = (53 * hash) + getFilesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static entities.NodeSearchResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.NodeSearchResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.NodeSearchResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.NodeSearchResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.NodeSearchResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.NodeSearchResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.NodeSearchResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static entities.NodeSearchResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static entities.NodeSearchResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static entities.NodeSearchResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static entities.NodeSearchResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static entities.NodeSearchResult parseFrom(
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
  public static Builder newBuilder(entities.NodeSearchResult prototype) {
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
   * Protobuf type {@code NodeSearchResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:NodeSearchResult)
      entities.NodeSearchResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return entities.Torr.internal_static_NodeSearchResult_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return entities.Torr.internal_static_NodeSearchResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              entities.NodeSearchResult.class, entities.NodeSearchResult.Builder.class);
    }

    // Construct using entities.NodeSearchResult.newBuilder()
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
        getFilesFieldBuilder();
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
      status_ = 0;

      if (filesBuilder_ == null) {
        files_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        filesBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return entities.Torr.internal_static_NodeSearchResult_descriptor;
    }

    public entities.NodeSearchResult getDefaultInstanceForType() {
      return entities.NodeSearchResult.getDefaultInstance();
    }

    public entities.NodeSearchResult build() {
      entities.NodeSearchResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public entities.NodeSearchResult buildPartial() {
      entities.NodeSearchResult result = new entities.NodeSearchResult(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (nodeBuilder_ == null) {
        result.node_ = node_;
      } else {
        result.node_ = nodeBuilder_.build();
      }
      result.status_ = status_;
      if (filesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          files_ = java.util.Collections.unmodifiableList(files_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.files_ = files_;
      } else {
        result.files_ = filesBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof entities.NodeSearchResult) {
        return mergeFrom((entities.NodeSearchResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(entities.NodeSearchResult other) {
      if (other == entities.NodeSearchResult.getDefaultInstance()) return this;
      if (other.hasNode()) {
        mergeNode(other.getNode());
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (filesBuilder_ == null) {
        if (!other.files_.isEmpty()) {
          if (files_.isEmpty()) {
            files_ = other.files_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureFilesIsMutable();
            files_.addAll(other.files_);
          }
          onChanged();
        }
      } else {
        if (!other.files_.isEmpty()) {
          if (filesBuilder_.isEmpty()) {
            filesBuilder_.dispose();
            filesBuilder_ = null;
            files_ = other.files_;
            bitField0_ = (bitField0_ & ~0x00000004);
            filesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFilesFieldBuilder() : null;
          } else {
            filesBuilder_.addAllMessages(other.files_);
          }
        }
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
      entities.NodeSearchResult parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (entities.NodeSearchResult) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private entities.Node node_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        entities.Node, entities.Node.Builder, entities.NodeOrBuilder> nodeBuilder_;
    /**
     * <code>.Node node = 1;</code>
     */
    public boolean hasNode() {
      return nodeBuilder_ != null || node_ != null;
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public entities.Node getNode() {
      if (nodeBuilder_ == null) {
        return node_ == null ? entities.Node.getDefaultInstance() : node_;
      } else {
        return nodeBuilder_.getMessage();
      }
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public Builder setNode(entities.Node value) {
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
        entities.Node.Builder builderForValue) {
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
    public Builder mergeNode(entities.Node value) {
      if (nodeBuilder_ == null) {
        if (node_ != null) {
          node_ =
            entities.Node.newBuilder(node_).mergeFrom(value).buildPartial();
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
    public entities.Node.Builder getNodeBuilder() {
      
      onChanged();
      return getNodeFieldBuilder().getBuilder();
    }
    /**
     * <code>.Node node = 1;</code>
     */
    public entities.NodeOrBuilder getNodeOrBuilder() {
      if (nodeBuilder_ != null) {
        return nodeBuilder_.getMessageOrBuilder();
      } else {
        return node_ == null ?
            entities.Node.getDefaultInstance() : node_;
      }
    }
    /**
     * <code>.Node node = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        entities.Node, entities.Node.Builder, entities.NodeOrBuilder> 
        getNodeFieldBuilder() {
      if (nodeBuilder_ == null) {
        nodeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            entities.Node, entities.Node.Builder, entities.NodeOrBuilder>(
                getNode(),
                getParentForChildren(),
                isClean());
        node_ = null;
      }
      return nodeBuilder_;
    }

    private int status_ = 0;
    /**
     * <code>.Status status = 2;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.Status status = 2;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Status status = 2;</code>
     */
    public entities.Status getStatus() {
      entities.Status result = entities.Status.valueOf(status_);
      return result == null ? entities.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.Status status = 2;</code>
     */
    public Builder setStatus(entities.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Status status = 2;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<entities.FileInfo> files_ =
      java.util.Collections.emptyList();
    private void ensureFilesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        files_ = new java.util.ArrayList<entities.FileInfo>(files_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder> filesBuilder_;

    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public java.util.List<entities.FileInfo> getFilesList() {
      if (filesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(files_);
      } else {
        return filesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public int getFilesCount() {
      if (filesBuilder_ == null) {
        return files_.size();
      } else {
        return filesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public entities.FileInfo getFiles(int index) {
      if (filesBuilder_ == null) {
        return files_.get(index);
      } else {
        return filesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder setFiles(
        int index, entities.FileInfo value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.set(index, value);
        onChanged();
      } else {
        filesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder setFiles(
        int index, entities.FileInfo.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.set(index, builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder addFiles(entities.FileInfo value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.add(value);
        onChanged();
      } else {
        filesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder addFiles(
        int index, entities.FileInfo value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.add(index, value);
        onChanged();
      } else {
        filesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder addFiles(
        entities.FileInfo.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.add(builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder addFiles(
        int index, entities.FileInfo.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.add(index, builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder addAllFiles(
        java.lang.Iterable<? extends entities.FileInfo> values) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, files_);
        onChanged();
      } else {
        filesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder clearFiles() {
      if (filesBuilder_ == null) {
        files_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        filesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public Builder removeFiles(int index) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.remove(index);
        onChanged();
      } else {
        filesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public entities.FileInfo.Builder getFilesBuilder(
        int index) {
      return getFilesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public entities.FileInfoOrBuilder getFilesOrBuilder(
        int index) {
      if (filesBuilder_ == null) {
        return files_.get(index);  } else {
        return filesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public java.util.List<? extends entities.FileInfoOrBuilder> 
         getFilesOrBuilderList() {
      if (filesBuilder_ != null) {
        return filesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(files_);
      }
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public entities.FileInfo.Builder addFilesBuilder() {
      return getFilesFieldBuilder().addBuilder(
          entities.FileInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public entities.FileInfo.Builder addFilesBuilder(
        int index) {
      return getFilesFieldBuilder().addBuilder(
          index, entities.FileInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .FileInfo files = 3;</code>
     */
    public java.util.List<entities.FileInfo.Builder> 
         getFilesBuilderList() {
      return getFilesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder> 
        getFilesFieldBuilder() {
      if (filesBuilder_ == null) {
        filesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder>(
                files_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        files_ = null;
      }
      return filesBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:NodeSearchResult)
  }

  // @@protoc_insertion_point(class_scope:NodeSearchResult)
  private static final entities.NodeSearchResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new entities.NodeSearchResult();
  }

  public static entities.NodeSearchResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeSearchResult>
      PARSER = new com.google.protobuf.AbstractParser<NodeSearchResult>() {
    public NodeSearchResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NodeSearchResult(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeSearchResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NodeSearchResult> getParserForType() {
    return PARSER;
  }

  public entities.NodeSearchResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

