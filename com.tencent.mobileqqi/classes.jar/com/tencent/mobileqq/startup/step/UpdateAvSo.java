package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
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
  
  private static String a()
  {
    return "lib/armeabi/";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    b(localBaseApplicationImpl, "VideoCtrl");
    b(localBaseApplicationImpl, "qq_sharp");
    b(localBaseApplicationImpl, "traeimp-armeabi-v7a");
    b(localBaseApplicationImpl, "qav_graphics");
    b(localBaseApplicationImpl, "qav_gaudio_engine");
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/"; new File(paramContext + a("TcVp8Codec")).exists(); paramContext = paramContext.getApplicationInfo().dataDir + "/lib/") {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVModuleExtract", 2, "fail to find codec so in lib");
    }
    return false;
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
        b(paramContext, paramString);
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
  
  /* Error */
  public static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 8
    //   3: iconst_0
    //   4: invokevirtual 163	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 28
    //   9: ldc 165
    //   11: invokestatic 171	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   14: invokevirtual 175	java/lang/Integer:intValue	()I
    //   17: istore_2
    //   18: new 26	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   25: ldc 14
    //   27: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 29
    //   39: ldc 148
    //   41: astore 21
    //   43: aload 28
    //   45: aload 29
    //   47: iconst_m1
    //   48: invokeinterface 181 3 0
    //   53: istore_3
    //   54: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +46 -> 103
    //   60: ldc 11
    //   62: iconst_2
    //   63: new 26	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   70: ldc 183
    //   72: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 185
    //   81: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc 190
    //   90: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_2
    //   94: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload_3
    //   104: iload_2
    //   105: if_icmpeq +1149 -> 1254
    //   108: new 26	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokevirtual 120	android/content/Context:getFilesDir	()Ljava/io/File;
    //   119: invokevirtual 123	java/io/File:getParent	()Ljava/lang/String;
    //   122: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 125
    //   127: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 31
    //   135: new 81	java/io/File
    //   138: dup
    //   139: new 26	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   146: aload 31
    //   148: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokestatic 85	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore 30
    //   166: aload 30
    //   168: invokevirtual 193	java/io/File:delete	()Z
    //   171: pop
    //   172: aload 30
    //   174: invokevirtual 92	java/io/File:exists	()Z
    //   177: ifne +1138 -> 1315
    //   180: aconst_null
    //   181: astore 22
    //   183: aconst_null
    //   184: astore 23
    //   186: aconst_null
    //   187: astore 20
    //   189: aconst_null
    //   190: astore 24
    //   192: aconst_null
    //   193: astore 27
    //   195: aconst_null
    //   196: astore 19
    //   198: aconst_null
    //   199: astore 10
    //   201: aconst_null
    //   202: astore 25
    //   204: aconst_null
    //   205: astore 26
    //   207: aconst_null
    //   208: astore 18
    //   210: aconst_null
    //   211: astore 11
    //   213: aload 25
    //   215: astore 15
    //   217: aload 10
    //   219: astore 13
    //   221: aload 22
    //   223: astore 17
    //   225: aload 26
    //   227: astore 14
    //   229: aload 27
    //   231: astore 12
    //   233: aload 23
    //   235: astore 16
    //   237: new 81	java/io/File
    //   240: dup
    //   241: aload 31
    //   243: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore 32
    //   248: aload 25
    //   250: astore 15
    //   252: aload 10
    //   254: astore 13
    //   256: aload 22
    //   258: astore 17
    //   260: aload 26
    //   262: astore 14
    //   264: aload 27
    //   266: astore 12
    //   268: aload 23
    //   270: astore 16
    //   272: aload 32
    //   274: invokevirtual 92	java/io/File:exists	()Z
    //   277: ifne +39 -> 316
    //   280: aload 25
    //   282: astore 15
    //   284: aload 10
    //   286: astore 13
    //   288: aload 22
    //   290: astore 17
    //   292: aload 26
    //   294: astore 14
    //   296: aload 27
    //   298: astore 12
    //   300: aload 23
    //   302: astore 16
    //   304: aload 32
    //   306: invokevirtual 196	java/io/File:mkdir	()Z
    //   309: istore 4
    //   311: iload 4
    //   313: ifeq +985 -> 1298
    //   316: aload 25
    //   318: astore 15
    //   320: aload 10
    //   322: astore 13
    //   324: aload 22
    //   326: astore 17
    //   328: aload 26
    //   330: astore 14
    //   332: aload 27
    //   334: astore 12
    //   336: aload 23
    //   338: astore 16
    //   340: aload_0
    //   341: invokevirtual 200	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   344: new 26	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   351: invokestatic 202	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   354: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokestatic 85	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 208	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   370: astore 10
    //   372: aload 24
    //   374: astore_0
    //   375: aload 10
    //   377: ifnull +58 -> 435
    //   380: aload 11
    //   382: astore 15
    //   384: aload 10
    //   386: astore 13
    //   388: aload 22
    //   390: astore 17
    //   392: aload 11
    //   394: astore 14
    //   396: aload 10
    //   398: astore 12
    //   400: aload 23
    //   402: astore 16
    //   404: new 210	java/io/FileOutputStream
    //   407: dup
    //   408: new 26	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   415: aload 31
    //   417: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokestatic 85	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   424: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: iconst_1
    //   431: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   434: astore_0
    //   435: lconst_0
    //   436: lstore 6
    //   438: aload 11
    //   440: astore 15
    //   442: aload 10
    //   444: astore 13
    //   446: aload_0
    //   447: astore 17
    //   449: aload 11
    //   451: astore 14
    //   453: aload 10
    //   455: astore 12
    //   457: aload_0
    //   458: astore 16
    //   460: sipush 2048
    //   463: newarray byte
    //   465: astore_1
    //   466: lload 6
    //   468: lstore 8
    //   470: aload 10
    //   472: ifnull +221 -> 693
    //   475: aload 11
    //   477: astore 15
    //   479: aload 10
    //   481: astore 13
    //   483: aload_0
    //   484: astore 17
    //   486: aload 11
    //   488: astore 14
    //   490: aload 10
    //   492: astore 12
    //   494: aload_0
    //   495: astore 16
    //   497: aload 10
    //   499: aload_1
    //   500: iconst_0
    //   501: aload_1
    //   502: arraylength
    //   503: invokevirtual 219	java/io/InputStream:read	([BII)I
    //   506: istore_3
    //   507: lload 6
    //   509: lstore 8
    //   511: iload_3
    //   512: iconst_m1
    //   513: if_icmpeq +180 -> 693
    //   516: aload 11
    //   518: astore 15
    //   520: aload 10
    //   522: astore 13
    //   524: aload_0
    //   525: astore 17
    //   527: aload 11
    //   529: astore 14
    //   531: aload 10
    //   533: astore 12
    //   535: aload_0
    //   536: astore 16
    //   538: aload_0
    //   539: aload_1
    //   540: iconst_0
    //   541: iload_3
    //   542: invokevirtual 225	java/io/OutputStream:write	([BII)V
    //   545: lload 6
    //   547: iload_3
    //   548: i2l
    //   549: ladd
    //   550: lstore 6
    //   552: goto -86 -> 466
    //   555: astore 10
    //   557: aconst_null
    //   558: astore 12
    //   560: aconst_null
    //   561: astore 13
    //   563: aload 25
    //   565: astore 15
    //   567: aload 22
    //   569: astore 17
    //   571: aload 26
    //   573: astore 14
    //   575: aload 23
    //   577: astore 16
    //   579: aload_0
    //   580: invokevirtual 200	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   583: new 26	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   590: invokestatic 202	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   593: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokestatic 85	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   600: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: ldc 227
    //   605: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokevirtual 208	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   614: astore 18
    //   616: aload 18
    //   618: astore 10
    //   620: aload 18
    //   622: ifnull -250 -> 372
    //   625: aload 25
    //   627: astore 15
    //   629: aload 18
    //   631: astore 13
    //   633: aload 22
    //   635: astore 17
    //   637: aload 26
    //   639: astore 14
    //   641: aload 18
    //   643: astore 12
    //   645: aload 23
    //   647: astore 16
    //   649: aload_0
    //   650: invokevirtual 200	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   653: new 26	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   660: invokestatic 202	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   663: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_1
    //   667: invokestatic 85	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   670: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc 229
    //   675: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokevirtual 208	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   684: astore 11
    //   686: aload 18
    //   688: astore 10
    //   690: goto -318 -> 372
    //   693: aload 11
    //   695: ifnull +79 -> 774
    //   698: aload 11
    //   700: astore 15
    //   702: aload 10
    //   704: astore 13
    //   706: aload_0
    //   707: astore 17
    //   709: aload 11
    //   711: astore 14
    //   713: aload 10
    //   715: astore 12
    //   717: aload_0
    //   718: astore 16
    //   720: aload 11
    //   722: aload_1
    //   723: iconst_0
    //   724: aload_1
    //   725: arraylength
    //   726: invokevirtual 219	java/io/InputStream:read	([BII)I
    //   729: istore_3
    //   730: iload_3
    //   731: iconst_m1
    //   732: if_icmpeq +42 -> 774
    //   735: aload 11
    //   737: astore 15
    //   739: aload 10
    //   741: astore 13
    //   743: aload_0
    //   744: astore 17
    //   746: aload 11
    //   748: astore 14
    //   750: aload 10
    //   752: astore 12
    //   754: aload_0
    //   755: astore 16
    //   757: aload_0
    //   758: aload_1
    //   759: iconst_0
    //   760: iload_3
    //   761: invokevirtual 225	java/io/OutputStream:write	([BII)V
    //   764: lload 8
    //   766: iload_3
    //   767: i2l
    //   768: ladd
    //   769: lstore 8
    //   771: goto -78 -> 693
    //   774: aload 11
    //   776: astore 15
    //   778: aload 10
    //   780: astore 13
    //   782: aload_0
    //   783: astore 17
    //   785: aload 11
    //   787: astore 14
    //   789: aload 10
    //   791: astore 12
    //   793: aload_0
    //   794: astore 16
    //   796: aload 11
    //   798: astore 18
    //   800: aload 10
    //   802: astore 19
    //   804: aload_0
    //   805: astore 20
    //   807: aload 30
    //   809: invokevirtual 92	java/io/File:exists	()Z
    //   812: ifeq +486 -> 1298
    //   815: aload 11
    //   817: astore 15
    //   819: aload 10
    //   821: astore 13
    //   823: aload_0
    //   824: astore 17
    //   826: aload 11
    //   828: astore 14
    //   830: aload 10
    //   832: astore 12
    //   834: aload_0
    //   835: astore 16
    //   837: lload 8
    //   839: aload 30
    //   841: invokevirtual 233	java/io/File:length	()J
    //   844: lcmp
    //   845: ifeq +153 -> 998
    //   848: aload 11
    //   850: astore 15
    //   852: aload 10
    //   854: astore 13
    //   856: aload_0
    //   857: astore 17
    //   859: aload 11
    //   861: astore 14
    //   863: aload 10
    //   865: astore 12
    //   867: aload_0
    //   868: astore 16
    //   870: aload 30
    //   872: invokevirtual 193	java/io/File:delete	()Z
    //   875: pop
    //   876: aload 11
    //   878: astore 15
    //   880: aload 10
    //   882: astore 13
    //   884: aload_0
    //   885: astore 17
    //   887: aload 11
    //   889: astore 14
    //   891: aload 10
    //   893: astore 12
    //   895: aload_0
    //   896: astore 16
    //   898: new 26	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   905: ldc 148
    //   907: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: ldc 235
    //   912: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: astore 18
    //   920: aload 11
    //   922: astore 14
    //   924: aload 10
    //   926: astore 12
    //   928: aload_0
    //   929: astore 16
    //   931: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +358 -> 1292
    //   937: aload 11
    //   939: astore 14
    //   941: aload 10
    //   943: astore 12
    //   945: aload_0
    //   946: astore 16
    //   948: ldc 11
    //   950: iconst_2
    //   951: aload 18
    //   953: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   956: iconst_0
    //   957: istore 4
    //   959: aload_0
    //   960: ifnull +7 -> 967
    //   963: aload_0
    //   964: invokevirtual 240	java/io/OutputStream:close	()V
    //   967: aload 10
    //   969: ifnull +8 -> 977
    //   972: aload 10
    //   974: invokevirtual 241	java/io/InputStream:close	()V
    //   977: iload 4
    //   979: istore 5
    //   981: aload 11
    //   983: ifnull +12 -> 995
    //   986: aload 11
    //   988: invokevirtual 241	java/io/InputStream:close	()V
    //   991: iload 4
    //   993: istore 5
    //   995: iload 5
    //   997: ireturn
    //   998: iload_2
    //   999: ifne +49 -> 1048
    //   1002: aload 11
    //   1004: astore 15
    //   1006: aload 10
    //   1008: astore 13
    //   1010: aload_0
    //   1011: astore 17
    //   1013: aload 11
    //   1015: astore 14
    //   1017: aload 10
    //   1019: astore 12
    //   1021: aload_0
    //   1022: astore 16
    //   1024: aload 28
    //   1026: invokeinterface 245 1 0
    //   1031: aload 29
    //   1033: iconst_m1
    //   1034: invokeinterface 251 3 0
    //   1039: invokeinterface 254 1 0
    //   1044: pop
    //   1045: goto +279 -> 1324
    //   1048: aload 11
    //   1050: astore 15
    //   1052: aload 10
    //   1054: astore 13
    //   1056: aload_0
    //   1057: astore 17
    //   1059: aload 11
    //   1061: astore 14
    //   1063: aload 10
    //   1065: astore 12
    //   1067: aload_0
    //   1068: astore 16
    //   1070: aload 28
    //   1072: invokeinterface 245 1 0
    //   1077: aload 29
    //   1079: iload_2
    //   1080: invokeinterface 251 3 0
    //   1085: invokeinterface 254 1 0
    //   1090: pop
    //   1091: goto +233 -> 1324
    //   1094: astore_1
    //   1095: aload 21
    //   1097: astore 18
    //   1099: aload 17
    //   1101: astore_0
    //   1102: aload 13
    //   1104: astore 10
    //   1106: aload 15
    //   1108: astore 11
    //   1110: iconst_0
    //   1111: istore 5
    //   1113: aload 11
    //   1115: astore 14
    //   1117: aload 10
    //   1119: astore 12
    //   1121: aload_0
    //   1122: astore 16
    //   1124: new 26	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   1131: aload 18
    //   1133: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: ldc_w 256
    //   1139: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: aload_1
    //   1143: invokestatic 262	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1146: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: astore_1
    //   1153: aload 11
    //   1155: astore 14
    //   1157: aload 10
    //   1159: astore 12
    //   1161: aload_0
    //   1162: astore 16
    //   1164: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1167: ifeq +21 -> 1188
    //   1170: aload 11
    //   1172: astore 14
    //   1174: aload 10
    //   1176: astore 12
    //   1178: aload_0
    //   1179: astore 16
    //   1181: ldc 11
    //   1183: iconst_2
    //   1184: aload_1
    //   1185: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: aload_0
    //   1189: ifnull +7 -> 1196
    //   1192: aload_0
    //   1193: invokevirtual 240	java/io/OutputStream:close	()V
    //   1196: aload 10
    //   1198: ifnull +8 -> 1206
    //   1201: aload 10
    //   1203: invokevirtual 241	java/io/InputStream:close	()V
    //   1206: aload 11
    //   1208: ifnull -213 -> 995
    //   1211: aload 11
    //   1213: invokevirtual 241	java/io/InputStream:close	()V
    //   1216: iconst_0
    //   1217: ireturn
    //   1218: astore_0
    //   1219: iconst_0
    //   1220: ireturn
    //   1221: astore_0
    //   1222: aload 16
    //   1224: ifnull +8 -> 1232
    //   1227: aload 16
    //   1229: invokevirtual 240	java/io/OutputStream:close	()V
    //   1232: aload 12
    //   1234: ifnull +8 -> 1242
    //   1237: aload 12
    //   1239: invokevirtual 241	java/io/InputStream:close	()V
    //   1242: aload 14
    //   1244: ifnull +8 -> 1252
    //   1247: aload 14
    //   1249: invokevirtual 241	java/io/InputStream:close	()V
    //   1252: aload_0
    //   1253: athrow
    //   1254: iconst_1
    //   1255: ireturn
    //   1256: astore_0
    //   1257: goto -290 -> 967
    //   1260: astore_0
    //   1261: goto -284 -> 977
    //   1264: astore_0
    //   1265: iload 4
    //   1267: ireturn
    //   1268: astore_0
    //   1269: goto -73 -> 1196
    //   1272: astore_0
    //   1273: goto -67 -> 1206
    //   1276: astore_1
    //   1277: goto -45 -> 1232
    //   1280: astore_1
    //   1281: goto -39 -> 1242
    //   1284: astore_1
    //   1285: goto -33 -> 1252
    //   1288: astore_1
    //   1289: goto -179 -> 1110
    //   1292: iconst_0
    //   1293: istore 4
    //   1295: goto -336 -> 959
    //   1298: iconst_0
    //   1299: istore 4
    //   1301: aload 18
    //   1303: astore 11
    //   1305: aload 19
    //   1307: astore 10
    //   1309: aload 20
    //   1311: astore_0
    //   1312: goto -353 -> 959
    //   1315: iconst_0
    //   1316: ireturn
    //   1317: astore 10
    //   1319: iconst_0
    //   1320: istore_2
    //   1321: goto -1303 -> 18
    //   1324: iconst_1
    //   1325: istore 4
    //   1327: goto -368 -> 959
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1330	0	paramContext	Context
    //   0	1330	1	paramString	String
    //   17	1304	2	i	int
    //   53	714	3	j	int
    //   309	1017	4	bool1	boolean
    //   979	133	5	bool2	boolean
    //   436	115	6	l1	long
    //   468	370	8	l2	long
    //   199	333	10	localInputStream	java.io.InputStream
    //   555	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   618	690	10	localObject1	java.lang.Object
    //   1317	1	10	localNumberFormatException	java.lang.NumberFormatException
    //   211	1093	11	localObject2	java.lang.Object
    //   231	1007	12	localObject3	java.lang.Object
    //   219	884	13	localObject4	java.lang.Object
    //   227	1021	14	localObject5	java.lang.Object
    //   215	892	15	localObject6	java.lang.Object
    //   235	993	16	localObject7	java.lang.Object
    //   223	877	17	localObject8	java.lang.Object
    //   208	1094	18	localObject9	java.lang.Object
    //   196	1110	19	localObject10	java.lang.Object
    //   187	1123	20	localContext	Context
    //   41	1055	21	str1	String
    //   181	453	22	localObject11	java.lang.Object
    //   184	462	23	localObject12	java.lang.Object
    //   190	183	24	localObject13	java.lang.Object
    //   202	424	25	localObject14	java.lang.Object
    //   205	433	26	localObject15	java.lang.Object
    //   193	140	27	localObject16	java.lang.Object
    //   7	1064	28	localSharedPreferences	android.content.SharedPreferences
    //   37	1041	29	str2	String
    //   164	707	30	localFile1	File
    //   133	283	31	str3	String
    //   246	59	32	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   340	372	555	java/io/FileNotFoundException
    //   237	248	1094	java/io/IOException
    //   272	280	1094	java/io/IOException
    //   304	311	1094	java/io/IOException
    //   340	372	1094	java/io/IOException
    //   404	435	1094	java/io/IOException
    //   460	466	1094	java/io/IOException
    //   497	507	1094	java/io/IOException
    //   538	545	1094	java/io/IOException
    //   579	616	1094	java/io/IOException
    //   649	686	1094	java/io/IOException
    //   720	730	1094	java/io/IOException
    //   757	764	1094	java/io/IOException
    //   807	815	1094	java/io/IOException
    //   837	848	1094	java/io/IOException
    //   870	876	1094	java/io/IOException
    //   898	920	1094	java/io/IOException
    //   1024	1045	1094	java/io/IOException
    //   1070	1091	1094	java/io/IOException
    //   1211	1216	1218	java/io/IOException
    //   237	248	1221	finally
    //   272	280	1221	finally
    //   304	311	1221	finally
    //   340	372	1221	finally
    //   404	435	1221	finally
    //   460	466	1221	finally
    //   497	507	1221	finally
    //   538	545	1221	finally
    //   579	616	1221	finally
    //   649	686	1221	finally
    //   720	730	1221	finally
    //   757	764	1221	finally
    //   807	815	1221	finally
    //   837	848	1221	finally
    //   870	876	1221	finally
    //   898	920	1221	finally
    //   931	937	1221	finally
    //   948	956	1221	finally
    //   1024	1045	1221	finally
    //   1070	1091	1221	finally
    //   1124	1153	1221	finally
    //   1164	1170	1221	finally
    //   1181	1188	1221	finally
    //   963	967	1256	java/io/IOException
    //   972	977	1260	java/io/IOException
    //   986	991	1264	java/io/IOException
    //   1192	1196	1268	java/io/IOException
    //   1201	1206	1272	java/io/IOException
    //   1227	1232	1276	java/io/IOException
    //   1237	1242	1280	java/io/IOException
    //   1247	1252	1284	java/io/IOException
    //   931	937	1288	java/io/IOException
    //   948	956	1288	java/io/IOException
    //   9	18	1317	java/lang/NumberFormatException
  }
  
  protected boolean a()
  {
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateAvSo
 * JD-Core Version:    0.7.0.1
 */