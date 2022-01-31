package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.qphone.base.util.QLog;

public class StartService
  extends Step
{
  protected boolean a()
  {
    if (StartService.StartServiceState.a) {}
    for (;;)
    {
      return true;
      StartService.StartServiceState.a = true;
      try
      {
        QLog.init(BaseApplicationImpl.a);
        label18:
        BaseApplicationImpl.a.startService();
        Object localObject = BaseApplicationImpl.a.waitAppRuntime(null);
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          continue;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
        localQQAppInterface.onGuardEvent(6, 0L, 0L);
        if (!localQQAppInterface.e()) {
          continue;
        }
        Automator localAutomator1 = localQQAppInterface.a;
        Automator localAutomator2 = localQQAppInterface.a;
        if (this.x == 18) {}
        for (localObject = "{[11,13],16,19,20,21}";; localObject = "{{4,3,5,6},[11,13],16,19,20,21,36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46,51}")
        {
          localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
          localQQAppInterface.start(false);
          return true;
        }
      }
      catch (Exception localException)
      {
        break label18;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */