package com.tencent.mobileqq.startup.step;

import acoo;
import annm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

public class StartService
  extends Step
{
  public static boolean cIM;
  
  protected boolean doStep()
  {
    Object localObject = null;
    if (cIM) {
      return true;
    }
    cIM = true;
    if (BaseApplicationImpl.sProcessId != 4)
    {
      BaseApplicationImpl.sApplication.startService();
      localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    }
    label48:
    QQAppInterface localQQAppInterface;
    Automator localAutomator1;
    Automator localAutomator2;
    if (BaseApplicationImpl.sProcessId == 7)
    {
      annm.QM("com.tencent.mobileqq:tool");
      if (BaseApplicationImpl.sProcessId != 1) {
        break label129;
      }
      localQQAppInterface = (QQAppInterface)localObject;
      localQQAppInterface.onGuardEvent(6, 0L, 0L);
      if (!localQQAppInterface.abl()) {
        break label137;
      }
      localAutomator1 = localQQAppInterface.a;
      localAutomator2 = localQQAppInterface.a;
      if (this.mId != 21) {
        break label131;
      }
    }
    label129:
    label131:
    for (localObject = "{[11,12,14],17,20,21,22109,}";; localObject = "{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}")
    {
      localAutomator1.a(acoo.a(localAutomator2, (String)localObject));
      localQQAppInterface.start(false);
      return true;
      if (BaseApplicationImpl.sProcessId != 11) {
        break label48;
      }
      annm.QM("com.tencent.mobileqq:miniapp");
      break label48;
      break;
    }
    label137:
    BaseApplicationImpl.appStartTime = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */