package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class QMMailManager$53
  implements QMCallback.IErrorCallback
{
  QMMailManager$53(QMMailManager paramQMMailManager, AtomicBoolean paramAtomicBoolean, AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch, QMFolder paramQMFolder, Account paramAccount) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (this.val$completed.getAndSet(true)) {}
    do
    {
      return;
      QMLog.log(5, "QMMailManager", "syncUpdateWithNotification onError: " + paramQMNetworkError);
      this.val$errorCount.getAndIncrement();
      this.val$cdl.countDown();
    } while (this.val$folder.getType() != 1);
    Threads.runInBackground(new QMMailManager.53.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.53
 * JD-Core Version:    0.7.0.1
 */