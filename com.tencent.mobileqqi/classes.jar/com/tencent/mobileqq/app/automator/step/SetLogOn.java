package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.log.ReportLog;
import mqq.manager.ServerConfigManager.ConfigType;

public class SetLogOn
  extends AsyncStep
{
  protected int a()
  {
    String str = this.a.a.a(ServerConfigManager.ConfigType.user, "needUploadQQIni");
    if (AppSetting.g) {
      ReportLog.a(this.a.a.a(), true);
    }
    for (;;)
    {
      str = this.a.a.a(ServerConfigManager.ConfigType.app, "bit");
      if ((str != null) && (str.length() > 0)) {}
      try
      {
        long l = Long.parseLong(str);
        if (l > 0L) {
          this.a.a.b(l);
        }
      }
      catch (Exception localException)
      {
        label85:
        break label85;
      }
      return 7;
      if ((str != null) && (str.length() > 0)) {
        if (str.equals("1")) {
          ReportLog.a(this.a.a.a(), true);
        } else {
          ReportLog.a(this.a.a.a(), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SetLogOn
 * JD-Core Version:    0.7.0.1
 */