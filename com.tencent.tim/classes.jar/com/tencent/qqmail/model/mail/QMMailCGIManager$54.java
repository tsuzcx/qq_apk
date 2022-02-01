package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class QMMailCGIManager$54
  implements QMCallback.IBeforeSendCallback
{
  QMMailCGIManager$54(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, long paramLong) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(Long.valueOf(this.val$mailId));
    }
    QMWatcherCenter.triggerQueryRecallMailProcess(this.val$mailId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.54
 * JD-Core Version:    0.7.0.1
 */