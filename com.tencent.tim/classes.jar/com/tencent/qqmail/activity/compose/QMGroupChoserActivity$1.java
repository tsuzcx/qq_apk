package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.watcher.LoadGroupContactListWatcher;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;

class QMGroupChoserActivity$1
  implements LoadGroupContactListWatcher
{
  QMGroupChoserActivity$1(QMGroupChoserActivity paramQMGroupChoserActivity) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMGroupChoserActivity.access$000(this.this$0, false);
    QMGroupChoserActivity.access$300(this.this$0, false);
  }
  
  public void onSuccess(int paramInt, MailGroupContactList paramMailGroupContactList)
  {
    QMGroupChoserActivity.access$000(this.this$0, false);
    QMGroupChoserActivity.access$102(this.this$0, paramMailGroupContactList);
    Threads.runOnMainThread(new QMGroupChoserActivity.1.1(this));
    QMGroupChoserActivity.access$300(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.1
 * JD-Core Version:    0.7.0.1
 */