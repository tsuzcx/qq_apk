package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface QMCalendarSyncICSWatcher
  extends Watchers.Watcher
{
  public abstract void onComplete(int paramInt);
  
  public abstract void onStart(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.QMCalendarSyncICSWatcher
 * JD-Core Version:    0.7.0.1
 */