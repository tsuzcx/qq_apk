package com.tencent.mobileqq.app.automator.step;

import acdt;
import acdu;
import acdv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateDiscuss
  extends AsyncStep
{
  private acdv a;
  
  private void cNJ()
  {
    if (this.jdField_a_of_type_Acdv == null)
    {
      this.jdField_a_of_type_Acdv = new a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Acdv);
    }
    ((acdt)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(6)).hp(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin()).longValue());
  }
  
  public int od()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.O.getBoolean("isDiscussionlistok", false);
    acdu localacdu = (acdu)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(53);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(1);
      localacdu.cIn();
      localFriendListHandler.notifyUI(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localacdu.cIn();
    cNJ();
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Acdv != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Acdv);
      this.jdField_a_of_type_Acdv = null;
    }
  }
  
  class a
    extends acdv
  {
    private a() {}
    
    public void AW(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "updateDiscussionList: " + paramBoolean);
      }
      if (!paramBoolean)
      {
        UpdateDiscuss.this.setResult(6);
        return;
      }
      UpdateDiscuss.this.a.O.edit().putBoolean("isDiscussionlistok", true).commit();
      UpdateDiscuss.this.a.notifyUI(3, true, Integer.valueOf(3));
      UpdateDiscuss.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */