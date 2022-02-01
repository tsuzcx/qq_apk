package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarMainFragment$2
  implements View.OnClickListener
{
  CalendarMainFragment$2(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(View paramView)
  {
    CalendarListFragment localCalendarListFragment = new CalendarListFragment(0);
    this.this$0.startFragment(localCalendarListFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.2
 * JD-Core Version:    0.7.0.1
 */