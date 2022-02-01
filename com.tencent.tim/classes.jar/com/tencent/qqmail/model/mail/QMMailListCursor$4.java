package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailListCursor$4
  implements Runnable
{
  QMMailListCursor$4(QMMailListCursor paramQMMailListCursor, Cursor paramCursor) {}
  
  public void run()
  {
    QMLog.log(4, "QMMailListCursor", "no data and onRefresh," + this.this$0);
    if (QMMailListCursor.access$000(this.this$0) != null)
    {
      QMLog.log(4, "QMMailListCursor", "onRefresh#run noData");
      QMMailListCursor.access$000(this.this$0).run();
    }
    QMCursorCollector.release(this.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.4
 * JD-Core Version:    0.7.0.1
 */