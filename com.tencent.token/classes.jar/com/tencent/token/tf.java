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

public final class tf
  extends te
{
  public static byte a = 1;
  public static byte d = 2;
  public static byte e = 3;
  public static byte f = 4;
  static tf g;
  private final String h = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  
  private tf()
  {
    super(1);
  }
  
  public static tf a()
  {
    if (g == null) {
      g = new tf();
    }
    return g;
  }
  
  private xh b(byte paramByte, long paramLong)
  {
    this.b.clear();
    Object localObject1 = new xh();
    Object localObject3 = th.a();
    Object localObject2;
    if (!((th)localObject3).i())
    {
      localObject2 = ((th)localObject3).m();
      localObject1 = localObject2;
      if (!((xh)localObject2).b()) {
        return localObject2;
      }
    }
    int i;
    if (paramLong > 0L)
    {
      i = 0;
      while (i < ((th)localObject3).k.a())
      {
        localObject2 = ((th)localObject3).a(i);
        StringBuilder localStringBuilder2 = new StringBuilder("other app: hash=");
        localStringBuilder2.append(paramLong);
        localStringBuilder2.append(", uin=");
        localStringBuilder2.append(((QQUser)localObject2).mUin);
        localStringBuilder2.append(", real=");
        localStringBuilder2.append(((QQUser)localObject2).mRealUin);
        localStringBuilder2.append(", bind=");
        localStringBuilder2.append(((QQUser)localObject2).mIsBinded);
        xj.c(localStringBuilder2.toString());
        if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == paramLong)) {
          break;
        }
        if ((!((QQUser)localObject2).mIsBinded) && (aao.f(((QQUser)localObject2).mRealUin) == paramLong))
        {
          ((xh)localObject1).a(10029, null, null);
          return localObject1;
        }
        i += 1;
      }
      if (i == ((th)localObject3).k.a())
      {
        ((xh)localObject1).a(110, null, null);
        return localObject1;
      }
    }
    long l = ((th)localObject3).c();
    if ((((th)localObject3).k.b() != null) && (l != 0L))
    {
      if (((th)localObject3).k.b().mIsBinded) {
        l = ((th)localObject3).k.b().mUin;
      }
      localObject3 = new CountDownLatch(1);
      localObject2 = new AtomicReference(null);
      rf.a().a(l, paramByte, new rf.a()
      {
        public final void a(ri paramAnonymousri)
        {
          this.a.set(paramAnonymousri);
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
      localObject2 = (ri)((AtomicReference)localObject2).get();
      if (localObject2 == null)
      {
        ((xh)localObject1).a(-799, null, null);
        return localObject1;
      }
      try
      {
        i = ((ri)localObject2).b;
        if (i != 0)
        {
          localObject2 = ((ri)localObject2).d;
          ((xh)localObject1).a(i, (String)localObject2, (String)localObject2);
          return localObject1;
        }
        localObject2 = ((ri)localObject2).c;
        if (localObject2 != null)
        {
          localObject2 = new JSONObject((String)localObject2).getJSONArray("msgs");
          if (!a((JSONArray)localObject2, paramLong))
          {
            localStringBuilder1 = new StringBuilder("update conf list failed:");
            localStringBuilder1.append(((JSONArray)localObject2).toString());
            ((xh)localObject1).a(10000, localStringBuilder1.toString(), null);
            return localObject1;
          }
          th.a().g();
          ((xh)localObject1).a = 0;
          return localObject1;
        }
        xj.c("parseJSON error decodeData");
        ((xh)localObject1).a(10022, RqdApplication.p().getString(2131493068), null);
        return localObject1;
      }
      catch (Exception localException)
      {
        localStringBuilder1 = new StringBuilder("unknown err: ");
        localStringBuilder1.append(localException.toString());
        xj.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localException.toString());
        ((xh)localObject1).a(10021, localStringBuilder1.toString(), null);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("parse json failed: ");
        localStringBuilder1.append(localJSONException.toString());
        xj.c(localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder("JSONException:");
        localStringBuilder1.append(localJSONException.toString());
        ((xh)localObject1).a(10020, localStringBuilder1.toString(), null);
        return localObject1;
      }
    }
    ((xh)localObject1).a(110, null, null);
    return localObject1;
  }
  
  private static long d()
  {
    Context localContext = RqdApplication.p();
    long l1 = 0L;
    try
    {
      long l2 = localContext.getSharedPreferences("dualmsgtime", 0).getLong("time", 0L);
      l1 = l2;
      xj.c("load mLastItemTime=".concat(String.valueOf(l2)));
      return l2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xj.c(localStringBuilder.toString());
    }
    return l1;
  }
  
  public final xh a(byte paramByte, long paramLong)
  {
    xh localxh2 = b(paramByte, paramLong);
    if (localxh2.b()) {
      return localxh2;
    }
    xh localxh1 = localxh2;
    if (localxh2.a == 104)
    {
      th.a().h();
      localxh1 = b(paramByte, paramLong);
    }
    return localxh1;
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
    xj.a(bool);
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          while (i < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(i);
            sm localsm = new sm();
            if (!localsm.a((JSONObject)localObject)) {
              xj.c("object item parse failed: ".concat(String.valueOf(i)));
            }
            localObject = new StringBuilder("server item time=");
            ((StringBuilder)localObject).append(localsm.e);
            xj.c(((StringBuilder)localObject).toString());
            if (this.c < localsm.e)
            {
              this.c = localsm.e;
              localObject = new StringBuilder("get mLastItemTime=");
              ((StringBuilder)localObject).append(this.c);
              xj.c(((StringBuilder)localObject).toString());
              localObject = RqdApplication.p();
              try
              {
                localObject = ((Context)localObject).getSharedPreferences("dualmsgtime", 0).edit();
                ((SharedPreferences.Editor)localObject).putLong("time", this.c);
                ((SharedPreferences.Editor)localObject).commit();
                localObject = new StringBuilder("save mLastItemTime=");
                ((StringBuilder)localObject).append(this.c);
                xj.c(((StringBuilder)localObject).toString());
              }
              catch (Exception localException)
              {
                StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
                localStringBuilder.append(localException.getMessage());
                xj.c(localStringBuilder.toString());
              }
            }
            if (paramLong == 0L) {
              this.b.add(localsm);
            } else if ((paramLong > 0L) && (paramLong == localsm.c)) {
              this.b.add(localsm);
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
 * Qualified Name:     com.tencent.token.tf
 * JD-Core Version:    0.7.0.1
 */