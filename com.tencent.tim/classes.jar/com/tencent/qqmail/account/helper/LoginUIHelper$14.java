package com.tencent.qqmail.account.helper;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

final class LoginUIHelper$14
  implements Runnable
{
  LoginUIHelper$14(int paramInt, Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnDismissListener paramOnDismissListener, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    int i = 2131695510;
    String str;
    switch (this.val$errorType)
    {
    default: 
      LoginUIHelper.processUnknownError(this.val$context, this.val$context.getString(2131695520), this.val$okListener, this.val$dismissListener);
      return;
    case -1001: 
    case -56: 
    case -55: 
    case 1: 
    case 7: 
    case 8: 
    case 10: 
    case 100: 
    case 10001: 
      switch (this.val$errorType)
      {
      default: 
        i = 0;
        if (i != 0) {
          break;
        }
      }
      for (str = this.val$errMsg;; str = this.val$context.getString(i))
      {
        LoginUIHelper.access$200(LoginUIHelper.access$100(this.val$context, this.val$context.getString(2131695520), str, this.val$context.getString(2131696547), this.val$okListener, this.val$dismissListener), false);
        return;
        i = 2131695545;
        break;
        i = 2131695515;
        DataCollector.logException(7, 45, "Event_Error", this.val$context.getString(2131695546), true);
        break;
        i = 2131695535;
        DataCollector.logException(7, 44, "Event_Error", this.val$context.getString(2131695535), true);
        break;
        i = 2131695515;
        break;
        i = 2131695511;
        break;
        i = 2131695508;
        break;
        DataCollector.logException(7, 42, "Event_Error", this.val$context.getString(2131695510), true);
        break;
        i = 2131695557;
        break;
        i = 2131695542;
        break;
      }
    case 2: 
      QMLog.log(4, "LoginUIHelper", "LOGIN_ERROR_TYPE_VERIFY_CODE_ERROR");
      return;
    case 3: 
      QMLog.log(4, "LoginUIHelper", "LOGIN_ERROR_TYPE_NEED_VERIFY_CODE");
      return;
    }
    if (this.val$errorType == 4)
    {
      str = QMApplicationContext.sharedInstance().getString(2131695558);
      if (this.val$errorType != 4) {
        break label501;
      }
      DataCollector.logException(7, 46, "Event_Error", QMApplicationContext.sharedInstance().getString(2131695558), true);
    }
    for (;;)
    {
      LoginUIHelper.access$400(this.val$context, str, this.val$okListener, this.val$cancelListener, this.val$dismissListener, this.val$errorType);
      return;
      str = QMApplicationContext.sharedInstance().getString(2131695560);
      break;
      label501:
      DataCollector.logException(7, 47, "Event_Error", this.val$context.getString(2131695560), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.14
 * JD-Core Version:    0.7.0.1
 */