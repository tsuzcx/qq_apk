package com.tencent.token;

import com.tencent.token.global.c.a;

public abstract class dy
{
  private volatile int a = c.a.h;
  private volatile boolean b = true;
  private dx c = dx.a;
  
  public dy(int paramInt, boolean paramBoolean, dx paramdx)
  {
    a(paramInt);
    a(paramBoolean);
    a(paramdx);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected abstract void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable);
  
  public void a(dx paramdx)
  {
    this.c = paramdx;
  }
  
  protected abstract void a(String paramString);
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((c()) && (paramInt == (this.a & paramInt))) {
      a(paramInt, paramThread, paramLong, paramString1, paramString2, paramThrowable);
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public dx d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dy
 * JD-Core Version:    0.7.0.1
 */