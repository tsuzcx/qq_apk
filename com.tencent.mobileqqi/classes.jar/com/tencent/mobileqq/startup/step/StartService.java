package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.qphone.base.util.QLog;

public class StartService
  extends Step
{
  public static boolean a = false;
  
  protected boolean a()
  {
    if (a) {}
    for (;;)
    {
      return true;
      a = true;
      try
      {
        QLog.init(BaseApplicationImpl.a);
        BaseApplicationImpl.a.startService();
        Object localObject = BaseApplicationImpl.a.waitAppRuntime(null);
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          continue;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
        if (!localQQAppInterface.e()) {
          continue;
        }
        Automator localAutomator1 = localQQAppInterface.a;
        Automator localAutomator2 = localQQAppInterface.a;
        if (this.x == 19)
        {
          localObject = "{[10,11,13],16,19,20,21}";
          localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
          localQQAppInterface.start(false);
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("BaseApplication", 2, "init QLog error " + localException, localException);
            continue;
            String str = "{{4,3,5,6},[10,11,13],16,19,20,21,38,39,[24,9,25,27,28,29,30,31,32,33,35,36,37,41,42,43,45,46],49,50}";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */