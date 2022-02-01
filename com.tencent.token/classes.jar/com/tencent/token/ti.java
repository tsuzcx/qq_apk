package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class ti
{
  public static int a = 0;
  private static int b = 1;
  
  public static wz a(aar paramaar, String paramString)
  {
    wz localwz = new wz();
    Object localObject2 = (Long)paramaar.c.get("param.uinhash");
    if (localObject2 == null)
    {
      localwz.a(10000, null, null);
      return localwz;
    }
    try
    {
      Object localObject1 = ta.a();
      Object localObject3 = ((ta)localObject1).k.b();
      if ((localObject3 != null) && (((ta)localObject1).l == localObject3))
      {
        long l = System.currentTimeMillis() / 1000L;
        if (((ta)localObject1).m + ((ta)localObject1).n > l)
        {
          localObject1 = ((ta)localObject1).l;
          break label175;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
      localStringBuilder.append(((ta)localObject1).l);
      localStringBuilder.append(",current_user=");
      localStringBuilder.append(localObject3);
      xb.a(localStringBuilder.toString());
      ((ta)localObject1).l = null;
      ((ta)localObject1).m = 0L;
      ((ta)localObject1).n = 0L;
      localObject1 = null;
      label175:
      xb.c("login task: loginedUser".concat(String.valueOf(localObject1)));
      localObject3 = (Long)paramaar.c.get("param.uin.wtlogin");
      if ((localObject1 != null) && ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin == ((Long)localObject2).longValue())) && ((((QQUser)localObject1).mIsBinded) || (localObject3 == null) || (((QQUser)localObject1).mRealUin == ((Long)localObject3).longValue())))
      {
        localObject2 = th.a(paramString);
        if (localObject3 != null) {
          paramaar.c.put("param.uinhash", Long.valueOf(((QQUser)localObject1).mUin));
        }
        if (localObject2 != null)
        {
          localObject1 = ((tk)localObject2).c(paramaar);
          if (((wz)localObject1).b()) {
            return localObject1;
          }
          if ((((wz)localObject1).a != 109) && (((wz)localObject1).a != 104)) {
            return localObject1;
          }
          paramaar = c(paramaar, paramString);
          if (paramaar.b())
          {
            sa.a();
            ta.a().g();
          }
          return paramaar;
        }
        localwz.a(10000, null, null);
        return localwz;
      }
      paramaar = c(paramaar, paramString);
      if (paramaar.b())
      {
        sa.a();
        ta.a().g();
      }
      return paramaar;
    }
    finally {}
  }
  
  public static Callable<wz> a(aar paramaar)
  {
    new Callable() {};
  }
  
  private static wz b(aar paramaar, String paramString)
  {
    Object localObject1 = new wz();
    ??? = paramaar.c.get("param.uin.wtlogin");
    if (??? == null)
    {
      ((wz)localObject1).a(10000, null, null);
      return localObject1;
    }
    String str = String.valueOf(((Long)???).longValue());
    b = 1;
    Object localObject3 = rz.a(RqdApplication.n());
    ??? = new StringBuilder("st sync account=");
    ((StringBuilder)???).append(str);
    ((StringBuilder)???).append(",appid=523005419");
    xb.a(((StringBuilder)???).toString());
    Object localObject4 = rz.a(RqdApplication.n());
    synchronized (rz.g)
    {
      if (!((rz)localObject4).a(str, 523005419L))
      {
        ((rz)localObject4).e = true;
        ((rz)localObject4).a(str, null, 523005419L);
        rz.g.wait();
        b = 1;
      }
      else
      {
        ((rz)localObject4).f.a(15, null, null);
      }
      ??? = ((rz)localObject3).f;
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((wz)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((wz)???).c);
      xb.a(((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((wz)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((wz)???).c);
      xb.a(((StringBuilder)localObject4).toString());
      if (!((wz)???).b())
      {
        paramString = ((wz)???).c;
        paramaar = paramString;
        if (((wz)???).c.indexOf("(") == -1)
        {
          paramaar = paramString;
          if (((wz)???).c.indexOf(")") == -1)
          {
            paramaar = new StringBuilder();
            paramaar.append(((wz)???).c);
            paramaar.append("(");
            paramaar.append(((rz)localObject3).f.a);
            paramaar.append(")");
            paramaar = paramaar.toString();
          }
        }
        xb.c("wtlogin error for user: ".concat(String.valueOf(paramaar)));
        if ((((wz)???).a != 15) && (((wz)???).a != 16) && (((wz)???).a != 1) && (((wz)???).a != 2))
        {
          if ((((wz)???).a != 40) && (((wz)???).a != 42) && (((wz)???).a != 64))
          {
            if (((wz)???).a == -1000)
            {
              paramString = new StringBuilder();
              paramString.append(paramaar);
              paramString.append("(");
              paramString.append(((wz)???).a);
              paramString.append(")");
              paramString = paramString.toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramaar);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(((wz)???).a);
              ((StringBuilder)localObject3).append(")");
              ((wz)localObject1).a(10003, paramString, ((StringBuilder)localObject3).toString());
              return localObject1;
            }
            paramString = new StringBuilder();
            paramString.append(paramaar);
            paramString.append("(");
            paramString.append(((wz)???).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramaar);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((wz)???).a);
            ((StringBuilder)localObject3).append(")");
            ((wz)localObject1).a(10028, paramString, ((StringBuilder)localObject3).toString());
            return localObject1;
          }
          ((wz)localObject1).a(((wz)???).a, paramaar, paramaar);
          ((wz)localObject1).d = ((wz)???).d;
          return localObject1;
        }
        ((wz)localObject1).a(10027, paramaar, paramaar);
        return localObject1;
      }
      localObject1 = (byte[])((wz)???).d;
      int i = b;
      paramaar.c.put("param.uin.wtlogin", str);
      paramaar.c.put("param.wtlogin.a2", localObject1);
      paramaar.c.put("param.wtlogin.type", Integer.valueOf(i));
      localObject1 = tn.a(paramaar, "mbtoken3_vfy_wtlogin");
      if (((wz)localObject1).b())
      {
        paramString = th.a(paramString);
        if (paramString != null) {
          return paramString.c(paramaar);
        }
        ((wz)localObject1).a(10000, null, null);
        return localObject1;
      }
      return localObject1;
    }
  }
  
  private static wz c(aar paramaar, String paramString)
  {
    new wz();
    if (paramaar.c.get("param.uin.wtlogin") != null) {
      return b(paramaar, paramString);
    }
    new wz();
    int i;
    if (paramaar.m == 1)
    {
      paramaar.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramaar.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = tn.a(paramaar, "mbtoken3_login_v2");
    if (((wz)localObject).b())
    {
      a = 0;
      paramString = th.a(paramString);
      if (paramString != null)
      {
        if (i != -1)
        {
          paramaar.m = 1;
          paramaar.k = true;
        }
        return paramString.c(paramaar);
      }
      ((wz)localObject).a(10000, null, null);
      return localObject;
    }
    if ((!((wz)localObject).b()) && (((wz)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + qz.a().g();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      xb.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = th.a("mbtoken3_login_v2").c(paramaar);
      if (((wz)localObject).b())
      {
        a = 0;
        paramString = th.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramaar.m = 1;
            paramaar.k = true;
          }
          return paramString.c(paramaar);
        }
        ((wz)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    if ((!((wz)localObject).b()) && (((wz)localObject).a == 112))
    {
      localObject = th.a("mbtoken3_login_v2").c(paramaar);
      if (((wz)localObject).b())
      {
        a = 0;
        paramString = th.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramaar.m = 1;
            paramaar.k = true;
          }
          return paramString.c(paramaar);
        }
        ((wz)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ti
 * JD-Core Version:    0.7.0.1
 */