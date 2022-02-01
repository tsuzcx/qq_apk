package com.tencent.qqmail.activity.contacts.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.DatePicker;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactEditBirthdayItemView$1$1
  implements DialogInterface.OnClickListener
{
  ContactEditBirthdayItemView$1$1(ContactEditBirthdayItemView.1 param1, DatePicker paramDatePicker) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$1.this$0.setNodeInputText(this.val$dataPicker.getYear() + "-" + (this.val$dataPicker.getMonth() + 1) + "-" + this.val$dataPicker.getDayOfMonth());
    if (this.this$1.this$0.contactItemViewOperateCallback != null) {
      this.this$1.this$0.contactItemViewOperateCallback.notifyDataChange();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView.1.1
 * JD-Core Version:    0.7.0.1
 */