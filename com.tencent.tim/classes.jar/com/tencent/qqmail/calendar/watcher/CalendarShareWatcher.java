package com.tencent.qqmail.calendar.watcher;

import com.tencent.qqmail.calendar.data.CalendarShareError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarShareWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, String[] paramArrayOfString, CalendarShareError paramCalendarShareError);
  
  public abstract void onProcess(int paramInt, String[] paramArrayOfString);
  
  public abstract void onSuccess(int paramInt, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.CalendarShareWatcher
 * JD-Core Version:    0.7.0.1
 */