package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarListFragment$8
  implements View.OnClickListener
{
  CalendarListFragment$8(CalendarListFragment paramCalendarListFragment) {}
  
  public void onClick(View paramView)
  {
    CalendarListFragment.access$200(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.8
 * JD-Core Version:    0.7.0.1
 */