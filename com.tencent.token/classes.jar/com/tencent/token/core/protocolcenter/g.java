package com.tencent.token.core.protocolcenter;

import com.tencent.token.bw;
import com.tencent.token.cb;
import com.tencent.token.dp;
import com.tencent.token.global.e;
import java.util.concurrent.Callable;

public class g
{
  public static e a(dp paramdp, String paramString)
  {
    e locale = bw.a().b();
    if (!locale.b()) {
      return locale;
    }
    paramString = b.a(paramString);
    if (paramString != null)
    {
      paramdp = paramString.c(paramdp);
      if (paramdp.b()) {
        cb.a().c();
      }
      return paramdp;
    }
    locale.b(10000);
    return locale;
  }
  
  public static Callable<e> a(dp paramdp)
  {
    new Callable()
    {
      public e a()
      {
        Object localObject = this.a;
        localObject = g.b((dp)localObject, ((dp)localObject).a);
        this.a.l.a(this.a, (e)localObject);
        return localObject;
      }
    };
  }
  
  public static e b(dp paramdp, String paramString)
  {
    e locale = new e();
    try
    {
      if (cb.a().b() == null)
      {
        paramdp = a(paramdp, paramString);
        return paramdp;
      }
      d locald = b.a(paramString);
      if (locald != null)
      {
        locale = locald.c(paramdp);
        if (locale.b())
        {
          cb.a().c();
          return locale;
        }
        if (locale.a == 104)
        {
          paramdp = a(paramdp, paramString);
          return paramdp;
        }
        return locale;
      }
      locale.b(10000);
      return locale;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.g
 * JD-Core Version:    0.7.0.1
 */