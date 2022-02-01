package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lp;
import com.tencent.token.lq;

public final class h
  extends c
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  
  public final void a(lp paramlp)
  {
    this.a = paramlp.a(this.a, 0, true);
    this.b = paramlp.a(this.b, 1, true);
    this.c = paramlp.a(2, true);
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.a, 0);
    paramlq.a(this.b, 1);
    paramlq.a(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.h
 * JD-Core Version:    0.7.0.1
 */