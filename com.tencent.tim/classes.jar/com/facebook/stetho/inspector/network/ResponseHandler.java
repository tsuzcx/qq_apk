package com.facebook.stetho.inspector.network;

import java.io.IOException;

public abstract interface ResponseHandler
{
  public abstract void onEOF();
  
  public abstract void onError(IOException paramIOException);
  
  public abstract void onRead(int paramInt);
  
  public abstract void onReadDecoded(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.ResponseHandler
 * JD-Core Version:    0.7.0.1
 */