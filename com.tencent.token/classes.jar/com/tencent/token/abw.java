package com.tencent.token;

public abstract class abw
{
  private volatile boolean a = true;
  volatile int b = xf.a.h;
  protected abv c = abv.a;
  
  public abw(int paramInt, abv paramabv)
  {
    this.b = paramInt;
    this.a = true;
    this.c = paramabv;
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
 * Qualified Name:     com.tencent.token.abw
 * JD-Core Version:    0.7.0.1
 */