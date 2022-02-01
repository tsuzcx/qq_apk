package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class tk
{
  public static byte c = 1;
  public static byte d = 2;
  public static byte e = 3;
  public aay f = null;
  
  protected tk(String paramString)
  {
    this.f = new aay(paramString);
  }
  
  final xh a(byte paramByte)
  {
    final xh localxh = new xh();
    th.a();
    final QQUser localQQUser = th.a(localxh);
    if (localQQUser == null)
    {
      xj.a(localxh.b() ^ true);
      return localxh;
    }
    Object localObject = sg.a(RqdApplication.p()).a(localQQUser.mRealUin);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = aao.a((byte[])localObject);
    }
    rf.a().h();
    System.currentTimeMillis();
    long l = aap.a(2, localQQUser.mUin);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    rf.a().a(paramByte, 0, 2, localQQUser.mUin, (String)localObject, l, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        Object localObject = new xh();
        ((xh)localObject).a = paramAnonymousri.b;
        ((xh)localObject).c = paramAnonymousri.d;
        ((xh)localObject).b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            localObject = new JSONObject(paramAnonymousri.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != localQQUser.mUin)
            {
              paramAnonymousri = localxh;
              localObject = new StringBuilder("uin not match=");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append(localQQUser.mUin);
              paramAnonymousri.a(10000, ((StringBuilder)localObject).toString(), null);
              localCountDownLatch.countDown();
              return;
            }
            tk.this.f.e = l;
            paramAnonymousri = localxh;
            localObject = tk.this.f.a((JSONObject)localObject, l, this.d);
            paramAnonymousri.a = ((xh)localObject).a;
            paramAnonymousri.b = ((xh)localObject).b;
            paramAnonymousri.c = ((xh)localObject).c;
            paramAnonymousri.d = ((xh)localObject).d;
            paramAnonymousri.e = ((xh)localObject).e;
            th.a().g();
          }
          catch (JSONException paramAnonymousri)
          {
            localObject = localxh;
            StringBuilder localStringBuilder = new StringBuilder("JSONException:");
            localStringBuilder.append(paramAnonymousri.toString());
            ((xh)localObject).a(10020, localStringBuilder.toString(), null);
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localxh;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localxh;
  }
  
  public final void a(long paramLong)
  {
    this.f.e = paramLong;
  }
  
  public final boolean c()
  {
    aay localaay = this.f;
    QQUser localQQUser = th.a().k.b();
    if (localQQUser != null) {
      return localQQUser.mUin == localaay.e;
    }
    return false;
  }
  
  public final void d()
  {
    this.f.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tk
 * JD-Core Version:    0.7.0.1
 */