package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lj;
import com.tencent.token.lk;

public final class h
  extends c
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  
  public final void a(lj paramlj)
  {
    this.a = paramlj.a(this.a, 0, true);
    this.b = paramlj.a(this.b, 1, true);
    this.c = paramlj.a(2, true);
  }
  
  public final void a(lk paramlk)
  {
    paramlk.a(this.a, 0);
    paramlk.a(this.b, 1);
    paramlk.a(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.h
 * JD-Core Version:    0.7.0.1
 */