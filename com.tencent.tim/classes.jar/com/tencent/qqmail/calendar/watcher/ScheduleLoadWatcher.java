package com.tencent.qqmail.calendar.watcher;

import java.util.Calendar;
import moai.core.watcher.Watchers.Watcher;

public abstract interface ScheduleLoadWatcher
  extends Watchers.Watcher
{
  public abstract void onLoadSuccess(Calendar paramCalendar, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher
 * JD-Core Version:    0.7.0.1
 */