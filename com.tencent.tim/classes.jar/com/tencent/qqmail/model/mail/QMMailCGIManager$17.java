package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$17
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$17(QMMailCGIManager paramQMMailCGIManager, CheckMailCallback paramCheckMailCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "QMMailCGIManager", "checkMail, onError: " + paramQMNetworkError);
    this.val$checkMailCallback.notSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.17
 * JD-Core Version:    0.7.0.1
 */