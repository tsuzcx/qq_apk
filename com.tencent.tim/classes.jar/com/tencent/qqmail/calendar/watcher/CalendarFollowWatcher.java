package com.tencent.qqmail.calendar.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarFollowWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString1, String paramString2, String paramString3);
  
  public abstract void onProcess(String paramString1, String paramString2);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.CalendarFollowWatcher
 * JD-Core Version:    0.7.0.1
 */