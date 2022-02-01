package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class th
{
  public static int a = 0;
  private static int b = 1;
  
  public static wy a(aaq paramaaq, String paramString)
  {
    wy localwy = new wy();
    Object localObject2 = (Long)paramaaq.c.get("param.uinhash");
    if (localObject2 == null)
    {
      localwy.a(10000, null, null);
      return localwy;
    }
    try
    {
      Object localObject1 = sz.a();
      Object localObject3 = ((sz)localObject1).k.b();
      if ((localObject3 != null) && (((sz)localObject1).l == localObject3))
      {
        long l = System.currentTimeMillis() / 1000L;
        if (((sz)localObject1).m + ((sz)localObject1).n > l)
        {
          localObject1 = ((sz)localObject1).l;
          break label175;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
      localStringBuilder.append(((sz)localObject1).l);
      localStringBuilder.append(",current_user=");
      localStringBuilder.append(localObject3);
      xa.a(localStringBuilder.toString());
      ((sz)localObject1).l = null;
      ((sz)localObject1).m = 0L;
      ((sz)localObject1).n = 0L;
      localObject1 = null;
      label175:
      xa.c("login task: loginedUser".concat(String.valueOf(localObject1)));
      localObject3 = (Long)paramaaq.c.get("param.uin.wtlogin");
      if ((localObject1 != null) && ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin == ((Long)localObject2).longValue())) && ((((QQUser)localObject1).mIsBinded) || (localObject3 == null) || (((QQUser)localObject1).mRealUin == ((Long)localObject3).longValue())))
      {
        localObject2 = tg.a(paramString);
        if (localObject3 != null) {
          paramaaq.c.put("param.uinhash", Long.valueOf(((QQUser)localObject1).mUin));
        }
        if (localObject2 != null)
        {
          localObject1 = ((tj)localObject2).c(paramaaq);
          if (((wy)localObject1).b()) {
            return localObject1;
          }
          if ((((wy)localObject1).a != 109) && (((wy)localObject1).a != 104)) {
            return localObject1;
          }
          paramaaq = c(paramaaq, paramString);
          if (paramaaq.b())
          {
            rz.a();
            sz.a().g();
          }
          return paramaaq;
        }
        localwy.a(10000, null, null);
        return localwy;
      }
      paramaaq = c(paramaaq, paramString);
      if (paramaaq.b())
      {
        rz.a();
        sz.a().g();
      }
      return paramaaq;
    }
    finally {}
  }
  
  public static Callable<wy> a(aaq paramaaq)
  {
    new Callable() {};
  }
  
  private static wy b(aaq paramaaq, String paramString)
  {
    Object localObject1 = new wy();
    ??? = paramaaq.c.get("param.uin.wtlogin");
    if (??? == null)
    {
      ((wy)localObject1).a(10000, null, null);
      return localObject1;
    }
    String str = String.valueOf(((Long)???).longValue());
    b = 1;
    Object localObject3 = ry.a(RqdApplication.n());
    ??? = new StringBuilder("st sync account=");
    ((StringBuilder)???).append(str);
    ((StringBuilder)???).append(",appid=523005419");
    xa.a(((StringBuilder)???).toString());
    Object localObject4 = ry.a(RqdApplication.n());
    synchronized (ry.g)
    {
      if (!((ry)localObject4).a(str, 523005419L))
      {
        ((ry)localObject4).e = true;
        ((ry)localObject4).a(str, null, 523005419L);
        ry.g.wait();
        b = 1;
      }
      else
      {
        ((ry)localObject4).f.a(15, null, null);
      }
      ??? = ((ry)localObject3).f;
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((wy)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((wy)???).c);
      xa.a(((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((wy)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((wy)???).c);
      xa.a(((StringBuilder)localObject4).toString());
      if (!((wy)???).b())
      {
        paramString = ((wy)???).c;
        paramaaq = paramString;
        if (((wy)???).c.indexOf("(") == -1)
        {
          paramaaq = paramString;
          if (((wy)???).c.indexOf(")") == -1)
          {
            paramaaq = new StringBuilder();
            paramaaq.append(((wy)???).c);
            paramaaq.append("(");
            paramaaq.append(((ry)localObject3).f.a);
            paramaaq.append(")");
            paramaaq = paramaaq.toString();
          }
        }
        xa.c("wtlogin error for user: ".concat(String.valueOf(paramaaq)));
        if ((((wy)???).a != 15) && (((wy)???).a != 16) && (((wy)???).a != 1) && (((wy)???).a != 2))
        {
          if ((((wy)???).a != 40) && (((wy)???).a != 42) && (((wy)???).a != 64))
          {
            if (((wy)???).a == -1000)
            {
              paramString = new StringBuilder();
              paramString.append(paramaaq);
              paramString.append("(");
              paramString.append(((wy)???).a);
              paramString.append(")");
              paramString = paramString.toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramaaq);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(((wy)???).a);
              ((StringBuilder)localObject3).append(")");
              ((wy)localObject1).a(10003, paramString, ((StringBuilder)localObject3).toString());
              return localObject1;
            }
            paramString = new StringBuilder();
            paramString.append(paramaaq);
            paramString.append("(");
            paramString.append(((wy)???).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramaaq);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((wy)???).a);
            ((StringBuilder)localObject3).append(")");
            ((wy)localObject1).a(10028, paramString, ((StringBuilder)localObject3).toString());
            return localObject1;
          }
          ((wy)localObject1).a(((wy)???).a, paramaaq, paramaaq);
          ((wy)localObject1).d = ((wy)???).d;
          return localObject1;
        }
        ((wy)localObject1).a(10027, paramaaq, paramaaq);
        return localObject1;
      }
      localObject1 = (byte[])((wy)???).d;
      int i = b;
      paramaaq.c.put("param.uin.wtlogin", str);
      paramaaq.c.put("param.wtlogin.a2", localObject1);
      paramaaq.c.put("param.wtlogin.type", Integer.valueOf(i));
      localObject1 = tm.a(paramaaq, "mbtoken3_vfy_wtlogin");
      if (((wy)localObject1).b())
      {
        paramString = tg.a(paramString);
        if (paramString != null) {
          return paramString.c(paramaaq);
        }
        ((wy)localObject1).a(10000, null, null);
        return localObject1;
      }
      return localObject1;
    }
  }
  
  private static wy c(aaq paramaaq, String paramString)
  {
    new wy();
    if (paramaaq.c.get("param.uin.wtlogin") != null) {
      return b(paramaaq, paramString);
    }
    new wy();
    int i;
    if (paramaaq.m == 1)
    {
      paramaaq.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramaaq.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = tm.a(paramaaq, "mbtoken3_login_v2");
    if (((wy)localObject).b())
    {
      a = 0;
      paramString = tg.a(paramString);
      if (paramString != null)
      {
        if (i != -1)
        {
          paramaaq.m = 1;
          paramaaq.k = true;
        }
        return paramString.c(paramaaq);
      }
      ((wy)localObject).a(10000, null, null);
      return localObject;
    }
    if ((!((wy)localObject).b()) && (((wy)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + qy.a().g();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      xa.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = tg.a("mbtoken3_login_v2").c(paramaaq);
      if (((wy)localObject).b())
      {
        a = 0;
        paramString = tg.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramaaq.m = 1;
            paramaaq.k = true;
          }
          return paramString.c(paramaaq);
        }
        ((wy)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    if ((!((wy)localObject).b()) && (((wy)localObject).a == 112))
    {
      localObject = tg.a("mbtoken3_login_v2").c(paramaaq);
      if (((wy)localObject).b())
      {
        a = 0;
        paramString = tg.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramaaq.m = 1;
            paramaaq.k = true;
          }
          return paramString.c(paramaaq);
        }
        ((wy)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.th
 * JD-Core Version:    0.7.0.1
 */