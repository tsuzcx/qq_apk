package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConvMailListFragment$16
  implements View.OnClickListener
{
  ConvMailListFragment$16(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ConvMailListFragment.access$2200(this.this$0)) {
      ConvMailListFragment.access$400(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.16
 * JD-Core Version:    0.7.0.1
 */