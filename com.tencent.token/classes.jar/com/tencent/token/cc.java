package com.tencent.token;

import com.tencent.token.core.protocolcenter.protocol.ProtoModSeed;
import com.tencent.token.utils.encrypt.c;
import com.tencent.token.utils.j;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;

public class cc
{
  private static cc b = null;
  private static String d = "";
  private static String e = "https://aq.qq.com";
  public cm a = null;
  private bx c = null;
  
  static
  {
    if (j.c == 0) {
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
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 15) {
      str = paramString.substring(0, 15);
    }
    d = c.c(c.b(str.getBytes()));
  }
  
  public static cc c()
  {
    if (b == null) {
      b = new cc();
    }
    return b;
  }
  
  public void a(long paramLong)
  {
    this.c.a(paramLong);
  }
  
  public void a(dq paramdq)
  {
    this.c.a(paramdq);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a = paramArrayOfByte;
    TmsLog.i("mod_seed", "recv initCode, hexStr: " + l.a(paramArrayOfByte));
    if (paramArrayOfByte != null) {
      ProtoModSeed.a(false);
    }
  }
  
  public void b(long paramLong)
  {
    paramLong = 1000L * paramLong;
    if (paramLong > 0L)
    {
      long l = System.currentTimeMillis();
      c().a(paramLong - l);
      c().i();
      c().n();
    }
  }
  
  public void c(long paramLong)
  {
    this.c.b(paramLong);
  }
  
  public void c(String paramString)
  {
    this.c.a(paramString);
  }
  
  public void d()
  {
    b = null;
  }
  
  public void e()
  {
    this.c.b();
  }
  
  public byte[] f()
  {
    return this.c.a;
  }
  
  public boolean g()
  {
    return this.c.a();
  }
  
  public String h()
  {
    return this.c.f();
  }
  
  public void i()
  {
    this.c.c();
  }
  
  public String j()
  {
    return this.c.g();
  }
  
  public long k()
  {
    return this.c.h();
  }
  
  public int[] l()
  {
    int[] arrayOfInt = new int[6];
    System.arraycopy(this.c.b, 0, arrayOfInt, 0, 6);
    return arrayOfInt;
  }
  
  public void m()
  {
    this.c.i();
  }
  
  public void n()
  {
    this.c.j();
  }
  
  public String o()
  {
    return this.c.k();
  }
  
  public String p()
  {
    String str2 = "0000";
    String str3 = this.c.a(0);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.length() != 0)
      {
        str1 = str2;
        if (str3.length() >= 4) {
          str1 = str3.substring(0, 4);
        }
      }
    }
    return str1;
  }
  
  public long q()
  {
    return this.c.l();
  }
  
  public long r()
  {
    return 30000L - s() % 30000L;
  }
  
  public long s()
  {
    return System.currentTimeMillis() + q();
  }
  
  public boolean t()
  {
    return this.c.m();
  }
  
  public void u()
  {
    this.c.a(false);
  }
  
  public void v()
  {
    this.c.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cc
 * JD-Core Version:    0.7.0.1
 */