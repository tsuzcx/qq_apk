package com.tencent.mobileqq.activity;

import aqgv;
import com.tencent.mobileqq.app.BaseActivity;

class QQSettingMe$14
  implements Runnable
{
  QQSettingMe$14(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    String str2 = aqgv.o(this.this$0.app, this.val$uin);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2.trim())) {}
    }
    else
    {
      str1 = this.val$uin;
    }
    this.this$0.c.runOnUiThread(new QQSettingMe.14.1(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.14
 * JD-Core Version:    0.7.0.1
 */