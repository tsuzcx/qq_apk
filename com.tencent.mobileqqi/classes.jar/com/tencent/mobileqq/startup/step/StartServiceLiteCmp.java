package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartServiceLiteCmp
  extends Step
{
  protected boolean a()
  {
    Object localObject = BaseApplicationImpl.a.a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ((QQAppInterface)localObject).a.a(StepFactory.a(((QQAppInterface)localObject).a, "{{4,3,5,6},38,39,[24,9,25,27,28,29,30,31,32,33,35,36,37,41,42,43,45,46],49}"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartServiceLiteCmp
 * JD-Core Version:    0.7.0.1
 */