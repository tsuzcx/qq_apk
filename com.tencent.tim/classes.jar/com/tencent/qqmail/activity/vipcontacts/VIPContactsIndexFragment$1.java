package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.VipContactWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.HashMap;

class VIPContactsIndexFragment$1
  implements VipContactWatcher
{
  VIPContactsIndexFragment$1(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onError(HashMap<Long, Boolean> paramHashMap, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(HashMap<Long, Boolean> paramHashMap)
  {
    this.this$0.refreshData();
    VIPContactsIndexFragment.access$000(this.this$0, new VIPContactsIndexFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.1
 * JD-Core Version:    0.7.0.1
 */