package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$17$1
  extends SimpleDeltaCallback
{
  QMMailManager$17$1(QMMailManager.17 param17, int paramInt, long[] paramArrayOfLong) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.tagMails(paramSQLiteDatabase, this.val$accountId, this.val$mailIdsByAccount, this.this$1.val$addTagIds, this.this$1.val$deleteTagIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.17.1
 * JD-Core Version:    0.7.0.1
 */