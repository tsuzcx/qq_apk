package com.tencent.common.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tf;

public class BaseApplicationImpl
  extends MobileQQ
{
  public static int a = 0;
  public static long a = 0L;
  public static Handler a;
  public static MQLruCache a;
  public static BaseApplicationImpl a;
  public static StartupDirector a;
  public static String a;
  public static boolean a = false;
  public static final int b = -1;
  public static long b = 0L;
  public static String b;
  public static boolean b = false;
  public static final int c = 1;
  public static long c = 0L;
  public static String c;
  public static boolean c = false;
  public static final int d = 2;
  public static long d = 0L;
  public static final String d = "com.tencent.qqlite.broadcast.qq";
  public static final int e = 3;
  public static long e = 0L;
  public static final String e = "com.tencent.qqlite";
  public static final int f = 4;
  public static long f;
  public static int g = -1;
  private Handler b;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    d = 0L;
    e = 0L;
    f = 0L;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
  }
  
  public BaseApplicationImpl()
  {
    this.jdField_b_of_type_AndroidOsHandler = new tf(this);
  }
  
  public static BaseApplicationImpl a()
  {
    return jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public AppRuntime a()
  {
    return waitAppRuntime(null);
  }
  
  public void a()
  {
    super.onCreate();
  }
  
  public AppRuntime createRuntime(String paramString)
  {
    return AppInterfaceFactory.a(this, paramString);
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a;
  }
  
  public String getBootBroadcastName(String paramString)
  {
    if (paramString.equals("com.tencent.qqlite")) {
      return "com.tencent.qqlite.broadcast.qq";
    }
    return "";
  }
  
  public boolean isNeedMSF(String paramString)
  {
    return !paramString.equals(getPackageName() + ":picture");
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      return jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramObject, paramIntent);
    }
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onCreate()
  {
    if (jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      return;
    }
    jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this;
    Step.AmStepFactory.a(2, null, null).b();
    jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = StartupDirector.a(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramBroadcastReceiver = super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramBroadcastReceiver;
    }
    catch (Exception paramBroadcastReceiver)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "", paramBroadcastReceiver);
      }
    }
    return null;
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (Exception paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */