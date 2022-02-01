package com.tencent.token;

import java.util.concurrent.CountDownLatch;

final class pe
  implements Runnable
{
  pe(pd parampd, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      pg localpg = new pg(this.b.a);
      pd.a(this.b, localpg.getInt("_build_info_sdk_int_", 0));
    }
    catch (Exception localException)
    {
      localException.getMessage();
    }
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pe
 * JD-Core Version:    0.7.0.1
 */