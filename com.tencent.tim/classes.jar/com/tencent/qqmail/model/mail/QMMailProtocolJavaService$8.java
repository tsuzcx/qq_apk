package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.FolderSyncImapCallBack;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$8
  implements FolderSyncImapCallBack
{
  QMMailProtocolJavaService$8(QMMailProtocolJavaService paramQMMailProtocolJavaService, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, int paramInt, Account paramAccount) {}
  
  public void onSyncStatusError(int paramInt1, int paramInt2, String paramString)
  {
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    QMLog.log(6, "QMMailProtocolJavaService", "syncImapFolderStatus error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    do
    {
      do
      {
        if (this.val$callback != null) {
          this.val$callback.error(new QMProtocolError(i));
        }
        QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "syncFolderStatus", paramInt2, paramString);
        return;
      } while (paramInt1 != 8);
      QMLog.log(6, "QMMailProtocolJavaService", "syncFolderStatus refreshAccessToken folderId:" + this.val$folder.getId());
    } while (!this.val$protocolProfile.isOauth());
    LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.8.1(this));
  }
  
  public void onSyncStatusSuccess(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i = this.val$folder.getSvrCount();
    if ((paramInt2 != this.val$folder.getSvrUnreadCount()) || (paramInt1 != i)) {}
    for (i = 1;; i = 0)
    {
      if ((this.val$folder.isOverdue()) || (i != 0)) {
        bool = true;
      }
      if (this.val$callback != null) {
        this.val$callback.success(bool, paramInt2, paramInt1);
      }
      QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "syncFolderStatus");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.8
 * JD-Core Version:    0.7.0.1
 */