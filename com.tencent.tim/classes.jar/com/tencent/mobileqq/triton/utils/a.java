package com.tencent.mobileqq.triton.utils;

public class a
{
  private volatile double a = 0.0D;
  private volatile long b = -1000L;
  private int c = 0;
  
  public void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    for (this.a = 0.0D;; this.a = (1000000000.0D / (paramFloat * 1.0D)))
    {
      this.b = 0L;
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.a == 0.0D) {
      return bool2;
    }
    long l = paramLong - this.b;
    double d = l / this.a;
    int i = this.c;
    if (d > i) {
      this.c = (i + 1);
    }
    for (;;)
    {
      bool2 = bool1;
      if (l <= 1000000000L) {
        break;
      }
      this.b = paramLong;
      this.c = 0;
      return bool1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.a
 * JD-Core Version:    0.7.0.1
 */