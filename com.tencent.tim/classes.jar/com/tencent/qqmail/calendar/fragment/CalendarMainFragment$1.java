package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;

class CalendarMainFragment$1
  implements ScheduleUpdateWatcher
{
  CalendarMainFragment$1(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onUpdateCache(QMCalendarEvent paramQMCalendarEvent, long paramLong)
  {
    CalendarMainFragment.access$300(this.this$0, new CalendarMainFragment.1.1(this, paramQMCalendarEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.1
 * JD-Core Version:    0.7.0.1
 */