package com.tencent.android.tpush.d;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  private static final String[] a = { "com.tencent.android.tpush.otherpush.mipush.impl.OtherPushImpl", "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl" };
  private static int b = -2;
  private static String c = null;
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = Class.forName(paramString2);
      paramString2.getMethod("setAppid", new Class[] { Context.class, String.class }).invoke(paramString2, new Object[] { paramContext, paramString1 });
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.ww("OtherPush", "setAppid Error, are you import otherpush package? " + paramContext);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (b == -2)
    {
      int i = 0;
      while (i < a.length) {
        try
        {
          Class.forName(a[i]);
          if (a(paramContext, a[i]))
          {
            b = i;
            c = a[i];
            return true;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          i += 1;
        }
      }
      b = -1;
    }
    if (b > -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      TLogger.ii("OtherPush", "checkDevice pushClassName" + paramString);
      paramString = Class.forName(paramString);
      boolean bool = ((Boolean)paramString.getMethod("checkDevice", new Class[] { Context.class }).invoke(paramString, new Object[] { paramContext })).booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = paramContext.getCause();
      TLogger.ee("OtherPush", "checkDevice Error for InvocationTargetException: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return false;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("OtherPush", "checkDevice Error, are you import otherpush package? " + paramContext);
    }
    return false;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a
 * JD-Core Version:    0.7.0.1
 */