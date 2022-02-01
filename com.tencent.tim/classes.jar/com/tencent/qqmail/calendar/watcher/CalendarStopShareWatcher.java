package com.tencent.qqmail.calendar.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarStopShareWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(int paramInt, String paramString);
  
  public abstract void onSuccess(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher
 * JD-Core Version:    0.7.0.1
 */