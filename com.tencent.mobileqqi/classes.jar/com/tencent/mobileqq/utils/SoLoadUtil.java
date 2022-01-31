package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SoLoadUtil
{
  private static final int jdField_a_of_type_Int = 5;
  private static final String jdField_a_of_type_JavaLangString = "SoLoadUtil";
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static final String b = "so_load_sp";
  private static final String c = "so_sp";
  private static final String d = "key_so_crc";
  private static final String e = "key_so_version_";
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add("libamrnb.so");
    jdField_a_of_type_JavaUtilSet.add("libSync_mq.so");
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 63
    //   14: invokevirtual 69	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 63
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 71
    //   35: invokevirtual 69	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 73
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: ldc 75
    //   49: astore_0
    //   50: goto -27 -> 23
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	44	0	str	String
    //   53	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	53	finally
    //   11	20	53	finally
    //   32	41	53	finally
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/armeabi/";
    }
    return "lib/" + a() + "/";
  }
  
  private static final HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static final void a(HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplication.getContext()).a("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap paramHashMap, int paramInt, String paramString)
  {
    paramHashMap.put("message", paramString);
    StatisticCollector.a(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, false);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 78	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   16: ldc 195
    //   18: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_1
    //   32: invokestatic 200	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   35: astore 23
    //   37: ldc 110
    //   39: astore 14
    //   41: iconst_0
    //   42: istore 8
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_0
    //   48: istore_2
    //   49: aload_0
    //   50: astore 13
    //   52: aload_0
    //   53: ifnonnull +8 -> 61
    //   56: invokestatic 203	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   59: astore 13
    //   61: new 78	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   68: aload 13
    //   70: invokevirtual 209	android/content/Context:getFilesDir	()Ljava/io/File;
    //   73: invokevirtual 214	java/io/File:getParent	()Ljava/lang/String;
    //   76: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 216
    //   81: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 27
    //   89: new 78	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   96: aload 13
    //   98: invokevirtual 209	android/content/Context:getFilesDir	()Ljava/io/File;
    //   101: invokevirtual 214	java/io/File:getParent	()Ljava/lang/String;
    //   104: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 218
    //   109: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 15
    //   117: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +11 -> 131
    //   123: ldc 10
    //   125: iconst_2
    //   126: ldc 220
    //   128: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 8
    //   133: istore 6
    //   135: aload 14
    //   137: astore_0
    //   138: iload_3
    //   139: ifeq +131 -> 270
    //   142: new 211	java/io/File
    //   145: dup
    //   146: new 78	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   153: aload 15
    //   155: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokestatic 222	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 226	java/io/File:exists	()Z
    //   176: ifeq +756 -> 932
    //   179: iload 7
    //   181: istore_3
    //   182: aload_0
    //   183: invokevirtual 229	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   186: invokestatic 232	java/lang/System:load	(Ljava/lang/String;)V
    //   189: iconst_1
    //   190: istore_3
    //   191: aload 23
    //   193: iconst_0
    //   194: ldc 110
    //   196: invokestatic 234	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;)V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_0
    //   202: new 78	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   209: ldc 110
    //   211: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 236
    //   216: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   223: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 14
    //   231: iconst_0
    //   232: iconst_2
    //   233: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   236: istore 4
    //   238: iload 4
    //   240: istore_2
    //   241: iload_3
    //   242: istore 6
    //   244: aload 14
    //   246: astore_0
    //   247: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +20 -> 270
    //   253: ldc 10
    //   255: iconst_2
    //   256: aload 14
    //   258: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 14
    //   263: astore_0
    //   264: iload_3
    //   265: istore 6
    //   267: iload 4
    //   269: istore_2
    //   270: new 211	java/io/File
    //   273: dup
    //   274: new 78	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   281: aload 27
    //   283: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_1
    //   287: invokestatic 222	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: astore 24
    //   301: ldc 246
    //   303: invokestatic 252	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   306: invokevirtual 256	java/lang/Integer:intValue	()I
    //   309: istore 4
    //   311: new 78	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   318: ldc 24
    //   320: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_1
    //   324: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: astore 14
    //   332: new 78	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   339: ldc 21
    //   341: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: astore 25
    //   353: aload 13
    //   355: ldc 18
    //   357: iconst_0
    //   358: invokevirtual 260	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   361: astore 26
    //   363: aload 26
    //   365: aload 14
    //   367: iconst_m1
    //   368: invokeinterface 266 3 0
    //   373: istore 5
    //   375: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +51 -> 429
    //   381: ldc 10
    //   383: iconst_2
    //   384: new 78	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 268
    //   394: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_1
    //   398: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 270
    //   404: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 5
    //   409: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc_w 275
    //   415: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload 4
    //   420: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iload 5
    //   431: iload 4
    //   433: if_icmpge +43 -> 476
    //   436: aload 24
    //   438: invokevirtual 226	java/io/File:exists	()Z
    //   441: ifeq +9 -> 450
    //   444: aload 24
    //   446: invokevirtual 278	java/io/File:delete	()Z
    //   449: pop
    //   450: iload 4
    //   452: ifne +555 -> 1007
    //   455: aload 26
    //   457: invokeinterface 282 1 0
    //   462: aload 14
    //   464: iconst_m1
    //   465: invokeinterface 288 3 0
    //   470: invokeinterface 291 1 0
    //   475: pop
    //   476: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +12 -> 491
    //   482: ldc 10
    //   484: iconst_2
    //   485: ldc_w 293
    //   488: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: aload 24
    //   493: invokevirtual 226	java/io/File:exists	()Z
    //   496: ifne +1153 -> 1649
    //   499: aconst_null
    //   500: astore 18
    //   502: aconst_null
    //   503: astore 17
    //   505: aconst_null
    //   506: astore 21
    //   508: aconst_null
    //   509: astore 19
    //   511: aconst_null
    //   512: astore 20
    //   514: aconst_null
    //   515: astore 22
    //   517: ldc2_w 294
    //   520: lstore 11
    //   522: aload 19
    //   524: astore 16
    //   526: aload 20
    //   528: astore 14
    //   530: aload 17
    //   532: astore 15
    //   534: new 211	java/io/File
    //   537: dup
    //   538: aload 27
    //   540: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   543: astore 28
    //   545: aload 19
    //   547: astore 16
    //   549: aload 20
    //   551: astore 14
    //   553: aload 17
    //   555: astore 15
    //   557: aload 28
    //   559: invokevirtual 226	java/io/File:exists	()Z
    //   562: ifne +37 -> 599
    //   565: aload 19
    //   567: astore 16
    //   569: aload 20
    //   571: astore 14
    //   573: aload 17
    //   575: astore 15
    //   577: aload 28
    //   579: invokevirtual 298	java/io/File:mkdir	()Z
    //   582: istore_3
    //   583: lload 11
    //   585: lstore 9
    //   587: aload 22
    //   589: astore 15
    //   591: aload 21
    //   593: astore 14
    //   595: iload_3
    //   596: ifeq +113 -> 709
    //   599: aload 19
    //   601: astore 16
    //   603: aload 20
    //   605: astore 14
    //   607: aload 17
    //   609: astore 15
    //   611: aload 13
    //   613: invokevirtual 302	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   616: new 78	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   623: iconst_0
    //   624: invokestatic 304	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   627: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_1
    //   631: invokestatic 222	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   634: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokevirtual 310	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   643: astore 21
    //   645: aload 21
    //   647: astore 13
    //   649: aload 13
    //   651: astore 16
    //   653: aload 13
    //   655: astore 14
    //   657: aload 17
    //   659: astore 15
    //   661: new 312	java/io/FileOutputStream
    //   664: dup
    //   665: new 78	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   672: aload 27
    //   674: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_1
    //   678: invokestatic 222	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   681: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokespecial 313	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   690: astore 17
    //   692: aload 13
    //   694: aload 17
    //   696: invokestatic 318	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   699: lstore 9
    //   701: aload 17
    //   703: astore 14
    //   705: aload 13
    //   707: astore 15
    //   709: aload 14
    //   711: ifnull +8 -> 719
    //   714: aload 14
    //   716: invokevirtual 323	java/io/OutputStream:close	()V
    //   719: iload_2
    //   720: istore 4
    //   722: aload_0
    //   723: astore 14
    //   725: lload 9
    //   727: lstore 11
    //   729: aload 15
    //   731: ifnull +908 -> 1639
    //   734: aload 15
    //   736: invokevirtual 326	java/io/InputStream:close	()V
    //   739: iload_2
    //   740: istore 4
    //   742: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +12 -> 757
    //   748: ldc 10
    //   750: iconst_2
    //   751: ldc_w 328
    //   754: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: iload 4
    //   759: istore_2
    //   760: aload_0
    //   761: astore 13
    //   763: aload 24
    //   765: invokevirtual 226	java/io/File:exists	()Z
    //   768: ifeq +75 -> 843
    //   771: lload 9
    //   773: aload 24
    //   775: invokevirtual 331	java/io/File:length	()J
    //   778: lcmp
    //   779: ifeq +484 -> 1263
    //   782: aload 24
    //   784: invokevirtual 278	java/io/File:delete	()Z
    //   787: pop
    //   788: new 78	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   795: aload_0
    //   796: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: ldc_w 333
    //   802: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: astore_0
    //   809: iload 4
    //   811: bipush 8
    //   813: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   816: istore 4
    //   818: iload 4
    //   820: istore_2
    //   821: aload_0
    //   822: astore 13
    //   824: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +16 -> 843
    //   830: ldc 10
    //   832: iconst_2
    //   833: aload_0
    //   834: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload_0
    //   838: astore 13
    //   840: iload 4
    //   842: istore_2
    //   843: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +12 -> 858
    //   849: ldc 10
    //   851: iconst_2
    //   852: ldc_w 335
    //   855: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: aload 24
    //   860: invokevirtual 226	java/io/File:exists	()Z
    //   863: ifeq +767 -> 1630
    //   866: aload 24
    //   868: invokevirtual 229	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   871: invokestatic 232	java/lang/System:load	(Ljava/lang/String;)V
    //   874: iconst_1
    //   875: istore_3
    //   876: aload 13
    //   878: astore_0
    //   879: iload_2
    //   880: istore 4
    //   882: iload_3
    //   883: istore 6
    //   885: aload_0
    //   886: astore 13
    //   888: iload_3
    //   889: ifne +31 -> 920
    //   892: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +12 -> 907
    //   898: ldc 10
    //   900: iconst_2
    //   901: ldc_w 337
    //   904: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: aload_1
    //   908: invokestatic 340	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   911: iconst_1
    //   912: istore 6
    //   914: aload_0
    //   915: astore 13
    //   917: iload_2
    //   918: istore 4
    //   920: aload 23
    //   922: iload 4
    //   924: aload 13
    //   926: invokestatic 234	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;)V
    //   929: iload 6
    //   931: ireturn
    //   932: new 78	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   939: ldc 110
    //   941: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc_w 342
    //   947: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: astore 14
    //   955: iconst_0
    //   956: iconst_4
    //   957: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   960: istore 4
    //   962: iload 4
    //   964: istore_2
    //   965: iload 8
    //   967: istore 6
    //   969: aload 14
    //   971: astore_0
    //   972: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   975: ifeq -705 -> 270
    //   978: ldc 10
    //   980: iconst_2
    //   981: aload 14
    //   983: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: iload 4
    //   988: istore_2
    //   989: iload 8
    //   991: istore 6
    //   993: aload 14
    //   995: astore_0
    //   996: goto -726 -> 270
    //   999: astore 14
    //   1001: iconst_0
    //   1002: istore 4
    //   1004: goto -693 -> 311
    //   1007: aload 26
    //   1009: invokeinterface 282 1 0
    //   1014: aload 14
    //   1016: iload 4
    //   1018: invokeinterface 288 3 0
    //   1023: invokeinterface 291 1 0
    //   1028: pop
    //   1029: goto -553 -> 476
    //   1032: astore 14
    //   1034: aload 19
    //   1036: astore 16
    //   1038: aload 20
    //   1040: astore 14
    //   1042: aload 17
    //   1044: astore 15
    //   1046: aload 13
    //   1048: invokevirtual 302	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1051: new 78	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1058: iconst_1
    //   1059: invokestatic 304	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1062: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload_1
    //   1066: invokestatic 222	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1069: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokevirtual 310	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1078: astore 13
    //   1080: goto -431 -> 649
    //   1083: astore 13
    //   1085: iload_2
    //   1086: istore 4
    //   1088: goto -346 -> 742
    //   1091: astore 14
    //   1093: aload 18
    //   1095: astore 17
    //   1097: aload 16
    //   1099: astore 13
    //   1101: aload 14
    //   1103: astore 16
    //   1105: aload 13
    //   1107: astore 14
    //   1109: aload 17
    //   1111: astore 15
    //   1113: new 78	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1120: aload_0
    //   1121: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: ldc_w 344
    //   1127: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload 16
    //   1132: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1135: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: astore_0
    //   1142: aload 13
    //   1144: astore 14
    //   1146: aload 17
    //   1148: astore 15
    //   1150: iload_2
    //   1151: bipush 16
    //   1153: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1156: istore_2
    //   1157: aload 13
    //   1159: astore 14
    //   1161: aload 17
    //   1163: astore 15
    //   1165: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +18 -> 1186
    //   1171: aload 13
    //   1173: astore 14
    //   1175: aload 17
    //   1177: astore 15
    //   1179: ldc 10
    //   1181: iconst_2
    //   1182: aload_0
    //   1183: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1186: aload 17
    //   1188: ifnull +8 -> 1196
    //   1191: aload 17
    //   1193: invokevirtual 323	java/io/OutputStream:close	()V
    //   1196: iload_2
    //   1197: istore 4
    //   1199: aload_0
    //   1200: astore 14
    //   1202: aload 13
    //   1204: ifnull +435 -> 1639
    //   1207: aload 13
    //   1209: invokevirtual 326	java/io/InputStream:close	()V
    //   1212: ldc2_w 294
    //   1215: lstore 9
    //   1217: iload_2
    //   1218: istore 4
    //   1220: goto -478 -> 742
    //   1223: astore 13
    //   1225: ldc2_w 294
    //   1228: lstore 9
    //   1230: iload_2
    //   1231: istore 4
    //   1233: goto -491 -> 742
    //   1236: astore_0
    //   1237: aload 14
    //   1239: astore 13
    //   1241: aload 15
    //   1243: ifnull +8 -> 1251
    //   1246: aload 15
    //   1248: invokevirtual 323	java/io/OutputStream:close	()V
    //   1251: aload 13
    //   1253: ifnull +8 -> 1261
    //   1256: aload 13
    //   1258: invokevirtual 326	java/io/InputStream:close	()V
    //   1261: aload_0
    //   1262: athrow
    //   1263: aload 24
    //   1265: invokestatic 350	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1268: lstore 9
    //   1270: aload 26
    //   1272: invokeinterface 282 1 0
    //   1277: aload 25
    //   1279: lload 9
    //   1281: invokeinterface 354 4 0
    //   1286: invokeinterface 291 1 0
    //   1291: pop
    //   1292: iload 4
    //   1294: istore_2
    //   1295: aload_0
    //   1296: astore 13
    //   1298: goto -455 -> 843
    //   1301: astore_0
    //   1302: aload 24
    //   1304: invokestatic 350	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1307: lstore 9
    //   1309: aload 26
    //   1311: aload 25
    //   1313: ldc2_w 294
    //   1316: invokeinterface 358 4 0
    //   1321: lstore 11
    //   1323: lload 9
    //   1325: ldc2_w 294
    //   1328: lcmp
    //   1329: ifeq +120 -> 1449
    //   1332: lload 9
    //   1334: lload 11
    //   1336: lcmp
    //   1337: ifeq +112 -> 1449
    //   1340: aload 24
    //   1342: invokevirtual 278	java/io/File:delete	()Z
    //   1345: pop
    //   1346: new 78	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1353: aload 13
    //   1355: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: ldc_w 360
    //   1361: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: lload 9
    //   1366: invokevirtual 363	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1369: ldc_w 365
    //   1372: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: lload 11
    //   1377: invokevirtual 363	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1380: ldc_w 367
    //   1383: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: aload 24
    //   1388: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1391: ldc_w 372
    //   1394: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: aload_0
    //   1398: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1401: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: astore 13
    //   1409: iload_2
    //   1410: sipush 128
    //   1413: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1416: istore 4
    //   1418: iload 4
    //   1420: istore_2
    //   1421: aload 13
    //   1423: astore_0
    //   1424: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1427: ifeq +97 -> 1524
    //   1430: ldc 10
    //   1432: iconst_2
    //   1433: aload 13
    //   1435: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: iconst_0
    //   1439: istore_3
    //   1440: aload 13
    //   1442: astore_0
    //   1443: iload 4
    //   1445: istore_2
    //   1446: goto -567 -> 879
    //   1449: new 78	java/lang/StringBuilder
    //   1452: dup
    //   1453: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1456: aload 13
    //   1458: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc_w 374
    //   1464: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload 24
    //   1469: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1472: ldc_w 372
    //   1475: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: aload_0
    //   1479: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1482: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1488: astore 13
    //   1490: iload_2
    //   1491: bipush 32
    //   1493: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1496: istore 4
    //   1498: iload 4
    //   1500: istore_2
    //   1501: aload 13
    //   1503: astore_0
    //   1504: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1507: ifeq +17 -> 1524
    //   1510: ldc 10
    //   1512: iconst_2
    //   1513: aload 13
    //   1515: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1518: aload 13
    //   1520: astore_0
    //   1521: iload 4
    //   1523: istore_2
    //   1524: iconst_0
    //   1525: istore_3
    //   1526: goto -647 -> 879
    //   1529: astore_1
    //   1530: new 78	java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1537: aload_0
    //   1538: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: ldc_w 376
    //   1544: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload_1
    //   1548: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1551: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: astore_0
    //   1558: iload_2
    //   1559: bipush 64
    //   1561: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1564: istore_2
    //   1565: iload_2
    //   1566: istore 4
    //   1568: iload_3
    //   1569: istore 6
    //   1571: aload_0
    //   1572: astore 13
    //   1574: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1577: ifeq -657 -> 920
    //   1580: ldc 10
    //   1582: iconst_2
    //   1583: aload_0
    //   1584: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1587: iload_2
    //   1588: istore 4
    //   1590: iload_3
    //   1591: istore 6
    //   1593: aload_0
    //   1594: astore 13
    //   1596: goto -676 -> 920
    //   1599: astore 13
    //   1601: goto -882 -> 719
    //   1604: astore 14
    //   1606: goto -410 -> 1196
    //   1609: astore_1
    //   1610: goto -359 -> 1251
    //   1613: astore_1
    //   1614: goto -353 -> 1261
    //   1617: astore_0
    //   1618: aload 17
    //   1620: astore 15
    //   1622: goto -381 -> 1241
    //   1625: astore 16
    //   1627: goto -522 -> 1105
    //   1630: aload 13
    //   1632: astore_0
    //   1633: iload 6
    //   1635: istore_3
    //   1636: goto -757 -> 879
    //   1639: aload 14
    //   1641: astore_0
    //   1642: lload 11
    //   1644: lstore 9
    //   1646: goto -904 -> 742
    //   1649: aload_0
    //   1650: astore 13
    //   1652: goto -809 -> 843
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1655	0	paramContext	Context
    //   0	1655	1	paramString	String
    //   0	1655	2	paramInt	int
    //   0	1655	3	paramBoolean	boolean
    //   236	1353	4	i	int
    //   373	61	5	j	int
    //   133	1501	6	bool1	boolean
    //   45	135	7	bool2	boolean
    //   42	948	8	bool3	boolean
    //   585	1060	9	l1	long
    //   520	1123	11	l2	long
    //   50	1029	13	localObject1	Object
    //   1083	1	13	localIOException1	java.io.IOException
    //   1099	109	13	localObject2	Object
    //   1223	1	13	localIOException2	java.io.IOException
    //   1239	356	13	localObject3	Object
    //   1599	32	13	localIOException3	java.io.IOException
    //   1650	1	13	localContext	Context
    //   39	955	14	localObject4	Object
    //   999	16	14	localNumberFormatException	java.lang.NumberFormatException
    //   1032	1	14	localException	java.lang.Exception
    //   1040	1	14	localObject5	Object
    //   1091	11	14	localIOException4	java.io.IOException
    //   1107	131	14	localObject6	Object
    //   1604	36	14	localIOException5	java.io.IOException
    //   115	1506	15	localObject7	Object
    //   524	607	16	localObject8	Object
    //   1625	1	16	localIOException6	java.io.IOException
    //   503	1116	17	localObject9	Object
    //   500	594	18	localObject10	Object
    //   509	526	19	localObject11	Object
    //   512	527	20	localObject12	Object
    //   506	140	21	localInputStream	java.io.InputStream
    //   515	73	22	localObject13	Object
    //   35	886	23	localHashMap	HashMap
    //   299	1169	24	localFile1	java.io.File
    //   351	961	25	str1	String
    //   361	949	26	localSharedPreferences	android.content.SharedPreferences
    //   87	586	27	str2	String
    //   543	35	28	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   182	189	201	java/lang/UnsatisfiedLinkError
    //   191	199	201	java/lang/UnsatisfiedLinkError
    //   301	311	999	java/lang/NumberFormatException
    //   611	645	1032	java/lang/Exception
    //   734	739	1083	java/io/IOException
    //   534	545	1091	java/io/IOException
    //   557	565	1091	java/io/IOException
    //   577	583	1091	java/io/IOException
    //   611	645	1091	java/io/IOException
    //   661	692	1091	java/io/IOException
    //   1046	1080	1091	java/io/IOException
    //   1207	1212	1223	java/io/IOException
    //   534	545	1236	finally
    //   557	565	1236	finally
    //   577	583	1236	finally
    //   611	645	1236	finally
    //   661	692	1236	finally
    //   1046	1080	1236	finally
    //   1113	1142	1236	finally
    //   1150	1157	1236	finally
    //   1165	1171	1236	finally
    //   1179	1186	1236	finally
    //   866	874	1301	java/lang/UnsatisfiedLinkError
    //   907	911	1529	java/lang/UnsatisfiedLinkError
    //   714	719	1599	java/io/IOException
    //   1191	1196	1604	java/io/IOException
    //   1246	1251	1609	java/io/IOException
    //   1256	1261	1613	java/io/IOException
    //   692	701	1617	finally
    //   692	701	1625	java/io/IOException
  }
  
  private static boolean a(String paramString)
  {
    return false;
  }
  
  /* Error */
  @java.lang.Deprecated
  private static boolean b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: new 78	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   18: ldc 81
    //   20: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 87
    //   29: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 11
    //   37: new 78	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 209	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 214	java/io/File:getParent	()Ljava/lang/String;
    //   51: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 216
    //   56: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 13
    //   64: new 78	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   71: aload 13
    //   73: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 11
    //   78: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 12
    //   86: aload_0
    //   87: ldc 15
    //   89: iconst_0
    //   90: invokevirtual 260	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   93: astore 10
    //   95: iload 7
    //   97: istore 6
    //   99: aload 10
    //   101: aload 11
    //   103: iconst_m1
    //   104: invokeinterface 266 3 0
    //   109: iload_2
    //   110: if_icmpne +11 -> 121
    //   113: aload 12
    //   115: invokestatic 232	java/lang/System:load	(Ljava/lang/String;)V
    //   118: iconst_1
    //   119: istore 6
    //   121: iload 6
    //   123: istore 8
    //   125: iload 6
    //   127: ifne +715 -> 842
    //   130: aconst_null
    //   131: astore 9
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_0
    //   136: invokevirtual 302	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   139: aload 11
    //   141: invokevirtual 310	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: aload_0
    //   148: astore 9
    //   150: new 211	java/io/File
    //   153: dup
    //   154: aload 13
    //   156: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: astore 13
    //   161: aload_0
    //   162: astore_1
    //   163: aload_0
    //   164: astore 9
    //   166: aload 13
    //   168: invokevirtual 226	java/io/File:exists	()Z
    //   171: ifne +20 -> 191
    //   174: aload_0
    //   175: astore_1
    //   176: iload 6
    //   178: istore 7
    //   180: aload_0
    //   181: astore 9
    //   183: aload 13
    //   185: invokevirtual 298	java/io/File:mkdir	()Z
    //   188: ifeq +593 -> 781
    //   191: aload_0
    //   192: astore_1
    //   193: aload_0
    //   194: astore 9
    //   196: new 211	java/io/File
    //   199: dup
    //   200: aload 12
    //   202: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 13
    //   207: iconst_0
    //   208: istore_3
    //   209: iconst_0
    //   210: istore 5
    //   212: aload_0
    //   213: astore_1
    //   214: new 312	java/io/FileOutputStream
    //   217: dup
    //   218: aload 13
    //   220: invokespecial 383	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   223: astore 9
    //   225: aload_0
    //   226: aload 9
    //   228: invokestatic 318	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   231: pop2
    //   232: iconst_1
    //   233: istore 5
    //   235: iload 5
    //   237: istore 4
    //   239: aload 9
    //   241: ifnull +14 -> 255
    //   244: aload_0
    //   245: astore_1
    //   246: aload 9
    //   248: invokevirtual 323	java/io/OutputStream:close	()V
    //   251: iload 5
    //   253: istore 4
    //   255: iload 4
    //   257: ifne +491 -> 748
    //   260: aload_0
    //   261: astore_1
    //   262: getstatic 33	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   265: aload 11
    //   267: invokeinterface 385 2 0
    //   272: istore 7
    //   274: iload 7
    //   276: ifeq +472 -> 748
    //   279: iload_3
    //   280: iconst_5
    //   281: if_icmpge +467 -> 748
    //   284: iload_3
    //   285: iconst_1
    //   286: iadd
    //   287: istore_3
    //   288: goto -79 -> 209
    //   291: astore_1
    //   292: iload 7
    //   294: istore 6
    //   296: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -178 -> 121
    //   302: ldc 10
    //   304: iconst_2
    //   305: aload_1
    //   306: invokestatic 242	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   309: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iload 7
    //   314: istore 6
    //   316: goto -195 -> 121
    //   319: astore 9
    //   321: aload_0
    //   322: astore_1
    //   323: aload 9
    //   325: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   328: iload 5
    //   330: istore 4
    //   332: goto -77 -> 255
    //   335: astore 10
    //   337: aload_0
    //   338: astore_1
    //   339: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +74 -> 416
    //   345: aload_0
    //   346: astore_1
    //   347: new 78	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   354: astore 9
    //   356: aload_0
    //   357: astore_1
    //   358: aload 9
    //   360: aload 11
    //   362: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 390
    //   368: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: new 211	java/io/File
    //   374: dup
    //   375: aload 12
    //   377: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: invokevirtual 226	java/io/File:exists	()Z
    //   383: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   386: ldc_w 395
    //   389: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 10
    //   394: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_0
    //   402: astore_1
    //   403: ldc 10
    //   405: iconst_2
    //   406: aload 9
    //   408: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: aload 10
    //   413: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: iload_3
    //   417: istore 4
    //   419: iload 6
    //   421: istore 8
    //   423: aload_0
    //   424: ifnull +418 -> 842
    //   427: aload_0
    //   428: invokevirtual 326	java/io/InputStream:close	()V
    //   431: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +45 -> 479
    //   437: ldc 10
    //   439: iconst_2
    //   440: new 78	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   447: aload 11
    //   449: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 403
    //   455: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: iload_2
    //   459: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: ldc_w 405
    //   465: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: iload 6
    //   470: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   473: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: invokestatic 157	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   482: invokestatic 162	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   485: astore_0
    //   486: new 102	java/util/HashMap
    //   489: dup
    //   490: invokespecial 103	java/util/HashMap:<init>	()V
    //   493: astore_1
    //   494: aload_1
    //   495: ldc_w 407
    //   498: iload 6
    //   500: invokestatic 409	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   503: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_1
    //   508: ldc 150
    //   510: aload 11
    //   512: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: aload_1
    //   517: ldc 116
    //   519: getstatic 121	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   522: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: aload_1
    //   527: ldc 123
    //   529: new 78	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   536: getstatic 126	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   539: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc 128
    //   544: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: getstatic 131	android/os/Build:MODEL	Ljava/lang/String;
    //   550: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   559: pop
    //   560: aload_1
    //   561: ldc 133
    //   563: getstatic 52	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   566: new 135	java/util/Date
    //   569: dup
    //   570: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   573: invokespecial 144	java/util/Date:<init>	(J)V
    //   576: invokevirtual 148	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   579: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   582: pop
    //   583: iload 6
    //   585: ifne +63 -> 648
    //   588: new 211	java/io/File
    //   591: dup
    //   592: aload 12
    //   594: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   597: astore 9
    //   599: aload 9
    //   601: ifnull +47 -> 648
    //   604: aload_1
    //   605: ldc_w 411
    //   608: aload 9
    //   610: invokevirtual 226	java/io/File:exists	()Z
    //   613: invokestatic 409	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   616: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: aload_1
    //   621: ldc_w 413
    //   624: aload 9
    //   626: invokevirtual 331	java/io/File:length	()J
    //   629: invokestatic 416	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   632: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   635: pop
    //   636: aload_1
    //   637: ldc_w 418
    //   640: iload_3
    //   641: invokestatic 421	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   644: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   647: pop
    //   648: aload_0
    //   649: ldc 110
    //   651: ldc 10
    //   653: iload 6
    //   655: lconst_0
    //   656: lconst_0
    //   657: aload_1
    //   658: ldc 110
    //   660: invokevirtual 167	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   663: iload 6
    //   665: ireturn
    //   666: astore_1
    //   667: iload 5
    //   669: istore 4
    //   671: aload 9
    //   673: ifnull -418 -> 255
    //   676: aload_0
    //   677: astore_1
    //   678: aload 9
    //   680: invokevirtual 323	java/io/OutputStream:close	()V
    //   683: iload 5
    //   685: istore 4
    //   687: goto -432 -> 255
    //   690: astore 9
    //   692: aload_0
    //   693: astore_1
    //   694: aload 9
    //   696: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   699: iload 5
    //   701: istore 4
    //   703: goto -448 -> 255
    //   706: astore_0
    //   707: aload_1
    //   708: ifnull +7 -> 715
    //   711: aload_1
    //   712: invokevirtual 326	java/io/InputStream:close	()V
    //   715: aload_0
    //   716: athrow
    //   717: astore 10
    //   719: aload 9
    //   721: ifnull +10 -> 731
    //   724: aload_0
    //   725: astore_1
    //   726: aload 9
    //   728: invokevirtual 323	java/io/OutputStream:close	()V
    //   731: aload_0
    //   732: astore_1
    //   733: aload 10
    //   735: athrow
    //   736: astore 9
    //   738: aload_0
    //   739: astore_1
    //   740: aload 9
    //   742: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   745: goto -14 -> 731
    //   748: aload_0
    //   749: astore_1
    //   750: aload 10
    //   752: invokeinterface 282 1 0
    //   757: aload 11
    //   759: iload_2
    //   760: invokeinterface 288 3 0
    //   765: invokeinterface 291 1 0
    //   770: pop
    //   771: aload_0
    //   772: astore_1
    //   773: aload 12
    //   775: invokestatic 232	java/lang/System:load	(Ljava/lang/String;)V
    //   778: iconst_1
    //   779: istore 7
    //   781: iload_3
    //   782: istore 4
    //   784: iload 7
    //   786: istore 8
    //   788: aload_0
    //   789: ifnull +53 -> 842
    //   792: aload_0
    //   793: invokevirtual 326	java/io/InputStream:close	()V
    //   796: iload 7
    //   798: istore 6
    //   800: goto -369 -> 431
    //   803: astore_0
    //   804: aload_0
    //   805: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   808: iload 7
    //   810: istore 6
    //   812: goto -381 -> 431
    //   815: astore_0
    //   816: aload_0
    //   817: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   820: goto -389 -> 431
    //   823: astore_1
    //   824: aload_1
    //   825: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   828: goto -113 -> 715
    //   831: astore 10
    //   833: iload 5
    //   835: istore_3
    //   836: aload 9
    //   838: astore_0
    //   839: goto -502 -> 337
    //   842: iload 4
    //   844: istore_3
    //   845: iload 8
    //   847: istore 6
    //   849: goto -418 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	852	0	paramContext	Context
    //   0	852	1	paramString	String
    //   0	852	2	paramInt	int
    //   4	841	3	i	int
    //   6	837	4	j	int
    //   9	825	5	k	int
    //   97	751	6	bool1	boolean
    //   1	808	7	bool2	boolean
    //   123	723	8	bool3	boolean
    //   131	116	9	localObject1	Object
    //   319	5	9	localIOException1	java.io.IOException
    //   354	325	9	localObject2	Object
    //   690	37	9	localIOException2	java.io.IOException
    //   736	101	9	localIOException3	java.io.IOException
    //   93	7	10	localSharedPreferences	android.content.SharedPreferences
    //   335	77	10	localThrowable1	java.lang.Throwable
    //   717	34	10	localObject3	Object
    //   831	1	10	localThrowable2	java.lang.Throwable
    //   35	723	11	str1	String
    //   84	690	12	str2	String
    //   62	157	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	291	java/lang/Throwable
    //   246	251	319	java/io/IOException
    //   214	225	335	java/lang/Throwable
    //   246	251	335	java/lang/Throwable
    //   262	274	335	java/lang/Throwable
    //   323	328	335	java/lang/Throwable
    //   678	683	335	java/lang/Throwable
    //   694	699	335	java/lang/Throwable
    //   726	731	335	java/lang/Throwable
    //   733	736	335	java/lang/Throwable
    //   740	745	335	java/lang/Throwable
    //   750	771	335	java/lang/Throwable
    //   773	778	335	java/lang/Throwable
    //   225	232	666	java/lang/Exception
    //   678	683	690	java/io/IOException
    //   135	145	706	finally
    //   150	161	706	finally
    //   166	174	706	finally
    //   183	191	706	finally
    //   196	207	706	finally
    //   214	225	706	finally
    //   246	251	706	finally
    //   262	274	706	finally
    //   323	328	706	finally
    //   339	345	706	finally
    //   347	356	706	finally
    //   358	401	706	finally
    //   403	416	706	finally
    //   678	683	706	finally
    //   694	699	706	finally
    //   726	731	706	finally
    //   733	736	706	finally
    //   740	745	706	finally
    //   750	771	706	finally
    //   773	778	706	finally
    //   225	232	717	finally
    //   726	731	736	java/io/IOException
    //   792	796	803	java/io/IOException
    //   427	431	815	java/io/IOException
    //   711	715	823	java/io/IOException
    //   135	145	831	java/lang/Throwable
    //   150	161	831	java/lang/Throwable
    //   166	174	831	java/lang/Throwable
    //   183	191	831	java/lang/Throwable
    //   196	207	831	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */