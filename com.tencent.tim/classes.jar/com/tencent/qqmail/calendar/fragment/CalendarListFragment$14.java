package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;

class CalendarListFragment$14
  implements View.OnClickListener
{
  CalendarListFragment$14(CalendarListFragment paramCalendarListFragment, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void onClick(View paramView)
  {
    CalendarDetailFragment localCalendarDetailFragment = new CalendarDetailFragment(this.val$calendar);
    this.this$0.startFragment(localCalendarDetailFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.14
 * JD-Core Version:    0.7.0.1
 */