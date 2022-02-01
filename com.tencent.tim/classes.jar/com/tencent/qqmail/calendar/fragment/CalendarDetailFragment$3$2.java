package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.utilities.ui.QMTips;

class CalendarDetailFragment$3$2
  implements Runnable
{
  CalendarDetailFragment$3$2(CalendarDetailFragment.3 param3, String paramString) {}
  
  public void run()
  {
    this.this$1.this$0.getTips().hide();
    if (CalendarDetailFragment.access$600(this.this$1.this$0) == 1) {
      CalendarDetailFragment.access$700(this.this$1.this$0, this.val$url);
    }
    do
    {
      return;
      if (CalendarDetailFragment.access$600(this.this$1.this$0) == 2)
      {
        CalendarDetailFragment.access$800(this.this$1.this$0, this.val$url);
        return;
      }
    } while (CalendarDetailFragment.access$600(this.this$1.this$0) != 3);
    CalendarDetailFragment.access$900(this.this$1.this$0, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.3.2
 * JD-Core Version:    0.7.0.1
 */