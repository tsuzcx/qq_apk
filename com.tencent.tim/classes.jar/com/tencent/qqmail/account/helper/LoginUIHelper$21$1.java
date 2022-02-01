package com.tencent.qqmail.account.helper;

import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class LoginUIHelper$21$1
  implements Runnable
{
  LoginUIHelper$21$1(LoginUIHelper.21 param21, boolean paramBoolean) {}
  
  public void run()
  {
    if (AppStatusUtil.isAppOnForeground())
    {
      QMLog.log(4, "LoginUIHelper", "click exit app. then app go forground. *dont* kill process");
      return;
    }
    LoginUIHelper.access$500(this.val$exitWithPush);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.21.1
 * JD-Core Version:    0.7.0.1
 */