package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Callable;

class QMMailListCursor$2
  implements Callable<Cursor>
{
  QMMailListCursor$2(QMMailListCursor paramQMMailListCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null)
    {
      localCursor.getCount();
      QMLog.log(4, "QMMailListCursor", "queryRawCursor:" + localCursor.getCount() + "," + this.this$0);
    }
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.2
 * JD-Core Version:    0.7.0.1
 */