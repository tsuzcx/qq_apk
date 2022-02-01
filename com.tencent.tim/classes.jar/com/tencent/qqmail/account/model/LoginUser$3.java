package com.tencent.qqmail.account.model;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;

class LoginUser$3
  extends LoginUser.Callback
{
  LoginUser$3(LoginUser paramLoginUser, long paramLong)
  {
    super(paramLoginUser, null);
  }
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkError instanceof QMLoginError))
    {
      LoginUser.access$300(this.this$0, this.val$currentLoginId, paramQMNetworkError);
      return;
    }
    LoginUser.access$300(this.this$0, 0L, paramQMNetworkError);
  }
  
  public void onSuccess(String paramString)
  {
    LoginUser.access$100(this.this$0);
    LoginUser.access$200(this.this$0, this.val$currentLoginId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.3
 * JD-Core Version:    0.7.0.1
 */