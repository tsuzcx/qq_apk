package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.smtt.sdk.WebView;
import hlx;
import hly;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppReport
{
  protected static final int a = 10;
  protected static final long a = 86400000L;
  protected static final String a = "AppReport";
  public static Lock a;
  public static boolean a = false;
  public static final int b = 70;
  public static final String b = "appcenter_app_report_storage_file.txt";
  public static final int c = 1;
  public static final String c = "appcenter_app_report";
  public static final int d = 2;
  public static final String d = "app_last_fullReport_success_time";
  public static final int e = 4;
  public static final String e = "is_app_last_fullReport_success";
  public static final int f = 8;
  protected static final String f = "full_report_date";
  protected static final String g = "full_report_day_times";
  public static final String h = "is_incremental_report_overflow";
  protected static final String i = "platform";
  protected static final String j = "version";
  protected static final String k = "android_id";
  protected static final String l = "imsi";
  protected static final String m = "mac_addr";
  protected static final String n = "imei";
  protected static final String o = "keystr";
  protected static final String p = "sid";
  protected static final String q = "uin";
  protected static final String r = "resolution";
  protected static final String s = "model_info";
  protected static final String t = "package";
  protected static final String u = "type";
  protected static final String v = "ALL";
  protected static final String w = "INC";
  protected static final String x = "http://appsupport.qq.com/cgi-bin/appstage/sdk_update";
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_a_of_type_Boolean = false;
  }
  
  public static Bundle a(Context paramContext, Map paramMap, String paramString1, String paramString2)
  {
    paramContext = new Bundle();
    paramContext.putString("platform", CommonDataAdapter.a().g());
    paramContext.putString("version", CommonDataAdapter.a().c());
    paramContext.putString("uin", paramString2);
    paramContext.putString("imei", MobileInfoUtil.c());
    paramContext.putString("imsi", MobileInfoUtil.d());
    paramContext.putString("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
    paramContext.putString("mac_addr", MobileInfoUtil.a());
    paramContext.putString("model_info", Build.MODEL);
    paramContext.putString("resolution", MobileInfoUtil.e());
    paramContext.putString("keystr", CommonDataAdapter.a().a());
    paramContext.putString("sid", CommonDataAdapter.a().a());
    paramContext.putString("package", paramMap.values().toString());
    paramContext.putString("type", paramString1);
    return paramContext;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 193	java/io/File
    //   3: dup
    //   4: new 163	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 197	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: getstatic 203	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 20
    //   26: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 210	java/io/File:exists	()Z
    //   38: ifne +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: getstatic 99	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 215 1 0
    //   51: aload_0
    //   52: ldc 20
    //   54: invokevirtual 219	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   57: astore 4
    //   59: new 221	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 222	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 8
    //   83: aload 5
    //   85: astore 6
    //   87: aload 4
    //   89: astore 7
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 228	java/io/FileInputStream:read	([B)I
    //   98: istore_1
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpeq +64 -> 165
    //   104: aload 5
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: aload 5
    //   114: aload 8
    //   116: iconst_0
    //   117: iload_1
    //   118: invokevirtual 232	java/io/ByteArrayOutputStream:write	([BII)V
    //   121: goto -38 -> 83
    //   124: astore 6
    //   126: aload 5
    //   128: astore_0
    //   129: aload 6
    //   131: astore 5
    //   133: aload 5
    //   135: invokevirtual 235	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 238	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -108 -> 41
    //   152: aload_0
    //   153: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 5
    //   167: astore 6
    //   169: aload 4
    //   171: astore 7
    //   173: getstatic 99	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 243 1 0
    //   181: aload 5
    //   183: astore 6
    //   185: aload 4
    //   187: astore 7
    //   189: new 245	java/lang/String
    //   192: dup
    //   193: aload 5
    //   195: invokevirtual 249	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: invokespecial 252	java/lang/String:<init>	([B)V
    //   201: invokevirtual 255	java/lang/String:trim	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload 5
    //   208: astore 6
    //   210: aload 4
    //   212: astore 7
    //   214: aload 8
    //   216: invokevirtual 259	java/lang/String:length	()I
    //   219: ifle +612 -> 831
    //   222: aload 5
    //   224: astore 6
    //   226: aload 4
    //   228: astore 7
    //   230: aload 8
    //   232: iconst_0
    //   233: aload 8
    //   235: invokevirtual 259	java/lang/String:length	()I
    //   238: iconst_1
    //   239: isub
    //   240: invokevirtual 263	java/lang/String:substring	(II)Ljava/lang/String;
    //   243: ldc_w 265
    //   246: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   249: astore 8
    //   251: aload 5
    //   253: astore 6
    //   255: aload 4
    //   257: astore 7
    //   259: new 271	java/util/HashMap
    //   262: dup
    //   263: invokespecial 272	java/util/HashMap:<init>	()V
    //   266: astore 9
    //   268: aload 8
    //   270: ifnull +420 -> 690
    //   273: aload 5
    //   275: astore 6
    //   277: aload 4
    //   279: astore 7
    //   281: aload 8
    //   283: arraylength
    //   284: ifle +406 -> 690
    //   287: aload 5
    //   289: astore 6
    //   291: aload 4
    //   293: astore 7
    //   295: aload 8
    //   297: arraylength
    //   298: istore_2
    //   299: iconst_0
    //   300: istore_1
    //   301: iload_1
    //   302: iload_2
    //   303: if_icmpge +387 -> 690
    //   306: aload 5
    //   308: astore 6
    //   310: aload 4
    //   312: astore 7
    //   314: aload 8
    //   316: iload_1
    //   317: aaload
    //   318: ldc_w 274
    //   321: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   324: astore 10
    //   326: aload 5
    //   328: astore 6
    //   330: aload 4
    //   332: astore 7
    //   334: aload 10
    //   336: iconst_1
    //   337: aaload
    //   338: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: istore_3
    //   342: iload_3
    //   343: bipush 8
    //   345: if_icmpne +38 -> 383
    //   348: aload 5
    //   350: astore 6
    //   352: aload 4
    //   354: astore 7
    //   356: aload 9
    //   358: aload 10
    //   360: iconst_0
    //   361: aaload
    //   362: aload 10
    //   364: iconst_0
    //   365: aaload
    //   366: iconst_0
    //   367: ldc_w 282
    //   370: iload_3
    //   371: invokestatic 284	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   374: invokeinterface 288 3 0
    //   379: pop
    //   380: goto +457 -> 837
    //   383: aload 5
    //   385: astore 6
    //   387: aload 4
    //   389: astore 7
    //   391: aload_0
    //   392: invokevirtual 292	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   395: aload 10
    //   397: iconst_0
    //   398: aaload
    //   399: iconst_0
    //   400: invokevirtual 298	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   403: astore 11
    //   405: aload 5
    //   407: astore 6
    //   409: aload 4
    //   411: astore 7
    //   413: aload 9
    //   415: aload 10
    //   417: iconst_0
    //   418: aaload
    //   419: aload 10
    //   421: iconst_0
    //   422: aaload
    //   423: aload 11
    //   425: getfield 303	android/content/pm/PackageInfo:versionCode	I
    //   428: aload 11
    //   430: getfield 306	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   433: iload_3
    //   434: invokestatic 284	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   437: invokeinterface 288 3 0
    //   442: pop
    //   443: goto +394 -> 837
    //   446: astore 11
    //   448: aload 5
    //   450: astore 6
    //   452: aload 4
    //   454: astore 7
    //   456: ldc 13
    //   458: new 163	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 308
    //   468: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 10
    //   473: iconst_0
    //   474: aaload
    //   475: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 310
    //   481: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 11
    //   486: invokevirtual 311	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   489: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 315	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: goto +339 -> 837
    //   501: astore 6
    //   503: aload 5
    //   505: astore_0
    //   506: aload 6
    //   508: astore 5
    //   510: aload_0
    //   511: astore 6
    //   513: aload 4
    //   515: astore 7
    //   517: aload 5
    //   519: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   522: aload 4
    //   524: ifnull +8 -> 532
    //   527: aload 4
    //   529: invokevirtual 238	java/io/FileInputStream:close	()V
    //   532: aload_0
    //   533: ifnull -492 -> 41
    //   536: aload_0
    //   537: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   540: aconst_null
    //   541: areturn
    //   542: astore_0
    //   543: aload_0
    //   544: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   547: aconst_null
    //   548: areturn
    //   549: astore 11
    //   551: aload 5
    //   553: astore 6
    //   555: aload 4
    //   557: astore 7
    //   559: ldc 13
    //   561: new 163	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 317
    //   571: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 10
    //   576: iconst_0
    //   577: aaload
    //   578: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 310
    //   584: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 11
    //   589: invokevirtual 318	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   592: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 315	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: goto +236 -> 837
    //   604: astore_0
    //   605: aload 7
    //   607: astore 4
    //   609: aload 6
    //   611: astore 5
    //   613: aload 4
    //   615: ifnull +8 -> 623
    //   618: aload 4
    //   620: invokevirtual 238	java/io/FileInputStream:close	()V
    //   623: aload 5
    //   625: ifnull +8 -> 633
    //   628: aload 5
    //   630: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   633: aload_0
    //   634: athrow
    //   635: astore 11
    //   637: aload 5
    //   639: astore 6
    //   641: aload 4
    //   643: astore 7
    //   645: ldc 13
    //   647: new 163	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 317
    //   657: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 10
    //   662: iconst_0
    //   663: aaload
    //   664: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 310
    //   670: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 11
    //   675: invokevirtual 319	java/lang/Exception:toString	()Ljava/lang/String;
    //   678: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 315	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: goto +150 -> 837
    //   690: aload 4
    //   692: ifnull +8 -> 700
    //   695: aload 4
    //   697: invokevirtual 238	java/io/FileInputStream:close	()V
    //   700: aload 5
    //   702: ifnull +8 -> 710
    //   705: aload 5
    //   707: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   710: aload 9
    //   712: areturn
    //   713: astore_0
    //   714: aload_0
    //   715: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   718: goto -18 -> 700
    //   721: astore_0
    //   722: aload_0
    //   723: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   726: goto -16 -> 710
    //   729: astore 4
    //   731: aload 4
    //   733: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   736: goto -588 -> 148
    //   739: astore 4
    //   741: aload 4
    //   743: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   746: goto -214 -> 532
    //   749: astore 4
    //   751: aload 4
    //   753: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   756: goto -133 -> 623
    //   759: astore 4
    //   761: aload 4
    //   763: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   766: goto -133 -> 633
    //   769: astore_0
    //   770: aconst_null
    //   771: astore 5
    //   773: aconst_null
    //   774: astore 4
    //   776: goto -163 -> 613
    //   779: astore_0
    //   780: aconst_null
    //   781: astore 5
    //   783: goto -170 -> 613
    //   786: astore 6
    //   788: aload_0
    //   789: astore 5
    //   791: aload 6
    //   793: astore_0
    //   794: goto -181 -> 613
    //   797: astore 5
    //   799: aconst_null
    //   800: astore_0
    //   801: aconst_null
    //   802: astore 4
    //   804: goto -294 -> 510
    //   807: astore 5
    //   809: aconst_null
    //   810: astore_0
    //   811: goto -301 -> 510
    //   814: astore 5
    //   816: aconst_null
    //   817: astore_0
    //   818: aconst_null
    //   819: astore 4
    //   821: goto -688 -> 133
    //   824: astore 5
    //   826: aconst_null
    //   827: astore_0
    //   828: goto -695 -> 133
    //   831: aconst_null
    //   832: astore 8
    //   834: goto -583 -> 251
    //   837: iload_1
    //   838: iconst_1
    //   839: iadd
    //   840: istore_1
    //   841: goto -540 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	paramContext	Context
    //   98	743	1	i1	int
    //   298	6	2	i2	int
    //   341	93	3	i3	int
    //   57	639	4	localObject1	Object
    //   729	3	4	localIOException1	IOException
    //   739	3	4	localIOException2	IOException
    //   749	3	4	localIOException3	IOException
    //   759	3	4	localIOException4	IOException
    //   774	46	4	localObject2	Object
    //   66	724	5	localObject3	Object
    //   797	1	5	localIOException5	IOException
    //   807	1	5	localIOException6	IOException
    //   814	1	5	localFileNotFoundException1	FileNotFoundException
    //   824	1	5	localFileNotFoundException2	FileNotFoundException
    //   70	37	6	localObject4	Object
    //   124	6	6	localFileNotFoundException3	FileNotFoundException
    //   167	284	6	localObject5	Object
    //   501	6	6	localIOException7	IOException
    //   511	129	6	localObject6	Object
    //   786	6	6	localObject7	Object
    //   74	570	7	localObject8	Object
    //   81	752	8	localObject9	Object
    //   266	445	9	localHashMap	java.util.HashMap
    //   324	337	10	arrayOfString	String[]
    //   403	26	11	localPackageInfo	android.content.pm.PackageInfo
    //   446	39	11	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   549	39	11	localNumberFormatException	java.lang.NumberFormatException
    //   635	39	11	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	83	124	java/io/FileNotFoundException
    //   91	99	124	java/io/FileNotFoundException
    //   112	121	124	java/io/FileNotFoundException
    //   173	181	124	java/io/FileNotFoundException
    //   189	206	124	java/io/FileNotFoundException
    //   214	222	124	java/io/FileNotFoundException
    //   230	251	124	java/io/FileNotFoundException
    //   259	268	124	java/io/FileNotFoundException
    //   281	287	124	java/io/FileNotFoundException
    //   295	299	124	java/io/FileNotFoundException
    //   314	326	124	java/io/FileNotFoundException
    //   334	342	124	java/io/FileNotFoundException
    //   356	380	124	java/io/FileNotFoundException
    //   391	405	124	java/io/FileNotFoundException
    //   413	443	124	java/io/FileNotFoundException
    //   456	498	124	java/io/FileNotFoundException
    //   559	601	124	java/io/FileNotFoundException
    //   645	687	124	java/io/FileNotFoundException
    //   152	156	158	java/io/IOException
    //   334	342	446	android/content/pm/PackageManager$NameNotFoundException
    //   356	380	446	android/content/pm/PackageManager$NameNotFoundException
    //   391	405	446	android/content/pm/PackageManager$NameNotFoundException
    //   413	443	446	android/content/pm/PackageManager$NameNotFoundException
    //   76	83	501	java/io/IOException
    //   91	99	501	java/io/IOException
    //   112	121	501	java/io/IOException
    //   173	181	501	java/io/IOException
    //   189	206	501	java/io/IOException
    //   214	222	501	java/io/IOException
    //   230	251	501	java/io/IOException
    //   259	268	501	java/io/IOException
    //   281	287	501	java/io/IOException
    //   295	299	501	java/io/IOException
    //   314	326	501	java/io/IOException
    //   334	342	501	java/io/IOException
    //   356	380	501	java/io/IOException
    //   391	405	501	java/io/IOException
    //   413	443	501	java/io/IOException
    //   456	498	501	java/io/IOException
    //   559	601	501	java/io/IOException
    //   645	687	501	java/io/IOException
    //   536	540	542	java/io/IOException
    //   334	342	549	java/lang/NumberFormatException
    //   356	380	549	java/lang/NumberFormatException
    //   391	405	549	java/lang/NumberFormatException
    //   413	443	549	java/lang/NumberFormatException
    //   76	83	604	finally
    //   91	99	604	finally
    //   112	121	604	finally
    //   173	181	604	finally
    //   189	206	604	finally
    //   214	222	604	finally
    //   230	251	604	finally
    //   259	268	604	finally
    //   281	287	604	finally
    //   295	299	604	finally
    //   314	326	604	finally
    //   334	342	604	finally
    //   356	380	604	finally
    //   391	405	604	finally
    //   413	443	604	finally
    //   456	498	604	finally
    //   517	522	604	finally
    //   559	601	604	finally
    //   645	687	604	finally
    //   334	342	635	java/lang/Exception
    //   356	380	635	java/lang/Exception
    //   391	405	635	java/lang/Exception
    //   413	443	635	java/lang/Exception
    //   695	700	713	java/io/IOException
    //   705	710	721	java/io/IOException
    //   143	148	729	java/io/IOException
    //   527	532	739	java/io/IOException
    //   618	623	749	java/io/IOException
    //   628	633	759	java/io/IOException
    //   43	59	769	finally
    //   59	68	779	finally
    //   133	138	786	finally
    //   43	59	797	java/io/IOException
    //   59	68	807	java/io/IOException
    //   43	59	814	java/io/FileNotFoundException
    //   59	68	824	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    LogUtility.b("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3)
  {
    ThreadManager.a(new hlx(paramString1, paramInt, paramContext, paramString2, paramWebView, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2)
  {
    ThreadManager.a(new hly(paramContext, paramString1, paramWebView, paramString2));
  }
  
  public static boolean a()
  {
    boolean bool = OpenConfig.a(CommonDataAdapter.a().a(), null).b("C_Full_Report");
    LogUtility.c("AppReport", "<AppReport>, app full report switch : " + bool);
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appcenter_app_report", 0);
    long l1 = localSharedPreferences.getLong("full_report_date", 0L);
    int i1 = localSharedPreferences.getInt("full_report_day_times", 0);
    if (SystemClock.currentThreadTimeMillis() - l1 > 86400000L)
    {
      paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
      paramContext.putLong("full_report_date", SystemClock.currentThreadTimeMillis());
      paramContext.putInt("full_report_day_times", 0);
      paramContext.commit();
      return true;
    }
    if (i1 > 10) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    paramContext.putInt("full_report_day_times", i1 + 1);
    paramContext.commit();
    return true;
  }
  
  public static void b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport
 * JD-Core Version:    0.7.0.1
 */