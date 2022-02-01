package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class tp
{
  public static int a = 0;
  private static int b = 1;
  
  public static xh a(abc paramabc, String paramString)
  {
    xh localxh = new xh();
    Object localObject2 = (Long)paramabc.c.get("param.uinhash");
    if (localObject2 == null)
    {
      localxh.a(10000, null, null);
      return localxh;
    }
    try
    {
      Object localObject1 = th.a();
      Object localObject3 = ((th)localObject1).k.b();
      if ((localObject3 != null) && (((th)localObject1).l == localObject3))
      {
        long l = System.currentTimeMillis() / 1000L;
        if (((th)localObject1).m + ((th)localObject1).n > l)
        {
          localObject1 = ((th)localObject1).l;
          break label175;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
      localStringBuilder.append(((th)localObject1).l);
      localStringBuilder.append(",current_user=");
      localStringBuilder.append(localObject3);
      xj.a(localStringBuilder.toString());
      ((th)localObject1).l = null;
      ((th)localObject1).m = 0L;
      ((th)localObject1).n = 0L;
      localObject1 = null;
      label175:
      xj.c("login task: loginedUser".concat(String.valueOf(localObject1)));
      localObject3 = (Long)paramabc.c.get("param.uin.wtlogin");
      if ((localObject1 != null) && ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin == ((Long)localObject2).longValue())) && ((((QQUser)localObject1).mIsBinded) || (localObject3 == null) || (((QQUser)localObject1).mRealUin == ((Long)localObject3).longValue())))
      {
        localObject2 = to.a(paramString);
        if (localObject3 != null) {
          paramabc.c.put("param.uinhash", Long.valueOf(((QQUser)localObject1).mUin));
        }
        if (localObject2 != null)
        {
          localObject1 = ((tr)localObject2).c(paramabc);
          if (((xh)localObject1).b()) {
            return localObject1;
          }
          if ((((xh)localObject1).a != 109) && (((xh)localObject1).a != 104)) {
            return localObject1;
          }
          paramabc = c(paramabc, paramString);
          if (paramabc.b())
          {
            sh.a();
            th.a().g();
          }
          return paramabc;
        }
        localxh.a(10000, null, null);
        return localxh;
      }
      paramabc = c(paramabc, paramString);
      if (paramabc.b())
      {
        sh.a();
        th.a().g();
      }
      return paramabc;
    }
    finally {}
  }
  
  public static Callable<xh> a(abc paramabc)
  {
    new Callable() {};
  }
  
  private static xh b(abc paramabc, String paramString)
  {
    Object localObject1 = new xh();
    ??? = paramabc.c.get("param.uin.wtlogin");
    if (??? == null)
    {
      ((xh)localObject1).a(10000, null, null);
      return localObject1;
    }
    String str = String.valueOf(((Long)???).longValue());
    b = 1;
    Object localObject3 = sg.a(RqdApplication.p());
    ??? = new StringBuilder("st sync account=");
    ((StringBuilder)???).append(str);
    ((StringBuilder)???).append(",appid=523005419");
    xj.a(((StringBuilder)???).toString());
    Object localObject4 = sg.a(RqdApplication.p());
    synchronized (sg.g)
    {
      if (!((sg)localObject4).a(str, 523005419L))
      {
        ((sg)localObject4).e = true;
        ((sg)localObject4).a(str, null, 523005419L);
        sg.g.wait();
        b = 1;
      }
      else
      {
        ((sg)localObject4).f.a(15, null, null);
      }
      ??? = ((sg)localObject3).f;
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((xh)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((xh)???).c);
      xj.a(((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((xh)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((xh)???).c);
      xj.a(((StringBuilder)localObject4).toString());
      if (!((xh)???).b())
      {
        paramString = ((xh)???).c;
        paramabc = paramString;
        if (((xh)???).c.indexOf("(") == -1)
        {
          paramabc = paramString;
          if (((xh)???).c.indexOf(")") == -1)
          {
            paramabc = new StringBuilder();
            paramabc.append(((xh)???).c);
            paramabc.append("(");
            paramabc.append(((sg)localObject3).f.a);
            paramabc.append(")");
            paramabc = paramabc.toString();
          }
        }
        xj.c("wtlogin error for user: ".concat(String.valueOf(paramabc)));
        if ((((xh)???).a != 15) && (((xh)???).a != 16) && (((xh)???).a != 1) && (((xh)???).a != 2))
        {
          if ((((xh)???).a != 40) && (((xh)???).a != 42) && (((xh)???).a != 64))
          {
            if (((xh)???).a == -1000)
            {
              paramString = new StringBuilder();
              paramString.append(paramabc);
              paramString.append("(");
              paramString.append(((xh)???).a);
              paramString.append(")");
              paramString = paramString.toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramabc);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(((xh)???).a);
              ((StringBuilder)localObject3).append(")");
              ((xh)localObject1).a(10003, paramString, ((StringBuilder)localObject3).toString());
              return localObject1;
            }
            paramString = new StringBuilder();
            paramString.append(paramabc);
            paramString.append("(");
            paramString.append(((xh)???).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramabc);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((xh)???).a);
            ((StringBuilder)localObject3).append(")");
            ((xh)localObject1).a(10028, paramString, ((StringBuilder)localObject3).toString());
            return localObject1;
          }
          ((xh)localObject1).a(((xh)???).a, paramabc, paramabc);
          ((xh)localObject1).d = ((xh)???).d;
          return localObject1;
        }
        ((xh)localObject1).a(10027, paramabc, paramabc);
        return localObject1;
      }
      localObject1 = (byte[])((xh)???).d;
      int i = b;
      paramabc.c.put("param.uin.wtlogin", str);
      paramabc.c.put("param.wtlogin.a2", localObject1);
      paramabc.c.put("param.wtlogin.type", Integer.valueOf(i));
      localObject1 = tu.a(paramabc, "mbtoken3_vfy_wtlogin");
      if (((xh)localObject1).b())
      {
        paramString = to.a(paramString);
        if (paramString != null) {
          return paramString.c(paramabc);
        }
        ((xh)localObject1).a(10000, null, null);
        return localObject1;
      }
      return localObject1;
    }
  }
  
  private static xh c(abc paramabc, String paramString)
  {
    new xh();
    if (paramabc.c.get("param.uin.wtlogin") != null) {
      return b(paramabc, paramString);
    }
    new xh();
    int i;
    if (paramabc.m == 1)
    {
      paramabc.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramabc.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = tu.a(paramabc, "mbtoken3_login_v2");
    if (((xh)localObject).b())
    {
      a = 0;
      paramString = to.a(paramString);
      if (paramString != null)
      {
        if (i != -1)
        {
          paramabc.m = 1;
          paramabc.k = true;
        }
        return paramString.c(paramabc);
      }
      ((xh)localObject).a(10000, null, null);
      return localObject;
    }
    if ((!((xh)localObject).b()) && (((xh)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + rf.a().g();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      xj.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = to.a("mbtoken3_login_v2").c(paramabc);
      if (((xh)localObject).b())
      {
        a = 0;
        paramString = to.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramabc.m = 1;
            paramabc.k = true;
          }
          return paramString.c(paramabc);
        }
        ((xh)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    if ((!((xh)localObject).b()) && (((xh)localObject).a == 112))
    {
      localObject = to.a("mbtoken3_login_v2").c(paramabc);
      if (((xh)localObject).b())
      {
        a = 0;
        paramString = to.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramabc.m = 1;
            paramabc.k = true;
          }
          return paramString.c(paramabc);
        }
        ((xh)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tp
 * JD-Core Version:    0.7.0.1
 */