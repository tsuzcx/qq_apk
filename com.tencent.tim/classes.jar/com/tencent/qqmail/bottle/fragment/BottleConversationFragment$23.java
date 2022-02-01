package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;
import com.tencent.qqmail.bottle.model.BottleConversation;

class BottleConversationFragment$23
  implements AdapterView.OnItemClickListener
{
  BottleConversationFragment$23(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong < 0L) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      BottleConversation localBottleConversation = BottleConversationFragment.access$1600(this.this$0).getItem((int)paramLong);
      if (localBottleConversation.isUnsend() == true) {
        BottleConversationFragment.access$1900(this.this$0, localBottleConversation);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.23
 * JD-Core Version:    0.7.0.1
 */