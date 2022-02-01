package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface SyncNickWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SyncNickWatcher
 * JD-Core Version:    0.7.0.1
 */