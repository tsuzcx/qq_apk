package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class av
  extends au
{
  public static byte a = 1;
  public static byte d = 2;
  public static byte e = 3;
  public static byte f = 4;
  static av g;
  private final String h = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int i;
  
  private av()
  {
    super(1);
  }
  
  public static av a()
  {
    if (g == null) {
      g = new av();
    }
    return g;
  }
  
  private d b(byte paramByte, long paramLong)
  {
    int m = 1;
    int j = 1;
    int k = 0;
    this.b.clear();
    Object localObject1 = new d((byte)0);
    Object localObject4 = ax.a();
    Object localObject2;
    if (!((ax)localObject4).o())
    {
      if (!((ax)localObject4).p())
      {
        localObject2 = ((ax)localObject4).q();
        if (((d)localObject2).a == 0) {}
        for (;;)
        {
          localObject1 = localObject2;
          if (j != 0) {
            break;
          }
          return localObject2;
          j = 0;
        }
      }
      localObject2 = ((ax)localObject4).t();
      if (((d)localObject2).a == 0) {}
      for (j = m;; j = 0)
      {
        localObject1 = localObject2;
        if (j != 0) {
          break;
        }
        return localObject2;
      }
    }
    for (;;)
    {
      if (paramLong > 0L)
      {
        j = k;
        while (j < ((ax)localObject4).d())
        {
          localObject2 = ((ax)localObject4).a(j);
          e.c("other app: hash=" + paramLong + ", uin=" + ((QQUser)localObject2).mUin + ", real=" + ((QQUser)localObject2).mRealUin + ", bind=" + ((QQUser)localObject2).mIsBinded);
          if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == paramLong)) {
            break;
          }
          if ((!((QQUser)localObject2).mIsBinded) && (s.f(((QQUser)localObject2).mRealUin) == paramLong))
          {
            ((d)localObject1).a(10029, null, null);
            return localObject1;
          }
          j += 1;
        }
        if (j == ((ax)localObject4).d())
        {
          ((d)localObject1).a(110, null, null);
          return localObject1;
        }
      }
      long l = ((ax)localObject4).f();
      if ((((ax)localObject4).e() == null) || (l == 0L))
      {
        ((d)localObject1).a(110, null, null);
        return localObject1;
      }
      if (((ax)localObject4).e().mIsBinded) {
        l = ((ax)localObject4).e().mUin;
      }
      localObject4 = new gv();
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", l);
        j = af.a + 1;
        af.a = j;
        this.i = j;
        ((JSONObject)localObject2).put("seq_id", this.i);
        ((JSONObject)localObject2).put("op_time", ag.c().r() / 1000L);
        ((JSONObject)localObject2).put("tkn_seq", ag.c().j().replaceAll("-", ""));
        ((JSONObject)localObject2).put("source", paramByte);
        localObject2 = ((JSONObject)localObject2).toString();
        e.a("plain:" + (String)localObject2);
        localObject2 = s.b(((String)localObject2).getBytes());
        localObject2 = "?aq_base_sid=" + ax.g() + "&data=" + (String)localObject2;
        localObject2 = com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject2;
        arrayOfByte = ((gv)localObject4).a((String)localObject2);
        if (arrayOfByte == null)
        {
          localObject4 = ((gv)localObject4).a();
          ((d)localObject1).a(((d)localObject4).a, ((d)localObject4).b, ((d)localObject4).c);
          e.c("client request url: " + (String)localObject2 + " failed, reason: " + ((d)localObject1).a + ":" + ((d)localObject1).b);
          return localObject1;
        }
      }
      catch (JSONException localJSONException1)
      {
        byte[] arrayOfByte;
        Object localObject3;
        for (;;)
        {
          e.c("JSONException:" + localJSONException1.getMessage());
          localObject3 = null;
        }
        try
        {
          localObject3 = new JSONObject(new String(arrayOfByte));
          paramByte = ((JSONObject)localObject3).getInt("err");
          if (paramByte != 0)
          {
            localObject3 = ((JSONObject)localObject3).getString("info");
            ((d)localObject1).a(paramByte, (String)localObject3, (String)localObject3);
          }
          else
          {
            localObject3 = s.d(((JSONObject)localObject3).getString("data"));
            if (localObject3 != null)
            {
              localObject3 = new JSONObject(new String((byte[])localObject3));
              paramByte = ((JSONObject)localObject3).getInt("seq_id");
              if (paramByte != this.i)
              {
                ((d)localObject1).a(10030, null, null);
                localObject3 = new StringBuilder().append("parseJSON error seq is wrong seq=").append(paramByte).append(",right = ");
                af.a();
                e.c(af.b());
                return localObject1;
              }
              localObject3 = ((JSONObject)localObject3).getJSONArray("msgs");
              if (!a((JSONArray)localObject3, paramLong)) {
                ((d)localObject1).a(10000, "update conf list failed:" + ((JSONArray)localObject3).toString(), null);
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          e.c("parse json failed: " + localJSONException2.toString());
          ((d)localObject1).a(10020, "JSONException:" + localJSONException2.toString(), null);
          break;
          ax.a().m();
          ((d)localObject1).a = 0;
        }
        catch (Exception localException)
        {
          e.c("unknown err: " + localException.toString());
          ((d)localObject1).a(10021, "JSONException:" + localException.toString(), null);
        }
        e.c("parseJSON error decodeData=" + localException);
        ((d)localObject1).a(10022, RqdApplication.i().getString(2131361799), null);
      }
    }
    return localObject1;
  }
  
  private static long d()
  {
    Context localContext = RqdApplication.i();
    try
    {
      l = localContext.getSharedPreferences("dualmsgtime", 0).getLong("time", 0L);
      e.c("SharedPreferences msg " + localException1.getMessage());
    }
    catch (Exception localException1)
    {
      try
      {
        e.c("load mLastItemTime=" + l);
        return l;
      }
      catch (Exception localException2)
      {
        long l;
        break label50;
      }
      localException1 = localException1;
      l = 0L;
    }
    label50:
    return l;
  }
  
  public final d a(byte paramByte, long paramLong)
  {
    d locald = b(paramByte, paramLong);
    int j;
    if (locald.a == 0)
    {
      j = 1;
      if (j == 0) {
        break label33;
      }
    }
    label33:
    while (locald.a != 104)
    {
      return locald;
      j = 0;
      break;
    }
    ax.a().n();
    return b(paramByte, paramLong);
  }
  
  public final boolean a(JSONArray paramJSONArray, long paramLong)
  {
    this.b.clear();
    if (paramJSONArray != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      if (paramJSONArray != null) {}
      for (;;)
      {
        int j;
        com.tencent.token.core.bean.b localb;
        try
        {
          if (paramJSONArray.length() <= 0) {
            break label331;
          }
          j = 0;
          if (j >= paramJSONArray.length()) {
            break label331;
          }
          Object localObject = paramJSONArray.getJSONObject(j);
          localb = new com.tencent.token.core.bean.b();
          if (!localb.a((JSONObject)localObject)) {
            e.c("object item parse failed: " + j);
          }
          e.c("server item time=" + localb.e());
          if (this.c < localb.e())
          {
            this.c = localb.e();
            e.c("get mLastItemTime=" + this.c);
            localObject = RqdApplication.i();
          }
          try
          {
            localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
            ((SharedPreferences.Editor)localObject).putLong("time", this.c);
            ((SharedPreferences.Editor)localObject).commit();
            e.c("save mLastItemTime=" + this.c);
            if (paramLong == 0L) {
              this.b.add(localb);
            }
          }
          catch (Exception localException)
          {
            e.c("SharedPreferences msg " + localException.getMessage());
            continue;
          }
          if (paramLong <= 0L) {
            break label333;
          }
        }
        catch (JSONException paramJSONArray)
        {
          paramJSONArray.printStackTrace();
          return false;
        }
        if (paramLong == localb.c())
        {
          this.b.add(localb);
          break label333;
          label331:
          return true;
        }
        label333:
        j += 1;
      }
    }
  }
  
  public final long c()
  {
    this.c = d();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.av
 * JD-Core Version:    0.7.0.1
 */