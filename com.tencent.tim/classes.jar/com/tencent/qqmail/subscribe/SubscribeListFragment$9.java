package com.tencent.qqmail.subscribe;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeListFragment$9
  implements View.OnClickListener
{
  SubscribeListFragment$9(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onButtonBackClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.9
 * JD-Core Version:    0.7.0.1
 */