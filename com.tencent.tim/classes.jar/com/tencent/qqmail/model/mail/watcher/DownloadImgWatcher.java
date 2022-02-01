package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface DownloadImgWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long paramLong, String paramString1, String paramString2, Object paramObject);
  
  public abstract void onProcess(long paramLong1, String paramString, long paramLong2, long paramLong3);
  
  public abstract void onSuccess(long paramLong, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher
 * JD-Core Version:    0.7.0.1
 */