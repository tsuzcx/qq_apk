package com.tencent.token;

import java.util.Date;
import javax.annotation.Nullable;

public final class aja
{
  @Nullable
  public final aip a;
  @Nullable
  public final air b;
  
  aja(aip paramaip, air paramair)
  {
    this.a = paramaip;
    this.b = paramair;
  }
  
  public static boolean a(air paramair, aip paramaip)
  {
    switch (paramair.c)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramair.a("Expires") == null) && (paramair.b().e == -1) && (!paramair.b().g) && (!paramair.b().f)) {
        return false;
      }
      break;
    }
    return (!paramair.b().d) && (!paramaip.b().d);
  }
  
  public static final class a
  {
    final long a;
    final aip b;
    final air c;
    Date d;
    String e;
    Date f;
    String g;
    Date h;
    long i;
    long j;
    String k;
    int l = -1;
    
    public a(long paramLong, aip paramaip, air paramair)
    {
      this.a = paramLong;
      this.b = paramaip;
      this.c = paramair;
      if (paramair != null)
      {
        this.i = paramair.k;
        this.j = paramair.l;
        paramaip = paramair.f;
        int m = 0;
        int n = paramaip.a.length / 2;
        while (m < n)
        {
          paramair = paramaip.a(m);
          String str = paramaip.b(m);
          if ("Date".equalsIgnoreCase(paramair))
          {
            this.d = ajn.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramair))
          {
            this.h = ajn.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramair))
          {
            this.f = ajn.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramair))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramair))
          {
            this.l = ajo.b(str, -1);
          }
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aja
 * JD-Core Version:    0.7.0.1
 */