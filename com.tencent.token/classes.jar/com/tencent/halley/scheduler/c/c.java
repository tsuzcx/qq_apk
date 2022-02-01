package com.tencent.halley.scheduler.c;

import com.tencent.token.li;
import com.tencent.token.lj;

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
  
  public final void a(li paramli)
  {
    this.a = paramli.a(this.a, 0, false);
    this.b = paramli.a(this.b, 1, false);
    this.c = paramli.a(this.c, 2, false);
    this.d = paramli.a(this.d, 3, false);
    this.e = paramli.a(this.e, 4, false);
    if (g == null) {
      g = new i();
    }
    this.f = ((i)paramli.a(g, 5, false));
  }
  
  public final void a(lj paramlj)
  {
    paramlj.a(this.a, 0);
    paramlj.a(this.b, 1);
    paramlj.a(this.c, 2);
    paramlj.a(this.d, 3);
    paramlj.a(this.e, 4);
    i locali = this.f;
    if (locali != null) {
      paramlj.a(locali, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.c
 * JD-Core Version:    0.7.0.1
 */