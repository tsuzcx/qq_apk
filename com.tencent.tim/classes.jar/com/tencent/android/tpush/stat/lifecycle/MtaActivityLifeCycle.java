package com.tencent.android.tpush.stat.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;

public class MtaActivityLifeCycle
{
  private static int a = 0;
  private static long b = 0L;
  private static Activity c;
  
  public static long getAppOnForegroundTime()
  {
    return b;
  }
  
  public static Activity getCurrentTopActivity()
  {
    return c;
  }
  
  public static Boolean registerActivityLifecycleCallbacks(Application paramApplication, a parama)
  {
    if ((paramApplication == null) || (parama == null) || (Build.VERSION.SDK_INT < 14)) {
      return Boolean.valueOf(false);
    }
    try
    {
      paramApplication.registerActivityLifecycleCallbacks(new MtaActivityLifeCycle.1(parama));
      return Boolean.valueOf(true);
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.lifecycle.MtaActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */