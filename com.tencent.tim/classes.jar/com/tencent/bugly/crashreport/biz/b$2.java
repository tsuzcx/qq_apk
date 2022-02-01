package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.List;

final class b$2
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle = "unknown";
    if (paramActivity != null) {
      paramBundle = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(paramBundle))) {}
    do
    {
      return;
      x.c(">>> %s onCreated <<<", new Object[] { paramBundle });
      paramActivity = com.tencent.bugly.crashreport.common.info.a.b();
    } while (paramActivity == null);
    paramActivity.C.add(b.a(paramBundle, "onCreated"));
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(str))) {}
    do
    {
      return;
      x.c(">>> %s onDestroyed <<<", new Object[] { str });
      paramActivity = com.tencent.bugly.crashreport.common.info.a.b();
    } while (paramActivity == null);
    paramActivity.C.add(b.a(str, "onDestroyed"));
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(str))) {}
    com.tencent.bugly.crashreport.common.info.a locala;
    do
    {
      return;
      x.c(">>> %s onPaused <<<", new Object[] { str });
      locala = com.tencent.bugly.crashreport.common.info.a.b();
    } while (locala == null);
    locala.C.add(b.a(str, "onPaused"));
    locala.t = System.currentTimeMillis();
    locala.u = (locala.t - locala.s);
    b.b(locala.t);
    if (locala.u < 0L) {
      locala.u = 0L;
    }
    if (paramActivity != null)
    {
      locala.r = "background";
      return;
    }
    locala.r = "unknown";
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(str))) {}
    label204:
    do
    {
      do
      {
        for (;;)
        {
          return;
          x.c(">>> %s onResumed <<<", new Object[] { str });
          paramActivity = com.tencent.bugly.crashreport.common.info.a.b();
          if (paramActivity != null)
          {
            paramActivity.C.add(b.a(str, "onResumed"));
            paramActivity.r = str;
            paramActivity.s = System.currentTimeMillis();
            paramActivity.v = (paramActivity.s - b.c());
            long l2 = paramActivity.s - b.d();
            if (b.e() > 0L) {}
            for (l1 = b.e(); l2 > l1; l1 = b.f())
            {
              paramActivity.c();
              b.g();
              x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
              if (b.h() % b.i() != 0) {
                break label204;
              }
              b.b.a(4, b.j(), 0L);
              return;
            }
          }
        }
        b.b.a(4, false, 0L);
        l1 = System.currentTimeMillis();
      } while (l1 - b.k() <= b.l());
      b.a(l1);
      x.a("add a timer to upload hot start user info", new Object[0]);
    } while (!b.j());
    paramActivity = b.b;
    long l1 = b.l();
    w.a().a(new a.a(paramActivity, null, true), l1);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    x.c(">>> %s onStart <<<", new Object[] { str });
    com.tencent.bugly.crashreport.common.info.a.b().a(true);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    x.c(">>> %s onStop <<<", new Object[] { str });
    com.tencent.bugly.crashreport.common.info.a.b().a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.b.2
 * JD-Core Version:    0.7.0.1
 */