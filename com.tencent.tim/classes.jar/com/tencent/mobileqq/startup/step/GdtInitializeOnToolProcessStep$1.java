package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import tjp;

class GdtInitializeOnToolProcessStep$1
  implements Runnable
{
  GdtInitializeOnToolProcessStep$1(GdtInitializeOnToolProcessStep paramGdtInitializeOnToolProcessStep) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      tjp.a().init(BaseApplicationImpl.getContext());
      GdtInitializeOnToolProcessStep.l("GdtInitializeOnToolProcessStep", "ipc register durationMillis:" + (System.currentTimeMillis() - l), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      GdtInitializeOnToolProcessStep.l("GdtInitializeOnToolProcessStep", "doStep", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.GdtInitializeOnToolProcessStep.1
 * JD-Core Version:    0.7.0.1
 */