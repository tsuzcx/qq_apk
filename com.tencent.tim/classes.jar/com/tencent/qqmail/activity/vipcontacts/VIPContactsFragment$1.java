package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class VIPContactsFragment$1
  implements LoadContactListWatcher
{
  VIPContactsFragment$1(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    VIPContactsFragment.access$002(this.this$0, true);
    VIPContactsFragment.access$102(this.this$0, true);
    VIPContactsFragment.access$400(this.this$0, new VIPContactsFragment.1.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    VIPContactsFragment.access$002(this.this$0, true);
    VIPContactsFragment.access$102(this.this$0, false);
    VIPContactsFragment.access$300(this.this$0, new VIPContactsFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.1
 * JD-Core Version:    0.7.0.1
 */