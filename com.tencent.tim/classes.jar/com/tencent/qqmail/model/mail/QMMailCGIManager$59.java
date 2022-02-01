package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$59
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$59(QMMailCGIManager paramQMMailCGIManager, long paramLong1, String paramString, long paramLong2, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "QMMailCGIManager", "modifySendUtc Success:" + this.val$mailId + ":" + this.val$remoteId + ":" + this.val$modifiedSendUtc);
    QMMailCGIManager.access$000(this.this$0).mail.updateMailSendUtc(QMMailCGIManager.access$000(this.this$0).getWritableDatabase(), this.val$mailId, this.val$modifiedSendUtc);
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
    }
    QMWatcherCenter.triggerModifySendUtcSuccess(this.val$mailId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.59
 * JD-Core Version:    0.7.0.1
 */