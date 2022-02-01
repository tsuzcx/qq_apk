package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class VIPContactsFragment$2
  implements LoadVipContactListWatcher
{
  VIPContactsFragment$2(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    VIPContactsFragment.access$500(this.this$0, new VIPContactsFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.2
 * JD-Core Version:    0.7.0.1
 */