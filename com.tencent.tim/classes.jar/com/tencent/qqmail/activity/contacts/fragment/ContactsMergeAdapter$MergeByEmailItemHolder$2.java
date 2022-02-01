package com.tencent.qqmail.activity.contacts.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsMergeAdapter$MergeByEmailItemHolder$2
  implements CompoundButton.OnCheckedChangeListener
{
  ContactsMergeAdapter$MergeByEmailItemHolder$2(ContactsMergeAdapter.MergeByEmailItemHolder paramMergeByEmailItemHolder, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.this$1.isCheck = paramBoolean;
    ContactsMergeAdapter.access$100(this.this$1.this$0).onEmailListItemClick(this.val$position, this.this$1.isCheck);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeAdapter.MergeByEmailItemHolder.2
 * JD-Core Version:    0.7.0.1
 */