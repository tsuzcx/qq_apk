package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ComposeMobileContactsActivity$1
  implements LoadContactListWatcher
{
  ComposeMobileContactsActivity$1(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == 0)
    {
      ComposeMobileContactsActivity.access$002(this.this$0, true);
      ComposeMobileContactsActivity.access$300(this.this$0, new ComposeMobileContactsActivity.1.2(this));
    }
  }
  
  public void onSuccess(int paramInt)
  {
    if (paramInt == 0)
    {
      ComposeMobileContactsActivity.access$002(this.this$0, true);
      ComposeMobileContactsActivity.access$200(this.this$0, new ComposeMobileContactsActivity.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */