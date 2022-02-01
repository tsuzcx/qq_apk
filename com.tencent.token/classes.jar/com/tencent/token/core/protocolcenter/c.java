package com.tencent.token.core.protocolcenter;

import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class c
{
  public static int a = 0;
  private static int b = 1;
  
  public static e a(do paramdo, String paramString)
  {
    Object localObject1 = new e();
    Object localObject2 = paramdo.c.get("param.uin.wtlogin");
    if (localObject2 == null) {
      ((e)localObject1).b(10000);
    }
    do
    {
      return localObject1;
      long l = ((Long)localObject2).longValue();
      String str = l + "";
      b = 1;
      bz localbz = bz.a(RqdApplication.l());
      a(str, 523005419L);
      localObject2 = localbz.b;
      com.tencent.token.global.g.a("wtlogin result=" + ((e)localObject2).a + ",errinfo=" + ((e)localObject2).c);
      com.tencent.token.global.g.a("wtlogin result=" + ((e)localObject2).a + ",errinfo=" + ((e)localObject2).c);
      if (!((e)localObject2).b())
      {
        paramString = ((e)localObject2).c;
        paramdo = paramString;
        if (((e)localObject2).c.indexOf("(") == -1)
        {
          paramdo = paramString;
          if (((e)localObject2).c.indexOf(")") == -1) {
            paramdo = ((e)localObject2).c + "(" + localbz.b.a + ")";
          }
        }
        com.tencent.token.global.g.c("wtlogin error for user: " + paramdo);
        if ((((e)localObject2).a == 15) || (((e)localObject2).a == 16) || (((e)localObject2).a == 1) || (((e)localObject2).a == 2)) {
          ((e)localObject1).a(10027, paramdo, paramdo);
        }
        for (;;)
        {
          return localObject1;
          if ((((e)localObject2).a == 40) || (((e)localObject2).a == 42) || (((e)localObject2).a == 64))
          {
            ((e)localObject1).a(((e)localObject2).a, paramdo, paramdo);
            ((e)localObject1).d = ((e)localObject2).d;
          }
          else if (((e)localObject2).a == -1000)
          {
            ((e)localObject1).a(10003, paramdo + "(" + ((e)localObject2).a + ")", paramdo + "(" + ((e)localObject2).a + ")");
          }
          else
          {
            ((e)localObject1).a(10028, paramdo + "(" + ((e)localObject2).a + ")", paramdo + "(" + ((e)localObject2).a + ")");
          }
        }
      }
      ProtoDoWtLogin.a(paramdo, str, (byte[])((e)localObject2).d, b);
      localObject2 = g.b(paramdo, "mbtoken3_vfy_wtlogin");
      localObject1 = localObject2;
    } while (!((e)localObject2).b());
    paramString = b.a(paramString);
    if (paramString != null) {
      return paramString.c(paramdo);
    }
    ((e)localObject2).b(10000);
    return localObject2;
  }
  
  public static Callable<e> a(do paramdo)
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
    bz localbz = bz.a(RqdApplication.l());
    synchronized (bz.c)
    {
      if (!localbz.b(paramString, paramLong))
      {
        localbz.a(true);
        localbz.a(paramString, null, paramLong);
        bz.c.wait();
        if (paramLong == 523005419L) {
          b = 1;
        }
        return;
      }
      localbz.b.b(15);
    }
  }
  
  public static e b(do paramdo, String paramString)
  {
    new e();
    if (paramdo.m == 1) {
      paramdo.m = 0;
    }
    for (int i = 1;; i = -1)
    {
      paramdo.c.put("param.loginv2.clearkick", Integer.valueOf(a));
      e locale2 = g.b(paramdo, "mbtoken3_login_v2");
      e locale1;
      if (locale2.b())
      {
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramdo.m = 1;
            paramdo.k = true;
          }
          locale1 = paramString.c(paramdo);
          return locale1;
        }
        locale2.b(10000);
        return locale2;
      }
      if ((!locale2.b()) && (locale2.a == 102))
      {
        long l1 = System.currentTimeMillis() + cc.c().q();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
        com.tencent.token.global.g.a("sleep " + l2 + "s for dyncode refresh:" + l1);
        Thread.sleep(l2 * 1000L);
        locale1 = b.a("mbtoken3_login_v2").c(paramdo);
        if (!locale1.b()) {
          break label356;
        }
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null) {
          if (i != -1)
          {
            paramdo.m = 1;
            paramdo.k = true;
          }
        }
      }
      label356:
      for (paramdo = paramString.c(paramdo);; paramdo = locale1)
      {
        return paramdo;
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
        locale1 = b.a("mbtoken3_login_v2").c(paramdo);
        if (locale1.b())
        {
          a = 0;
          paramString = b.a(paramString);
          if (paramString != null) {
            if (i != -1)
            {
              paramdo.m = 1;
              paramdo.k = true;
            }
          }
        }
        for (paramdo = paramString.c(paramdo);; paramdo = locale1)
        {
          return paramdo;
          locale1.b(10000);
          return locale1;
        }
      }
    }
  }
  
  public static e c(do paramdo, String paramString)
  {
    new e();
    if (paramdo.c.get("param.uin.wtlogin") != null) {
      return a(paramdo, paramString);
    }
    return b(paramdo, paramString);
  }
  
  public static e d(do paramdo, String paramString)
  {
    e locale = new e();
    Object localObject = (Long)paramdo.c.get("param.uinhash");
    if (localObject == null)
    {
      locale.b(10000);
      return locale;
    }
    QQUser localQQUser;
    Long localLong;
    try
    {
      localQQUser = cr.a().l();
      com.tencent.token.global.g.c("login task: loginedUser" + localQQUser);
      localLong = (Long)paramdo.c.get("param.uin.wtlogin");
      if ((localQQUser == null) || ((localQQUser.mIsBinded) && (localQQUser.mUin != ((Long)localObject).longValue())) || ((!localQQUser.mIsBinded) && (localLong != null) && (localQQUser.mRealUin != localLong.longValue())))
      {
        paramdo = c(paramdo, paramString);
        if (paramdo.b()) {
          ca.a().c();
        }
        return paramdo;
      }
    }
    finally {}
    localObject = b.a(paramString);
    if (localLong != null) {
      paramdo.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
    }
    if (localObject != null)
    {
      locale = ((d)localObject).c(paramdo);
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
      paramdo = c(paramdo, paramString);
      if (paramdo.b()) {
        ca.a().c();
      }
      return paramdo;
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.c
 * JD-Core Version:    0.7.0.1
 */