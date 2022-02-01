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

public class cp
  extends co
{
  public static byte a = 1;
  public static byte e = 2;
  public static byte f = 3;
  public static byte g = 4;
  static cp h;
  private final String i = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int j;
  
  private cp()
  {
    super(1);
  }
  
  public static cp a()
  {
    if (h == null) {
      h = new cp();
    }
    return h;
  }
  
  private e b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new e();
    Object localObject4 = cr.a();
    Object localObject2;
    if (!((cr)localObject4).o()) {
      if (!((cr)localObject4).p())
      {
        localObject2 = ((cr)localObject4).q();
        localObject1 = localObject2;
        if (((e)localObject2).b()) {}
      }
      else
      {
        do
        {
          return localObject2;
          localObject1 = ((cr)localObject4).u();
          localObject2 = localObject1;
        } while (!((e)localObject1).b());
      }
    }
    for (;;)
    {
      int k;
      if (paramLong > 0L)
      {
        k = 0;
        for (;;)
        {
          if (k < ((cr)localObject4).d())
          {
            localObject2 = ((cr)localObject4).a(k);
            g.c("other app: hash=" + paramLong + ", uin=" + ((QQUser)localObject2).mUin + ", real=" + ((QQUser)localObject2).mRealUin + ", bind=" + ((QQUser)localObject2).mIsBinded);
            if ((!((QQUser)localObject2).mIsBinded) || (((QQUser)localObject2).mUin != paramLong)) {}
          }
          else
          {
            if (k != ((cr)localObject4).d()) {
              break;
            }
            ((e)localObject1).b(110);
            return localObject1;
          }
          if ((!((QQUser)localObject2).mIsBinded) && (l.f(((QQUser)localObject2).mRealUin) == paramLong))
          {
            ((e)localObject1).b(10029);
            return localObject1;
          }
          k += 1;
        }
      }
      long l = ((cr)localObject4).f();
      if ((((cr)localObject4).e() == null) || (l == 0L))
      {
        ((e)localObject1).b(110);
        return localObject1;
      }
      if (((cr)localObject4).e().mIsBinded) {
        l = ((cr)localObject4).e().mUin;
      }
      ez localez = new ez();
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", l);
        k = cb.a + 1;
        cb.a = k;
        this.j = k;
        ((JSONObject)localObject2).put("seq_id", this.j);
        ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
        ((JSONObject)localObject2).put("tkn_seq", cc.c().j().replaceAll("-", ""));
        ((JSONObject)localObject2).put("source", paramByte);
        localObject2 = ((JSONObject)localObject2).toString();
        g.a("plain:" + (String)localObject2);
        localObject2 = l.b(((String)localObject2).getBytes());
        localObject2 = "?aq_base_sid=" + ((cr)localObject4).g() + "&data=" + (String)localObject2;
        localObject2 = c.e() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject2;
        localObject4 = localez.a((String)localObject2);
        if (localObject4 == null)
        {
          ((e)localObject1).a(localez.a());
          g.c("client request url: " + (String)localObject2 + " failed, reason: " + ((e)localObject1).a + ":" + ((e)localObject1).b);
          return localObject1;
        }
      }
      catch (JSONException localJSONException1)
      {
        Object localObject3;
        for (;;)
        {
          g.c("JSONException:" + localJSONException1.getMessage());
          localObject3 = null;
        }
        try
        {
          localObject3 = new JSONObject(new String((byte[])localObject4));
          paramByte = ((JSONObject)localObject3).getInt("err");
          if (paramByte != 0)
          {
            localObject3 = ((JSONObject)localObject3).getString("info");
            ((e)localObject1).a(paramByte, (String)localObject3, (String)localObject3);
          }
          else
          {
            localObject3 = l.c(((JSONObject)localObject3).getString("data"));
            if (localObject3 != null)
            {
              localObject3 = new JSONObject(new String((byte[])localObject3));
              paramByte = ((JSONObject)localObject3).getInt("seq_id");
              if (paramByte != this.j)
              {
                ((e)localObject1).b(10030);
                g.c("parseJSON error seq is wrong seq=" + paramByte + ",right = " + cb.a().b());
                return localObject1;
              }
              localObject3 = ((JSONObject)localObject3).getJSONArray("msgs");
              if (!a((JSONArray)localObject3, paramLong)) {
                ((e)localObject1).a(10000, "update conf list failed:" + ((JSONArray)localObject3).toString());
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          g.c("parse json failed: " + localJSONException2.toString());
          ((e)localObject1).a(10020, "JSONException:" + localJSONException2.toString());
          break;
          cr.a().m();
          ((e)localObject1).c();
        }
        catch (Exception localException)
        {
          g.c("unknown err: " + localException.toString());
          ((e)localObject1).a(10021, "JSONException:" + localException.toString());
        }
        g.c("parseJSON error decodeData=" + localException);
        ((e)localObject1).a(10022, RqdApplication.l().getString(2131230925));
      }
    }
    return localObject1;
  }
  
  private void e()
  {
    Object localObject = RqdApplication.l();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("time", this.c);
      ((SharedPreferences.Editor)localObject).commit();
      g.c("save mLastItemTime=" + this.c);
      return;
    }
    catch (Exception localException)
    {
      g.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public e a(byte paramByte, long paramLong)
  {
    e locale = b(paramByte, paramLong);
    if (locale.b()) {}
    while (locale.a != 104) {
      return locale;
    }
    cr.a().n();
    return b(paramByte, paramLong);
  }
  
  public boolean a(JSONArray paramJSONArray, long paramLong)
  {
    this.b.clear();
    if (paramJSONArray != null) {}
    for (boolean bool = true;; bool = false)
    {
      g.a(bool);
      if (paramJSONArray != null) {}
      for (;;)
      {
        int k;
        try
        {
          if (paramJSONArray.length() > 0)
          {
            k = 0;
            if (k < paramJSONArray.length())
            {
              JSONObject localJSONObject = paramJSONArray.getJSONObject(k);
              a locala = new a();
              if (!locala.a(localJSONObject)) {
                g.c("object item parse failed: " + k);
              }
              g.c("server item time=" + locala.e());
              if (this.c < locala.e())
              {
                this.c = locala.e();
                g.c("get mLastItemTime=" + this.c);
                e();
              }
              if (paramLong == 0L) {
                this.b.add(locala);
              } else if ((paramLong > 0L) && (paramLong == locala.c())) {
                this.b.add(locala);
              }
            }
          }
        }
        catch (JSONException paramJSONArray)
        {
          paramJSONArray.printStackTrace();
          return false;
        }
        return true;
        k += 1;
      }
    }
  }
  
  public long c()
  {
    Context localContext = RqdApplication.l();
    try
    {
      l = localContext.getSharedPreferences("dualmsgtime", 0).getLong("time", 0L);
      g.c("SharedPreferences msg " + localException1.getMessage());
    }
    catch (Exception localException1)
    {
      try
      {
        g.c("load mLastItemTime=" + l);
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
  
  public long d()
  {
    this.c = c();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cp
 * JD-Core Version:    0.7.0.1
 */