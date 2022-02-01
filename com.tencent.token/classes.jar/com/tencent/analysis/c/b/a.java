package com.tencent.analysis.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.analysis.a.i;
import com.tencent.analysis.a.j;
import com.tencent.analysis.d.a.c;
import com.tencent.analysis.d.a.d;
import java.util.Map;

public final class a
  extends com.tencent.analysis.c.a.b
{
  private i a = new i();
  private j b = new j();
  
  private String d()
  {
    Object localObject1 = new com.tencent.analysis.e.a();
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      boolean bool;
      if ((((com.tencent.analysis.e.a)localObject1).a != null) && (!((com.tencent.analysis.e.a)localObject1).a.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.a, ((com.tencent.analysis.e.a)localObject1).a);
        new StringBuilder("sdkRequst_qimei:").append(((com.tencent.analysis.e.a)localObject1).a);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).b != null) && (!((com.tencent.analysis.e.a)localObject1).b.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.b, ((com.tencent.analysis.e.a)localObject1).b);
        new StringBuilder("sdkRequst_imei:").append(((com.tencent.analysis.e.a)localObject1).b);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).c != null) && (!((com.tencent.analysis.e.a)localObject1).c.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.c, ((com.tencent.analysis.e.a)localObject1).c);
        new StringBuilder("sdkRequst_mac:").append(((com.tencent.analysis.e.a)localObject1).c);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).d != null) && (!((com.tencent.analysis.e.a)localObject1).d.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.d, ((com.tencent.analysis.e.a)localObject1).d);
        new StringBuilder("sdkRequst_imsi:").append(((com.tencent.analysis.e.a)localObject1).d);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).e != null) && (!((com.tencent.analysis.e.a)localObject1).e.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.e, ((com.tencent.analysis.e.a)localObject1).e);
        new StringBuilder("sdkRequst_androidId:").append(((com.tencent.analysis.e.a)localObject1).e);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).f != null) && (!((com.tencent.analysis.e.a)localObject1).f.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.f, ((com.tencent.analysis.e.a)localObject1).f);
        new StringBuilder("sdkRequst_model:").append(((com.tencent.analysis.e.a)localObject1).f);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).g != null) && (!((com.tencent.analysis.e.a)localObject1).g.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.g, ((com.tencent.analysis.e.a)localObject1).g);
        new StringBuilder("sdkRequst_phonePlatform:").append(((com.tencent.analysis.e.a)localObject1).g);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).h != null) && (!((com.tencent.analysis.e.a)localObject1).h.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.h, ((com.tencent.analysis.e.a)localObject1).h);
        new StringBuilder("sdkRequst_osVersion:").append(((com.tencent.analysis.e.a)localObject1).h);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).i != null) && (!((com.tencent.analysis.e.a)localObject1).i.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.i, ((com.tencent.analysis.e.a)localObject1).i);
        new StringBuilder("sdkRequst_resolution:").append(((com.tencent.analysis.e.a)localObject1).i);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).j != null) && (!((com.tencent.analysis.e.a)localObject1).j.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.j, ((com.tencent.analysis.e.a)localObject1).j);
        new StringBuilder("sdkRequst_cpu:").append(((com.tencent.analysis.e.a)localObject1).j);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).k != null) && (!((com.tencent.analysis.e.a)localObject1).k.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.k, ((com.tencent.analysis.e.a)localObject1).k);
        new StringBuilder("sdkRequst_gpu:").append(((com.tencent.analysis.e.a)localObject1).k);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).l != null) && (!((com.tencent.analysis.e.a)localObject1).l.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.l, ((com.tencent.analysis.e.a)localObject1).l);
        new StringBuilder("sdkRequst_romSize:").append(((com.tencent.analysis.e.a)localObject1).l);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).m != null) && (!((com.tencent.analysis.e.a)localObject1).m.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.m, ((com.tencent.analysis.e.a)localObject1).m);
        new StringBuilder("sdkRequst_ramSize:").append(((com.tencent.analysis.e.a)localObject1).m);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).n != null) && (!((com.tencent.analysis.e.a)localObject1).n.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.n, ((com.tencent.analysis.e.a)localObject1).n);
        new StringBuilder("sdkRequst_country:").append(((com.tencent.analysis.e.a)localObject1).n);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).o != null) && (!((com.tencent.analysis.e.a)localObject1).o.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.o, ((com.tencent.analysis.e.a)localObject1).o);
        new StringBuilder("sdkRequst_language:").append(((com.tencent.analysis.e.a)localObject1).o);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).p != null) && (!((com.tencent.analysis.e.a)localObject1).p.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.p, ((com.tencent.analysis.e.a)localObject1).p);
        new StringBuilder("sdkRequst_sensor:").append(((com.tencent.analysis.e.a)localObject1).p);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).q != null) && (!((com.tencent.analysis.e.a)localObject1).q.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.q, ((com.tencent.analysis.e.a)localObject1).q);
        new StringBuilder("sdkRequst_appName:").append(((com.tencent.analysis.e.a)localObject1).q);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).r != null) && (!((com.tencent.analysis.e.a)localObject1).r.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.r, ((com.tencent.analysis.e.a)localObject1).r);
        new StringBuilder("sdkRequst_appVersion:").append(((com.tencent.analysis.e.a)localObject1).r);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).s != null) && (!((com.tencent.analysis.e.a)localObject1).s.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.s, ((com.tencent.analysis.e.a)localObject1).s);
        new StringBuilder("sdkRequst_sdkVersion:").append(((com.tencent.analysis.e.a)localObject1).s);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).t != null) && (!((com.tencent.analysis.e.a)localObject1).t.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.t, ((com.tencent.analysis.e.a)localObject1).t);
        new StringBuilder("sdkRequst_channel:").append(((com.tencent.analysis.e.a)localObject1).t);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).u != null) && (!((com.tencent.analysis.e.a)localObject1).u.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.u, ((com.tencent.analysis.e.a)localObject1).u);
        new StringBuilder("sdkRequst_brand:").append(((com.tencent.analysis.e.a)localObject1).u);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).v != null) && (!((com.tencent.analysis.e.a)localObject1).v.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.v, ((com.tencent.analysis.e.a)localObject1).v);
        new StringBuilder("sdkRequst_inumeric:").append(((com.tencent.analysis.e.a)localObject1).v);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).w != null) && (!((com.tencent.analysis.e.a)localObject1).w.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.w, ((com.tencent.analysis.e.a)localObject1).w);
        new StringBuilder("sdkRequst_uptimeMillis:").append(((com.tencent.analysis.e.a)localObject1).w);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).x != null) && (!((com.tencent.analysis.e.a)localObject1).x.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.x, ((com.tencent.analysis.e.a)localObject1).x);
        new StringBuilder("sdkRequst_elapsedRealtime:").append(((com.tencent.analysis.e.a)localObject1).x);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).y != null) && (!((com.tencent.analysis.e.a)localObject1).y.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.y, ((com.tencent.analysis.e.a)localObject1).y);
        new StringBuilder("sdkRequst_userID:").append(((com.tencent.analysis.e.a)localObject1).y);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).z != null) && (!((com.tencent.analysis.e.a)localObject1).z.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.z, ((com.tencent.analysis.e.a)localObject1).z);
        new StringBuilder("sdkRequst_networkType:").append(((com.tencent.analysis.e.a)localObject1).z);
        bool = com.tencent.analysis.b.c;
      }
      if ((((com.tencent.analysis.e.a)localObject1).A != null) && (!((com.tencent.analysis.e.a)localObject1).A.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.A, ((com.tencent.analysis.e.a)localObject1).A);
        new StringBuilder("sdkRequst_appVersionName:").append(((com.tencent.analysis.e.a)localObject1).A);
        bool = com.tencent.analysis.b.c;
      }
    }
    localObject1 = this.a;
    localObject2 = com.tencent.analysis.a.b.B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.a().a);
    ((i)localObject1).a((com.tencent.analysis.a.b)localObject2, localStringBuilder.toString());
    try
    {
      localObject1 = this.a.c();
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public final void b()
  {
    boolean bool = com.tencent.analysis.b.c;
  }
  
  public final void b(String paramString)
  {
    if (paramString != null) {
      if (paramString.equals("")) {
        return;
      }
    }
    try
    {
      this.b.a(paramString);
      if (!this.b.c()) {
        return;
      }
      Object localObject;
      if ((this.b.d().containsKey(com.tencent.analysis.a.b.a)) && (!((String)this.b.d().get(com.tencent.analysis.a.b.a)).equals("")))
      {
        paramString = com.tencent.analysis.a.a;
        localObject = c.b();
        String str = (String)this.b.d().get(com.tencent.analysis.a.b.a);
        localObject = ((d)localObject).b.c(str.getBytes());
        paramString.getSharedPreferences("analysis_sdk", 0).edit().putString("key_qimei", (String)localObject).commit();
        new StringBuilder("sdkResponse_qimei:").append((String)this.b.d().get(com.tencent.analysis.a.b.a));
        bool = com.tencent.analysis.b.c;
      }
      if ((this.b.a().containsKey(com.tencent.analysis.a.b.C)) && (this.b.a().containsKey(com.tencent.analysis.a.b.B))) {
        c.a(Integer.parseInt((String)this.b.a().get(com.tencent.analysis.a.b.B)), (String)this.b.a().get(com.tencent.analysis.a.b.C));
      }
      if (this.b.a().containsKey(com.tencent.analysis.a.b.D))
      {
        localObject = (String)this.b.a().get(com.tencent.analysis.a.b.D);
        "sdkResponse_locate_config:".concat(String.valueOf(localObject));
        bool = com.tencent.analysis.b.c;
        if (localObject != null)
        {
          paramString = com.tencent.analysis.a.a;
          localObject = c.b().b.c(((String)localObject).getBytes());
          paramString.getSharedPreferences("analysis_sdk", 0).edit().putString("local_gps", (String)localObject).commit();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      boolean bool;
      label363:
      break label363;
    }
    bool = com.tencent.analysis.b.c;
  }
  
  public final void c()
  {
    boolean bool = com.tencent.analysis.b.c;
    a(d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.c.b.a
 * JD-Core Version:    0.7.0.1
 */