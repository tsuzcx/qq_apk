package com.tencent.tpns.baseapi.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tpns.baseapi.base.util.Logger;

public class TPushAlarmManager
{
  private static TPushAlarmManager a = new TPushAlarmManager();
  private static AlarmManager b = null;
  
  private static void a(Context paramContext)
  {
    try
    {
      if ((b == null) && (paramContext != null)) {
        b = (AlarmManager)paramContext.getSystemService("alarm");
      }
      return;
    }
    finally {}
  }
  
  public static TPushAlarmManager getAlarmManager(Context paramContext)
  {
    if (b == null) {
      a(paramContext);
    }
    return a;
  }
  
  public void cancal(PendingIntent paramPendingIntent)
  {
    if (b != null) {
      b.cancel(paramPendingIntent);
    }
  }
  
  public void set(int paramInt, long paramLong, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (!paramBoolean)) {
      try
      {
        Logger.d("TPushAlarmManager", "Alarm setExactAndAllowWhileIdle  delay: " + paramLong);
        b.setExactAndAllowWhileIdle(paramInt, paramLong, paramPendingIntent);
        return;
      }
      catch (Throwable paramPendingIntent)
      {
        Logger.e("TPushAlarmManager", "Alarm scheule using setExactAndAllowWhileIdle, error: " + paramLong, paramPendingIntent);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        Logger.d("TPushAlarmManager", "Alarm scheule using setExact, delay: " + paramLong);
        b.setExact(paramInt, paramLong, paramPendingIntent);
        return;
      }
      catch (Throwable paramPendingIntent)
      {
        Logger.e("TPushAlarmManager", "Alarm scheule using setExact, error: " + paramLong, paramPendingIntent);
        return;
      }
    }
    try
    {
      Logger.d("TPushAlarmManager", "Alarm scheule using set, delay: " + paramLong);
      b.set(paramInt, paramLong, paramPendingIntent);
      return;
    }
    catch (Throwable paramPendingIntent)
    {
      Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + paramLong, paramPendingIntent);
    }
  }
  
  public void setRepeating(long paramLong1, long paramLong2, PendingIntent paramPendingIntent)
  {
    if (b != null) {
      b.setRepeating(2, paramLong1, paramLong2, paramPendingIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.TPushAlarmManager
 * JD-Core Version:    0.7.0.1
 */