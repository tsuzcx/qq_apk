package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckUpgrade
  extends AsyncStep
{
  protected int a()
  {
    if ((this.a.a != null) && (!GuardManager.a.a())) {
      this.a.a.a(0);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckUpgrade
 * JD-Core Version:    0.7.0.1
 */