package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsListFragment$9
  implements View.OnClickListener
{
  ContactsListFragment$9(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    ContactsListFragment.access$2400(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.9
 * JD-Core Version:    0.7.0.1
 */