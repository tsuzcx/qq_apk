package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;

class ContactHeaderItemView$4
  implements View.OnLongClickListener
{
  ContactHeaderItemView$4(ContactHeaderItemView paramContactHeaderItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.contactItemViewOperateCallback != null)
    {
      paramView = ContactHeaderItemView.access$200(this.this$0).getText().toString().replace(" ", "");
      if (!paramView.isEmpty())
      {
        this.this$0.contactItemViewOperateCallback.clickToCopy(paramView, 1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView.4
 * JD-Core Version:    0.7.0.1
 */