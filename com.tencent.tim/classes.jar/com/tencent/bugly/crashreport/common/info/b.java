package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class b
{
  private static final String[] a = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  private static final String[] b = { "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] c = { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null)) {}
    do
    {
      do
      {
        return "fail";
        paramContext = paramContext.getApplicationInfo().nativeLibraryDir;
      } while (TextUtils.isEmpty(paramContext));
      if (paramContext.endsWith("arm")) {
        return "armeabi-v7a";
      }
      if (paramContext.endsWith("arm64")) {
        return "arm64-v8a";
      }
      if (paramContext.endsWith("x86")) {
        return "x86";
      }
    } while (!paramContext.endsWith("x86_64"));
    return "x86_64";
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = System.getProperty("os.arch");
      paramContext = paramContext;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1) {
          return "WIFI";
        }
        if (localNetworkInfo.getType() != 0) {
          continue;
        }
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          continue;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        case 15: 
          paramContext = "MOBILE(" + i + ")";
        }
      }
      catch (Exception paramContext)
      {
        if (x.a(paramContext)) {
          continue;
        }
        paramContext.printStackTrace();
        return "unknown";
        paramContext = "unknown";
        break;
        return "unknown";
      }
      return "HSPA+";
    }
    return paramContext;
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
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String c(Context paramContext)
  {
    String str = z.a(paramContext, "ro.miui.ui.version.name");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "XiaoMi/MIUI/" + str;
    }
    str = z.a(paramContext, "ro.build.version.emui");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "HuaWei/EMOTION/" + str;
    }
    str = z.a(paramContext, "ro.lenovo.series");
    if ((!z.a(str)) && (!str.equals("fail")))
    {
      paramContext = z.a(paramContext, "ro.build.version.incremental");
      return "Lenovo/VIBE/" + paramContext;
    }
    str = z.a(paramContext, "ro.build.nubia.rom.name");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Zte/NUBIA/" + str + "_" + z.a(paramContext, "ro.build.nubia.rom.code");
    }
    str = z.a(paramContext, "ro.meizu.product.model");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Meizu/FLYME/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.build.version.opporom");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Oppo/COLOROS/" + str;
    }
    str = z.a(paramContext, "ro.vivo.os.build.display.id");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "vivo/FUNTOUCH/" + str;
    }
    str = z.a(paramContext, "ro.aa.romver");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "htc/" + str + "/" + z.a(paramContext, "ro.build.description");
    }
    str = z.a(paramContext, "ro.lewa.version");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "tcl/" + str + "/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.gn.gnromvernumber");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "amigo/" + str + "/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "dido/" + str;
    }
    return z.a(paramContext, "ro.build.fingerprint") + "/" + z.a(paramContext, "ro.build.rom.id");
  }
  
  public static long d()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String d(Context paramContext)
  {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static long e()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool = false;
    if (g(paramContext) == null)
    {
      paramContext = new ArrayList();
      int i = 0;
      if (i < c.length)
      {
        if (i == 0) {
          if (!new File(c[i]).exists()) {
            paramContext.add(Integer.valueOf(i));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (new File(c[i]).exists()) {
            paramContext.add(Integer.valueOf(i));
          }
        }
      }
      if (!paramContext.isEmpty()) {
        break label112;
      }
    }
    label112:
    for (paramContext = null;; paramContext = paramContext.toString())
    {
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
  }
  
  /* Error */
  public static long f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 458	java/io/FileReader
    //   6: dup
    //   7: ldc_w 460
    //   10: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: new 463	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 2048
    //   24: invokespecial 466	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +55 -> 93
    //   41: aload 5
    //   43: invokevirtual 472	java/io/BufferedReader:close	()V
    //   46: aload 6
    //   48: invokevirtual 473	java/io/FileReader:close	()V
    //   51: ldc2_w 402
    //   54: lstore_0
    //   55: lload_0
    //   56: lreturn
    //   57: astore 4
    //   59: aload 4
    //   61: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   64: ifne -18 -> 46
    //   67: aload 4
    //   69: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   72: goto -26 -> 46
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   82: ifne -31 -> 51
    //   85: aload 4
    //   87: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   90: goto -39 -> 51
    //   93: aload 4
    //   95: ldc_w 476
    //   98: iconst_2
    //   99: invokevirtual 480	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   102: iconst_1
    //   103: aaload
    //   104: invokevirtual 483	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: ldc_w 485
    //   110: ldc_w 487
    //   113: invokevirtual 491	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: invokevirtual 494	java/lang/String:trim	()Ljava/lang/String;
    //   119: invokestatic 500	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   122: lstore_0
    //   123: lload_0
    //   124: bipush 10
    //   126: lshl
    //   127: lstore_2
    //   128: aload 5
    //   130: invokevirtual 472	java/io/BufferedReader:close	()V
    //   133: aload 6
    //   135: invokevirtual 473	java/io/FileReader:close	()V
    //   138: lload_2
    //   139: lreturn
    //   140: astore 4
    //   142: lload_2
    //   143: lstore_0
    //   144: aload 4
    //   146: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   149: ifne -94 -> 55
    //   152: aload 4
    //   154: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   157: lload_2
    //   158: lreturn
    //   159: astore 4
    //   161: aload 4
    //   163: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   166: ifne -33 -> 133
    //   169: aload 4
    //   171: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   174: goto -41 -> 133
    //   177: astore 6
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 7
    //   184: astore 5
    //   186: aload 6
    //   188: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   191: ifne +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 472	java/io/BufferedReader:close	()V
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 473	java/io/FileReader:close	()V
    //   219: ldc2_w 501
    //   222: lreturn
    //   223: astore 5
    //   225: aload 5
    //   227: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   230: ifne -21 -> 209
    //   233: aload 5
    //   235: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   238: goto -29 -> 209
    //   241: astore 4
    //   243: aload 4
    //   245: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   248: ifne -29 -> 219
    //   251: aload 4
    //   253: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   256: goto -37 -> 219
    //   259: astore 4
    //   261: aconst_null
    //   262: astore 5
    //   264: aconst_null
    //   265: astore 6
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 472	java/io/BufferedReader:close	()V
    //   277: aload 6
    //   279: ifnull +8 -> 287
    //   282: aload 6
    //   284: invokevirtual 473	java/io/FileReader:close	()V
    //   287: aload 4
    //   289: athrow
    //   290: astore 5
    //   292: aload 5
    //   294: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   297: ifne -20 -> 277
    //   300: aload 5
    //   302: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   305: goto -28 -> 277
    //   308: astore 5
    //   310: aload 5
    //   312: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   315: ifne -28 -> 287
    //   318: aload 5
    //   320: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   323: goto -36 -> 287
    //   326: astore 4
    //   328: aconst_null
    //   329: astore 5
    //   331: goto -64 -> 267
    //   334: astore 4
    //   336: goto -69 -> 267
    //   339: astore 7
    //   341: aload 4
    //   343: astore 6
    //   345: aload 7
    //   347: astore 4
    //   349: goto -82 -> 267
    //   352: astore 5
    //   354: aload 6
    //   356: astore 4
    //   358: aload 5
    //   360: astore 6
    //   362: aload 7
    //   364: astore 5
    //   366: goto -180 -> 186
    //   369: astore 7
    //   371: aload 6
    //   373: astore 4
    //   375: aload 7
    //   377: astore 6
    //   379: goto -193 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   54	90	0	l1	long
    //   127	31	2	l2	long
    //   34	3	4	str	String
    //   57	11	4	localIOException1	java.io.IOException
    //   75	19	4	localIOException2	java.io.IOException
    //   140	13	4	localIOException3	java.io.IOException
    //   159	11	4	localIOException4	java.io.IOException
    //   180	35	4	localObject1	Object
    //   241	11	4	localIOException5	java.io.IOException
    //   259	29	4	localObject2	Object
    //   326	1	4	localObject3	Object
    //   334	8	4	localObject4	Object
    //   347	27	4	localObject5	Object
    //   27	178	5	localObject6	Object
    //   223	11	5	localIOException6	java.io.IOException
    //   262	11	5	localObject7	Object
    //   290	11	5	localIOException7	java.io.IOException
    //   308	11	5	localIOException8	java.io.IOException
    //   329	1	5	localObject8	Object
    //   352	7	5	localThrowable1	Throwable
    //   364	1	5	localObject9	Object
    //   13	121	6	localFileReader	java.io.FileReader
    //   177	18	6	localThrowable2	Throwable
    //   265	113	6	localObject10	Object
    //   1	182	7	localObject11	Object
    //   339	24	7	localObject12	Object
    //   369	7	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	46	57	java/io/IOException
    //   46	51	75	java/io/IOException
    //   133	138	140	java/io/IOException
    //   128	133	159	java/io/IOException
    //   3	15	177	java/lang/Throwable
    //   204	209	223	java/io/IOException
    //   214	219	241	java/io/IOException
    //   3	15	259	finally
    //   272	277	290	java/io/IOException
    //   282	287	308	java/io/IOException
    //   15	29	326	finally
    //   29	36	334	finally
    //   93	123	334	finally
    //   186	199	339	finally
    //   15	29	352	java/lang/Throwable
    //   29	36	369	java/lang/Throwable
    //   93	123	369	java/lang/Throwable
  }
  
  public static boolean f(Context paramContext)
  {
    return (h(paramContext) | p() | q() | o()) > 0;
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc2_w 402
    //   6: lstore_0
    //   7: new 458	java/io/FileReader
    //   10: dup
    //   11: ldc_w 460
    //   14: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: new 463	java/io/BufferedReader
    //   22: dup
    //   23: aload 8
    //   25: sipush 2048
    //   28: invokespecial 466	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 7
    //   33: aload 7
    //   35: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: pop
    //   39: aload 7
    //   41: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +52 -> 100
    //   51: aload 7
    //   53: invokevirtual 472	java/io/BufferedReader:close	()V
    //   56: aload 8
    //   58: invokevirtual 473	java/io/FileReader:close	()V
    //   61: lload_0
    //   62: lreturn
    //   63: astore 6
    //   65: aload 6
    //   67: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   70: ifne -14 -> 56
    //   73: aload 6
    //   75: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   78: goto -22 -> 56
    //   81: astore 6
    //   83: aload 6
    //   85: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   88: ifne -27 -> 61
    //   91: aload 6
    //   93: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   96: ldc2_w 402
    //   99: lreturn
    //   100: aload 6
    //   102: ldc_w 476
    //   105: iconst_2
    //   106: invokevirtual 480	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   109: iconst_1
    //   110: aaload
    //   111: invokevirtual 483	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   114: ldc_w 485
    //   117: ldc_w 487
    //   120: invokevirtual 491	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   123: invokevirtual 494	java/lang/String:trim	()Ljava/lang/String;
    //   126: invokestatic 500	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   129: lstore_2
    //   130: aload 7
    //   132: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnonnull +54 -> 193
    //   142: aload 7
    //   144: invokevirtual 472	java/io/BufferedReader:close	()V
    //   147: aload 8
    //   149: invokevirtual 473	java/io/FileReader:close	()V
    //   152: ldc2_w 402
    //   155: lreturn
    //   156: astore 6
    //   158: aload 6
    //   160: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   163: ifne -102 -> 61
    //   166: aload 6
    //   168: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   171: ldc2_w 402
    //   174: lreturn
    //   175: astore 6
    //   177: aload 6
    //   179: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   182: ifne -35 -> 147
    //   185: aload 6
    //   187: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   190: goto -43 -> 147
    //   193: aload 6
    //   195: ldc_w 476
    //   198: iconst_2
    //   199: invokevirtual 480	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   202: iconst_1
    //   203: aaload
    //   204: invokevirtual 483	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   207: ldc_w 485
    //   210: ldc_w 487
    //   213: invokevirtual 491	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   216: invokevirtual 494	java/lang/String:trim	()Ljava/lang/String;
    //   219: invokestatic 500	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   222: lstore 4
    //   224: aload 7
    //   226: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore 6
    //   231: aload 6
    //   233: ifnonnull +54 -> 287
    //   236: aload 7
    //   238: invokevirtual 472	java/io/BufferedReader:close	()V
    //   241: aload 8
    //   243: invokevirtual 473	java/io/FileReader:close	()V
    //   246: ldc2_w 402
    //   249: lreturn
    //   250: astore 6
    //   252: aload 6
    //   254: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   257: ifne -196 -> 61
    //   260: aload 6
    //   262: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   265: ldc2_w 402
    //   268: lreturn
    //   269: astore 6
    //   271: aload 6
    //   273: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   276: ifne -35 -> 241
    //   279: aload 6
    //   281: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   284: goto -43 -> 241
    //   287: aload 6
    //   289: ldc_w 476
    //   292: iconst_2
    //   293: invokevirtual 480	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   296: iconst_1
    //   297: aaload
    //   298: invokevirtual 483	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   301: ldc_w 485
    //   304: ldc_w 487
    //   307: invokevirtual 491	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   310: invokevirtual 494	java/lang/String:trim	()Ljava/lang/String;
    //   313: invokestatic 500	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   316: lstore_0
    //   317: lload_0
    //   318: bipush 10
    //   320: lshl
    //   321: lconst_0
    //   322: lload_2
    //   323: bipush 10
    //   325: lshl
    //   326: ladd
    //   327: lload 4
    //   329: bipush 10
    //   331: lshl
    //   332: ladd
    //   333: ladd
    //   334: lstore_2
    //   335: aload 7
    //   337: invokevirtual 472	java/io/BufferedReader:close	()V
    //   340: aload 8
    //   342: invokevirtual 473	java/io/FileReader:close	()V
    //   345: lload_2
    //   346: lreturn
    //   347: astore 6
    //   349: lload_2
    //   350: lstore_0
    //   351: aload 6
    //   353: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   356: ifne -295 -> 61
    //   359: aload 6
    //   361: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   364: lload_2
    //   365: lreturn
    //   366: astore 6
    //   368: aload 6
    //   370: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   373: ifne -33 -> 340
    //   376: aload 6
    //   378: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   381: goto -41 -> 340
    //   384: astore 8
    //   386: aconst_null
    //   387: astore 7
    //   389: aload 8
    //   391: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   394: ifne +8 -> 402
    //   397: aload 8
    //   399: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   402: aload 7
    //   404: ifnull +8 -> 412
    //   407: aload 7
    //   409: invokevirtual 472	java/io/BufferedReader:close	()V
    //   412: aload 6
    //   414: ifnull +8 -> 422
    //   417: aload 6
    //   419: invokevirtual 473	java/io/FileReader:close	()V
    //   422: ldc2_w 501
    //   425: lreturn
    //   426: astore 7
    //   428: aload 7
    //   430: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   433: ifne -21 -> 412
    //   436: aload 7
    //   438: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   441: goto -29 -> 412
    //   444: astore 6
    //   446: aload 6
    //   448: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   451: ifne -29 -> 422
    //   454: aload 6
    //   456: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   459: goto -37 -> 422
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 7
    //   467: aconst_null
    //   468: astore 8
    //   470: aload 7
    //   472: ifnull +8 -> 480
    //   475: aload 7
    //   477: invokevirtual 472	java/io/BufferedReader:close	()V
    //   480: aload 8
    //   482: ifnull +8 -> 490
    //   485: aload 8
    //   487: invokevirtual 473	java/io/FileReader:close	()V
    //   490: aload 6
    //   492: athrow
    //   493: astore 7
    //   495: aload 7
    //   497: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   500: ifne -20 -> 480
    //   503: aload 7
    //   505: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   508: goto -28 -> 480
    //   511: astore 7
    //   513: aload 7
    //   515: invokestatic 187	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   518: ifne -28 -> 490
    //   521: aload 7
    //   523: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   526: goto -36 -> 490
    //   529: astore 6
    //   531: aconst_null
    //   532: astore 7
    //   534: goto -64 -> 470
    //   537: astore 6
    //   539: goto -69 -> 470
    //   542: astore 9
    //   544: aload 6
    //   546: astore 8
    //   548: aload 9
    //   550: astore 6
    //   552: goto -82 -> 470
    //   555: astore 9
    //   557: aconst_null
    //   558: astore 7
    //   560: aload 8
    //   562: astore 6
    //   564: aload 9
    //   566: astore 8
    //   568: goto -179 -> 389
    //   571: astore 9
    //   573: aload 8
    //   575: astore 6
    //   577: aload 9
    //   579: astore 8
    //   581: goto -192 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	345	0	l1	long
    //   129	236	2	l2	long
    //   222	106	4	l3	long
    //   1	46	6	str1	String
    //   63	11	6	localIOException1	java.io.IOException
    //   81	20	6	localIOException2	java.io.IOException
    //   135	3	6	str2	String
    //   156	11	6	localIOException3	java.io.IOException
    //   175	19	6	localIOException4	java.io.IOException
    //   229	3	6	str3	String
    //   250	11	6	localIOException5	java.io.IOException
    //   269	19	6	localIOException6	java.io.IOException
    //   347	13	6	localIOException7	java.io.IOException
    //   366	52	6	localIOException8	java.io.IOException
    //   444	11	6	localIOException9	java.io.IOException
    //   462	29	6	localObject1	Object
    //   529	1	6	localObject2	Object
    //   537	8	6	localObject3	Object
    //   550	26	6	localObject4	Object
    //   31	377	7	localBufferedReader	java.io.BufferedReader
    //   426	11	7	localIOException10	java.io.IOException
    //   465	11	7	localObject5	Object
    //   493	11	7	localIOException11	java.io.IOException
    //   511	11	7	localIOException12	java.io.IOException
    //   532	27	7	localObject6	Object
    //   17	324	8	localFileReader	java.io.FileReader
    //   384	14	8	localThrowable1	Throwable
    //   468	112	8	localObject7	Object
    //   542	7	9	localObject8	Object
    //   555	10	9	localThrowable2	Throwable
    //   571	7	9	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   51	56	63	java/io/IOException
    //   56	61	81	java/io/IOException
    //   147	152	156	java/io/IOException
    //   142	147	175	java/io/IOException
    //   241	246	250	java/io/IOException
    //   236	241	269	java/io/IOException
    //   340	345	347	java/io/IOException
    //   335	340	366	java/io/IOException
    //   7	19	384	java/lang/Throwable
    //   407	412	426	java/io/IOException
    //   417	422	444	java/io/IOException
    //   7	19	462	finally
    //   475	480	493	java/io/IOException
    //   485	490	511	java/io/IOException
    //   19	33	529	finally
    //   33	46	537	finally
    //   100	137	537	finally
    //   193	231	537	finally
    //   287	317	537	finally
    //   389	402	542	finally
    //   19	33	555	java/lang/Throwable
    //   33	46	571	java/lang/Throwable
    //   100	137	571	java/lang/Throwable
    //   193	231	571	java/lang/Throwable
    //   287	317	571	java/lang/Throwable
  }
  
  private static String g(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < b.length) {}
      try
      {
        paramContext.getPackageInfo(b[i], 1);
        localArrayList.add(Integer.valueOf(i));
        label43:
        i += 1;
        continue;
        if (localArrayList.isEmpty()) {
          return null;
        }
        return localArrayList.toString();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label43;
      }
    }
  }
  
  private static int h(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        paramContext.getInstallerPackageName("de.robv.android.xposed.installer");
        i = 1;
      }
      catch (Exception localException)
      {
        continue;
      }
      try
      {
        paramContext.getInstallerPackageName("com.saurik.substrate");
        return i | 0x2;
      }
      catch (Exception paramContext)
      {
        return i;
      }
    }
  }
  
  public static long h()
  {
    if (!n()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static long i()
  {
    if (!n()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String j()
  {
    return "";
  }
  
  public static String k()
  {
    Object localObject = "fail";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return localObject;
    return "fail";
  }
  
  public static boolean l()
  {
    boolean bool = false;
    String[] arrayOfString = a;
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
  
  public static boolean m()
  {
    float f1 = (float)(Runtime.getRuntime().maxMemory() / 1048576.0D);
    float f2 = (float)(Runtime.getRuntime().totalMemory() / 1048576.0D);
    float f3 = f1 - f2;
    x.c("maxMemory : %f", new Object[] { Float.valueOf(f1) });
    x.c("totalMemory : %f", new Object[] { Float.valueOf(f2) });
    x.c("freeMemory : %f", new Object[] { Float.valueOf(f3) });
    return f3 < 10.0F;
  }
  
  private static boolean n()
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
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  private static int o()
  {
    try
    {
      Method localMethod = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = localMethod.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy");
      if (bool) {
        return 256;
      }
    }
    catch (Exception localException)
    {
      return 256;
    }
    return 0;
  }
  
  private static int p()
  {
    int m = 0;
    try
    {
      throw new Exception("detect hook");
    }
    catch (Exception localException)
    {
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int i1 = arrayOfStackTraceElement.length;
      int j = 0;
      int k = 0;
      while (k < i1)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
        int i = j;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("main")) {
            i = j | 0x4;
          }
        }
        j = i;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          j = i;
          if (localStackTraceElement.getMethodName().equals("handleHookedMethod")) {
            j = i | 0x8;
          }
        }
        i = j;
        if (localStackTraceElement.getClassName().equals("com.saurik.substrate.MS$2"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("invoked")) {
            i = j | 0x10;
          }
        }
        j = i;
        int n = m;
        if (localStackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit"))
        {
          m += 1;
          j = i;
          n = m;
          if (m == 2)
          {
            j = i | 0x20;
            n = m;
          }
        }
        k += 1;
        m = n;
      }
      return j;
    }
  }
  
  /* Error */
  private static int q()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore_0
    //   11: new 659	java/util/HashSet
    //   14: dup
    //   15: invokespecial 660	java/util/HashSet:<init>	()V
    //   18: astore 10
    //   20: new 463	java/io/BufferedReader
    //   23: dup
    //   24: new 662	java/io/InputStreamReader
    //   27: dup
    //   28: new 664	java/io/FileInputStream
    //   31: dup
    //   32: new 237	java/lang/StringBuilder
    //   35: dup
    //   36: ldc_w 666
    //   39: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: invokestatic 671	android/os/Process:myPid	()I
    //   45: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 673
    //   51: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: ldc_w 676
    //   63: invokespecial 679	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   66: invokespecial 682	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   69: astore 8
    //   71: iload_0
    //   72: istore_1
    //   73: aload 8
    //   75: astore 9
    //   77: iload 5
    //   79: istore_2
    //   80: iload 6
    //   82: istore_3
    //   83: aload 8
    //   85: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 11
    //   90: aload 11
    //   92: ifnull +110 -> 202
    //   95: iload_0
    //   96: istore_1
    //   97: aload 8
    //   99: astore 9
    //   101: iload 5
    //   103: istore_2
    //   104: iload 6
    //   106: istore_3
    //   107: aload 11
    //   109: ldc_w 684
    //   112: invokevirtual 216	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +26 -> 141
    //   118: iload_0
    //   119: istore_1
    //   120: aload 8
    //   122: astore 9
    //   124: iload 5
    //   126: istore_2
    //   127: iload 6
    //   129: istore_3
    //   130: aload 11
    //   132: ldc_w 686
    //   135: invokevirtual 216	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   138: ifeq -67 -> 71
    //   141: iload_0
    //   142: istore_1
    //   143: aload 8
    //   145: astore 9
    //   147: iload 5
    //   149: istore_2
    //   150: iload 6
    //   152: istore_3
    //   153: aload 10
    //   155: aload 11
    //   157: aload 11
    //   159: ldc_w 688
    //   162: invokevirtual 692	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: iconst_1
    //   166: iadd
    //   167: invokevirtual 696	java/lang/String:substring	(I)Ljava/lang/String;
    //   170: invokevirtual 697	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -103 -> 71
    //   177: astore 9
    //   179: iload_1
    //   180: istore_0
    //   181: aload 9
    //   183: invokevirtual 698	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   186: iload_0
    //   187: istore_1
    //   188: aload 8
    //   190: ifnull +10 -> 200
    //   193: aload 8
    //   195: invokevirtual 472	java/io/BufferedReader:close	()V
    //   198: iload_0
    //   199: istore_1
    //   200: iload_1
    //   201: ireturn
    //   202: iload_0
    //   203: istore_1
    //   204: aload 8
    //   206: astore 9
    //   208: iload 5
    //   210: istore_2
    //   211: iload 6
    //   213: istore_3
    //   214: aload 10
    //   216: invokevirtual 702	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   219: astore 10
    //   221: iload 4
    //   223: istore_0
    //   224: iload_0
    //   225: istore_1
    //   226: aload 8
    //   228: astore 9
    //   230: iload_0
    //   231: istore_2
    //   232: iload_0
    //   233: istore_3
    //   234: aload 10
    //   236: invokeinterface 707 1 0
    //   241: ifeq +89 -> 330
    //   244: iload_0
    //   245: istore_1
    //   246: aload 8
    //   248: astore 9
    //   250: iload_0
    //   251: istore_2
    //   252: iload_0
    //   253: istore_3
    //   254: aload 10
    //   256: invokeinterface 711 1 0
    //   261: astore 11
    //   263: iload_0
    //   264: istore_1
    //   265: aload 8
    //   267: astore 9
    //   269: iload_0
    //   270: istore_2
    //   271: iload_0
    //   272: istore_3
    //   273: aload 11
    //   275: checkcast 12	java/lang/String
    //   278: invokevirtual 483	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   281: ldc_w 713
    //   284: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   287: istore 7
    //   289: iload 7
    //   291: ifeq +230 -> 521
    //   294: iload_0
    //   295: bipush 64
    //   297: ior
    //   298: istore_0
    //   299: aload 8
    //   301: astore 9
    //   303: aload 11
    //   305: checkcast 12	java/lang/String
    //   308: ldc_w 534
    //   311: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: istore 7
    //   316: iload 7
    //   318: ifeq +200 -> 518
    //   321: iload_0
    //   322: sipush 128
    //   325: ior
    //   326: istore_0
    //   327: goto -103 -> 224
    //   330: aload 8
    //   332: invokevirtual 472	java/io/BufferedReader:close	()V
    //   335: iload_0
    //   336: ireturn
    //   337: astore 8
    //   339: aload 8
    //   341: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   344: iload_0
    //   345: ireturn
    //   346: astore 8
    //   348: aload 8
    //   350: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   353: iload_0
    //   354: ireturn
    //   355: astore 10
    //   357: aconst_null
    //   358: astore 8
    //   360: iconst_0
    //   361: istore_0
    //   362: aload 8
    //   364: astore 9
    //   366: aload 10
    //   368: invokevirtual 714	java/io/FileNotFoundException:printStackTrace	()V
    //   371: iload_0
    //   372: istore_1
    //   373: aload 8
    //   375: ifnull -175 -> 200
    //   378: aload 8
    //   380: invokevirtual 472	java/io/BufferedReader:close	()V
    //   383: iload_0
    //   384: ireturn
    //   385: astore 8
    //   387: aload 8
    //   389: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   392: iload_0
    //   393: ireturn
    //   394: astore 10
    //   396: aconst_null
    //   397: astore 8
    //   399: iconst_0
    //   400: istore_0
    //   401: aload 8
    //   403: astore 9
    //   405: aload 10
    //   407: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   410: iload_0
    //   411: istore_1
    //   412: aload 8
    //   414: ifnull -214 -> 200
    //   417: aload 8
    //   419: invokevirtual 472	java/io/BufferedReader:close	()V
    //   422: iload_0
    //   423: ireturn
    //   424: astore 8
    //   426: aload 8
    //   428: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   431: iload_0
    //   432: ireturn
    //   433: astore 8
    //   435: aconst_null
    //   436: astore 9
    //   438: aload 9
    //   440: ifnull +8 -> 448
    //   443: aload 9
    //   445: invokevirtual 472	java/io/BufferedReader:close	()V
    //   448: aload 8
    //   450: athrow
    //   451: astore 9
    //   453: aload 9
    //   455: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   458: goto -10 -> 448
    //   461: astore 8
    //   463: goto -25 -> 438
    //   466: astore 10
    //   468: aload 8
    //   470: astore 9
    //   472: aload 10
    //   474: astore 8
    //   476: goto -38 -> 438
    //   479: astore 10
    //   481: iload_2
    //   482: istore_0
    //   483: goto -82 -> 401
    //   486: astore 10
    //   488: goto -87 -> 401
    //   491: astore 10
    //   493: iload_3
    //   494: istore_0
    //   495: goto -133 -> 362
    //   498: astore 10
    //   500: goto -138 -> 362
    //   503: astore 9
    //   505: iconst_0
    //   506: istore_0
    //   507: aconst_null
    //   508: astore 8
    //   510: goto -329 -> 181
    //   513: astore 9
    //   515: goto -334 -> 181
    //   518: goto -191 -> 327
    //   521: goto -222 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	497	0	i	int
    //   72	340	1	j	int
    //   79	403	2	k	int
    //   82	412	3	m	int
    //   1	221	4	n	int
    //   4	205	5	i1	int
    //   7	205	6	i2	int
    //   287	30	7	bool	boolean
    //   69	262	8	localBufferedReader1	java.io.BufferedReader
    //   337	3	8	localIOException1	java.io.IOException
    //   346	3	8	localIOException2	java.io.IOException
    //   358	21	8	localObject1	Object
    //   385	3	8	localIOException3	java.io.IOException
    //   397	21	8	localObject2	Object
    //   424	3	8	localIOException4	java.io.IOException
    //   433	16	8	localObject3	Object
    //   461	8	8	localObject4	Object
    //   474	35	8	localObject5	Object
    //   75	71	9	localBufferedReader2	java.io.BufferedReader
    //   177	5	9	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   206	238	9	localObject6	Object
    //   451	3	9	localIOException5	java.io.IOException
    //   470	1	9	localObject7	Object
    //   503	1	9	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   513	1	9	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   18	237	10	localObject8	Object
    //   355	12	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   394	12	10	localIOException6	java.io.IOException
    //   466	7	10	localObject9	Object
    //   479	1	10	localIOException7	java.io.IOException
    //   486	1	10	localIOException8	java.io.IOException
    //   491	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   498	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   88	216	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   83	90	177	java/io/UnsupportedEncodingException
    //   107	118	177	java/io/UnsupportedEncodingException
    //   130	141	177	java/io/UnsupportedEncodingException
    //   153	174	177	java/io/UnsupportedEncodingException
    //   214	221	177	java/io/UnsupportedEncodingException
    //   234	244	177	java/io/UnsupportedEncodingException
    //   254	263	177	java/io/UnsupportedEncodingException
    //   273	289	177	java/io/UnsupportedEncodingException
    //   330	335	337	java/io/IOException
    //   193	198	346	java/io/IOException
    //   11	71	355	java/io/FileNotFoundException
    //   378	383	385	java/io/IOException
    //   11	71	394	java/io/IOException
    //   417	422	424	java/io/IOException
    //   11	71	433	finally
    //   443	448	451	java/io/IOException
    //   83	90	461	finally
    //   107	118	461	finally
    //   130	141	461	finally
    //   153	174	461	finally
    //   214	221	461	finally
    //   234	244	461	finally
    //   254	263	461	finally
    //   273	289	461	finally
    //   303	316	461	finally
    //   366	371	461	finally
    //   405	410	461	finally
    //   181	186	466	finally
    //   83	90	479	java/io/IOException
    //   107	118	479	java/io/IOException
    //   130	141	479	java/io/IOException
    //   153	174	479	java/io/IOException
    //   214	221	479	java/io/IOException
    //   234	244	479	java/io/IOException
    //   254	263	479	java/io/IOException
    //   273	289	479	java/io/IOException
    //   303	316	486	java/io/IOException
    //   83	90	491	java/io/FileNotFoundException
    //   107	118	491	java/io/FileNotFoundException
    //   130	141	491	java/io/FileNotFoundException
    //   153	174	491	java/io/FileNotFoundException
    //   214	221	491	java/io/FileNotFoundException
    //   234	244	491	java/io/FileNotFoundException
    //   254	263	491	java/io/FileNotFoundException
    //   273	289	491	java/io/FileNotFoundException
    //   303	316	498	java/io/FileNotFoundException
    //   11	71	503	java/io/UnsupportedEncodingException
    //   303	316	513	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.b
 * JD-Core Version:    0.7.0.1
 */