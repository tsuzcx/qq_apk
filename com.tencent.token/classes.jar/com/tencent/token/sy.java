package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class sy
  extends sx
{
  public static byte a = 1;
  public static byte d = 2;
  public static byte e = 3;
  public static byte f = 4;
  static sy g;
  private final String h = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  
  private sy()
  {
    super(1);
  }
  
  public static sy a()
  {
    if (g == null) {
      g = new sy();
    }
    return g;
  }
  
  private wz b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new wz();
    Object localObject3 = ta.a();
    Object localObject2;
    if (!((ta)localObject3).i())
    {
      localObject2 = ((ta)localObject3).m();
      localObject1 = localObject2;
      if (!((wz)localObject2).b()) {
        return localObject2;
      }
    }
    int i;
    if (paramLong > 0L)
    {
      i = 0;
      while (i < ((ta)localObject3).k.a())
      {
        localObject2 = ((ta)localObject3).a(i);
        StringBuilder localStringBuilder2 = new StringBuilder("other app: hash=");
        localStringBuilder2.append(paramLong);
        localStringBuilder2.append(", uin=");
        localStringBuilder2.append(((QQUser)localObject2).mUin);
        localStringBuilder2.append(", real=");
        localStringBuilder2.append(((QQUser)localObject2).mRealUin);
        localStringBuilder2.append(", bind=");
        localStringBuilder2.append(((QQUser)localObject2).mIsBinded);
        xb.c(localStringBuilder2.toString());
        if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == paramLong)) {
          break;
        }
        if ((!((QQUser)localObject2).mIsBinded) && (aad.f(((QQUser)localObject2).mRealUin) == paramLong))
        {
          ((wz)localObject1).a(10029, null, null);
          return localObject1;
        }
        i += 1;
      }
      if (i == ((ta)localObject3).k.a())
      {
        ((wz)localObject1).a(110, null, null);
        return localObject1;
      }
    }
    long l = ((ta)localObject3).c();
    if ((((ta)localObject3).k.b() != null) && (l != 0L))
    {
      if (((ta)localObject3).k.b().mIsBinded) {
        l = ((ta)localObject3).k.b().mUin;
      }
      localObject3 = new CountDownLatch(1);
      localObject2 = new AtomicReference(null);
      qz.a().a(l, paramByte, new qz.a()
      {
        public final void a(rb paramAnonymousrb)
        {
          this.a.set(paramAnonymousrb);
          this.b.countDown();
        }
      });
      try
      {
        ((CountDownLatch)localObject3).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      localObject2 = (rb)((AtomicReference)localObject2).get();
      if (localObject2 == null)
      {
        ((wz)localObject1).a(-799, null, null);
        return localObject1;
      }
      try
      {
        i = ((rb)localObject2).b;
        if (i != 0)
        {
          localObject2 = ((rb)localObject2).d;
          ((wz)localObject1).a(i, (String)localObject2, (String)localObject2);
          return localObject1;
        }
        localObject2 = ((rb)localObject2).c;
        if (localObject2 != null)
        {
          localObject2 = new JSONObject((String)localObject2).getJSONArray("msgs");
          if (!a((JSONArray)localObject2, paramLong))
          {
            localStringBuilder1 = new StringBuilder("update conf list failed:");
            localStringBuilder1.append(((JSONArray)localObject2).toString());
            ((wz)localObject1).a(10000, localStringBuilder1.toString(), null);
            return localObject1;
          }
          ta.a().g();
          ((wz)localObject1).a = 0;
          return localObject1;
        }
        xb.c("parseJSON error decodeData");
        ((wz)localObject1).a(10022, RqdApplication.n().getString(2131493068), null);
        return localObject1;
      }
      catch (Exception localException)
      {
        localStringBuilder1 = new StringBuilder("unknown err: ");
        localStringBuilder1.append(localException.toString());
        xb.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localException.toString());
        ((wz)localObject1).a(10021, localStringBuilder1.toString(), null);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("parse json failed: ");
        localStringBuilder1.append(localJSONException.toString());
        xb.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localJSONException.toString());
        ((wz)localObject1).a(10020, localStringBuilder1.toString(), null);
        return localObject1;
      }
    }
    ((wz)localObject1).a(110, null, null);
    return localObject1;
  }
  
  private static long d()
  {
    Context localContext = RqdApplication.n();
    long l1 = 0L;
    try
    {
      long l2 = localContext.getSharedPreferences("dualmsgtime", 0).getLong("time", 0L);
      l1 = l2;
      xb.c("load mLastItemTime=".concat(String.valueOf(l2)));
      return l2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return l1;
  }
  
  public final wz a(byte paramByte, long paramLong)
  {
    wz localwz2 = b(paramByte, paramLong);
    if (localwz2.b()) {
      return localwz2;
    }
    wz localwz1 = localwz2;
    if (localwz2.a == 104)
    {
      ta.a().h();
      localwz1 = b(paramByte, paramLong);
    }
    return localwz1;
  }
  
  public final boolean a(JSONArray paramJSONArray, long paramLong)
  {
    this.b.clear();
    boolean bool;
    if (paramJSONArray != null) {
      bool = true;
    } else {
      bool = false;
    }
    xb.a(bool);
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          while (i < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(i);
            sf localsf = new sf();
            if (!localsf.a((JSONObject)localObject)) {
              xb.c("object item parse failed: ".concat(String.valueOf(i)));
            }
            localObject = new StringBuilder("server item time=");
            ((StringBuilder)localObject).append(localsf.e);
            xb.c(((StringBuilder)localObject).toString());
            if (this.c < localsf.e)
            {
              this.c = localsf.e;
              localObject = new StringBuilder("get mLastItemTime=");
              ((StringBuilder)localObject).append(this.c);
              xb.c(((StringBuilder)localObject).toString());
              localObject = RqdApplication.n();
              try
              {
                localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
                ((SharedPreferences.Editor)localObject).putLong("time", this.c);
                ((SharedPreferences.Editor)localObject).commit();
                localObject = new StringBuilder("save mLastItemTime=");
                ((StringBuilder)localObject).append(this.c);
                xb.c(((StringBuilder)localObject).toString());
              }
              catch (Exception localException)
              {
                StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
                localStringBuilder.append(localException.getMessage());
                xb.c(localStringBuilder.toString());
              }
            }
            if (paramLong == 0L) {
              this.b.add(localsf);
            } else if ((paramLong > 0L) && (paramLong == localsf.c)) {
              this.b.add(localsf);
            }
            i += 1;
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
  
  public final long c()
  {
    this.c = d();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sy
 * JD-Core Version:    0.7.0.1
 */