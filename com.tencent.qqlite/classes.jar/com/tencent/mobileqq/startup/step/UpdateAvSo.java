package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class UpdateAvSo
  extends Step
{
  private static final String b = "so_sp";
  private static final String c = "AVModuleExtract";
  private static final String d = "key_so_version_";
  private static final String e = "first_qq_lauch_";
  private static final String f = "first_av_lauch_";
  
  public static long a()
  {
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (localSharedPreferences.getLong("first_av_lauch_108074", 0L) != 0L) {
      return 0L;
    }
    localSharedPreferences.edit().putLong("first_av_lauch_108074", l).commit();
    return l - b();
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVModuleExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    c(localBaseApplicationImpl, "VideoCtrl");
    c(localBaseApplicationImpl, "qq_sharp");
    c(localBaseApplicationImpl, "traeimp-armeabi-v7a");
    c(localBaseApplicationImpl, "qav_graphics");
    c(localBaseApplicationImpl, "qav_gaudio_engine");
  }
  
  public static boolean a(Context paramContext)
  {
    return b(paramContext, "qq_vqq");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVModuleExtract", 2, "start LoadExtractedSo: " + paramString);
    }
    try
    {
      System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        boolean bool;
        HashMap localHashMap;
        c(paramContext, paramString);
        try
        {
          System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
          bool = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          bool = false;
        }
      }
    }
    if (!bool)
    {
      QLog.e("AVModuleExtract", 1, "LoadExtractedSo failed: " + paramString);
      localHashMap = new HashMap();
      localHashMap.put("soname", paramString);
      StatisticCollector.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, localHashMap, "");
    }
    return bool;
  }
  
  private static long b()
  {
    long l2 = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0).getLong("first_qq_lauch_108074", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = BaseApplicationImpl.b;
    }
    return l1;
  }
  
  private static String b()
  {
    return "lib/armeabi/";
  }
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.b);
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.b > 0L) {}
    for (long l = BaseApplicationImpl.b;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong("first_qq_lauch_108074", l).commit();
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return (b(paramContext, "TcHevcDec")) && (b(paramContext, "TcVp8Codec")) && (b(paramContext, "TcVpxDec")) && (b(paramContext, "TcVpxEnc"));
  }
  
  @TargetApi(9)
  public static boolean b(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + a(paramString));
      File localFile = new File(a() + a(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVModuleExtract", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  /* Error */
  public static boolean c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 8
    //   3: iconst_0
    //   4: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 28
    //   9: ldc 225
    //   11: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   14: invokevirtual 235	java/lang/Integer:intValue	()I
    //   17: istore_2
    //   18: new 87	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   25: ldc 14
    //   27: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 29
    //   39: ldc 85
    //   41: astore 21
    //   43: aload 28
    //   45: aload 29
    //   47: iconst_m1
    //   48: invokeinterface 239 3 0
    //   53: istore_3
    //   54: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +46 -> 103
    //   60: ldc 11
    //   62: iconst_2
    //   63: new 87	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   70: ldc 241
    //   72: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 243
    //   81: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc 248
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_2
    //   94: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: invokestatic 206	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   106: astore 31
    //   108: aload 31
    //   110: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +16 -> 129
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: ireturn
    //   122: astore 10
    //   124: iconst_0
    //   125: istore_2
    //   126: goto -108 -> 18
    //   129: new 90	java/io/File
    //   132: dup
    //   133: new 87	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   140: aload 31
    //   142: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokestatic 131	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 30
    //   160: iload_3
    //   161: iload_2
    //   162: if_icmpne +13 -> 175
    //   165: aload 30
    //   167: invokevirtual 209	java/io/File:exists	()Z
    //   170: ifeq +5 -> 175
    //   173: iconst_1
    //   174: ireturn
    //   175: aload 30
    //   177: invokevirtual 257	java/io/File:delete	()Z
    //   180: pop
    //   181: aload 30
    //   183: invokevirtual 209	java/io/File:exists	()Z
    //   186: ifne +1097 -> 1283
    //   189: aconst_null
    //   190: astore 22
    //   192: aconst_null
    //   193: astore 23
    //   195: aconst_null
    //   196: astore 20
    //   198: aconst_null
    //   199: astore 24
    //   201: aconst_null
    //   202: astore 27
    //   204: aconst_null
    //   205: astore 19
    //   207: aconst_null
    //   208: astore 10
    //   210: aconst_null
    //   211: astore 25
    //   213: aconst_null
    //   214: astore 26
    //   216: aconst_null
    //   217: astore 18
    //   219: aconst_null
    //   220: astore 11
    //   222: aload 25
    //   224: astore 15
    //   226: aload 10
    //   228: astore 13
    //   230: aload 22
    //   232: astore 17
    //   234: aload 26
    //   236: astore 14
    //   238: aload 27
    //   240: astore 12
    //   242: aload 23
    //   244: astore 16
    //   246: new 90	java/io/File
    //   249: dup
    //   250: aload 31
    //   252: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 32
    //   257: aload 25
    //   259: astore 15
    //   261: aload 10
    //   263: astore 13
    //   265: aload 22
    //   267: astore 17
    //   269: aload 26
    //   271: astore 14
    //   273: aload 27
    //   275: astore 12
    //   277: aload 23
    //   279: astore 16
    //   281: aload 32
    //   283: invokevirtual 209	java/io/File:exists	()Z
    //   286: ifne +39 -> 325
    //   289: aload 25
    //   291: astore 15
    //   293: aload 10
    //   295: astore 13
    //   297: aload 22
    //   299: astore 17
    //   301: aload 26
    //   303: astore 14
    //   305: aload 27
    //   307: astore 12
    //   309: aload 23
    //   311: astore 16
    //   313: aload 32
    //   315: invokevirtual 260	java/io/File:mkdir	()Z
    //   318: istore 4
    //   320: iload 4
    //   322: ifeq +944 -> 1266
    //   325: aload 25
    //   327: astore 15
    //   329: aload 10
    //   331: astore 13
    //   333: aload 22
    //   335: astore 17
    //   337: aload 26
    //   339: astore 14
    //   341: aload 27
    //   343: astore 12
    //   345: aload 23
    //   347: astore 16
    //   349: aload_0
    //   350: invokevirtual 264	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   353: new 87	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   360: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   363: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: invokestatic 131	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 272	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   379: astore 10
    //   381: aload 24
    //   383: astore_0
    //   384: aload 10
    //   386: ifnull +58 -> 444
    //   389: aload 11
    //   391: astore 15
    //   393: aload 10
    //   395: astore 13
    //   397: aload 22
    //   399: astore 17
    //   401: aload 11
    //   403: astore 14
    //   405: aload 10
    //   407: astore 12
    //   409: aload 23
    //   411: astore 16
    //   413: new 274	java/io/FileOutputStream
    //   416: dup
    //   417: new 87	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   424: aload 31
    //   426: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokestatic 131	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   433: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: iconst_1
    //   440: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   443: astore_0
    //   444: lconst_0
    //   445: lstore 6
    //   447: aload 11
    //   449: astore 15
    //   451: aload 10
    //   453: astore 13
    //   455: aload_0
    //   456: astore 17
    //   458: aload 11
    //   460: astore 14
    //   462: aload 10
    //   464: astore 12
    //   466: aload_0
    //   467: astore 16
    //   469: sipush 2048
    //   472: newarray byte
    //   474: astore_1
    //   475: lload 6
    //   477: lstore 8
    //   479: aload 10
    //   481: ifnull +223 -> 704
    //   484: aload 11
    //   486: astore 15
    //   488: aload 10
    //   490: astore 13
    //   492: aload_0
    //   493: astore 17
    //   495: aload 11
    //   497: astore 14
    //   499: aload 10
    //   501: astore 12
    //   503: aload_0
    //   504: astore 16
    //   506: aload 10
    //   508: aload_1
    //   509: iconst_0
    //   510: aload_1
    //   511: arraylength
    //   512: invokevirtual 283	java/io/InputStream:read	([BII)I
    //   515: istore_3
    //   516: lload 6
    //   518: lstore 8
    //   520: iload_3
    //   521: iconst_m1
    //   522: if_icmpeq +182 -> 704
    //   525: aload 11
    //   527: astore 15
    //   529: aload 10
    //   531: astore 13
    //   533: aload_0
    //   534: astore 17
    //   536: aload 11
    //   538: astore 14
    //   540: aload 10
    //   542: astore 12
    //   544: aload_0
    //   545: astore 16
    //   547: aload_0
    //   548: aload_1
    //   549: iconst_0
    //   550: iload_3
    //   551: invokevirtual 289	java/io/OutputStream:write	([BII)V
    //   554: lload 6
    //   556: iload_3
    //   557: i2l
    //   558: ladd
    //   559: lstore 6
    //   561: goto -86 -> 475
    //   564: astore 10
    //   566: aconst_null
    //   567: astore 12
    //   569: aconst_null
    //   570: astore 13
    //   572: aload 25
    //   574: astore 15
    //   576: aload 22
    //   578: astore 17
    //   580: aload 26
    //   582: astore 14
    //   584: aload 23
    //   586: astore 16
    //   588: aload_0
    //   589: invokevirtual 264	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   592: new 87	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   599: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   602: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_1
    //   606: invokestatic 131	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   609: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 291
    //   615: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokevirtual 272	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   624: astore 18
    //   626: aload 18
    //   628: astore 10
    //   630: aload 18
    //   632: ifnull -251 -> 381
    //   635: aload 25
    //   637: astore 15
    //   639: aload 18
    //   641: astore 13
    //   643: aload 22
    //   645: astore 17
    //   647: aload 26
    //   649: astore 14
    //   651: aload 18
    //   653: astore 12
    //   655: aload 23
    //   657: astore 16
    //   659: aload_0
    //   660: invokevirtual 264	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   663: new 87	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   670: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   673: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_1
    //   677: invokestatic 131	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 293
    //   686: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokevirtual 272	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   695: astore 11
    //   697: aload 18
    //   699: astore 10
    //   701: goto -320 -> 381
    //   704: aload 11
    //   706: ifnull +79 -> 785
    //   709: aload 11
    //   711: astore 15
    //   713: aload 10
    //   715: astore 13
    //   717: aload_0
    //   718: astore 17
    //   720: aload 11
    //   722: astore 14
    //   724: aload 10
    //   726: astore 12
    //   728: aload_0
    //   729: astore 16
    //   731: aload 11
    //   733: aload_1
    //   734: iconst_0
    //   735: aload_1
    //   736: arraylength
    //   737: invokevirtual 283	java/io/InputStream:read	([BII)I
    //   740: istore_3
    //   741: iload_3
    //   742: iconst_m1
    //   743: if_icmpeq +42 -> 785
    //   746: aload 11
    //   748: astore 15
    //   750: aload 10
    //   752: astore 13
    //   754: aload_0
    //   755: astore 17
    //   757: aload 11
    //   759: astore 14
    //   761: aload 10
    //   763: astore 12
    //   765: aload_0
    //   766: astore 16
    //   768: aload_0
    //   769: aload_1
    //   770: iconst_0
    //   771: iload_3
    //   772: invokevirtual 289	java/io/OutputStream:write	([BII)V
    //   775: lload 8
    //   777: iload_3
    //   778: i2l
    //   779: ladd
    //   780: lstore 8
    //   782: goto -78 -> 704
    //   785: aload 11
    //   787: astore 15
    //   789: aload 10
    //   791: astore 13
    //   793: aload_0
    //   794: astore 17
    //   796: aload 11
    //   798: astore 14
    //   800: aload 10
    //   802: astore 12
    //   804: aload_0
    //   805: astore 16
    //   807: aload 11
    //   809: astore 18
    //   811: aload 10
    //   813: astore 19
    //   815: aload_0
    //   816: astore 20
    //   818: aload 30
    //   820: invokevirtual 209	java/io/File:exists	()Z
    //   823: ifeq +443 -> 1266
    //   826: aload 11
    //   828: astore 15
    //   830: aload 10
    //   832: astore 13
    //   834: aload_0
    //   835: astore 17
    //   837: aload 11
    //   839: astore 14
    //   841: aload 10
    //   843: astore 12
    //   845: aload_0
    //   846: astore 16
    //   848: lload 8
    //   850: aload 30
    //   852: invokevirtual 296	java/io/File:length	()J
    //   855: lcmp
    //   856: ifeq +154 -> 1010
    //   859: aload 11
    //   861: astore 15
    //   863: aload 10
    //   865: astore 13
    //   867: aload_0
    //   868: astore 17
    //   870: aload 11
    //   872: astore 14
    //   874: aload 10
    //   876: astore 12
    //   878: aload_0
    //   879: astore 16
    //   881: aload 30
    //   883: invokevirtual 257	java/io/File:delete	()Z
    //   886: pop
    //   887: aload 11
    //   889: astore 15
    //   891: aload 10
    //   893: astore 13
    //   895: aload_0
    //   896: astore 17
    //   898: aload 11
    //   900: astore 14
    //   902: aload 10
    //   904: astore 12
    //   906: aload_0
    //   907: astore 16
    //   909: new 87	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   916: ldc 85
    //   918: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: ldc_w 298
    //   924: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: astore 18
    //   932: aload 11
    //   934: astore 14
    //   936: aload 10
    //   938: astore 12
    //   940: aload_0
    //   941: astore 16
    //   943: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   946: ifeq +314 -> 1260
    //   949: aload 11
    //   951: astore 14
    //   953: aload 10
    //   955: astore 12
    //   957: aload_0
    //   958: astore 16
    //   960: ldc 11
    //   962: iconst_2
    //   963: aload 18
    //   965: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: iconst_0
    //   969: istore 4
    //   971: aload_0
    //   972: ifnull +7 -> 979
    //   975: aload_0
    //   976: invokevirtual 301	java/io/OutputStream:close	()V
    //   979: aload 10
    //   981: ifnull +8 -> 989
    //   984: aload 10
    //   986: invokevirtual 302	java/io/InputStream:close	()V
    //   989: iload 4
    //   991: istore 5
    //   993: aload 11
    //   995: ifnull -876 -> 119
    //   998: aload 11
    //   1000: invokevirtual 302	java/io/InputStream:close	()V
    //   1003: iload 4
    //   1005: ireturn
    //   1006: astore_0
    //   1007: iload 4
    //   1009: ireturn
    //   1010: iload_2
    //   1011: ifne +49 -> 1060
    //   1014: aload 11
    //   1016: astore 15
    //   1018: aload 10
    //   1020: astore 13
    //   1022: aload_0
    //   1023: astore 17
    //   1025: aload 11
    //   1027: astore 14
    //   1029: aload 10
    //   1031: astore 12
    //   1033: aload_0
    //   1034: astore 16
    //   1036: aload 28
    //   1038: invokeinterface 55 1 0
    //   1043: aload 29
    //   1045: iconst_m1
    //   1046: invokeinterface 306 3 0
    //   1051: invokeinterface 65 1 0
    //   1056: pop
    //   1057: goto +228 -> 1285
    //   1060: aload 11
    //   1062: astore 15
    //   1064: aload 10
    //   1066: astore 13
    //   1068: aload_0
    //   1069: astore 17
    //   1071: aload 11
    //   1073: astore 14
    //   1075: aload 10
    //   1077: astore 12
    //   1079: aload_0
    //   1080: astore 16
    //   1082: aload 28
    //   1084: invokeinterface 55 1 0
    //   1089: aload 29
    //   1091: iload_2
    //   1092: invokeinterface 306 3 0
    //   1097: invokeinterface 65 1 0
    //   1102: pop
    //   1103: goto +182 -> 1285
    //   1106: astore_1
    //   1107: aload 21
    //   1109: astore 18
    //   1111: aload 17
    //   1113: astore_0
    //   1114: aload 13
    //   1116: astore 10
    //   1118: aload 15
    //   1120: astore 11
    //   1122: iconst_0
    //   1123: istore 5
    //   1125: aload 11
    //   1127: astore 14
    //   1129: aload 10
    //   1131: astore 12
    //   1133: aload_0
    //   1134: astore 16
    //   1136: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1139: ifeq +23 -> 1162
    //   1142: aload 11
    //   1144: astore 14
    //   1146: aload 10
    //   1148: astore 12
    //   1150: aload_0
    //   1151: astore 16
    //   1153: ldc 11
    //   1155: iconst_2
    //   1156: aload 18
    //   1158: aload_1
    //   1159: invokestatic 309	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1162: aload_0
    //   1163: ifnull +7 -> 1170
    //   1166: aload_0
    //   1167: invokevirtual 301	java/io/OutputStream:close	()V
    //   1170: aload 10
    //   1172: ifnull +8 -> 1180
    //   1175: aload 10
    //   1177: invokevirtual 302	java/io/InputStream:close	()V
    //   1180: aload 11
    //   1182: ifnull -1063 -> 119
    //   1185: aload 11
    //   1187: invokevirtual 302	java/io/InputStream:close	()V
    //   1190: iconst_0
    //   1191: ireturn
    //   1192: astore_0
    //   1193: iconst_0
    //   1194: ireturn
    //   1195: astore_0
    //   1196: aload 16
    //   1198: ifnull +8 -> 1206
    //   1201: aload 16
    //   1203: invokevirtual 301	java/io/OutputStream:close	()V
    //   1206: aload 12
    //   1208: ifnull +8 -> 1216
    //   1211: aload 12
    //   1213: invokevirtual 302	java/io/InputStream:close	()V
    //   1216: aload 14
    //   1218: ifnull +8 -> 1226
    //   1221: aload 14
    //   1223: invokevirtual 302	java/io/InputStream:close	()V
    //   1226: aload_0
    //   1227: athrow
    //   1228: astore_0
    //   1229: goto -250 -> 979
    //   1232: astore_0
    //   1233: goto -244 -> 989
    //   1236: astore_0
    //   1237: goto -67 -> 1170
    //   1240: astore_0
    //   1241: goto -61 -> 1180
    //   1244: astore_1
    //   1245: goto -39 -> 1206
    //   1248: astore_1
    //   1249: goto -33 -> 1216
    //   1252: astore_1
    //   1253: goto -27 -> 1226
    //   1256: astore_1
    //   1257: goto -135 -> 1122
    //   1260: iconst_0
    //   1261: istore 4
    //   1263: goto -292 -> 971
    //   1266: iconst_0
    //   1267: istore 4
    //   1269: aload 18
    //   1271: astore 11
    //   1273: aload 19
    //   1275: astore 10
    //   1277: aload 20
    //   1279: astore_0
    //   1280: goto -309 -> 971
    //   1283: iconst_0
    //   1284: ireturn
    //   1285: iconst_1
    //   1286: istore 4
    //   1288: goto -317 -> 971
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1291	0	paramContext	Context
    //   0	1291	1	paramString	String
    //   17	1075	2	i	int
    //   53	725	3	j	int
    //   318	969	4	bool1	boolean
    //   117	1007	5	bool2	boolean
    //   445	115	6	l1	long
    //   477	372	8	l2	long
    //   122	1	10	localNumberFormatException	java.lang.NumberFormatException
    //   208	333	10	localInputStream	java.io.InputStream
    //   564	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   628	648	10	localObject1	Object
    //   220	1052	11	localObject2	Object
    //   240	972	12	localObject3	Object
    //   228	887	13	localObject4	Object
    //   236	986	14	localObject5	Object
    //   224	895	15	localObject6	Object
    //   244	958	16	localObject7	Object
    //   232	880	17	localObject8	Object
    //   217	1053	18	localObject9	Object
    //   205	1069	19	localObject10	Object
    //   196	1082	20	localContext	Context
    //   41	1067	21	str1	String
    //   190	454	22	localObject11	Object
    //   193	463	23	localObject12	Object
    //   199	183	24	localObject13	Object
    //   211	425	25	localObject14	Object
    //   214	434	26	localObject15	Object
    //   202	140	27	localObject16	Object
    //   7	1076	28	localSharedPreferences	SharedPreferences
    //   37	1053	29	str2	String
    //   158	724	30	localFile1	File
    //   106	319	31	str3	String
    //   255	59	32	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	18	122	java/lang/NumberFormatException
    //   349	381	564	java/io/FileNotFoundException
    //   998	1003	1006	java/io/IOException
    //   246	257	1106	java/io/IOException
    //   281	289	1106	java/io/IOException
    //   313	320	1106	java/io/IOException
    //   349	381	1106	java/io/IOException
    //   413	444	1106	java/io/IOException
    //   469	475	1106	java/io/IOException
    //   506	516	1106	java/io/IOException
    //   547	554	1106	java/io/IOException
    //   588	626	1106	java/io/IOException
    //   659	697	1106	java/io/IOException
    //   731	741	1106	java/io/IOException
    //   768	775	1106	java/io/IOException
    //   818	826	1106	java/io/IOException
    //   848	859	1106	java/io/IOException
    //   881	887	1106	java/io/IOException
    //   909	932	1106	java/io/IOException
    //   1036	1057	1106	java/io/IOException
    //   1082	1103	1106	java/io/IOException
    //   1185	1190	1192	java/io/IOException
    //   246	257	1195	finally
    //   281	289	1195	finally
    //   313	320	1195	finally
    //   349	381	1195	finally
    //   413	444	1195	finally
    //   469	475	1195	finally
    //   506	516	1195	finally
    //   547	554	1195	finally
    //   588	626	1195	finally
    //   659	697	1195	finally
    //   731	741	1195	finally
    //   768	775	1195	finally
    //   818	826	1195	finally
    //   848	859	1195	finally
    //   881	887	1195	finally
    //   909	932	1195	finally
    //   943	949	1195	finally
    //   960	968	1195	finally
    //   1036	1057	1195	finally
    //   1082	1103	1195	finally
    //   1136	1142	1195	finally
    //   1153	1162	1195	finally
    //   975	979	1228	java/io/IOException
    //   984	989	1232	java/io/IOException
    //   1166	1170	1236	java/io/IOException
    //   1175	1180	1240	java/io/IOException
    //   1201	1206	1244	java/io/IOException
    //   1211	1216	1248	java/io/IOException
    //   1221	1226	1252	java/io/IOException
    //   943	949	1256	java/io/IOException
    //   960	968	1256	java/io/IOException
  }
  
  protected boolean a()
  {
    a();
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateAvSo
 * JD-Core Version:    0.7.0.1
 */