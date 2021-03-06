// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torr.proto

package main.java.entities;

/**
 * Protobuf type {@code SearchResponse}
 */
public  final class SearchResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SearchResponse)
    SearchResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SearchResponse.newBuilder() to construct.
  private SearchResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SearchResponse() {
    status_ = 0;
    errorMessage_ = "";
    results_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SearchResponse(
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
              results_ = new java.util.ArrayList<main.java.entities.NodeSearchResult>();
              mutable_bitField0_ |= 0x00000004;
            }
            results_.add(
                input.readMessage(main.java.entities.NodeSearchResult.parser(), extensionRegistry));
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
        results_ = java.util.Collections.unmodifiableList(results_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return main.java.entities.Torr.internal_static_SearchResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.entities.Torr.internal_static_SearchResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.entities.SearchResponse.class, main.java.entities.SearchResponse.Builder.class);
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

  public static final int RESULTS_FIELD_NUMBER = 3;
  private java.util.List<main.java.entities.NodeSearchResult> results_;
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  public java.util.List<main.java.entities.NodeSearchResult> getResultsList() {
    return results_;
  }
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  public java.util.List<? extends main.java.entities.NodeSearchResultOrBuilder> 
      getResultsOrBuilderList() {
    return results_;
  }
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  public int getResultsCount() {
    return results_.size();
  }
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  public main.java.entities.NodeSearchResult getResults(int index) {
    return results_.get(index);
  }
  /**
   * <code>repeated .NodeSearchResult results = 3;</code>
   */
  public main.java.entities.NodeSearchResultOrBuilder getResultsOrBuilder(
      int index) {
    return results_.get(index);
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
    for (int i = 0; i < results_.size(); i++) {
      output.writeMessage(3, results_.get(i));
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
    for (int i = 0; i < results_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, results_.get(i));
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
    if (!(obj instanceof main.java.entities.SearchResponse)) {
      return super.equals(obj);
    }
    main.java.entities.SearchResponse other = (main.java.entities.SearchResponse) obj;

    boolean result = true;
    result = result && status_ == other.status_;
    result = result && getErrorMessage()
        .equals(other.getErrorMessage());
    result = result && getResultsList()
        .equals(other.getResultsList());
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
    if (getResultsCount() > 0) {
      hash = (37 * hash) + RESULTS_FIELD_NUMBER;
      hash = (53 * hash) + getResultsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.entities.SearchResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.SearchResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.SearchResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.SearchResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.SearchResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.entities.SearchResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.entities.SearchResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.SearchResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.SearchResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.entities.SearchResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.entities.SearchResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.entities.SearchResponse parseFrom(
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
  public static Builder newBuilder(main.java.entities.SearchResponse prototype) {
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
   * Protobuf type {@code SearchResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SearchResponse)
      main.java.entities.SearchResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.entities.Torr.internal_static_SearchResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.entities.Torr.internal_static_SearchResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.entities.SearchResponse.class, main.java.entities.SearchResponse.Builder.class);
    }

    // Construct using main.java.entities.SearchResponse.newBuilder()
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
        getResultsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      status_ = 0;

      errorMessage_ = "";

      if (resultsBuilder_ == null) {
        results_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        resultsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.entities.Torr.internal_static_SearchResponse_descriptor;
    }

    public main.java.entities.SearchResponse getDefaultInstanceForType() {
      return main.java.entities.SearchResponse.getDefaultInstance();
    }

    public main.java.entities.SearchResponse build() {
      main.java.entities.SearchResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public main.java.entities.SearchResponse buildPartial() {
      main.java.entities.SearchResponse result = new main.java.entities.SearchResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.status_ = status_;
      result.errorMessage_ = errorMessage_;
      if (resultsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          results_ = java.util.Collections.unmodifiableList(results_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.results_ = results_;
      } else {
        result.results_ = resultsBuilder_.build();
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
      if (other instanceof main.java.entities.SearchResponse) {
        return mergeFrom((main.java.entities.SearchResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.entities.SearchResponse other) {
      if (other == main.java.entities.SearchResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (!other.getErrorMessage().isEmpty()) {
        errorMessage_ = other.errorMessage_;
        onChanged();
      }
      if (resultsBuilder_ == null) {
        if (!other.results_.isEmpty()) {
          if (results_.isEmpty()) {
            results_ = other.results_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureResultsIsMutable();
            results_.addAll(other.results_);
          }
          onChanged();
        }
      } else {
        if (!other.results_.isEmpty()) {
          if (resultsBuilder_.isEmpty()) {
            resultsBuilder_.dispose();
            resultsBuilder_ = null;
            results_ = other.results_;
            bitField0_ = (bitField0_ & ~0x00000004);
            resultsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getResultsFieldBuilder() : null;
          } else {
            resultsBuilder_.addAllMessages(other.results_);
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
      main.java.entities.SearchResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.entities.SearchResponse) e.getUnfinishedMessage();
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

    private java.util.List<main.java.entities.NodeSearchResult> results_ =
      java.util.Collections.emptyList();
    private void ensureResultsIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        results_ = new java.util.ArrayList<main.java.entities.NodeSearchResult>(results_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        main.java.entities.NodeSearchResult, main.java.entities.NodeSearchResult.Builder, main.java.entities.NodeSearchResultOrBuilder> resultsBuilder_;

    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public java.util.List<main.java.entities.NodeSearchResult> getResultsList() {
      if (resultsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(results_);
      } else {
        return resultsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public int getResultsCount() {
      if (resultsBuilder_ == null) {
        return results_.size();
      } else {
        return resultsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public main.java.entities.NodeSearchResult getResults(int index) {
      if (resultsBuilder_ == null) {
        return results_.get(index);
      } else {
        return resultsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder setResults(
        int index, main.java.entities.NodeSearchResult value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.set(index, value);
        onChanged();
      } else {
        resultsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder setResults(
        int index, main.java.entities.NodeSearchResult.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.set(index, builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder addResults(main.java.entities.NodeSearchResult value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.add(value);
        onChanged();
      } else {
        resultsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder addResults(
        int index, main.java.entities.NodeSearchResult value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.add(index, value);
        onChanged();
      } else {
        resultsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder addResults(
        main.java.entities.NodeSearchResult.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.add(builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder addResults(
        int index, main.java.entities.NodeSearchResult.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.add(index, builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder addAllResults(
        java.lang.Iterable<? extends main.java.entities.NodeSearchResult> values) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, results_);
        onChanged();
      } else {
        resultsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder clearResults() {
      if (resultsBuilder_ == null) {
        results_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        resultsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public Builder removeResults(int index) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.remove(index);
        onChanged();
      } else {
        resultsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public main.java.entities.NodeSearchResult.Builder getResultsBuilder(
        int index) {
      return getResultsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public main.java.entities.NodeSearchResultOrBuilder getResultsOrBuilder(
        int index) {
      if (resultsBuilder_ == null) {
        return results_.get(index);  } else {
        return resultsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public java.util.List<? extends main.java.entities.NodeSearchResultOrBuilder> 
         getResultsOrBuilderList() {
      if (resultsBuilder_ != null) {
        return resultsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(results_);
      }
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public main.java.entities.NodeSearchResult.Builder addResultsBuilder() {
      return getResultsFieldBuilder().addBuilder(
          main.java.entities.NodeSearchResult.getDefaultInstance());
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public main.java.entities.NodeSearchResult.Builder addResultsBuilder(
        int index) {
      return getResultsFieldBuilder().addBuilder(
          index, main.java.entities.NodeSearchResult.getDefaultInstance());
    }
    /**
     * <code>repeated .NodeSearchResult results = 3;</code>
     */
    public java.util.List<main.java.entities.NodeSearchResult.Builder> 
         getResultsBuilderList() {
      return getResultsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        main.java.entities.NodeSearchResult, main.java.entities.NodeSearchResult.Builder, main.java.entities.NodeSearchResultOrBuilder> 
        getResultsFieldBuilder() {
      if (resultsBuilder_ == null) {
        resultsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            main.java.entities.NodeSearchResult, main.java.entities.NodeSearchResult.Builder, main.java.entities.NodeSearchResultOrBuilder>(
                results_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        results_ = null;
      }
      return resultsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:SearchResponse)
  }

  // @@protoc_insertion_point(class_scope:SearchResponse)
  private static final main.java.entities.SearchResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.entities.SearchResponse();
  }

  public static main.java.entities.SearchResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchResponse>
      PARSER = new com.google.protobuf.AbstractParser<SearchResponse>() {
    public SearchResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SearchResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SearchResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchResponse> getParserForType() {
    return PARSER;
  }

  public main.java.entities.SearchResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

