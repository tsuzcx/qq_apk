package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadIcsFragment$5
  implements View.OnClickListener
{
  ReadIcsFragment$5(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onClick(View paramView)
  {
    ReadIcsAttendeeFragment localReadIcsAttendeeFragment = new ReadIcsAttendeeFragment();
    localReadIcsAttendeeFragment.preEvent(ReadIcsFragment.access$000(this.this$0));
    this.this$0.startFragment(localReadIcsAttendeeFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.5
 * JD-Core Version:    0.7.0.1
 */