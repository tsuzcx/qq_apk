package com.huawei.hms.support.api.push.c.a;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return b(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return b(paramContext);
    }
    return true;
  }
  
  @SuppressLint({"NewApi", "InlinedApi"})
  private static boolean b(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
      return i == 0;
    }
    catch (ClassNotFoundException paramContext)
    {
      return true;
    }
    catch (RuntimeException paramContext)
    {
      break label122;
    }
    catch (NoSuchFieldException paramContext)
    {
      break label122;
    }
    catch (IllegalAccessException paramContext)
    {
      break label122;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label122;
    }
    catch (InvocationTargetException paramContext)
    {
      label122:
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.c.a.a
 * JD-Core Version:    0.7.0.1
 */