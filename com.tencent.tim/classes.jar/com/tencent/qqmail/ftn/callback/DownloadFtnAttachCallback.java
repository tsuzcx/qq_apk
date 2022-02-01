package com.tencent.qqmail.ftn.callback;

public abstract interface DownloadFtnAttachCallback
{
  public abstract void onError(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void onProgress(String paramString, long paramLong);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.callback.DownloadFtnAttachCallback
 * JD-Core Version:    0.7.0.1
 */