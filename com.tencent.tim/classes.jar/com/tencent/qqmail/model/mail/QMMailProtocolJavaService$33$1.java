package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolJavaService$33$1
  implements RefreshTokenCallback
{
  QMMailProtocolJavaService$33$1(QMMailProtocolJavaService.33 param33) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "QMMailProtocolJavaService", "refresh token error while idle");
  }
  
  public void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    QMLog.log(5, "QMMailProtocolJavaService", "refresh token success while idle");
    this.this$1.this$0.startIdle(AccountManager.shareInstance().getAccountList().getAccountById(paramInt1), this.this$1.val$folder, this.this$1.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.33.1
 * JD-Core Version:    0.7.0.1
 */