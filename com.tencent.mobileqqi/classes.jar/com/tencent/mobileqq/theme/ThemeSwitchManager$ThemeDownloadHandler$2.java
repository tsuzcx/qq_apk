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
      if ((!this.this$1.this$0.isComplete) && (ThemeSwitchManager.access$700(this.this$1.this$0) != null))
      {
        ThemeSwitchManager.access$600(this.this$1.this$0).removeCallbacks(ThemeSwitchManager.access$700(this.this$1.this$0));
        ThemeSwitchManager.access$600(this.this$1.this$0).postDelayed(ThemeSwitchManager.access$700(this.this$1.this$0), 3000L);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "screenBroadcastReceiver action:" + paramContext);
      }
      return;
      if (("android.intent.action.SCREEN_OFF".equals(paramContext)) && (ThemeSwitchManager.access$700(this.this$1.this$0) != null)) {
        ThemeSwitchManager.access$600(this.this$1.this$0).removeCallbacks(ThemeSwitchManager.access$700(this.this$1.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler.2
 * JD-Core Version:    0.7.0.1
 */