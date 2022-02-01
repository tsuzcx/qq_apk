package com.tencent.qqmail.activity.contacts.fragment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class ContactsListFragment$22
  implements View.OnClickListener
{
  ContactsListFragment$22(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ContactsOtherFragment localContactsOtherFragment = new ContactsOtherFragment(ContactsListFragment.access$2700(this.this$0));
      this.this$0.startFragment(localContactsOtherFragment);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "ContactsListFragment", Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.22
 * JD-Core Version:    0.7.0.1
 */