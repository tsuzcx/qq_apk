package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import cxv;
import mqq.observer.AccountObserver;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver a;
  
  protected int a()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver == null)
    {
      this.jdField_a_of_type_MqqObserverAccountObserver = new cxv(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().e();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.l();
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
  
  public void a(int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.b + " RESULT_NET_CONNECT resend request!");
      }
    }
    super.a(paramInt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_MqqObserverAccountObserver = null;
    }
    if ((this.h == 11) && (this.g == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush
 * JD-Core Version:    0.7.0.1
 */