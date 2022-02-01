package com.tencent.token;

import java.util.Date;
import javax.annotation.Nullable;

public final class akw
{
  @Nullable
  public final akl a;
  @Nullable
  public final akn b;
  
  akw(akl paramakl, akn paramakn)
  {
    this.a = paramakl;
    this.b = paramakn;
  }
  
  public static boolean a(akn paramakn, akl paramakl)
  {
    switch (paramakn.c)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramakn.a("Expires") == null) && (paramakn.b().e == -1) && (!paramakn.b().g) && (!paramakn.b().f)) {
        return false;
      }
      break;
    }
    return (!paramakn.b().d) && (!paramakl.b().d);
  }
  
  public static final class a
  {
    final long a;
    final akl b;
    final akn c;
    Date d;
    String e;
    Date f;
    String g;
    Date h;
    long i;
    long j;
    String k;
    int l = -1;
    
    public a(long paramLong, akl paramakl, akn paramakn)
    {
      this.a = paramLong;
      this.b = paramakl;
      this.c = paramakn;
      if (paramakn != null)
      {
        this.i = paramakn.k;
        this.j = paramakn.l;
        paramakl = paramakn.f;
        int m = 0;
        int n = paramakl.a.length / 2;
        while (m < n)
        {
          paramakn = paramakl.a(m);
          String str = paramakl.b(m);
          if ("Date".equalsIgnoreCase(paramakn))
          {
            this.d = alj.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramakn))
          {
            this.h = alj.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramakn))
          {
            this.f = alj.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramakn))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramakn))
          {
            this.l = alk.b(str, -1);
          }
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akw
 * JD-Core Version:    0.7.0.1
 */