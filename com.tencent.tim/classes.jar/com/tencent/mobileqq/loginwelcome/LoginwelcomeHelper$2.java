package com.tencent.mobileqq.loginwelcome;

import aiwd;
import com.tencent.mobileqq.activity.Conversation;

public class LoginwelcomeHelper$2
  implements Runnable
{
  public LoginwelcomeHelper$2(aiwd paramaiwd) {}
  
  public void run()
  {
    if (this.this$0.a.app != null)
    {
      LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.this$0.a.app);
      localLoginWelcomeManager.duX();
      if (localLoginWelcomeManager.cme) {
        localLoginWelcomeManager.dva();
      }
      if (localLoginWelcomeManager.cmf) {
        localLoginWelcomeManager.dvb();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2
 * JD-Core Version:    0.7.0.1
 */