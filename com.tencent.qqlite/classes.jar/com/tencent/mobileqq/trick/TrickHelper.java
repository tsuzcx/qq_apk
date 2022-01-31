package com.tencent.mobileqq.trick;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ejf;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TrickHelper
{
  public static final int a = 2013;
  private static TrickHelper jdField_a_of_type_ComTencentMobileqqTrickTrickHelper = null;
  private static final String jdField_a_of_type_JavaLangString = "TrickHelper";
  public static final int b = 2014;
  private Handler jdField_a_of_type_AndroidOsHandler = new ejf(this);
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FrontWindow jdField_a_of_type_ComTencentMobileqqTrickFrontWindow;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TrickHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTrickTrickHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTrickTrickHelper == null) {
        jdField_a_of_type_ComTencentMobileqqTrickTrickHelper = new TrickHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqTrickTrickHelper;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      Context localContext = BaseApplicationImpl.getContext();
      if (this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow == null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localContext.getApplicationContext().getSystemService("window"));
        this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow = new FrontWindow(localContext.getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = 1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = 1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = -2;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 262152;
      }
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow.setListening(true);
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "enable");
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TrickHelper", 2, "enable ex", localException);
    }
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow != null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow);
        this.jdField_a_of_type_ComTencentMobileqqTrickFrontWindow.setListening(false);
        if (QLog.isColorLevel()) {
          QLog.d("TrickHelper", 2, "disable");
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TrickHelper", 2, "disable ex", localException);
    }
  }
  
  private void e()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if ((l1 > GuardManager.a) && (GuardManager.a != 0L))
      {
        long l2 = GuardManager.a;
        long l3 = MemoryManager.a(Process.myPid()) / 1024L;
        long l4 = DeviceInfoUtil.e() / 1024L;
        long l5 = DeviceInfoUtil.c() / 1024L;
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("osVersion", Build.VERSION.RELEASE);
        localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("time", String.valueOf((l1 - l2) / 1000L));
        localHashMap.put("qqUsedMemory", String.valueOf(l3));
        localHashMap.put("sysClassMemory", String.valueOf(l4));
        localHashMap.put("sysTotalMemory", String.valueOf(l5));
        localStatisticCollector.a("", "MemoryTrick", true, 0L, 0L, localHashMap, "");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TrickHelper", 2, "report err", localException);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      boolean bool = MemoryManager.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "startTrick enable=" + bool);
      }
      if (bool) {
        c();
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (ClassNameHelper.a().contains(localObject))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2013);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2014);
        return true;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2013, 100L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2013, 200L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2013, 300L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2013, 500L);
      }
      return false;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool = MemoryManager.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "stopTrick enable=" + bool);
      }
      if (bool) {
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.trick.TrickHelper
 * JD-Core Version:    0.7.0.1
 */