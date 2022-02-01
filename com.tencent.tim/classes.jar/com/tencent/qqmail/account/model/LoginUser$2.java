package com.tencent.qqmail.account.model;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginUser$2
  extends LoginUser.Callback
{
  LoginUser$2(LoginUser paramLoginUser, long paramLong)
  {
    super(paramLoginUser, null);
  }
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    LoginUser.access$300(this.this$0, this.val$currentLoginId, paramQMNetworkError);
  }
  
  public void onSuccess(String paramString)
  {
    LoginUser.access$100(this.this$0);
    LoginUser.access$200(this.this$0, this.val$currentLoginId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.2
 * JD-Core Version:    0.7.0.1
 */