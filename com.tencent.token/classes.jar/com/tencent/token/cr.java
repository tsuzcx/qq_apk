package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.f;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cr
{
  static cr a = null;
  private static boolean i = true;
  public db b = new db();
  public df c = new df();
  public dg d = new dg();
  public dm e = new dm();
  public dh f = new dh();
  public dl g = new dl();
  public dk h = new dk();
  
  private cr()
  {
    q();
  }
  
  public static cr a()
  {
    if (a == null)
    {
      a = new cr();
      return a;
    }
    if (i)
    {
      i = false;
      a.m();
    }
    return a;
  }
  
  private e a(f paramf, boolean paramBoolean, e parame)
  {
    parame = b(paramf, paramBoolean, parame);
    if (parame.b()) {
      paramf.c = paramBoolean;
    }
    return parame;
  }
  
  private e b(f paramf, boolean paramBoolean, e parame)
  {
    e locale = new e();
    QQUser localQQUser = cq.a().b(locale);
    if (localQQUser == null) {
      return locale;
    }
    int j = ca.a + 1;
    ca.a = j;
    Object localObject1 = new StringBuilder().append("{\"conf_data\":[{\"id\":").append(paramf.a).append(",\"value\":");
    if (paramBoolean) {}
    for (paramf = "1";; paramf = "0")
    {
      paramf = paramf + "}], \"A2\":\"\", \"seq_id\":" + j + ", \"op_time\":" + (int)(cb.c().s() / 1000L) + ",\"uin\":" + localQQUser.mUin + "}";
      g.a(paramf);
      localObject1 = l.b(paramf.getBytes());
      if (localObject1 != null) {
        break;
      }
      locale.b(10000);
      g.c("encTransData failed: " + paramf);
      return locale;
    }
    paramf = new ey();
    Object localObject2 = new StringBuilder().append("?aq_base_sid=");
    cq.a();
    localObject1 = cq.c + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_set_service_status_encrypt" + (String)localObject1;
    localObject2 = paramf.a((String)localObject1);
    if (localObject2 == null)
    {
      locale.a(paramf.a());
      g.c("client request url: " + (String)localObject1 + " failed, reason=" + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      paramf = new JSONObject(new String((byte[])localObject2));
      int k = paramf.getInt("err");
      if (k != 0)
      {
        paramf = paramf.getString("info");
        locale.a(k, paramf, paramf);
        parame.b(k);
      }
      else
      {
        paramf = l.c(paramf.getString("data"));
        if (paramf != null)
        {
          paramf = new JSONObject(new String(paramf));
          g.b("ProtoSetServiceStatusV2:" + paramf);
          long l = paramf.getLong("uin");
          if (l != localQQUser.mUin)
          {
            locale.a(10000, "uin not match=" + l + ":" + localQQUser.mUin);
            return locale;
          }
          if (paramf.getInt("seq_id") != j)
          {
            locale.b(10030);
            return locale;
          }
          cq.a().m();
          locale.c();
        }
      }
    }
    catch (JSONException paramf)
    {
      g.c("parse json failed: " + paramf.toString());
      locale.a(10020, "JSONException:" + paramf.toString());
      break label715;
      g.c("parseJSON error decodeData=" + paramf);
      locale.a(10022, RqdApplication.l().getString(2131230925), RqdApplication.l().getString(2131230925));
    }
    catch (Exception paramf)
    {
      g.c("unknown err: " + paramf.toString());
      locale.a(10021, "JSONException:" + paramf.toString());
    }
    label715:
    return locale;
  }
  
  private void q()
  {
    this.h.b();
  }
  
  public int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public f a(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public f a(int paramInt, boolean paramBoolean)
  {
    return this.b.a(paramInt, paramBoolean);
  }
  
  public e a(f paramf, boolean paramBoolean)
  {
    new e();
    e locale1 = new e();
    e locale2 = a(paramf, paramBoolean, locale1);
    if (locale2.b()) {}
    while (!cq.a().c(locale1.a)) {
      return locale2;
    }
    return a(paramf, paramBoolean, locale1);
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public f b(int paramInt)
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
        f localf = new f();
        if (!localf.a(localJSONObject)) {
          g.c("object item parse failed: ");
        }
        this.e.a(localf);
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
  
  public f g()
  {
    return this.e.a;
  }
  
  public f h()
  {
    return this.f.a;
  }
  
  public f i()
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
 * Qualified Name:     com.tencent.token.cr
 * JD-Core Version:    0.7.0.1
 */