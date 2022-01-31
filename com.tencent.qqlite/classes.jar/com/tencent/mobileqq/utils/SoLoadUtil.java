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
  
  private static final void a(HashMap paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
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
    //   0: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 78	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   16: ldc 200
    //   18: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: invokestatic 208	android/os/SystemClock:uptimeMillis	()J
    //   34: lstore 13
    //   36: aload_1
    //   37: invokestatic 210	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   40: astore 25
    //   42: ldc 110
    //   44: astore 16
    //   46: iconst_0
    //   47: istore 8
    //   49: iconst_0
    //   50: istore 7
    //   52: iconst_0
    //   53: istore_2
    //   54: aload_0
    //   55: astore 15
    //   57: aload_0
    //   58: ifnonnull +8 -> 66
    //   61: invokestatic 213	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   64: astore 15
    //   66: new 78	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   73: aload 15
    //   75: invokevirtual 219	android/content/Context:getFilesDir	()Ljava/io/File;
    //   78: invokevirtual 224	java/io/File:getParent	()Ljava/lang/String;
    //   81: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 226
    //   86: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 29
    //   94: new 78	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   101: aload 15
    //   103: invokevirtual 219	android/content/Context:getFilesDir	()Ljava/io/File;
    //   106: invokevirtual 224	java/io/File:getParent	()Ljava/lang/String;
    //   109: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 228
    //   114: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 17
    //   122: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +11 -> 136
    //   128: ldc 10
    //   130: iconst_2
    //   131: ldc 230
    //   133: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: iload 8
    //   138: istore 6
    //   140: aload 16
    //   142: astore_0
    //   143: iload_3
    //   144: ifeq +137 -> 281
    //   147: new 221	java/io/File
    //   150: dup
    //   151: new 78	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   158: aload 17
    //   160: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokestatic 232	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 236	java/io/File:exists	()Z
    //   181: ifeq +768 -> 949
    //   184: iload 7
    //   186: istore_3
    //   187: aload_0
    //   188: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: invokestatic 242	java/lang/System:load	(Ljava/lang/String;)V
    //   194: iconst_1
    //   195: istore_3
    //   196: aload 25
    //   198: iconst_0
    //   199: ldc 110
    //   201: invokestatic 208	android/os/SystemClock:uptimeMillis	()J
    //   204: lload 13
    //   206: lsub
    //   207: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   210: iconst_1
    //   211: ireturn
    //   212: astore_0
    //   213: new 78	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   220: ldc 110
    //   222: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 246
    //   227: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   234: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 16
    //   242: iconst_0
    //   243: iconst_2
    //   244: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   247: istore 4
    //   249: iload 4
    //   251: istore_2
    //   252: iload_3
    //   253: istore 6
    //   255: aload 16
    //   257: astore_0
    //   258: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +20 -> 281
    //   264: ldc 10
    //   266: iconst_2
    //   267: aload 16
    //   269: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 16
    //   274: astore_0
    //   275: iload_3
    //   276: istore 6
    //   278: iload 4
    //   280: istore_2
    //   281: new 221	java/io/File
    //   284: dup
    //   285: new 78	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   292: aload 29
    //   294: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_1
    //   298: invokestatic 232	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   310: astore 26
    //   312: ldc 254
    //   314: invokestatic 260	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   317: invokevirtual 264	java/lang/Integer:intValue	()I
    //   320: istore 4
    //   322: new 78	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   329: ldc 24
    //   331: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_1
    //   335: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: astore 16
    //   343: new 78	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   350: ldc 21
    //   352: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 27
    //   364: aload 15
    //   366: ldc 18
    //   368: iconst_0
    //   369: invokevirtual 268	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   372: astore 28
    //   374: aload 28
    //   376: aload 16
    //   378: iconst_m1
    //   379: invokeinterface 274 3 0
    //   384: istore 5
    //   386: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +51 -> 440
    //   392: ldc 10
    //   394: iconst_2
    //   395: new 78	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 276
    //   405: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 278
    //   415: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload 5
    //   420: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: ldc_w 283
    //   426: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload 4
    //   431: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iload 5
    //   442: iload 4
    //   444: if_icmpeq +43 -> 487
    //   447: aload 26
    //   449: invokevirtual 236	java/io/File:exists	()Z
    //   452: ifeq +9 -> 461
    //   455: aload 26
    //   457: invokevirtual 286	java/io/File:delete	()Z
    //   460: pop
    //   461: iload 4
    //   463: ifne +561 -> 1024
    //   466: aload 28
    //   468: invokeinterface 290 1 0
    //   473: aload 16
    //   475: iconst_m1
    //   476: invokeinterface 296 3 0
    //   481: invokeinterface 299 1 0
    //   486: pop
    //   487: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +12 -> 502
    //   493: ldc 10
    //   495: iconst_2
    //   496: ldc_w 301
    //   499: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload 26
    //   504: invokevirtual 236	java/io/File:exists	()Z
    //   507: ifne +1159 -> 1666
    //   510: aconst_null
    //   511: astore 20
    //   513: aconst_null
    //   514: astore 19
    //   516: aconst_null
    //   517: astore 23
    //   519: aconst_null
    //   520: astore 21
    //   522: aconst_null
    //   523: astore 22
    //   525: aconst_null
    //   526: astore 24
    //   528: ldc2_w 302
    //   531: lstore 11
    //   533: aload 21
    //   535: astore 18
    //   537: aload 22
    //   539: astore 16
    //   541: aload 19
    //   543: astore 17
    //   545: new 221	java/io/File
    //   548: dup
    //   549: aload 29
    //   551: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   554: astore 30
    //   556: aload 21
    //   558: astore 18
    //   560: aload 22
    //   562: astore 16
    //   564: aload 19
    //   566: astore 17
    //   568: aload 30
    //   570: invokevirtual 236	java/io/File:exists	()Z
    //   573: ifne +37 -> 610
    //   576: aload 21
    //   578: astore 18
    //   580: aload 22
    //   582: astore 16
    //   584: aload 19
    //   586: astore 17
    //   588: aload 30
    //   590: invokevirtual 306	java/io/File:mkdir	()Z
    //   593: istore_3
    //   594: lload 11
    //   596: lstore 9
    //   598: aload 24
    //   600: astore 17
    //   602: aload 23
    //   604: astore 16
    //   606: iload_3
    //   607: ifeq +113 -> 720
    //   610: aload 21
    //   612: astore 18
    //   614: aload 22
    //   616: astore 16
    //   618: aload 19
    //   620: astore 17
    //   622: aload 15
    //   624: invokevirtual 310	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   627: new 78	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   634: iconst_0
    //   635: invokestatic 312	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   638: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_1
    //   642: invokestatic 232	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   645: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokevirtual 318	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   654: astore 23
    //   656: aload 23
    //   658: astore 15
    //   660: aload 15
    //   662: astore 18
    //   664: aload 15
    //   666: astore 16
    //   668: aload 19
    //   670: astore 17
    //   672: new 320	java/io/FileOutputStream
    //   675: dup
    //   676: new 78	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   683: aload 29
    //   685: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_1
    //   689: invokestatic 232	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   692: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   701: astore 19
    //   703: aload 15
    //   705: aload 19
    //   707: invokestatic 326	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   710: lstore 9
    //   712: aload 19
    //   714: astore 16
    //   716: aload 15
    //   718: astore 17
    //   720: aload 16
    //   722: ifnull +8 -> 730
    //   725: aload 16
    //   727: invokevirtual 331	java/io/OutputStream:close	()V
    //   730: iload_2
    //   731: istore 4
    //   733: aload_0
    //   734: astore 16
    //   736: lload 9
    //   738: lstore 11
    //   740: aload 17
    //   742: ifnull +914 -> 1656
    //   745: aload 17
    //   747: invokevirtual 334	java/io/InputStream:close	()V
    //   750: iload_2
    //   751: istore 4
    //   753: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   756: ifeq +12 -> 768
    //   759: ldc 10
    //   761: iconst_2
    //   762: ldc_w 336
    //   765: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: iload 4
    //   770: istore_2
    //   771: aload_0
    //   772: astore 15
    //   774: aload 26
    //   776: invokevirtual 236	java/io/File:exists	()Z
    //   779: ifeq +75 -> 854
    //   782: lload 9
    //   784: aload 26
    //   786: invokevirtual 339	java/io/File:length	()J
    //   789: lcmp
    //   790: ifeq +490 -> 1280
    //   793: aload 26
    //   795: invokevirtual 286	java/io/File:delete	()Z
    //   798: pop
    //   799: new 78	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   806: aload_0
    //   807: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: ldc_w 341
    //   813: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: astore_0
    //   820: iload 4
    //   822: bipush 8
    //   824: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   827: istore 4
    //   829: iload 4
    //   831: istore_2
    //   832: aload_0
    //   833: astore 15
    //   835: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq +16 -> 854
    //   841: ldc 10
    //   843: iconst_2
    //   844: aload_0
    //   845: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: aload_0
    //   849: astore 15
    //   851: iload 4
    //   853: istore_2
    //   854: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   857: ifeq +12 -> 869
    //   860: ldc 10
    //   862: iconst_2
    //   863: ldc_w 343
    //   866: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   869: aload 26
    //   871: invokevirtual 236	java/io/File:exists	()Z
    //   874: ifeq +773 -> 1647
    //   877: aload 26
    //   879: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   882: invokestatic 242	java/lang/System:load	(Ljava/lang/String;)V
    //   885: iconst_1
    //   886: istore_3
    //   887: aload 15
    //   889: astore_0
    //   890: iload_2
    //   891: istore 4
    //   893: iload_3
    //   894: istore 6
    //   896: aload_0
    //   897: astore 15
    //   899: iload_3
    //   900: ifne +31 -> 931
    //   903: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq +12 -> 918
    //   909: ldc 10
    //   911: iconst_2
    //   912: ldc_w 345
    //   915: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   918: aload_1
    //   919: invokestatic 348	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   922: iconst_1
    //   923: istore 6
    //   925: aload_0
    //   926: astore 15
    //   928: iload_2
    //   929: istore 4
    //   931: aload 25
    //   933: iload 4
    //   935: aload 15
    //   937: invokestatic 208	android/os/SystemClock:uptimeMillis	()J
    //   940: lload 13
    //   942: lsub
    //   943: invokestatic 244	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   946: iload 6
    //   948: ireturn
    //   949: new 78	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   956: ldc 110
    //   958: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 350
    //   964: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: astore 16
    //   972: iconst_0
    //   973: iconst_4
    //   974: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   977: istore 4
    //   979: iload 4
    //   981: istore_2
    //   982: iload 8
    //   984: istore 6
    //   986: aload 16
    //   988: astore_0
    //   989: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   992: ifeq -711 -> 281
    //   995: ldc 10
    //   997: iconst_2
    //   998: aload 16
    //   1000: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1003: iload 4
    //   1005: istore_2
    //   1006: iload 8
    //   1008: istore 6
    //   1010: aload 16
    //   1012: astore_0
    //   1013: goto -732 -> 281
    //   1016: astore 16
    //   1018: iconst_0
    //   1019: istore 4
    //   1021: goto -699 -> 322
    //   1024: aload 28
    //   1026: invokeinterface 290 1 0
    //   1031: aload 16
    //   1033: iload 4
    //   1035: invokeinterface 296 3 0
    //   1040: invokeinterface 299 1 0
    //   1045: pop
    //   1046: goto -559 -> 487
    //   1049: astore 16
    //   1051: aload 21
    //   1053: astore 18
    //   1055: aload 22
    //   1057: astore 16
    //   1059: aload 19
    //   1061: astore 17
    //   1063: aload 15
    //   1065: invokevirtual 310	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1068: new 78	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1075: iconst_1
    //   1076: invokestatic 312	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1079: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: aload_1
    //   1083: invokestatic 232	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1086: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokevirtual 318	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1095: astore 15
    //   1097: goto -437 -> 660
    //   1100: astore 15
    //   1102: iload_2
    //   1103: istore 4
    //   1105: goto -352 -> 753
    //   1108: astore 16
    //   1110: aload 20
    //   1112: astore 19
    //   1114: aload 18
    //   1116: astore 15
    //   1118: aload 16
    //   1120: astore 18
    //   1122: aload 15
    //   1124: astore 16
    //   1126: aload 19
    //   1128: astore 17
    //   1130: new 78	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1137: aload_0
    //   1138: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: ldc_w 352
    //   1144: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: aload 18
    //   1149: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1152: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: astore_0
    //   1159: aload 15
    //   1161: astore 16
    //   1163: aload 19
    //   1165: astore 17
    //   1167: iload_2
    //   1168: bipush 16
    //   1170: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1173: istore_2
    //   1174: aload 15
    //   1176: astore 16
    //   1178: aload 19
    //   1180: astore 17
    //   1182: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1185: ifeq +18 -> 1203
    //   1188: aload 15
    //   1190: astore 16
    //   1192: aload 19
    //   1194: astore 17
    //   1196: ldc 10
    //   1198: iconst_2
    //   1199: aload_0
    //   1200: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1203: aload 19
    //   1205: ifnull +8 -> 1213
    //   1208: aload 19
    //   1210: invokevirtual 331	java/io/OutputStream:close	()V
    //   1213: iload_2
    //   1214: istore 4
    //   1216: aload_0
    //   1217: astore 16
    //   1219: aload 15
    //   1221: ifnull +435 -> 1656
    //   1224: aload 15
    //   1226: invokevirtual 334	java/io/InputStream:close	()V
    //   1229: ldc2_w 302
    //   1232: lstore 9
    //   1234: iload_2
    //   1235: istore 4
    //   1237: goto -484 -> 753
    //   1240: astore 15
    //   1242: ldc2_w 302
    //   1245: lstore 9
    //   1247: iload_2
    //   1248: istore 4
    //   1250: goto -497 -> 753
    //   1253: astore_0
    //   1254: aload 16
    //   1256: astore 15
    //   1258: aload 17
    //   1260: ifnull +8 -> 1268
    //   1263: aload 17
    //   1265: invokevirtual 331	java/io/OutputStream:close	()V
    //   1268: aload 15
    //   1270: ifnull +8 -> 1278
    //   1273: aload 15
    //   1275: invokevirtual 334	java/io/InputStream:close	()V
    //   1278: aload_0
    //   1279: athrow
    //   1280: aload 26
    //   1282: invokestatic 358	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1285: lstore 9
    //   1287: aload 28
    //   1289: invokeinterface 290 1 0
    //   1294: aload 27
    //   1296: lload 9
    //   1298: invokeinterface 362 4 0
    //   1303: invokeinterface 299 1 0
    //   1308: pop
    //   1309: iload 4
    //   1311: istore_2
    //   1312: aload_0
    //   1313: astore 15
    //   1315: goto -461 -> 854
    //   1318: astore_0
    //   1319: aload 26
    //   1321: invokestatic 358	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1324: lstore 9
    //   1326: aload 28
    //   1328: aload 27
    //   1330: ldc2_w 302
    //   1333: invokeinterface 366 4 0
    //   1338: lstore 11
    //   1340: lload 9
    //   1342: ldc2_w 302
    //   1345: lcmp
    //   1346: ifeq +120 -> 1466
    //   1349: lload 9
    //   1351: lload 11
    //   1353: lcmp
    //   1354: ifeq +112 -> 1466
    //   1357: aload 26
    //   1359: invokevirtual 286	java/io/File:delete	()Z
    //   1362: pop
    //   1363: new 78	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1370: aload 15
    //   1372: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: ldc_w 368
    //   1378: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: lload 9
    //   1383: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1386: ldc_w 370
    //   1389: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: lload 11
    //   1394: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1397: ldc_w 372
    //   1400: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload 26
    //   1405: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1408: ldc_w 377
    //   1411: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload_0
    //   1415: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1418: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: astore 15
    //   1426: iload_2
    //   1427: sipush 128
    //   1430: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1433: istore 4
    //   1435: iload 4
    //   1437: istore_2
    //   1438: aload 15
    //   1440: astore_0
    //   1441: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1444: ifeq +97 -> 1541
    //   1447: ldc 10
    //   1449: iconst_2
    //   1450: aload 15
    //   1452: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1455: iconst_0
    //   1456: istore_3
    //   1457: aload 15
    //   1459: astore_0
    //   1460: iload 4
    //   1462: istore_2
    //   1463: goto -573 -> 890
    //   1466: new 78	java/lang/StringBuilder
    //   1469: dup
    //   1470: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1473: aload 15
    //   1475: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: ldc_w 379
    //   1481: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 26
    //   1486: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1489: ldc_w 377
    //   1492: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: aload_0
    //   1496: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1499: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: astore 15
    //   1507: iload_2
    //   1508: bipush 32
    //   1510: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1513: istore 4
    //   1515: iload 4
    //   1517: istore_2
    //   1518: aload 15
    //   1520: astore_0
    //   1521: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1524: ifeq +17 -> 1541
    //   1527: ldc 10
    //   1529: iconst_2
    //   1530: aload 15
    //   1532: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1535: aload 15
    //   1537: astore_0
    //   1538: iload 4
    //   1540: istore_2
    //   1541: iconst_0
    //   1542: istore_3
    //   1543: goto -653 -> 890
    //   1546: astore_1
    //   1547: new 78	java/lang/StringBuilder
    //   1550: dup
    //   1551: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1554: aload_0
    //   1555: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: ldc_w 381
    //   1561: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: aload_1
    //   1565: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1568: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1574: astore_0
    //   1575: iload_2
    //   1576: bipush 64
    //   1578: invokestatic 252	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1581: istore_2
    //   1582: iload_2
    //   1583: istore 4
    //   1585: iload_3
    //   1586: istore 6
    //   1588: aload_0
    //   1589: astore 15
    //   1591: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1594: ifeq -663 -> 931
    //   1597: ldc 10
    //   1599: iconst_2
    //   1600: aload_0
    //   1601: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1604: iload_2
    //   1605: istore 4
    //   1607: iload_3
    //   1608: istore 6
    //   1610: aload_0
    //   1611: astore 15
    //   1613: goto -682 -> 931
    //   1616: astore 15
    //   1618: goto -888 -> 730
    //   1621: astore 16
    //   1623: goto -410 -> 1213
    //   1626: astore_1
    //   1627: goto -359 -> 1268
    //   1630: astore_1
    //   1631: goto -353 -> 1278
    //   1634: astore_0
    //   1635: aload 19
    //   1637: astore 17
    //   1639: goto -381 -> 1258
    //   1642: astore 18
    //   1644: goto -522 -> 1122
    //   1647: aload 15
    //   1649: astore_0
    //   1650: iload 6
    //   1652: istore_3
    //   1653: goto -763 -> 890
    //   1656: aload 16
    //   1658: astore_0
    //   1659: lload 11
    //   1661: lstore 9
    //   1663: goto -910 -> 753
    //   1666: aload_0
    //   1667: astore 15
    //   1669: goto -815 -> 854
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1672	0	paramContext	Context
    //   0	1672	1	paramString	String
    //   0	1672	2	paramInt	int
    //   0	1672	3	paramBoolean	boolean
    //   247	1359	4	i	int
    //   384	61	5	j	int
    //   138	1513	6	bool1	boolean
    //   50	135	7	bool2	boolean
    //   47	960	8	bool3	boolean
    //   596	1066	9	l1	long
    //   531	1129	11	l2	long
    //   34	907	13	l3	long
    //   55	1041	15	localObject1	Object
    //   1100	1	15	localIOException1	java.io.IOException
    //   1116	109	15	localObject2	Object
    //   1240	1	15	localIOException2	java.io.IOException
    //   1256	356	15	localObject3	Object
    //   1616	32	15	localIOException3	java.io.IOException
    //   1667	1	15	localContext	Context
    //   44	967	16	localObject4	Object
    //   1016	16	16	localNumberFormatException	java.lang.NumberFormatException
    //   1049	1	16	localException	java.lang.Exception
    //   1057	1	16	localObject5	Object
    //   1108	11	16	localIOException4	java.io.IOException
    //   1124	131	16	localObject6	Object
    //   1621	36	16	localIOException5	java.io.IOException
    //   120	1518	17	localObject7	Object
    //   535	613	18	localObject8	Object
    //   1642	1	18	localIOException6	java.io.IOException
    //   514	1122	19	localObject9	Object
    //   511	600	20	localObject10	Object
    //   520	532	21	localObject11	Object
    //   523	533	22	localObject12	Object
    //   517	140	23	localInputStream	java.io.InputStream
    //   526	73	24	localObject13	Object
    //   40	892	25	localHashMap	HashMap
    //   310	1175	26	localFile1	java.io.File
    //   362	967	27	str1	String
    //   372	955	28	localSharedPreferences	android.content.SharedPreferences
    //   92	592	29	str2	String
    //   554	35	30	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   187	194	212	java/lang/UnsatisfiedLinkError
    //   196	210	212	java/lang/UnsatisfiedLinkError
    //   312	322	1016	java/lang/NumberFormatException
    //   622	656	1049	java/lang/Exception
    //   745	750	1100	java/io/IOException
    //   545	556	1108	java/io/IOException
    //   568	576	1108	java/io/IOException
    //   588	594	1108	java/io/IOException
    //   622	656	1108	java/io/IOException
    //   672	703	1108	java/io/IOException
    //   1063	1097	1108	java/io/IOException
    //   1224	1229	1240	java/io/IOException
    //   545	556	1253	finally
    //   568	576	1253	finally
    //   588	594	1253	finally
    //   622	656	1253	finally
    //   672	703	1253	finally
    //   1063	1097	1253	finally
    //   1130	1159	1253	finally
    //   1167	1174	1253	finally
    //   1182	1188	1253	finally
    //   1196	1203	1253	finally
    //   877	885	1318	java/lang/UnsatisfiedLinkError
    //   918	922	1546	java/lang/UnsatisfiedLinkError
    //   725	730	1616	java/io/IOException
    //   1208	1213	1621	java/io/IOException
    //   1263	1268	1626	java/io/IOException
    //   1273	1278	1630	java/io/IOException
    //   703	712	1634	finally
    //   703	712	1642	java/io/IOException
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
    //   45: invokevirtual 219	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 224	java/io/File:getParent	()Ljava/lang/String;
    //   51: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 226
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
    //   90: invokevirtual 268	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   93: astore 10
    //   95: iload 7
    //   97: istore 6
    //   99: aload 10
    //   101: aload 11
    //   103: iconst_m1
    //   104: invokeinterface 274 3 0
    //   109: iload_2
    //   110: if_icmpne +11 -> 121
    //   113: aload 12
    //   115: invokestatic 242	java/lang/System:load	(Ljava/lang/String;)V
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
    //   136: invokevirtual 310	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   139: aload 11
    //   141: invokevirtual 318	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: aload_0
    //   148: astore 9
    //   150: new 221	java/io/File
    //   153: dup
    //   154: aload 13
    //   156: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: astore 13
    //   161: aload_0
    //   162: astore_1
    //   163: aload_0
    //   164: astore 9
    //   166: aload 13
    //   168: invokevirtual 236	java/io/File:exists	()Z
    //   171: ifne +20 -> 191
    //   174: aload_0
    //   175: astore_1
    //   176: iload 6
    //   178: istore 7
    //   180: aload_0
    //   181: astore 9
    //   183: aload 13
    //   185: invokevirtual 306	java/io/File:mkdir	()Z
    //   188: ifeq +593 -> 781
    //   191: aload_0
    //   192: astore_1
    //   193: aload_0
    //   194: astore 9
    //   196: new 221	java/io/File
    //   199: dup
    //   200: aload 12
    //   202: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 13
    //   207: iconst_0
    //   208: istore_3
    //   209: iconst_0
    //   210: istore 5
    //   212: aload_0
    //   213: astore_1
    //   214: new 320	java/io/FileOutputStream
    //   217: dup
    //   218: aload 13
    //   220: invokespecial 388	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   223: astore 9
    //   225: aload_0
    //   226: aload 9
    //   228: invokestatic 326	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
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
    //   248: invokevirtual 331	java/io/OutputStream:close	()V
    //   251: iload 5
    //   253: istore 4
    //   255: iload 4
    //   257: ifne +491 -> 748
    //   260: aload_0
    //   261: astore_1
    //   262: getstatic 33	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   265: aload 11
    //   267: invokeinterface 390 2 0
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
    //   296: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -178 -> 121
    //   302: ldc 10
    //   304: iconst_2
    //   305: aload_1
    //   306: invokestatic 250	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   309: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iload 7
    //   314: istore 6
    //   316: goto -195 -> 121
    //   319: astore 9
    //   321: aload_0
    //   322: astore_1
    //   323: aload 9
    //   325: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   328: iload 5
    //   330: istore 4
    //   332: goto -77 -> 255
    //   335: astore 10
    //   337: aload_0
    //   338: astore_1
    //   339: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   365: ldc_w 395
    //   368: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: new 221	java/io/File
    //   374: dup
    //   375: aload 12
    //   377: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: invokevirtual 236	java/io/File:exists	()Z
    //   383: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   386: ldc_w 400
    //   389: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 10
    //   394: invokevirtual 403	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_0
    //   402: astore_1
    //   403: ldc 10
    //   405: iconst_2
    //   406: aload 9
    //   408: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: aload 10
    //   413: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: iload_3
    //   417: istore 4
    //   419: iload 6
    //   421: istore 8
    //   423: aload_0
    //   424: ifnull +418 -> 842
    //   427: aload_0
    //   428: invokevirtual 334	java/io/InputStream:close	()V
    //   431: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +45 -> 479
    //   437: ldc 10
    //   439: iconst_2
    //   440: new 78	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   447: aload 11
    //   449: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 408
    //   455: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: iload_2
    //   459: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: ldc_w 410
    //   465: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: iload 6
    //   470: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   473: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: invokestatic 157	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   482: invokestatic 162	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   485: astore_0
    //   486: new 102	java/util/HashMap
    //   489: dup
    //   490: invokespecial 103	java/util/HashMap:<init>	()V
    //   493: astore_1
    //   494: aload_1
    //   495: ldc_w 412
    //   498: iload 6
    //   500: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
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
    //   588: new 221	java/io/File
    //   591: dup
    //   592: aload 12
    //   594: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   597: astore 9
    //   599: aload 9
    //   601: ifnull +47 -> 648
    //   604: aload_1
    //   605: ldc_w 416
    //   608: aload 9
    //   610: invokevirtual 236	java/io/File:exists	()Z
    //   613: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   616: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: aload_1
    //   621: ldc_w 418
    //   624: aload 9
    //   626: invokevirtual 339	java/io/File:length	()J
    //   629: invokestatic 421	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   632: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   635: pop
    //   636: aload_1
    //   637: ldc_w 423
    //   640: iload_3
    //   641: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
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
    //   680: invokevirtual 331	java/io/OutputStream:close	()V
    //   683: iload 5
    //   685: istore 4
    //   687: goto -432 -> 255
    //   690: astore 9
    //   692: aload_0
    //   693: astore_1
    //   694: aload 9
    //   696: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   699: iload 5
    //   701: istore 4
    //   703: goto -448 -> 255
    //   706: astore_0
    //   707: aload_1
    //   708: ifnull +7 -> 715
    //   711: aload_1
    //   712: invokevirtual 334	java/io/InputStream:close	()V
    //   715: aload_0
    //   716: athrow
    //   717: astore 10
    //   719: aload 9
    //   721: ifnull +10 -> 731
    //   724: aload_0
    //   725: astore_1
    //   726: aload 9
    //   728: invokevirtual 331	java/io/OutputStream:close	()V
    //   731: aload_0
    //   732: astore_1
    //   733: aload 10
    //   735: athrow
    //   736: astore 9
    //   738: aload_0
    //   739: astore_1
    //   740: aload 9
    //   742: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   745: goto -14 -> 731
    //   748: aload_0
    //   749: astore_1
    //   750: aload 10
    //   752: invokeinterface 290 1 0
    //   757: aload 11
    //   759: iload_2
    //   760: invokeinterface 296 3 0
    //   765: invokeinterface 299 1 0
    //   770: pop
    //   771: aload_0
    //   772: astore_1
    //   773: aload 12
    //   775: invokestatic 242	java/lang/System:load	(Ljava/lang/String;)V
    //   778: iconst_1
    //   779: istore 7
    //   781: iload_3
    //   782: istore 4
    //   784: iload 7
    //   786: istore 8
    //   788: aload_0
    //   789: ifnull +53 -> 842
    //   792: aload_0
    //   793: invokevirtual 334	java/io/InputStream:close	()V
    //   796: iload 7
    //   798: istore 6
    //   800: goto -369 -> 431
    //   803: astore_0
    //   804: aload_0
    //   805: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   808: iload 7
    //   810: istore 6
    //   812: goto -381 -> 431
    //   815: astore_0
    //   816: aload_0
    //   817: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   820: goto -389 -> 431
    //   823: astore_1
    //   824: aload_1
    //   825: invokevirtual 393	java/io/IOException:printStackTrace	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */