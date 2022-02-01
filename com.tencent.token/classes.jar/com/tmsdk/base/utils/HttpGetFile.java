package com.tmsdk.base.utils;

import android.content.Context;
import btmsdkobf.bl;
import java.io.File;

public class HttpGetFile
  extends bl
{
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private int G = 0;
  private boolean H = false;
  private long I = 0L;
  private long J = 0L;
  private boolean K = false;
  private Context mContext;
  
  public HttpGetFile(Context paramContext)
  {
    this.mContext = paramContext;
    this.C = paramContext.getCacheDir().getAbsolutePath();
    this.D = paramContext.getFilesDir().getAbsolutePath();
  }
  
  /* Error */
  private int a(java.net.HttpURLConnection paramHttpURLConnection, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 23
    //   7: aconst_null
    //   8: astore 21
    //   10: aconst_null
    //   11: astore 14
    //   13: aconst_null
    //   14: astore 15
    //   16: aconst_null
    //   17: astore 16
    //   19: aconst_null
    //   20: astore 17
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 12
    //   28: aconst_null
    //   29: astore 13
    //   31: aconst_null
    //   32: astore 18
    //   34: aconst_null
    //   35: astore 19
    //   37: aconst_null
    //   38: astore 20
    //   40: aconst_null
    //   41: astore 22
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   48: i2l
    //   49: aload_0
    //   50: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   53: ladd
    //   54: putfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   57: aload_0
    //   58: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   61: ldc2_w 80
    //   64: lmul
    //   65: aload_0
    //   66: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   69: ldiv
    //   70: l2i
    //   71: istore 5
    //   73: new 53	java/io/File
    //   76: dup
    //   77: aload_0
    //   78: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   85: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: astore 11
    //   90: aload 11
    //   92: invokevirtual 88	java/io/File:exists	()Z
    //   95: ifne +18 -> 113
    //   98: aload 11
    //   100: invokevirtual 91	java/io/File:getParentFile	()Ljava/io/File;
    //   103: invokevirtual 94	java/io/File:mkdirs	()Z
    //   106: pop
    //   107: aload 11
    //   109: invokevirtual 97	java/io/File:createNewFile	()Z
    //   112: pop
    //   113: new 99	java/io/FileOutputStream
    //   116: dup
    //   117: aload 11
    //   119: iconst_1
    //   120: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   123: astore 11
    //   125: iload_3
    //   126: ifeq +27 -> 153
    //   129: aload 22
    //   131: astore 12
    //   133: aload 21
    //   135: astore 13
    //   137: new 104	java/util/zip/InflaterInputStream
    //   140: dup
    //   141: aload_1
    //   142: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   145: invokespecial 111	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   148: astore 10
    //   150: goto +1276 -> 1426
    //   153: aload 22
    //   155: astore 12
    //   157: aload 21
    //   159: astore 13
    //   161: aload_1
    //   162: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   165: astore 10
    //   167: goto +1259 -> 1426
    //   170: aload 10
    //   172: astore 12
    //   174: aload 10
    //   176: astore 13
    //   178: aload 10
    //   180: astore 14
    //   182: aload 10
    //   184: astore 15
    //   186: aload 10
    //   188: astore 16
    //   190: aload 10
    //   192: astore 17
    //   194: aload 10
    //   196: aload 23
    //   198: invokevirtual 117	java/io/InputStream:read	([B)I
    //   201: istore 9
    //   203: iload 9
    //   205: iconst_m1
    //   206: if_icmpeq +301 -> 507
    //   209: aload 10
    //   211: astore 12
    //   213: aload 10
    //   215: astore 13
    //   217: aload 10
    //   219: astore 14
    //   221: aload 10
    //   223: astore 15
    //   225: aload 10
    //   227: astore 16
    //   229: aload 10
    //   231: astore 17
    //   233: aload_0
    //   234: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   237: istore_3
    //   238: iload_3
    //   239: ifeq +67 -> 306
    //   242: aload 10
    //   244: ifnull +30 -> 274
    //   247: ldc 119
    //   249: ldc 121
    //   251: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 10
    //   256: invokevirtual 129	java/io/InputStream:close	()V
    //   259: goto +15 -> 274
    //   262: astore_1
    //   263: ldc 119
    //   265: ldc 131
    //   267: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_1
    //   271: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   274: ldc 119
    //   276: ldc 139
    //   278: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 11
    //   283: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   286: sipush -5003
    //   289: ireturn
    //   290: astore_1
    //   291: ldc 119
    //   293: ldc 142
    //   295: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_1
    //   299: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   302: sipush -5003
    //   305: ireturn
    //   306: aload 10
    //   308: astore 12
    //   310: aload 10
    //   312: astore 13
    //   314: aload 10
    //   316: astore 14
    //   318: aload 10
    //   320: astore 15
    //   322: aload 10
    //   324: astore 16
    //   326: aload 10
    //   328: astore 17
    //   330: aload_0
    //   331: aload_0
    //   332: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   335: iload 9
    //   337: i2l
    //   338: ladd
    //   339: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   342: iload 4
    //   344: iload 9
    //   346: iadd
    //   347: istore 4
    //   349: aload 10
    //   351: astore 12
    //   353: aload 10
    //   355: astore 13
    //   357: aload 10
    //   359: astore 14
    //   361: aload 10
    //   363: astore 15
    //   365: aload 10
    //   367: astore 16
    //   369: aload 10
    //   371: astore 17
    //   373: aload_0
    //   374: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   377: ldc2_w 80
    //   380: lmul
    //   381: aload_0
    //   382: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   385: ldiv
    //   386: l2i
    //   387: istore 8
    //   389: iload 5
    //   391: istore 6
    //   393: iload 8
    //   395: iload 5
    //   397: if_icmpeq +69 -> 466
    //   400: aload 10
    //   402: astore 12
    //   404: aload 10
    //   406: astore 13
    //   408: aload 10
    //   410: astore 14
    //   412: aload 10
    //   414: astore 15
    //   416: aload 10
    //   418: astore 16
    //   420: aload 10
    //   422: astore 17
    //   424: aload_2
    //   425: ldc 144
    //   427: iload 8
    //   429: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   432: aload 10
    //   434: astore 12
    //   436: aload 10
    //   438: astore 13
    //   440: aload 10
    //   442: astore 14
    //   444: aload 10
    //   446: astore 15
    //   448: aload 10
    //   450: astore 16
    //   452: aload 10
    //   454: astore 17
    //   456: aload_0
    //   457: iconst_2
    //   458: aload_2
    //   459: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   462: iload 8
    //   464: istore 6
    //   466: aload 10
    //   468: astore 12
    //   470: aload 10
    //   472: astore 13
    //   474: aload 10
    //   476: astore 14
    //   478: aload 10
    //   480: astore 15
    //   482: aload 10
    //   484: astore 16
    //   486: aload 10
    //   488: astore 17
    //   490: aload 11
    //   492: aload 23
    //   494: iconst_0
    //   495: iload 9
    //   497: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   500: iload 6
    //   502: istore 5
    //   504: goto -334 -> 170
    //   507: aload 10
    //   509: astore 12
    //   511: aload 10
    //   513: astore 13
    //   515: aload 10
    //   517: astore 14
    //   519: aload 10
    //   521: astore 15
    //   523: aload 10
    //   525: astore 16
    //   527: aload 10
    //   529: astore 17
    //   531: aload 11
    //   533: invokevirtual 160	java/io/FileOutputStream:flush	()V
    //   536: aload 10
    //   538: astore 12
    //   540: aload 10
    //   542: astore 13
    //   544: aload 10
    //   546: astore 14
    //   548: aload 10
    //   550: astore 15
    //   552: aload 10
    //   554: astore 16
    //   556: aload 10
    //   558: astore 17
    //   560: new 162	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   567: astore_2
    //   568: aload 10
    //   570: astore 12
    //   572: aload 10
    //   574: astore 13
    //   576: aload 10
    //   578: astore 14
    //   580: aload 10
    //   582: astore 15
    //   584: aload 10
    //   586: astore 16
    //   588: aload 10
    //   590: astore 17
    //   592: aload_2
    //   593: ldc 165
    //   595: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 10
    //   601: astore 12
    //   603: aload 10
    //   605: astore 13
    //   607: aload 10
    //   609: astore 14
    //   611: aload 10
    //   613: astore 15
    //   615: aload 10
    //   617: astore 16
    //   619: aload 10
    //   621: astore 17
    //   623: aload_2
    //   624: aload_0
    //   625: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   628: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 10
    //   634: astore 12
    //   636: aload 10
    //   638: astore 13
    //   640: aload 10
    //   642: astore 14
    //   644: aload 10
    //   646: astore 15
    //   648: aload 10
    //   650: astore 16
    //   652: aload 10
    //   654: astore 17
    //   656: aload_2
    //   657: ldc 174
    //   659: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 10
    //   665: astore 12
    //   667: aload 10
    //   669: astore 13
    //   671: aload 10
    //   673: astore 14
    //   675: aload 10
    //   677: astore 15
    //   679: aload 10
    //   681: astore 16
    //   683: aload 10
    //   685: astore 17
    //   687: aload_2
    //   688: aload_0
    //   689: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   692: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 10
    //   698: astore 12
    //   700: aload 10
    //   702: astore 13
    //   704: aload 10
    //   706: astore 14
    //   708: aload 10
    //   710: astore 15
    //   712: aload 10
    //   714: astore 16
    //   716: aload 10
    //   718: astore 17
    //   720: aload_2
    //   721: ldc 176
    //   723: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 10
    //   729: astore 12
    //   731: aload 10
    //   733: astore 13
    //   735: aload 10
    //   737: astore 14
    //   739: aload 10
    //   741: astore 15
    //   743: aload 10
    //   745: astore 16
    //   747: aload 10
    //   749: astore 17
    //   751: aload_2
    //   752: aload_1
    //   753: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   756: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 10
    //   762: astore 12
    //   764: aload 10
    //   766: astore 13
    //   768: aload 10
    //   770: astore 14
    //   772: aload 10
    //   774: astore 15
    //   776: aload 10
    //   778: astore 16
    //   780: aload 10
    //   782: astore 17
    //   784: ldc 119
    //   786: aload_2
    //   787: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload 10
    //   795: astore 12
    //   797: aload 10
    //   799: astore 13
    //   801: aload 10
    //   803: astore 14
    //   805: aload 10
    //   807: astore 15
    //   809: aload 10
    //   811: astore 16
    //   813: aload 10
    //   815: astore 17
    //   817: aload_1
    //   818: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   821: istore 5
    //   823: iload 4
    //   825: iload 5
    //   827: if_icmpne +10 -> 837
    //   830: iload 7
    //   832: istore 4
    //   834: goto +7 -> 841
    //   837: bipush 249
    //   839: istore 4
    //   841: iload 4
    //   843: istore 5
    //   845: aload 10
    //   847: ifnull +39 -> 886
    //   850: ldc 119
    //   852: ldc 121
    //   854: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: aload 10
    //   859: invokevirtual 129	java/io/InputStream:close	()V
    //   862: iload 4
    //   864: istore 5
    //   866: goto +20 -> 886
    //   869: astore_1
    //   870: ldc 119
    //   872: ldc 131
    //   874: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_1
    //   878: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   881: sipush -7000
    //   884: istore 5
    //   886: ldc 119
    //   888: ldc 139
    //   890: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload 11
    //   895: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   898: iload 5
    //   900: ireturn
    //   901: astore_1
    //   902: ldc 119
    //   904: ldc 142
    //   906: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   909: aload_1
    //   910: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   913: sipush -7000
    //   916: ireturn
    //   917: astore_2
    //   918: aload 12
    //   920: astore 10
    //   922: aload 11
    //   924: astore_1
    //   925: goto +435 -> 1360
    //   928: astore 12
    //   930: aload 11
    //   932: astore 10
    //   934: aload 13
    //   936: astore 11
    //   938: goto +70 -> 1008
    //   941: astore 12
    //   943: aload 11
    //   945: astore 10
    //   947: aload 14
    //   949: astore 11
    //   951: goto +119 -> 1070
    //   954: astore 12
    //   956: aload 11
    //   958: astore 10
    //   960: aload 15
    //   962: astore 11
    //   964: goto +152 -> 1116
    //   967: astore 12
    //   969: aload 11
    //   971: astore 10
    //   973: aload 16
    //   975: astore 11
    //   977: goto +234 -> 1211
    //   980: astore 12
    //   982: aload 11
    //   984: astore 10
    //   986: aload 17
    //   988: astore 11
    //   990: goto +316 -> 1306
    //   993: astore_2
    //   994: aconst_null
    //   995: astore 10
    //   997: aload 20
    //   999: astore_1
    //   1000: goto +360 -> 1360
    //   1003: astore 12
    //   1005: aconst_null
    //   1006: astore 11
    //   1008: aload 10
    //   1010: astore_1
    //   1011: aload 11
    //   1013: astore_2
    //   1014: ldc 119
    //   1016: aload 12
    //   1018: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   1021: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1024: aload 10
    //   1026: astore_1
    //   1027: aload 11
    //   1029: astore_2
    //   1030: ldc 119
    //   1032: ldc 185
    //   1034: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: aload 10
    //   1039: astore_1
    //   1040: aload 11
    //   1042: astore_2
    //   1043: aload 12
    //   1045: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   1048: aload 10
    //   1050: astore_1
    //   1051: aload 11
    //   1053: astore_2
    //   1054: new 188	btmsdkobf/bm
    //   1057: dup
    //   1058: sipush -5000
    //   1061: aload 12
    //   1063: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1066: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1069: athrow
    //   1070: aload 10
    //   1072: astore_1
    //   1073: aload 11
    //   1075: astore_2
    //   1076: ldc 119
    //   1078: ldc 196
    //   1080: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1083: aload 10
    //   1085: astore_1
    //   1086: aload 11
    //   1088: astore_2
    //   1089: aload 12
    //   1091: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1094: aload 10
    //   1096: astore_1
    //   1097: aload 11
    //   1099: astore_2
    //   1100: new 188	btmsdkobf/bm
    //   1103: dup
    //   1104: sipush -5056
    //   1107: aload 12
    //   1109: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1112: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1115: athrow
    //   1116: aload 10
    //   1118: astore_1
    //   1119: aload 11
    //   1121: astore_2
    //   1122: new 162	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1129: astore 13
    //   1131: aload 10
    //   1133: astore_1
    //   1134: aload 11
    //   1136: astore_2
    //   1137: aload 13
    //   1139: ldc 199
    //   1141: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload 10
    //   1147: astore_1
    //   1148: aload 11
    //   1150: astore_2
    //   1151: aload 13
    //   1153: aload 12
    //   1155: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1158: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 10
    //   1164: astore_1
    //   1165: aload 11
    //   1167: astore_2
    //   1168: ldc 119
    //   1170: aload 13
    //   1172: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload 10
    //   1180: astore_1
    //   1181: aload 11
    //   1183: astore_2
    //   1184: aload 12
    //   1186: invokevirtual 201	java/net/SocketTimeoutException:printStackTrace	()V
    //   1189: aload 10
    //   1191: astore_1
    //   1192: aload 11
    //   1194: astore_2
    //   1195: new 188	btmsdkobf/bm
    //   1198: dup
    //   1199: sipush -5055
    //   1202: aload 12
    //   1204: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1207: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1210: athrow
    //   1211: aload 10
    //   1213: astore_1
    //   1214: aload 11
    //   1216: astore_2
    //   1217: new 162	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1224: astore 13
    //   1226: aload 10
    //   1228: astore_1
    //   1229: aload 11
    //   1231: astore_2
    //   1232: aload 13
    //   1234: ldc 203
    //   1236: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload 10
    //   1242: astore_1
    //   1243: aload 11
    //   1245: astore_2
    //   1246: aload 13
    //   1248: aload 12
    //   1250: invokevirtual 204	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1253: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 10
    //   1259: astore_1
    //   1260: aload 11
    //   1262: astore_2
    //   1263: ldc 119
    //   1265: aload 13
    //   1267: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1273: aload 10
    //   1275: astore_1
    //   1276: aload 11
    //   1278: astore_2
    //   1279: aload 12
    //   1281: invokevirtual 205	java/net/SocketException:printStackTrace	()V
    //   1284: aload 10
    //   1286: astore_1
    //   1287: aload 11
    //   1289: astore_2
    //   1290: new 188	btmsdkobf/bm
    //   1293: dup
    //   1294: sipush -5054
    //   1297: aload 12
    //   1299: invokevirtual 204	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1302: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1305: athrow
    //   1306: aload 10
    //   1308: astore_1
    //   1309: aload 11
    //   1311: astore_2
    //   1312: ldc 119
    //   1314: ldc 207
    //   1316: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1319: aload 10
    //   1321: astore_1
    //   1322: aload 11
    //   1324: astore_2
    //   1325: aload 12
    //   1327: invokevirtual 208	java/io/FileNotFoundException:printStackTrace	()V
    //   1330: aload 10
    //   1332: astore_1
    //   1333: aload 11
    //   1335: astore_2
    //   1336: new 188	btmsdkobf/bm
    //   1339: dup
    //   1340: sipush -7001
    //   1343: aload 12
    //   1345: invokevirtual 209	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   1348: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1351: athrow
    //   1352: astore 11
    //   1354: aload_2
    //   1355: astore 10
    //   1357: aload 11
    //   1359: astore_2
    //   1360: aload 10
    //   1362: ifnull +32 -> 1394
    //   1365: ldc 119
    //   1367: ldc 121
    //   1369: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   1372: aload 10
    //   1374: invokevirtual 129	java/io/InputStream:close	()V
    //   1377: goto +17 -> 1394
    //   1380: astore 10
    //   1382: ldc 119
    //   1384: ldc 131
    //   1386: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: aload 10
    //   1391: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1394: aload_1
    //   1395: ifnull +29 -> 1424
    //   1398: ldc 119
    //   1400: ldc 139
    //   1402: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   1405: aload_1
    //   1406: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   1409: goto +15 -> 1424
    //   1412: astore_1
    //   1413: ldc 119
    //   1415: ldc 142
    //   1417: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1424: aload_2
    //   1425: athrow
    //   1426: iconst_0
    //   1427: istore 7
    //   1429: iconst_0
    //   1430: istore 4
    //   1432: goto -1262 -> 170
    //   1435: astore_1
    //   1436: aconst_null
    //   1437: astore 11
    //   1439: aload 12
    //   1441: astore 10
    //   1443: aload_1
    //   1444: astore 12
    //   1446: goto -376 -> 1070
    //   1449: astore 12
    //   1451: aconst_null
    //   1452: astore 11
    //   1454: aload 13
    //   1456: astore 10
    //   1458: goto -342 -> 1116
    //   1461: astore 12
    //   1463: aconst_null
    //   1464: astore 11
    //   1466: aload 18
    //   1468: astore 10
    //   1470: goto -259 -> 1211
    //   1473: astore 12
    //   1475: aconst_null
    //   1476: astore 11
    //   1478: aload 19
    //   1480: astore 10
    //   1482: goto -176 -> 1306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1485	0	this	HttpGetFile
    //   0	1485	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	1485	2	paramBundle	android.os.Bundle
    //   0	1485	3	paramBoolean	boolean
    //   342	1089	4	i	int
    //   71	828	5	j	int
    //   391	110	6	k	int
    //   830	598	7	m	int
    //   387	76	8	n	int
    //   201	295	9	i1	int
    //   23	1350	10	localObject1	Object
    //   1380	10	10	localIOException1	java.io.IOException
    //   1441	40	10	localObject2	Object
    //   88	1246	11	localObject3	Object
    //   1352	6	11	localObject4	Object
    //   1437	40	11	localObject5	Object
    //   26	893	12	localObject6	Object
    //   928	1	12	localException1	java.lang.Exception
    //   941	1	12	localIOException2	java.io.IOException
    //   954	1	12	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   967	1	12	localSocketException1	java.net.SocketException
    //   980	1	12	localFileNotFoundException1	java.io.FileNotFoundException
    //   1003	437	12	localException2	java.lang.Exception
    //   1444	1	12	localHttpURLConnection	java.net.HttpURLConnection
    //   1449	1	12	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1461	1	12	localSocketException2	java.net.SocketException
    //   1473	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    //   29	1426	13	localObject7	Object
    //   11	937	14	localObject8	Object
    //   14	947	15	localObject9	Object
    //   17	957	16	localObject10	Object
    //   20	967	17	localObject11	Object
    //   32	1435	18	localObject12	Object
    //   35	1444	19	localObject13	Object
    //   38	960	20	localObject14	Object
    //   8	150	21	localObject15	Object
    //   41	113	22	localObject16	Object
    //   5	488	23	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   254	259	262	java/io/IOException
    //   281	286	290	java/io/IOException
    //   857	862	869	java/io/IOException
    //   893	898	901	java/io/IOException
    //   137	150	917	finally
    //   161	167	917	finally
    //   194	203	917	finally
    //   233	238	917	finally
    //   330	342	917	finally
    //   373	389	917	finally
    //   424	432	917	finally
    //   456	462	917	finally
    //   490	500	917	finally
    //   531	536	917	finally
    //   560	568	917	finally
    //   592	599	917	finally
    //   623	632	917	finally
    //   656	663	917	finally
    //   687	696	917	finally
    //   720	727	917	finally
    //   751	760	917	finally
    //   784	793	917	finally
    //   817	823	917	finally
    //   137	150	928	java/lang/Exception
    //   161	167	928	java/lang/Exception
    //   194	203	928	java/lang/Exception
    //   233	238	928	java/lang/Exception
    //   330	342	928	java/lang/Exception
    //   373	389	928	java/lang/Exception
    //   424	432	928	java/lang/Exception
    //   456	462	928	java/lang/Exception
    //   490	500	928	java/lang/Exception
    //   531	536	928	java/lang/Exception
    //   560	568	928	java/lang/Exception
    //   592	599	928	java/lang/Exception
    //   623	632	928	java/lang/Exception
    //   656	663	928	java/lang/Exception
    //   687	696	928	java/lang/Exception
    //   720	727	928	java/lang/Exception
    //   751	760	928	java/lang/Exception
    //   784	793	928	java/lang/Exception
    //   817	823	928	java/lang/Exception
    //   137	150	941	java/io/IOException
    //   161	167	941	java/io/IOException
    //   194	203	941	java/io/IOException
    //   233	238	941	java/io/IOException
    //   330	342	941	java/io/IOException
    //   373	389	941	java/io/IOException
    //   424	432	941	java/io/IOException
    //   456	462	941	java/io/IOException
    //   490	500	941	java/io/IOException
    //   531	536	941	java/io/IOException
    //   560	568	941	java/io/IOException
    //   592	599	941	java/io/IOException
    //   623	632	941	java/io/IOException
    //   656	663	941	java/io/IOException
    //   687	696	941	java/io/IOException
    //   720	727	941	java/io/IOException
    //   751	760	941	java/io/IOException
    //   784	793	941	java/io/IOException
    //   817	823	941	java/io/IOException
    //   137	150	954	java/net/SocketTimeoutException
    //   161	167	954	java/net/SocketTimeoutException
    //   194	203	954	java/net/SocketTimeoutException
    //   233	238	954	java/net/SocketTimeoutException
    //   330	342	954	java/net/SocketTimeoutException
    //   373	389	954	java/net/SocketTimeoutException
    //   424	432	954	java/net/SocketTimeoutException
    //   456	462	954	java/net/SocketTimeoutException
    //   490	500	954	java/net/SocketTimeoutException
    //   531	536	954	java/net/SocketTimeoutException
    //   560	568	954	java/net/SocketTimeoutException
    //   592	599	954	java/net/SocketTimeoutException
    //   623	632	954	java/net/SocketTimeoutException
    //   656	663	954	java/net/SocketTimeoutException
    //   687	696	954	java/net/SocketTimeoutException
    //   720	727	954	java/net/SocketTimeoutException
    //   751	760	954	java/net/SocketTimeoutException
    //   784	793	954	java/net/SocketTimeoutException
    //   817	823	954	java/net/SocketTimeoutException
    //   137	150	967	java/net/SocketException
    //   161	167	967	java/net/SocketException
    //   194	203	967	java/net/SocketException
    //   233	238	967	java/net/SocketException
    //   330	342	967	java/net/SocketException
    //   373	389	967	java/net/SocketException
    //   424	432	967	java/net/SocketException
    //   456	462	967	java/net/SocketException
    //   490	500	967	java/net/SocketException
    //   531	536	967	java/net/SocketException
    //   560	568	967	java/net/SocketException
    //   592	599	967	java/net/SocketException
    //   623	632	967	java/net/SocketException
    //   656	663	967	java/net/SocketException
    //   687	696	967	java/net/SocketException
    //   720	727	967	java/net/SocketException
    //   751	760	967	java/net/SocketException
    //   784	793	967	java/net/SocketException
    //   817	823	967	java/net/SocketException
    //   137	150	980	java/io/FileNotFoundException
    //   161	167	980	java/io/FileNotFoundException
    //   194	203	980	java/io/FileNotFoundException
    //   233	238	980	java/io/FileNotFoundException
    //   330	342	980	java/io/FileNotFoundException
    //   373	389	980	java/io/FileNotFoundException
    //   424	432	980	java/io/FileNotFoundException
    //   456	462	980	java/io/FileNotFoundException
    //   490	500	980	java/io/FileNotFoundException
    //   531	536	980	java/io/FileNotFoundException
    //   560	568	980	java/io/FileNotFoundException
    //   592	599	980	java/io/FileNotFoundException
    //   623	632	980	java/io/FileNotFoundException
    //   656	663	980	java/io/FileNotFoundException
    //   687	696	980	java/io/FileNotFoundException
    //   720	727	980	java/io/FileNotFoundException
    //   751	760	980	java/io/FileNotFoundException
    //   784	793	980	java/io/FileNotFoundException
    //   817	823	980	java/io/FileNotFoundException
    //   43	113	993	finally
    //   113	125	993	finally
    //   43	113	1003	java/lang/Exception
    //   113	125	1003	java/lang/Exception
    //   1014	1024	1352	finally
    //   1030	1037	1352	finally
    //   1043	1048	1352	finally
    //   1054	1070	1352	finally
    //   1076	1083	1352	finally
    //   1089	1094	1352	finally
    //   1100	1116	1352	finally
    //   1122	1131	1352	finally
    //   1137	1145	1352	finally
    //   1151	1162	1352	finally
    //   1168	1178	1352	finally
    //   1184	1189	1352	finally
    //   1195	1211	1352	finally
    //   1217	1226	1352	finally
    //   1232	1240	1352	finally
    //   1246	1257	1352	finally
    //   1263	1273	1352	finally
    //   1279	1284	1352	finally
    //   1290	1306	1352	finally
    //   1312	1319	1352	finally
    //   1325	1330	1352	finally
    //   1336	1352	1352	finally
    //   1372	1377	1380	java/io/IOException
    //   1405	1409	1412	java/io/IOException
    //   43	113	1435	java/io/IOException
    //   113	125	1435	java/io/IOException
    //   43	113	1449	java/net/SocketTimeoutException
    //   113	125	1449	java/net/SocketTimeoutException
    //   43	113	1461	java/net/SocketException
    //   113	125	1461	java/net/SocketException
    //   43	113	1473	java/io/FileNotFoundException
    //   113	125	1473	java/io/FileNotFoundException
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 162	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   15: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 4
    //   21: getstatic 213	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 4
    //   30: aload_0
    //   31: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   34: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 215
    //   40: aload 4
    //   42: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 162	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   63: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: getstatic 213	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: aload_0
    //   79: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   82: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc 215
    //   88: aload 4
    //   90: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: sipush -7001
    //   99: istore_3
    //   100: aconst_null
    //   101: astore 9
    //   103: aconst_null
    //   104: astore 4
    //   106: aconst_null
    //   107: astore 6
    //   109: aconst_null
    //   110: astore 8
    //   112: aconst_null
    //   113: astore 7
    //   115: new 53	java/io/File
    //   118: dup
    //   119: aload_0
    //   120: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   127: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: astore 5
    //   132: aload 5
    //   134: invokevirtual 88	java/io/File:exists	()Z
    //   137: ifeq +310 -> 447
    //   140: aload_0
    //   141: getfield 35	com/tmsdk/base/utils/HttpGetFile:G	I
    //   144: iconst_1
    //   145: if_icmpne +47 -> 192
    //   148: aload_0
    //   149: getfield 45	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   152: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   155: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   162: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +27 -> 192
    //   168: aload_0
    //   169: getfield 45	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   172: aload_0
    //   173: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   176: aload_0
    //   177: getfield 35	com/tmsdk/base/utils/HttpGetFile:G	I
    //   180: invokevirtual 225	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   183: astore 7
    //   185: aload 7
    //   187: astore 4
    //   189: goto +117 -> 306
    //   192: new 162	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   199: astore 7
    //   201: aload 7
    //   203: aload_0
    //   204: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   207: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 7
    //   213: getstatic 213	java/io/File:separator	Ljava/lang/String;
    //   216: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: aload_0
    //   223: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   226: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: new 53	java/io/File
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 88	java/io/File:exists	()Z
    //   249: ifeq +27 -> 276
    //   252: aload 7
    //   254: invokevirtual 231	java/io/File:delete	()Z
    //   257: pop
    //   258: new 99	java/io/FileOutputStream
    //   261: dup
    //   262: aload 7
    //   264: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore 7
    //   269: aload 7
    //   271: astore 4
    //   273: goto +33 -> 306
    //   276: aload 7
    //   278: invokevirtual 91	java/io/File:getParentFile	()Ljava/io/File;
    //   281: invokevirtual 94	java/io/File:mkdirs	()Z
    //   284: pop
    //   285: aload 7
    //   287: invokevirtual 97	java/io/File:createNewFile	()Z
    //   290: pop
    //   291: new 99	java/io/FileOutputStream
    //   294: dup
    //   295: aload 7
    //   297: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   300: astore 7
    //   302: aload 7
    //   304: astore 4
    //   306: new 236	java/io/FileInputStream
    //   309: dup
    //   310: aload 5
    //   312: invokespecial 237	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   315: astore 6
    //   317: sipush 1024
    //   320: newarray byte
    //   322: astore 7
    //   324: aload 6
    //   326: aload 7
    //   328: invokevirtual 238	java/io/FileInputStream:read	([B)I
    //   331: istore_2
    //   332: iload_2
    //   333: iconst_m1
    //   334: if_icmpeq +15 -> 349
    //   337: aload 4
    //   339: aload 7
    //   341: iconst_0
    //   342: iload_2
    //   343: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   346: goto -22 -> 324
    //   349: iconst_0
    //   350: istore_3
    //   351: goto +103 -> 454
    //   354: astore 7
    //   356: aload 6
    //   358: astore 8
    //   360: aload 4
    //   362: astore 6
    //   364: goto +455 -> 819
    //   367: astore 8
    //   369: goto +23 -> 392
    //   372: astore 8
    //   374: goto +38 -> 412
    //   377: astore 8
    //   379: goto +53 -> 432
    //   382: astore 6
    //   384: goto +443 -> 827
    //   387: astore 8
    //   389: aconst_null
    //   390: astore 6
    //   392: aload 4
    //   394: astore 9
    //   396: aload 5
    //   398: astore 10
    //   400: aload 6
    //   402: astore 7
    //   404: goto +213 -> 617
    //   407: astore 8
    //   409: aconst_null
    //   410: astore 6
    //   412: aload 4
    //   414: astore 9
    //   416: aload 5
    //   418: astore 10
    //   420: aload 6
    //   422: astore 7
    //   424: goto +257 -> 681
    //   427: astore 8
    //   429: aconst_null
    //   430: astore 6
    //   432: aload 4
    //   434: astore 9
    //   436: aload 5
    //   438: astore 10
    //   440: aload 6
    //   442: astore 7
    //   444: goto +301 -> 745
    //   447: aconst_null
    //   448: astore 4
    //   450: aload 7
    //   452: astore 6
    //   454: iload_3
    //   455: istore_2
    //   456: aload 6
    //   458: ifnull +31 -> 489
    //   461: aload 6
    //   463: invokevirtual 239	java/io/FileInputStream:close	()V
    //   466: iload_3
    //   467: istore_2
    //   468: goto +21 -> 489
    //   471: astore 6
    //   473: ldc 119
    //   475: ldc 241
    //   477: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload 6
    //   482: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   485: sipush -7000
    //   488: istore_2
    //   489: iload_2
    //   490: istore_3
    //   491: aload 4
    //   493: ifnull +31 -> 524
    //   496: aload 4
    //   498: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   501: iload_2
    //   502: istore_3
    //   503: goto +21 -> 524
    //   506: astore 4
    //   508: ldc 119
    //   510: ldc 243
    //   512: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 4
    //   517: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   520: sipush -7000
    //   523: istore_3
    //   524: iload_1
    //   525: ifeq +17 -> 542
    //   528: aload 5
    //   530: invokevirtual 88	java/io/File:exists	()Z
    //   533: ifeq +9 -> 542
    //   536: aload 5
    //   538: invokevirtual 231	java/io/File:delete	()Z
    //   541: pop
    //   542: iload_3
    //   543: ireturn
    //   544: astore 6
    //   546: aconst_null
    //   547: astore 4
    //   549: goto +278 -> 827
    //   552: astore 8
    //   554: aconst_null
    //   555: astore 7
    //   557: aload 5
    //   559: astore 10
    //   561: goto +56 -> 617
    //   564: astore 8
    //   566: aconst_null
    //   567: astore 7
    //   569: aload 4
    //   571: astore 9
    //   573: aload 5
    //   575: astore 10
    //   577: goto +104 -> 681
    //   580: astore 8
    //   582: aconst_null
    //   583: astore 7
    //   585: aload 6
    //   587: astore 9
    //   589: aload 5
    //   591: astore 10
    //   593: goto +152 -> 745
    //   596: astore 6
    //   598: aconst_null
    //   599: astore 5
    //   601: aload 5
    //   603: astore 4
    //   605: goto +222 -> 827
    //   608: astore 8
    //   610: aconst_null
    //   611: astore 10
    //   613: aload 10
    //   615: astore 7
    //   617: aload 9
    //   619: astore 6
    //   621: aload 10
    //   623: astore 4
    //   625: aload 7
    //   627: astore 5
    //   629: ldc 119
    //   631: ldc 245
    //   633: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload 9
    //   638: astore 6
    //   640: aload 10
    //   642: astore 4
    //   644: aload 7
    //   646: astore 5
    //   648: aload 8
    //   650: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   653: aload 9
    //   655: astore 6
    //   657: aload 10
    //   659: astore 4
    //   661: aload 7
    //   663: astore 5
    //   665: new 188	btmsdkobf/bm
    //   668: dup
    //   669: sipush -7000
    //   672: aload 8
    //   674: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   677: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   680: athrow
    //   681: aload 9
    //   683: astore 6
    //   685: aload 10
    //   687: astore 4
    //   689: aload 7
    //   691: astore 5
    //   693: ldc 119
    //   695: ldc 247
    //   697: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload 9
    //   702: astore 6
    //   704: aload 10
    //   706: astore 4
    //   708: aload 7
    //   710: astore 5
    //   712: aload 8
    //   714: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   717: aload 9
    //   719: astore 6
    //   721: aload 10
    //   723: astore 4
    //   725: aload 7
    //   727: astore 5
    //   729: new 188	btmsdkobf/bm
    //   732: dup
    //   733: sipush -7056
    //   736: aload 8
    //   738: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   741: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   744: athrow
    //   745: aload 9
    //   747: astore 6
    //   749: aload 10
    //   751: astore 4
    //   753: aload 7
    //   755: astore 5
    //   757: ldc 119
    //   759: ldc 207
    //   761: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload 9
    //   766: astore 6
    //   768: aload 10
    //   770: astore 4
    //   772: aload 7
    //   774: astore 5
    //   776: aload 8
    //   778: invokevirtual 208	java/io/FileNotFoundException:printStackTrace	()V
    //   781: aload 9
    //   783: astore 6
    //   785: aload 10
    //   787: astore 4
    //   789: aload 7
    //   791: astore 5
    //   793: new 188	btmsdkobf/bm
    //   796: dup
    //   797: sipush -7001
    //   800: aload 8
    //   802: invokevirtual 209	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   805: invokespecial 194	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   808: athrow
    //   809: astore 7
    //   811: aload 5
    //   813: astore 8
    //   815: aload 4
    //   817: astore 5
    //   819: aload 6
    //   821: astore 4
    //   823: aload 7
    //   825: astore 6
    //   827: aload 8
    //   829: ifnull +25 -> 854
    //   832: aload 8
    //   834: invokevirtual 239	java/io/FileInputStream:close	()V
    //   837: goto +17 -> 854
    //   840: astore 7
    //   842: ldc 119
    //   844: ldc 241
    //   846: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload 7
    //   851: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   854: aload 4
    //   856: ifnull +25 -> 881
    //   859: aload 4
    //   861: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   864: goto +17 -> 881
    //   867: astore 4
    //   869: ldc 119
    //   871: ldc 243
    //   873: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: aload 4
    //   878: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   881: iload_1
    //   882: ifeq +22 -> 904
    //   885: aload 5
    //   887: ifnull +17 -> 904
    //   890: aload 5
    //   892: invokevirtual 88	java/io/File:exists	()Z
    //   895: ifeq +9 -> 904
    //   898: aload 5
    //   900: invokevirtual 231	java/io/File:delete	()Z
    //   903: pop
    //   904: aload 6
    //   906: athrow
    //   907: astore 8
    //   909: aconst_null
    //   910: astore 10
    //   912: aload 10
    //   914: astore 7
    //   916: aload 4
    //   918: astore 9
    //   920: goto -239 -> 681
    //   923: astore 8
    //   925: aconst_null
    //   926: astore 10
    //   928: aload 10
    //   930: astore 7
    //   932: aload 6
    //   934: astore 9
    //   936: goto -191 -> 745
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	939	0	this	HttpGetFile
    //   0	939	1	paramBoolean	boolean
    //   331	171	2	i	int
    //   99	444	3	j	int
    //   7	490	4	localObject1	Object
    //   506	10	4	localIOException1	java.io.IOException
    //   547	313	4	localObject2	Object
    //   867	50	4	localIOException2	java.io.IOException
    //   130	769	5	localObject3	Object
    //   107	256	6	localObject4	Object
    //   382	1	6	localObject5	Object
    //   390	72	6	localObject6	Object
    //   471	10	6	localIOException3	java.io.IOException
    //   544	42	6	localObject7	Object
    //   596	1	6	localObject8	Object
    //   619	314	6	localObject9	Object
    //   113	227	7	localObject10	Object
    //   354	1	7	localObject11	Object
    //   402	388	7	localObject12	Object
    //   809	15	7	localObject13	Object
    //   840	10	7	localIOException4	java.io.IOException
    //   914	17	7	localObject14	Object
    //   110	249	8	localObject15	Object
    //   367	1	8	localException1	java.lang.Exception
    //   372	1	8	localIOException5	java.io.IOException
    //   377	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   387	1	8	localException2	java.lang.Exception
    //   407	1	8	localIOException6	java.io.IOException
    //   427	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   552	1	8	localException3	java.lang.Exception
    //   564	1	8	localIOException7	java.io.IOException
    //   580	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   608	193	8	localException4	java.lang.Exception
    //   813	20	8	localObject16	Object
    //   907	1	8	localIOException8	java.io.IOException
    //   923	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   101	834	9	localObject17	Object
    //   398	531	10	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   317	324	354	finally
    //   324	332	354	finally
    //   337	346	354	finally
    //   317	324	367	java/lang/Exception
    //   324	332	367	java/lang/Exception
    //   337	346	367	java/lang/Exception
    //   317	324	372	java/io/IOException
    //   324	332	372	java/io/IOException
    //   337	346	372	java/io/IOException
    //   317	324	377	java/io/FileNotFoundException
    //   324	332	377	java/io/FileNotFoundException
    //   337	346	377	java/io/FileNotFoundException
    //   306	317	382	finally
    //   306	317	387	java/lang/Exception
    //   306	317	407	java/io/IOException
    //   306	317	427	java/io/FileNotFoundException
    //   461	466	471	java/io/IOException
    //   496	501	506	java/io/IOException
    //   132	185	544	finally
    //   192	269	544	finally
    //   276	302	544	finally
    //   132	185	552	java/lang/Exception
    //   192	269	552	java/lang/Exception
    //   276	302	552	java/lang/Exception
    //   132	185	564	java/io/IOException
    //   192	269	564	java/io/IOException
    //   276	302	564	java/io/IOException
    //   132	185	580	java/io/FileNotFoundException
    //   192	269	580	java/io/FileNotFoundException
    //   276	302	580	java/io/FileNotFoundException
    //   115	132	596	finally
    //   115	132	608	java/lang/Exception
    //   629	636	809	finally
    //   648	653	809	finally
    //   665	681	809	finally
    //   693	700	809	finally
    //   712	717	809	finally
    //   729	745	809	finally
    //   757	764	809	finally
    //   776	781	809	finally
    //   793	809	809	finally
    //   832	837	840	java/io/IOException
    //   859	864	867	java/io/IOException
    //   115	132	907	java/io/IOException
    //   115	132	923	java/io/FileNotFoundException
  }
  
  public void cancelGet()
  {
    try
    {
      this.H = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int doGetFile(String paramString1, String paramString2, boolean paramBoolean, DataMd5Cheker paramDataMd5Cheker)
  {
    // Byte code:
    //   0: ldc 252
    //   2: astore 11
    //   4: new 146	android/os/Bundle
    //   7: dup
    //   8: invokespecial 253	android/os/Bundle:<init>	()V
    //   11: astore 17
    //   13: aconst_null
    //   14: astore 12
    //   16: aconst_null
    //   17: astore 13
    //   19: aconst_null
    //   20: astore 14
    //   22: aconst_null
    //   23: astore 15
    //   25: aconst_null
    //   26: astore 16
    //   28: aconst_null
    //   29: astore 8
    //   31: sipush -3000
    //   34: istore 6
    //   36: aload 11
    //   38: astore 10
    //   40: aload 8
    //   42: astore 9
    //   44: iload 6
    //   46: istore 5
    //   48: aload_0
    //   49: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   52: ifeq +9 -> 61
    //   55: aconst_null
    //   56: astore 8
    //   58: goto +1429 -> 1487
    //   61: aload 11
    //   63: astore 10
    //   65: aload 8
    //   67: astore 9
    //   69: iload 6
    //   71: istore 5
    //   73: new 255	java/net/URL
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 256	java/net/URL:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 260	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   84: checkcast 75	java/net/HttpURLConnection
    //   87: astore 8
    //   89: aload 8
    //   91: sipush 10000
    //   94: invokevirtual 264	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   97: aload 8
    //   99: sipush 20000
    //   102: invokevirtual 267	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   105: aload 8
    //   107: iconst_1
    //   108: invokevirtual 271	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   111: aload 8
    //   113: ldc_w 273
    //   116: invokevirtual 276	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +6 -> 129
    //   126: goto +9 -> 135
    //   129: aload_2
    //   130: aconst_null
    //   131: invokestatic 288	btmsdkobf/dz:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_1
    //   135: new 162	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   142: astore_2
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc_w 290
    //   153: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: aload_2
    //   159: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: putfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   165: new 162	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   172: astore_2
    //   173: aload_2
    //   174: ldc_w 292
    //   177: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: aload_0
    //   183: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   186: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: ldc 119
    //   192: aload_2
    //   193: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   203: ifnonnull +8 -> 211
    //   206: aload_0
    //   207: aload_1
    //   208: putfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   211: new 53	java/io/File
    //   214: dup
    //   215: aload_0
    //   216: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   219: aload_0
    //   220: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   223: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 88	java/io/File:exists	()Z
    //   231: ifeq +61 -> 292
    //   234: aload_0
    //   235: aload_1
    //   236: invokevirtual 296	java/io/File:length	()J
    //   239: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   242: new 162	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   249: astore_1
    //   250: aload_1
    //   251: ldc_w 298
    //   254: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: aload_0
    //   260: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   263: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc_w 300
    //   271: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 8
    //   277: ldc_w 302
    //   280: aload_1
    //   281: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 305	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: iconst_1
    //   289: putfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   292: aload 8
    //   294: invokevirtual 308	java/net/HttpURLConnection:getResponseCode	()I
    //   297: istore 5
    //   299: new 162	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   306: astore_1
    //   307: aload_1
    //   308: ldc_w 310
    //   311: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_1
    //   316: iload 5
    //   318: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 119
    //   324: aload_1
    //   325: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: iload 5
    //   333: sipush 200
    //   336: if_icmpeq +22 -> 358
    //   339: iload 5
    //   341: sipush 206
    //   344: if_icmpeq +14 -> 358
    //   347: sipush -3000
    //   350: iload 5
    //   352: isub
    //   353: istore 5
    //   355: goto +191 -> 546
    //   358: aload_0
    //   359: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   362: ifeq +6 -> 368
    //   365: goto +1122 -> 1487
    //   368: aload_0
    //   369: aload 8
    //   371: aload 17
    //   373: iload_3
    //   374: invokespecial 312	com/tmsdk/base/utils/HttpGetFile:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;Z)I
    //   377: istore 5
    //   379: iload 5
    //   381: ifeq +6 -> 387
    //   384: goto +162 -> 546
    //   387: aload 4
    //   389: ifnull +135 -> 524
    //   392: new 162	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   399: astore_1
    //   400: aload_1
    //   401: aload_0
    //   402: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   405: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: getstatic 213	java/io/File:separator	Ljava/lang/String;
    //   413: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_1
    //   418: aload_0
    //   419: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   422: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 4
    //   428: aload_1
    //   429: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokeinterface 316 2 0
    //   437: istore_3
    //   438: iload_3
    //   439: ifne +85 -> 524
    //   442: new 162	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   449: astore_1
    //   450: aload_1
    //   451: aload_0
    //   452: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   455: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_1
    //   460: getstatic 213	java/io/File:separator	Ljava/lang/String;
    //   463: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_1
    //   468: aload_0
    //   469: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   472: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: new 53	java/io/File
    //   479: dup
    //   480: aload_1
    //   481: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   487: invokevirtual 231	java/io/File:delete	()Z
    //   490: pop
    //   491: sipush -7000
    //   494: istore 5
    //   496: goto +50 -> 546
    //   499: astore_1
    //   500: sipush -7000
    //   503: istore 5
    //   505: aload 11
    //   507: astore 10
    //   509: goto +888 -> 1397
    //   512: astore_2
    //   513: aload 8
    //   515: astore_1
    //   516: sipush -7000
    //   519: istore 5
    //   521: goto +348 -> 869
    //   524: aload_0
    //   525: iconst_1
    //   526: invokespecial 318	com/tmsdk/base/utils/HttpGetFile:a	(Z)I
    //   529: istore 7
    //   531: iload 7
    //   533: ifeq +10 -> 543
    //   536: iload 7
    //   538: istore 5
    //   540: goto -156 -> 384
    //   543: iconst_0
    //   544: istore 5
    //   546: aload 8
    //   548: ifnull +8 -> 556
    //   551: aload 8
    //   553: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   556: iload 5
    //   558: istore 7
    //   560: iload 5
    //   562: ifeq +832 -> 1394
    //   565: iload 5
    //   567: istore 7
    //   569: iload 5
    //   571: bipush 249
    //   573: if_icmpeq +821 -> 1394
    //   576: aload 11
    //   578: astore_1
    //   579: aload 17
    //   581: ldc_w 323
    //   584: iload 5
    //   586: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   589: aload 17
    //   591: ldc_w 325
    //   594: aload_1
    //   595: invokevirtual 328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 17
    //   600: ldc_w 330
    //   603: aload_0
    //   604: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   607: l2i
    //   608: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload 17
    //   613: ldc_w 332
    //   616: aload_0
    //   617: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   620: l2i
    //   621: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   624: aload 17
    //   626: ldc_w 334
    //   629: aload_0
    //   630: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   633: i2b
    //   634: invokevirtual 338	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   637: aload_0
    //   638: iconst_1
    //   639: aload 17
    //   641: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   644: iload 5
    //   646: ireturn
    //   647: astore_1
    //   648: aload 11
    //   650: astore 10
    //   652: goto +745 -> 1397
    //   655: astore_2
    //   656: goto +27 -> 683
    //   659: astore_1
    //   660: aload 11
    //   662: astore 10
    //   664: iload 6
    //   666: istore 5
    //   668: goto +729 -> 1397
    //   671: astore_1
    //   672: aload 8
    //   674: astore_2
    //   675: goto +47 -> 722
    //   678: astore_2
    //   679: iload 6
    //   681: istore 5
    //   683: aload 8
    //   685: astore_1
    //   686: goto +183 -> 869
    //   689: astore_1
    //   690: aload 8
    //   692: astore_2
    //   693: goto +263 -> 956
    //   696: astore_1
    //   697: aload 8
    //   699: astore_2
    //   700: goto +404 -> 1104
    //   703: astore_1
    //   704: aload 8
    //   706: astore_2
    //   707: goto +544 -> 1251
    //   710: astore_1
    //   711: aload 9
    //   713: astore 8
    //   715: goto +682 -> 1397
    //   718: astore_1
    //   719: aload 12
    //   721: astore_2
    //   722: aload 11
    //   724: astore 10
    //   726: aload_2
    //   727: astore 9
    //   729: iload 6
    //   731: istore 5
    //   733: aload_1
    //   734: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   737: astore 4
    //   739: aload 4
    //   741: astore 10
    //   743: aload_2
    //   744: astore 9
    //   746: iload 6
    //   748: istore 5
    //   750: new 162	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   757: astore 8
    //   759: aload 4
    //   761: astore 10
    //   763: aload_2
    //   764: astore 9
    //   766: iload 6
    //   768: istore 5
    //   770: aload 8
    //   772: ldc_w 340
    //   775: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload 4
    //   781: astore 10
    //   783: aload_2
    //   784: astore 9
    //   786: iload 6
    //   788: istore 5
    //   790: aload 8
    //   792: aload_1
    //   793: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   796: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 4
    //   802: astore 10
    //   804: aload_2
    //   805: astore 9
    //   807: iload 6
    //   809: istore 5
    //   811: ldc 119
    //   813: aload 8
    //   815: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload 4
    //   823: astore 10
    //   825: aload_2
    //   826: astore 9
    //   828: iload 6
    //   830: istore 5
    //   832: aload_1
    //   833: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   836: aload 4
    //   838: astore_1
    //   839: iload 6
    //   841: istore 5
    //   843: aload_2
    //   844: ifnull -265 -> 579
    //   847: aload_2
    //   848: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   851: aload 4
    //   853: astore_1
    //   854: iload 6
    //   856: istore 5
    //   858: goto -279 -> 579
    //   861: astore_2
    //   862: iload 6
    //   864: istore 5
    //   866: aload 13
    //   868: astore_1
    //   869: aload 11
    //   871: astore 10
    //   873: aload_1
    //   874: astore 9
    //   876: aload_2
    //   877: invokevirtual 342	btmsdkobf/bm:I	()I
    //   880: istore 6
    //   882: aload 11
    //   884: astore 10
    //   886: aload_1
    //   887: astore 9
    //   889: iload 6
    //   891: istore 5
    //   893: aload_2
    //   894: invokevirtual 343	btmsdkobf/bm:getMessage	()Ljava/lang/String;
    //   897: astore_2
    //   898: aload_1
    //   899: ifnull +7 -> 906
    //   902: aload_1
    //   903: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   906: iload 6
    //   908: istore 7
    //   910: iload 6
    //   912: ifeq +482 -> 1394
    //   915: iload 6
    //   917: istore 7
    //   919: iload 6
    //   921: bipush 249
    //   923: if_icmpeq +471 -> 1394
    //   926: aload 17
    //   928: ldc_w 323
    //   931: iload 6
    //   933: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   936: aload 17
    //   938: ldc_w 325
    //   941: aload_2
    //   942: invokevirtual 328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: iload 6
    //   947: istore 5
    //   949: goto -351 -> 598
    //   952: astore_1
    //   953: aload 14
    //   955: astore_2
    //   956: sipush -3056
    //   959: istore 6
    //   961: aload 11
    //   963: astore 10
    //   965: aload_2
    //   966: astore 9
    //   968: iload 6
    //   970: istore 5
    //   972: aload_1
    //   973: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   976: astore 4
    //   978: aload 4
    //   980: astore 10
    //   982: aload_2
    //   983: astore 9
    //   985: iload 6
    //   987: istore 5
    //   989: new 162	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   996: astore 8
    //   998: aload 4
    //   1000: astore 10
    //   1002: aload_2
    //   1003: astore 9
    //   1005: iload 6
    //   1007: istore 5
    //   1009: aload 8
    //   1011: ldc_w 345
    //   1014: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: aload 4
    //   1020: astore 10
    //   1022: aload_2
    //   1023: astore 9
    //   1025: iload 6
    //   1027: istore 5
    //   1029: aload 8
    //   1031: aload_1
    //   1032: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1035: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 4
    //   1041: astore 10
    //   1043: aload_2
    //   1044: astore 9
    //   1046: iload 6
    //   1048: istore 5
    //   1050: ldc 119
    //   1052: aload 8
    //   1054: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1060: aload 4
    //   1062: astore 10
    //   1064: aload_2
    //   1065: astore 9
    //   1067: iload 6
    //   1069: istore 5
    //   1071: aload_1
    //   1072: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1075: aload 4
    //   1077: astore_1
    //   1078: iload 6
    //   1080: istore 5
    //   1082: aload_2
    //   1083: ifnull -504 -> 579
    //   1086: aload_2
    //   1087: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   1090: aload 4
    //   1092: astore_1
    //   1093: iload 6
    //   1095: istore 5
    //   1097: goto -518 -> 579
    //   1100: astore_1
    //   1101: aload 15
    //   1103: astore_2
    //   1104: sipush -3055
    //   1107: istore 6
    //   1109: aload 11
    //   1111: astore 10
    //   1113: aload_2
    //   1114: astore 9
    //   1116: iload 6
    //   1118: istore 5
    //   1120: aload_1
    //   1121: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1124: astore 4
    //   1126: aload 4
    //   1128: astore 10
    //   1130: aload_2
    //   1131: astore 9
    //   1133: iload 6
    //   1135: istore 5
    //   1137: new 162	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1144: astore 8
    //   1146: aload 4
    //   1148: astore 10
    //   1150: aload_2
    //   1151: astore 9
    //   1153: iload 6
    //   1155: istore 5
    //   1157: aload 8
    //   1159: ldc 199
    //   1161: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload 4
    //   1167: astore 10
    //   1169: aload_2
    //   1170: astore 9
    //   1172: iload 6
    //   1174: istore 5
    //   1176: aload 8
    //   1178: aload_1
    //   1179: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1182: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 4
    //   1188: astore 10
    //   1190: aload_2
    //   1191: astore 9
    //   1193: iload 6
    //   1195: istore 5
    //   1197: ldc 119
    //   1199: aload 8
    //   1201: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1207: aload 4
    //   1209: astore 10
    //   1211: aload_2
    //   1212: astore 9
    //   1214: iload 6
    //   1216: istore 5
    //   1218: aload_1
    //   1219: invokevirtual 201	java/net/SocketTimeoutException:printStackTrace	()V
    //   1222: aload 4
    //   1224: astore_1
    //   1225: iload 6
    //   1227: istore 5
    //   1229: aload_2
    //   1230: ifnull -651 -> 579
    //   1233: aload_2
    //   1234: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   1237: aload 4
    //   1239: astore_1
    //   1240: iload 6
    //   1242: istore 5
    //   1244: goto -665 -> 579
    //   1247: astore_1
    //   1248: aload 16
    //   1250: astore_2
    //   1251: sipush -3054
    //   1254: istore 6
    //   1256: aload 11
    //   1258: astore 10
    //   1260: aload_2
    //   1261: astore 9
    //   1263: iload 6
    //   1265: istore 5
    //   1267: aload_1
    //   1268: invokevirtual 204	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1271: astore 4
    //   1273: aload 4
    //   1275: astore 10
    //   1277: aload_2
    //   1278: astore 9
    //   1280: iload 6
    //   1282: istore 5
    //   1284: new 162	java/lang/StringBuilder
    //   1287: dup
    //   1288: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1291: astore 8
    //   1293: aload 4
    //   1295: astore 10
    //   1297: aload_2
    //   1298: astore 9
    //   1300: iload 6
    //   1302: istore 5
    //   1304: aload 8
    //   1306: ldc 203
    //   1308: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: aload 4
    //   1314: astore 10
    //   1316: aload_2
    //   1317: astore 9
    //   1319: iload 6
    //   1321: istore 5
    //   1323: aload 8
    //   1325: aload_1
    //   1326: invokevirtual 204	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1329: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: pop
    //   1333: aload 4
    //   1335: astore 10
    //   1337: aload_2
    //   1338: astore 9
    //   1340: iload 6
    //   1342: istore 5
    //   1344: ldc 119
    //   1346: aload 8
    //   1348: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload 4
    //   1356: astore 10
    //   1358: aload_2
    //   1359: astore 9
    //   1361: iload 6
    //   1363: istore 5
    //   1365: aload_1
    //   1366: invokevirtual 205	java/net/SocketException:printStackTrace	()V
    //   1369: aload 4
    //   1371: astore_1
    //   1372: iload 6
    //   1374: istore 5
    //   1376: aload_2
    //   1377: ifnull -798 -> 579
    //   1380: aload_2
    //   1381: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   1384: aload 4
    //   1386: astore_1
    //   1387: iload 6
    //   1389: istore 5
    //   1391: goto -812 -> 579
    //   1394: iload 7
    //   1396: ireturn
    //   1397: aload 8
    //   1399: ifnull +8 -> 1407
    //   1402: aload 8
    //   1404: invokevirtual 321	java/net/HttpURLConnection:disconnect	()V
    //   1407: iload 5
    //   1409: ifeq +76 -> 1485
    //   1412: iload 5
    //   1414: bipush 249
    //   1416: if_icmpeq +69 -> 1485
    //   1419: aload 17
    //   1421: ldc_w 323
    //   1424: iload 5
    //   1426: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1429: aload 17
    //   1431: ldc_w 325
    //   1434: aload 10
    //   1436: invokevirtual 328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1439: aload 17
    //   1441: ldc_w 330
    //   1444: aload_0
    //   1445: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1448: l2i
    //   1449: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1452: aload 17
    //   1454: ldc_w 332
    //   1457: aload_0
    //   1458: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1461: l2i
    //   1462: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1465: aload 17
    //   1467: ldc_w 334
    //   1470: aload_0
    //   1471: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1474: i2b
    //   1475: invokevirtual 338	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1478: aload_0
    //   1479: iconst_1
    //   1480: aload 17
    //   1482: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1485: aload_1
    //   1486: athrow
    //   1487: sipush -3003
    //   1490: istore 5
    //   1492: goto -946 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1495	0	this	HttpGetFile
    //   0	1495	1	paramString1	String
    //   0	1495	2	paramString2	String
    //   0	1495	3	paramBoolean	boolean
    //   0	1495	4	paramDataMd5Cheker	DataMd5Cheker
    //   46	1445	5	i	int
    //   34	1354	6	j	int
    //   529	866	7	k	int
    //   29	1374	8	localObject1	Object
    //   42	1318	9	localObject2	Object
    //   38	1397	10	localObject3	Object
    //   2	1255	11	str	String
    //   14	706	12	localObject4	Object
    //   17	850	13	localObject5	Object
    //   20	934	14	localObject6	Object
    //   23	1079	15	localObject7	Object
    //   26	1223	16	localObject8	Object
    //   11	1470	17	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   442	491	499	finally
    //   442	491	512	btmsdkobf/bm
    //   392	438	647	finally
    //   524	531	647	finally
    //   392	438	655	btmsdkobf/bm
    //   524	531	655	btmsdkobf/bm
    //   89	126	659	finally
    //   129	135	659	finally
    //   135	211	659	finally
    //   211	292	659	finally
    //   292	331	659	finally
    //   358	365	659	finally
    //   368	379	659	finally
    //   89	126	671	java/lang/Exception
    //   129	135	671	java/lang/Exception
    //   135	211	671	java/lang/Exception
    //   211	292	671	java/lang/Exception
    //   292	331	671	java/lang/Exception
    //   358	365	671	java/lang/Exception
    //   368	379	671	java/lang/Exception
    //   392	438	671	java/lang/Exception
    //   442	491	671	java/lang/Exception
    //   524	531	671	java/lang/Exception
    //   89	126	678	btmsdkobf/bm
    //   129	135	678	btmsdkobf/bm
    //   135	211	678	btmsdkobf/bm
    //   211	292	678	btmsdkobf/bm
    //   292	331	678	btmsdkobf/bm
    //   358	365	678	btmsdkobf/bm
    //   368	379	678	btmsdkobf/bm
    //   89	126	689	java/io/IOException
    //   129	135	689	java/io/IOException
    //   135	211	689	java/io/IOException
    //   211	292	689	java/io/IOException
    //   292	331	689	java/io/IOException
    //   358	365	689	java/io/IOException
    //   368	379	689	java/io/IOException
    //   392	438	689	java/io/IOException
    //   442	491	689	java/io/IOException
    //   524	531	689	java/io/IOException
    //   89	126	696	java/net/SocketTimeoutException
    //   129	135	696	java/net/SocketTimeoutException
    //   135	211	696	java/net/SocketTimeoutException
    //   211	292	696	java/net/SocketTimeoutException
    //   292	331	696	java/net/SocketTimeoutException
    //   358	365	696	java/net/SocketTimeoutException
    //   368	379	696	java/net/SocketTimeoutException
    //   392	438	696	java/net/SocketTimeoutException
    //   442	491	696	java/net/SocketTimeoutException
    //   524	531	696	java/net/SocketTimeoutException
    //   89	126	703	java/net/SocketException
    //   129	135	703	java/net/SocketException
    //   135	211	703	java/net/SocketException
    //   211	292	703	java/net/SocketException
    //   292	331	703	java/net/SocketException
    //   358	365	703	java/net/SocketException
    //   368	379	703	java/net/SocketException
    //   392	438	703	java/net/SocketException
    //   442	491	703	java/net/SocketException
    //   524	531	703	java/net/SocketException
    //   48	55	710	finally
    //   73	89	710	finally
    //   733	739	710	finally
    //   750	759	710	finally
    //   770	779	710	finally
    //   790	800	710	finally
    //   811	821	710	finally
    //   832	836	710	finally
    //   876	882	710	finally
    //   893	898	710	finally
    //   972	978	710	finally
    //   989	998	710	finally
    //   1009	1018	710	finally
    //   1029	1039	710	finally
    //   1050	1060	710	finally
    //   1071	1075	710	finally
    //   1120	1126	710	finally
    //   1137	1146	710	finally
    //   1157	1165	710	finally
    //   1176	1186	710	finally
    //   1197	1207	710	finally
    //   1218	1222	710	finally
    //   1267	1273	710	finally
    //   1284	1293	710	finally
    //   1304	1312	710	finally
    //   1323	1333	710	finally
    //   1344	1354	710	finally
    //   1365	1369	710	finally
    //   48	55	718	java/lang/Exception
    //   73	89	718	java/lang/Exception
    //   48	55	861	btmsdkobf/bm
    //   73	89	861	btmsdkobf/bm
    //   48	55	952	java/io/IOException
    //   73	89	952	java/io/IOException
    //   48	55	1100	java/net/SocketTimeoutException
    //   73	89	1100	java/net/SocketTimeoutException
    //   48	55	1247	java/net/SocketException
    //   73	89	1247	java/net/SocketException
  }
  
  public String getAbsoluteDownFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.D);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.F);
    return localStringBuilder.toString();
  }
  
  public boolean isCanceled()
  {
    try
    {
      boolean bool = this.H;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setFileMode(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setSaveName(String paramString)
  {
    this.F = paramString;
  }
  
  public void setSavePath(String paramString)
  {
    this.D = paramString;
  }
  
  public static abstract interface DataMd5Cheker
  {
    public abstract boolean isMatch(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.HttpGetFile
 * JD-Core Version:    0.7.0.1
 */