package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface ParseEmlWatcher
  extends Watchers.Watcher
{
  public abstract void onError();
  
  public abstract void onSuccess(int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.ParseEmlWatcher
 * JD-Core Version:    0.7.0.1
 */