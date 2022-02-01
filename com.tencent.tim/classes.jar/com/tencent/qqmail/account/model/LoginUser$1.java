package com.tencent.qqmail.account.model;

import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginUser$1
  extends LoginUser.Callback
{
  LoginUser$1(LoginUser paramLoginUser, long paramLong)
  {
    super(paramLoginUser, null);
  }
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("login onError:");
    if (paramQMNetworkError != null)
    {
      str = paramQMNetworkError.toString();
      QMLog.log(6, "LoginUser", str);
      localStringBuilder = new StringBuilder().append("login onError:");
      if (paramQMNetworkError == null) {
        break label92;
      }
    }
    label92:
    for (String str = paramQMNetworkError.toString();; str = "error is null")
    {
      Log.d("donald", str);
      LoginUser.access$300(this.this$0, this.val$currentLoginId, paramQMNetworkError);
      return;
      str = "error is null";
      break;
    }
  }
  
  public void onSuccess(String paramString)
  {
    LoginUser.access$100(this.this$0);
    LoginUser.access$200(this.this$0, this.val$currentLoginId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.1
 * JD-Core Version:    0.7.0.1
 */