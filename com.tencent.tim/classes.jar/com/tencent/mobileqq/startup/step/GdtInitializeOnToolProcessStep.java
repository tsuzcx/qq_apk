package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import thr;

final class GdtInitializeOnToolProcessStep
  extends Step
{
  static void l(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  protected boolean doStep()
  {
    try
    {
      l("GdtInitializeOnToolProcessStep", "doStep", null);
      long l = System.currentTimeMillis();
      ThreadManager.excute(new GdtInitializeOnToolProcessStep.1(this), 16, null, true);
      thr.a().cV(BaseApplicationImpl.getContext());
      l("GdtInitializeOnToolProcessStep", "doStep durationMillis:" + (System.currentTimeMillis() - l), null);
      return true;
    }
    catch (Throwable localThrowable)
    {
      l("GdtInitializeOnToolProcessStep", "doStep", localThrowable);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.GdtInitializeOnToolProcessStep
 * JD-Core Version:    0.7.0.1
 */