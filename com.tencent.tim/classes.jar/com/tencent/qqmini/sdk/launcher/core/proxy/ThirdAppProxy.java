package com.tencent.qqmini.sdk.launcher.core.proxy;

import org.json.JSONObject;

public abstract class ThirdAppProxy
{
  public abstract void init();
  
  public abstract boolean installApp(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void queryDownloadTask(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, AppDownloadListener paramAppDownloadListener);
  
  public abstract boolean stopDownloadTask(String paramString);
  
  public abstract void unInit();
  
  public static abstract interface AppDownloadListener
  {
    public abstract void onDownloadComplete();
    
    public abstract void onDownloadFailed(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onDownloadProgress(long paramLong1, long paramLong2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
 * JD-Core Version:    0.7.0.1
 */