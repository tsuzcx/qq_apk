package com.tencent.token.core.protocolcenter;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.cp;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class c
{
  public static int a = 0;
  private static int b = 1;
  
  public static f a(ev paramev, String paramString)
  {
    Object localObject1 = new f();
    Object localObject2 = paramev.c.get("param.uin.wtlogin");
    if (localObject2 == null) {
      ((f)localObject1).b(10000);
    }
    do
    {
      return localObject1;
      long l = ((Long)localObject2).longValue();
      String str = l + "";
      b = 1;
      cp localcp = cp.a(RqdApplication.l());
      a(str, 523005419L);
      localObject2 = localcp.b;
      h.a("wtlogin result=" + ((f)localObject2).a + ",errinfo=" + ((f)localObject2).c);
      h.a("wtlogin result=" + ((f)localObject2).a + ",errinfo=" + ((f)localObject2).c);
      if (!((f)localObject2).b())
      {
        paramString = ((f)localObject2).c;
        paramev = paramString;
        if (((f)localObject2).c.indexOf("(") == -1)
        {
          paramev = paramString;
          if (((f)localObject2).c.indexOf(")") == -1) {
            paramev = ((f)localObject2).c + "(" + localcp.b.a + ")";
          }
        }
        h.c("wtlogin error for user: " + paramev);
        if ((((f)localObject2).a == 15) || (((f)localObject2).a == 16) || (((f)localObject2).a == 1) || (((f)localObject2).a == 2)) {
          ((f)localObject1).a(10027, paramev, paramev);
        }
        for (;;)
        {
          return localObject1;
          if ((((f)localObject2).a == 40) || (((f)localObject2).a == 42) || (((f)localObject2).a == 64))
          {
            ((f)localObject1).a(((f)localObject2).a, paramev, paramev);
            ((f)localObject1).d = ((f)localObject2).d;
          }
          else if (((f)localObject2).a == -1000)
          {
            ((f)localObject1).a(10003, paramev + "(" + ((f)localObject2).a + ")", paramev + "(" + ((f)localObject2).a + ")");
          }
          else
          {
            ((f)localObject1).a(10028, paramev + "(" + ((f)localObject2).a + ")", paramev + "(" + ((f)localObject2).a + ")");
          }
        }
      }
      ProtoDoWtLogin.a(paramev, str, (byte[])((f)localObject2).d, b);
      localObject2 = o.b(paramev, "mbtoken3_vfy_wtlogin");
      localObject1 = localObject2;
    } while (!((f)localObject2).b());
    paramString = b.a(paramString);
    if (paramString != null) {
      return paramString.c(paramev);
    }
    ((f)localObject2).b(10000);
    return localObject2;
  }
  
  public static Callable a(ev paramev)
  {
    return new d(paramev);
  }
  
  private static void a(String paramString, long paramLong)
  {
    h.a("st sync account=" + paramString + ",appid=" + paramLong);
    cp localcp = cp.a(RqdApplication.l());
    synchronized (cp.c)
    {
      if (!localcp.b(paramString, paramLong))
      {
        localcp.a(true);
        localcp.a(paramString, null, paramLong);
        cp.c.wait();
        if (paramLong == 523005419L) {
          b = 1;
        }
        return;
      }
      localcp.b.b(15);
    }
  }
  
  public static f b(ev paramev, String paramString)
  {
    new f();
    if (paramev.m == 1) {
      paramev.m = 0;
    }
    for (int i = 1;; i = -1)
    {
      paramev.c.put("param.loginv2.clearkick", Integer.valueOf(a));
      f localf2 = o.b(paramev, "mbtoken3_login_v2");
      f localf1;
      if (localf2.b())
      {
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramev.m = 1;
            paramev.k = true;
          }
          localf1 = paramString.c(paramev);
          return localf1;
        }
        localf2.b(10000);
        return localf2;
      }
      if ((!localf2.b()) && (localf2.a == 102))
      {
        long l1 = System.currentTimeMillis() + cx.c().q();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
        h.a("sleep " + l2 + "s for dyncode refresh:" + l1);
        Thread.sleep(l2 * 1000L);
        localf1 = b.a("mbtoken3_login_v2").c(paramev);
        if (!localf1.b()) {
          break label356;
        }
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null) {
          if (i != -1)
          {
            paramev.m = 1;
            paramev.k = true;
          }
        }
      }
      label356:
      for (paramev = paramString.c(paramev);; paramev = localf1)
      {
        return paramev;
        localf1.b(10000);
        return localf1;
        localf1 = localf2;
        if (localf2.b()) {
          break;
        }
        localf1 = localf2;
        if (localf2.a != 112) {
          break;
        }
        localf1 = b.a("mbtoken3_login_v2").c(paramev);
        if (localf1.b())
        {
          a = 0;
          paramString = b.a(paramString);
          if (paramString != null) {
            if (i != -1)
            {
              paramev.m = 1;
              paramev.k = true;
            }
          }
        }
        for (paramev = paramString.c(paramev);; paramev = localf1)
        {
          return paramev;
          localf1.b(10000);
          return localf1;
        }
      }
    }
  }
  
  public static f c(ev paramev, String paramString)
  {
    new f();
    if (paramev.c.get("param.uin.wtlogin") != null) {
      return a(paramev, paramString);
    }
    return b(paramev, paramString);
  }
  
  public static f d(ev paramev, String paramString)
  {
    f localf = new f();
    Object localObject = (Long)paramev.c.get("param.uinhash");
    if (localObject == null)
    {
      localf.b(10000);
      return localf;
    }
    QQUser localQQUser;
    Long localLong;
    try
    {
      localQQUser = do.a().l();
      h.c("login task: loginedUser" + localQQUser);
      localLong = (Long)paramev.c.get("param.uin.wtlogin");
      if ((localQQUser == null) || ((localQQUser.mIsBinded) && (localQQUser.mUin != ((Long)localObject).longValue())) || ((!localQQUser.mIsBinded) && (localLong != null) && (localQQUser.mRealUin != localLong.longValue())))
      {
        paramev = c(paramev, paramString);
        if (paramev.b()) {
          cv.a().c();
        }
        return paramev;
      }
    }
    finally {}
    localObject = b.a(paramString);
    if (localLong != null) {
      paramev.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
    }
    if (localObject != null)
    {
      localf = ((e)localObject).c(paramev);
      if (localf.b()) {
        return localf;
      }
    }
    else
    {
      localf.b(10000);
      return localf;
    }
    if ((localf.a == 109) || (localf.a == 104))
    {
      paramev = c(paramev, paramString);
      if (paramev.b()) {
        cv.a().c();
      }
      return paramev;
    }
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.c
 * JD-Core Version:    0.7.0.1
 */