package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailManager$3
  implements IdleCallback
{
  QMMailManager$3(QMMailManager paramQMMailManager, QMFolder paramQMFolder, Account paramAccount) {}
  
  public void onIdleDetectNew() {}
  
  public void onIdleError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onIdleSuccess() {}
  
  public void onSvrCountChange()
  {
    QMFolder localQMFolder = this.val$folder;
    QMLog.log(4, "QMMailManager", "idle return, sync folder " + this.val$folder.getRemoteId());
    this.this$0.syncUpdateWithNotification(this.val$account.getId(), new QMFolder[] { localQMFolder }, true, "idle", null);
  }
  
  public void reportDomain() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.3
 * JD-Core Version:    0.7.0.1
 */