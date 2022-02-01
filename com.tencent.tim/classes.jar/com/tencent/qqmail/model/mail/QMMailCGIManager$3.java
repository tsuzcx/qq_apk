package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$3
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$3(QMMailCGIManager paramQMMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMSyncErrorManager.sharedInstance().handleSyncError(this.val$accountId, paramQMNetworkError, false);
    if (paramQMNetworkError != null)
    {
      QMLog.log(6, "QMMailCGIManager", "errorCode:" + paramQMNetworkError.getCode());
      QMWatcherCenter.triggerSyncError(this.val$accountId, paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.3
 * JD-Core Version:    0.7.0.1
 */