package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadMailFragment$110
  implements View.OnClickListener
{
  ReadMailFragment$110(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onButtonBackClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.110
 * JD-Core Version:    0.7.0.1
 */