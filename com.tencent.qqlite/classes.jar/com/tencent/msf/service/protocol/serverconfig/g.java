package com.tencent.msf.service.protocol.serverconfig;

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
  public static final int g = 4;
  public static final g h;
  private static g[] j;
  private int k;
  private String l = new String();
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      j = new g[3];
      b = new g(0, 1, "PUSH_SERVER_LIST");
      d = new g(1, 2, "PUSH_FMT_SERVER_LIST");
      f = new g(2, 3, "PUSH_CLILOG_CONFIG");
      h = new g(2, 4, "PUSH_PROXY_LIST");
      return;
    }
  }
  
  private g(int paramInt1, int paramInt2, String paramString)
  {
    this.l = paramString;
    this.k = paramInt2;
    j[paramInt1] = this;
  }
  
  public static g a(int paramInt)
  {
    int m = 0;
    while (m < j.length)
    {
      if (j[m].a() == paramInt) {
        return j[m];
      }
      m += 1;
    }
    if (!i) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static g a(String paramString)
  {
    int m = 0;
    while (m < j.length)
    {
      if (j[m].toString().equals(paramString)) {
        return j[m];
      }
      m += 1;
    }
    if (!i) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public String toString()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.g
 * JD-Core Version:    0.7.0.1
 */