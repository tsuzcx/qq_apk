package com.tencent.mobileqq.msf.service;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class k
{
  private static final String A = "sp_boot_time";
  private static final String B = "sp_last_su_time";
  private static final String C = "sp_day_id";
  private static final String D = "sp_s_times";
  private static final int E = 0;
  private static final int F = 1;
  private static final int G = 2;
  private static final int H = 3;
  private static final int I = 4;
  private static int J = 0;
  private static int K = 0;
  private static String L;
  private static long M = 0L;
  private static boolean N = false;
  private static long O = 0L;
  private static int P = -1;
  private static boolean Q = false;
  private static boolean R = false;
  public static int a = 8;
  public static int b = 22;
  public static String c = "MSFAliveManager";
  public static boolean d = false;
  public static final int e = 1;
  public static boolean f = false;
  public static int g = 0;
  public static int h = 0;
  public static int i = 0;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static int m = 0;
  public static int n = 0;
  public static int o = 0;
  public static int p = 0;
  public static final String q = "sp_boot_msf";
  public static final int r = 1;
  public static final int s = 2;
  public static boolean t = false;
  public static final String u = "key_action_name";
  public static final String v = "key_from_job";
  private static final long w = 900000L;
  private static boolean x = false;
  private static final String y = "sp_job_ab";
  private static final String z = "sp_key_job_ab_enable";
  
  static
  {
    f = false;
    g = 0;
    h = 0;
    i = 1;
    j = 2;
    k = 0;
    l = 1;
    m = 2;
    n = 3;
    o = 4;
    p = 5;
  }
  
  public static long a(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toDays(TimeZone.getDefault().getRawOffset() + paramLong);
  }
  
  public static void a()
  {
    int i1 = 1;
    if (R) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Math.random() >= 0.009999999776482582D) {
          break label232;
        }
        if ((i1 != 0) && (t) && (MsfCore.sCore != null) && (MsfService.core.sender.b.l().c()))
        {
          long l1 = BaseApplication.getContext().getPackageManager().getPackageInfo("com.tencent.tim", 0).lastUpdateTime;
          l1 = System.currentTimeMillis() - l1;
          QLog.i(c, 1, "intervalTime = " + l1 + ",model = " + Build.MODEL + ",manufacture = " + Build.MANUFACTURER + ",startupType = " + String.valueOf(K) + ",os = " + Build.VERSION.SDK_INT + ",sStartupBroadcast = " + L);
          com.tencent.mobileqq.msf.core.c.a.a(MsfCore.sCore, "update_start_rate", "", "", "", 1, "", String.valueOf(K), L, String.valueOf(l1), "", "", "", "");
        }
        R = true;
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(c, 2, "checkReportUpdateBoot", localException);
      return;
      label232:
      i1 = 0;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    long l2;
    long l3;
    long l1;
    boolean bool;
    label111:
    SharedPreferences.Editor localEditor;
    if (M == 0L)
    {
      J = paramInt;
      M = System.currentTimeMillis();
      if (paramIntent != null) {
        break label404;
      }
      K = 1;
      l2 = System.currentTimeMillis();
      O = l2 - SystemClock.elapsedRealtime();
      paramIntent = BaseApplication.getContext().getSharedPreferences("sp_boot_msf", 0);
      l3 = paramIntent.getLong("sp_boot_time", 0L);
      l1 = paramIntent.getLong("sp_last_su_time", 0L);
      if ((l3 == 0L) || (Math.abs(l3 - O) <= 120000L) || (O <= l1) || (l1 <= 0L)) {
        break label453;
      }
      bool = true;
      N = bool;
      localEditor = paramIntent.edit();
      localEditor.putLong("sp_boot_time", O).putLong("sp_last_su_time", l2);
      l2 = paramIntent.getLong("sp_day_id", 0L);
      l3 = (System.currentTimeMillis() + 28800000L) / 86400000L;
      if ((l2 != 0L) && (l2 <= l3)) {
        break label459;
      }
      localEditor.putLong("sp_day_id", 1L + l3).putInt("sp_s_times", 0);
    }
    for (;;)
    {
      localEditor.apply();
      QLog.d(c, 1, new Object[] { "startupType = ", Integer.valueOf(K), ", firstStartup = ", Boolean.valueOf(N), ", bootTime = ", Long.valueOf(O), ", lastStartupTime = ", Long.valueOf(l1), ", isOffline = ", Boolean.valueOf(MsfCore.sCore.isOffline()), ", recordDay = ", Long.valueOf(l2), ", currentDay = ", Long.valueOf(l3), ", times=", P + ", sFromType = " + J, "sStartupBroadcast = " + L });
      return;
      label404:
      if (paramIntent.getStringExtra("key_action_name") != null)
      {
        K = 4;
        L = paramIntent.getStringExtra("key_action_name");
        break;
      }
      if (paramIntent.getBooleanExtra("key_from_job", false))
      {
        K = 3;
        break;
      }
      K = 2;
      break;
      label453:
      bool = false;
      break label111;
      label459:
      if (l2 < l3)
      {
        P = paramIntent.getInt("sp_s_times", 0);
        localEditor.putLong("sp_day_id", l3).putInt("sp_s_times", 1);
      }
      else
      {
        localEditor.putInt("sp_s_times", paramIntent.getInt("sp_s_times", 0) + 1);
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.msf.core.c.k paramk, boolean paramBoolean)
  {
    d = paramBoolean;
    long l3 = System.currentTimeMillis();
    long l4 = SystemClock.elapsedRealtime();
    long l1 = System.currentTimeMillis();
    long l2 = b(l1);
    if (QLog.isColorLevel()) {
      QLog.d(c, 1, "MSFAliveRecorder onMSFServiceBeginAsync " + l1);
    }
    a.a();
    if ((a.d <= 0L) || (Math.abs(a.d - (l3 - l4)) > 10000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 1, "reboot or bad data " + a.d);
      }
      a.b();
    }
    label337:
    for (;;)
    {
      if (l2 < a) {
        a.b();
      }
      if (l2 <= b) {
        a.a(paramk);
      }
      return;
      l3 = a(a.c);
      l4 = a(l1);
      if (l3 != l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 1, "not same day report " + l3 + " " + l4);
        }
        a.b(paramk);
      }
      for (;;)
      {
        if (l2 <= b) {
          break label337;
        }
        a.b(paramk);
        break;
        if (QLog.isColorLevel()) {
          QLog.d(c, 1, "fix data " + a.p + " " + a.c);
        }
        if ((l1 <= a.c) || (l1 - a.c > 39600000L))
        {
          a.b();
        }
        else
        {
          if (!a.p) {
            a.o += l1 - a.c;
          }
          a.c = l1;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    
    if (!g())
    {
      QLog.d(c, 1, "MSF_Alive_Log reportJobAliveMsf not enable");
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null))
    {
      HashMap localHashMap = new HashMap(8);
      localHashMap.put("osVersion", Build.VERSION.SDK_INT + "");
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("manufacture", Build.MANUFACTURER);
      if (paramBoolean) {}
      for (String str = "1";; str = "0")
      {
        localHashMap.put("rdminit", str);
        MsfCore.sCore.statReporter.a("EvtJobPullMsfAlive", true, 0L, 0L, localHashMap, false, false);
        f = false;
        return;
      }
    }
    f = true;
  }
  
  public static long b(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toHours(TimeZone.getDefault().getRawOffset() + paramLong) % 24L;
  }
  
  public static void b()
  {
    if (Q) {
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null) && (!MsfCore.sCore.isOffline()) && (K != 0))
    {
      boolean bool;
      HashMap localHashMap;
      if (N) {
        if (Math.random() < 0.009999999776482582D)
        {
          bool = true;
          long l1 = (M - O) / 1000L;
          i1 = MsfSdkUtils.getAutoStartMode(BaseApplication.getContext());
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, new Object[] { "report service boot, isFirst = ", Boolean.valueOf(N), ", type = ", Integer.valueOf(K), ", bootDuration  = " + l1, "bdAction = " + L, ", report = ", Boolean.valueOf(bool), ", autoMode = " + i1 });
          }
          if (bool)
          {
            localHashMap = new HashMap(8);
            localHashMap.put("osVersion", Build.VERSION.SDK_INT + "");
            localHashMap.put("model", Build.MODEL);
            localHashMap.put("manufacture", Build.MANUFACTURER);
            localHashMap.put("startupType", String.valueOf(K));
            localHashMap.put("startupAction", L);
            localHashMap.put("bootDuration", String.valueOf(l1));
            localHashMap.put("autoMode", String.valueOf(i1));
            MsfCore.sCore.statReporter.a("EvtMSFServiceBoot", N, l1, 0L, localHashMap, false, false);
            if ((MsfCore.sCore != null) && (N) && (MsfService.core.sender.b.l().c())) {
              com.tencent.mobileqq.msf.core.c.a.a(MsfCore.sCore, "self_start_rate", "", "", "", 1, "", String.valueOf(K), L, String.valueOf(l1), String.valueOf(i1), "", "", "");
            }
          }
          if (Math.random() >= 0.003000000026077032D) {
            break label584;
          }
        }
      }
      label584:
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 0) && (P != -1))
        {
          localHashMap = new HashMap(8);
          localHashMap.put("osVersion", Build.VERSION.SDK_INT + "");
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("manufacture", Build.MANUFACTURER);
          localHashMap.put("startTimes", String.valueOf(P));
          MsfCore.sCore.statReporter.a("EvtMSFStartTimes", true, 0L, 0L, localHashMap, false, false);
        }
        Q = true;
        return;
        bool = false;
        break;
        if (Math.random() < 0.001000000047497451D)
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
    }
    QLog.e(c, 1, "boot type uninit");
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 1, "onMSFServiceDestroy");
    }
    a.c();
  }
  
  public static void d()
  {
    d = false;
  }
  
  public static void e()
  {
    if (!g()) {
      QLog.d(c, 1, "MSF_Alive_Log add JobScheduler not enable");
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return;
        } while (Build.VERSION.SDK_INT < 21);
        QLog.d(c, 1, "MSF_Alive_Log add JobScheduler begin");
      } while (x);
      JobScheduler localJobScheduler = (JobScheduler)BaseApplication.getContext().getSystemService("jobscheduler");
      JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(BaseApplication.getContext(), MSFAliveJobService.class));
      localBuilder.setPeriodic(900000L);
      localBuilder.setPersisted(true);
      try
      {
        i1 = localJobScheduler.schedule(localBuilder.build());
        if (i1 == 1)
        {
          QLog.d(c, 1, "MSF_Alive_Log add JobScheduler success!");
          x = true;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.d(c, 1, "MSF_Alive_Log add JobScheduler Throwable:", localThrowable);
          i1 = 0;
        }
      }
    } while (i1 != 0);
    QLog.d(c, 1, "MSF_Alive_Log add JobScheduler fail!");
  }
  
  public static void f()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((JobScheduler)BaseApplication.getContext().getSystemService("jobscheduler")).cancel(1);
      QLog.d(c, 1, "MSF_Alive_Log cancel JobScheduler!");
    }
  }
  
  public static boolean g()
  {
    if (Build.VERSION.SDK_INT < 21) {
      g = p;
    }
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        for (;;)
        {
          QLog.d(c, 1, new Object[] { "MSF_Alive_Log get job state = ", Integer.valueOf(g) });
          if ((g != m) && (g != n)) {
            break label212;
          }
          return true;
          i1 = com.tencent.mobileqq.msf.core.a.a.bw();
          if (i1 == j)
          {
            g = m;
          }
          else
          {
            if (i1 != h) {
              break;
            }
            g = l;
          }
        }
      } while (i1 != i);
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_job_ab", 0);
      g = localSharedPreferences.getInt("sp_key_job_ab_enable", k);
    } while (g != k);
    if (Math.random() <= 0.5D) {}
    for (int i1 = n;; i1 = o)
    {
      g = i1;
      localSharedPreferences.edit().putInt("sp_key_job_ab_enable", g).commit();
      QLog.d(c, 1, new Object[] { "MSF_Alive_Log sample job AB Test: ", Integer.valueOf(g) });
      break;
    }
    label212:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.k
 * JD-Core Version:    0.7.0.1
 */