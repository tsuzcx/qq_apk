package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface QMCalendarLoadEventListWatcher
  extends Watchers.Watcher
{
  public abstract void onComplete(int paramInt);
  
  public abstract void onError(int paramInt1, int paramInt2);
  
  public abstract void onProcess(int paramInt1, int paramInt2);
  
  public abstract void onStart(int paramInt);
  
  public abstract void onSuccess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.QMCalendarLoadEventListWatcher
 * JD-Core Version:    0.7.0.1
 */