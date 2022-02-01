package com.tencent.token.core.protocolcenter;

import com.tencent.token.by;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class c
{
  public static int a = 0;
  private static int b = 1;
  
  public static e a(dn paramdn, String paramString)
  {
    Object localObject1 = new e();
    Object localObject2 = paramdn.c.get("param.uin.wtlogin");
    if (localObject2 == null) {
      ((e)localObject1).b(10000);
    }
    do
    {
      return localObject1;
      long l = ((Long)localObject2).longValue();
      String str = l + "";
      b = 1;
      by localby = by.a(RqdApplication.l());
      a(str, 523005419L);
      localObject2 = localby.b;
      com.tencent.token.global.g.a("wtlogin result=" + ((e)localObject2).a + ",errinfo=" + ((e)localObject2).c);
      com.tencent.token.global.g.a("wtlogin result=" + ((e)localObject2).a + ",errinfo=" + ((e)localObject2).c);
      if (!((e)localObject2).b())
      {
        paramString = ((e)localObject2).c;
        paramdn = paramString;
        if (((e)localObject2).c.indexOf("(") == -1)
        {
          paramdn = paramString;
          if (((e)localObject2).c.indexOf(")") == -1) {
            paramdn = ((e)localObject2).c + "(" + localby.b.a + ")";
          }
        }
        com.tencent.token.global.g.c("wtlogin error for user: " + paramdn);
        if ((((e)localObject2).a == 15) || (((e)localObject2).a == 16) || (((e)localObject2).a == 1) || (((e)localObject2).a == 2)) {
          ((e)localObject1).a(10027, paramdn, paramdn);
        }
        for (;;)
        {
          return localObject1;
          if ((((e)localObject2).a == 40) || (((e)localObject2).a == 42) || (((e)localObject2).a == 64))
          {
            ((e)localObject1).a(((e)localObject2).a, paramdn, paramdn);
            ((e)localObject1).d = ((e)localObject2).d;
          }
          else if (((e)localObject2).a == -1000)
          {
            ((e)localObject1).a(10003, paramdn + "(" + ((e)localObject2).a + ")", paramdn + "(" + ((e)localObject2).a + ")");
          }
          else
          {
            ((e)localObject1).a(10028, paramdn + "(" + ((e)localObject2).a + ")", paramdn + "(" + ((e)localObject2).a + ")");
          }
        }
      }
      ProtoDoWtLogin.a(paramdn, str, (byte[])((e)localObject2).d, b);
      localObject2 = g.b(paramdn, "mbtoken3_vfy_wtlogin");
      localObject1 = localObject2;
    } while (!((e)localObject2).b());
    paramString = b.a(paramString);
    if (paramString != null) {
      return paramString.c(paramdn);
    }
    ((e)localObject2).b(10000);
    return localObject2;
  }
  
  public static Callable<e> a(dn paramdn)
  {
    new Callable()
    {
      public e a()
      {
        e locale = c.d(this.a, this.a.a);
        this.a.l.a(this.a, locale);
        return locale;
      }
    };
  }
  
  private static void a(String paramString, long paramLong)
  {
    com.tencent.token.global.g.a("st sync account=" + paramString + ",appid=" + paramLong);
    by localby = by.a(RqdApplication.l());
    synchronized (by.c)
    {
      if (!localby.b(paramString, paramLong))
      {
        localby.a(true);
        localby.a(paramString, null, paramLong);
        by.c.wait();
        if (paramLong == 523005419L) {
          b = 1;
        }
        return;
      }
      localby.b.b(15);
    }
  }
  
  public static e b(dn paramdn, String paramString)
  {
    new e();
    if (paramdn.m == 1) {
      paramdn.m = 0;
    }
    for (int i = 1;; i = -1)
    {
      paramdn.c.put("param.loginv2.clearkick", Integer.valueOf(a));
      e locale2 = g.b(paramdn, "mbtoken3_login_v2");
      e locale1;
      if (locale2.b())
      {
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramdn.m = 1;
            paramdn.k = true;
          }
          locale1 = paramString.c(paramdn);
          return locale1;
        }
        locale2.b(10000);
        return locale2;
      }
      if ((!locale2.b()) && (locale2.a == 102))
      {
        long l1 = System.currentTimeMillis() + cb.c().q();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
        com.tencent.token.global.g.a("sleep " + l2 + "s for dyncode refresh:" + l1);
        Thread.sleep(l2 * 1000L);
        locale1 = b.a("mbtoken3_login_v2").c(paramdn);
        if (!locale1.b()) {
          break label356;
        }
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null) {
          if (i != -1)
          {
            paramdn.m = 1;
            paramdn.k = true;
          }
        }
      }
      label356:
      for (paramdn = paramString.c(paramdn);; paramdn = locale1)
      {
        return paramdn;
        locale1.b(10000);
        return locale1;
        locale1 = locale2;
        if (locale2.b()) {
          break;
        }
        locale1 = locale2;
        if (locale2.a != 112) {
          break;
        }
        locale1 = b.a("mbtoken3_login_v2").c(paramdn);
        if (locale1.b())
        {
          a = 0;
          paramString = b.a(paramString);
          if (paramString != null) {
            if (i != -1)
            {
              paramdn.m = 1;
              paramdn.k = true;
            }
          }
        }
        for (paramdn = paramString.c(paramdn);; paramdn = locale1)
        {
          return paramdn;
          locale1.b(10000);
          return locale1;
        }
      }
    }
  }
  
  public static e c(dn paramdn, String paramString)
  {
    new e();
    if (paramdn.c.get("param.uin.wtlogin") != null) {
      return a(paramdn, paramString);
    }
    return b(paramdn, paramString);
  }
  
  public static e d(dn paramdn, String paramString)
  {
    e locale = new e();
    Object localObject = (Long)paramdn.c.get("param.uinhash");
    if (localObject == null)
    {
      locale.b(10000);
      return locale;
    }
    QQUser localQQUser;
    Long localLong;
    try
    {
      localQQUser = cq.a().l();
      com.tencent.token.global.g.c("login task: loginedUser" + localQQUser);
      localLong = (Long)paramdn.c.get("param.uin.wtlogin");
      if ((localQQUser == null) || ((localQQUser.mIsBinded) && (localQQUser.mUin != ((Long)localObject).longValue())) || ((!localQQUser.mIsBinded) && (localLong != null) && (localQQUser.mRealUin != localLong.longValue())))
      {
        paramdn = c(paramdn, paramString);
        if (paramdn.b()) {
          bz.a().c();
        }
        return paramdn;
      }
    }
    finally {}
    localObject = b.a(paramString);
    if (localLong != null) {
      paramdn.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
    }
    if (localObject != null)
    {
      locale = ((d)localObject).c(paramdn);
      if (locale.b()) {
        return locale;
      }
    }
    else
    {
      locale.b(10000);
      return locale;
    }
    if ((locale.a == 109) || (locale.a == 104))
    {
      paramdn = c(paramdn, paramString);
      if (paramdn.b()) {
        bz.a().c();
      }
      return paramdn;
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.c
 * JD-Core Version:    0.7.0.1
 */