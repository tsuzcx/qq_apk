package com.tencent.beacon.base.util;

import android.util.Log;
import java.util.Locale;

public class c
{
  public static boolean a = true;
  private static BeaconLogger b;
  private static boolean c;
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    if (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((paramClass.equals(Log.class)) && (i < paramArrayOfStackTraceElement.length - 1) && (paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) {}
      while (!str.equals(paramClass.getName()))
      {
        i += 1;
        break;
      }
      return i + 1;
    }
    return -1;
  }
  
  public static void a(BeaconLogger paramBeaconLogger)
  {
    b = paramBeaconLogger;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.d("beacon", c(paramString1 + " step: " + paramInt + ". " + paramString2, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.d("beacon", c(paramString1 + " step: " + paramInt + ". " + paramString2, paramVarArgs));
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.d("beacon", c(paramString1 + " " + paramString2, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.d("beacon", c(paramString1 + " " + paramString2, paramVarArgs));
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.d("beacon", c(paramString, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.d("beacon", c(paramString, paramVarArgs));
  }
  
  public static void a(Throwable paramThrowable)
  {
    BeaconLogger localBeaconLogger;
    if ((paramThrowable != null) && (c()))
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        paramThrowable.printStackTrace();
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.printStackTrace(paramThrowable);
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Log.i("beacon", "beacon logAble: " + paramBoolean);
      c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.e("beacon", c(paramString, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.e("beacon", c(paramString, paramVarArgs));
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String c(String paramString, Object... paramVarArgs)
  {
    String str = e();
    if (paramString == null) {
      return str + "msg is null";
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return str + paramString;
    }
    return str + String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private static boolean c()
  {
    return a();
  }
  
  private static StackTraceElement d()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = a(arrayOfStackTraceElement, c.class);
    int i = j;
    if (j == -1)
    {
      j = a(arrayOfStackTraceElement, Log.class);
      i = j;
      if (j == -1) {
        return null;
      }
    }
    return arrayOfStackTraceElement[i];
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.i("beacon", c(paramString, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.i("beacon", c(paramString, paramVarArgs));
  }
  
  private static String e()
  {
    if (b())
    {
      StackTraceElement localStackTraceElement = d();
      if (localStackTraceElement != null)
      {
        Object localObject2 = localStackTraceElement.getFileName();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str = localStackTraceElement.getMethodName();
        localObject2 = str;
        if (str.contains("$")) {
          localObject2 = str.substring(str.indexOf("$") + 1, str.lastIndexOf("$") - 2);
        }
        return "(" + (String)localObject1 + ":" + localStackTraceElement.getLineNumber() + ")" + (String)localObject2 + " ";
      }
    }
    return "";
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    BeaconLogger localBeaconLogger;
    if (c())
    {
      localBeaconLogger = b;
      if (localBeaconLogger == null) {
        Log.w("beacon", c(paramString, paramVarArgs));
      }
    }
    else
    {
      return;
    }
    localBeaconLogger.w("beacon", c(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.util.c
 * JD-Core Version:    0.7.0.1
 */