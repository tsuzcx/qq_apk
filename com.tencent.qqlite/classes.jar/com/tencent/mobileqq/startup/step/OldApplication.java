package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import cooperation.plugin.PluginAdapterImpl;

public class OldApplication
  extends Step
{
  protected boolean a()
  {
    BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
    SoLoadUtilNew.setReport(new SoLoadReportImpl());
    TimeFormatterUtils.a();
    BaseApplicationImpl.appnewmsgicon = 2130838144;
    BaseApplicationImpl.qqlaunchicon = 2130838046;
    BaseApplicationImpl.defaultNotifSoundResourceId = 2131165185;
    BaseApplicationImpl.devlockQuickloginIcon = 2130838504;
    mqq.app.MainService.isDebugVersion = false;
    if (BaseApplicationImpl.h == 1)
    {
      BaseApplicationImpl.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      BaseApplicationImpl.b = BaseApplicationImpl.jdField_a_of_type_Long;
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler = new Handler();
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    }
    try
    {
      for (;;)
      {
        Class.forName("android.os.AsyncTask");
        return "com.tencent.qqlite".equals(BaseApplicationImpl.processName);
        if (BaseApplicationImpl.h != 4) {
          IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */