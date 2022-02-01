package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

public abstract class UploaderProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean upload(String paramString1, Map<String, String> paramMap1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap2, int paramInt, UploadListener paramUploadListener);
  
  public static abstract interface UploadListener
  {
    public abstract void onUploadFailed(int paramInt, String paramString);
    
    public abstract void onUploadHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
    
    public abstract void onUploadProgress(float paramFloat, long paramLong1, long paramLong2);
    
    public abstract void onUploadSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy
 * JD-Core Version:    0.7.0.1
 */