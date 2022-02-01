package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class tw
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public abi f = null;
  
  protected tw(String paramString)
  {
    this.f = new abi(paramString);
  }
  
  final xt a(byte paramByte)
  {
    final xt localxt = new xt();
    tt.a();
    final QQUser localQQUser = tt.a(localxt);
    if (localQQUser == null)
    {
      xv.a(localxt.b() ^ true);
      return localxt;
    }
    Object localObject = ss.a(RqdApplication.n()).a(localQQUser.mRealUin);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = aay.a((byte[])localObject);
    }
    rt.a().h();
    System.currentTimeMillis();
    long l = aaz.a(2, localQQUser.mUin);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    rt.a().a(paramByte, 0, 2, localQQUser.mUin, (String)localObject, l, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        Object localObject = new xt();
        ((xt)localObject).a = paramAnonymousrv.b;
        ((xt)localObject).c = paramAnonymousrv.d;
        ((xt)localObject).b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0) {
          try
          {
            localObject = new JSONObject(paramAnonymousrv.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != localQQUser.mUin)
            {
              paramAnonymousrv = localxt;
              localObject = new StringBuilder("uin not match=");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append(localQQUser.mUin);
              paramAnonymousrv.a(10000, ((StringBuilder)localObject).toString(), null);
              localCountDownLatch.countDown();
              return;
            }
            tw.this.f.e = l;
            paramAnonymousrv = localxt;
            localObject = tw.this.f.a((JSONObject)localObject, l, this.d);
            paramAnonymousrv.a = ((xt)localObject).a;
            paramAnonymousrv.b = ((xt)localObject).b;
            paramAnonymousrv.c = ((xt)localObject).c;
            paramAnonymousrv.d = ((xt)localObject).d;
            paramAnonymousrv.e = ((xt)localObject).e;
            tt.a().g();
          }
          catch (JSONException paramAnonymousrv)
          {
            localObject = localxt;
            StringBuilder localStringBuilder = new StringBuilder("JSONException:");
            localStringBuilder.append(paramAnonymousrv.toString());
            ((xt)localObject).a(10020, localStringBuilder.toString(), null);
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localxt;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localxt;
  }
  
  public final void a(long paramLong)
  {
    this.f.e = paramLong;
  }
  
  public final boolean c()
  {
    abi localabi = this.f;
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser != null) {
      return localQQUser.mUin == localabi.e;
    }
    return false;
  }
  
  public final void d()
  {
    this.f.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tw
 * JD-Core Version:    0.7.0.1
 */