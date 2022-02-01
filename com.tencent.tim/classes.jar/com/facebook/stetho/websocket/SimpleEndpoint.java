package com.facebook.stetho.websocket;

public abstract interface SimpleEndpoint
{
  public abstract void onClose(SimpleSession paramSimpleSession, int paramInt, String paramString);
  
  public abstract void onError(SimpleSession paramSimpleSession, Throwable paramThrowable);
  
  public abstract void onMessage(SimpleSession paramSimpleSession, String paramString);
  
  public abstract void onMessage(SimpleSession paramSimpleSession, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onOpen(SimpleSession paramSimpleSession);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.SimpleEndpoint
 * JD-Core Version:    0.7.0.1
 */