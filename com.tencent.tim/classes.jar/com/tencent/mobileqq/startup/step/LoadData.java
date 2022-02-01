package com.tencent.mobileqq.startup.step;

import aako;
import anmo;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import swu;

public class LoadData
  extends Step
{
  protected boolean doStep()
  {
    boolean bool2 = true;
    AppActivity localAppActivity = this.mDirector.d;
    long l = System.currentTimeMillis();
    swu.DH = l;
    if (localAppActivity != null)
    {
      if (swu.aE(BaseApplicationImpl.sApplication)) {
        aako.t(BaseApplicationImpl.sApplication, true);
      }
    }
    else {
      return false;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    if (this.mId == 19)
    {
      bool1 = true;
      if ((!localAppActivity.preloadData(localAppRuntime, bool1)) || (System.currentTimeMillis() - l >= 550L)) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */