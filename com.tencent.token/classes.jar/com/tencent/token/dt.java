package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import org.json.JSONException;
import org.json.JSONObject;

public class dt
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public er f = null;
  
  protected dt(String paramString)
  {
    this.f = new er(paramString);
  }
  
  private f a(f paramf, int paramInt, byte paramByte)
  {
    return a(paramf, paramInt, 40, paramByte);
  }
  
  private f a(f paramf, int paramInt1, int paramInt2, byte paramByte)
  {
    paramf = new f();
    QQUser localQQUser = do.a().b(paramf);
    boolean bool;
    if (localQQUser == null)
    {
      if (!paramf.b()) {}
      for (bool = true;; bool = false)
      {
        h.a(bool);
        return paramf;
      }
    }
    gk localgk = new gk();
    long l1 = cx.c().s();
    long l2 = System.currentTimeMillis();
    if (l1 > l2) {}
    Object localObject1;
    int i;
    for (;;)
    {
      l1 = 300L + l1 / 1000L;
      l2 = x.a(paramInt1, localQQUser.mUin);
      localObject1 = null;
      i = cw.a + 1;
      cw.a = i;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", localQQUser.mUin);
        ((JSONObject)localObject2).put("seq_id", i);
        ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
        ((JSONObject)localObject2).put("msg_type", paramInt1);
        ((JSONObject)localObject2).put("req_msg_num", paramInt2);
        ((JSONObject)localObject2).put("start_time", l2);
        ((JSONObject)localObject2).put("end_time", l1);
        ((JSONObject)localObject2).put("source", l1);
        ((JSONObject)localObject2).put("end_time", l1);
        ((JSONObject)localObject2).put("source", paramByte);
        localObject2 = ((JSONObject)localObject2).toString();
        h.a("plain:" + (String)localObject2);
        localObject2 = w.b(((String)localObject2).getBytes());
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          Object localObject2;
          h.c("JSONException:" + localJSONException3.getMessage());
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
          h.a("error = " + paramInt2);
          localObject1 = ((JSONObject)localObject1).getString("info");
          paramf.a(paramInt2, (String)localObject1, (String)localObject1);
          return paramf;
          localObject1 = w.c(((JSONObject)localObject1).getString("data"));
          if (localObject1 == null) {
            break label813;
          }
          localObject1 = new JSONObject(new String((byte[])localObject1));
          paramInt2 = ((JSONObject)localObject1).getInt("seq_id");
          if (paramInt2 == i) {
            break label676;
          }
          paramf.b(10030);
          h.c("parseJSON error seq is wrong seq=" + paramInt2 + ",right = " + i);
          return paramf;
        }
        catch (JSONException localJSONException1)
        {
          paramf.a(10020, "JSONException:" + localJSONException1.toString());
          return paramf;
          l1 = localJSONException1.getLong("uin");
          if (l1 == localQQUser.mUin) {
            break label773;
          }
          paramf.a(10000, "uin not match=" + l1 + ":" + localQQUser.mUin);
          return paramf;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            paramf.a(10021, "JSONException:" + localException1.toString());
            break;
            this.f.b(l1);
            f localf = this.f.a(localException1, l1, paramInt1);
            paramf = localf;
            try
            {
              do.a().m();
            }
            catch (JSONException localJSONException2)
            {
              continue;
              h.c("parseJSON error decodeData=" + localJSONException2);
              paramf.a(10022, RqdApplication.l().getString(2131230925));
            }
            catch (Exception localException2) {}
          }
        }
      }
      localObject2 = new StringBuilder().append("?aq_base_sid=");
      do.a();
      localObject1 = do.c + "&data=" + (String)localObject1;
      do.a();
      if (do.c == null) {
        break;
      }
      bool = true;
      h.a(bool);
      localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_get_message_v2" + (String)localObject1;
      localObject2 = localgk.a((String)localObject1);
      if (localObject2 != null) {
        break label478;
      }
      paramf.a(localgk.a());
      h.c("client request url: " + (String)localObject1 + " failed, reason=" + paramf.a + ":" + paramf.b);
      return paramf;
      l1 = l2;
    }
    label478:
    return paramf;
  }
  
  protected f a(int paramInt, byte paramByte)
  {
    f localf1 = new f();
    f localf2 = a(localf1, paramInt, paramByte);
    if (localf2.b()) {}
    while (!do.a().c(localf1.a)) {
      return localf2;
    }
    return a(localf1, paramInt, paramByte);
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
 * Qualified Name:     com.tencent.token.dt
 * JD-Core Version:    0.7.0.1
 */