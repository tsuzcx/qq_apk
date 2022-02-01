package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FtnListActivity$19
  implements View.OnClickListener
{
  FtnListActivity$19(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    FtnListActivity.access$3900(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.19
 * JD-Core Version:    0.7.0.1
 */