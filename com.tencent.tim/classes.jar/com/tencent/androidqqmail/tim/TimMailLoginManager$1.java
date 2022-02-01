package com.tencent.androidqqmail.tim;

import mqq.app.AppRuntime;

final class TimMailLoginManager$1
  implements Runnable
{
  TimMailLoginManager$1(String paramString1, String paramString2, String paramString3, AppRuntime paramAppRuntime, TimMailLoginManager.GetTicketCallback paramGetTicketCallback) {}
  
  public void run()
  {
    if (this.val$fPwd == null)
    {
      String str = this.val$account.split("@")[0];
      if (this.val$timAccount.equals(str)) {}
      for (int i = 16;; i = 756044602)
      {
        if (this.val$timAccount.equals(str)) {}
        this.val$pluginRuntime.ssoGetTicketNoPasswd(str, 64, i, 756044602, new TimMailLoginManager.1.1(this, str, i, 756044602));
        return;
      }
    }
    this.val$pluginRuntime.ssoLogin(this.val$account, this.val$fPwd, 64, 756044602L, new TimMailLoginManager.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager.1
 * JD-Core Version:    0.7.0.1
 */