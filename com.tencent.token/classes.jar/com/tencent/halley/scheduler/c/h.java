package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.li;
import com.tencent.token.lj;

public final class h
  extends c
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  
  public final void a(li paramli)
  {
    this.a = paramli.a(this.a, 0, true);
    this.b = paramli.a(this.b, 1, true);
    this.c = paramli.a(2, true);
  }
  
  public final void a(lj paramlj)
  {
    paramlj.a(this.a, 0);
    paramlj.a(this.b, 1);
    paramlj.a(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.h
 * JD-Core Version:    0.7.0.1
 */