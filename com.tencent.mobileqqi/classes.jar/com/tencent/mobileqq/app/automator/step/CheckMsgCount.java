package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import fhm;

public class CheckMsgCount
  extends AsyncStep
{
  protected int a()
  {
    ThreadManager.a(new fhm(this));
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckMsgCount
 * JD-Core Version:    0.7.0.1
 */