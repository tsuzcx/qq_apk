package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$21$3
  extends SimpleDeltaCallback
{
  QMMailManager$21$3(QMMailManager.21 param21, int paramInt) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.markSubscribeConvReadStat(paramSQLiteDatabase, this.val$accountId, this.this$1.val$isUnread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.21.3
 * JD-Core Version:    0.7.0.1
 */