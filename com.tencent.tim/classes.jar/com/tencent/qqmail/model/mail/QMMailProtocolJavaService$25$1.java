package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolJavaService$25$1
  implements RefreshTokenCallback
{
  QMMailProtocolJavaService$25$1(QMMailProtocolJavaService.25 param25) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "sendMail refreshAccessToken error");
    this.this$1.val$callback.handleError(paramQMNetworkError);
    this.this$1.val$callback.handleComplete(null);
  }
  
  public void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramString1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    this.this$1.this$0.sendMail(paramString1, this.this$1.val$mailUI, this.this$1.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.25.1
 * JD-Core Version:    0.7.0.1
 */