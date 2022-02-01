package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.common.e;
import java.util.Iterator;
import java.util.List;

public final class ax
  implements aw
{
  private static ax a = null;
  
  public static ax a()
  {
    try
    {
      if (a == null) {
        a = new ax();
      }
      ax localax = a;
      return localax;
    }
    finally {}
  }
  
  private static bh a(ao paramao)
  {
    bh localbh = new bh();
    localbh.a = paramao.b();
    localbh.b = paramao.c();
    localbh.c = paramao.d();
    localbh.d = paramao.a();
    localbh.e = paramao.e();
    localbh.h = paramao.g();
    if (localbh.h == 1) {
      localbh.g = bp.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localbh.i = paramao.h();
      Object localObject = paramao.f();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label290;
      }
      localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append("|");
      }
      localbh.f = bp.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localbh.j = localStringBuilder.toString();
    localbh.k = paramao.i();
    if (paramao.j()) {}
    for (int i = 1;; i = 0)
    {
      localbh.l = i;
      localbh.m = paramao.k();
      localbh.n = paramao.l();
      localbh.o = paramao.m();
      localbh.p = paramao.n();
      localbh.r = paramao.p();
      localbh.q = paramao.o();
      localbh.s = paramao.q();
      localbh.t = paramao.r();
      localbh.u = paramao.s();
      return localbh;
      label290:
      localbh.j = "";
      break;
    }
  }
  
  public final void a(ao paramao, ap paramap)
  {
    b.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
    paramao = a(paramao);
    if (paramao != null)
    {
      b.b("AccessSchedulerStatistics", "AccessSchedulerFinished：" + paramao.toString());
      new a(paramao).start();
    }
  }
  
  public final void b(ao paramao, ap paramap)
  {
    b.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onResSchedulerFinished, do sdk report...");
    paramao = a(paramao);
    if (paramao != null)
    {
      b.b("AccessSchedulerStatistics", "ResSchedulerFinished：" + paramao.toString());
      e.a("B_ACSDK_RES_Result", e.a(paramao));
    }
  }
  
  final class a
    extends Thread
  {
    private bh a;
    
    a(bh parambh)
    {
      this.a = parambh;
    }
    
    public final void run()
    {
      try
      {
        Thread.sleep(10000L);
        e.a("B_ACSDK_SDK_Result", e.a(this.a));
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ax
 * JD-Core Version:    0.7.0.1
 */