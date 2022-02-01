package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

final class ai
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")) {}
    do
    {
      do
      {
        do
        {
          try
          {
            ac.a(ac.Q);
            return;
          }
          catch (Exception paramContext)
          {
            while (!QLog.isColorLevel()) {}
            QLog.e("health_manager", 2, "setTodayOffSet Exception:" + paramContext.toString());
            return;
          }
        } while (!paramIntent.getAction().equals("MSF_Action_Refresh_Steps"));
        QLog.i("health_manager", 1, "AlarmManager 23:59 action received:" + ac.M);
      } while ((!ac.M) || (ac.L == null) || (ac.al == null));
      try
      {
        ac.L.flush(ac.al);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("health_manager", 2, "Exception:" + paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ai
 * JD-Core Version:    0.7.0.1
 */