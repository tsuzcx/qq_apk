package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface SendMailWatcher
  extends Watchers.Watcher
{
  public abstract void onBeforeSend(String paramString, Object paramObject);
  
  public abstract void onComplete(String paramString);
  
  public abstract void onError(String paramString, Object paramObject);
  
  public abstract void onProgress(String paramString, double paramDouble);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SendMailWatcher
 * JD-Core Version:    0.7.0.1
 */