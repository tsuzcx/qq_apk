package com.tencent.mobileqq.activity.phone;

import com.tencent.qphone.base.util.QLog;

class GuideBindPhoneActivity$2
  implements Runnable
{
  GuideBindPhoneActivity$2(GuideBindPhoneActivity paramGuideBindPhoneActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuideBindPhoneActivity", 2, "do not have read phone contact permission");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity.2
 * JD-Core Version:    0.7.0.1
 */