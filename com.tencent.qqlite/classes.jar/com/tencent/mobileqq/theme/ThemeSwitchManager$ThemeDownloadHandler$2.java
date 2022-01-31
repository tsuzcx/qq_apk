package com.tencent.mobileqq.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class ThemeSwitchManager$ThemeDownloadHandler$2
  extends BroadcastReceiver
{
  ThemeSwitchManager$ThemeDownloadHandler$2(ThemeSwitchManager.ThemeDownloadHandler paramThemeDownloadHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext)) {
      if ((!this.this$1.this$0.isComplete) && (this.this$1.this$0.checkTopActivity != null))
      {
        this.this$1.this$0.handler.removeCallbacks(this.this$1.this$0.checkTopActivity);
        this.this$1.this$0.handler.postDelayed(this.this$1.this$0.checkTopActivity, 3000L);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "screenBroadcastReceiver action:" + paramContext);
      }
      return;
      if (("android.intent.action.SCREEN_OFF".equals(paramContext)) && (this.this$1.this$0.checkTopActivity != null)) {
        this.this$1.this$0.handler.removeCallbacks(this.this$1.this$0.checkTopActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler.2
 * JD-Core Version:    0.7.0.1
 */