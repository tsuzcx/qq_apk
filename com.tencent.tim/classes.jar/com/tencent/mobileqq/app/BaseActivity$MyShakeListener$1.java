package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import aqey;
import aqoo;
import aqoq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class BaseActivity$MyShakeListener$1
  implements Runnable
{
  BaseActivity$MyShakeListener$1(BaseActivity.b paramb, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    boolean bool = true;
    Object localObject;
    if (!this.o.isResume())
    {
      localObject = this.o.getSharedPreferences("screen_shot", 4).getString("currentactivity", null);
      bool = this.o.getClass().getName().equals(localObject);
    }
    if ((bool) && (SettingCloneUtil.readValue(this.o, null, this.o.getString(2131697091), "qqsetting_screenshot_key", false)) && (aqey.isScreenOn(BaseApplicationImpl.sApplication)))
    {
      if (!this.o.isSupportScreenShot())
      {
        ScreenShot.EN("MyShakeListener - not support screen shot");
        return;
      }
      if (this.o.screenShot == null) {
        if (this.o.isResume()) {
          break label195;
        }
      }
      label195:
      for (localObject = this.o.getApplicationContext();; localObject = this.o)
      {
        this.o.screenShot = new ScreenShot((Context)localObject, this.o.getWindow());
        if (!this.o.screenShot.isInit()) {
          break;
        }
        bool = this.o.screenShot.isShowing();
        if (!bool) {
          break label204;
        }
        ScreenShot.EN("MyShakeListener - screenshot is showing");
        return;
      }
      label204:
      if (this.o.screenShot.activate()) {
        break label299;
      }
      ScreenShot.EN("MyShakeListener - screenshot cant activate");
      BaseActivity.access$000(this.o);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseActivity", 2, "snapshot activate " + bool);
      }
      long l2 = SystemClock.uptimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqBaseActivity", 2, "cost:" + (l2 - l1));
      return;
      label299:
      if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11)) {
        aqoo.a().setActivityWindowType_TYPE_KEYGUARD(this.o.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.MyShakeListener.1
 * JD-Core Version:    0.7.0.1
 */