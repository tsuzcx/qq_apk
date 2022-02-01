package com.tencent.feedback.anr;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;

public class ANRReport
{
  public static void startANRMonitor(Context paramContext)
  {
    try
    {
      paramContext = c.a();
      if (paramContext != null) {
        paramContext.f();
      }
      return;
    }
    catch (Exception paramContext)
    {
      x.b(paramContext);
    }
  }
  
  public static void stopANRMonitor()
  {
    try
    {
      c localc = c.a();
      if (localc != null) {
        localc.g();
      }
      return;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.ANRReport
 * JD-Core Version:    0.7.0.1
 */