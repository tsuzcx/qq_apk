package com.tencent.qqmail.calendar.watcher;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import moai.core.watcher.Watchers.Watcher;

public abstract interface ScheduleUpdateWatcher
  extends Watchers.Watcher
{
  public abstract void onUpdateCache(QMCalendarEvent paramQMCalendarEvent, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher
 * JD-Core Version:    0.7.0.1
 */