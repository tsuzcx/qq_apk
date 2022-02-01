package com.facebook.stetho.websocket;

public abstract interface SimpleSession
{
  public abstract void close(int paramInt, String paramString);
  
  public abstract boolean isOpen();
  
  public abstract void sendBinary(byte[] paramArrayOfByte);
  
  public abstract void sendText(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.SimpleSession
 * JD-Core Version:    0.7.0.1
 */