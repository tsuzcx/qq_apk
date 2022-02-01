package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;

class CalendarMainFragment$1$1
  implements Runnable
{
  CalendarMainFragment$1$1(CalendarMainFragment.1 param1, QMCalendarEvent paramQMCalendarEvent) {}
  
  public void run()
  {
    if (this.val$event == null)
    {
      CalendarMainFragment.access$000(this.this$1.this$0);
      CalendarMainFragment.access$100(this.this$1.this$0);
    }
    while (!CalendarMainFragment.access$200(this.this$1.this$0, this.val$event)) {
      return;
    }
    CalendarMainFragment.access$100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.1.1
 * JD-Core Version:    0.7.0.1
 */