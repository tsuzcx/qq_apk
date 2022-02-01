package com.tencent.qqmail.calendar.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarFolderCreateWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.CalendarFolderCreateWatcher
 * JD-Core Version:    0.7.0.1
 */