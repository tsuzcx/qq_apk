package com.tencent.qqmail.launcher.third;

import com.tencent.qqmail.launcher.base.BaseLauncherActivity;
import com.tencent.qqmail.launcher.base.WelcomeLoader;

public abstract class ThirdLauncherActivity
  extends BaseLauncherActivity
{
  public void initUI()
  {
    if (WelcomeLoader.getInstance().isFinish())
    {
      route();
      return;
    }
    WelcomeLoader.getInstance().registerCallback(new ThirdLauncherActivity.1(this));
  }
  
  protected abstract void route();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.ThirdLauncherActivity
 * JD-Core Version:    0.7.0.1
 */