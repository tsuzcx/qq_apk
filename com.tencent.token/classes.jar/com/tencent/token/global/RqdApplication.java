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
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.token.aaw;
import com.tencent.token.aay;
import com.tencent.token.aaz;
import com.tencent.token.abb;
import com.tencent.token.abc;
import com.tencent.token.acb;
import com.tencent.token.ajr;
import com.tencent.token.ajs;
import com.tencent.token.aut;
import com.tencent.token.bj;
import com.tencent.token.bj.a;
import com.tencent.token.bl;
import com.tencent.token.bm;
import com.tencent.token.bt;
import com.tencent.token.bu;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.rg;
import com.tencent.token.rg.a;
import com.tencent.token.rs;
import com.tencent.token.rt;
import com.tencent.token.rt.b;
import com.tencent.token.rw;
import com.tencent.token.rw.b;
import com.tencent.token.sj;
import com.tencent.token.ss;
import com.tencent.token.su;
import com.tencent.token.sv;
import com.tencent.token.sw;
import com.tencent.token.tt;
import com.tencent.token.xo;
import com.tencent.token.xr;
import com.tencent.token.xv;
import com.tencent.token.xx;
import com.tencent.token.yc;
import com.tencent.token.yd;
import com.tencent.token.yj;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.utils.MD5Util;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public class RqdApplication
  extends Application
  implements bl
{
  public static int a = 0;
  public static boolean b = false;
  public static volatile int c = 1;
  public static volatile int d = 60;
  public static String e;
  public static boolean f = false;
  public static boolean g = false;
  public static final boolean h = aaw.d;
  public static boolean i = false;
  static boolean m = false;
  private static Context n;
  private static RqdApplication o;
  private static abb p;
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
    Context localContext2 = xx.a();
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
  
  public static void e()
  {
    b().getSharedPreferences("sp_name_global", 0).edit().putBoolean("KEY_FIRSTTIME", false).commit();
  }
  
  public static boolean f()
  {
    return (q()) && (b(b()));
  }
  
  public static void g()
  {
    c = 1;
    d = 0;
  }
  
  public static void h()
  {
    a = 0;
    if ((sw.a().c()) && (sw.a().a == 2)) {
      a |= 0x1;
    }
    if (aaz.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean i()
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
  
  public static boolean j()
  {
    return (a & 0x1) == 1;
  }
  
  public static boolean k()
  {
    tt localtt = tt.a();
    if ((localtt != null) && (localtt.k.b() != null)) {
      return (a & 0x2) == 2;
    }
    aaz.b(0L);
    return false;
  }
  
  public static void l()
  {
    a = 0;
  }
  
  public static abb m()
  {
    Object localObject = p;
    if (localObject != null) {
      return localObject;
    }
    localObject = new abc(b());
    p = (abb)localObject;
    return localObject;
  }
  
  public static Context n()
  {
    return b();
  }
  
  public static boolean o()
  {
    return m;
  }
  
  private static void p()
  {
    TMSDKContext.SaveStringData(1150055, "");
    if (f()) {
      TMSDKContext.SaveStringData(1150056, "");
    }
  }
  
  private static boolean q()
  {
    return b().getSharedPreferences("sp_name_global", 0).getBoolean("KEY_FIRSTTIME", true);
  }
  
  private static String r()
  {
    if ((tt.a().k.b() != null) && (tt.a().k.b().mRealUin != 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(tt.a().k.b().mRealUin);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = aay.c(b());
    int i1;
    if (localObject == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      localObject = bw.ah().aj();
    }
    xv.c("RqdApplication: userId =".concat(String.valueOf(localObject)));
    return localObject;
  }
  
  private static CrashStrategyBean s()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setStoreCrashSdcard(aaw.o);
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
    com.tencent.token.aag.b = System.currentTimeMillis();
  }
  
  public final void c()
  {
    if (!this.j.compareAndSet(false, true)) {
      return;
    }
    CrashReport.setLogAble(aaw.l, aaw.m);
    CrashReport.setUserId(b(), "testUserId");
    Object localObject = s();
    CrashReport.initCrashReport(b(), null, null, true, (CrashStrategyBean)localObject);
    localObject = acb.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(b(), (String)localObject, aaw.p);
    if (aaw.n) {
      ANRReport.startANRMonitor(b());
    }
    TMSDKContext.setTMSDKLogEnable(false);
    i = TMSDKContext.init(b(), null);
    CrashReport.setUserId(b(), r());
    TMSDKContext.setAutoConnectionSwitch(b(), true);
    yc.a();
    aut.a(this, new yj());
    rg.a.a().a();
    rw.b.a().a(b());
    p();
    d();
  }
  
  final void d()
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
          RqdApplication.this.d();
        }
      }, 500L);
      return;
    }
    sv.b(xr.h());
    rt.a();
    rt.a(yd.a);
    try
    {
      rt.a();
      label151:
      rt.a().a(b(), "com.tencent.token", str, sv.a(), new rt.b()
      {
        public final String a()
        {
          return yc.b();
        }
        
        public final void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
        {
          QQUser localQQUser = tt.a().d(paramAnonymousLong);
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
          while (i < tt.a().k.a())
          {
            QQUser localQQUser = tt.a().a(i);
            if (localQQUser.mRealUin == paramAnonymousLong) {
              return localQQUser.mIsBinded;
            }
            i += 1;
          }
          return false;
        }
        
        public final rs b()
        {
          rs localrs = new rs();
          Object localObject = ss.a(RqdApplication.n());
          QQUser localQQUser = tt.a().k.b();
          if (localQQUser == null) {
            return localrs;
          }
          if (localQQUser.mRealUin != 0L)
          {
            localObject = ((ss)localObject).a(localQQUser.mRealUin);
            if (localObject != null) {
              localrs.c = aay.a((byte[])localObject);
            }
          }
          localrs.a = localQQUser.mRealUin;
          localrs.b = localQQUser.mUin;
          if (localrs.b == localrs.a) {
            localrs.b = aay.f(localrs.a);
          }
          return localrs;
        }
      });
      this.k = true;
      su.a().c();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      throw localUnsatisfiedLinkError;
    }
    catch (Throwable localThrowable)
    {
      break label151;
    }
  }
  
  public Context getApplicationContext()
  {
    if (g) {
      return super.getApplicationContext();
    }
    return b();
  }
  
  @bt(a=bj.a.ON_STOP)
  public void onAppBackgrounded()
  {
    m = false;
  }
  
  @bt(a=bj.a.ON_START)
  public void onAppForegrounded()
  {
    m = true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    o = this;
    n = this;
    try
    {
      Field localField1 = System.class.getField("err");
      localField1.setAccessible(true);
      Field localField2 = Field.class.getDeclaredField("accessFlags");
      localField2.setAccessible(true);
      localField2.setInt(localField1, localField1.getModifiers() & 0xFFFFFFEF);
      localField1.set(null, new PrintStream(new OutputStream()
      {
        public final void write(int paramAnonymousInt) {}
      }));
      label73:
      xo.a(n);
      com.tencent.token.akg.a = false;
      xx.a(n);
      bu.a().getLifecycle().a(this);
      xr.a(getApplicationContext());
      ajs.a(getApplicationContext());
      if (sj.a().b())
      {
        g = true;
        c();
      }
      boolean bool = aaz.c();
      if (!bool) {
        h();
      }
      if (bool) {
        aaz.a(false);
      }
      new Thread()
      {
        public final void run()
        {
          try
          {
            for (;;)
            {
              if ((!sw.a().d()) && (aaz.e() == 0L))
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
                if (aay.d()) {
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
            xv.b(localException.toString());
            localException.printStackTrace();
          }
        }
      }.start();
      xv.a("rqd start");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */