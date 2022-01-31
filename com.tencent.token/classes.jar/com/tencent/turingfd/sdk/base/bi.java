package com.tencent.turingfd.sdk.base;

public class bi
  extends Thread
{
  public bi(bm parambm) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      label6:
      bm localbm = this.a;
      bm.a(localbm, bm.a(localbm).a);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bi
 * JD-Core Version:    0.7.0.1
 */