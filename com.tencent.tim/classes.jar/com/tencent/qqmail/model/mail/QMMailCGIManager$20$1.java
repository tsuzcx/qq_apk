package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class QMMailCGIManager$20$1
  implements QMCallback.IBeforeSendCallback
{
  QMMailCGIManager$20$1(QMMailCGIManager.20 param20, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.process();
    }
    QMWatcherCenter.triggerLoadListProcess(this.val$folderId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.20.1
 * JD-Core Version:    0.7.0.1
 */