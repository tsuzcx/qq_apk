package com.tencent.qqmail.account.model;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class LoginUser$5
  implements QMGeneralCallback
{
  LoginUser$5(LoginUser paramLoginUser, LoginCallback paramLoginCallback) {}
  
  public void onError()
  {
    QMLog.log(4, "LoginUser", "changePwd4WtloginCallback error");
    LoginUser.access$1202(this.this$0, false);
    if (this.val$callback != null) {
      this.val$callback.loginFail();
    }
    SharedPreferenceUtil.setWtlogin(true);
    QMNetworkError localQMNetworkError = new QMNetworkError(2, -10000, QMApplicationContext.sharedInstance().getString(2131695520), "");
    LoginUser.access$1400(this.this$0, localQMNetworkError);
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "LoginUser", "changePwd4WtloginCallback success");
    SharedPreferenceUtil.setWtlogin(true);
    LoginUser.access$1202(this.this$0, false);
    LoginUser.access$1300(this.this$0, false, "", this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.5
 * JD-Core Version:    0.7.0.1
 */