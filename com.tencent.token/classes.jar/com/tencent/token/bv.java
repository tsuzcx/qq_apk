package com.tencent.token;

import java.util.concurrent.CountDownLatch;

final class bv
  implements Runnable
{
  private CountDownLatch a = null;
  private bw b = null;
  private bs c = null;
  
  public bv(CountDownLatch paramCountDownLatch, bw parambw, bs parambs)
  {
    this.a = paramCountDownLatch;
    this.b = parambw;
    this.c = parambs;
  }
  
  public final void run()
  {
    try
    {
      this.c.a();
      bt.a = this.c.d();
      bt.b = this.c.e();
      this.b.a(this.c);
      label38:
      if (this.a != null) {
        this.a.countDown();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bv
 * JD-Core Version:    0.7.0.1
 */