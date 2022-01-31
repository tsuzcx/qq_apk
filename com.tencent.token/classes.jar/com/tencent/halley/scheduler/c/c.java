package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.a;
import com.tencent.halley.common.b.d;

public final class c
  extends com.tencent.halley.common.b.c
{
  private static i g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public i f = null;
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, false);
    this.b = parama.a(this.b, 1, false);
    this.c = parama.a(this.c, 2, false);
    this.d = parama.a(this.d, 3, false);
    this.e = parama.a(this.e, 4, false);
    if (g == null) {
      g = new i();
    }
    this.f = ((i)parama.a(g, 5, false));
  }
  
  public final void a(d paramd)
  {
    paramd.a(this.a, 0);
    paramd.a(this.b, 1);
    paramd.a(this.c, 2);
    paramd.a(this.d, 3);
    paramd.a(this.e, 4);
    if (this.f != null) {
      paramd.a(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.c
 * JD-Core Version:    0.7.0.1
 */