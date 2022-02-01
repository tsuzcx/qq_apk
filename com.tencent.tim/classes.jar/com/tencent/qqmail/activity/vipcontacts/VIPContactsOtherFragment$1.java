package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class VIPContactsOtherFragment$1
  implements LoadContactListWatcher
{
  VIPContactsOtherFragment$1(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    this.this$0.refreshData();
    VIPContactsOtherFragment.access$000(this.this$0, new VIPContactsOtherFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.1
 * JD-Core Version:    0.7.0.1
 */