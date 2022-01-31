package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dm
  extends dl
{
  public static byte a = 1;
  public static byte e = 2;
  public static byte f = 3;
  public static byte g = 4;
  static dm h;
  private final String i = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int j;
  
  private dm()
  {
    super(1);
  }
  
  public static dm a()
  {
    if (h == null) {
      h = new dm();
    }
    return h;
  }
  
  private f b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new f();
    Object localObject4 = do.a();
    Object localObject2;
    if (!((do)localObject4).o()) {
      if (!((do)localObject4).p())
      {
        localObject2 = ((do)localObject4).q();
        localObject1 = localObject2;
        if (((f)localObject2).b()) {}
      }
      else
      {
        do
        {
          return localObject2;
          localObject1 = ((do)localObject4).t();
          localObject2 = localObject1;
        } while (!((f)localObject1).b());
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
          if (k < ((do)localObject4).d())
          {
            localObject2 = ((do)localObject4).a(k);
            h.c("other app: hash=" + paramLong + ", uin=" + ((QQUser)localObject2).mUin + ", real=" + ((QQUser)localObject2).mRealUin + ", bind=" + ((QQUser)localObject2).mIsBinded);
            if ((!((QQUser)localObject2).mIsBinded) || (((QQUser)localObject2).mUin != paramLong)) {}
          }
          else
          {
            if (k != ((do)localObject4).d()) {
              break;
            }
            ((f)localObject1).b(110);
            return localObject1;
          }
          if ((!((QQUser)localObject2).mIsBinded) && (w.f(((QQUser)localObject2).mRealUin) == paramLong))
          {
            ((f)localObject1).b(10029);
            return localObject1;
          }
          k += 1;
        }
      }
      long l = ((do)localObject4).f();
      if ((((do)localObject4).e() == null) || (l == 0L))
      {
        ((f)localObject1).b(110);
        return localObject1;
      }
      if (((do)localObject4).e().mIsBinded) {
        l = ((do)localObject4).e().mUin;
      }
      gk localgk = new gk();
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", l);
        k = cw.a + 1;
        cw.a = k;
        this.j = k;
        ((JSONObject)localObject2).put("seq_id", this.j);
        ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
        ((JSONObject)localObject2).put("tkn_seq", cx.c().j().replaceAll("-", ""));
        ((JSONObject)localObject2).put("source", paramByte);
        localObject2 = ((JSONObject)localObject2).toString();
        h.a("plain:" + (String)localObject2);
        localObject2 = w.b(((String)localObject2).getBytes());
        localObject2 = "?aq_base_sid=" + ((do)localObject4).g() + "&data=" + (String)localObject2;
        localObject2 = c.e() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject2;
        localObject4 = localgk.a((String)localObject2);
        if (localObject4 == null)
        {
          ((f)localObject1).a(localgk.a());
          h.c("client request url: " + (String)localObject2 + " failed, reason: " + ((f)localObject1).a + ":" + ((f)localObject1).b);
          return localObject1;
        }
      }
      catch (JSONException localJSONException1)
      {
        Object localObject3;
        for (;;)
        {
          h.c("JSONException:" + localJSONException1.getMessage());
          localObject3 = null;
        }
        try
        {
          localObject3 = new JSONObject(new String((byte[])localObject4));
          paramByte = ((JSONObject)localObject3).getInt("err");
          if (paramByte != 0)
          {
            localObject3 = ((JSONObject)localObject3).getString("info");
            ((f)localObject1).a(paramByte, (String)localObject3, (String)localObject3);
          }
          else
          {
            localObject3 = w.c(((JSONObject)localObject3).getString("data"));
            if (localObject3 != null)
            {
              localObject3 = new JSONObject(new String((byte[])localObject3));
              paramByte = ((JSONObject)localObject3).getInt("seq_id");
              if (paramByte != this.j)
              {
                ((f)localObject1).b(10030);
                h.c("parseJSON error seq is wrong seq=" + paramByte + ",right = " + cw.a().b());
                return localObject1;
              }
              localObject3 = ((JSONObject)localObject3).getJSONArray("msgs");
              if (!a((JSONArray)localObject3, paramLong)) {
                ((f)localObject1).a(10000, "update conf list failed:" + ((JSONArray)localObject3).toString());
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          h.c("parse json failed: " + localJSONException2.toString());
          ((f)localObject1).a(10020, "JSONException:" + localJSONException2.toString());
          break;
          do.a().m();
          ((f)localObject1).c();
        }
        catch (Exception localException)
        {
          h.c("unknown err: " + localException.toString());
          ((f)localObject1).a(10021, "JSONException:" + localException.toString());
        }
        h.c("parseJSON error decodeData=" + localException);
        ((f)localObject1).a(10022, RqdApplication.l().getString(2131230925));
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
      h.c("save mLastItemTime=" + this.c);
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public f a(byte paramByte, long paramLong)
  {
    f localf = b(paramByte, paramLong);
    if (localf.b()) {}
    while (localf.a != 104) {
      return localf;
    }
    do.a().n();
    return b(paramByte, paramLong);
  }
  
  public boolean a(JSONArray paramJSONArray, long paramLong)
  {
    this.b.clear();
    if (paramJSONArray != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
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
                h.c("object item parse failed: " + k);
              }
              h.c("server item time=" + locala.e());
              if (this.c < locala.e())
              {
                this.c = locala.e();
                h.c("get mLastItemTime=" + this.c);
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
      h.c("SharedPreferences msg " + localException1.getMessage());
    }
    catch (Exception localException1)
    {
      try
      {
        h.c("load mLastItemTime=" + l);
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
 * Qualified Name:     com.tencent.token.dm
 * JD-Core Version:    0.7.0.1
 */