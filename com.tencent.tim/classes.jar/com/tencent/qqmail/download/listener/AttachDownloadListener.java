package com.tencent.qqmail.download.listener;

import java.io.File;

public abstract interface AttachDownloadListener
{
  public abstract void onBeforeSend(String paramString);
  
  public abstract void onError(String paramString, Object paramObject);
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onSuccess(String paramString1, File paramFile, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.listener.AttachDownloadListener
 * JD-Core Version:    0.7.0.1
 */