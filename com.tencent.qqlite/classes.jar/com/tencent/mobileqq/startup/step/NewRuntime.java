package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;

public class NewRuntime
  extends Step
{
  protected boolean a()
  {
    BaseApplicationImpl.a.doInit(false);
    if ((GuardManager.a == null) && ("com.tencent.qqlite".equals(BaseApplicationImpl.processName))) {
      GuardManager.a = new GuardManager(BaseApplicationImpl.a, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NewRuntime
 * JD-Core Version:    0.7.0.1
 */