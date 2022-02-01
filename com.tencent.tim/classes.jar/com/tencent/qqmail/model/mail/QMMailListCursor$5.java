package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class QMMailListCursor$5
  implements Callable<Cursor>
{
  QMMailListCursor$5(QMMailListCursor paramQMMailListCursor, CountDownLatch paramCountDownLatch) {}
  
  public Cursor call()
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    this.val$cdl.countDown();
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.5
 * JD-Core Version:    0.7.0.1
 */