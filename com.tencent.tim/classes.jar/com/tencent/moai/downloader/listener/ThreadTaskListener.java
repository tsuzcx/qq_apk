package com.tencent.moai.downloader.listener;

import com.tencent.moai.downloader.exception.ThreadTaskError;

public abstract interface ThreadTaskListener
{
  public abstract void onAbort(long paramLong1, long paramLong2, String paramString);
  
  public abstract void onFail(long paramLong1, long paramLong2, String paramString, ThreadTaskError paramThreadTaskError);
  
  public abstract void onProgress(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4);
  
  public abstract void onReceiveHeader(long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void onStart(long paramLong1, long paramLong2, String paramString);
  
  public abstract void onSuccess(long paramLong1, long paramLong2, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.listener.ThreadTaskListener
 * JD-Core Version:    0.7.0.1
 */