package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class VIPContactsIndexFragment$3
  implements LoadVipContactListWatcher
{
  VIPContactsIndexFragment$3(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    VIPContactsIndexFragment.access$102(this.this$0, true);
    this.this$0.refreshData();
    VIPContactsIndexFragment.access$500(this.this$0, new VIPContactsIndexFragment.3.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    VIPContactsIndexFragment.access$102(this.this$0, true);
    this.this$0.refreshData();
    VIPContactsIndexFragment.access$400(this.this$0, new VIPContactsIndexFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.3
 * JD-Core Version:    0.7.0.1
 */