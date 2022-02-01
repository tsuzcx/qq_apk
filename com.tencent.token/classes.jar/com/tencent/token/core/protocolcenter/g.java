package com.tencent.token.core.protocolcenter;

import com.tencent.token.bv;
import com.tencent.token.ca;
import com.tencent.token.do;
import com.tencent.token.global.e;
import java.util.concurrent.Callable;

public class g
{
  public static e a(do paramdo, String paramString)
  {
    e locale = bv.a().b();
    if (!locale.b()) {
      return locale;
    }
    paramString = b.a(paramString);
    if (paramString != null)
    {
      paramdo = paramString.c(paramdo);
      if (paramdo.b()) {
        ca.a().c();
      }
      return paramdo;
    }
    locale.b(10000);
    return locale;
  }
  
  public static Callable<e> a(do paramdo)
  {
    new Callable()
    {
      public e a()
      {
        Object localObject = this.a;
        localObject = g.b((do)localObject, ((do)localObject).a);
        this.a.l.a(this.a, (e)localObject);
        return localObject;
      }
    };
  }
  
  public static e b(do paramdo, String paramString)
  {
    e locale = new e();
    try
    {
      if (ca.a().b() == null)
      {
        paramdo = a(paramdo, paramString);
        return paramdo;
      }
      d locald = b.a(paramString);
      if (locald != null)
      {
        locale = locald.c(paramdo);
        if (locale.b())
        {
          ca.a().c();
          return locale;
        }
        if (locale.a == 104)
        {
          paramdo = a(paramdo, paramString);
          return paramdo;
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