package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Future;

class QMMailListCursor$7$1
  implements Runnable
{
  QMMailListCursor$7$1(QMMailListCursor.7 param7) {}
  
  public void run()
  {
    if ((this.this$1.val$fNextCursor != QMMailListCursor.access$100(this.this$1.this$0)) || (this.this$1.val$fNextCanLoadMore != QMMailListCursor.access$200(this.this$1.this$0))) {
      return;
    }
    i = -1;
    try
    {
      j = ((Cursor)this.this$1.val$fNextCursor.get()).getCount();
      i = j;
      bool = ((Boolean)this.this$1.val$fNextCanLoadMore.get()).booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Runnable localRunnable;
        QMLog.log(5, "QMMailListCursor", "new cursor error", localException);
        boolean bool = false;
        int j = i;
      }
    }
    QMLog.log(4, "QMMailListCursor", "refresh done, update cursor and notify data changed, newCousorCount: " + j + ", newCanLoadMore: " + bool + "," + this.this$1.this$0);
    QMMailListCursor.access$302(this.this$1.this$0, this.this$1.val$fNextCursor);
    QMMailListCursor.access$402(this.this$1.this$0, this.this$1.val$fNextCanLoadMore);
    localRunnable = QMMailListCursor.access$000(this.this$1.this$0);
    if (localRunnable != null) {
      localRunnable.run();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.7.1
 * JD-Core Version:    0.7.0.1
 */