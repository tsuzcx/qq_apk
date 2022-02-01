package com.tencent.mobileqq.startup.director;

import acmq;
import anmo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.a;
import tzc;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(anmo paramanmo) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    acmq.a().a(DeviceProfileManager.a());
    if (anmo.dKh != 0)
    {
      tzc.a().stop(anmo.dKh);
      anmo.dKh = 0;
    }
    Step.a.b(30, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */