package com.tencent.feedback.anr;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.eup.d;

public class ANRReport
{
  public static void startANRMonitor(Context paramContext)
  {
    b.a(paramContext).startWatching();
  }
  
  public static void stopANRMonitor()
  {
    if (b.a(null) != null) {
      b.a(null).stopWatching();
    }
  }
  
  public static boolean uploadANRInfo(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    c localc = c.p();
    if (localc == null)
    {
      e.d("commonInfo is null not init ?", new Object[0]);
      return false;
    }
    CrashStrategyBean localCrashStrategyBean = CrashReport.getCrashRuntimeStrategy();
    if (localCrashStrategyBean == null)
    {
      e.d("crash strategy null,not init?", new Object[0]);
      return false;
    }
    paramString1 = com.tencent.feedback.eup.b.a(paramContext, localc.g(), localc.i(), localc.n(), paramString1, "main", "", "ANR_RQD_EXCEPTION", "", paramString2, paramLong, paramString3, null);
    paramString1.e(true);
    boolean bool = com.tencent.feedback.eup.b.a(paramContext).a(paramString1, localCrashStrategyBean);
    e.b("sha1:%s %d", new Object[] { paramString1.t(), Integer.valueOf(paramString1.r()) });
    e.b("handle anr %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void uploadANRInfoAsync(Context paramContext, final int paramInt, final String paramString1, final String paramString2, final String paramString3, final long paramLong)
  {
    if ((paramInt <= 0) || (paramString1 == null) || (paramLong <= 0L))
    {
      e.d("anr args unright pid, procName ,anrTime should not be null", new Object[0]);
      return;
    }
    com.tencent.feedback.common.b.b().a(new Runnable()
    {
      public final void run()
      {
        ANRReport.uploadANRInfo(this.a, paramInt, paramString1, paramString2, paramString3, paramLong);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.ANRReport
 * JD-Core Version:    0.7.0.1
 */