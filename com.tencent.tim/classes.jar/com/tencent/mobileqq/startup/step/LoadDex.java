package com.tencent.mobileqq.startup.step;

import ahwd;
import android.os.Build.VERSION;
import aqum;
import arnf;
import arng;
import arwd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import mqq.os.MqqHandler;
import sws;
import tnh;

public class LoadDex
  extends Step
{
  private void dRR()
  {
    boolean bool1 = arng.co(BaseApplicationImpl.sApplication);
    boolean bool2 = arng.cp(BaseApplicationImpl.sApplication);
    if (QLog.isColorLevel()) {
      QLog.d("ExternalDirFileOperationMonitor", 2, "init hook, remove: " + bool1 + ", open: " + bool2);
    }
    NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupFileHook(new arnf(BaseApplicationImpl.getContext()), bool1, bool2);
  }
  
  protected boolean doStep()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
      tnh.cZ(BaseApplicationImpl.sApplication);
    }
    label83:
    label88:
    do
    {
      return true;
      boolean bool1;
      if ((!AppSetting.Nv()) || (this.mId == 1))
      {
        bool1 = true;
        BaseApplicationImpl.sInjectResult = InjectUtils.injectExtraDexes(BaseApplicationImpl.sApplication, bool1);
        if (bool1) {
          if (BaseApplicationImpl.sInjectResult != null) {
            break label83;
          }
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        BaseApplicationImpl.isCurrentVersionFirstLaunch = bool2;
        if ((bool1) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {
          break label88;
        }
        return false;
        bool1 = false;
        break;
      }
    } while (!"Success".equals(BaseApplicationImpl.sInjectResult));
    try
    {
      tnh.cZ(BaseApplicationImpl.sApplication);
      aqum.a().fJ(BaseApplicationImpl.sApplication);
      if (BaseApplicationImpl.sProcessId == 1)
      {
        eipc.EIPCContentProvider.sIsDexInjectFinish = true;
        ThreadRegulator.a().init();
      }
      if (BaseApplicationImpl.sProcessId != 4)
      {
        Step.a.dRW();
        Step.c.dRX();
      }
      if (2 != BaseApplicationImpl.sProcessId)
      {
        if ((7 == BaseApplicationImpl.sProcessId) || (11 == BaseApplicationImpl.sProcessId)) {
          ThreadManager.getSubThreadHandler().post(Step.a.b(14, this.mDirector, null));
        }
      }
      else
      {
        if (1 != BaseApplicationImpl.sProcessId) {
          break label432;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.1(this), 30000L);
      }
      for (;;)
      {
        if (1 == BaseApplicationImpl.sProcessId) {
          ThreadManager.getFileThreadHandler().post(new LoadDex.3(this));
        }
        if ((Build.VERSION.SDK_INT < 24) || (BaseApplicationImpl.sProcessId != 1)) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.4(this), 3000L);
        }
        if (BaseApplicationImpl.sProcessId == 4) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.5(this), 3000L);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.6(this), 3000L);
        if ((BaseApplicationImpl.processName != null) && (Build.VERSION.SDK_INT >= 21) && (BaseApplicationImpl.processName.endsWith("TMAssistantDownloadSDKService"))) {
          DownloadTaskNotifier.get().addListener(arwd.a());
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          Step.a.b(8, this.mDirector, null).step();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.8(this), 5000L);
        dRR();
        if (BaseApplicationImpl.sProcessId != 1) {
          UnifiedMonitor.dSU();
        }
        ahwd.initHandler();
        sws.initHandler();
        return true;
        if (1 == BaseApplicationImpl.sProcessId) {
          break;
        }
        ThreadManager.getSubThreadHandler().postDelayed(Step.a.b(14, this.mDirector, null), 3000L);
        break;
        label432:
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.2(this), 5000L);
      }
      return true;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */