package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ContactsListFragment$2
  implements LoadVipContactListWatcher
{
  ContactsListFragment$2(ContactsListFragment paramContactsListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    ContactsListFragment.access$800(this.this$0, new ContactsListFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.2
 * JD-Core Version:    0.7.0.1
 */