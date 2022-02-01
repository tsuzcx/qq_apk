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

public final class my
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
  public ni p;
  public boolean q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  
  public final mz a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (!nz.f())
    {
      this.m = -4;
      this.n = "Network fail before schedule";
      return null;
    }
    Object localObject1 = new lk();
    Object localObject2;
    int i1;
    if (paramBoolean)
    {
      this.f = oa.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("resSize", Long.toString(this.h));
      ((Map)localObject2).put("imei", lq.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      if (this.i) {
        ((Map)localObject2).put("httpsKey", "enable");
      }
      localObject2 = new d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((lk)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((lk)localObject1).a("resDispatch");
      ((lk)localObject1).a("request", localObject2);
      i1 = this.w;
    }
    else
    {
      this.f = oa.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("taskVersionCode", nn.a().c.a);
      ((Map)localObject2).put("imei", lq.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      ((Map)localObject2).put("packageName", lq.e());
      localObject2 = new d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((lk)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((lk)localObject1).a("srvDispatch");
      ((lk)localObject1).a("request", localObject2);
      i1 = 22;
    }
    localObject1 = ln.a((lk)localObject1);
    ((ns)localObject1).a(i1);
    this.q = nz.f();
    this.p = ((ns)localObject1).d();
    this.r = ((ns)localObject1).g();
    this.s = ((ns)localObject1).e();
    this.t = ((ns)localObject1).h();
    this.u = ((ns)localObject1).f();
    if ((((ns)localObject1).b() == 0) && (((ns)localObject1).a() != null))
    {
      localObject1 = ((ns)localObject1).a();
      localObject2 = new e();
      try
      {
        localObject1 = (e)((lk)localObject1).b("response", localObject2);
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
          lh.a("ScheduleRequestImpl", "wup decode fail.", localException1);
          this.m = -8;
          this.o = localException1.getClass().getSimpleName();
          str1 = oa.a(localException1);
        }
      }
      this.n = ((String)localObject1);
      return null;
      label532:
      localObject2 = new mz();
      localObject3 = nz.a();
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
                ((mz)localObject2).d = ((f)((e)localObject1).a.get(localObject4)).a;
              }
            }
          }
          localObject4 = new nj(this.g);
          localIterator = ((Map)localObject3).keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject5 = (String)localIterator.next();
            if (((Map)localObject3).get(localObject5) != null)
            {
              Object localObject6 = ((f)((Map)localObject3).get(localObject5)).a;
              localObject5 = new nj.a((String)localObject5, l2, ((f)((e)localObject1).a.get(localObject5)).b);
              localObject6 = ((ArrayList)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                String str3 = (String)((Iterator)localObject6).next();
                ni localni = new ni();
                if (localni.a(str3)) {
                  ((nj.a)localObject5).c.add(localni);
                } else {
                  lh.c("ScheduleRequestImpl", "parse ipPort fail. ipPort:".concat(String.valueOf(str3)));
                }
              }
              ((nj)localObject4).a((nj.a)localObject5);
            }
          }
          ((mz)localObject2).a = ((nj)localObject4);
        }
      }
      else
      {
        ((mz)localObject2).a = null;
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
          lp.a((byte[])localObject3);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      nn.a();
      str2 = (String)((e)localObject1).d.get("ipinfo");
      if ((str2 == null) || (!"".equals(str2))) {
        no.a("ipInfo", str2);
      }
      if (((e)localObject1).c != null) {
        ((mz)localObject2).b = new nq(((e)localObject1).c);
      }
      if (((e)localObject1).b != null) {
        ((mz)localObject2).c = new np(((e)localObject1).b);
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
 * Qualified Name:     com.tencent.token.my
 * JD-Core Version:    0.7.0.1
 */