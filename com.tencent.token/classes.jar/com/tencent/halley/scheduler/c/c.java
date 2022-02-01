package com.tencent.halley.scheduler.c;

import com.tencent.token.md;
import com.tencent.token.me;

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
  
  public final void a(md parammd)
  {
    this.a = parammd.a(this.a, 0, false);
    this.b = parammd.a(this.b, 1, false);
    this.c = parammd.a(this.c, 2, false);
    this.d = parammd.a(this.d, 3, false);
    this.e = parammd.a(this.e, 4, false);
    if (g == null) {
      g = new i();
    }
    this.f = ((i)parammd.a(g, 5, false));
  }
  
  public final void a(me paramme)
  {
    paramme.a(this.a, 0);
    paramme.a(this.b, 1);
    paramme.a(this.c, 2);
    paramme.a(this.d, 3);
    paramme.a(this.e, 4);
    i locali = this.f;
    if (locali != null) {
      paramme.a(locali, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.c
 * JD-Core Version:    0.7.0.1
 */