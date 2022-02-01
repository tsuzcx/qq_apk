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

public class ct
{
  static ct a;
  private static boolean i = true;
  public dd b = new dd();
  public dh c = new dh();
  public di d = new di();
  public do e = new do();
  public dj f = new dj();
  public dn g = new dn();
  public dm h = new dm();
  
  private ct()
  {
    q();
  }
  
  public static ct a()
  {
    ct localct = a;
    if (localct == null)
    {
      a = new ct();
      return a;
    }
    if (i)
    {
      i = false;
      localct.m();
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
    QQUser localQQUser = cs.a().b(locale);
    if (localQQUser == null) {
      return locale;
    }
    int j = cc.a + 1;
    cc.a = j;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("{\"conf_data\":[{\"id\":");
    ((StringBuilder)localObject1).append(paramf.a);
    ((StringBuilder)localObject1).append(",\"value\":");
    if (paramBoolean) {
      paramf = "1";
    } else {
      paramf = "0";
    }
    ((StringBuilder)localObject1).append(paramf);
    ((StringBuilder)localObject1).append("}], \"A2\":\"\", \"seq_id\":");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(", \"op_time\":");
    ((StringBuilder)localObject1).append((int)(cd.c().s() / 1000L));
    ((StringBuilder)localObject1).append(",\"uin\":");
    ((StringBuilder)localObject1).append(localQQUser.mUin);
    ((StringBuilder)localObject1).append("}");
    paramf = ((StringBuilder)localObject1).toString();
    g.a(paramf);
    localObject1 = l.b(paramf.getBytes());
    if (localObject1 == null)
    {
      locale.b(10000);
      parame = new StringBuilder();
      parame.append("encTransData failed: ");
      parame.append(paramf);
      g.c(parame.toString());
      return locale;
    }
    paramf = new fc();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?aq_base_sid=");
    cs.a();
    ((StringBuilder)localObject2).append(cs.c);
    ((StringBuilder)localObject2).append("&data=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(c.e());
    ((StringBuilder)localObject2).append("/cn/mbtoken3/mbtoken3_set_service_status_encrypt");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = paramf.a((String)localObject1);
    if (localObject2 == null)
    {
      locale.a(paramf.a());
      paramf = new StringBuilder();
      paramf.append("client request url: ");
      paramf.append((String)localObject1);
      paramf.append(" failed, reason=");
      paramf.append(locale.a);
      paramf.append(":");
      paramf.append(locale.b);
      g.c(paramf.toString());
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
        return locale;
      }
      paramf = l.c(paramf.getString("data"));
      if (paramf != null)
      {
        paramf = new JSONObject(new String(paramf));
        parame = new StringBuilder();
        parame.append("ProtoSetServiceStatusV2:");
        parame.append(paramf);
        g.b(parame.toString());
        long l = paramf.getLong("uin");
        if (l != localQQUser.mUin)
        {
          paramf = new StringBuilder();
          paramf.append("uin not match=");
          paramf.append(l);
          paramf.append(":");
          paramf.append(localQQUser.mUin);
          locale.a(10000, paramf.toString());
          return locale;
        }
        if (paramf.getInt("seq_id") != j)
        {
          locale.b(10030);
          return locale;
        }
        cs.a().m();
        locale.c();
        return locale;
      }
      parame = new StringBuilder();
      parame.append("parseJSON error decodeData=");
      parame.append(paramf);
      g.c(parame.toString());
      locale.a(10022, RqdApplication.n().getString(2131493068), RqdApplication.n().getString(2131493068));
      return locale;
    }
    catch (Exception paramf)
    {
      parame = new StringBuilder();
      parame.append("unknown err: ");
      parame.append(paramf.toString());
      g.c(parame.toString());
      parame = new StringBuilder();
      parame.append("JSONException:");
      parame.append(paramf.toString());
      locale.a(10021, parame.toString());
      return locale;
    }
    catch (JSONException paramf)
    {
      parame = new StringBuilder();
      parame.append("parse json failed: ");
      parame.append(paramf.toString());
      g.c(parame.toString());
      parame = new StringBuilder();
      parame.append("JSONException:");
      parame.append(paramf.toString());
      locale.a(10020, parame.toString());
    }
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
    e locale2 = new e();
    e locale1 = a(paramf, paramBoolean, locale2);
    if (locale1.b()) {
      return locale1;
    }
    if (cs.a().c(locale2.a)) {
      locale1 = a(paramf, paramBoolean, locale2);
    }
    return locale1;
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
    int j = 0;
    int m = 0;
    int k = 0;
    while (j < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
      if (4 == localJSONObject.getInt("id"))
      {
        f localf = new f();
        if (!localf.a(localJSONObject)) {
          g.c("object item parse failed: ");
        }
        this.e.a(localf);
        m = 1;
      }
      if (6 == localJSONObject.getInt("id")) {
        if (c(localJSONObject.getJSONArray("child")))
        {
          localObject = localJSONObject;
          k = 1;
        }
        else
        {
          throw new JSONException("parse all services data failed");
        }
      }
      j += 1;
    }
    if ((m != 0) && (k != 0))
    {
      paramJSONArray = this.d;
      paramJSONArray.e = true;
      this.e.d = true;
      paramJSONArray.f = false;
      paramJSONArray.a(localObject.toString());
      return;
    }
    throw new JSONException("parse all services data failed");
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
 * Qualified Name:     com.tencent.token.ct
 * JD-Core Version:    0.7.0.1
 */