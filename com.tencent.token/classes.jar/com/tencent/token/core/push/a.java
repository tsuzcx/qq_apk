package com.tencent.token.core.push;

import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.token.global.RqdApplication;

public class a
  extends ContextWrapper
{
  private NotificationManager a;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  private NotificationManager b()
  {
    if (this.a == null) {
      this.a = ((NotificationManager)getSystemService("notification"));
    }
    return this.a;
  }
  
  public Notification.Builder a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new Notification.Builder(RqdApplication.l(), "channel_qqsafe").setDefaults(1).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent).setSmallIcon(2130837767).setAutoCancel(true);
    }
    return null;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      NotificationChannel localNotificationChannel = new NotificationChannel("channel_qqsafe", "channel_name_qqsafe", 4);
      b().createNotificationChannel(localNotificationChannel);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      a();
      paramString1 = a(paramString1, paramString2, paramPendingIntent).build();
      b().notify(paramInt, paramString1);
      return;
    }
    paramString1 = b(paramString1, paramString2, paramPendingIntent).build();
    b().notify(paramInt, paramString1);
  }
  
  public NotificationCompat.Builder b(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    return new NotificationCompat.Builder(RqdApplication.l()).setDefaults(1).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent).setSmallIcon(2130837767).setAutoCancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.a
 * JD-Core Version:    0.7.0.1
 */