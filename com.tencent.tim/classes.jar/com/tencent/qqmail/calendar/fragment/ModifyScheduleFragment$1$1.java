package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMSchedule;

class ModifyScheduleFragment$1$1
  implements Runnable
{
  ModifyScheduleFragment$1$1(ModifyScheduleFragment.1 param1, QMCalendarEvent paramQMCalendarEvent, long paramLong) {}
  
  public void run()
  {
    if ((this.val$event != null) && (ModifyScheduleFragment.access$000(this.this$1.this$0) != null) && (ModifyScheduleFragment.access$000(this.this$1.this$0).getEid() == this.val$event.getId()))
    {
      ModifyScheduleFragment.access$000(this.this$1.this$0).setEid(this.val$newEventId);
      ModifyScheduleFragment.access$000(this.this$1.this$0).setId(QMSchedule.generateId(ModifyScheduleFragment.access$000(this.this$1.this$0)));
      if (ModifyScheduleFragment.access$100(this.this$1.this$0) != null) {
        ModifyScheduleFragment.access$100(this.this$1.this$0).setId(this.val$newEventId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.1.1
 * JD-Core Version:    0.7.0.1
 */