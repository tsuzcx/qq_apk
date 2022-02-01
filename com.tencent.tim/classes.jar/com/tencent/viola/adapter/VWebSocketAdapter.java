package com.tencent.viola.adapter;

import android.support.annotation.Nullable;

public abstract interface VWebSocketAdapter
{
  public static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
  
  public abstract void close(int paramInt, String paramString);
  
  public abstract void connect(String paramString1, @Nullable String paramString2, EventListener paramEventListener);
  
  public abstract void destroy();
  
  public abstract void disconnect();
  
  public abstract void send(String paramString);
  
  public static abstract interface EventListener
  {
    public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void onError(String paramString);
    
    public abstract void onMessage(String paramString);
    
    public abstract void onOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.VWebSocketAdapter
 * JD-Core Version:    0.7.0.1
 */