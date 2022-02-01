package com.facebook.stetho.inspector.network;

import java.io.IOException;

public class DefaultResponseHandler
  implements ResponseHandler
{
  private int mBytesRead = 0;
  private int mDecodedBytesRead = -1;
  private final NetworkEventReporter mEventReporter;
  private final String mRequestId;
  
  public DefaultResponseHandler(NetworkEventReporter paramNetworkEventReporter, String paramString)
  {
    this.mEventReporter = paramNetworkEventReporter;
    this.mRequestId = paramString;
  }
  
  private void reportDataReceived()
  {
    NetworkEventReporter localNetworkEventReporter = this.mEventReporter;
    String str = this.mRequestId;
    int j = this.mBytesRead;
    if (this.mDecodedBytesRead >= 0) {}
    for (int i = this.mDecodedBytesRead;; i = this.mBytesRead)
    {
      localNetworkEventReporter.dataReceived(str, j, i);
      return;
    }
  }
  
  public void onEOF()
  {
    reportDataReceived();
    this.mEventReporter.responseReadFinished(this.mRequestId);
  }
  
  public void onError(IOException paramIOException)
  {
    reportDataReceived();
    this.mEventReporter.responseReadFailed(this.mRequestId, paramIOException.toString());
  }
  
  public void onRead(int paramInt)
  {
    this.mBytesRead += paramInt;
  }
  
  public void onReadDecoded(int paramInt)
  {
    if (this.mDecodedBytesRead == -1) {
      this.mDecodedBytesRead = 0;
    }
    this.mDecodedBytesRead += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.DefaultResponseHandler
 * JD-Core Version:    0.7.0.1
 */