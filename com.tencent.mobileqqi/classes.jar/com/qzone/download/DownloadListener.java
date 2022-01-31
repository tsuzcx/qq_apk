package com.qzone.download;

public abstract interface DownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString, DownloadResult paramDownloadResult);
  
  public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.DownloadListener
 * JD-Core Version:    0.7.0.1
 */