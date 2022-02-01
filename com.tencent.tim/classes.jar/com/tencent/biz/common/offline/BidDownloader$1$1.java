package com.tencent.biz.common.offline;

import joz;

public class BidDownloader$1$1
  extends Thread
{
  public BidDownloader$1$1(joz paramjoz) {}
  
  public void run()
  {
    if (this.a.this$0.failCount == 1) {}
    for (;;)
    {
      try
      {
        Thread.sleep(5000L);
        this.a.this$0.ayQ();
        return;
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        continue;
      }
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */