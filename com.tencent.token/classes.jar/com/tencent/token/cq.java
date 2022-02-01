package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cq
  extends cp
{
  public static byte a = 1;
  public static byte e = 2;
  public static byte f = 3;
  public static byte g = 4;
  static cq h;
  private final String i = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int j;
  
  private cq()
  {
    super(1);
  }
  
  public static cq a()
  {
    if (h == null) {
      h = new cq();
    }
    return h;
  }
  
  private e b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new e();
    cs localcs = cs.a();
    Object localObject2;
    if (!localcs.o()) {
      if (!localcs.p())
      {
        localObject2 = localcs.q();
        localObject1 = localObject2;
        if (!((e)localObject2).b()) {
          return localObject2;
        }
      }
      else
      {
        localObject2 = localcs.u();
        localObject1 = localObject2;
        if (!((e)localObject2).b()) {
          return localObject2;
        }
      }
    }
    int k;
    Object localObject3;
    if (paramLong > 0L)
    {
      k = 0;
      while (k < localcs.d())
      {
        localObject2 = localcs.a(k);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("other app: hash=");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(", uin=");
        ((StringBuilder)localObject3).append(((QQUser)localObject2).mUin);
        ((StringBuilder)localObject3).append(", real=");
        ((StringBuilder)localObject3).append(((QQUser)localObject2).mRealUin);
        ((StringBuilder)localObject3).append(", bind=");
        ((StringBuilder)localObject3).append(((QQUser)localObject2).mIsBinded);
        g.c(((StringBuilder)localObject3).toString());
        if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == paramLong)) {
          break;
        }
        if ((!((QQUser)localObject2).mIsBinded) && (l.f(((QQUser)localObject2).mRealUin) == paramLong))
        {
          ((e)localObject1).b(10029);
          return localObject1;
        }
        k += 1;
      }
      if (k == localcs.d())
      {
        ((e)localObject1).b(110);
        return localObject1;
      }
    }
    long l = localcs.f();
    if ((localcs.e() != null) && (l != 0L))
    {
      if (localcs.e().mIsBinded) {
        l = localcs.e().mUin;
      }
      fc localfc = new fc();
      localObject2 = null;
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("uin", l);
        k = cc.a + 1;
        cc.a = k;
        this.j = k;
        ((JSONObject)localObject3).put("seq_id", this.j);
        ((JSONObject)localObject3).put("op_time", cd.c().s() / 1000L);
        ((JSONObject)localObject3).put("tkn_seq", cd.c().j().replaceAll("-", ""));
        ((JSONObject)localObject3).put("source", paramByte);
        localObject3 = ((JSONObject)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("plain:");
        localStringBuilder.append((String)localObject3);
        g.a(localStringBuilder.toString());
        localObject3 = l.b(((String)localObject3).getBytes());
        localObject2 = localObject3;
      }
      catch (JSONException localJSONException2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSONException:");
        localStringBuilder.append(localJSONException2.getMessage());
        g.c(localStringBuilder.toString());
      }
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("?aq_base_sid=");
      ((StringBuilder)localObject4).append(localcs.g());
      ((StringBuilder)localObject4).append("&data=");
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(c.e());
      ((StringBuilder)localObject4).append("/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2");
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = localfc.a((String)localObject2);
      if (localObject4 == null)
      {
        ((e)localObject1).a(localfc.a());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("client request url: ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(" failed, reason: ");
        ((StringBuilder)localObject4).append(((e)localObject1).a);
        ((StringBuilder)localObject4).append(":");
        ((StringBuilder)localObject4).append(((e)localObject1).b);
        g.c(((StringBuilder)localObject4).toString());
        return localObject1;
      }
      try
      {
        localObject2 = new JSONObject(new String((byte[])localObject4));
        paramByte = ((JSONObject)localObject2).getInt("err");
        if (paramByte != 0)
        {
          localObject2 = ((JSONObject)localObject2).getString("info");
          ((e)localObject1).a(paramByte, (String)localObject2, (String)localObject2);
          return localObject1;
        }
        localObject2 = l.c(((JSONObject)localObject2).getString("data"));
        if (localObject2 != null)
        {
          localObject2 = new JSONObject(new String((byte[])localObject2));
          paramByte = ((JSONObject)localObject2).getInt("seq_id");
          if (paramByte != this.j)
          {
            ((e)localObject1).b(10030);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parseJSON error seq is wrong seq=");
            ((StringBuilder)localObject2).append(paramByte);
            ((StringBuilder)localObject2).append(",right = ");
            ((StringBuilder)localObject2).append(cc.a().b());
            g.c(((StringBuilder)localObject2).toString());
            return localObject1;
          }
          localObject2 = ((JSONObject)localObject2).getJSONArray("msgs");
          if (!a((JSONArray)localObject2, paramLong))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("update conf list failed:");
            ((StringBuilder)localObject4).append(((JSONArray)localObject2).toString());
            ((e)localObject1).a(10000, ((StringBuilder)localObject4).toString());
            return localObject1;
          }
          cs.a().m();
          ((e)localObject1).c();
          return localObject1;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parseJSON error decodeData=");
        ((StringBuilder)localObject4).append(localObject2);
        g.c(((StringBuilder)localObject4).toString());
        ((e)localObject1).a(10022, RqdApplication.n().getString(2131493068));
        return localObject1;
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("unknown err: ");
        ((StringBuilder)localObject4).append(localException.toString());
        g.c(((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("JSONException:");
        ((StringBuilder)localObject4).append(localException.toString());
        ((e)localObject1).a(10021, ((StringBuilder)localObject4).toString());
        return localObject1;
      }
      catch (JSONException localJSONException1)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parse json failed: ");
        ((StringBuilder)localObject4).append(localJSONException1.toString());
        g.c(((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("JSONException:");
        ((StringBuilder)localObject4).append(localJSONException1.toString());
        ((e)localObject1).a(10020, ((StringBuilder)localObject4).toString());
        return localObject1;
      }
    }
    ((e)localObject1).b(110);
    return localObject1;
  }
  
  private void e()
  {
    Object localObject = RqdApplication.n();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("time", this.c);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save mLastItemTime=");
      ((StringBuilder)localObject).append(this.c);
      g.c(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public e a(byte paramByte, long paramLong)
  {
    e locale2 = b(paramByte, paramLong);
    if (locale2.b()) {
      return locale2;
    }
    e locale1 = locale2;
    if (locale2.a == 104)
    {
      cs.a().n();
      locale1 = b(paramByte, paramLong);
    }
    return locale1;
  }
  
  public boolean a(JSONArray paramJSONArray, long paramLong)
  {
    this.b.clear();
    boolean bool;
    if (paramJSONArray != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int k = 0;
          while (k < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(k);
            a locala = new a();
            if (!locala.a((JSONObject)localObject))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("object item parse failed: ");
              ((StringBuilder)localObject).append(k);
              g.c(((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("server item time=");
            ((StringBuilder)localObject).append(locala.e());
            g.c(((StringBuilder)localObject).toString());
            if (this.c < locala.e())
            {
              this.c = locala.e();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("get mLastItemTime=");
              ((StringBuilder)localObject).append(this.c);
              g.c(((StringBuilder)localObject).toString());
              e();
            }
            if (paramLong == 0L) {
              this.b.add(locala);
            } else if ((paramLong > 0L) && (paramLong == locala.c())) {
              this.b.add(locala);
            }
            k += 1;
          }
        }
        return true;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return false;
      }
    }
  }
  
  public long c()
  {
    Object localObject = RqdApplication.n();
    long l1 = 0L;
    try
    {
      long l2 = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).getLong("time", 0L);
      l1 = l2;
      localObject = new StringBuilder();
      l1 = l2;
      ((StringBuilder)localObject).append("load mLastItemTime=");
      l1 = l2;
      ((StringBuilder)localObject).append(l2);
      l1 = l2;
      g.c(((StringBuilder)localObject).toString());
      return l2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
    return l1;
  }
  
  public long d()
  {
    this.c = c();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cq
 * JD-Core Version:    0.7.0.1
 */