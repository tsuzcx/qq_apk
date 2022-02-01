package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;

class ModifyScheduleFragment$1
  implements ScheduleUpdateWatcher
{
  ModifyScheduleFragment$1(ModifyScheduleFragment paramModifyScheduleFragment) {}
  
  public void onUpdateCache(QMCalendarEvent paramQMCalendarEvent, long paramLong)
  {
    ModifyScheduleFragment.access$200(this.this$0, new ModifyScheduleFragment.1.1(this, paramQMCalendarEvent, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.1
 * JD-Core Version:    0.7.0.1
 */