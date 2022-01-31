package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import cxg;

public class GetGeneralSettings
  extends AsyncStep
{
  private FriendListObserver a;
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d == 1) {}
    for (boolean bool = true; bool; bool = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cxg(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(bool)) {
        break;
      }
      return 2;
    }
    return 7;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */