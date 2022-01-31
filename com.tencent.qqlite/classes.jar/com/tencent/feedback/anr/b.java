package com.tencent.feedback.anr;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.feedback.common.a;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.service.RQDService;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import java.util.Date;
import java.util.Map;

public class b
  extends FileObserver
{
  private static b c = null;
  private long a = -1L;
  private Context b;
  
  private b(Context paramContext)
  {
    super("/data/anr/", 8);
    a.h(paramContext);
    Process.myPid();
    this.b = paramContext.getApplicationContext();
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new b(paramContext.getApplicationContext());
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private boolean a()
  {
    boolean bool = false;
    long l2;
    try
    {
      e.b("onTraceFileCloseWrite", new Object[0]);
      l2 = new Date().getTime();
      if (l2 < this.a + 5000L) {
        e.b("already done", new Object[0]);
      }
      for (;;)
      {
        return bool;
        CrashStrategyBean localCrashStrategyBean = CrashReport.getCrashRuntimeStrategy();
        if (localCrashStrategyBean != null) {
          break;
        }
        e.c("not strategy ? init eup ?", new Object[0]);
      }
      bool = localObject1.isMerged();
    }
    finally {}
    Object localObject2 = c.p();
    String str;
    label104:
    long l1;
    if (localObject2 != null)
    {
      str = ((c)localObject2).g();
      if (localObject2 == null) {
        break label208;
      }
      l1 = ((c)localObject2).i();
      label115:
      if (localObject2 == null) {
        break label213;
      }
    }
    label208:
    label213:
    for (localObject2 = ((c)localObject2).n();; localObject2 = null)
    {
      this.a = l2;
      Intent localIntent = new Intent(this.b, RQDService.class);
      localIntent.setAction("com.tencent.feedback.10");
      localIntent.putExtra("com.tencent.feedback.104", new ANRHandleServiceTask(bool, str, l1, (Map)localObject2));
      this.b.startService(localIntent);
      e.b("start service", new Object[0]);
      bool = true;
      break;
      str = "10000";
      break label104;
      l1 = 0L;
      break label115;
    }
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    e.c("received event %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!"/data/anr/traces.txt".equals("/data/anr/" + paramString))
    {
      e.c("not anr file %s", new Object[] { paramString });
      return;
    }
    a();
  }
  
  public void stopWatching()
  {
    try
    {
      c = null;
      super.stopWatching();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.b
 * JD-Core Version:    0.7.0.1
 */