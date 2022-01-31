package com.tencent.msf.service.protocol.h;

import java.io.Serializable;

public final class g
  implements Serializable
{
  public static final int a = 1;
  public static final g b;
  public static final int c = 2;
  public static final g d;
  public static final int e = 3;
  public static final g f;
  private static g[] h;
  private int i;
  private String j = new String();
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      h = new g[3];
      b = new g(0, 1, "PUSH_SERVER_LIST");
      d = new g(1, 2, "PUSH_FMT_SERVER_LIST");
      f = new g(2, 3, "PUSH_CLILOG_CONFIG");
      return;
    }
  }
  
  private g(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static g a(int paramInt)
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
  
  public static g a(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.h.g
 * JD-Core Version:    0.7.0.1
 */