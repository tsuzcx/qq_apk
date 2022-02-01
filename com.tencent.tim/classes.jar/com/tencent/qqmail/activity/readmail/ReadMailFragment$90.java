package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadMailFragment$90
  implements View.OnClickListener
{
  ReadMailFragment$90(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    ReadMailFragment.access$4800(this.this$0);
    ReadMailFragment.access$16000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.90
 * JD-Core Version:    0.7.0.1
 */