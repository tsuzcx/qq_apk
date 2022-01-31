package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class bj
{
  public static int a = 0;
  
  public static d a(fs paramfs, String paramString)
  {
    int i = 1;
    d locald = new d((byte)0);
    Object localObject = (Long)paramfs.c.get("param.uinhash");
    if (localObject == null)
    {
      locald.a(10000, null, null);
      return locald;
    }
    QQUser localQQUser;
    Long localLong;
    for (;;)
    {
      try
      {
        localQQUser = ax.a().l();
        e.c("login task: loginedUser" + localQQUser);
        localLong = (Long)paramfs.c.get("param.uin.wtlogin");
        if ((localQQUser != null) && ((!localQQUser.mIsBinded) || (localQQUser.mUin == ((Long)localObject).longValue())) && ((localQQUser.mIsBinded) || (localLong == null) || (localQQUser.mRealUin == localLong.longValue()))) {
          break;
        }
        paramfs = c(paramfs, paramString);
        if (paramfs.a == 0)
        {
          if (i != 0)
          {
            ae.a();
            ax.a().m();
          }
          return paramfs;
        }
      }
      finally {}
      i = 0;
    }
    localObject = bi.a(paramString);
    if (localLong != null) {
      paramfs.c.put("param.uinhash", Long.valueOf(localQQUser.mUin));
    }
    if (localObject != null)
    {
      locald = ((bm)localObject).c(paramfs);
      if (locald.a != 0) {
        break label321;
      }
    }
    label321:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        return locald;
        locald.a(10000, null, null);
        return locald;
      }
      if ((locald.a == 109) || (locald.a == 104))
      {
        paramfs = c(paramfs, paramString);
        if (paramfs.a == 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            ae.a();
            ax.a().m();
          }
          return paramfs;
        }
      }
      return locald;
    }
  }
  
  public static Callable a(fs paramfs)
  {
    return new bk(paramfs);
  }
  
  private static d b(fs paramfs, String paramString)
  {
    Object localObject1 = new d((byte)0);
    Object localObject2 = paramfs.c.get("param.uin.wtlogin");
    if (localObject2 == null)
    {
      ((d)localObject1).a(10000, null, null);
      return localObject1;
    }
    long l = ((Long)localObject2).longValue();
    localObject2 = l + "";
    x localx1 = x.a(RqdApplication.i());
    e.a("st sync account=" + (String)localObject2 + ",appid=" + 523005425L);
    x localx2 = x.a(RqdApplication.i());
    for (;;)
    {
      synchronized (x.c)
      {
        if (!localx2.b((String)localObject2, 523005425L))
        {
          localx2.a();
          localx2.a((String)localObject2, null, 523005425L);
          x.c.wait();
          ??? = localx1.b;
          if (((d)???).a == 0)
          {
            i = 1;
            if (i != 0) {
              break;
            }
            paramfs = ((d)???).c + "(" + localx1.b.a + ")";
            e.c("wtlogin error for user: " + paramfs);
            if ((((d)???).a != 15) && (((d)???).a != 16) && (((d)???).a != 1) && (((d)???).a != 2)) {
              break label326;
            }
            ((d)localObject1).a(10027, paramfs, paramfs);
            return localObject1;
          }
        }
        else
        {
          localx2.b.a(15, null, null);
        }
      }
      i = 0;
      continue;
      label326:
      if (((d)???).a == -1000) {
        ((d)localObject1).a(10003, paramfs + "(" + ((d)???).a + ")", paramfs + "(" + ((d)???).a + ")");
      } else {
        ((d)localObject1).a(10028, paramfs + "(" + ((d)???).a + ")", paramfs + "(" + ((d)???).a + ")");
      }
    }
    cu.a(paramfs, (String)localObject2, (byte[])((d)???).d, 2);
    localObject2 = bw.a(paramfs, "mbtoken3_vfy_wtlogin");
    if (((d)localObject2).a == 0) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject2;
      if (i == 0) {
        break;
      }
      paramString = bi.a(paramString);
      if (paramString == null) {
        break label548;
      }
      return paramString.c(paramfs);
    }
    label548:
    ((d)localObject2).a(10000, null, null);
    return localObject2;
  }
  
  private static d c(fs paramfs, String paramString)
  {
    new d((byte)0);
    if (paramfs.c.get("param.uin.wtlogin") != null) {
      return b(paramfs, paramString);
    }
    new d((byte)0);
    if (paramfs.m == 1) {
      paramfs.m = 0;
    }
    for (int i = 1;; i = -1)
    {
      paramfs.c.put("param.loginv2.clearkick", Integer.valueOf(a));
      Object localObject2 = bw.a(paramfs, "mbtoken3_login_v2");
      int j;
      if (((d)localObject2).a == 0) {
        j = 1;
      }
      Object localObject1;
      while (j != 0)
      {
        a = 0;
        paramString = bi.a(paramString);
        if (paramString != null)
        {
          if (i != -1)
          {
            paramfs.m = 1;
            paramfs.k = true;
          }
          return paramString.c(paramfs);
          j = 0;
        }
        else
        {
          ((d)localObject2).a(10000, null, null);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        return localObject1;
        if (((d)localObject2).a == 0)
        {
          j = 1;
          if ((j != 0) || (((d)localObject2).a != 102)) {
            break label328;
          }
          long l1 = System.currentTimeMillis() + ag.c().p();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 1L;
          e.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          Thread.sleep(1000L * l2);
          localObject1 = bi.a("mbtoken3_login_v2").c(paramfs);
          if (((d)localObject1).a != 0) {
            break label310;
          }
        }
        label310:
        for (j = 1;; j = 0)
        {
          localObject2 = localObject1;
          if (j == 0) {
            break label446;
          }
          a = 0;
          paramString = bi.a(paramString);
          if (paramString == null) {
            break label315;
          }
          if (i != -1)
          {
            paramfs.m = 1;
            paramfs.k = true;
          }
          return paramString.c(paramfs);
          j = 0;
          break;
        }
        label315:
        ((d)localObject1).a(10000, null, null);
        continue;
        label328:
        if (((d)localObject2).a == 0)
        {
          j = 1;
          localObject1 = localObject2;
          if (j != 0) {
            continue;
          }
          localObject1 = localObject2;
          if (((d)localObject2).a != 112) {
            continue;
          }
          localObject1 = bi.a("mbtoken3_login_v2").c(paramfs);
          if (((d)localObject1).a != 0) {
            break label428;
          }
        }
        label428:
        for (j = 1;; j = 0)
        {
          localObject2 = localObject1;
          if (j == 0) {
            break label446;
          }
          a = 0;
          paramString = bi.a(paramString);
          if (paramString == null) {
            break label433;
          }
          if (i != -1)
          {
            paramfs.m = 1;
            paramfs.k = true;
          }
          return paramString.c(paramfs);
          j = 0;
          break;
        }
        label433:
        ((d)localObject1).a(10000, null, null);
      }
      label446:
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bj
 * JD-Core Version:    0.7.0.1
 */