package com.tencent.qqmail.account.model;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class LoginUser$8
  implements QMCallback.IBeforeSendCallback
{
  LoginUser$8(LoginUser paramLoginUser, int paramInt) {}
  
  public void run(QMNetworkRequest arg1)
  {
    synchronized (this.this$0)
    {
      if (this.val$requestSequence != LoginUser.access$2400(this.this$0))
      {
        QMLog.log(4, "LoginUser", "before seq change: " + this.val$requestSequence + ", " + LoginUser.access$2400(this.this$0));
        return;
      }
      LoginUser.access$2502(this.this$0, null);
      QMLog.log(4, "LoginUser", "before send : set loginstatus=LOGIN_STATUS_LOGINING");
      LoginUser.access$2602(this.this$0, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.8
 * JD-Core Version:    0.7.0.1
 */