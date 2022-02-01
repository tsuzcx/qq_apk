package com.tencent.msf.service.protocol.f;

import java.io.Serializable;

public final class c
  implements Serializable
{
  public static final int a = 0;
  public static final c b;
  public static final int c = 1;
  public static final c d;
  public static final int e = 2;
  public static final c f;
  private static c[] h;
  private int i;
  private String j = new String();
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      h = new c[3];
      b = new c(0, 0, "GPS_WGS84");
      d = new c(1, 1, "GPS_MARS");
      f = new c(2, 2, "GPS_WGS_REAL");
      return;
    }
  }
  
  private c(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static c a(int paramInt)
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
  
  public static c a(String paramString)
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
 * Qualified Name:     com.tencent.msf.service.protocol.f.c
 * JD-Core Version:    0.7.0.1
 */