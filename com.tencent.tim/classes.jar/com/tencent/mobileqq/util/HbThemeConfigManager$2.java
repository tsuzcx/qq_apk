package com.tencent.mobileqq.util;

import android.util.Base64;
import aqds;
import aqhq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class HbThemeConfigManager$2
  implements Runnable
{
  public HbThemeConfigManager$2(aqds paramaqds, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config: " + this.val$config);
      }
      aqhq.z(aqds.a(this.this$0, this.val$app), "hbThemeConfig.cfg", Base64.encodeToString(this.val$config.getBytes(), 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager.2
 * JD-Core Version:    0.7.0.1
 */