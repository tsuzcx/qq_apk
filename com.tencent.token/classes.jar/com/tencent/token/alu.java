package com.tencent.token;

import java.util.Date;
import javax.annotation.Nullable;

public final class alu
{
  @Nullable
  public final alj a;
  @Nullable
  public final all b;
  
  alu(alj paramalj, all paramall)
  {
    this.a = paramalj;
    this.b = paramall;
  }
  
  public static boolean a(all paramall, alj paramalj)
  {
    switch (paramall.c)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramall.a("Expires") == null) && (paramall.b().e == -1) && (!paramall.b().g) && (!paramall.b().f)) {
        return false;
      }
      break;
    }
    return (!paramall.b().d) && (!paramalj.b().d);
  }
  
  public static final class a
  {
    final long a;
    final alj b;
    final all c;
    Date d;
    String e;
    Date f;
    String g;
    Date h;
    long i;
    long j;
    String k;
    int l = -1;
    
    public a(long paramLong, alj paramalj, all paramall)
    {
      this.a = paramLong;
      this.b = paramalj;
      this.c = paramall;
      if (paramall != null)
      {
        this.i = paramall.k;
        this.j = paramall.l;
        paramalj = paramall.f;
        int m = 0;
        int n = paramalj.a.length / 2;
        while (m < n)
        {
          paramall = paramalj.a(m);
          String str = paramalj.b(m);
          if ("Date".equalsIgnoreCase(paramall))
          {
            this.d = amh.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramall))
          {
            this.h = amh.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramall))
          {
            this.f = amh.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramall))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramall))
          {
            this.l = ami.b(str, -1);
          }
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alu
 * JD-Core Version:    0.7.0.1
 */