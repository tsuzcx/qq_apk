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
    //   86: ifeq +236 -> 322
    //   89: aload_1
    //   90: astore 4
    //   92: aload 10
    //   94: invokeinterface 95 1 0
    //   99: checkcast 97	java/util/zip/ZipEntry
    //   102: invokevirtual 100	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   105: astore 5
    //   107: aload_1
    //   108: astore 4
    //   110: aload 5
    //   112: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   118: ifne -42 -> 76
    //   121: aload_1
    //   122: astore 4
    //   124: new 56	java/io/File
    //   127: dup
    //   128: new 67	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   135: aload 8
    //   137: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 5
    //   142: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 7
    //   153: aload_1
    //   154: astore 5
    //   156: aload 5
    //   158: astore_1
    //   159: aload 7
    //   161: ifnull -85 -> 76
    //   164: aload 5
    //   166: astore 4
    //   168: aload 7
    //   170: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   173: getstatic 107	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   176: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +14 -> 193
    //   182: aload 5
    //   184: astore 4
    //   186: getstatic 107	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   189: astore_1
    //   190: goto -114 -> 76
    //   193: aload 5
    //   195: astore 4
    //   197: getstatic 116	android/os/Build$VERSION:SDK_INT	I
    //   200: bipush 7
    //   202: if_icmple +38 -> 240
    //   205: aload 5
    //   207: astore 4
    //   209: aload 7
    //   211: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   214: getstatic 119	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   217: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq +20 -> 240
    //   223: aload 5
    //   225: ifnonnull +15 -> 240
    //   228: aload 5
    //   230: astore 4
    //   232: getstatic 119	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   235: astore 5
    //   237: goto -81 -> 156
    //   240: aload 5
    //   242: astore 4
    //   244: getstatic 107	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   247: ldc 121
    //   249: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: ifeq +56 -> 308
    //   255: aload 5
    //   257: ifnonnull +51 -> 308
    //   260: aload 5
    //   262: astore 4
    //   264: aload 7
    //   266: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   269: ldc 123
    //   271: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifne +20 -> 294
    //   277: aload 5
    //   279: astore 4
    //   281: aload 7
    //   283: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   286: ldc 125
    //   288: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq +17 -> 308
    //   294: aload 5
    //   296: astore 4
    //   298: aload 7
    //   300: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   303: astore 5
    //   305: goto -149 -> 156
    //   308: aload 5
    //   310: astore 4
    //   312: aload 7
    //   314: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   317: astore 7
    //   319: goto -163 -> 156
    //   322: aload 6
    //   324: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   327: aload 9
    //   329: astore 4
    //   331: aload_1
    //   332: astore 9
    //   334: aconst_null
    //   335: astore 6
    //   337: aconst_null
    //   338: astore 10
    //   340: aconst_null
    //   341: astore 7
    //   343: aload 4
    //   345: astore 5
    //   347: aload 7
    //   349: astore_1
    //   350: aload 4
    //   352: ifnonnull +341 -> 693
    //   355: aload 4
    //   357: astore 5
    //   359: aload 7
    //   361: astore_1
    //   362: aload 9
    //   364: ifnull +329 -> 693
    //   367: aload 10
    //   369: astore_1
    //   370: new 78	java/util/zip/ZipFile
    //   373: dup
    //   374: aload_0
    //   375: invokespecial 81	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   378: astore_0
    //   379: sipush 4096
    //   382: newarray byte
    //   384: astore 12
    //   386: aload_0
    //   387: invokevirtual 85	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   390: astore 13
    //   392: aload 4
    //   394: astore 5
    //   396: aload 13
    //   398: invokeinterface 91 1 0
    //   403: ifeq +476 -> 879
    //   406: aload 13
    //   408: invokeinterface 95 1 0
    //   413: checkcast 97	java/util/zip/ZipEntry
    //   416: astore 14
    //   418: aload 14
    //   420: invokevirtual 100	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   423: astore 6
    //   425: aload 6
    //   427: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   430: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   433: ifne -37 -> 396
    //   436: new 56	java/io/File
    //   439: dup
    //   440: new 67	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   447: aload 8
    //   449: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 6
    //   454: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   463: astore 4
    //   465: aload 6
    //   467: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   470: invokevirtual 139	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   473: istore_2
    //   474: aload 6
    //   476: astore_1
    //   477: iload_2
    //   478: iconst_m1
    //   479: if_icmpeq +12 -> 491
    //   482: aload 6
    //   484: iload_2
    //   485: iconst_1
    //   486: iadd
    //   487: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   490: astore_1
    //   491: new 56	java/io/File
    //   494: dup
    //   495: new 67	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   502: aload 8
    //   504: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_1
    //   508: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   517: astore 15
    //   519: iconst_0
    //   520: istore_3
    //   521: aload 4
    //   523: astore_1
    //   524: iload_3
    //   525: istore_2
    //   526: aload_1
    //   527: ifnull +17 -> 544
    //   530: aload_1
    //   531: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   534: aload 9
    //   536: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifeq +210 -> 749
    //   542: iconst_1
    //   543: istore_2
    //   544: iload_2
    //   545: ifeq -149 -> 396
    //   548: aload 15
    //   550: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   553: invokevirtual 146	java/io/File:mkdirs	()Z
    //   556: pop
    //   557: aconst_null
    //   558: astore 10
    //   560: aconst_null
    //   561: astore 11
    //   563: aconst_null
    //   564: astore_1
    //   565: aconst_null
    //   566: astore 7
    //   568: aload 10
    //   570: astore 6
    //   572: aload_0
    //   573: aload 14
    //   575: invokevirtual 150	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   578: astore 4
    //   580: aload 4
    //   582: astore 7
    //   584: aload 10
    //   586: astore 6
    //   588: aload 4
    //   590: astore_1
    //   591: new 152	java/io/FileOutputStream
    //   594: dup
    //   595: aload 15
    //   597: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   600: astore 10
    //   602: aload 4
    //   604: aload 12
    //   606: invokevirtual 161	java/io/InputStream:read	([B)I
    //   609: istore_2
    //   610: iload_2
    //   611: ifle +146 -> 757
    //   614: aload 10
    //   616: aload 12
    //   618: iconst_0
    //   619: iload_2
    //   620: invokevirtual 165	java/io/FileOutputStream:write	([BII)V
    //   623: goto -21 -> 602
    //   626: astore 5
    //   628: aload 4
    //   630: astore 7
    //   632: aload 10
    //   634: astore 4
    //   636: aload 4
    //   638: astore 6
    //   640: aload 7
    //   642: astore_1
    //   643: aload 5
    //   645: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   648: aload 4
    //   650: astore 6
    //   652: aload 7
    //   654: astore_1
    //   655: aload 5
    //   657: invokestatic 172	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   660: astore 5
    //   662: aload 5
    //   664: astore_1
    //   665: aload 4
    //   667: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   670: aload 7
    //   672: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   675: aload_1
    //   676: astore 4
    //   678: aload 4
    //   680: astore 5
    //   682: aload 4
    //   684: ifnull -288 -> 396
    //   687: aload_0
    //   688: astore_1
    //   689: aload 4
    //   691: astore 5
    //   693: aload_1
    //   694: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   697: aload 5
    //   699: areturn
    //   700: astore 6
    //   702: aload 7
    //   704: astore 5
    //   706: aload 5
    //   708: astore_1
    //   709: aload 6
    //   711: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   714: aload 5
    //   716: astore_1
    //   717: aload 6
    //   719: invokestatic 172	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   722: astore 6
    //   724: aload 6
    //   726: astore_1
    //   727: aload 5
    //   729: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   732: aload 4
    //   734: astore 9
    //   736: aload_1
    //   737: astore 4
    //   739: goto -405 -> 334
    //   742: astore_0
    //   743: aload_1
    //   744: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   747: aload_0
    //   748: athrow
    //   749: aload_1
    //   750: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   753: astore_1
    //   754: goto -230 -> 524
    //   757: aload 10
    //   759: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   762: aload 4
    //   764: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   767: aload 5
    //   769: astore 4
    //   771: goto -93 -> 678
    //   774: aload 6
    //   776: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   779: aload_1
    //   780: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   783: aload 4
    //   785: athrow
    //   786: astore 4
    //   788: aload_0
    //   789: astore_1
    //   790: aload 4
    //   792: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   795: aload_0
    //   796: astore_1
    //   797: aload 4
    //   799: invokestatic 172	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   802: astore 4
    //   804: aload_0
    //   805: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   808: aload 4
    //   810: areturn
    //   811: astore_0
    //   812: aload_1
    //   813: invokestatic 135	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   816: aload_0
    //   817: athrow
    //   818: astore 4
    //   820: aload_0
    //   821: astore_1
    //   822: aload 4
    //   824: astore_0
    //   825: goto -13 -> 812
    //   828: astore 4
    //   830: aload 6
    //   832: astore_0
    //   833: goto -45 -> 788
    //   836: astore 5
    //   838: aload 10
    //   840: astore 6
    //   842: aload 4
    //   844: astore_1
    //   845: aload 5
    //   847: astore 4
    //   849: goto -75 -> 774
    //   852: astore 5
    //   854: aload 11
    //   856: astore 4
    //   858: goto -222 -> 636
    //   861: astore_0
    //   862: aload 6
    //   864: astore_1
    //   865: goto -122 -> 743
    //   868: astore_1
    //   869: aload 6
    //   871: astore 5
    //   873: aload_1
    //   874: astore 6
    //   876: goto -170 -> 706
    //   879: aload_0
    //   880: astore_1
    //   881: goto -188 -> 693
    //   884: astore 4
    //   886: goto -112 -> 774
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	paramString1	String
    //   0	889	1	paramString2	String
    //   473	147	2	i	int
    //   520	5	3	j	int
    //   44	740	4	localObject1	Object
    //   786	12	4	localIOException1	IOException
    //   802	7	4	str1	String
    //   818	5	4	localObject2	Object
    //   828	15	4	localIOException2	IOException
    //   847	10	4	localObject3	Object
    //   884	1	4	localObject4	Object
    //   50	345	5	localObject5	Object
    //   626	30	5	localIOException3	IOException
    //   660	108	5	localObject6	Object
    //   836	10	5	localObject7	Object
    //   852	1	5	localIOException4	IOException
    //   871	1	5	localObject8	Object
    //   60	591	6	localObject9	Object
    //   700	18	6	localIOException5	IOException
    //   722	153	6	localObject10	Object
    //   41	662	7	localObject11	Object
    //   1	502	8	str2	String
    //   36	699	9	localObject12	Object
    //   47	792	10	localObject13	Object
    //   561	294	11	localObject14	Object
    //   384	233	12	arrayOfByte	byte[]
    //   390	17	13	localEnumeration	java.util.Enumeration
    //   416	158	14	localZipEntry	java.util.zip.ZipEntry
    //   517	79	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   602	610	626	java/io/IOException
    //   614	623	626	java/io/IOException
    //   52	62	700	java/io/IOException
    //   52	62	742	finally
    //   709	714	742	finally
    //   717	724	742	finally
    //   379	392	786	java/io/IOException
    //   396	474	786	java/io/IOException
    //   482	491	786	java/io/IOException
    //   491	519	786	java/io/IOException
    //   530	542	786	java/io/IOException
    //   548	557	786	java/io/IOException
    //   665	675	786	java/io/IOException
    //   749	754	786	java/io/IOException
    //   757	767	786	java/io/IOException
    //   774	786	786	java/io/IOException
    //   370	379	811	finally
    //   790	795	811	finally
    //   797	804	811	finally
    //   379	392	818	finally
    //   396	474	818	finally
    //   482	491	818	finally
    //   491	519	818	finally
    //   530	542	818	finally
    //   548	557	818	finally
    //   665	675	818	finally
    //   749	754	818	finally
    //   757	767	818	finally
    //   774	786	818	finally
    //   370	379	828	java/io/IOException
    //   602	610	836	finally
    //   614	623	836	finally
    //   572	580	852	java/io/IOException
    //   591	602	852	java/io/IOException
    //   66	73	861	finally
    //   79	89	861	finally
    //   92	107	861	finally
    //   110	121	861	finally
    //   124	153	861	finally
    //   168	182	861	finally
    //   186	190	861	finally
    //   197	205	861	finally
    //   209	223	861	finally
    //   232	237	861	finally
    //   244	255	861	finally
    //   264	277	861	finally
    //   281	294	861	finally
    //   298	305	861	finally
    //   312	319	861	finally
    //   66	73	868	java/io/IOException
    //   79	89	868	java/io/IOException
    //   92	107	868	java/io/IOException
    //   110	121	868	java/io/IOException
    //   124	153	868	java/io/IOException
    //   168	182	868	java/io/IOException
    //   186	190	868	java/io/IOException
    //   197	205	868	java/io/IOException
    //   209	223	868	java/io/IOException
    //   232	237	868	java/io/IOException
    //   244	255	868	java/io/IOException
    //   264	277	868	java/io/IOException
    //   281	294	868	java/io/IOException
    //   298	305	868	java/io/IOException
    //   312	319	868	java/io/IOException
    //   572	580	884	finally
    //   591	602	884	finally
    //   643	648	884	finally
    //   655	662	884	finally
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
    //   0: ldc 190
    //   2: invokestatic 195	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   5: aload_1
    //   6: ldc 197
    //   8: ldc 199
    //   10: invokevirtual 202	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 9
    //   15: aload_2
    //   16: invokevirtual 205	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 208	java/io/File:delete	()Z
    //   26: pop
    //   27: new 56	java/io/File
    //   30: dup
    //   31: new 67	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc 23
    //   44: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: aload 8
    //   57: invokevirtual 205	java/io/File:exists	()Z
    //   60: ifeq +9 -> 69
    //   63: aload 8
    //   65: invokevirtual 208	java/io/File:delete	()Z
    //   68: pop
    //   69: aload 8
    //   71: invokevirtual 214	java/io/File:createNewFile	()Z
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
    //   91: invokevirtual 220	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   94: new 67	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   101: ldc 222
    //   103: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 9
    //   108: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 228	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_1
    //   120: aload 6
    //   122: astore 4
    //   124: aload_0
    //   125: astore 5
    //   127: new 152	java/io/FileOutputStream
    //   130: dup
    //   131: aload 8
    //   133: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore 6
    //   138: sipush 8192
    //   141: newarray byte
    //   143: astore_1
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 161	java/io/InputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: iconst_m1
    //   152: if_icmpeq +46 -> 198
    //   155: aload 6
    //   157: aload_1
    //   158: iconst_0
    //   159: iload_3
    //   160: invokevirtual 231	java/io/OutputStream:write	([BII)V
    //   163: goto -19 -> 144
    //   166: astore_2
    //   167: aload 6
    //   169: astore 4
    //   171: aload_0
    //   172: astore_1
    //   173: new 180	java/lang/Exception
    //   176: dup
    //   177: ldc 233
    //   179: aload_2
    //   180: invokespecial 236	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: athrow
    //   184: astore_2
    //   185: aload_1
    //   186: astore_0
    //   187: aload_0
    //   188: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   191: aload 4
    //   193: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   196: aload_2
    //   197: athrow
    //   198: aload 8
    //   200: aload_2
    //   201: invokevirtual 240	java/io/File:renameTo	(Ljava/io/File;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 243	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   209: invokestatic 249	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore_1
    //   213: aload_0
    //   214: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   217: aload 6
    //   219: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
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
    //   8: new 152	java/io/FileOutputStream
    //   11: dup
    //   12: new 67	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 184	com/tencent/mobileqq/pluginsdk/PluginUtils:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   24: invokevirtual 243	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   27: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 382
    //   33: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 383	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 387	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokevirtual 391	java/lang/String:getBytes	()[B
    //   51: invokevirtual 394	java/io/FileOutputStream:write	([B)V
    //   54: aload_0
    //   55: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_1
    //   61: aload 4
    //   63: astore_0
    //   64: aload_0
    //   65: astore_3
    //   66: aload_1
    //   67: invokevirtual 395	java/io/FileNotFoundException:printStackTrace	()V
    //   70: aload_0
    //   71: astore_3
    //   72: aload_1
    //   73: invokestatic 172	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aload 5
    //   86: astore_0
    //   87: aload_0
    //   88: astore_3
    //   89: aload_1
    //   90: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 172	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_0
    //   101: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic 176	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
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
    //   6: getstatic 361	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   9: ifnonnull +107 -> 116
    //   12: new 42	java/util/concurrent/ConcurrentHashMap
    //   15: dup
    //   16: invokespecial 43	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   19: putstatic 361	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   22: aconst_null
    //   23: astore_1
    //   24: aconst_null
    //   25: astore_2
    //   26: new 401	java/io/BufferedReader
    //   29: dup
    //   30: new 403	java/io/InputStreamReader
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 220	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   38: ldc_w 405
    //   41: invokevirtual 228	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: invokespecial 408	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 411	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 414	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +62 -> 119
    //   60: aload_1
    //   61: invokevirtual 417	java/lang/String:trim	()Ljava/lang/String;
    //   64: ldc_w 419
    //   67: invokevirtual 423	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 4
    //   72: aload 4
    //   74: iconst_0
    //   75: aaload
    //   76: astore_2
    //   77: ldc_w 357
    //   80: astore_1
    //   81: aload 4
    //   83: arraylength
    //   84: iconst_1
    //   85: if_icmple +8 -> 93
    //   88: aload 4
    //   90: iconst_1
    //   91: aaload
    //   92: astore_1
    //   93: getstatic 361	com/tencent/mobileqq/pluginsdk/PluginUtils:sManifest	Ljava/util/Map;
    //   96: aload_2
    //   97: aload_1
    //   98: invokeinterface 301 3 0
    //   103: pop
    //   104: goto -53 -> 51
    //   107: astore_1
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 426	java/io/BufferedReader:close	()V
    //   116: aload_3
    //   117: monitorexit
    //   118: return
    //   119: aload_0
    //   120: ifnull -4 -> 116
    //   123: aload_0
    //   124: invokevirtual 426	java/io/BufferedReader:close	()V
    //   127: goto -11 -> 116
    //   130: astore_0
    //   131: goto -15 -> 116
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 426	java/io/BufferedReader:close	()V
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