package com.tencent.mobileqq.startup.step;

import anmp;
import mqq.app.MobileQQ;

public class BroadcastReportRegister
  extends Step
{
  protected boolean doStep()
  {
    MobileQQ.sMobileQQ.registerAppCallbacks(new anmp(this));
    this.mDirector = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.BroadcastReportRegister
 * JD-Core Version:    0.7.0.1
 */