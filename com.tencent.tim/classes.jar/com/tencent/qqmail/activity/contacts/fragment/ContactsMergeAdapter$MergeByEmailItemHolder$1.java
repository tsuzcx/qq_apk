package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsMergeAdapter$MergeByEmailItemHolder$1
  implements View.OnClickListener
{
  ContactsMergeAdapter$MergeByEmailItemHolder$1(ContactsMergeAdapter.MergeByEmailItemHolder paramMergeByEmailItemHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.this$1.this$0.getOnItemClickListener() != null) {
      this.this$1.this$0.getOnItemClickListener().onChooseNameClick(this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeAdapter.MergeByEmailItemHolder.1
 * JD-Core Version:    0.7.0.1
 */