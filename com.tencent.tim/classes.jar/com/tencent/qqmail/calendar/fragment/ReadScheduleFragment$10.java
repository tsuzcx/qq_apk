package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadScheduleFragment$10
  implements View.OnClickListener
{
  ReadScheduleFragment$10(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.10
 * JD-Core Version:    0.7.0.1
 */