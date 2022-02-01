package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class ContactDetailFragment$4
  implements SyncPhotoWatcher
{
  ContactDetailFragment$4(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    ContactDetailFragment.access$1200(this.this$0, new ContactDetailFragment.4.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */