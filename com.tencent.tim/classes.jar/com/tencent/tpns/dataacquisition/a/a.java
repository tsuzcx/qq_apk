package com.tencent.tpns.dataacquisition.a;

import alla;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  private static String a = null;
  private static final String[] b = { "com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] c = { "/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager" };
  private static DisplayMetrics d = null;
  private static int e = -1;
  private static Boolean f = null;
  private static String g = null;
  private static long h = -1L;
  private static a i = null;
  
  public static Integer a(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int j = paramContext.getNetworkType();
        return Integer.valueOf(j);
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("unexpected for getTelephonyNetworkType");
    }
    return null;
  }
  
  public static String a()
  {
    try
    {
      if (a == null) {
        a = Build.MODEL;
      }
      if (a == null) {
        a = "";
      }
      String str = a;
      return str;
    }
    finally {}
  }
  
  private static String a(List<String> paramList)
  {
    if (paramList.size() == 0) {
      return "unknown";
    }
    paramList = (String)paramList.get(0);
    if (paramList.contains("mumu")) {
      return "mumu";
    }
    if (paramList.contains("ami")) {
      return "AMIDuOS";
    }
    if (paramList.contains("bluestacks")) {
      return "蓝叠";
    }
    if ((paramList.contains("kaopu001")) || (paramList.contains("tiantian"))) {
      return "天天";
    }
    if (paramList.contains("kpzs")) {
      return "靠谱助手";
    }
    if (paramList.contains("genymotion"))
    {
      if (DeviceInfos.getDM().contains("iTools")) {
        return "iTools";
      }
      if (DeviceInfos.getDM().contains("ChangWan")) {
        return "畅玩";
      }
      return "genymotion";
    }
    if (paramList.contains("uc")) {
      return "uc";
    }
    if (paramList.contains("blue")) {
      return "blue";
    }
    if (paramList.contains("microvirt")) {
      return "逍遥";
    }
    if (paramList.contains("itools")) {
      return "itools";
    }
    if (paramList.contains("syd")) {
      return "手游岛";
    }
    if (paramList.contains("bignox")) {
      return "夜神";
    }
    if (paramList.contains("haimawan")) {
      return "海马玩";
    }
    if (paramList.contains("windroy")) {
      return "windroy";
    }
    if (paramList.contains("flysilkworm")) {
      return "雷电";
    }
    if (paramList.contains("emu")) {
      return "emu";
    }
    if (paramList.contains("le8")) {
      return "le8";
    }
    if (paramList.contains("vphone")) {
      return "vphone";
    }
    if (paramList.contains("duoyi")) {
      return "多益";
    }
    if (Build.MANUFACTURER.toLowerCase().contains("google")) {
      return "Google";
    }
    return "unknown";
  }
  
  public static boolean b()
  {
    try
    {
      String str = Build.CPU_ABI;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (!str.toLowerCase().contains("x86"))
      {
        boolean bool = str.toLowerCase().contains("amd");
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext != null) && (paramContext.isAvailable())) {
            return true;
          }
          com.tencent.tpns.dataacquisition.b.a.a("Network error");
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.tpns.dataacquisition.b.a.a("isNetworkAvailable error", paramContext);
      }
    }
    return false;
  }
  
  public static byte c(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
        {
          paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
          if (paramContext == null) {
            return 0;
          }
          paramContext = paramContext.getActiveNetworkInfo();
          if (paramContext == null) {
            return -1;
          }
          if ((!paramContext.isAvailable()) || (!paramContext.isConnected())) {
            break label176;
          }
          if (paramContext.getType() == 1) {
            return 1;
          }
          if (paramContext.getType() == 0)
          {
            int j = paramContext.getSubtype();
            switch (j)
            {
            case 12: 
            case 14: 
            default: 
              return 0;
            case 1: 
            case 2: 
            case 4: 
            case 7: 
            case 11: 
              return 2;
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 15: 
              return 3;
            }
            return 4;
          }
          return 0;
        }
      }
      catch (Throwable paramContext)
      {
        com.tencent.tpns.dataacquisition.b.a.a("getNetworkType: ", paramContext);
      }
    } else {
      return -1;
    }
    label176:
    return -1;
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: getstatic 302	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   3: ldc_w 309
    //   6: invokevirtual 353	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   9: ifeq +9 -> 18
    //   12: ldc_w 355
    //   15: astore_1
    //   16: aload_1
    //   17: areturn
    //   18: ldc 197
    //   20: astore 5
    //   22: sipush 1024
    //   25: newarray byte
    //   27: astore_2
    //   28: new 357	java/io/RandomAccessFile
    //   31: dup
    //   32: ldc_w 359
    //   35: ldc_w 361
    //   38: invokespecial 365	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_3
    //   43: astore_1
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 369	java/io/RandomAccessFile:read	([B)I
    //   49: istore_0
    //   50: iload_0
    //   51: ifge +47 -> 98
    //   54: aload 5
    //   56: astore_1
    //   57: aload_3
    //   58: ifnull -42 -> 16
    //   61: aload_3
    //   62: invokevirtual 372	java/io/RandomAccessFile:close	()V
    //   65: ldc 197
    //   67: areturn
    //   68: astore_1
    //   69: new 374	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 378
    //   79: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 385	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 189	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
    //   95: ldc 197
    //   97: areturn
    //   98: aload_3
    //   99: astore_1
    //   100: new 30	java/lang/String
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 391	java/lang/String:<init>	([B)V
    //   108: astore_2
    //   109: aload_3
    //   110: astore_1
    //   111: aload_2
    //   112: iconst_0
    //   113: invokevirtual 395	java/lang/String:indexOf	(I)I
    //   116: istore_0
    //   117: iload_0
    //   118: iconst_m1
    //   119: if_icmpeq +53 -> 172
    //   122: aload_3
    //   123: astore_1
    //   124: aload_2
    //   125: iconst_0
    //   126: iload_0
    //   127: invokevirtual 399	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: ifnull -118 -> 16
    //   137: aload_3
    //   138: invokevirtual 372	java/io/RandomAccessFile:close	()V
    //   141: aload_2
    //   142: areturn
    //   143: astore_1
    //   144: new 374	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 378
    //   154: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 385	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 189	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
    //   170: aload_2
    //   171: areturn
    //   172: goto -41 -> 131
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: astore_1
    //   181: ldc_w 401
    //   184: aload 4
    //   186: invokestatic 337	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload 5
    //   191: astore_1
    //   192: aload_2
    //   193: ifnull -177 -> 16
    //   196: aload_2
    //   197: invokevirtual 372	java/io/RandomAccessFile:close	()V
    //   200: ldc 197
    //   202: areturn
    //   203: astore_1
    //   204: new 374	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 378
    //   214: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_1
    //   218: invokevirtual 385	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 189	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
    //   230: ldc 197
    //   232: areturn
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 372	java/io/RandomAccessFile:close	()V
    //   244: aload_2
    //   245: athrow
    //   246: astore_1
    //   247: new 374	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 378
    //   257: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 385	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 189	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
    //   273: goto -29 -> 244
    //   276: astore_2
    //   277: goto -41 -> 236
    //   280: astore 4
    //   282: aload_3
    //   283: astore_2
    //   284: goto -105 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	78	0	j	int
    //   15	42	1	localObject1	Object
    //   68	15	1	localThrowable1	Throwable
    //   99	34	1	localObject2	Object
    //   143	15	1	localThrowable2	Throwable
    //   180	12	1	localObject3	Object
    //   203	15	1	localThrowable3	Throwable
    //   235	6	1	localObject4	Object
    //   246	15	1	localThrowable4	Throwable
    //   27	170	2	localObject5	Object
    //   233	12	2	localObject6	Object
    //   276	1	2	localObject7	Object
    //   283	1	2	localObject8	Object
    //   41	242	3	localRandomAccessFile	java.io.RandomAccessFile
    //   175	10	4	localThrowable5	Throwable
    //   280	1	4	localThrowable6	Throwable
    //   20	170	5	str	String
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/lang/Throwable
    //   137	141	143	java/lang/Throwable
    //   22	42	175	java/lang/Throwable
    //   196	200	203	java/lang/Throwable
    //   22	42	233	finally
    //   240	244	246	java/lang/Throwable
    //   44	50	276	finally
    //   100	109	276	finally
    //   111	117	276	finally
    //   124	131	276	finally
    //   181	189	276	finally
    //   44	50	280	java/lang/Throwable
    //   100	109	280	java/lang/Throwable
    //   111	117	280	java/lang/Throwable
    //   124	131	280	java/lang/Throwable
  }
  
  public static String d()
  {
    String str2 = c();
    String str1;
    if (str2.contains("ARMv5")) {
      str1 = "armv5";
    }
    while (str2.contains("neon"))
    {
      return str1 + "_neon";
      if (str2.contains("ARMv6")) {
        str1 = "armv6";
      } else if (str2.contains("ARMv7")) {
        str1 = "armv7";
      } else if (str2.contains("Intel")) {
        str1 = "x86";
      } else {
        return "unknown";
      }
    }
    if (str2.contains("vfpv3")) {
      return str1 + "_vfpv3";
    }
    if (str2.contains(" vfp")) {
      return str1 + "_vfp";
    }
    return str1 + "_none";
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          boolean bool = "WIFI".equalsIgnoreCase(paramContext.getTypeName());
          return bool;
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("Check isWiFiActive error", paramContext);
    }
    return false;
  }
  
  public static String e()
  {
    long l1 = f() / 1000000L;
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = localStatFs.getBlockSize();
    l2 = localStatFs.getAvailableBlocks() * l2 / 1000000L;
    return String.valueOf(l2) + "/" + String.valueOf(l1);
  }
  
  public static String e(Context paramContext)
  {
    Object localObject;
    try
    {
      if ((com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.INTERNET")) && (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          paramContext = ((NetworkInfo)localObject).getTypeName();
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          if (paramContext != null)
          {
            if ("WIFI".equalsIgnoreCase(paramContext)) {
              return "WIFI";
            }
            if (!"MOBILE".equalsIgnoreCase(paramContext)) {
              break label109;
            }
            if (localObject != null) {
              break label107;
            }
            return "MOBILE";
          }
        }
      }
      else
      {
        com.tencent.tpns.dataacquisition.b.a.b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.tpns.dataacquisition.b.a.b(paramContext);
      }
    }
    return null;
    label107:
    label109:
    while (localObject != null) {
      return localObject;
    }
    return paramContext;
  }
  
  public static long f()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static DisplayMetrics f(Context paramContext)
  {
    if (d == null)
    {
      d = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(d);
    }
    return d;
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: getstatic 156	com/tencent/tpns/dataacquisition/a/a:h	J
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +7 -> 14
    //   10: getstatic 156	com/tencent/tpns/dataacquisition/a/a:h	J
    //   13: lreturn
    //   14: new 509	java/io/BufferedReader
    //   17: dup
    //   18: new 511	java/io/FileReader
    //   21: dup
    //   22: ldc_w 513
    //   25: invokespecial 514	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: sipush 8192
    //   31: invokespecial 517	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore 8
    //   36: aload 8
    //   38: astore 7
    //   40: aload 8
    //   42: invokevirtual 520	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 9
    //   47: lload_3
    //   48: lstore_1
    //   49: aload 9
    //   51: ifnull +31 -> 82
    //   54: aload 8
    //   56: astore 7
    //   58: aload 9
    //   60: ldc_w 522
    //   63: invokevirtual 526	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: iconst_1
    //   67: aaload
    //   68: invokestatic 529	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   71: invokevirtual 532	java/lang/Integer:intValue	()I
    //   74: istore_0
    //   75: iload_0
    //   76: i2l
    //   77: ldc2_w 533
    //   80: lmul
    //   81: lstore_1
    //   82: lload_1
    //   83: lstore 5
    //   85: aload 8
    //   87: ifnull +11 -> 98
    //   90: aload 8
    //   92: invokevirtual 535	java/io/BufferedReader:close	()V
    //   95: lload_1
    //   96: lstore 5
    //   98: lload 5
    //   100: putstatic 156	com/tencent/tpns/dataacquisition/a/a:h	J
    //   103: getstatic 156	com/tencent/tpns/dataacquisition/a/a:h	J
    //   106: lreturn
    //   107: astore 9
    //   109: aconst_null
    //   110: astore 8
    //   112: aload 8
    //   114: astore 7
    //   116: new 374	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 378
    //   126: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 9
    //   131: invokevirtual 536	java/io/IOException:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 189	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
    //   143: lload_3
    //   144: lstore 5
    //   146: aload 8
    //   148: ifnull -50 -> 98
    //   151: aload 8
    //   153: invokevirtual 535	java/io/BufferedReader:close	()V
    //   156: lload_3
    //   157: lstore 5
    //   159: goto -61 -> 98
    //   162: astore 7
    //   164: lload_3
    //   165: lstore 5
    //   167: goto -69 -> 98
    //   170: astore 8
    //   172: aconst_null
    //   173: astore 7
    //   175: aload 7
    //   177: ifnull +8 -> 185
    //   180: aload 7
    //   182: invokevirtual 535	java/io/BufferedReader:close	()V
    //   185: aload 8
    //   187: athrow
    //   188: astore 7
    //   190: lload_1
    //   191: lstore 5
    //   193: goto -95 -> 98
    //   196: astore 7
    //   198: goto -13 -> 185
    //   201: astore 8
    //   203: goto -28 -> 175
    //   206: astore 9
    //   208: goto -96 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	2	0	j	int
    //   48	143	1	l1	long
    //   1	164	3	l2	long
    //   83	109	5	l3	long
    //   38	77	7	localBufferedReader1	java.io.BufferedReader
    //   162	1	7	localThrowable1	Throwable
    //   173	8	7	localObject1	Object
    //   188	1	7	localThrowable2	Throwable
    //   196	1	7	localThrowable3	Throwable
    //   34	118	8	localBufferedReader2	java.io.BufferedReader
    //   170	16	8	localObject2	Object
    //   201	1	8	localObject3	Object
    //   45	14	9	str	String
    //   107	23	9	localIOException1	IOException
    //   206	1	9	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   14	36	107	java/io/IOException
    //   151	156	162	java/lang/Throwable
    //   14	36	170	finally
    //   90	95	188	java/lang/Throwable
    //   180	185	196	java/lang/Throwable
    //   40	47	201	finally
    //   58	75	201	finally
    //   116	143	201	finally
    //   40	47	206	java/io/IOException
    //   58	75	206	java/io/IOException
  }
  
  public static boolean g(Context paramContext)
  {
    return (SensorManager)paramContext.getSystemService("sensor") != null;
  }
  
  public static int h(Context paramContext)
  {
    if (e >= 0) {
      return e;
    }
    try
    {
      boolean bool = b.a();
      if (bool) {
        return 1;
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("call hasRootAccess Error:", paramContext);
    }
    return 0;
  }
  
  public static boolean h()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tpns.dataacquisition.b.a.a("isSDCardMounted", localThrowable);
    }
    return false;
  }
  
  public static String i()
  {
    try
    {
      double d1 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0D;
      Object localObject = NumberFormat.getInstance();
      ((NumberFormat)localObject).setGroupingUsed(false);
      localObject = ((NumberFormat)localObject).format(d1);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        paramContext = Environment.getExternalStorageState();
        if ((paramContext != null) && (paramContext.equals("mounted")))
        {
          paramContext = Environment.getExternalStorageDirectory().getPath();
          if (paramContext != null)
          {
            paramContext = new StatFs(paramContext);
            long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
            long l2 = paramContext.getAvailableBlocks();
            l2 = paramContext.getBlockSize() * l2 / 1000000L;
            return String.valueOf(l2) + "/" + String.valueOf(l1);
          }
        }
      }
      else
      {
        com.tencent.tpns.dataacquisition.b.a.a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("getExternalStorageInfo err:", paramContext);
    }
    return null;
  }
  
  public static int j(Context paramContext)
  {
    if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.BLUETOOTH"))
    {
      paramContext = BluetoothAdapter.getDefaultAdapter();
      if (paramContext == null) {
        return -1;
      }
      if (paramContext.isEnabled()) {
        return 1;
      }
    }
    return 0;
  }
  
  public static String j()
  {
    return "";
  }
  
  public static boolean k(Context paramContext)
  {
    if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.BLUETOOTH")) {}
    try
    {
      paramContext = BluetoothAdapter.getDefaultAdapter();
      if (paramContext == null) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramContext.getName());
      if (bool) {
        break label38;
      }
    }
    catch (Exception paramContext)
    {
      label32:
      break label32;
    }
    return true;
    label38:
    return false;
  }
  
  public static boolean l(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(5);
      if (paramContext == null) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramContext.getName());
      if (bool) {
        return false;
      }
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static boolean m(Context paramContext)
  {
    if (f == null) {
      if ((b()) && (k(paramContext)) && (l(paramContext))) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      f = Boolean.valueOf(bool);
      return f.booleanValue();
    }
  }
  
  public static String n(Context paramContext)
  {
    if (g == null) {
      g = a(w(paramContext));
    }
    return g;
  }
  
  public static String o(Context paramContext)
  {
    long l1 = x(paramContext) / 1000000L;
    long l2 = g() / 1000000L;
    return String.valueOf(l1) + "/" + String.valueOf(l2);
  }
  
  public static JSONObject p(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      y(paramContext);
      int j = a.b();
      if (j > 0) {
        localJSONObject.put("fx", j / 1000000);
      }
      y(paramContext);
      j = a.c();
      if (j > 0) {
        localJSONObject.put("fn", j / 1000000);
      }
      y(paramContext);
      j = a.a();
      if (j > 0) {
        localJSONObject.put("n", j);
      }
      y(paramContext);
      String str = a.d();
      if ((str != null) && (str.length() != 0))
      {
        y(paramContext);
        localJSONObject.put("na", a.d());
      }
      y(paramContext);
      localJSONObject.put("m", a.e());
      return localJSONObject;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("getCpuInfo", paramContext);
    }
    return localJSONObject;
  }
  
  public static String q(Context paramContext)
  {
    for (;;)
    {
      int j;
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          paramContext = paramContext.getSensorList(-1);
          if (paramContext != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            j = 0;
            if (j < paramContext.size())
            {
              localStringBuilder.append(((Sensor)paramContext.get(j)).getType());
              if (j == paramContext.size() - 1) {
                break label104;
              }
              localStringBuilder.append(",");
              break label104;
            }
            paramContext = localStringBuilder.toString();
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        com.tencent.tpns.dataacquisition.b.a.a("getAllSensors", paramContext);
      }
      return "";
      label104:
      j += 1;
    }
  }
  
  public static JSONArray r(Context paramContext)
  {
    try
    {
      paramContext = (SensorManager)paramContext.getSystemService("sensor");
      if (paramContext != null)
      {
        paramContext = paramContext.getSensorList(-1);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          JSONArray localJSONArray = new JSONArray();
          int j = 0;
          while (j < paramContext.size())
          {
            Sensor localSensor = (Sensor)paramContext.get(j);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("name", localSensor.getName());
            localJSONObject.put("vendor", localSensor.getVendor());
            localJSONArray.put(localJSONObject);
            j += 1;
          }
          return localJSONArray;
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("getSensors:" + paramContext.toString());
    }
    return null;
  }
  
  public static boolean s(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("Util -> isScreenOn", paramContext);
    }
    return false;
  }
  
  public static int t(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      j = paramContext.getIntExtra("status", -1);
      if (j == 2) {
        break label59;
      }
      if (j != 5) {
        break label67;
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tpns.dataacquisition.b.a.a("Util -> getChangedStatus", paramContext);
      return -1;
    }
    int j = paramContext.getIntExtra("plugged", -1);
    return j;
    label59:
    label67:
    for (j = 1; j == 0; j = 0) {
      return -1;
    }
  }
  
  public static String u(Context paramContext)
  {
    if (com.tencent.tpns.dataacquisition.b.a.a(paramContext, "android.permission.BLUETOOTH")) {
      try
      {
        paramContext = BluetoothAdapter.getDefaultAdapter();
        if (paramContext != null)
        {
          paramContext = paramContext.getName();
          if (paramContext != null) {
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return "";
  }
  
  public static String v(Context paramContext)
  {
    try
    {
      paramContext = alla.f((TelephonyManager)paramContext.getSystemService("phone"));
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  /* Error */
  private static List<String> w(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 757	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 758	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: iconst_0
    //   12: istore_1
    //   13: getstatic 138	com/tencent/tpns/dataacquisition/a/a:b	[Ljava/lang/String;
    //   16: arraylength
    //   17: istore_3
    //   18: iload_1
    //   19: iload_3
    //   20: if_icmpge +37 -> 57
    //   23: aload_0
    //   24: invokevirtual 762	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: getstatic 138	com/tencent/tpns/dataacquisition/a/a:b	[Ljava/lang/String;
    //   30: iload_1
    //   31: aaload
    //   32: iconst_1
    //   33: invokevirtual 768	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: pop
    //   37: aload 4
    //   39: getstatic 138	com/tencent/tpns/dataacquisition/a/a:b	[Ljava/lang/String;
    //   42: iload_1
    //   43: aaload
    //   44: invokeinterface 771 2 0
    //   49: pop
    //   50: iload_1
    //   51: iconst_1
    //   52: iadd
    //   53: istore_1
    //   54: goto -41 -> 13
    //   57: aload 4
    //   59: invokeinterface 203 1 0
    //   64: ifne +56 -> 120
    //   67: iload_2
    //   68: istore_1
    //   69: iload_1
    //   70: getstatic 144	com/tencent/tpns/dataacquisition/a/a:c	[Ljava/lang/String;
    //   73: arraylength
    //   74: if_icmpge +46 -> 120
    //   77: new 451	java/io/File
    //   80: dup
    //   81: getstatic 144	com/tencent/tpns/dataacquisition/a/a:c	[Ljava/lang/String;
    //   84: iload_1
    //   85: aaload
    //   86: invokespecial 772	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 775	java/io/File:exists	()Z
    //   92: ifeq +16 -> 108
    //   95: aload 4
    //   97: getstatic 144	com/tencent/tpns/dataacquisition/a/a:c	[Ljava/lang/String;
    //   100: iload_1
    //   101: aaload
    //   102: invokeinterface 771 2 0
    //   107: pop
    //   108: iload_1
    //   109: iconst_1
    //   110: iadd
    //   111: istore_1
    //   112: goto -43 -> 69
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 778	java/lang/Exception:printStackTrace	()V
    //   120: aload 4
    //   122: areturn
    //   123: astore 5
    //   125: goto -75 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   12	100	1	j	int
    //   1	67	2	k	int
    //   17	4	3	m	int
    //   9	112	4	localArrayList	java.util.ArrayList
    //   123	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   13	18	115	java/lang/Exception
    //   23	50	115	java/lang/Exception
    //   57	67	115	java/lang/Exception
    //   69	108	115	java/lang/Exception
    //   23	50	123	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private static long x(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  private static a y(Context paramContext)
  {
    try
    {
      if (i == null) {
        i = new a();
      }
      paramContext = i;
      return paramContext;
    }
    finally {}
  }
  
  static class a
  {
    static int a()
    {
      int i = 1;
      try
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new a.a.a());
        if (arrayOfFile != null) {
          i = arrayOfFile.length;
        }
        return i;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return 1;
    }
    
    static int b()
    {
      int k = 0;
      int i = 0;
      Object localObject3 = null;
      Object localObject1 = null;
      String str = "";
      for (;;)
      {
        try
        {
          localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          byte[] arrayOfByte = new byte[24];
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          if (localInputStream.read(arrayOfByte) != -1)
          {
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            str = str + new String(arrayOfByte);
            continue;
          }
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          str = str.trim();
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          if (str.length() > 0)
          {
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            i = Integer.valueOf(str).intValue();
          }
          j = i;
        }
        catch (Throwable localThrowable4)
        {
          InputStream localInputStream;
          localObject3 = localThrowable1;
          com.tencent.tpns.dataacquisition.b.a.a("getMaxCpuFreq err", localThrowable4);
          int j = k;
          if (localThrowable1 == null) {
            continue;
          }
          try
          {
            localThrowable1.close();
            j = k;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for:" + localThrowable2.getMessage());
            j = k;
          }
          continue;
        }
        finally
        {
          if (localObject3 == null) {
            break label277;
          }
        }
        try
        {
          localInputStream.close();
          j = i;
        }
        catch (Throwable localThrowable1)
        {
          com.tencent.tpns.dataacquisition.b.a.a("unexpected for:" + localThrowable1.getMessage());
          j = i;
        }
      }
      return j * 1000;
      try
      {
        localObject3.close();
        label277:
        throw localObject2;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          com.tencent.tpns.dataacquisition.b.a.a("unexpected for:" + localThrowable3.getMessage());
        }
      }
    }
    
    static int c()
    {
      int k = 0;
      int i = 0;
      Object localObject3 = null;
      Object localObject1 = null;
      String str = "";
      for (;;)
      {
        try
        {
          localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          byte[] arrayOfByte = new byte[24];
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          if (localInputStream.read(arrayOfByte) != -1)
          {
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            str = str + new String(arrayOfByte, "UTF-8");
            continue;
          }
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          str = str.trim();
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          if (str.length() > 0)
          {
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            i = Integer.valueOf(str).intValue();
          }
          j = i;
        }
        catch (IOException localIOException)
        {
          InputStream localInputStream;
          localObject3 = localThrowable1;
          com.tencent.tpns.dataacquisition.b.a.a("getMinCpuFreq", localIOException);
          int j = k;
          if (localThrowable1 == null) {
            continue;
          }
          try
          {
            localThrowable1.close();
            j = k;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + localThrowable2.getMessage());
            j = k;
          }
          continue;
        }
        finally
        {
          if (localObject3 == null) {
            break label279;
          }
        }
        try
        {
          localInputStream.close();
          j = i;
        }
        catch (Throwable localThrowable1)
        {
          com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + localThrowable1.getMessage());
          j = i;
        }
      }
      return j * 1000;
      try
      {
        localObject3.close();
        label279:
        throw localObject2;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + localThrowable3.getMessage());
        }
      }
    }
    
    /* Error */
    static String d()
    {
      // Byte code:
      //   0: new 126	java/io/BufferedReader
      //   3: dup
      //   4: new 128	java/io/FileReader
      //   7: dup
      //   8: ldc 130
      //   10: invokespecial 131	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   13: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   16: astore_1
      //   17: aload_1
      //   18: astore_0
      //   19: aload_1
      //   20: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   23: astore_2
      //   24: aload_1
      //   25: astore_0
      //   26: aload_2
      //   27: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   30: ifne +62 -> 92
      //   33: aload_1
      //   34: astore_0
      //   35: aload_2
      //   36: ldc 145
      //   38: iconst_2
      //   39: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
      //   42: astore_2
      //   43: aload_1
      //   44: astore_0
      //   45: aload_2
      //   46: arraylength
      //   47: ifle +45 -> 92
      //   50: aload_2
      //   51: iconst_1
      //   52: aaload
      //   53: astore_0
      //   54: aload_1
      //   55: ifnull +7 -> 62
      //   58: aload_1
      //   59: invokevirtual 150	java/io/BufferedReader:close	()V
      //   62: aload_0
      //   63: areturn
      //   64: astore_1
      //   65: new 64	java/lang/StringBuilder
      //   68: dup
      //   69: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   72: ldc 121
      //   74: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: aload_1
      //   78: invokevirtual 99	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   81: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   90: aload_0
      //   91: areturn
      //   92: aload_1
      //   93: ifnull +7 -> 100
      //   96: aload_1
      //   97: invokevirtual 150	java/io/BufferedReader:close	()V
      //   100: ldc 35
      //   102: areturn
      //   103: astore_0
      //   104: new 64	java/lang/StringBuilder
      //   107: dup
      //   108: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   111: ldc 121
      //   113: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: aload_0
      //   117: invokevirtual 99	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   120: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   129: goto -29 -> 100
      //   132: astore_2
      //   133: aconst_null
      //   134: astore_1
      //   135: aload_1
      //   136: astore_0
      //   137: ldc 152
      //   139: aload_2
      //   140: invokestatic 109	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   143: aload_1
      //   144: ifnull -44 -> 100
      //   147: aload_1
      //   148: invokevirtual 150	java/io/BufferedReader:close	()V
      //   151: goto -51 -> 100
      //   154: astore_0
      //   155: new 64	java/lang/StringBuilder
      //   158: dup
      //   159: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   162: ldc 121
      //   164: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   167: aload_0
      //   168: invokevirtual 99	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   171: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   180: goto -80 -> 100
      //   183: astore_1
      //   184: aconst_null
      //   185: astore_0
      //   186: aload_0
      //   187: ifnull +7 -> 194
      //   190: aload_0
      //   191: invokevirtual 150	java/io/BufferedReader:close	()V
      //   194: aload_1
      //   195: athrow
      //   196: astore_0
      //   197: new 64	java/lang/StringBuilder
      //   200: dup
      //   201: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   204: ldc 121
      //   206: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   209: aload_0
      //   210: invokevirtual 99	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   213: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   219: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   222: goto -28 -> 194
      //   225: astore_1
      //   226: goto -40 -> 186
      //   229: astore_2
      //   230: goto -95 -> 135
      // Local variable table:
      //   start	length	slot	name	signature
      //   18	73	0	localBufferedReader1	java.io.BufferedReader
      //   103	14	0	localThrowable1	Throwable
      //   136	1	0	localObject1	Object
      //   154	14	0	localThrowable2	Throwable
      //   185	6	0	localObject2	Object
      //   196	14	0	localThrowable3	Throwable
      //   16	43	1	localBufferedReader2	java.io.BufferedReader
      //   64	33	1	localThrowable4	Throwable
      //   134	14	1	localObject3	Object
      //   183	12	1	localObject4	Object
      //   225	1	1	localObject5	Object
      //   23	28	2	localObject6	Object
      //   132	8	2	localThrowable5	Throwable
      //   229	1	2	localThrowable6	Throwable
      // Exception table:
      //   from	to	target	type
      //   58	62	64	java/lang/Throwable
      //   96	100	103	java/lang/Throwable
      //   0	17	132	java/lang/Throwable
      //   147	151	154	java/lang/Throwable
      //   0	17	183	finally
      //   190	194	196	java/lang/Throwable
      //   19	24	225	finally
      //   26	33	225	finally
      //   35	43	225	finally
      //   45	50	225	finally
      //   137	143	225	finally
      //   19	24	229	java/lang/Throwable
      //   26	33	229	java/lang/Throwable
      //   35	43	229	java/lang/Throwable
      //   45	50	229	java/lang/Throwable
    }
    
    /* Error */
    static String e()
    {
      // Byte code:
      //   0: ldc 35
      //   2: astore_2
      //   3: new 126	java/io/BufferedReader
      //   6: dup
      //   7: new 128	java/io/FileReader
      //   10: dup
      //   11: ldc 130
      //   13: invokespecial 131	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   16: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   19: astore_1
      //   20: aload_1
      //   21: astore_0
      //   22: aload_1
      //   23: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   26: astore_3
      //   27: aload_2
      //   28: astore_0
      //   29: aload_3
      //   30: ifnull +40 -> 70
      //   33: aload_1
      //   34: astore_0
      //   35: aload_3
      //   36: ldc 145
      //   38: iconst_2
      //   39: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
      //   42: astore_3
      //   43: aload_3
      //   44: ifnull -24 -> 20
      //   47: aload_1
      //   48: astore_0
      //   49: aload_3
      //   50: iconst_0
      //   51: aaload
      //   52: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
      //   55: invokevirtual 156	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   58: ldc 158
      //   60: invokevirtual 162	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   63: ifeq -43 -> 20
      //   66: aload_3
      //   67: iconst_1
      //   68: aaload
      //   69: astore_0
      //   70: aload_0
      //   71: astore_2
      //   72: aload_1
      //   73: ifnull +9 -> 82
      //   76: aload_1
      //   77: invokevirtual 150	java/io/BufferedReader:close	()V
      //   80: aload_0
      //   81: astore_2
      //   82: aload_2
      //   83: areturn
      //   84: astore_1
      //   85: ldc 164
      //   87: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   90: aload_0
      //   91: areturn
      //   92: astore_3
      //   93: aconst_null
      //   94: astore_1
      //   95: aload_1
      //   96: astore_0
      //   97: ldc 166
      //   99: aload_3
      //   100: invokestatic 109	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   103: aload_1
      //   104: ifnull -22 -> 82
      //   107: aload_1
      //   108: invokevirtual 150	java/io/BufferedReader:close	()V
      //   111: ldc 35
      //   113: areturn
      //   114: astore_0
      //   115: ldc 164
      //   117: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   120: ldc 35
      //   122: areturn
      //   123: astore_1
      //   124: aconst_null
      //   125: astore_0
      //   126: aload_0
      //   127: ifnull +7 -> 134
      //   130: aload_0
      //   131: invokevirtual 150	java/io/BufferedReader:close	()V
      //   134: aload_1
      //   135: athrow
      //   136: astore_0
      //   137: ldc 164
      //   139: invokestatic 104	com/tencent/tpns/dataacquisition/b/a:a	(Ljava/lang/Object;)V
      //   142: goto -8 -> 134
      //   145: astore_1
      //   146: goto -20 -> 126
      //   149: astore_3
      //   150: goto -55 -> 95
      // Local variable table:
      //   start	length	slot	name	signature
      //   21	76	0	localObject1	Object
      //   114	1	0	localThrowable1	Throwable
      //   125	6	0	localObject2	Object
      //   136	1	0	localThrowable2	Throwable
      //   19	58	1	localBufferedReader	java.io.BufferedReader
      //   84	1	1	localThrowable3	Throwable
      //   94	14	1	localObject3	Object
      //   123	12	1	localObject4	Object
      //   145	1	1	localObject5	Object
      //   2	81	2	localObject6	Object
      //   26	41	3	localObject7	Object
      //   92	8	3	localThrowable4	Throwable
      //   149	1	3	localThrowable5	Throwable
      // Exception table:
      //   from	to	target	type
      //   76	80	84	java/lang/Throwable
      //   3	20	92	java/lang/Throwable
      //   107	111	114	java/lang/Throwable
      //   3	20	123	finally
      //   130	134	136	java/lang/Throwable
      //   22	27	145	finally
      //   35	43	145	finally
      //   49	66	145	finally
      //   97	103	145	finally
      //   22	27	149	java/lang/Throwable
      //   35	43	149	java/lang/Throwable
      //   49	66	149	java/lang/Throwable
    }
  }
  
  static class b
  {
    private static int a = -1;
    
    public static boolean a()
    {
      if (a == 1) {
        return true;
      }
      if (a == 0) {
        return false;
      }
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "/bin";
      arrayOfString[1] = "/system/bin/";
      arrayOfString[2] = "/system/xbin/";
      arrayOfString[3] = "/system/sbin/";
      arrayOfString[4] = "/sbin/";
      arrayOfString[5] = "/vendor/bin/";
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < arrayOfString.length)
          {
            File localFile = new File(arrayOfString[i] + "su");
            if ((localFile == null) || (!localFile.exists())) {
              break label139;
            }
            a = 1;
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + localThrowable.getMessage());
          a = 0;
          return false;
        }
        label139:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.dataacquisition.a.a
 * JD-Core Version:    0.7.0.1
 */