package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.tencent.qqmail.utilities.AppStatusUtil;

final class QMLogStream$5
  implements Runnable
{
  QMLogStream$5(long paramLong) {}
  
  public void run()
  {
    if (QMLogStream.access$900()) {}
    for (;;)
    {
      try
      {
        if (QMLogStream.isOtherProcessHandlingLogFile()) {
          break label134;
        }
        QMLogStream.setOtherProcessHandlingLogFile(true);
        boolean bool = AppStatusUtil.isAppOnForeground();
        if (!bool) {
          break label128;
        }
        String str1 = "1";
        QMLogStream.logWithoutUmaNow(-40006, str1, "Event_App_State");
        StringBuilder localStringBuilder = new StringBuilder().append("submit state log:");
        if (!bool) {
          break label146;
        }
        str1 = "1";
        Log.i("QMLogStream", str1);
        QMLogStream.setOtherProcessHandlingLogFile(false);
        Thread.sleep(this.val$minutes * 60L * 1000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        QMLogStream.setOtherProcessHandlingLogFile(false);
        QMLog.log(6, "QMLogStream", "startCgiLogState. err:" + localInterruptedException.toString());
      }
      break;
      label128:
      String str2 = "0";
      continue;
      label134:
      QMLog.log(4, "QMLogStream", "other process handling logfile");
      continue;
      return;
      label146:
      str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.5
 * JD-Core Version:    0.7.0.1
 */