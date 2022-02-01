package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class QMMailManager$39
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$39(QMMailManager paramQMMailManager, ComposeMailUI paramComposeMailUI, Account paramAccount, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    SQLiteDatabase localSQLiteDatabase = QMMailManager.access$000(this.this$0).getWritableDatabase();
    if (this.val$mail.isSaved()) {
      QMMailManager.access$000(this.this$0).folder.setOverdue(localSQLiteDatabase, QMMailManager.access$400(this.this$0).getDraftFolderId(this.val$account.getId()), true);
    }
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.39
 * JD-Core Version:    0.7.0.1
 */