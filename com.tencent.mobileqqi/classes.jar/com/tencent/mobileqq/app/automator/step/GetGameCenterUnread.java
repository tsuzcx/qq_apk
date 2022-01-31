package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import fml;

public class GetGameCenterUnread
  extends AsyncStep
{
  private fml a;
  
  public GetGameCenterUnread(Automator paramAutomator, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = paramAutomator;
    this.h = paramInt;
  }
  
  protected int a()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(11);
    if (localGameCenterManagerImp != null)
    {
      if (this.jdField_a_of_type_Fml == null)
      {
        this.jdField_a_of_type_Fml = new fml(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.registObserver(this.jdField_a_of_type_Fml);
      }
      localGameCenterManagerImp.b();
      return 2;
    }
    return 7;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Fml != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.unRegistObserver(this.jdField_a_of_type_Fml);
      this.jdField_a_of_type_Fml = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGameCenterUnread
 * JD-Core Version:    0.7.0.1
 */