package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class ez
{
  public static int f = 300000;
  e a = new e();
  int b = 20000;
  int c = 20000;
  int d = 30000;
  int e = 30000;
  private final int g = 2;
  
  private byte[] a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    return a(paramString1, paramString2, paramString3, true, paramFile);
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: new 51	com/tencent/token/utils/k
    //   3: dup
    //   4: invokespecial 52	com/tencent/token/utils/k:<init>	()V
    //   7: astore 40
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 34
    //   18: aconst_null
    //   19: astore 25
    //   21: aconst_null
    //   22: astore 27
    //   24: aconst_null
    //   25: astore 26
    //   27: aconst_null
    //   28: astore 11
    //   30: aconst_null
    //   31: astore 32
    //   33: aconst_null
    //   34: astore 21
    //   36: aconst_null
    //   37: astore 35
    //   39: aconst_null
    //   40: astore 24
    //   42: aconst_null
    //   43: astore 22
    //   45: aconst_null
    //   46: astore 23
    //   48: aconst_null
    //   49: astore 28
    //   51: aconst_null
    //   52: astore 31
    //   54: aconst_null
    //   55: astore 20
    //   57: aload_0
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 55	com/tencent/token/ez:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   63: astore 9
    //   65: aload 9
    //   67: ifnonnull +81 -> 148
    //   70: aconst_null
    //   71: astore_1
    //   72: iconst_0
    //   73: ifeq +11 -> 84
    //   76: new 57	java/lang/NullPointerException
    //   79: dup
    //   80: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   83: athrow
    //   84: iconst_0
    //   85: ifeq +11 -> 96
    //   88: new 57	java/lang/NullPointerException
    //   91: dup
    //   92: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   95: athrow
    //   96: iconst_0
    //   97: ifeq +11 -> 108
    //   100: new 57	java/lang/NullPointerException
    //   103: dup
    //   104: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   107: athrow
    //   108: aload_1
    //   109: astore_2
    //   110: aload 9
    //   112: ifnull +10 -> 122
    //   115: aload 9
    //   117: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   120: aload_1
    //   121: astore_2
    //   122: aload_2
    //   123: areturn
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   129: goto -45 -> 84
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   137: goto -41 -> 96
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   145: goto -37 -> 108
    //   148: aload_3
    //   149: ifnull +3095 -> 3244
    //   152: aload_3
    //   153: invokevirtual 72	java/lang/String:length	()I
    //   156: ifle +3088 -> 3244
    //   159: aconst_null
    //   160: astore 19
    //   162: aload 5
    //   164: ifnull +3074 -> 3238
    //   167: new 74	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   174: ldc 77
    //   176: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_3
    //   180: invokevirtual 85	java/lang/String:getBytes	()[B
    //   183: arraylength
    //   184: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc 90
    //   189: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: invokevirtual 95	java/io/File:length	()J
    //   197: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   206: ldc 109
    //   208: invokevirtual 85	java/lang/String:getBytes	()[B
    //   211: astore 15
    //   213: new 111	java/io/FileInputStream
    //   216: dup
    //   217: aload 5
    //   219: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   222: astore 19
    //   224: aload_3
    //   225: invokevirtual 85	java/lang/String:getBytes	()[B
    //   228: arraylength
    //   229: aload 15
    //   231: arraylength
    //   232: iadd
    //   233: i2l
    //   234: aload 5
    //   236: invokevirtual 95	java/io/File:length	()J
    //   239: ladd
    //   240: ldc 116
    //   242: invokevirtual 85	java/lang/String:getBytes	()[B
    //   245: arraylength
    //   246: i2l
    //   247: ladd
    //   248: lstore 7
    //   250: new 74	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   257: ldc 118
    //   259: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: lload 7
    //   264: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   273: aload 9
    //   275: ldc 120
    //   277: ldc 122
    //   279: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload 9
    //   284: ldc 128
    //   286: lload 7
    //   288: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   291: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload 9
    //   296: iconst_1
    //   297: invokevirtual 136	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   300: new 138	java/io/DataOutputStream
    //   303: dup
    //   304: aload 9
    //   306: invokevirtual 142	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   309: invokespecial 145	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   312: astore 14
    //   314: aload 31
    //   316: astore 13
    //   318: aload 32
    //   320: astore 12
    //   322: aload 14
    //   324: astore 10
    //   326: aload 9
    //   328: astore 11
    //   330: aload 14
    //   332: astore 17
    //   334: aload 14
    //   336: astore 16
    //   338: aload 14
    //   340: astore 18
    //   342: aload 14
    //   344: aload_3
    //   345: invokevirtual 148	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   348: aload 5
    //   350: ifnull +417 -> 767
    //   353: aload 31
    //   355: astore 13
    //   357: aload 32
    //   359: astore 12
    //   361: aload 14
    //   363: astore 10
    //   365: aload 9
    //   367: astore 11
    //   369: aload 14
    //   371: astore 17
    //   373: aload 14
    //   375: astore 16
    //   377: aload 14
    //   379: astore 18
    //   381: sipush 1024
    //   384: newarray byte
    //   386: astore 29
    //   388: aload 31
    //   390: astore 13
    //   392: aload 32
    //   394: astore 12
    //   396: aload 14
    //   398: astore 10
    //   400: aload 9
    //   402: astore 11
    //   404: aload 14
    //   406: astore 17
    //   408: aload 14
    //   410: astore 16
    //   412: aload 14
    //   414: astore 18
    //   416: aload 19
    //   418: aload 29
    //   420: invokevirtual 152	java/io/FileInputStream:read	([B)I
    //   423: istore 6
    //   425: iload 6
    //   427: iconst_m1
    //   428: if_icmpeq +266 -> 694
    //   431: aload 31
    //   433: astore 13
    //   435: aload 32
    //   437: astore 12
    //   439: aload 14
    //   441: astore 10
    //   443: aload 9
    //   445: astore 11
    //   447: aload 14
    //   449: astore 17
    //   451: aload 14
    //   453: astore 16
    //   455: aload 14
    //   457: astore 18
    //   459: aload 14
    //   461: aload 29
    //   463: iconst_0
    //   464: iload 6
    //   466: invokevirtual 156	java/io/DataOutputStream:write	([BII)V
    //   469: goto -81 -> 388
    //   472: astore 5
    //   474: aload 9
    //   476: astore_3
    //   477: aconst_null
    //   478: astore_2
    //   479: aload 14
    //   481: astore 9
    //   483: aload 21
    //   485: astore 10
    //   487: aload 20
    //   489: astore 11
    //   491: aload 5
    //   493: invokevirtual 157	java/net/SocketTimeoutException:printStackTrace	()V
    //   496: aload_0
    //   497: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   500: sipush 10002
    //   503: new 74	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   510: aload 5
    //   512: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   515: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc 160
    //   520: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 5
    //   525: invokevirtual 163	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   528: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   537: invokestatic 171	com/tencent/token/bu:a	()Lcom/tencent/token/bu;
    //   540: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   543: getstatic 18	com/tencent/token/ez:f	I
    //   546: invokevirtual 179	com/tencent/token/bu:a	(JI)V
    //   549: aload 5
    //   551: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   554: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   557: aload 5
    //   559: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   562: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   565: aload 11
    //   567: ifnull +8 -> 575
    //   570: aload 11
    //   572: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   575: aload 10
    //   577: ifnull +8 -> 585
    //   580: aload 10
    //   582: invokevirtual 189	java/io/InputStream:close	()V
    //   585: aload 9
    //   587: ifnull +8 -> 595
    //   590: aload 9
    //   592: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   595: aload_2
    //   596: astore 5
    //   598: aload_3
    //   599: ifnull +10 -> 609
    //   602: aload_3
    //   603: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   606: aload_2
    //   607: astore 5
    //   609: new 74	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   616: ldc 192
    //   618: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 40
    //   623: invokevirtual 194	com/tencent/token/utils/k:a	()J
    //   626: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: ldc 196
    //   631: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_1
    //   635: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 198	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   644: new 74	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   651: ldc 192
    //   653: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 40
    //   658: invokevirtual 194	com/tencent/token/utils/k:a	()J
    //   661: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   664: ldc 196
    //   666: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: astore_2
    //   670: aload_1
    //   671: ldc 200
    //   673: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   676: iconst_m1
    //   677: if_icmpne +2091 -> 2768
    //   680: aload_2
    //   681: aload_1
    //   682: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   691: aload 5
    //   693: areturn
    //   694: aload 31
    //   696: astore 13
    //   698: aload 32
    //   700: astore 12
    //   702: aload 14
    //   704: astore 10
    //   706: aload 9
    //   708: astore 11
    //   710: aload 14
    //   712: astore 17
    //   714: aload 14
    //   716: astore 16
    //   718: aload 14
    //   720: astore 18
    //   722: aload 14
    //   724: ldc 116
    //   726: invokevirtual 85	java/lang/String:getBytes	()[B
    //   729: invokevirtual 207	java/io/DataOutputStream:write	([B)V
    //   732: aload 31
    //   734: astore 13
    //   736: aload 32
    //   738: astore 12
    //   740: aload 14
    //   742: astore 10
    //   744: aload 9
    //   746: astore 11
    //   748: aload 14
    //   750: astore 17
    //   752: aload 14
    //   754: astore 16
    //   756: aload 14
    //   758: astore 18
    //   760: aload 14
    //   762: aload 15
    //   764: invokevirtual 207	java/io/DataOutputStream:write	([B)V
    //   767: aload 31
    //   769: astore 13
    //   771: aload 32
    //   773: astore 12
    //   775: aload 14
    //   777: astore 10
    //   779: aload 9
    //   781: astore 11
    //   783: aload 14
    //   785: astore 17
    //   787: aload 14
    //   789: astore 16
    //   791: aload 14
    //   793: astore 18
    //   795: aload 14
    //   797: invokevirtual 210	java/io/DataOutputStream:flush	()V
    //   800: aload 31
    //   802: astore 13
    //   804: aload 32
    //   806: astore 12
    //   808: aload 14
    //   810: astore 10
    //   812: aload 9
    //   814: astore 11
    //   816: aload 14
    //   818: astore 17
    //   820: aload 14
    //   822: astore 16
    //   824: aload 14
    //   826: astore 18
    //   828: aload 14
    //   830: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   833: aconst_null
    //   834: astore 19
    //   836: aconst_null
    //   837: astore 30
    //   839: aconst_null
    //   840: astore 33
    //   842: aconst_null
    //   843: astore 36
    //   845: aconst_null
    //   846: astore 39
    //   848: aconst_null
    //   849: astore 37
    //   851: aconst_null
    //   852: astore 38
    //   854: aconst_null
    //   855: astore 29
    //   857: aload 31
    //   859: astore 13
    //   861: aload 32
    //   863: astore 12
    //   865: aload 36
    //   867: astore 10
    //   869: aload 9
    //   871: astore 11
    //   873: aload 39
    //   875: astore 17
    //   877: aload 37
    //   879: astore 16
    //   881: aload 38
    //   883: astore 18
    //   885: aload 9
    //   887: invokevirtual 213	java/net/HttpURLConnection:getResponseCode	()I
    //   890: istore 6
    //   892: aload 31
    //   894: astore 13
    //   896: aload 32
    //   898: astore 12
    //   900: aload 36
    //   902: astore 10
    //   904: aload 9
    //   906: astore 11
    //   908: aload 39
    //   910: astore 17
    //   912: aload 37
    //   914: astore 16
    //   916: aload 38
    //   918: astore 18
    //   920: ldc 215
    //   922: new 74	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   929: ldc 217
    //   931: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: iload 6
    //   936: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   939: ldc 219
    //   941: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload_1
    //   945: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 224	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iload 6
    //   956: sipush 200
    //   959: if_icmpeq +17 -> 976
    //   962: iload 6
    //   964: sipush 206
    //   967: if_icmpeq +9 -> 976
    //   970: iload 6
    //   972: iconst_m1
    //   973: if_icmpne +763 -> 1736
    //   976: aload 31
    //   978: astore 13
    //   980: aload 32
    //   982: astore 12
    //   984: aload 36
    //   986: astore 10
    //   988: aload 9
    //   990: astore 11
    //   992: aload 39
    //   994: astore 17
    //   996: aload 37
    //   998: astore 16
    //   1000: aload 38
    //   1002: astore 18
    //   1004: aload 9
    //   1006: invokevirtual 227	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1009: astore 14
    //   1011: aload 14
    //   1013: ifnonnull +425 -> 1438
    //   1016: ldc 229
    //   1018: astore 14
    //   1020: aload 31
    //   1022: astore 13
    //   1024: aload 32
    //   1026: astore 12
    //   1028: aload 36
    //   1030: astore 10
    //   1032: aload 9
    //   1034: astore 11
    //   1036: aload 39
    //   1038: astore 17
    //   1040: aload 37
    //   1042: astore 16
    //   1044: aload 38
    //   1046: astore 18
    //   1048: new 74	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1055: ldc 231
    //   1057: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: aload 14
    //   1062: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: ldc 233
    //   1067: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_2
    //   1071: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: ldc 235
    //   1076: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload_1
    //   1080: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 198	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   1089: aload 31
    //   1091: astore 13
    //   1093: aload 32
    //   1095: astore 12
    //   1097: aload 36
    //   1099: astore 10
    //   1101: aload 9
    //   1103: astore 11
    //   1105: aload 39
    //   1107: astore 17
    //   1109: aload 37
    //   1111: astore 16
    //   1113: aload 38
    //   1115: astore 18
    //   1117: new 74	java/lang/StringBuilder
    //   1120: dup
    //   1121: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1124: ldc 231
    //   1126: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: aload 14
    //   1131: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: ldc 233
    //   1136: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload_2
    //   1140: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: ldc 235
    //   1145: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: astore 34
    //   1150: aload 31
    //   1152: astore 13
    //   1154: aload 32
    //   1156: astore 12
    //   1158: aload 36
    //   1160: astore 10
    //   1162: aload 9
    //   1164: astore 11
    //   1166: aload 39
    //   1168: astore 17
    //   1170: aload 37
    //   1172: astore 16
    //   1174: aload 38
    //   1176: astore 18
    //   1178: aload_1
    //   1179: ldc 200
    //   1181: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1184: iconst_m1
    //   1185: if_icmpne +291 -> 1476
    //   1188: aload_1
    //   1189: astore 15
    //   1191: aload 31
    //   1193: astore 13
    //   1195: aload 32
    //   1197: astore 12
    //   1199: aload 36
    //   1201: astore 10
    //   1203: aload 9
    //   1205: astore 11
    //   1207: aload 39
    //   1209: astore 17
    //   1211: aload 37
    //   1213: astore 16
    //   1215: aload 38
    //   1217: astore 18
    //   1219: aload 34
    //   1221: aload 15
    //   1223: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1232: iload 4
    //   1234: ifeq +310 -> 1544
    //   1237: aload 31
    //   1239: astore 13
    //   1241: aload 32
    //   1243: astore 12
    //   1245: aload 36
    //   1247: astore 10
    //   1249: aload 9
    //   1251: astore 11
    //   1253: aload 39
    //   1255: astore 17
    //   1257: aload 37
    //   1259: astore 16
    //   1261: aload 38
    //   1263: astore 18
    //   1265: aload 14
    //   1267: ldc 237
    //   1269: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1272: iconst_m1
    //   1273: if_icmpne +42 -> 1315
    //   1276: aload 31
    //   1278: astore 13
    //   1280: aload 32
    //   1282: astore 12
    //   1284: aload 36
    //   1286: astore 10
    //   1288: aload 9
    //   1290: astore 11
    //   1292: aload 39
    //   1294: astore 17
    //   1296: aload 37
    //   1298: astore 16
    //   1300: aload 38
    //   1302: astore 18
    //   1304: aload 14
    //   1306: ldc 239
    //   1308: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1311: iconst_m1
    //   1312: if_icmpeq +232 -> 1544
    //   1315: aload 31
    //   1317: astore 13
    //   1319: aload 32
    //   1321: astore 12
    //   1323: aload 36
    //   1325: astore 10
    //   1327: aload 9
    //   1329: astore 11
    //   1331: aload 39
    //   1333: astore 17
    //   1335: aload 37
    //   1337: astore 16
    //   1339: aload 38
    //   1341: astore 18
    //   1343: ldc 241
    //   1345: invokestatic 243	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   1348: aload 31
    //   1350: astore 13
    //   1352: aload 32
    //   1354: astore 12
    //   1356: aload 36
    //   1358: astore 10
    //   1360: aload 9
    //   1362: astore 11
    //   1364: aload 39
    //   1366: astore 17
    //   1368: aload 37
    //   1370: astore 16
    //   1372: aload 38
    //   1374: astore 18
    //   1376: aload_0
    //   1377: aload_1
    //   1378: aload_2
    //   1379: aload_3
    //   1380: aload 5
    //   1382: invokespecial 245	com/tencent/token/ez:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)[B
    //   1385: astore_2
    //   1386: aload_2
    //   1387: astore_1
    //   1388: iconst_0
    //   1389: ifeq +11 -> 1400
    //   1392: new 57	java/lang/NullPointerException
    //   1395: dup
    //   1396: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1399: athrow
    //   1400: iconst_0
    //   1401: ifeq +11 -> 1412
    //   1404: new 57	java/lang/NullPointerException
    //   1407: dup
    //   1408: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1411: athrow
    //   1412: iconst_0
    //   1413: ifeq +11 -> 1424
    //   1416: new 57	java/lang/NullPointerException
    //   1419: dup
    //   1420: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1423: athrow
    //   1424: aload_1
    //   1425: astore_2
    //   1426: aload 9
    //   1428: ifnull -1306 -> 122
    //   1431: aload 9
    //   1433: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1436: aload_1
    //   1437: areturn
    //   1438: aload 31
    //   1440: astore 13
    //   1442: aload 32
    //   1444: astore 12
    //   1446: aload 36
    //   1448: astore 10
    //   1450: aload 9
    //   1452: astore 11
    //   1454: aload 39
    //   1456: astore 17
    //   1458: aload 37
    //   1460: astore 16
    //   1462: aload 38
    //   1464: astore 18
    //   1466: aload 14
    //   1468: invokevirtual 248	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1471: astore 14
    //   1473: goto -453 -> 1020
    //   1476: aload 31
    //   1478: astore 13
    //   1480: aload 32
    //   1482: astore 12
    //   1484: aload 36
    //   1486: astore 10
    //   1488: aload 9
    //   1490: astore 11
    //   1492: aload 39
    //   1494: astore 17
    //   1496: aload 37
    //   1498: astore 16
    //   1500: aload 38
    //   1502: astore 18
    //   1504: aload_1
    //   1505: iconst_0
    //   1506: aload_1
    //   1507: ldc 200
    //   1509: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1512: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   1515: astore 15
    //   1517: goto -326 -> 1191
    //   1520: astore_2
    //   1521: aload_2
    //   1522: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1525: goto -125 -> 1400
    //   1528: astore_2
    //   1529: aload_2
    //   1530: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1533: goto -121 -> 1412
    //   1536: astore_2
    //   1537: aload_2
    //   1538: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1541: goto -117 -> 1424
    //   1544: aload 31
    //   1546: astore 13
    //   1548: aload 32
    //   1550: astore 12
    //   1552: aload 36
    //   1554: astore 10
    //   1556: aload 9
    //   1558: astore 11
    //   1560: aload 39
    //   1562: astore 17
    //   1564: aload 37
    //   1566: astore 16
    //   1568: aload 38
    //   1570: astore 18
    //   1572: aload 9
    //   1574: invokevirtual 256	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1577: astore_2
    //   1578: new 183	java/io/ByteArrayOutputStream
    //   1581: dup
    //   1582: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
    //   1585: astore_3
    //   1586: aload_2
    //   1587: invokevirtual 259	java/io/InputStream:read	()I
    //   1590: istore 6
    //   1592: iload 6
    //   1594: iconst_m1
    //   1595: if_icmpeq +12 -> 1607
    //   1598: aload_3
    //   1599: iload 6
    //   1601: invokevirtual 262	java/io/ByteArrayOutputStream:write	(I)V
    //   1604: goto -18 -> 1586
    //   1607: aload_3
    //   1608: invokevirtual 263	java/io/ByteArrayOutputStream:flush	()V
    //   1611: aload_3
    //   1612: invokevirtual 266	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1615: astore 5
    //   1617: aload 5
    //   1619: ifnull +9 -> 1628
    //   1622: aload 5
    //   1624: arraylength
    //   1625: ifgt +73 -> 1698
    //   1628: aload_0
    //   1629: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1632: ldc_w 267
    //   1635: invokevirtual 269	com/tencent/token/global/e:b	(I)V
    //   1638: aconst_null
    //   1639: astore 5
    //   1641: aload_3
    //   1642: astore 10
    //   1644: aload_2
    //   1645: astore_3
    //   1646: aload 5
    //   1648: astore_2
    //   1649: aload 10
    //   1651: ifnull +8 -> 1659
    //   1654: aload 10
    //   1656: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1659: aload_3
    //   1660: ifnull +7 -> 1667
    //   1663: aload_3
    //   1664: invokevirtual 189	java/io/InputStream:close	()V
    //   1667: iconst_0
    //   1668: ifeq +11 -> 1679
    //   1671: new 57	java/lang/NullPointerException
    //   1674: dup
    //   1675: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1678: athrow
    //   1679: aload_2
    //   1680: astore 5
    //   1682: aload 9
    //   1684: ifnull -1075 -> 609
    //   1687: aload 9
    //   1689: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1692: aload_2
    //   1693: astore 5
    //   1695: goto -1086 -> 609
    //   1698: aload_0
    //   1699: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1702: invokevirtual 271	com/tencent/token/global/e:c	()V
    //   1705: goto -64 -> 1641
    //   1708: astore 13
    //   1710: aload_3
    //   1711: astore 11
    //   1713: aload_2
    //   1714: astore 10
    //   1716: aconst_null
    //   1717: astore 12
    //   1719: aload 9
    //   1721: astore_3
    //   1722: aload 5
    //   1724: astore_2
    //   1725: aload 13
    //   1727: astore 5
    //   1729: aload 12
    //   1731: astore 9
    //   1733: goto -1242 -> 491
    //   1736: aload 31
    //   1738: astore 13
    //   1740: aload 32
    //   1742: astore 12
    //   1744: aload 36
    //   1746: astore 10
    //   1748: aload 9
    //   1750: astore 11
    //   1752: aload 39
    //   1754: astore 17
    //   1756: aload 37
    //   1758: astore 16
    //   1760: aload 38
    //   1762: astore 18
    //   1764: aload_0
    //   1765: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1768: sipush 10005
    //   1771: new 74	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1778: ldc_w 273
    //   1781: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: iload 6
    //   1786: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1789: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1792: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1795: aload 31
    //   1797: astore 13
    //   1799: aload 32
    //   1801: astore 12
    //   1803: aload 36
    //   1805: astore 10
    //   1807: aload 9
    //   1809: astore 11
    //   1811: aload 39
    //   1813: astore 17
    //   1815: aload 37
    //   1817: astore 16
    //   1819: aload 38
    //   1821: astore 18
    //   1823: new 74	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1830: ldc_w 275
    //   1833: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: aload_1
    //   1837: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: ldc_w 277
    //   1843: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: iload 6
    //   1848: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1851: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1854: invokestatic 243	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   1857: aload 31
    //   1859: astore 13
    //   1861: aload 32
    //   1863: astore 12
    //   1865: aload 36
    //   1867: astore 10
    //   1869: aload 9
    //   1871: astore 11
    //   1873: aload 39
    //   1875: astore 17
    //   1877: aload 37
    //   1879: astore 16
    //   1881: aload 38
    //   1883: astore 18
    //   1885: new 74	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1892: ldc_w 279
    //   1895: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: astore_3
    //   1899: aload 31
    //   1901: astore 13
    //   1903: aload 32
    //   1905: astore 12
    //   1907: aload 36
    //   1909: astore 10
    //   1911: aload 9
    //   1913: astore 11
    //   1915: aload 39
    //   1917: astore 17
    //   1919: aload 37
    //   1921: astore 16
    //   1923: aload 38
    //   1925: astore 18
    //   1927: aload_1
    //   1928: ldc 200
    //   1930: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1933: iconst_m1
    //   1934: if_icmpne +67 -> 2001
    //   1937: aload_1
    //   1938: astore_2
    //   1939: aload 31
    //   1941: astore 13
    //   1943: aload 32
    //   1945: astore 12
    //   1947: aload 36
    //   1949: astore 10
    //   1951: aload 9
    //   1953: astore 11
    //   1955: aload 39
    //   1957: astore 17
    //   1959: aload 37
    //   1961: astore 16
    //   1963: aload 38
    //   1965: astore 18
    //   1967: aload_3
    //   1968: aload_2
    //   1969: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: ldc_w 277
    //   1975: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: iload 6
    //   1980: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1983: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1986: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1989: aconst_null
    //   1990: astore_2
    //   1991: aload 35
    //   1993: astore 10
    //   1995: aload 34
    //   1997: astore_3
    //   1998: goto -349 -> 1649
    //   2001: aload 31
    //   2003: astore 13
    //   2005: aload 32
    //   2007: astore 12
    //   2009: aload 36
    //   2011: astore 10
    //   2013: aload 9
    //   2015: astore 11
    //   2017: aload 39
    //   2019: astore 17
    //   2021: aload 37
    //   2023: astore 16
    //   2025: aload 38
    //   2027: astore 18
    //   2029: aload_1
    //   2030: iconst_0
    //   2031: aload_1
    //   2032: ldc 200
    //   2034: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2037: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   2040: astore_2
    //   2041: goto -102 -> 1939
    //   2044: astore 5
    //   2046: aload 5
    //   2048: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2051: goto -392 -> 1659
    //   2054: astore_3
    //   2055: aload_3
    //   2056: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2059: goto -392 -> 1667
    //   2062: astore_3
    //   2063: aload_3
    //   2064: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2067: goto -388 -> 1679
    //   2070: astore 5
    //   2072: aload 5
    //   2074: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2077: goto -1502 -> 575
    //   2080: astore 5
    //   2082: aload 5
    //   2084: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2087: goto -1502 -> 585
    //   2090: astore 5
    //   2092: aload 5
    //   2094: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2097: goto -1502 -> 595
    //   2100: astore_3
    //   2101: aconst_null
    //   2102: astore 9
    //   2104: aconst_null
    //   2105: astore 14
    //   2107: aconst_null
    //   2108: astore_2
    //   2109: aload 25
    //   2111: astore 5
    //   2113: aload 24
    //   2115: astore 15
    //   2117: aload 15
    //   2119: astore 13
    //   2121: aload 5
    //   2123: astore 12
    //   2125: aload 14
    //   2127: astore 10
    //   2129: aload 9
    //   2131: astore 11
    //   2133: aload_3
    //   2134: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   2137: aload 15
    //   2139: astore 13
    //   2141: aload 5
    //   2143: astore 12
    //   2145: aload 14
    //   2147: astore 10
    //   2149: aload 9
    //   2151: astore 11
    //   2153: aload_0
    //   2154: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   2157: sipush 10003
    //   2160: new 74	java/lang/StringBuilder
    //   2163: dup
    //   2164: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2167: aload_3
    //   2168: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   2171: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: ldc 160
    //   2176: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: aload_3
    //   2180: invokevirtual 282	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2183: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2189: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2192: aload 15
    //   2194: astore 13
    //   2196: aload 5
    //   2198: astore 12
    //   2200: aload 14
    //   2202: astore 10
    //   2204: aload 9
    //   2206: astore 11
    //   2208: aload_3
    //   2209: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   2212: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   2215: aload 15
    //   2217: astore 13
    //   2219: aload 5
    //   2221: astore 12
    //   2223: aload 14
    //   2225: astore 10
    //   2227: aload 9
    //   2229: astore 11
    //   2231: aload_3
    //   2232: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   2235: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2238: aload 15
    //   2240: ifnull +8 -> 2248
    //   2243: aload 15
    //   2245: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2248: aload 5
    //   2250: ifnull +8 -> 2258
    //   2253: aload 5
    //   2255: invokevirtual 189	java/io/InputStream:close	()V
    //   2258: aload 14
    //   2260: ifnull +8 -> 2268
    //   2263: aload 14
    //   2265: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2268: aload_2
    //   2269: astore 5
    //   2271: aload 9
    //   2273: ifnull -1664 -> 609
    //   2276: aload 9
    //   2278: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2281: aload_2
    //   2282: astore 5
    //   2284: goto -1675 -> 609
    //   2287: astore_3
    //   2288: aload_3
    //   2289: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2292: goto -44 -> 2248
    //   2295: astore_3
    //   2296: aload_3
    //   2297: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2300: goto -42 -> 2258
    //   2303: astore_3
    //   2304: aload_3
    //   2305: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2308: goto -40 -> 2268
    //   2311: astore_3
    //   2312: aconst_null
    //   2313: astore 9
    //   2315: aconst_null
    //   2316: astore 14
    //   2318: aconst_null
    //   2319: astore_2
    //   2320: aload 27
    //   2322: astore 5
    //   2324: aload 22
    //   2326: astore 15
    //   2328: aload 15
    //   2330: astore 13
    //   2332: aload 5
    //   2334: astore 12
    //   2336: aload 14
    //   2338: astore 10
    //   2340: aload 9
    //   2342: astore 11
    //   2344: aload_3
    //   2345: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2348: aload 15
    //   2350: astore 13
    //   2352: aload 5
    //   2354: astore 12
    //   2356: aload 14
    //   2358: astore 10
    //   2360: aload 9
    //   2362: astore 11
    //   2364: aload_0
    //   2365: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   2368: sipush 10003
    //   2371: new 74	java/lang/StringBuilder
    //   2374: dup
    //   2375: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2378: aload_3
    //   2379: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   2382: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2385: ldc 160
    //   2387: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2390: aload_3
    //   2391: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2394: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2400: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2403: aload 15
    //   2405: astore 13
    //   2407: aload 5
    //   2409: astore 12
    //   2411: aload 14
    //   2413: astore 10
    //   2415: aload 9
    //   2417: astore 11
    //   2419: aload_3
    //   2420: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   2423: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   2426: aload 15
    //   2428: astore 13
    //   2430: aload 5
    //   2432: astore 12
    //   2434: aload 14
    //   2436: astore 10
    //   2438: aload 9
    //   2440: astore 11
    //   2442: aload_3
    //   2443: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   2446: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2449: aload 15
    //   2451: ifnull +8 -> 2459
    //   2454: aload 15
    //   2456: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2459: aload 5
    //   2461: ifnull +8 -> 2469
    //   2464: aload 5
    //   2466: invokevirtual 189	java/io/InputStream:close	()V
    //   2469: aload 14
    //   2471: ifnull +8 -> 2479
    //   2474: aload 14
    //   2476: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2479: aload_2
    //   2480: astore 5
    //   2482: aload 9
    //   2484: ifnull -1875 -> 609
    //   2487: aload 9
    //   2489: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2492: aload_2
    //   2493: astore 5
    //   2495: goto -1886 -> 609
    //   2498: astore_3
    //   2499: aload_3
    //   2500: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2503: goto -44 -> 2459
    //   2506: astore_3
    //   2507: aload_3
    //   2508: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2511: goto -42 -> 2469
    //   2514: astore_3
    //   2515: aload_3
    //   2516: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2519: goto -40 -> 2479
    //   2522: astore_3
    //   2523: aconst_null
    //   2524: astore 9
    //   2526: aconst_null
    //   2527: astore 14
    //   2529: aconst_null
    //   2530: astore_2
    //   2531: aload 26
    //   2533: astore 5
    //   2535: aload 23
    //   2537: astore 15
    //   2539: aload 15
    //   2541: astore 13
    //   2543: aload 5
    //   2545: astore 12
    //   2547: aload 14
    //   2549: astore 10
    //   2551: aload 9
    //   2553: astore 11
    //   2555: aload_3
    //   2556: invokevirtual 285	java/lang/Throwable:printStackTrace	()V
    //   2559: aload 15
    //   2561: astore 13
    //   2563: aload 5
    //   2565: astore 12
    //   2567: aload 14
    //   2569: astore 10
    //   2571: aload 9
    //   2573: astore 11
    //   2575: aload_0
    //   2576: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   2579: sipush 10003
    //   2582: new 74	java/lang/StringBuilder
    //   2585: dup
    //   2586: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2589: aload_3
    //   2590: invokevirtual 286	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2593: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: ldc 160
    //   2598: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: aload_3
    //   2602: invokevirtual 287	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2605: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2611: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2614: aload 15
    //   2616: ifnull +8 -> 2624
    //   2619: aload 15
    //   2621: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2624: aload 5
    //   2626: ifnull +8 -> 2634
    //   2629: aload 5
    //   2631: invokevirtual 189	java/io/InputStream:close	()V
    //   2634: aload 14
    //   2636: ifnull +8 -> 2644
    //   2639: aload 14
    //   2641: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2644: aload_2
    //   2645: astore 5
    //   2647: aload 9
    //   2649: ifnull -2040 -> 609
    //   2652: aload 9
    //   2654: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2657: aload_2
    //   2658: astore 5
    //   2660: goto -2051 -> 609
    //   2663: astore_3
    //   2664: aload_3
    //   2665: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2668: goto -44 -> 2624
    //   2671: astore_3
    //   2672: aload_3
    //   2673: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2676: goto -42 -> 2634
    //   2679: astore_3
    //   2680: aload_3
    //   2681: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2684: goto -40 -> 2644
    //   2687: astore_1
    //   2688: aconst_null
    //   2689: astore 9
    //   2691: aconst_null
    //   2692: astore 10
    //   2694: aload 11
    //   2696: astore 12
    //   2698: aload 28
    //   2700: astore 13
    //   2702: aload 13
    //   2704: ifnull +8 -> 2712
    //   2707: aload 13
    //   2709: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2712: aload 12
    //   2714: ifnull +8 -> 2722
    //   2717: aload 12
    //   2719: invokevirtual 189	java/io/InputStream:close	()V
    //   2722: aload 10
    //   2724: ifnull +8 -> 2732
    //   2727: aload 10
    //   2729: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2732: aload 9
    //   2734: ifnull +8 -> 2742
    //   2737: aload 9
    //   2739: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2742: aload_1
    //   2743: athrow
    //   2744: astore_2
    //   2745: aload_2
    //   2746: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2749: goto -37 -> 2712
    //   2752: astore_2
    //   2753: aload_2
    //   2754: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2757: goto -35 -> 2722
    //   2760: astore_2
    //   2761: aload_2
    //   2762: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2765: goto -33 -> 2732
    //   2768: aload_1
    //   2769: iconst_0
    //   2770: aload_1
    //   2771: ldc 200
    //   2773: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2776: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   2779: astore_1
    //   2780: goto -2100 -> 680
    //   2783: astore_1
    //   2784: aconst_null
    //   2785: astore 10
    //   2787: aload 28
    //   2789: astore 13
    //   2791: aload 11
    //   2793: astore 12
    //   2795: goto -93 -> 2702
    //   2798: astore_1
    //   2799: aload 11
    //   2801: astore 9
    //   2803: goto -101 -> 2702
    //   2806: astore_1
    //   2807: aload 28
    //   2809: astore 13
    //   2811: aload_2
    //   2812: astore 12
    //   2814: aload 33
    //   2816: astore 10
    //   2818: goto -116 -> 2702
    //   2821: astore_1
    //   2822: aload_3
    //   2823: astore 13
    //   2825: aload_2
    //   2826: astore 12
    //   2828: aload 33
    //   2830: astore 10
    //   2832: goto -130 -> 2702
    //   2835: astore_1
    //   2836: aload 11
    //   2838: astore 13
    //   2840: aload 10
    //   2842: astore 12
    //   2844: aload 9
    //   2846: astore 10
    //   2848: aload_3
    //   2849: astore 9
    //   2851: goto -149 -> 2702
    //   2854: astore_3
    //   2855: aconst_null
    //   2856: astore 14
    //   2858: aconst_null
    //   2859: astore_2
    //   2860: aload 23
    //   2862: astore 15
    //   2864: aload 26
    //   2866: astore 5
    //   2868: goto -329 -> 2539
    //   2871: astore_3
    //   2872: aconst_null
    //   2873: astore_2
    //   2874: aload 23
    //   2876: astore 15
    //   2878: aload 26
    //   2880: astore 5
    //   2882: aload 17
    //   2884: astore 14
    //   2886: goto -347 -> 2539
    //   2889: astore_3
    //   2890: aload_2
    //   2891: astore 5
    //   2893: aconst_null
    //   2894: astore_2
    //   2895: aload 23
    //   2897: astore 15
    //   2899: aload 30
    //   2901: astore 14
    //   2903: goto -364 -> 2539
    //   2906: astore 10
    //   2908: aload_3
    //   2909: astore 15
    //   2911: aload_2
    //   2912: astore 5
    //   2914: aconst_null
    //   2915: astore_2
    //   2916: aload 10
    //   2918: astore_3
    //   2919: aload 30
    //   2921: astore 14
    //   2923: goto -384 -> 2539
    //   2926: astore 11
    //   2928: aload_3
    //   2929: astore 15
    //   2931: aload_2
    //   2932: astore 10
    //   2934: aload 5
    //   2936: astore_2
    //   2937: aload 11
    //   2939: astore_3
    //   2940: aload 10
    //   2942: astore 5
    //   2944: aload 30
    //   2946: astore 14
    //   2948: goto -409 -> 2539
    //   2951: astore_3
    //   2952: aconst_null
    //   2953: astore 14
    //   2955: aconst_null
    //   2956: astore_2
    //   2957: aload 22
    //   2959: astore 15
    //   2961: aload 27
    //   2963: astore 5
    //   2965: goto -637 -> 2328
    //   2968: astore_3
    //   2969: aconst_null
    //   2970: astore_2
    //   2971: aload 22
    //   2973: astore 15
    //   2975: aload 27
    //   2977: astore 5
    //   2979: aload 16
    //   2981: astore 14
    //   2983: goto -655 -> 2328
    //   2986: astore_3
    //   2987: aload_2
    //   2988: astore 5
    //   2990: aconst_null
    //   2991: astore_2
    //   2992: aload 22
    //   2994: astore 15
    //   2996: aload 19
    //   2998: astore 14
    //   3000: goto -672 -> 2328
    //   3003: astore 10
    //   3005: aload_3
    //   3006: astore 15
    //   3008: aload_2
    //   3009: astore 5
    //   3011: aconst_null
    //   3012: astore_2
    //   3013: aload 10
    //   3015: astore_3
    //   3016: aload 19
    //   3018: astore 14
    //   3020: goto -692 -> 2328
    //   3023: astore 11
    //   3025: aload_3
    //   3026: astore 15
    //   3028: aload_2
    //   3029: astore 10
    //   3031: aload 5
    //   3033: astore_2
    //   3034: aload 11
    //   3036: astore_3
    //   3037: aload 10
    //   3039: astore 5
    //   3041: aload 19
    //   3043: astore 14
    //   3045: goto -717 -> 2328
    //   3048: astore_3
    //   3049: aconst_null
    //   3050: astore 14
    //   3052: aconst_null
    //   3053: astore_2
    //   3054: aload 24
    //   3056: astore 15
    //   3058: aload 25
    //   3060: astore 5
    //   3062: goto -945 -> 2117
    //   3065: astore_3
    //   3066: aconst_null
    //   3067: astore_2
    //   3068: aload 24
    //   3070: astore 15
    //   3072: aload 25
    //   3074: astore 5
    //   3076: aload 18
    //   3078: astore 14
    //   3080: goto -963 -> 2117
    //   3083: astore_3
    //   3084: aload_2
    //   3085: astore 5
    //   3087: aconst_null
    //   3088: astore_2
    //   3089: aload 24
    //   3091: astore 15
    //   3093: aload 29
    //   3095: astore 14
    //   3097: goto -980 -> 2117
    //   3100: astore 10
    //   3102: aload_3
    //   3103: astore 15
    //   3105: aload_2
    //   3106: astore 5
    //   3108: aconst_null
    //   3109: astore_2
    //   3110: aload 10
    //   3112: astore_3
    //   3113: aload 29
    //   3115: astore 14
    //   3117: goto -1000 -> 2117
    //   3120: astore 11
    //   3122: aload_3
    //   3123: astore 15
    //   3125: aload_2
    //   3126: astore 10
    //   3128: aload 5
    //   3130: astore_2
    //   3131: aload 11
    //   3133: astore_3
    //   3134: aload 10
    //   3136: astore 5
    //   3138: aload 29
    //   3140: astore 14
    //   3142: goto -1025 -> 2117
    //   3145: astore 5
    //   3147: aconst_null
    //   3148: astore_2
    //   3149: aload 20
    //   3151: astore 11
    //   3153: aload 21
    //   3155: astore 10
    //   3157: aload 12
    //   3159: astore 9
    //   3161: aload 13
    //   3163: astore_3
    //   3164: goto -2673 -> 491
    //   3167: astore 5
    //   3169: aload 9
    //   3171: astore_3
    //   3172: aconst_null
    //   3173: astore_2
    //   3174: aload 20
    //   3176: astore 11
    //   3178: aload 21
    //   3180: astore 10
    //   3182: aload 12
    //   3184: astore 9
    //   3186: goto -2695 -> 491
    //   3189: astore 5
    //   3191: aconst_null
    //   3192: astore 12
    //   3194: aload 9
    //   3196: astore_3
    //   3197: aconst_null
    //   3198: astore_2
    //   3199: aload 20
    //   3201: astore 11
    //   3203: aload 21
    //   3205: astore 10
    //   3207: aload 12
    //   3209: astore 9
    //   3211: goto -2720 -> 491
    //   3214: astore 5
    //   3216: aload_2
    //   3217: astore 10
    //   3219: aconst_null
    //   3220: astore 12
    //   3222: aload 9
    //   3224: astore_3
    //   3225: aconst_null
    //   3226: astore_2
    //   3227: aload 20
    //   3229: astore 11
    //   3231: aload 12
    //   3233: astore 9
    //   3235: goto -2744 -> 491
    //   3238: aconst_null
    //   3239: astore 15
    //   3241: goto -2947 -> 294
    //   3244: goto -2411 -> 833
    //   3247: astore 5
    //   3249: aload_3
    //   3250: astore 11
    //   3252: aload_2
    //   3253: astore 10
    //   3255: aconst_null
    //   3256: astore 12
    //   3258: aload 9
    //   3260: astore_3
    //   3261: aconst_null
    //   3262: astore_2
    //   3263: aload 12
    //   3265: astore 9
    //   3267: goto -2776 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3270	0	this	ez
    //   0	3270	1	paramString1	String
    //   0	3270	2	paramString2	String
    //   0	3270	3	paramString3	String
    //   0	3270	4	paramBoolean	boolean
    //   0	3270	5	paramFile	File
    //   423	1556	6	i	int
    //   248	39	7	l	long
    //   63	3203	9	localObject1	Object
    //   324	2523	10	localObject2	Object
    //   2906	11	10	localThrowable1	java.lang.Throwable
    //   2932	9	10	str1	String
    //   3003	11	10	localException1	Exception
    //   3029	9	10	str2	String
    //   3100	11	10	localIOException1	IOException
    //   3126	128	10	localObject3	Object
    //   28	2809	11	localObject4	Object
    //   2926	12	11	localThrowable2	java.lang.Throwable
    //   3023	12	11	localException2	Exception
    //   3120	12	11	localIOException2	IOException
    //   3151	100	11	localObject5	Object
    //   13	3251	12	localObject6	Object
    //   10	1537	13	localObject7	Object
    //   1708	18	13	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1738	1424	13	localObject8	Object
    //   312	2829	14	localObject9	Object
    //   211	3029	15	localObject10	Object
    //   336	2644	16	localObject11	Object
    //   332	2551	17	localObject12	Object
    //   340	2737	18	localObject13	Object
    //   160	2882	19	localFileInputStream	java.io.FileInputStream
    //   55	3173	20	localObject14	Object
    //   34	3170	21	localObject15	Object
    //   43	2950	22	localObject16	Object
    //   46	2850	23	localObject17	Object
    //   40	3050	24	localObject18	Object
    //   19	3054	25	localObject19	Object
    //   25	2854	26	localObject20	Object
    //   22	2954	27	localObject21	Object
    //   49	2759	28	localObject22	Object
    //   386	2753	29	arrayOfByte	byte[]
    //   837	2108	30	localObject23	Object
    //   52	1950	31	localObject24	Object
    //   31	1975	32	localObject25	Object
    //   840	1989	33	localObject26	Object
    //   16	1980	34	localStringBuilder	java.lang.StringBuilder
    //   37	1955	35	localObject27	Object
    //   843	1167	36	localObject28	Object
    //   849	1173	37	localObject29	Object
    //   852	1174	38	localObject30	Object
    //   846	1172	39	localObject31	Object
    //   7	650	40	localk	com.tencent.token.utils.k
    // Exception table:
    //   from	to	target	type
    //   76	84	124	java/lang/Exception
    //   88	96	132	java/lang/Exception
    //   100	108	140	java/lang/Exception
    //   342	348	472	java/net/SocketTimeoutException
    //   381	388	472	java/net/SocketTimeoutException
    //   416	425	472	java/net/SocketTimeoutException
    //   459	469	472	java/net/SocketTimeoutException
    //   722	732	472	java/net/SocketTimeoutException
    //   760	767	472	java/net/SocketTimeoutException
    //   795	800	472	java/net/SocketTimeoutException
    //   828	833	472	java/net/SocketTimeoutException
    //   1392	1400	1520	java/lang/Exception
    //   1404	1412	1528	java/lang/Exception
    //   1416	1424	1536	java/lang/Exception
    //   1622	1628	1708	java/net/SocketTimeoutException
    //   1628	1638	1708	java/net/SocketTimeoutException
    //   1698	1705	1708	java/net/SocketTimeoutException
    //   1654	1659	2044	java/lang/Exception
    //   1663	1667	2054	java/lang/Exception
    //   1671	1679	2062	java/lang/Exception
    //   570	575	2070	java/lang/Exception
    //   580	585	2080	java/lang/Exception
    //   590	595	2090	java/lang/Exception
    //   57	65	2100	java/io/IOException
    //   2243	2248	2287	java/lang/Exception
    //   2253	2258	2295	java/lang/Exception
    //   2263	2268	2303	java/lang/Exception
    //   57	65	2311	java/lang/Exception
    //   2454	2459	2498	java/lang/Exception
    //   2464	2469	2506	java/lang/Exception
    //   2474	2479	2514	java/lang/Exception
    //   57	65	2522	java/lang/Throwable
    //   2619	2624	2663	java/lang/Exception
    //   2629	2634	2671	java/lang/Exception
    //   2639	2644	2679	java/lang/Exception
    //   57	65	2687	finally
    //   2707	2712	2744	java/lang/Exception
    //   2717	2722	2752	java/lang/Exception
    //   2727	2732	2760	java/lang/Exception
    //   152	159	2783	finally
    //   167	294	2783	finally
    //   294	314	2783	finally
    //   342	348	2798	finally
    //   381	388	2798	finally
    //   416	425	2798	finally
    //   459	469	2798	finally
    //   722	732	2798	finally
    //   760	767	2798	finally
    //   795	800	2798	finally
    //   828	833	2798	finally
    //   885	892	2798	finally
    //   920	954	2798	finally
    //   1004	1011	2798	finally
    //   1048	1089	2798	finally
    //   1117	1150	2798	finally
    //   1178	1188	2798	finally
    //   1219	1232	2798	finally
    //   1265	1276	2798	finally
    //   1304	1315	2798	finally
    //   1343	1348	2798	finally
    //   1376	1386	2798	finally
    //   1466	1473	2798	finally
    //   1504	1517	2798	finally
    //   1572	1578	2798	finally
    //   1764	1795	2798	finally
    //   1823	1857	2798	finally
    //   1885	1899	2798	finally
    //   1927	1937	2798	finally
    //   1967	1989	2798	finally
    //   2029	2041	2798	finally
    //   2133	2137	2798	finally
    //   2153	2192	2798	finally
    //   2208	2215	2798	finally
    //   2231	2238	2798	finally
    //   2344	2348	2798	finally
    //   2364	2403	2798	finally
    //   2419	2426	2798	finally
    //   2442	2449	2798	finally
    //   2555	2559	2798	finally
    //   2575	2614	2798	finally
    //   1578	1586	2806	finally
    //   1586	1592	2821	finally
    //   1598	1604	2821	finally
    //   1607	1617	2821	finally
    //   1622	1628	2821	finally
    //   1628	1638	2821	finally
    //   1698	1705	2821	finally
    //   491	565	2835	finally
    //   152	159	2854	java/lang/Throwable
    //   167	294	2854	java/lang/Throwable
    //   294	314	2854	java/lang/Throwable
    //   342	348	2871	java/lang/Throwable
    //   381	388	2871	java/lang/Throwable
    //   416	425	2871	java/lang/Throwable
    //   459	469	2871	java/lang/Throwable
    //   722	732	2871	java/lang/Throwable
    //   760	767	2871	java/lang/Throwable
    //   795	800	2871	java/lang/Throwable
    //   828	833	2871	java/lang/Throwable
    //   885	892	2871	java/lang/Throwable
    //   920	954	2871	java/lang/Throwable
    //   1004	1011	2871	java/lang/Throwable
    //   1048	1089	2871	java/lang/Throwable
    //   1117	1150	2871	java/lang/Throwable
    //   1178	1188	2871	java/lang/Throwable
    //   1219	1232	2871	java/lang/Throwable
    //   1265	1276	2871	java/lang/Throwable
    //   1304	1315	2871	java/lang/Throwable
    //   1343	1348	2871	java/lang/Throwable
    //   1376	1386	2871	java/lang/Throwable
    //   1466	1473	2871	java/lang/Throwable
    //   1504	1517	2871	java/lang/Throwable
    //   1572	1578	2871	java/lang/Throwable
    //   1764	1795	2871	java/lang/Throwable
    //   1823	1857	2871	java/lang/Throwable
    //   1885	1899	2871	java/lang/Throwable
    //   1927	1937	2871	java/lang/Throwable
    //   1967	1989	2871	java/lang/Throwable
    //   2029	2041	2871	java/lang/Throwable
    //   1578	1586	2889	java/lang/Throwable
    //   1586	1592	2906	java/lang/Throwable
    //   1598	1604	2906	java/lang/Throwable
    //   1607	1617	2906	java/lang/Throwable
    //   1622	1628	2926	java/lang/Throwable
    //   1628	1638	2926	java/lang/Throwable
    //   1698	1705	2926	java/lang/Throwable
    //   152	159	2951	java/lang/Exception
    //   167	294	2951	java/lang/Exception
    //   294	314	2951	java/lang/Exception
    //   342	348	2968	java/lang/Exception
    //   381	388	2968	java/lang/Exception
    //   416	425	2968	java/lang/Exception
    //   459	469	2968	java/lang/Exception
    //   722	732	2968	java/lang/Exception
    //   760	767	2968	java/lang/Exception
    //   795	800	2968	java/lang/Exception
    //   828	833	2968	java/lang/Exception
    //   885	892	2968	java/lang/Exception
    //   920	954	2968	java/lang/Exception
    //   1004	1011	2968	java/lang/Exception
    //   1048	1089	2968	java/lang/Exception
    //   1117	1150	2968	java/lang/Exception
    //   1178	1188	2968	java/lang/Exception
    //   1219	1232	2968	java/lang/Exception
    //   1265	1276	2968	java/lang/Exception
    //   1304	1315	2968	java/lang/Exception
    //   1343	1348	2968	java/lang/Exception
    //   1376	1386	2968	java/lang/Exception
    //   1466	1473	2968	java/lang/Exception
    //   1504	1517	2968	java/lang/Exception
    //   1572	1578	2968	java/lang/Exception
    //   1764	1795	2968	java/lang/Exception
    //   1823	1857	2968	java/lang/Exception
    //   1885	1899	2968	java/lang/Exception
    //   1927	1937	2968	java/lang/Exception
    //   1967	1989	2968	java/lang/Exception
    //   2029	2041	2968	java/lang/Exception
    //   1578	1586	2986	java/lang/Exception
    //   1586	1592	3003	java/lang/Exception
    //   1598	1604	3003	java/lang/Exception
    //   1607	1617	3003	java/lang/Exception
    //   1622	1628	3023	java/lang/Exception
    //   1628	1638	3023	java/lang/Exception
    //   1698	1705	3023	java/lang/Exception
    //   152	159	3048	java/io/IOException
    //   167	294	3048	java/io/IOException
    //   294	314	3048	java/io/IOException
    //   342	348	3065	java/io/IOException
    //   381	388	3065	java/io/IOException
    //   416	425	3065	java/io/IOException
    //   459	469	3065	java/io/IOException
    //   722	732	3065	java/io/IOException
    //   760	767	3065	java/io/IOException
    //   795	800	3065	java/io/IOException
    //   828	833	3065	java/io/IOException
    //   885	892	3065	java/io/IOException
    //   920	954	3065	java/io/IOException
    //   1004	1011	3065	java/io/IOException
    //   1048	1089	3065	java/io/IOException
    //   1117	1150	3065	java/io/IOException
    //   1178	1188	3065	java/io/IOException
    //   1219	1232	3065	java/io/IOException
    //   1265	1276	3065	java/io/IOException
    //   1304	1315	3065	java/io/IOException
    //   1343	1348	3065	java/io/IOException
    //   1376	1386	3065	java/io/IOException
    //   1466	1473	3065	java/io/IOException
    //   1504	1517	3065	java/io/IOException
    //   1572	1578	3065	java/io/IOException
    //   1764	1795	3065	java/io/IOException
    //   1823	1857	3065	java/io/IOException
    //   1885	1899	3065	java/io/IOException
    //   1927	1937	3065	java/io/IOException
    //   1967	1989	3065	java/io/IOException
    //   2029	2041	3065	java/io/IOException
    //   1578	1586	3083	java/io/IOException
    //   1586	1592	3100	java/io/IOException
    //   1598	1604	3100	java/io/IOException
    //   1607	1617	3100	java/io/IOException
    //   1622	1628	3120	java/io/IOException
    //   1628	1638	3120	java/io/IOException
    //   1698	1705	3120	java/io/IOException
    //   57	65	3145	java/net/SocketTimeoutException
    //   152	159	3167	java/net/SocketTimeoutException
    //   167	294	3167	java/net/SocketTimeoutException
    //   294	314	3167	java/net/SocketTimeoutException
    //   885	892	3189	java/net/SocketTimeoutException
    //   920	954	3189	java/net/SocketTimeoutException
    //   1004	1011	3189	java/net/SocketTimeoutException
    //   1048	1089	3189	java/net/SocketTimeoutException
    //   1117	1150	3189	java/net/SocketTimeoutException
    //   1178	1188	3189	java/net/SocketTimeoutException
    //   1219	1232	3189	java/net/SocketTimeoutException
    //   1265	1276	3189	java/net/SocketTimeoutException
    //   1304	1315	3189	java/net/SocketTimeoutException
    //   1343	1348	3189	java/net/SocketTimeoutException
    //   1376	1386	3189	java/net/SocketTimeoutException
    //   1466	1473	3189	java/net/SocketTimeoutException
    //   1504	1517	3189	java/net/SocketTimeoutException
    //   1572	1578	3189	java/net/SocketTimeoutException
    //   1764	1795	3189	java/net/SocketTimeoutException
    //   1823	1857	3189	java/net/SocketTimeoutException
    //   1885	1899	3189	java/net/SocketTimeoutException
    //   1927	1937	3189	java/net/SocketTimeoutException
    //   1967	1989	3189	java/net/SocketTimeoutException
    //   2029	2041	3189	java/net/SocketTimeoutException
    //   1578	1586	3214	java/net/SocketTimeoutException
    //   1586	1592	3247	java/net/SocketTimeoutException
    //   1598	1604	3247	java/net/SocketTimeoutException
    //   1607	1617	3247	java/net/SocketTimeoutException
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 51	com/tencent/token/utils/k
    //   3: dup
    //   4: invokespecial 52	com/tencent/token/utils/k:<init>	()V
    //   7: astore 30
    //   9: aconst_null
    //   10: astore 20
    //   12: aconst_null
    //   13: astore 21
    //   15: aconst_null
    //   16: astore 19
    //   18: aconst_null
    //   19: astore 12
    //   21: aconst_null
    //   22: astore 27
    //   24: aconst_null
    //   25: astore 14
    //   27: aconst_null
    //   28: astore 17
    //   30: aconst_null
    //   31: astore 18
    //   33: aconst_null
    //   34: astore 16
    //   36: aconst_null
    //   37: astore 25
    //   39: aconst_null
    //   40: astore 28
    //   42: aconst_null
    //   43: astore 15
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 55	com/tencent/token/ez:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   51: astore 9
    //   53: aload 9
    //   55: ifnonnull +81 -> 136
    //   58: aconst_null
    //   59: astore_1
    //   60: iconst_0
    //   61: ifeq +11 -> 72
    //   64: new 57	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: iconst_0
    //   73: ifeq +11 -> 84
    //   76: new 57	java/lang/NullPointerException
    //   79: dup
    //   80: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   83: athrow
    //   84: iconst_0
    //   85: ifeq +11 -> 96
    //   88: new 57	java/lang/NullPointerException
    //   91: dup
    //   92: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   95: athrow
    //   96: aload_1
    //   97: astore_2
    //   98: aload 9
    //   100: ifnull +10 -> 110
    //   103: aload 9
    //   105: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   117: goto -45 -> 72
    //   120: astore_2
    //   121: aload_2
    //   122: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   125: goto -41 -> 84
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   133: goto -37 -> 96
    //   136: aload_3
    //   137: ifnull +2617 -> 2754
    //   140: aload_3
    //   141: invokevirtual 72	java/lang/String:length	()I
    //   144: ifle +2610 -> 2754
    //   147: aconst_null
    //   148: astore 11
    //   150: aload 5
    //   152: ifnull +114 -> 266
    //   155: new 74	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   162: ldc 77
    //   164: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_3
    //   168: invokevirtual 85	java/lang/String:getBytes	()[B
    //   171: arraylength
    //   172: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 90
    //   177: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: arraylength
    //   183: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   192: ldc 109
    //   194: invokevirtual 85	java/lang/String:getBytes	()[B
    //   197: astore 11
    //   199: aload_3
    //   200: invokevirtual 85	java/lang/String:getBytes	()[B
    //   203: arraylength
    //   204: aload 11
    //   206: arraylength
    //   207: iadd
    //   208: aload 5
    //   210: arraylength
    //   211: iadd
    //   212: ldc 116
    //   214: invokevirtual 85	java/lang/String:getBytes	()[B
    //   217: arraylength
    //   218: iadd
    //   219: i2l
    //   220: lstore 7
    //   222: new 74	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   229: ldc 118
    //   231: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: lload 7
    //   236: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   245: aload 9
    //   247: ldc 120
    //   249: ldc 122
    //   251: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 9
    //   256: ldc 128
    //   258: lload 7
    //   260: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   263: invokevirtual 126	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 9
    //   268: iconst_1
    //   269: invokevirtual 136	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   272: new 138	java/io/DataOutputStream
    //   275: dup
    //   276: aload 9
    //   278: invokevirtual 142	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   281: invokespecial 145	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   284: astore 10
    //   286: aload 10
    //   288: aload_3
    //   289: invokevirtual 148	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   292: aload 5
    //   294: ifnull +27 -> 321
    //   297: aload 10
    //   299: aload 5
    //   301: invokevirtual 207	java/io/DataOutputStream:write	([B)V
    //   304: aload 10
    //   306: ldc 116
    //   308: invokevirtual 85	java/lang/String:getBytes	()[B
    //   311: invokevirtual 207	java/io/DataOutputStream:write	([B)V
    //   314: aload 10
    //   316: aload 11
    //   318: invokevirtual 207	java/io/DataOutputStream:write	([B)V
    //   321: aload 10
    //   323: invokevirtual 210	java/io/DataOutputStream:flush	()V
    //   326: aload 10
    //   328: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   331: aconst_null
    //   332: astore 22
    //   334: aconst_null
    //   335: astore 24
    //   337: aconst_null
    //   338: astore 26
    //   340: aconst_null
    //   341: astore 29
    //   343: aconst_null
    //   344: astore 23
    //   346: aload 28
    //   348: astore 13
    //   350: aload 27
    //   352: astore 12
    //   354: aload 29
    //   356: astore 11
    //   358: aload 9
    //   360: astore 10
    //   362: aload 9
    //   364: invokevirtual 213	java/net/HttpURLConnection:getResponseCode	()I
    //   367: istore 6
    //   369: aload 28
    //   371: astore 13
    //   373: aload 27
    //   375: astore 12
    //   377: aload 29
    //   379: astore 11
    //   381: aload 9
    //   383: astore 10
    //   385: ldc 215
    //   387: new 74	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   394: ldc 217
    //   396: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: iload 6
    //   401: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: ldc 219
    //   406: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_1
    //   410: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 224	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: iload 6
    //   421: sipush 200
    //   424: if_icmpeq +17 -> 441
    //   427: iload 6
    //   429: sipush 206
    //   432: if_icmpeq +9 -> 441
    //   435: iload 6
    //   437: iconst_m1
    //   438: if_icmpne +822 -> 1260
    //   441: aload 28
    //   443: astore 13
    //   445: aload 27
    //   447: astore 12
    //   449: aload 29
    //   451: astore 11
    //   453: aload 9
    //   455: astore 10
    //   457: aload 9
    //   459: invokevirtual 227	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   462: astore 14
    //   464: aload 14
    //   466: ifnonnull +330 -> 796
    //   469: ldc 229
    //   471: astore 14
    //   473: aload 28
    //   475: astore 13
    //   477: aload 27
    //   479: astore 12
    //   481: aload 29
    //   483: astore 11
    //   485: aload 9
    //   487: astore 10
    //   489: new 74	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   496: ldc 231
    //   498: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 14
    //   503: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc 233
    //   508: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_2
    //   512: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc 235
    //   517: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 198	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   530: aload 28
    //   532: astore 13
    //   534: aload 27
    //   536: astore 12
    //   538: aload 29
    //   540: astore 11
    //   542: aload 9
    //   544: astore 10
    //   546: new 74	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   553: ldc 231
    //   555: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 14
    //   560: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc 233
    //   565: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc 235
    //   574: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: astore 31
    //   579: aload 28
    //   581: astore 13
    //   583: aload 27
    //   585: astore 12
    //   587: aload 29
    //   589: astore 11
    //   591: aload 9
    //   593: astore 10
    //   595: aload_1
    //   596: ldc 200
    //   598: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   601: iconst_m1
    //   602: if_icmpne +220 -> 822
    //   605: aload_1
    //   606: astore 15
    //   608: aload 28
    //   610: astore 13
    //   612: aload 27
    //   614: astore 12
    //   616: aload 29
    //   618: astore 11
    //   620: aload 9
    //   622: astore 10
    //   624: aload 31
    //   626: aload 15
    //   628: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   637: iload 4
    //   639: ifeq +239 -> 878
    //   642: aload 28
    //   644: astore 13
    //   646: aload 27
    //   648: astore 12
    //   650: aload 29
    //   652: astore 11
    //   654: aload 9
    //   656: astore 10
    //   658: aload 14
    //   660: ldc 237
    //   662: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   665: iconst_m1
    //   666: if_icmpne +30 -> 696
    //   669: aload 28
    //   671: astore 13
    //   673: aload 27
    //   675: astore 12
    //   677: aload 29
    //   679: astore 11
    //   681: aload 9
    //   683: astore 10
    //   685: aload 14
    //   687: ldc 239
    //   689: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   692: iconst_m1
    //   693: if_icmpeq +185 -> 878
    //   696: aload 28
    //   698: astore 13
    //   700: aload 27
    //   702: astore 12
    //   704: aload 29
    //   706: astore 11
    //   708: aload 9
    //   710: astore 10
    //   712: ldc 241
    //   714: invokestatic 243	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   717: aload 28
    //   719: astore 13
    //   721: aload 27
    //   723: astore 12
    //   725: aload 29
    //   727: astore 11
    //   729: aload 9
    //   731: astore 10
    //   733: aload_0
    //   734: aload_1
    //   735: aload_2
    //   736: aload_3
    //   737: iconst_1
    //   738: aload 5
    //   740: invokespecial 290	com/tencent/token/ez:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z[B)[B
    //   743: astore_2
    //   744: aload_2
    //   745: astore_1
    //   746: iconst_0
    //   747: ifeq +11 -> 758
    //   750: new 57	java/lang/NullPointerException
    //   753: dup
    //   754: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   757: athrow
    //   758: iconst_0
    //   759: ifeq +11 -> 770
    //   762: new 57	java/lang/NullPointerException
    //   765: dup
    //   766: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   769: athrow
    //   770: iconst_0
    //   771: ifeq +11 -> 782
    //   774: new 57	java/lang/NullPointerException
    //   777: dup
    //   778: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   781: athrow
    //   782: aload_1
    //   783: astore_2
    //   784: aload 9
    //   786: ifnull -676 -> 110
    //   789: aload 9
    //   791: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   794: aload_1
    //   795: areturn
    //   796: aload 28
    //   798: astore 13
    //   800: aload 27
    //   802: astore 12
    //   804: aload 29
    //   806: astore 11
    //   808: aload 9
    //   810: astore 10
    //   812: aload 14
    //   814: invokevirtual 248	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   817: astore 14
    //   819: goto -346 -> 473
    //   822: aload 28
    //   824: astore 13
    //   826: aload 27
    //   828: astore 12
    //   830: aload 29
    //   832: astore 11
    //   834: aload 9
    //   836: astore 10
    //   838: aload_1
    //   839: iconst_0
    //   840: aload_1
    //   841: ldc 200
    //   843: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   846: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   849: astore 15
    //   851: goto -243 -> 608
    //   854: astore_2
    //   855: aload_2
    //   856: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   859: goto -101 -> 758
    //   862: astore_2
    //   863: aload_2
    //   864: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   867: goto -97 -> 770
    //   870: astore_2
    //   871: aload_2
    //   872: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   875: goto -93 -> 782
    //   878: aload 28
    //   880: astore 13
    //   882: aload 27
    //   884: astore 12
    //   886: aload 29
    //   888: astore 11
    //   890: aload 9
    //   892: astore 10
    //   894: aload 9
    //   896: invokevirtual 256	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   899: astore_2
    //   900: new 183	java/io/ByteArrayOutputStream
    //   903: dup
    //   904: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
    //   907: astore_3
    //   908: aload_2
    //   909: invokevirtual 259	java/io/InputStream:read	()I
    //   912: istore 6
    //   914: iload 6
    //   916: iconst_m1
    //   917: if_icmpeq +228 -> 1145
    //   920: aload_3
    //   921: iload 6
    //   923: invokevirtual 262	java/io/ByteArrayOutputStream:write	(I)V
    //   926: goto -18 -> 908
    //   929: astore 11
    //   931: aconst_null
    //   932: astore 12
    //   934: aconst_null
    //   935: astore 5
    //   937: aload 9
    //   939: astore 10
    //   941: aload 12
    //   943: astore 9
    //   945: aload 11
    //   947: invokevirtual 157	java/net/SocketTimeoutException:printStackTrace	()V
    //   950: aload_0
    //   951: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   954: sipush 10002
    //   957: new 74	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   964: aload 11
    //   966: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   969: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc 160
    //   974: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: aload 11
    //   979: invokevirtual 163	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   982: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   991: invokestatic 171	com/tencent/token/bu:a	()Lcom/tencent/token/bu;
    //   994: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   997: getstatic 18	com/tencent/token/ez:f	I
    //   1000: invokevirtual 179	com/tencent/token/bu:a	(JI)V
    //   1003: aload 11
    //   1005: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   1008: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1011: aload 11
    //   1013: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   1016: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1019: aload_3
    //   1020: ifnull +7 -> 1027
    //   1023: aload_3
    //   1024: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1027: aload_2
    //   1028: ifnull +7 -> 1035
    //   1031: aload_2
    //   1032: invokevirtual 189	java/io/InputStream:close	()V
    //   1035: aload 9
    //   1037: ifnull +8 -> 1045
    //   1040: aload 9
    //   1042: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   1045: aload 5
    //   1047: astore_3
    //   1048: aload 10
    //   1050: ifnull +11 -> 1061
    //   1053: aload 10
    //   1055: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1058: aload 5
    //   1060: astore_3
    //   1061: new 74	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1068: ldc 192
    //   1070: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload 30
    //   1075: invokevirtual 194	com/tencent/token/utils/k:a	()J
    //   1078: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1081: ldc 196
    //   1083: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: aload_1
    //   1087: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 198	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   1096: new 74	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1103: ldc 192
    //   1105: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: aload 30
    //   1110: invokevirtual 194	com/tencent/token/utils/k:a	()J
    //   1113: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1116: ldc 196
    //   1118: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: astore_2
    //   1122: aload_1
    //   1123: ldc 200
    //   1125: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1128: iconst_m1
    //   1129: if_icmpne +1072 -> 2201
    //   1132: aload_2
    //   1133: aload_1
    //   1134: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1143: aload_3
    //   1144: areturn
    //   1145: aload_3
    //   1146: invokevirtual 263	java/io/ByteArrayOutputStream:flush	()V
    //   1149: aload_3
    //   1150: invokevirtual 266	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1153: astore 5
    //   1155: aload 5
    //   1157: ifnull +9 -> 1166
    //   1160: aload 5
    //   1162: arraylength
    //   1163: ifgt +71 -> 1234
    //   1166: aload_0
    //   1167: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1170: ldc_w 267
    //   1173: invokevirtual 269	com/tencent/token/global/e:b	(I)V
    //   1176: aconst_null
    //   1177: astore 5
    //   1179: aload_3
    //   1180: astore 10
    //   1182: aload_2
    //   1183: astore_3
    //   1184: aload 5
    //   1186: astore_2
    //   1187: aload 10
    //   1189: ifnull +8 -> 1197
    //   1192: aload 10
    //   1194: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1197: aload_3
    //   1198: ifnull +7 -> 1205
    //   1201: aload_3
    //   1202: invokevirtual 189	java/io/InputStream:close	()V
    //   1205: iconst_0
    //   1206: ifeq +11 -> 1217
    //   1209: new 57	java/lang/NullPointerException
    //   1212: dup
    //   1213: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1216: athrow
    //   1217: aload_2
    //   1218: astore_3
    //   1219: aload 9
    //   1221: ifnull -160 -> 1061
    //   1224: aload 9
    //   1226: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1229: aload_2
    //   1230: astore_3
    //   1231: goto -170 -> 1061
    //   1234: aload_0
    //   1235: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1238: invokevirtual 271	com/tencent/token/global/e:c	()V
    //   1241: goto -62 -> 1179
    //   1244: astore 11
    //   1246: aconst_null
    //   1247: astore 12
    //   1249: aload 9
    //   1251: astore 10
    //   1253: aload 12
    //   1255: astore 9
    //   1257: goto -312 -> 945
    //   1260: aload 28
    //   1262: astore 13
    //   1264: aload 27
    //   1266: astore 12
    //   1268: aload 29
    //   1270: astore 11
    //   1272: aload 9
    //   1274: astore 10
    //   1276: aload_0
    //   1277: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1280: sipush 10005
    //   1283: new 74	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1290: ldc_w 273
    //   1293: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload 6
    //   1298: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1307: aload 28
    //   1309: astore 13
    //   1311: aload 27
    //   1313: astore 12
    //   1315: aload 29
    //   1317: astore 11
    //   1319: aload 9
    //   1321: astore 10
    //   1323: new 74	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 275
    //   1333: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_1
    //   1337: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 277
    //   1343: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: iload 6
    //   1348: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1351: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1354: invokestatic 243	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   1357: aload 28
    //   1359: astore 13
    //   1361: aload 27
    //   1363: astore 12
    //   1365: aload 29
    //   1367: astore 11
    //   1369: aload 9
    //   1371: astore 10
    //   1373: new 74	java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1380: ldc_w 279
    //   1383: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: astore_3
    //   1387: aload 28
    //   1389: astore 13
    //   1391: aload 27
    //   1393: astore 12
    //   1395: aload 29
    //   1397: astore 11
    //   1399: aload 9
    //   1401: astore 10
    //   1403: aload_1
    //   1404: ldc 200
    //   1406: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1409: iconst_m1
    //   1410: if_icmpne +55 -> 1465
    //   1413: aload_1
    //   1414: astore_2
    //   1415: aload 28
    //   1417: astore 13
    //   1419: aload 27
    //   1421: astore 12
    //   1423: aload 29
    //   1425: astore 11
    //   1427: aload 9
    //   1429: astore 10
    //   1431: aload_3
    //   1432: aload_2
    //   1433: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: ldc_w 277
    //   1439: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: iload 6
    //   1444: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1453: aconst_null
    //   1454: astore_2
    //   1455: aload 15
    //   1457: astore 10
    //   1459: aload 14
    //   1461: astore_3
    //   1462: goto -275 -> 1187
    //   1465: aload 28
    //   1467: astore 13
    //   1469: aload 27
    //   1471: astore 12
    //   1473: aload 29
    //   1475: astore 11
    //   1477: aload 9
    //   1479: astore 10
    //   1481: aload_1
    //   1482: iconst_0
    //   1483: aload_1
    //   1484: ldc 200
    //   1486: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1489: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   1492: astore_2
    //   1493: goto -78 -> 1415
    //   1496: astore 5
    //   1498: aload 5
    //   1500: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1503: goto -306 -> 1197
    //   1506: astore_3
    //   1507: aload_3
    //   1508: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1511: goto -306 -> 1205
    //   1514: astore_3
    //   1515: aload_3
    //   1516: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1519: goto -302 -> 1217
    //   1522: astore_3
    //   1523: aload_3
    //   1524: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1527: goto -500 -> 1027
    //   1530: astore_2
    //   1531: aload_2
    //   1532: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1535: goto -500 -> 1035
    //   1538: astore_2
    //   1539: aload_2
    //   1540: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1543: goto -498 -> 1045
    //   1546: astore_3
    //   1547: aconst_null
    //   1548: astore 14
    //   1550: aconst_null
    //   1551: astore 9
    //   1553: aconst_null
    //   1554: astore_2
    //   1555: aload 20
    //   1557: astore 5
    //   1559: aload 17
    //   1561: astore 15
    //   1563: aload 15
    //   1565: astore 13
    //   1567: aload 5
    //   1569: astore 12
    //   1571: aload 14
    //   1573: astore 11
    //   1575: aload 9
    //   1577: astore 10
    //   1579: aload_3
    //   1580: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   1583: aload 15
    //   1585: astore 13
    //   1587: aload 5
    //   1589: astore 12
    //   1591: aload 14
    //   1593: astore 11
    //   1595: aload 9
    //   1597: astore 10
    //   1599: aload_0
    //   1600: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1603: sipush 10003
    //   1606: new 74	java/lang/StringBuilder
    //   1609: dup
    //   1610: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1613: aload_3
    //   1614: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   1617: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: ldc 160
    //   1622: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: aload_3
    //   1626: invokevirtual 282	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1629: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1638: aload 15
    //   1640: astore 13
    //   1642: aload 5
    //   1644: astore 12
    //   1646: aload 14
    //   1648: astore 11
    //   1650: aload 9
    //   1652: astore 10
    //   1654: aload_3
    //   1655: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   1658: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1661: aload 15
    //   1663: astore 13
    //   1665: aload 5
    //   1667: astore 12
    //   1669: aload 14
    //   1671: astore 11
    //   1673: aload 9
    //   1675: astore 10
    //   1677: aload_3
    //   1678: invokevirtual 281	java/io/IOException:toString	()Ljava/lang/String;
    //   1681: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1684: aload 15
    //   1686: ifnull +8 -> 1694
    //   1689: aload 15
    //   1691: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1694: aload 5
    //   1696: ifnull +8 -> 1704
    //   1699: aload 5
    //   1701: invokevirtual 189	java/io/InputStream:close	()V
    //   1704: aload 14
    //   1706: ifnull +8 -> 1714
    //   1709: aload 14
    //   1711: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   1714: aload_2
    //   1715: astore_3
    //   1716: aload 9
    //   1718: ifnull -657 -> 1061
    //   1721: aload 9
    //   1723: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1726: aload_2
    //   1727: astore_3
    //   1728: goto -667 -> 1061
    //   1731: astore_3
    //   1732: aload_3
    //   1733: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1736: goto -42 -> 1694
    //   1739: astore_3
    //   1740: aload_3
    //   1741: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1744: goto -40 -> 1704
    //   1747: astore_3
    //   1748: aload_3
    //   1749: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1752: goto -38 -> 1714
    //   1755: astore_3
    //   1756: aconst_null
    //   1757: astore 14
    //   1759: aconst_null
    //   1760: astore 9
    //   1762: aconst_null
    //   1763: astore_2
    //   1764: aload 21
    //   1766: astore 5
    //   1768: aload 18
    //   1770: astore 15
    //   1772: aload 15
    //   1774: astore 13
    //   1776: aload 5
    //   1778: astore 12
    //   1780: aload 14
    //   1782: astore 11
    //   1784: aload 9
    //   1786: astore 10
    //   1788: aload_3
    //   1789: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1792: aload 15
    //   1794: astore 13
    //   1796: aload 5
    //   1798: astore 12
    //   1800: aload 14
    //   1802: astore 11
    //   1804: aload 9
    //   1806: astore 10
    //   1808: aload_0
    //   1809: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   1812: sipush 10003
    //   1815: new 74	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1822: aload_3
    //   1823: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   1826: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: ldc 160
    //   1831: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: aload_3
    //   1835: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1838: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1844: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1847: aload 15
    //   1849: astore 13
    //   1851: aload 5
    //   1853: astore 12
    //   1855: aload 14
    //   1857: astore 11
    //   1859: aload 9
    //   1861: astore 10
    //   1863: aload_3
    //   1864: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   1867: invokestatic 107	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1870: aload 15
    //   1872: astore 13
    //   1874: aload 5
    //   1876: astore 12
    //   1878: aload 14
    //   1880: astore 11
    //   1882: aload 9
    //   1884: astore 10
    //   1886: aload_3
    //   1887: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   1890: invokestatic 181	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1893: aload 15
    //   1895: ifnull +8 -> 1903
    //   1898: aload 15
    //   1900: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1903: aload 5
    //   1905: ifnull +8 -> 1913
    //   1908: aload 5
    //   1910: invokevirtual 189	java/io/InputStream:close	()V
    //   1913: aload 14
    //   1915: ifnull +8 -> 1923
    //   1918: aload 14
    //   1920: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   1923: aload_2
    //   1924: astore_3
    //   1925: aload 9
    //   1927: ifnull -866 -> 1061
    //   1930: aload 9
    //   1932: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1935: aload_2
    //   1936: astore_3
    //   1937: goto -876 -> 1061
    //   1940: astore_3
    //   1941: aload_3
    //   1942: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1945: goto -42 -> 1903
    //   1948: astore_3
    //   1949: aload_3
    //   1950: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1953: goto -40 -> 1913
    //   1956: astore_3
    //   1957: aload_3
    //   1958: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1961: goto -38 -> 1923
    //   1964: astore_3
    //   1965: aconst_null
    //   1966: astore 14
    //   1968: aconst_null
    //   1969: astore 9
    //   1971: aconst_null
    //   1972: astore_2
    //   1973: aload 19
    //   1975: astore 5
    //   1977: aload 16
    //   1979: astore 15
    //   1981: aload 15
    //   1983: astore 13
    //   1985: aload 5
    //   1987: astore 12
    //   1989: aload 14
    //   1991: astore 11
    //   1993: aload 9
    //   1995: astore 10
    //   1997: aload_3
    //   1998: invokevirtual 285	java/lang/Throwable:printStackTrace	()V
    //   2001: aload 15
    //   2003: astore 13
    //   2005: aload 5
    //   2007: astore 12
    //   2009: aload 14
    //   2011: astore 11
    //   2013: aload 9
    //   2015: astore 10
    //   2017: aload_0
    //   2018: getfield 29	com/tencent/token/ez:a	Lcom/tencent/token/global/e;
    //   2021: sipush 10003
    //   2024: new 74	java/lang/StringBuilder
    //   2027: dup
    //   2028: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2031: aload_3
    //   2032: invokevirtual 286	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2035: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: ldc 160
    //   2040: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: aload_3
    //   2044: invokevirtual 287	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2047: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2053: invokevirtual 166	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2056: aload 15
    //   2058: ifnull +8 -> 2066
    //   2061: aload 15
    //   2063: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2066: aload 5
    //   2068: ifnull +8 -> 2076
    //   2071: aload 5
    //   2073: invokevirtual 189	java/io/InputStream:close	()V
    //   2076: aload 14
    //   2078: ifnull +8 -> 2086
    //   2081: aload 14
    //   2083: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2086: aload_2
    //   2087: astore_3
    //   2088: aload 9
    //   2090: ifnull -1029 -> 1061
    //   2093: aload 9
    //   2095: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2098: aload_2
    //   2099: astore_3
    //   2100: goto -1039 -> 1061
    //   2103: astore_3
    //   2104: aload_3
    //   2105: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2108: goto -42 -> 2066
    //   2111: astore_3
    //   2112: aload_3
    //   2113: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2116: goto -40 -> 2076
    //   2119: astore_3
    //   2120: aload_3
    //   2121: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2124: goto -38 -> 2086
    //   2127: astore_1
    //   2128: aconst_null
    //   2129: astore_2
    //   2130: aconst_null
    //   2131: astore 9
    //   2133: aload 25
    //   2135: astore 13
    //   2137: aload 13
    //   2139: ifnull +8 -> 2147
    //   2142: aload 13
    //   2144: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2147: aload 12
    //   2149: ifnull +8 -> 2157
    //   2152: aload 12
    //   2154: invokevirtual 189	java/io/InputStream:close	()V
    //   2157: aload_2
    //   2158: ifnull +7 -> 2165
    //   2161: aload_2
    //   2162: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2165: aload 9
    //   2167: ifnull +8 -> 2175
    //   2170: aload 9
    //   2172: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2175: aload_1
    //   2176: athrow
    //   2177: astore_3
    //   2178: aload_3
    //   2179: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2182: goto -35 -> 2147
    //   2185: astore_3
    //   2186: aload_3
    //   2187: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2190: goto -33 -> 2157
    //   2193: astore_2
    //   2194: aload_2
    //   2195: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2198: goto -33 -> 2165
    //   2201: aload_1
    //   2202: iconst_0
    //   2203: aload_1
    //   2204: ldc 200
    //   2206: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2209: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   2212: astore_1
    //   2213: goto -1081 -> 1132
    //   2216: astore_1
    //   2217: aconst_null
    //   2218: astore_2
    //   2219: aload 25
    //   2221: astore 13
    //   2223: goto -86 -> 2137
    //   2226: astore_1
    //   2227: aload 10
    //   2229: astore_2
    //   2230: aload 25
    //   2232: astore 13
    //   2234: goto -97 -> 2137
    //   2237: astore_1
    //   2238: aload 11
    //   2240: astore_2
    //   2241: aload 10
    //   2243: astore 9
    //   2245: goto -108 -> 2137
    //   2248: astore_1
    //   2249: aload 25
    //   2251: astore 13
    //   2253: aload_2
    //   2254: astore 12
    //   2256: aload 26
    //   2258: astore_2
    //   2259: goto -122 -> 2137
    //   2262: astore_1
    //   2263: aload_3
    //   2264: astore 13
    //   2266: aload_2
    //   2267: astore 12
    //   2269: aload 26
    //   2271: astore_2
    //   2272: goto -135 -> 2137
    //   2275: astore_1
    //   2276: aload 9
    //   2278: astore 5
    //   2280: aload 10
    //   2282: astore 9
    //   2284: aload_3
    //   2285: astore 13
    //   2287: aload_2
    //   2288: astore 12
    //   2290: aload 5
    //   2292: astore_2
    //   2293: goto -156 -> 2137
    //   2296: astore_3
    //   2297: aconst_null
    //   2298: astore 14
    //   2300: aconst_null
    //   2301: astore_2
    //   2302: aload 16
    //   2304: astore 15
    //   2306: aload 19
    //   2308: astore 5
    //   2310: goto -329 -> 1981
    //   2313: astore_3
    //   2314: aconst_null
    //   2315: astore_2
    //   2316: aload 16
    //   2318: astore 15
    //   2320: aload 19
    //   2322: astore 5
    //   2324: aload 10
    //   2326: astore 14
    //   2328: goto -347 -> 1981
    //   2331: astore_3
    //   2332: aconst_null
    //   2333: astore_2
    //   2334: aload 16
    //   2336: astore 15
    //   2338: aload 19
    //   2340: astore 5
    //   2342: aload 24
    //   2344: astore 14
    //   2346: goto -365 -> 1981
    //   2349: astore_3
    //   2350: aload_2
    //   2351: astore 5
    //   2353: aconst_null
    //   2354: astore_2
    //   2355: aload 16
    //   2357: astore 15
    //   2359: aload 24
    //   2361: astore 14
    //   2363: goto -382 -> 1981
    //   2366: astore 10
    //   2368: aload_3
    //   2369: astore 15
    //   2371: aload_2
    //   2372: astore 5
    //   2374: aconst_null
    //   2375: astore_2
    //   2376: aload 10
    //   2378: astore_3
    //   2379: aload 24
    //   2381: astore 14
    //   2383: goto -402 -> 1981
    //   2386: astore 11
    //   2388: aload_3
    //   2389: astore 15
    //   2391: aload_2
    //   2392: astore 10
    //   2394: aload 5
    //   2396: astore_2
    //   2397: aload 11
    //   2399: astore_3
    //   2400: aload 10
    //   2402: astore 5
    //   2404: aload 24
    //   2406: astore 14
    //   2408: goto -427 -> 1981
    //   2411: astore_3
    //   2412: aconst_null
    //   2413: astore 14
    //   2415: aconst_null
    //   2416: astore_2
    //   2417: aload 18
    //   2419: astore 15
    //   2421: aload 21
    //   2423: astore 5
    //   2425: goto -653 -> 1772
    //   2428: astore_3
    //   2429: aconst_null
    //   2430: astore_2
    //   2431: aload 18
    //   2433: astore 15
    //   2435: aload 21
    //   2437: astore 5
    //   2439: aload 10
    //   2441: astore 14
    //   2443: goto -671 -> 1772
    //   2446: astore_3
    //   2447: aconst_null
    //   2448: astore_2
    //   2449: aload 18
    //   2451: astore 15
    //   2453: aload 21
    //   2455: astore 5
    //   2457: aload 22
    //   2459: astore 14
    //   2461: goto -689 -> 1772
    //   2464: astore_3
    //   2465: aload_2
    //   2466: astore 5
    //   2468: aconst_null
    //   2469: astore_2
    //   2470: aload 18
    //   2472: astore 15
    //   2474: aload 22
    //   2476: astore 14
    //   2478: goto -706 -> 1772
    //   2481: astore 10
    //   2483: aload_3
    //   2484: astore 15
    //   2486: aload_2
    //   2487: astore 5
    //   2489: aconst_null
    //   2490: astore_2
    //   2491: aload 10
    //   2493: astore_3
    //   2494: aload 22
    //   2496: astore 14
    //   2498: goto -726 -> 1772
    //   2501: astore 11
    //   2503: aload_3
    //   2504: astore 15
    //   2506: aload_2
    //   2507: astore 10
    //   2509: aload 5
    //   2511: astore_2
    //   2512: aload 11
    //   2514: astore_3
    //   2515: aload 10
    //   2517: astore 5
    //   2519: aload 22
    //   2521: astore 14
    //   2523: goto -751 -> 1772
    //   2526: astore_3
    //   2527: aconst_null
    //   2528: astore 14
    //   2530: aconst_null
    //   2531: astore_2
    //   2532: aload 17
    //   2534: astore 15
    //   2536: aload 20
    //   2538: astore 5
    //   2540: goto -977 -> 1563
    //   2543: astore_3
    //   2544: aconst_null
    //   2545: astore_2
    //   2546: aload 17
    //   2548: astore 15
    //   2550: aload 20
    //   2552: astore 5
    //   2554: aload 10
    //   2556: astore 14
    //   2558: goto -995 -> 1563
    //   2561: astore_3
    //   2562: aconst_null
    //   2563: astore_2
    //   2564: aload 17
    //   2566: astore 15
    //   2568: aload 20
    //   2570: astore 5
    //   2572: aload 23
    //   2574: astore 14
    //   2576: goto -1013 -> 1563
    //   2579: astore_3
    //   2580: aload_2
    //   2581: astore 5
    //   2583: aconst_null
    //   2584: astore_2
    //   2585: aload 17
    //   2587: astore 15
    //   2589: aload 23
    //   2591: astore 14
    //   2593: goto -1030 -> 1563
    //   2596: astore 5
    //   2598: aload_3
    //   2599: astore 15
    //   2601: aload_2
    //   2602: astore 10
    //   2604: aconst_null
    //   2605: astore_2
    //   2606: aload 5
    //   2608: astore_3
    //   2609: aload 10
    //   2611: astore 5
    //   2613: aload 23
    //   2615: astore 14
    //   2617: goto -1054 -> 1563
    //   2620: astore 11
    //   2622: aload_3
    //   2623: astore 15
    //   2625: aload_2
    //   2626: astore 10
    //   2628: aload 5
    //   2630: astore_2
    //   2631: aload 11
    //   2633: astore_3
    //   2634: aload 10
    //   2636: astore 5
    //   2638: aload 23
    //   2640: astore 14
    //   2642: goto -1079 -> 1563
    //   2645: astore 11
    //   2647: aconst_null
    //   2648: astore_2
    //   2649: aconst_null
    //   2650: astore 9
    //   2652: aconst_null
    //   2653: astore 10
    //   2655: aconst_null
    //   2656: astore_3
    //   2657: aconst_null
    //   2658: astore 5
    //   2660: goto -1715 -> 945
    //   2663: astore 11
    //   2665: aconst_null
    //   2666: astore_3
    //   2667: aconst_null
    //   2668: astore_2
    //   2669: aconst_null
    //   2670: astore 12
    //   2672: aload 9
    //   2674: astore 10
    //   2676: aconst_null
    //   2677: astore 5
    //   2679: aload 12
    //   2681: astore 9
    //   2683: goto -1738 -> 945
    //   2686: astore 11
    //   2688: aconst_null
    //   2689: astore_2
    //   2690: aload 10
    //   2692: astore 12
    //   2694: aload 9
    //   2696: astore 10
    //   2698: aconst_null
    //   2699: astore_3
    //   2700: aconst_null
    //   2701: astore 5
    //   2703: aload 12
    //   2705: astore 9
    //   2707: goto -1762 -> 945
    //   2710: astore 11
    //   2712: aconst_null
    //   2713: astore_3
    //   2714: aconst_null
    //   2715: astore_2
    //   2716: aconst_null
    //   2717: astore 12
    //   2719: aload 9
    //   2721: astore 10
    //   2723: aconst_null
    //   2724: astore 5
    //   2726: aload 12
    //   2728: astore 9
    //   2730: goto -1785 -> 945
    //   2733: astore 11
    //   2735: aconst_null
    //   2736: astore_3
    //   2737: aconst_null
    //   2738: astore 12
    //   2740: aload 9
    //   2742: astore 10
    //   2744: aconst_null
    //   2745: astore 5
    //   2747: aload 12
    //   2749: astore 9
    //   2751: goto -1806 -> 945
    //   2754: goto -2423 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2757	0	this	ez
    //   0	2757	1	paramString1	String
    //   0	2757	2	paramString2	String
    //   0	2757	3	paramString3	String
    //   0	2757	4	paramBoolean	boolean
    //   0	2757	5	paramArrayOfByte	byte[]
    //   367	1076	6	i	int
    //   220	39	7	l	long
    //   51	2699	9	localObject1	Object
    //   284	2041	10	localObject2	Object
    //   2366	11	10	localThrowable1	java.lang.Throwable
    //   2392	48	10	str	String
    //   2481	11	10	localException1	Exception
    //   2507	236	10	localObject3	Object
    //   148	741	11	localObject4	Object
    //   929	83	11	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1244	1	11	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1270	969	11	localObject5	Object
    //   2386	12	11	localThrowable2	java.lang.Throwable
    //   2501	12	11	localException2	Exception
    //   2620	12	11	localIOException	IOException
    //   2645	1	11	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   2663	1	11	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   2686	1	11	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   2710	1	11	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   2733	1	11	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   19	2729	12	localObject6	Object
    //   348	1938	13	localObject7	Object
    //   25	2616	14	localObject8	Object
    //   43	2581	15	localObject9	Object
    //   34	2322	16	localObject10	Object
    //   28	2558	17	localObject11	Object
    //   31	2440	18	localObject12	Object
    //   16	2323	19	localObject13	Object
    //   10	2559	20	localObject14	Object
    //   13	2441	21	localObject15	Object
    //   332	2188	22	localObject16	Object
    //   344	2295	23	localObject17	Object
    //   335	2070	24	localObject18	Object
    //   37	2213	25	localObject19	Object
    //   338	1932	26	localObject20	Object
    //   22	1448	27	localObject21	Object
    //   40	1426	28	localObject22	Object
    //   341	1133	29	localObject23	Object
    //   7	1102	30	localk	com.tencent.token.utils.k
    //   577	48	31	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	72	112	java/lang/Exception
    //   76	84	120	java/lang/Exception
    //   88	96	128	java/lang/Exception
    //   750	758	854	java/lang/Exception
    //   762	770	862	java/lang/Exception
    //   774	782	870	java/lang/Exception
    //   908	914	929	java/net/SocketTimeoutException
    //   920	926	929	java/net/SocketTimeoutException
    //   1145	1155	929	java/net/SocketTimeoutException
    //   1160	1166	1244	java/net/SocketTimeoutException
    //   1166	1176	1244	java/net/SocketTimeoutException
    //   1234	1241	1244	java/net/SocketTimeoutException
    //   1192	1197	1496	java/lang/Exception
    //   1201	1205	1506	java/lang/Exception
    //   1209	1217	1514	java/lang/Exception
    //   1023	1027	1522	java/lang/Exception
    //   1031	1035	1530	java/lang/Exception
    //   1040	1045	1538	java/lang/Exception
    //   45	53	1546	java/io/IOException
    //   1689	1694	1731	java/lang/Exception
    //   1699	1704	1739	java/lang/Exception
    //   1709	1714	1747	java/lang/Exception
    //   45	53	1755	java/lang/Exception
    //   1898	1903	1940	java/lang/Exception
    //   1908	1913	1948	java/lang/Exception
    //   1918	1923	1956	java/lang/Exception
    //   45	53	1964	java/lang/Throwable
    //   2061	2066	2103	java/lang/Exception
    //   2071	2076	2111	java/lang/Exception
    //   2081	2086	2119	java/lang/Exception
    //   45	53	2127	finally
    //   2142	2147	2177	java/lang/Exception
    //   2152	2157	2185	java/lang/Exception
    //   2161	2165	2193	java/lang/Exception
    //   140	147	2216	finally
    //   155	266	2216	finally
    //   266	286	2216	finally
    //   286	292	2226	finally
    //   297	321	2226	finally
    //   321	331	2226	finally
    //   362	369	2237	finally
    //   385	419	2237	finally
    //   457	464	2237	finally
    //   489	530	2237	finally
    //   546	579	2237	finally
    //   595	605	2237	finally
    //   624	637	2237	finally
    //   658	669	2237	finally
    //   685	696	2237	finally
    //   712	717	2237	finally
    //   733	744	2237	finally
    //   812	819	2237	finally
    //   838	851	2237	finally
    //   894	900	2237	finally
    //   1276	1307	2237	finally
    //   1323	1357	2237	finally
    //   1373	1387	2237	finally
    //   1403	1413	2237	finally
    //   1431	1453	2237	finally
    //   1481	1493	2237	finally
    //   1579	1583	2237	finally
    //   1599	1638	2237	finally
    //   1654	1661	2237	finally
    //   1677	1684	2237	finally
    //   1788	1792	2237	finally
    //   1808	1847	2237	finally
    //   1863	1870	2237	finally
    //   1886	1893	2237	finally
    //   1997	2001	2237	finally
    //   2017	2056	2237	finally
    //   900	908	2248	finally
    //   908	914	2262	finally
    //   920	926	2262	finally
    //   1145	1155	2262	finally
    //   1160	1166	2262	finally
    //   1166	1176	2262	finally
    //   1234	1241	2262	finally
    //   945	1019	2275	finally
    //   140	147	2296	java/lang/Throwable
    //   155	266	2296	java/lang/Throwable
    //   266	286	2296	java/lang/Throwable
    //   286	292	2313	java/lang/Throwable
    //   297	321	2313	java/lang/Throwable
    //   321	331	2313	java/lang/Throwable
    //   362	369	2331	java/lang/Throwable
    //   385	419	2331	java/lang/Throwable
    //   457	464	2331	java/lang/Throwable
    //   489	530	2331	java/lang/Throwable
    //   546	579	2331	java/lang/Throwable
    //   595	605	2331	java/lang/Throwable
    //   624	637	2331	java/lang/Throwable
    //   658	669	2331	java/lang/Throwable
    //   685	696	2331	java/lang/Throwable
    //   712	717	2331	java/lang/Throwable
    //   733	744	2331	java/lang/Throwable
    //   812	819	2331	java/lang/Throwable
    //   838	851	2331	java/lang/Throwable
    //   894	900	2331	java/lang/Throwable
    //   1276	1307	2331	java/lang/Throwable
    //   1323	1357	2331	java/lang/Throwable
    //   1373	1387	2331	java/lang/Throwable
    //   1403	1413	2331	java/lang/Throwable
    //   1431	1453	2331	java/lang/Throwable
    //   1481	1493	2331	java/lang/Throwable
    //   900	908	2349	java/lang/Throwable
    //   908	914	2366	java/lang/Throwable
    //   920	926	2366	java/lang/Throwable
    //   1145	1155	2366	java/lang/Throwable
    //   1160	1166	2386	java/lang/Throwable
    //   1166	1176	2386	java/lang/Throwable
    //   1234	1241	2386	java/lang/Throwable
    //   140	147	2411	java/lang/Exception
    //   155	266	2411	java/lang/Exception
    //   266	286	2411	java/lang/Exception
    //   286	292	2428	java/lang/Exception
    //   297	321	2428	java/lang/Exception
    //   321	331	2428	java/lang/Exception
    //   362	369	2446	java/lang/Exception
    //   385	419	2446	java/lang/Exception
    //   457	464	2446	java/lang/Exception
    //   489	530	2446	java/lang/Exception
    //   546	579	2446	java/lang/Exception
    //   595	605	2446	java/lang/Exception
    //   624	637	2446	java/lang/Exception
    //   658	669	2446	java/lang/Exception
    //   685	696	2446	java/lang/Exception
    //   712	717	2446	java/lang/Exception
    //   733	744	2446	java/lang/Exception
    //   812	819	2446	java/lang/Exception
    //   838	851	2446	java/lang/Exception
    //   894	900	2446	java/lang/Exception
    //   1276	1307	2446	java/lang/Exception
    //   1323	1357	2446	java/lang/Exception
    //   1373	1387	2446	java/lang/Exception
    //   1403	1413	2446	java/lang/Exception
    //   1431	1453	2446	java/lang/Exception
    //   1481	1493	2446	java/lang/Exception
    //   900	908	2464	java/lang/Exception
    //   908	914	2481	java/lang/Exception
    //   920	926	2481	java/lang/Exception
    //   1145	1155	2481	java/lang/Exception
    //   1160	1166	2501	java/lang/Exception
    //   1166	1176	2501	java/lang/Exception
    //   1234	1241	2501	java/lang/Exception
    //   140	147	2526	java/io/IOException
    //   155	266	2526	java/io/IOException
    //   266	286	2526	java/io/IOException
    //   286	292	2543	java/io/IOException
    //   297	321	2543	java/io/IOException
    //   321	331	2543	java/io/IOException
    //   362	369	2561	java/io/IOException
    //   385	419	2561	java/io/IOException
    //   457	464	2561	java/io/IOException
    //   489	530	2561	java/io/IOException
    //   546	579	2561	java/io/IOException
    //   595	605	2561	java/io/IOException
    //   624	637	2561	java/io/IOException
    //   658	669	2561	java/io/IOException
    //   685	696	2561	java/io/IOException
    //   712	717	2561	java/io/IOException
    //   733	744	2561	java/io/IOException
    //   812	819	2561	java/io/IOException
    //   838	851	2561	java/io/IOException
    //   894	900	2561	java/io/IOException
    //   1276	1307	2561	java/io/IOException
    //   1323	1357	2561	java/io/IOException
    //   1373	1387	2561	java/io/IOException
    //   1403	1413	2561	java/io/IOException
    //   1431	1453	2561	java/io/IOException
    //   1481	1493	2561	java/io/IOException
    //   900	908	2579	java/io/IOException
    //   908	914	2596	java/io/IOException
    //   920	926	2596	java/io/IOException
    //   1145	1155	2596	java/io/IOException
    //   1160	1166	2620	java/io/IOException
    //   1166	1176	2620	java/io/IOException
    //   1234	1241	2620	java/io/IOException
    //   45	53	2645	java/net/SocketTimeoutException
    //   140	147	2663	java/net/SocketTimeoutException
    //   155	266	2663	java/net/SocketTimeoutException
    //   266	286	2663	java/net/SocketTimeoutException
    //   286	292	2686	java/net/SocketTimeoutException
    //   297	321	2686	java/net/SocketTimeoutException
    //   321	331	2686	java/net/SocketTimeoutException
    //   362	369	2710	java/net/SocketTimeoutException
    //   385	419	2710	java/net/SocketTimeoutException
    //   457	464	2710	java/net/SocketTimeoutException
    //   489	530	2710	java/net/SocketTimeoutException
    //   546	579	2710	java/net/SocketTimeoutException
    //   595	605	2710	java/net/SocketTimeoutException
    //   624	637	2710	java/net/SocketTimeoutException
    //   658	669	2710	java/net/SocketTimeoutException
    //   685	696	2710	java/net/SocketTimeoutException
    //   712	717	2710	java/net/SocketTimeoutException
    //   733	744	2710	java/net/SocketTimeoutException
    //   812	819	2710	java/net/SocketTimeoutException
    //   838	851	2710	java/net/SocketTimeoutException
    //   894	900	2710	java/net/SocketTimeoutException
    //   1276	1307	2710	java/net/SocketTimeoutException
    //   1323	1357	2710	java/net/SocketTimeoutException
    //   1373	1387	2710	java/net/SocketTimeoutException
    //   1403	1413	2710	java/net/SocketTimeoutException
    //   1431	1453	2710	java/net/SocketTimeoutException
    //   1481	1493	2710	java/net/SocketTimeoutException
    //   900	908	2733	java/net/SocketTimeoutException
  }
  
  public static int b()
  {
    Object localObject = RqdApplication.l();
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (((NetworkInfo)localObject).getType() == 0)
        {
          String str1 = android.net.Proxy.getDefaultHost();
          int i = android.net.Proxy.getDefaultPort();
          String str2 = ((NetworkInfo)localObject).getExtraInfo();
          f = ((NetworkInfo)localObject).getSubtype() + 200000;
          g.a("conn proxy host=" + str1 + "; port=" + i + "; mobile type=" + str2);
          g.d("conn proxy host=" + str1 + "; port=" + i + "; mobile type=" + str2);
          if ((str1 != null) && (-1 != i) && (str2 != null) && ((str2.toLowerCase(Locale.getDefault()).equals("cmwap")) || (str2.toLowerCase(Locale.getDefault()).equals("uniwap")) || (str2.toLowerCase(Locale.getDefault()).equals("3gwap")))) {
            return 3;
          }
          if ((str1 != null) && (-1 != i) && (str2 != null) && (str2.toLowerCase(Locale.getDefault()).equals("ctwap"))) {
            return 5;
          }
          return 2;
        }
        f = 100000;
        return 1;
      }
      return 6;
    }
    return 0;
  }
  
  public e a()
  {
    return this.a;
  }
  
  HttpURLConnection a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new URL(paramString1);
      switch (b())
      {
      case 5: 
        if (paramString1.getProtocol().toLowerCase().equals("https")) {
          paramString1 = (HttpsURLConnection)paramString1.openConnection();
        }
        break;
      case 6: 
        while (paramString2.equals("POST"))
        {
          paramString1.setConnectTimeout(this.d);
          paramString1.setReadTimeout(this.e);
          paramString1.setRequestMethod(paramString2);
          return paramString1;
          InetSocketAddress localInetSocketAddress = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
          paramString1 = (HttpURLConnection)paramString1.openConnection(new java.net.Proxy(Proxy.Type.HTTP, localInetSocketAddress));
          continue;
          this.a.a(10001, "conn is close");
          return null;
        }
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        this.a.a(10003, paramString1.toString() + "-" + paramString1.getMessage());
        paramString1 = null;
        break;
        paramString1 = (HttpURLConnection)paramString1.openConnection();
        continue;
        paramString1.setConnectTimeout(this.b);
        paramString1.setReadTimeout(this.c);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        this.a.a(10003, paramString1.toString() + "-" + paramString1.getMessage());
        paramString1.printStackTrace();
        paramString1 = null;
        break;
      }
    }
    return paramString1;
  }
  
  public byte[] a(String paramString)
  {
    int i = 0;
    byte[] arrayOfByte = null;
    for (;;)
    {
      if (i < 2)
      {
        arrayOfByte = a(paramString, "GET", null, null);
        if (arrayOfByte == null) {}
      }
      else
      {
        return arrayOfByte;
      }
      i += 1;
    }
  }
  
  public byte[] a(String paramString, ContentValues paramContentValues)
  {
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      Iterator localIterator = paramContentValues.iterator();
      paramContentValues = "";
      for (String str = "";; str = "&")
      {
        localObject = paramContentValues;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramContentValues = paramContentValues + str + (String)((Map.Entry)localObject).getKey() + "=" + ((Map.Entry)localObject).getValue();
      }
    }
    Object localObject = null;
    return a(paramString, "POST", (String)localObject, null);
  }
  
  public byte[] a(String paramString1, File paramFile, ContentValues paramContentValues, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      paramContentValues = paramContentValues.iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localStringBuffer.append("--");
        localStringBuffer.append("-----------------------x10d15y03m09d0");
        localStringBuffer.append("\r\n");
        localStringBuffer.append("Content-Disposition: form-data; name=\"");
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("\"\r\n\r\n");
        localStringBuffer.append(localEntry.getValue());
        localStringBuffer.append("\r\n");
      }
    }
    localStringBuffer.append("--");
    localStringBuffer.append("-----------------------x10d15y03m09d0");
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Content-Disposition: form-data; name=\"");
    localStringBuffer.append("log_file");
    localStringBuffer.append("\"; filename=\"");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("\"\r\n");
    localStringBuffer.append("Content-Type: application/octet-stream\r\n\r\n");
    g.c("testlogfile:" + localStringBuffer);
    return a(paramString1, "POST", localStringBuffer.toString(), paramFile);
  }
  
  public byte[] a(String paramString1, byte[] paramArrayOfByte, ContentValues paramContentValues, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      paramContentValues = paramContentValues.iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localStringBuffer.append("--");
        localStringBuffer.append("-----------------------x10d15y03m09d0");
        localStringBuffer.append("\r\n");
        localStringBuffer.append("Content-Disposition: form-data; name=\"");
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("\"\r\n\r\n");
        localStringBuffer.append(localEntry.getValue());
        localStringBuffer.append("\r\n");
      }
    }
    localStringBuffer.append("--");
    localStringBuffer.append("-----------------------x10d15y03m09d0");
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Content-Disposition: form-data; name=\"");
    localStringBuffer.append("data_file");
    localStringBuffer.append("\"; filename=\"");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("\"\r\n");
    localStringBuffer.append("Content-Type: application/octet-stream\r\n\r\n");
    g.c("requestUploadFileEnc:" + localStringBuffer);
    return a(paramString1, "POST", localStringBuffer.toString(), true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */