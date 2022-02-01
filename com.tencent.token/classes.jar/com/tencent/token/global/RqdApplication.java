package com.tencent.token.global;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.android.safeguard.Safeguard;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.service.a;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
import com.tencent.token.dc;
import com.tencent.token.dd;
import com.tencent.token.dw;
import com.tencent.token.eq;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import com.tmsdk.TMSDKContext;
import java.io.File;
import tmsdk.common.module.pgsdk.PermissionGuide;

public class RqdApplication
  extends Application
{
  public static int a = 0;
  public static boolean b;
  public static volatile int c = 1;
  public static volatile int d = 60;
  public static String e;
  public static boolean f;
  public static final boolean g = com.tencent.token.utils.j.d;
  public static boolean h = false;
  private static Context i;
  private static dc j;
  private static int k = -1;
  
  public static void a()
  {
    l().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  private static boolean a(Context paramContext)
  {
    return b(paramContext) == c(paramContext);
  }
  
  private static long b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static boolean b()
  {
    return (o()) && (a(l()));
  }
  
  private static long c(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static String c()
  {
    int n = 1;
    Object localObject = "testUserId";
    if ((cq.a().e() != null) && (cq.a().e().mRealUin != 0L)) {
      return "" + cq.a().e().mRealUin;
    }
    String str1 = l.b(i);
    String str2 = l.c(i);
    int m;
    if (str1 == null)
    {
      m = 1;
      if (str2 != null) {
        break label152;
      }
      label82:
      if ((m == 0) || (n == 0))
      {
        if ((m != 0) || (n != 0)) {
          break label157;
        }
        localObject = str1 + ";" + str2;
      }
    }
    for (;;)
    {
      g.c("RqdApplication: userId =" + (String)localObject);
      return localObject;
      m = 0;
      break;
      label152:
      n = 0;
      break label82;
      label157:
      if (m != 0) {
        localObject = str2;
      } else {
        localObject = str1;
      }
    }
  }
  
  public static void d()
  {
    c = 1;
    d = 0;
  }
  
  public static void e()
  {
    a = 0;
    if ((cc.a().c()) && (cc.a().e() == 2)) {
      a |= 0x1;
    }
    if (m.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean f()
  {
    int m;
    if ((a & 0x1) == 1)
    {
      m = 1;
      if (m == 0) {
        break label22;
      }
    }
    label22:
    while ((a & 0x2) == 2)
    {
      return true;
      m = 0;
      break;
    }
    return false;
  }
  
  public static boolean g()
  {
    return (a & 0x1) == 1;
  }
  
  public static boolean h()
  {
    cq localcq = cq.a();
    if ((localcq == null) || (localcq.e() == null)) {
      m.b(0L);
    }
    while ((a & 0x2) != 2) {
      return false;
    }
    return true;
  }
  
  public static void i()
  {
    a = 0;
  }
  
  public static String j()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (k == 0)
    {
      localObject1 = localObject2;
      if (!c.l()) {
        localObject1 = new Safeguard(i, "safeguard_pref").getSafeguardInfo();
      }
    }
    k += 1;
    return localObject1;
  }
  
  public static dc k()
  {
    if (j != null) {
      return j;
    }
    j = new dd(l());
    return j;
  }
  
  public static Context l()
  {
    return i;
  }
  
  private void n()
  {
    TMSDKContext.SaveStringData(1150055, "");
    if (b())
    {
      TMSDKContext.SaveStringData(1150056, "");
      Log.i("xx", "new");
    }
  }
  
  private static boolean o()
  {
    return l().getSharedPreferences("sp_name_global", 0).getBoolean("KEY_FIRSTTIME", true);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    com.tencent.token.upload.e.b = System.currentTimeMillis();
  }
  
  protected CrashStrategyBean m()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(com.tencent.token.utils.j.o);
    localCrashStrategyBean.setCrashSdcardMaxSize(5000);
    localCrashStrategyBean.setMaxStoredNum(10);
    localCrashStrategyBean.setMaxUploadNum_GPRS(2);
    localCrashStrategyBean.setMaxUploadNum_Wifi(20);
    localCrashStrategyBean.setMaxLogRow(300);
    localCrashStrategyBean.setMaxStackFrame(5);
    localCrashStrategyBean.setMaxStackLine(200);
    return localCrashStrategyBean;
  }
  
  public void onCreate()
  {
    super.onCreate();
    i = getApplicationContext();
    c.a(getApplicationContext());
    eq.a(getApplicationContext());
    CrashReport.setLogAble(com.tencent.token.utils.j.l, com.tencent.token.utils.j.m);
    CrashReport.setUserId(i, "testUserId");
    Object localObject = m();
    CrashReport.initCrashReport(i, null, null, true, (CrashStrategyBean)localObject);
    localObject = dw.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(i, (String)localObject, com.tencent.token.utils.j.p);
    if (com.tencent.token.utils.j.n) {
      ANRReport.startANRMonitor(i);
    }
    CrashReport.setUserId(l(), c());
    TMSDKContext.setTMSDKLogEnable(false);
    h = TMSDKContext.init(this, null);
    TMSDKContext.setAutoConnectionSwitch(this, true);
    k.a();
    PermissionGuide.init(this, new com.tencent.token.global.taiji.j());
    PermissionGuide.pullAdapterSolution();
    a.a().a(this);
    n();
    boolean bool = m.c();
    if (!bool) {
      e();
    }
    if (bool) {
      m.a(false);
    }
    new Thread()
    {
      public void run()
      {
        for (;;)
        {
          try
          {
            if ((!cc.a().d()) && (m.e() == 0L)) {
              break label82;
            }
            if (RqdApplication.d < 60)
            {
              RqdApplication.c = 1;
              Thread.sleep(60000L);
              RqdApplication.d = 60;
              continue;
            }
            Thread.sleep(1000L);
          }
          catch (Exception localException)
          {
            g.b(localException.toString());
            localException.printStackTrace();
            return;
          }
          if (l.d())
          {
            RqdApplication.c = 1;
          }
          else
          {
            RqdApplication.c = 0;
            continue;
            label82:
            Thread.sleep(60000L);
          }
        }
      }
    }.start();
    g.a("rqd start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */