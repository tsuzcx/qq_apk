package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class ContactsHistoryMailListFragment$2
  implements SyncPhotoWatcher
{
  ContactsHistoryMailListFragment$2(ContactsHistoryMailListFragment paramContactsHistoryMailListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    ContactsHistoryMailListFragment.access$900(this.this$0, new ContactsHistoryMailListFragment.2.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.2
 * JD-Core Version:    0.7.0.1
 */