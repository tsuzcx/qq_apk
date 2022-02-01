package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleConversationFragment$3
  implements View.OnClickListener
{
  BottleConversationFragment$3(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    BottleConversationFragment.access$200(this.this$0, true);
    BottleConversationFragment.access$301(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.3
 * JD-Core Version:    0.7.0.1
 */