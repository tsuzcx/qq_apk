package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$20$1
  extends SimpleDeltaCallback
{
  QMMailManager$20$1(QMMailManager.20 param20, long[] paramArrayOfLong) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.unreadMails(paramSQLiteDatabase, this.val$mailIdsByAcount, this.this$1.val$isUnread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.20.1
 * JD-Core Version:    0.7.0.1
 */