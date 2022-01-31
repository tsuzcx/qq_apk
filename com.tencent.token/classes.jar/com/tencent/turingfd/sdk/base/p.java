package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class p
{
  public static String a = "";
  
  public static ac a(Context paramContext)
  {
    try
    {
      localObject1 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject1 == null) {
        break label1145;
      }
      localObject2 = ((WifiInfo)localObject1).getMacAddress();
    }
    catch (Throwable localThrowable6)
    {
      for (;;)
      {
        Object localObject1;
        label194:
        label1145:
        Object localObject2 = "";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("02:00:00:00:00:00")) {
        break label194;
      }
    }
    try
    {
      localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          localObject3 = ((NetworkInterface)localObject2).getName();
        } while (!((String)localObject3).equalsIgnoreCase("wlan0"));
        localObject2 = ((NetworkInterface)localObject2).getHardwareAddress();
      } while (localObject2 == null);
      localObject1 = new StringBuilder();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        byte b = localObject2[i];
        ((StringBuilder)localObject1).append(String.format("%02x:", new Object[] { Byte.valueOf(b) }));
        i += 1;
      }
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Throwable localThrowable4)
    {
      for (;;)
      {
        try
        {
          localObject1 = (WindowManager)paramContext.getSystemService("window");
          localObject3 = new DisplayMetrics();
          ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
          i = ((DisplayMetrics)localObject3).widthPixels;
        }
        catch (Throwable localThrowable4)
        {
          try
          {
            localObject1 = (WindowManager)paramContext.getSystemService("window");
            localObject3 = new DisplayMetrics();
            ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
            j = ((DisplayMetrics)localObject3).heightPixels;
            if (i < j)
            {
              k = j;
              j = i;
              i = k;
              localif = new if();
            }
          }
          catch (Throwable localThrowable4)
          {
            try
            {
              localObject1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
              Object localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = "";
              }
              localif.K = ((String)localObject3);
              localObject3 = ed.e(paramContext);
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              localif.Q = ((String)localObject1);
              localif.Ea = "";
              localif.R = ((String)localObject2);
              localif.S = "0";
              localif.U = "0";
              localif.W = 92;
              localif.aa = "21916EDD69455490";
              localif.F = 32;
              localif.ba = "105678";
              localif.ca = 2;
              localif.da = 201;
              localif.ea = false;
            }
            catch (Throwable localThrowable4)
            {
              try
              {
                if localif;
                localif.fa = paramContext.getPackageName();
                localObject2 = Build.MODEL;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                localif.ga = ((String)localObject1);
                localif.ha = Build.VERSION.SDK_INT;
                try
                {
                  paramContext = paramContext.getContentResolver();
                  paramContext = Settings.Secure.getString(paramContext, "android_id");
                }
                catch (Throwable paramContext)
                {
                  paramContext = "";
                  continue;
                  aj.b = Integer.valueOf(paramContext.length);
                  k = aj.b.intValue();
                  continue;
                }
                localObject1 = paramContext;
                if (paramContext == null) {
                  localObject1 = "";
                }
                localif.ia = ((String)localObject1);
                localif.ja = 2052;
                localif.ka = 1;
                localif.Na = aj.a("ro.product.cpu.abi2");
                localObject1 = aj.a();
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.ma = paramContext;
                if (aj.b == null) {}
                try
                {
                  paramContext = new af();
                  paramContext = new File("/sys/devices/system/cpu/").listFiles(paramContext);
                  if (paramContext != null) {
                    continue;
                  }
                }
                catch (Throwable paramContext)
                {
                  String str1;
                  String str2;
                  continue;
                }
                k = 1;
                localif.na = k;
                localif.oa = (i + "*" + j);
                localif.qa = aj.b();
                localObject1 = Build.BRAND;
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.sa = paramContext;
                localObject1 = Build.VERSION.INCREMENTAL;
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.ta = paramContext;
                localObject1 = Build.VERSION.RELEASE;
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.ua = paramContext;
                localif.version = "1.0.0";
                localif.Ia = 1;
                localif.Ja = "";
                localObject1 = aj.c();
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.xa = paramContext;
                localif.Aa = 0;
                localif.Ba = 0;
                localObject1 = Build.DEVICE;
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Ka = paramContext;
                localObject1 = Build.BOARD;
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.La = paramContext;
                localif.Ma = aj.a("ro.build.product");
                localif.Oa = aj.a("ro.build.fingerprint");
                localif.Pa = aj.a("ro.product.locale.language");
                localif.Qa = aj.a("ro.product.locale.region");
                localObject1 = aj.d();
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Ra = paramContext;
                localif.ya = aj.a("ro.board.platform");
                localif.Ta = aj.a("ro.mediatek.platform");
                localif.za = aj.a("ro.sf.lcd_density");
                localif.va = aj.a("ro.product.name");
                localif.wa = aj.a("ro.build.version.release");
                localObject1 = aj.a(false);
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Ua = paramContext;
                localif.Ca = false;
                localif.Va = 0;
                localObject1 = aj.e();
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Wa = paramContext;
                localObject1 = ed.a(true);
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Xa = paramContext;
                localObject1 = ed.a(false);
                paramContext = (Context)localObject1;
                if (localObject1 == null) {
                  paramContext = "";
                }
                localif.Ya = paramContext;
                paramContext = new ad(1, 10001, 0);
                paramContext.d = localif;
                paramContext.f = new try();
                return paramContext.a();
                localThrowable1 = localThrowable1;
                str1 = "";
                continue;
                localThrowable2 = localThrowable2;
                int i = -1;
                continue;
                localThrowable3 = localThrowable3;
                int j = -1;
                continue;
                continue;
                localThrowable4 = localThrowable4;
                str2 = "";
              }
              catch (Throwable localThrowable5)
              {
                int k;
                continue;
              }
            }
          }
        }
        localObject2 = localThrowable5;
        continue;
        String str3 = "";
      }
    }
    if (localObject1 == null) {
      localObject2 = "";
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(a + "turingfd_shark_105678_32_baseFull", 0).edit().putString("g", paramString).commit();
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences(a + "turingfd_shark_105678_32_baseFull", 0).getString("g", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.p
 * JD-Core Version:    0.7.0.1
 */