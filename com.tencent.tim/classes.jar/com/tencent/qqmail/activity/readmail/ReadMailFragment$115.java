package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadMailFragment$115
  implements View.OnClickListener
{
  ReadMailFragment$115(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    ReadMailFragment.access$17600(this.this$0);
    ReadMailFragment.access$17500(this.this$0, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.115
 * JD-Core Version:    0.7.0.1
 */