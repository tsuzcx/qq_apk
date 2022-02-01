package com.tencent.token;

import com.tencent.halley.scheduler.c.d;
import com.tencent.halley.scheduler.c.e;
import com.tencent.halley.scheduler.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class nf
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public long h;
  public boolean i = false;
  public ArrayList j;
  public int k;
  public int l;
  public int m;
  public String n;
  public String o;
  public np p;
  public boolean q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  
  public final ng a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (!og.f())
    {
      this.m = -4;
      this.n = "Network fail before schedule";
      return null;
    }
    Object localObject1 = new lr();
    Object localObject2;
    int i1;
    if (paramBoolean)
    {
      this.f = oh.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("resSize", Long.toString(this.h));
      ((Map)localObject2).put("imei", lx.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      if (this.i) {
        ((Map)localObject2).put("httpsKey", "enable");
      }
      localObject2 = new d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((lr)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((lr)localObject1).a("resDispatch");
      ((lr)localObject1).a("request", localObject2);
      i1 = this.w;
    }
    else
    {
      this.f = oh.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("taskVersionCode", nu.a().c.a);
      ((Map)localObject2).put("imei", lx.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      ((Map)localObject2).put("packageName", lx.e());
      localObject2 = new d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((lr)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((lr)localObject1).a("srvDispatch");
      ((lr)localObject1).a("request", localObject2);
      i1 = 22;
    }
    localObject1 = lu.a((lr)localObject1);
    ((nz)localObject1).a(i1);
    this.q = og.f();
    this.p = ((nz)localObject1).d();
    this.r = ((nz)localObject1).g();
    this.s = ((nz)localObject1).e();
    this.t = ((nz)localObject1).h();
    this.u = ((nz)localObject1).f();
    if ((((nz)localObject1).b() == 0) && (((nz)localObject1).a() != null))
    {
      localObject1 = ((nz)localObject1).a();
      localObject2 = new e();
      try
      {
        localObject1 = (e)((lr)localObject1).b("response", localObject2);
        if (localObject1 != null) {
          break label532;
        }
        this.m = -8;
        localObject1 = "Response is Null";
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject3;
          long l2;
          Object localObject4;
          Iterator localIterator;
          String str2;
          lo.a("ScheduleRequestImpl", "wup decode fail.", localException1);
          this.m = -8;
          this.o = localException1.getClass().getSimpleName();
          str1 = oh.a(localException1);
        }
      }
      this.n = ((String)localObject1);
      return null;
      label532:
      localObject2 = new ng();
      localObject3 = og.a();
      l2 = System.currentTimeMillis();
      if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
      {
        localObject3 = ((e)localObject1).a;
        if ((localObject3 != null) && (((Map)localObject3).size() > 0))
        {
          if (paramBoolean)
          {
            localObject3 = ((e)localObject1).a.keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              if (((e)localObject1).a.get(localObject4) != null) {
                ((ng)localObject2).d = ((f)((e)localObject1).a.get(localObject4)).a;
              }
            }
          }
          localObject4 = new nq(this.g);
          localIterator = ((Map)localObject3).keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject5 = (String)localIterator.next();
            if (((Map)localObject3).get(localObject5) != null)
            {
              Object localObject6 = ((f)((Map)localObject3).get(localObject5)).a;
              localObject5 = new nq.a((String)localObject5, l2, ((f)((e)localObject1).a.get(localObject5)).b);
              localObject6 = ((ArrayList)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                String str3 = (String)((Iterator)localObject6).next();
                np localnp = new np();
                if (localnp.a(str3)) {
                  ((nq.a)localObject5).c.add(localnp);
                } else {
                  lo.c("ScheduleRequestImpl", "parse ipPort fail. ipPort:".concat(String.valueOf(str3)));
                }
              }
              ((nq)localObject4).a((nq.a)localObject5);
            }
          }
          ((ng)localObject2).a = ((nq)localObject4);
        }
      }
      else
      {
        ((ng)localObject2).a = null;
        this.m = -9;
        localObject4 = new StringBuilder("req apn:");
        ((StringBuilder)localObject4).append(this.g);
        ((StringBuilder)localObject4).append(",current apn:");
        ((StringBuilder)localObject4).append((String)localObject3);
        this.n = ((StringBuilder)localObject4).toString();
      }
      try
      {
        localObject3 = (byte[])((e)localObject1).e.get("detectTask");
        if (localObject3 != null) {
          lw.a((byte[])localObject3);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      nu.a();
      str2 = (String)((e)localObject1).d.get("ipinfo");
      if ((str2 == null) || (!"".equals(str2))) {
        nv.a("ipInfo", str2);
      }
      if (((e)localObject1).c != null) {
        ((ng)localObject2).b = new nx(((e)localObject1).c);
      }
      if (((e)localObject1).b != null) {
        ((ng)localObject2).c = new nw(((e)localObject1).b);
      }
      this.v = ((int)(System.currentTimeMillis() - l1));
      return localObject2;
    }
    String str1;
    this.m = str1.b();
    this.o = str1.c();
    return null;
  }
  
  public final void a(Set paramSet)
  {
    this.j = new ArrayList();
    this.j.addAll(paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nf
 * JD-Core Version:    0.7.0.1
 */