package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AggregateMailListFragment$19
  implements View.OnClickListener
{
  AggregateMailListFragment$19(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AggregateMailListFragment.access$2400(this.this$0)) {
      AggregateMailListFragment.access$400(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.19
 * JD-Core Version:    0.7.0.1
 */