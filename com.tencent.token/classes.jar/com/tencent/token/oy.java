package com.tencent.token;

import java.util.concurrent.CountDownLatch;

final class oy
  implements Runnable
{
  oy(ox paramox, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      pa localpa = new pa(this.b.a);
      ox.a(this.b, localpa.getInt("_build_info_sdk_int_", 0));
    }
    catch (Exception localException)
    {
      localException.getMessage();
    }
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oy
 * JD-Core Version:    0.7.0.1
 */