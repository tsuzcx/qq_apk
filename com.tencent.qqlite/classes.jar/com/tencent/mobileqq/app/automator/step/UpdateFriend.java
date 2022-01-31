package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import cxz;

public class UpdateFriend
  extends AsyncStep
{
  private FriendListObserver a;
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cxz(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
  }
  
  protected int a()
  {
    if (this.h == 3)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFriendlistok", false);
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        bool = localFriendsManager.a();
        localFriendListHandler.a(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(1));
        return 7;
      }
      localFriendsManager.a();
      c();
      return 2;
    }
    if (this.h == 7)
    {
      c();
      return 2;
    }
    return 7;
  }
  
  public void a()
  {
    if (this.h == 3) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
    }
    if (this.h == 8) {}
    for (int i = 0;; i = 2)
    {
      this.i = i;
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */