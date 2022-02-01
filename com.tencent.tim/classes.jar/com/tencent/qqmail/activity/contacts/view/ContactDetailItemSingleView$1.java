package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactDetailItemSingleView$1
  implements View.OnClickListener
{
  ContactDetailItemSingleView$1(ContactDetailItemSingleView paramContactDetailItemSingleView) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      str = ContactDetailItemSingleView.access$000(this.this$0).getText().toString().replace(" ", "");
      if (!str.equals("")) {
        break label50;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      if (this.this$0.getItemType() == ContactBaseItemView.ContactItemType.TYPE_EMAIL) {
        this.this$0.contactItemViewOperateCallback.clickToCopy(str, 0);
      } else if (this.this$0.getItemType() == ContactBaseItemView.ContactItemType.TYPE_TEL) {
        this.this$0.contactItemViewOperateCallback.callPhone(str);
      } else if (this.this$0.getItemType() == ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY) {
        this.this$0.contactItemViewOperateCallback.goToCalendar(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemSingleView.1
 * JD-Core Version:    0.7.0.1
 */