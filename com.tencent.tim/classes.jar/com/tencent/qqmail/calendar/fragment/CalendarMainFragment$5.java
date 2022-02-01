package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.view.CalendarViewGroup;

class CalendarMainFragment$5
  implements View.OnClickListener
{
  CalendarMainFragment$5(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(View paramView)
  {
    CalendarMainFragment.access$400(this.this$0).snapToTodayScreen();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.5
 * JD-Core Version:    0.7.0.1
 */