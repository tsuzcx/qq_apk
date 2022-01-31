package com.tencent.mobileqq.webprocess;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class WebProcessReceiver
  extends BroadcastReceiver
{
  protected static WebProcessReceiver a;
  protected static final String a = "WebProcessReceiver";
  protected static boolean a = false;
  public static final String b = "com.tencent.qqlite.webprocess.preload_web_process";
  public static final String c = "com.tencent.qqlite.webprocess.exit_web_process";
  public static final String d = "mqql.intent.action.EXIT";
  public static final String e = "mqql.intent.action.ACCOUNT_CHANGED";
  public static final String f = "mqql.intent.action.LOGOUT";
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver == null) {
      jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver = new WebProcessReceiver();
    }
    if ((jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver != null) && (!jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "registerReceiver");
      }
      jdField_a_of_type_Boolean = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.exit");
      localIntentFilter.addAction("com.tencent.qqlite.webprocess.exit_web_process");
      localIntentFilter.addAction("mqql.intent.action.EXIT_com.tencent.mobileqq");
      localIntentFilter.addAction("mqql.intent.action.LOGOUT");
      localIntentFilter.addAction("mqql.intent.action.ACCOUNT_CHANGED");
      paramContext.getApplicationContext().registerReceiver(jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver, localIntentFilter);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    paramContext = MobileQQ.getMobileQQ().getProcessName();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public static void b(Context paramContext)
  {
    if ((jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver != null) && (jdField_a_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "unregisterReceiver");
      }
    }
    try
    {
      jdField_a_of_type_Boolean = false;
      paramContext.getApplicationContext().unregisterReceiver(jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessReceiver);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  protected void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.report");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  protected boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiver", 2, "exit");
    }
    try
    {
      a();
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("WebProcessReceiver", 2, "kill web process exception=" + localException.getMessage());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "action=" + (String)localObject);
      }
      if (((String)localObject).equals("com.tencent.qqlite.webprocess.preload_web_process"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "preload web process!");
        }
        a(paramContext);
        return;
      }
      if (("com.tencent.qqlite.webprocess.exit_web_process".equals(localObject)) || ("mqql.intent.action.LOGOUT".equalsIgnoreCase((String)localObject)) || ("mqql.intent.action.EXIT_com.tencent.mobileqq".equalsIgnoreCase((String)localObject)) || ("mqql.intent.action.ACCOUNT_CHANGED".equalsIgnoreCase((String)localObject)))
      {
        b(paramContext);
        b();
        return;
      }
      if (!"com.tencent.process.exit".equalsIgnoreCase((String)localObject)) {
        continue;
      }
      localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (((List)localObject).size() >= 1)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "runningActivity=" + (String)localObject);
        }
        if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).contains("com.pay")) || (((String)localObject).contains("com.tenpay")))) {
          continue;
        }
      }
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        continue;
      }
      ArrayList localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
      if ((!a(((Bundle)localObject).getString("verify"), localArrayList)) || (!a(localArrayList, MobileQQ.getContext()))) {
        continue;
      }
      try
      {
        if (MsfServiceSdk.get() != null)
        {
          MsfServiceSdk.get().unRegisterMsfService();
          MsfServiceSdk.get().unbindMsfService();
        }
        label286:
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "qq_mode_foreground=" + paramIntent.getBooleanExtra("qq_mode_foreground", false));
        }
        if (paramIntent.getBooleanExtra("qq_mode_foreground", false)) {
          continue;
        }
        b(paramContext);
        b();
        return;
      }
      catch (Exception localException)
      {
        break label286;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */