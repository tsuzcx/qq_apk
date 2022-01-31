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
    Object localObject = new com.tencent.analysis.e.a();
    i locali = this.a;
    if (locali != null)
    {
      String str;
      if ((((com.tencent.analysis.e.a)localObject).a != null) && (!((com.tencent.analysis.e.a)localObject).a.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.a, ((com.tencent.analysis.e.a)localObject).a);
        str = "sdkRequst_qimei:" + ((com.tencent.analysis.e.a)localObject).a;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).b != null) && (!((com.tencent.analysis.e.a)localObject).b.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.b, ((com.tencent.analysis.e.a)localObject).b);
        str = "sdkRequst_imei:" + ((com.tencent.analysis.e.a)localObject).b;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).c != null) && (!((com.tencent.analysis.e.a)localObject).c.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.c, ((com.tencent.analysis.e.a)localObject).c);
        str = "sdkRequst_mac:" + ((com.tencent.analysis.e.a)localObject).c;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).d != null) && (!((com.tencent.analysis.e.a)localObject).d.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.d, ((com.tencent.analysis.e.a)localObject).d);
        str = "sdkRequst_imsi:" + ((com.tencent.analysis.e.a)localObject).d;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).e != null) && (!((com.tencent.analysis.e.a)localObject).e.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.e, ((com.tencent.analysis.e.a)localObject).e);
        str = "sdkRequst_androidId:" + ((com.tencent.analysis.e.a)localObject).e;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).f != null) && (!((com.tencent.analysis.e.a)localObject).f.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.f, ((com.tencent.analysis.e.a)localObject).f);
        str = "sdkRequst_model:" + ((com.tencent.analysis.e.a)localObject).f;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).g != null) && (!((com.tencent.analysis.e.a)localObject).g.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.g, ((com.tencent.analysis.e.a)localObject).g);
        str = "sdkRequst_phonePlatform:" + ((com.tencent.analysis.e.a)localObject).g;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).h != null) && (!((com.tencent.analysis.e.a)localObject).h.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.h, ((com.tencent.analysis.e.a)localObject).h);
        str = "sdkRequst_osVersion:" + ((com.tencent.analysis.e.a)localObject).h;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).i != null) && (!((com.tencent.analysis.e.a)localObject).i.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.i, ((com.tencent.analysis.e.a)localObject).i);
        str = "sdkRequst_resolution:" + ((com.tencent.analysis.e.a)localObject).i;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).j != null) && (!((com.tencent.analysis.e.a)localObject).j.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.j, ((com.tencent.analysis.e.a)localObject).j);
        str = "sdkRequst_cpu:" + ((com.tencent.analysis.e.a)localObject).j;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).k != null) && (!((com.tencent.analysis.e.a)localObject).k.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.k, ((com.tencent.analysis.e.a)localObject).k);
        str = "sdkRequst_gpu:" + ((com.tencent.analysis.e.a)localObject).k;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).l != null) && (!((com.tencent.analysis.e.a)localObject).l.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.l, ((com.tencent.analysis.e.a)localObject).l);
        str = "sdkRequst_romSize:" + ((com.tencent.analysis.e.a)localObject).l;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).m != null) && (!((com.tencent.analysis.e.a)localObject).m.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.m, ((com.tencent.analysis.e.a)localObject).m);
        str = "sdkRequst_ramSize:" + ((com.tencent.analysis.e.a)localObject).m;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).n != null) && (!((com.tencent.analysis.e.a)localObject).n.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.n, ((com.tencent.analysis.e.a)localObject).n);
        str = "sdkRequst_country:" + ((com.tencent.analysis.e.a)localObject).n;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).o != null) && (!((com.tencent.analysis.e.a)localObject).o.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.o, ((com.tencent.analysis.e.a)localObject).o);
        str = "sdkRequst_language:" + ((com.tencent.analysis.e.a)localObject).o;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).p != null) && (!((com.tencent.analysis.e.a)localObject).p.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.p, ((com.tencent.analysis.e.a)localObject).p);
        str = "sdkRequst_sensor:" + ((com.tencent.analysis.e.a)localObject).p;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).q != null) && (!((com.tencent.analysis.e.a)localObject).q.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.q, ((com.tencent.analysis.e.a)localObject).q);
        str = "sdkRequst_appName:" + ((com.tencent.analysis.e.a)localObject).q;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).r != null) && (!((com.tencent.analysis.e.a)localObject).r.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.r, ((com.tencent.analysis.e.a)localObject).r);
        str = "sdkRequst_appVersion:" + ((com.tencent.analysis.e.a)localObject).r;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).s != null) && (!((com.tencent.analysis.e.a)localObject).s.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.s, ((com.tencent.analysis.e.a)localObject).s);
        str = "sdkRequst_sdkVersion:" + ((com.tencent.analysis.e.a)localObject).s;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).t != null) && (!((com.tencent.analysis.e.a)localObject).t.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.t, ((com.tencent.analysis.e.a)localObject).t);
        str = "sdkRequst_channel:" + ((com.tencent.analysis.e.a)localObject).t;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).u != null) && (!((com.tencent.analysis.e.a)localObject).u.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.u, ((com.tencent.analysis.e.a)localObject).u);
        str = "sdkRequst_brand:" + ((com.tencent.analysis.e.a)localObject).u;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).v != null) && (!((com.tencent.analysis.e.a)localObject).v.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.v, ((com.tencent.analysis.e.a)localObject).v);
        str = "sdkRequst_inumeric:" + ((com.tencent.analysis.e.a)localObject).v;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).w != null) && (!((com.tencent.analysis.e.a)localObject).w.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.w, ((com.tencent.analysis.e.a)localObject).w);
        str = "sdkRequst_uptimeMillis:" + ((com.tencent.analysis.e.a)localObject).w;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).x != null) && (!((com.tencent.analysis.e.a)localObject).x.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.x, ((com.tencent.analysis.e.a)localObject).x);
        str = "sdkRequst_elapsedRealtime:" + ((com.tencent.analysis.e.a)localObject).x;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).y != null) && (!((com.tencent.analysis.e.a)localObject).y.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.y, ((com.tencent.analysis.e.a)localObject).y);
        str = "sdkRequst_userID:" + ((com.tencent.analysis.e.a)localObject).y;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).z != null) && (!((com.tencent.analysis.e.a)localObject).z.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.z, ((com.tencent.analysis.e.a)localObject).z);
        str = "sdkRequst_networkType:" + ((com.tencent.analysis.e.a)localObject).z;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", str);
        }
      }
      if ((((com.tencent.analysis.e.a)localObject).A != null) && (!((com.tencent.analysis.e.a)localObject).A.equals("")))
      {
        locali.b(com.tencent.analysis.a.b.A, ((com.tencent.analysis.e.a)localObject).A);
        localObject = "sdkRequst_appVersionName:" + ((com.tencent.analysis.e.a)localObject).A;
        if (com.tencent.analysis.b.c) {
          Log.i("sdkRequst", (String)localObject);
        }
      }
    }
    this.a.a(com.tencent.analysis.a.b.B, c.a().a);
    try
    {
      localObject = this.a.c();
      return localObject;
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
    if ((paramString == null) || (paramString.equals(""))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.b.a(paramString);
          if (this.b.c())
          {
            Object localObject;
            if ((this.b.d().containsKey(com.tencent.analysis.a.b.a)) && (!((String)this.b.d().get(com.tencent.analysis.a.b.a)).equals("")))
            {
              paramString = com.tencent.analysis.a.a;
              localObject = c.b();
              String str = (String)this.b.d().get(com.tencent.analysis.a.b.a);
              localObject = ((d)localObject).b.c(str.getBytes());
              paramString.getSharedPreferences("analysis_sdk", 0).edit().putString("key_qimei", (String)localObject).commit();
              paramString = "sdkResponse_qimei:" + (String)this.b.d().get(com.tencent.analysis.a.b.a);
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
              localObject = "sdkResponse_locate_config:" + paramString;
              if (com.tencent.analysis.b.c) {
                Log.i("sdkResponse", (String)localObject);
              }
              if (paramString != null)
              {
                localObject = com.tencent.analysis.a.a;
                paramString = c.b().b.c(paramString.getBytes());
                ((Context)localObject).getSharedPreferences("analysis_sdk", 0).edit().putString("local_gps", paramString).commit();
                return;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          paramString = paramString.toString();
        }
      }
    } while (!com.tencent.analysis.b.c);
    Log.i("ShakeHandsTask", paramString);
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