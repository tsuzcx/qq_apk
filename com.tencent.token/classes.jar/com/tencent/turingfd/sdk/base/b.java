package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;

public class b
{
  public static final String a = cv.a + "_" + "baseFull";
  public static String b = "";
  
  public static o a(Context paramContext)
  {
    try
    {
      localObject1 = (WindowManager)paramContext.getSystemService("window");
      localObject2 = new DisplayMetrics();
      ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      i = ((DisplayMetrics)localObject2).widthPixels;
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        localObject1 = (WindowManager)paramContext.getSystemService("window");
        localObject2 = new DisplayMetrics();
        ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
        j = ((DisplayMetrics)localObject2).heightPixels;
        if (i < j)
        {
          localif = new if();
          localObject2 = cm.e(paramContext);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localif.H = ((String)localObject1);
          localObject2 = cm.f(paramContext);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localif.I = ((String)localObject1);
          localif.Ba = "";
          localif.K = "0";
          localif.Q = "0";
          localif.R = 92;
          localif.S = "09AEBC42447E1917";
          localif.B = 49;
          localif.U = cv.a;
          localif.W = 2;
          localif.aa = 201;
          localif.ba = false;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          try
          {
            if localif;
            localif.ca = paramContext.getPackageName();
            Object localObject2 = Build.MODEL;
            Object localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localif.da = ((String)localObject1);
            localif.ea = Build.VERSION.SDK_INT;
            try
            {
              paramContext = paramContext.getContentResolver();
              paramContext = Settings.Secure.getString(paramContext, "android_id");
            }
            catch (Throwable paramContext)
            {
              paramContext = "";
              continue;
              u.b = Integer.valueOf(paramContext.length);
              k = u.b.intValue();
              continue;
            }
            localObject1 = paramContext;
            if (paramContext == null) {
              localObject1 = "";
            }
            localif.fa = ((String)localObject1);
            localif.ga = 2052;
            localif.ha = 1;
            localif.Ka = u.a("ro.product.cpu.abi2");
            localObject1 = u.a();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.ja = paramContext;
            if (u.b == null) {}
            try
            {
              paramContext = new p();
              paramContext = new File("/sys/devices/system/cpu/").listFiles(paramContext);
              if (paramContext != null) {
                continue;
              }
            }
            catch (Throwable paramContext)
            {
              continue;
            }
            k = 1;
            localif.ka = k;
            localif.la = (j + "*" + i);
            localif.na = u.b();
            localObject1 = Build.BRAND;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.pa = paramContext;
            localObject1 = Build.VERSION.INCREMENTAL;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.qa = paramContext;
            localObject1 = Build.VERSION.RELEASE;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.ra = paramContext;
            localif.version = "1.0.0";
            localif.Fa = 1;
            localif.Ga = "";
            localObject1 = u.c();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.ua = paramContext;
            localif.xa = 0;
            localif.ya = 0;
            localObject1 = Build.DEVICE;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ha = paramContext;
            localObject1 = Build.BOARD;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ia = paramContext;
            localif.Ja = u.a("ro.build.product");
            localif.La = u.a("ro.build.fingerprint");
            localif.Ma = u.a("ro.product.locale.language");
            localif.Na = u.a("ro.product.locale.region");
            localObject1 = u.d();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Oa = paramContext;
            localif.va = u.a("ro.board.platform");
            localif.Qa = u.a("ro.mediatek.platform");
            localif.wa = u.a("ro.sf.lcd_density");
            localif.sa = u.a("ro.product.name");
            localif.ta = u.a("ro.build.version.release");
            localObject1 = u.a(false);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ra = paramContext;
            localif.za = false;
            localif.Sa = 0;
            localObject1 = u.e();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ta = paramContext;
            localObject1 = cm.a(true);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ua = paramContext;
            localObject1 = cm.a(false);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Va = paramContext;
            paramContext = new o.b(1, 10001, 0);
            paramContext.d = localif;
            paramContext.f = new try();
            return paramContext.a();
            localThrowable1 = localThrowable1;
            i = -1;
            continue;
            localThrowable2 = localThrowable2;
            j = -1;
          }
          catch (Throwable localThrowable3)
          {
            continue;
          }
          int k = j;
          int j = i;
          int i = k;
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(b + a, 0).edit();
      paramContext.putString("g", paramString).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(b + a, 0);
      paramContext = paramContext.getString("g", "");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.b
 * JD-Core Version:    0.7.0.1
 */