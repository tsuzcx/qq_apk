package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactEditBirthdayItemView$2
  implements View.OnClickListener
{
  ContactEditBirthdayItemView$2(ContactEditBirthdayItemView paramContactEditBirthdayItemView) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.nodeTextViewInput != null)
    {
      this.this$0.setNodeInputText("");
      if (this.this$0.contactItemViewOperateCallback != null) {
        this.this$0.contactItemViewOperateCallback.notifyDataChange();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView.2
 * JD-Core Version:    0.7.0.1
 */