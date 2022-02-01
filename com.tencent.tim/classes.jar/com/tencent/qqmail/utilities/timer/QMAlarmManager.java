package com.tencent.qqmail.utilities.timer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMAlarmManager
{
  private static final String TAG = "QMAlarmManager";
  
  public static void registerRepeatingInexactlyAlarm(long paramLong, PendingIntent paramPendingIntent)
  {
    ((AlarmManager)QMApplicationContext.sharedInstance().getSystemService("alarm")).setInexactRepeating(3, SystemClock.elapsedRealtime() + paramLong, paramLong, paramPendingIntent);
  }
  
  public static void registerSingleExactlyAlarm(long paramLong, PendingIntent paramPendingIntent)
  {
    AlarmManager localAlarmManager;
    try
    {
      localAlarmManager = (AlarmManager)QMApplicationContext.sharedInstance().getSystemService("alarm");
      int i = Build.VERSION.SDK_INT;
      paramLong = SystemClock.elapsedRealtime() + paramLong;
      if (i < 19)
      {
        localAlarmManager.set(2, paramLong, paramPendingIntent);
        return;
      }
      if (i < 23)
      {
        localAlarmManager.setExact(2, paramLong, paramPendingIntent);
        return;
      }
    }
    catch (Throwable paramPendingIntent)
    {
      QMLog.log(5, "QMAlarmManager", "registerSingleExactlyAlarm failed", paramPendingIntent);
      return;
    }
    localAlarmManager.setExactAndAllowWhileIdle(2, paramLong, paramPendingIntent);
  }
  
  public static void registerSingleInexactlyAlarm(long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      ((AlarmManager)QMApplicationContext.sharedInstance().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + paramLong, paramPendingIntent);
      return;
    }
    catch (Throwable paramPendingIntent) {}
  }
  
  public static void unRegisterAlarm(PendingIntent paramPendingIntent)
  {
    ((AlarmManager)QMApplicationContext.sharedInstance().getSystemService("alarm")).cancel(paramPendingIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.timer.QMAlarmManager
 * JD-Core Version:    0.7.0.1
 */