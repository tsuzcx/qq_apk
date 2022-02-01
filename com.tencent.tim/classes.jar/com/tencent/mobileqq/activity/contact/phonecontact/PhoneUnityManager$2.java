package com.tencent.mobileqq.activity.contact.phonecontact;

import acll;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yut;
import yuu;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(yuu paramyuu) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    yut localyut = this.this$0.a();
    ((acll)this.this$0.mApp.getBusinessHandler(34)).notifyUI(9, true, localyut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */