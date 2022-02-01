package com.tencent.qqmail.account.model;

import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.callback.WtLoginCallback;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginUser$7
  implements WtLoginCallback
{
  LoginUser$7(LoginUser paramLoginUser, LoginCallback paramLoginCallback, QMNetworkError paramQMNetworkError) {}
  
  public void onError(int paramInt, String paramString1, String paramString2)
  {
    LoginUser.access$2102(this.this$0, 3);
    QMLog.log(6, "LoginUser", "retryWtAutoLogin error ,isBindPhone:" + LoginUser.access$2200(this.this$0) + ",phoneNum:" + LoginUser.access$2300(this.this$0) + ",email:" + LoginUser.access$2000(this.this$0) + ",ret:" + paramInt + ",tips:" + paramString1 + ",userAccount:" + paramString2);
    LoginUser.access$1400(this.this$0, this.val$err);
    DataCollector.logDetailEvent("DetailEvent_WT_AutoLogin", LoginUser.access$1700(this.this$0).getId(), 1L, "email:" + paramString2 + ",ret:" + paramInt + ",tips:" + paramString1);
    AddAccountLocalLogUtil.timeLineAccountChange("SDK", "retryWtAutoLogin:" + LoginUser.access$2000(this.this$0) + ", ret:" + paramInt);
    if (paramInt == 192)
    {
      QMLog.log(4, "LoginUser", "retryWtAutoLogin. ret:" + paramInt + ". trigger ACCOUNT_STATE_DEVICE_LOCK");
      AccountManager.shareInstance().triggerAccountStateChange(LoginUser.access$1700(this.this$0).getId(), -5, paramString1);
    }
    for (;;)
    {
      if (this.val$outerCallBack != null) {
        this.val$outerCallBack.loginFail();
      }
      return;
      QMLog.log(4, "LoginUser", "retryWtAutoLogin ret:" + paramInt + ", err. set state psw err:" + LoginUser.access$1700(this.this$0).getEmail() + ". tips:" + paramString1);
      if ((paramString1 == null) || (paramString1.equals(""))) {
        PasswordErrHandler.saveStateAndShowErr(LoginUser.access$1700(this.this$0).getId(), -1);
      } else {
        PasswordErrHandler.saveStateAndShowErr(LoginUser.access$1700(this.this$0).getId(), -1, paramString2 + ", " + paramString1);
      }
    }
  }
  
  public void onSuccess(int paramInt, String paramString)
  {
    LoginUser.access$2102(this.this$0, 2);
    QMLog.log(4, "LoginUser", "get new wtlogin ticket ok. retry autoLogin,isBindPhone:" + LoginUser.access$2200(this.this$0) + ",phoneNum:" + LoginUser.access$2300(this.this$0) + ",email:" + LoginUser.access$2000(this.this$0) + ",ret:" + paramInt + ",userAccount:" + paramString);
    BackOffFilter.resetError(QMMath.hashInt("retryWtAutoLogin"));
    LoginUser.access$1300(this.this$0, false, "", this.val$outerCallBack);
    DataCollector.logDetailEvent("DetailEvent_WT_AutoLogin", LoginUser.access$1700(this.this$0).getId(), 0L, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.7
 * JD-Core Version:    0.7.0.1
 */