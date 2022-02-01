package com.tencent.token;

public abstract class abl
{
  private volatile boolean a = true;
  volatile int b = ww.a.h;
  protected abk c = abk.a;
  
  public abl(int paramInt, abk paramabk)
  {
    this.b = paramInt;
    this.a = true;
    this.c = paramabk;
  }
  
  protected abstract void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2);
  
  public final void b(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2)
  {
    if ((this.a) && (paramInt == (this.b & paramInt))) {
      a(paramInt, paramThread, paramLong, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abl
 * JD-Core Version:    0.7.0.1
 */