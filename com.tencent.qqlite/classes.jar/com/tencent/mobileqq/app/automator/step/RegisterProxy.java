package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import cxs;
import cxt;
import java.util.HashMap;

public class RegisterProxy
  extends AsyncStep
{
  private static final int j = 0;
  private static final int k = 1;
  private static final int l = 2;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private cxs jdField_a_of_type_Cxs;
  public long c;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  
  public RegisterProxy()
  {
    this.jdField_c_of_type_Long = 0L;
  }
  
  private boolean b()
  {
    return (this.n == 2) && (this.o == 2) && (this.p == 2);
  }
  
  private void c()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    HashMap localHashMap;
    String str;
    if (BaseApplicationImpl.jdField_a_of_type_Long < 0L)
    {
      MsgAutoMonitorUtil.a().k();
      l2 = BaseApplicationImpl.jdField_a_of_type_Long + l1;
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 9) {
          break label406;
        }
        str = ">9";
        label99:
        localHashMap.put("param_FailCount", str);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 0) {
          break label421;
        }
        str = "CLIENT_TIMEOUT";
        label123:
        localHashMap.put("param_FailCode", str);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_c_of_type_Long));
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
      }
    }
    else
    {
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      if (BaseApplicationImpl.jdField_b_of_type_Long > 0L)
      {
        l1 = l1 - BaseApplicationImpl.jdField_b_of_type_Long - BaseApplicationImpl.jdField_c_of_type_Long - BaseApplicationImpl.d - BaseApplicationImpl.e - BaseApplicationImpl.f;
        BaseApplicationImpl.jdField_b_of_type_Long = 0L;
        if ((!BaseApplicationImpl.jdField_b_of_type_Boolean) || (!BaseApplicationImpl.jdField_c_of_type_Boolean)) {
          break label428;
        }
        str = "1";
      }
    }
    for (;;)
    {
      Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + str + ", userLoginCostTime=" + BaseApplicationImpl.jdField_c_of_type_Long + ", userPhoneNumCostTime=" + BaseApplicationImpl.e + ", userVerifyCodeCostTime=" + BaseApplicationImpl.f + ", userRegisterGuideCostTime=" + BaseApplicationImpl.d);
      BaseApplicationImpl.e = 0L;
      BaseApplicationImpl.f = 0L;
      BaseApplicationImpl.d = 0L;
      localHashMap = new HashMap();
      localHashMap.put("actLoginType", str);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      return;
      Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break;
      label406:
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break label99;
      label421:
      str = "";
      break label123;
      label428:
      if ((BaseApplicationImpl.jdField_b_of_type_Boolean) && (!BaseApplicationImpl.jdField_c_of_type_Boolean)) {
        str = "2";
      } else if ((!BaseApplicationImpl.jdField_b_of_type_Boolean) && (BaseApplicationImpl.jdField_c_of_type_Boolean)) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.h == 17) {}
    for (int i = 2;; i = 1)
    {
      localMessageHandler.a(i, true);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      return 2;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cxt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_Cxs = new cxs(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Cxs);
    }
    if ((this.h == 16) || (this.h == 18)) {
      MsgAutoMonitorUtil.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.i = 1;
  }
  
  public boolean a()
  {
    return ((this.m == 2) || (this.m == 1)) && ((this.n == 2) || (this.n == 1)) && ((this.o == 2) || (this.o == 1)) && ((this.p == 2) || (this.p == 1));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Cxs);
      this.jdField_a_of_type_Cxs = null;
    }
    MsgAutoMonitorUtil.a().b(Thread.currentThread().getThreadGroup().activeCount());
    c();
    if (this.h == 16) {
      AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(b());
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l1);
      if (NetworkUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label255;
        }
        localObject = "actSyncMsgFirst";
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, (String)localObject, b(), l1, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()) {}
    for (int i = 2;; i = 1)
    {
      ((Automator)localObject).d = i;
      return;
      label255:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */