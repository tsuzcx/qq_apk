package com.tencent.qqmail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

class QMApplicationContext$4
  implements Runnable
{
  QMApplicationContext$4(QMApplicationContext paramQMApplicationContext, long paramLong) {}
  
  public void run()
  {
    String str = "visible_welcome_" + AppConfig.getSystemVersionCode();
    if (SPManager.getSp("qmapplication_start_up_info").getLong(str, -1L) == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        SPManager.getEditor("qmapplication_start_up_info").putLong(str, this.val$elapsed).apply();
      }
      QMLog.log(4, "QMApplicationContext", "Visible Welcome, first: " + bool + ", elapsed: " + this.val$elapsed + "ms");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.4
 * JD-Core Version:    0.7.0.1
 */