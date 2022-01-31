package com.tencent.msf.service.protocol.security;

import java.io.Serializable;

public final class t
  implements Serializable
{
  public static final int a = 0;
  public static final t b;
  public static final int c = 1;
  public static final t d;
  private static t[] f;
  private int g;
  private String h = new String();
  
  static
  {
    if (!t.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = new t[2];
      b = new t(0, 0, "VPIC_TYPE_URL");
      d = new t(1, 1, "VPIC_TYPE_BIN");
      return;
    }
  }
  
  private t(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramString;
    this.g = paramInt2;
    f[paramInt1] = this;
  }
  
  public static t a(int paramInt)
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
  
  public static t a(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.t
 * JD-Core Version:    0.7.0.1
 */