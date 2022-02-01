package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class tc
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public aam f = null;
  
  protected tc(String paramString)
  {
    this.f = new aam(paramString);
  }
  
  final wy a(byte paramByte)
  {
    final wy localwy = new wy();
    sz.a();
    final QQUser localQQUser = sz.a(localwy);
    if (localQQUser == null)
    {
      xa.a(localwy.b() ^ true);
      return localwy;
    }
    Object localObject = ry.a(RqdApplication.n()).a(localQQUser.mRealUin);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = aac.a((byte[])localObject);
    }
    qy.a().h();
    System.currentTimeMillis();
    long l = aad.a(2, localQQUser.mUin);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    qy.a().a(paramByte, 0, 2, localQQUser.mUin, (String)localObject, l, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        Object localObject = new wy();
        ((wy)localObject).a = paramAnonymousra.b;
        ((wy)localObject).c = paramAnonymousra.d;
        ((wy)localObject).b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            localObject = new JSONObject(paramAnonymousra.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != localQQUser.mUin)
            {
              paramAnonymousra = localwy;
              localObject = new StringBuilder("uin not match=");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append(localQQUser.mUin);
              paramAnonymousra.a(10000, ((StringBuilder)localObject).toString(), null);
              localCountDownLatch.countDown();
              return;
            }
            tc.this.f.e = l;
            paramAnonymousra = localwy;
            localObject = tc.this.f.a((JSONObject)localObject, l, this.d);
            paramAnonymousra.a = ((wy)localObject).a;
            paramAnonymousra.b = ((wy)localObject).b;
            paramAnonymousra.c = ((wy)localObject).c;
            paramAnonymousra.d = ((wy)localObject).d;
            paramAnonymousra.e = ((wy)localObject).e;
            sz.a().g();
          }
          catch (JSONException paramAnonymousra)
          {
            localObject = localwy;
            StringBuilder localStringBuilder = new StringBuilder("JSONException:");
            localStringBuilder.append(paramAnonymousra.toString());
            ((wy)localObject).a(10020, localStringBuilder.toString(), null);
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localwy;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localwy;
  }
  
  public final void a(long paramLong)
  {
    this.f.e = paramLong;
  }
  
  public final boolean c()
  {
    aam localaam = this.f;
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser != null) {
      return localQQUser.mUin == localaam.e;
    }
    return false;
  }
  
  public final void d()
  {
    this.f.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tc
 * JD-Core Version:    0.7.0.1
 */