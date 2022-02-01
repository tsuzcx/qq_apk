package com.tencent.token.global;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import btmsdkobf.bw;
import com.android.safeguard.Safeguard;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.token.aab;
import com.tencent.token.aad;
import com.tencent.token.aae;
import com.tencent.token.aag;
import com.tencent.token.aah;
import com.tencent.token.abi;
import com.tencent.token.abk;
import com.tencent.token.ahh;
import com.tencent.token.ahi;
import com.tencent.token.arz;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.qm;
import com.tencent.token.qm.a;
import com.tencent.token.qy;
import com.tencent.token.qz;
import com.tencent.token.qz.b;
import com.tencent.token.rc;
import com.tencent.token.rc.b;
import com.tencent.token.rp;
import com.tencent.token.rx;
import com.tencent.token.rz;
import com.tencent.token.sb;
import com.tencent.token.sc;
import com.tencent.token.sd;
import com.tencent.token.ss;
import com.tencent.token.ta;
import com.tencent.token.wx;
import com.tencent.token.xb;
import com.tencent.token.xf;
import com.tencent.token.xl;
import com.tmsdk.TMSDKContext;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class RqdApplication
  extends Application
{
  public static int a = 0;
  public static boolean b = false;
  public static volatile int c = 1;
  public static volatile int d = 60;
  public static String e;
  public static boolean f = false;
  public static boolean g = false;
  public static final boolean h = aab.d;
  public static boolean i = false;
  private static Context l;
  private static RqdApplication m;
  private static aag n;
  private static int o = -1;
  AtomicBoolean j = new AtomicBoolean(false);
  public boolean k = false;
  
  public static RqdApplication a()
  {
    return m;
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
  
  public static void d()
  {
    n().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  public static boolean e()
  {
    return (p()) && (a(n()));
  }
  
  public static void f()
  {
    c = 1;
    d = 0;
  }
  
  public static void g()
  {
    a = 0;
    if ((sd.a().c()) && (sd.a().a == 2)) {
      a |= 0x1;
    }
    if (aae.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean h()
  {
    int i1;
    if ((a & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
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
    ta localta = ta.a();
    if ((localta != null) && (localta.k.b() != null)) {
      return (a & 0x2) == 2;
    }
    aae.b(0L);
    return false;
  }
  
  public static void k()
  {
    a = 0;
  }
  
  public static String l()
  {
    String str;
    if ((o == 0) && (!wx.j())) {
      str = new Safeguard(l, "safeguard_pref").getSafeguardInfo();
    } else {
      str = null;
    }
    o += 1;
    return str;
  }
  
  public static aag m()
  {
    Object localObject = n;
    if (localObject != null) {
      return localObject;
    }
    localObject = new aah(n());
    n = (aag)localObject;
    return localObject;
  }
  
  public static Context n()
  {
    if (g) {
      return m;
    }
    return l;
  }
  
  private static void o()
  {
    TMSDKContext.SaveStringData(1150055, "");
    if (e()) {
      TMSDKContext.SaveStringData(1150056, "");
    }
  }
  
  private static boolean p()
  {
    return n().getSharedPreferences("sp_name_global", 0).getBoolean("KEY_FIRSTTIME", true);
  }
  
  private static String q()
  {
    Object localObject = "testUserId";
    if ((ta.a().k.b() != null) && (ta.a().k.b().mRealUin != 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ta.a().k.b().mRealUin);
      return ((StringBuilder)localObject).toString();
    }
    String str1 = aad.b(l);
    String str2 = aad.c(l);
    int i2 = 1;
    int i1;
    if (str1 == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (str2 != null) {
      i2 = 0;
    }
    if ((i1 == 0) || (i2 == 0)) {
      if ((i1 == 0) && (i2 == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(";");
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (i1 != 0)
      {
        localObject = str2;
      }
      else
      {
        localObject = str1;
      }
    }
    xb.c("RqdApplication: userId =".concat(String.valueOf(localObject)));
    return localObject;
  }
  
  private static CrashStrategyBean r()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(aab.o);
    localCrashStrategyBean.setCrashSdcardMaxSize(5000);
    localCrashStrategyBean.setMaxStoredNum(10);
    localCrashStrategyBean.setMaxUploadNum_GPRS(2);
    localCrashStrategyBean.setMaxUploadNum_Wifi(20);
    localCrashStrategyBean.setMaxLogRow(300);
    localCrashStrategyBean.setMaxStackFrame(5);
    localCrashStrategyBean.setMaxStackLine(200);
    return localCrashStrategyBean;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    com.tencent.token.zk.b = System.currentTimeMillis();
  }
  
  public final void b()
  {
    if (!this.j.compareAndSet(false, true)) {
      return;
    }
    CrashReport.setLogAble(aab.l, aab.m);
    CrashReport.setUserId(l, "testUserId");
    Object localObject = r();
    CrashReport.initCrashReport(l, null, null, true, (CrashStrategyBean)localObject);
    localObject = abk.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(l, (String)localObject, aab.p);
    if (aab.n) {
      ANRReport.startANRMonitor(l);
    }
    CrashReport.setUserId(l, q());
    TMSDKContext.setTMSDKLogEnable(false);
    i = TMSDKContext.init(l, null);
    TMSDKContext.setAutoConnectionSwitch(l, true);
    xf.a();
    arz.a(this, new xl());
    qm.a.a().a();
    rc.b.a().a(l);
    o();
    c();
  }
  
  final void c()
  {
    if (this.k) {
      return;
    }
    String str = bw.ah().aj();
    if (TextUtils.isEmpty(str))
    {
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          RqdApplication.this.c();
        }
      }, 500L);
      return;
    }
    sc.b(wx.h());
    try
    {
      rx localrx = new rx();
      Object localObject1 = localrx.a;
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Object localObject2 = rx.c();
        long l1 = ((SharedPreferences)localObject2).getLong("seed_expire_time", 0L);
        long l2 = Long.parseLong(((SharedPreferences)localObject2).getString("token_seq_sp", ""));
        localObject1 = ss.a((byte[])localObject1);
        boolean bool = qz.a().a((String)localObject1, l1, l2);
        localObject2 = new StringBuilder("init initCodeStr:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", expireTime:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(", accept:");
        ((StringBuilder)localObject2).append(bool);
        if (bool)
        {
          localrx.a = null;
          localrx.a();
        }
      }
      qz.a();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw localUnsatisfiedLinkError;
    }
    catch (Throwable localThrowable)
    {
      label208:
      break label208;
    }
    qz.a().a(l, "com.tencent.token", str, sc.a(), new qz.b()
    {
      public final String a()
      {
        return xf.b();
      }
      
      public final void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
      {
        QQUser localQQUser = ta.a().d(paramAnonymousLong);
        if (localQQUser != null) {}
        try
        {
          localQQUser.mUin = Long.parseLong(paramAnonymousString1);
          label23:
          if (!TextUtils.isEmpty(paramAnonymousString2)) {
            localQQUser.mUinMask = paramAnonymousString2;
          }
          return;
        }
        catch (Throwable paramAnonymousString1)
        {
          break label23;
        }
      }
      
      public final void a(String paramAnonymousString)
      {
        CrashReport.handleCatchException(Thread.currentThread(), new Throwable("galtrack_token:".concat(String.valueOf(paramAnonymousString))), "自定义上报", null);
      }
      
      public final boolean a(long paramAnonymousLong)
      {
        int i = 0;
        while (i < ta.a().k.a())
        {
          QQUser localQQUser = ta.a().a(i);
          if (localQQUser.mRealUin == paramAnonymousLong) {
            return localQQUser.mIsBinded;
          }
          i += 1;
        }
        return false;
      }
      
      public final qy b()
      {
        qy localqy = new qy();
        Object localObject = rz.a(RqdApplication.n());
        QQUser localQQUser = ta.a().k.b();
        if (localQQUser == null) {
          return localqy;
        }
        if (localQQUser.mRealUin != 0L)
        {
          localObject = ((rz)localObject).a(localQQUser.mRealUin);
          if (localObject != null) {
            localqy.c = aad.a((byte[])localObject);
          }
        }
        localqy.a = localQQUser.mRealUin;
        localqy.b = localQQUser.mUin;
        if (localqy.b == localqy.a) {
          localqy.b = aad.f(localqy.a);
        }
        return localqy;
      }
    });
    this.k = true;
    sb.a().c();
  }
  
  public Context getApplicationContext()
  {
    if (g) {
      return super.getApplicationContext();
    }
    return l;
  }
  
  public void onCreate()
  {
    super.onCreate();
    m = this;
    l = this;
    l = abi.a(getApplicationContext());
    wx.a(getApplicationContext());
    ahi.a(getApplicationContext());
    if (rp.a().b())
    {
      g = true;
      b();
    }
    boolean bool = aae.c();
    if (!bool) {
      g();
    }
    if (bool) {
      aae.a(false);
    }
    new Thread()
    {
      public final void run()
      {
        try
        {
          for (;;)
          {
            if ((!sd.a().d()) && (aae.e() == 0L))
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
              if (aad.d()) {
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
          xb.b(localException.toString());
          localException.printStackTrace();
        }
      }
    }.start();
    xb.a("rqd start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */