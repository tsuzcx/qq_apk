package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class td
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public aan f = null;
  
  protected td(String paramString)
  {
    this.f = new aan(paramString);
  }
  
  final wz a(byte paramByte)
  {
    final wz localwz = new wz();
    ta.a();
    final QQUser localQQUser = ta.a(localwz);
    if (localQQUser == null)
    {
      xb.a(localwz.b() ^ true);
      return localwz;
    }
    Object localObject = rz.a(RqdApplication.n()).a(localQQUser.mRealUin);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = aad.a((byte[])localObject);
    }
    qz.a().h();
    System.currentTimeMillis();
    long l = aae.a(2, localQQUser.mUin);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    qz.a().a(paramByte, 0, 2, localQQUser.mUin, (String)localObject, l, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        Object localObject = new wz();
        ((wz)localObject).a = paramAnonymousrb.b;
        ((wz)localObject).c = paramAnonymousrb.d;
        ((wz)localObject).b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0) {
          try
          {
            localObject = new JSONObject(paramAnonymousrb.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != localQQUser.mUin)
            {
              paramAnonymousrb = localwz;
              localObject = new StringBuilder("uin not match=");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append(localQQUser.mUin);
              paramAnonymousrb.a(10000, ((StringBuilder)localObject).toString(), null);
              localCountDownLatch.countDown();
              return;
            }
            td.this.f.e = l;
            paramAnonymousrb = localwz;
            localObject = td.this.f.a((JSONObject)localObject, l, this.d);
            paramAnonymousrb.a = ((wz)localObject).a;
            paramAnonymousrb.b = ((wz)localObject).b;
            paramAnonymousrb.c = ((wz)localObject).c;
            paramAnonymousrb.d = ((wz)localObject).d;
            paramAnonymousrb.e = ((wz)localObject).e;
            ta.a().g();
          }
          catch (JSONException paramAnonymousrb)
          {
            localObject = localwz;
            StringBuilder localStringBuilder = new StringBuilder("JSONException:");
            localStringBuilder.append(paramAnonymousrb.toString());
            ((wz)localObject).a(10020, localStringBuilder.toString(), null);
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localwz;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localwz;
  }
  
  public final void a(long paramLong)
  {
    this.f.e = paramLong;
  }
  
  public final boolean c()
  {
    aan localaan = this.f;
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser != null) {
      return localQQUser.mUin == localaan.e;
    }
    return false;
  }
  
  public final void d()
  {
    this.f.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.td
 * JD-Core Version:    0.7.0.1
 */