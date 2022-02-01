package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConvMailListFragment$15
  implements View.OnClickListener
{
  ConvMailListFragment$15(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!ConvMailListFragment.access$2200(this.this$0)) {
      ConvMailListFragment.access$2300(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ConvMailListFragment.access$2400(this.this$0)) {
        ConvMailListFragment.access$2500(this.this$0, false);
      } else {
        ConvMailListFragment.access$2500(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.15
 * JD-Core Version:    0.7.0.1
 */