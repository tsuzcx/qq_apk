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
import com.tencent.token.aaa;
import com.tencent.token.aac;
import com.tencent.token.aad;
import com.tencent.token.aaf;
import com.tencent.token.aag;
import com.tencent.token.abh;
import com.tencent.token.abj;
import com.tencent.token.ahg;
import com.tencent.token.ahh;
import com.tencent.token.ary;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ql;
import com.tencent.token.ql.a;
import com.tencent.token.qx;
import com.tencent.token.qy;
import com.tencent.token.qy.b;
import com.tencent.token.rb;
import com.tencent.token.rb.b;
import com.tencent.token.ro;
import com.tencent.token.rw;
import com.tencent.token.ry;
import com.tencent.token.sa;
import com.tencent.token.sb;
import com.tencent.token.sc;
import com.tencent.token.sr;
import com.tencent.token.sz;
import com.tencent.token.ww;
import com.tencent.token.xa;
import com.tencent.token.xe;
import com.tencent.token.xk;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.utils.MD5Util;
import com.tmsdk.base.utils.NetworkUtil;
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
  public static final boolean h = aaa.d;
  public static boolean i = false;
  private static Context m;
  private static RqdApplication n;
  private static aaf o;
  private static int p = -1;
  AtomicBoolean j = new AtomicBoolean(false);
  public boolean k = false;
  int l = 0;
  
  public static RqdApplication a()
  {
    return n;
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
  
  public static void d()
  {
    n().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  public static boolean e()
  {
    return (p()) && (b(n()));
  }
  
  public static void f()
  {
    c = 1;
    d = 0;
  }
  
  public static void g()
  {
    a = 0;
    if ((sc.a().c()) && (sc.a().a == 2)) {
      a |= 0x1;
    }
    if (aad.e() != 0L) {
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
    sz localsz = sz.a();
    if ((localsz != null) && (localsz.k.b() != null)) {
      return (a & 0x2) == 2;
    }
    aad.b(0L);
    return false;
  }
  
  public static void k()
  {
    a = 0;
  }
  
  public static String l()
  {
    String str;
    if ((p == 0) && (!ww.j())) {
      str = new Safeguard(m, "safeguard_pref").getSafeguardInfo();
    } else {
      str = null;
    }
    p += 1;
    return str;
  }
  
  public static aaf m()
  {
    Object localObject = o;
    if (localObject != null) {
      return localObject;
    }
    localObject = new aag(n());
    o = (aaf)localObject;
    return localObject;
  }
  
  public static Context n()
  {
    if (g) {
      return n;
    }
    return m;
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
    if ((sz.a().k.b() != null) && (sz.a().k.b().mRealUin != 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sz.a().k.b().mRealUin);
      return ((StringBuilder)localObject).toString();
    }
    String str1 = aac.b(m);
    String str2 = aac.c(m);
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
    xa.c("RqdApplication: userId =".concat(String.valueOf(localObject)));
    return localObject;
  }
  
  private static CrashStrategyBean r()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(aaa.o);
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
    com.tencent.token.zj.b = System.currentTimeMillis();
  }
  
  public final void b()
  {
    if (!this.j.compareAndSet(false, true)) {
      return;
    }
    CrashReport.setLogAble(aaa.l, aaa.m);
    CrashReport.setUserId(m, "testUserId");
    Object localObject = r();
    CrashReport.initCrashReport(m, null, null, true, (CrashStrategyBean)localObject);
    localObject = abj.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(m, (String)localObject, aaa.p);
    if (aaa.n) {
      ANRReport.startANRMonitor(m);
    }
    CrashReport.setUserId(m, q());
    TMSDKContext.setTMSDKLogEnable(false);
    i = TMSDKContext.init(m, null);
    TMSDKContext.setAutoConnectionSwitch(m, true);
    xe.a();
    ary.a(this, new xk());
    ql.a.a().a();
    rb.b.a().a(m);
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
      this.l += 1;
      if (this.l > 10)
      {
        if (!NetworkUtil.isNetworkConnected())
        {
          Toast.makeText(m, "网络连接失败，请检查网络", 0).show();
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
          RqdApplication.this.c();
        }
      }, 500L);
      return;
    }
    sb.b(ww.h());
    try
    {
      rw localrw = new rw();
      Object localObject1 = localrw.a;
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Object localObject2 = rw.c();
        long l1 = ((SharedPreferences)localObject2).getLong("seed_expire_time", 0L);
        long l2 = Long.parseLong(((SharedPreferences)localObject2).getString("token_seq_sp", ""));
        localObject1 = sr.a((byte[])localObject1);
        boolean bool = qy.a().a((String)localObject1, l1, l2);
        localObject2 = new StringBuilder("init initCodeStr:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", expireTime:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(", accept:");
        ((StringBuilder)localObject2).append(bool);
        if (bool)
        {
          localrw.a = null;
          localrw.a();
        }
      }
      qy.a();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw localUnsatisfiedLinkError;
    }
    catch (Throwable localThrowable)
    {
      label291:
      break label291;
    }
    qy.a().a(m, "com.tencent.token", str, sb.a(), new qy.b()
    {
      public final String a()
      {
        return xe.b();
      }
      
      public final void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
      {
        QQUser localQQUser = sz.a().d(paramAnonymousLong);
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
        while (i < sz.a().k.a())
        {
          QQUser localQQUser = sz.a().a(i);
          if (localQQUser.mRealUin == paramAnonymousLong) {
            return localQQUser.mIsBinded;
          }
          i += 1;
        }
        return false;
      }
      
      public final qx b()
      {
        qx localqx = new qx();
        Object localObject = ry.a(RqdApplication.n());
        QQUser localQQUser = sz.a().k.b();
        if (localQQUser == null) {
          return localqx;
        }
        if (localQQUser.mRealUin != 0L)
        {
          localObject = ((ry)localObject).a(localQQUser.mRealUin);
          if (localObject != null) {
            localqx.c = aac.a((byte[])localObject);
          }
        }
        localqx.a = localQQUser.mRealUin;
        localqx.b = localQQUser.mUin;
        if (localqx.b == localqx.a) {
          localqx.b = aac.f(localqx.a);
        }
        return localqx;
      }
    });
    this.k = true;
    sa.a().c();
  }
  
  public Context getApplicationContext()
  {
    if (g) {
      return super.getApplicationContext();
    }
    return m;
  }
  
  public void onCreate()
  {
    super.onCreate();
    n = this;
    m = this;
    m = abh.a(getApplicationContext());
    ww.a(getApplicationContext());
    ahh.a(getApplicationContext());
    if (ro.a().b())
    {
      g = true;
      b();
    }
    boolean bool = aad.c();
    if (!bool) {
      g();
    }
    if (bool) {
      aad.a(false);
    }
    new Thread()
    {
      public final void run()
      {
        try
        {
          for (;;)
          {
            if ((!sc.a().d()) && (aad.e() == 0L))
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
              if (aac.d()) {
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
          xa.b(localException.toString());
          localException.printStackTrace();
        }
      }
    }.start();
    xa.a("rqd start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */