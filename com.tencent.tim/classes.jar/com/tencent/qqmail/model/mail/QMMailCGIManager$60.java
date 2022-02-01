package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$60
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$60(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, long paramLong) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailCGIManager", "modifySendUtc Error:" + paramQMNetworkError.code + ":" + paramQMNetworkError.desp);
    if (this.val$callback != null) {
      this.val$callback.handleError(paramQMNetworkError);
    }
    QMWatcherCenter.triggerModifySendUtcError(this.val$mailId, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.60
 * JD-Core Version:    0.7.0.1
 */