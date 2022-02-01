package com.tencent.biz.pubaccount.readinjoy.automator;

import kpg;
import kpi;

public class AsyncSteps$1
  implements Runnable
{
  public AsyncSteps$1(kpg paramkpg, kpi paramkpi) {}
  
  public void run()
  {
    if (this.a.Aj())
    {
      this.a.onEnd();
      this.this$0.onEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1
 * JD-Core Version:    0.7.0.1
 */