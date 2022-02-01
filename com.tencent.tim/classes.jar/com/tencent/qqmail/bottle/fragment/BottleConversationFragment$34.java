package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleConversationController;

class BottleConversationFragment$34
  implements View.OnClickListener
{
  BottleConversationFragment$34(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    BottleConversationFragment.access$700(this.this$0).loadConversation(BottleConversationFragment.access$500(this.this$0), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.34
 * JD-Core Version:    0.7.0.1
 */