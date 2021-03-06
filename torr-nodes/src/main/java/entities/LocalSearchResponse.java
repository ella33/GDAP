// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package main.java.entities;

/**
 * Protobuf type {@code LocalSearchResponse}
 */
public  final class LocalSearchResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LocalSearchResponse)
    LocalSearchResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocalSearchResponse.newBuilder() to construct.
  private LocalSearchResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocalSearchResponse() {
    status_ = 0;
    errorMessage_ = "";
    fileInfo_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocalSearchResponse(
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
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            errorMessage_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              fileInfo_ = new java.util.ArrayList<main.java.entities.FileInfo>();
              mutable_bitField0_ |= 0x00000004;
            }
            fileInfo_.add(
                input.readMessage(main.java.entities.FileInfo.parser(), extensionRegistry));
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
        fileInfo_ = java.util.Collections.unmodifiableList(fileInfo_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return main.java.entities.Torr.internal_static_LocalSearchResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.entities.Torr.internal_static_LocalSearchResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.entities.LocalSearchResponse.class, main.java.entities.LocalSearchResponse.Builder.class);
  }

  private int bitField0_;
  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.Status status = 1;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.Status status = 1;</code>
   */
  public main.java.entities.Status getStatus() {
    main.java.entities.Status result = main.java.entities.Status.valueOf(status_);
    return result == null ? main.java.entities.Status.UNRECOGNIZED : result;
  }

  public static final int ERRORMESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object errorMessage_;
  /**
   * <code>string errorMessage = 2;</code>
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
   * <code>string errorMessage = 2;</code>
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

  public static final int FILEINFO_FIELD_NUMBER = 3;
  private java.util.List<main.java.entities.FileInfo> fileInfo_;
  /**
   * <code>repeated .FileInfo fileInfo = 3;</code>
   */
  public java.util.List<main.java.entities.FileInfo> getFileInfoList() {
    return fileInfo_;
  }
  /**
   * <code>repeated .FileInfo fileInfo = 3;</code>
   */
  public java.util.List<? extends main.java.entities.FileInfoOrBuilder> 
      getFileInfoOrBuilderList() {
    return fileInfo_;
  }
  /**
   * <code>repeated .FileInfo fileInfo = 3;</code>
   */
  public int getFileInfoCount() {
    return fileInfo_.size();
  }
  /**
   * <code>repeated .FileInfo fileInfo = 3;</code>
   */
  public main.java.entities.FileInfo getFileInfo(int index) {
    return fileInfo_.get(index);
  }
  /**
   * <code>repeated .FileInfo fileInfo = 3;</code>
   */
  public main.java.entities.FileInfoOrBuilder getFileInfoOrBuilder(
      int index) {
    return fileInfo_.get(index);
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
    if (status_ != main.java.entities.Status.SUCCESS.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (!getErrorMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, errorMessage_);
    }
    for (int i = 0; i < fileInfo_.size(); i++) {
      output.writeMessage(3, fileInfo_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != main.java.entities.Status.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (!getErrorMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, errorMessage_);
    }
    for (int i = 0; i < fileInfo_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, fileInfo_.get(i));
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
    if (!(obj instanceof main.java.entities.LocalSearchResponse)) {
      return super.equals(obj);
    }
    main.java.entities.LocalSearchResponse other = (main.java.entities.LocalSearchResponse) obj;

    boolean result = true;
    result = result && status_ == other.status_;
    result = result && getErrorMessage()
        .equals(other.getErrorMessage());
    result = result && getFileInfoList()
        .equals(other.getFileInfoList());
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
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + ERRORMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getErrorMessage().hashCode();
    if (getFileInfoCount() > 0) {
      hash = (37 * hash) + FILEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getFileInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.entities.LocalSearchResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.LocalSearchResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.entities.LocalSearchResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.LocalSearchResponse parseFrom(
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
  public static Builder newBuilder(main.java.entities.LocalSearchResponse prototype) {
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
   * Protobuf type {@code LocalSearchResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LocalSearchResponse)
      main.java.entities.LocalSearchResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.entities.Torr.internal_static_LocalSearchResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.entities.Torr.internal_static_LocalSearchResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.entities.LocalSearchResponse.class, main.java.entities.LocalSearchResponse.Builder.class);
    }

    // Construct using main.java.entities.LocalSearchResponse.newBuilder()
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
        getFileInfoFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      status_ = 0;

      errorMessage_ = "";

      if (fileInfoBuilder_ == null) {
        fileInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        fileInfoBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.entities.Torr.internal_static_LocalSearchResponse_descriptor;
    }

    public main.java.entities.LocalSearchResponse getDefaultInstanceForType() {
      return main.java.entities.LocalSearchResponse.getDefaultInstance();
    }

    public main.java.entities.LocalSearchResponse build() {
      main.java.entities.LocalSearchResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public main.java.entities.LocalSearchResponse buildPartial() {
      main.java.entities.LocalSearchResponse result = new main.java.entities.LocalSearchResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.status_ = status_;
      result.errorMessage_ = errorMessage_;
      if (fileInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          fileInfo_ = java.util.Collections.unmodifiableList(fileInfo_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.fileInfo_ = fileInfo_;
      } else {
        result.fileInfo_ = fileInfoBuilder_.build();
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
      if (other instanceof main.java.entities.LocalSearchResponse) {
        return mergeFrom((main.java.entities.LocalSearchResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.entities.LocalSearchResponse other) {
      if (other == main.java.entities.LocalSearchResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (!other.getErrorMessage().isEmpty()) {
        errorMessage_ = other.errorMessage_;
        onChanged();
      }
      if (fileInfoBuilder_ == null) {
        if (!other.fileInfo_.isEmpty()) {
          if (fileInfo_.isEmpty()) {
            fileInfo_ = other.fileInfo_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureFileInfoIsMutable();
            fileInfo_.addAll(other.fileInfo_);
          }
          onChanged();
        }
      } else {
        if (!other.fileInfo_.isEmpty()) {
          if (fileInfoBuilder_.isEmpty()) {
            fileInfoBuilder_.dispose();
            fileInfoBuilder_ = null;
            fileInfo_ = other.fileInfo_;
            bitField0_ = (bitField0_ & ~0x00000004);
            fileInfoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFileInfoFieldBuilder() : null;
          } else {
            fileInfoBuilder_.addAllMessages(other.fileInfo_);
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
      main.java.entities.LocalSearchResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.entities.LocalSearchResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int status_ = 0;
    /**
     * <code>.Status status = 1;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.Status status = 1;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Status status = 1;</code>
     */
    public main.java.entities.Status getStatus() {
      main.java.entities.Status result = main.java.entities.Status.valueOf(status_);
      return result == null ? main.java.entities.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.Status status = 1;</code>
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
     * <code>.Status status = 1;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object errorMessage_ = "";
    /**
     * <code>string errorMessage = 2;</code>
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
     * <code>string errorMessage = 2;</code>
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
     * <code>string errorMessage = 2;</code>
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
     * <code>string errorMessage = 2;</code>
     */
    public Builder clearErrorMessage() {
      
      errorMessage_ = getDefaultInstance().getErrorMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string errorMessage = 2;</code>
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

    private java.util.List<main.java.entities.FileInfo> fileInfo_ =
      java.util.Collections.emptyList();
    private void ensureFileInfoIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        fileInfo_ = new java.util.ArrayList<main.java.entities.FileInfo>(fileInfo_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        main.java.entities.FileInfo, main.java.entities.FileInfo.Builder, main.java.entities.FileInfoOrBuilder> fileInfoBuilder_;

    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public java.util.List<main.java.entities.FileInfo> getFileInfoList() {
      if (fileInfoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(fileInfo_);
      } else {
        return fileInfoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public int getFileInfoCount() {
      if (fileInfoBuilder_ == null) {
        return fileInfo_.size();
      } else {
        return fileInfoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public main.java.entities.FileInfo getFileInfo(int index) {
      if (fileInfoBuilder_ == null) {
        return fileInfo_.get(index);
      } else {
        return fileInfoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder setFileInfo(
        int index, main.java.entities.FileInfo value) {
      if (fileInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFileInfoIsMutable();
        fileInfo_.set(index, value);
        onChanged();
      } else {
        fileInfoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder setFileInfo(
        int index, main.java.entities.FileInfo.Builder builderForValue) {
      if (fileInfoBuilder_ == null) {
        ensureFileInfoIsMutable();
        fileInfo_.set(index, builderForValue.build());
        onChanged();
      } else {
        fileInfoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder addFileInfo(main.java.entities.FileInfo value) {
      if (fileInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFileInfoIsMutable();
        fileInfo_.add(value);
        onChanged();
      } else {
        fileInfoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder addFileInfo(
        int index, main.java.entities.FileInfo value) {
      if (fileInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFileInfoIsMutable();
        fileInfo_.add(index, value);
        onChanged();
      } else {
        fileInfoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder addFileInfo(
        main.java.entities.FileInfo.Builder builderForValue) {
      if (fileInfoBuilder_ == null) {
        ensureFileInfoIsMutable();
        fileInfo_.add(builderForValue.build());
        onChanged();
      } else {
        fileInfoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder addFileInfo(
        int index, main.java.entities.FileInfo.Builder builderForValue) {
      if (fileInfoBuilder_ == null) {
        ensureFileInfoIsMutable();
        fileInfo_.add(index, builderForValue.build());
        onChanged();
      } else {
        fileInfoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder addAllFileInfo(
        java.lang.Iterable<? extends main.java.entities.FileInfo> values) {
      if (fileInfoBuilder_ == null) {
        ensureFileInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, fileInfo_);
        onChanged();
      } else {
        fileInfoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder clearFileInfo() {
      if (fileInfoBuilder_ == null) {
        fileInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        fileInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public Builder removeFileInfo(int index) {
      if (fileInfoBuilder_ == null) {
        ensureFileInfoIsMutable();
        fileInfo_.remove(index);
        onChanged();
      } else {
        fileInfoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public main.java.entities.FileInfo.Builder getFileInfoBuilder(
        int index) {
      return getFileInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public main.java.entities.FileInfoOrBuilder getFileInfoOrBuilder(
        int index) {
      if (fileInfoBuilder_ == null) {
        return fileInfo_.get(index);  } else {
        return fileInfoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public java.util.List<? extends main.java.entities.FileInfoOrBuilder> 
         getFileInfoOrBuilderList() {
      if (fileInfoBuilder_ != null) {
        return fileInfoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(fileInfo_);
      }
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public main.java.entities.FileInfo.Builder addFileInfoBuilder() {
      return getFileInfoFieldBuilder().addBuilder(
          main.java.entities.FileInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public main.java.entities.FileInfo.Builder addFileInfoBuilder(
        int index) {
      return getFileInfoFieldBuilder().addBuilder(
          index, main.java.entities.FileInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .FileInfo fileInfo = 3;</code>
     */
    public java.util.List<main.java.entities.FileInfo.Builder> 
         getFileInfoBuilderList() {
      return getFileInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        main.java.entities.FileInfo, main.java.entities.FileInfo.Builder, main.java.entities.FileInfoOrBuilder> 
        getFileInfoFieldBuilder() {
      if (fileInfoBuilder_ == null) {
        fileInfoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            main.java.entities.FileInfo, main.java.entities.FileInfo.Builder, main.java.entities.FileInfoOrBuilder>(
                fileInfo_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        fileInfo_ = null;
      }
      return fileInfoBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:LocalSearchResponse)
  }

  // @@protoc_insertion_point(class_scope:LocalSearchResponse)
  private static final main.java.entities.LocalSearchResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.entities.LocalSearchResponse();
  }

  public static main.java.entities.LocalSearchResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LocalSearchResponse>
      PARSER = new com.google.protobuf.AbstractParser<LocalSearchResponse>() {
    public LocalSearchResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocalSearchResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocalSearchResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocalSearchResponse> getParserForType() {
    return PARSER;
  }

  public main.java.entities.LocalSearchResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

