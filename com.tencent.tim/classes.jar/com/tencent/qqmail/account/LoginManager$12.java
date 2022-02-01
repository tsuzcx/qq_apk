package com.tencent.qqmail.account;

import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class LoginManager$12
  implements QMCallback.IErrorCallback
{
  LoginManager$12(LoginManager paramLoginManager, QQMailAccount paramQQMailAccount, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, String paramString5) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkResponse = new StringBuilder().append("syncLoginSvrUTC err:");
    if (paramQMNetworkError == null) {}
    for (paramQMNetworkRequest = "";; paramQMNetworkRequest = paramQMNetworkError.desp)
    {
      QMLog.log(6, "LoginManager", paramQMNetworkRequest);
      this.val$account.login(this.val$currentLoginId, this.val$userName, this.val$a2, this.val$password, this.val$uin, this.val$isBizMail, this.val$isBindPhone, this.val$phonenum);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.12
 * JD-Core Version:    0.7.0.1
 */