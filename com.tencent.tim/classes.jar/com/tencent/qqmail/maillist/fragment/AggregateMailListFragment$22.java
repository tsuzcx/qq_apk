package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AggregateMailListFragment$22
  implements View.OnClickListener
{
  AggregateMailListFragment$22(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AggregateMailListFragment.access$800(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AggregateMailListFragment.access$2800(this.this$0).length > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label52;
        }
        AggregateMailListFragment.access$2900(this.this$0, 7);
        break;
      }
      label52:
      AggregateMailListFragment.access$3000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.22
 * JD-Core Version:    0.7.0.1
 */