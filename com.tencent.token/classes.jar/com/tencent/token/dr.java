package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dr
{
  static dr a = null;
  private static boolean i = true;
  public ef b = new ef();
  public en c = new en();
  public eo d = new eo();
  public eu e = new eu();
  public ep f = new ep();
  public et g = new et();
  public es h = new es();
  
  private dr()
  {
    q();
  }
  
  public static dr a()
  {
    if (a == null)
    {
      a = new dr();
      return a;
    }
    if (i)
    {
      i = false;
      a.m();
    }
    return a;
  }
  
  private f a(com.tencent.token.core.bean.h paramh, boolean paramBoolean, f paramf)
  {
    paramf = b(paramh, paramBoolean, paramf);
    if (paramf.b()) {
      paramh.c = paramBoolean;
    }
    return paramf;
  }
  
  private f b(com.tencent.token.core.bean.h paramh, boolean paramBoolean, f paramf)
  {
    f localf = new f();
    QQUser localQQUser = do.a().b(localf);
    if (localQQUser == null) {
      return localf;
    }
    int j = cw.a + 1;
    cw.a = j;
    Object localObject1 = new StringBuilder().append("{\"conf_data\":[{\"id\":").append(paramh.a).append(",\"value\":");
    if (paramBoolean) {}
    for (paramh = "1";; paramh = "0")
    {
      paramh = paramh + "}], \"A2\":\"\", \"seq_id\":" + j + ", \"op_time\":" + (int)(cx.c().s() / 1000L) + ",\"uin\":" + localQQUser.mUin + "}";
      com.tencent.token.global.h.a(paramh);
      localObject1 = w.b(paramh.getBytes());
      if (localObject1 != null) {
        break;
      }
      localf.b(10000);
      com.tencent.token.global.h.c("encTransData failed: " + paramh);
      return localf;
    }
    paramh = new gk();
    Object localObject2 = new StringBuilder().append("?aq_base_sid=");
    do.a();
    localObject1 = do.c + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_set_service_status_encrypt" + (String)localObject1;
    localObject2 = paramh.a((String)localObject1);
    if (localObject2 == null)
    {
      localf.a(paramh.a());
      com.tencent.token.global.h.c("client request url: " + (String)localObject1 + " failed, reason=" + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      paramh = new JSONObject(new String((byte[])localObject2));
      int k = paramh.getInt("err");
      if (k != 0)
      {
        paramh = paramh.getString("info");
        localf.a(k, paramh, paramh);
        paramf.b(k);
      }
      else
      {
        paramh = w.c(paramh.getString("data"));
        if (paramh != null)
        {
          paramh = new JSONObject(new String(paramh));
          com.tencent.token.global.h.b("ProtoSetServiceStatusV2:" + paramh);
          long l = paramh.getLong("uin");
          if (l != localQQUser.mUin)
          {
            localf.a(10000, "uin not match=" + l + ":" + localQQUser.mUin);
            return localf;
          }
          if (paramh.getInt("seq_id") != j)
          {
            localf.b(10030);
            return localf;
          }
          do.a().m();
          localf.c();
        }
      }
    }
    catch (JSONException paramh)
    {
      com.tencent.token.global.h.c("parse json failed: " + paramh.toString());
      localf.a(10020, "JSONException:" + paramh.toString());
      break label715;
      com.tencent.token.global.h.c("parseJSON error decodeData=" + paramh);
      localf.a(10022, RqdApplication.l().getString(2131230925), RqdApplication.l().getString(2131230925));
    }
    catch (Exception paramh)
    {
      com.tencent.token.global.h.c("unknown err: " + paramh.toString());
      localf.a(10021, "JSONException:" + paramh.toString());
    }
    label715:
    return localf;
  }
  
  private void q()
  {
    this.h.b();
  }
  
  public int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public com.tencent.token.core.bean.h a(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public com.tencent.token.core.bean.h a(int paramInt, boolean paramBoolean)
  {
    return this.b.a(paramInt, paramBoolean);
  }
  
  public f a(com.tencent.token.core.bean.h paramh, boolean paramBoolean)
  {
    new f();
    f localf1 = new f();
    f localf2 = a(paramh, paramBoolean, localf1);
    if (localf2.b()) {}
    while (!do.a().c(localf1.a)) {
      return localf2;
    }
    return a(paramh, paramBoolean, localf1);
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public com.tencent.token.core.bean.h b(int paramInt)
  {
    return this.d.a(paramInt);
  }
  
  public void b()
  {
    this.b.g = true;
  }
  
  public boolean b(JSONArray paramJSONArray)
  {
    return this.c.a(paramJSONArray);
  }
  
  public int c()
  {
    return this.c.d();
  }
  
  public boolean c(JSONArray paramJSONArray)
  {
    return this.d.a(paramJSONArray);
  }
  
  public int d()
  {
    return this.c.c();
  }
  
  public boolean d(JSONArray paramJSONArray)
  {
    return this.f.a(paramJSONArray);
  }
  
  public int e()
  {
    return this.d.d();
  }
  
  public boolean e(JSONArray paramJSONArray)
  {
    return this.g.a(paramJSONArray);
  }
  
  public int f()
  {
    return this.d.c();
  }
  
  public void f(JSONArray paramJSONArray)
  {
    Object localObject = null;
    int k = 0;
    int j = 0;
    int m = 0;
    if (k < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(k);
      if (4 == localJSONObject.getInt("id"))
      {
        com.tencent.token.core.bean.h localh = new com.tencent.token.core.bean.h();
        if (!localh.a(localJSONObject)) {
          com.tencent.token.global.h.c("object item parse failed: ");
        }
        this.e.a(localh);
        m = 1;
      }
      if (6 != localJSONObject.getInt("id")) {
        break label183;
      }
      if (!c(localJSONObject.getJSONArray("child"))) {
        throw new JSONException("parse all services data failed");
      }
      j = 1;
      localObject = localJSONObject;
    }
    label183:
    for (;;)
    {
      k += 1;
      break;
      if ((m == 0) || (j == 0)) {
        throw new JSONException("parse all services data failed");
      }
      this.d.e = true;
      this.e.d = true;
      this.d.f = false;
      this.d.a(localObject.toString());
      return;
    }
  }
  
  public com.tencent.token.core.bean.h g()
  {
    return this.e.a;
  }
  
  public com.tencent.token.core.bean.h h()
  {
    return this.f.a;
  }
  
  public com.tencent.token.core.bean.h i()
  {
    return this.g.a;
  }
  
  public boolean j()
  {
    return this.b.g;
  }
  
  public boolean k()
  {
    return this.c.f;
  }
  
  public boolean l()
  {
    return this.d.f;
  }
  
  public void m() {}
  
  public boolean n()
  {
    return this.b.a();
  }
  
  public boolean o()
  {
    return this.c.b();
  }
  
  public boolean p()
  {
    return this.d.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dr
 * JD-Core Version:    0.7.0.1
 */