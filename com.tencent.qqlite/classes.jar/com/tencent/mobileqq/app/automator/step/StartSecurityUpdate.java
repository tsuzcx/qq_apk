package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask;
import java.util.Timer;

public class StartSecurityUpdate
  extends AsyncStep
{
  protected int a()
  {
    this.a.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.a.jdField_a_of_type_JavaUtilTimer.schedule(new QPSingleUpdTimerTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 300000L, 86400000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityUpdate
 * JD-Core Version:    0.7.0.1
 */