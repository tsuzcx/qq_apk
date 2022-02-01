package com.tencent.halley.scheduler.c;

import com.tencent.token.lj;
import com.tencent.token.lk;

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
  
  public final void a(lj paramlj)
  {
    this.a = paramlj.a(this.a, 0, false);
    this.b = paramlj.a(this.b, 1, false);
    this.c = paramlj.a(this.c, 2, false);
    this.d = paramlj.a(this.d, 3, false);
    this.e = paramlj.a(this.e, 4, false);
    if (g == null) {
      g = new i();
    }
    this.f = ((i)paramlj.a(g, 5, false));
  }
  
  public final void a(lk paramlk)
  {
    paramlk.a(this.a, 0);
    paramlk.a(this.b, 1);
    paramlk.a(this.c, 2);
    paramlk.a(this.d, 3);
    paramlk.a(this.e, 4);
    i locali = this.f;
    if (locali != null) {
      paramlk.a(locali, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.c
 * JD-Core Version:    0.7.0.1
 */