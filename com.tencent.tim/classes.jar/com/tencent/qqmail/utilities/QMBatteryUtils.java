package com.tencent.qqmail.utilities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import com.tencent.qqmail.QMApplicationContext;

public class QMBatteryUtils
{
  private static final BroadcastReceiver EMPTY_RECEIVER = new QMBatteryUtils.1();
  
  public static boolean isCharging()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = ((BatteryManager)QMApplicationContext.sharedInstance().getSystemService("batterymanager")).isCharging();
    }
    for (;;)
    {
      return bool;
      Intent localIntent = QMApplicationContext.sharedInstance().registerReceiver(EMPTY_RECEIVER, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      QMApplicationContext.sharedInstance().unregisterReceiver(EMPTY_RECEIVER);
      if (localIntent != null) {}
      for (int i = localIntent.getIntExtra("status", -1); (i == 2) || (i == 5); i = 0) {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMBatteryUtils
 * JD-Core Version:    0.7.0.1
 */