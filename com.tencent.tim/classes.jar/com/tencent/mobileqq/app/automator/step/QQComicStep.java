package com.tencent.mobileqq.app.automator.step;

import acpi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class QQComicStep
  extends AsyncStep
{
  public int od()
  {
    this.a.mApp.addObserver(new acpi(this), true);
    ThreadManager.getUIHandler().postDelayed(new QQComicStep.2(this), 3000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQComicStep
 * JD-Core Version:    0.7.0.1
 */