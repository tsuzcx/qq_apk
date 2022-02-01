package com.tencent.token;

import android.content.Context;
import java.io.File;

public final class acr
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = aev.a("mpdc_");
    localStringBuilder.append(afi.a);
    localStringBuilder.append("_1");
    a = localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 47	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: astore 16
    //   9: aload 16
    //   11: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +1191 -> 1208
    //   20: aload_0
    //   21: invokevirtual 57	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   24: astore 12
    //   26: aload 12
    //   28: aload 16
    //   30: bipush 64
    //   32: invokevirtual 63	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   35: astore 12
    //   37: aload 12
    //   39: getfield 69	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   42: astore 14
    //   44: aload 14
    //   46: ifnull +1162 -> 1208
    //   49: aload 14
    //   51: getfield 74	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   54: astore 17
    //   56: aload 17
    //   58: ifnull +1150 -> 1208
    //   61: new 76	java/io/File
    //   64: dup
    //   65: aload 17
    //   67: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 13
    //   72: aload 14
    //   74: getfield 83	android/content/pm/ApplicationInfo:flags	I
    //   77: istore_1
    //   78: ldc2_w 84
    //   81: lstore 5
    //   83: aload 13
    //   85: invokevirtual 89	java/io/File:length	()J
    //   88: lstore_3
    //   89: goto +7 -> 96
    //   92: ldc2_w 84
    //   95: lstore_3
    //   96: aload 13
    //   98: invokevirtual 92	java/io/File:lastModified	()J
    //   101: ldc2_w 93
    //   104: ldiv
    //   105: lstore 7
    //   107: lload 7
    //   109: lstore 5
    //   111: aload 12
    //   113: getfield 97	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   116: invokestatic 103	com/tencent/token/aez:e	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 18
    //   121: aload 12
    //   123: getfield 106	android/content/pm/PackageInfo:versionCode	I
    //   126: istore_2
    //   127: aload 12
    //   129: getfield 110	android/content/pm/PackageInfo:firstInstallTime	J
    //   132: lstore 7
    //   134: aload 12
    //   136: getfield 113	android/content/pm/PackageInfo:lastUpdateTime	J
    //   139: lstore 9
    //   141: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   144: pop2
    //   145: ldc 120
    //   147: astore 15
    //   149: aload 12
    //   151: getfield 124	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   154: astore 13
    //   156: aload 15
    //   158: astore 12
    //   160: aload 13
    //   162: ifnull +115 -> 277
    //   165: aload 15
    //   167: astore 12
    //   169: aload 13
    //   171: arraylength
    //   172: ifle +105 -> 277
    //   175: aload 13
    //   177: iconst_0
    //   178: aaload
    //   179: astore 12
    //   181: new 126	java/io/ByteArrayInputStream
    //   184: dup
    //   185: aload 12
    //   187: invokevirtual 132	android/content/pm/Signature:toByteArray	()[B
    //   190: invokespecial 135	java/io/ByteArrayInputStream:<init>	([B)V
    //   193: astore 13
    //   195: aload 13
    //   197: astore 12
    //   199: ldc 137
    //   201: invokestatic 143	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   204: aload 13
    //   206: invokevirtual 147	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   209: checkcast 149	java/security/cert/X509Certificate
    //   212: invokevirtual 152	java/security/cert/X509Certificate:getEncoded	()[B
    //   215: invokestatic 156	com/tencent/token/aez:c	([B)Ljava/lang/String;
    //   218: astore 14
    //   220: aload 13
    //   222: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   225: aload 14
    //   227: astore 12
    //   229: goto +48 -> 277
    //   232: astore 14
    //   234: goto +15 -> 249
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 12
    //   241: goto +29 -> 270
    //   244: astore 14
    //   246: aconst_null
    //   247: astore 13
    //   249: aload 13
    //   251: astore 12
    //   253: aload 14
    //   255: invokevirtual 162	java/lang/Throwable:printStackTrace	()V
    //   258: aload 13
    //   260: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   263: aload 15
    //   265: astore 12
    //   267: goto +10 -> 277
    //   270: aload 12
    //   272: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   275: aload_0
    //   276: athrow
    //   277: aload 12
    //   279: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: istore 11
    //   284: aload 12
    //   286: astore 13
    //   288: iload 11
    //   290: ifeq +47 -> 337
    //   293: new 76	java/io/File
    //   296: dup
    //   297: aload 17
    //   299: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   302: invokestatic 165	com/tencent/token/aez:c	(Ljava/io/File;)Ljava/util/List;
    //   305: astore 14
    //   307: aload 12
    //   309: astore 13
    //   311: aload 14
    //   313: invokeinterface 171 1 0
    //   318: ifle +19 -> 337
    //   321: aload 14
    //   323: iconst_0
    //   324: invokeinterface 175 2 0
    //   329: checkcast 177	java/lang/String
    //   332: invokestatic 103	com/tencent/token/aez:e	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 13
    //   337: new 22	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   344: astore 12
    //   346: aload 12
    //   348: lload_3
    //   349: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 12
    //   355: ldc 184
    //   357: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 12
    //   363: aload 13
    //   365: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 12
    //   371: ldc 184
    //   373: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 12
    //   379: aload 16
    //   381: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 12
    //   387: ldc 184
    //   389: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 12
    //   395: aload 18
    //   397: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 12
    //   403: ldc 184
    //   405: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 12
    //   411: iload_2
    //   412: invokevirtual 26	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 12
    //   418: ldc 184
    //   420: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 12
    //   426: lload 7
    //   428: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 12
    //   434: ldc 184
    //   436: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 12
    //   442: lload 9
    //   444: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 12
    //   450: ldc 184
    //   452: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 12
    //   458: iload_1
    //   459: invokevirtual 26	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 12
    //   465: ldc 184
    //   467: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 12
    //   473: lload 5
    //   475: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 12
    //   481: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: astore 16
    //   486: goto +3 -> 489
    //   489: aload 16
    //   491: ifnonnull +9 -> 500
    //   494: ldc 2
    //   496: monitorexit
    //   497: ldc 120
    //   499: areturn
    //   500: aload 16
    //   502: invokevirtual 187	java/lang/String:getBytes	()[B
    //   505: invokestatic 191	com/tencent/token/aez:d	([B)[B
    //   508: invokestatic 193	com/tencent/token/aez:e	([B)Ljava/lang/String;
    //   511: astore 21
    //   513: aload_0
    //   514: invokestatic 197	com/tencent/token/acr:b	(Landroid/content/Context;)Ljava/io/File;
    //   517: astore 12
    //   519: aload 12
    //   521: ifnonnull +9 -> 530
    //   524: aconst_null
    //   525: astore 12
    //   527: goto +326 -> 853
    //   530: aload 12
    //   532: invokevirtual 201	java/io/File:exists	()Z
    //   535: ifne +10 -> 545
    //   538: ldc 120
    //   540: astore 12
    //   542: goto +311 -> 853
    //   545: aload 12
    //   547: invokevirtual 204	java/io/File:isFile	()Z
    //   550: ifne +16 -> 566
    //   553: aload 12
    //   555: invokestatic 207	com/tencent/token/aez:b	(Ljava/io/File;)Z
    //   558: pop
    //   559: ldc 120
    //   561: astore 12
    //   563: goto +290 -> 853
    //   566: new 209	java/io/ByteArrayOutputStream
    //   569: dup
    //   570: invokespecial 210	java/io/ByteArrayOutputStream:<init>	()V
    //   573: astore 20
    //   575: new 212	java/io/RandomAccessFile
    //   578: dup
    //   579: aload 12
    //   581: ldc 214
    //   583: invokespecial 217	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   586: astore 13
    //   588: aload 13
    //   590: invokevirtual 221	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   593: astore 12
    //   595: aload 12
    //   597: invokevirtual 227	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   600: astore 15
    //   602: bipush 32
    //   604: invokestatic 233	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   607: astore 14
    //   609: aload 12
    //   611: aload 14
    //   613: invokevirtual 237	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   616: istore_1
    //   617: iload_1
    //   618: ifle +18 -> 636
    //   621: aload 20
    //   623: aload 14
    //   625: invokevirtual 240	java/nio/ByteBuffer:array	()[B
    //   628: iconst_0
    //   629: iload_1
    //   630: invokevirtual 244	java/io/ByteArrayOutputStream:write	([BII)V
    //   633: goto -24 -> 609
    //   636: aload 20
    //   638: invokevirtual 245	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   641: astore 19
    //   643: aload 12
    //   645: astore 17
    //   647: aload 19
    //   649: astore 14
    //   651: aload 13
    //   653: astore 18
    //   655: aload 15
    //   657: ifnull +177 -> 834
    //   660: aload 15
    //   662: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   665: istore 11
    //   667: aload 12
    //   669: astore 17
    //   671: aload 19
    //   673: astore 14
    //   675: aload 13
    //   677: astore 18
    //   679: iload 11
    //   681: ifeq +153 -> 834
    //   684: aload 15
    //   686: invokevirtual 253	java/nio/channels/FileLock:release	()V
    //   689: aload 12
    //   691: astore 17
    //   693: aload 19
    //   695: astore 14
    //   697: aload 13
    //   699: astore 18
    //   701: goto +133 -> 834
    //   704: astore_0
    //   705: goto +40 -> 745
    //   708: aload 15
    //   710: astore 14
    //   712: goto +72 -> 784
    //   715: astore_0
    //   716: goto +26 -> 742
    //   719: astore_0
    //   720: aconst_null
    //   721: astore 12
    //   723: goto +19 -> 742
    //   726: aconst_null
    //   727: astore 12
    //   729: aconst_null
    //   730: astore 14
    //   732: goto +52 -> 784
    //   735: astore_0
    //   736: aconst_null
    //   737: astore 12
    //   739: aconst_null
    //   740: astore 13
    //   742: aconst_null
    //   743: astore 15
    //   745: aload 15
    //   747: ifnull +20 -> 767
    //   750: aload 15
    //   752: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   755: istore 11
    //   757: iload 11
    //   759: ifeq +8 -> 767
    //   762: aload 15
    //   764: invokevirtual 253	java/nio/channels/FileLock:release	()V
    //   767: aload 12
    //   769: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   772: aload 13
    //   774: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   777: aload 20
    //   779: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   782: aload_0
    //   783: athrow
    //   784: aload 14
    //   786: ifnull +37 -> 823
    //   789: aload 14
    //   791: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   794: istore 11
    //   796: iload 11
    //   798: ifeq +25 -> 823
    //   801: aload 14
    //   803: invokevirtual 253	java/nio/channels/FileLock:release	()V
    //   806: goto +17 -> 823
    //   809: aconst_null
    //   810: astore 14
    //   812: aload 12
    //   814: astore 17
    //   816: aload 13
    //   818: astore 18
    //   820: goto +14 -> 834
    //   823: aconst_null
    //   824: astore 14
    //   826: aload 13
    //   828: astore 18
    //   830: aload 12
    //   832: astore 17
    //   834: aload 17
    //   836: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   839: aload 18
    //   841: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   844: aload 20
    //   846: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   849: aload 14
    //   851: astore 12
    //   853: aload 12
    //   855: ifnonnull +9 -> 864
    //   858: ldc 2
    //   860: monitorexit
    //   861: ldc 120
    //   863: areturn
    //   864: aload 12
    //   866: aload 21
    //   868: invokestatic 257	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   871: ifeq +9 -> 880
    //   874: ldc 2
    //   876: monitorexit
    //   877: ldc 120
    //   879: areturn
    //   880: aload_0
    //   881: invokestatic 197	com/tencent/token/acr:b	(Landroid/content/Context;)Ljava/io/File;
    //   884: astore_0
    //   885: aload_0
    //   886: ifnull +200 -> 1086
    //   889: new 212	java/io/RandomAccessFile
    //   892: dup
    //   893: aload_0
    //   894: ldc 214
    //   896: invokespecial 217	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   899: astore 12
    //   901: aload 12
    //   903: invokevirtual 221	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   906: astore_0
    //   907: aload_0
    //   908: invokevirtual 227	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   911: astore 13
    //   913: aload 21
    //   915: invokevirtual 187	java/lang/String:getBytes	()[B
    //   918: astore 14
    //   920: aload 14
    //   922: arraylength
    //   923: invokestatic 233	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   926: astore 15
    //   928: aload 15
    //   930: aload 14
    //   932: invokevirtual 261	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   935: pop
    //   936: aload 15
    //   938: invokevirtual 265	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   941: pop
    //   942: aload 15
    //   944: invokevirtual 268	java/nio/ByteBuffer:hasRemaining	()Z
    //   947: ifeq +13 -> 960
    //   950: aload_0
    //   951: aload 15
    //   953: invokevirtual 270	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   956: pop
    //   957: goto -15 -> 942
    //   960: aload_0
    //   961: aload 14
    //   963: arraylength
    //   964: i2l
    //   965: invokevirtual 274	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   968: pop
    //   969: aload_0
    //   970: astore 14
    //   972: aload 12
    //   974: astore 15
    //   976: aload 13
    //   978: ifnull +98 -> 1076
    //   981: aload_0
    //   982: astore 14
    //   984: aload 12
    //   986: astore 15
    //   988: aload 13
    //   990: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   993: ifeq +83 -> 1076
    //   996: goto +68 -> 1064
    //   999: aload 14
    //   1001: ifnull +20 -> 1021
    //   1004: aload 14
    //   1006: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   1009: istore 11
    //   1011: iload 11
    //   1013: ifeq +8 -> 1021
    //   1016: aload 14
    //   1018: invokevirtual 253	java/nio/channels/FileLock:release	()V
    //   1021: aload_0
    //   1022: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1025: aload 12
    //   1027: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1030: aload 13
    //   1032: athrow
    //   1033: aload_0
    //   1034: astore 14
    //   1036: aload 12
    //   1038: astore 15
    //   1040: aload 13
    //   1042: ifnull +34 -> 1076
    //   1045: aload 13
    //   1047: invokevirtual 250	java/nio/channels/FileLock:isValid	()Z
    //   1050: istore 11
    //   1052: aload_0
    //   1053: astore 14
    //   1055: aload 12
    //   1057: astore 15
    //   1059: iload 11
    //   1061: ifeq +15 -> 1076
    //   1064: aload 13
    //   1066: invokevirtual 253	java/nio/channels/FileLock:release	()V
    //   1069: aload 12
    //   1071: astore 15
    //   1073: aload_0
    //   1074: astore 14
    //   1076: aload 14
    //   1078: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1081: aload 15
    //   1083: invokestatic 159	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1086: ldc 2
    //   1088: monitorexit
    //   1089: aload 16
    //   1091: areturn
    //   1092: astore_0
    //   1093: ldc 2
    //   1095: monitorexit
    //   1096: aload_0
    //   1097: athrow
    //   1098: astore 12
    //   1100: goto +108 -> 1208
    //   1103: astore 14
    //   1105: goto -1013 -> 92
    //   1108: astore 13
    //   1110: goto -999 -> 111
    //   1113: astore 13
    //   1115: aload 12
    //   1117: astore 13
    //   1119: goto -782 -> 337
    //   1122: astore 12
    //   1124: goto +90 -> 1214
    //   1127: astore 12
    //   1129: goto -403 -> 726
    //   1132: astore 14
    //   1134: goto -405 -> 729
    //   1137: astore 14
    //   1139: goto -431 -> 708
    //   1142: astore 14
    //   1144: aload 12
    //   1146: astore 17
    //   1148: aload 19
    //   1150: astore 14
    //   1152: aload 13
    //   1154: astore 18
    //   1156: goto -322 -> 834
    //   1159: astore 14
    //   1161: goto -394 -> 767
    //   1164: astore 14
    //   1166: goto -357 -> 809
    //   1169: astore_0
    //   1170: goto +105 -> 1275
    //   1173: astore_0
    //   1174: goto +80 -> 1254
    //   1177: astore 13
    //   1179: goto +77 -> 1256
    //   1182: astore 14
    //   1184: goto +55 -> 1239
    //   1187: astore 14
    //   1189: goto -168 -> 1021
    //   1192: astore 13
    //   1194: aload_0
    //   1195: astore 14
    //   1197: aload 12
    //   1199: astore 15
    //   1201: goto -125 -> 1076
    //   1204: astore_0
    //   1205: goto -935 -> 270
    //   1208: aconst_null
    //   1209: astore 16
    //   1211: goto -722 -> 489
    //   1214: aconst_null
    //   1215: astore 12
    //   1217: aconst_null
    //   1218: astore 13
    //   1220: aconst_null
    //   1221: astore 14
    //   1223: goto -439 -> 784
    //   1226: astore 15
    //   1228: aload 13
    //   1230: astore 14
    //   1232: aload 15
    //   1234: astore 13
    //   1236: goto -237 -> 999
    //   1239: goto -206 -> 1033
    //   1242: astore 13
    //   1244: goto +25 -> 1269
    //   1247: astore 13
    //   1249: aconst_null
    //   1250: astore_0
    //   1251: goto +18 -> 1269
    //   1254: aconst_null
    //   1255: astore_0
    //   1256: aconst_null
    //   1257: astore 13
    //   1259: goto -226 -> 1033
    //   1262: astore 13
    //   1264: aconst_null
    //   1265: astore_0
    //   1266: aconst_null
    //   1267: astore 12
    //   1269: aconst_null
    //   1270: astore 14
    //   1272: goto -273 -> 999
    //   1275: aconst_null
    //   1276: astore_0
    //   1277: aconst_null
    //   1278: astore 12
    //   1280: aconst_null
    //   1281: astore 13
    //   1283: goto -250 -> 1033
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	paramContext	Context
    //   77	553	1	i	int
    //   126	286	2	j	int
    //   88	261	3	l1	long
    //   81	393	5	l2	long
    //   105	322	7	l3	long
    //   139	304	9	l4	long
    //   282	778	11	bool	boolean
    //   24	1046	12	localObject1	Object
    //   1098	18	12	localThrowable1	java.lang.Throwable
    //   1122	1	12	localThrowable2	java.lang.Throwable
    //   1127	71	12	localThrowable3	java.lang.Throwable
    //   1215	64	12	localObject2	Object
    //   70	995	13	localObject3	Object
    //   1108	1	13	localThrowable4	java.lang.Throwable
    //   1113	1	13	localThrowable5	java.lang.Throwable
    //   1117	36	13	localThrowable6	java.lang.Throwable
    //   1177	1	13	localThrowable7	java.lang.Throwable
    //   1192	1	13	localIOException1	java.io.IOException
    //   1218	17	13	localObject4	Object
    //   1242	1	13	localObject5	Object
    //   1247	1	13	localObject6	Object
    //   1257	1	13	localObject7	Object
    //   1262	1	13	localObject8	Object
    //   1281	1	13	localObject9	Object
    //   42	184	14	localObject10	Object
    //   232	1	14	localThrowable8	java.lang.Throwable
    //   244	10	14	localThrowable9	java.lang.Throwable
    //   305	772	14	localObject11	Object
    //   1103	1	14	localThrowable10	java.lang.Throwable
    //   1132	1	14	localThrowable11	java.lang.Throwable
    //   1137	1	14	localThrowable12	java.lang.Throwable
    //   1142	1	14	localIOException2	java.io.IOException
    //   1150	1	14	localObject12	Object
    //   1159	1	14	localIOException3	java.io.IOException
    //   1164	1	14	localIOException4	java.io.IOException
    //   1182	1	14	localThrowable13	java.lang.Throwable
    //   1187	1	14	localIOException5	java.io.IOException
    //   1195	76	14	localObject13	Object
    //   147	1053	15	localObject14	Object
    //   1226	7	15	localObject15	Object
    //   7	1203	16	str1	String
    //   54	1093	17	localObject16	Object
    //   119	1036	18	localObject17	Object
    //   641	508	19	str2	String
    //   573	272	20	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   511	403	21	str3	String
    // Exception table:
    //   from	to	target	type
    //   199	220	232	java/lang/Throwable
    //   181	195	237	finally
    //   181	195	244	java/lang/Throwable
    //   602	609	704	finally
    //   609	617	704	finally
    //   621	633	704	finally
    //   636	643	704	finally
    //   595	602	715	finally
    //   588	595	719	finally
    //   575	588	735	finally
    //   3	17	1092	finally
    //   20	26	1092	finally
    //   26	37	1092	finally
    //   37	44	1092	finally
    //   49	56	1092	finally
    //   61	78	1092	finally
    //   83	89	1092	finally
    //   96	107	1092	finally
    //   111	145	1092	finally
    //   149	156	1092	finally
    //   169	175	1092	finally
    //   220	225	1092	finally
    //   258	263	1092	finally
    //   270	277	1092	finally
    //   277	284	1092	finally
    //   293	307	1092	finally
    //   311	337	1092	finally
    //   337	486	1092	finally
    //   500	519	1092	finally
    //   530	538	1092	finally
    //   545	559	1092	finally
    //   566	575	1092	finally
    //   660	667	1092	finally
    //   684	689	1092	finally
    //   750	757	1092	finally
    //   762	767	1092	finally
    //   767	784	1092	finally
    //   789	796	1092	finally
    //   801	806	1092	finally
    //   834	849	1092	finally
    //   864	874	1092	finally
    //   880	885	1092	finally
    //   988	996	1092	finally
    //   1004	1011	1092	finally
    //   1016	1021	1092	finally
    //   1021	1033	1092	finally
    //   1045	1052	1092	finally
    //   1064	1069	1092	finally
    //   1076	1086	1092	finally
    //   26	37	1098	java/lang/Throwable
    //   83	89	1103	java/lang/Throwable
    //   96	107	1108	java/lang/Throwable
    //   293	307	1113	java/lang/Throwable
    //   311	337	1113	java/lang/Throwable
    //   575	588	1122	java/lang/Throwable
    //   588	595	1127	java/lang/Throwable
    //   595	602	1132	java/lang/Throwable
    //   602	609	1137	java/lang/Throwable
    //   609	617	1137	java/lang/Throwable
    //   621	633	1137	java/lang/Throwable
    //   636	643	1137	java/lang/Throwable
    //   684	689	1142	java/io/IOException
    //   762	767	1159	java/io/IOException
    //   801	806	1164	java/io/IOException
    //   889	901	1169	java/lang/Throwable
    //   901	907	1173	java/lang/Throwable
    //   907	913	1177	java/lang/Throwable
    //   913	942	1182	java/lang/Throwable
    //   942	957	1182	java/lang/Throwable
    //   960	969	1182	java/lang/Throwable
    //   1016	1021	1187	java/io/IOException
    //   1064	1069	1192	java/io/IOException
    //   199	220	1204	finally
    //   253	258	1204	finally
    //   913	942	1226	finally
    //   942	957	1226	finally
    //   960	969	1226	finally
    //   907	913	1242	finally
    //   901	907	1247	finally
    //   889	901	1262	finally
  }
  
  private static File b(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acr
 * JD-Core Version:    0.7.0.1
 */