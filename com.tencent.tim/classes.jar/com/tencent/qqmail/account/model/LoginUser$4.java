package com.tencent.qqmail.account.model;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.TimerTask;

class LoginUser$4
  extends TimerTask
{
  LoginUser$4(LoginUser paramLoginUser, long paramLong, LoginCallback paramLoginCallback) {}
  
  public void run()
  {
    LoginUser.access$1002(this.this$0, false);
    QMLog.log(4, "Login", "after waiting " + this.val$waitTime + " second, now autoLogin again! network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
    LoginUser.access$1100(this.this$0, this.val$loginCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.4
 * JD-Core Version:    0.7.0.1
 */