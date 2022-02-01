package com.tencent.biz.pubaccount.readinjoy.automator;

import kpg;
import kph;
import kpi;
import kpl;
import kpm;

public class Automator$6
  implements Runnable
{
  public Automator$6(kph paramkph, kpi paramkpi) {}
  
  public void run()
  {
    this.a.onEnd();
    kpl localkpl = this.a.a();
    if ((localkpl instanceof kpg))
    {
      ((kpg)localkpl).aFI();
      return;
    }
    if ((localkpl instanceof kpm))
    {
      ((kpm)localkpl).aFK();
      return;
    }
    kph.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */