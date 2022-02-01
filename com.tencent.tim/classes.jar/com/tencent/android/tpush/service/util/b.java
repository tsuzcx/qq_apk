package com.tencent.android.tpush.service.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationManagerCompat;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
{
  public static boolean a(Context paramContext)
  {
    try
    {
      if (CloudManager.getInstance(paramContext).disableCollData())
      {
        TLogger.d("NotificationsUtils", "disable notification");
        return true;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        TLogger.i("NotificationsUtils", "OS >= 26, return true");
        return NotificationManagerCompat.from(paramContext).areNotificationsEnabled();
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
        Object localObject = paramContext.getApplicationInfo();
        paramContext = paramContext.getApplicationContext().getPackageName();
        int i = ((ApplicationInfo)localObject).uid;
        localObject = Class.forName(AppOpsManager.class.getName());
        i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
        if (i == 0) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("NotificationsUtils", paramContext.getMessage());
    }
  }
  
  public static int b(Context paramContext)
  {
    int i = 2;
    try
    {
      if (CloudManager.getInstance(paramContext).disableCollData())
      {
        TLogger.d("NotificationsUtils", "disable notification status");
        return 4;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        TLogger.i("NotificationsUtils", "OS >= 26, return true");
        if (NotificationManagerCompat.from(paramContext).areNotificationsEnabled()) {
          return 2;
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
          Object localObject = paramContext.getApplicationInfo();
          paramContext = paramContext.getApplicationContext().getPackageName();
          int j = ((ApplicationInfo)localObject).uid;
          localObject = Class.forName(AppOpsManager.class.getName());
          j = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(j), paramContext })).intValue();
          if (j == 0) {}
          for (;;)
          {
            return i;
            i = 1;
          }
        }
        return 4;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("NotificationsUtils", paramContext.getMessage());
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.b
 * JD-Core Version:    0.7.0.1
 */