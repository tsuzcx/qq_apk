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
import com.tencent.service.update.e;
import com.tencent.token.ce;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.de;
import com.tencent.token.df;
import com.tencent.token.dx;
import com.tencent.token.dz;
import com.tencent.token.et;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import com.tmsdk.TMSDKContext;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.module.pgsdk.PermissionGuide;

public class RqdApplication
  extends Application
{
  public static int a = 0;
  public static boolean b = false;
  public static volatile int c = 1;
  public static volatile int d = 60;
  public static String e;
  public static boolean f = false;
  public static final boolean g = com.tencent.token.utils.j.d;
  public static boolean h = false;
  private static Context j;
  private static RqdApplication k;
  private static de l;
  private static int m = -1;
  AtomicBoolean i = new AtomicBoolean(false);
  
  public static RqdApplication a()
  {
    return k;
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
      long l1 = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  private static long c(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l1 = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static void c()
  {
    n().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  public static boolean d()
  {
    return (q()) && (a(n()));
  }
  
  public static String e()
  {
    Object localObject1 = "testUserId";
    if ((cs.a().e() != null) && (cs.a().e().mRealUin != 0L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(cs.a().e().mRealUin);
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = l.b(j);
    String str = l.c(j);
    int i1 = 1;
    int n;
    if (localObject2 == null) {
      n = 1;
    } else {
      n = 0;
    }
    if (str != null) {
      i1 = 0;
    }
    if ((n == 0) || (i1 == 0)) {
      if ((n == 0) && (i1 == 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(";");
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (n != 0)
      {
        localObject1 = str;
      }
      else
      {
        localObject1 = localObject2;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RqdApplication: userId =");
    ((StringBuilder)localObject2).append((String)localObject1);
    g.c(((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public static void f()
  {
    c = 1;
    d = 0;
  }
  
  public static void g()
  {
    a = 0;
    if ((ce.a().c()) && (ce.a().e() == 2)) {
      a |= 0x1;
    }
    if (m.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean h()
  {
    int n;
    if ((a & 0x1) == 1) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0) {
      return true;
    }
    return (a & 0x2) == 2;
  }
  
  public static boolean i()
  {
    return (a & 0x1) == 1;
  }
  
  public static boolean j()
  {
    cs localcs = cs.a();
    boolean bool = false;
    if ((localcs != null) && (localcs.e() != null))
    {
      if ((a & 0x2) == 2) {
        bool = true;
      }
      return bool;
    }
    m.b(0L);
    return false;
  }
  
  public static void k()
  {
    a = 0;
  }
  
  public static String l()
  {
    String str;
    if ((m == 0) && (!c.l())) {
      str = new Safeguard(j, "safeguard_pref").getSafeguardInfo();
    } else {
      str = null;
    }
    m += 1;
    return str;
  }
  
  public static de m()
  {
    de localde = l;
    if (localde != null) {
      return localde;
    }
    l = new df(n());
    return l;
  }
  
  public static Context n()
  {
    return j;
  }
  
  private void p()
  {
    TMSDKContext.SaveStringData(1150055, "");
    if (d())
    {
      TMSDKContext.SaveStringData(1150056, "");
      Log.i("xx", "new");
    }
  }
  
  private static boolean q()
  {
    return n().getSharedPreferences("sp_name_global", 0).getBoolean("KEY_FIRSTTIME", true);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    com.tencent.token.upload.e.b = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (!this.i.compareAndSet(false, true))
    {
      Log.e("RQ", "already init before");
      return;
    }
    CrashReport.setLogAble(com.tencent.token.utils.j.l, com.tencent.token.utils.j.m);
    CrashReport.setUserId(j, "testUserId");
    Object localObject = o();
    CrashReport.initCrashReport(j, null, null, true, (CrashStrategyBean)localObject);
    localObject = dz.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(j, (String)localObject, com.tencent.token.utils.j.p);
    if (com.tencent.token.utils.j.n) {
      ANRReport.startANRMonitor(j);
    }
    CrashReport.setUserId(j, e());
    TMSDKContext.setTMSDKLogEnable(false);
    h = TMSDKContext.init(j, null);
    TMSDKContext.setAutoConnectionSwitch(j, true);
    k.a();
    PermissionGuide.init(this, new com.tencent.token.global.taiji.j());
    PermissionGuide.pullAdapterSolution();
    a.a().a(j);
    p();
  }
  
  public Context getApplicationContext()
  {
    return j;
  }
  
  protected CrashStrategyBean o()
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
    k = this;
    j = this;
    j = dx.a(getApplicationContext());
    c.a(getApplicationContext());
    et.a(getApplicationContext());
    if (e.a().b()) {
      b();
    }
    boolean bool = m.c();
    if (!bool) {
      g();
    }
    if (bool) {
      m.a(false);
    }
    new Thread()
    {
      public void run()
      {
        try
        {
          for (;;)
          {
            if ((!ce.a().d()) && (m.e() == 0L))
            {
              Thread.sleep(60000L);
            }
            else if (RqdApplication.d < 60)
            {
              RqdApplication.c = 1;
              Thread.sleep(60000L);
              RqdApplication.d = 60;
            }
            else
            {
              Thread.sleep(1000L);
              if (l.d()) {
                RqdApplication.c = 1;
              } else {
                RqdApplication.c = 0;
              }
            }
          }
          return;
        }
        catch (Exception localException)
        {
          g.b(localException.toString());
          localException.printStackTrace();
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