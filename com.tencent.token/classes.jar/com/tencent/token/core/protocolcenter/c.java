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
    e locale = new e();
    Object localObject1 = paramdo.c.get("param.uin.wtlogin");
    if (localObject1 == null)
    {
      locale.b(10000);
      return locale;
    }
    long l = ((Long)localObject1).longValue();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("");
    String str = ((StringBuilder)localObject1).toString();
    b = 1;
    Object localObject2 = bz.a(RqdApplication.l());
    a(str, 523005419L);
    localObject1 = ((bz)localObject2).b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wtlogin result=");
    localStringBuilder.append(((e)localObject1).a);
    localStringBuilder.append(",errinfo=");
    localStringBuilder.append(((e)localObject1).c);
    com.tencent.token.global.g.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("wtlogin result=");
    localStringBuilder.append(((e)localObject1).a);
    localStringBuilder.append(",errinfo=");
    localStringBuilder.append(((e)localObject1).c);
    com.tencent.token.global.g.a(localStringBuilder.toString());
    if (!((e)localObject1).b())
    {
      paramString = ((e)localObject1).c;
      paramdo = paramString;
      if (((e)localObject1).c.indexOf("(") == -1)
      {
        paramdo = paramString;
        if (((e)localObject1).c.indexOf(")") == -1)
        {
          paramdo = new StringBuilder();
          paramdo.append(((e)localObject1).c);
          paramdo.append("(");
          paramdo.append(((bz)localObject2).b.a);
          paramdo.append(")");
          paramdo = paramdo.toString();
        }
      }
      paramString = new StringBuilder();
      paramString.append("wtlogin error for user: ");
      paramString.append(paramdo);
      com.tencent.token.global.g.c(paramString.toString());
      if ((((e)localObject1).a != 15) && (((e)localObject1).a != 16) && (((e)localObject1).a != 1) && (((e)localObject1).a != 2))
      {
        if ((((e)localObject1).a != 40) && (((e)localObject1).a != 42) && (((e)localObject1).a != 64))
        {
          if (((e)localObject1).a == -1000)
          {
            paramString = new StringBuilder();
            paramString.append(paramdo);
            paramString.append("(");
            paramString.append(((e)localObject1).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramdo);
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(((e)localObject1).a);
            ((StringBuilder)localObject2).append(")");
            locale.a(10003, paramString, ((StringBuilder)localObject2).toString());
            return locale;
          }
          paramString = new StringBuilder();
          paramString.append(paramdo);
          paramString.append("(");
          paramString.append(((e)localObject1).a);
          paramString.append(")");
          paramString = paramString.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramdo);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(((e)localObject1).a);
          ((StringBuilder)localObject2).append(")");
          locale.a(10028, paramString, ((StringBuilder)localObject2).toString());
          return locale;
        }
        locale.a(((e)localObject1).a, paramdo, paramdo);
        locale.d = ((e)localObject1).d;
        return locale;
      }
      locale.a(10027, paramdo, paramdo);
      return locale;
    }
    ProtoDoWtLogin.a(paramdo, str, (byte[])((e)localObject1).d, b);
    locale = g.b(paramdo, "mbtoken3_vfy_wtlogin");
    if (locale.b())
    {
      paramString = b.a(paramString);
      if (paramString != null) {
        return paramString.c(paramdo);
      }
      locale.b(10000);
      return locale;
    }
    return locale;
  }
  
  public static Callable<e> a(do paramdo)
  {
    new Callable()
    {
      public e a()
      {
        Object localObject = this.a;
        localObject = c.d((do)localObject, ((do)localObject).a);
        this.a.l.a(this.a, (e)localObject);
        return localObject;
      }
    };
  }
  
  private static void a(String paramString, long paramLong)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("st sync account=");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append(",appid=");
    ((StringBuilder)???).append(paramLong);
    com.tencent.token.global.g.a(((StringBuilder)???).toString());
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
      }
      else
      {
        localbz.b.b(15);
      }
      return;
    }
  }
  
  public static e b(do paramdo, String paramString)
  {
    new e();
    int i;
    if (paramdo.m == 1)
    {
      paramdo.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramdo.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = g.b(paramdo, "mbtoken3_login_v2");
    if (((e)localObject).b())
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
        return paramString.c(paramdo);
      }
      ((e)localObject).b(10000);
      return localObject;
    }
    if ((!((e)localObject).b()) && (((e)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + cc.c().q();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      com.tencent.token.global.g.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = b.a("mbtoken3_login_v2").c(paramdo);
      if (((e)localObject).b())
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
          return paramString.c(paramdo);
        }
        ((e)localObject).b(10000);
        return localObject;
      }
      return localObject;
    }
    if ((!((e)localObject).b()) && (((e)localObject).a == 112))
    {
      localObject = b.a("mbtoken3_login_v2").c(paramdo);
      if (((e)localObject).b())
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
          return paramString.c(paramdo);
        }
        ((e)localObject).b(10000);
        return localObject;
      }
      return localObject;
    }
    return localObject;
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
    Object localObject1 = (Long)paramdo.c.get("param.uinhash");
    if (localObject1 == null)
    {
      locale.b(10000);
      return locale;
    }
    try
    {
      QQUser localQQUser = cr.a().l();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("login task: loginedUser");
      ((StringBuilder)localObject2).append(localQQUser);
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
      localObject2 = (Long)paramdo.c.get("param.uin.wtlogin");
      if ((localQQUser != null) && ((!localQQUser.mIsBinded) || (localQQUser.mUin == ((Long)localObject1).longValue())) && ((localQQUser.mIsBinded) || (localObject2 == null) || (localQQUser.mRealUin == ((Long)localObject2).longValue())))
      {
        localObject1 = b.a(paramString);
        if (localObject2 != null) {
          paramdo.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
        }
        if (localObject1 != null)
        {
          locale = ((d)localObject1).c(paramdo);
          if (locale.b()) {
            return locale;
          }
          if ((locale.a != 109) && (locale.a != 104)) {
            return locale;
          }
          paramdo = c(paramdo, paramString);
          if (paramdo.b()) {
            ca.a().c();
          }
          return paramdo;
        }
        locale.b(10000);
        return locale;
      }
      paramdo = c(paramdo, paramString);
      if (paramdo.b()) {
        ca.a().c();
      }
      return paramdo;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.c
 * JD-Core Version:    0.7.0.1
 */