package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class BaseActivity$1
  implements Runnable
{
  BaseActivity$1(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    int i = 0;
    if (!SettingCloneUtil.readValue(this.this$0, null, this.this$0.getString(2131697091), "qqsetting_screenshot_key", false)) {}
    for (;;)
    {
      if (i != 0) {
        this.this$0.turnOnShake();
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      BaseActivity.access$102(new BaseActivity.a(null));
      try
      {
        this.this$0.getApplicationContext().registerReceiver(BaseActivity.access$100(), localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "", localException);
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.1
 * JD-Core Version:    0.7.0.1
 */