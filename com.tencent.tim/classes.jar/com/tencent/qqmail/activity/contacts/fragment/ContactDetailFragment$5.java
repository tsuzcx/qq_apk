package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.namelist.watcher.DeleteNameListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ContactDetailFragment$5
  implements DeleteNameListWatcher
{
  ContactDetailFragment$5(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onBefore(int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void onError(int paramInt1, int paramInt2, String[] paramArrayOfString, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, ContactDetailFragment.TAG, "deleteNameListWatcher error:" + paramQMNetworkError.toString());
    ContactDetailFragment.access$1400(this.this$0, new ContactDetailFragment.5.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    QMLog.log(3, ContactDetailFragment.TAG, "deleteNameListWatcher success");
    ContactDetailFragment.access$1300(this.this$0, new ContactDetailFragment.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.5
 * JD-Core Version:    0.7.0.1
 */