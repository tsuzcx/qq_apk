package com.tencent.mobileqq.app.automator.step;

import acoz;
import ateh;
import atgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class CloudFileAsyncStep
  extends AsyncStep
{
  public atgg a;
  private int retryCount = 5;
  
  public CloudFileAsyncStep()
  {
    this.jdField_a_of_type_Atgg = new acoz(this);
  }
  
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileAsyncStep", 2, "doStep");
    }
    ((ateh)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(180)).a(this.jdField_a_of_type_Atgg);
    return 2;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CloudFileAsyncStep
 * JD-Core Version:    0.7.0.1
 */