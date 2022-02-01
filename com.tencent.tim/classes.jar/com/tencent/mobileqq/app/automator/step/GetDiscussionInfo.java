package com.tencent.mobileqq.app.automator.step;

import acdt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetDiscussionInfo
  extends AsyncStep
{
  public int od()
  {
    ((acdt)this.a.app.getBusinessHandler(6)).cIm();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDiscussionInfo
 * JD-Core Version:    0.7.0.1
 */