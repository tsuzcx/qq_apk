package com.tencent.halley.scheduler.c;

import com.tencent.token.lp;
import com.tencent.token.lq;

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
  
  public final void a(lp paramlp)
  {
    this.a = paramlp.a(this.a, 0, false);
    this.b = paramlp.a(this.b, 1, false);
    this.c = paramlp.a(this.c, 2, false);
    this.d = paramlp.a(this.d, 3, false);
    this.e = paramlp.a(this.e, 4, false);
    if (g == null) {
      g = new i();
    }
    this.f = ((i)paramlp.a(g, 5, false));
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.a, 0);
    paramlq.a(this.b, 1);
    paramlq.a(this.c, 2);
    paramlq.a(this.d, 3);
    paramlq.a(this.e, 4);
    i locali = this.f;
    if (locali != null) {
      paramlq.a(locali, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.c
 * JD-Core Version:    0.7.0.1
 */