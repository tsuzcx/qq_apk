package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class ContactEditFragment$3
  implements SyncPhotoWatcher
{
  ContactEditFragment$3(ContactEditFragment paramContactEditFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    ContactEditFragment.access$500(this.this$0, new ContactEditFragment.3.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.3
 * JD-Core Version:    0.7.0.1
 */