package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$40
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$40(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
    }
    QMWatcherCenter.triggerDeleteMailSyncRemoteSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.40
 * JD-Core Version:    0.7.0.1
 */