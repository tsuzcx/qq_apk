package com.tencent.qqmail.account.model;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class LoginUser$10
  implements QMCallback.ISuccessCallback
{
  LoginUser$10(LoginUser paramLoginUser, int paramInt, LoginUser.Callback paramCallback, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = null;
    QMLog.log(4, "LoginUser", "login success");
    synchronized (this.this$0)
    {
      int i;
      if (this.val$requestSequence == LoginUser.access$2400(this.this$0))
      {
        i = 1;
        if (i != 0)
        {
          LoginUser.access$2702(this.this$0, -1);
          LoginUser.access$2802(this.this$0, null);
        }
        if (i == 0)
        {
          QMLog.log(4, "LoginUser", "success seq change: " + this.val$requestSequence + ", " + LoginUser.access$2400(this.this$0));
          this.val$callback.onAbort();
        }
      }
      else
      {
        i = 0;
      }
    }
    if (0 == 0) {
      paramQMNetworkRequest = LoginUser.access$3000(this.this$0, paramQMNetworkResponse);
    }
    ??? = paramQMNetworkRequest;
    if (paramQMNetworkRequest == null) {
      ??? = LoginUser.access$3100(this.this$0, this.val$email, paramQMNetworkResponse);
    }
    if (??? == null)
    {
      LoginManager.shareInstance().saveAccountLogined(LoginUser.access$1700(this.this$0).getId(), LoginUser.LoginData.access$700(LoginUser.access$2500(this.this$0)), LoginUser.LoginData.access$800(LoginUser.access$2500(this.this$0)));
      this.val$callback.onSuccess(LoginUser.LoginData.access$500(LoginUser.access$2500(this.this$0)));
      return;
    }
    QMLog.log(4, "LoginUser", "onsuccess : set loginstatus=LOGIN_STATUS_LOGIN_FAIL");
    LoginUser.access$2602(this.this$0, 3);
    this.val$callback.onError((QMNetworkError)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.10
 * JD-Core Version:    0.7.0.1
 */