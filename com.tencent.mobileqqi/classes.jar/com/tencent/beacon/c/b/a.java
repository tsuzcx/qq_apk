package com.tencent.beacon.c.b;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;

public final class a
  extends c
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public boolean d = true;
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public int i = 0;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    this.a = parama.b(0, true);
    this.b = parama.b(1, true);
    this.c = parama.b(2, true);
    boolean bool = this.d;
    this.d = parama.a(3, true);
    this.e = parama.a(this.e, 4, true);
    this.f = parama.a(this.f, 5, true);
    this.g = parama.b(6, true);
    this.h = parama.a(this.h, 7, true);
    this.i = parama.a(this.i, 8, false);
  }
  
  public final void a(b paramb)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.c.b.a
 * JD-Core Version:    0.7.0.1
 */