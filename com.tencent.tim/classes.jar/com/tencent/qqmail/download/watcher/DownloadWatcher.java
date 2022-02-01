package com.tencent.qqmail.download.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface DownloadWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, long paramLong, Object paramObject);
  
  public abstract void onProcess(int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onSuccess(int paramInt, long paramLong, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.watcher.DownloadWatcher
 * JD-Core Version:    0.7.0.1
 */