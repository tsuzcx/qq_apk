package com.tencent.qqmail.account.model;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class LoginUser$9
  implements QMCallback.IErrorCallback
{
  LoginUser$9(LoginUser paramLoginUser, int paramInt, LoginUser.Callback paramCallback) {}
  
  public void run(QMNetworkRequest arg1, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "LoginUser", "login error");
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
          QMLog.log(4, "LoginUser", "error seq change: " + this.val$requestSequence + ", " + LoginUser.access$2400(this.this$0));
          this.val$callback.onAbort();
        }
      }
      else
      {
        i = 0;
      }
    }
    if (((paramQMNetworkError instanceof QMCancelError)) && (!((QMCancelError)paramQMNetworkError).isUserAborted))
    {
      QMLog.log(4, "LoginUser", "auto aborted");
      this.val$callback.onAbort();
      return;
    }
    ??? = LoginUser.access$2900(this.this$0, paramQMNetworkError);
    QMLog.log(4, "LoginUser", "onerror : set loginstatus=LOGIN_STATUS_LOGIN_FAIL");
    LoginUser.access$2602(this.this$0, 3);
    this.val$callback.onError(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.9
 * JD-Core Version:    0.7.0.1
 */