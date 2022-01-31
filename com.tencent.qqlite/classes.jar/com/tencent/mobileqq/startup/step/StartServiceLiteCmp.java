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
      ((QQAppInterface)localObject).a.a(StepFactory.a(((QQAppInterface)localObject).a, "{{4,3,5,6},36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46}"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartServiceLiteCmp
 * JD-Core Version:    0.7.0.1
 */