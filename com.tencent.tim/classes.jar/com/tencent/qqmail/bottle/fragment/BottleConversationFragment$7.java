package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleConversationFragment$7
  implements View.OnClickListener
{
  BottleConversationFragment$7(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    BottleConversationFragment.access$200(this.this$0, true);
    BottleConversationFragment.access$1001(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.7
 * JD-Core Version:    0.7.0.1
 */