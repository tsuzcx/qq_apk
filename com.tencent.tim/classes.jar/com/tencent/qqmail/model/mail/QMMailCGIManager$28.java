package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class QMMailCGIManager$28
  implements QMCallback.IBeforeSendCallback
{
  QMMailCGIManager$28(QMMailCGIManager paramQMMailCGIManager, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMWatcherCenter.triggerLoadMailProcess(this.val$mailId, 0L, 0L);
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(Long.valueOf(this.val$mailId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.28
 * JD-Core Version:    0.7.0.1
 */