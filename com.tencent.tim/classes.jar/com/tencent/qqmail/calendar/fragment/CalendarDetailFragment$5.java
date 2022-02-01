package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarDetailFragment$5
  implements View.OnClickListener
{
  CalendarDetailFragment$5(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onClick(View paramView)
  {
    CalendarEditFragment localCalendarEditFragment = new CalendarEditFragment(CalendarDetailFragment.access$100(this.this$0));
    this.this$0.startFragment(localCalendarEditFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.5
 * JD-Core Version:    0.7.0.1
 */