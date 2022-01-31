package com.tencent.token;

import com.tencent.token.global.d;

public abstract class fg
{
  private volatile int a = d.h;
  private volatile boolean b = true;
  private ff c = ff.a;
  
  public fg(int paramInt, boolean paramBoolean, ff paramff)
  {
    a(paramInt);
    a(paramBoolean);
    a(paramff);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected abstract void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable);
  
  public void a(ff paramff)
  {
    this.c = paramff;
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
  
  public ff d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fg
 * JD-Core Version:    0.7.0.1
 */