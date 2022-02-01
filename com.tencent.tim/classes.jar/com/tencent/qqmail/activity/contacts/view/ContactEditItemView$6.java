package com.tencent.qqmail.activity.contacts.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactEditItemView$6
  implements TextWatcher
{
  ContactEditItemView$6(ContactEditItemView paramContactEditItemView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.this$0.nodeInput != null)
    {
      paramEditable = this.this$0.nodeInput.getText().toString();
      if (this.this$0.contactItemViewOperateCallback != null) {
        this.this$0.contactItemViewOperateCallback.notifyDataChange();
      }
      if ((!paramEditable.isEmpty()) && (this.this$0.nodeInput.hasFocus())) {
        this.this$0.iconClear.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.this$0.iconClear.setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditItemView.6
 * JD-Core Version:    0.7.0.1
 */