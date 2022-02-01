package net.jarlehansen.protobuf.original.input;

import java.io.IOException;

public class InvalidProtocolBufferException
  extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;
  
  public InvalidProtocolBufferException(String paramString)
  {
    super(paramString);
  }
  
  static InvalidProtocolBufferException invalidTag()
  {
    return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
  }
  
  static InvalidProtocolBufferException malformedVarint()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
  }
  
  static InvalidProtocolBufferException negativeSize()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static InvalidProtocolBufferException sizeLimitExceeded()
  {
    return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static InvalidProtocolBufferException truncatedMessage()
  {
    return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.original.input.InvalidProtocolBufferException
 * JD-Core Version:    0.7.0.1
 */