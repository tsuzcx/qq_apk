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
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.eg;
import com.tencent.token.ei;
import com.tencent.token.fe;
import com.tencent.token.ga;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
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
  public static final boolean g = com.tencent.token.utils.u.d;
  public static boolean h = false;
  private static Context i;
  private static eg j;
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
    if ((do.a().e() != null) && (do.a().e().mRealUin != 0L)) {
      return "" + do.a().e().mRealUin;
    }
    String str1 = w.b(i);
    String str2 = w.c(i);
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
      h.c("RqdApplication: userId =" + (String)localObject);
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
    if ((cy.a().c()) && (cy.a().e() == 2)) {
      a |= 0x1;
    }
    if (x.e() != 0L) {
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
    do localdo = do.a();
    if ((localdo == null) || (localdo.e() == null)) {
      x.b(0L);
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
  
  public static eg k()
  {
    if (j != null) {
      return j;
    }
    j = new ei(l());
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
    com.tencent.token.upload.f.b = System.currentTimeMillis();
  }
  
  protected CrashStrategyBean m()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(com.tencent.token.utils.u.o);
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
    ga.a(getApplicationContext());
    CrashReport.setLogAble(com.tencent.token.utils.u.l, com.tencent.token.utils.u.m);
    CrashReport.setUserId(i, "testUserId");
    Object localObject = m();
    CrashReport.initCrashReport(i, null, null, true, (CrashStrategyBean)localObject);
    localObject = fe.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(i, (String)localObject, com.tencent.token.utils.u.p);
    if (com.tencent.token.utils.u.n) {
      ANRReport.startANRMonitor(i);
    }
    CrashReport.setUserId(l(), c());
    TMSDKContext.setTMSDKLogEnable(true);
    h = TMSDKContext.init(this, null);
    TMSDKContext.setAutoConnectionSwitch(this, true);
    n.a();
    PermissionGuide.init(this, new com.tencent.token.global.taiji.u());
    PermissionGuide.pullAdapterSolution();
    a.a().a(this);
    n();
    boolean bool = x.c();
    if (!bool) {
      e();
    }
    if (bool) {
      x.a(false);
    }
    new i(this).start();
    h.a("rqd start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */