package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.StartService.StartServiceState;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cpz;
import cqa;
import cst;
import csu;
import cte;
import ctg;
import cth;
import cti;
import cto;
import ctp;
import cus;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;
import mqq.app.ApplicationLifeController;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static long a = 0L;
  public static GuardManager a;
  public static final String a = "com.tencent.plugin.state.change";
  public static final String b = "key_plugin_state";
  public static final int c = 0;
  static final String jdField_c_of_type_JavaLangString = "GuardManager";
  private static final boolean jdField_c_of_type_Boolean = true;
  public static final int d = 1;
  protected static final String d = "fake_p_msg";
  public static final int e = 0;
  protected static final String e = "trick_p_msg";
  public static final int f = 1;
  private static final String f = "com.tencent.process.exit";
  public static final int g = 2;
  private static final String g = "com.tencent.process.stopping";
  protected static final int h = 12000;
  private static final String h = "com.tencent.process.starting";
  protected static final int i = 1;
  private static final String i = "20140619";
  protected static final int j = 3;
  protected static final int k = 50;
  protected static final int l = 2;
  public static final int m = 6;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 1;
  public static final int q = 6;
  public static final int r = 0;
  private static final int t = 101;
  private static final int u = 1;
  private static final int v = 2;
  private static final int w = 3;
  public int a;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private cti jdField_a_of_type_Cti = null;
  private Random jdField_a_of_type_JavaUtilRandom;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  private boolean jdField_a_of_type_Boolean;
  private cti[] jdField_a_of_type_ArrayOfCti = new cti[9];
  public long[][] a;
  public int b;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private int s = 0;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 }));
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0L;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label129:
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cth(this, null);
        paramApplication = new IntentFilter();
        paramApplication.addAction("android.intent.action.SCREEN_OFF");
        paramApplication.addAction("android.intent.action.SCREEN_ON");
      }
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramApplication);
        label182:
        a(paramInt, null);
        if (paramInt != 1) {
          ApplicationLifeController.getController().setRuntimeReady(true);
        }
        return;
      }
      catch (Throwable paramApplication)
      {
        break label182;
      }
    }
    catch (Throwable paramApplication)
    {
      break label129;
    }
  }
  
  private cti a(int paramInt)
  {
    cti localcti = this.jdField_a_of_type_ArrayOfCti[paramInt];
    Object localObject = localcti;
    if (localcti == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new cst();
      }
    }
    for (;;)
    {
      ((cti)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((cti)localObject).s = paramInt;
      this.jdField_a_of_type_ArrayOfCti[paramInt] = localObject;
      return localObject;
      localObject = new csu();
      continue;
      localObject = new cpz();
      continue;
      localObject = new cqa();
      continue;
      localObject = new ctp();
      continue;
      localObject = new cti();
      continue;
      localObject = new cto();
      continue;
      localObject = new cus();
    }
  }
  
  private static String a(ArrayList paramArrayList, boolean paramBoolean)
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
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a(int paramInt)
  {
    int i3 = (int)(System.currentTimeMillis() / 60000L);
    if (i3 == this.jdField_b_of_type_Int)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.jdField_a_of_type_Int;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int i2;
    if ((i3 < this.jdField_b_of_type_Int) || (i3 - this.jdField_b_of_type_Int > 15))
    {
      i1 = 0;
      while (i1 < 3)
      {
        i2 = 0;
        while (i2 < 15)
        {
          this.jdField_a_of_type_Array2dOfLong[i1][i2] = 0L;
          i2 += 1;
        }
        i1 += 1;
      }
      this.jdField_b_of_type_Int = (i3 - 15);
      this.jdField_a_of_type_Int = 0;
    }
    int i4 = (i3 - this.jdField_b_of_type_Int) % 15;
    int i1 = 1;
    while (i1 <= i4)
    {
      i2 = 0;
      while (i2 < 3)
      {
        this.jdField_a_of_type_Array2dOfLong[i2][((this.jdField_a_of_type_Int + i1) % 15)] = 0L;
        i2 += 1;
      }
      i1 += 1;
    }
    this.jdField_b_of_type_Int = i3;
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + i4) % 15);
    this.jdField_a_of_type_Array2dOfLong[paramInt][this.jdField_a_of_type_Int] = 1L;
  }
  
  public void a()
  {
    a(8, null);
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        label33:
        do
        {
          this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          CoreService.b();
          return;
          localThrowable1 = localThrowable1;
        } while (!QLog.isColorLevel());
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        break label33;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "nextState: " + cti.jdField_a_of_type_ArrayOfJavaLangString[this.s] + ", " + cti.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject);
        }
        int i1 = this.s;
        if (i1 == 8) {
          return;
        }
        if (this.s != paramInt)
        {
          Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.s, paramInt);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 11000L);
          if (this.s == 1) {
            ApplicationLifeController.getController().setRuntimeReady(true);
          }
          this.jdField_a_of_type_Cti = a(paramInt);
          this.s = paramInt;
          this.jdField_a_of_type_Cti.a(5, paramObject);
          continue;
        }
        if (paramInt != 0) {
          continue;
        }
      }
      finally {}
      this.jdField_a_of_type_Cti = a(paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Long == 0L) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getAccount())) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    paramHashMap.put("config", cte.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.a("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Long == 0L) {}
    long l1;
    int i1;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      i1 = (int)((l1 - this.jdField_b_of_type_Long) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportForeground(" + paramBoolean + "):[" + this.jdField_b_of_type_Long + " - " + l1 + " = " + i1 + "]");
      }
      if (i1 > 0)
      {
        Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
        ReportController.b((QQAppInterface)BaseApplicationImpl.a.a(), "CliOper", "", "", "Online_time", "Fe_time", 0, i1, 0, (String)localObject, "", "", "");
      }
      if (!paramBoolean) {
        break;
      }
    } while (i1 <= 0);
    this.jdField_b_of_type_Long = l1;
    return;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(boolean paramBoolean, String... paramVarArgs)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject = ((ActivityManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str1 = localRunningAppProcessInfo.processName;
        if ((str1.startsWith("com.tencent.qqlite")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF")))
        {
          int i3;
          int i2;
          int i1;
          if (paramVarArgs != null)
          {
            i3 = paramVarArgs.length;
            i2 = 0;
            i1 = 0;
          }
          for (;;)
          {
            if (i2 < i3)
            {
              String str2 = paramVarArgs[i2];
              if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                break label234;
              }
            }
            label234:
            for (i1 = 1;; i1 = 0)
            {
              if (i1 == 0) {
                break label239;
              }
              localArrayList3.add(str1);
              if (i1 != 0) {
                break;
              }
              if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                break label248;
              }
              localArrayList1.add(str1);
              break;
            }
            label239:
            i2 += 1;
          }
          label248:
          localArrayList2.add(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(BaseApplicationImpl.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
    }
    if (localArrayList1.size() > 0)
    {
      paramVarArgs = new Intent("com.tencent.process.exit");
      paramVarArgs.putExtra("exit_type", 101);
      paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
      paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
      paramVarArgs.putExtra("verify", a(localArrayList1, false));
      this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramVarArgs);
    }
  }
  
  public boolean a()
  {
    return (this.s == 6) || (this.s == 7) || (this.s == 5);
  }
  
  public boolean a(int paramInt)
  {
    int i2 = 2;
    Object localObject1 = (ActivityManager)BaseApplicationImpl.a().getSystemService("activity");
    Object localObject2 = ((ActivityManager)localObject1).getRunningAppProcesses();
    int i1;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      i1 = 2;
      if (((Iterator)localObject2).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        if ((!localRunningAppProcessInfo.processName.startsWith("com.tencent.qqlite")) || (localRunningAppProcessInfo.importance != 100)) {
          break label267;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "isQQProcessForground >> " + localRunningAppProcessInfo.processName + "[ " + localRunningAppProcessInfo.importance + " ]");
        }
        i1 = 1;
      }
    }
    label267:
    for (;;)
    {
      break;
      if ((i1 != paramInt) && (paramInt != 0))
      {
        localObject1 = ((ActivityManager)localObject1).getRunningTasks(1);
        paramInt = i2;
        if (localObject1 != null)
        {
          paramInt = i2;
          if (!((List)localObject1).isEmpty())
          {
            localObject1 = (ActivityManager.RunningTaskInfo)((List)localObject1).get(0);
            paramInt = i2;
            if (localObject1 != null)
            {
              paramInt = i2;
              if (((ActivityManager.RunningTaskInfo)localObject1).topActivity != null)
              {
                paramInt = i2;
                if (!"com.tencent.qqlite".equals(((ActivityManager.RunningTaskInfo)localObject1).topActivity.getPackageName())) {}
              }
            }
          }
        }
      }
      for (paramInt = 1;; paramInt = i1)
      {
        if (paramInt == 1)
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("GuardManager", 2, "isQQProcessForground: RunningAppProcess null");
          }
          i1 = 2;
          break;
        }
        return false;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "enterQQLSActivity");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label43:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      TrickHelper.a().b();
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label43;
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt < 3) {
      a(paramInt);
    }
    try
    {
      this.jdField_a_of_type_Cti.a(paramInt, paramObject);
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    long l1 = MemoryManager.a(Process.myPid());
    a(0);
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < 15)
    {
      i3 = (int)(i3 + this.jdField_a_of_type_Array2dOfLong[1][i1]);
      i2 = (int)(i2 + this.jdField_a_of_type_Array2dOfLong[0][i1]);
      i1 += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l1 / 1024L));
    localHashMap.put("resumeCount", String.valueOf(i3 * 1.0D / 15.0D));
    localHashMap.put("msgCount", String.valueOf(i2 * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(cte.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)));
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      a(str, localHashMap);
      return;
    }
  }
  
  public boolean b()
  {
    return (this.s == 4) || (this.s == 6);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "exitQQLSActivity");
    }
    this.jdField_b_of_type_Boolean = false;
    IntentFilter localIntentFilter;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cth(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label73:
      if ((this.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    cte localcte = cte.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    int i1 = localcte.jdField_a_of_type_Int;
    long l1 = localcte.jdField_b_of_type_Int | i1 << 8;
    int i2 = cte.a().c;
    if (paramBoolean) {}
    for (i1 = 1;; i1 = 0)
    {
      localAppRuntime.onGuardEvent(5, l1, i1 | i2 << 8);
      return;
    }
  }
  
  public void d()
  {
    try
    {
      if (b()) {
        a(this.s + 1, "trick_p_msg");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask == null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask = new ctg(this, null);
      ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 36000L, 12000L);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    if ((this.jdField_a_of_type_JavaUtilTimerTask != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((a(2)) || (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        label60:
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        this.jdField_a_of_type_Boolean = false;
        a(false);
        b(4, paramMessage.obj);
        paramMessage = new Intent("com.tencent.plugin.state.change");
        paramMessage.putExtra("key_plugin_state", 1);
        BaseApplicationImpl.a().sendBroadcast(paramMessage);
        TrickHelper.a().a();
        jdField_a_of_type_Long = System.currentTimeMillis();
        return true;
        this.jdField_a_of_type_Boolean = true;
        a(true);
        a((QQAppInterface)BaseApplicationImpl.a.a());
        return true;
        Object localObject;
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cth(this, null);
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
        }
        try
        {
          this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
          label201:
          this.jdField_a_of_type_Boolean = true;
          localObject = (QQAppInterface)BaseApplicationImpl.a.a();
          a((QQAppInterface)localObject);
          Intent localIntent = new Intent("com.tencent.plugin.state.change");
          localIntent.putExtra("key_plugin_state", 1);
          BaseApplicationImpl.a().sendBroadcast(localIntent);
          if (StartService.StartServiceState.jdField_a_of_type_Boolean)
          {
            TrickHelper.a().b();
            MemoryManager.a().a(BaseApplicationImpl.a, (QQAppInterface)localObject);
          }
          b(3, paramMessage.obj);
          if (this.jdField_b_of_type_Long != 0L) {
            continue;
          }
          this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
          return true;
          if (this.jdField_a_of_type_JavaUtilRandom == null) {
            this.jdField_a_of_type_JavaUtilRandom = new Random();
          }
          if (this.jdField_a_of_type_JavaUtilRandom.nextInt(20000) != 0) {
            continue;
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("before", cti.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg1]);
          ((HashMap)localObject).put("after", cti.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg2]);
          a("GM_guardChangeS", (HashMap)localObject);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          break label201;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label60;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    String str = paramIntent.getStringExtra("runningProcessName");
    long l1 = paramIntent.getLongExtra("runningtime", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, paramContext + " received with " + str + " at " + l1 + ", when " + this.jdField_d_of_type_Long + ", " + this.c + ", QQLS:" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!"com.tencent.process.stopping".equals(paramContext)) {
          break;
        }
      } while ((l1 < this.jdField_d_of_type_Long) && (l1 >= this.jdField_d_of_type_Long - 1000000L));
      this.jdField_d_of_type_Long = l1;
      paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramContext, 50L);
      return;
    } while ((!"com.tencent.process.starting".equals(paramContext)) || ((l1 < this.c) && (l1 >= this.jdField_d_of_type_Long - 1000000L)));
    this.c = l1;
    paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */