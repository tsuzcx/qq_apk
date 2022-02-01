package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eza;
import ezb;
import fcc;
import fcd;
import fcq;
import fcr;
import fcs;
import fct;
import fde;
import fdf;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.ApplicationLifeController;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static final int a = 0;
  public static GuardManager a;
  public static final String a = "com.tencent.plugin.state.change";
  public static final int b = 1;
  public static final String b = "key_plugin_state";
  protected static final int c = 12000;
  static final String jdField_c_of_type_JavaLangString = "GuardManager";
  private static final boolean jdField_c_of_type_Boolean = true;
  protected static final int d = 1;
  protected static final String d = "fake_p_msg";
  protected static final int e = 4;
  private static final String e = "com.tencent.process.exit";
  protected static final int f = 50;
  private static final String f = "com.tencent.process.stopping";
  protected static final int g = 2;
  private static final String g = "com.tencent.process.starting";
  public static final int h = 6;
  private static final String h = "20140619";
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 6;
  private static final int o = 1;
  private static final int p = 2;
  private long jdField_a_of_type_Long = 0L;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private fcs jdField_a_of_type_Fcs = null;
  private fct jdField_a_of_type_Fct = null;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  private boolean jdField_a_of_type_Boolean;
  private fct[] jdField_a_of_type_ArrayOfFct = new fct[9];
  public long[][] a;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = 0L;
  private boolean d = false;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  
  public GuardManager(Application paramApplication)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 2, 15 }));
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    a(1, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label140:
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fcr(this, null);
        paramApplication = new IntentFilter();
        paramApplication.addAction("android.intent.action.SCREEN_OFF");
        paramApplication.addAction("android.intent.action.SCREEN_ON");
      }
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramApplication);
        label193:
        ApplicationLifeController.getController().setRuntimeReady(true);
        return;
      }
      catch (Throwable paramApplication)
      {
        break label193;
      }
    }
    catch (Throwable paramApplication)
    {
      break label140;
    }
  }
  
  private fct a(int paramInt)
  {
    fct localfct = this.jdField_a_of_type_ArrayOfFct[paramInt];
    Object localObject = localfct;
    if (localfct == null) {
      switch (paramInt)
      {
      case 6: 
      default: 
        localObject = new fde();
      }
    }
    for (;;)
    {
      ((fct)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((fct)localObject).s = paramInt;
      this.jdField_a_of_type_ArrayOfFct[paramInt] = localObject;
      return localObject;
      localObject = new fcc();
      continue;
      localObject = new fcd();
      continue;
      localObject = new eza();
      continue;
      localObject = new ezb();
      continue;
      localObject = new fdf();
      continue;
      localObject = new fct();
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
    if (i3 == this.m)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.l;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int i2;
    if ((i3 < this.m) || (i3 - this.m > 15))
    {
      i1 = 0;
      while (i1 < 2)
      {
        i2 = 0;
        while (i2 < 15)
        {
          this.jdField_a_of_type_Array2dOfLong[i1][i2] = 0L;
          i2 += 1;
        }
        i1 += 1;
      }
      this.m = (i3 - 15);
      this.l = 0;
    }
    int i4 = (i3 - this.m) % 15;
    int i1 = 1;
    while (i1 < i4)
    {
      i2 = 0;
      while (i2 < 2)
      {
        this.jdField_a_of_type_Array2dOfLong[i2][((this.l + i1) % 15)] = 0L;
        i2 += 1;
      }
      i1 += 1;
    }
    this.m = i3;
    this.l = ((this.l + i4) % 15);
    this.jdField_a_of_type_Array2dOfLong[paramInt][this.l] = 1L;
  }
  
  private boolean b()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mobileqqi")) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public long a(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i1 = arrayOfMemoryInfo[0].getTotalPss();
        return i1 * 1024;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
    }
    return 62914560L;
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
          StatisticCollector.a(BaseApplication.getContext()).a("", "GuardExit", true, 0L, 0L, null, "");
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
  
  /* Error */
  public void a(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +60 -> 65
    //   8: ldc 21
    //   10: iconst_2
    //   11: new 196	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 352
    //   21: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 355	fct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   31: aaload
    //   32: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 357
    //   38: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: getstatic 355	fct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   44: iload_1
    //   45: aaload
    //   46: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 357
    //   52: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_2
    //   56: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   69: iload_1
    //   70: if_icmpeq +94 -> 164
    //   73: aload_0
    //   74: getfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   77: bipush 8
    //   79: if_icmpeq +85 -> 164
    //   82: aload_0
    //   83: aload_0
    //   84: iload_1
    //   85: invokespecial 365	com/tencent/mobileqq/app/GuardManager:a	(I)Lfct;
    //   88: putfield 86	com/tencent/mobileqq/app/GuardManager:jdField_a_of_type_Fct	Lfct;
    //   91: aload_0
    //   92: getfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   95: iconst_1
    //   96: if_icmpne +80 -> 176
    //   99: invokestatic 338	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   102: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   105: astore_3
    //   106: new 367	java/util/HashMap
    //   109: dup
    //   110: invokespecial 368	java/util/HashMap:<init>	()V
    //   113: astore 4
    //   115: aload 4
    //   117: ldc_w 370
    //   120: ldc_w 372
    //   123: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload 4
    //   129: ldc_w 378
    //   132: getstatic 355	fct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   135: iload_1
    //   136: aaload
    //   137: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload_3
    //   142: ldc_w 345
    //   145: ldc_w 380
    //   148: iconst_1
    //   149: lconst_0
    //   150: lconst_0
    //   151: aload 4
    //   153: ldc_w 345
    //   156: invokevirtual 350	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   159: aload_0
    //   160: iload_1
    //   161: putfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   164: aload_0
    //   165: getfield 86	com/tencent/mobileqq/app/GuardManager:jdField_a_of_type_Fct	Lfct;
    //   168: iconst_5
    //   169: aload_2
    //   170: invokevirtual 381	fct:a	(ILjava/lang/Object;)V
    //   173: aload_0
    //   174: monitorexit
    //   175: return
    //   176: iload_1
    //   177: iconst_2
    //   178: if_icmpeq +8 -> 186
    //   181: iload_1
    //   182: iconst_3
    //   183: if_icmpne -24 -> 159
    //   186: invokestatic 338	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   189: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   192: astore_3
    //   193: new 367	java/util/HashMap
    //   196: dup
    //   197: invokespecial 368	java/util/HashMap:<init>	()V
    //   200: astore 4
    //   202: aload 4
    //   204: ldc_w 370
    //   207: getstatic 355	fct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 88	com/tencent/mobileqq/app/GuardManager:n	I
    //   214: aaload
    //   215: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload 4
    //   221: ldc_w 378
    //   224: getstatic 355	fct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   227: iload_1
    //   228: aaload
    //   229: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: aload_3
    //   234: ldc_w 345
    //   237: ldc_w 380
    //   240: iconst_1
    //   241: lconst_0
    //   242: lconst_0
    //   243: aload 4
    //   245: ldc_w 345
    //   248: invokevirtual 350	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   251: goto -92 -> 159
    //   254: astore_2
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_2
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	GuardManager
    //   0	259	1	paramInt	int
    //   0	259	2	paramObject	Object
    //   105	129	3	localStatisticCollector	StatisticCollector
    //   113	131	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	65	254	finally
    //   65	159	254	finally
    //   159	164	254	finally
    //   164	173	254	finally
    //   186	251	254	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getAccount())) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    long l1;
    int i1;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      i1 = (int)((l1 - this.jdField_a_of_type_Long) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportForeground(" + paramBoolean + "):[" + this.jdField_a_of_type_Long + " - " + l1 + " = " + i1 + "]");
      }
      if (i1 > 0)
      {
        Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
        ReportController.b((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a(), "CliOper", "", "", "Online_time", "Fe_time", 0, i1, 0, (String)localObject, "", "", "");
      }
      if (!paramBoolean) {
        break;
      }
    } while (i1 <= 0);
    this.jdField_a_of_type_Long = l1;
    return;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(String... paramVarArgs)
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
        if ((str1.startsWith("com.tencent.mobileqqi")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF")))
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
                break label230;
              }
            }
            label230:
            for (i1 = 1;; i1 = 0)
            {
              if (i1 == 0) {
                break label235;
              }
              localArrayList3.add(str1);
              if (i1 != 0) {
                break;
              }
              if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                break label242;
              }
              localArrayList1.add(str1);
              break;
            }
            label235:
            i2 += 1;
          }
          label242:
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
      paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
      paramVarArgs.putExtra("verify", a(localArrayList1, false));
      this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramVarArgs);
    }
  }
  
  public boolean a()
  {
    return (this.n == 6) || (this.n == 7) || (this.n == 5);
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
    if (paramInt < 2) {
      a(paramInt);
    }
    this.jdField_a_of_type_Fct.a(paramInt, paramObject);
  }
  
  public void b(boolean paramBoolean)
  {
    long l1 = a(Process.myPid());
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
    localHashMap.put("resumeCount", String.valueOf(i3));
    localHashMap.put("msgCount", String.valueOf(i2));
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.a());
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      localStatisticCollector.a(null, str, true, 0L, 0L, localHashMap, null);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportActiveLevel, qqUsedMemory = " + l1 / 1024L + ", resumeCount = " + i3 + ", msgCount = " + i2);
      }
      return;
    }
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fcr(this, null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label73:
      if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "startTimer");
      }
      if (this.jdField_a_of_type_JavaUtilTimerTask == null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask = new fcq(this, null);
        ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 12000L, 12000L);
      }
      this.d = true;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "cancelTimer");
      }
      if ((this.jdField_a_of_type_JavaUtilTimerTask != null) && (this.d)) {
        this.d = false;
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (this.jdField_a_of_type_Fcs == null)
    {
      this.jdField_a_of_type_Fcs = new fcs(this);
      this.jdField_a_of_type_Fcs.a();
    }
    if (this.jdField_a_of_type_Fcs.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_Fcs.jdField_b_of_type_Long = DeviceInfoUtil.c();
    }
    if (this.jdField_a_of_type_Fcs.jdField_c_of_type_Long == 0L) {
      this.jdField_a_of_type_Fcs.jdField_c_of_type_Long = DeviceInfoUtil.e();
    }
    long l3 = DeviceInfoUtil.d();
    long l4 = a(Process.myPid());
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    long l1;
    long l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      l1 = 0L;
      l2 = l1;
      if (!((Iterator)localObject1).hasNext()) {
        break label196;
      }
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      String str = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
      if ((!str.startsWith("com.tencent.mobileqqi")) || (str.equals("com.tencent.mobileqqi"))) {
        break label955;
      }
      l1 += a(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
    }
    label950:
    label955:
    for (;;)
    {
      break;
      l2 = 0L;
      label196:
      if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {
        return;
      }
      if (this.jdField_a_of_type_Fcs.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Fcs.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      localObject1 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject1).d += l3;
      localObject1 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject1).e = (l2 + ((fcs)localObject1).e);
      localObject1 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject1).f += l4;
      localObject1 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject1).jdField_a_of_type_Int += 1;
      localObject1 = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
      localObject2 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject2).g += ((MQLruCache)localObject1).maxSize();
      localObject2 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject2).h += ((MQLruCache)localObject1).size();
      localObject2 = this.jdField_a_of_type_Fcs;
      ((fcs)localObject2).jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
      localObject2 = this.jdField_a_of_type_Fcs;
      int i1 = ((fcs)localObject2).jdField_b_of_type_Int;
      ((fcs)localObject2).jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i1);
      l1 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          if (l1 - this.jdField_a_of_type_Fcs.jdField_a_of_type_Long > 86400000L)
          {
            i1 = this.jdField_a_of_type_Fcs.jdField_a_of_type_Int;
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("sysTotalMemory", String.valueOf(this.jdField_a_of_type_Fcs.jdField_b_of_type_Long / 1024L));
            ((HashMap)localObject1).put("sysClassMemory", String.valueOf(this.jdField_a_of_type_Fcs.jdField_c_of_type_Long / 1024L));
            ((HashMap)localObject1).put("sysAvailableMemory", String.valueOf(this.jdField_a_of_type_Fcs.d / (i1 * 1024)));
            ((HashMap)localObject1).put("qqOtherUsedMemory", String.valueOf(this.jdField_a_of_type_Fcs.e / (i1 * 1024)));
            ((HashMap)localObject1).put("qqUsedMemory", String.valueOf(this.jdField_a_of_type_Fcs.f / (i1 * 1024)));
            ((HashMap)localObject1).put("imageCacheMax", String.valueOf(this.jdField_a_of_type_Fcs.g / (i1 * 1024)));
            ((HashMap)localObject1).put("imageCacheUsed", String.valueOf(this.jdField_a_of_type_Fcs.h / (i1 * 1024)));
            ((HashMap)localObject1).put("imageHitCount", String.valueOf(this.jdField_a_of_type_Fcs.jdField_c_of_type_Int / i1));
            i1 = this.jdField_a_of_type_Fcs.jdField_c_of_type_Int + this.jdField_a_of_type_Fcs.jdField_b_of_type_Int;
            if (i1 == 0) {
              break label950;
            }
            d1 = this.jdField_a_of_type_Fcs.jdField_c_of_type_Int * 100.0D / i1;
            ((HashMap)localObject1).put("imageHitRate", String.valueOf(d1));
            StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actMemory", true, 0L, 0L, (HashMap)localObject1, null);
            this.jdField_a_of_type_Fcs.jdField_a_of_type_Long = l1;
            this.jdField_a_of_type_Fcs.b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("GuardManager", 2, "reportMemoryInfo, startTime=" + this.jdField_a_of_type_Fcs.jdField_a_of_type_Long + ", statCount=" + this.jdField_a_of_type_Fcs.jdField_a_of_type_Int + ", sysTotalMemory=" + this.jdField_a_of_type_Fcs.jdField_b_of_type_Long + ", sysAvailableMemory=" + this.jdField_a_of_type_Fcs.d + ", qqOtherUsedMemory=" + this.jdField_a_of_type_Fcs.e + ", qqUsedMemory=" + this.jdField_a_of_type_Fcs.f + ",imageCacheMax=" + this.jdField_a_of_type_Fcs.g + ",imageCacheUsed=" + this.jdField_a_of_type_Fcs.h + ",imageHitCount=" + this.jdField_a_of_type_Fcs.jdField_c_of_type_Int + ",imageHitTotal=" + (this.jdField_a_of_type_Fcs.jdField_c_of_type_Int + this.jdField_a_of_type_Fcs.jdField_b_of_type_Int));
          }
          this.jdField_a_of_type_Fcs.c();
          return;
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GuardManager", 2, "reportMemoryInfo exception", localException);
        return;
        double d1 = 0.0D;
      }
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
      if ((b()) || (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        label55:
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        this.jdField_a_of_type_Boolean = false;
        a(false);
        this.jdField_a_of_type_Fct.a(3, paramMessage.obj);
        paramMessage = new Intent("com.tencent.plugin.state.change");
        paramMessage.putExtra("key_plugin_state", 1);
        BaseApplicationImpl.a().sendBroadcast(paramMessage);
        return true;
        this.jdField_a_of_type_Boolean = true;
        a(true);
        a((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a());
        return true;
        Object localObject;
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fcr(this, null);
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
        }
        try
        {
          this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
          label187:
          this.jdField_a_of_type_Boolean = true;
          a((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a());
          localObject = new Intent("com.tencent.plugin.state.change");
          ((Intent)localObject).putExtra("key_plugin_state", 1);
          BaseApplicationImpl.a().sendBroadcast((Intent)localObject);
          this.jdField_a_of_type_Fct.a(2, paramMessage.obj);
          if (this.jdField_a_of_type_Long != 0L) {
            continue;
          }
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          return true;
        }
        catch (Throwable localThrowable1)
        {
          break label187;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label55;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    String str = paramIntent.getStringExtra("runningProcessName");
    long l1 = paramIntent.getLongExtra("runningtime", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, paramContext + " received with " + str + " at " + l1 + ", when " + this.jdField_c_of_type_Long + ", " + this.jdField_b_of_type_Long + ", QQLS:" + this.jdField_b_of_type_Boolean);
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
      } while ((l1 < this.jdField_c_of_type_Long) && (l1 >= this.jdField_c_of_type_Long - 1000000L));
      this.jdField_c_of_type_Long = l1;
      paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramContext, 50L);
      return;
    } while ((!"com.tencent.process.starting".equals(paramContext)) || ((l1 < this.jdField_b_of_type_Long) && (l1 >= this.jdField_c_of_type_Long - 1000000L)));
    this.jdField_b_of_type_Long = l1;
    paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */