package com.tencent.qqmail.activity.contacts.view;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactEditBirthdayItemView$1$3
  implements DatePickerDialog.OnDateSetListener
{
  ContactEditBirthdayItemView$1$3(ContactEditBirthdayItemView.1 param1) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$1.this$0.setNodeInputText(paramInt1 + "-" + (paramInt2 + 1) + "-" + paramInt3);
    if (this.this$1.this$0.contactItemViewOperateCallback != null) {
      this.this$1.this$0.contactItemViewOperateCallback.notifyDataChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView.1.3
 * JD-Core Version:    0.7.0.1
 */