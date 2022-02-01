package com.tencent.token.global;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import btmsdkobf.bw;
import btmsdkobf.cx;
import btmsdkobf.cy;
import btmsdkobf.db;
import com.android.safeguard.Safeguard;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.token.aam;
import com.tencent.token.aao;
import com.tencent.token.aap;
import com.tencent.token.aar;
import com.tencent.token.aas;
import com.tencent.token.abu;
import com.tencent.token.ais;
import com.tencent.token.ait;
import com.tencent.token.atv;
import com.tencent.token.av;
import com.tencent.token.av.a;
import com.tencent.token.ax;
import com.tencent.token.ay;
import com.tencent.token.bf;
import com.tencent.token.bg;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.qs;
import com.tencent.token.qs.a;
import com.tencent.token.re;
import com.tencent.token.rf;
import com.tencent.token.rf.b;
import com.tencent.token.rj;
import com.tencent.token.rj.b;
import com.tencent.token.rw;
import com.tencent.token.se;
import com.tencent.token.sg;
import com.tencent.token.si;
import com.tencent.token.sj;
import com.tencent.token.sk;
import com.tencent.token.sz;
import com.tencent.token.th;
import com.tencent.token.xc;
import com.tencent.token.xf;
import com.tencent.token.xj;
import com.tencent.token.xl;
import com.tencent.token.xq;
import com.tencent.token.xr;
import com.tencent.token.xx;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.utils.MD5Util;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class RqdApplication
  extends Application
  implements ax
{
  public static int a = 0;
  public static boolean b = false;
  public static volatile int c = 1;
  public static volatile int d = 60;
  public static String e;
  public static boolean f = false;
  public static boolean g = false;
  public static final boolean h = aam.d;
  public static boolean i = false;
  static boolean m = false;
  private static Context n;
  private static RqdApplication o;
  private static aar p;
  private static int q = -1;
  AtomicBoolean j = new AtomicBoolean(false);
  public boolean k = false;
  int l = 0;
  
  public static RqdApplication a()
  {
    return o;
  }
  
  public static String a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(str, 0).publicSourceDir;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label22:
      break label22;
    }
    return null;
  }
  
  public static Context b()
  {
    Context localContext2 = xl.a();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = n;
    }
    return localContext1;
  }
  
  private static boolean b(Context paramContext)
  {
    return c(paramContext) == d(paramContext);
  }
  
  private static long c(Context paramContext)
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
  
  public static Context c()
  {
    return n;
  }
  
  private static long d(Context paramContext)
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
  
  public static void f()
  {
    b().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  public static boolean g()
  {
    return (s()) && (b(b()));
  }
  
  public static void h()
  {
    c = 1;
    d = 0;
  }
  
  public static void i()
  {
    a = 0;
    if ((sk.a().c()) && (sk.a().a == 2)) {
      a |= 0x1;
    }
    if (aap.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean j()
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
  
  public static boolean k()
  {
    return (a & 0x1) == 1;
  }
  
  public static boolean l()
  {
    th localth = th.a();
    if ((localth != null) && (localth.k.b() != null)) {
      return (a & 0x2) == 2;
    }
    aap.b(0L);
    return false;
  }
  
  public static void m()
  {
    a = 0;
  }
  
  public static String n()
  {
    String str;
    if ((q == 0) && (!xf.j())) {
      str = new Safeguard(n, "safeguard_pref").getSafeguardInfo();
    } else {
      str = null;
    }
    q += 1;
    return str;
  }
  
  public static aar o()
  {
    Object localObject = p;
    if (localObject != null) {
      return localObject;
    }
    localObject = new aas(b());
    p = (aar)localObject;
    return localObject;
  }
  
  public static Context p()
  {
    return b();
  }
  
  public static boolean q()
  {
    return m;
  }
  
  private static void r()
  {
    TMSDKContext.SaveStringData(1150055, "");
    if (g()) {
      TMSDKContext.SaveStringData(1150056, "");
    }
  }
  
  private static boolean s()
  {
    return b().getSharedPreferences("sp_name_global", 0).getBoolean("KEY_FIRSTTIME", true);
  }
  
  private static String t()
  {
    Object localObject = "testUserId";
    if ((th.a().k.b() != null) && (th.a().k.b().mRealUin != 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(th.a().k.b().mRealUin);
      return ((StringBuilder)localObject).toString();
    }
    String str1 = aao.b(b());
    String str2 = aao.c(b());
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
    xj.c("RqdApplication: userId =".concat(String.valueOf(localObject)));
    return localObject;
  }
  
  private static CrashStrategyBean u()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(aam.o);
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
    n = this;
    com.tencent.token.zw.b = System.currentTimeMillis();
  }
  
  public final void d()
  {
    if (!this.j.compareAndSet(false, true)) {
      return;
    }
    CrashReport.setLogAble(aam.l, aam.m);
    CrashReport.setUserId(b(), "testUserId");
    Object localObject = u();
    CrashReport.initCrashReport(b(), null, null, true, (CrashStrategyBean)localObject);
    localObject = abu.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(b(), (String)localObject, aam.p);
    if (aam.n) {
      ANRReport.startANRMonitor(b());
    }
    CrashReport.setUserId(b(), t());
    TMSDKContext.setTMSDKLogEnable(false);
    i = TMSDKContext.init(b(), null);
    TMSDKContext.setAutoConnectionSwitch(b(), true);
    xq.a();
    atv.a(this, new xx());
    qs.a.a().a();
    rj.b.a().a(b());
    r();
    e();
  }
  
  final void e()
  {
    if (this.k) {
      return;
    }
    String str = bw.ah().aj();
    if (TextUtils.isEmpty(str))
    {
      this.l += 1;
      if (this.l > 10)
      {
        if (!NetworkUtil.isNetworkConnected())
        {
          Toast.makeText(n, "网络连接失败，请检查网络", 0).show();
        }
        else if (cx.iT)
        {
          db.bZ().hF.jy.sendEmptyMessage(2);
          db.bZ().hF.jy.sendEmptyMessageDelayed(3, 1000L);
        }
        this.l = 0;
      }
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          RqdApplication.this.e();
        }
      }, 500L);
      return;
    }
    sj.b(xf.h());
    rf.a();
    rf.b(xr.a);
    try
    {
      se localse = new se();
      Object localObject1 = localse.a;
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Object localObject2 = se.c();
        long l1 = ((SharedPreferences)localObject2).getLong("seed_expire_time", 0L);
        long l2 = Long.parseLong(((SharedPreferences)localObject2).getString("token_seq_sp", ""));
        localObject1 = sz.a((byte[])localObject1);
        boolean bool = rf.a().a((String)localObject1, l1, l2);
        localObject2 = new StringBuilder("init initCodeStr:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", expireTime:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(", accept:");
        ((StringBuilder)localObject2).append(bool);
        if (bool)
        {
          localse.a = null;
          localse.a();
        }
      }
      rf.a();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw localUnsatisfiedLinkError;
    }
    catch (Throwable localThrowable)
    {
      label301:
      break label301;
    }
    rf.a().a(b(), "com.tencent.token", str, sj.a(), new rf.b()
    {
      public final String a()
      {
        return xq.b();
      }
      
      public final void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
      {
        QQUser localQQUser = th.a().d(paramAnonymousLong);
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
        Object localObject = paramAnonymousString;
        if (paramAnonymousString != null)
        {
          localObject = paramAnonymousString;
          if (paramAnonymousString.contains("[AP]"))
          {
            localObject = RqdApplication.a(RqdApplication.this.getApplicationContext());
            if (localObject != null)
            {
              localObject = MD5Util.getFileMD5(new File((String)localObject));
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramAnonymousString);
              localStringBuilder.append(", md5:");
              localStringBuilder.append((String)localObject);
              localObject = localStringBuilder.toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramAnonymousString);
              ((StringBuilder)localObject).append(", md5 file null");
              localObject = ((StringBuilder)localObject).toString();
            }
          }
        }
        CrashReport.handleCatchException(Thread.currentThread(), new Throwable("galtrack_token:".concat(String.valueOf(localObject))), "自定义上报", null);
      }
      
      public final boolean a(long paramAnonymousLong)
      {
        int i = 0;
        while (i < th.a().k.a())
        {
          QQUser localQQUser = th.a().a(i);
          if (localQQUser.mRealUin == paramAnonymousLong) {
            return localQQUser.mIsBinded;
          }
          i += 1;
        }
        return false;
      }
      
      public final re b()
      {
        re localre = new re();
        Object localObject = sg.a(RqdApplication.p());
        QQUser localQQUser = th.a().k.b();
        if (localQQUser == null) {
          return localre;
        }
        if (localQQUser.mRealUin != 0L)
        {
          localObject = ((sg)localObject).a(localQQUser.mRealUin);
          if (localObject != null) {
            localre.c = aao.a((byte[])localObject);
          }
        }
        localre.a = localQQUser.mRealUin;
        localre.b = localQQUser.mUin;
        if (localre.b == localre.a) {
          localre.b = aao.f(localre.a);
        }
        return localre;
      }
    });
    this.k = true;
    si.a().c();
  }
  
  public Context getApplicationContext()
  {
    if (g) {
      return super.getApplicationContext();
    }
    return b();
  }
  
  @bf(a=av.a.ON_STOP)
  public void onAppBackgrounded()
  {
    m = false;
  }
  
  @bf(a=av.a.ON_START)
  public void onAppForegrounded()
  {
    m = true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    o = this;
    n = this;
    xc.a(this);
    com.tencent.token.aji.a = false;
    xl.a(n);
    bg.a().getLifecycle().a(this);
    xf.a(getApplicationContext());
    ait.a(getApplicationContext());
    if (rw.a().b())
    {
      g = true;
      d();
    }
    boolean bool = aap.c();
    if (!bool) {
      i();
    }
    if (bool) {
      aap.a(false);
    }
    new Thread()
    {
      public final void run()
      {
        try
        {
          for (;;)
          {
            if ((!sk.a().d()) && (aap.e() == 0L))
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
              if (aao.d()) {
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
          xj.b(localException.toString());
          localException.printStackTrace();
        }
      }
    }.start();
    xj.a("rqd start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */