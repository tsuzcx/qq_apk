package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.FtnManager;

class FtnListActivity$18
  implements View.OnClickListener
{
  FtnListActivity$18(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    FtnListActivity.access$1000(this.this$0, 1);
    FtnListActivity.access$500(this.this$0).getList();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.18
 * JD-Core Version:    0.7.0.1
 */