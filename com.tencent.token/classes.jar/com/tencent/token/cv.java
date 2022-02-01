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

public class cv
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public dl f = null;
  
  protected cv(String paramString)
  {
    this.f = new dl(paramString);
  }
  
  private e a(e parame, int paramInt, byte paramByte)
  {
    return a(parame, paramInt, 40, paramByte);
  }
  
  private e a(e parame, int paramInt1, int paramInt2, byte paramByte)
  {
    parame = new e();
    Object localObject5 = cs.a().b(parame);
    if (localObject5 == null)
    {
      g.a(parame.b() ^ true);
      return parame;
    }
    Object localObject3 = new fc();
    long l1 = cd.c().s();
    long l2 = System.currentTimeMillis();
    if (l1 <= l2) {
      l1 = l2;
    }
    l1 = l1 / 1000L + 300L;
    l2 = m.a(paramInt1, ((QQUser)localObject5).mUin);
    Object localObject4 = null;
    int i = cc.a + 1;
    cc.a = i;
    StringBuilder localStringBuilder;
    try
    {
      Object localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("uin", ((QQUser)localObject5).mUin);
        ((JSONObject)localObject1).put("seq_id", i);
        ((JSONObject)localObject1).put("op_time", cd.c().s() / 1000L);
        ((JSONObject)localObject1).put("msg_type", paramInt1);
        ((JSONObject)localObject1).put("req_msg_num", paramInt2);
        ((JSONObject)localObject1).put("start_time", l2);
        ((JSONObject)localObject1).put("end_time", l1);
        ((JSONObject)localObject1).put("source", l1);
        ((JSONObject)localObject1).put("end_time", l1);
        ((JSONObject)localObject1).put("source", paramByte);
        localObject1 = ((JSONObject)localObject1).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("plain:");
        localStringBuilder.append((String)localObject1);
        g.a(localStringBuilder.toString());
        localObject1 = l.b(((String)localObject1).getBytes());
      }
      catch (JSONException localJSONException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (JSONException localJSONException2) {}
    localStringBuilder.append("JSONException:");
    localStringBuilder.append(localJSONException2.getMessage());
    g.c(localStringBuilder.toString());
    Object localObject2 = localObject4;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("?aq_base_sid=");
    cs.a();
    ((StringBuilder)localObject4).append(cs.c);
    ((StringBuilder)localObject4).append("&data=");
    ((StringBuilder)localObject4).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject4).toString();
    cs.a();
    boolean bool;
    if (cs.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(c.e());
    ((StringBuilder)localObject4).append("/cn/mbtoken3/mbtoken3_get_message_v2");
    ((StringBuilder)localObject4).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject4).toString();
    localObject4 = ((fc)localObject3).a((String)localObject2);
    if (localObject4 == null)
    {
      parame.a(((fc)localObject3).a());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("client request url: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(" failed, reason=");
      ((StringBuilder)localObject3).append(parame.a);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(parame.b);
      g.c(((StringBuilder)localObject3).toString());
      return parame;
    }
    localObject2 = parame;
    localObject3 = parame;
    try
    {
      localObject4 = new JSONObject(new String((byte[])localObject4));
      localObject2 = parame;
      localObject3 = parame;
      paramInt2 = ((JSONObject)localObject4).getInt("err");
      if (paramInt2 != 0)
      {
        localObject2 = parame;
        localObject3 = parame;
        localObject5 = new StringBuilder();
        localObject2 = parame;
        localObject3 = parame;
        ((StringBuilder)localObject5).append("error = ");
        localObject2 = parame;
        localObject3 = parame;
        ((StringBuilder)localObject5).append(paramInt2);
        localObject2 = parame;
        localObject3 = parame;
        g.a(((StringBuilder)localObject5).toString());
        localObject2 = parame;
        localObject3 = parame;
        localObject4 = ((JSONObject)localObject4).getString("info");
        localObject2 = parame;
        localObject3 = parame;
        parame.a(paramInt2, (String)localObject4, (String)localObject4);
        return parame;
      }
      localObject2 = parame;
      localObject3 = parame;
      localObject4 = l.c(((JSONObject)localObject4).getString("data"));
      if (localObject4 != null)
      {
        localObject2 = parame;
        localObject3 = parame;
        localObject4 = new JSONObject(new String((byte[])localObject4));
        localObject2 = parame;
        localObject3 = parame;
        paramInt2 = ((JSONObject)localObject4).getInt("seq_id");
        if (paramInt2 != i)
        {
          localObject2 = parame;
          localObject3 = parame;
          parame.b(10030);
          localObject2 = parame;
          localObject3 = parame;
          localObject4 = new StringBuilder();
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append("parseJSON error seq is wrong seq=");
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(paramInt2);
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(",right = ");
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(i);
          localObject2 = parame;
          localObject3 = parame;
          g.c(((StringBuilder)localObject4).toString());
          return parame;
        }
        localObject2 = parame;
        localObject3 = parame;
        l1 = ((JSONObject)localObject4).getLong("uin");
        localObject2 = parame;
        localObject3 = parame;
        if (l1 != ((QQUser)localObject5).mUin)
        {
          localObject2 = parame;
          localObject3 = parame;
          localObject4 = new StringBuilder();
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append("uin not match=");
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(l1);
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(":");
          localObject2 = parame;
          localObject3 = parame;
          ((StringBuilder)localObject4).append(((QQUser)localObject5).mUin);
          localObject2 = parame;
          localObject3 = parame;
          parame.a(10000, ((StringBuilder)localObject4).toString());
          return parame;
        }
        localObject2 = parame;
        localObject3 = parame;
        this.f.b(l1);
        localObject2 = parame;
        localObject3 = parame;
        parame = this.f.a((JSONObject)localObject4, l1, paramInt1);
        localObject2 = parame;
        localObject3 = parame;
        cs.a().m();
        return parame;
      }
      localObject2 = parame;
      localObject3 = parame;
      localObject5 = new StringBuilder();
      localObject2 = parame;
      localObject3 = parame;
      ((StringBuilder)localObject5).append("parseJSON error decodeData=");
      localObject2 = parame;
      localObject3 = parame;
      ((StringBuilder)localObject5).append(localObject4);
      localObject2 = parame;
      localObject3 = parame;
      g.c(((StringBuilder)localObject5).toString());
      localObject2 = parame;
      localObject3 = parame;
      parame.a(10022, RqdApplication.n().getString(2131493068));
      return parame;
    }
    catch (Exception parame)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("JSONException:");
      ((StringBuilder)localObject3).append(parame.toString());
      ((e)localObject2).a(10021, ((StringBuilder)localObject3).toString());
      return localObject2;
    }
    catch (JSONException parame)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException:");
      ((StringBuilder)localObject2).append(parame.toString());
      ((e)localObject3).a(10020, ((StringBuilder)localObject2).toString());
    }
    return localObject3;
  }
  
  protected e a(int paramInt, byte paramByte)
  {
    e locale2 = new e();
    e locale1 = a(locale2, paramInt, paramByte);
    if (locale1.b()) {
      return locale1;
    }
    if (cs.a().c(locale2.a)) {
      locale1 = a(locale2, paramInt, paramByte);
    }
    return locale1;
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
 * Qualified Name:     com.tencent.token.cv
 * JD-Core Version:    0.7.0.1
 */