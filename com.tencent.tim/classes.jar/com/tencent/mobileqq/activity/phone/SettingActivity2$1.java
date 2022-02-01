package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

class SettingActivity2$1
  implements Runnable
{
  SettingActivity2$1(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    boolean bool = this.this$0.f.Uy();
    if (QLog.isColorLevel()) {
      QLog.i("SettingActivity2", 2, "doOnResume : " + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.1
 * JD-Core Version:    0.7.0.1
 */