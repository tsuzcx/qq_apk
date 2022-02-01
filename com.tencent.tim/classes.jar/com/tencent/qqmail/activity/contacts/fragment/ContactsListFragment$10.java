package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsListFragment$10
  implements View.OnClickListener
{
  ContactsListFragment$10(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ContactsListFragment.access$200(this.this$0) == 0) {
      ContactsListAdapter.clearSelectContacts();
    }
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.10
 * JD-Core Version:    0.7.0.1
 */