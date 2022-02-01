package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class StartSecurityScan
  extends AsyncStep
{
  public int od()
  {
    if (this.a.app.abA()) {
      this.a.app.cLJ();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityScan
 * JD-Core Version:    0.7.0.1
 */