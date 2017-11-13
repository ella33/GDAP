// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package entities;

/**
 * Protobuf type {@code UploadResponse}
 */
public  final class UploadResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UploadResponse)
    UploadResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadResponse.newBuilder() to construct.
  private UploadResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadResponse() {
    status_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UploadResponse(
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
            entities.FileInfo.Builder subBuilder = null;
            if (fileInfo_ != null) {
              subBuilder = fileInfo_.toBuilder();
            }
            fileInfo_ = input.readMessage(entities.FileInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(fileInfo_);
              fileInfo_ = subBuilder.buildPartial();
            }

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
    return entities.Torr.internal_static_UploadResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return entities.Torr.internal_static_UploadResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            entities.UploadResponse.class, entities.UploadResponse.Builder.class);
  }

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
  public entities.Status getStatus() {
    entities.Status result = entities.Status.valueOf(status_);
    return result == null ? entities.Status.UNRECOGNIZED : result;
  }

  public static final int FILEINFO_FIELD_NUMBER = 2;
  private entities.FileInfo fileInfo_;
  /**
   * <code>.FileInfo fileInfo = 2;</code>
   */
  public boolean hasFileInfo() {
    return fileInfo_ != null;
  }
  /**
   * <code>.FileInfo fileInfo = 2;</code>
   */
  public entities.FileInfo getFileInfo() {
    return fileInfo_ == null ? entities.FileInfo.getDefaultInstance() : fileInfo_;
  }
  /**
   * <code>.FileInfo fileInfo = 2;</code>
   */
  public entities.FileInfoOrBuilder getFileInfoOrBuilder() {
    return getFileInfo();
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
    if (status_ != entities.Status.SUCCESS.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (fileInfo_ != null) {
      output.writeMessage(2, getFileInfo());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != entities.Status.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (fileInfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFileInfo());
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
    if (!(obj instanceof entities.UploadResponse)) {
      return super.equals(obj);
    }
    entities.UploadResponse other = (entities.UploadResponse) obj;

    boolean result = true;
    result = result && status_ == other.status_;
    result = result && (hasFileInfo() == other.hasFileInfo());
    if (hasFileInfo()) {
      result = result && getFileInfo()
          .equals(other.getFileInfo());
    }
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
    if (hasFileInfo()) {
      hash = (37 * hash) + FILEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getFileInfo().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static entities.UploadResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.UploadResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.UploadResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.UploadResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.UploadResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static entities.UploadResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static entities.UploadResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static entities.UploadResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static entities.UploadResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static entities.UploadResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static entities.UploadResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static entities.UploadResponse parseFrom(
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
  public static Builder newBuilder(entities.UploadResponse prototype) {
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
   * Protobuf type {@code UploadResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UploadResponse)
      entities.UploadResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return entities.Torr.internal_static_UploadResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return entities.Torr.internal_static_UploadResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              entities.UploadResponse.class, entities.UploadResponse.Builder.class);
    }

    // Construct using entities.UploadResponse.newBuilder()
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
      status_ = 0;

      if (fileInfoBuilder_ == null) {
        fileInfo_ = null;
      } else {
        fileInfo_ = null;
        fileInfoBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return entities.Torr.internal_static_UploadResponse_descriptor;
    }

    public entities.UploadResponse getDefaultInstanceForType() {
      return entities.UploadResponse.getDefaultInstance();
    }

    public entities.UploadResponse build() {
      entities.UploadResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public entities.UploadResponse buildPartial() {
      entities.UploadResponse result = new entities.UploadResponse(this);
      result.status_ = status_;
      if (fileInfoBuilder_ == null) {
        result.fileInfo_ = fileInfo_;
      } else {
        result.fileInfo_ = fileInfoBuilder_.build();
      }
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
      if (other instanceof entities.UploadResponse) {
        return mergeFrom((entities.UploadResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(entities.UploadResponse other) {
      if (other == entities.UploadResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.hasFileInfo()) {
        mergeFileInfo(other.getFileInfo());
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
      entities.UploadResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (entities.UploadResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

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
    public entities.Status getStatus() {
      entities.Status result = entities.Status.valueOf(status_);
      return result == null ? entities.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.Status status = 1;</code>
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
     * <code>.Status status = 1;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private entities.FileInfo fileInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder> fileInfoBuilder_;
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public boolean hasFileInfo() {
      return fileInfoBuilder_ != null || fileInfo_ != null;
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public entities.FileInfo getFileInfo() {
      if (fileInfoBuilder_ == null) {
        return fileInfo_ == null ? entities.FileInfo.getDefaultInstance() : fileInfo_;
      } else {
        return fileInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public Builder setFileInfo(entities.FileInfo value) {
      if (fileInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        fileInfo_ = value;
        onChanged();
      } else {
        fileInfoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public Builder setFileInfo(
        entities.FileInfo.Builder builderForValue) {
      if (fileInfoBuilder_ == null) {
        fileInfo_ = builderForValue.build();
        onChanged();
      } else {
        fileInfoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public Builder mergeFileInfo(entities.FileInfo value) {
      if (fileInfoBuilder_ == null) {
        if (fileInfo_ != null) {
          fileInfo_ =
            entities.FileInfo.newBuilder(fileInfo_).mergeFrom(value).buildPartial();
        } else {
          fileInfo_ = value;
        }
        onChanged();
      } else {
        fileInfoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public Builder clearFileInfo() {
      if (fileInfoBuilder_ == null) {
        fileInfo_ = null;
        onChanged();
      } else {
        fileInfo_ = null;
        fileInfoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public entities.FileInfo.Builder getFileInfoBuilder() {
      
      onChanged();
      return getFileInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    public entities.FileInfoOrBuilder getFileInfoOrBuilder() {
      if (fileInfoBuilder_ != null) {
        return fileInfoBuilder_.getMessageOrBuilder();
      } else {
        return fileInfo_ == null ?
            entities.FileInfo.getDefaultInstance() : fileInfo_;
      }
    }
    /**
     * <code>.FileInfo fileInfo = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder> 
        getFileInfoFieldBuilder() {
      if (fileInfoBuilder_ == null) {
        fileInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            entities.FileInfo, entities.FileInfo.Builder, entities.FileInfoOrBuilder>(
                getFileInfo(),
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


    // @@protoc_insertion_point(builder_scope:UploadResponse)
  }

  // @@protoc_insertion_point(class_scope:UploadResponse)
  private static final entities.UploadResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new entities.UploadResponse();
  }

  public static entities.UploadResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UploadResponse>
      PARSER = new com.google.protobuf.AbstractParser<UploadResponse>() {
    public UploadResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UploadResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UploadResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadResponse> getParserForType() {
    return PARSER;
  }

  public entities.UploadResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

