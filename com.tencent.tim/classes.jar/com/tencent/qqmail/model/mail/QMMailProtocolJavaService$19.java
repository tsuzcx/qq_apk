package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;

class QMMailProtocolJavaService$19
  implements MailListCallBack
{
  QMMailProtocolJavaService$19(QMMailProtocolJavaService paramQMMailProtocolJavaService, int paramInt1, int paramInt2, int paramInt3, MailListCallback paramMailListCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, Account paramAccount, QMFolder paramQMFolder, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onExchangeSyncFolderFinished(int paramInt, String paramString)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "onRetrieveMail onExchangeSyncFolderFinished folderId:" + paramInt + " syncState:" + paramString);
    if (paramString == null) {
      return;
    }
    QMFolderManager.sharedInstance().updateFolderSyncState(paramInt, paramString);
  }
  
  public void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "onRetrieveMail onExchangeSyncFolderReadStatusFinished folderId:" + paramInt);
    QMMailManager.sharedInstance().updateMailInfo(paramInt, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfString4);
    QMFolderManager.sharedInstance().updateLocalMailUnreadCountIntoFolder(paramInt);
  }
  
  public void onRetrieveMailsError(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    QMLog.log(6, "QMMailProtocolJavaService", "fetchMailList error resultCode: " + paramInt1 + ", detailCode: " + paramInt2 + ", detailMessage: " + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 6)
    {
      QMLog.log(6, "QMMailProtocolJavaService", "fetchMailList wipe account:" + this.val$accountId);
      QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(this.val$accountId);
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.onRetrieveError(new QMProtocolError(i));
      }
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "fetchMailList", paramInt2, paramString);
      return;
      if (paramInt1 == 4)
      {
        QMLog.log(6, "QMMailProtocolJavaService", "fetchMailList auth err:" + this.val$accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
      }
      else
      {
        if (paramInt1 == 8)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("fetchMailList token expire ").append(this.val$accountId).append(" refresh token ");
          if (this.val$account.getRefreshToken() == null) {}
          for (;;)
          {
            QMLog.log(6, "QMMailProtocolJavaService", bool);
            if (!this.val$protocolProfile.isOauth()) {
              break;
            }
            LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.19.1(this));
            return;
            bool = false;
          }
        }
        if ((this.val$profile.isOauth) && (paramInt1 == 5) && (QMProxyUtil.isClosed())) {
          QMSharedPreferenceManager.getInstance().setGmailErrorMsgShow(true);
        }
      }
    }
  }
  
  public void onRetrieveMailsSuccess(int paramInt, com.tencent.moai.mailsdk.model.Mail[] paramArrayOfMail1, com.tencent.moai.mailsdk.model.Mail[] paramArrayOfMail2, com.tencent.moai.mailsdk.model.Mail[] paramArrayOfMail3, boolean paramBoolean)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "fetchMailList success");
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    String[] arrayOfString1 = new String[paramArrayOfMail1.length];
    String[] arrayOfString2 = new String[paramArrayOfMail2.length];
    String[] arrayOfString3 = new String[paramArrayOfMail3.length];
    int i = 0;
    while (i < paramArrayOfMail1.length)
    {
      arrayOfString1[i] = paramArrayOfMail1[i].getRemoteId();
      localArrayList2.add(QMMailProtocolJavaService.access$600(this.this$0, this.val$accountId, this.val$folderId, paramArrayOfMail1[i], this.val$protocolType));
      i += 1;
    }
    i = 0;
    while (i < paramArrayOfMail2.length)
    {
      arrayOfString2[i] = paramArrayOfMail2[i].getRemoteId();
      localArrayList1.add(QMMailProtocolJavaService.access$600(this.this$0, this.val$accountId, this.val$folderId, paramArrayOfMail2[i], this.val$protocolType));
      i += 1;
    }
    i = 0;
    while (i < paramArrayOfMail3.length)
    {
      arrayOfString3[i] = paramArrayOfMail3[i].getRemoteId();
      i += 1;
    }
    paramArrayOfMail1 = localArrayList2.iterator();
    while (paramArrayOfMail1.hasNext())
    {
      paramArrayOfMail2 = (com.tencent.qqmail.model.qmdomain.Mail)paramArrayOfMail1.next();
      if (this.val$callback != null) {
        this.val$callback.onRetrieveMail(paramArrayOfMail2);
      }
    }
    if (this.val$callback != null) {
      this.val$callback.onRetrieveStatus((com.tencent.qqmail.model.qmdomain.Mail[])localArrayList1.toArray(new com.tencent.qqmail.model.qmdomain.Mail[localArrayList1.size()]));
    }
    if (this.val$callback != null) {
      this.val$callback.onRetrieveSuccess(paramInt, paramBoolean, arrayOfString1, arrayOfString2, arrayOfString3);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "fetchMailList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.19
 * JD-Core Version:    0.7.0.1
 */