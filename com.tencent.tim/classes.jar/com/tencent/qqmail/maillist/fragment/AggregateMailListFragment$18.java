package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AggregateMailListFragment$18
  implements View.OnClickListener
{
  AggregateMailListFragment$18(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!AggregateMailListFragment.access$2400(this.this$0)) {
      this.this$0.onButtonBackClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AggregateMailListFragment.access$2500(this.this$0)) {
        AggregateMailListFragment.access$2600(this.this$0, false);
      } else {
        AggregateMailListFragment.access$2600(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.18
 * JD-Core Version:    0.7.0.1
 */