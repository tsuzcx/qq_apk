package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SearchMailWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ContactsHistoryMailListFragment$1
  implements SearchMailWatcher
{
  ContactsHistoryMailListFragment$1(ContactsHistoryMailListFragment paramContactsHistoryMailListFragment) {}
  
  public void onComplete()
  {
    ContactsHistoryMailListFragment.access$800(this.this$0, new ContactsHistoryMailListFragment.1.3(this));
  }
  
  public void onError(QMNetworkError paramQMNetworkError, boolean paramBoolean)
  {
    int i = paramQMNetworkError.code;
    QMLog.log(6, ContactsHistoryMailListFragment.access$000(), "SearchMailWatcher onError " + i);
    ContactsHistoryMailListFragment.access$500(this.this$0, new ContactsHistoryMailListFragment.1.2(this, paramBoolean));
  }
  
  public void onLock(int paramInt1, int paramInt2) {}
  
  public void onProcess(long paramLong) {}
  
  public void onSuccess(long[] paramArrayOfLong, boolean paramBoolean)
  {
    ContactsHistoryMailListFragment.access$400(this.this$0, new ContactsHistoryMailListFragment.1.1(this, paramBoolean, paramArrayOfLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.1
 * JD-Core Version:    0.7.0.1
 */