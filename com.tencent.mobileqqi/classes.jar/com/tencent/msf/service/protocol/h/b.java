package com.tencent.msf.service.protocol.h;

import java.io.Serializable;

public final class b
  implements Serializable
{
  public static final int a = 1;
  public static final b b;
  public static final int c = 2;
  public static final b d;
  private static b[] f;
  private int g;
  private String h = new String();
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = new b[2];
      b = new b(0, 1, "CliLogCfgByTime");
      d = new b(1, 2, "CliLogCfgSetLevel");
      return;
    }
  }
  
  private b(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramString;
    this.g = paramInt2;
    f[paramInt1] = this;
  }
  
  public static b a(int paramInt)
  {
    int i = 0;
    while (i < f.length)
    {
      if (f[i].a() == paramInt) {
        return f[i];
      }
      i += 1;
    }
    if (!e) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static b a(String paramString)
  {
    int i = 0;
    while (i < f.length)
    {
      if (f[i].toString().equals(paramString)) {
        return f[i];
      }
      i += 1;
    }
    if (!e) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.h.b
 * JD-Core Version:    0.7.0.1
 */