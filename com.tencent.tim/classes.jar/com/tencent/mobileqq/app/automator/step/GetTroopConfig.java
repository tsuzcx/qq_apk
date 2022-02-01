package com.tencent.mobileqq.app.automator.step;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopConfig
  extends AsyncStep
{
  public int od()
  {
    if (this.a.app != null) {
      ((acms)this.a.app.getBusinessHandler(20)).cMH();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopConfig
 * JD-Core Version:    0.7.0.1
 */