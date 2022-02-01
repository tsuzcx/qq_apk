package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class WebSocketProxy
{
  private static AtomicInteger sWebSocketRequestId = new AtomicInteger();
  
  public static int getWebSocketRequestId()
  {
    return sWebSocketRequestId.getAndIncrement();
  }
  
  public abstract boolean closeSocket(int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketListener paramWebSocketListener);
  
  public abstract boolean send(int paramInt, String paramString);
  
  public abstract boolean send(int paramInt, byte[] paramArrayOfByte);
  
  public static abstract interface WebSocketListener
  {
    public abstract void onClose(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onError(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onMessage(int paramInt, String paramString);
    
    public abstract void onMessage(int paramInt, byte[] paramArrayOfByte);
    
    public abstract void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy
 * JD-Core Version:    0.7.0.1
 */