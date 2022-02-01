package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;

class ReadIcsFragment$4
  implements View.OnClickListener
{
  ReadIcsFragment$4(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onClick(View paramView)
  {
    ReadIcsBodyFragment localReadIcsBodyFragment = new ReadIcsBodyFragment();
    localReadIcsBodyFragment.prepareBodyText(ReadIcsFragment.access$000(this.this$0).getBody());
    this.this$0.startFragment(localReadIcsBodyFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.4
 * JD-Core Version:    0.7.0.1
 */