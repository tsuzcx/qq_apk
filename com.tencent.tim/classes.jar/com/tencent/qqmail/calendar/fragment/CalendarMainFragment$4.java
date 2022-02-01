package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.view.CalendarViewGroup;

class CalendarMainFragment$4
  implements View.OnClickListener
{
  CalendarMainFragment$4(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(View paramView)
  {
    ModifyScheduleFragment localModifyScheduleFragment = new ModifyScheduleFragment(CalendarMainFragment.access$400(this.this$0).getSelectedDay());
    this.this$0.startFragment(localModifyScheduleFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.4
 * JD-Core Version:    0.7.0.1
 */