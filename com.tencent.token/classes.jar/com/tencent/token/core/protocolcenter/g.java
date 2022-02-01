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
      paramdo = locale;
    }
    do
    {
      return paramdo;
      paramString = b.a(paramString);
      if (paramString == null) {
        break;
      }
      paramString = paramString.c(paramdo);
      paramdo = paramString;
    } while (!paramString.b());
    ca.a().c();
    return paramString;
    locale.b(10000);
    return locale;
  }
  
  public static Callable<e> a(do paramdo)
  {
    new Callable()
    {
      public e a()
      {
        e locale = g.b(this.a, this.a.a);
        this.a.l.a(this.a, locale);
        return locale;
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
        if (!locale.b()) {
          break label82;
        }
        ca.a().c();
        return locale;
      }
    }
    finally {}
    locale.b(10000);
    return locale;
    label82:
    if (locale.a == 104)
    {
      paramdo = a(paramdo, paramString);
      return paramdo;
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.g
 * JD-Core Version:    0.7.0.1
 */