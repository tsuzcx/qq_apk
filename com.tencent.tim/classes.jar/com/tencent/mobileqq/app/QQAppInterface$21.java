package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class QQAppInterface$21
  implements Runnable
{
  QQAppInterface$21(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "isCallTabShow needupdate,result=" + this.O);
    }
    SettingCloneUtil.writeValue(this.this$0.getApplication(), this.this$0.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", this.O.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.21
 * JD-Core Version:    0.7.0.1
 */