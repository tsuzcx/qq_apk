package com.tencent.token;

import com.tencent.halley.common.g;

final class bf
  extends Thread
{
  private bq a;
  
  bf(be parambe, bq parambq)
  {
    this.a = parambq;
  }
  
  public final void run()
  {
    try
    {
      Thread.sleep(10000L);
      g.a("B_ACSDK_SDK_Result", g.a(this.a));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bf
 * JD-Core Version:    0.7.0.1
 */