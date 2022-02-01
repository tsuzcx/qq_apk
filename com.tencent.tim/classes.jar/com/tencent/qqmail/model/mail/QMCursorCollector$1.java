package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.utilities.log.QMLog;

final class QMCursorCollector$1
  implements Runnable
{
  QMCursorCollector$1(Cursor paramCursor) {}
  
  public void run()
  {
    if (!this.val$cur.isClosed()) {
      this.val$cur.close();
    }
    QMLog.log(4, "QMCursorCollector", "cleanup, close cursor: " + this.val$cur);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMCursorCollector.1
 * JD-Core Version:    0.7.0.1
 */