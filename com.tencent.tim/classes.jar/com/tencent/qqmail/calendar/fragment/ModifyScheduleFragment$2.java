package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ModifyScheduleFragment$2
  implements View.OnClickListener
{
  ModifyScheduleFragment$2(ModifyScheduleFragment paramModifyScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    ModifyScheduleFragment.access$302(this.this$0, -1);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.2
 * JD-Core Version:    0.7.0.1
 */