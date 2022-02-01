package com.tencent.msf.service.protocol.security;

import java.io.Serializable;

public final class s
  implements Serializable
{
  public static final int a = 0;
  public static final s b;
  public static final int c = 1;
  public static final s d;
  public static final int e = 2;
  public static final s f;
  private static s[] h;
  private int i;
  private String j = new String();
  
  static
  {
    if (!s.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      h = new s[3];
      b = new s(0, 0, "VPIC_FORMAT_JPG");
      d = new s(1, 1, "VPIC_FORMAT_PNG");
      f = new s(2, 2, "VPIC_FORMAT_BMP");
      return;
    }
  }
  
  private s(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static s a(int paramInt)
  {
    int k = 0;
    while (k < h.length)
    {
      if (h[k].a() == paramInt) {
        return h[k];
      }
      k += 1;
    }
    if (!g) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static s a(String paramString)
  {
    int k = 0;
    while (k < h.length)
    {
      if (h[k].toString().equals(paramString)) {
        return h[k];
      }
      k += 1;
    }
    if (!g) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.s
 * JD-Core Version:    0.7.0.1
 */