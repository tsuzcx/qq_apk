package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadScheduleFragment$13
  implements View.OnClickListener
{
  ReadScheduleFragment$13(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    ReadAttendeeFragment localReadAttendeeFragment = new ReadAttendeeFragment();
    localReadAttendeeFragment.preEvent(ReadScheduleFragment.access$100(this.this$0));
    this.this$0.startFragment(localReadAttendeeFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.13
 * JD-Core Version:    0.7.0.1
 */