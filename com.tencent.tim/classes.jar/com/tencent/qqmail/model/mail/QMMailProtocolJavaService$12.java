package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$12
  implements FolderListCallBack
{
  QMMailProtocolJavaService$12(QMMailProtocolJavaService paramQMMailProtocolJavaService, int paramInt, FolderListCallback paramFolderListCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, Account paramAccount) {}
  
  public void onRetrieveFoldersError(int paramInt1, int paramInt2, String paramString)
  {
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    QMLog.log(6, "QMMailProtocolJavaService", "fetchFolderList error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    if (paramInt1 == 4)
    {
      QMLog.log(6, "QMMailProtocolJavaService", "fetchFolderList auth error : " + this.val$accountId);
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    while (paramInt1 != 8)
    {
      if (paramInt1 == 6)
      {
        QMLog.log(6, "QMMailProtocolJavaService", "fetchFolderList wipe account: " + this.val$accountId);
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(this.val$accountId);
      }
      if (this.val$folderListCallback != null) {
        this.val$folderListCallback.onError(new QMProtocolError(i));
      }
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "fetchFolderList", paramInt2, paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("fetchFolderList token expire ").append(this.val$accountId).append(" refresh token ");
    if (this.val$account.getRefreshToken() == null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(6, "QMMailProtocolJavaService", bool);
      if (!this.val$protocolProfile.isOauth()) {
        break;
      }
      LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.12.1(this));
      return;
    }
  }
  
  public void onRetrieveFoldersSuccess(Folder[] paramArrayOfFolder1, Folder[] paramArrayOfFolder2, Folder[] paramArrayOfFolder3)
  {
    int j = 0;
    QMLog.log(4, "QMMailProtocolJavaService", "fetchFolderList success");
    QMFolder[] arrayOfQMFolder2 = new QMFolder[0];
    QMFolder[] arrayOfQMFolder1 = arrayOfQMFolder2;
    int i;
    if (paramArrayOfFolder1 != null)
    {
      arrayOfQMFolder1 = arrayOfQMFolder2;
      if (paramArrayOfFolder1.length > 0)
      {
        arrayOfQMFolder1 = new QMFolder[paramArrayOfFolder1.length];
        i = 0;
        while (i < paramArrayOfFolder1.length)
        {
          arrayOfQMFolder1[i] = QMMailProtocolJavaService.access$500(this.this$0, this.val$accountId, paramArrayOfFolder1[i]);
          i += 1;
        }
      }
    }
    arrayOfQMFolder2 = new QMFolder[0];
    paramArrayOfFolder1 = arrayOfQMFolder2;
    if (paramArrayOfFolder2 != null)
    {
      paramArrayOfFolder1 = arrayOfQMFolder2;
      if (paramArrayOfFolder2.length > 0)
      {
        paramArrayOfFolder1 = new QMFolder[paramArrayOfFolder2.length];
        i = 0;
        while (i < paramArrayOfFolder2.length)
        {
          paramArrayOfFolder1[i] = QMMailProtocolJavaService.access$500(this.this$0, this.val$accountId, paramArrayOfFolder2[i]);
          i += 1;
        }
      }
    }
    arrayOfQMFolder2 = new QMFolder[0];
    paramArrayOfFolder2 = arrayOfQMFolder2;
    if (paramArrayOfFolder3 != null)
    {
      paramArrayOfFolder2 = arrayOfQMFolder2;
      if (paramArrayOfFolder3.length > 0)
      {
        arrayOfQMFolder2 = new QMFolder[paramArrayOfFolder3.length];
        i = j;
        for (;;)
        {
          paramArrayOfFolder2 = arrayOfQMFolder2;
          if (i >= paramArrayOfFolder3.length) {
            break;
          }
          arrayOfQMFolder2[i] = QMMailProtocolJavaService.access$500(this.this$0, this.val$accountId, paramArrayOfFolder3[i]);
          i += 1;
        }
      }
    }
    if (this.val$folderListCallback != null) {
      this.val$folderListCallback.onSuccess(arrayOfQMFolder1, paramArrayOfFolder1, paramArrayOfFolder2);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "fetchFolderList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.12
 * JD-Core Version:    0.7.0.1
 */