package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarShareFragment$6
  implements View.OnClickListener
{
  CalendarShareFragment$6(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void onClick(View paramView)
  {
    CalendarShareFragment.access$1100(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.6
 * JD-Core Version:    0.7.0.1
 */