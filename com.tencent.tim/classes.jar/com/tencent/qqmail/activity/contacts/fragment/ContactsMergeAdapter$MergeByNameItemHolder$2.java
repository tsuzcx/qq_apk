package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsMergeAdapter$MergeByNameItemHolder$2
  implements View.OnClickListener
{
  ContactsMergeAdapter$MergeByNameItemHolder$2(ContactsMergeAdapter.MergeByNameItemHolder paramMergeByNameItemHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ContactsMergeAdapter.MergeByNameItemHolder localMergeByNameItemHolder = this.this$1;
    if (!this.this$1.isCheck) {}
    for (boolean bool = true;; bool = false)
    {
      localMergeByNameItemHolder.isCheck = bool;
      this.this$1.mCheckBox.setChecked(this.this$1.isCheck);
      ContactsMergeAdapter.access$100(this.this$1.this$0).onNameListItemClick(this.val$position, this.this$1.isCheck);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeAdapter.MergeByNameItemHolder.2
 * JD-Core Version:    0.7.0.1
 */