package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FtnListActivity$22
  implements View.OnClickListener
{
  FtnListActivity$22(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!FtnListActivity.access$4100(this.this$0)) {
      FtnListActivity.access$4800(this.this$0, paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FtnListActivity.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.22
 * JD-Core Version:    0.7.0.1
 */