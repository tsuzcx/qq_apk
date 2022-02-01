package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.FtnManager;

class ComposeFtnListActivity$7
  implements View.OnClickListener
{
  ComposeFtnListActivity$7(ComposeFtnListActivity paramComposeFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeFtnListActivity.access$1000(this.this$0, 1);
    FtnManager.sharedInstance().getList();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity.7
 * JD-Core Version:    0.7.0.1
 */