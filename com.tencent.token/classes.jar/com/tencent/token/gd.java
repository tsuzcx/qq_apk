package com.tencent.token;

import com.tencent.token.global.c;

public abstract class gd
{
  private volatile int a = c.h;
  private volatile boolean b = true;
  private gc c = gc.a;
  
  public gd()
  {
    this(63, gc.a);
  }
  
  public gd(int paramInt, gc paramgc)
  {
    this.a = paramInt;
    this.b = true;
    this.c = paramgc;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected abstract void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2);
  
  public final void b(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2)
  {
    if ((this.b) && (paramInt == (this.a & paramInt))) {
      a(paramInt, paramThread, paramLong, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gd
 * JD-Core Version:    0.7.0.1
 */