package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsListFragment$5
  implements View.OnClickListener
{
  ContactsListFragment$5(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    ContactsListFragment.access$002(this.this$0, false);
    ContactsListFragment.access$102(this.this$0, false);
    ContactsListFragment.access$1400(this.this$0, new ContactsListFragment.5.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.5
 * JD-Core Version:    0.7.0.1
 */