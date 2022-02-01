package com.tencent.qqmail.calendar.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarShareWXUrlWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(int paramInt);
  
  public abstract void onSuccess(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.CalendarShareWXUrlWatcher
 * JD-Core Version:    0.7.0.1
 */