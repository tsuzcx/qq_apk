package com.tencent.qqmail.activity.contacts.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactEditBirthdayItemView$1$2
  implements DialogInterface.OnClickListener
{
  ContactEditBirthdayItemView$1$2(ContactEditBirthdayItemView.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$1.this$0.contactItemViewOperateCallback != null) {
      this.this$1.this$0.contactItemViewOperateCallback.notifyDataChange();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView.1.2
 * JD-Core Version:    0.7.0.1
 */