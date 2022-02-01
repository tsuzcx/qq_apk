package com.tencent.mobileqq.app;

import akth;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.util.WeakReference;

public final class BatteryBroadcastReceiver
  extends BroadcastReceiver
{
  private final WeakReference<QQAppInterface> K;
  private int cux = -1;
  
  public BatteryBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.K = new WeakReference(paramQQAppInterface);
  }
  
  private void cHh()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.K.get();
    if ((localQQAppInterface != null) && (localQQAppInterface.getOnlineStatus() == AppRuntime.Status.online) && (localQQAppInterface.getExtOnlineStatus() == 1000L))
    {
      localQQAppInterface.a(AppRuntime.Status.online, 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, "toggleChangeInCharging");
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      paramContext = (QQAppInterface)this.K.get();
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, new Object[] { "onReceive action:", str });
      }
      if (!TextUtils.equals(str, "android.intent.action.ACTION_POWER_CONNECTED")) {
        break label71;
      }
      if (paramContext != null) {
        paramContext.setPowerConnect(1);
      }
      cHh();
    }
    label71:
    int i;
    do
    {
      do
      {
        return;
        if (TextUtils.equals(str, "android.intent.action.ACTION_POWER_DISCONNECTED"))
        {
          if (paramContext != null) {
            paramContext.setPowerConnect(0);
          }
          cHh();
          return;
        }
      } while (!TextUtils.equals(str, "android.intent.action.BATTERY_CHANGED"));
      int j = paramIntent.getIntExtra("level", 0);
      int k = paramIntent.getIntExtra("scale", 100);
      i = j;
      if (k != 0) {
        i = j * 100 / k;
      }
    } while (paramContext == null);
    paramIntent = paramContext.getOnlineStatus();
    long l = paramContext.getExtOnlineStatus();
    if (QLog.isColorLevel()) {
      QLog.d("BatteryBroadcastReceiver", 2, "onBatteryChanged onlineStatus == " + paramIntent + ", extOnlineStatus() == " + l);
    }
    if ((paramIntent == AppRuntime.Status.online) && (l == 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, "onBatteryChanged curLevel == " + i + ", lastLevel == " + this.cux);
      }
      if (this.cux != i)
      {
        this.cux = i;
        paramIntent = new Bundle();
        paramIntent.putInt("KEY_BATTERY", i);
        paramContext.notifyObservers(akth.class, 0, true, paramIntent);
      }
    }
    paramContext.setBatteryCapacity(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BatteryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */