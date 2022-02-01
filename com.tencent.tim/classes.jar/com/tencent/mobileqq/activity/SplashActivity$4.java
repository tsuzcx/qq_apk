package com.tencent.mobileqq.activity;

import anot;
import aqmb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SplashActivity$4
  implements Runnable
{
  SplashActivity$4(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    long l = SpaceLowNoticeActiviy.a(this.this$0.app, "conf_space_low_shreshold", 104857600L);
    if (SpaceLowNoticeActiviy.bu(SpaceLowNoticeActiviy.a(this.this$0.app, "conf_space_check_interval", 259200000L)))
    {
      if (aqmb.t(this.this$0) + aqmb.getAvailableInternalMemorySize() < l)
      {
        QLog.i("SplashActivity", 1, "qqclean conf did notice");
        SpaceLowNoticeActiviy.dh(this.this$0);
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007545", "0X8007545", 0, 0, this.this$0.app.getCurrentAccountUin(), "", "", "");
      }
    }
    else {
      return;
    }
    QLog.i("SplashActivity", 1, "qqclean conf not need notice");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.4
 * JD-Core Version:    0.7.0.1
 */