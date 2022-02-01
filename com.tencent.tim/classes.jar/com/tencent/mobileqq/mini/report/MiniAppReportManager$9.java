package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aroi;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

final class MiniAppReportManager$9
  implements Runnable
{
  MiniAppReportManager$9(MiniAppConfig paramMiniAppConfig, long paramLong) {}
  
  public void run()
  {
    try
    {
      long l = aroi.a().getUin();
      Object localObject = MiniAppReportManager.access$1100(this.val$miniAppConfig);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = MiniAppReportManager.access$1200(l, (String)localObject);
        String str = MiniAppReportManager.access$1300(l, MiniProgramReportHelper.getLaunchIdFromMainProcess(this.val$miniAppConfig));
        l = ((SharedPreferences)localObject).getLong(str, 0L);
        ((SharedPreferences)localObject).edit().putLong(str, this.val$addDuration + l).apply();
        if (QLog.isColorLevel()) {
          QLog.i("MiniAppReportManager", 2, "recordDuration: " + (l + this.val$addDuration) + " key: " + str);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "recordDuration exception ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.9
 * JD-Core Version:    0.7.0.1
 */