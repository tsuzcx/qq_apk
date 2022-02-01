package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class VIPContactsIndexFragment$4
  implements SyncPhotoWatcher
{
  VIPContactsIndexFragment$4(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    if (VIPContactsIndexFragment.access$600(this.this$0) != null) {
      VIPContactsIndexFragment.access$800(this.this$0, new VIPContactsIndexFragment.4.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.4
 * JD-Core Version:    0.7.0.1
 */