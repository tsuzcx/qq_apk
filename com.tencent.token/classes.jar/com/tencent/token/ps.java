package com.tencent.token;

import java.util.concurrent.CountDownLatch;

final class ps
  implements Runnable
{
  ps(pr parampr, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      pu localpu = new pu(this.b.a);
      pr.a(this.b, localpu.getInt("_build_info_sdk_int_", 0));
    }
    catch (Exception localException)
    {
      localException.getMessage();
    }
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ps
 * JD-Core Version:    0.7.0.1
 */