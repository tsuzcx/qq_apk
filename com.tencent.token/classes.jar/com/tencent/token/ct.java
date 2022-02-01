package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import org.json.JSONException;
import org.json.JSONObject;

public class ct
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public dj f = null;
  
  protected ct(String paramString)
  {
    this.f = new dj(paramString);
  }
  
  private e a(e parame, int paramInt, byte paramByte)
  {
    return a(parame, paramInt, 40, paramByte);
  }
  
  private e a(e parame, int paramInt1, int paramInt2, byte paramByte)
  {
    parame = new e();
    QQUser localQQUser = cq.a().b(parame);
    boolean bool;
    if (localQQUser == null)
    {
      if (!parame.b()) {}
      for (bool = true;; bool = false)
      {
        g.a(bool);
        return parame;
      }
    }
    ey localey = new ey();
    long l1 = cb.c().s();
    long l2 = System.currentTimeMillis();
    if (l1 > l2) {}
    Object localObject1;
    int i;
    for (;;)
    {
      l1 = 300L + l1 / 1000L;
      l2 = m.a(paramInt1, localQQUser.mUin);
      localObject1 = null;
      i = ca.a + 1;
      ca.a = i;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", localQQUser.mUin);
        ((JSONObject)localObject2).put("seq_id", i);
        ((JSONObject)localObject2).put("op_time", cb.c().s() / 1000L);
        ((JSONObject)localObject2).put("msg_type", paramInt1);
        ((JSONObject)localObject2).put("req_msg_num", paramInt2);
        ((JSONObject)localObject2).put("start_time", l2);
        ((JSONObject)localObject2).put("end_time", l1);
        ((JSONObject)localObject2).put("source", l1);
        ((JSONObject)localObject2).put("end_time", l1);
        ((JSONObject)localObject2).put("source", paramByte);
        localObject2 = ((JSONObject)localObject2).toString();
        g.a("plain:" + (String)localObject2);
        localObject2 = l.b(((String)localObject2).getBytes());
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          Object localObject2;
          g.c("JSONException:" + localJSONException3.getMessage());
          continue;
          bool = false;
        }
        try
        {
          localObject1 = new JSONObject(new String(localJSONException3));
          paramInt2 = ((JSONObject)localObject1).getInt("err");
          if (paramInt2 == 0) {
            break label551;
          }
          g.a("error = " + paramInt2);
          localObject1 = ((JSONObject)localObject1).getString("info");
          parame.a(paramInt2, (String)localObject1, (String)localObject1);
          return parame;
          localObject1 = l.c(((JSONObject)localObject1).getString("data"));
          if (localObject1 == null) {
            break label813;
          }
          localObject1 = new JSONObject(new String((byte[])localObject1));
          paramInt2 = ((JSONObject)localObject1).getInt("seq_id");
          if (paramInt2 == i) {
            break label676;
          }
          parame.b(10030);
          g.c("parseJSON error seq is wrong seq=" + paramInt2 + ",right = " + i);
          return parame;
        }
        catch (JSONException localJSONException1)
        {
          parame.a(10020, "JSONException:" + localJSONException1.toString());
          return parame;
          l1 = localJSONException1.getLong("uin");
          if (l1 == localQQUser.mUin) {
            break label773;
          }
          parame.a(10000, "uin not match=" + l1 + ":" + localQQUser.mUin);
          return parame;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            parame.a(10021, "JSONException:" + localException1.toString());
            break;
            this.f.b(l1);
            e locale = this.f.a(localException1, l1, paramInt1);
            parame = locale;
            try
            {
              cq.a().m();
            }
            catch (JSONException localJSONException2)
            {
              continue;
              g.c("parseJSON error decodeData=" + localJSONException2);
              parame.a(10022, RqdApplication.l().getString(2131230925));
            }
            catch (Exception localException2) {}
          }
        }
      }
      localObject2 = new StringBuilder().append("?aq_base_sid=");
      cq.a();
      localObject1 = cq.c + "&data=" + (String)localObject1;
      cq.a();
      if (cq.c == null) {
        break;
      }
      bool = true;
      g.a(bool);
      localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_get_message_v2" + (String)localObject1;
      localObject2 = localey.a((String)localObject1);
      if (localObject2 != null) {
        break label478;
      }
      parame.a(localey.a());
      g.c("client request url: " + (String)localObject1 + " failed, reason=" + parame.a + ":" + parame.b);
      return parame;
      l1 = l2;
    }
    label478:
    return parame;
  }
  
  protected e a(int paramInt, byte paramByte)
  {
    e locale1 = new e();
    e locale2 = a(locale1, paramInt, paramByte);
    if (locale2.b()) {}
    while (!cq.a().c(locale1.a)) {
      return locale2;
    }
    return a(locale1, paramInt, paramByte);
  }
  
  public void a(int paramInt)
  {
    this.f.c(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.f.b(paramLong);
  }
  
  public boolean d()
  {
    return this.f.i();
  }
  
  public boolean e()
  {
    return this.f.j();
  }
  
  public int f()
  {
    return this.f.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ct
 * JD-Core Version:    0.7.0.1
 */