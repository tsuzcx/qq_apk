package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsListFragment$19
  implements View.OnClickListener
{
  ContactsListFragment$19(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.launchContactsGroupSelect();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.19
 * JD-Core Version:    0.7.0.1
 */