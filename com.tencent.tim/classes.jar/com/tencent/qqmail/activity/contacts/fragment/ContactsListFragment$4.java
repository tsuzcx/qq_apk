package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class ContactsListFragment$4
  implements SyncPhotoWatcher
{
  ContactsListFragment$4(ContactsListFragment paramContactsListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    if (ContactsListFragment.access$1200(this.this$0) != null) {
      ContactsListFragment.access$1300(this.this$0, new ContactsListFragment.4.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.4
 * JD-Core Version:    0.7.0.1
 */