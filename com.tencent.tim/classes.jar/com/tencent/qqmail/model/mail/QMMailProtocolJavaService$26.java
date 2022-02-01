package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$26
  implements RefreshTokenCallback
{
  QMMailProtocolJavaService$26(QMMailProtocolJavaService paramQMMailProtocolJavaService, QMFolder paramQMFolder, Mail paramMail, boolean paramBoolean1, boolean paramBoolean2, LoadMailCallback paramLoadMailCallback) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "downloadMailText refreshAccessToken error");
    if (this.val$callback != null) {
      this.val$callback.loadMailError((QMProtocolError)paramQMNetworkError);
    }
  }
  
  public void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramString1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    this.this$0.downloadMailText(paramString1, this.val$folder, this.val$mail, this.val$forceLoadMail, this.val$isSearchMail, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.26
 * JD-Core Version:    0.7.0.1
 */