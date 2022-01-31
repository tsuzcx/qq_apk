package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.qphone.base.util.QLog;

class ThemeSwitchManager$ThemeDownloadHandler$1
  implements Runnable
{
  ThemeSwitchManager$ThemeDownloadHandler$1(ThemeSwitchManager.ThemeDownloadHandler paramThemeDownloadHandler, Activity paramActivity, Bundle paramBundle, ThemeUtil.ThemeInfo paramThemeInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "checkTopActivity is running");
    }
    ThemeSwitchManager.access$600(this.this$1.this$0).removeCallbacks(ThemeSwitchManager.access$700(this.this$1.this$0));
    Object localObject = ThemeSwitchManager.access$300(this.this$1.this$0, ThemeSwitchManager.access$100(this.this$1.this$0));
    if (localObject == null)
    {
      ThemeSwitchManager.access$602(this.this$1.this$0, null);
      return;
    }
    localObject = localObject[1];
    if ((localObject != null) && (this.val$refActivity != null) && (((String)localObject).equals(SplashActivity.class.getName())) && ((this.val$refActivity instanceof SplashActivity)) && (((FrameActivity)this.val$refActivity).a() == 3))
    {
      this.val$result.putSerializable("themeinfo", this.val$themeInfo);
      if (ThemeSwitchManager.access$500(this.this$1.this$0)) {
        ThemeSwitchManager.access$200(this.this$1.this$0, true, false, this.val$result);
      }
      this.this$1.this$0.setup(BaseApplicationImpl.a.a(), this.val$themeInfo);
    }
    for (;;)
    {
      this.this$1.this$0.isComplete = true;
      ThemeSwitchManager.access$602(this.this$1.this$0, null);
      ThemeSwitchManager.access$702(this.this$1.this$0, null);
      if (this.this$1.this$0.screenBroadcastReceiver == null) {
        break;
      }
      ThemeSwitchManager.access$100(this.this$1.this$0).unregisterReceiver(this.this$1.this$0.screenBroadcastReceiver);
      this.this$1.this$0.screenBroadcastReceiver = null;
      return;
      if (ThemeSwitchManager.access$500(this.this$1.this$0))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("themedownloadalert", true);
        ((Intent)localObject).putExtra("themeID", this.val$themeInfo.themeId);
        ((Intent)localObject).setClass(ThemeSwitchManager.access$100(this.this$1.this$0), ThemeSwitchDlgActivity.class);
        if (BaseActivity.a != null)
        {
          BaseActivity.a.startActivity((Intent)localObject);
        }
        else
        {
          ((Intent)localObject).setFlags(268435456);
          ThemeSwitchManager.access$100(this.this$1.this$0).startActivity((Intent)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */