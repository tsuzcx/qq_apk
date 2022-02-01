package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactDetailItemSingleView$2
  implements View.OnLongClickListener
{
  ContactDetailItemSingleView$2(ContactDetailItemSingleView paramContactDetailItemSingleView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      paramView = ContactDetailItemSingleView.access$000(this.this$0).getText().toString().replace(" ", "");
      if (!paramView.equals("")) {}
    }
    else
    {
      return false;
    }
    this.this$0.contactItemViewOperateCallback.clickToCopy(paramView, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemSingleView.2
 * JD-Core Version:    0.7.0.1
 */