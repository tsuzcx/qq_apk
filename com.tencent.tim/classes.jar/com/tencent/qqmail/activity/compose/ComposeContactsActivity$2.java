package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ComposeContactsActivity$2
  implements LoadVipContactListWatcher
{
  ComposeContactsActivity$2(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    ComposeContactsActivity.access$500(this.this$0, new ComposeContactsActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */