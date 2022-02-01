package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMMailManager$52
  implements Runnable
{
  QMMailManager$52(QMMailManager paramQMMailManager, long[] paramArrayOfLong) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = QMMailManager.access$000(this.this$0).getWritableDatabase();
    QMMailManager.access$000(this.this$0).mail.updateMailAttr(localSQLiteDatabase, this.val$mailIds, 65536L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.52
 * JD-Core Version:    0.7.0.1
 */