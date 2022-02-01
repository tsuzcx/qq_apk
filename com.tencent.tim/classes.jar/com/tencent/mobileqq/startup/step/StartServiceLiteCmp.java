package com.tencent.mobileqq.startup.step;

import acoo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

public class StartServiceLiteCmp
  extends Step
{
  protected boolean doStep()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).abl()) {
        ((QQAppInterface)localObject).a.a(acoo.a(((QQAppInterface)localObject).a, "{{4,3,5,6},44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58}"));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartServiceLiteCmp
 * JD-Core Version:    0.7.0.1
 */