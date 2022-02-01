package com.tencent.qqmail.account.helper;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.utilities.log.QMLog;

final class LoginUIHelper$6
  implements Runnable
{
  LoginUIHelper$6(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean) {}
  
  public void run()
  {
    LoginUIHelper.access$200(LoginUIHelper.access$100(this.val$context, this.val$context.getString(2131695520), this.val$errorMsg, this.val$context.getString(2131696547), this.val$okListener, this.val$dismissListener), this.val$priority);
    QMLog.log(5, "LoginUIHelper", "processCustomError:" + this.val$errorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.6
 * JD-Core Version:    0.7.0.1
 */