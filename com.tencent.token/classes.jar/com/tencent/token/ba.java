package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba
{
  static ba a = null;
  private static boolean i = true;
  public fc b = new fc();
  public fk c = new fk();
  public fl d = new fl();
  public fr e = new fr();
  public fm f = new fm();
  public fq g = new fq();
  public fp h = new fp();
  
  private ba()
  {
    this.h.b();
  }
  
  public static ba a()
  {
    if (a == null)
    {
      ba localba = new ba();
      a = localba;
      return localba;
    }
    if (i) {
      i = false;
    }
    return a;
  }
  
  public static d a(com.tencent.token.core.bean.g paramg, boolean paramBoolean)
  {
    int k = 1;
    new d((byte)0);
    d locald2 = new d((byte)0);
    d locald1 = a(paramg, paramBoolean, locald2);
    if (locald1.a == 0)
    {
      j = 1;
      if (j != 0) {
        paramg.c = paramBoolean;
      }
      if (locald1.a != 0) {
        break label71;
      }
      j = 1;
      label59:
      if (j == 0) {
        break label76;
      }
    }
    label71:
    label76:
    while (!ax.a().c(locald2.a))
    {
      return locald1;
      j = 0;
      break;
      j = 0;
      break label59;
    }
    locald2 = a(paramg, paramBoolean, locald2);
    if (locald2.a == 0) {}
    for (int j = k;; j = 0)
    {
      locald1 = locald2;
      if (j == 0) {
        break;
      }
      paramg.c = paramBoolean;
      return locald2;
    }
  }
  
  private static d a(com.tencent.token.core.bean.g paramg, boolean paramBoolean, d paramd)
  {
    d locald = new d((byte)0);
    ax.a();
    QQUser localQQUser = ax.b(locald);
    if (localQQUser == null) {
      return locald;
    }
    Object localObject1 = new StringBuilder().append("{\"conf_data\":[{\"id\":").append(paramg.a).append(",\"value\":");
    if (paramBoolean) {}
    for (paramg = "1";; paramg = "0")
    {
      paramg = paramg + "}]}";
      e.a(paramg);
      localObject1 = s.b(paramg.getBytes());
      if (localObject1 != null) {
        break;
      }
      locald.a(10000, null, null);
      e.c("encTransData failed: " + paramg);
      return locald;
    }
    paramg = new gv();
    Object localObject2 = new StringBuilder().append("?uin=").append(localQQUser.mUin).append("&sess_id=");
    ax.a();
    localObject1 = ax.c + "&data=" + (String)localObject1;
    localObject1 = b.c() + "/cn/mbtoken3/mbtoken3_set_service_status" + (String)localObject1;
    localObject2 = paramg.a((String)localObject1);
    if (localObject2 == null)
    {
      paramg = paramg.a();
      locald.a(paramg.a, paramg.b, paramg.c);
      e.c("client request url: " + (String)localObject1 + " failed, reason=" + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      paramg = new JSONObject(new String((byte[])localObject2));
      long l = paramg.getLong("uin");
      int j = paramg.getInt("err");
      if (l != localQQUser.mUin)
      {
        locald.a(10000, "uin not match=" + l + ":" + localQQUser.mUin, null);
        return locald;
      }
      if (j != 0)
      {
        paramg = paramg.getString("info");
        locald.a(j, paramg, paramg);
        paramd.a(j, null, null);
      }
      else
      {
        ax.a().m();
        locald.a = 0;
      }
    }
    catch (JSONException paramg)
    {
      e.c("parse json failed: " + paramg.toString());
      locald.a(10020, "JSONException:" + paramg.toString(), null);
    }
    catch (Exception paramg)
    {
      e.c("unknown err: " + paramg.toString());
      locald.a(10021, "JSONException:" + paramg.toString(), null);
    }
    return locald;
  }
  
  public final int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public final com.tencent.token.core.bean.g a(int paramInt)
  {
    Object localObject = this.c;
    if ((paramInt < 0) || (paramInt >= ((fk)localObject).c())) {}
    do
    {
      return null;
      localObject = ((fk)localObject).a();
    } while (localObject == null);
    return (com.tencent.token.core.bean.g)((List)localObject).get(paramInt);
  }
  
  public final com.tencent.token.core.bean.g a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.b;
    if ((paramInt < 0) || (paramInt >= ((fc)localObject).b(paramBoolean))) {}
    do
    {
      return null;
      localObject = ((fc)localObject).a(paramBoolean);
    } while (localObject == null);
    return (com.tencent.token.core.bean.g)((List)localObject).get(paramInt);
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public final com.tencent.token.core.bean.g b(int paramInt)
  {
    Object localObject = this.d;
    List localList;
    int j;
    if (paramInt >= 0)
    {
      localList = ((fl)localObject).a();
      if (localList != null) {
        break label29;
      }
      j = 0;
      if (paramInt < j) {
        break label40;
      }
    }
    label29:
    label40:
    do
    {
      return null;
      j = localList.size();
      break;
      localObject = ((fl)localObject).a();
    } while (localObject == null);
    return (com.tencent.token.core.bean.g)((List)localObject).get(paramInt);
  }
  
  public final void b()
  {
    this.b.g = true;
  }
  
  public final boolean b(JSONArray paramJSONArray)
  {
    return this.c.a(paramJSONArray);
  }
  
  public final int c()
  {
    return this.c.d();
  }
  
  public final boolean c(JSONArray paramJSONArray)
  {
    return this.f.a(paramJSONArray);
  }
  
  public final int d()
  {
    return this.c.c();
  }
  
  public final boolean d(JSONArray paramJSONArray)
  {
    return this.g.a(paramJSONArray);
  }
  
  public final int e()
  {
    return this.d.c();
  }
  
  public final void e(JSONArray paramJSONArray)
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
        com.tencent.token.core.bean.g localg = new com.tencent.token.core.bean.g();
        if (!localg.a(localJSONObject)) {
          e.c("object item parse failed: ");
        }
        this.e.a(localg);
        m = 1;
      }
      if (6 != localJSONObject.getInt("id")) {
        break label189;
      }
      localObject = localJSONObject.getJSONArray("child");
      if (!this.d.a((JSONArray)localObject)) {
        throw new JSONException("parse all services data failed");
      }
      j = 1;
      localObject = localJSONObject;
    }
    label189:
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
      com.tencent.token.global.g.a("game_protect", ((JSONObject)localObject).toString());
      return;
    }
  }
  
  public final int f()
  {
    List localList = this.d.a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final com.tencent.token.core.bean.g g()
  {
    return this.e.a;
  }
  
  public final com.tencent.token.core.bean.g h()
  {
    return this.f.a;
  }
  
  public final com.tencent.token.core.bean.g i()
  {
    return this.g.a;
  }
  
  public final boolean j()
  {
    return this.b.g;
  }
  
  public final boolean k()
  {
    return this.c.f;
  }
  
  public final boolean l()
  {
    return this.d.f;
  }
  
  public final boolean m()
  {
    return this.b.a();
  }
  
  public final boolean n()
  {
    return this.c.b();
  }
  
  public final boolean o()
  {
    return this.d.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ba
 * JD-Core Version:    0.7.0.1
 */