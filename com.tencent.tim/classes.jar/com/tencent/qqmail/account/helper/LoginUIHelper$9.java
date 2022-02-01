package com.tencent.qqmail.account.helper;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.QMApplicationContext;

final class LoginUIHelper$9
  implements Runnable
{
  LoginUIHelper$9(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    if (this.val$context == null) {
      return;
    }
    LoginUIHelper.access$200(LoginUIHelper.access$300(this.val$context, QMApplicationContext.sharedInstance().getString(2131695520), this.val$msg, this.val$context.getString(2131689500), this.val$context.getString(2131691246), this.val$positiveListener, this.val$negativeListener, this.val$dismissListener), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.9
 * JD-Core Version:    0.7.0.1
 */