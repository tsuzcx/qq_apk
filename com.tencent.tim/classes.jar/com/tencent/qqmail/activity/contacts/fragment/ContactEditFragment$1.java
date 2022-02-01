package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;
import com.tencent.qqmail.view.QMTopBar;

class ContactEditFragment$1
  implements ContactItemViewOperateCallback
{
  ContactEditFragment$1(ContactEditFragment paramContactEditFragment) {}
  
  public void callPhone(String paramString) {}
  
  public void clickToCopy(String paramString, int paramInt) {}
  
  public void goToCalendar(String paramString) {}
  
  public void notifyDataChange()
  {
    if ((ContactEditFragment.access$000(this.this$0)) && (!ContactEditFragment.access$100(this.this$0))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.getTopBar().getButtonRight().setEnabled(bool);
      return;
    }
  }
  
  public void removeSelf()
  {
    this.this$0.hideKeyBoard();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.1
 * JD-Core Version:    0.7.0.1
 */