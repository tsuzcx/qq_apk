package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleConversationFragment$8
  implements View.OnClickListener
{
  BottleConversationFragment$8(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.showPopWindow(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.8
 * JD-Core Version:    0.7.0.1
 */