package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMMailManager$7$1
  extends SimpleDeltaCallback
{
  QMMailManager$7$1(QMMailManager.7 param7, int paramInt, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailManager.access$000(this.this$1.this$0).mail.moveMails(paramSQLiteDatabase, this.val$accountId, this.val$mailIdsByAccount, this.this$1.val$targetFolder.getId(), this.val$isQQMail);
    this.this$1.this$0.updateAdvertiseEntrance(paramSQLiteDatabase, this.val$accountId);
    this.this$1.this$0.updateSubscribeEntrance(paramSQLiteDatabase, this.val$accountId);
    QMMailManager.access$000(this.this$1.this$0).folder.setOverdue(paramSQLiteDatabase, QMMailManager.access$400(this.this$1.this$0).getInboxFolderId(this.val$accountId), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.7.1
 * JD-Core Version:    0.7.0.1
 */