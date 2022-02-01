package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import jnp;

public class GetTroopRedPointInfoStep
  extends AsyncStep
{
  public int od()
  {
    ((jnp)this.a.app.getBusinessHandler(43)).yd();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep
 * JD-Core Version:    0.7.0.1
 */