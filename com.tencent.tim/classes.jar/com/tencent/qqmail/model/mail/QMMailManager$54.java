package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class QMMailManager$54
  implements QMCallback.ISuccessCallback
{
  QMMailManager$54(QMMailManager paramQMMailManager, AtomicBoolean paramAtomicBoolean, Account paramAccount, QMFolder paramQMFolder, CountDownLatch paramCountDownLatch) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (this.val$completed.getAndSet(true)) {
      return;
    }
    QMLog.log(3, "QMMailManager", "syncUpdateWithNotification onSuccess, account: " + this.val$account.getEmail() + ", folder: " + this.val$folder.getName());
    this.val$cdl.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.54
 * JD-Core Version:    0.7.0.1
 */