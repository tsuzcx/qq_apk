package com.tencent.qqmail.ftn.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface FtnDownloadWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt1, String paramString, int paramInt2);
  
  public abstract void onProgress(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract void onSuccess(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.watcher.FtnDownloadWatcher
 * JD-Core Version:    0.7.0.1
 */