package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactEditComposeEmailView$1
  implements View.OnClickListener
{
  ContactEditComposeEmailView$1(ContactEditComposeEmailView paramContactEditComposeEmailView) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.nodeInput != null) {
      this.this$0.nodeInput.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditComposeEmailView.1
 * JD-Core Version:    0.7.0.1
 */