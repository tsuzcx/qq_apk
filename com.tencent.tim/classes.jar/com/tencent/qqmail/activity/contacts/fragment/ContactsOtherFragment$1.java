package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ContactsOtherFragment$1
  implements LoadContactListWatcher
{
  ContactsOtherFragment$1(ContactsOtherFragment paramContactsOtherFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    this.this$0.refreshData();
    ContactsOtherFragment.access$000(this.this$0, new ContactsOtherFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsOtherFragment.1
 * JD-Core Version:    0.7.0.1
 */