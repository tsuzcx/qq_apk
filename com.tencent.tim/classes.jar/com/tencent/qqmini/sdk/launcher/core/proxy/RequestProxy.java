package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RequestProxy
{
  private static AtomicInteger sRequestId = new AtomicInteger();
  
  public static int getRequestSocketId()
  {
    return sRequestId.getAndIncrement();
  }
  
  public abstract void abort(String paramString);
  
  public abstract boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestListener paramRequestListener);
  
  public static abstract interface RequestListener
  {
    public abstract void onRequestFailed(int paramInt, String paramString);
    
    public abstract void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
    
    public abstract void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
 * JD-Core Version:    0.7.0.1
 */