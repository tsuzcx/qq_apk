package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;

class ReadScheduleFragment$14
  implements View.OnClickListener
{
  ReadScheduleFragment$14(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    ReadEventBodyFragment localReadEventBodyFragment = new ReadEventBodyFragment();
    localReadEventBodyFragment.prepareBodyText(ReadScheduleFragment.access$100(this.this$0).getBody());
    this.this$0.startFragment(localReadEventBodyFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.14
 * JD-Core Version:    0.7.0.1
 */