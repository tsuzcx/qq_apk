package com.tencent.token;

import com.tencent.halley.common.c;
import com.tencent.halley.common.g;
import java.util.Iterator;
import java.util.List;

public final class be
  implements bd
{
  private static be a = null;
  
  public static be a()
  {
    try
    {
      if (a == null) {
        a = new be();
      }
      be localbe = a;
      return localbe;
    }
    finally {}
  }
  
  private static bq a(at paramat)
  {
    bq localbq = new bq();
    localbq.a = paramat.b();
    localbq.b = paramat.c();
    localbq.c = paramat.d();
    localbq.d = paramat.a();
    localbq.e = paramat.e();
    localbq.h = paramat.g();
    if (localbq.h == 1) {
      localbq.g = cb.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localbq.i = paramat.h();
      Object localObject = paramat.f();
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
      localbq.f = cb.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localbq.j = localStringBuilder.toString();
    localbq.k = paramat.i();
    if (paramat.j()) {}
    for (int i = 1;; i = 0)
    {
      localbq.l = i;
      localbq.m = paramat.k();
      localbq.n = paramat.l();
      localbq.o = paramat.m();
      localbq.p = paramat.n();
      localbq.r = paramat.p();
      localbq.q = paramat.o();
      localbq.s = paramat.q();
      localbq.t = paramat.r();
      localbq.u = paramat.s();
      return localbq;
      label290:
      localbq.j = "";
      break;
    }
  }
  
  public final void a(at paramat, au paramau)
  {
    c.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
    paramat = a(paramat);
    if (paramat != null)
    {
      c.b("AccessSchedulerStatistics", "AccessSchedulerFinished：" + paramat.toString());
      new bf(this, paramat).start();
    }
  }
  
  public final void b(at paramat, au paramau)
  {
    c.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onResSchedulerFinished, do sdk report...");
    paramat = a(paramat);
    if (paramat != null)
    {
      c.b("AccessSchedulerStatistics", "ResSchedulerFinished：" + paramat.toString());
      g.a("B_ACSDK_RES_Result", g.a(paramat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.be
 * JD-Core Version:    0.7.0.1
 */