package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

class QMMailListCursor$7
  implements Runnable
{
  QMMailListCursor$7(QMMailListCursor paramQMMailListCursor, CountDownLatch paramCountDownLatch, Future paramFuture1, Future paramFuture2, Cursor paramCursor) {}
  
  public void run()
  {
    try
    {
      this.val$cdl.await();
      label7:
      QMMailListCursor.access$500(this.this$0).runOnMainThreadWithContext(new QMMailListCursor.7.1(this));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.7
 * JD-Core Version:    0.7.0.1
 */