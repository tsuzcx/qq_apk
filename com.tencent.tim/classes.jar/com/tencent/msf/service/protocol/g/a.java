package com.tencent.msf.service.protocol.g;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public static final int a = 1;
  public static final a b;
  public static final int c = 3;
  public static final a d;
  public static final int e = 4;
  public static final a f;
  public static final int g = 5;
  public static final a h;
  public static final int i = 6;
  public static final a j;
  public static final int k = 7;
  public static final a l;
  public static final int m = 9;
  public static final a n;
  public static final int o = 10;
  public static final a p;
  private static a[] r;
  private int s;
  private String t = new String();
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      q = bool;
      r = new a[8];
      b = new a(0, 1, "REQUEST");
      d = new a(1, 3, "QUERYSMSSTAT");
      f = new a(2, 4, "REQUESTSMSAG");
      h = new a(3, 5, "VERIFYSMSCODE");
      j = new a(4, 6, "GETQQ");
      l = new a(5, 7, "QUERYACCOUNT");
      n = new a(6, 9, "VERIFYANDGETQQ");
      p = new a(7, 10, "REQUEST_EX");
      return;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.t = paramString;
    this.s = paramInt2;
    r[paramInt1] = this;
  }
  
  public static a a(int paramInt)
  {
    int i1 = 0;
    while (i1 < r.length)
    {
      if (r[i1].a() == paramInt) {
        return r[i1];
      }
      i1 += 1;
    }
    if (!q) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static a a(String paramString)
  {
    int i1 = 0;
    while (i1 < r.length)
    {
      if (r[i1].toString().equals(paramString)) {
        return r[i1];
      }
      i1 += 1;
    }
    if (!q) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.s;
  }
  
  public String toString()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.a
 * JD-Core Version:    0.7.0.1
 */