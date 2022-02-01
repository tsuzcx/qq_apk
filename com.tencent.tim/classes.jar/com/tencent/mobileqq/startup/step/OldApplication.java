package com.tencent.mobileqq.startup.step;

import aciu;
import android.os.Build.VERSION;
import android.os.SystemClock;
import aqmm;
import aqmu;
import avgc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.statistics.UEC;
import mqq.app.Foreground;
import mqq.app.lifecycle.MobileQQActivityLifeCycle;
import mqq.os.MqqHandler;

public class OldApplication
  extends Step
{
  protected boolean doStep()
  {
    mqq.app.MainService.isDebugVersion = false;
    mqq.app.MainService.isGrayVersion = false;
    long l;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      l = SystemClock.uptimeMillis();
      BaseApplicationImpl.sLaunchTime = l;
      BaseApplicationImpl.sShowTime = l;
      BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
      BaseApplicationImpl.sUiHandler = new MqqHandler();
    }
    for (;;)
    {
      IPluginAdapterProxy.setProxy(new avgc());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new aqmm());
      aqmu.init();
      BaseApplicationImpl.appnewmsgicon = 2130842268;
      BaseApplicationImpl.appnewavmsgicon = 2130842979;
      BaseApplicationImpl.qqlaunchicon = 2130840732;
      BaseApplicationImpl.qqWifiLayout = 2131562052;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131382262;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131382263;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131382254;
      BaseApplicationImpl.qqWifiSettingViewId = 2131382261;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131382264;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131382265;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131382255;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130847809;
      BaseApplicationImpl.qqWifiNoSignal = 2130847810;
      BaseApplicationImpl.qqWifiUserful = 2130847815;
      BaseApplicationImpl.qqWifiSettings = 2130847814;
      BaseApplicationImpl.qqWifiOperation = 2130847808;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130847813;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130847812;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130847811;
      BaseApplicationImpl.qqwifinotifydivide = 2131166612;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130845074;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (aciu.abf()))
      {
        MobileQQActivityLifeCycle localMobileQQActivityLifeCycle = new MobileQQActivityLifeCycle(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
        UEC.a().a(localMobileQQActivityLifeCycle);
      }
      try
      {
        Class.forName("android.os.AsyncTask");
        if (BaseApplicationImpl.sProcessId == 1)
        {
          return true;
          if ((BaseApplicationImpl.sProcessId == 4) || (BaseApplicationImpl.sProcessId != 2)) {
            continue;
          }
          l = System.currentTimeMillis();
          BaseApplicationImpl.sLaunchTime = l;
          BaseApplicationImpl.sShowTime = l;
          BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */