package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

final class ThemeUiPlugin$1
  implements Runnable
{
  ThemeUiPlugin$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    ThemeUiPlugin.initDownloadedThemeNumForReport = ThemeUtil.getThemeDownloadNum(this.val$app.a());
    ThemeUiPlugin.initCurrThemeNameForReport = ThemeUtil.getUserCurrentThemeId(this.val$app);
    Message localMessage = ThemeUiPlugin.reportHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { this.val$selfUin, this.val$app };
    if (QLog.isColorLevel()) {
      QLog.d("ThemeUiPlugin", 2, "begin to report theme info");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeUiPlugin", 2, "initDownloadedThemeNumForReport is:" + ThemeUiPlugin.initDownloadedThemeNumForReport + ",initCurrThemeNameForReport is:" + ThemeUiPlugin.initCurrThemeNameForReport);
    }
    ThemeUiPlugin.reportHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */