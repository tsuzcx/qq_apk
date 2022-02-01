package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;

class ReadScheduleFragment$1
  implements ScheduleUpdateWatcher
{
  ReadScheduleFragment$1(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onUpdateCache(QMCalendarEvent paramQMCalendarEvent, long paramLong)
  {
    ReadScheduleFragment.access$200(this.this$0, new ReadScheduleFragment.1.1(this, paramQMCalendarEvent, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.1
 * JD-Core Version:    0.7.0.1
 */