package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.md;
import com.tencent.token.me;

public final class h
  extends c
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  
  public final void a(md parammd)
  {
    this.a = parammd.a(this.a, 0, true);
    this.b = parammd.a(this.b, 1, true);
    this.c = parammd.a(2, true);
  }
  
  public final void a(me paramme)
  {
    paramme.a(this.a, 0);
    paramme.a(this.b, 1);
    paramme.a(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.h
 * JD-Core Version:    0.7.0.1
 */