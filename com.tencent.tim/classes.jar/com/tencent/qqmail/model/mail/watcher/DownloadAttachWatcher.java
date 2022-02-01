package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface DownloadAttachWatcher
  extends Watchers.Watcher
{
  public abstract boolean abort();
  
  public abstract boolean goOn();
  
  public abstract boolean isAbort();
  
  public abstract boolean isMatch(long paramLong);
  
  public abstract void onError(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, Object paramObject);
  
  public abstract void onProcess(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
  
  public abstract void onSuccess(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.DownloadAttachWatcher
 * JD-Core Version:    0.7.0.1
 */