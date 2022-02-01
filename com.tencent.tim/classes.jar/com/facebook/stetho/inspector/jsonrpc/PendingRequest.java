package com.facebook.stetho.inspector.jsonrpc;

import javax.annotation.Nullable;

public class PendingRequest
{
  @Nullable
  public final PendingRequestCallback callback;
  public final long requestId;
  
  public PendingRequest(long paramLong, @Nullable PendingRequestCallback paramPendingRequestCallback)
  {
    this.requestId = paramLong;
    this.callback = paramPendingRequestCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.PendingRequest
 * JD-Core Version:    0.7.0.1
 */