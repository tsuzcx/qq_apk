package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactDetailItemView$1
  implements View.OnClickListener
{
  ContactDetailItemView$1(ContactDetailItemView paramContactDetailItemView) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      str = ContactDetailItemView.access$000(this.this$0).getText().toString().replace(" ", "");
      if (!str.isEmpty())
      {
        if (this.this$0.getItemType() != ContactBaseItemView.ContactItemType.TYPE_EMAIL) {
          break label75;
        }
        this.this$0.contactItemViewOperateCallback.clickToCopy(str, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label75:
      if (this.this$0.getItemType() == ContactBaseItemView.ContactItemType.TYPE_TEL) {
        this.this$0.contactItemViewOperateCallback.callPhone(str);
      } else if (this.this$0.getItemType() == ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY) {
        this.this$0.contactItemViewOperateCallback.goToCalendar(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemView.1
 * JD-Core Version:    0.7.0.1
 */