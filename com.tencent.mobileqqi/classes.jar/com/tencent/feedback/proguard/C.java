package com.tencent.feedback.proguard;

public final class C
  extends j
{
  private static byte[] r;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public byte[] g = null;
  public String h = "";
  public String i = "";
  public byte j = 0;
  public byte k = 0;
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  private byte p = 0;
  private String q = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.b(4, true);
    this.f = paramh.a(this.f, 5, true);
    if (r == null)
    {
      arrayOfByte = new byte[1];
      r = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = r;
    this.g = paramh.c(6, true);
    this.h = paramh.b(7, false);
    this.i = paramh.b(8, false);
    this.j = paramh.a(this.j, 9, false);
    this.k = paramh.a(this.k, 10, false);
    this.l = paramh.b(11, false);
    this.m = paramh.b(12, false);
    this.n = paramh.b(13, false);
    this.p = paramh.a(this.p, 14, false);
    this.o = paramh.b(15, false);
    this.q = paramh.b(16, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    parami.a(this.e, 4);
    parami.a(this.f, 5);
    parami.a(this.g, 6);
    if (this.h != null) {
      parami.a(this.h, 7);
    }
    if (this.i != null) {
      parami.a(this.i, 8);
    }
    parami.a(this.j, 9);
    parami.a(this.k, 10);
    if (this.l != null) {
      parami.a(this.l, 11);
    }
    if (this.m != null) {
      parami.a(this.m, 12);
    }
    if (this.n != null) {
      parami.a(this.n, 13);
    }
    parami.a(this.p, 14);
    if (this.o != null) {
      parami.a(this.o, 15);
    }
    if (this.q != null) {
      parami.a(this.q, 16);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.C
 * JD-Core Version:    0.7.0.1
 */