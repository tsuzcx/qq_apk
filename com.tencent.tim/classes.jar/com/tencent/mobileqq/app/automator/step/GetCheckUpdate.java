package com.tencent.mobileqq.app.automator.step;

import acbo;
import acfk;
import acim;
import ackz;
import acla;
import aclb;
import aivr;
import alcm;
import anay;
import andi;
import aqeu.a;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import jpf.a;
import jpp.a;
import wnd;

public class GetCheckUpdate
  extends AsyncStep
{
  a a;
  
  public int od()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(1);
    if (this.cyx == 46) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.aW(true, i);
      return 2;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app;
    if (this.cyx == 46)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.getBusinessHandler(11);
      if (localPublicAccountHandler.isNeedUpdate())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new PublicAccountHandler.b(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new aqeu.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new jpp.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new jpf.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new ackz(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new andi(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new anay(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new aclb(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new acla(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new alcm(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new acfk(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new wnd(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new acim(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new aivr(localQQAppInterface));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a = new a(null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetCheckUpdate$a = null;
    }
  }
  
  class a
    extends acbo
  {
    private a() {}
    
    public void U(boolean paramBoolean, Object paramObject)
    {
      GetCheckUpdate.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */