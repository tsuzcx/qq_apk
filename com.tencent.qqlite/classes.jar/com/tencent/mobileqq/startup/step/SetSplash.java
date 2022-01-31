package com.tencent.mobileqq.startup.step;

import android.content.res.Resources.NotFoundException;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class SetSplash
  extends Step
{
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (bool) {
        return true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "doStep fail init activity preview:" + localNotFoundException.getMessage());
      }
      this.a.b = SetSplashImpl.a(localAppActivity);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */