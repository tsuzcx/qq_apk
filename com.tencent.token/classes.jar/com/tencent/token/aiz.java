package com.tencent.token;

import java.util.Date;
import javax.annotation.Nullable;

public final class aiz
{
  @Nullable
  public final aio a;
  @Nullable
  public final aiq b;
  
  aiz(aio paramaio, aiq paramaiq)
  {
    this.a = paramaio;
    this.b = paramaiq;
  }
  
  public static boolean a(aiq paramaiq, aio paramaio)
  {
    switch (paramaiq.c)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramaiq.a("Expires") == null) && (paramaiq.b().e == -1) && (!paramaiq.b().g) && (!paramaiq.b().f)) {
        return false;
      }
      break;
    }
    return (!paramaiq.b().d) && (!paramaio.b().d);
  }
  
  public static final class a
  {
    final long a;
    final aio b;
    final aiq c;
    Date d;
    String e;
    Date f;
    String g;
    Date h;
    long i;
    long j;
    String k;
    int l = -1;
    
    public a(long paramLong, aio paramaio, aiq paramaiq)
    {
      this.a = paramLong;
      this.b = paramaio;
      this.c = paramaiq;
      if (paramaiq != null)
      {
        this.i = paramaiq.k;
        this.j = paramaiq.l;
        paramaio = paramaiq.f;
        int m = 0;
        int n = paramaio.a.length / 2;
        while (m < n)
        {
          paramaiq = paramaio.a(m);
          String str = paramaio.b(m);
          if ("Date".equalsIgnoreCase(paramaiq))
          {
            this.d = ajm.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramaiq))
          {
            this.h = ajm.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramaiq))
          {
            this.f = ajm.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramaiq))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramaiq))
          {
            this.l = ajn.b(str, -1);
          }
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiz
 * JD-Core Version:    0.7.0.1
 */