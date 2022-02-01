package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;

class ReadScheduleFragment$21
  implements Runnable
{
  ReadScheduleFragment$21(ReadScheduleFragment paramReadScheduleFragment, QMCalendarEvent paramQMCalendarEvent, int paramInt, QMSchedule paramQMSchedule) {}
  
  public void run()
  {
    if (this.val$event.getCategory() == 1)
    {
      CalendarProviderManager.sharedInstance().deleteLocalEvent(ReadScheduleFragment.access$100(this.this$0).getId(), this.val$modifyType, this.val$schedule);
      return;
    }
    QMCalendarManager.getInstance().deleteEvent(ReadScheduleFragment.access$100(this.this$0).getId(), this.val$modifyType, this.val$schedule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.21
 * JD-Core Version:    0.7.0.1
 */