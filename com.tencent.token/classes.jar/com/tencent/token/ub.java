package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class ub
{
  public static int a = 0;
  private static int b = 1;
  
  public static xt a(abm paramabm, String paramString)
  {
    xt localxt = new xt();
    Object localObject2 = (Long)paramabm.c.get("param.uinhash");
    if (localObject2 == null)
    {
      localxt.a(10000, null, null);
      return localxt;
    }
    try
    {
      Object localObject1 = tt.a();
      Object localObject3 = ((tt)localObject1).k.b();
      if ((localObject3 != null) && (((tt)localObject1).l == localObject3))
      {
        long l = System.currentTimeMillis() / 1000L;
        if (((tt)localObject1).m + ((tt)localObject1).n > l)
        {
          localObject1 = ((tt)localObject1).l;
          break label175;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
      localStringBuilder.append(((tt)localObject1).l);
      localStringBuilder.append(",current_user=");
      localStringBuilder.append(localObject3);
      xv.a(localStringBuilder.toString());
      ((tt)localObject1).l = null;
      ((tt)localObject1).m = 0L;
      ((tt)localObject1).n = 0L;
      localObject1 = null;
      label175:
      xv.c("login task: loginedUser".concat(String.valueOf(localObject1)));
      localObject3 = (Long)paramabm.c.get("param.uin.wtlogin");
      if ((localObject1 != null) && ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin == ((Long)localObject2).longValue())) && ((((QQUser)localObject1).mIsBinded) || (localObject3 == null) || (((QQUser)localObject1).mRealUin == ((Long)localObject3).longValue())))
      {
        localObject2 = ua.a(paramString);
        if (localObject3 != null) {
          paramabm.c.put("param.uinhash", Long.valueOf(((QQUser)localObject1).mUin));
        }
        if (localObject2 != null)
        {
          localObject1 = ((ud)localObject2).c(paramabm);
          if (((xt)localObject1).b()) {
            return localObject1;
          }
          if ((((xt)localObject1).a != 109) && (((xt)localObject1).a != 104)) {
            return localObject1;
          }
          paramabm = c(paramabm, paramString);
          if (paramabm.b())
          {
            st.a();
            tt.a().g();
          }
          return paramabm;
        }
        localxt.a(10000, null, null);
        return localxt;
      }
      paramabm = c(paramabm, paramString);
      if (paramabm.b())
      {
        st.a();
        tt.a().g();
      }
      return paramabm;
    }
    finally {}
  }
  
  public static Callable<xt> a(abm paramabm)
  {
    new Callable() {};
  }
  
  private static xt b(abm paramabm, String paramString)
  {
    Object localObject1 = new xt();
    ??? = paramabm.c.get("param.uin.wtlogin");
    if (??? == null)
    {
      ((xt)localObject1).a(10000, null, null);
      return localObject1;
    }
    String str = String.valueOf(((Long)???).longValue());
    b = 1;
    Object localObject3 = ss.a(RqdApplication.n());
    ??? = new StringBuilder("st sync account=");
    ((StringBuilder)???).append(str);
    ((StringBuilder)???).append(",appid=523005419");
    xv.a(((StringBuilder)???).toString());
    Object localObject4 = ss.a(RqdApplication.n());
    synchronized (ss.g)
    {
      if (!((ss)localObject4).a(str, 523005419L))
      {
        ((ss)localObject4).e = true;
        ((ss)localObject4).a(str, null, 523005419L);
        ss.g.wait();
        b = 1;
      }
      else
      {
        ((ss)localObject4).f.a(15, null, null);
      }
      ??? = ((ss)localObject3).f;
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((xt)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((xt)???).c);
      xv.a(((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder("wtlogin result=");
      ((StringBuilder)localObject4).append(((xt)???).a);
      ((StringBuilder)localObject4).append(",errinfo=");
      ((StringBuilder)localObject4).append(((xt)???).c);
      xv.a(((StringBuilder)localObject4).toString());
      if (!((xt)???).b())
      {
        paramString = ((xt)???).c;
        paramabm = paramString;
        if (((xt)???).c.indexOf("(") == -1)
        {
          paramabm = paramString;
          if (((xt)???).c.indexOf(")") == -1)
          {
            paramabm = new StringBuilder();
            paramabm.append(((xt)???).c);
            paramabm.append("(");
            paramabm.append(((ss)localObject3).f.a);
            paramabm.append(")");
            paramabm = paramabm.toString();
          }
        }
        xv.c("wtlogin error for user: ".concat(String.valueOf(paramabm)));
        if ((((xt)???).a != 15) && (((xt)???).a != 16) && (((xt)???).a != 1) && (((xt)???).a != 2))
        {
          if ((((xt)???).a != 40) && (((xt)???).a != 42) && (((xt)???).a != 64))
          {
            if (((xt)???).a == -1000)
            {
              paramString = new StringBuilder();
              paramString.append(paramabm);
              paramString.append("(");
              paramString.append(((xt)???).a);
              paramString.append(")");
              paramString = paramString.toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramabm);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(((xt)???).a);
              ((StringBuilder)localObject3).append(")");
              ((xt)localObject1).a(10003, paramString, ((StringBuilder)localObject3).toString());
              return localObject1;
            }
            paramString = new StringBuilder();
            paramString.append(paramabm);
            paramString.append("(");
            paramString.append(((xt)???).a);
            paramString.append(")");
            paramString = paramString.toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramabm);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((xt)???).a);
            ((StringBuilder)localObject3).append(")");
            ((xt)localObject1).a(10028, paramString, ((StringBuilder)localObject3).toString());
            return localObject1;
          }
          ((xt)localObject1).a(((xt)???).a, paramabm, paramabm);
          ((xt)localObject1).d = ((xt)???).d;
          return localObject1;
        }
        ((xt)localObject1).a(10027, paramabm, paramabm);
        return localObject1;
      }
      localObject1 = (byte[])((xt)???).d;
      int i = b;
      paramabm.c.put("param.uin.wtlogin", str);
      paramabm.c.put("param.wtlogin.a2", localObject1);
      paramabm.c.put("param.wtlogin.type", Integer.valueOf(i));
      localObject1 = ug.a(paramabm, "mbtoken3_vfy_wtlogin");
      if (((xt)localObject1).b())
      {
        paramString = ua.a(paramString);
        if (paramString != null) {
          return paramString.c(paramabm);
        }
        ((xt)localObject1).a(10000, null, null);
        return localObject1;
      }
      return localObject1;
    }
  }
  
  private static xt c(abm paramabm, String paramString)
  {
    new xt();
    if (paramabm.c.get("param.uin.wtlogin") != null) {
      return b(paramabm, paramString);
    }
    new xt();
    int i;
    if (paramabm.m == 1)
    {
      paramabm.m = 0;
      i = 1;
    }
    else
    {
      i = -1;
    }
    paramabm.c.put("param.loginv2.clearkick", Integer.valueOf(a));
    Object localObject = ug.a(paramabm, "mbtoken3_login_v2");
    if (((xt)localObject).b())
    {
      a = 0;
      paramString = ua.a(paramString);
      if (paramString != null)
      {
        if (i != -1)
        {
          paramabm.m = 1;
          paramabm.k = true;
        }
        return paramString.c(paramabm);
      }
      ((xt)localObject).a(10000, null, null);
      return localObject;
    }
    if ((!((xt)localObject).b()) && (((xt)localObject).a == 102))
    {
      long l1 = System.currentTimeMillis() + rt.a().g();
      long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
      localObject = new StringBuilder("sleep ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("s for dyncode refresh:");
      ((StringBuilder)localObject).append(l1);
      xv.a(((StringBuilder)localObject).toString());
      Thread.sleep(l2 * 1000L);
      localObject = ua.a("mbtoken3_login_v2").c(paramabm);
      if (((xt)localObject).b())
      {
        a = 0;
        paramString = ua.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramabm.m = 1;
            paramabm.k = true;
          }
          return paramString.c(paramabm);
        }
        ((xt)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    if ((!((xt)localObject).b()) && (((xt)localObject).a == 112))
    {
      localObject = ua.a("mbtoken3_login_v2").c(paramabm);
      if (((xt)localObject).b())
      {
        a = 0;
        paramString = ua.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramabm.m = 1;
            paramabm.k = true;
          }
          return paramString.c(paramabm);
        }
        ((xt)localObject).a(10000, null, null);
        return localObject;
      }
      return localObject;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ub
 * JD-Core Version:    0.7.0.1
 */