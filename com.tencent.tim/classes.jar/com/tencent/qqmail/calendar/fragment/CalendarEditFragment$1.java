package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarEditFragment$1
  implements View.OnClickListener
{
  CalendarEditFragment$1(CalendarEditFragment paramCalendarEditFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideKeyBoard();
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarEditFragment.1
 * JD-Core Version:    0.7.0.1
 */