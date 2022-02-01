package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarShareFragment$5
  implements View.OnClickListener
{
  CalendarShareFragment$5(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.5
 * JD-Core Version:    0.7.0.1
 */