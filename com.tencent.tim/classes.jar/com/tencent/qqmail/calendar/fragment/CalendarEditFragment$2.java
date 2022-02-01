package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import moai.oss.KvHelper;

class CalendarEditFragment$2
  implements View.OnClickListener
{
  CalendarEditFragment$2(CalendarEditFragment paramCalendarEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (!CalendarEditFragment.access$000(this.this$0).getText().toString().isEmpty()) {
      if (CalendarEditFragment.access$100(this.this$0) == 0)
      {
        KvHelper.eventCalendarAddCalendar(new double[0]);
        CalendarEditFragment.access$200(this.this$0);
        this.this$0.popBackStack();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (CalendarEditFragment.access$100(this.this$0) == 1)
      {
        KvHelper.eventCalendarModifyCalendar(new double[0]);
        CalendarEditFragment.access$300(this.this$0);
        CalendarEditFragment.access$400(this.this$0);
        this.this$0.popBackStack();
        continue;
        this.this$0.popBackStack();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarEditFragment.2
 * JD-Core Version:    0.7.0.1
 */