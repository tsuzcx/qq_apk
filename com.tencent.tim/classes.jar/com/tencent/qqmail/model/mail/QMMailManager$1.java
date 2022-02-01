package com.tencent.qqmail.model.mail;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

class QMMailManager$1
  implements Runnable
{
  QMMailManager$1(QMMailManager paramQMMailManager, CountDownLatch paramCountDownLatch, Set paramSet, int paramInt) {}
  
  public void run()
  {
    this.val$cdl.countDown();
    this.val$finished.add(Integer.valueOf(this.val$accountId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.1
 * JD-Core Version:    0.7.0.1
 */