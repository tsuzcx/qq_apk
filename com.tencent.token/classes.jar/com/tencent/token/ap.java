package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.common.g;
import com.tencent.halley.common.h;
import com.tencent.halley.scheduler.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ap
{
  private String a;
  private String b;
  private String c;
  private int d;
  private String e;
  private String f;
  private String g;
  private long h;
  private boolean i = false;
  private ArrayList j;
  private int k;
  private int l;
  private int m;
  private String n;
  private String o;
  private az p;
  private boolean q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  
  public aq a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (!bq.f())
    {
      this.m = -4;
      this.n = "Network fail before schedule";
      return null;
    }
    Object localObject1 = new com.tencent.halley.common.b.d();
    Object localObject2;
    int i1;
    if (paramBoolean)
    {
      this.f = br.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("resSize", Long.toString(this.h));
      ((Map)localObject2).put("imei", h.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      if (this.i) {
        ((Map)localObject2).put("httpsKey", "enable");
      }
      localObject2 = new com.tencent.halley.scheduler.c.d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((com.tencent.halley.common.b.d)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((com.tencent.halley.common.b.d)localObject1).a("resDispatch");
      ((com.tencent.halley.common.b.d)localObject1).a("request", localObject2);
      i1 = this.w;
    }
    else
    {
      this.f = br.b(this.j.toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("taskVersionCode", be.a().c.a);
      ((Map)localObject2).put("imei", h.c());
      ((Map)localObject2).put("reqKey", this.f);
      ((Map)localObject2).put("req_cip_info", "1");
      ((Map)localObject2).put("packageName", h.e());
      localObject2 = new com.tencent.halley.scheduler.c.d(this.a, this.b, this.j, this.e, this.c, this.d, this.k, this.l, this.g, (Map)localObject2);
      ((com.tencent.halley.common.b.d)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((com.tencent.halley.common.b.d)localObject1).a("srvDispatch");
      ((com.tencent.halley.common.b.d)localObject1).a("request", localObject2);
      i1 = 22;
    }
    localObject1 = com.tencent.halley.common.e.a((com.tencent.halley.common.b.d)localObject1);
    ((bj)localObject1).a(i1);
    this.q = bq.f();
    this.p = ((bj)localObject1).d();
    this.r = ((bj)localObject1).g();
    this.s = ((bj)localObject1).e();
    this.t = ((bj)localObject1).h();
    this.u = ((bj)localObject1).f();
    if ((((bj)localObject1).b() == 0) && (((bj)localObject1).a() != null))
    {
      localObject1 = ((bj)localObject1).a();
      localObject2 = new com.tencent.halley.scheduler.c.e();
      try
      {
        localObject1 = (com.tencent.halley.scheduler.c.e)((com.tencent.halley.common.b.d)localObject1).b("response", localObject2);
        if (localObject1 == null)
        {
          this.m = -8;
          this.n = "Response is Null";
          return null;
        }
        localObject2 = new aq();
        Object localObject3 = bq.a();
        long l2 = System.currentTimeMillis();
        if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
        {
          localObject3 = ((com.tencent.halley.scheduler.c.e)localObject1).a;
          if ((localObject3 != null) && (((Map)localObject3).size() > 0))
          {
            if (paramBoolean)
            {
              localObject3 = ((com.tencent.halley.scheduler.c.e)localObject1).a.keySet().iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                if (((com.tencent.halley.scheduler.c.e)localObject1).a.get(localObject4) != null) {
                  ((aq)localObject2).a(((f)((com.tencent.halley.scheduler.c.e)localObject1).a.get(localObject4)).a);
                }
              }
            }
            localObject4 = new ba(this.g);
            Iterator localIterator = ((Map)localObject3).keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject5 = (String)localIterator.next();
              if (((Map)localObject3).get(localObject5) != null)
              {
                Object localObject6 = ((f)((Map)localObject3).get(localObject5)).a;
                localObject5 = new ba.a((String)localObject5, l2, ((f)((com.tencent.halley.scheduler.c.e)localObject1).a.get(localObject5)).b);
                localObject6 = ((ArrayList)localObject6).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  String str2 = (String)((Iterator)localObject6).next();
                  Object localObject7 = new az();
                  if (((az)localObject7).a(str2))
                  {
                    ((ba.a)localObject5).a((az)localObject7);
                  }
                  else
                  {
                    localObject7 = new StringBuilder("parse ipPort fail. ipPort:");
                    ((StringBuilder)localObject7).append(str2);
                    b.c("ScheduleRequestImpl", ((StringBuilder)localObject7).toString());
                  }
                }
                ((ba)localObject4).a((ba.a)localObject5);
              }
            }
            ((aq)localObject2).a((ba)localObject4);
          }
        }
        else
        {
          ((aq)localObject2).a(null);
          this.m = -9;
          localObject4 = new StringBuilder("req apn:");
          ((StringBuilder)localObject4).append(this.g);
          ((StringBuilder)localObject4).append(",current apn:");
          ((StringBuilder)localObject4).append((String)localObject3);
          this.n = ((StringBuilder)localObject4).toString();
        }
        try
        {
          localObject3 = (byte[])((com.tencent.halley.scheduler.c.e)localObject1).e.get("detectTask");
          if (localObject3 != null) {
            g.a((byte[])localObject3);
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        Object localObject4 = be.a();
        String str1 = (String)((com.tencent.halley.scheduler.c.e)localObject1).d.get("ipinfo");
        if ((str1 == null) || (!"".equals(str1)))
        {
          localObject4 = ((be)localObject4).c;
          bf.a("ipInfo", str1);
        }
        if (((com.tencent.halley.scheduler.c.e)localObject1).c != null) {
          ((aq)localObject2).a(new bh(((com.tencent.halley.scheduler.c.e)localObject1).c));
        }
        if (((com.tencent.halley.scheduler.c.e)localObject1).b != null) {
          ((aq)localObject2).a(new bg(((com.tencent.halley.scheduler.c.e)localObject1).b));
        }
        this.v = ((int)(System.currentTimeMillis() - l1));
        return localObject2;
      }
      catch (Exception localException1)
      {
        b.a("ScheduleRequestImpl", "wup decode fail.", localException1);
        this.m = -8;
        this.o = localException1.getClass().getSimpleName();
        this.n = br.a(localException1);
        return null;
      }
    }
    this.m = localException1.b();
    this.o = localException1.c();
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(Set paramSet)
  {
    this.j = new ArrayList();
    this.j.addAll(paramSet);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public ArrayList f()
  {
    return this.j;
  }
  
  public int g()
  {
    return this.k;
  }
  
  public int h()
  {
    return this.l;
  }
  
  public az i()
  {
    return this.p;
  }
  
  public boolean j()
  {
    return this.q;
  }
  
  public int k()
  {
    return this.m;
  }
  
  public String l()
  {
    return this.n;
  }
  
  public String m()
  {
    return this.o;
  }
  
  public int n()
  {
    return this.r;
  }
  
  public int o()
  {
    return this.s;
  }
  
  public int p()
  {
    return this.t;
  }
  
  public int q()
  {
    return this.u;
  }
  
  public int r()
  {
    return this.v;
  }
  
  public String s()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ap
 * JD-Core Version:    0.7.0.1
 */