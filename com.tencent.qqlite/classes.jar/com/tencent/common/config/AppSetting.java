package com.tencent.common.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class AppSetting
{
  private static final String A;
  private static final String B = "V3";
  private static String C;
  private static String D;
  private static final String E = "N";
  private static String F;
  public static int a = 537044116;
  public static final String a = "607";
  public static final boolean a = true;
  public static int b = 0;
  public static final String b = "130";
  public static final boolean b = false;
  public static int c = 0;
  public static final String c = "B4663756AFAD5954";
  public static final boolean c = true;
  public static int d = 0;
  public static final String d = "108074";
  public static final boolean d = false;
  public static int e = 1000;
  public static final String e = "AQQ_2013 4.6";
  public static final boolean e = true;
  public static int f = e + 1;
  public static final String f = "2013";
  public static final boolean f = false;
  public static final String g = "3.4.0";
  public static boolean g = false;
  public static final String h = "5.3.1";
  public static final boolean h = true;
  public static final String i = "QQ/4.6";
  public static final boolean i = true;
  public static final String j = "V 3.4.0.607";
  public static boolean j = false;
  public static final String k = "3.4.0.607";
  public static boolean k = false;
  public static final String l = "3.4.0.607.2015-11-16.r108074.YingYongBao";
  public static boolean l = false;
  public static final String m = "2013 3.4.0";
  public static final boolean m = true;
  public static final String n = "2013 3.4.0607";
  public static boolean n = false;
  public static String o;
  public static boolean o = false;
  public static final String p = "enable_ptt_roam";
  public static boolean p = false;
  public static final String q = "c2c_del_msg_oper_enable";
  public static final String r = "flashlogo.png";
  public static final String s = "birthdayflashlogo.png";
  public static String t = "libGIFEngine.so,armeabi,47d9b8a38f072088c0bf1fc06fa9a81079b5146d;libImgProcessScan.so,armeabi,33d4c3984ec37edfd0ae69677356dfc1c57ea5b8;libNativeRQD.so,armeabi,eb630b737dd709e42495513b36930c55a0dacfcb;libQrMod.so,armeabi,444c48021f3555ddc76fd7aa995e881cbe82bee8;libTcHevcDec.so,armeabi,12d3eb1b8521b56ad220bc739620e6ab516ff86e;libTcVp8Codec.so,armeabi,33f826c8fee7e69b9e8f88a9ce3277b81fdead3d;libTcVpxDec.so,armeabi,69d67581507af3c5adb1d05d394027709af29ca8;libTcVpxEnc.so,armeabi,185989aad1cf0ed337335c3ec5c04fb83f54557a;libagc.so,armeabi,fcca8ad2d3606a4b67190a88278e1bfa7f0e8f33;libamrnb.so,armeabi,0bc9c3a3dfead30b8625f8941331de7e2b75f9ad;libaudiohelper.so,armeabi,ec5d62a2e7d07fe53c1f342f84fceb01d9e68660;libbspatch.so,armeabi,3a1737cddbd391f80dd38c6abf3a64224894b836;libmagicfaceDec.so,armeabi,011f2aa3075c2fc81f3965f81b8fd28ebb5396cc;libmqq.so,armeabi,e241bcbdba6311e53d8469b0ff7ee0827a46f7f9;libnetworkbase.so,armeabi,d66301ccceb1618650bf0bb2ba7e3d4fbbdaa5b0;libns.so,armeabi,7953912e3640f19d56f375610e0f58dd439c512b;libpixelutils.so,armeabi,52137b8dbe32461b0f6ed3baa44c1cdb1a035a99;libsm_mq.so,armeabi,b6547484fb54295778846229da27f984257a62b1;libuploadnetwork.so,armeabi,8028d435e2d284e581351a77bb47092df84cd6e2;libvipfont.so,armeabi,2ef572ced94ff478ba00ec3349e0ca1721c99a9d;libwebviewext.so,armeabi,336fedac85e4b7e6f7aacb8fdc30bd7f89c184c7;libVideoCtrl.so,armeabi,2d06391d93e052a78a85b596ee3077e826f9f477;libcodecwrapperV2.so,armeabi,01bf9a56adfa644b561d2f5482600ef1159326e2;liblitetransfer.so,armeabi,198f7e51d8a4f91291a7db67406bd83a56dadbab;libmqpintchk.so,armeabi,2ffd2bb77ed7b2d692e6885af80b3c919bd0cdbf;libmsfbootV2.so,armeabi,53d22810992acc7c9302abc3d83289526b02434a;libqav_gaudio_engine.so,armeabi,a4dfb0949b6e7f8ee196eead7fe30f145e27356b;libqav_graphics.so,armeabi,b72247e9d5b94966b8755b99031d21ca5161e24e;libqq_la.so,armeabi,90ddc5ac6c984235554e78199ed727d311ef1574;libqq_sharp.so,armeabi,a52566e2fbd32bf3fd7f19ddf382aaa11afcf40c;libstlport_shared.so,armeabi,acf769a3d84bf71b50a9c4ab481acebecddc6ebd;libtraeimp-armeabi-v7a.so,armeabi,62b982297c43c901a05cb3ee48136e43f81b1018;libwtecdh.so,armeabi,d8f225e91f88951c5457b897192fe5d3408dd05e;libxplatform.so,armeabi,b66d3ee930d3d8a09bf3588dea4af4767fc49024;libtenpay_utils.so,armeabi,9bc0554375c6608630675891bef86597cb018ed5;";
  public static String u = "libNativeRQD.so,x86,cd1f59ec48000fd83a9f35a5188cab7b8d9a987f;libcodecwrapperV2.so,x86,c0d41407c25a565d93c3cbc3f327427e72b00e7a;libmqpintchk.so,x86,8f3dd3d3cd57d7758f652ee2eb5876fe03a03e29;libmsfbootV2.so,x86,738151f13df2bb46acdf5782ff3ba7a6fecdd6c4;libwtecdh.so,x86,7d4592eadba1283f086d4d09b272893b5f41dc86;";
  public static String v = "";
  private static final String w = "NA_0";
  private static final String x = "000000";
  private static final String y = "ADR";
  private static final String z = "18";
  
  static
  {
    A = Build.VERSION.RELEASE;
    C = null;
    g = false;
    j = false;
    k = false;
    d = 1048576;
    l = true;
    jdField_o_of_type_JavaLangString = "use_msg_reflesh_delay";
    n = true;
    jdField_o_of_type_Boolean = true;
    p = true;
  }
  
  @TargetApi(10)
  private static int a(Context paramContext)
  {
    if (paramContext == null) {}
    while ((Build.VERSION.SDK_INT < 10) || (NfcAdapter.getDefaultAdapter(paramContext) == null)) {
      return 0;
    }
    return 1;
  }
  
  public static final String a()
  {
    return "B4663756AFAD5954";
  }
  
  public static String a(Context paramContext)
  {
    if (C == null) {}
    try
    {
      Object localObject = paramContext.getFilesDir().getAbsolutePath();
      if (new File((String)localObject).exists())
      {
        localObject = new File((String)localObject + "/channel2.ini");
        if (((File)localObject).exists())
        {
          paramContext = new FileInputStream((File)localObject);
          localObject = a(paramContext);
          paramContext.close();
          if (localObject != null)
          {
            paramContext = ((String)localObject).trim();
            if (paramContext.length() > 8) {
              C = paramContext.substring(8);
            }
          }
          return C;
        }
        localObject = new FileOutputStream((File)localObject);
        paramContext = paramContext.getAssets().open("channel.ini");
        String str = a(paramContext);
        paramContext.close();
        if (str != null)
        {
          paramContext = str.trim();
          ((OutputStream)localObject).write(paramContext.getBytes());
          if (paramContext.length() > 8) {
            C = paramContext.substring(8);
          }
        }
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        return C;
      }
      paramContext = paramContext.getAssets().open("channel.ini");
      localObject = a(paramContext);
      paramContext.close();
      if (localObject != null)
      {
        paramContext = ((String)localObject).trim();
        if (paramContext.length() > 8) {
          C = paramContext.substring(8);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppSetting", 2, "read channel failed: " + paramContext.toString());
        }
        C = "0";
      }
    }
    return C;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    String str = "";
    long l1 = DeviceInfoUtil.c() / 1048576L;
    int i1 = a(paramContext);
    localObject1 = str;
    try
    {
      Object localObject3 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = str;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = str;
      str = localTelephonyManager.getDeviceId();
      localObject1 = str;
      localObject3 = a(localTelephonyManager, (ConnectivityManager)localObject3);
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = localObject1;
        localObject1 = "//";
      }
    }
    localStringBuffer.append(str + "/");
    localStringBuffer.append(a(paramContext) + "/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(a + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(a(Build.MODEL) + "/");
    localStringBuffer.append(a(Build.BRAND) + "/");
    localStringBuffer.append(l1 + "/");
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(i1 + "/");
    return localStringBuffer.toString();
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      return "//";
    }
    String str3 = "";
    String str5 = "";
    String str4 = "";
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    String str1 = str4;
    paramConnectivityManager = str5;
    String str2 = str3;
    if (localNetworkInfo != null)
    {
      str1 = str4;
      paramConnectivityManager = str5;
      str2 = str3;
      if (localNetworkInfo.isAvailable()) {
        switch (localNetworkInfo.getType())
        {
        case 7: 
        case 8: 
        default: 
          paramConnectivityManager = "unknown";
          str1 = "unknown";
          str2 = str3;
        }
      }
    }
    for (;;)
    {
      return paramConnectivityManager + "/" + str2 + "/" + str1;
      paramConnectivityManager = "cable";
      str1 = str4;
      str2 = str3;
      continue;
      paramConnectivityManager = "WIFI";
      str1 = str4;
      str2 = str3;
      continue;
      str2 = a(paramTelephonyManager.getNetworkOperatorName());
      switch (paramTelephonyManager.getNetworkType())
      {
      default: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
        break;
      case 13: 
        paramConnectivityManager = "4G";
        str1 = "LTE";
        break;
      case 3: 
        paramConnectivityManager = "3G";
        str1 = "UMTS";
        break;
      case 5: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_0";
        break;
      case 6: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_A";
        break;
      case 8: 
        paramConnectivityManager = "3G";
        str1 = "SDPA";
        break;
      case 9: 
        paramConnectivityManager = "3G";
        str1 = "HSUPA";
        break;
      case 10: 
        paramConnectivityManager = "3G";
        str1 = "HSPA";
        break;
      case 12: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_B";
        break;
      case 14: 
        paramConnectivityManager = "3G";
        str1 = "EHRPD";
        break;
      case 15: 
        paramConnectivityManager = "3G";
        str1 = "HSPAP";
        break;
      case 1: 
        paramConnectivityManager = "2G";
        str1 = "GPRS";
        break;
      case 2: 
        paramConnectivityManager = "2G";
        str1 = "EDGE";
        break;
      case 4: 
        paramConnectivityManager = "2G";
        str1 = "CDMA";
        break;
      case 7: 
        paramConnectivityManager = "2G";
        str1 = "1xRTT";
        break;
      case 11: 
        paramConnectivityManager = "2G";
        str1 = "IDEN";
        break;
      case 0: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i1));
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext.getResources().getDisplayMetrics().widthPixels;
    c = paramContext.getResources().getDisplayMetrics().heightPixels;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      int i1 = b;
      b = c;
      c = i1;
    }
    F = "" + b / 16 + c / 16;
  }
  
  public static final String b()
  {
    if (D != null) {
      return D;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < localObject2.length)
      {
        if ((localObject2[i1] > ' ') && (localObject2[i1] != '/') && (localObject2[i1] != '_') && (localObject2[i1] != '&') && (localObject2[i1] != '|') && (localObject2[i1] != '-')) {
          localStringBuffer.append(localObject2[i1]);
        }
        i1 += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      D = "AQQ_2013 4.6/2013 3.4.0607&NA_0/000000&ADR&" + F + "18" + "&" + (String)localObject2 + "&" + C + "&" + "B4663756AFAD5954" + "&" + A + "&" + "V3";
      return D;
      label297:
      str2 = "ALL";
    }
  }
  
  public static String c()
  {
    return "2013 3.4.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */