package com.tencent.feedback.anr;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.c;

public class ANRReport
{
  public static void startANRMonitor(Context paramContext)
  {
    paramContext = c.a();
    if (paramContext != null) {
      paramContext.f();
    }
  }
  
  public static void stopANRMonitor()
  {
    c localc = c.a();
    if (localc != null) {
      localc.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.ANRReport
 * JD-Core Version:    0.7.0.1
 */