package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactDetailItemView$2
  implements View.OnLongClickListener
{
  ContactDetailItemView$2(ContactDetailItemView paramContactDetailItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      paramView = ContactDetailItemView.access$000(this.this$0).getText().toString().replace(" ", "");
      if (!paramView.isEmpty())
      {
        this.this$0.contactItemViewOperateCallback.clickToCopy(paramView, 1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemView.2
 * JD-Core Version:    0.7.0.1
 */