package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.turingfd.sdk.base.if;
import com.tencent.turingfd.sdk.base.try;
import java.io.File;

public final class abn
{
  public static final String a;
  public static String b = "";
  
  static
  {
    StringBuilder localStringBuilder = aeu.a("turingfd_shark_");
    localStringBuilder.append(afh.a);
    localStringBuilder.append("_baseFull");
    a = localStringBuilder.toString();
  }
  
  public static acb a(Context paramContext)
  {
    j = -1;
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
        k = ((DisplayMetrics)localObject2).heightPixels;
        j = k;
        m = i;
        k = j;
        if (i >= j) {
          break label100;
        }
        k = i;
        m = j;
        localif = new if();
        localObject2 = aey.e(paramContext);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label128;
        }
        localObject1 = "";
        localif.H = ((String)localObject1);
        localObject2 = aey.f(paramContext);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label154;
        }
        localObject1 = "";
        localif.I = ((String)localObject1);
        localif.Ba = "";
        localif.K = "0";
        localif.Q = "0";
        localif.R = 92;
        localif.S = "09AEBC42447E1917";
        localif.B = 49;
        localObject1 = aeu.a("");
        ((StringBuilder)localObject1).append(afh.a);
        localif.U = ((StringBuilder)localObject1).toString();
        localif.W = 2;
        localif.aa = 201;
        localif.ba = false;
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            int k;
            int m;
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
              break label306;
            }
            paramContext = "";
            localObject1 = paramContext;
            if (paramContext == null) {
              localObject1 = "";
            }
            localif.fa = ((String)localObject1);
            localif.ga = 2052;
            localif.ha = 1;
            localif.Ka = acg.a("ro.product.cpu.abi2");
            localObject1 = acg.a();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.ja = paramContext;
            if (acg.a == null) {}
            try
            {
              paramContext = new aca();
              paramContext = new File("/sys/devices/system/cpu/").listFiles(paramContext);
              if (paramContext != null) {
                acg.a = Integer.valueOf(paramContext.length);
              }
            }
            catch (Throwable paramContext)
            {
              break label416;
            }
            int i = 1;
            break label428;
            i = acg.a.intValue();
            localif.ka = i;
            paramContext = new StringBuilder();
            paramContext.append(m);
            paramContext.append("*");
            paramContext.append(k);
            localif.la = paramContext.toString();
            localif.na = acg.b();
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
            localObject1 = Build.MANUFACTURER;
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "UNKNOWN";
            }
            localObject1 = paramContext;
            if (paramContext == null) {
              localObject1 = "";
            }
            localif.ua = ((String)localObject1);
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
            localif.Ja = acg.a("ro.build.product");
            localif.La = acg.a("ro.build.fingerprint");
            localif.Ma = acg.a("ro.product.locale.language");
            localif.Na = acg.a("ro.product.locale.region");
            localObject1 = acg.c();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Oa = paramContext;
            localif.va = acg.a("ro.board.platform");
            localif.Qa = acg.a("ro.mediatek.platform");
            localif.wa = acg.a("ro.sf.lcd_density");
            localif.sa = acg.a("ro.product.name");
            localif.ta = acg.a("ro.build.version.release");
            localObject1 = acg.d();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ra = paramContext;
            localif.za = false;
            localif.Sa = 0;
            localObject1 = acg.e();
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ta = paramContext;
            localObject1 = aey.a(true);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Ua = paramContext;
            localObject1 = aey.a(false);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = "";
            }
            localif.Va = paramContext;
            paramContext = new acb.a(1, 10001, 0);
            paramContext.d = localif;
            paramContext.f = new try();
            return paramContext.a();
            localThrowable1 = localThrowable1;
          }
          localThrowable2 = localThrowable2;
        }
        catch (Throwable localThrowable3)
        {
          break label258;
        }
      }
    }
    i = -1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(a);
      paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      paramContext.putString("g", paramString).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(a);
      paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
      paramContext = paramContext.getString("g", "");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abn
 * JD-Core Version:    0.7.0.1
 */