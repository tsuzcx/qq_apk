package com.tencent.mqp.app.sec;

import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  private static final String FAKE_PATH_USE_CACHE = "abcdef";
  private static String sCachedMd5;
  private static AtomicBoolean sIsDownloading = new AtomicBoolean(false);
  private static boolean sIsFirstTimeUseCache;
  public static String tag = "downloadfile";
  public static String zipfeaturefilepath = "";
  
  static
  {
    sIsFirstTimeUseCache = true;
  }
  
  /* Error */
  public static String d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 46	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 49	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 53	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 55	java/net/HttpURLConnection
    //   14: astore 6
    //   16: new 57	java/io/BufferedInputStream
    //   19: dup
    //   20: aload 6
    //   22: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 7
    //   30: new 66	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   38: astore 4
    //   40: aload 4
    //   42: astore_0
    //   43: sipush 512
    //   46: newarray byte
    //   48: astore 5
    //   50: aload 4
    //   52: astore_0
    //   53: aload 7
    //   55: aload 5
    //   57: iconst_0
    //   58: sipush 512
    //   61: invokevirtual 71	java/io/BufferedInputStream:read	([BII)I
    //   64: istore_2
    //   65: iload_2
    //   66: iconst_m1
    //   67: if_icmpeq +96 -> 163
    //   70: aload 4
    //   72: astore_0
    //   73: aload 4
    //   75: aload 5
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 75	java/io/FileOutputStream:write	([BII)V
    //   82: goto -32 -> 50
    //   85: astore 5
    //   87: aload 4
    //   89: astore_0
    //   90: aload 5
    //   92: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: ifnull +8 -> 105
    //   100: aload 4
    //   102: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   105: aload 7
    //   107: ifnull +8 -> 115
    //   110: aload 7
    //   112: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   115: aload 6
    //   117: ifnull +8 -> 125
    //   120: aload 6
    //   122: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   125: new 87	java/io/File
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: invokevirtual 92	java/io/File:exists	()Z
    //   136: ifne +117 -> 253
    //   139: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +12 -> 154
    //   145: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   148: iconst_2
    //   149: ldc 99
    //   151: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   161: aconst_null
    //   162: areturn
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   173: aload 7
    //   175: ifnull +8 -> 183
    //   178: aload 7
    //   180: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   183: aload 6
    //   185: ifnull -60 -> 125
    //   188: aload 6
    //   190: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   193: goto -68 -> 125
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   201: goto -76 -> 125
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   209: goto -84 -> 125
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   223: aload 7
    //   225: ifnull +8 -> 233
    //   228: aload 7
    //   230: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   233: aload 6
    //   235: ifnull +8 -> 243
    //   238: aload 6
    //   240: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   250: goto -7 -> 243
    //   253: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +12 -> 268
    //   259: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   262: iconst_2
    //   263: ldc 105
    //   265: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: new 107	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   275: aload_1
    //   276: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 114
    //   281: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 4
    //   289: new 87	java/io/File
    //   292: dup
    //   293: aload 4
    //   295: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 92	java/io/File:exists	()Z
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: invokevirtual 121	java/io/File:delete	()Z
    //   310: pop
    //   311: aload_1
    //   312: invokestatic 125	com/tencent/mqp/app/sec/e:validateZipFile	(Ljava/lang/String;)Z
    //   315: ifne +14 -> 329
    //   318: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   321: iconst_1
    //   322: ldc 127
    //   324: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aconst_null
    //   328: areturn
    //   329: new 129	com/tencent/commonsdk/zip/QZipFile
    //   332: dup
    //   333: aload_1
    //   334: invokespecial 130	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   337: astore 5
    //   339: aload 5
    //   341: astore_0
    //   342: aload 5
    //   344: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   347: astore 6
    //   349: aload 5
    //   351: astore_0
    //   352: aload 6
    //   354: invokeinterface 139 1 0
    //   359: ifeq +110 -> 469
    //   362: aload 5
    //   364: astore_0
    //   365: aload 6
    //   367: invokeinterface 143 1 0
    //   372: checkcast 145	java/util/zip/ZipEntry
    //   375: astore 7
    //   377: aload 5
    //   379: astore_0
    //   380: aload 7
    //   382: invokevirtual 148	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   385: ldc 150
    //   387: invokevirtual 156	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   390: iconst_m1
    //   391: if_icmpne -42 -> 349
    //   394: aload 5
    //   396: astore_0
    //   397: aload 5
    //   399: aload 7
    //   401: aload 4
    //   403: invokestatic 160	com/tencent/mqp/app/sec/e:s	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;Ljava/lang/String;)Z
    //   406: pop
    //   407: goto -58 -> 349
    //   410: astore_0
    //   411: aload 5
    //   413: astore 4
    //   415: aload_0
    //   416: astore 5
    //   418: aload 4
    //   420: astore_0
    //   421: aload 5
    //   423: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   426: aload 4
    //   428: ifnull +8 -> 436
    //   431: aload 4
    //   433: invokevirtual 161	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   436: new 87	java/io/File
    //   439: dup
    //   440: aload_1
    //   441: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   444: invokevirtual 121	java/io/File:delete	()Z
    //   447: ifeq +157 -> 604
    //   450: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +266 -> 719
    //   456: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   459: iconst_2
    //   460: ldc 163
    //   462: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: aconst_null
    //   466: astore_0
    //   467: aload_0
    //   468: areturn
    //   469: aload 5
    //   471: astore_0
    //   472: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +15 -> 490
    //   478: aload 5
    //   480: astore_0
    //   481: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   484: iconst_2
    //   485: ldc 165
    //   487: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: aload 5
    //   492: astore_0
    //   493: new 87	java/io/File
    //   496: dup
    //   497: aload 4
    //   499: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   502: invokevirtual 92	java/io/File:exists	()Z
    //   505: istore_3
    //   506: iload_3
    //   507: ifeq +51 -> 558
    //   510: aload 5
    //   512: ifnull +8 -> 520
    //   515: aload 5
    //   517: invokevirtual 161	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   520: new 87	java/io/File
    //   523: dup
    //   524: aload_1
    //   525: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   528: invokevirtual 121	java/io/File:delete	()Z
    //   531: ifeq +41 -> 572
    //   534: aload 4
    //   536: astore_0
    //   537: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq -73 -> 467
    //   543: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   546: iconst_2
    //   547: ldc 163
    //   549: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload 4
    //   554: astore_0
    //   555: goto -88 -> 467
    //   558: aconst_null
    //   559: astore 4
    //   561: goto -51 -> 510
    //   564: astore_0
    //   565: aload_0
    //   566: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   569: goto -49 -> 520
    //   572: aload 4
    //   574: astore_0
    //   575: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq -111 -> 467
    //   581: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   584: iconst_2
    //   585: ldc 167
    //   587: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aload 4
    //   592: astore_0
    //   593: goto -126 -> 467
    //   596: astore_0
    //   597: aload_0
    //   598: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   601: goto -165 -> 436
    //   604: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq +112 -> 719
    //   610: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   613: iconst_2
    //   614: ldc 167
    //   616: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aconst_null
    //   620: astore_0
    //   621: goto -154 -> 467
    //   624: astore 4
    //   626: aconst_null
    //   627: astore_0
    //   628: aload_0
    //   629: ifnull +7 -> 636
    //   632: aload_0
    //   633: invokevirtual 161	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   636: new 87	java/io/File
    //   639: dup
    //   640: aload_1
    //   641: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   644: invokevirtual 121	java/io/File:delete	()Z
    //   647: ifeq +29 -> 676
    //   650: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +12 -> 665
    //   656: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   659: iconst_2
    //   660: ldc 163
    //   662: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload 4
    //   667: athrow
    //   668: astore_0
    //   669: aload_0
    //   670: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   673: goto -37 -> 636
    //   676: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   679: ifeq -14 -> 665
    //   682: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   685: iconst_2
    //   686: ldc 167
    //   688: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: goto -26 -> 665
    //   694: astore 4
    //   696: goto -68 -> 628
    //   699: astore 5
    //   701: aconst_null
    //   702: astore 4
    //   704: goto -286 -> 418
    //   707: astore_1
    //   708: goto -493 -> 215
    //   711: astore 5
    //   713: aconst_null
    //   714: astore 4
    //   716: goto -629 -> 87
    //   719: aconst_null
    //   720: astore_0
    //   721: goto -254 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	paramString1	String
    //   0	724	1	paramString2	String
    //   64	15	2	i	int
    //   505	2	3	bool	boolean
    //   38	553	4	localObject1	Object
    //   624	42	4	localObject2	Object
    //   694	1	4	localObject3	Object
    //   702	13	4	localObject4	Object
    //   48	28	5	arrayOfByte	byte[]
    //   85	6	5	localIOException1	java.io.IOException
    //   337	179	5	localObject5	Object
    //   699	1	5	localIOException2	java.io.IOException
    //   711	1	5	localIOException3	java.io.IOException
    //   14	352	6	localObject6	Object
    //   28	372	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   43	50	85	java/io/IOException
    //   53	65	85	java/io/IOException
    //   73	82	85	java/io/IOException
    //   0	30	156	java/lang/Exception
    //   168	173	196	java/io/IOException
    //   178	183	196	java/io/IOException
    //   188	193	196	java/io/IOException
    //   100	105	204	java/io/IOException
    //   110	115	204	java/io/IOException
    //   120	125	204	java/io/IOException
    //   30	40	212	finally
    //   219	223	245	java/io/IOException
    //   228	233	245	java/io/IOException
    //   238	243	245	java/io/IOException
    //   342	349	410	java/io/IOException
    //   352	362	410	java/io/IOException
    //   365	377	410	java/io/IOException
    //   380	394	410	java/io/IOException
    //   397	407	410	java/io/IOException
    //   472	478	410	java/io/IOException
    //   481	490	410	java/io/IOException
    //   493	506	410	java/io/IOException
    //   515	520	564	java/io/IOException
    //   431	436	596	java/io/IOException
    //   329	339	624	finally
    //   632	636	668	java/io/IOException
    //   342	349	694	finally
    //   352	362	694	finally
    //   365	377	694	finally
    //   380	394	694	finally
    //   397	407	694	finally
    //   421	426	694	finally
    //   472	478	694	finally
    //   481	490	694	finally
    //   493	506	694	finally
    //   329	339	699	java/io/IOException
    //   43	50	707	finally
    //   53	65	707	finally
    //   73	82	707	finally
    //   90	95	707	finally
    //   30	40	711	java/io/IOException
  }
  
  /* Error */
  private static boolean s(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 170	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   11: astore_0
    //   12: new 66	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 175	java/io/InputStream:read	([B)I
    //   32: istore_3
    //   33: iload_3
    //   34: ifle +53 -> 87
    //   37: aload_2
    //   38: aload_1
    //   39: iconst_0
    //   40: iload_3
    //   41: invokevirtual 178	java/io/OutputStream:write	([BII)V
    //   44: goto -17 -> 27
    //   47: astore 6
    //   49: aload_0
    //   50: astore_1
    //   51: aload_2
    //   52: astore_0
    //   53: aload 6
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 179	java/io/InputStream:close	()V
    //   68: iload 5
    //   70: istore 4
    //   72: aload_0
    //   73: ifnull +11 -> 84
    //   76: aload_0
    //   77: invokevirtual 180	java/io/OutputStream:close	()V
    //   80: iload 5
    //   82: istore 4
    //   84: iload 4
    //   86: ireturn
    //   87: iconst_1
    //   88: istore 4
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 179	java/io/InputStream:close	()V
    //   98: aload_2
    //   99: ifnull -15 -> 84
    //   102: aload_2
    //   103: invokevirtual 180	java/io/OutputStream:close	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   120: goto -22 -> 98
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   128: goto -60 -> 68
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 179	java/io/InputStream:close	()V
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 180	java/io/OutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   166: goto -15 -> 151
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   174: goto -15 -> 159
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_2
    //   180: goto -37 -> 143
    //   183: astore_1
    //   184: goto -41 -> 143
    //   187: astore_2
    //   188: aload_1
    //   189: astore 6
    //   191: aload_2
    //   192: astore_1
    //   193: aload_0
    //   194: astore_2
    //   195: aload 6
    //   197: astore_0
    //   198: goto -55 -> 143
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_0
    //   204: aload 6
    //   206: astore_1
    //   207: goto -151 -> 56
    //   210: astore_2
    //   211: aconst_null
    //   212: astore 6
    //   214: aload_0
    //   215: astore_1
    //   216: aload 6
    //   218: astore_0
    //   219: goto -163 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	222	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	222	2	paramString	String
    //   32	9	3	i	int
    //   70	19	4	bool1	boolean
    //   4	77	5	bool2	boolean
    //   1	1	6	localObject	Object
    //   47	7	6	localIOException	java.io.IOException
    //   189	28	6	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   21	27	47	java/io/IOException
    //   27	33	47	java/io/IOException
    //   37	44	47	java/io/IOException
    //   102	106	108	java/io/IOException
    //   94	98	115	java/io/IOException
    //   64	68	123	java/io/IOException
    //   76	80	131	java/io/IOException
    //   6	12	138	finally
    //   147	151	161	java/io/IOException
    //   155	159	169	java/io/IOException
    //   12	21	177	finally
    //   21	27	183	finally
    //   27	33	183	finally
    //   37	44	183	finally
    //   56	60	187	finally
    //   6	12	201	java/io/IOException
    //   12	21	210	java/io/IOException
  }
  
  /* Error */
  private static boolean validateZipFile(String paramString)
  {
    // Byte code:
    //   0: new 87	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 184	java/io/File:length	()J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 186	java/io/RandomAccessFile
    //   23: dup
    //   24: aload_0
    //   25: ldc 188
    //   27: invokespecial 191	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: invokevirtual 195	java/io/RandomAccessFile:readInt	()I
    //   37: istore_1
    //   38: iload_1
    //   39: ldc 196
    //   41: if_icmpeq +16 -> 57
    //   44: aload_2
    //   45: ifnull -27 -> 18
    //   48: aload_2
    //   49: invokevirtual 197	java/io/RandomAccessFile:close	()V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_0
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_2
    //   58: astore_0
    //   59: aload_2
    //   60: aload_2
    //   61: invokevirtual 198	java/io/RandomAccessFile:length	()J
    //   64: ldc2_w 199
    //   67: lsub
    //   68: invokevirtual 204	java/io/RandomAccessFile:seek	(J)V
    //   71: aload_2
    //   72: astore_0
    //   73: aload_2
    //   74: invokevirtual 195	java/io/RandomAccessFile:readInt	()I
    //   77: istore_1
    //   78: iload_1
    //   79: ldc 205
    //   81: if_icmpeq +16 -> 97
    //   84: aload_2
    //   85: ifnull -67 -> 18
    //   88: aload_2
    //   89: invokevirtual 197	java/io/RandomAccessFile:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 197	java/io/RandomAccessFile:close	()V
    //   105: iconst_1
    //   106: ireturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_0
    //   112: aload_3
    //   113: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   116: aload_2
    //   117: ifnull -99 -> 18
    //   120: aload_2
    //   121: invokevirtual 197	java/io/RandomAccessFile:close	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore_0
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 197	java/io/RandomAccessFile:close	()V
    //   140: aload_2
    //   141: athrow
    //   142: astore_0
    //   143: goto -38 -> 105
    //   146: astore_0
    //   147: goto -7 -> 140
    //   150: astore_2
    //   151: goto -19 -> 132
    //   154: astore_3
    //   155: goto -45 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   37	45	1	i	int
    //   30	91	2	localRandomAccessFile	java.io.RandomAccessFile
    //   129	12	2	localObject1	Object
    //   150	1	2	localObject2	Object
    //   107	6	3	localIOException1	java.io.IOException
    //   154	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/io/IOException
    //   88	92	94	java/io/IOException
    //   20	31	107	java/io/IOException
    //   120	124	126	java/io/IOException
    //   20	31	129	finally
    //   101	105	142	java/io/IOException
    //   136	140	146	java/io/IOException
    //   33	38	150	finally
    //   59	71	150	finally
    //   73	78	150	finally
    //   112	116	150	finally
    //   33	38	154	java/io/IOException
    //   59	71	154	java/io/IOException
    //   73	78	154	java/io/IOException
  }
  
  /* Error */
  public static String x(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore_2
    //   8: getstatic 35	com/tencent/mqp/app/sec/e:sIsDownloading	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   11: iconst_0
    //   12: iconst_1
    //   13: invokevirtual 215	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   16: ifne +14 -> 30
    //   19: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   22: iconst_1
    //   23: ldc 217
    //   25: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 87	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 223	android/content/Context:getFilesDir	()Ljava/io/File;
    //   38: ldc 225
    //   40: invokespecial 226	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore 4
    //   45: aload 4
    //   47: invokevirtual 92	java/io/File:exists	()Z
    //   50: ifne +9 -> 59
    //   53: aload 4
    //   55: invokevirtual 229	java/io/File:mkdir	()Z
    //   58: pop
    //   59: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +11 -> 73
    //   65: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   68: iconst_2
    //   69: aload_1
    //   70: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: new 107	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   80: aload_0
    //   81: invokevirtual 223	android/content/Context:getFilesDir	()Ljava/io/File;
    //   84: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: ldc 234
    //   89: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: putstatic 25	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   98: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +13 -> 114
    //   104: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   107: iconst_2
    //   108: getstatic 25	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   111: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: new 236	org/json/JSONObject
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 237	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: aload_0
    //   124: ldc 239
    //   126: invokevirtual 243	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual 246	java/lang/String:trim	()Ljava/lang/String;
    //   132: astore 7
    //   134: aload_0
    //   135: ldc 248
    //   137: invokevirtual 243	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 246	java/lang/String:trim	()Ljava/lang/String;
    //   143: astore 8
    //   145: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +12 -> 160
    //   151: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   154: iconst_2
    //   155: aload 8
    //   157: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: new 107	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   167: getstatic 25	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   170: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 114
    //   175: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore_0
    //   182: new 87	java/io/File
    //   185: dup
    //   186: aload_0
    //   187: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 92	java/io/File:exists	()Z
    //   193: istore_3
    //   194: iload_3
    //   195: ifne +243 -> 438
    //   198: aload 8
    //   200: ifnull +512 -> 712
    //   203: aconst_null
    //   204: astore_0
    //   205: iload_2
    //   206: ifeq +503 -> 709
    //   209: aconst_null
    //   210: astore_1
    //   211: iconst_2
    //   212: istore_2
    //   213: iload_2
    //   214: iflt +19 -> 233
    //   217: aload_0
    //   218: astore 4
    //   220: aload 8
    //   222: getstatic 25	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   225: invokestatic 250	com/tencent/mqp/app/sec/e:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +327 -> 557
    //   233: aload_1
    //   234: ifnull +475 -> 709
    //   237: aload_0
    //   238: astore 4
    //   240: aload_1
    //   241: invokestatic 255	aszr:getFileMd5BigFile	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 8
    //   246: aload 8
    //   248: ifnull +461 -> 709
    //   251: aload_0
    //   252: astore 4
    //   254: aload 8
    //   256: aload 7
    //   258: invokevirtual 258	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   261: istore_3
    //   262: iload_3
    //   263: ifeq +446 -> 709
    //   266: aload 8
    //   268: putstatic 260	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   271: aload_1
    //   272: astore_0
    //   273: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +15 -> 291
    //   279: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   282: iconst_2
    //   283: ldc_w 262
    //   286: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_1
    //   290: astore_0
    //   291: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +30 -> 324
    //   297: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   300: iconst_2
    //   301: new 107	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 264
    //   311: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_0
    //   315: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: astore_1
    //   326: aload_0
    //   327: ifnonnull +102 -> 429
    //   330: aload_0
    //   331: astore_1
    //   332: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +94 -> 429
    //   338: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   341: iconst_2
    //   342: ldc_w 266
    //   345: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: new 107	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   355: getstatic 25	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   358: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 114
    //   363: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: astore_1
    //   370: new 87	java/io/File
    //   373: dup
    //   374: aload_1
    //   375: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   378: astore 4
    //   380: aload 4
    //   382: invokevirtual 92	java/io/File:exists	()Z
    //   385: ifeq +9 -> 394
    //   388: aload 4
    //   390: invokevirtual 121	java/io/File:delete	()Z
    //   393: pop
    //   394: aload 5
    //   396: astore 4
    //   398: new 66	java/io/FileOutputStream
    //   401: dup
    //   402: aload_1
    //   403: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   406: astore 5
    //   408: aload 5
    //   410: ldc_w 268
    //   413: invokevirtual 272	java/lang/String:getBytes	()[B
    //   416: invokevirtual 275	java/io/OutputStream:write	([B)V
    //   419: aload 5
    //   421: ifnull +285 -> 706
    //   424: aload 5
    //   426: invokevirtual 180	java/io/OutputStream:close	()V
    //   429: getstatic 35	com/tencent/mqp/app/sec/e:sIsDownloading	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_0
    //   433: invokevirtual 278	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   436: aload_1
    //   437: areturn
    //   438: getstatic 260	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   441: ifnull +61 -> 502
    //   444: getstatic 260	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   447: astore 4
    //   449: aload 4
    //   451: astore_1
    //   452: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +29 -> 484
    //   458: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   461: iconst_2
    //   462: iconst_2
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: ldc_w 280
    //   471: aastore
    //   472: dup
    //   473: iconst_1
    //   474: getstatic 260	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   477: aastore
    //   478: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   481: aload 4
    //   483: astore_1
    //   484: aload_1
    //   485: ifnull +67 -> 552
    //   488: aload_1
    //   489: aload 7
    //   491: invokevirtual 258	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   494: ifne +30 -> 524
    //   497: aconst_null
    //   498: astore_0
    //   499: goto -294 -> 205
    //   502: aload_0
    //   503: invokestatic 255	aszr:getFileMd5BigFile	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore_1
    //   507: aload_1
    //   508: putstatic 260	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   511: goto -27 -> 484
    //   514: astore_1
    //   515: aconst_null
    //   516: astore_0
    //   517: aload_1
    //   518: invokevirtual 284	org/json/JSONException:printStackTrace	()V
    //   521: goto -230 -> 291
    //   524: getstatic 27	com/tencent/mqp/app/sec/e:sIsFirstTimeUseCache	Z
    //   527: istore_3
    //   528: iload_3
    //   529: ifeq +15 -> 544
    //   532: aload_0
    //   533: astore 4
    //   535: iconst_0
    //   536: putstatic 27	com/tencent/mqp/app/sec/e:sIsFirstTimeUseCache	Z
    //   539: iconst_0
    //   540: istore_2
    //   541: goto -336 -> 205
    //   544: ldc 8
    //   546: astore_0
    //   547: iconst_0
    //   548: istore_2
    //   549: goto -344 -> 205
    //   552: aconst_null
    //   553: astore_0
    //   554: goto -349 -> 205
    //   557: iload_2
    //   558: iconst_1
    //   559: isub
    //   560: istore_2
    //   561: aload_0
    //   562: astore 4
    //   564: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +16 -> 583
    //   570: aload_0
    //   571: astore 4
    //   573: getstatic 21	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   576: iconst_2
    //   577: ldc_w 286
    //   580: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: aload_0
    //   584: astore 4
    //   586: ldc2_w 287
    //   589: invokestatic 293	java/lang/Thread:sleep	(J)V
    //   592: goto -379 -> 213
    //   595: astore 9
    //   597: aload_0
    //   598: astore 4
    //   600: aload 9
    //   602: invokevirtual 294	java/lang/InterruptedException:printStackTrace	()V
    //   605: goto -392 -> 213
    //   608: astore_1
    //   609: aload 4
    //   611: astore_0
    //   612: goto -95 -> 517
    //   615: astore_0
    //   616: aload_0
    //   617: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   620: goto -191 -> 429
    //   623: astore_1
    //   624: aload 6
    //   626: astore 5
    //   628: aload 5
    //   630: astore 4
    //   632: aload_1
    //   633: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   636: aload_0
    //   637: astore_1
    //   638: aload 5
    //   640: ifnull -211 -> 429
    //   643: aload 5
    //   645: invokevirtual 180	java/io/OutputStream:close	()V
    //   648: aload_0
    //   649: astore_1
    //   650: goto -221 -> 429
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   658: aload_0
    //   659: astore_1
    //   660: goto -231 -> 429
    //   663: astore_0
    //   664: aload 4
    //   666: ifnull +8 -> 674
    //   669: aload 4
    //   671: invokevirtual 180	java/io/OutputStream:close	()V
    //   674: aload_0
    //   675: athrow
    //   676: astore_1
    //   677: aload_1
    //   678: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   681: goto -7 -> 674
    //   684: astore_0
    //   685: aload 5
    //   687: astore 4
    //   689: goto -25 -> 664
    //   692: astore_1
    //   693: goto -65 -> 628
    //   696: astore 4
    //   698: aload_1
    //   699: astore_0
    //   700: aload 4
    //   702: astore_1
    //   703: goto -186 -> 517
    //   706: goto -277 -> 429
    //   709: goto -418 -> 291
    //   712: iconst_0
    //   713: istore_2
    //   714: aconst_null
    //   715: astore_0
    //   716: goto -511 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	paramContext	android.content.Context
    //   0	719	1	paramString	String
    //   7	707	2	i	int
    //   193	336	3	bool	boolean
    //   43	645	4	localObject1	Object
    //   696	5	4	localJSONException	org.json.JSONException
    //   1	685	5	localObject2	Object
    //   4	621	6	localObject3	Object
    //   132	358	7	str1	String
    //   143	124	8	str2	String
    //   595	6	9	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   114	160	514	org/json/JSONException
    //   160	194	514	org/json/JSONException
    //   438	449	514	org/json/JSONException
    //   452	481	514	org/json/JSONException
    //   488	497	514	org/json/JSONException
    //   502	511	514	org/json/JSONException
    //   524	528	514	org/json/JSONException
    //   586	592	595	java/lang/InterruptedException
    //   220	229	608	org/json/JSONException
    //   240	246	608	org/json/JSONException
    //   254	262	608	org/json/JSONException
    //   535	539	608	org/json/JSONException
    //   564	570	608	org/json/JSONException
    //   573	583	608	org/json/JSONException
    //   586	592	608	org/json/JSONException
    //   600	605	608	org/json/JSONException
    //   424	429	615	java/io/IOException
    //   398	408	623	java/io/IOException
    //   643	648	653	java/io/IOException
    //   398	408	663	finally
    //   632	636	663	finally
    //   669	674	676	java/io/IOException
    //   408	419	684	finally
    //   408	419	692	java/io/IOException
    //   266	271	696	org/json/JSONException
    //   273	289	696	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.e
 * JD-Core Version:    0.7.0.1
 */