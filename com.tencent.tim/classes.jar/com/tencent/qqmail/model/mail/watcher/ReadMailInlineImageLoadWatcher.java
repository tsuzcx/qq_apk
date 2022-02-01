package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface ReadMailInlineImageLoadWatcher
  extends Watchers.Watcher
{
  public abstract boolean abort();
  
  public abstract boolean goOn();
  
  public abstract boolean isAbort();
  
  public abstract boolean isMatch(String paramString);
  
  public abstract void onError(long paramLong, String paramString, int paramInt);
  
  public abstract void onProcess(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt);
  
  public abstract void onSuccess(long paramLong, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.ReadMailInlineImageLoadWatcher
 * JD-Core Version:    0.7.0.1
 */