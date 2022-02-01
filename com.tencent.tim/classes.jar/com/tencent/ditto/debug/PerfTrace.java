package com.tencent.ditto.debug;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerfTrace
{
  public static boolean Debug;
  private static Method methodTraceBegin;
  private static Method methodTraceEnd;
  public static boolean supportSysTrace;
  
  static
  {
    boolean bool = true;
    Debug = false;
    supportSysTrace = false;
    methodTraceBegin = null;
    methodTraceEnd = null;
    if (Build.VERSION.SDK_INT >= 18) {}
    for (;;)
    {
      supportSysTrace = bool;
      try
      {
        Class localClass = Class.forName("android.os.Trace");
        methodTraceBegin = localClass.getDeclaredMethod("traceBegin", new Class[] { Long.TYPE, String.class });
        methodTraceEnd = localClass.getDeclaredMethod("traceEnd", new Class[] { Long.TYPE });
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
      bool = false;
    }
  }
  
  public static void sysTraceBegin(String paramString)
  {
    if (!Debug) {}
    while (methodTraceBegin == null) {
      return;
    }
    try
    {
      methodTraceBegin.invoke(null, new Object[] { Long.valueOf(8L), paramString });
      return;
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void sysTraceEnd()
  {
    if (!Debug) {}
    while (methodTraceEnd == null) {
      return;
    }
    try
    {
      methodTraceEnd.invoke(null, new Object[] { Integer.valueOf(1) });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.debug.PerfTrace
 * JD-Core Version:    0.7.0.1
 */