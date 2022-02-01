package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$23$1
  extends SimpleDeltaCallback
{
  QMMailManager$23$1(QMMailManager.23 param23, int paramInt, boolean paramBoolean) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.spamMails(paramSQLiteDatabase, this.this$1.val$mailIds, this.val$accountId);
    this.this$1.this$0.updateAdvertiseEntrance(paramSQLiteDatabase, this.val$accountId);
    if (this.val$isQQMail)
    {
      this.this$1.this$0.updateSubscribeEntrance(paramSQLiteDatabase, this.val$accountId);
      int i = QMMailManager.access$400(this.this$1.this$0).getSpamFolderId(this.val$accountId);
      QMMailManager.access$000(this.this$1.this$0).folder.updateFolderFromTime(paramSQLiteDatabase, i, false, 0L);
      QMMailManager.access$000(this.this$1.this$0).folder.updateFolderFromTime(paramSQLiteDatabase, this.this$1.val$folderId, false, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.23.1
 * JD-Core Version:    0.7.0.1
 */