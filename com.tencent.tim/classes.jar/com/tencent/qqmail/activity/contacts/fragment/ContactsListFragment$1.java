package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ContactsListFragment$1
  implements LoadContactListWatcher
{
  ContactsListFragment$1(ContactsListFragment paramContactsListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    ContactsListFragment.access$002(this.this$0, true);
    ContactsListFragment.access$102(this.this$0, true);
    ContactsListFragment.access$700(this.this$0, new ContactsListFragment.1.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    ContactsListFragment.access$002(this.this$0, true);
    ContactsListFragment.access$102(this.this$0, false);
    ContactsListFragment.access$600(this.this$0, new ContactsListFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.1
 * JD-Core Version:    0.7.0.1
 */