package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CheckMsgCount
  extends AsyncStep
{
  public int od()
  {
    ThreadManager.post(new CheckMsgCount.1(this), 5, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckMsgCount
 * JD-Core Version:    0.7.0.1
 */