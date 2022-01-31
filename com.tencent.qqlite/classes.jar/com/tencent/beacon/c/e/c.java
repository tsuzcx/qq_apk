package com.tencent.beacon.c.e;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;

public final class c
  extends com.tencent.beacon.e.c
{
  public String a = "";
  public int b = 0;
  public boolean c = true;
  private int d = 0;
  
  public final void a(a parama)
  {
    this.a = parama.b(0, true);
    this.b = parama.a(this.b, 1, true);
    this.d = parama.a(this.d, 2, false);
    boolean bool = this.c;
    this.c = parama.a(3, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.d, 2);
    paramb.a(this.c, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.c.e.c
 * JD-Core Version:    0.7.0.1
 */