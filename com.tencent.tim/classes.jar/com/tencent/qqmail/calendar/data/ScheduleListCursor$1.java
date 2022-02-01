package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Calendar;

class ScheduleListCursor$1
  implements Runnable
{
  ScheduleListCursor$1(ScheduleListCursor paramScheduleListCursor, Calendar paramCalendar, ScheduleLoadWatcher paramScheduleLoadWatcher) {}
  
  public void run()
  {
    Threads.runOnMainThread(new ScheduleListCursor.1.1(this, QMCalendarManager.getInstance().getScheduleListCursor(this.val$day)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.ScheduleListCursor.1
 * JD-Core Version:    0.7.0.1
 */