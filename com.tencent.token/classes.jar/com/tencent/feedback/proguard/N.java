package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Map;

public final class N
  extends j
  implements Cloneable
{
  private static byte[] m;
  private static Map n;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public byte[] h = null;
  public String i = "";
  public String j = "";
  private Map k = null;
  private String l = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.b(4, false);
    this.f = paramh.b(5, true);
    this.g = paramh.a(this.g, 6, true);
    if (m == null)
    {
      arrayOfByte = (byte[])new byte[1];
      m = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    byte[] arrayOfByte = m;
    this.h = ((byte[])paramh.c(7, true));
    this.i = paramh.b(8, false);
    this.j = paramh.b(9, false);
    if (n == null)
    {
      n = new HashMap();
      n.put("", "");
    }
    this.k = ((Map)paramh.a(n, 10, false));
    this.l = paramh.b(11, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    if (this.e != null) {
      parami.a(this.e, 4);
    }
    parami.a(this.f, 5);
    parami.a(this.g, 6);
    parami.a(this.h, 7);
    if (this.i != null) {
      parami.a(this.i, 8);
    }
    if (this.j != null) {
      parami.a(this.j, 9);
    }
    if (this.k != null) {
      parami.a(this.k, 10);
    }
    if (this.l != null) {
      parami.a(this.l, 11);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.N
 * JD-Core Version:    0.7.0.1
 */