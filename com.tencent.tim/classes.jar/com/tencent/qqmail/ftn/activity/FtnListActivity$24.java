package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FtnListActivity$24
  implements View.OnClickListener
{
  FtnListActivity$24(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!FtnListActivity.access$2800(this.this$0)) {
      FtnListActivity.access$4900(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FtnListActivity.access$5100(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.24
 * JD-Core Version:    0.7.0.1
 */