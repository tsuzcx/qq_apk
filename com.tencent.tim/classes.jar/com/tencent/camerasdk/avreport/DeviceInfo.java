package com.tencent.camerasdk.avreport;

import alkz;
import alla;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo
{
  private static final String[] SU_FILES = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  private static final String TAG = "MobileBase-DeviceInfo";
  private static final String[] VM_APPS = { "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] VM_FILES = { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  private static String roDebuggable = null;
  private static String roSecure;
  private static Map<String, String> systemProperties = null;
  
  static
  {
    roSecure = null;
  }
  
  public static boolean checkIsHaveCard()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when checking external card.", localThrowable);
    }
    return false;
  }
  
  /* Error */
  public static List<String> executeCommand(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 225	com/tencent/camerasdk/avreport/AppInfo:isLowMemory	(Landroid/content/Context;)Z
    //   6: ifeq +16 -> 22
    //   9: new 227	java/util/ArrayList
    //   12: dup
    //   13: ldc 229
    //   15: invokestatic 235	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   18: invokespecial 238	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   21: areturn
    //   22: new 227	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 239	java/util/ArrayList:<init>	()V
    //   29: astore_3
    //   30: ldc 241
    //   32: astore_0
    //   33: new 243	java/io/File
    //   36: dup
    //   37: ldc 241
    //   39: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 249	java/io/File:exists	()Z
    //   45: ifeq +329 -> 374
    //   48: new 243	java/io/File
    //   51: dup
    //   52: ldc 241
    //   54: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: invokevirtual 252	java/io/File:canExecute	()Z
    //   60: ifne +6 -> 66
    //   63: goto +311 -> 374
    //   66: new 227	java/util/ArrayList
    //   69: dup
    //   70: iconst_2
    //   71: anewarray 21	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: ldc 254
    //   82: aastore
    //   83: invokestatic 260	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   86: invokespecial 238	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   89: astore_0
    //   90: aload_0
    //   91: aload_1
    //   92: invokeinterface 265 2 0
    //   97: pop
    //   98: invokestatic 271	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   101: aload_0
    //   102: iconst_3
    //   103: anewarray 21	java/lang/String
    //   106: invokeinterface 275 2 0
    //   111: checkcast 276	[Ljava/lang/String;
    //   114: invokevirtual 280	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   117: astore_0
    //   118: new 282	java/io/BufferedReader
    //   121: dup
    //   122: new 284	java/io/InputStreamReader
    //   125: dup
    //   126: aload_0
    //   127: invokevirtual 290	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   130: invokespecial 293	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   133: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore 4
    //   143: aload 4
    //   145: ifnull +43 -> 188
    //   148: aload_3
    //   149: aload 4
    //   151: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: goto -18 -> 137
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_0
    //   161: ldc 10
    //   163: ldc_w 302
    //   166: aload_2
    //   167: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 305	java/io/BufferedReader:close	()V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 305	java/io/BufferedReader:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: new 282	java/io/BufferedReader
    //   191: dup
    //   192: new 284	java/io/InputStreamReader
    //   195: dup
    //   196: aload_0
    //   197: invokevirtual 308	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   200: invokespecial 293	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   203: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   211: astore_2
    //   212: aload_2
    //   213: ifnull +16 -> 229
    //   216: aload_3
    //   217: aload_2
    //   218: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: goto -15 -> 207
    //   225: astore_2
    //   226: goto -65 -> 161
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 305	java/io/BufferedReader:close	()V
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 305	java/io/BufferedReader:close	()V
    //   245: aload_3
    //   246: areturn
    //   247: astore_1
    //   248: ldc 10
    //   250: ldc_w 310
    //   253: aload_1
    //   254: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -20 -> 237
    //   260: astore_0
    //   261: ldc 10
    //   263: ldc_w 310
    //   266: aload_0
    //   267: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -25 -> 245
    //   273: astore_1
    //   274: ldc 10
    //   276: ldc_w 310
    //   279: aload_1
    //   280: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -105 -> 178
    //   286: astore_0
    //   287: ldc 10
    //   289: ldc_w 310
    //   292: aload_0
    //   293: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: goto -110 -> 186
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_1
    //   303: ifnull +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 305	java/io/BufferedReader:close	()V
    //   310: aload_2
    //   311: ifnull +7 -> 318
    //   314: aload_2
    //   315: invokevirtual 305	java/io/BufferedReader:close	()V
    //   318: aload_0
    //   319: athrow
    //   320: astore_1
    //   321: ldc 10
    //   323: ldc_w 310
    //   326: aload_1
    //   327: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: goto -20 -> 310
    //   333: astore_1
    //   334: ldc 10
    //   336: ldc_w 310
    //   339: aload_1
    //   340: invokestatic 313	com/tencent/camerasdk/avreport/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   343: goto -25 -> 318
    //   346: astore_0
    //   347: goto -45 -> 302
    //   350: astore_3
    //   351: aload_0
    //   352: astore_2
    //   353: aload_3
    //   354: astore_0
    //   355: goto -53 -> 302
    //   358: astore_3
    //   359: aload_0
    //   360: astore_2
    //   361: aload_3
    //   362: astore_0
    //   363: goto -61 -> 302
    //   366: astore_2
    //   367: aconst_null
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_1
    //   371: goto -210 -> 161
    //   374: ldc_w 315
    //   377: astore_0
    //   378: goto -312 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramContext	Context
    //   0	381	1	paramString	String
    //   1	1	2	localObject1	Object
    //   158	9	2	localThrowable1	Throwable
    //   211	7	2	str1	String
    //   225	90	2	localThrowable2	Throwable
    //   352	9	2	localContext	Context
    //   366	1	2	localThrowable3	Throwable
    //   29	217	3	localArrayList	java.util.ArrayList
    //   350	4	3	localObject2	Object
    //   358	4	3	localObject3	Object
    //   141	9	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   137	143	158	java/lang/Throwable
    //   148	155	158	java/lang/Throwable
    //   188	207	158	java/lang/Throwable
    //   207	212	225	java/lang/Throwable
    //   216	222	225	java/lang/Throwable
    //   233	237	247	java/io/IOException
    //   241	245	260	java/io/IOException
    //   174	178	273	java/io/IOException
    //   182	186	286	java/io/IOException
    //   33	48	299	finally
    //   48	63	299	finally
    //   66	137	299	finally
    //   306	310	320	java/io/IOException
    //   314	318	333	java/io/IOException
    //   137	143	346	finally
    //   148	155	346	finally
    //   188	207	346	finally
    //   207	212	350	finally
    //   216	222	350	finally
    //   161	170	358	finally
    //   33	48	366	java/lang/Throwable
    //   48	63	366	java/lang/Throwable
    //   66	137	366	java/lang/Throwable
  }
  
  public static String formatIpAddress(int paramInt)
  {
    if (paramInt < 0) {
      return "null";
    }
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getAndroidId(Context paramContext)
  {
    String str2 = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = alla.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      String str1;
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting Android ID.", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        str1 = paramContext.toLowerCase();
        return str1;
      }
      catch (Throwable localThrowable2)
      {
        break label41;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label41:
    return paramContext;
  }
  
  public static int getApiLevelInt()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting API level.", localThrowable);
    }
    return -1;
  }
  
  public static String getBrand()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting brand.", localThrowable);
    }
    return "fail";
  }
  
  public static String getCountry()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting country name.", localThrowable);
    }
    return "fail";
  }
  
  public static String getCpuAbi(Context paramContext, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {}
    try
    {
      localObject1 = getSystemProperty(paramContext, "ro.product.cpu.abilist");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals("fail")) {}
      }
      else
      {
        localObject2 = getSystemProperty(paramContext, "ro.product.cpu.abi");
      }
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!((String)localObject2).equals("fail")) {
          break label102;
        }
      }
      for (localObject1 = localObject3;; localObject1 = localObject2.split(",")[0])
      {
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = System.getProperty("os.arch");
        }
        return "" + paramContext;
        label102:
        LogUtils.d("MobileBase-DeviceInfo", "ABI list: " + (String)localObject2);
      }
      return "fail";
    }
    catch (Throwable paramContext)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting CPU ABI.", paramContext);
    }
  }
  
  public static String getCpuName(Context paramContext)
  {
    return getSystemProperty(paramContext, "ro.board.platform");
  }
  
  /* Error */
  public static String getDebugInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 323	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: getstatic 185	com/tencent/camerasdk/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: ldc_w 438
    //   18: invokestatic 400	com/tencent/camerasdk/avreport/DeviceInfo:getSystemProperty	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic 185	com/tencent/camerasdk/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   24: getstatic 185	com/tencent/camerasdk/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   27: ifnull +35 -> 62
    //   30: aload_3
    //   31: ldc_w 438
    //   34: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w 440
    //   42: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: getstatic 185	com/tencent/camerasdk/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   50: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 442
    //   58: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 187	com/tencent/camerasdk/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   65: ifnonnull +13 -> 78
    //   68: aload_0
    //   69: ldc_w 444
    //   72: invokestatic 400	com/tencent/camerasdk/avreport/DeviceInfo:getSystemProperty	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic 187	com/tencent/camerasdk/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   78: getstatic 187	com/tencent/camerasdk/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   81: ifnull +35 -> 116
    //   84: aload_3
    //   85: ldc_w 444
    //   88: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 440
    //   96: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: getstatic 187	com/tencent/camerasdk/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   104: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc_w 442
    //   112: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 282	java/io/BufferedReader
    //   119: dup
    //   120: new 446	java/io/FileReader
    //   123: dup
    //   124: ldc_w 448
    //   127: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: ldc_w 451
    //   151: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq -20 -> 134
    //   157: aload_2
    //   158: ifnull +47 -> 205
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: ldc_w 451
    //   167: invokevirtual 458	java/lang/String:length	()I
    //   170: invokevirtual 461	java/lang/String:substring	(I)Ljava/lang/String;
    //   173: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
    //   176: astore_2
    //   177: aload_1
    //   178: astore_0
    //   179: aload_3
    //   180: ldc_w 466
    //   183: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: astore_0
    //   189: aload_3
    //   190: ldc_w 440
    //   193: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: astore_0
    //   199: aload_3
    //   200: aload_2
    //   201: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_1
    //   206: astore_0
    //   207: aload_3
    //   208: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_2
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 305	java/io/BufferedReader:close	()V
    //   220: aload_2
    //   221: areturn
    //   222: astore_0
    //   223: ldc 10
    //   225: ldc_w 468
    //   228: aload_0
    //   229: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_2
    //   233: areturn
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_1
    //   237: aload_1
    //   238: astore_0
    //   239: ldc 10
    //   241: ldc_w 470
    //   244: aload_2
    //   245: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 305	java/io/BufferedReader:close	()V
    //   256: aload_3
    //   257: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: areturn
    //   261: astore_0
    //   262: ldc 10
    //   264: ldc_w 468
    //   267: aload_0
    //   268: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -15 -> 256
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_0
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 305	java/io/BufferedReader:close	()V
    //   285: aload_1
    //   286: athrow
    //   287: astore_0
    //   288: ldc 10
    //   290: ldc_w 468
    //   293: aload_0
    //   294: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: goto -12 -> 285
    //   300: astore_1
    //   301: goto -24 -> 277
    //   304: astore_2
    //   305: goto -68 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramContext	Context
    //   133	120	1	localBufferedReader	java.io.BufferedReader
    //   274	12	1	localObject1	Object
    //   300	1	1	localObject2	Object
    //   140	93	2	str	String
    //   234	11	2	localThrowable1	Throwable
    //   304	1	2	localThrowable2	Throwable
    //   7	250	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   216	220	222	java/io/IOException
    //   116	134	234	java/lang/Throwable
    //   252	256	261	java/io/IOException
    //   116	134	274	finally
    //   281	285	287	java/io/IOException
    //   136	141	300	finally
    //   147	157	300	finally
    //   163	177	300	finally
    //   179	187	300	finally
    //   189	197	300	finally
    //   199	205	300	finally
    //   207	212	300	finally
    //   239	248	300	finally
    //   136	141	304	java/lang/Throwable
    //   147	157	304	java/lang/Throwable
    //   163	177	304	java/lang/Throwable
    //   179	187	304	java/lang/Throwable
    //   189	197	304	java/lang/Throwable
    //   199	205	304	java/lang/Throwable
    //   207	212	304	java/lang/Throwable
  }
  
  /* Error */
  public static long getDeviceBootTime(Context paramContext)
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_3
    //   2: fconst_0
    //   3: fstore_1
    //   4: new 282	java/io/BufferedReader
    //   7: dup
    //   8: new 446	java/io/FileReader
    //   11: dup
    //   12: ldc_w 474
    //   15: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_0
    //   26: aload 4
    //   28: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +43 -> 78
    //   38: aload 4
    //   40: astore_0
    //   41: aload 5
    //   43: ldc_w 476
    //   46: invokevirtual 430	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_0
    //   50: aaload
    //   51: astore 5
    //   53: aload 4
    //   55: astore_0
    //   56: invokestatic 480	java/lang/System:currentTimeMillis	()J
    //   59: l2f
    //   60: ldc_w 481
    //   63: fdiv
    //   64: fstore_1
    //   65: aload 4
    //   67: astore_0
    //   68: aload 5
    //   70: invokestatic 487	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   73: fstore_2
    //   74: fload_1
    //   75: fload_2
    //   76: fsub
    //   77: fstore_1
    //   78: fload_1
    //   79: fstore_2
    //   80: aload 4
    //   82: ifnull +10 -> 92
    //   85: aload 4
    //   87: invokevirtual 305	java/io/BufferedReader:close	()V
    //   90: fload_1
    //   91: fstore_2
    //   92: fload_2
    //   93: f2l
    //   94: lreturn
    //   95: astore_0
    //   96: ldc 10
    //   98: ldc_w 468
    //   101: aload_0
    //   102: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: fload_1
    //   106: fstore_2
    //   107: goto -15 -> 92
    //   110: astore 5
    //   112: aconst_null
    //   113: astore 4
    //   115: aload 4
    //   117: astore_0
    //   118: ldc 10
    //   120: ldc_w 489
    //   123: aload 5
    //   125: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: fload_3
    //   129: fstore_2
    //   130: aload 4
    //   132: ifnull -40 -> 92
    //   135: aload 4
    //   137: invokevirtual 305	java/io/BufferedReader:close	()V
    //   140: fload_3
    //   141: fstore_2
    //   142: goto -50 -> 92
    //   145: astore_0
    //   146: ldc 10
    //   148: ldc_w 468
    //   151: aload_0
    //   152: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: fload_3
    //   156: fstore_2
    //   157: goto -65 -> 92
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 305	java/io/BufferedReader:close	()V
    //   172: aload 4
    //   174: athrow
    //   175: astore_0
    //   176: ldc 10
    //   178: ldc_w 468
    //   181: aload_0
    //   182: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: goto -13 -> 172
    //   188: astore 4
    //   190: goto -26 -> 164
    //   193: astore 5
    //   195: goto -80 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramContext	Context
    //   3	103	1	f1	float
    //   73	84	2	f2	float
    //   1	155	3	f3	float
    //   21	115	4	localBufferedReader	java.io.BufferedReader
    //   160	13	4	localObject1	Object
    //   188	1	4	localObject2	Object
    //   31	38	5	str	String
    //   110	14	5	localThrowable1	Throwable
    //   193	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   85	90	95	java/io/IOException
    //   4	23	110	java/lang/Throwable
    //   135	140	145	java/io/IOException
    //   4	23	160	finally
    //   168	172	175	java/io/IOException
    //   26	33	188	finally
    //   41	53	188	finally
    //   56	65	188	finally
    //   68	74	188	finally
    //   118	128	188	finally
    //   26	33	193	java/lang/Throwable
    //   41	53	193	java/lang/Throwable
    //   56	65	193	java/lang/Throwable
    //   68	74	193	java/lang/Throwable
  }
  
  public static String getDeviceName()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting device name.", localThrowable);
    }
    return "fail";
  }
  
  /* Error */
  public static String getElectronicfo()
  {
    // Byte code:
    //   0: new 323	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_1
    //   14: astore_2
    //   15: new 243	java/io/File
    //   18: dup
    //   19: ldc_w 498
    //   22: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 249	java/io/File:exists	()Z
    //   28: ifeq +73 -> 101
    //   31: aload_1
    //   32: astore_2
    //   33: new 282	java/io/BufferedReader
    //   36: dup
    //   37: new 446	java/io/FileReader
    //   40: dup
    //   41: ldc_w 498
    //   44: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +34 -> 93
    //   62: aload_1
    //   63: astore_0
    //   64: aload 4
    //   66: ldc_w 500
    //   69: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: astore_0
    //   75: aload 4
    //   77: ldc_w 440
    //   80: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: astore_0
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 305	java/io/BufferedReader:close	()V
    //   99: aload_1
    //   100: astore_0
    //   101: aload_0
    //   102: astore_2
    //   103: aload 4
    //   105: ldc_w 442
    //   108: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: astore_1
    //   114: aload_0
    //   115: astore_2
    //   116: new 243	java/io/File
    //   119: dup
    //   120: ldc_w 502
    //   123: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 249	java/io/File:exists	()Z
    //   129: ifeq +71 -> 200
    //   132: aload_0
    //   133: astore_2
    //   134: new 282	java/io/BufferedReader
    //   137: dup
    //   138: new 446	java/io/FileReader
    //   141: dup
    //   142: ldc_w 502
    //   145: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: aload_1
    //   155: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +34 -> 194
    //   163: aload_1
    //   164: astore_0
    //   165: aload 4
    //   167: ldc_w 504
    //   170: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: astore_0
    //   176: aload 4
    //   178: ldc_w 440
    //   181: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: astore_0
    //   187: aload 4
    //   189: aload_2
    //   190: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: astore_0
    //   196: aload_1
    //   197: invokevirtual 305	java/io/BufferedReader:close	()V
    //   200: aload_1
    //   201: astore_2
    //   202: aload 4
    //   204: ldc_w 442
    //   207: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: astore_2
    //   213: new 243	java/io/File
    //   216: dup
    //   217: ldc_w 506
    //   220: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: invokevirtual 249	java/io/File:exists	()Z
    //   226: ifeq +198 -> 424
    //   229: aload_1
    //   230: astore_2
    //   231: new 282	java/io/BufferedReader
    //   234: dup
    //   235: new 446	java/io/FileReader
    //   238: dup
    //   239: ldc_w 506
    //   242: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   245: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   248: astore_3
    //   249: aload_3
    //   250: astore_0
    //   251: aload_3
    //   252: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +34 -> 291
    //   260: aload_3
    //   261: astore_0
    //   262: aload 4
    //   264: ldc_w 508
    //   267: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: astore_0
    //   273: aload 4
    //   275: ldc_w 440
    //   278: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_3
    //   283: astore_0
    //   284: aload 4
    //   286: aload_1
    //   287: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: astore_0
    //   293: aload_3
    //   294: invokevirtual 305	java/io/BufferedReader:close	()V
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 305	java/io/BufferedReader:close	()V
    //   305: aload 4
    //   307: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: areturn
    //   311: astore_0
    //   312: ldc 10
    //   314: ldc_w 468
    //   317: aload_0
    //   318: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   321: goto -16 -> 305
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_0
    //   327: ldc 10
    //   329: ldc_w 470
    //   332: aload_1
    //   333: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload_0
    //   337: ifnull -32 -> 305
    //   340: aload_0
    //   341: invokevirtual 305	java/io/BufferedReader:close	()V
    //   344: goto -39 -> 305
    //   347: astore_0
    //   348: ldc 10
    //   350: ldc_w 468
    //   353: aload_0
    //   354: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: goto -52 -> 305
    //   360: astore_0
    //   361: aload_2
    //   362: astore_1
    //   363: aload_1
    //   364: ifnull +7 -> 371
    //   367: aload_1
    //   368: invokevirtual 305	java/io/BufferedReader:close	()V
    //   371: aload_0
    //   372: athrow
    //   373: astore_1
    //   374: ldc 10
    //   376: ldc_w 468
    //   379: aload_1
    //   380: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   383: goto -12 -> 371
    //   386: astore_0
    //   387: goto -24 -> 363
    //   390: astore_0
    //   391: goto -28 -> 363
    //   394: astore_0
    //   395: aload_3
    //   396: astore_1
    //   397: goto -34 -> 363
    //   400: astore_2
    //   401: aload_0
    //   402: astore_1
    //   403: aload_2
    //   404: astore_0
    //   405: goto -42 -> 363
    //   408: astore_1
    //   409: goto -82 -> 327
    //   412: astore_1
    //   413: goto -86 -> 327
    //   416: astore_2
    //   417: aload_1
    //   418: astore_0
    //   419: aload_2
    //   420: astore_1
    //   421: goto -94 -> 327
    //   424: aload_1
    //   425: astore_3
    //   426: goto -129 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	281	0	localObject1	Object
    //   311	7	0	localIOException1	java.io.IOException
    //   326	15	0	localObject2	Object
    //   347	7	0	localIOException2	java.io.IOException
    //   360	12	0	localObject3	Object
    //   386	1	0	localObject4	Object
    //   390	1	0	localObject5	Object
    //   394	8	0	localObject6	Object
    //   404	15	0	localObject7	Object
    //   10	277	1	localObject8	Object
    //   324	9	1	localThrowable1	Throwable
    //   362	6	1	localObject9	Object
    //   373	7	1	localIOException3	java.io.IOException
    //   396	7	1	localObject10	Object
    //   408	1	1	localThrowable2	Throwable
    //   412	6	1	localThrowable3	Throwable
    //   420	5	1	localObject11	Object
    //   14	348	2	localObject12	Object
    //   400	4	2	localObject13	Object
    //   416	4	2	localThrowable4	Throwable
    //   248	178	3	localObject14	Object
    //   7	299	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   301	305	311	java/io/IOException
    //   15	31	324	java/lang/Throwable
    //   33	51	324	java/lang/Throwable
    //   340	344	347	java/io/IOException
    //   15	31	360	finally
    //   33	51	360	finally
    //   103	112	360	finally
    //   116	132	360	finally
    //   134	152	360	finally
    //   202	211	360	finally
    //   213	229	360	finally
    //   231	249	360	finally
    //   367	371	373	java/io/IOException
    //   53	58	386	finally
    //   64	73	386	finally
    //   75	84	386	finally
    //   86	93	386	finally
    //   95	99	386	finally
    //   154	159	390	finally
    //   165	174	390	finally
    //   176	185	390	finally
    //   187	194	390	finally
    //   196	200	390	finally
    //   251	256	394	finally
    //   262	271	394	finally
    //   273	282	394	finally
    //   284	291	394	finally
    //   293	297	394	finally
    //   327	336	400	finally
    //   53	58	408	java/lang/Throwable
    //   64	73	408	java/lang/Throwable
    //   75	84	408	java/lang/Throwable
    //   86	93	408	java/lang/Throwable
    //   95	99	408	java/lang/Throwable
    //   154	159	408	java/lang/Throwable
    //   165	174	408	java/lang/Throwable
    //   176	185	408	java/lang/Throwable
    //   187	194	408	java/lang/Throwable
    //   196	200	408	java/lang/Throwable
    //   251	256	408	java/lang/Throwable
    //   262	271	408	java/lang/Throwable
    //   273	282	408	java/lang/Throwable
    //   284	291	408	java/lang/Throwable
    //   293	297	408	java/lang/Throwable
    //   103	112	412	java/lang/Throwable
    //   116	132	412	java/lang/Throwable
    //   134	152	412	java/lang/Throwable
    //   202	211	416	java/lang/Throwable
    //   213	229	416	java/lang/Throwable
    //   231	249	416	java/lang/Throwable
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getHardwareSerialNumber()
  {
    try
    {
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting hardware serial number.", localThrowable);
    }
    return "fail";
  }
  
  public static String getIpAddress(Context paramContext)
  {
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {
        break label107;
      }
      paramContext = alkz.a(paramContext);
      if (paramContext == null) {
        break label107;
      }
      int i = paramContext.getIpAddress();
      LogUtils.d("MobileBase-DeviceInfo", "IP integer address: " + i);
      paramContext = formatIpAddress(i);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting IP address.", paramContext);
        paramContext = "fail";
      }
    }
    LogUtils.d("MobileBase-DeviceInfo", "IP address: " + paramContext);
    return paramContext;
  }
  
  /* Error */
  public static String getMmccid()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 323	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: new 243	java/io/File
    //   15: dup
    //   16: ldc_w 548
    //   19: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 249	java/io/File:exists	()Z
    //   25: ifeq +347 -> 372
    //   28: new 282	java/io/BufferedReader
    //   31: dup
    //   32: new 446	java/io/FileReader
    //   35: dup
    //   36: ldc_w 548
    //   39: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: astore_0
    //   59: aload 5
    //   61: aload_2
    //   62: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 305	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: astore_0
    //   74: aload_0
    //   75: astore_3
    //   76: aload 5
    //   78: ldc_w 426
    //   81: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: new 243	java/io/File
    //   92: dup
    //   93: ldc_w 550
    //   96: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 249	java/io/File:exists	()Z
    //   102: ifeq +49 -> 151
    //   105: aload_0
    //   106: astore_3
    //   107: new 282	java/io/BufferedReader
    //   110: dup
    //   111: new 446	java/io/FileReader
    //   114: dup
    //   115: ldc_w 550
    //   118: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore_1
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +12 -> 145
    //   136: aload_1
    //   137: astore_0
    //   138: aload 5
    //   140: aload_2
    //   141: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: astore_0
    //   147: aload_1
    //   148: invokevirtual 305	java/io/BufferedReader:close	()V
    //   151: aload_1
    //   152: astore_3
    //   153: aload 5
    //   155: ldc_w 426
    //   158: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: astore_3
    //   164: new 243	java/io/File
    //   167: dup
    //   168: ldc_w 552
    //   171: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 249	java/io/File:exists	()Z
    //   177: ifeq +192 -> 369
    //   180: aload_1
    //   181: astore_3
    //   182: new 282	java/io/BufferedReader
    //   185: dup
    //   186: new 446	java/io/FileReader
    //   189: dup
    //   190: ldc_w 552
    //   193: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   196: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   199: astore_2
    //   200: aload_2
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   206: astore_3
    //   207: aload_2
    //   208: astore_1
    //   209: aload_3
    //   210: ifnull +14 -> 224
    //   213: aload_2
    //   214: astore_0
    //   215: aload 5
    //   217: aload_3
    //   218: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: astore_1
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: astore_0
    //   228: aload 5
    //   230: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_3
    //   234: aload_3
    //   235: astore_0
    //   236: aload_0
    //   237: astore_2
    //   238: aload_1
    //   239: ifnull +9 -> 248
    //   242: aload_1
    //   243: invokevirtual 305	java/io/BufferedReader:close	()V
    //   246: aload_0
    //   247: astore_2
    //   248: aload_2
    //   249: areturn
    //   250: astore_1
    //   251: ldc 10
    //   253: ldc_w 468
    //   256: aload_1
    //   257: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_0
    //   261: areturn
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_0
    //   265: aload_0
    //   266: astore_2
    //   267: ldc 10
    //   269: ldc_w 554
    //   272: aload_1
    //   273: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: aload 4
    //   278: astore_2
    //   279: aload_0
    //   280: ifnull -32 -> 248
    //   283: aload_0
    //   284: invokevirtual 305	java/io/BufferedReader:close	()V
    //   287: aconst_null
    //   288: areturn
    //   289: astore_0
    //   290: ldc 10
    //   292: ldc_w 468
    //   295: aload_0
    //   296: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: aconst_null
    //   300: areturn
    //   301: astore_0
    //   302: aconst_null
    //   303: astore_1
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 305	java/io/BufferedReader:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: astore_1
    //   315: ldc 10
    //   317: ldc_w 468
    //   320: aload_1
    //   321: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: goto -12 -> 312
    //   327: astore_0
    //   328: goto -24 -> 304
    //   331: astore_0
    //   332: aload_3
    //   333: astore_1
    //   334: goto -30 -> 304
    //   337: astore_0
    //   338: goto -34 -> 304
    //   341: astore_0
    //   342: aload_2
    //   343: astore_1
    //   344: goto -40 -> 304
    //   347: astore_0
    //   348: aload_2
    //   349: astore_1
    //   350: goto -46 -> 304
    //   353: astore_1
    //   354: goto -89 -> 265
    //   357: astore_1
    //   358: goto -93 -> 265
    //   361: astore_2
    //   362: aload_1
    //   363: astore_0
    //   364: aload_2
    //   365: astore_1
    //   366: goto -101 -> 265
    //   369: goto -145 -> 224
    //   372: aconst_null
    //   373: astore_0
    //   374: goto -300 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	237	0	localObject1	Object
    //   289	7	0	localIOException1	java.io.IOException
    //   301	12	0	localObject2	Object
    //   327	1	0	localObject3	Object
    //   331	1	0	localObject4	Object
    //   337	1	0	localObject5	Object
    //   341	1	0	localObject6	Object
    //   347	1	0	localObject7	Object
    //   363	11	0	localThrowable1	Throwable
    //   45	198	1	localObject8	Object
    //   250	7	1	localIOException2	java.io.IOException
    //   262	11	1	localThrowable2	Throwable
    //   303	6	1	localObject9	Object
    //   314	7	1	localIOException3	java.io.IOException
    //   333	17	1	localObject10	Object
    //   353	1	1	localThrowable3	Throwable
    //   357	6	1	localThrowable4	Throwable
    //   365	1	1	localObject11	Object
    //   52	297	2	localObject12	Object
    //   361	4	2	localThrowable5	Throwable
    //   75	258	3	localObject13	Object
    //   1	276	4	localObject14	Object
    //   10	219	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   242	246	250	java/io/IOException
    //   3	46	262	java/lang/Throwable
    //   283	287	289	java/io/IOException
    //   3	46	301	finally
    //   308	312	314	java/io/IOException
    //   48	53	327	finally
    //   59	66	327	finally
    //   68	72	327	finally
    //   76	85	331	finally
    //   89	105	331	finally
    //   107	125	331	finally
    //   153	162	331	finally
    //   164	180	331	finally
    //   182	200	331	finally
    //   127	132	337	finally
    //   138	145	337	finally
    //   147	151	337	finally
    //   202	207	341	finally
    //   215	222	341	finally
    //   228	234	347	finally
    //   267	276	347	finally
    //   48	53	353	java/lang/Throwable
    //   59	66	353	java/lang/Throwable
    //   68	72	353	java/lang/Throwable
    //   127	132	353	java/lang/Throwable
    //   138	145	353	java/lang/Throwable
    //   147	151	353	java/lang/Throwable
    //   202	207	353	java/lang/Throwable
    //   215	222	353	java/lang/Throwable
    //   228	234	353	java/lang/Throwable
    //   76	85	357	java/lang/Throwable
    //   89	105	357	java/lang/Throwable
    //   107	125	357	java/lang/Throwable
    //   153	162	361	java/lang/Throwable
    //   164	180	361	java/lang/Throwable
    //   182	200	361	java/lang/Throwable
  }
  
  public static String getNetWorkType(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localObject == null) {
          return null;
        }
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject == null) {
          return null;
        }
        if (((NetworkInfo)localObject).getType() == 1) {
          return "WIFI";
        }
        if (((NetworkInfo)localObject).getType() != 0) {
          break label185;
        }
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          break label185;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        case 15: 
          return "MOBILE(" + i + ")";
        }
      }
      catch (Throwable paramContext)
      {
        LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting type of network.", paramContext);
      }
      return "HSPA+";
      label185:
      return "unknown";
    }
    return "GPRS";
    return "EDGE";
    return "UMTS";
    return "HSDPA";
    return "HSUPA";
    return "HSPA";
    return "CDMA";
    return "EVDO_0";
    return "EVDO_A";
    return "1xRTT";
    return "iDen";
    return "EVDO_B";
    return "LTE";
    return "eHRPD";
  }
  
  public static byte getNetworkClass(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return -1;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return -1;
      }
      if (((NetworkInfo)localObject).getType() == 1) {
        return 1;
      }
      if (((NetworkInfo)localObject).getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          return -1;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting class of network.", paramContext);
      }
    }
    return -1;
    return 2;
    return 3;
    return 4;
  }
  
  /* Error */
  public static long getRamAvailSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc2_w 621
    //   6: lstore_2
    //   7: new 446	java/io/FileReader
    //   10: dup
    //   11: ldc_w 624
    //   14: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: new 282	java/io/BufferedReader
    //   22: dup
    //   23: aload 8
    //   25: sipush 2048
    //   28: invokespecial 627	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 7
    //   33: aload 7
    //   35: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: pop
    //   39: aload 7
    //   41: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +60 -> 108
    //   51: aload 7
    //   53: ifnull +8 -> 61
    //   56: aload 7
    //   58: invokevirtual 305	java/io/BufferedReader:close	()V
    //   61: lload_2
    //   62: lstore_0
    //   63: aload 8
    //   65: ifnull +10 -> 75
    //   68: aload 8
    //   70: invokevirtual 628	java/io/FileReader:close	()V
    //   73: lload_2
    //   74: lstore_0
    //   75: lload_0
    //   76: lreturn
    //   77: astore 6
    //   79: ldc 10
    //   81: ldc_w 630
    //   84: aload 6
    //   86: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: goto -28 -> 61
    //   92: astore 6
    //   94: ldc 10
    //   96: ldc_w 468
    //   99: aload 6
    //   101: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: ldc2_w 621
    //   107: lreturn
    //   108: aload 6
    //   110: ldc_w 632
    //   113: iconst_2
    //   114: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   117: iconst_1
    //   118: aaload
    //   119: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   122: ldc_w 637
    //   125: ldc_w 418
    //   128: invokevirtual 641	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   131: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
    //   134: invokestatic 647	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore_0
    //   138: aload 7
    //   140: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   143: astore 6
    //   145: aload 6
    //   147: ifnonnull +60 -> 207
    //   150: aload 7
    //   152: ifnull +8 -> 160
    //   155: aload 7
    //   157: invokevirtual 305	java/io/BufferedReader:close	()V
    //   160: lload_2
    //   161: lstore_0
    //   162: aload 8
    //   164: ifnull -89 -> 75
    //   167: aload 8
    //   169: invokevirtual 628	java/io/FileReader:close	()V
    //   172: ldc2_w 621
    //   175: lreturn
    //   176: astore 6
    //   178: ldc 10
    //   180: ldc_w 468
    //   183: aload 6
    //   185: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: ldc2_w 621
    //   191: lreturn
    //   192: astore 6
    //   194: ldc 10
    //   196: ldc_w 630
    //   199: aload 6
    //   201: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: goto -44 -> 160
    //   207: aload 6
    //   209: ldc_w 632
    //   212: iconst_2
    //   213: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   216: iconst_1
    //   217: aaload
    //   218: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   221: ldc_w 637
    //   224: ldc_w 418
    //   227: invokevirtual 641	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   230: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
    //   233: invokestatic 647	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   236: lstore 4
    //   238: aload 7
    //   240: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   243: astore 6
    //   245: aload 6
    //   247: ifnonnull +60 -> 307
    //   250: aload 7
    //   252: ifnull +8 -> 260
    //   255: aload 7
    //   257: invokevirtual 305	java/io/BufferedReader:close	()V
    //   260: lload_2
    //   261: lstore_0
    //   262: aload 8
    //   264: ifnull -189 -> 75
    //   267: aload 8
    //   269: invokevirtual 628	java/io/FileReader:close	()V
    //   272: ldc2_w 621
    //   275: lreturn
    //   276: astore 6
    //   278: ldc 10
    //   280: ldc_w 468
    //   283: aload 6
    //   285: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: ldc2_w 621
    //   291: lreturn
    //   292: astore 6
    //   294: ldc 10
    //   296: ldc_w 630
    //   299: aload 6
    //   301: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   304: goto -44 -> 260
    //   307: aload 6
    //   309: ldc_w 632
    //   312: iconst_2
    //   313: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   316: iconst_1
    //   317: aaload
    //   318: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   321: ldc_w 637
    //   324: ldc_w 418
    //   327: invokevirtual 641	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   330: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
    //   333: invokestatic 647	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   336: lstore_2
    //   337: lload_2
    //   338: ldc2_w 648
    //   341: lmul
    //   342: lconst_0
    //   343: lload_0
    //   344: ldc2_w 648
    //   347: lmul
    //   348: ladd
    //   349: lload 4
    //   351: ldc2_w 648
    //   354: lmul
    //   355: ladd
    //   356: ladd
    //   357: lstore_2
    //   358: aload 7
    //   360: ifnull +8 -> 368
    //   363: aload 7
    //   365: invokevirtual 305	java/io/BufferedReader:close	()V
    //   368: lload_2
    //   369: lstore_0
    //   370: aload 8
    //   372: ifnull -297 -> 75
    //   375: aload 8
    //   377: invokevirtual 628	java/io/FileReader:close	()V
    //   380: lload_2
    //   381: lreturn
    //   382: astore 6
    //   384: ldc 10
    //   386: ldc_w 468
    //   389: aload 6
    //   391: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   394: lload_2
    //   395: lreturn
    //   396: astore 6
    //   398: ldc 10
    //   400: ldc_w 630
    //   403: aload 6
    //   405: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: goto -40 -> 368
    //   411: astore 8
    //   413: aconst_null
    //   414: astore 7
    //   416: ldc 10
    //   418: ldc_w 651
    //   421: aload 8
    //   423: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload 7
    //   428: ifnull +8 -> 436
    //   431: aload 7
    //   433: invokevirtual 305	java/io/BufferedReader:close	()V
    //   436: aload 6
    //   438: ifnull +8 -> 446
    //   441: aload 6
    //   443: invokevirtual 628	java/io/FileReader:close	()V
    //   446: ldc2_w 652
    //   449: lreturn
    //   450: astore 7
    //   452: ldc 10
    //   454: ldc_w 630
    //   457: aload 7
    //   459: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   462: goto -26 -> 436
    //   465: astore 6
    //   467: ldc 10
    //   469: ldc_w 468
    //   472: aload 6
    //   474: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto -31 -> 446
    //   480: astore 6
    //   482: aconst_null
    //   483: astore 7
    //   485: aconst_null
    //   486: astore 8
    //   488: aload 7
    //   490: ifnull +8 -> 498
    //   493: aload 7
    //   495: invokevirtual 305	java/io/BufferedReader:close	()V
    //   498: aload 8
    //   500: ifnull +8 -> 508
    //   503: aload 8
    //   505: invokevirtual 628	java/io/FileReader:close	()V
    //   508: aload 6
    //   510: athrow
    //   511: astore 7
    //   513: ldc 10
    //   515: ldc_w 630
    //   518: aload 7
    //   520: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   523: goto -25 -> 498
    //   526: astore 7
    //   528: ldc 10
    //   530: ldc_w 468
    //   533: aload 7
    //   535: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   538: goto -30 -> 508
    //   541: astore 6
    //   543: aconst_null
    //   544: astore 7
    //   546: goto -58 -> 488
    //   549: astore 6
    //   551: goto -63 -> 488
    //   554: astore 9
    //   556: aload 6
    //   558: astore 8
    //   560: aload 9
    //   562: astore 6
    //   564: goto -76 -> 488
    //   567: astore 9
    //   569: aconst_null
    //   570: astore 7
    //   572: aload 8
    //   574: astore 6
    //   576: aload 9
    //   578: astore 8
    //   580: goto -164 -> 416
    //   583: astore 9
    //   585: aload 8
    //   587: astore 6
    //   589: aload 9
    //   591: astore 8
    //   593: goto -177 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	308	0	l1	long
    //   6	389	2	l2	long
    //   236	114	4	l3	long
    //   1	46	6	str1	String
    //   77	8	6	localIOException1	java.io.IOException
    //   92	17	6	localIOException2	java.io.IOException
    //   143	3	6	str2	String
    //   176	8	6	localIOException3	java.io.IOException
    //   192	16	6	localIOException4	java.io.IOException
    //   243	3	6	str3	String
    //   276	8	6	localIOException5	java.io.IOException
    //   292	16	6	localIOException6	java.io.IOException
    //   382	8	6	localIOException7	java.io.IOException
    //   396	46	6	localIOException8	java.io.IOException
    //   465	8	6	localIOException9	java.io.IOException
    //   480	29	6	localObject1	Object
    //   541	1	6	localObject2	Object
    //   549	8	6	localObject3	Object
    //   562	26	6	localObject4	Object
    //   31	401	7	localBufferedReader	java.io.BufferedReader
    //   450	8	7	localIOException10	java.io.IOException
    //   483	11	7	localObject5	Object
    //   511	8	7	localIOException11	java.io.IOException
    //   526	8	7	localIOException12	java.io.IOException
    //   544	27	7	localObject6	Object
    //   17	359	8	localFileReader	java.io.FileReader
    //   411	11	8	localThrowable1	Throwable
    //   486	106	8	localObject7	Object
    //   554	7	9	localObject8	Object
    //   567	10	9	localThrowable2	Throwable
    //   583	7	9	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   56	61	77	java/io/IOException
    //   68	73	92	java/io/IOException
    //   167	172	176	java/io/IOException
    //   155	160	192	java/io/IOException
    //   267	272	276	java/io/IOException
    //   255	260	292	java/io/IOException
    //   375	380	382	java/io/IOException
    //   363	368	396	java/io/IOException
    //   7	19	411	java/lang/Throwable
    //   431	436	450	java/io/IOException
    //   441	446	465	java/io/IOException
    //   7	19	480	finally
    //   493	498	511	java/io/IOException
    //   503	508	526	java/io/IOException
    //   19	33	541	finally
    //   33	46	549	finally
    //   108	145	549	finally
    //   207	245	549	finally
    //   307	337	549	finally
    //   416	426	554	finally
    //   19	33	567	java/lang/Throwable
    //   33	46	583	java/lang/Throwable
    //   108	145	583	java/lang/Throwable
    //   207	245	583	java/lang/Throwable
    //   307	337	583	java/lang/Throwable
  }
  
  /* Error */
  public static long getRamTotalSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 446	java/io/FileReader
    //   6: dup
    //   7: ldc_w 624
    //   10: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: new 282	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 2048
    //   24: invokespecial 627	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +64 -> 102
    //   41: ldc2_w 621
    //   44: lstore_2
    //   45: aload 5
    //   47: ifnull +8 -> 55
    //   50: aload 5
    //   52: invokevirtual 305	java/io/BufferedReader:close	()V
    //   55: lload_2
    //   56: lstore_0
    //   57: aload 6
    //   59: ifnull +10 -> 69
    //   62: aload 6
    //   64: invokevirtual 628	java/io/FileReader:close	()V
    //   67: lload_2
    //   68: lstore_0
    //   69: lload_0
    //   70: lreturn
    //   71: astore 4
    //   73: ldc 10
    //   75: ldc_w 630
    //   78: aload 4
    //   80: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: goto -28 -> 55
    //   86: astore 4
    //   88: ldc 10
    //   90: ldc_w 468
    //   93: aload 4
    //   95: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: ldc2_w 621
    //   101: lreturn
    //   102: aload 4
    //   104: ldc_w 632
    //   107: iconst_2
    //   108: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   111: iconst_1
    //   112: aaload
    //   113: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   116: ldc_w 637
    //   119: ldc_w 418
    //   122: invokevirtual 641	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
    //   128: invokestatic 647	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   131: lstore_0
    //   132: lload_0
    //   133: ldc2_w 648
    //   136: lmul
    //   137: lstore_2
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 305	java/io/BufferedReader:close	()V
    //   148: lload_2
    //   149: lstore_0
    //   150: aload 6
    //   152: ifnull -83 -> 69
    //   155: aload 6
    //   157: invokevirtual 628	java/io/FileReader:close	()V
    //   160: lload_2
    //   161: lreturn
    //   162: astore 4
    //   164: ldc 10
    //   166: ldc_w 468
    //   169: aload 4
    //   171: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: lload_2
    //   175: lreturn
    //   176: astore 4
    //   178: ldc 10
    //   180: ldc_w 630
    //   183: aload 4
    //   185: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -40 -> 148
    //   191: astore 6
    //   193: aconst_null
    //   194: astore 4
    //   196: aload 7
    //   198: astore 5
    //   200: ldc 10
    //   202: ldc_w 656
    //   205: aload 6
    //   207: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload 5
    //   212: ifnull +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 305	java/io/BufferedReader:close	()V
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 628	java/io/FileReader:close	()V
    //   230: ldc2_w 652
    //   233: lreturn
    //   234: astore 5
    //   236: ldc 10
    //   238: ldc_w 630
    //   241: aload 5
    //   243: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -26 -> 220
    //   249: astore 4
    //   251: ldc 10
    //   253: ldc_w 468
    //   256: aload 4
    //   258: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: goto -31 -> 230
    //   264: astore 4
    //   266: aconst_null
    //   267: astore 5
    //   269: aconst_null
    //   270: astore 6
    //   272: aload 5
    //   274: ifnull +8 -> 282
    //   277: aload 5
    //   279: invokevirtual 305	java/io/BufferedReader:close	()V
    //   282: aload 6
    //   284: ifnull +8 -> 292
    //   287: aload 6
    //   289: invokevirtual 628	java/io/FileReader:close	()V
    //   292: aload 4
    //   294: athrow
    //   295: astore 5
    //   297: ldc 10
    //   299: ldc_w 630
    //   302: aload 5
    //   304: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -25 -> 282
    //   310: astore 5
    //   312: ldc 10
    //   314: ldc_w 468
    //   317: aload 5
    //   319: invokestatic 215	com/tencent/camerasdk/avreport/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: goto -30 -> 292
    //   325: astore 4
    //   327: aconst_null
    //   328: astore 5
    //   330: goto -58 -> 272
    //   333: astore 4
    //   335: goto -63 -> 272
    //   338: astore 7
    //   340: aload 4
    //   342: astore 6
    //   344: aload 7
    //   346: astore 4
    //   348: goto -76 -> 272
    //   351: astore 5
    //   353: aload 6
    //   355: astore 4
    //   357: aload 5
    //   359: astore 6
    //   361: aload 7
    //   363: astore 5
    //   365: goto -165 -> 200
    //   368: astore 7
    //   370: aload 6
    //   372: astore 4
    //   374: aload 7
    //   376: astore 6
    //   378: goto -178 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	94	0	l1	long
    //   44	131	2	l2	long
    //   34	3	4	str	String
    //   71	8	4	localIOException1	java.io.IOException
    //   86	17	4	localIOException2	java.io.IOException
    //   162	8	4	localIOException3	java.io.IOException
    //   176	8	4	localIOException4	java.io.IOException
    //   194	32	4	localObject1	Object
    //   249	8	4	localIOException5	java.io.IOException
    //   264	29	4	localObject2	Object
    //   325	1	4	localObject3	Object
    //   333	8	4	localObject4	Object
    //   346	27	4	localObject5	Object
    //   27	189	5	localObject6	Object
    //   234	8	5	localIOException6	java.io.IOException
    //   267	11	5	localObject7	Object
    //   295	8	5	localIOException7	java.io.IOException
    //   310	8	5	localIOException8	java.io.IOException
    //   328	1	5	localObject8	Object
    //   351	7	5	localThrowable1	Throwable
    //   363	1	5	localObject9	Object
    //   13	143	6	localFileReader	java.io.FileReader
    //   191	15	6	localThrowable2	Throwable
    //   270	107	6	localObject10	Object
    //   1	196	7	localObject11	Object
    //   338	24	7	localObject12	Object
    //   368	7	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   50	55	71	java/io/IOException
    //   62	67	86	java/io/IOException
    //   155	160	162	java/io/IOException
    //   143	148	176	java/io/IOException
    //   3	15	191	java/lang/Throwable
    //   215	220	234	java/io/IOException
    //   225	230	249	java/io/IOException
    //   3	15	264	finally
    //   277	282	295	java/io/IOException
    //   287	292	310	java/io/IOException
    //   15	29	325	finally
    //   29	36	333	finally
    //   102	132	333	finally
    //   200	210	338	finally
    //   15	29	351	java/lang/Throwable
    //   29	36	368	java/lang/Throwable
    //   102	132	368	java/lang/Throwable
  }
  
  public static long getRomAvailSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting available size of ROM.", localThrowable);
    }
    return -1L;
  }
  
  public static String getRomFingerprint(Context paramContext)
  {
    String str = getSystemProperty(paramContext, "ro.miui.ui.version.name");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "XiaoMi/MIUI/" + str;
    }
    str = getSystemProperty(paramContext, "ro.build.version.emui");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "HuaWei/EMOTION/" + str;
    }
    str = getSystemProperty(paramContext, "ro.lenovo.series");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail")))
    {
      paramContext = getSystemProperty(paramContext, "ro.build.version.incremental");
      return "Lenovo/VIBE/" + paramContext;
    }
    str = getSystemProperty(paramContext, "ro.build.nubia.rom.name");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "Zte/NUBIA/" + str + "_" + getSystemProperty(paramContext, "ro.build.nubia.rom.code");
    }
    str = getSystemProperty(paramContext, "ro.meizu.product.model");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "Meizu/FLYME/" + getSystemProperty(paramContext, "ro.build.display.id");
    }
    str = getSystemProperty(paramContext, "ro.build.version.opporom");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "Oppo/COLOROS/" + str;
    }
    str = getSystemProperty(paramContext, "ro.vivo.os.build.display.id");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "vivo/FUNTOUCH/" + str;
    }
    str = getSystemProperty(paramContext, "ro.aa.romver");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "htc/" + str + "/" + getSystemProperty(paramContext, "ro.build.description");
    }
    str = getSystemProperty(paramContext, "ro.lewa.version");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "tcl/" + str + "/" + getSystemProperty(paramContext, "ro.build.display.id");
    }
    str = getSystemProperty(paramContext, "ro.gn.gnromvernumber");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("fail"))) {
      return "amigo/" + str + "/" + getSystemProperty(paramContext, "ro.build.display.id");
    }
    paramContext = getSystemProperty(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("fail"))) {
      return "dido/" + paramContext;
    }
    return "Android";
  }
  
  public static long getRomTotalSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting total size of ROM.", localThrowable);
    }
    return -1L;
  }
  
  public static String getSimInfo(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = getSystemProperty(paramContext, "gsm.sim.state");
    if (str != null)
    {
      localStringBuilder.append("gsm.sim.state");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("\n");
    paramContext = getSystemProperty(paramContext, "gsm.sim.state2");
    if (paramContext != null)
    {
      localStringBuilder.append("gsm.sim.state2");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"MissingPermission", "HardwareIds"})
  public static String getSimSerialNumber(Context paramContext)
  {
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (localObject == null) {
        break label74;
      }
      if (ActivityCompat.checkSelfPermission(paramContext, "android.permission.READ_PHONE_STATE") == 0) {
        break label67;
      }
      localObject = alla.d((TelephonyManager)localObject);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        paramContext = "fail";
        LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting SIM serial number.", localThrowable);
        continue;
        String str = "fail";
        continue;
        paramContext = "fail";
      }
    }
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "null";
    }
    return paramContext;
  }
  
  public static String getSystemProperty(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      return "";
    }
    if (systemProperties == null)
    {
      systemProperties = new HashMap();
      Object localObject = executeCommand(paramContext, "getprop");
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        LogUtils.d("MobileBase-DeviceInfo", "Successfully get 'getprop' list.");
        paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
          if (localMatcher.find()) {
            systemProperties.put(localMatcher.group(1), localMatcher.group(2));
          }
        }
        LogUtils.d("MobileBase-DeviceInfo", "System properties number: " + systemProperties.size());
      }
    }
    if (systemProperties.containsKey(paramString)) {
      return (String)systemProperties.get(paramString);
    }
    return "fail";
  }
  
  public static String getVersion()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting release version.", localThrowable);
    }
    return "fail";
  }
  
  public static boolean isDeviceRooted()
  {
    boolean bool = false;
    String[] arrayOfString = SU_FILES;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!new File(arrayOfString[i]).exists()) {}
    }
    for (i = 1;; i = 0)
    {
      if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {}
      for (j = 1;; j = 0)
      {
        if ((j != 0) || (i != 0)) {
          bool = true;
        }
        return bool;
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */