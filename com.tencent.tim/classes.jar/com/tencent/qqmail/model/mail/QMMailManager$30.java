package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;

class QMMailManager$30
  extends SimpleDeltaCallback
{
  QMMailManager$30(QMMailManager paramQMMailManager, long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    int[] arrayOfInt = QMMailManager.access$000(this.this$0).mail.getMailFolderIds(paramSQLiteDatabase, this.val$mailIds);
    this.this$0.deleteAggregateMail(this.val$mailIds);
    if (this.val$isPurgeDelete) {
      if (this.val$isQQMail) {
        QMMailManager.access$000(this.this$0).mail.deleteMails(paramSQLiteDatabase, this.val$mailIds);
      }
    }
    for (;;)
    {
      if ((this.val$isQQMail) && (this.val$isPurgeDelete)) {
        QMMailManager.access$000(this.this$0).mail.deleteSubscribes(paramSQLiteDatabase, this.val$mailIds);
      }
      this.this$0.updateAdvertiseEntrance(paramSQLiteDatabase, this.val$accountId);
      if (this.val$isQQMail) {
        this.this$0.updateSubscribeEntrance(paramSQLiteDatabase, this.val$accountId);
      }
      if (!this.val$isQQMail) {
        break;
      }
      if (!this.val$isPurgeDelete)
      {
        i = QMMailManager.access$400(this.this$0).getTrashFolderId(this.val$accountId);
        QMMailManager.access$000(this.this$0).folder.updateFolderFromTime(paramSQLiteDatabase, i, false, 0L);
      }
      if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
        break;
      }
      int i = 0;
      while (i < arrayOfInt.length)
      {
        QMMailManager.access$000(this.this$0).folder.updateFolderFromTime(paramSQLiteDatabase, arrayOfInt[i], false, 0L);
        i += 1;
      }
      QMMailManager.access$000(this.this$0).mail.deleteMailsWithConv(paramSQLiteDatabase, this.val$accountId, this.val$mailIds);
      continue;
      i = QMMailManager.access$400(this.this$0).getTrashFolderId(this.val$accountId);
      QMMailManager.access$000(this.this$0).mail.unreadMails(paramSQLiteDatabase, this.val$mailIds, false);
      QMMailManager.access$000(this.this$0).mail.moveMails(paramSQLiteDatabase, this.val$accountId, this.val$mailIds, i, this.val$isQQMail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.30
 * JD-Core Version:    0.7.0.1
 */