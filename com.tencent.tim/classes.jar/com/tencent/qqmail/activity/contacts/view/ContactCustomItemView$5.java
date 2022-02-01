package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;

class ContactCustomItemView$5
  implements View.OnFocusChangeListener
{
  ContactCustomItemView$5(ContactCustomItemView paramContactCustomItemView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (ContactCustomItemView.access$500(this.this$0) != null)
    {
      if ((!ContactCustomItemView.access$300(this.this$0).getText().toString().isEmpty()) && (paramBoolean)) {
        ContactCustomItemView.access$500(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ContactCustomItemView.access$500(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView.5
 * JD-Core Version:    0.7.0.1
 */