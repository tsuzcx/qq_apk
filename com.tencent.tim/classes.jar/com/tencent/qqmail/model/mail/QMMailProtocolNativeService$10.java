package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Mail.Folder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$10
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$10(QMMailProtocolNativeService paramQMMailProtocolNativeService, int paramInt1, int paramInt2, FolderListCallback paramFolderListCallback, Profile paramProfile, Account paramAccount) {}
  
  public void onRetrieveFolders(Mail.Folder[] paramArrayOfFolder1, Mail.Folder[] paramArrayOfFolder2, Mail.Folder[] paramArrayOfFolder3, ProtocolResult paramProtocolResult, int paramInt)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "fetchFolderList result:" + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      QMLog.log(4, "QMMailProtocolNativeService", "fetchFolderList success");
      QMFolder[] arrayOfQMFolder2 = new QMFolder[0];
      QMFolder[] arrayOfQMFolder1 = arrayOfQMFolder2;
      if (paramArrayOfFolder1 != null)
      {
        arrayOfQMFolder1 = arrayOfQMFolder2;
        if (paramArrayOfFolder1.length > 0) {
          arrayOfQMFolder1 = QMMailProtocolNativeService.access$200(this.this$0, paramArrayOfFolder1, this.val$accountId, this.val$protocolType);
        }
      }
      arrayOfQMFolder2 = new QMFolder[0];
      paramArrayOfFolder1 = arrayOfQMFolder2;
      if (paramArrayOfFolder3 != null)
      {
        paramArrayOfFolder1 = arrayOfQMFolder2;
        if (paramArrayOfFolder3.length > 0) {
          paramArrayOfFolder1 = QMMailProtocolNativeService.access$200(this.this$0, paramArrayOfFolder3, this.val$accountId, this.val$protocolType);
        }
      }
      arrayOfQMFolder2 = new QMFolder[0];
      paramArrayOfFolder3 = arrayOfQMFolder2;
      if (paramArrayOfFolder2 != null)
      {
        paramArrayOfFolder3 = arrayOfQMFolder2;
        if (paramArrayOfFolder2.length > 0) {
          paramArrayOfFolder3 = QMMailProtocolNativeService.access$200(this.this$0, paramArrayOfFolder2, this.val$accountId, this.val$protocolType);
        }
      }
      if (this.val$folderListCallback != null) {
        this.val$folderListCallback.onSuccess(arrayOfQMFolder1, paramArrayOfFolder1, paramArrayOfFolder3);
      }
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$accountId, paramProtocolResult);
      }
    }
    while (paramProtocolResult.error_code_ == 0)
    {
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "fetchFolderList", true);
      return;
      if (paramProtocolResult.error_code_ == 3001)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList token expire:" + this.val$accountId);
        if (this.val$profile.isOauth) {
          LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolNativeService.10.1(this));
        }
      }
      else if (paramProtocolResult.error_code_ == 3000)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList token revoked");
      }
      else if (paramProtocolResult.error_code_ == 13)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList wipe account: " + this.val$accountId);
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(this.val$accountId);
      }
      else if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList auth error : " + this.val$accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
        if (this.val$folderListCallback != null) {
          this.val$folderListCallback.onError(new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList error : " + paramProtocolResult.error_code_);
        if (this.val$folderListCallback != null) {
          this.val$folderListCallback.onError(new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
    }
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "fetchFolderList", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.10
 * JD-Core Version:    0.7.0.1
 */