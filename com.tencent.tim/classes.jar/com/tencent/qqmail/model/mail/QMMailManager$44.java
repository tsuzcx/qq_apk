package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailManager$44
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$44(QMMailManager paramQMMailManager, ComposeMailUI paramComposeMailUI, Account paramAccount, boolean paramBoolean, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMMailManager", "send mail success, subject: " + this.val$mail.getInformation().getSubject());
    SQLiteDatabase localSQLiteDatabase = QMMailManager.access$000(this.this$0).getWritableDatabase();
    int i = this.val$account.getId();
    if ((!this.val$isSaveDraft) && (this.val$mail.isDraft()) && (!this.val$mail.isSaved())) {
      this.this$0.deleteMails(new long[] { this.val$mail.getDraftMailId() }, true);
    }
    QMMailManager.access$000(this.this$0).folder.setOverdue(localSQLiteDatabase, QMMailManager.access$400(this.this$0).getSentFolderId(i), true);
    if (this.val$mail.isSaved()) {
      QMMailManager.access$000(this.this$0).folder.setOverdue(localSQLiteDatabase, QMMailManager.access$400(this.this$0).getDraftFolderId(i), true);
    }
    long l = this.val$mail.getRlyMailId();
    String str = this.val$mail.getReplyId();
    if ((str != null) && (!str.equals("")))
    {
      QMMailManager.access$000(this.this$0).mail.updateMailAttr(localSQLiteDatabase, new long[] { l }, 524288L);
      QMMailManager.access$000(this.this$0).mail.resetMailAttr(localSQLiteDatabase, new long[] { l }, 536870912L);
      if (this.val$mail.getStatus().isGroupMail()) {
        QMMailManager.access$000(this.this$0).mail.updateMailLoaded(localSQLiteDatabase, l, false);
      }
    }
    l = this.val$mail.getFwdMailId();
    str = this.val$mail.getForwardId();
    if ((str != null) && (!str.equals("")))
    {
      QMMailManager.access$000(this.this$0).mail.updateMailAttr(localSQLiteDatabase, new long[] { l }, 1048576L);
      QMMailManager.access$000(this.this$0).mail.updateMailAttr(localSQLiteDatabase, new long[] { l }, 536870912L);
    }
    if (!this.val$account.isQQMail()) {
      QMMailManager.access$1100(this.this$0, this.val$mail);
    }
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
    QMWatcherCenter.triggerMailSentSuccess(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.44
 * JD-Core Version:    0.7.0.1
 */