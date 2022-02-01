package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import java.util.concurrent.Callable;

class ReadScheduleFragment$12
  implements Callable<Boolean>
{
  ReadScheduleFragment$12(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public Boolean call()
  {
    ReadScheduleFragment.access$102(this.this$0, QMCalendarManager.getInstance().getDetailCalendarEventFromSchedule(ReadScheduleFragment.access$000(this.this$0)));
    if ((ReadScheduleFragment.access$100(this.this$0) != null) && (ReadScheduleFragment.access$100(this.this$0).isICSEvent())) {
      QMCalendarManager.logEvent("Event_Calendar_Preview_Ics");
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.12
 * JD-Core Version:    0.7.0.1
 */