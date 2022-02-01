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
    //   150: goto +1222 -> 1372
    //   153: aload 22
    //   155: astore 12
    //   157: aload 21
    //   159: astore 13
    //   161: aload_1
    //   162: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   165: astore 10
    //   167: goto +1205 -> 1372
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
    //   206: if_icmpeq +300 -> 506
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
    //   239: ifeq +66 -> 305
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
    //   286: goto +15 -> 301
    //   289: astore_1
    //   290: ldc 119
    //   292: ldc 142
    //   294: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_1
    //   298: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   301: sipush -5003
    //   304: ireturn
    //   305: aload 10
    //   307: astore 12
    //   309: aload 10
    //   311: astore 13
    //   313: aload 10
    //   315: astore 14
    //   317: aload 10
    //   319: astore 15
    //   321: aload 10
    //   323: astore 16
    //   325: aload 10
    //   327: astore 17
    //   329: aload_0
    //   330: aload_0
    //   331: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   334: iload 9
    //   336: i2l
    //   337: ladd
    //   338: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   341: iload 4
    //   343: iload 9
    //   345: iadd
    //   346: istore 4
    //   348: aload 10
    //   350: astore 12
    //   352: aload 10
    //   354: astore 13
    //   356: aload 10
    //   358: astore 14
    //   360: aload 10
    //   362: astore 15
    //   364: aload 10
    //   366: astore 16
    //   368: aload 10
    //   370: astore 17
    //   372: aload_0
    //   373: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   376: ldc2_w 80
    //   379: lmul
    //   380: aload_0
    //   381: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   384: ldiv
    //   385: l2i
    //   386: istore 8
    //   388: iload 5
    //   390: istore 6
    //   392: iload 8
    //   394: iload 5
    //   396: if_icmpeq +69 -> 465
    //   399: aload 10
    //   401: astore 12
    //   403: aload 10
    //   405: astore 13
    //   407: aload 10
    //   409: astore 14
    //   411: aload 10
    //   413: astore 15
    //   415: aload 10
    //   417: astore 16
    //   419: aload 10
    //   421: astore 17
    //   423: aload_2
    //   424: ldc 144
    //   426: iload 8
    //   428: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   431: aload 10
    //   433: astore 12
    //   435: aload 10
    //   437: astore 13
    //   439: aload 10
    //   441: astore 14
    //   443: aload 10
    //   445: astore 15
    //   447: aload 10
    //   449: astore 16
    //   451: aload 10
    //   453: astore 17
    //   455: aload_0
    //   456: iconst_2
    //   457: aload_2
    //   458: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   461: iload 8
    //   463: istore 6
    //   465: aload 10
    //   467: astore 12
    //   469: aload 10
    //   471: astore 13
    //   473: aload 10
    //   475: astore 14
    //   477: aload 10
    //   479: astore 15
    //   481: aload 10
    //   483: astore 16
    //   485: aload 10
    //   487: astore 17
    //   489: aload 11
    //   491: aload 23
    //   493: iconst_0
    //   494: iload 9
    //   496: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   499: iload 6
    //   501: istore 5
    //   503: goto -333 -> 170
    //   506: aload 10
    //   508: astore 12
    //   510: aload 10
    //   512: astore 13
    //   514: aload 10
    //   516: astore 14
    //   518: aload 10
    //   520: astore 15
    //   522: aload 10
    //   524: astore 16
    //   526: aload 10
    //   528: astore 17
    //   530: aload 11
    //   532: invokevirtual 160	java/io/FileOutputStream:flush	()V
    //   535: aload 10
    //   537: astore 12
    //   539: aload 10
    //   541: astore 13
    //   543: aload 10
    //   545: astore 14
    //   547: aload 10
    //   549: astore 15
    //   551: aload 10
    //   553: astore 16
    //   555: aload 10
    //   557: astore 17
    //   559: new 162	java/lang/StringBuilder
    //   562: dup
    //   563: ldc 164
    //   565: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: astore_2
    //   569: aload 10
    //   571: astore 12
    //   573: aload 10
    //   575: astore 13
    //   577: aload 10
    //   579: astore 14
    //   581: aload 10
    //   583: astore 15
    //   585: aload 10
    //   587: astore 16
    //   589: aload 10
    //   591: astore 17
    //   593: aload_2
    //   594: aload_0
    //   595: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   598: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 10
    //   604: astore 12
    //   606: aload 10
    //   608: astore 13
    //   610: aload 10
    //   612: astore 14
    //   614: aload 10
    //   616: astore 15
    //   618: aload 10
    //   620: astore 16
    //   622: aload 10
    //   624: astore 17
    //   626: aload_2
    //   627: ldc 173
    //   629: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 10
    //   635: astore 12
    //   637: aload 10
    //   639: astore 13
    //   641: aload 10
    //   643: astore 14
    //   645: aload 10
    //   647: astore 15
    //   649: aload 10
    //   651: astore 16
    //   653: aload 10
    //   655: astore 17
    //   657: aload_2
    //   658: aload_0
    //   659: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   662: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 10
    //   668: astore 12
    //   670: aload 10
    //   672: astore 13
    //   674: aload 10
    //   676: astore 14
    //   678: aload 10
    //   680: astore 15
    //   682: aload 10
    //   684: astore 16
    //   686: aload 10
    //   688: astore 17
    //   690: aload_2
    //   691: ldc 178
    //   693: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 10
    //   699: astore 12
    //   701: aload 10
    //   703: astore 13
    //   705: aload 10
    //   707: astore 14
    //   709: aload 10
    //   711: astore 15
    //   713: aload 10
    //   715: astore 16
    //   717: aload 10
    //   719: astore 17
    //   721: aload_2
    //   722: aload_1
    //   723: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   726: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 10
    //   732: astore 12
    //   734: aload 10
    //   736: astore 13
    //   738: aload 10
    //   740: astore 14
    //   742: aload 10
    //   744: astore 15
    //   746: aload 10
    //   748: astore 16
    //   750: aload 10
    //   752: astore 17
    //   754: ldc 119
    //   756: aload_2
    //   757: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: aload 10
    //   765: astore 12
    //   767: aload 10
    //   769: astore 13
    //   771: aload 10
    //   773: astore 14
    //   775: aload 10
    //   777: astore 15
    //   779: aload 10
    //   781: astore 16
    //   783: aload 10
    //   785: astore 17
    //   787: aload_1
    //   788: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   791: istore 5
    //   793: iload 4
    //   795: iload 5
    //   797: if_icmpne +10 -> 807
    //   800: iload 7
    //   802: istore 4
    //   804: goto +7 -> 811
    //   807: bipush 249
    //   809: istore 4
    //   811: iload 4
    //   813: istore 5
    //   815: aload 10
    //   817: ifnull +39 -> 856
    //   820: ldc 119
    //   822: ldc 121
    //   824: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: aload 10
    //   829: invokevirtual 129	java/io/InputStream:close	()V
    //   832: iload 4
    //   834: istore 5
    //   836: goto +20 -> 856
    //   839: astore_1
    //   840: ldc 119
    //   842: ldc 131
    //   844: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload_1
    //   848: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   851: sipush -7000
    //   854: istore 5
    //   856: ldc 119
    //   858: ldc 139
    //   860: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload 11
    //   865: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   868: iload 5
    //   870: ireturn
    //   871: astore_1
    //   872: ldc 119
    //   874: ldc 142
    //   876: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload_1
    //   880: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   883: sipush -7000
    //   886: ireturn
    //   887: astore_2
    //   888: aload 12
    //   890: astore 10
    //   892: aload 11
    //   894: astore_1
    //   895: goto +411 -> 1306
    //   898: astore 12
    //   900: aload 11
    //   902: astore 10
    //   904: aload 13
    //   906: astore 11
    //   908: goto +70 -> 978
    //   911: astore 12
    //   913: aload 11
    //   915: astore 10
    //   917: aload 14
    //   919: astore 11
    //   921: goto +119 -> 1040
    //   924: astore 12
    //   926: aload 11
    //   928: astore 10
    //   930: aload 15
    //   932: astore 11
    //   934: goto +152 -> 1086
    //   937: astore 12
    //   939: aload 11
    //   941: astore 10
    //   943: aload 16
    //   945: astore 11
    //   947: goto +222 -> 1169
    //   950: astore 12
    //   952: aload 11
    //   954: astore 10
    //   956: aload 17
    //   958: astore 11
    //   960: goto +292 -> 1252
    //   963: astore_2
    //   964: aconst_null
    //   965: astore 10
    //   967: aload 20
    //   969: astore_1
    //   970: goto +336 -> 1306
    //   973: astore 12
    //   975: aconst_null
    //   976: astore 11
    //   978: aload 10
    //   980: astore_1
    //   981: aload 11
    //   983: astore_2
    //   984: ldc 119
    //   986: aload 12
    //   988: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   991: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload 10
    //   996: astore_1
    //   997: aload 11
    //   999: astore_2
    //   1000: ldc 119
    //   1002: ldc 187
    //   1004: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload 10
    //   1009: astore_1
    //   1010: aload 11
    //   1012: astore_2
    //   1013: aload 12
    //   1015: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   1018: aload 10
    //   1020: astore_1
    //   1021: aload 11
    //   1023: astore_2
    //   1024: new 190	btmsdkobf/bm
    //   1027: dup
    //   1028: sipush -5000
    //   1031: aload 12
    //   1033: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1036: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1039: athrow
    //   1040: aload 10
    //   1042: astore_1
    //   1043: aload 11
    //   1045: astore_2
    //   1046: ldc 119
    //   1048: ldc 198
    //   1050: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1053: aload 10
    //   1055: astore_1
    //   1056: aload 11
    //   1058: astore_2
    //   1059: aload 12
    //   1061: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1064: aload 10
    //   1066: astore_1
    //   1067: aload 11
    //   1069: astore_2
    //   1070: new 190	btmsdkobf/bm
    //   1073: dup
    //   1074: sipush -5056
    //   1077: aload 12
    //   1079: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1082: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1085: athrow
    //   1086: aload 10
    //   1088: astore_1
    //   1089: aload 11
    //   1091: astore_2
    //   1092: new 162	java/lang/StringBuilder
    //   1095: dup
    //   1096: ldc 201
    //   1098: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1101: astore 13
    //   1103: aload 10
    //   1105: astore_1
    //   1106: aload 11
    //   1108: astore_2
    //   1109: aload 13
    //   1111: aload 12
    //   1113: invokevirtual 202	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1116: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 10
    //   1122: astore_1
    //   1123: aload 11
    //   1125: astore_2
    //   1126: ldc 119
    //   1128: aload 13
    //   1130: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1136: aload 10
    //   1138: astore_1
    //   1139: aload 11
    //   1141: astore_2
    //   1142: aload 12
    //   1144: invokevirtual 203	java/net/SocketTimeoutException:printStackTrace	()V
    //   1147: aload 10
    //   1149: astore_1
    //   1150: aload 11
    //   1152: astore_2
    //   1153: new 190	btmsdkobf/bm
    //   1156: dup
    //   1157: sipush -5055
    //   1160: aload 12
    //   1162: invokevirtual 202	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1165: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1168: athrow
    //   1169: aload 10
    //   1171: astore_1
    //   1172: aload 11
    //   1174: astore_2
    //   1175: new 162	java/lang/StringBuilder
    //   1178: dup
    //   1179: ldc 205
    //   1181: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1184: astore 13
    //   1186: aload 10
    //   1188: astore_1
    //   1189: aload 11
    //   1191: astore_2
    //   1192: aload 13
    //   1194: aload 12
    //   1196: invokevirtual 206	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1199: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: pop
    //   1203: aload 10
    //   1205: astore_1
    //   1206: aload 11
    //   1208: astore_2
    //   1209: ldc 119
    //   1211: aload 13
    //   1213: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1219: aload 10
    //   1221: astore_1
    //   1222: aload 11
    //   1224: astore_2
    //   1225: aload 12
    //   1227: invokevirtual 207	java/net/SocketException:printStackTrace	()V
    //   1230: aload 10
    //   1232: astore_1
    //   1233: aload 11
    //   1235: astore_2
    //   1236: new 190	btmsdkobf/bm
    //   1239: dup
    //   1240: sipush -5054
    //   1243: aload 12
    //   1245: invokevirtual 206	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1248: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1251: athrow
    //   1252: aload 10
    //   1254: astore_1
    //   1255: aload 11
    //   1257: astore_2
    //   1258: ldc 119
    //   1260: ldc 209
    //   1262: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: aload 10
    //   1267: astore_1
    //   1268: aload 11
    //   1270: astore_2
    //   1271: aload 12
    //   1273: invokevirtual 210	java/io/FileNotFoundException:printStackTrace	()V
    //   1276: aload 10
    //   1278: astore_1
    //   1279: aload 11
    //   1281: astore_2
    //   1282: new 190	btmsdkobf/bm
    //   1285: dup
    //   1286: sipush -7001
    //   1289: aload 12
    //   1291: invokevirtual 211	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   1294: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   1297: athrow
    //   1298: astore 11
    //   1300: aload_2
    //   1301: astore 10
    //   1303: aload 11
    //   1305: astore_2
    //   1306: aload 10
    //   1308: ifnull +32 -> 1340
    //   1311: ldc 119
    //   1313: ldc 121
    //   1315: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   1318: aload 10
    //   1320: invokevirtual 129	java/io/InputStream:close	()V
    //   1323: goto +17 -> 1340
    //   1326: astore 10
    //   1328: ldc 119
    //   1330: ldc 131
    //   1332: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1335: aload 10
    //   1337: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1340: aload_1
    //   1341: ifnull +29 -> 1370
    //   1344: ldc 119
    //   1346: ldc 139
    //   1348: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: aload_1
    //   1352: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   1355: goto +15 -> 1370
    //   1358: astore_1
    //   1359: ldc 119
    //   1361: ldc 142
    //   1363: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1366: aload_1
    //   1367: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1370: aload_2
    //   1371: athrow
    //   1372: iconst_0
    //   1373: istore 7
    //   1375: iconst_0
    //   1376: istore 4
    //   1378: goto -1208 -> 170
    //   1381: astore_1
    //   1382: aconst_null
    //   1383: astore 11
    //   1385: aload 12
    //   1387: astore 10
    //   1389: aload_1
    //   1390: astore 12
    //   1392: goto -352 -> 1040
    //   1395: astore 12
    //   1397: aconst_null
    //   1398: astore 11
    //   1400: aload 13
    //   1402: astore 10
    //   1404: goto -318 -> 1086
    //   1407: astore 12
    //   1409: aconst_null
    //   1410: astore 11
    //   1412: aload 18
    //   1414: astore 10
    //   1416: goto -247 -> 1169
    //   1419: astore 12
    //   1421: aconst_null
    //   1422: astore 11
    //   1424: aload 19
    //   1426: astore 10
    //   1428: goto -176 -> 1252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1431	0	this	HttpGetFile
    //   0	1431	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	1431	2	paramBundle	android.os.Bundle
    //   0	1431	3	paramBoolean	boolean
    //   341	1036	4	i	int
    //   71	798	5	j	int
    //   390	110	6	k	int
    //   800	574	7	m	int
    //   386	76	8	n	int
    //   201	294	9	i1	int
    //   23	1296	10	localObject1	Object
    //   1326	10	10	localIOException1	java.io.IOException
    //   1387	40	10	localObject2	Object
    //   88	1192	11	localObject3	Object
    //   1298	6	11	localObject4	Object
    //   1383	40	11	localObject5	Object
    //   26	863	12	localObject6	Object
    //   898	1	12	localException1	java.lang.Exception
    //   911	1	12	localIOException2	java.io.IOException
    //   924	1	12	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   937	1	12	localSocketException1	java.net.SocketException
    //   950	1	12	localFileNotFoundException1	java.io.FileNotFoundException
    //   973	413	12	localException2	java.lang.Exception
    //   1390	1	12	localHttpURLConnection	java.net.HttpURLConnection
    //   1395	1	12	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1407	1	12	localSocketException2	java.net.SocketException
    //   1419	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    //   29	1372	13	localObject7	Object
    //   11	907	14	localObject8	Object
    //   14	917	15	localObject9	Object
    //   17	927	16	localObject10	Object
    //   20	937	17	localObject11	Object
    //   32	1381	18	localObject12	Object
    //   35	1390	19	localObject13	Object
    //   38	930	20	localObject14	Object
    //   8	150	21	localObject15	Object
    //   41	113	22	localObject16	Object
    //   5	487	23	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   254	259	262	java/io/IOException
    //   281	286	289	java/io/IOException
    //   827	832	839	java/io/IOException
    //   863	868	871	java/io/IOException
    //   137	150	887	finally
    //   161	167	887	finally
    //   194	203	887	finally
    //   233	238	887	finally
    //   329	341	887	finally
    //   372	388	887	finally
    //   423	431	887	finally
    //   455	461	887	finally
    //   489	499	887	finally
    //   530	535	887	finally
    //   559	569	887	finally
    //   593	602	887	finally
    //   626	633	887	finally
    //   657	666	887	finally
    //   690	697	887	finally
    //   721	730	887	finally
    //   754	763	887	finally
    //   787	793	887	finally
    //   137	150	898	java/lang/Exception
    //   161	167	898	java/lang/Exception
    //   194	203	898	java/lang/Exception
    //   233	238	898	java/lang/Exception
    //   329	341	898	java/lang/Exception
    //   372	388	898	java/lang/Exception
    //   423	431	898	java/lang/Exception
    //   455	461	898	java/lang/Exception
    //   489	499	898	java/lang/Exception
    //   530	535	898	java/lang/Exception
    //   559	569	898	java/lang/Exception
    //   593	602	898	java/lang/Exception
    //   626	633	898	java/lang/Exception
    //   657	666	898	java/lang/Exception
    //   690	697	898	java/lang/Exception
    //   721	730	898	java/lang/Exception
    //   754	763	898	java/lang/Exception
    //   787	793	898	java/lang/Exception
    //   137	150	911	java/io/IOException
    //   161	167	911	java/io/IOException
    //   194	203	911	java/io/IOException
    //   233	238	911	java/io/IOException
    //   329	341	911	java/io/IOException
    //   372	388	911	java/io/IOException
    //   423	431	911	java/io/IOException
    //   455	461	911	java/io/IOException
    //   489	499	911	java/io/IOException
    //   530	535	911	java/io/IOException
    //   559	569	911	java/io/IOException
    //   593	602	911	java/io/IOException
    //   626	633	911	java/io/IOException
    //   657	666	911	java/io/IOException
    //   690	697	911	java/io/IOException
    //   721	730	911	java/io/IOException
    //   754	763	911	java/io/IOException
    //   787	793	911	java/io/IOException
    //   137	150	924	java/net/SocketTimeoutException
    //   161	167	924	java/net/SocketTimeoutException
    //   194	203	924	java/net/SocketTimeoutException
    //   233	238	924	java/net/SocketTimeoutException
    //   329	341	924	java/net/SocketTimeoutException
    //   372	388	924	java/net/SocketTimeoutException
    //   423	431	924	java/net/SocketTimeoutException
    //   455	461	924	java/net/SocketTimeoutException
    //   489	499	924	java/net/SocketTimeoutException
    //   530	535	924	java/net/SocketTimeoutException
    //   559	569	924	java/net/SocketTimeoutException
    //   593	602	924	java/net/SocketTimeoutException
    //   626	633	924	java/net/SocketTimeoutException
    //   657	666	924	java/net/SocketTimeoutException
    //   690	697	924	java/net/SocketTimeoutException
    //   721	730	924	java/net/SocketTimeoutException
    //   754	763	924	java/net/SocketTimeoutException
    //   787	793	924	java/net/SocketTimeoutException
    //   137	150	937	java/net/SocketException
    //   161	167	937	java/net/SocketException
    //   194	203	937	java/net/SocketException
    //   233	238	937	java/net/SocketException
    //   329	341	937	java/net/SocketException
    //   372	388	937	java/net/SocketException
    //   423	431	937	java/net/SocketException
    //   455	461	937	java/net/SocketException
    //   489	499	937	java/net/SocketException
    //   530	535	937	java/net/SocketException
    //   559	569	937	java/net/SocketException
    //   593	602	937	java/net/SocketException
    //   626	633	937	java/net/SocketException
    //   657	666	937	java/net/SocketException
    //   690	697	937	java/net/SocketException
    //   721	730	937	java/net/SocketException
    //   754	763	937	java/net/SocketException
    //   787	793	937	java/net/SocketException
    //   137	150	950	java/io/FileNotFoundException
    //   161	167	950	java/io/FileNotFoundException
    //   194	203	950	java/io/FileNotFoundException
    //   233	238	950	java/io/FileNotFoundException
    //   329	341	950	java/io/FileNotFoundException
    //   372	388	950	java/io/FileNotFoundException
    //   423	431	950	java/io/FileNotFoundException
    //   455	461	950	java/io/FileNotFoundException
    //   489	499	950	java/io/FileNotFoundException
    //   530	535	950	java/io/FileNotFoundException
    //   559	569	950	java/io/FileNotFoundException
    //   593	602	950	java/io/FileNotFoundException
    //   626	633	950	java/io/FileNotFoundException
    //   657	666	950	java/io/FileNotFoundException
    //   690	697	950	java/io/FileNotFoundException
    //   721	730	950	java/io/FileNotFoundException
    //   754	763	950	java/io/FileNotFoundException
    //   787	793	950	java/io/FileNotFoundException
    //   43	113	963	finally
    //   113	125	963	finally
    //   43	113	973	java/lang/Exception
    //   113	125	973	java/lang/Exception
    //   984	994	1298	finally
    //   1000	1007	1298	finally
    //   1013	1018	1298	finally
    //   1024	1040	1298	finally
    //   1046	1053	1298	finally
    //   1059	1064	1298	finally
    //   1070	1086	1298	finally
    //   1092	1103	1298	finally
    //   1109	1120	1298	finally
    //   1126	1136	1298	finally
    //   1142	1147	1298	finally
    //   1153	1169	1298	finally
    //   1175	1186	1298	finally
    //   1192	1203	1298	finally
    //   1209	1219	1298	finally
    //   1225	1230	1298	finally
    //   1236	1252	1298	finally
    //   1258	1265	1298	finally
    //   1271	1276	1298	finally
    //   1282	1298	1298	finally
    //   1318	1323	1326	java/io/IOException
    //   1351	1355	1358	java/io/IOException
    //   43	113	1381	java/io/IOException
    //   113	125	1381	java/io/IOException
    //   43	113	1395	java/net/SocketTimeoutException
    //   113	125	1395	java/net/SocketTimeoutException
    //   43	113	1407	java/net/SocketException
    //   113	125	1407	java/net/SocketException
    //   43	113	1419	java/io/FileNotFoundException
    //   113	125	1419	java/io/FileNotFoundException
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 162	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   15: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 4
    //   21: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 4
    //   30: aload_0
    //   31: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   34: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 218
    //   40: aload 4
    //   42: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 162	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   63: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: aload_0
    //   79: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   82: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc 218
    //   88: aload 4
    //   90: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   162: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +27 -> 192
    //   168: aload_0
    //   169: getfield 45	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   172: aload_0
    //   173: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   176: aload_0
    //   177: getfield 35	com/tmsdk/base/utils/HttpGetFile:G	I
    //   180: invokevirtual 228	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   183: astore 7
    //   185: aload 7
    //   187: astore 4
    //   189: goto +117 -> 306
    //   192: new 162	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   199: astore 7
    //   201: aload 7
    //   203: aload_0
    //   204: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 7
    //   213: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   216: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: aload_0
    //   223: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   226: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: new 53	java/io/File
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 88	java/io/File:exists	()Z
    //   249: ifeq +27 -> 276
    //   252: aload 7
    //   254: invokevirtual 232	java/io/File:delete	()Z
    //   257: pop
    //   258: new 99	java/io/FileOutputStream
    //   261: dup
    //   262: aload 7
    //   264: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   297: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   300: astore 7
    //   302: aload 7
    //   304: astore 4
    //   306: new 237	java/io/FileInputStream
    //   309: dup
    //   310: aload 5
    //   312: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   315: astore 6
    //   317: sipush 1024
    //   320: newarray byte
    //   322: astore 7
    //   324: aload 6
    //   326: aload 7
    //   328: invokevirtual 239	java/io/FileInputStream:read	([B)I
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
    //   463: invokevirtual 240	java/io/FileInputStream:close	()V
    //   466: iload_3
    //   467: istore_2
    //   468: goto +21 -> 489
    //   471: astore 6
    //   473: ldc 119
    //   475: ldc 242
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
    //   510: ldc 244
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
    //   538: invokevirtual 232	java/io/File:delete	()Z
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
    //   631: ldc 246
    //   633: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload 9
    //   638: astore 6
    //   640: aload 10
    //   642: astore 4
    //   644: aload 7
    //   646: astore 5
    //   648: aload 8
    //   650: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   653: aload 9
    //   655: astore 6
    //   657: aload 10
    //   659: astore 4
    //   661: aload 7
    //   663: astore 5
    //   665: new 190	btmsdkobf/bm
    //   668: dup
    //   669: sipush -7000
    //   672: aload 8
    //   674: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   677: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   680: athrow
    //   681: aload 9
    //   683: astore 6
    //   685: aload 10
    //   687: astore 4
    //   689: aload 7
    //   691: astore 5
    //   693: ldc 119
    //   695: ldc 248
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
    //   729: new 190	btmsdkobf/bm
    //   732: dup
    //   733: sipush -7056
    //   736: aload 8
    //   738: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   741: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   744: athrow
    //   745: aload 9
    //   747: astore 6
    //   749: aload 10
    //   751: astore 4
    //   753: aload 7
    //   755: astore 5
    //   757: ldc 119
    //   759: ldc 209
    //   761: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload 9
    //   766: astore 6
    //   768: aload 10
    //   770: astore 4
    //   772: aload 7
    //   774: astore 5
    //   776: aload 8
    //   778: invokevirtual 210	java/io/FileNotFoundException:printStackTrace	()V
    //   781: aload 9
    //   783: astore 6
    //   785: aload 10
    //   787: astore 4
    //   789: aload 7
    //   791: astore 5
    //   793: new 190	btmsdkobf/bm
    //   796: dup
    //   797: sipush -7001
    //   800: aload 8
    //   802: invokevirtual 211	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   805: invokespecial 196	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
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
    //   834: invokevirtual 240	java/io/FileInputStream:close	()V
    //   837: goto +17 -> 854
    //   840: astore 7
    //   842: ldc 119
    //   844: ldc 242
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
    //   871: ldc 244
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
    //   900: invokevirtual 232	java/io/File:delete	()Z
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
    //   0: ldc 253
    //   2: astore 10
    //   4: new 146	android/os/Bundle
    //   7: dup
    //   8: invokespecial 254	android/os/Bundle:<init>	()V
    //   11: astore 18
    //   13: sipush -3056
    //   16: istore 7
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 14
    //   24: aconst_null
    //   25: astore 15
    //   27: aconst_null
    //   28: astore 16
    //   30: aconst_null
    //   31: astore 17
    //   33: aconst_null
    //   34: astore 9
    //   36: sipush -3000
    //   39: istore 6
    //   41: aload 10
    //   43: astore 11
    //   45: aload 9
    //   47: astore 12
    //   49: aload_0
    //   50: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   53: ifeq +9 -> 62
    //   56: aconst_null
    //   57: astore 9
    //   59: goto +1372 -> 1431
    //   62: aload 10
    //   64: astore 11
    //   66: aload 9
    //   68: astore 12
    //   70: new 256	java/net/URL
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 257	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 261	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   81: checkcast 75	java/net/HttpURLConnection
    //   84: astore 9
    //   86: aload 9
    //   88: sipush 10000
    //   91: invokevirtual 265	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   94: aload 9
    //   96: sipush 20000
    //   99: invokevirtual 268	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   102: aload 9
    //   104: iconst_1
    //   105: invokevirtual 272	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   108: aload 9
    //   110: ldc_w 274
    //   113: invokevirtual 277	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   116: aload_1
    //   117: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifeq +1319 -> 1439
    //   123: aload_2
    //   124: aconst_null
    //   125: invokestatic 289	btmsdkobf/dz:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_1
    //   129: goto +3 -> 132
    //   132: new 162	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   139: astore_2
    //   140: aload_2
    //   141: aload_1
    //   142: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: ldc_w 291
    //   150: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: putfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   162: new 162	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 293
    //   169: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   178: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 119
    //   184: aload_2
    //   185: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_0
    //   192: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   195: ifnonnull +8 -> 203
    //   198: aload_0
    //   199: aload_1
    //   200: putfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   203: new 53	java/io/File
    //   206: dup
    //   207: aload_0
    //   208: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   211: aload_0
    //   212: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   215: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 88	java/io/File:exists	()Z
    //   223: ifeq +56 -> 279
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 297	java/io/File:length	()J
    //   231: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   234: new 162	java/lang/StringBuilder
    //   237: dup
    //   238: ldc_w 299
    //   241: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: astore_1
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   250: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: ldc_w 301
    //   258: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 9
    //   264: ldc_w 303
    //   267: aload_1
    //   268: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: iconst_1
    //   276: putfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   279: aload 9
    //   281: invokevirtual 309	java/net/HttpURLConnection:getResponseCode	()I
    //   284: istore 5
    //   286: ldc 119
    //   288: ldc_w 311
    //   291: iload 5
    //   293: invokestatic 315	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   296: invokevirtual 319	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: iload 5
    //   304: sipush 200
    //   307: if_icmpeq +22 -> 329
    //   310: iload 5
    //   312: sipush 206
    //   315: if_icmpeq +14 -> 329
    //   318: sipush -3000
    //   321: iload 5
    //   323: isub
    //   324: istore 5
    //   326: goto +184 -> 510
    //   329: aload_0
    //   330: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   333: ifeq +6 -> 339
    //   336: goto +1095 -> 1431
    //   339: aload_0
    //   340: aload 9
    //   342: aload 18
    //   344: iload_3
    //   345: invokespecial 321	com/tmsdk/base/utils/HttpGetFile:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;Z)I
    //   348: istore 5
    //   350: iload 5
    //   352: ifeq +6 -> 358
    //   355: goto +155 -> 510
    //   358: aload 4
    //   360: ifnull +131 -> 491
    //   363: new 162	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   370: astore_1
    //   371: aload_1
    //   372: aload_0
    //   373: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   376: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   384: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_1
    //   389: aload_0
    //   390: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   393: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 4
    //   399: aload_1
    //   400: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokeinterface 325 2 0
    //   408: istore_3
    //   409: iload_3
    //   410: ifne +81 -> 491
    //   413: new 162	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   420: astore_1
    //   421: aload_1
    //   422: aload_0
    //   423: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   426: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_1
    //   431: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   434: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_1
    //   439: aload_0
    //   440: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   443: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: new 53	java/io/File
    //   450: dup
    //   451: aload_1
    //   452: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
    //   458: invokevirtual 232	java/io/File:delete	()Z
    //   461: pop
    //   462: sipush -7000
    //   465: istore 5
    //   467: goto +43 -> 510
    //   470: astore_1
    //   471: sipush -7000
    //   474: istore 5
    //   476: goto +865 -> 1341
    //   479: astore_2
    //   480: aload 9
    //   482: astore_1
    //   483: sipush -7000
    //   486: istore 5
    //   488: goto +298 -> 786
    //   491: aload_0
    //   492: iconst_1
    //   493: invokespecial 327	com/tmsdk/base/utils/HttpGetFile:a	(Z)I
    //   496: istore 8
    //   498: iload 8
    //   500: istore 5
    //   502: iload 8
    //   504: ifne -149 -> 355
    //   507: iconst_0
    //   508: istore 5
    //   510: aload 9
    //   512: ifnull +8 -> 520
    //   515: aload 9
    //   517: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   520: iload 5
    //   522: istore 6
    //   524: iload 5
    //   526: ifeq +801 -> 1327
    //   529: iload 5
    //   531: istore 6
    //   533: iload 5
    //   535: bipush 249
    //   537: if_icmpeq +790 -> 1327
    //   540: goto +409 -> 949
    //   543: astore_1
    //   544: goto +15 -> 559
    //   547: astore_2
    //   548: aload 9
    //   550: astore_1
    //   551: goto +235 -> 786
    //   554: astore_1
    //   555: iload 6
    //   557: istore 5
    //   559: goto +782 -> 1341
    //   562: astore_2
    //   563: aload 9
    //   565: astore_1
    //   566: goto +55 -> 621
    //   569: astore_2
    //   570: aload 9
    //   572: astore_1
    //   573: goto +208 -> 781
    //   576: astore_2
    //   577: aload 9
    //   579: astore_1
    //   580: goto +287 -> 867
    //   583: astore_2
    //   584: aload 9
    //   586: astore_1
    //   587: goto +449 -> 1036
    //   590: astore_2
    //   591: aload 9
    //   593: astore_1
    //   594: goto +596 -> 1190
    //   597: astore_2
    //   598: iload 6
    //   600: istore 5
    //   602: aload 12
    //   604: astore_1
    //   605: aload 11
    //   607: astore 10
    //   609: aload_1
    //   610: astore 9
    //   612: aload_2
    //   613: astore_1
    //   614: goto +727 -> 1341
    //   617: astore_2
    //   618: aload 13
    //   620: astore_1
    //   621: aload 10
    //   623: astore 11
    //   625: aload_1
    //   626: astore 12
    //   628: aload_2
    //   629: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   632: astore 4
    //   634: aload 4
    //   636: astore 11
    //   638: aload_1
    //   639: astore 12
    //   641: new 162	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 332
    //   648: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: astore 9
    //   653: aload 4
    //   655: astore 11
    //   657: aload_1
    //   658: astore 12
    //   660: aload 9
    //   662: aload_2
    //   663: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   666: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 4
    //   672: astore 11
    //   674: aload_1
    //   675: astore 12
    //   677: ldc 119
    //   679: aload 9
    //   681: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: aload 4
    //   689: astore 11
    //   691: aload_1
    //   692: astore 12
    //   694: aload_2
    //   695: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   698: aload_1
    //   699: ifnull +7 -> 706
    //   702: aload_1
    //   703: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   706: aload 18
    //   708: ldc_w 334
    //   711: sipush -3000
    //   714: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   717: aload 18
    //   719: ldc_w 336
    //   722: aload 4
    //   724: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload 18
    //   729: ldc_w 341
    //   732: aload_0
    //   733: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   736: l2i
    //   737: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   740: aload 18
    //   742: ldc_w 343
    //   745: aload_0
    //   746: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   749: l2i
    //   750: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   753: aload 18
    //   755: ldc_w 345
    //   758: aload_0
    //   759: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   762: i2b
    //   763: invokevirtual 349	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   766: aload_0
    //   767: iconst_1
    //   768: aload 18
    //   770: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   773: sipush -3000
    //   776: ireturn
    //   777: astore_2
    //   778: aload 14
    //   780: astore_1
    //   781: sipush -3000
    //   784: istore 5
    //   786: iload 5
    //   788: istore 6
    //   790: aload_2
    //   791: invokevirtual 351	btmsdkobf/bm:I	()I
    //   794: istore 5
    //   796: iload 5
    //   798: istore 6
    //   800: aload_2
    //   801: invokevirtual 352	btmsdkobf/bm:getMessage	()Ljava/lang/String;
    //   804: astore_2
    //   805: aload_1
    //   806: ifnull +7 -> 813
    //   809: aload_1
    //   810: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   813: iload 5
    //   815: istore 6
    //   817: iload 5
    //   819: ifeq +508 -> 1327
    //   822: iload 5
    //   824: istore 6
    //   826: iload 5
    //   828: bipush 249
    //   830: if_icmpeq +497 -> 1327
    //   833: aload 18
    //   835: ldc_w 334
    //   838: iload 5
    //   840: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   843: aload 18
    //   845: ldc_w 336
    //   848: aload_2
    //   849: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: goto +117 -> 969
    //   855: astore_2
    //   856: iload 6
    //   858: istore 5
    //   860: goto -251 -> 609
    //   863: astore_2
    //   864: aload 15
    //   866: astore_1
    //   867: aload_2
    //   868: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   871: astore 4
    //   873: aload 4
    //   875: astore 10
    //   877: new 162	java/lang/StringBuilder
    //   880: dup
    //   881: ldc_w 354
    //   884: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   887: astore 9
    //   889: aload 4
    //   891: astore 10
    //   893: aload 9
    //   895: aload_2
    //   896: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   899: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 4
    //   905: astore 10
    //   907: ldc 119
    //   909: aload 9
    //   911: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: aload 4
    //   919: astore 10
    //   921: aload_2
    //   922: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   925: aload 4
    //   927: astore 10
    //   929: iload 7
    //   931: istore 5
    //   933: aload_1
    //   934: ifnull +15 -> 949
    //   937: aload_1
    //   938: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   941: iload 7
    //   943: istore 5
    //   945: aload 4
    //   947: astore 10
    //   949: aload 18
    //   951: ldc_w 334
    //   954: iload 5
    //   956: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   959: aload 18
    //   961: ldc_w 336
    //   964: aload 10
    //   966: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   969: aload 18
    //   971: ldc_w 341
    //   974: aload_0
    //   975: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   978: l2i
    //   979: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   982: aload 18
    //   984: ldc_w 343
    //   987: aload_0
    //   988: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   991: l2i
    //   992: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   995: aload 18
    //   997: ldc_w 345
    //   1000: aload_0
    //   1001: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1004: i2b
    //   1005: invokevirtual 349	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1008: aload_0
    //   1009: iconst_1
    //   1010: aload 18
    //   1012: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1015: iload 5
    //   1017: ireturn
    //   1018: astore_2
    //   1019: aload_1
    //   1020: astore 9
    //   1022: sipush -3056
    //   1025: istore 5
    //   1027: aload_2
    //   1028: astore_1
    //   1029: goto +312 -> 1341
    //   1032: astore_2
    //   1033: aload 16
    //   1035: astore_1
    //   1036: aload_2
    //   1037: invokevirtual 202	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1040: astore 4
    //   1042: aload 4
    //   1044: astore 10
    //   1046: new 162	java/lang/StringBuilder
    //   1049: dup
    //   1050: ldc 201
    //   1052: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1055: astore 9
    //   1057: aload 4
    //   1059: astore 10
    //   1061: aload 9
    //   1063: aload_2
    //   1064: invokevirtual 202	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1067: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 4
    //   1073: astore 10
    //   1075: ldc 119
    //   1077: aload 9
    //   1079: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1085: aload 4
    //   1087: astore 10
    //   1089: aload_2
    //   1090: invokevirtual 203	java/net/SocketTimeoutException:printStackTrace	()V
    //   1093: aload_1
    //   1094: ifnull +7 -> 1101
    //   1097: aload_1
    //   1098: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   1101: aload 18
    //   1103: ldc_w 334
    //   1106: sipush -3055
    //   1109: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1112: aload 18
    //   1114: ldc_w 336
    //   1117: aload 4
    //   1119: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1122: aload 18
    //   1124: ldc_w 341
    //   1127: aload_0
    //   1128: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1131: l2i
    //   1132: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1135: aload 18
    //   1137: ldc_w 343
    //   1140: aload_0
    //   1141: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1144: l2i
    //   1145: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1148: aload 18
    //   1150: ldc_w 345
    //   1153: aload_0
    //   1154: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1157: i2b
    //   1158: invokevirtual 349	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1161: aload_0
    //   1162: iconst_1
    //   1163: aload 18
    //   1165: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1168: sipush -3055
    //   1171: ireturn
    //   1172: astore_2
    //   1173: aload_1
    //   1174: astore 9
    //   1176: sipush -3055
    //   1179: istore 5
    //   1181: aload_2
    //   1182: astore_1
    //   1183: goto +158 -> 1341
    //   1186: astore_2
    //   1187: aload 17
    //   1189: astore_1
    //   1190: aload_2
    //   1191: invokevirtual 206	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1194: astore 4
    //   1196: aload 4
    //   1198: astore 10
    //   1200: new 162	java/lang/StringBuilder
    //   1203: dup
    //   1204: ldc 205
    //   1206: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1209: astore 9
    //   1211: aload 4
    //   1213: astore 10
    //   1215: aload 9
    //   1217: aload_2
    //   1218: invokevirtual 206	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   1221: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload 4
    //   1227: astore 10
    //   1229: ldc 119
    //   1231: aload 9
    //   1233: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1239: aload 4
    //   1241: astore 10
    //   1243: aload_2
    //   1244: invokevirtual 207	java/net/SocketException:printStackTrace	()V
    //   1247: aload_1
    //   1248: ifnull +7 -> 1255
    //   1251: aload_1
    //   1252: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   1255: aload 18
    //   1257: ldc_w 334
    //   1260: sipush -3054
    //   1263: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1266: aload 18
    //   1268: ldc_w 336
    //   1271: aload 4
    //   1273: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1276: aload 18
    //   1278: ldc_w 341
    //   1281: aload_0
    //   1282: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1285: l2i
    //   1286: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1289: aload 18
    //   1291: ldc_w 343
    //   1294: aload_0
    //   1295: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1298: l2i
    //   1299: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1302: aload 18
    //   1304: ldc_w 345
    //   1307: aload_0
    //   1308: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1311: i2b
    //   1312: invokevirtual 349	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1315: aload_0
    //   1316: iconst_1
    //   1317: aload 18
    //   1319: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1322: sipush -3054
    //   1325: istore 6
    //   1327: iload 6
    //   1329: ireturn
    //   1330: astore_2
    //   1331: sipush -3054
    //   1334: istore 5
    //   1336: aload_1
    //   1337: astore 9
    //   1339: aload_2
    //   1340: astore_1
    //   1341: aload 9
    //   1343: ifnull +8 -> 1351
    //   1346: aload 9
    //   1348: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   1351: iload 5
    //   1353: ifeq +76 -> 1429
    //   1356: iload 5
    //   1358: bipush 249
    //   1360: if_icmpeq +69 -> 1429
    //   1363: aload 18
    //   1365: ldc_w 334
    //   1368: iload 5
    //   1370: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1373: aload 18
    //   1375: ldc_w 336
    //   1378: aload 10
    //   1380: invokevirtual 339	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1383: aload 18
    //   1385: ldc_w 341
    //   1388: aload_0
    //   1389: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1392: l2i
    //   1393: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1396: aload 18
    //   1398: ldc_w 343
    //   1401: aload_0
    //   1402: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1405: l2i
    //   1406: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1409: aload 18
    //   1411: ldc_w 345
    //   1414: aload_0
    //   1415: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1418: i2b
    //   1419: invokevirtual 349	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1422: aload_0
    //   1423: iconst_1
    //   1424: aload 18
    //   1426: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1429: aload_1
    //   1430: athrow
    //   1431: sipush -3003
    //   1434: istore 5
    //   1436: goto -926 -> 510
    //   1439: goto -1307 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1442	0	this	HttpGetFile
    //   0	1442	1	paramString1	String
    //   0	1442	2	paramString2	String
    //   0	1442	3	paramBoolean	boolean
    //   0	1442	4	paramDataMd5Cheker	DataMd5Cheker
    //   284	1151	5	i	int
    //   39	1289	6	j	int
    //   16	926	7	k	int
    //   496	7	8	m	int
    //   34	1313	9	localObject1	Object
    //   2	1377	10	localObject2	Object
    //   43	647	11	localObject3	Object
    //   47	646	12	localObject4	Object
    //   19	600	13	localObject5	Object
    //   22	757	14	localObject6	Object
    //   25	840	15	localObject7	Object
    //   28	1006	16	localObject8	Object
    //   31	1157	17	localObject9	Object
    //   11	1414	18	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   413	462	470	finally
    //   413	462	479	btmsdkobf/bm
    //   363	409	543	finally
    //   491	498	543	finally
    //   363	409	547	btmsdkobf/bm
    //   491	498	547	btmsdkobf/bm
    //   86	129	554	finally
    //   132	203	554	finally
    //   203	279	554	finally
    //   279	302	554	finally
    //   329	336	554	finally
    //   339	350	554	finally
    //   86	129	562	java/lang/Exception
    //   132	203	562	java/lang/Exception
    //   203	279	562	java/lang/Exception
    //   279	302	562	java/lang/Exception
    //   329	336	562	java/lang/Exception
    //   339	350	562	java/lang/Exception
    //   363	409	562	java/lang/Exception
    //   413	462	562	java/lang/Exception
    //   491	498	562	java/lang/Exception
    //   86	129	569	btmsdkobf/bm
    //   132	203	569	btmsdkobf/bm
    //   203	279	569	btmsdkobf/bm
    //   279	302	569	btmsdkobf/bm
    //   329	336	569	btmsdkobf/bm
    //   339	350	569	btmsdkobf/bm
    //   86	129	576	java/io/IOException
    //   132	203	576	java/io/IOException
    //   203	279	576	java/io/IOException
    //   279	302	576	java/io/IOException
    //   329	336	576	java/io/IOException
    //   339	350	576	java/io/IOException
    //   363	409	576	java/io/IOException
    //   413	462	576	java/io/IOException
    //   491	498	576	java/io/IOException
    //   86	129	583	java/net/SocketTimeoutException
    //   132	203	583	java/net/SocketTimeoutException
    //   203	279	583	java/net/SocketTimeoutException
    //   279	302	583	java/net/SocketTimeoutException
    //   329	336	583	java/net/SocketTimeoutException
    //   339	350	583	java/net/SocketTimeoutException
    //   363	409	583	java/net/SocketTimeoutException
    //   413	462	583	java/net/SocketTimeoutException
    //   491	498	583	java/net/SocketTimeoutException
    //   86	129	590	java/net/SocketException
    //   132	203	590	java/net/SocketException
    //   203	279	590	java/net/SocketException
    //   279	302	590	java/net/SocketException
    //   329	336	590	java/net/SocketException
    //   339	350	590	java/net/SocketException
    //   363	409	590	java/net/SocketException
    //   413	462	590	java/net/SocketException
    //   491	498	590	java/net/SocketException
    //   49	56	597	finally
    //   70	86	597	finally
    //   628	634	597	finally
    //   641	653	597	finally
    //   660	670	597	finally
    //   677	687	597	finally
    //   694	698	597	finally
    //   49	56	617	java/lang/Exception
    //   70	86	617	java/lang/Exception
    //   49	56	777	btmsdkobf/bm
    //   70	86	777	btmsdkobf/bm
    //   790	796	855	finally
    //   800	805	855	finally
    //   49	56	863	java/io/IOException
    //   70	86	863	java/io/IOException
    //   867	873	1018	finally
    //   877	889	1018	finally
    //   893	903	1018	finally
    //   907	917	1018	finally
    //   921	925	1018	finally
    //   49	56	1032	java/net/SocketTimeoutException
    //   70	86	1032	java/net/SocketTimeoutException
    //   1036	1042	1172	finally
    //   1046	1057	1172	finally
    //   1061	1071	1172	finally
    //   1075	1085	1172	finally
    //   1089	1093	1172	finally
    //   49	56	1186	java/net/SocketException
    //   70	86	1186	java/net/SocketException
    //   1190	1196	1330	finally
    //   1200	1211	1330	finally
    //   1215	1225	1330	finally
    //   1229	1239	1330	finally
    //   1243	1247	1330	finally
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