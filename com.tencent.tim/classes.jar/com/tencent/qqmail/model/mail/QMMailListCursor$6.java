package com.tencent.qqmail.model.mail;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class QMMailListCursor$6
  implements Callable<Boolean>
{
  QMMailListCursor$6(QMMailListCursor paramQMMailListCursor, CountDownLatch paramCountDownLatch) {}
  
  public Boolean call()
  {
    boolean bool = this.this$0.queryCanLoadMore();
    this.val$cdl.countDown();
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.6
 * JD-Core Version:    0.7.0.1
 */