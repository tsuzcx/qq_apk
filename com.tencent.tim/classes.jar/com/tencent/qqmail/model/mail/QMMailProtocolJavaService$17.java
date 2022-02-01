package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QMMailProtocolJavaService$17
  implements com.tencent.moai.mailsdk.callback.CheckMailCallback
{
  QMMailProtocolJavaService$17(QMMailProtocolJavaService paramQMMailProtocolJavaService, Account paramAccount, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, com.tencent.qqmail.model.mail.callback.CheckMailCallback paramCheckMailCallback, Map paramMap) {}
  
  public void notSync()
  {
    QMLog.log(4, "QMMailProtocolJavaService", "check mail not sync");
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "checkMail");
    if (this.val$checkMailCallback != null) {
      this.val$checkMailCallback.notSync();
    }
  }
  
  public void onFail(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "checkMail error resultCode: " + paramInt1 + ", detailCode: " + paramInt2 + ", detailMessage: " + paramString);
    int i = this.val$account.getId();
    if (paramInt1 == 4)
    {
      QMLog.log(6, "QMMailProtocolJavaService", "checkMail auth err:" + i);
      PasswordErrHandler.saveStateAndShowErr(i, -1);
      if (this.val$checkMailCallback != null) {
        this.val$checkMailCallback.notSync();
      }
    }
    for (;;)
    {
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "checkMail", paramInt2, paramString);
      return;
      if (paramInt1 == 8)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("checkMail token expire ").append(i).append(" refresh token ");
        if (this.val$account.getRefreshToken() == null) {}
        for (boolean bool = true;; bool = false)
        {
          QMLog.log(6, "QMMailProtocolJavaService", bool);
          if (!this.val$protocolProfile.isOauth()) {
            break;
          }
          LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.17.1(this));
          break;
        }
      }
      if (this.val$checkMailCallback != null) {
        this.val$checkMailCallback.notSync();
      }
    }
  }
  
  public void onSync(ArrayList<Folder> paramArrayList)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "check mail success:" + paramArrayList.size());
    QMFolder[] arrayOfQMFolder = new QMFolder[paramArrayList.size()];
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      Folder localFolder = (Folder)paramArrayList.next();
      arrayOfQMFolder[i] = QMMailProtocolJavaService.access$500(this.this$0, this.val$account.getId(), localFolder);
      i += 1;
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "checkMail");
    if (this.val$checkMailCallback != null) {
      this.val$checkMailCallback.onSync(arrayOfQMFolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.17
 * JD-Core Version:    0.7.0.1
 */