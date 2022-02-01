package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactCustomItemView$2
  implements View.OnClickListener
{
  ContactCustomItemView$2(ContactCustomItemView paramContactCustomItemView) {}
  
  public void onClick(View paramView)
  {
    ContactCustomItemView.access$200(this.this$0);
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      this.this$0.contactItemViewOperateCallback.notifyDataChange();
      this.this$0.contactItemViewOperateCallback.removeSelf();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView.2
 * JD-Core Version:    0.7.0.1
 */