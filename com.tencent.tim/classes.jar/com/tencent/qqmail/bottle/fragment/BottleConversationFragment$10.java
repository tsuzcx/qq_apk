package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.ListViewHelper;

class BottleConversationFragment$10
  implements View.OnClickListener
{
  BottleConversationFragment$10(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    ListViewHelper.scrollToTop(this.this$0.getActivity(), BottleConversationFragment.access$400(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.10
 * JD-Core Version:    0.7.0.1
 */