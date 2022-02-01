package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$18$1
  extends SimpleDeltaCallback
{
  QMMailManager$18$1(QMMailManager.18 param18) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.topMails(QMMailManager.access$000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$mailIds, this.this$1.val$isTopped);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.18.1
 * JD-Core Version:    0.7.0.1
 */