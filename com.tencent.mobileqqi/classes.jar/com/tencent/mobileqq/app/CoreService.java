package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;

public class CoreService
{
  public static Notification a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new Notification();
      ((Notification)localObject).icon = 2130838018;
      ((Notification)localObject).contentView = new RemoteViews(BaseApplicationImpl.a.getPackageName(), 2130903334);
      return localObject;
    }
    Object localObject = new Intent(BaseApplicationImpl.a, SplashActivity.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = PendingIntent.getActivity(BaseApplicationImpl.a, 0, (Intent)localObject, 402653184);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(BaseApplicationImpl.a);
    localBuilder.setContentTitle("QQ").setContentText("QQ正在后台运行").setWhen(System.currentTimeMillis()).setSmallIcon(2130838018);
    localBuilder.setContentIntent((PendingIntent)localObject);
    return localBuilder.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService
 * JD-Core Version:    0.7.0.1
 */