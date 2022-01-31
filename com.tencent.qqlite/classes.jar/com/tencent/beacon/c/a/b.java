package com.tencent.beacon.c.a;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.c;

public final class b
  extends c
{
  private static byte[] m;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public byte[] g = null;
  public byte h = 0;
  public byte i = 0;
  public String j = "";
  public String k = "";
  public String l = "";
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, true);
    this.b = parama.b(1, true);
    this.c = parama.b(2, true);
    this.d = parama.b(3, true);
    this.e = parama.b(4, true);
    this.f = parama.a(this.f, 5, true);
    if (m == null)
    {
      arrayOfByte = new byte[1];
      m = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = m;
    this.g = parama.c(6, true);
    this.h = parama.a(this.h, 7, true);
    this.i = parama.a(this.i, 8, true);
    this.j = parama.b(9, false);
    this.k = parama.b(10, false);
    this.l = parama.b(11, false);
  }
  
  public final void a(com.tencent.beacon.e.b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    paramb.a(this.e, 4);
    paramb.a(this.f, 5);
    paramb.a(this.g, 6);
    paramb.a(this.h, 7);
    paramb.a(this.i, 8);
    if (this.j != null) {
      paramb.a(this.j, 9);
    }
    if (this.k != null) {
      paramb.a(this.k, 10);
    }
    if (this.l != null) {
      paramb.a(this.l, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.c.a.b
 * JD-Core Version:    0.7.0.1
 */