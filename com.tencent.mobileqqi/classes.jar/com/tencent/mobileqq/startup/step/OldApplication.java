package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class OldApplication
  extends Step
{
  protected boolean a()
  {
    BaseApplicationImpl.appnewmsgicon = 2130838143;
    BaseApplicationImpl.appnewavmsgicon = 2130838269;
    BaseApplicationImpl.qqlaunchicon = 2130838016;
    BaseApplicationImpl.qqwifiicon = 2130838144;
    BaseApplicationImpl.defaultNotifSoundResourceId = 2131165197;
    BaseApplicationImpl.devlockQuickloginIcon = 2130838588;
    BaseApplicationImpl.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    BaseApplicationImpl.b = BaseApplicationImpl.jdField_a_of_type_Long;
    BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler = new Handler();
    TimeFormatterUtils.a();
    try
    {
      Class.forName("android.os.AsyncTask");
      return "com.tencent.mobileqqi".equals(BaseApplicationImpl.processName);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */