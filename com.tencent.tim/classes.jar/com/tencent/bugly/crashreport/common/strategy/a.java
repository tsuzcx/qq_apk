package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static int a = 1000;
  public static long b;
  private static a c = null;
  private static String i = null;
  private final List<com.tencent.bugly.a> d;
  private final w e;
  private final StrategyBean f;
  private StrategyBean g = null;
  private Context h;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    this.h = paramContext;
    if (com.tencent.bugly.crashreport.common.info.a.a(paramContext) != null)
    {
      paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext).z;
      if (!"oversea".equals(paramContext)) {
        break label72;
      }
      StrategyBean.a = "https://astat.bugly.qcloud.com/rqd/async";
      StrategyBean.b = "https://astat.bugly.qcloud.com/rqd/async";
    }
    for (;;)
    {
      this.f = new StrategyBean();
      this.d = paramList;
      this.e = w.a();
      return;
      label72:
      if ("na_https".equals(paramContext))
      {
        StrategyBean.a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
        StrategyBean.b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
      }
    }
  }
  
  public static a a()
  {
    try
    {
      a locala = c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (c == null) {
        c = new a(paramContext, paramList);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((z.a(paramString)) || (!z.c(paramString)))
    {
      x.d("URL user set is invalid.", new Object[0]);
      return;
    }
    i = paramString;
  }
  
  public static StrategyBean d()
  {
    Object localObject = p.a().a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (r)((List)localObject).get(0);
      if (((r)localObject).g != null) {
        return (StrategyBean)z.a(((r)localObject).g, StrategyBean.CREATOR);
      }
    }
    return null;
  }
  
  public final void a(long paramLong)
  {
    this.e.a(new a.1(this), paramLong);
  }
  
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    x.c("[Strategy] Notify %s", new Object[] { b.class.getName() });
    b.a(paramStrategyBean, paramBoolean);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.bugly.a locala = (com.tencent.bugly.a)localIterator.next();
      try
      {
        x.c("[Strategy] Notify %s", new Object[] { locala.getClass().getName() });
        locala.onServerStrategyChanged(paramStrategyBean);
      }
      catch (Throwable localThrowable) {}
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public final void a(ap paramap)
  {
    if (paramap == null) {}
    while ((this.g != null) && (paramap.h == this.g.n)) {
      return;
    }
    localStrategyBean = new StrategyBean();
    localStrategyBean.e = paramap.a;
    localStrategyBean.g = paramap.c;
    localStrategyBean.f = paramap.b;
    if ((z.a(i)) || (!z.c(i)))
    {
      if (z.c(paramap.d))
      {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramap.d });
        localStrategyBean.p = paramap.d;
      }
      if (z.c(paramap.e))
      {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramap.e });
        localStrategyBean.q = paramap.e;
      }
    }
    if ((paramap.f != null) && (!z.a(paramap.f.a))) {
      localStrategyBean.r = paramap.f.a;
    }
    if (paramap.h != 0L) {
      localStrategyBean.n = paramap.h;
    }
    String str;
    if ((paramap.g != null) && (paramap.g.size() > 0))
    {
      localStrategyBean.s = paramap.g;
      str = (String)paramap.g.get("B11");
      if ((str == null) || (!str.equals("1"))) {
        break label634;
      }
    }
    label634:
    for (localStrategyBean.h = true;; localStrategyBean.h = false)
    {
      str = (String)paramap.g.get("B3");
      if (str != null) {
        localStrategyBean.v = Long.valueOf(str).longValue();
      }
      localStrategyBean.o = paramap.i;
      localStrategyBean.u = paramap.i;
      str = (String)paramap.g.get("B27");
      if ((str != null) && (str.length() > 0)) {}
      try
      {
        int j = Integer.parseInt(str);
        if (j > 0) {
          localStrategyBean.t = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (!x.a(localException))
          {
            localException.printStackTrace();
            continue;
            localStrategyBean.j = false;
          }
        }
      }
      str = (String)paramap.g.get("B25");
      if ((str == null) || (!str.equals("1"))) {
        break;
      }
      localStrategyBean.j = true;
      x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.e), Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.f), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.l), Boolean.valueOf(localStrategyBean.m), Long.valueOf(localStrategyBean.o), Boolean.valueOf(localStrategyBean.j), Long.valueOf(localStrategyBean.n) });
      this.g = localStrategyBean;
      if (!z.c(paramap.d))
      {
        x.c("[Strategy] download url is null", new Object[0]);
        this.g.p = "";
      }
      if (!z.c(paramap.e))
      {
        x.c("[Strategy] download crashurl is null", new Object[0]);
        this.g.q = "";
      }
      p.a().b(2);
      paramap = new r();
      paramap.b = 2;
      paramap.a = localStrategyBean.c;
      paramap.e = localStrategyBean.d;
      paramap.g = z.a(localStrategyBean);
      p.a().a(paramap);
      a(localStrategyBean, true);
      return;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/bugly/crashreport/common/strategy/a:g	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localStrategyBean	StrategyBean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    if (this.g != null)
    {
      if (!z.c(this.g.p)) {
        this.g.p = StrategyBean.a;
      }
      if (!z.c(this.g.q)) {
        this.g.q = StrategyBean.b;
      }
      return this.g;
    }
    if ((!z.a(i)) && (z.c(i)))
    {
      this.f.p = i;
      this.f.q = i;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a
 * JD-Core Version:    0.7.0.1
 */