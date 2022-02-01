package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactHeaderItemView$3
  implements View.OnClickListener
{
  ContactHeaderItemView$3(ContactHeaderItemView paramContactHeaderItemView) {}
  
  public void onClick(View paramView)
  {
    if (ContactHeaderItemView.access$000(this.this$0) != null) {
      ContactHeaderItemView.access$000(this.this$0).setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView.3
 * JD-Core Version:    0.7.0.1
 */