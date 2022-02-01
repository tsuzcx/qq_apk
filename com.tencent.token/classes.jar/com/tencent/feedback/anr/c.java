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
  private static c b;
  private Context a;
  
  private c(Context paramContext)
  {
    super("/data/anr/", 8);
    com.tencent.feedback.common.c.a(paramContext).E();
    Process.myPid();
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
    this.a = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        if (b == null)
        {
          if (paramContext != null)
          {
            localContext = paramContext.getApplicationContext();
            if (localContext != null) {
              break label54;
            }
          }
          b = new c(paramContext);
        }
        else
        {
          paramContext = b;
          return paramContext;
        }
      }
      finally {}
      label54:
      paramContext = localContext;
    }
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    e.c("received event %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    Object localObject = new StringBuilder("/data/anr/");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    if (!paramString.contains("trace"))
    {
      e.c("not anr file %s", new Object[] { paramString });
      return;
    }
    localObject = CrashReport.getCrashRuntimeStrategy();
    if (localObject == null)
    {
      e.d("magic! no crash stategy,no anr return ?", new Object[0]);
      return;
    }
    if (!((CrashStrategyBean)localObject).isOpenANR())
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