package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactEditItemView$3
  implements View.OnClickListener
{
  ContactEditItemView$3(ContactEditItemView paramContactEditItemView) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.nodeInput != null) {
      this.this$0.nodeInput.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditItemView.3
 * JD-Core Version:    0.7.0.1
 */