package com.tencent.token;

public abstract class abm
{
  private volatile boolean a = true;
  volatile int b = wx.a.h;
  protected abl c = abl.a;
  
  public abm(int paramInt, abl paramabl)
  {
    this.b = paramInt;
    this.a = true;
    this.c = paramabl;
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
 * Qualified Name:     com.tencent.token.abm
 * JD-Core Version:    0.7.0.1
 */