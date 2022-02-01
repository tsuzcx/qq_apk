package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMMailManager$9$1
  extends SimpleDeltaCallback
{
  QMMailManager$9$1(QMMailManager.9 param9) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = QMMailManager.access$000(this.this$1.this$0).mail.getFolderMailIds(paramSQLiteDatabase, this.this$1.val$oldFolder);
    QMMailManager localQMMailManager = this.this$1.this$0;
    String str = this.this$1.val$oldFolder.getRemoteId();
    localQMMailManager.tagMails(paramSQLiteDatabase, new String[0], new String[] { str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.9.1
 * JD-Core Version:    0.7.0.1
 */