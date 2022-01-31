package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import fmw;
import mqq.observer.AccountObserver;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver a;
  
  protected int a()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver == null)
    {
      this.jdField_a_of_type_MqqObserverAccountObserver = new fmw(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.m();
    return 2;
  }
  
  public void a()
  {
    if (this.h == 12)
    {
      this.i = 0;
      return;
    }
    this.i = 10;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_MqqObserverAccountObserver = null;
    }
    if ((this.h == 11) && (this.g == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush
 * JD-Core Version:    0.7.0.1
 */