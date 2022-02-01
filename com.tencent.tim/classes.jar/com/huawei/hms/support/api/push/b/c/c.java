package com.huawei.hms.support.api.push.b.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Date;

public class c
{
  private static int a = 0;
  
  @TargetApi(26)
  public static Notification a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    a.a(paramContext, localBuilder, parama);
    int i = paramContext.getApplicationInfo().labelRes;
    localBuilder.setTicker(parama.k());
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setAutoCancel(true);
    localBuilder.setDefaults(1);
    if ((parama.m() == null) || ("".equals(parama.m()))) {
      localBuilder.setContentTitle(paramContext.getResources().getString(i));
    }
    for (;;)
    {
      localBuilder.setContentText(parama.k());
      localBuilder.setContentIntent(a(paramContext, parama, paramString, paramInt1, paramInt2));
      localBuilder.setDeleteIntent(b(paramContext, parama, paramString, paramInt1, paramInt3));
      paramString = a.a(paramContext, parama);
      if (paramString != null) {
        localBuilder.setLargeIcon(paramString);
      }
      if (Build.VERSION.SDK_INT >= 26) {
        localBuilder.setChannelId("HwPushChannelID");
      }
      a(paramContext, localBuilder, parama);
      b(paramContext, localBuilder, parama);
      return localBuilder.getNotification();
      localBuilder.setContentTitle(parama.m());
    }
  }
  
  private static PendingIntent a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "1").putExtra("extra_encrypt_data", paramString).putExtra("selfshow_notify_id", paramInt1).setPackage(paramContext.getPackageName()).setFlags(268435456);
    return PendingIntent.getBroadcast(paramContext, paramInt2, localIntent, 134217728);
  }
  
  @SuppressLint({"NewApi"})
  private static void a(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.b.b.a parama)
  {
    if ("com.huawei.android.pushagent".equals(paramContext.getPackageName()))
    {
      paramContext = new Bundle();
      parama = parama.i();
      if (!TextUtils.isEmpty(parama))
      {
        paramContext.putString("hw_origin_sender_package_name", parama);
        paramBuilder.setExtras(paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt)
  {
    try
    {
      HMSLog.d("PushSelfShowLog", "enter setDelayAlarm(intent:" + paramIntent.toURI() + " interval:" + paramLong + "ms, context:" + paramContext);
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (localAlarmManager != null)
      {
        paramContext = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728);
        localAlarmManager.set(0, System.currentTimeMillis() + paramLong, paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + paramContext.toString());
    }
  }
  
  @TargetApi(26)
  public static void a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama, String paramString)
  {
    if ((paramContext == null) || (parama == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        HMSLog.d("PushSelfShowLog", " showNotification , the msg id = " + parama.a());
        if (a == 0) {
          a = (paramContext.getPackageName() + new Date().toString()).hashCode();
        }
        if (TextUtils.isEmpty(parama.e()))
        {
          i = a + 1;
          a = i;
          j = a + 1;
          a = j;
          k = a + 1;
          a = k;
          m = a + 1;
          a = m;
          HMSLog.d("PushSelfShowLog", "notifyId:" + i + ",openNotifyId:" + j + ",delNotifyId:" + k + ",alarmNotifyId:" + m);
          if (!com.huawei.hms.support.api.push.b.d.a.a()) {
            break label481;
          }
          localObject = a(paramContext, parama, paramString, i, j, k);
          NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
          if ((localNotificationManager == null) || (localObject == null)) {
            break;
          }
          if (Build.VERSION.SDK_INT >= 26) {
            localNotificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", paramContext.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
          }
          localNotificationManager.notify(i, (Notification)localObject);
          if (parama.f() <= 0) {
            break;
          }
          localObject = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
          ((Intent)localObject).putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "-1").putExtra("extra_encrypt_data", paramString).putExtra("selfshow_notify_id", i).setPackage(paramContext.getPackageName()).setFlags(32);
          a(paramContext, (Intent)localObject, parama.f(), m);
          HMSLog.d("PushSelfShowLog", "setDelayAlarm alarmNotityId" + m + " and intent is " + ((Intent)localObject).toURI());
          break;
        }
      }
      finally {}
      int i = (parama.i() + parama.e()).hashCode();
      int j = a + 1;
      a = j;
      int k = a + 1;
      a = k;
      int m = a + 1;
      a = m;
      continue;
      label481:
      Object localObject = null;
    }
  }
  
  private static PendingIntent b(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", paramInt1).setPackage(paramContext.getPackageName()).putExtra("extra_encrypt_data", paramString).setFlags(268435456);
    return PendingIntent.getBroadcast(paramContext, paramInt2, localIntent, 134217728);
  }
  
  @SuppressLint({"NewApi"})
  private static void b(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.b.b.a parama)
  {
    if ((HwBuildEx.VERSION.EMUI_SDK_INT >= 11) && (com.huawei.hms.support.api.push.b.d.a.b(paramContext)))
    {
      Bundle localBundle = new Bundle();
      parama = parama.i();
      HMSLog.i("PushSelfShowLog", "the package name of notification is:" + parama);
      if (!TextUtils.isEmpty(parama))
      {
        paramContext = com.huawei.hms.support.api.push.b.d.a.a(paramContext, parama);
        HMSLog.i("PushSelfShowLog", "the app name is:" + paramContext);
        if (paramContext != null) {
          localBundle.putCharSequence("android.extraAppName", paramContext);
        }
      }
      paramBuilder.setExtras(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.c.c
 * JD-Core Version:    0.7.0.1
 */