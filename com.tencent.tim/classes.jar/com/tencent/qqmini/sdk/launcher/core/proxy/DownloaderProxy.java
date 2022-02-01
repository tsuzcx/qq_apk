package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.Map;

public abstract class DownloaderProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloadListener paramDownloadListener);
  
  public abstract void preConnectDownloadHost();
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadFailed(int paramInt, String paramString);
    
    public abstract void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
    
    public abstract void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2);
    
    public abstract void onDownloadSucceed(int paramInt, String paramString, DownloadResult paramDownloadResult);
    
    public static class DownloadResult
    {
      public long connectionTimeMs;
      public final long contentLength;
      public long dnsTimeMs;
      @NonNull
      public final Map<String, List<String>> headers;
      public long httpStatusCode;
      public boolean isFromReusedConnection;
      public String message;
      public long queueTimeMs;
      public long receiveTimeMs;
      public boolean success;
      public final long totalTimeMs;
      public String url;
      
      public DownloadResult(String paramString1, long paramLong1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, @NonNull Map<String, List<String>> paramMap)
      {
        this.url = paramString1;
        this.httpStatusCode = paramLong1;
        this.success = paramBoolean1;
        this.message = paramString2;
        this.isFromReusedConnection = paramBoolean2;
        this.queueTimeMs = paramLong2;
        this.dnsTimeMs = paramLong3;
        this.connectionTimeMs = paramLong4;
        this.receiveTimeMs = paramLong5;
        this.totalTimeMs = paramLong6;
        this.contentLength = paramLong7;
        this.headers = paramMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
 * JD-Core Version:    0.7.0.1
 */