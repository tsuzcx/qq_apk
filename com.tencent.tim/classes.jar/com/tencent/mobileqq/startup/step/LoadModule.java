package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import anna;
import annb;
import annc;
import annd;
import anne;
import annf;
import anng;
import annh;
import anni;
import annj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.imcore.IMCore;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.AIOUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.CaughtExceptionReport;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.SQLiteFTSUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LoadModule
  extends Step
{
  private static IMCoreProxyRoute.MsgProxyUtils.Proxy MsgProxyUtilsProxy = new anna();
  private static IMCoreProxyRoute.OGEntityDaoManager.Proxy OGEntityDaoManagerProxy;
  private static IMCoreProxyRoute.GetStaticProxy<AppRuntime> jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$GetStaticProxy = new anni();
  private static IMCoreProxyRoute.TableBuilder.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$TableBuilder$Proxy = new annb();
  private static volatile boolean isInit;
  
  static
  {
    OGEntityDaoManagerProxy = new annj();
  }
  
  private static void dRS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyImport Start, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.OGEntityDaoManager.registerProxy(OGEntityDaoManagerProxy);
    IMCoreProxyRoute.TableBuilder.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$TableBuilder$Proxy);
    IMCoreProxyRoute.MsgProxyUtils.registerProxy(MsgProxyUtilsProxy);
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", BaseApplicationImpl.processName });
    }
  }
  
  private static void dRT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport Start, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.StatisticCollector.registerProxy(new annc());
    IMCoreProxyRoute.CaughtExceptionReport.registerProxy(new annd());
    IMCoreProxyRoute.SQLiteFTSUtils.registerProxy(new anne());
    IMCoreProxyRoute.ThreadTraceHelper.registerProxy(new annf());
    IMCoreProxyRoute.AIOUtils.registerProxy(new anng());
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.ThreadRegulator.registerProxy(new annh());
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", BaseApplicationImpl.processName, " isInit=", Boolean.valueOf(isInit) });
    }
    if (isInit) {}
    long l;
    do
    {
      return true;
      isInit = true;
      l = SystemClock.uptimeMillis();
      IMCore.syncAppSetting(true, false, false, false);
      IMCore.init(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$GetStaticProxy);
      dRS();
      ThreadManager.getSubThreadHandler().post(new LoadModule.1(this));
    } while (!QLog.isColorLevel());
    QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Finish, cost=", Long.valueOf(SystemClock.uptimeMillis() - l) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule
 * JD-Core Version:    0.7.0.1
 */