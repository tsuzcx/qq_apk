package com.tencent.token;

import com.tencent.token.utils.encrypt.c;
import com.tencent.token.utils.q;

public final class ag
{
  private static ag b = null;
  private static String d = "";
  private static String e = "http://aq.qq.com";
  public as a = null;
  private u c = null;
  
  static
  {
    if (q.c == 0) {
      e = "http://test.aq.qq.com";
    }
  }
  
  public static String a()
  {
    return e;
  }
  
  public static void a(String paramString)
  {
    e = paramString;
  }
  
  public static String b()
  {
    return d;
  }
  
  public static void b(long paramLong)
  {
    paramLong = 1000L * paramLong;
    if (paramLong > 0L)
    {
      long l = System.currentTimeMillis();
      if (b == null) {
        b = new ag();
      }
      b.c.a(paramLong - l);
      if (b == null) {
        b = new ag();
      }
      b.c.a();
      if (b == null) {
        b = new ag();
      }
      b.c.g();
    }
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 15) {
      str = paramString.substring(0, 15);
    }
    d = c.b(c.a(str.getBytes()));
  }
  
  public static ag c()
  {
    if (b == null) {
      b = new ag();
    }
    return b;
  }
  
  public static void d()
  {
    b = null;
  }
  
  public final void a(long paramLong)
  {
    this.c.a(paramLong);
  }
  
  public final void a(fu paramfu)
  {
    this.c.a = new fz().b(ap.a(paramfu.a()));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.c.a = paramArrayOfByte;
  }
  
  public final void c(String paramString)
  {
    this.c.a(paramString);
  }
  
  public final void e()
  {
    this.c.a = null;
  }
  
  public final byte[] f()
  {
    return this.c.a;
  }
  
  public final boolean g()
  {
    u localu = this.c;
    return (localu.a == null) || (localu.a.length == 0);
  }
  
  public final String h()
  {
    return this.c.c();
  }
  
  public final void i()
  {
    this.c.a();
  }
  
  public final String j()
  {
    return this.c.d();
  }
  
  public final long k()
  {
    return this.c.e();
  }
  
  public final int[] l()
  {
    int[] arrayOfInt = new int[6];
    System.arraycopy(this.c.b, 0, arrayOfInt, 0, 6);
    return arrayOfInt;
  }
  
  public final void m()
  {
    this.c.f();
  }
  
  public final void n()
  {
    this.c.g();
  }
  
  public final String o()
  {
    return this.c.h();
  }
  
  public final long p()
  {
    return this.c.i();
  }
  
  public final long q()
  {
    return 30000L - (System.currentTimeMillis() + this.c.i()) % 30000L;
  }
  
  public final long r()
  {
    return System.currentTimeMillis() + this.c.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ag
 * JD-Core Version:    0.7.0.1
 */