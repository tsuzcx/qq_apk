package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import fmy;

public class UpdateDiscuss
  extends AsyncStep
{
  private DiscussionObserver a;
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new fmy(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).g(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isDiscussionlistok", false))
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a();
      localFriendListHandler.a(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(3));
      return 7;
    }
    c();
    return 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */