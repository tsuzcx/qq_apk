package com.tencent.qqmail.activity.contacts.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsMergeAdapter$MergeByNameItemHolder$1
  implements CompoundButton.OnCheckedChangeListener
{
  ContactsMergeAdapter$MergeByNameItemHolder$1(ContactsMergeAdapter.MergeByNameItemHolder paramMergeByNameItemHolder, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.this$1.isCheck = paramBoolean;
    ContactsMergeAdapter.access$100(this.this$1.this$0).onNameListItemClick(this.val$position, this.this$1.isCheck);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeAdapter.MergeByNameItemHolder.1
 * JD-Core Version:    0.7.0.1
 */