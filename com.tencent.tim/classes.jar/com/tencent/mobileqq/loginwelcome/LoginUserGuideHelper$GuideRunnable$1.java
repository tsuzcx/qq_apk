package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class LoginUserGuideHelper$GuideRunnable$1
  implements Runnable
{
  LoginUserGuideHelper$GuideRunnable$1(LoginUserGuideHelper.GuideRunnable paramGuideRunnable, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.val$app.getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.clY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable.1
 * JD-Core Version:    0.7.0.1
 */