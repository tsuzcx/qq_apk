package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactCustomItemView$4
  implements View.OnClickListener
{
  ContactCustomItemView$4(ContactCustomItemView paramContactCustomItemView) {}
  
  public void onClick(View paramView)
  {
    ContactCustomItemView.access$400(this.this$0).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView.4
 * JD-Core Version:    0.7.0.1
 */