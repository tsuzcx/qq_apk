package com.tencent.tim.mail;

import augm;
import augo;
import augr;
import augs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class MailPluginPreload
  extends AsyncStep
{
  private augr a;
  
  public MailPluginPreload()
  {
    this.jdField_a_of_type_Augr = new augs(this);
  }
  
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginPreload", 2, "MailPluginPreload start");
    }
    ((augo)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(374)).euR();
    augm localaugm = (augm)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(179);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Augr);
    localaugm.nt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getLongAccountUin());
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Augr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Augr);
      this.jdField_a_of_type_Augr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginPreload
 * JD-Core Version:    0.7.0.1
 */