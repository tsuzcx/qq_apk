package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsListFragment$20
  implements View.OnClickListener
{
  ContactsListFragment$20(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ContactsListFragment.access$2600(this.this$0)) {
      ContactsListFragment.access$3100(this.this$0, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.20
 * JD-Core Version:    0.7.0.1
 */