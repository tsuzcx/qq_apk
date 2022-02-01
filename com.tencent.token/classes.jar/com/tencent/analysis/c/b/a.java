package com.tencent.analysis.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
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
      if ((((com.tencent.analysis.e.a)localObject1).a != null) && (!((com.tencent.analysis.e.a)localObject1).a.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.a, ((com.tencent.analysis.e.a)localObject1).a);
        localObject3 = new StringBuilder("sdkRequst_qimei:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).a);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).b != null) && (!((com.tencent.analysis.e.a)localObject1).b.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.b, ((com.tencent.analysis.e.a)localObject1).b);
        localObject3 = new StringBuilder("sdkRequst_imei:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).b);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).c != null) && (!((com.tencent.analysis.e.a)localObject1).c.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.c, ((com.tencent.analysis.e.a)localObject1).c);
        localObject3 = new StringBuilder("sdkRequst_mac:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).c);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).d != null) && (!((com.tencent.analysis.e.a)localObject1).d.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.d, ((com.tencent.analysis.e.a)localObject1).d);
        localObject3 = new StringBuilder("sdkRequst_imsi:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).d);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).e != null) && (!((com.tencent.analysis.e.a)localObject1).e.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.e, ((com.tencent.analysis.e.a)localObject1).e);
        localObject3 = new StringBuilder("sdkRequst_androidId:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).e);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).f != null) && (!((com.tencent.analysis.e.a)localObject1).f.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.f, ((com.tencent.analysis.e.a)localObject1).f);
        localObject3 = new StringBuilder("sdkRequst_model:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).f);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).g != null) && (!((com.tencent.analysis.e.a)localObject1).g.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.g, ((com.tencent.analysis.e.a)localObject1).g);
        localObject3 = new StringBuilder("sdkRequst_phonePlatform:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).g);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).h != null) && (!((com.tencent.analysis.e.a)localObject1).h.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.h, ((com.tencent.analysis.e.a)localObject1).h);
        localObject3 = new StringBuilder("sdkRequst_osVersion:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).h);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).i != null) && (!((com.tencent.analysis.e.a)localObject1).i.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.i, ((com.tencent.analysis.e.a)localObject1).i);
        localObject3 = new StringBuilder("sdkRequst_resolution:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).i);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).j != null) && (!((com.tencent.analysis.e.a)localObject1).j.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.j, ((com.tencent.analysis.e.a)localObject1).j);
        localObject3 = new StringBuilder("sdkRequst_cpu:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).j);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).k != null) && (!((com.tencent.analysis.e.a)localObject1).k.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.k, ((com.tencent.analysis.e.a)localObject1).k);
        localObject3 = new StringBuilder("sdkRequst_gpu:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).k);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).l != null) && (!((com.tencent.analysis.e.a)localObject1).l.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.l, ((com.tencent.analysis.e.a)localObject1).l);
        localObject3 = new StringBuilder("sdkRequst_romSize:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).l);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).m != null) && (!((com.tencent.analysis.e.a)localObject1).m.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.m, ((com.tencent.analysis.e.a)localObject1).m);
        localObject3 = new StringBuilder("sdkRequst_ramSize:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).m);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).n != null) && (!((com.tencent.analysis.e.a)localObject1).n.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.n, ((com.tencent.analysis.e.a)localObject1).n);
        localObject3 = new StringBuilder("sdkRequst_country:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).n);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).o != null) && (!((com.tencent.analysis.e.a)localObject1).o.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.o, ((com.tencent.analysis.e.a)localObject1).o);
        localObject3 = new StringBuilder("sdkRequst_language:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).o);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).p != null) && (!((com.tencent.analysis.e.a)localObject1).p.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.p, ((com.tencent.analysis.e.a)localObject1).p);
        localObject3 = new StringBuilder("sdkRequst_sensor:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).p);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).q != null) && (!((com.tencent.analysis.e.a)localObject1).q.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.q, ((com.tencent.analysis.e.a)localObject1).q);
        localObject3 = new StringBuilder("sdkRequst_appName:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).q);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).r != null) && (!((com.tencent.analysis.e.a)localObject1).r.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.r, ((com.tencent.analysis.e.a)localObject1).r);
        localObject3 = new StringBuilder("sdkRequst_appVersion:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).r);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).s != null) && (!((com.tencent.analysis.e.a)localObject1).s.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.s, ((com.tencent.analysis.e.a)localObject1).s);
        localObject3 = new StringBuilder("sdkRequst_sdkVersion:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).s);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).t != null) && (!((com.tencent.analysis.e.a)localObject1).t.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.t, ((com.tencent.analysis.e.a)localObject1).t);
        localObject3 = new StringBuilder("sdkRequst_channel:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).t);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).u != null) && (!((com.tencent.analysis.e.a)localObject1).u.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.u, ((com.tencent.analysis.e.a)localObject1).u);
        localObject3 = new StringBuilder("sdkRequst_brand:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).u);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).v != null) && (!((com.tencent.analysis.e.a)localObject1).v.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.v, ((com.tencent.analysis.e.a)localObject1).v);
        localObject3 = new StringBuilder("sdkRequst_inumeric:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).v);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).w != null) && (!((com.tencent.analysis.e.a)localObject1).w.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.w, ((com.tencent.analysis.e.a)localObject1).w);
        localObject3 = new StringBuilder("sdkRequst_uptimeMillis:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).w);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).x != null) && (!((com.tencent.analysis.e.a)localObject1).x.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.x, ((com.tencent.analysis.e.a)localObject1).x);
        localObject3 = new StringBuilder("sdkRequst_elapsedRealtime:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).x);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).y != null) && (!((com.tencent.analysis.e.a)localObject1).y.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.y, ((com.tencent.analysis.e.a)localObject1).y);
        localObject3 = new StringBuilder("sdkRequst_userID:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).y);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).z != null) && (!((com.tencent.analysis.e.a)localObject1).z.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.z, ((com.tencent.analysis.e.a)localObject1).z);
        localObject3 = new StringBuilder("sdkRequst_networkType:");
        ((StringBuilder)localObject3).append(((com.tencent.analysis.e.a)localObject1).z);
        localObject3 = ((StringBuilder)localObject3).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject3);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject1).A != null) && (!((com.tencent.analysis.e.a)localObject1).A.equals("")))
      {
        ((i)localObject2).b(com.tencent.analysis.a.b.A, ((com.tencent.analysis.e.a)localObject1).A);
        localObject2 = new StringBuilder("sdkRequst_appVersionName:");
        ((StringBuilder)localObject2).append(((com.tencent.analysis.e.a)localObject1).A);
        localObject1 = ((StringBuilder)localObject2).toString();
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject1);
        }
      }
    }
    localObject1 = this.a;
    localObject2 = com.tencent.analysis.a.b.B;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(c.a().a);
    ((i)localObject1).a((com.tencent.analysis.a.b)localObject2, ((StringBuilder)localObject3).toString());
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
    if (com.tencent.analysis.b.c) {
      Log.i("sdkResponse", "shakeHands resPonse fail");
    }
  }
  
  public final void b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
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
          paramString = new StringBuilder("sdkResponse_qimei:");
          paramString.append((String)this.b.d().get(com.tencent.analysis.a.b.a));
          paramString = paramString.toString();
          if (com.tencent.analysis.b.c) {
            Log.i("sdkResponse", paramString);
          }
        }
        if ((this.b.a().containsKey(com.tencent.analysis.a.b.C)) && (this.b.a().containsKey(com.tencent.analysis.a.b.B))) {
          c.a(Integer.parseInt((String)this.b.a().get(com.tencent.analysis.a.b.B)), (String)this.b.a().get(com.tencent.analysis.a.b.C));
        }
        if (this.b.a().containsKey(com.tencent.analysis.a.b.D))
        {
          paramString = (String)this.b.a().get(com.tencent.analysis.a.b.D);
          localObject = new StringBuilder("sdkResponse_locate_config:");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
          if (com.tencent.analysis.b.c) {
            Log.i("sdkResponse", (String)localObject);
          }
          if (paramString != null)
          {
            localObject = com.tencent.analysis.a.a;
            paramString = c.b().b.c(paramString.getBytes());
            ((Context)localObject).getSharedPreferences("analysis_sdk", 0).edit().putString("local_gps", paramString).commit();
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString = paramString.toString();
        if (com.tencent.analysis.b.c) {
          Log.i("ShakeHandsTask", paramString);
        }
      }
    }
  }
  
  public final void c()
  {
    if (com.tencent.analysis.b.c) {
      Log.i("ShakeHandsTask", "ShakeHandsTask preparestart");
    }
    a(d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.c.b.a
 * JD-Core Version:    0.7.0.1
 */