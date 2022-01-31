package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
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

public class gk
{
  public static int f = 300000;
  f a = new f();
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
    //   0: new 51	com/tencent/token/utils/v
    //   3: dup
    //   4: invokespecial 52	com/tencent/token/utils/v:<init>	()V
    //   7: astore 40
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 34
    //   18: aconst_null
    //   19: astore 26
    //   21: aconst_null
    //   22: astore 25
    //   24: aconst_null
    //   25: astore 27
    //   27: aconst_null
    //   28: astore 11
    //   30: aconst_null
    //   31: astore 32
    //   33: aconst_null
    //   34: astore 24
    //   36: aconst_null
    //   37: astore 35
    //   39: aconst_null
    //   40: astore 23
    //   42: aconst_null
    //   43: astore 22
    //   45: aconst_null
    //   46: astore 21
    //   48: aconst_null
    //   49: astore 28
    //   51: aconst_null
    //   52: astore 31
    //   54: aconst_null
    //   55: astore 20
    //   57: aload_0
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 55	com/tencent/token/gk:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
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
    //   149: ifnull +3033 -> 3182
    //   152: aload_3
    //   153: invokevirtual 72	java/lang/String:length	()I
    //   156: ifle +3026 -> 3182
    //   159: aconst_null
    //   160: astore 19
    //   162: aload 5
    //   164: ifnull +3012 -> 3176
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
    //   203: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
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
    //   270: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
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
    //   336: astore 18
    //   338: aload 14
    //   340: astore 16
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
    //   375: astore 18
    //   377: aload 14
    //   379: astore 16
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
    //   410: astore 18
    //   412: aload 14
    //   414: astore 16
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
    //   453: astore 18
    //   455: aload 14
    //   457: astore 16
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
    //   483: aload 24
    //   485: astore 10
    //   487: aload 20
    //   489: astore 11
    //   491: aload 5
    //   493: invokevirtual 157	java/net/SocketTimeoutException:printStackTrace	()V
    //   496: aload_0
    //   497: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
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
    //   534: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   537: invokestatic 171	com/tencent/token/ch:a	()Lcom/tencent/token/ch;
    //   540: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   543: getstatic 18	com/tencent/token/gk:f	I
    //   546: invokevirtual 179	com/tencent/token/ch:a	(JI)V
    //   549: aload 5
    //   551: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   554: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   557: aload 5
    //   559: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   562: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
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
    //   623: invokevirtual 194	com/tencent/token/utils/v:a	()J
    //   626: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: ldc 196
    //   631: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_1
    //   635: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 198	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   644: new 74	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   651: ldc 192
    //   653: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 40
    //   658: invokevirtual 194	com/tencent/token/utils/v:a	()J
    //   661: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   664: ldc 196
    //   666: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: astore_2
    //   670: aload_1
    //   671: ldc 200
    //   673: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   676: iconst_m1
    //   677: if_icmpne +2029 -> 2706
    //   680: aload_2
    //   681: aload_1
    //   682: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
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
    //   716: astore 18
    //   718: aload 14
    //   720: astore 16
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
    //   754: astore 18
    //   756: aload 14
    //   758: astore 16
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
    //   789: astore 18
    //   791: aload 14
    //   793: astore 16
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
    //   822: astore 18
    //   824: aload 14
    //   826: astore 16
    //   828: aload 14
    //   830: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   833: aconst_null
    //   834: astore 30
    //   836: aconst_null
    //   837: astore 19
    //   839: aconst_null
    //   840: astore 33
    //   842: aconst_null
    //   843: astore 36
    //   845: aconst_null
    //   846: astore 38
    //   848: aconst_null
    //   849: astore 39
    //   851: aconst_null
    //   852: astore 37
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
    //   873: aload 38
    //   875: astore 17
    //   877: aload 39
    //   879: astore 18
    //   881: aload 37
    //   883: astore 16
    //   885: aload 9
    //   887: invokevirtual 213	java/net/HttpURLConnection:getResponseCode	()I
    //   890: istore 6
    //   892: iload 6
    //   894: sipush 200
    //   897: if_icmpeq +17 -> 914
    //   900: iload 6
    //   902: sipush 206
    //   905: if_icmpeq +9 -> 914
    //   908: iload 6
    //   910: iconst_m1
    //   911: if_icmpne +763 -> 1674
    //   914: aload 31
    //   916: astore 13
    //   918: aload 32
    //   920: astore 12
    //   922: aload 36
    //   924: astore 10
    //   926: aload 9
    //   928: astore 11
    //   930: aload 38
    //   932: astore 17
    //   934: aload 39
    //   936: astore 18
    //   938: aload 37
    //   940: astore 16
    //   942: aload 9
    //   944: invokevirtual 216	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   947: astore 14
    //   949: aload 14
    //   951: ifnonnull +425 -> 1376
    //   954: ldc 218
    //   956: astore 14
    //   958: aload 31
    //   960: astore 13
    //   962: aload 32
    //   964: astore 12
    //   966: aload 36
    //   968: astore 10
    //   970: aload 9
    //   972: astore 11
    //   974: aload 38
    //   976: astore 17
    //   978: aload 39
    //   980: astore 18
    //   982: aload 37
    //   984: astore 16
    //   986: new 74	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   993: ldc 220
    //   995: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload 14
    //   1000: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc 222
    //   1005: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: aload_2
    //   1009: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: ldc 224
    //   1014: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload_1
    //   1018: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 198	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   1027: aload 31
    //   1029: astore 13
    //   1031: aload 32
    //   1033: astore 12
    //   1035: aload 36
    //   1037: astore 10
    //   1039: aload 9
    //   1041: astore 11
    //   1043: aload 38
    //   1045: astore 17
    //   1047: aload 39
    //   1049: astore 18
    //   1051: aload 37
    //   1053: astore 16
    //   1055: new 74	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1062: ldc 220
    //   1064: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: aload 14
    //   1069: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: ldc 222
    //   1074: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_2
    //   1078: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc 224
    //   1083: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: astore 34
    //   1088: aload 31
    //   1090: astore 13
    //   1092: aload 32
    //   1094: astore 12
    //   1096: aload 36
    //   1098: astore 10
    //   1100: aload 9
    //   1102: astore 11
    //   1104: aload 38
    //   1106: astore 17
    //   1108: aload 39
    //   1110: astore 18
    //   1112: aload 37
    //   1114: astore 16
    //   1116: aload_1
    //   1117: ldc 200
    //   1119: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1122: iconst_m1
    //   1123: if_icmpne +291 -> 1414
    //   1126: aload_1
    //   1127: astore 15
    //   1129: aload 31
    //   1131: astore 13
    //   1133: aload 32
    //   1135: astore 12
    //   1137: aload 36
    //   1139: astore 10
    //   1141: aload 9
    //   1143: astore 11
    //   1145: aload 38
    //   1147: astore 17
    //   1149: aload 39
    //   1151: astore 18
    //   1153: aload 37
    //   1155: astore 16
    //   1157: aload 34
    //   1159: aload 15
    //   1161: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1170: iload 4
    //   1172: ifeq +310 -> 1482
    //   1175: aload 31
    //   1177: astore 13
    //   1179: aload 32
    //   1181: astore 12
    //   1183: aload 36
    //   1185: astore 10
    //   1187: aload 9
    //   1189: astore 11
    //   1191: aload 38
    //   1193: astore 17
    //   1195: aload 39
    //   1197: astore 18
    //   1199: aload 37
    //   1201: astore 16
    //   1203: aload 14
    //   1205: ldc 226
    //   1207: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1210: iconst_m1
    //   1211: if_icmpne +42 -> 1253
    //   1214: aload 31
    //   1216: astore 13
    //   1218: aload 32
    //   1220: astore 12
    //   1222: aload 36
    //   1224: astore 10
    //   1226: aload 9
    //   1228: astore 11
    //   1230: aload 38
    //   1232: astore 17
    //   1234: aload 39
    //   1236: astore 18
    //   1238: aload 37
    //   1240: astore 16
    //   1242: aload 14
    //   1244: ldc 228
    //   1246: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1249: iconst_m1
    //   1250: if_icmpeq +232 -> 1482
    //   1253: aload 31
    //   1255: astore 13
    //   1257: aload 32
    //   1259: astore 12
    //   1261: aload 36
    //   1263: astore 10
    //   1265: aload 9
    //   1267: astore 11
    //   1269: aload 38
    //   1271: astore 17
    //   1273: aload 39
    //   1275: astore 18
    //   1277: aload 37
    //   1279: astore 16
    //   1281: ldc 230
    //   1283: invokestatic 232	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   1286: aload 31
    //   1288: astore 13
    //   1290: aload 32
    //   1292: astore 12
    //   1294: aload 36
    //   1296: astore 10
    //   1298: aload 9
    //   1300: astore 11
    //   1302: aload 38
    //   1304: astore 17
    //   1306: aload 39
    //   1308: astore 18
    //   1310: aload 37
    //   1312: astore 16
    //   1314: aload_0
    //   1315: aload_1
    //   1316: aload_2
    //   1317: aload_3
    //   1318: aload 5
    //   1320: invokespecial 234	com/tencent/token/gk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)[B
    //   1323: astore_2
    //   1324: aload_2
    //   1325: astore_1
    //   1326: iconst_0
    //   1327: ifeq +11 -> 1338
    //   1330: new 57	java/lang/NullPointerException
    //   1333: dup
    //   1334: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1337: athrow
    //   1338: iconst_0
    //   1339: ifeq +11 -> 1350
    //   1342: new 57	java/lang/NullPointerException
    //   1345: dup
    //   1346: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1349: athrow
    //   1350: iconst_0
    //   1351: ifeq +11 -> 1362
    //   1354: new 57	java/lang/NullPointerException
    //   1357: dup
    //   1358: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1361: athrow
    //   1362: aload_1
    //   1363: astore_2
    //   1364: aload 9
    //   1366: ifnull -1244 -> 122
    //   1369: aload 9
    //   1371: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1374: aload_1
    //   1375: areturn
    //   1376: aload 31
    //   1378: astore 13
    //   1380: aload 32
    //   1382: astore 12
    //   1384: aload 36
    //   1386: astore 10
    //   1388: aload 9
    //   1390: astore 11
    //   1392: aload 38
    //   1394: astore 17
    //   1396: aload 39
    //   1398: astore 18
    //   1400: aload 37
    //   1402: astore 16
    //   1404: aload 14
    //   1406: invokevirtual 237	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1409: astore 14
    //   1411: goto -453 -> 958
    //   1414: aload 31
    //   1416: astore 13
    //   1418: aload 32
    //   1420: astore 12
    //   1422: aload 36
    //   1424: astore 10
    //   1426: aload 9
    //   1428: astore 11
    //   1430: aload 38
    //   1432: astore 17
    //   1434: aload 39
    //   1436: astore 18
    //   1438: aload 37
    //   1440: astore 16
    //   1442: aload_1
    //   1443: iconst_0
    //   1444: aload_1
    //   1445: ldc 200
    //   1447: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1450: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   1453: astore 15
    //   1455: goto -326 -> 1129
    //   1458: astore_2
    //   1459: aload_2
    //   1460: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1463: goto -125 -> 1338
    //   1466: astore_2
    //   1467: aload_2
    //   1468: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1471: goto -121 -> 1350
    //   1474: astore_2
    //   1475: aload_2
    //   1476: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1479: goto -117 -> 1362
    //   1482: aload 31
    //   1484: astore 13
    //   1486: aload 32
    //   1488: astore 12
    //   1490: aload 36
    //   1492: astore 10
    //   1494: aload 9
    //   1496: astore 11
    //   1498: aload 38
    //   1500: astore 17
    //   1502: aload 39
    //   1504: astore 18
    //   1506: aload 37
    //   1508: astore 16
    //   1510: aload 9
    //   1512: invokevirtual 245	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1515: astore_2
    //   1516: new 183	java/io/ByteArrayOutputStream
    //   1519: dup
    //   1520: invokespecial 246	java/io/ByteArrayOutputStream:<init>	()V
    //   1523: astore_3
    //   1524: aload_2
    //   1525: invokevirtual 248	java/io/InputStream:read	()I
    //   1528: istore 6
    //   1530: iload 6
    //   1532: iconst_m1
    //   1533: if_icmpeq +12 -> 1545
    //   1536: aload_3
    //   1537: iload 6
    //   1539: invokevirtual 251	java/io/ByteArrayOutputStream:write	(I)V
    //   1542: goto -18 -> 1524
    //   1545: aload_3
    //   1546: invokevirtual 252	java/io/ByteArrayOutputStream:flush	()V
    //   1549: aload_3
    //   1550: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1553: astore 5
    //   1555: aload 5
    //   1557: ifnull +9 -> 1566
    //   1560: aload 5
    //   1562: arraylength
    //   1563: ifgt +73 -> 1636
    //   1566: aload_0
    //   1567: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1570: ldc_w 256
    //   1573: invokevirtual 258	com/tencent/token/global/f:b	(I)V
    //   1576: aconst_null
    //   1577: astore 5
    //   1579: aload_3
    //   1580: astore 10
    //   1582: aload_2
    //   1583: astore_3
    //   1584: aload 5
    //   1586: astore_2
    //   1587: aload 10
    //   1589: ifnull +8 -> 1597
    //   1592: aload 10
    //   1594: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1597: aload_3
    //   1598: ifnull +7 -> 1605
    //   1601: aload_3
    //   1602: invokevirtual 189	java/io/InputStream:close	()V
    //   1605: iconst_0
    //   1606: ifeq +11 -> 1617
    //   1609: new 57	java/lang/NullPointerException
    //   1612: dup
    //   1613: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1616: athrow
    //   1617: aload_2
    //   1618: astore 5
    //   1620: aload 9
    //   1622: ifnull -1013 -> 609
    //   1625: aload 9
    //   1627: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1630: aload_2
    //   1631: astore 5
    //   1633: goto -1024 -> 609
    //   1636: aload_0
    //   1637: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1640: invokevirtual 260	com/tencent/token/global/f:c	()V
    //   1643: goto -64 -> 1579
    //   1646: astore 13
    //   1648: aload_3
    //   1649: astore 11
    //   1651: aload_2
    //   1652: astore 10
    //   1654: aconst_null
    //   1655: astore 12
    //   1657: aload 9
    //   1659: astore_3
    //   1660: aload 5
    //   1662: astore_2
    //   1663: aload 13
    //   1665: astore 5
    //   1667: aload 12
    //   1669: astore 9
    //   1671: goto -1180 -> 491
    //   1674: aload 31
    //   1676: astore 13
    //   1678: aload 32
    //   1680: astore 12
    //   1682: aload 36
    //   1684: astore 10
    //   1686: aload 9
    //   1688: astore 11
    //   1690: aload 38
    //   1692: astore 17
    //   1694: aload 39
    //   1696: astore 18
    //   1698: aload 37
    //   1700: astore 16
    //   1702: aload_0
    //   1703: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1706: sipush 10005
    //   1709: new 74	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1716: ldc_w 262
    //   1719: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: iload 6
    //   1724: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1727: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1730: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   1733: aload 31
    //   1735: astore 13
    //   1737: aload 32
    //   1739: astore 12
    //   1741: aload 36
    //   1743: astore 10
    //   1745: aload 9
    //   1747: astore 11
    //   1749: aload 38
    //   1751: astore 17
    //   1753: aload 39
    //   1755: astore 18
    //   1757: aload 37
    //   1759: astore 16
    //   1761: new 74	java/lang/StringBuilder
    //   1764: dup
    //   1765: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1768: ldc_w 264
    //   1771: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload_1
    //   1775: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: ldc_w 266
    //   1781: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: iload 6
    //   1786: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1789: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1792: invokestatic 232	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   1795: aload 31
    //   1797: astore 13
    //   1799: aload 32
    //   1801: astore 12
    //   1803: aload 36
    //   1805: astore 10
    //   1807: aload 9
    //   1809: astore 11
    //   1811: aload 38
    //   1813: astore 17
    //   1815: aload 39
    //   1817: astore 18
    //   1819: aload 37
    //   1821: astore 16
    //   1823: new 74	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1830: ldc_w 268
    //   1833: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: astore_3
    //   1837: aload 31
    //   1839: astore 13
    //   1841: aload 32
    //   1843: astore 12
    //   1845: aload 36
    //   1847: astore 10
    //   1849: aload 9
    //   1851: astore 11
    //   1853: aload 38
    //   1855: astore 17
    //   1857: aload 39
    //   1859: astore 18
    //   1861: aload 37
    //   1863: astore 16
    //   1865: aload_1
    //   1866: ldc 200
    //   1868: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1871: iconst_m1
    //   1872: if_icmpne +67 -> 1939
    //   1875: aload_1
    //   1876: astore_2
    //   1877: aload 31
    //   1879: astore 13
    //   1881: aload 32
    //   1883: astore 12
    //   1885: aload 36
    //   1887: astore 10
    //   1889: aload 9
    //   1891: astore 11
    //   1893: aload 38
    //   1895: astore 17
    //   1897: aload 39
    //   1899: astore 18
    //   1901: aload 37
    //   1903: astore 16
    //   1905: aload_3
    //   1906: aload_2
    //   1907: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: ldc_w 266
    //   1913: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: iload 6
    //   1918: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1921: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1924: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1927: aconst_null
    //   1928: astore_2
    //   1929: aload 35
    //   1931: astore 10
    //   1933: aload 34
    //   1935: astore_3
    //   1936: goto -349 -> 1587
    //   1939: aload 31
    //   1941: astore 13
    //   1943: aload 32
    //   1945: astore 12
    //   1947: aload 36
    //   1949: astore 10
    //   1951: aload 9
    //   1953: astore 11
    //   1955: aload 38
    //   1957: astore 17
    //   1959: aload 39
    //   1961: astore 18
    //   1963: aload 37
    //   1965: astore 16
    //   1967: aload_1
    //   1968: iconst_0
    //   1969: aload_1
    //   1970: ldc 200
    //   1972: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1975: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   1978: astore_2
    //   1979: goto -102 -> 1877
    //   1982: astore 5
    //   1984: aload 5
    //   1986: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1989: goto -392 -> 1597
    //   1992: astore_3
    //   1993: aload_3
    //   1994: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1997: goto -392 -> 1605
    //   2000: astore_3
    //   2001: aload_3
    //   2002: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2005: goto -388 -> 1617
    //   2008: astore 5
    //   2010: aload 5
    //   2012: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2015: goto -1440 -> 575
    //   2018: astore 5
    //   2020: aload 5
    //   2022: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2025: goto -1440 -> 585
    //   2028: astore 5
    //   2030: aload 5
    //   2032: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2035: goto -1440 -> 595
    //   2038: astore_3
    //   2039: aconst_null
    //   2040: astore 9
    //   2042: aconst_null
    //   2043: astore 14
    //   2045: aconst_null
    //   2046: astore_2
    //   2047: aload 26
    //   2049: astore 5
    //   2051: aload 23
    //   2053: astore 15
    //   2055: aload 15
    //   2057: astore 13
    //   2059: aload 5
    //   2061: astore 12
    //   2063: aload 14
    //   2065: astore 10
    //   2067: aload 9
    //   2069: astore 11
    //   2071: aload_3
    //   2072: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   2075: aload 15
    //   2077: astore 13
    //   2079: aload 5
    //   2081: astore 12
    //   2083: aload 14
    //   2085: astore 10
    //   2087: aload 9
    //   2089: astore 11
    //   2091: aload_0
    //   2092: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   2095: sipush 10003
    //   2098: new 74	java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2105: aload_3
    //   2106: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   2109: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2112: ldc 160
    //   2114: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: aload_3
    //   2118: invokevirtual 271	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2121: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2127: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   2130: aload 15
    //   2132: astore 13
    //   2134: aload 5
    //   2136: astore 12
    //   2138: aload 14
    //   2140: astore 10
    //   2142: aload 9
    //   2144: astore 11
    //   2146: aload_3
    //   2147: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   2150: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   2153: aload 15
    //   2155: astore 13
    //   2157: aload 5
    //   2159: astore 12
    //   2161: aload 14
    //   2163: astore 10
    //   2165: aload 9
    //   2167: astore 11
    //   2169: aload_3
    //   2170: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   2173: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   2176: aload 15
    //   2178: ifnull +8 -> 2186
    //   2181: aload 15
    //   2183: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2186: aload 5
    //   2188: ifnull +8 -> 2196
    //   2191: aload 5
    //   2193: invokevirtual 189	java/io/InputStream:close	()V
    //   2196: aload 14
    //   2198: ifnull +8 -> 2206
    //   2201: aload 14
    //   2203: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2206: aload_2
    //   2207: astore 5
    //   2209: aload 9
    //   2211: ifnull -1602 -> 609
    //   2214: aload 9
    //   2216: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2219: aload_2
    //   2220: astore 5
    //   2222: goto -1613 -> 609
    //   2225: astore_3
    //   2226: aload_3
    //   2227: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2230: goto -44 -> 2186
    //   2233: astore_3
    //   2234: aload_3
    //   2235: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2238: goto -42 -> 2196
    //   2241: astore_3
    //   2242: aload_3
    //   2243: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2246: goto -40 -> 2206
    //   2249: astore_3
    //   2250: aconst_null
    //   2251: astore 9
    //   2253: aconst_null
    //   2254: astore 14
    //   2256: aconst_null
    //   2257: astore_2
    //   2258: aload 25
    //   2260: astore 5
    //   2262: aload 22
    //   2264: astore 15
    //   2266: aload 15
    //   2268: astore 13
    //   2270: aload 5
    //   2272: astore 12
    //   2274: aload 14
    //   2276: astore 10
    //   2278: aload 9
    //   2280: astore 11
    //   2282: aload_3
    //   2283: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2286: aload 15
    //   2288: astore 13
    //   2290: aload 5
    //   2292: astore 12
    //   2294: aload 14
    //   2296: astore 10
    //   2298: aload 9
    //   2300: astore 11
    //   2302: aload_0
    //   2303: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   2306: sipush 10003
    //   2309: new 74	java/lang/StringBuilder
    //   2312: dup
    //   2313: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2316: aload_3
    //   2317: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   2320: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: ldc 160
    //   2325: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2328: aload_3
    //   2329: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2332: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2335: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2338: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   2341: aload 15
    //   2343: astore 13
    //   2345: aload 5
    //   2347: astore 12
    //   2349: aload 14
    //   2351: astore 10
    //   2353: aload 9
    //   2355: astore 11
    //   2357: aload_3
    //   2358: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   2361: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   2364: aload 15
    //   2366: astore 13
    //   2368: aload 5
    //   2370: astore 12
    //   2372: aload 14
    //   2374: astore 10
    //   2376: aload 9
    //   2378: astore 11
    //   2380: aload_3
    //   2381: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   2384: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   2387: aload 15
    //   2389: ifnull +8 -> 2397
    //   2392: aload 15
    //   2394: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2397: aload 5
    //   2399: ifnull +8 -> 2407
    //   2402: aload 5
    //   2404: invokevirtual 189	java/io/InputStream:close	()V
    //   2407: aload 14
    //   2409: ifnull +8 -> 2417
    //   2412: aload 14
    //   2414: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2417: aload_2
    //   2418: astore 5
    //   2420: aload 9
    //   2422: ifnull -1813 -> 609
    //   2425: aload 9
    //   2427: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2430: aload_2
    //   2431: astore 5
    //   2433: goto -1824 -> 609
    //   2436: astore_3
    //   2437: aload_3
    //   2438: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2441: goto -44 -> 2397
    //   2444: astore_3
    //   2445: aload_3
    //   2446: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2449: goto -42 -> 2407
    //   2452: astore_3
    //   2453: aload_3
    //   2454: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2457: goto -40 -> 2417
    //   2460: astore_3
    //   2461: aconst_null
    //   2462: astore 9
    //   2464: aconst_null
    //   2465: astore 14
    //   2467: aconst_null
    //   2468: astore_2
    //   2469: aload 27
    //   2471: astore 5
    //   2473: aload 21
    //   2475: astore 15
    //   2477: aload 15
    //   2479: astore 13
    //   2481: aload 5
    //   2483: astore 12
    //   2485: aload 14
    //   2487: astore 10
    //   2489: aload 9
    //   2491: astore 11
    //   2493: aload_3
    //   2494: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   2497: aload 15
    //   2499: astore 13
    //   2501: aload 5
    //   2503: astore 12
    //   2505: aload 14
    //   2507: astore 10
    //   2509: aload 9
    //   2511: astore 11
    //   2513: aload_0
    //   2514: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   2517: sipush 10003
    //   2520: new 74	java/lang/StringBuilder
    //   2523: dup
    //   2524: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   2527: aload_3
    //   2528: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2531: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: ldc 160
    //   2536: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: aload_3
    //   2540: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2543: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2549: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   2552: aload 15
    //   2554: ifnull +8 -> 2562
    //   2557: aload 15
    //   2559: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2562: aload 5
    //   2564: ifnull +8 -> 2572
    //   2567: aload 5
    //   2569: invokevirtual 189	java/io/InputStream:close	()V
    //   2572: aload 14
    //   2574: ifnull +8 -> 2582
    //   2577: aload 14
    //   2579: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2582: aload_2
    //   2583: astore 5
    //   2585: aload 9
    //   2587: ifnull -1978 -> 609
    //   2590: aload 9
    //   2592: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2595: aload_2
    //   2596: astore 5
    //   2598: goto -1989 -> 609
    //   2601: astore_3
    //   2602: aload_3
    //   2603: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2606: goto -44 -> 2562
    //   2609: astore_3
    //   2610: aload_3
    //   2611: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2614: goto -42 -> 2572
    //   2617: astore_3
    //   2618: aload_3
    //   2619: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2622: goto -40 -> 2582
    //   2625: astore_1
    //   2626: aconst_null
    //   2627: astore 9
    //   2629: aconst_null
    //   2630: astore 10
    //   2632: aload 11
    //   2634: astore 12
    //   2636: aload 28
    //   2638: astore 13
    //   2640: aload 13
    //   2642: ifnull +8 -> 2650
    //   2645: aload 13
    //   2647: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2650: aload 12
    //   2652: ifnull +8 -> 2660
    //   2655: aload 12
    //   2657: invokevirtual 189	java/io/InputStream:close	()V
    //   2660: aload 10
    //   2662: ifnull +8 -> 2670
    //   2665: aload 10
    //   2667: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2670: aload 9
    //   2672: ifnull +8 -> 2680
    //   2675: aload 9
    //   2677: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2680: aload_1
    //   2681: athrow
    //   2682: astore_2
    //   2683: aload_2
    //   2684: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2687: goto -37 -> 2650
    //   2690: astore_2
    //   2691: aload_2
    //   2692: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2695: goto -35 -> 2660
    //   2698: astore_2
    //   2699: aload_2
    //   2700: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2703: goto -33 -> 2670
    //   2706: aload_1
    //   2707: iconst_0
    //   2708: aload_1
    //   2709: ldc 200
    //   2711: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2714: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   2717: astore_1
    //   2718: goto -2038 -> 680
    //   2721: astore_1
    //   2722: aconst_null
    //   2723: astore 10
    //   2725: aload 28
    //   2727: astore 13
    //   2729: aload 11
    //   2731: astore 12
    //   2733: goto -93 -> 2640
    //   2736: astore_1
    //   2737: aload 11
    //   2739: astore 9
    //   2741: goto -101 -> 2640
    //   2744: astore_1
    //   2745: aload 28
    //   2747: astore 13
    //   2749: aload_2
    //   2750: astore 12
    //   2752: aload 33
    //   2754: astore 10
    //   2756: goto -116 -> 2640
    //   2759: astore_1
    //   2760: aload_3
    //   2761: astore 13
    //   2763: aload_2
    //   2764: astore 12
    //   2766: aload 33
    //   2768: astore 10
    //   2770: goto -130 -> 2640
    //   2773: astore_1
    //   2774: aload 11
    //   2776: astore 13
    //   2778: aload 10
    //   2780: astore 12
    //   2782: aload 9
    //   2784: astore 10
    //   2786: aload_3
    //   2787: astore 9
    //   2789: goto -149 -> 2640
    //   2792: astore_3
    //   2793: aconst_null
    //   2794: astore 14
    //   2796: aconst_null
    //   2797: astore_2
    //   2798: aload 21
    //   2800: astore 15
    //   2802: aload 27
    //   2804: astore 5
    //   2806: goto -329 -> 2477
    //   2809: astore_3
    //   2810: aconst_null
    //   2811: astore_2
    //   2812: aload 21
    //   2814: astore 15
    //   2816: aload 27
    //   2818: astore 5
    //   2820: aload 17
    //   2822: astore 14
    //   2824: goto -347 -> 2477
    //   2827: astore_3
    //   2828: aload_2
    //   2829: astore 5
    //   2831: aconst_null
    //   2832: astore_2
    //   2833: aload 21
    //   2835: astore 15
    //   2837: aload 19
    //   2839: astore 14
    //   2841: goto -364 -> 2477
    //   2844: astore 10
    //   2846: aload_3
    //   2847: astore 15
    //   2849: aload_2
    //   2850: astore 5
    //   2852: aconst_null
    //   2853: astore_2
    //   2854: aload 10
    //   2856: astore_3
    //   2857: aload 19
    //   2859: astore 14
    //   2861: goto -384 -> 2477
    //   2864: astore 11
    //   2866: aload_3
    //   2867: astore 15
    //   2869: aload_2
    //   2870: astore 10
    //   2872: aload 5
    //   2874: astore_2
    //   2875: aload 11
    //   2877: astore_3
    //   2878: aload 10
    //   2880: astore 5
    //   2882: aload 19
    //   2884: astore 14
    //   2886: goto -409 -> 2477
    //   2889: astore_3
    //   2890: aconst_null
    //   2891: astore 14
    //   2893: aconst_null
    //   2894: astore_2
    //   2895: aload 22
    //   2897: astore 15
    //   2899: aload 25
    //   2901: astore 5
    //   2903: goto -637 -> 2266
    //   2906: astore_3
    //   2907: aconst_null
    //   2908: astore_2
    //   2909: aload 22
    //   2911: astore 15
    //   2913: aload 25
    //   2915: astore 5
    //   2917: aload 18
    //   2919: astore 14
    //   2921: goto -655 -> 2266
    //   2924: astore_3
    //   2925: aload_2
    //   2926: astore 5
    //   2928: aconst_null
    //   2929: astore_2
    //   2930: aload 22
    //   2932: astore 15
    //   2934: aload 30
    //   2936: astore 14
    //   2938: goto -672 -> 2266
    //   2941: astore 10
    //   2943: aload_3
    //   2944: astore 15
    //   2946: aload_2
    //   2947: astore 5
    //   2949: aconst_null
    //   2950: astore_2
    //   2951: aload 10
    //   2953: astore_3
    //   2954: aload 30
    //   2956: astore 14
    //   2958: goto -692 -> 2266
    //   2961: astore 11
    //   2963: aload_3
    //   2964: astore 15
    //   2966: aload_2
    //   2967: astore 10
    //   2969: aload 5
    //   2971: astore_2
    //   2972: aload 11
    //   2974: astore_3
    //   2975: aload 10
    //   2977: astore 5
    //   2979: aload 30
    //   2981: astore 14
    //   2983: goto -717 -> 2266
    //   2986: astore_3
    //   2987: aconst_null
    //   2988: astore 14
    //   2990: aconst_null
    //   2991: astore_2
    //   2992: aload 23
    //   2994: astore 15
    //   2996: aload 26
    //   2998: astore 5
    //   3000: goto -945 -> 2055
    //   3003: astore_3
    //   3004: aconst_null
    //   3005: astore_2
    //   3006: aload 23
    //   3008: astore 15
    //   3010: aload 26
    //   3012: astore 5
    //   3014: aload 16
    //   3016: astore 14
    //   3018: goto -963 -> 2055
    //   3021: astore_3
    //   3022: aload_2
    //   3023: astore 5
    //   3025: aconst_null
    //   3026: astore_2
    //   3027: aload 23
    //   3029: astore 15
    //   3031: aload 29
    //   3033: astore 14
    //   3035: goto -980 -> 2055
    //   3038: astore 10
    //   3040: aload_3
    //   3041: astore 15
    //   3043: aload_2
    //   3044: astore 5
    //   3046: aconst_null
    //   3047: astore_2
    //   3048: aload 10
    //   3050: astore_3
    //   3051: aload 29
    //   3053: astore 14
    //   3055: goto -1000 -> 2055
    //   3058: astore 11
    //   3060: aload_3
    //   3061: astore 15
    //   3063: aload_2
    //   3064: astore 10
    //   3066: aload 5
    //   3068: astore_2
    //   3069: aload 11
    //   3071: astore_3
    //   3072: aload 10
    //   3074: astore 5
    //   3076: aload 29
    //   3078: astore 14
    //   3080: goto -1025 -> 2055
    //   3083: astore 5
    //   3085: aconst_null
    //   3086: astore_2
    //   3087: aload 20
    //   3089: astore 11
    //   3091: aload 24
    //   3093: astore 10
    //   3095: aload 12
    //   3097: astore 9
    //   3099: aload 13
    //   3101: astore_3
    //   3102: goto -2611 -> 491
    //   3105: astore 5
    //   3107: aload 9
    //   3109: astore_3
    //   3110: aconst_null
    //   3111: astore_2
    //   3112: aload 20
    //   3114: astore 11
    //   3116: aload 24
    //   3118: astore 10
    //   3120: aload 12
    //   3122: astore 9
    //   3124: goto -2633 -> 491
    //   3127: astore 5
    //   3129: aconst_null
    //   3130: astore 12
    //   3132: aload 9
    //   3134: astore_3
    //   3135: aconst_null
    //   3136: astore_2
    //   3137: aload 20
    //   3139: astore 11
    //   3141: aload 24
    //   3143: astore 10
    //   3145: aload 12
    //   3147: astore 9
    //   3149: goto -2658 -> 491
    //   3152: astore 5
    //   3154: aload_2
    //   3155: astore 10
    //   3157: aconst_null
    //   3158: astore 12
    //   3160: aload 9
    //   3162: astore_3
    //   3163: aconst_null
    //   3164: astore_2
    //   3165: aload 20
    //   3167: astore 11
    //   3169: aload 12
    //   3171: astore 9
    //   3173: goto -2682 -> 491
    //   3176: aconst_null
    //   3177: astore 15
    //   3179: goto -2885 -> 294
    //   3182: goto -2349 -> 833
    //   3185: astore 5
    //   3187: aload_3
    //   3188: astore 11
    //   3190: aload_2
    //   3191: astore 10
    //   3193: aconst_null
    //   3194: astore 12
    //   3196: aload 9
    //   3198: astore_3
    //   3199: aconst_null
    //   3200: astore_2
    //   3201: aload 12
    //   3203: astore 9
    //   3205: goto -2714 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3208	0	this	gk
    //   0	3208	1	paramString1	String
    //   0	3208	2	paramString2	String
    //   0	3208	3	paramString3	String
    //   0	3208	4	paramBoolean	boolean
    //   0	3208	5	paramFile	File
    //   423	1494	6	i	int
    //   248	39	7	l	long
    //   63	3141	9	localObject1	Object
    //   324	2461	10	localObject2	Object
    //   2844	11	10	localThrowable1	java.lang.Throwable
    //   2870	9	10	str1	String
    //   2941	11	10	localException1	Exception
    //   2967	9	10	str2	String
    //   3038	11	10	localIOException1	IOException
    //   3064	128	10	localObject3	Object
    //   28	2747	11	localObject4	Object
    //   2864	12	11	localThrowable2	java.lang.Throwable
    //   2961	12	11	localException2	Exception
    //   3058	12	11	localIOException2	IOException
    //   3089	100	11	localObject5	Object
    //   13	3189	12	localObject6	Object
    //   10	1475	13	localObject7	Object
    //   1646	18	13	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1676	1424	13	localObject8	Object
    //   312	2767	14	localObject9	Object
    //   211	2967	15	localObject10	Object
    //   340	2675	16	localObject11	Object
    //   332	2489	17	localObject12	Object
    //   336	2582	18	localObject13	Object
    //   160	2723	19	localFileInputStream	java.io.FileInputStream
    //   55	3111	20	localObject14	Object
    //   46	2788	21	localObject15	Object
    //   43	2888	22	localObject16	Object
    //   40	2988	23	localObject17	Object
    //   34	3108	24	localObject18	Object
    //   22	2892	25	localObject19	Object
    //   19	2992	26	localObject20	Object
    //   25	2792	27	localObject21	Object
    //   49	2697	28	localObject22	Object
    //   386	2691	29	arrayOfByte	byte[]
    //   834	2146	30	localObject23	Object
    //   52	1888	31	localObject24	Object
    //   31	1913	32	localObject25	Object
    //   840	1927	33	localObject26	Object
    //   16	1918	34	localStringBuilder	java.lang.StringBuilder
    //   37	1893	35	localObject27	Object
    //   843	1105	36	localObject28	Object
    //   852	1112	37	localObject29	Object
    //   846	1110	38	localObject30	Object
    //   849	1111	39	localObject31	Object
    //   7	650	40	localv	com.tencent.token.utils.v
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
    //   1330	1338	1458	java/lang/Exception
    //   1342	1350	1466	java/lang/Exception
    //   1354	1362	1474	java/lang/Exception
    //   1560	1566	1646	java/net/SocketTimeoutException
    //   1566	1576	1646	java/net/SocketTimeoutException
    //   1636	1643	1646	java/net/SocketTimeoutException
    //   1592	1597	1982	java/lang/Exception
    //   1601	1605	1992	java/lang/Exception
    //   1609	1617	2000	java/lang/Exception
    //   570	575	2008	java/lang/Exception
    //   580	585	2018	java/lang/Exception
    //   590	595	2028	java/lang/Exception
    //   57	65	2038	java/io/IOException
    //   2181	2186	2225	java/lang/Exception
    //   2191	2196	2233	java/lang/Exception
    //   2201	2206	2241	java/lang/Exception
    //   57	65	2249	java/lang/Exception
    //   2392	2397	2436	java/lang/Exception
    //   2402	2407	2444	java/lang/Exception
    //   2412	2417	2452	java/lang/Exception
    //   57	65	2460	java/lang/Throwable
    //   2557	2562	2601	java/lang/Exception
    //   2567	2572	2609	java/lang/Exception
    //   2577	2582	2617	java/lang/Exception
    //   57	65	2625	finally
    //   2645	2650	2682	java/lang/Exception
    //   2655	2660	2690	java/lang/Exception
    //   2665	2670	2698	java/lang/Exception
    //   152	159	2721	finally
    //   167	294	2721	finally
    //   294	314	2721	finally
    //   342	348	2736	finally
    //   381	388	2736	finally
    //   416	425	2736	finally
    //   459	469	2736	finally
    //   722	732	2736	finally
    //   760	767	2736	finally
    //   795	800	2736	finally
    //   828	833	2736	finally
    //   885	892	2736	finally
    //   942	949	2736	finally
    //   986	1027	2736	finally
    //   1055	1088	2736	finally
    //   1116	1126	2736	finally
    //   1157	1170	2736	finally
    //   1203	1214	2736	finally
    //   1242	1253	2736	finally
    //   1281	1286	2736	finally
    //   1314	1324	2736	finally
    //   1404	1411	2736	finally
    //   1442	1455	2736	finally
    //   1510	1516	2736	finally
    //   1702	1733	2736	finally
    //   1761	1795	2736	finally
    //   1823	1837	2736	finally
    //   1865	1875	2736	finally
    //   1905	1927	2736	finally
    //   1967	1979	2736	finally
    //   2071	2075	2736	finally
    //   2091	2130	2736	finally
    //   2146	2153	2736	finally
    //   2169	2176	2736	finally
    //   2282	2286	2736	finally
    //   2302	2341	2736	finally
    //   2357	2364	2736	finally
    //   2380	2387	2736	finally
    //   2493	2497	2736	finally
    //   2513	2552	2736	finally
    //   1516	1524	2744	finally
    //   1524	1530	2759	finally
    //   1536	1542	2759	finally
    //   1545	1555	2759	finally
    //   1560	1566	2759	finally
    //   1566	1576	2759	finally
    //   1636	1643	2759	finally
    //   491	565	2773	finally
    //   152	159	2792	java/lang/Throwable
    //   167	294	2792	java/lang/Throwable
    //   294	314	2792	java/lang/Throwable
    //   342	348	2809	java/lang/Throwable
    //   381	388	2809	java/lang/Throwable
    //   416	425	2809	java/lang/Throwable
    //   459	469	2809	java/lang/Throwable
    //   722	732	2809	java/lang/Throwable
    //   760	767	2809	java/lang/Throwable
    //   795	800	2809	java/lang/Throwable
    //   828	833	2809	java/lang/Throwable
    //   885	892	2809	java/lang/Throwable
    //   942	949	2809	java/lang/Throwable
    //   986	1027	2809	java/lang/Throwable
    //   1055	1088	2809	java/lang/Throwable
    //   1116	1126	2809	java/lang/Throwable
    //   1157	1170	2809	java/lang/Throwable
    //   1203	1214	2809	java/lang/Throwable
    //   1242	1253	2809	java/lang/Throwable
    //   1281	1286	2809	java/lang/Throwable
    //   1314	1324	2809	java/lang/Throwable
    //   1404	1411	2809	java/lang/Throwable
    //   1442	1455	2809	java/lang/Throwable
    //   1510	1516	2809	java/lang/Throwable
    //   1702	1733	2809	java/lang/Throwable
    //   1761	1795	2809	java/lang/Throwable
    //   1823	1837	2809	java/lang/Throwable
    //   1865	1875	2809	java/lang/Throwable
    //   1905	1927	2809	java/lang/Throwable
    //   1967	1979	2809	java/lang/Throwable
    //   1516	1524	2827	java/lang/Throwable
    //   1524	1530	2844	java/lang/Throwable
    //   1536	1542	2844	java/lang/Throwable
    //   1545	1555	2844	java/lang/Throwable
    //   1560	1566	2864	java/lang/Throwable
    //   1566	1576	2864	java/lang/Throwable
    //   1636	1643	2864	java/lang/Throwable
    //   152	159	2889	java/lang/Exception
    //   167	294	2889	java/lang/Exception
    //   294	314	2889	java/lang/Exception
    //   342	348	2906	java/lang/Exception
    //   381	388	2906	java/lang/Exception
    //   416	425	2906	java/lang/Exception
    //   459	469	2906	java/lang/Exception
    //   722	732	2906	java/lang/Exception
    //   760	767	2906	java/lang/Exception
    //   795	800	2906	java/lang/Exception
    //   828	833	2906	java/lang/Exception
    //   885	892	2906	java/lang/Exception
    //   942	949	2906	java/lang/Exception
    //   986	1027	2906	java/lang/Exception
    //   1055	1088	2906	java/lang/Exception
    //   1116	1126	2906	java/lang/Exception
    //   1157	1170	2906	java/lang/Exception
    //   1203	1214	2906	java/lang/Exception
    //   1242	1253	2906	java/lang/Exception
    //   1281	1286	2906	java/lang/Exception
    //   1314	1324	2906	java/lang/Exception
    //   1404	1411	2906	java/lang/Exception
    //   1442	1455	2906	java/lang/Exception
    //   1510	1516	2906	java/lang/Exception
    //   1702	1733	2906	java/lang/Exception
    //   1761	1795	2906	java/lang/Exception
    //   1823	1837	2906	java/lang/Exception
    //   1865	1875	2906	java/lang/Exception
    //   1905	1927	2906	java/lang/Exception
    //   1967	1979	2906	java/lang/Exception
    //   1516	1524	2924	java/lang/Exception
    //   1524	1530	2941	java/lang/Exception
    //   1536	1542	2941	java/lang/Exception
    //   1545	1555	2941	java/lang/Exception
    //   1560	1566	2961	java/lang/Exception
    //   1566	1576	2961	java/lang/Exception
    //   1636	1643	2961	java/lang/Exception
    //   152	159	2986	java/io/IOException
    //   167	294	2986	java/io/IOException
    //   294	314	2986	java/io/IOException
    //   342	348	3003	java/io/IOException
    //   381	388	3003	java/io/IOException
    //   416	425	3003	java/io/IOException
    //   459	469	3003	java/io/IOException
    //   722	732	3003	java/io/IOException
    //   760	767	3003	java/io/IOException
    //   795	800	3003	java/io/IOException
    //   828	833	3003	java/io/IOException
    //   885	892	3003	java/io/IOException
    //   942	949	3003	java/io/IOException
    //   986	1027	3003	java/io/IOException
    //   1055	1088	3003	java/io/IOException
    //   1116	1126	3003	java/io/IOException
    //   1157	1170	3003	java/io/IOException
    //   1203	1214	3003	java/io/IOException
    //   1242	1253	3003	java/io/IOException
    //   1281	1286	3003	java/io/IOException
    //   1314	1324	3003	java/io/IOException
    //   1404	1411	3003	java/io/IOException
    //   1442	1455	3003	java/io/IOException
    //   1510	1516	3003	java/io/IOException
    //   1702	1733	3003	java/io/IOException
    //   1761	1795	3003	java/io/IOException
    //   1823	1837	3003	java/io/IOException
    //   1865	1875	3003	java/io/IOException
    //   1905	1927	3003	java/io/IOException
    //   1967	1979	3003	java/io/IOException
    //   1516	1524	3021	java/io/IOException
    //   1524	1530	3038	java/io/IOException
    //   1536	1542	3038	java/io/IOException
    //   1545	1555	3038	java/io/IOException
    //   1560	1566	3058	java/io/IOException
    //   1566	1576	3058	java/io/IOException
    //   1636	1643	3058	java/io/IOException
    //   57	65	3083	java/net/SocketTimeoutException
    //   152	159	3105	java/net/SocketTimeoutException
    //   167	294	3105	java/net/SocketTimeoutException
    //   294	314	3105	java/net/SocketTimeoutException
    //   885	892	3127	java/net/SocketTimeoutException
    //   942	949	3127	java/net/SocketTimeoutException
    //   986	1027	3127	java/net/SocketTimeoutException
    //   1055	1088	3127	java/net/SocketTimeoutException
    //   1116	1126	3127	java/net/SocketTimeoutException
    //   1157	1170	3127	java/net/SocketTimeoutException
    //   1203	1214	3127	java/net/SocketTimeoutException
    //   1242	1253	3127	java/net/SocketTimeoutException
    //   1281	1286	3127	java/net/SocketTimeoutException
    //   1314	1324	3127	java/net/SocketTimeoutException
    //   1404	1411	3127	java/net/SocketTimeoutException
    //   1442	1455	3127	java/net/SocketTimeoutException
    //   1510	1516	3127	java/net/SocketTimeoutException
    //   1702	1733	3127	java/net/SocketTimeoutException
    //   1761	1795	3127	java/net/SocketTimeoutException
    //   1823	1837	3127	java/net/SocketTimeoutException
    //   1865	1875	3127	java/net/SocketTimeoutException
    //   1905	1927	3127	java/net/SocketTimeoutException
    //   1967	1979	3127	java/net/SocketTimeoutException
    //   1516	1524	3152	java/net/SocketTimeoutException
    //   1524	1530	3185	java/net/SocketTimeoutException
    //   1536	1542	3185	java/net/SocketTimeoutException
    //   1545	1555	3185	java/net/SocketTimeoutException
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 51	com/tencent/token/utils/v
    //   3: dup
    //   4: invokespecial 52	com/tencent/token/utils/v:<init>	()V
    //   7: astore 30
    //   9: aconst_null
    //   10: astore 21
    //   12: aconst_null
    //   13: astore 20
    //   15: aconst_null
    //   16: astore 19
    //   18: aconst_null
    //   19: astore 12
    //   21: aconst_null
    //   22: astore 28
    //   24: aconst_null
    //   25: astore 14
    //   27: aconst_null
    //   28: astore 18
    //   30: aconst_null
    //   31: astore 16
    //   33: aconst_null
    //   34: astore 17
    //   36: aconst_null
    //   37: astore 25
    //   39: aconst_null
    //   40: astore 27
    //   42: aconst_null
    //   43: astore 15
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 55	com/tencent/token/gk:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
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
    //   137: ifnull +2571 -> 2708
    //   140: aload_3
    //   141: invokevirtual 72	java/lang/String:length	()I
    //   144: ifle +2564 -> 2708
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
    //   189: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
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
    //   242: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
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
    //   335: astore 23
    //   337: aconst_null
    //   338: astore 26
    //   340: aconst_null
    //   341: astore 29
    //   343: aconst_null
    //   344: astore 24
    //   346: aload 27
    //   348: astore 13
    //   350: aload 28
    //   352: astore 12
    //   354: aload 29
    //   356: astore 11
    //   358: aload 9
    //   360: astore 10
    //   362: aload 9
    //   364: invokevirtual 213	java/net/HttpURLConnection:getResponseCode	()I
    //   367: istore 6
    //   369: iload 6
    //   371: sipush 200
    //   374: if_icmpeq +17 -> 391
    //   377: iload 6
    //   379: sipush 206
    //   382: if_icmpeq +9 -> 391
    //   385: iload 6
    //   387: iconst_m1
    //   388: if_icmpne +822 -> 1210
    //   391: aload 27
    //   393: astore 13
    //   395: aload 28
    //   397: astore 12
    //   399: aload 29
    //   401: astore 11
    //   403: aload 9
    //   405: astore 10
    //   407: aload 9
    //   409: invokevirtual 216	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   412: astore 14
    //   414: aload 14
    //   416: ifnonnull +330 -> 746
    //   419: ldc 218
    //   421: astore 14
    //   423: aload 27
    //   425: astore 13
    //   427: aload 28
    //   429: astore 12
    //   431: aload 29
    //   433: astore 11
    //   435: aload 9
    //   437: astore 10
    //   439: new 74	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   446: ldc 220
    //   448: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 14
    //   453: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc 222
    //   458: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_2
    //   462: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc 224
    //   467: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_1
    //   471: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 198	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   480: aload 27
    //   482: astore 13
    //   484: aload 28
    //   486: astore 12
    //   488: aload 29
    //   490: astore 11
    //   492: aload 9
    //   494: astore 10
    //   496: new 74	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   503: ldc 220
    //   505: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 14
    //   510: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc 222
    //   515: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_2
    //   519: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc 224
    //   524: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: astore 31
    //   529: aload 27
    //   531: astore 13
    //   533: aload 28
    //   535: astore 12
    //   537: aload 29
    //   539: astore 11
    //   541: aload 9
    //   543: astore 10
    //   545: aload_1
    //   546: ldc 200
    //   548: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   551: iconst_m1
    //   552: if_icmpne +220 -> 772
    //   555: aload_1
    //   556: astore 15
    //   558: aload 27
    //   560: astore 13
    //   562: aload 28
    //   564: astore 12
    //   566: aload 29
    //   568: astore 11
    //   570: aload 9
    //   572: astore 10
    //   574: aload 31
    //   576: aload 15
    //   578: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   587: iload 4
    //   589: ifeq +239 -> 828
    //   592: aload 27
    //   594: astore 13
    //   596: aload 28
    //   598: astore 12
    //   600: aload 29
    //   602: astore 11
    //   604: aload 9
    //   606: astore 10
    //   608: aload 14
    //   610: ldc 226
    //   612: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   615: iconst_m1
    //   616: if_icmpne +30 -> 646
    //   619: aload 27
    //   621: astore 13
    //   623: aload 28
    //   625: astore 12
    //   627: aload 29
    //   629: astore 11
    //   631: aload 9
    //   633: astore 10
    //   635: aload 14
    //   637: ldc 228
    //   639: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   642: iconst_m1
    //   643: if_icmpeq +185 -> 828
    //   646: aload 27
    //   648: astore 13
    //   650: aload 28
    //   652: astore 12
    //   654: aload 29
    //   656: astore 11
    //   658: aload 9
    //   660: astore 10
    //   662: ldc 230
    //   664: invokestatic 232	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   667: aload 27
    //   669: astore 13
    //   671: aload 28
    //   673: astore 12
    //   675: aload 29
    //   677: astore 11
    //   679: aload 9
    //   681: astore 10
    //   683: aload_0
    //   684: aload_1
    //   685: aload_2
    //   686: aload_3
    //   687: iconst_1
    //   688: aload 5
    //   690: invokespecial 279	com/tencent/token/gk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z[B)[B
    //   693: astore_2
    //   694: aload_2
    //   695: astore_1
    //   696: iconst_0
    //   697: ifeq +11 -> 708
    //   700: new 57	java/lang/NullPointerException
    //   703: dup
    //   704: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   707: athrow
    //   708: iconst_0
    //   709: ifeq +11 -> 720
    //   712: new 57	java/lang/NullPointerException
    //   715: dup
    //   716: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   719: athrow
    //   720: iconst_0
    //   721: ifeq +11 -> 732
    //   724: new 57	java/lang/NullPointerException
    //   727: dup
    //   728: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   731: athrow
    //   732: aload_1
    //   733: astore_2
    //   734: aload 9
    //   736: ifnull -626 -> 110
    //   739: aload 9
    //   741: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   744: aload_1
    //   745: areturn
    //   746: aload 27
    //   748: astore 13
    //   750: aload 28
    //   752: astore 12
    //   754: aload 29
    //   756: astore 11
    //   758: aload 9
    //   760: astore 10
    //   762: aload 14
    //   764: invokevirtual 237	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   767: astore 14
    //   769: goto -346 -> 423
    //   772: aload 27
    //   774: astore 13
    //   776: aload 28
    //   778: astore 12
    //   780: aload 29
    //   782: astore 11
    //   784: aload 9
    //   786: astore 10
    //   788: aload_1
    //   789: iconst_0
    //   790: aload_1
    //   791: ldc 200
    //   793: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   796: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   799: astore 15
    //   801: goto -243 -> 558
    //   804: astore_2
    //   805: aload_2
    //   806: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   809: goto -101 -> 708
    //   812: astore_2
    //   813: aload_2
    //   814: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   817: goto -97 -> 720
    //   820: astore_2
    //   821: aload_2
    //   822: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   825: goto -93 -> 732
    //   828: aload 27
    //   830: astore 13
    //   832: aload 28
    //   834: astore 12
    //   836: aload 29
    //   838: astore 11
    //   840: aload 9
    //   842: astore 10
    //   844: aload 9
    //   846: invokevirtual 245	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   849: astore_2
    //   850: new 183	java/io/ByteArrayOutputStream
    //   853: dup
    //   854: invokespecial 246	java/io/ByteArrayOutputStream:<init>	()V
    //   857: astore_3
    //   858: aload_2
    //   859: invokevirtual 248	java/io/InputStream:read	()I
    //   862: istore 6
    //   864: iload 6
    //   866: iconst_m1
    //   867: if_icmpeq +228 -> 1095
    //   870: aload_3
    //   871: iload 6
    //   873: invokevirtual 251	java/io/ByteArrayOutputStream:write	(I)V
    //   876: goto -18 -> 858
    //   879: astore 11
    //   881: aconst_null
    //   882: astore 12
    //   884: aconst_null
    //   885: astore 5
    //   887: aload 9
    //   889: astore 10
    //   891: aload 12
    //   893: astore 9
    //   895: aload 11
    //   897: invokevirtual 157	java/net/SocketTimeoutException:printStackTrace	()V
    //   900: aload_0
    //   901: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   904: sipush 10002
    //   907: new 74	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   914: aload 11
    //   916: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   919: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: ldc 160
    //   924: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload 11
    //   929: invokevirtual 163	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   932: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   941: invokestatic 171	com/tencent/token/ch:a	()Lcom/tencent/token/ch;
    //   944: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   947: getstatic 18	com/tencent/token/gk:f	I
    //   950: invokevirtual 179	com/tencent/token/ch:a	(JI)V
    //   953: aload 11
    //   955: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   958: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   961: aload 11
    //   963: invokevirtual 158	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   966: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   969: aload_3
    //   970: ifnull +7 -> 977
    //   973: aload_3
    //   974: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   977: aload_2
    //   978: ifnull +7 -> 985
    //   981: aload_2
    //   982: invokevirtual 189	java/io/InputStream:close	()V
    //   985: aload 9
    //   987: ifnull +8 -> 995
    //   990: aload 9
    //   992: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   995: aload 5
    //   997: astore_3
    //   998: aload 10
    //   1000: ifnull +11 -> 1011
    //   1003: aload 10
    //   1005: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1008: aload 5
    //   1010: astore_3
    //   1011: new 74	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1018: ldc 192
    //   1020: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: aload 30
    //   1025: invokevirtual 194	com/tencent/token/utils/v:a	()J
    //   1028: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1031: ldc 196
    //   1033: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload_1
    //   1037: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 198	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   1046: new 74	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1053: ldc 192
    //   1055: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: aload 30
    //   1060: invokevirtual 194	com/tencent/token/utils/v:a	()J
    //   1063: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: ldc 196
    //   1068: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: astore_2
    //   1072: aload_1
    //   1073: ldc 200
    //   1075: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1078: iconst_m1
    //   1079: if_icmpne +1072 -> 2151
    //   1082: aload_2
    //   1083: aload_1
    //   1084: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1093: aload_3
    //   1094: areturn
    //   1095: aload_3
    //   1096: invokevirtual 252	java/io/ByteArrayOutputStream:flush	()V
    //   1099: aload_3
    //   1100: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1103: astore 5
    //   1105: aload 5
    //   1107: ifnull +9 -> 1116
    //   1110: aload 5
    //   1112: arraylength
    //   1113: ifgt +71 -> 1184
    //   1116: aload_0
    //   1117: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1120: ldc_w 256
    //   1123: invokevirtual 258	com/tencent/token/global/f:b	(I)V
    //   1126: aconst_null
    //   1127: astore 5
    //   1129: aload_3
    //   1130: astore 10
    //   1132: aload_2
    //   1133: astore_3
    //   1134: aload 5
    //   1136: astore_2
    //   1137: aload 10
    //   1139: ifnull +8 -> 1147
    //   1142: aload 10
    //   1144: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1147: aload_3
    //   1148: ifnull +7 -> 1155
    //   1151: aload_3
    //   1152: invokevirtual 189	java/io/InputStream:close	()V
    //   1155: iconst_0
    //   1156: ifeq +11 -> 1167
    //   1159: new 57	java/lang/NullPointerException
    //   1162: dup
    //   1163: invokespecial 58	java/lang/NullPointerException:<init>	()V
    //   1166: athrow
    //   1167: aload_2
    //   1168: astore_3
    //   1169: aload 9
    //   1171: ifnull -160 -> 1011
    //   1174: aload 9
    //   1176: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1179: aload_2
    //   1180: astore_3
    //   1181: goto -170 -> 1011
    //   1184: aload_0
    //   1185: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1188: invokevirtual 260	com/tencent/token/global/f:c	()V
    //   1191: goto -62 -> 1129
    //   1194: astore 11
    //   1196: aconst_null
    //   1197: astore 12
    //   1199: aload 9
    //   1201: astore 10
    //   1203: aload 12
    //   1205: astore 9
    //   1207: goto -312 -> 895
    //   1210: aload 27
    //   1212: astore 13
    //   1214: aload 28
    //   1216: astore 12
    //   1218: aload 29
    //   1220: astore 11
    //   1222: aload 9
    //   1224: astore 10
    //   1226: aload_0
    //   1227: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1230: sipush 10005
    //   1233: new 74	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 262
    //   1243: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload 6
    //   1248: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   1257: aload 27
    //   1259: astore 13
    //   1261: aload 28
    //   1263: astore 12
    //   1265: aload 29
    //   1267: astore 11
    //   1269: aload 9
    //   1271: astore 10
    //   1273: new 74	java/lang/StringBuilder
    //   1276: dup
    //   1277: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1280: ldc_w 264
    //   1283: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: aload_1
    //   1287: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 266
    //   1293: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload 6
    //   1298: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokestatic 232	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   1307: aload 27
    //   1309: astore 13
    //   1311: aload 28
    //   1313: astore 12
    //   1315: aload 29
    //   1317: astore 11
    //   1319: aload 9
    //   1321: astore 10
    //   1323: new 74	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 268
    //   1333: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: astore_3
    //   1337: aload 27
    //   1339: astore 13
    //   1341: aload 28
    //   1343: astore 12
    //   1345: aload 29
    //   1347: astore 11
    //   1349: aload 9
    //   1351: astore 10
    //   1353: aload_1
    //   1354: ldc 200
    //   1356: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1359: iconst_m1
    //   1360: if_icmpne +55 -> 1415
    //   1363: aload_1
    //   1364: astore_2
    //   1365: aload 27
    //   1367: astore 13
    //   1369: aload 28
    //   1371: astore 12
    //   1373: aload 29
    //   1375: astore 11
    //   1377: aload 9
    //   1379: astore 10
    //   1381: aload_3
    //   1382: aload_2
    //   1383: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: ldc_w 266
    //   1389: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: iload 6
    //   1394: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1397: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1403: aconst_null
    //   1404: astore_2
    //   1405: aload 15
    //   1407: astore 10
    //   1409: aload 14
    //   1411: astore_3
    //   1412: goto -275 -> 1137
    //   1415: aload 27
    //   1417: astore 13
    //   1419: aload 28
    //   1421: astore 12
    //   1423: aload 29
    //   1425: astore 11
    //   1427: aload 9
    //   1429: astore 10
    //   1431: aload_1
    //   1432: iconst_0
    //   1433: aload_1
    //   1434: ldc 200
    //   1436: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1439: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   1442: astore_2
    //   1443: goto -78 -> 1365
    //   1446: astore 5
    //   1448: aload 5
    //   1450: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1453: goto -306 -> 1147
    //   1456: astore_3
    //   1457: aload_3
    //   1458: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1461: goto -306 -> 1155
    //   1464: astore_3
    //   1465: aload_3
    //   1466: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1469: goto -302 -> 1167
    //   1472: astore_3
    //   1473: aload_3
    //   1474: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1477: goto -500 -> 977
    //   1480: astore_2
    //   1481: aload_2
    //   1482: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1485: goto -500 -> 985
    //   1488: astore_2
    //   1489: aload_2
    //   1490: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1493: goto -498 -> 995
    //   1496: astore_3
    //   1497: aconst_null
    //   1498: astore 14
    //   1500: aconst_null
    //   1501: astore 9
    //   1503: aconst_null
    //   1504: astore_2
    //   1505: aload 21
    //   1507: astore 5
    //   1509: aload 18
    //   1511: astore 15
    //   1513: aload 15
    //   1515: astore 13
    //   1517: aload 5
    //   1519: astore 12
    //   1521: aload 14
    //   1523: astore 11
    //   1525: aload 9
    //   1527: astore 10
    //   1529: aload_3
    //   1530: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   1533: aload 15
    //   1535: astore 13
    //   1537: aload 5
    //   1539: astore 12
    //   1541: aload 14
    //   1543: astore 11
    //   1545: aload 9
    //   1547: astore 10
    //   1549: aload_0
    //   1550: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1553: sipush 10003
    //   1556: new 74	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1563: aload_3
    //   1564: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   1567: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: ldc 160
    //   1572: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload_3
    //   1576: invokevirtual 271	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1579: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   1588: aload 15
    //   1590: astore 13
    //   1592: aload 5
    //   1594: astore 12
    //   1596: aload 14
    //   1598: astore 11
    //   1600: aload 9
    //   1602: astore 10
    //   1604: aload_3
    //   1605: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   1608: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   1611: aload 15
    //   1613: astore 13
    //   1615: aload 5
    //   1617: astore 12
    //   1619: aload 14
    //   1621: astore 11
    //   1623: aload 9
    //   1625: astore 10
    //   1627: aload_3
    //   1628: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   1631: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1634: aload 15
    //   1636: ifnull +8 -> 1644
    //   1639: aload 15
    //   1641: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1644: aload 5
    //   1646: ifnull +8 -> 1654
    //   1649: aload 5
    //   1651: invokevirtual 189	java/io/InputStream:close	()V
    //   1654: aload 14
    //   1656: ifnull +8 -> 1664
    //   1659: aload 14
    //   1661: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   1664: aload_2
    //   1665: astore_3
    //   1666: aload 9
    //   1668: ifnull -657 -> 1011
    //   1671: aload 9
    //   1673: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1676: aload_2
    //   1677: astore_3
    //   1678: goto -667 -> 1011
    //   1681: astore_3
    //   1682: aload_3
    //   1683: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1686: goto -42 -> 1644
    //   1689: astore_3
    //   1690: aload_3
    //   1691: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1694: goto -40 -> 1654
    //   1697: astore_3
    //   1698: aload_3
    //   1699: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1702: goto -38 -> 1664
    //   1705: astore_3
    //   1706: aconst_null
    //   1707: astore 14
    //   1709: aconst_null
    //   1710: astore 9
    //   1712: aconst_null
    //   1713: astore_2
    //   1714: aload 20
    //   1716: astore 5
    //   1718: aload 16
    //   1720: astore 15
    //   1722: aload 15
    //   1724: astore 13
    //   1726: aload 5
    //   1728: astore 12
    //   1730: aload 14
    //   1732: astore 11
    //   1734: aload 9
    //   1736: astore 10
    //   1738: aload_3
    //   1739: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1742: aload 15
    //   1744: astore 13
    //   1746: aload 5
    //   1748: astore 12
    //   1750: aload 14
    //   1752: astore 11
    //   1754: aload 9
    //   1756: astore 10
    //   1758: aload_0
    //   1759: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1762: sipush 10003
    //   1765: new 74	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1772: aload_3
    //   1773: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   1776: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: ldc 160
    //   1781: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload_3
    //   1785: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1788: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1794: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   1797: aload 15
    //   1799: astore 13
    //   1801: aload 5
    //   1803: astore 12
    //   1805: aload 14
    //   1807: astore 11
    //   1809: aload 9
    //   1811: astore 10
    //   1813: aload_3
    //   1814: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   1817: invokestatic 107	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   1820: aload 15
    //   1822: astore 13
    //   1824: aload 5
    //   1826: astore 12
    //   1828: aload 14
    //   1830: astore 11
    //   1832: aload 9
    //   1834: astore 10
    //   1836: aload_3
    //   1837: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   1840: invokestatic 181	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   1843: aload 15
    //   1845: ifnull +8 -> 1853
    //   1848: aload 15
    //   1850: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   1853: aload 5
    //   1855: ifnull +8 -> 1863
    //   1858: aload 5
    //   1860: invokevirtual 189	java/io/InputStream:close	()V
    //   1863: aload 14
    //   1865: ifnull +8 -> 1873
    //   1868: aload 14
    //   1870: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   1873: aload_2
    //   1874: astore_3
    //   1875: aload 9
    //   1877: ifnull -866 -> 1011
    //   1880: aload 9
    //   1882: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   1885: aload_2
    //   1886: astore_3
    //   1887: goto -876 -> 1011
    //   1890: astore_3
    //   1891: aload_3
    //   1892: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1895: goto -42 -> 1853
    //   1898: astore_3
    //   1899: aload_3
    //   1900: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1903: goto -40 -> 1863
    //   1906: astore_3
    //   1907: aload_3
    //   1908: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   1911: goto -38 -> 1873
    //   1914: astore_3
    //   1915: aconst_null
    //   1916: astore 14
    //   1918: aconst_null
    //   1919: astore 9
    //   1921: aconst_null
    //   1922: astore_2
    //   1923: aload 19
    //   1925: astore 5
    //   1927: aload 17
    //   1929: astore 15
    //   1931: aload 15
    //   1933: astore 13
    //   1935: aload 5
    //   1937: astore 12
    //   1939: aload 14
    //   1941: astore 11
    //   1943: aload 9
    //   1945: astore 10
    //   1947: aload_3
    //   1948: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   1951: aload 15
    //   1953: astore 13
    //   1955: aload 5
    //   1957: astore 12
    //   1959: aload 14
    //   1961: astore 11
    //   1963: aload 9
    //   1965: astore 10
    //   1967: aload_0
    //   1968: getfield 29	com/tencent/token/gk:a	Lcom/tencent/token/global/f;
    //   1971: sipush 10003
    //   1974: new 74	java/lang/StringBuilder
    //   1977: dup
    //   1978: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1981: aload_3
    //   1982: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1985: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: ldc 160
    //   1990: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: aload_3
    //   1994: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1997: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2003: invokevirtual 166	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   2006: aload 15
    //   2008: ifnull +8 -> 2016
    //   2011: aload 15
    //   2013: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2016: aload 5
    //   2018: ifnull +8 -> 2026
    //   2021: aload 5
    //   2023: invokevirtual 189	java/io/InputStream:close	()V
    //   2026: aload 14
    //   2028: ifnull +8 -> 2036
    //   2031: aload 14
    //   2033: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2036: aload_2
    //   2037: astore_3
    //   2038: aload 9
    //   2040: ifnull -1029 -> 1011
    //   2043: aload 9
    //   2045: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2048: aload_2
    //   2049: astore_3
    //   2050: goto -1039 -> 1011
    //   2053: astore_3
    //   2054: aload_3
    //   2055: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2058: goto -42 -> 2016
    //   2061: astore_3
    //   2062: aload_3
    //   2063: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2066: goto -40 -> 2026
    //   2069: astore_3
    //   2070: aload_3
    //   2071: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2074: goto -38 -> 2036
    //   2077: astore_1
    //   2078: aconst_null
    //   2079: astore_2
    //   2080: aconst_null
    //   2081: astore 9
    //   2083: aload 25
    //   2085: astore 13
    //   2087: aload 13
    //   2089: ifnull +8 -> 2097
    //   2092: aload 13
    //   2094: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   2097: aload 12
    //   2099: ifnull +8 -> 2107
    //   2102: aload 12
    //   2104: invokevirtual 189	java/io/InputStream:close	()V
    //   2107: aload_2
    //   2108: ifnull +7 -> 2115
    //   2111: aload_2
    //   2112: invokevirtual 190	java/io/DataOutputStream:close	()V
    //   2115: aload 9
    //   2117: ifnull +8 -> 2125
    //   2120: aload 9
    //   2122: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   2125: aload_1
    //   2126: athrow
    //   2127: astore_3
    //   2128: aload_3
    //   2129: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2132: goto -35 -> 2097
    //   2135: astore_3
    //   2136: aload_3
    //   2137: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2140: goto -33 -> 2107
    //   2143: astore_2
    //   2144: aload_2
    //   2145: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   2148: goto -33 -> 2115
    //   2151: aload_1
    //   2152: iconst_0
    //   2153: aload_1
    //   2154: ldc 200
    //   2156: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2159: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   2162: astore_1
    //   2163: goto -1081 -> 1082
    //   2166: astore_1
    //   2167: aconst_null
    //   2168: astore_2
    //   2169: aload 25
    //   2171: astore 13
    //   2173: goto -86 -> 2087
    //   2176: astore_1
    //   2177: aload 10
    //   2179: astore_2
    //   2180: aload 25
    //   2182: astore 13
    //   2184: goto -97 -> 2087
    //   2187: astore_1
    //   2188: aload 11
    //   2190: astore_2
    //   2191: aload 10
    //   2193: astore 9
    //   2195: goto -108 -> 2087
    //   2198: astore_1
    //   2199: aload 25
    //   2201: astore 13
    //   2203: aload_2
    //   2204: astore 12
    //   2206: aload 26
    //   2208: astore_2
    //   2209: goto -122 -> 2087
    //   2212: astore_1
    //   2213: aload_3
    //   2214: astore 13
    //   2216: aload_2
    //   2217: astore 12
    //   2219: aload 26
    //   2221: astore_2
    //   2222: goto -135 -> 2087
    //   2225: astore_1
    //   2226: aload 9
    //   2228: astore 5
    //   2230: aload 10
    //   2232: astore 9
    //   2234: aload_3
    //   2235: astore 13
    //   2237: aload_2
    //   2238: astore 12
    //   2240: aload 5
    //   2242: astore_2
    //   2243: goto -156 -> 2087
    //   2246: astore_3
    //   2247: aconst_null
    //   2248: astore 14
    //   2250: aconst_null
    //   2251: astore_2
    //   2252: aload 17
    //   2254: astore 15
    //   2256: aload 19
    //   2258: astore 5
    //   2260: goto -329 -> 1931
    //   2263: astore_3
    //   2264: aconst_null
    //   2265: astore_2
    //   2266: aload 17
    //   2268: astore 15
    //   2270: aload 19
    //   2272: astore 5
    //   2274: aload 10
    //   2276: astore 14
    //   2278: goto -347 -> 1931
    //   2281: astore_3
    //   2282: aconst_null
    //   2283: astore_2
    //   2284: aload 17
    //   2286: astore 15
    //   2288: aload 19
    //   2290: astore 5
    //   2292: aload 23
    //   2294: astore 14
    //   2296: goto -365 -> 1931
    //   2299: astore_3
    //   2300: aload_2
    //   2301: astore 5
    //   2303: aconst_null
    //   2304: astore_2
    //   2305: aload 17
    //   2307: astore 15
    //   2309: aload 23
    //   2311: astore 14
    //   2313: goto -382 -> 1931
    //   2316: astore 5
    //   2318: aload_3
    //   2319: astore 15
    //   2321: aload_2
    //   2322: astore 10
    //   2324: aconst_null
    //   2325: astore_2
    //   2326: aload 5
    //   2328: astore_3
    //   2329: aload 10
    //   2331: astore 5
    //   2333: aload 23
    //   2335: astore 14
    //   2337: goto -406 -> 1931
    //   2340: astore 11
    //   2342: aload_3
    //   2343: astore 15
    //   2345: aload_2
    //   2346: astore 10
    //   2348: aload 5
    //   2350: astore_2
    //   2351: aload 11
    //   2353: astore_3
    //   2354: aload 10
    //   2356: astore 5
    //   2358: aload 23
    //   2360: astore 14
    //   2362: goto -431 -> 1931
    //   2365: astore_3
    //   2366: aconst_null
    //   2367: astore 14
    //   2369: aconst_null
    //   2370: astore_2
    //   2371: aload 16
    //   2373: astore 15
    //   2375: aload 20
    //   2377: astore 5
    //   2379: goto -657 -> 1722
    //   2382: astore_3
    //   2383: aconst_null
    //   2384: astore_2
    //   2385: aload 16
    //   2387: astore 15
    //   2389: aload 20
    //   2391: astore 5
    //   2393: aload 10
    //   2395: astore 14
    //   2397: goto -675 -> 1722
    //   2400: astore_3
    //   2401: aconst_null
    //   2402: astore_2
    //   2403: aload 16
    //   2405: astore 15
    //   2407: aload 20
    //   2409: astore 5
    //   2411: aload 22
    //   2413: astore 14
    //   2415: goto -693 -> 1722
    //   2418: astore_3
    //   2419: aload_2
    //   2420: astore 5
    //   2422: aconst_null
    //   2423: astore_2
    //   2424: aload 16
    //   2426: astore 15
    //   2428: aload 22
    //   2430: astore 14
    //   2432: goto -710 -> 1722
    //   2435: astore 5
    //   2437: aload_3
    //   2438: astore 15
    //   2440: aload_2
    //   2441: astore 10
    //   2443: aconst_null
    //   2444: astore_2
    //   2445: aload 5
    //   2447: astore_3
    //   2448: aload 10
    //   2450: astore 5
    //   2452: aload 22
    //   2454: astore 14
    //   2456: goto -734 -> 1722
    //   2459: astore 11
    //   2461: aload_3
    //   2462: astore 15
    //   2464: aload_2
    //   2465: astore 10
    //   2467: aload 5
    //   2469: astore_2
    //   2470: aload 11
    //   2472: astore_3
    //   2473: aload 10
    //   2475: astore 5
    //   2477: aload 22
    //   2479: astore 14
    //   2481: goto -759 -> 1722
    //   2484: astore_3
    //   2485: aconst_null
    //   2486: astore 14
    //   2488: aconst_null
    //   2489: astore_2
    //   2490: aload 18
    //   2492: astore 15
    //   2494: aload 21
    //   2496: astore 5
    //   2498: goto -985 -> 1513
    //   2501: astore_3
    //   2502: aconst_null
    //   2503: astore_2
    //   2504: aload 18
    //   2506: astore 15
    //   2508: aload 21
    //   2510: astore 5
    //   2512: aload 10
    //   2514: astore 14
    //   2516: goto -1003 -> 1513
    //   2519: astore_3
    //   2520: aconst_null
    //   2521: astore_2
    //   2522: aload 18
    //   2524: astore 15
    //   2526: aload 21
    //   2528: astore 5
    //   2530: aload 24
    //   2532: astore 14
    //   2534: goto -1021 -> 1513
    //   2537: astore_3
    //   2538: aload_2
    //   2539: astore 5
    //   2541: aconst_null
    //   2542: astore_2
    //   2543: aload 18
    //   2545: astore 15
    //   2547: aload 24
    //   2549: astore 14
    //   2551: goto -1038 -> 1513
    //   2554: astore 10
    //   2556: aload_3
    //   2557: astore 15
    //   2559: aload_2
    //   2560: astore 5
    //   2562: aconst_null
    //   2563: astore_2
    //   2564: aload 10
    //   2566: astore_3
    //   2567: aload 24
    //   2569: astore 14
    //   2571: goto -1058 -> 1513
    //   2574: astore 11
    //   2576: aload_3
    //   2577: astore 15
    //   2579: aload_2
    //   2580: astore 10
    //   2582: aload 5
    //   2584: astore_2
    //   2585: aload 11
    //   2587: astore_3
    //   2588: aload 10
    //   2590: astore 5
    //   2592: aload 24
    //   2594: astore 14
    //   2596: goto -1083 -> 1513
    //   2599: astore 11
    //   2601: aconst_null
    //   2602: astore_2
    //   2603: aconst_null
    //   2604: astore 9
    //   2606: aconst_null
    //   2607: astore 10
    //   2609: aconst_null
    //   2610: astore_3
    //   2611: aconst_null
    //   2612: astore 5
    //   2614: goto -1719 -> 895
    //   2617: astore 11
    //   2619: aconst_null
    //   2620: astore_3
    //   2621: aconst_null
    //   2622: astore_2
    //   2623: aconst_null
    //   2624: astore 12
    //   2626: aload 9
    //   2628: astore 10
    //   2630: aconst_null
    //   2631: astore 5
    //   2633: aload 12
    //   2635: astore 9
    //   2637: goto -1742 -> 895
    //   2640: astore 11
    //   2642: aconst_null
    //   2643: astore_2
    //   2644: aload 10
    //   2646: astore 12
    //   2648: aload 9
    //   2650: astore 10
    //   2652: aconst_null
    //   2653: astore_3
    //   2654: aconst_null
    //   2655: astore 5
    //   2657: aload 12
    //   2659: astore 9
    //   2661: goto -1766 -> 895
    //   2664: astore 11
    //   2666: aconst_null
    //   2667: astore_3
    //   2668: aconst_null
    //   2669: astore_2
    //   2670: aconst_null
    //   2671: astore 12
    //   2673: aload 9
    //   2675: astore 10
    //   2677: aconst_null
    //   2678: astore 5
    //   2680: aload 12
    //   2682: astore 9
    //   2684: goto -1789 -> 895
    //   2687: astore 11
    //   2689: aconst_null
    //   2690: astore_3
    //   2691: aconst_null
    //   2692: astore 12
    //   2694: aload 9
    //   2696: astore 10
    //   2698: aconst_null
    //   2699: astore 5
    //   2701: aload 12
    //   2703: astore 9
    //   2705: goto -1810 -> 895
    //   2708: goto -2377 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2711	0	this	gk
    //   0	2711	1	paramString1	String
    //   0	2711	2	paramString2	String
    //   0	2711	3	paramString3	String
    //   0	2711	4	paramBoolean	boolean
    //   0	2711	5	paramArrayOfByte	byte[]
    //   367	1026	6	i	int
    //   220	39	7	l	long
    //   51	2653	9	localObject1	Object
    //   284	2229	10	localObject2	Object
    //   2554	11	10	localIOException1	IOException
    //   2580	117	10	localObject3	Object
    //   148	691	11	localObject4	Object
    //   879	83	11	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1194	1	11	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1220	969	11	localObject5	Object
    //   2340	12	11	localThrowable	java.lang.Throwable
    //   2459	12	11	localException	Exception
    //   2574	12	11	localIOException2	IOException
    //   2599	1	11	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   2617	1	11	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   2640	1	11	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   2664	1	11	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   2687	1	11	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   19	2683	12	localObject6	Object
    //   348	1888	13	localObject7	Object
    //   25	2570	14	localObject8	Object
    //   43	2535	15	localObject9	Object
    //   31	2394	16	localObject10	Object
    //   34	2272	17	localObject11	Object
    //   28	2516	18	localObject12	Object
    //   16	2273	19	localObject13	Object
    //   13	2395	20	localObject14	Object
    //   10	2517	21	localObject15	Object
    //   332	2146	22	localObject16	Object
    //   335	2024	23	localObject17	Object
    //   344	2249	24	localObject18	Object
    //   37	2163	25	localObject19	Object
    //   338	1882	26	localObject20	Object
    //   40	1376	27	localObject21	Object
    //   22	1398	28	localObject22	Object
    //   341	1083	29	localObject23	Object
    //   7	1052	30	localv	com.tencent.token.utils.v
    //   527	48	31	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	72	112	java/lang/Exception
    //   76	84	120	java/lang/Exception
    //   88	96	128	java/lang/Exception
    //   700	708	804	java/lang/Exception
    //   712	720	812	java/lang/Exception
    //   724	732	820	java/lang/Exception
    //   858	864	879	java/net/SocketTimeoutException
    //   870	876	879	java/net/SocketTimeoutException
    //   1095	1105	879	java/net/SocketTimeoutException
    //   1110	1116	1194	java/net/SocketTimeoutException
    //   1116	1126	1194	java/net/SocketTimeoutException
    //   1184	1191	1194	java/net/SocketTimeoutException
    //   1142	1147	1446	java/lang/Exception
    //   1151	1155	1456	java/lang/Exception
    //   1159	1167	1464	java/lang/Exception
    //   973	977	1472	java/lang/Exception
    //   981	985	1480	java/lang/Exception
    //   990	995	1488	java/lang/Exception
    //   45	53	1496	java/io/IOException
    //   1639	1644	1681	java/lang/Exception
    //   1649	1654	1689	java/lang/Exception
    //   1659	1664	1697	java/lang/Exception
    //   45	53	1705	java/lang/Exception
    //   1848	1853	1890	java/lang/Exception
    //   1858	1863	1898	java/lang/Exception
    //   1868	1873	1906	java/lang/Exception
    //   45	53	1914	java/lang/Throwable
    //   2011	2016	2053	java/lang/Exception
    //   2021	2026	2061	java/lang/Exception
    //   2031	2036	2069	java/lang/Exception
    //   45	53	2077	finally
    //   2092	2097	2127	java/lang/Exception
    //   2102	2107	2135	java/lang/Exception
    //   2111	2115	2143	java/lang/Exception
    //   140	147	2166	finally
    //   155	266	2166	finally
    //   266	286	2166	finally
    //   286	292	2176	finally
    //   297	321	2176	finally
    //   321	331	2176	finally
    //   362	369	2187	finally
    //   407	414	2187	finally
    //   439	480	2187	finally
    //   496	529	2187	finally
    //   545	555	2187	finally
    //   574	587	2187	finally
    //   608	619	2187	finally
    //   635	646	2187	finally
    //   662	667	2187	finally
    //   683	694	2187	finally
    //   762	769	2187	finally
    //   788	801	2187	finally
    //   844	850	2187	finally
    //   1226	1257	2187	finally
    //   1273	1307	2187	finally
    //   1323	1337	2187	finally
    //   1353	1363	2187	finally
    //   1381	1403	2187	finally
    //   1431	1443	2187	finally
    //   1529	1533	2187	finally
    //   1549	1588	2187	finally
    //   1604	1611	2187	finally
    //   1627	1634	2187	finally
    //   1738	1742	2187	finally
    //   1758	1797	2187	finally
    //   1813	1820	2187	finally
    //   1836	1843	2187	finally
    //   1947	1951	2187	finally
    //   1967	2006	2187	finally
    //   850	858	2198	finally
    //   858	864	2212	finally
    //   870	876	2212	finally
    //   1095	1105	2212	finally
    //   1110	1116	2212	finally
    //   1116	1126	2212	finally
    //   1184	1191	2212	finally
    //   895	969	2225	finally
    //   140	147	2246	java/lang/Throwable
    //   155	266	2246	java/lang/Throwable
    //   266	286	2246	java/lang/Throwable
    //   286	292	2263	java/lang/Throwable
    //   297	321	2263	java/lang/Throwable
    //   321	331	2263	java/lang/Throwable
    //   362	369	2281	java/lang/Throwable
    //   407	414	2281	java/lang/Throwable
    //   439	480	2281	java/lang/Throwable
    //   496	529	2281	java/lang/Throwable
    //   545	555	2281	java/lang/Throwable
    //   574	587	2281	java/lang/Throwable
    //   608	619	2281	java/lang/Throwable
    //   635	646	2281	java/lang/Throwable
    //   662	667	2281	java/lang/Throwable
    //   683	694	2281	java/lang/Throwable
    //   762	769	2281	java/lang/Throwable
    //   788	801	2281	java/lang/Throwable
    //   844	850	2281	java/lang/Throwable
    //   1226	1257	2281	java/lang/Throwable
    //   1273	1307	2281	java/lang/Throwable
    //   1323	1337	2281	java/lang/Throwable
    //   1353	1363	2281	java/lang/Throwable
    //   1381	1403	2281	java/lang/Throwable
    //   1431	1443	2281	java/lang/Throwable
    //   850	858	2299	java/lang/Throwable
    //   858	864	2316	java/lang/Throwable
    //   870	876	2316	java/lang/Throwable
    //   1095	1105	2316	java/lang/Throwable
    //   1110	1116	2340	java/lang/Throwable
    //   1116	1126	2340	java/lang/Throwable
    //   1184	1191	2340	java/lang/Throwable
    //   140	147	2365	java/lang/Exception
    //   155	266	2365	java/lang/Exception
    //   266	286	2365	java/lang/Exception
    //   286	292	2382	java/lang/Exception
    //   297	321	2382	java/lang/Exception
    //   321	331	2382	java/lang/Exception
    //   362	369	2400	java/lang/Exception
    //   407	414	2400	java/lang/Exception
    //   439	480	2400	java/lang/Exception
    //   496	529	2400	java/lang/Exception
    //   545	555	2400	java/lang/Exception
    //   574	587	2400	java/lang/Exception
    //   608	619	2400	java/lang/Exception
    //   635	646	2400	java/lang/Exception
    //   662	667	2400	java/lang/Exception
    //   683	694	2400	java/lang/Exception
    //   762	769	2400	java/lang/Exception
    //   788	801	2400	java/lang/Exception
    //   844	850	2400	java/lang/Exception
    //   1226	1257	2400	java/lang/Exception
    //   1273	1307	2400	java/lang/Exception
    //   1323	1337	2400	java/lang/Exception
    //   1353	1363	2400	java/lang/Exception
    //   1381	1403	2400	java/lang/Exception
    //   1431	1443	2400	java/lang/Exception
    //   850	858	2418	java/lang/Exception
    //   858	864	2435	java/lang/Exception
    //   870	876	2435	java/lang/Exception
    //   1095	1105	2435	java/lang/Exception
    //   1110	1116	2459	java/lang/Exception
    //   1116	1126	2459	java/lang/Exception
    //   1184	1191	2459	java/lang/Exception
    //   140	147	2484	java/io/IOException
    //   155	266	2484	java/io/IOException
    //   266	286	2484	java/io/IOException
    //   286	292	2501	java/io/IOException
    //   297	321	2501	java/io/IOException
    //   321	331	2501	java/io/IOException
    //   362	369	2519	java/io/IOException
    //   407	414	2519	java/io/IOException
    //   439	480	2519	java/io/IOException
    //   496	529	2519	java/io/IOException
    //   545	555	2519	java/io/IOException
    //   574	587	2519	java/io/IOException
    //   608	619	2519	java/io/IOException
    //   635	646	2519	java/io/IOException
    //   662	667	2519	java/io/IOException
    //   683	694	2519	java/io/IOException
    //   762	769	2519	java/io/IOException
    //   788	801	2519	java/io/IOException
    //   844	850	2519	java/io/IOException
    //   1226	1257	2519	java/io/IOException
    //   1273	1307	2519	java/io/IOException
    //   1323	1337	2519	java/io/IOException
    //   1353	1363	2519	java/io/IOException
    //   1381	1403	2519	java/io/IOException
    //   1431	1443	2519	java/io/IOException
    //   850	858	2537	java/io/IOException
    //   858	864	2554	java/io/IOException
    //   870	876	2554	java/io/IOException
    //   1095	1105	2554	java/io/IOException
    //   1110	1116	2574	java/io/IOException
    //   1116	1126	2574	java/io/IOException
    //   1184	1191	2574	java/io/IOException
    //   45	53	2599	java/net/SocketTimeoutException
    //   140	147	2617	java/net/SocketTimeoutException
    //   155	266	2617	java/net/SocketTimeoutException
    //   266	286	2617	java/net/SocketTimeoutException
    //   286	292	2640	java/net/SocketTimeoutException
    //   297	321	2640	java/net/SocketTimeoutException
    //   321	331	2640	java/net/SocketTimeoutException
    //   362	369	2664	java/net/SocketTimeoutException
    //   407	414	2664	java/net/SocketTimeoutException
    //   439	480	2664	java/net/SocketTimeoutException
    //   496	529	2664	java/net/SocketTimeoutException
    //   545	555	2664	java/net/SocketTimeoutException
    //   574	587	2664	java/net/SocketTimeoutException
    //   608	619	2664	java/net/SocketTimeoutException
    //   635	646	2664	java/net/SocketTimeoutException
    //   662	667	2664	java/net/SocketTimeoutException
    //   683	694	2664	java/net/SocketTimeoutException
    //   762	769	2664	java/net/SocketTimeoutException
    //   788	801	2664	java/net/SocketTimeoutException
    //   844	850	2664	java/net/SocketTimeoutException
    //   1226	1257	2664	java/net/SocketTimeoutException
    //   1273	1307	2664	java/net/SocketTimeoutException
    //   1323	1337	2664	java/net/SocketTimeoutException
    //   1353	1363	2664	java/net/SocketTimeoutException
    //   1381	1403	2664	java/net/SocketTimeoutException
    //   1431	1443	2664	java/net/SocketTimeoutException
    //   850	858	2687	java/net/SocketTimeoutException
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
          h.a("conn proxy host=" + str1 + "; port=" + i + "; mobile type=" + str2);
          h.d("conn proxy host=" + str1 + "; port=" + i + "; mobile type=" + str2);
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
  
  public f a()
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
    h.c("testlogfile:" + localStringBuffer);
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
    h.c("requestUploadFileEnc:" + localStringBuffer);
    return a(paramString1, "POST", localStringBuffer.toString(), true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gk
 * JD-Core Version:    0.7.0.1
 */