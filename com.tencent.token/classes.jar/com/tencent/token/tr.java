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

public final class tr
  extends tq
{
  public static byte a = 1;
  public static byte d = 2;
  public static byte e = 3;
  public static byte f = 4;
  static tr g;
  private final String h = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  
  private tr()
  {
    super(1);
  }
  
  public static tr a()
  {
    if (g == null) {
      g = new tr();
    }
    return g;
  }
  
  private xt b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new xt();
    Object localObject3 = tt.a();
    Object localObject2;
    if (!((tt)localObject3).i())
    {
      localObject2 = ((tt)localObject3).m();
      localObject1 = localObject2;
      if (!((xt)localObject2).b()) {
        return localObject2;
      }
    }
    int i;
    if (paramLong > 0L)
    {
      i = 0;
      while (i < ((tt)localObject3).k.a())
      {
        localObject2 = ((tt)localObject3).a(i);
        StringBuilder localStringBuilder2 = new StringBuilder("other app: hash=");
        localStringBuilder2.append(paramLong);
        localStringBuilder2.append(", uin=");
        localStringBuilder2.append(((QQUser)localObject2).mUin);
        localStringBuilder2.append(", real=");
        localStringBuilder2.append(((QQUser)localObject2).mRealUin);
        localStringBuilder2.append(", bind=");
        localStringBuilder2.append(((QQUser)localObject2).mIsBinded);
        xv.c(localStringBuilder2.toString());
        if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == paramLong)) {
          break;
        }
        if ((!((QQUser)localObject2).mIsBinded) && (aay.f(((QQUser)localObject2).mRealUin) == paramLong))
        {
          ((xt)localObject1).a(10029, null, null);
          return localObject1;
        }
        i += 1;
      }
      if (i == ((tt)localObject3).k.a())
      {
        ((xt)localObject1).a(110, null, null);
        return localObject1;
      }
    }
    long l = ((tt)localObject3).c();
    if ((((tt)localObject3).k.b() != null) && (l != 0L))
    {
      if (((tt)localObject3).k.b().mIsBinded) {
        l = ((tt)localObject3).k.b().mUin;
      }
      localObject3 = new CountDownLatch(1);
      localObject2 = new AtomicReference(null);
      rt.a().a(l, paramByte, new rt.a()
      {
        public final void a(rv paramAnonymousrv)
        {
          this.a.set(paramAnonymousrv);
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
      localObject2 = (rv)((AtomicReference)localObject2).get();
      if (localObject2 == null)
      {
        ((xt)localObject1).a(-799, null, null);
        return localObject1;
      }
      try
      {
        i = ((rv)localObject2).b;
        if (i != 0)
        {
          localObject2 = ((rv)localObject2).d;
          ((xt)localObject1).a(i, (String)localObject2, (String)localObject2);
          return localObject1;
        }
        localObject2 = ((rv)localObject2).c;
        if (localObject2 != null)
        {
          localObject2 = new JSONObject((String)localObject2).getJSONArray("msgs");
          if (!a((JSONArray)localObject2, paramLong))
          {
            localStringBuilder1 = new StringBuilder("update conf list failed:");
            localStringBuilder1.append(((JSONArray)localObject2).toString());
            ((xt)localObject1).a(10000, localStringBuilder1.toString(), null);
            return localObject1;
          }
          tt.a().g();
          ((xt)localObject1).a = 0;
          return localObject1;
        }
        xv.c("parseJSON error decodeData");
        ((xt)localObject1).a(10022, RqdApplication.n().getString(2131493069), null);
        return localObject1;
      }
      catch (Exception localException)
      {
        localStringBuilder1 = new StringBuilder("unknown err: ");
        localStringBuilder1.append(localException.toString());
        xv.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localException.toString());
        ((xt)localObject1).a(10021, localStringBuilder1.toString(), null);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("parse json failed: ");
        localStringBuilder1.append(localJSONException.toString());
        xv.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localJSONException.toString());
        ((xt)localObject1).a(10020, localStringBuilder1.toString(), null);
        return localObject1;
      }
    }
    ((xt)localObject1).a(110, null, null);
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
      xv.c("load mLastItemTime=".concat(String.valueOf(l2)));
      return l2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xv.c(localStringBuilder.toString());
    }
    return l1;
  }
  
  public final xt a(byte paramByte, long paramLong)
  {
    xt localxt2 = b(paramByte, paramLong);
    if (localxt2.b()) {
      return localxt2;
    }
    xt localxt1 = localxt2;
    if (localxt2.a == 104)
    {
      tt.a().h();
      localxt1 = b(paramByte, paramLong);
    }
    return localxt1;
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
    xv.a(bool);
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          while (i < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(i);
            sy localsy = new sy();
            if (!localsy.a((JSONObject)localObject)) {
              xv.c("object item parse failed: ".concat(String.valueOf(i)));
            }
            localObject = new StringBuilder("server item time=");
            ((StringBuilder)localObject).append(localsy.e);
            xv.c(((StringBuilder)localObject).toString());
            if (this.c < localsy.e)
            {
              this.c = localsy.e;
              localObject = new StringBuilder("get mLastItemTime=");
              ((StringBuilder)localObject).append(this.c);
              xv.c(((StringBuilder)localObject).toString());
              localObject = RqdApplication.n();
              try
              {
                localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
                ((SharedPreferences.Editor)localObject).putLong("time", this.c);
                ((SharedPreferences.Editor)localObject).commit();
                localObject = new StringBuilder("save mLastItemTime=");
                ((StringBuilder)localObject).append(this.c);
                xv.c(((StringBuilder)localObject).toString());
              }
              catch (Exception localException)
              {
                StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
                localStringBuilder.append(localException.getMessage());
                xv.c(localStringBuilder.toString());
              }
            }
            if (paramLong == 0L) {
              this.b.add(localsy);
            } else if ((paramLong > 0L) && (paramLong == localsy.c)) {
              this.b.add(localsy);
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
 * Qualified Name:     com.tencent.token.tr
 * JD-Core Version:    0.7.0.1
 */