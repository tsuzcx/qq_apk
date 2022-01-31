package com.tencent.sc.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

public class MsgNotifacation
{
  public static final int a = 0;
  private static MsgNotifacation jdField_a_of_type_ComTencentScAppMsgNotifacation = null;
  public static final long[] a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  private Notification jdField_a_of_type_AndroidAppNotification = null;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
  }
  
  public static int a(String paramString)
  {
    int k = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int m = arrayOfClass.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          Class localClass = arrayOfClass[i];
          if ("id".equals(localClass.getSimpleName())) {
            j = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public static MsgNotifacation a()
  {
    if (jdField_a_of_type_ComTencentScAppMsgNotifacation == null) {
      jdField_a_of_type_ComTencentScAppMsgNotifacation = new MsgNotifacation();
    }
    return jdField_a_of_type_ComTencentScAppMsgNotifacation;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.r();
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((NotificationManager)paramQQAppInterface.a().getSystemService("notification")).cancel(120);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        a(paramInt, paramQQAppInterface);
        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(BaseApplication.getContext()).setSmallIcon(2130839678).setAutoCancel(true).setOngoing(false).setWhen(System.currentTimeMillis()).setTicker(paramString);
        paramQQAppInterface.getApplication();
        paramInt = (int)(64.0F * MobileQQ.getContext().getResources().getDisplayMetrics().density + 0.5D);
        paramQQAppInterface.getApplication();
        localBuilder.setLargeIcon(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(MobileQQ.getContext().getResources(), 2130839678), paramInt, paramInt, true));
        Object localObject1 = QZoneHelper.a(paramQQAppInterface.a());
        ((Intent)localObject1).putExtra("qzone_uin", paramQQAppInterface.getAccount());
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("FromNotification", true);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("sid", paramQQAppInterface.getSid());
        ((Intent)localObject1).putExtra("src_type", "app");
        ((Intent)localObject1).putExtra("isFromQQ", "true");
        ((Intent)localObject1).putExtra("page", "tab_remind");
        ((Intent)localObject1).putExtra("version", "1");
        localObject2 = new Intent(paramQQAppInterface.a(), TranslucentActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).putExtras((Intent)localObject1);
        localObject1 = PendingIntent.getActivity(paramQQAppInterface.a(), 124, (Intent)localObject2, 1073741824);
        paramInt = ((QZoneManagerImp)paramQQAppInterface.getManager(9)).a(QZoneManager.FeedType.mySpacefeed);
        if (paramInt >= 2) {
          localBuilder.setContentInfo(String.valueOf(paramInt));
        }
        localBuilder.setContentIntent((PendingIntent)localObject1).setContentTitle(BaseApplication.getContext().getString(2131563431)).setContentText(paramString);
        this.jdField_a_of_type_AndroidAppNotification = localBuilder.build();
        ((NotificationManager)paramQQAppInterface.a().getSystemService("notification")).notify(120, this.jdField_a_of_type_AndroidAppNotification);
      } while (paramQQAppInterface == null);
      QzonePluginProxyActivity.a(paramQQAppInterface);
    } while (GuardManager.a == null);
    GuardManager.a.b(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sc.app.MsgNotifacation
 * JD-Core Version:    0.7.0.1
 */