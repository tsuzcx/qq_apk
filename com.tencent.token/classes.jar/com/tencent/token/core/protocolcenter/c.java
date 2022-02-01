package com.tencent.token.core.protocolcenter;

import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.cs;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class c
{
  public static int a = 0;
  private static int b = 1;
  
  public static e a(dp paramdp, String paramString)
  {
    e locale = new e();
    Object localObject1 = paramdp.c.get("param.uin.wtlogin");
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
    Object localObject2 = ca.a(RqdApplication.n());
    a(str, 523005419L);
    localObject1 = ((ca)localObject2).b;
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
      paramdp = paramString;
      if (((e)localObject1).c.indexOf("(") == -1)
      {
        paramdp = paramString;
        if (((e)localObject1).c.indexOf(")") == -1)
        {
          paramdp = new StringBuilder();
          paramdp.append(((e)localObject1).c);
          paramdp.append("(");
          paramdp.append(((ca)localObject2).b.a);
          paramdp.append(")");
          paramdp = paramdp.toString();
        }
      }
      paramString = new StringBuilder();
      paramString.append("wtlogin error for user: ");
      paramString.append(paramdp);
      com.tencent.token.global.g.c(paramString.toString());
      if ((((e)localObject1).a != 15) && (((e)localObject1).a != 16) && (((e)localObject1).a != 1) && (((e)localObject1).a != 2))
      {
        if ((((e)localObject1).a != 40) && (((e)localObject1).a != 42) && (((e)localObject1).a != 64))
        {
          if (((e)localObject1).a == -1000)
          {
            paramString = new StringBuilder();
            paramString.append(paramdp);
            paramString.append("(");
            paramString.append(((e)localObject1).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramdp);
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(((e)localObject1).a);
            ((StringBuilder)localObject2).append(")");
            locale.a(10003, paramString, ((StringBuilder)localObject2).toString());
            return locale;
          }
          paramString = new StringBuilder();
          paramString.append(paramdp);
          paramString.append("(");
          paramString.append(((e)localObject1).a);
          paramString.append(")");
          paramString = paramString.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramdp);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(((e)localObject1).a);
          ((StringBuilder)localObject2).append(")");
          locale.a(10028, paramString, ((StringBuilder)localObject2).toString());
          return locale;
        }
        locale.a(((e)localObject1).a, paramdp, paramdp);
        locale.d = ((e)localObject1).d;
        return locale;
      }
      locale.a(10027, paramdp, paramdp);
      return locale;
    }
    ProtoDoWtLogin.a(paramdp, str, (byte[])((e)localObject1).d, b);
    locale = g.b(paramdp, "mbtoken3_vfy_wtlogin");
    if (locale.b())
    {
      paramString = b.a(paramString);
      if (paramString != null) {
        return paramString.c(paramdp);
      }
      locale.b(10000);
      return locale;
    }
    return locale;
  }
  
  public static Callable<e> a(dp paramdp)
  {
    new Callable()
    {
      public e a()
      {
        Object localObject = this.a;
        localObject = c.d((dp)localObject, ((dp)localObject).a);
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
    ca localca = ca.a(RqdApplication.n());
    synchronized (ca.c)
    {
      if (!localca.b(paramString, paramLong))
      {
        localca.a(true);
        localca.a(paramString, null, paramLong);
        ca.c.wait();
        if (paramLong == 523005419L) {
          b = 1;
        }
      }
      else
      {
        localca.b.b(15);
      }
      return;
    }
  }
  
  public static e b(dp paramdp, String paramString)
  {
    new e();
    int i;
    if (paramdp.m == 1)
    {
      paramdp.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramdp.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = g.b(paramdp, "mbtoken3_login_v2");
    if (((e)localObject).b())
    {
      a = 0;
      paramString = b.a(paramString);
      if (paramString != null)
      {
        if (i != -1)
        {
          paramdp.m = 1;
          paramdp.k = true;
        }
        return paramString.c(paramdp);
      }
      ((e)localObject).b(10000);
      return localObject;
    }
    if ((!((e)localObject).b()) && (((e)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + cd.c().q();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      com.tencent.token.global.g.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = b.a("mbtoken3_login_v2").c(paramdp);
      if (((e)localObject).b())
      {
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramdp.m = 1;
            paramdp.k = true;
          }
          return paramString.c(paramdp);
        }
        ((e)localObject).b(10000);
        return localObject;
      }
      return localObject;
    }
    if ((!((e)localObject).b()) && (((e)localObject).a == 112))
    {
      localObject = b.a("mbtoken3_login_v2").c(paramdp);
      if (((e)localObject).b())
      {
        a = 0;
        paramString = b.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramdp.m = 1;
            paramdp.k = true;
          }
          return paramString.c(paramdp);
        }
        ((e)localObject).b(10000);
        return localObject;
      }
      return localObject;
    }
    return localObject;
  }
  
  public static e c(dp paramdp, String paramString)
  {
    new e();
    if (paramdp.c.get("param.uin.wtlogin") != null) {
      return a(paramdp, paramString);
    }
    return b(paramdp, paramString);
  }
  
  public static e d(dp paramdp, String paramString)
  {
    e locale = new e();
    Object localObject1 = (Long)paramdp.c.get("param.uinhash");
    if (localObject1 == null)
    {
      locale.b(10000);
      return locale;
    }
    try
    {
      QQUser localQQUser = cs.a().l();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("login task: loginedUser");
      ((StringBuilder)localObject2).append(localQQUser);
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
      localObject2 = (Long)paramdp.c.get("param.uin.wtlogin");
      if ((localQQUser != null) && ((!localQQUser.mIsBinded) || (localQQUser.mUin == ((Long)localObject1).longValue())) && ((localQQUser.mIsBinded) || (localObject2 == null) || (localQQUser.mRealUin == ((Long)localObject2).longValue())))
      {
        localObject1 = b.a(paramString);
        if (localObject2 != null) {
          paramdp.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
        }
        if (localObject1 != null)
        {
          locale = ((d)localObject1).c(paramdp);
          if (locale.b()) {
            return locale;
          }
          if ((locale.a != 109) && (locale.a != 104)) {
            return locale;
          }
          paramdp = c(paramdp, paramString);
          if (paramdp.b()) {
            cb.a().c();
          }
          return paramdp;
        }
        locale.b(10000);
        return locale;
      }
      paramdp = c(paramdp, paramString);
      if (paramdp.b()) {
        cb.a().c();
      }
      return paramdp;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.c
 * JD-Core Version:    0.7.0.1
 */