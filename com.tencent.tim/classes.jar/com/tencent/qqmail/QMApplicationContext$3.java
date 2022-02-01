package com.tencent.qqmail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import moai.oss.KvHelper;

class QMApplicationContext$3
  implements Runnable
{
  QMApplicationContext$3(QMApplicationContext paramQMApplicationContext, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    KvHelper.applicationLauncherTime(new double[] { this.val$elapsed });
    String str = "application_oncreate_" + AppConfig.getSystemVersionCode();
    if (SPManager.getSp("qmapplication_start_up_info").getLong(str, -1L) == -1L) {}
    for (;;)
    {
      if (bool) {
        SPManager.getEditor("qmapplication_start_up_info").putLong(str, this.val$elapsed).apply();
      }
      QMLog.log(4, "QMApplicationContext", "App OnCreate Done, first: " + bool + ", elapsed: " + this.val$elapsed + "ms");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.3
 * JD-Core Version:    0.7.0.1
 */