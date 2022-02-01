package com.tencent.msf.service.protocol.serverconfig;

import java.io.Serializable;

public final class h
  implements Serializable
{
  public static final int a = 1;
  public static final h b;
  public static final int c = 2;
  public static final h d;
  public static final int e = 3;
  public static final h f;
  private static h[] h;
  private int i;
  private String j = new String();
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      h = new h[3];
      b = new h(0, 1, "PUSH_SERVER_LIST");
      d = new h(1, 2, "PUSH_FMT_SERVER_LIST");
      f = new h(2, 3, "PUSH_CLILOG_CONFIG");
      return;
    }
  }
  
  private h(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static h a(int paramInt)
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
  
  public static h a(String paramString)
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
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.h
 * JD-Core Version:    0.7.0.1
 */