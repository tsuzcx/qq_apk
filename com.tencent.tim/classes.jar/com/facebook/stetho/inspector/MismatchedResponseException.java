package com.facebook.stetho.inspector;

public class MismatchedResponseException
  extends MessageHandlingException
{
  public long mRequestId;
  
  public MismatchedResponseException(long paramLong)
  {
    super("Response for request id " + paramLong + ", but no such request is pending");
    this.mRequestId = paramLong;
  }
  
  public long getRequestId()
  {
    return this.mRequestId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.MismatchedResponseException
 * JD-Core Version:    0.7.0.1
 */