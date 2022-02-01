package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;
import com.tencent.qqmail.model.mail.rule.QMRuleManager;

class QMMailManager$22$1
  extends SimpleDeltaCallback
{
  QMMailManager$22$1(QMMailManager.22 param22, boolean paramBoolean, int paramInt, long[] paramArrayOfLong) {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.this$1.val$isReject) {
      if ((this.val$isQQMail) && (this.this$1.val$isSubscribeFolder))
      {
        if (this.val$isQQMail) {
          break label232;
        }
        if (!this.this$1.val$isReject) {
          break label207;
        }
        QMMailManager.access$100(this.this$1.this$0).createReject(this.val$accountId, this.this$1.val$address);
      }
    }
    label207:
    label232:
    while (!this.this$1.val$isSubscribeFolder)
    {
      return;
      QMMailSQLite localQMMailSQLite = QMMailManager.access$000(this.this$1.this$0).mail;
      int j = this.val$accountId;
      long[] arrayOfLong = this.val$mailIds;
      if (this.val$isQQMail) {}
      for (int i = QMMailManager.access$400(this.this$1.this$0).getSpamFolderId(this.val$accountId);; i = QMMailManager.access$400(this.this$1.this$0).getTrashFolderId(this.val$accountId))
      {
        localQMMailSQLite.moveMails(paramSQLiteDatabase, j, arrayOfLong, i, this.val$isQQMail);
        break;
      }
      QMMailManager.access$000(this.this$1.this$0).mail.moveMails(paramSQLiteDatabase, this.val$accountId, this.val$mailIds, QMMailManager.access$400(this.this$1.this$0).getInboxFolderId(this.val$accountId), this.val$isQQMail);
      break;
      QMMailManager.access$100(this.this$1.this$0).removeReject(this.val$accountId, this.this$1.val$address);
      return;
    }
    this.this$1.this$0.updateSubscribeEntrance(paramSQLiteDatabase, this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.22.1
 * JD-Core Version:    0.7.0.1
 */