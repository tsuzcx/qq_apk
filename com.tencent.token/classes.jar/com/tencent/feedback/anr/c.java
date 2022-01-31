package com.tencent.feedback.anr;

import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.feedback.common.e;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;

public class c
  extends FileObserver
{
  private static c b = null;
  private Context a;
  
  private c(Context paramContext)
  {
    super("/data/anr/", 8);
    com.tencent.feedback.common.c.a(paramContext).E();
    Process.myPid();
    if (paramContext == null) {}
    for (;;)
    {
      this.a = paramContext;
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  /* Error */
  public static c a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/tencent/feedback/anr/c:b	Lcom/tencent/feedback/anr/c;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: ifnonnull +23 -> 33
    //   13: new 2	com/tencent/feedback/anr/c
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 46	com/tencent/feedback/anr/c:<init>	(Landroid/content/Context;)V
    //   21: putstatic 12	com/tencent/feedback/anr/c:b	Lcom/tencent/feedback/anr/c;
    //   24: getstatic 12	com/tencent/feedback/anr/c:b	Lcom/tencent/feedback/anr/c;
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 43	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull -26 -> 13
    //   42: aload_1
    //   43: astore_0
    //   44: goto -31 -> 13
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramContext	Context
    //   37	6	1	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	9	47	finally
    //   13	24	47	finally
    //   24	28	47	finally
    //   33	38	47	finally
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    e.c("received event %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = "/data/anr/" + paramString;
    if (!paramString.contains("trace"))
    {
      e.c("not anr file %s", new Object[] { paramString });
      return;
    }
    CrashStrategyBean localCrashStrategyBean = CrashReport.getCrashRuntimeStrategy();
    if (localCrashStrategyBean == null)
    {
      e.d("magic! no crash stategy,no anr return ?", new Object[0]);
      return;
    }
    if (!localCrashStrategyBean.isOpenANR())
    {
      e.a("close anr!", new Object[0]);
      return;
    }
    b.a(this.a).a(paramString);
  }
  
  public void startWatching()
  {
    super.startWatching();
    e.a("start watching", new Object[0]);
  }
  
  public void stopWatching()
  {
    try
    {
      b = null;
      super.stopWatching();
      e.a("stop watching", new Object[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.c
 * JD-Core Version:    0.7.0.1
 */