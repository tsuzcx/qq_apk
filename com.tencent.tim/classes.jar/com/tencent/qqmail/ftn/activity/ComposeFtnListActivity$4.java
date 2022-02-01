package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeFtnListActivity$4
  implements View.OnClickListener
{
  ComposeFtnListActivity$4(ComposeFtnListActivity paramComposeFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeFtnListActivity.access$200(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity.4
 * JD-Core Version:    0.7.0.1
 */