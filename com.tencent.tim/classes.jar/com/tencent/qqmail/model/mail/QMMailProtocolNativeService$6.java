package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.ProtocolResult.ImapCommandStatusResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$6
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$6(QMMailProtocolNativeService paramQMMailProtocolNativeService, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback, Profile paramProfile, Account paramAccount) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "syncFolderStatus folder:" + this.val$folder.getId() + ",result:" + paramProtocolResult.error_code_);
    int j;
    int k;
    int i;
    if (paramProtocolResult.error_code_ == 0)
    {
      j = this.val$folder.getSvrCount();
      k = this.val$folder.getSvrUnreadCount();
      if (paramProtocolResult.imap_status_result_ == null) {
        break label464;
      }
      if ((paramProtocolResult.imap_status_result_.unseen_ != k) || (paramProtocolResult.imap_status_result_.messages_ != j)) {
        i = 1;
      }
    }
    for (;;)
    {
      boolean bool;
      if ((this.val$folder.isOverdue()) || (i != 0))
      {
        bool = true;
        label116:
        if (this.val$callback != null)
        {
          IListStatusCallback localIListStatusCallback = this.val$callback;
          i = k;
          if (paramProtocolResult.imap_status_result_ != null) {
            i = paramProtocolResult.imap_status_result_.unseen_;
          }
          if (paramProtocolResult.imap_status_result_ != null) {
            j = paramProtocolResult.imap_status_result_.messages_;
          }
          localIListStatusCallback.success(bool, i, j);
        }
      }
      for (;;)
      {
        if (paramProtocolResult.error_code_ != 0) {
          break label449;
        }
        QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "syncFolderStatus", true);
        return;
        i = 0;
        break;
        bool = false;
        break label116;
        if (paramProtocolResult.error_code_ == 3001)
        {
          QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus refreshAccessToken folderId:" + this.val$folder.getId());
          if (this.val$profile.isOauth) {
            LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolNativeService.6.1(this));
          }
        }
        else if (paramProtocolResult.error_code_ == 3000)
        {
          QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus token revoked");
        }
        else if (paramProtocolResult.error_code_ == 4)
        {
          QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus auth err : " + this.val$folder.getAccountId());
          PasswordErrHandler.saveStateAndShowErr(this.val$folder.getAccountId(), -1);
          if (this.val$callback != null) {
            this.val$callback.error(new QMProtocolError(paramProtocolResult.error_code_));
          }
        }
        else
        {
          QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus err : " + paramProtocolResult.error_code_);
          if (this.val$callback != null) {
            this.val$callback.error(new QMProtocolError(paramProtocolResult.error_code_));
          }
        }
      }
      label449:
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "syncFolderStatus", false);
      return;
      label464:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.6
 * JD-Core Version:    0.7.0.1
 */