package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mqp.app.sec.ScConfigManager;

public class CheckSafeCenterConfig
  extends AsyncStep
{
  public int od()
  {
    if (this.cyx == 98) {
      ScConfigManager.a().bf(this.a.app, "SecCenterConfig");
    }
    for (;;)
    {
      return 7;
      if (this.cyx == 99) {
        ScConfigManager.a().r(this.a.app, "SecCenterConfig", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig
 * JD-Core Version:    0.7.0.1
 */