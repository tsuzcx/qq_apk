package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
{
  public static int a = 0;
  public static boolean b = false;
  public static int c = 2;
  public static boolean d = true;
  public static int e = 20480;
  public static int f = 20480;
  public static long g = 604800000L;
  public static String h = null;
  public static boolean i = false;
  public static String j = null;
  public static int k = 5000;
  public static boolean l = true;
  public static boolean m = false;
  public static String n = null;
  public static String o = null;
  private static c r;
  public final b p;
  private final Context q;
  private final d s;
  private final NativeCrashHandler t;
  private com.tencent.bugly.crashreport.common.strategy.a u;
  private w v;
  private final com.tencent.bugly.crashreport.crash.anr.b w;
  
  private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, com.tencent.bugly.proguard.a parama, e parame, String paramString)
  {
    a = paramInt;
    paramContext = z.a(paramContext);
    this.q = paramContext;
    this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.v = paramw;
    this.p = new b(paramInt, paramContext, u.a(), p.a(), this.u, parama, parame);
    parama = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.s = new d(paramContext, this.p, this.u, parama);
    this.t = NativeCrashHandler.getInstance(paramContext, parama, this.p, this.u, paramw, paramBoolean, paramString);
    parama.E = this.t;
    this.w = new com.tencent.bugly.crashreport.crash.anr.b(paramContext, this.u, parama, paramw, this.p);
  }
  
  public static c a()
  {
    try
    {
      c localc = r;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, com.tencent.bugly.proguard.a parama, e parame, String paramString)
  {
    try
    {
      if (r == null) {
        r = new c(1003, paramContext, w.a(), paramBoolean, null, parame, null);
      }
      paramContext = r;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    w.a().a(new Thread()
    {
      public final void run()
      {
        if (!z.a(c.b(c.this), "local_crash_lock", 10000L)) {
          return;
        }
        List localList = c.this.p.a();
        if ((localList != null) && (localList.size() > 0))
        {
          int j = localList.size();
          if (j > 100L)
          {
            ArrayList localArrayList = new ArrayList();
            Collections.sort(localList);
            int i = 0;
            for (;;)
            {
              localObject = localArrayList;
              if (i >= 100L) {
                break;
              }
              localArrayList.add(localList.get(j - 1 - i));
              i += 1;
            }
          }
          Object localObject = localList;
          c.this.p.a((List)localObject, 0L, false, false, false);
        }
        z.b(c.b(c.this), "local_crash_lock");
      }
    }, paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    this.s.a(paramStrategyBean);
    this.t.onStrategyChanged(paramStrategyBean);
    this.w.a(paramStrategyBean);
    w.a().a(new Thread()
    {
      public final void run()
      {
        if (!z.a(c.b(c.this), "local_crash_lock", 10000L)) {
          return;
        }
        List localList = c.this.p.a();
        if ((localList != null) && (localList.size() > 0))
        {
          int j = localList.size();
          if (j > 100L)
          {
            ArrayList localArrayList = new ArrayList();
            Collections.sort(localList);
            int i = 0;
            for (;;)
            {
              localObject = localArrayList;
              if (i >= 100L) {
                break;
              }
              localArrayList.add(localList.get(j - 1 - i));
              i += 1;
            }
          }
          Object localObject = localList;
          c.this.p.a((List)localObject, 0L, false, false, false);
        }
        z.b(c.b(c.this), "local_crash_lock");
      }
    }, 3000L);
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean)
  {
    this.p.d(paramCrashDetailBean);
  }
  
  public final void a(e parame)
  {
    try
    {
      if (this.p != null) {
        this.p.a = parame;
      }
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void a(final Thread paramThread, final Throwable paramThrowable, boolean paramBoolean1, final String paramString, final byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    this.v.a(new Runnable()
    {
      public final void run()
      {
        try
        {
          x.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
          c.a(c.this).a(paramThread, paramThrowable, false, paramString, paramArrayOfByte);
          if (this.f)
          {
            x.a("clear user datas", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a.a(c.b(c.this)).B();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          if (x.b(localThrowable) != true) {
            localThrowable.printStackTrace();
          }
          x.e("java catch error: %s", new Object[] { paramThrowable.toString() });
        }
      }
    });
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      this.t.testNativeCrash(paramBoolean1, paramBoolean2, paramBoolean3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    this.s.b();
  }
  
  public final void c()
  {
    this.s.a();
  }
  
  public final void d()
  {
    this.t.setUserOpened(false);
  }
  
  public final void e()
  {
    this.t.setUserOpened(true);
  }
  
  public final void f()
  {
    this.w.a(true);
  }
  
  public final void g()
  {
    this.w.a(false);
  }
  
  public final boolean h()
  {
    return this.w.a();
  }
  
  public final byte[] i()
  {
    List localList = this.p.a();
    return this.p.a(localList, true);
  }
  
  public final int j()
  {
    List localList = this.p.a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final NativeExceptionHandler k()
  {
    return this.t.getNativeExceptionHandler();
  }
  
  public final void l()
  {
    this.t.checkUploadRecordCrash();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c
 * JD-Core Version:    0.7.0.1
 */