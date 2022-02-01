package com.tencent.mobileqq.app.automator;

import acon;

public class ParallGroup
  extends StepGroup
  implements acon
{
  protected int cyC;
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.cyC - 1;
      this.cyC = paramInt;
      if (paramInt == 0)
      {
        setResult(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
  
  protected int od()
  {
    this.cyC = this.el.length;
    for (;;)
    {
      AsyncStep localAsyncStep = a();
      if ((localAsyncStep == null) || (this.mResult == 8)) {
        break;
      }
      localAsyncStep.a = this;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b(localAsyncStep);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ParallGroup
 * JD-Core Version:    0.7.0.1
 */