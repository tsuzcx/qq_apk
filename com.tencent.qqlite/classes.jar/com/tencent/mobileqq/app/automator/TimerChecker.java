package com.tencent.mobileqq.app.automator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TimerChecker
  extends AsyncStep
{
  private static final String c = "LAST_UPDATE_TIME_PRE_";
  private static final String d = "TIMER_CHECK_STEP";
  private static final int j = 1000;
  private ParallGroup a;
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.run();
    }
    return 7;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject = StepFactory.jdField_a_of_type_ArrayOfInt;
    StringBuilder localStringBuilder = new StringBuilder("[");
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      if ((l - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getLong("LAST_UPDATE_TIME_PRE_" + localObject[i], 0L) >= localObject[i] * 60 * 60 * 1000) && (StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i].length() > 2))
      {
        localStringBuilder.append(StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i]).append(',');
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.edit().putLong("LAST_UPDATE_TIME_PRE_" + localObject[i], l).commit();
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    if ((((String)localObject).substring(0, ((String)localObject).length() - 1) + "]").length() > 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup = new ParallGroup();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.c = localStringBuilder.toString();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.b = "TIMER_CHECK_STEP";
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.h = 1000;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorParallGroup.i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.TimerChecker
 * JD-Core Version:    0.7.0.1
 */