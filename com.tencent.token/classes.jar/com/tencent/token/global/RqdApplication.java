package com.tencent.token.global;

import android.app.Application;
import android.content.Context;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.kingkong.Common;
import com.tencent.token.a;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fd;
import com.tencent.token.ff;
import com.tencent.token.gb;
import com.tencent.token.gl;
import com.tencent.token.utils.q;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.io.File;

public class RqdApplication
  extends Application
{
  public static int a = 0;
  public static boolean b;
  public static volatile int c = 1;
  public static volatile int d = 120;
  public static String e;
  public static boolean f;
  public static final boolean g = q.d;
  private static Context h;
  private static fd i;
  private static int j = -1;
  
  public static void a()
  {
    c = 1;
    d = 0;
  }
  
  public static void b()
  {
    a = 0;
    if ((ah.a().c()) && (ah.a().e() == 2)) {
      a |= 0x1;
    }
    if (t.e() != 0L) {
      a |= 0x2;
    }
  }
  
  public static boolean c()
  {
    int k;
    if ((a & 0x1) == 1)
    {
      k = 1;
      if (k == 0) {
        break label22;
      }
    }
    label22:
    while ((a & 0x2) == 2)
    {
      return true;
      k = 0;
      break;
    }
    return false;
  }
  
  public static boolean d()
  {
    return (a & 0x1) == 1;
  }
  
  public static boolean e()
  {
    ax localax = ax.a();
    if ((localax == null) || (localax.e() == null)) {
      t.b(0L);
    }
    while ((a & 0x2) != 2) {
      return false;
    }
    return true;
  }
  
  public static void f()
  {
    a = 0;
  }
  
  public static String g()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (j == 0)
    {
      localObject1 = localObject2;
      if (!b.i()) {
        localObject1 = new a(h, "safeguard_pref").a();
      }
    }
    j += 1;
    return localObject1;
  }
  
  public static fd h()
  {
    if (i != null) {
      return i;
    }
    ff localff = new ff(h);
    i = localff;
    return localff;
  }
  
  public static Context i()
  {
    return h;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h = getApplicationContext();
    b.a(getApplicationContext());
    gl.a(getApplicationContext());
    CrashReport.setLogAble(q.l, q.m);
    CrashReport.setUserId(h, "testUserId");
    Object localObject = new CrashStrategyBean();
    ((CrashStrategyBean)localObject).setStoreCrashSdcard(q.o);
    ((CrashStrategyBean)localObject).setCrashSdcardMaxSize(5000);
    ((CrashStrategyBean)localObject).setMaxStoredNum(10);
    ((CrashStrategyBean)localObject).setMaxUploadNum_GPRS(2);
    ((CrashStrategyBean)localObject).setMaxUploadNum_Wifi(20);
    ((CrashStrategyBean)localObject).setMaxLogRow(300);
    ((CrashStrategyBean)localObject).setMaxStackFrame(5);
    ((CrashStrategyBean)localObject).setMaxStackLine(200);
    CrashReport.initCrashReport(h, null, null, true, (CrashStrategyBean)localObject);
    localObject = gb.b().getAbsolutePath();
    CrashReport.initNativeCrashReport(h, (String)localObject, q.p);
    if (q.n) {
      ANRReport.startANRMonitor(h);
    }
    Context localContext = h;
    localObject = "testUserId";
    if ((ax.a().e() != null) && (ax.a().e().mRealUin != 0L))
    {
      localObject = "" + ax.a().e().mRealUin;
      CrashReport.setUserId(localContext, (String)localObject);
      Common.SetContext(this);
      Common.SetSafeStatus(true);
      boolean bool = t.c();
      if (!bool) {
        b();
      }
      if (bool) {
        t.a(false);
      }
      new f(this).start();
      e.a("rqd start");
      return;
    }
    String str1 = s.b(h);
    String str2 = s.c(h);
    int k;
    label286:
    int m;
    if (str1 == null)
    {
      k = 1;
      if (str2 != null) {
        break label367;
      }
      m = 1;
      label293:
      if ((k == 0) || (m == 0))
      {
        if ((k != 0) || (m != 0)) {
          break label372;
        }
        localObject = str1 + ";" + str2;
      }
    }
    for (;;)
    {
      e.c("RqdApplication: userId =" + (String)localObject);
      break;
      k = 0;
      break label286;
      label367:
      m = 0;
      break label293;
      label372:
      if (k != 0) {
        localObject = str2;
      } else {
        localObject = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.RqdApplication
 * JD-Core Version:    0.7.0.1
 */