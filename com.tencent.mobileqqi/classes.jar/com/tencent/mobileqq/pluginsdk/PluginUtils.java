package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"NewApi"})
public class PluginUtils
{
  private static final int BUFFER_LENGTH = 8192;
  static final String EXTRA_ID_NULL = "0";
  private static final String SUFFIX_TMP = ".tmp";
  private static Map<String, String> sExtraIds = new ConcurrentHashMap();
  private static Map<String, File> sInstallPathMap;
  private static Map<String, String> sManifest;
  private static Map<String, PackageInfo> sPackageInfoMap;
  private static Object sVerionRecLocker = new Object();
  
  static
  {
    sInstallPathMap = new ConcurrentHashMap();
    sPackageInfoMap = new ConcurrentHashMap();
  }
  
  /* Error */
  public static String extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 8
    //   3: aload_1
    //   4: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   7: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10: ifne +25 -> 35
    //   13: new 67	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 8
    //   35: aconst_null
    //   36: astore 9
    //   38: aconst_null
    //   39: astore_1
    //   40: aconst_null
    //   41: astore 7
    //   43: aconst_null
    //   44: astore 4
    //   46: aconst_null
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 5
    //   52: new 78	java/util/zip/ZipFile
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 81	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   60: astore 6
    //   62: aload 10
    //   64: astore 4
    //   66: aload 6
    //   68: invokevirtual 85	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   71: astore 10
    //   73: aload 5
    //   75: astore_1
    //   76: aload_1
    //   77: astore 4
    //   79: aload 10
    //   81: invokeinterface 91 1 0
    //   86: ifeq +254 -> 340
    //   89: aload_1
    //   90: astore 4
    //   92: aload 10
    //   94: invokeinterface 95 1 0
    //   99: checkcast 97	java/util/zip/ZipEntry
    //   102: invokevirtual 100	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull -33 -> 76
    //   112: aload_1
    //   113: astore 4
    //   115: aload 5
    //   117: ldc 102
    //   119: invokevirtual 106	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   122: ifne -46 -> 76
    //   125: aload_1
    //   126: astore 4
    //   128: aload 5
    //   130: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   133: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   136: ifne -60 -> 76
    //   139: aload_1
    //   140: astore 4
    //   142: new 56	java/io/File
    //   145: dup
    //   146: new 67	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   153: aload 8
    //   155: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 5
    //   160: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore 7
    //   171: aload_1
    //   172: astore 5
    //   174: aload 5
    //   176: astore_1
    //   177: aload 7
    //   179: ifnull -103 -> 76
    //   182: aload 5
    //   184: astore 4
    //   186: aload 7
    //   188: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   191: getstatic 113	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   194: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq +14 -> 211
    //   200: aload 5
    //   202: astore 4
    //   204: getstatic 113	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   207: astore_1
    //   208: goto -132 -> 76
    //   211: aload 5
    //   213: astore 4
    //   215: getstatic 122	android/os/Build$VERSION:SDK_INT	I
    //   218: bipush 7
    //   220: if_icmple +38 -> 258
    //   223: aload 5
    //   225: astore 4
    //   227: aload 7
    //   229: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   232: getstatic 125	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   235: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +20 -> 258
    //   241: aload 5
    //   243: ifnonnull +15 -> 258
    //   246: aload 5
    //   248: astore 4
    //   250: getstatic 125	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   253: astore 5
    //   255: goto -81 -> 174
    //   258: aload 5
    //   260: astore 4
    //   262: getstatic 113	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   265: ldc 127
    //   267: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +56 -> 326
    //   273: aload 5
    //   275: ifnonnull +51 -> 326
    //   278: aload 5
    //   280: astore 4
    //   282: aload 7
    //   284: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   287: ldc 129
    //   289: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifne +20 -> 312
    //   295: aload 5
    //   297: astore 4
    //   299: aload 7
    //   301: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   304: ldc 131
    //   306: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq +17 -> 326
    //   312: aload 5
    //   314: astore 4
    //   316: aload 7
    //   318: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   321: astore 5
    //   323: goto -149 -> 174
    //   326: aload 5
    //   328: astore 4
    //   330: aload 7
    //   332: invokevirtual 135	java/io/File:getParentFile	()Ljava/io/File;
    //   335: astore 7
    //   337: goto -163 -> 174
    //   340: aload 6
    //   342: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   345: aload 9
    //   347: astore 4
    //   349: aload_1
    //   350: astore 9
    //   352: aconst_null
    //   353: astore 6
    //   355: aconst_null
    //   356: astore 10
    //   358: aconst_null
    //   359: astore 7
    //   361: aload 4
    //   363: astore 5
    //   365: aload 7
    //   367: astore_1
    //   368: aload 4
    //   370: ifnonnull +356 -> 726
    //   373: aload 4
    //   375: astore 5
    //   377: aload 7
    //   379: astore_1
    //   380: aload 9
    //   382: ifnull +344 -> 726
    //   385: aload 10
    //   387: astore_1
    //   388: new 78	java/util/zip/ZipFile
    //   391: dup
    //   392: aload_0
    //   393: invokespecial 81	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   396: astore_0
    //   397: sipush 4096
    //   400: newarray byte
    //   402: astore 12
    //   404: aload_0
    //   405: invokevirtual 85	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   408: astore 13
    //   410: aload 4
    //   412: astore 5
    //   414: aload 13
    //   416: invokeinterface 91 1 0
    //   421: ifeq +491 -> 912
    //   424: aload 13
    //   426: invokeinterface 95 1 0
    //   431: checkcast 97	java/util/zip/ZipEntry
    //   434: astore 14
    //   436: aload 14
    //   438: invokevirtual 100	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   441: astore 6
    //   443: aload 6
    //   445: ifnull -31 -> 414
    //   448: aload 6
    //   450: ldc 102
    //   452: invokevirtual 106	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   455: ifne -41 -> 414
    //   458: aload 6
    //   460: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   463: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   466: ifne -52 -> 414
    //   469: new 56	java/io/File
    //   472: dup
    //   473: new 67	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   480: aload 8
    //   482: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 6
    //   487: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   496: astore 4
    //   498: aload 6
    //   500: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   503: invokevirtual 145	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   506: istore_2
    //   507: aload 6
    //   509: astore_1
    //   510: iload_2
    //   511: iconst_m1
    //   512: if_icmpeq +12 -> 524
    //   515: aload 6
    //   517: iload_2
    //   518: iconst_1
    //   519: iadd
    //   520: invokevirtual 149	java/lang/String:substring	(I)Ljava/lang/String;
    //   523: astore_1
    //   524: new 56	java/io/File
    //   527: dup
    //   528: new 67	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   535: aload 8
    //   537: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   550: astore 15
    //   552: iconst_0
    //   553: istore_3
    //   554: aload 4
    //   556: astore_1
    //   557: iload_3
    //   558: istore_2
    //   559: aload_1
    //   560: ifnull +17 -> 577
    //   563: aload_1
    //   564: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   567: aload 9
    //   569: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   572: ifeq +210 -> 782
    //   575: iconst_1
    //   576: istore_2
    //   577: iload_2
    //   578: ifeq -164 -> 414
    //   581: aload 15
    //   583: invokevirtual 135	java/io/File:getParentFile	()Ljava/io/File;
    //   586: invokevirtual 152	java/io/File:mkdirs	()Z
    //   589: pop
    //   590: aconst_null
    //   591: astore 10
    //   593: aconst_null
    //   594: astore 11
    //   596: aconst_null
    //   597: astore_1
    //   598: aconst_null
    //   599: astore 7
    //   601: aload 10
    //   603: astore 6
    //   605: aload_0
    //   606: aload 14
    //   608: invokevirtual 156	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   611: astore 4
    //   613: aload 4
    //   615: astore 7
    //   617: aload 10
    //   619: astore 6
    //   621: aload 4
    //   623: astore_1
    //   624: new 158	java/io/FileOutputStream
    //   627: dup
    //   628: aload 15
    //   630: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   633: astore 10
    //   635: aload 4
    //   637: aload 12
    //   639: invokevirtual 167	java/io/InputStream:read	([B)I
    //   642: istore_2
    //   643: iload_2
    //   644: ifle +146 -> 790
    //   647: aload 10
    //   649: aload 12
    //   651: iconst_0
    //   652: iload_2
    //   653: invokevirtual 171	java/io/FileOutputStream:write	([BII)V
    //   656: goto -21 -> 635
    //   659: astore 5
    //   661: aload 4
    //   663: astore 7
    //   665: aload 10
    //   667: astore 4
    //   669: aload 4
    //   671: astore 6
    //   673: aload 7
    //   675: astore_1
    //   676: aload 5
    //   678: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   681: aload 4
    //   683: astore 6
    //   685: aload 7
    //   687: astore_1
    //   688: aload 5
    //   690: invokestatic 178	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   693: astore 5
    //   695: aload 5
    //   697: astore_1
    //   698: aload 4
    //   700: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   703: aload 7
    //   705: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   708: aload_1
    //   709: astore 4
    //   711: aload 4
    //   713: astore 5
    //   715: aload 4
    //   717: ifnull -303 -> 414
    //   720: aload_0
    //   721: astore_1
    //   722: aload 4
    //   724: astore 5
    //   726: aload_1
    //   727: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   730: aload 5
    //   732: areturn
    //   733: astore 6
    //   735: aload 7
    //   737: astore 5
    //   739: aload 5
    //   741: astore_1
    //   742: aload 6
    //   744: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   747: aload 5
    //   749: astore_1
    //   750: aload 6
    //   752: invokestatic 178	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   755: astore 6
    //   757: aload 6
    //   759: astore_1
    //   760: aload 5
    //   762: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   765: aload 4
    //   767: astore 9
    //   769: aload_1
    //   770: astore 4
    //   772: goto -420 -> 352
    //   775: astore_0
    //   776: aload_1
    //   777: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   780: aload_0
    //   781: athrow
    //   782: aload_1
    //   783: invokevirtual 135	java/io/File:getParentFile	()Ljava/io/File;
    //   786: astore_1
    //   787: goto -230 -> 557
    //   790: aload 10
    //   792: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   795: aload 4
    //   797: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   800: aload 5
    //   802: astore 4
    //   804: goto -93 -> 711
    //   807: aload 6
    //   809: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   812: aload_1
    //   813: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   816: aload 4
    //   818: athrow
    //   819: astore 4
    //   821: aload_0
    //   822: astore_1
    //   823: aload 4
    //   825: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   828: aload_0
    //   829: astore_1
    //   830: aload 4
    //   832: invokestatic 178	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   835: astore 4
    //   837: aload_0
    //   838: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   841: aload 4
    //   843: areturn
    //   844: astore_0
    //   845: aload_1
    //   846: invokestatic 141	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   849: aload_0
    //   850: athrow
    //   851: astore 4
    //   853: aload_0
    //   854: astore_1
    //   855: aload 4
    //   857: astore_0
    //   858: goto -13 -> 845
    //   861: astore 4
    //   863: aload 6
    //   865: astore_0
    //   866: goto -45 -> 821
    //   869: astore 5
    //   871: aload 10
    //   873: astore 6
    //   875: aload 4
    //   877: astore_1
    //   878: aload 5
    //   880: astore 4
    //   882: goto -75 -> 807
    //   885: astore 5
    //   887: aload 11
    //   889: astore 4
    //   891: goto -222 -> 669
    //   894: astore_0
    //   895: aload 6
    //   897: astore_1
    //   898: goto -122 -> 776
    //   901: astore_1
    //   902: aload 6
    //   904: astore 5
    //   906: aload_1
    //   907: astore 6
    //   909: goto -170 -> 739
    //   912: aload_0
    //   913: astore_1
    //   914: goto -188 -> 726
    //   917: astore 4
    //   919: goto -112 -> 807
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	922	0	paramString1	String
    //   0	922	1	paramString2	String
    //   506	147	2	i	int
    //   553	5	3	j	int
    //   44	773	4	localObject1	Object
    //   819	12	4	localIOException1	IOException
    //   835	7	4	str1	String
    //   851	5	4	localObject2	Object
    //   861	15	4	localIOException2	IOException
    //   880	10	4	localObject3	Object
    //   917	1	4	localObject4	Object
    //   50	363	5	localObject5	Object
    //   659	30	5	localIOException3	IOException
    //   693	108	5	localObject6	Object
    //   869	10	5	localObject7	Object
    //   885	1	5	localIOException4	IOException
    //   904	1	5	localObject8	Object
    //   60	624	6	localObject9	Object
    //   733	18	6	localIOException5	IOException
    //   755	153	6	localObject10	Object
    //   41	695	7	localObject11	Object
    //   1	535	8	str2	String
    //   36	732	9	localObject12	Object
    //   47	825	10	localObject13	Object
    //   594	294	11	localObject14	Object
    //   402	248	12	arrayOfByte	byte[]
    //   408	17	13	localEnumeration	java.util.Enumeration
    //   434	173	14	localZipEntry	java.util.zip.ZipEntry
    //   550	79	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   635	643	659	java/io/IOException
    //   647	656	659	java/io/IOException
    //   52	62	733	java/io/IOException
    //   52	62	775	finally
    //   742	747	775	finally
    //   750	757	775	finally
    //   397	410	819	java/io/IOException
    //   414	443	819	java/io/IOException
    //   448	507	819	java/io/IOException
    //   515	524	819	java/io/IOException
    //   524	552	819	java/io/IOException
    //   563	575	819	java/io/IOException
    //   581	590	819	java/io/IOException
    //   698	708	819	java/io/IOException
    //   782	787	819	java/io/IOException
    //   790	800	819	java/io/IOException
    //   807	819	819	java/io/IOException
    //   388	397	844	finally
    //   823	828	844	finally
    //   830	837	844	finally
    //   397	410	851	finally
    //   414	443	851	finally
    //   448	507	851	finally
    //   515	524	851	finally
    //   524	552	851	finally
    //   563	575	851	finally
    //   581	590	851	finally
    //   698	708	851	finally
    //   782	787	851	finally
    //   790	800	851	finally
    //   807	819	851	finally
    //   388	397	861	java/io/IOException
    //   635	643	869	finally
    //   647	656	869	finally
    //   605	613	885	java/io/IOException
    //   624	635	885	java/io/IOException
    //   66	73	894	finally
    //   79	89	894	finally
    //   92	107	894	finally
    //   115	125	894	finally
    //   128	139	894	finally
    //   142	171	894	finally
    //   186	200	894	finally
    //   204	208	894	finally
    //   215	223	894	finally
    //   227	241	894	finally
    //   250	255	894	finally
    //   262	273	894	finally
    //   282	295	894	finally
    //   299	312	894	finally
    //   316	323	894	finally
    //   330	337	894	finally
    //   66	73	901	java/io/IOException
    //   79	89	901	java/io/IOException
    //   92	107	901	java/io/IOException
    //   115	125	901	java/io/IOException
    //   128	139	901	java/io/IOException
    //   142	171	901	java/io/IOException
    //   186	200	901	java/io/IOException
    //   204	208	901	java/io/IOException
    //   215	223	901	java/io/IOException
    //   227	241	901	java/io/IOException
    //   250	255	901	java/io/IOException
    //   262	273	901	java/io/IOException
    //   282	295	901	java/io/IOException
    //   299	312	901	java/io/IOException
    //   316	323	901	java/io/IOException
    //   330	337	901	java/io/IOException
    //   605	613	917	finally
    //   624	635	917	finally
    //   676	681	917	finally
    //   688	695	917	finally
  }
  
  private static String extractPluginAndGetMd5Code(Context paramContext, String paramString)
    throws Exception
  {
    return extractPluginAndGetMd5Code(paramContext, paramString, getInstallPath(paramContext, paramString));
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 201	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   5: aload_1
    //   6: ldc 203
    //   8: ldc 205
    //   10: invokevirtual 208	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 9
    //   15: aload_2
    //   16: invokevirtual 211	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 214	java/io/File:delete	()Z
    //   26: pop
    //   27: new 56	java/io/File
    //   30: dup
    //   31: new 67	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc 23
    //   44: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: aload 8
    //   57: invokevirtual 211	java/io/File:exists	()Z
    //   60: ifeq +9 -> 69
    //   63: aload 8
    //   65: invokevirtual 214	java/io/File:delete	()Z
    //   68: pop
    //   69: aload 8
    //   71: invokevirtual 220	java/io/File:createNewFile	()Z
    //   74: pop
    //   75: aconst_null
    //   76: astore 5
    //   78: aconst_null
    //   79: astore_1
    //   80: aconst_null
    //   81: astore 6
    //   83: aconst_null
    //   84: astore 7
    //   86: aload 6
    //   88: astore 4
    //   90: aload_0
    //   91: invokevirtual 226	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   94: new 67	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   101: ldc 228
    //   103: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 9
    //   108: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 234	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_1
    //   120: aload 6
    //   122: astore 4
    //   124: aload_0
    //   125: astore 5
    //   127: new 158	java/io/FileOutputStream
    //   130: dup
    //   131: aload 8
    //   133: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore 6
    //   138: sipush 8192
    //   141: newarray byte
    //   143: astore_1
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 167	java/io/InputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: iconst_m1
    //   152: if_icmpeq +46 -> 198
    //   155: aload 6
    //   157: aload_1
    //   158: iconst_0
    //   159: iload_3
    //   160: invokevirtual 237	java/io/OutputStream:write	([BII)V
    //   163: goto -19 -> 144
    //   166: astore_2
    //   167: aload 6
    //   169: astore 4
    //   171: aload_0
    //   172: astore_1
    //   173: new 186	java/lang/Exception
    //   176: dup
    //   177: ldc 239
    //   179: aload_2
    //   180: invokespecial 242	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: athrow
    //   184: astore_2
    //   185: aload_1
    //   186: astore_0
    //   187: aload_0
    //   188: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   191: aload 4
    //   193: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   196: aload_2
    //   197: athrow
    //   198: aload 8
    //   200: aload_2
    //   201: invokevirtual 246	java/io/File:renameTo	(Ljava/io/File;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 249	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   209: invokestatic 255	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore_1
    //   213: aload_0
    //   214: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   217: aload 6
    //   219: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   222: aload_1
    //   223: areturn
    //   224: astore_2
    //   225: aload 6
    //   227: astore 4
    //   229: goto -42 -> 187
    //   232: astore_2
    //   233: aload 5
    //   235: astore_0
    //   236: aload 7
    //   238: astore 4
    //   240: goto -69 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramContext	Context
    //   0	243	1	paramString	String
    //   0	243	2	paramFile	File
    //   149	11	3	i	int
    //   88	151	4	localObject1	Object
    //   76	158	5	localContext	Context
    //   81	145	6	localFileOutputStream	java.io.FileOutputStream
    //   84	153	7	localObject2	Object
    //   53	146	8	localFile	File
    //   13	94	9	str	String
    // Exception table:
    //   from	to	target	type
    //   138	144	166	java/lang/Exception
    //   144	150	166	java/lang/Exception
    //   155	163	166	java/lang/Exception
    //   198	213	166	java/lang/Exception
    //   90	118	184	finally
    //   127	138	184	finally
    //   173	184	184	finally
    //   138	144	224	finally
    //   144	150	224	finally
    //   155	163	224	finally
    //   198	213	224	finally
    //   90	118	232	java/lang/Exception
    //   127	138	232	java/lang/Exception
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static File getInstallPath(Context paramContext, String paramString)
  {
    File localFile = (File)sInstallPathMap.get(paramString);
    Object localObject = localFile;
    int i;
    if (localFile == null)
    {
      localObject = getPluginPath(paramContext);
      if (localObject == null) {
        return null;
      }
      i = paramString.lastIndexOf('.');
      if ((i == -1) || (paramString.substring(i).equalsIgnoreCase(".apk"))) {
        break label116;
      }
      paramContext = paramString.substring(0, i) + ".apk";
    }
    for (;;)
    {
      paramString = new File((File)localObject, paramContext);
      localObject = paramString;
      if (paramString != null)
      {
        sInstallPathMap.put(paramContext, paramString);
        localObject = paramString;
      }
      return localObject;
      label116:
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  public static File getInstalledPluginPath(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File getLibPath(Context paramContext)
  {
    return paramContext.getDir("lib", 0);
  }
  
  public static File getOptimizedDexPath(Context paramContext)
  {
    return paramContext.getDir("odex", 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo = (PackageInfo)sPackageInfoMap.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        sPackageInfoMap.put(paramString, localPackageInfo);
        paramContext = localPackageInfo;
      }
    }
    return paramContext;
  }
  
  static File getPluginPath(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  @Deprecated
  public static String installPlugin(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = getInstallPath(paramContext, paramString1);
    DebugHelper.debug("PluginUtils.installPlugin installPath = " + localFile + ", extraId = " + paramString2);
    boolean bool = false;
    if (localFile.exists()) {
      bool = quickVerifyCrcCode(paramContext, paramString1, paramString2);
    }
    DebugHelper.debug("PluginUtils.installPlugin installed: " + bool);
    Object localObject1;
    if (bool)
    {
      sExtraIds.put(paramString1, paramString2);
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        sPackageInfoMap.remove(localFile.getCanonicalPath());
        label116:
        readManifest(paramContext);
        Object localObject3 = "";
        String str1 = null;
        try
        {
          localObject1 = extractPluginAndGetMd5Code(paramContext, paramString1);
          localObject3 = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            str1 = getExceptionInfo(localException);
          }
          Object localObject2 = str1;
        }
        String str2 = (String)sManifest.get(paramString1);
        bool = ((String)localObject3).equals(str2);
        if ((str1 == null) && (bool)) {
          try
          {
            localObject1 = getLibPath(paramContext).getCanonicalPath();
            str1 = extractLibs(localFile.getCanonicalPath(), (String)localObject1);
            localObject1 = str1;
            if (str1 != null) {
              continue;
            }
            sExtraIds.put(paramString1, paramString2);
            markPluginMd5Code(paramContext, paramString1, (String)localObject3);
            return str1;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            localFile.delete();
            return getExceptionInfo(paramContext);
          }
        }
        if (str1 != null) {
          continue;
        }
        return getExceptionInfo(new VerifyError("real=" + (String)localObject3 + ", conf=" + str2));
      }
      catch (IOException localIOException)
      {
        break label116;
      }
    }
  }
  
  @Deprecated
  public static boolean isPluginInstalled(Context paramContext, String paramString1, String paramString2)
  {
    if (((String)sExtraIds.get(paramString1) == null) && (paramString2.equals("0"))) {
      return false;
    }
    return quickVerifyCrcCode(paramContext, paramString1, paramString2);
  }
  
  /* Error */
  private static String markPluginMd5Code(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: new 158	java/io/FileOutputStream
    //   11: dup
    //   12: new 67	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 190	com/tencent/mobileqq/pluginsdk/PluginUtils:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   24: invokevirtual 249	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   27: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 388
    //   33: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 389	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokevirtual 397	java/lang/String:getBytes	()[B
    //   51: invokevirtual 400	java/io/FileOutputStream:write	([B)V
    //   54: aload_0
    //   55: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_1
    //   61: aload 4
    //   63: astore_0
    //   64: aload_0
    //   65: astore_3
    //   66: aload_1
    //   67: invokevirtual 401	java/io/FileNotFoundException:printStackTrace	()V
    //   70: aload_0
    //   71: astore_3
    //   72: aload_1
    //   73: invokestatic 178	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aload 5
    //   86: astore_0
    //   87: aload_0
    //   88: astore_3
    //   89: aload_1
    //   90: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 178	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_0
    //   101: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic 182	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: aload_0
    //   115: astore_3
    //   116: aload_1
    //   117: astore_0
    //   118: goto -11 -> 107
    //   121: astore_1
    //   122: goto -35 -> 87
    //   125: astore_1
    //   126: goto -62 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString1	String
    //   0	129	2	paramString2	String
    //   4	112	3	localContext	Context
    //   6	56	4	localObject1	Object
    //   1	84	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	43	60	java/io/FileNotFoundException
    //   8	43	83	java/io/IOException
    //   8	43	106	finally
    //   66	70	106	finally
    //   72	77	106	finally
    //   89	93	106	finally
    //   95	100	106	finally
    //   43	54	113	finally
    //   43	54	121	java/io/IOException
    //   43	54	125	java/io/FileNotFoundException
  }
  
  static boolean quickVerifyCrcCode(Context paramContext, String paramString1, String paramString2)
  {
    readManifest(paramContext);
    boolean bool = false;
    try
    {
      paramContext = getInstallPath(paramContext, paramString1);
      paramContext = new File(paramContext.getCanonicalPath() + ".id");
      if (paramContext.exists()) {
        bool = IOUtil.contentEquals(paramContext, (String)sManifest.get(paramString1));
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  /* Error */
  static void readManifest(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/mobileqq/pluginsdk/PluginUtils:sVerionRecLocker	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: getstatic 367	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   9: ifnonnull +107 -> 116
    //   12: new 42	java/util/concurrent/ConcurrentHashMap
    //   15: dup
    //   16: invokespecial 43	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   19: putstatic 367	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   22: aconst_null
    //   23: astore_1
    //   24: aconst_null
    //   25: astore_2
    //   26: new 407	java/io/BufferedReader
    //   29: dup
    //   30: new 409	java/io/InputStreamReader
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 226	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   38: ldc_w 411
    //   41: invokevirtual 234	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: invokespecial 414	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 417	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 420	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +62 -> 119
    //   60: aload_1
    //   61: invokevirtual 423	java/lang/String:trim	()Ljava/lang/String;
    //   64: ldc_w 425
    //   67: invokevirtual 429	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 4
    //   72: aload 4
    //   74: iconst_0
    //   75: aaload
    //   76: astore_2
    //   77: ldc_w 363
    //   80: astore_1
    //   81: aload 4
    //   83: arraylength
    //   84: iconst_1
    //   85: if_icmple +8 -> 93
    //   88: aload 4
    //   90: iconst_1
    //   91: aaload
    //   92: astore_1
    //   93: getstatic 367	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   96: aload_2
    //   97: aload_1
    //   98: invokeinterface 307 3 0
    //   103: pop
    //   104: goto -53 -> 51
    //   107: astore_1
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 432	java/io/BufferedReader:close	()V
    //   116: aload_3
    //   117: monitorexit
    //   118: return
    //   119: aload_0
    //   120: ifnull -4 -> 116
    //   123: aload_0
    //   124: invokevirtual 432	java/io/BufferedReader:close	()V
    //   127: goto -11 -> 116
    //   130: astore_0
    //   131: goto -15 -> 116
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 432	java/io/BufferedReader:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: aload_3
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    //   150: astore_0
    //   151: goto -35 -> 116
    //   154: astore_1
    //   155: goto -12 -> 143
    //   158: astore_2
    //   159: aload_0
    //   160: astore_1
    //   161: aload_2
    //   162: astore_0
    //   163: goto -28 -> 135
    //   166: astore_0
    //   167: aload_2
    //   168: astore_0
    //   169: goto -61 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   23	75	1	str	String
    //   107	33	1	localIOException	IOException
    //   154	1	1	localException	Exception
    //   160	1	1	localContext	Context
    //   25	72	2	localObject1	Object
    //   158	10	2	localObject2	Object
    //   3	144	3	localObject3	Object
    //   70	19	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   51	56	107	java/io/IOException
    //   60	72	107	java/io/IOException
    //   81	88	107	java/io/IOException
    //   93	104	107	java/io/IOException
    //   123	127	130	java/lang/Exception
    //   26	51	134	finally
    //   6	22	145	finally
    //   112	116	145	finally
    //   116	118	145	finally
    //   123	127	145	finally
    //   139	143	145	finally
    //   143	145	145	finally
    //   146	148	145	finally
    //   112	116	150	java/lang/Exception
    //   139	143	154	java/lang/Exception
    //   51	56	158	finally
    //   60	72	158	finally
    //   81	88	158	finally
    //   93	104	158	finally
    //   26	51	166	java/io/IOException
  }
  
  static void unInstallPlugin(Context paramContext, String paramString)
  {
    paramContext = getInstallPath(paramContext, paramString);
    if (paramContext != null) {
      paramContext.delete();
    }
    try
    {
      paramContext = new File(paramContext.getCanonicalPath() + ".id");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      return;
    }
    catch (IOException paramContext) {}
  }
  
  static boolean verifyCrcCode(Context paramContext, String paramString1, String paramString2)
  {
    if (((String)sExtraIds.get(paramString1) == null) && (paramString2.equals("0"))) {}
    for (;;)
    {
      return false;
      try
      {
        readManifest(paramContext);
        paramContext = getInstallPath(paramContext, paramString1);
        paramString1 = (String)sManifest.get(paramString1);
        paramContext = PluginStatic.encodeFile(paramContext.getCanonicalPath());
        QLog.d("PluginDebug", 1, "verifyCrcCode apkCrcCode = " + paramContext + ", ManifestCrcCode = " + paramString1);
        if (paramContext.equals(paramString1))
        {
          boolean bool = "".equals(paramContext);
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  static class GetPackageInfoFailException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public GetPackageInfoFailException(String paramString)
    {
      super();
    }
  }
  
  static class PluginActivityNotFoundException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginUtils
 * JD-Core Version:    0.7.0.1
 */