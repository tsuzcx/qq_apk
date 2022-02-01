package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ComposeContactsActivity$1
  implements LoadContactListWatcher
{
  ComposeContactsActivity$1(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    ComposeContactsActivity.access$002(this.this$0, true);
    ComposeContactsActivity.access$102(this.this$0, true);
    ComposeContactsActivity.access$400(this.this$0, new ComposeContactsActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    ComposeContactsActivity.access$002(this.this$0, true);
    ComposeContactsActivity.access$102(this.this$0, false);
    ComposeContactsActivity.access$300(this.this$0, new ComposeContactsActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */