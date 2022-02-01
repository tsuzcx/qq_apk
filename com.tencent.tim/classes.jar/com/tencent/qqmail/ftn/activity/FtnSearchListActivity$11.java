package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FtnSearchListActivity$11
  implements View.OnClickListener
{
  FtnSearchListActivity$11(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideKeyBoard();
    FtnSearchListActivity.access$1900(this.this$0);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.11
 * JD-Core Version:    0.7.0.1
 */