package com.tencent.moai.downloader.listener;

import com.tencent.moai.downloader.exception.DownloadTaskError;

public abstract interface DownloadTaskListener
{
  public abstract void onAbort(long paramLong, String paramString);
  
  public abstract void onFail(long paramLong, String paramString, DownloadTaskError paramDownloadTaskError);
  
  public abstract void onProgress(long paramLong1, String paramString, long paramLong2, long paramLong3);
  
  public abstract void onStart(long paramLong, String paramString);
  
  public abstract void onSuccess(long paramLong, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.listener.DownloadTaskListener
 * JD-Core Version:    0.7.0.1
 */