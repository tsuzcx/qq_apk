package com.tencent.qqmail.activity.contacts.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactCustomItemView$6
  implements TextWatcher
{
  ContactCustomItemView$6(ContactCustomItemView paramContactCustomItemView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ContactCustomItemView.access$300(this.this$0) != null)
    {
      if ((ContactCustomItemView.access$300(this.this$0).getText().toString().isEmpty()) || (!ContactCustomItemView.access$300(this.this$0).hasFocus())) {
        break label76;
      }
      ContactCustomItemView.access$500(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (this.this$0.contactItemViewOperateCallback != null) {
        this.this$0.contactItemViewOperateCallback.notifyDataChange();
      }
      return;
      label76:
      ContactCustomItemView.access$500(this.this$0).setVisibility(8);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView.6
 * JD-Core Version:    0.7.0.1
 */