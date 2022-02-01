package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class VIPContactsIndexFragment$2
  implements LoadContactListWatcher
{
  VIPContactsIndexFragment$2(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    VIPContactsIndexFragment.access$102(this.this$0, true);
    this.this$0.refreshData();
    VIPContactsIndexFragment.access$300(this.this$0, new VIPContactsIndexFragment.2.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    VIPContactsIndexFragment.access$102(this.this$0, true);
    this.this$0.refreshData();
    VIPContactsIndexFragment.access$200(this.this$0, new VIPContactsIndexFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.2
 * JD-Core Version:    0.7.0.1
 */