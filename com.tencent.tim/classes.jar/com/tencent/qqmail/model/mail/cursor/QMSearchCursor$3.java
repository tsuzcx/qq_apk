package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

class QMSearchCursor$3
  implements Runnable
{
  QMSearchCursor$3(QMSearchCursor paramQMSearchCursor) {}
  
  public void run()
  {
    this.this$0.sqliteHelper.mail.cleanRemoteSearchMails(this.this$0.sqliteHelper.getWritableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor.3
 * JD-Core Version:    0.7.0.1
 */