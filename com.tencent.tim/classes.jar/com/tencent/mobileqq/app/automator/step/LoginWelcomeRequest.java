package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class LoginWelcomeRequest
  extends AsyncStep
{
  public int od()
  {
    ThreadManager.postImmediately(new LoginWelcomeRequest.1(this), null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest
 * JD-Core Version:    0.7.0.1
 */