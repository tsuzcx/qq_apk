package com.tencent.service;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.token.aad;
import com.tmsdk.common.util.TmsLog;

public class ActivateService
  extends Service
{
  NotificationManager a;
  String b = "channelId";
  String c = "channelName";
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    try
    {
      TmsLog.i("ActivateService", "onCreate.");
      super.onCreate();
      this.a = ((NotificationManager)getSystemService("notification"));
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = new NotificationChannel(this.b, this.c, 4);
        this.a.createNotificationChannel((NotificationChannel)localObject);
      }
      Object localObject = new Notification.Builder(this).setSmallIcon(2131099894).setContentTitle("QQ安全中心").setContentText("服务正在运行...");
      if (Build.VERSION.SDK_INT >= 26) {
        ((Notification.Builder)localObject).setChannelId(this.b);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        localObject = ((Notification.Builder)localObject).build();
      } else {
        localObject = new Notification();
      }
      startForeground(1, (Notification)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    try
    {
      TmsLog.i("ActivateService", "onDestroy.");
      super.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    TmsLog.i("ActivateService", "onStartCommand.");
    aad.g();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.ActivateService
 * JD-Core Version:    0.7.0.1
 */