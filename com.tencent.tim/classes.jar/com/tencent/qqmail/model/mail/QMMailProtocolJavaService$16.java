package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Map;

class QMMailProtocolJavaService$16
  implements RefreshTokenCallback
{
  QMMailProtocolJavaService$16(QMMailProtocolJavaService paramQMMailProtocolJavaService, Map paramMap, CheckMailCallback paramCheckMailCallback) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "checkMail refreshAccessToken error");
    if (this.val$checkMailCallback != null) {
      this.val$checkMailCallback.notSync();
    }
  }
  
  public void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramString1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    this.this$0.checkMail(paramString1, this.val$folderMap, this.val$checkMailCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.16
 * JD-Core Version:    0.7.0.1
 */