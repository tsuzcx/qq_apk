package com.facebook.stetho.websocket;

import java.io.IOException;

abstract interface WriteCallback
{
  public abstract void onFailure(IOException paramIOException);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WriteCallback
 * JD-Core Version:    0.7.0.1
 */