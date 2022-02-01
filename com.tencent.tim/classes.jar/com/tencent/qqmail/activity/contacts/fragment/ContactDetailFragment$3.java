package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.VipContactWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.HashMap;

class ContactDetailFragment$3
  implements VipContactWatcher
{
  ContactDetailFragment$3(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onError(HashMap<Long, Boolean> paramHashMap, QMNetworkError paramQMNetworkError)
  {
    this.this$0.refreshData();
    ContactDetailFragment.access$1000(this.this$0, new ContactDetailFragment.3.2(this));
  }
  
  public void onSuccess(HashMap<Long, Boolean> paramHashMap)
  {
    this.this$0.refreshData();
    ContactDetailFragment.access$900(this.this$0, new ContactDetailFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */