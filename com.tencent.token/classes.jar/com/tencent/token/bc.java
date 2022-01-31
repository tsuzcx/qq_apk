package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class bc
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public fo f = null;
  
  protected bc(String paramString)
  {
    this.f = new fo(paramString);
  }
  
  private d b(byte paramByte)
  {
    Object localObject1 = new d((byte)0);
    ax.a();
    QQUser localQQUser = ax.b((d)localObject1);
    boolean bool;
    if (localQQUser == null)
    {
      if (((d)localObject1).a == 0)
      {
        paramByte = 1;
        if (paramByte != 0) {
          break label54;
        }
      }
      label54:
      for (bool = true;; bool = false)
      {
        e.a(bool);
        return localObject1;
        paramByte = 0;
        break;
      }
    }
    gv localgv = new gv();
    long l1 = ag.c().r();
    long l2 = System.currentTimeMillis();
    if (l1 > l2) {}
    Object localObject2;
    byte b;
    for (;;)
    {
      l1 = l1 / 1000L + 300L;
      l2 = t.a(2, localQQUser.mUin);
      localObject2 = null;
      b = af.a + 1;
      af.a = b;
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("uin", localQQUser.mUin);
        ((JSONObject)localObject3).put("seq_id", b);
        ((JSONObject)localObject3).put("op_time", ag.c().r() / 1000L);
        ((JSONObject)localObject3).put("msg_type", 2);
        ((JSONObject)localObject3).put("req_msg_num", 40);
        ((JSONObject)localObject3).put("start_time", l2);
        ((JSONObject)localObject3).put("end_time", l1);
        ((JSONObject)localObject3).put("source", l1);
        ((JSONObject)localObject3).put("end_time", l1);
        ((JSONObject)localObject3).put("source", paramByte);
        localObject3 = ((JSONObject)localObject3).toString();
        e.a("plain:" + (String)localObject3);
        localObject3 = s.b(((String)localObject3).getBytes());
        localObject2 = localObject3;
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          Object localObject3;
          e.c("JSONException:" + localJSONException3.getMessage());
          continue;
          bool = false;
        }
        try
        {
          localObject2 = new JSONObject(new String(localJSONException3));
          paramByte = ((JSONObject)localObject2).getInt("err");
          if (paramByte == 0) {
            break label581;
          }
          e.a("error = " + paramByte);
          localObject2 = ((JSONObject)localObject2).getString("info");
          ((d)localObject1).a(paramByte, (String)localObject2, (String)localObject2);
          break label901;
          localObject2 = s.d(((JSONObject)localObject2).getString("data"));
          if (localObject2 == null) {
            break label853;
          }
          localObject2 = new JSONObject(new String((byte[])localObject2));
          paramByte = ((JSONObject)localObject2).getInt("seq_id");
          if (paramByte == b) {
            break label710;
          }
          ((d)localObject1).a(10030, null, null);
          e.c("parseJSON error seq is wrong seq=" + paramByte + ",right = " + b);
          return localObject1;
        }
        catch (JSONException localJSONException1)
        {
          ((d)localObject1).a(10020, "JSONException:" + localJSONException1.toString(), null);
          break label901;
          l1 = localJSONException1.getLong("uin");
          if (l1 == localQQUser.mUin) {
            break label812;
          }
          ((d)localObject1).a(10000, "uin not match=" + l1 + ":" + localQQUser.mUin, null);
          return localObject1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ((d)localObject1).a(10021, "JSONException:" + localException1.toString(), null);
            break;
            this.f.b(l1);
            d locald = this.f.a(localException1, l1, 2);
            localObject1 = locald;
            try
            {
              ax.a().m();
            }
            catch (JSONException localJSONException2)
            {
              continue;
              e.c("parseJSON error decodeData=" + localJSONException2);
              ((d)localObject1).a(10022, RqdApplication.i().getString(2131361799), null);
            }
            catch (Exception localException2) {}
          }
        }
      }
      localObject3 = new StringBuilder().append("?aq_base_sid=");
      ax.a();
      localObject2 = ax.c + "&data=" + (String)localObject2;
      ax.a();
      if (ax.c == null) {
        break;
      }
      bool = true;
      e.a(bool);
      localObject2 = b.c() + "/cn/mbtoken3/mbtoken3_get_message_v2" + (String)localObject2;
      localObject3 = localgv.a((String)localObject2);
      if (localObject3 != null) {
        break label507;
      }
      localObject3 = localgv.a();
      ((d)localObject1).a(((d)localObject3).a, ((d)localObject3).b, ((d)localObject3).c);
      e.c("client request url: " + (String)localObject2 + " failed, reason=" + ((d)localObject1).a + ":" + ((d)localObject1).b);
      return localObject1;
      l1 = l2;
    }
    label507:
    return localObject1;
  }
  
  protected final d a(byte paramByte)
  {
    int i = 0;
    d locald1 = new d((byte)0);
    d locald2 = b(paramByte);
    if (locald2.a == 0) {
      i = 1;
    }
    if (i != 0) {}
    while (!ax.a().c(locald1.a)) {
      return locald2;
    }
    return b(paramByte);
  }
  
  public final void a(long paramLong)
  {
    this.f.b(paramLong);
  }
  
  public final boolean d()
  {
    return this.f.j();
  }
  
  public final boolean e()
  {
    return this.f.k();
  }
  
  public final void f()
  {
    this.f.h();
  }
  
  public final int g()
  {
    return this.f.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bc
 * JD-Core Version:    0.7.0.1
 */