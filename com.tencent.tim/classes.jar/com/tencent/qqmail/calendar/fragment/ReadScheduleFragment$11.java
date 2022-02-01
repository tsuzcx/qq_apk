package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;

class ReadScheduleFragment$11
  implements View.OnClickListener
{
  ReadScheduleFragment$11(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    ModifyScheduleFragment localModifyScheduleFragment = new ModifyScheduleFragment(ReadScheduleFragment.access$100(this.this$0), ReadScheduleFragment.access$000(this.this$0));
    this.this$0.startFragmentForResult(localModifyScheduleFragment, 1);
    ReadScheduleFragment.access$1200(this.this$0).getButtonRight().setEnabled(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.11
 * JD-Core Version:    0.7.0.1
 */