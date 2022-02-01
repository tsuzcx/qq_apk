package com.tencent.mobileqq.msf.core.net.patch;

import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class a
{
  public static final String a = "HttpDownloadUtil";
  public static final int b = 2;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 13;
  
  /* Error */
  private static int a(URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 34	java/lang/Object:<init>	()V
    //   12: astore 30
    //   14: iload_3
    //   15: istore 6
    //   17: iload_3
    //   18: ifge +6 -> 24
    //   21: iconst_2
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 19
    //   30: aload 19
    //   32: ifnull +17 -> 49
    //   35: aload 19
    //   37: invokevirtual 64	java/io/File:exists	()Z
    //   40: ifne +9 -> 49
    //   43: aload 19
    //   45: invokevirtual 67	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aconst_null
    //   50: astore 19
    //   52: aload_0
    //   53: invokevirtual 73	java/net/URL:toString	()Ljava/lang/String;
    //   56: astore 20
    //   58: new 75	org/apache/http/client/methods/HttpGet
    //   61: dup
    //   62: aload 20
    //   64: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   67: astore 29
    //   69: new 80	org/apache/http/params/BasicHttpParams
    //   72: dup
    //   73: invokespecial 81	org/apache/http/params/BasicHttpParams:<init>	()V
    //   76: astore 31
    //   78: sipush 20000
    //   81: istore 4
    //   83: ldc 82
    //   85: istore_3
    //   86: aload_2
    //   87: ifnull +97 -> 184
    //   90: invokestatic 87	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   93: astore 20
    //   95: invokestatic 91	android/net/Proxy:getDefaultPort	()I
    //   98: istore_3
    //   99: aload_2
    //   100: invokevirtual 96	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   103: astore 21
    //   105: aload_2
    //   106: invokestatic 102	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   109: ifeq +47 -> 156
    //   112: aload 21
    //   114: ifnull +13 -> 127
    //   117: aload 21
    //   119: ldc 104
    //   121: invokevirtual 110	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +32 -> 156
    //   127: aload 20
    //   129: ifnull +27 -> 156
    //   132: iload_3
    //   133: ifle +23 -> 156
    //   136: aload 31
    //   138: ldc 112
    //   140: new 114	org/apache/http/HttpHost
    //   143: dup
    //   144: aload 20
    //   146: iload_3
    //   147: invokespecial 117	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   150: invokeinterface 123 3 0
    //   155: pop
    //   156: aload_2
    //   157: invokestatic 102	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   160: ifeq +1036 -> 1196
    //   163: sipush 20000
    //   166: istore 4
    //   168: ldc 82
    //   170: istore_3
    //   171: aload 31
    //   173: ldc 125
    //   175: sipush 2048
    //   178: invokeinterface 129 3 0
    //   183: pop
    //   184: aload 31
    //   186: ldc 131
    //   188: iload 4
    //   190: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: invokeinterface 123 3 0
    //   198: pop
    //   199: aload 31
    //   201: ldc 139
    //   203: iload_3
    //   204: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokeinterface 123 3 0
    //   212: pop
    //   213: aload 29
    //   215: aload 31
    //   217: invokevirtual 143	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   220: aload_1
    //   221: ifnull +15 -> 236
    //   224: aload_1
    //   225: invokevirtual 64	java/io/File:exists	()Z
    //   228: ifeq +8 -> 236
    //   231: aload_1
    //   232: invokevirtual 146	java/io/File:delete	()Z
    //   235: pop
    //   236: aconst_null
    //   237: astore 21
    //   239: iconst_m1
    //   240: istore 7
    //   242: iload 7
    //   244: ifne +35 -> 279
    //   247: aload 31
    //   249: ldc 112
    //   251: new 114	org/apache/http/HttpHost
    //   254: dup
    //   255: aload_0
    //   256: invokevirtual 149	java/net/URL:getHost	()Ljava/lang/String;
    //   259: aload_0
    //   260: invokevirtual 152	java/net/URL:getPort	()I
    //   263: invokespecial 117	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   266: invokeinterface 123 3 0
    //   271: pop
    //   272: aload 29
    //   274: aload 31
    //   276: invokevirtual 143	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   279: iconst_5
    //   280: istore 4
    //   282: aload 21
    //   284: astore 23
    //   286: aload 19
    //   288: astore 22
    //   290: iload 4
    //   292: istore_3
    //   293: aload 21
    //   295: astore 26
    //   297: aload 19
    //   299: astore 24
    //   301: aload 21
    //   303: astore 27
    //   305: aload 19
    //   307: astore 25
    //   309: aload 21
    //   311: astore 28
    //   313: aload 19
    //   315: astore 20
    //   317: invokestatic 155	com/tencent/mobileqq/msf/core/net/patch/a:a	()Lorg/apache/http/client/HttpClient;
    //   320: new 114	org/apache/http/HttpHost
    //   323: dup
    //   324: aload_0
    //   325: invokevirtual 149	java/net/URL:getHost	()Ljava/lang/String;
    //   328: invokespecial 156	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   331: aload 29
    //   333: invokeinterface 162 3 0
    //   338: astore_2
    //   339: aload 21
    //   341: astore 23
    //   343: aload 19
    //   345: astore 22
    //   347: iload 4
    //   349: istore_3
    //   350: aload 21
    //   352: astore 26
    //   354: aload 19
    //   356: astore 24
    //   358: aload 21
    //   360: astore 27
    //   362: aload 19
    //   364: astore 25
    //   366: aload 21
    //   368: astore 28
    //   370: aload 19
    //   372: astore 20
    //   374: aload_2
    //   375: invokeinterface 168 1 0
    //   380: invokeinterface 173 1 0
    //   385: istore 5
    //   387: aload 21
    //   389: astore 23
    //   391: aload 19
    //   393: astore 22
    //   395: iload 4
    //   397: istore_3
    //   398: aload 21
    //   400: astore 26
    //   402: aload 19
    //   404: astore 24
    //   406: aload 21
    //   408: astore 27
    //   410: aload 19
    //   412: astore 25
    //   414: aload 21
    //   416: astore 28
    //   418: aload 19
    //   420: astore 20
    //   422: aload_2
    //   423: invokeinterface 177 1 0
    //   428: astore_2
    //   429: iload 5
    //   431: istore_3
    //   432: aload 19
    //   434: astore 24
    //   436: sipush 200
    //   439: iload 5
    //   441: if_icmpne +379 -> 820
    //   444: aload_2
    //   445: astore 23
    //   447: aload 19
    //   449: astore 22
    //   451: iload 4
    //   453: istore_3
    //   454: aload_2
    //   455: astore 26
    //   457: aload 19
    //   459: astore 24
    //   461: aload_2
    //   462: astore 27
    //   464: aload 19
    //   466: astore 25
    //   468: aload_2
    //   469: astore 28
    //   471: aload 19
    //   473: astore 20
    //   475: aload_2
    //   476: invokeinterface 182 1 0
    //   481: lstore 16
    //   483: lconst_0
    //   484: lstore 8
    //   486: aload_2
    //   487: astore 23
    //   489: aload 19
    //   491: astore 22
    //   493: iload 4
    //   495: istore_3
    //   496: aload_2
    //   497: astore 26
    //   499: aload 19
    //   501: astore 24
    //   503: aload_2
    //   504: astore 27
    //   506: aload 19
    //   508: astore 25
    //   510: new 184	java/io/BufferedOutputStream
    //   513: dup
    //   514: new 186	java/io/FileOutputStream
    //   517: dup
    //   518: aload_1
    //   519: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   522: invokespecial 192	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   525: astore 20
    //   527: lload 8
    //   529: lstore 10
    //   531: lload 8
    //   533: lstore 12
    //   535: aload 20
    //   537: astore 21
    //   539: aload 20
    //   541: astore 22
    //   543: aload 20
    //   545: astore 23
    //   547: aload_2
    //   548: aload 20
    //   550: invokeinterface 195 2 0
    //   555: lload 8
    //   557: lstore 10
    //   559: lload 8
    //   561: lstore 12
    //   563: aload 20
    //   565: astore 21
    //   567: aload 20
    //   569: astore 22
    //   571: aload 20
    //   573: astore 23
    //   575: aload 20
    //   577: invokevirtual 200	java/io/OutputStream:flush	()V
    //   580: lload 8
    //   582: lstore 10
    //   584: lload 8
    //   586: lstore 12
    //   588: aload 20
    //   590: astore 21
    //   592: aload 20
    //   594: astore 22
    //   596: aload 20
    //   598: astore 23
    //   600: aload_1
    //   601: invokevirtual 203	java/io/File:length	()J
    //   604: lstore 8
    //   606: lload 8
    //   608: lstore 10
    //   610: lload 8
    //   612: lstore 12
    //   614: aload 20
    //   616: astore 21
    //   618: aload 20
    //   620: astore 22
    //   622: aload 20
    //   624: astore 23
    //   626: aload_1
    //   627: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   630: invokevirtual 207	java/io/File:setLastModified	(J)Z
    //   633: pop
    //   634: lload 8
    //   636: lstore 10
    //   638: lload 8
    //   640: lstore 12
    //   642: aload 20
    //   644: astore 21
    //   646: aload 20
    //   648: astore 22
    //   650: aload 20
    //   652: astore 23
    //   654: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +72 -> 729
    //   660: lload 8
    //   662: lstore 10
    //   664: lload 8
    //   666: lstore 12
    //   668: aload 20
    //   670: astore 21
    //   672: aload 20
    //   674: astore 22
    //   676: aload 20
    //   678: astore 23
    //   680: ldc 8
    //   682: iconst_2
    //   683: new 214	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   690: ldc 217
    //   692: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   698: lload 14
    //   700: lsub
    //   701: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   704: ldc 226
    //   706: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: lload 8
    //   711: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: ldc 228
    //   716: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_0
    //   720: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: aload 20
    //   731: astore 19
    //   733: iconst_0
    //   734: istore_3
    //   735: iload_3
    //   736: istore 4
    //   738: lload 16
    //   740: lconst_0
    //   741: lcmp
    //   742: ifle +71 -> 813
    //   745: iload_3
    //   746: istore 4
    //   748: lload 8
    //   750: lload 16
    //   752: lcmp
    //   753: ifge +60 -> 813
    //   756: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   759: ifeq +50 -> 809
    //   762: ldc 8
    //   764: iconst_2
    //   765: new 214	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   772: ldc 237
    //   774: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: lload 16
    //   779: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   782: ldc 239
    //   784: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_1
    //   788: invokevirtual 203	java/io/File:length	()J
    //   791: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   794: ldc 241
    //   796: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_0
    //   800: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 244	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: bipush 8
    //   811: istore 4
    //   813: aload 19
    //   815: astore 24
    //   817: iload 4
    //   819: istore_3
    //   820: aload_2
    //   821: ifnull +9 -> 830
    //   824: aload_2
    //   825: invokeinterface 247 1 0
    //   830: aload 24
    //   832: ifnull +8 -> 840
    //   835: aload 24
    //   837: invokevirtual 250	java/io/OutputStream:close	()V
    //   840: iload_3
    //   841: istore 4
    //   843: aload_2
    //   844: astore 21
    //   846: aload 24
    //   848: astore 20
    //   850: iload_3
    //   851: ifeq +161 -> 1012
    //   854: iload_3
    //   855: istore 4
    //   857: aload_2
    //   858: astore 21
    //   860: aload 24
    //   862: astore 20
    //   864: aload_1
    //   865: ifnull +147 -> 1012
    //   868: iload_3
    //   869: istore 5
    //   871: aload_2
    //   872: astore 22
    //   874: aload 24
    //   876: astore 23
    //   878: aload_1
    //   879: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   882: astore 19
    //   884: aload 19
    //   886: ifnull +37 -> 923
    //   889: iload_3
    //   890: istore 5
    //   892: aload_2
    //   893: astore 22
    //   895: aload 24
    //   897: astore 23
    //   899: aload 19
    //   901: invokevirtual 64	java/io/File:exists	()Z
    //   904: ifne +19 -> 923
    //   907: iload_3
    //   908: istore 5
    //   910: aload_2
    //   911: astore 22
    //   913: aload 24
    //   915: astore 23
    //   917: aload 19
    //   919: invokevirtual 67	java/io/File:mkdirs	()Z
    //   922: pop
    //   923: iload_3
    //   924: istore 4
    //   926: aload_2
    //   927: astore 21
    //   929: aload 24
    //   931: astore 20
    //   933: iload_3
    //   934: istore 5
    //   936: aload_2
    //   937: astore 22
    //   939: aload 24
    //   941: astore 23
    //   943: aload_1
    //   944: invokevirtual 64	java/io/File:exists	()Z
    //   947: ifeq +65 -> 1012
    //   950: iload_3
    //   951: istore 5
    //   953: aload_2
    //   954: astore 22
    //   956: aload 24
    //   958: astore 23
    //   960: aload_1
    //   961: invokevirtual 146	java/io/File:delete	()Z
    //   964: istore 18
    //   966: iload_3
    //   967: istore 5
    //   969: aload_2
    //   970: astore 22
    //   972: aload 24
    //   974: astore 23
    //   976: ldc 8
    //   978: iconst_1
    //   979: new 214	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   986: ldc 252
    //   988: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: iload 18
    //   993: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   996: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1002: aload 24
    //   1004: astore 20
    //   1006: aload_2
    //   1007: astore 21
    //   1009: iload_3
    //   1010: istore 4
    //   1012: iload 7
    //   1014: iconst_1
    //   1015: iadd
    //   1016: istore 7
    //   1018: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +39 -> 1060
    //   1024: ldc 8
    //   1026: iconst_2
    //   1027: new 214	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 259
    //   1037: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: iload 4
    //   1042: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1045: ldc 241
    //   1047: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload_0
    //   1051: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: iload 4
    //   1062: ifeq +50 -> 1112
    //   1065: ldc 8
    //   1067: iconst_1
    //   1068: new 214	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1075: ldc_w 259
    //   1078: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: iload 4
    //   1083: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1086: ldc 241
    //   1088: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload_0
    //   1092: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1095: ldc_w 264
    //   1098: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: iload 7
    //   1103: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1106: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: iload 4
    //   1114: ifeq +23 -> 1137
    //   1117: iload 7
    //   1119: iconst_2
    //   1120: if_icmpge +17 -> 1137
    //   1123: aload 30
    //   1125: monitorenter
    //   1126: aload 30
    //   1128: ldc2_w 265
    //   1131: invokevirtual 270	java/lang/Object:wait	(J)V
    //   1134: aload 30
    //   1136: monitorexit
    //   1137: iload 4
    //   1139: ifeq +10 -> 1149
    //   1142: iload 7
    //   1144: iload 6
    //   1146: if_icmplt +1307 -> 2453
    //   1149: iload 4
    //   1151: ireturn
    //   1152: astore_0
    //   1153: ldc 8
    //   1155: iconst_1
    //   1156: ldc_w 272
    //   1159: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: iconst_4
    //   1163: ireturn
    //   1164: astore 21
    //   1166: new 75	org/apache/http/client/methods/HttpGet
    //   1169: dup
    //   1170: aload 20
    //   1172: invokestatic 275	com/tencent/mobileqq/msf/core/net/patch/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1175: invokespecial 78	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1178: astore 29
    //   1180: goto -1111 -> 69
    //   1183: astore_0
    //   1184: ldc 8
    //   1186: iconst_1
    //   1187: ldc_w 277
    //   1190: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1193: bipush 13
    //   1195: ireturn
    //   1196: sipush 10000
    //   1199: istore 4
    //   1201: sipush 30000
    //   1204: istore_3
    //   1205: aload 31
    //   1207: ldc 125
    //   1209: sipush 4096
    //   1212: invokeinterface 129 3 0
    //   1217: pop
    //   1218: goto -1034 -> 184
    //   1221: astore 19
    //   1223: lload 10
    //   1225: lstore 8
    //   1227: aload 20
    //   1229: astore 19
    //   1231: aload 19
    //   1233: astore 21
    //   1235: aload 19
    //   1237: astore 22
    //   1239: aload 19
    //   1241: astore 23
    //   1243: ldc 8
    //   1245: iconst_1
    //   1246: new 214	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1253: ldc_w 279
    //   1256: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload_1
    //   1260: invokevirtual 64	java/io/File:exists	()Z
    //   1263: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1266: ldc_w 281
    //   1269: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: aload_1
    //   1273: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1276: invokevirtual 64	java/io/File:exists	()Z
    //   1279: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1282: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1288: iconst_5
    //   1289: istore_3
    //   1290: goto -555 -> 735
    //   1293: astore 21
    //   1295: aload 20
    //   1297: astore 19
    //   1299: lload 12
    //   1301: lstore 8
    //   1303: aload_2
    //   1304: astore 23
    //   1306: aload 19
    //   1308: astore 22
    //   1310: iload 4
    //   1312: istore_3
    //   1313: aload_2
    //   1314: astore 26
    //   1316: aload 19
    //   1318: astore 24
    //   1320: aload_2
    //   1321: astore 27
    //   1323: aload 19
    //   1325: astore 25
    //   1327: aload_2
    //   1328: astore 28
    //   1330: aload 19
    //   1332: astore 20
    //   1334: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1337: ifeq +47 -> 1384
    //   1340: aload_2
    //   1341: astore 23
    //   1343: aload 19
    //   1345: astore 22
    //   1347: iload 4
    //   1349: istore_3
    //   1350: aload_2
    //   1351: astore 26
    //   1353: aload 19
    //   1355: astore 24
    //   1357: aload_2
    //   1358: astore 27
    //   1360: aload 19
    //   1362: astore 25
    //   1364: aload_2
    //   1365: astore 28
    //   1367: aload 19
    //   1369: astore 20
    //   1371: ldc 8
    //   1373: iconst_2
    //   1374: aload 21
    //   1376: invokevirtual 284	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1379: aload 21
    //   1381: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1384: iconst_4
    //   1385: istore_3
    //   1386: goto -651 -> 735
    //   1389: astore 21
    //   1391: iconst_5
    //   1392: istore_3
    //   1393: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1396: ifeq +31 -> 1427
    //   1399: ldc 8
    //   1401: iconst_2
    //   1402: new 214	java/lang/StringBuilder
    //   1405: dup
    //   1406: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1409: ldc_w 289
    //   1412: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload_0
    //   1416: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1419: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1422: aload 21
    //   1424: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1427: aload 21
    //   1429: instanceof 291
    //   1432: istore 18
    //   1434: iload 18
    //   1436: ifeq +217 -> 1653
    //   1439: bipush 10
    //   1441: istore_3
    //   1442: aload_2
    //   1443: ifnull +9 -> 1452
    //   1446: aload_2
    //   1447: invokeinterface 247 1 0
    //   1452: aload 19
    //   1454: ifnull +8 -> 1462
    //   1457: aload 19
    //   1459: invokevirtual 250	java/io/OutputStream:close	()V
    //   1462: iload_3
    //   1463: istore 4
    //   1465: aload_2
    //   1466: astore 21
    //   1468: aload 19
    //   1470: astore 20
    //   1472: iload_3
    //   1473: ifeq -461 -> 1012
    //   1476: iload_3
    //   1477: istore 4
    //   1479: aload_2
    //   1480: astore 21
    //   1482: aload 19
    //   1484: astore 20
    //   1486: aload_1
    //   1487: ifnull -475 -> 1012
    //   1490: iload_3
    //   1491: istore 5
    //   1493: aload_2
    //   1494: astore 22
    //   1496: aload 19
    //   1498: astore 23
    //   1500: aload_1
    //   1501: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1504: astore 20
    //   1506: aload 20
    //   1508: ifnull +37 -> 1545
    //   1511: iload_3
    //   1512: istore 5
    //   1514: aload_2
    //   1515: astore 22
    //   1517: aload 19
    //   1519: astore 23
    //   1521: aload 20
    //   1523: invokevirtual 64	java/io/File:exists	()Z
    //   1526: ifne +19 -> 1545
    //   1529: iload_3
    //   1530: istore 5
    //   1532: aload_2
    //   1533: astore 22
    //   1535: aload 19
    //   1537: astore 23
    //   1539: aload 20
    //   1541: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1544: pop
    //   1545: iload_3
    //   1546: istore 4
    //   1548: aload_2
    //   1549: astore 21
    //   1551: aload 19
    //   1553: astore 20
    //   1555: iload_3
    //   1556: istore 5
    //   1558: aload_2
    //   1559: astore 22
    //   1561: aload 19
    //   1563: astore 23
    //   1565: aload_1
    //   1566: invokevirtual 64	java/io/File:exists	()Z
    //   1569: ifeq -557 -> 1012
    //   1572: iload_3
    //   1573: istore 5
    //   1575: aload_2
    //   1576: astore 22
    //   1578: aload 19
    //   1580: astore 23
    //   1582: aload_1
    //   1583: invokevirtual 146	java/io/File:delete	()Z
    //   1586: istore 18
    //   1588: iload_3
    //   1589: istore 5
    //   1591: aload_2
    //   1592: astore 22
    //   1594: aload 19
    //   1596: astore 23
    //   1598: ldc 8
    //   1600: iconst_1
    //   1601: new 214	java/lang/StringBuilder
    //   1604: dup
    //   1605: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1608: ldc 252
    //   1610: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: iload 18
    //   1615: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1618: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1621: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1624: iload_3
    //   1625: istore 4
    //   1627: aload_2
    //   1628: astore 21
    //   1630: aload 19
    //   1632: astore 20
    //   1634: goto -622 -> 1012
    //   1637: astore_2
    //   1638: iload 5
    //   1640: istore 4
    //   1642: aload 22
    //   1644: astore 21
    //   1646: aload 23
    //   1648: astore 20
    //   1650: goto -638 -> 1012
    //   1653: aload 21
    //   1655: instanceof 293
    //   1658: ifne +802 -> 2460
    //   1661: aload 21
    //   1663: instanceof 295
    //   1666: ifeq +6 -> 1672
    //   1669: goto +791 -> 2460
    //   1672: aload 21
    //   1674: instanceof 297
    //   1677: istore 18
    //   1679: iload 18
    //   1681: ifeq +9 -> 1690
    //   1684: bipush 11
    //   1686: istore_3
    //   1687: goto -245 -> 1442
    //   1690: iconst_4
    //   1691: istore_3
    //   1692: goto -250 -> 1442
    //   1695: astore 20
    //   1697: aload 21
    //   1699: astore 19
    //   1701: aload_2
    //   1702: astore 23
    //   1704: aload 19
    //   1706: astore 22
    //   1708: iload 4
    //   1710: istore_3
    //   1711: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1714: ifeq +41 -> 1755
    //   1717: aload_2
    //   1718: astore 23
    //   1720: aload 19
    //   1722: astore 22
    //   1724: iload 4
    //   1726: istore_3
    //   1727: ldc 8
    //   1729: iconst_2
    //   1730: new 214	java/lang/StringBuilder
    //   1733: dup
    //   1734: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1737: ldc_w 299
    //   1740: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: aload_0
    //   1744: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1747: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1750: aload 20
    //   1752: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1755: iconst_5
    //   1756: istore_3
    //   1757: aload_2
    //   1758: ifnull +9 -> 1767
    //   1761: aload_2
    //   1762: invokeinterface 247 1 0
    //   1767: aload 19
    //   1769: ifnull +8 -> 1777
    //   1772: aload 19
    //   1774: invokevirtual 250	java/io/OutputStream:close	()V
    //   1777: iload_3
    //   1778: istore 4
    //   1780: aload_2
    //   1781: astore 21
    //   1783: aload 19
    //   1785: astore 20
    //   1787: aload_1
    //   1788: ifnull -776 -> 1012
    //   1791: iload_3
    //   1792: istore 5
    //   1794: aload_2
    //   1795: astore 22
    //   1797: aload 19
    //   1799: astore 23
    //   1801: aload_1
    //   1802: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   1805: astore 20
    //   1807: aload 20
    //   1809: ifnull +37 -> 1846
    //   1812: iload_3
    //   1813: istore 5
    //   1815: aload_2
    //   1816: astore 22
    //   1818: aload 19
    //   1820: astore 23
    //   1822: aload 20
    //   1824: invokevirtual 64	java/io/File:exists	()Z
    //   1827: ifne +19 -> 1846
    //   1830: iload_3
    //   1831: istore 5
    //   1833: aload_2
    //   1834: astore 22
    //   1836: aload 19
    //   1838: astore 23
    //   1840: aload 20
    //   1842: invokevirtual 67	java/io/File:mkdirs	()Z
    //   1845: pop
    //   1846: iload_3
    //   1847: istore 4
    //   1849: aload_2
    //   1850: astore 21
    //   1852: aload 19
    //   1854: astore 20
    //   1856: iload_3
    //   1857: istore 5
    //   1859: aload_2
    //   1860: astore 22
    //   1862: aload 19
    //   1864: astore 23
    //   1866: aload_1
    //   1867: invokevirtual 64	java/io/File:exists	()Z
    //   1870: ifeq -858 -> 1012
    //   1873: iload_3
    //   1874: istore 5
    //   1876: aload_2
    //   1877: astore 22
    //   1879: aload 19
    //   1881: astore 23
    //   1883: aload_1
    //   1884: invokevirtual 146	java/io/File:delete	()Z
    //   1887: istore 18
    //   1889: iload_3
    //   1890: istore 5
    //   1892: aload_2
    //   1893: astore 22
    //   1895: aload 19
    //   1897: astore 23
    //   1899: ldc 8
    //   1901: iconst_1
    //   1902: new 214	java/lang/StringBuilder
    //   1905: dup
    //   1906: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1909: ldc 252
    //   1911: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: iload 18
    //   1916: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1919: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1922: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1925: iload_3
    //   1926: istore 4
    //   1928: aload_2
    //   1929: astore 21
    //   1931: aload 19
    //   1933: astore 20
    //   1935: goto -923 -> 1012
    //   1938: astore 20
    //   1940: aload 22
    //   1942: astore 19
    //   1944: aload_2
    //   1945: astore 23
    //   1947: aload 19
    //   1949: astore 22
    //   1951: iload 4
    //   1953: istore_3
    //   1954: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1957: ifeq +41 -> 1998
    //   1960: aload_2
    //   1961: astore 23
    //   1963: aload 19
    //   1965: astore 22
    //   1967: iload 4
    //   1969: istore_3
    //   1970: ldc 8
    //   1972: iconst_2
    //   1973: new 214	java/lang/StringBuilder
    //   1976: dup
    //   1977: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1980: ldc_w 299
    //   1983: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: aload_0
    //   1987: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1990: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: aload 20
    //   1995: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1998: iconst_5
    //   1999: istore_3
    //   2000: aload_2
    //   2001: ifnull +9 -> 2010
    //   2004: aload_2
    //   2005: invokeinterface 247 1 0
    //   2010: aload 19
    //   2012: ifnull +8 -> 2020
    //   2015: aload 19
    //   2017: invokevirtual 250	java/io/OutputStream:close	()V
    //   2020: iload_3
    //   2021: istore 4
    //   2023: aload_2
    //   2024: astore 21
    //   2026: aload 19
    //   2028: astore 20
    //   2030: aload_1
    //   2031: ifnull -1019 -> 1012
    //   2034: iload_3
    //   2035: istore 5
    //   2037: aload_2
    //   2038: astore 22
    //   2040: aload 19
    //   2042: astore 23
    //   2044: aload_1
    //   2045: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   2048: astore 20
    //   2050: aload 20
    //   2052: ifnull +37 -> 2089
    //   2055: iload_3
    //   2056: istore 5
    //   2058: aload_2
    //   2059: astore 22
    //   2061: aload 19
    //   2063: astore 23
    //   2065: aload 20
    //   2067: invokevirtual 64	java/io/File:exists	()Z
    //   2070: ifne +19 -> 2089
    //   2073: iload_3
    //   2074: istore 5
    //   2076: aload_2
    //   2077: astore 22
    //   2079: aload 19
    //   2081: astore 23
    //   2083: aload 20
    //   2085: invokevirtual 67	java/io/File:mkdirs	()Z
    //   2088: pop
    //   2089: iload_3
    //   2090: istore 4
    //   2092: aload_2
    //   2093: astore 21
    //   2095: aload 19
    //   2097: astore 20
    //   2099: iload_3
    //   2100: istore 5
    //   2102: aload_2
    //   2103: astore 22
    //   2105: aload 19
    //   2107: astore 23
    //   2109: aload_1
    //   2110: invokevirtual 64	java/io/File:exists	()Z
    //   2113: ifeq -1101 -> 1012
    //   2116: iload_3
    //   2117: istore 5
    //   2119: aload_2
    //   2120: astore 22
    //   2122: aload 19
    //   2124: astore 23
    //   2126: aload_1
    //   2127: invokevirtual 146	java/io/File:delete	()Z
    //   2130: istore 18
    //   2132: iload_3
    //   2133: istore 5
    //   2135: aload_2
    //   2136: astore 22
    //   2138: aload 19
    //   2140: astore 23
    //   2142: ldc 8
    //   2144: iconst_1
    //   2145: new 214	java/lang/StringBuilder
    //   2148: dup
    //   2149: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   2152: ldc 252
    //   2154: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: iload 18
    //   2159: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2162: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2165: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2168: iload_3
    //   2169: istore 4
    //   2171: aload_2
    //   2172: astore 21
    //   2174: aload 19
    //   2176: astore 20
    //   2178: goto -1166 -> 1012
    //   2181: astore_0
    //   2182: aload 23
    //   2184: astore 19
    //   2186: iload 4
    //   2188: istore_3
    //   2189: aload_2
    //   2190: ifnull +9 -> 2199
    //   2193: aload_2
    //   2194: invokeinterface 247 1 0
    //   2199: aload 19
    //   2201: ifnull +8 -> 2209
    //   2204: aload 19
    //   2206: invokevirtual 250	java/io/OutputStream:close	()V
    //   2209: iload_3
    //   2210: ifeq +67 -> 2277
    //   2213: aload_1
    //   2214: ifnull +63 -> 2277
    //   2217: aload_1
    //   2218: invokevirtual 60	java/io/File:getParentFile	()Ljava/io/File;
    //   2221: astore_2
    //   2222: aload_2
    //   2223: ifnull +15 -> 2238
    //   2226: aload_2
    //   2227: invokevirtual 64	java/io/File:exists	()Z
    //   2230: ifne +8 -> 2238
    //   2233: aload_2
    //   2234: invokevirtual 67	java/io/File:mkdirs	()Z
    //   2237: pop
    //   2238: aload_1
    //   2239: invokevirtual 64	java/io/File:exists	()Z
    //   2242: ifeq +35 -> 2277
    //   2245: aload_1
    //   2246: invokevirtual 146	java/io/File:delete	()Z
    //   2249: istore 18
    //   2251: ldc 8
    //   2253: iconst_1
    //   2254: new 214	java/lang/StringBuilder
    //   2257: dup
    //   2258: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   2261: ldc 252
    //   2263: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: iload 18
    //   2268: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2271: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2274: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2277: aload_0
    //   2278: athrow
    //   2279: astore_0
    //   2280: aload 30
    //   2282: monitorexit
    //   2283: aload_0
    //   2284: athrow
    //   2285: astore_2
    //   2286: goto -1152 -> 1134
    //   2289: astore_2
    //   2290: aload_2
    //   2291: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2294: goto -95 -> 2199
    //   2297: astore_2
    //   2298: goto -89 -> 2209
    //   2301: astore 20
    //   2303: aload 20
    //   2305: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2308: goto -856 -> 1452
    //   2311: astore 20
    //   2313: goto -851 -> 1462
    //   2316: astore 20
    //   2318: aload 20
    //   2320: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2323: goto -556 -> 1767
    //   2326: astore 20
    //   2328: goto -551 -> 1777
    //   2331: astore 20
    //   2333: aload 20
    //   2335: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2338: goto -328 -> 2010
    //   2341: astore 20
    //   2343: goto -323 -> 2020
    //   2346: astore 19
    //   2348: aload 19
    //   2350: invokevirtual 302	java/io/IOException:printStackTrace	()V
    //   2353: goto -1523 -> 830
    //   2356: astore 19
    //   2358: goto -1518 -> 840
    //   2361: astore_1
    //   2362: goto -85 -> 2277
    //   2365: astore_0
    //   2366: aload 23
    //   2368: astore_2
    //   2369: aload 22
    //   2371: astore 19
    //   2373: goto -184 -> 2189
    //   2376: astore_0
    //   2377: goto -188 -> 2189
    //   2380: astore_0
    //   2381: goto -192 -> 2189
    //   2384: astore 20
    //   2386: aload 26
    //   2388: astore_2
    //   2389: aload 24
    //   2391: astore 19
    //   2393: goto -449 -> 1944
    //   2396: astore 20
    //   2398: iload_3
    //   2399: istore 4
    //   2401: goto -457 -> 1944
    //   2404: astore 20
    //   2406: aload 27
    //   2408: astore_2
    //   2409: aload 25
    //   2411: astore 19
    //   2413: goto -712 -> 1701
    //   2416: astore 20
    //   2418: iload_3
    //   2419: istore 4
    //   2421: goto -720 -> 1701
    //   2424: astore 21
    //   2426: iconst_5
    //   2427: istore_3
    //   2428: aload 28
    //   2430: astore_2
    //   2431: aload 20
    //   2433: astore 19
    //   2435: goto -1042 -> 1393
    //   2438: astore 21
    //   2440: goto -1047 -> 1393
    //   2443: astore 21
    //   2445: goto -1142 -> 1303
    //   2448: astore 20
    //   2450: goto -1219 -> 1231
    //   2453: aload 20
    //   2455: astore 19
    //   2457: goto -2215 -> 242
    //   2460: iconst_2
    //   2461: istore_3
    //   2462: goto -1020 -> 1442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2465	0	paramURL	URL
    //   0	2465	1	paramFile	File
    //   0	2465	2	paramNetworkInfo	NetworkInfo
    //   0	2465	3	paramInt	int
    //   81	2339	4	m	int
    //   385	1749	5	n	int
    //   15	1132	6	i1	int
    //   240	907	7	i2	int
    //   484	818	8	l1	long
    //   529	695	10	l2	long
    //   533	767	12	l3	long
    //   3	696	14	l4	long
    //   481	297	16	l5	long
    //   964	1303	18	bool	boolean
    //   28	890	19	localObject1	Object
    //   1221	1	19	localFileNotFoundException1	java.io.FileNotFoundException
    //   1229	976	19	localObject2	Object
    //   2346	3	19	localIOException1	java.io.IOException
    //   2356	1	19	localIOException2	java.io.IOException
    //   2371	85	19	localObject3	Object
    //   56	1593	20	localObject4	Object
    //   1695	56	20	localException1	Exception
    //   1785	149	20	localObject5	Object
    //   1938	56	20	localThrowable1	java.lang.Throwable
    //   2028	149	20	localObject6	Object
    //   2301	3	20	localIOException3	java.io.IOException
    //   2311	1	20	localIOException4	java.io.IOException
    //   2316	3	20	localIOException5	java.io.IOException
    //   2326	1	20	localIOException6	java.io.IOException
    //   2331	3	20	localIOException7	java.io.IOException
    //   2341	1	20	localIOException8	java.io.IOException
    //   2384	1	20	localThrowable2	java.lang.Throwable
    //   2396	1	20	localThrowable3	java.lang.Throwable
    //   2404	1	20	localException2	Exception
    //   2416	16	20	localException3	Exception
    //   2448	6	20	localFileNotFoundException2	java.io.FileNotFoundException
    //   103	905	21	localObject7	Object
    //   1164	1	21	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1233	1	21	localObject8	Object
    //   1293	87	21	localIOException9	java.io.IOException
    //   1389	39	21	localIOException10	java.io.IOException
    //   1466	707	21	localObject9	Object
    //   2424	1	21	localIOException11	java.io.IOException
    //   2438	1	21	localIOException12	java.io.IOException
    //   2443	1	21	localIOException13	java.io.IOException
    //   288	2082	22	localObject10	Object
    //   284	2083	23	localObject11	Object
    //   299	2091	24	localObject12	Object
    //   307	2103	25	localObject13	Object
    //   295	2092	26	localObject14	Object
    //   303	2104	27	localObject15	Object
    //   311	2118	28	localObject16	Object
    //   67	1112	29	localHttpGet	org.apache.http.client.methods.HttpGet
    //   12	2269	30	localObject17	Object
    //   76	1130	31	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   24	30	1152	java/lang/Exception
    //   35	49	1152	java/lang/Exception
    //   58	69	1164	java/lang/IllegalArgumentException
    //   1166	1180	1183	java/lang/IllegalArgumentException
    //   547	555	1221	java/io/FileNotFoundException
    //   575	580	1221	java/io/FileNotFoundException
    //   600	606	1221	java/io/FileNotFoundException
    //   626	634	1221	java/io/FileNotFoundException
    //   654	660	1221	java/io/FileNotFoundException
    //   680	729	1221	java/io/FileNotFoundException
    //   547	555	1293	java/io/IOException
    //   575	580	1293	java/io/IOException
    //   600	606	1293	java/io/IOException
    //   626	634	1293	java/io/IOException
    //   654	660	1293	java/io/IOException
    //   680	729	1293	java/io/IOException
    //   1243	1288	1389	java/io/IOException
    //   878	884	1637	java/lang/Exception
    //   899	907	1637	java/lang/Exception
    //   917	923	1637	java/lang/Exception
    //   943	950	1637	java/lang/Exception
    //   960	966	1637	java/lang/Exception
    //   976	1002	1637	java/lang/Exception
    //   1500	1506	1637	java/lang/Exception
    //   1521	1529	1637	java/lang/Exception
    //   1539	1545	1637	java/lang/Exception
    //   1565	1572	1637	java/lang/Exception
    //   1582	1588	1637	java/lang/Exception
    //   1598	1624	1637	java/lang/Exception
    //   1801	1807	1637	java/lang/Exception
    //   1822	1830	1637	java/lang/Exception
    //   1840	1846	1637	java/lang/Exception
    //   1866	1873	1637	java/lang/Exception
    //   1883	1889	1637	java/lang/Exception
    //   1899	1925	1637	java/lang/Exception
    //   2044	2050	1637	java/lang/Exception
    //   2065	2073	1637	java/lang/Exception
    //   2083	2089	1637	java/lang/Exception
    //   2109	2116	1637	java/lang/Exception
    //   2126	2132	1637	java/lang/Exception
    //   2142	2168	1637	java/lang/Exception
    //   547	555	1695	java/lang/Exception
    //   575	580	1695	java/lang/Exception
    //   600	606	1695	java/lang/Exception
    //   626	634	1695	java/lang/Exception
    //   654	660	1695	java/lang/Exception
    //   680	729	1695	java/lang/Exception
    //   1243	1288	1695	java/lang/Exception
    //   547	555	1938	java/lang/Throwable
    //   575	580	1938	java/lang/Throwable
    //   600	606	1938	java/lang/Throwable
    //   626	634	1938	java/lang/Throwable
    //   654	660	1938	java/lang/Throwable
    //   680	729	1938	java/lang/Throwable
    //   1243	1288	1938	java/lang/Throwable
    //   547	555	2181	finally
    //   575	580	2181	finally
    //   600	606	2181	finally
    //   626	634	2181	finally
    //   654	660	2181	finally
    //   680	729	2181	finally
    //   1243	1288	2181	finally
    //   1126	1134	2279	finally
    //   1134	1137	2279	finally
    //   2280	2283	2279	finally
    //   1126	1134	2285	java/lang/InterruptedException
    //   2193	2199	2289	java/io/IOException
    //   2204	2209	2297	java/io/IOException
    //   1446	1452	2301	java/io/IOException
    //   1457	1462	2311	java/io/IOException
    //   1761	1767	2316	java/io/IOException
    //   1772	1777	2326	java/io/IOException
    //   2004	2010	2331	java/io/IOException
    //   2015	2020	2341	java/io/IOException
    //   824	830	2346	java/io/IOException
    //   835	840	2356	java/io/IOException
    //   2217	2222	2361	java/lang/Exception
    //   2226	2238	2361	java/lang/Exception
    //   2238	2277	2361	java/lang/Exception
    //   317	339	2365	finally
    //   374	387	2365	finally
    //   422	429	2365	finally
    //   475	483	2365	finally
    //   510	527	2365	finally
    //   1334	1340	2365	finally
    //   1371	1384	2365	finally
    //   1711	1717	2365	finally
    //   1727	1755	2365	finally
    //   1954	1960	2365	finally
    //   1970	1998	2365	finally
    //   756	809	2376	finally
    //   1393	1427	2380	finally
    //   1427	1434	2380	finally
    //   1653	1669	2380	finally
    //   1672	1679	2380	finally
    //   317	339	2384	java/lang/Throwable
    //   374	387	2384	java/lang/Throwable
    //   422	429	2384	java/lang/Throwable
    //   475	483	2384	java/lang/Throwable
    //   510	527	2384	java/lang/Throwable
    //   1334	1340	2384	java/lang/Throwable
    //   1371	1384	2384	java/lang/Throwable
    //   756	809	2396	java/lang/Throwable
    //   317	339	2404	java/lang/Exception
    //   374	387	2404	java/lang/Exception
    //   422	429	2404	java/lang/Exception
    //   475	483	2404	java/lang/Exception
    //   510	527	2404	java/lang/Exception
    //   1334	1340	2404	java/lang/Exception
    //   1371	1384	2404	java/lang/Exception
    //   756	809	2416	java/lang/Exception
    //   317	339	2424	java/io/IOException
    //   374	387	2424	java/io/IOException
    //   422	429	2424	java/io/IOException
    //   475	483	2424	java/io/IOException
    //   1334	1340	2424	java/io/IOException
    //   1371	1384	2424	java/io/IOException
    //   756	809	2438	java/io/IOException
    //   510	527	2443	java/io/IOException
    //   510	527	2448	java/io/FileNotFoundException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  private static HttpClient a()
  {
    Object localObject = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset((HttpParams)localObject, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue((HttpParams)localObject, true);
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      }
      for (;;)
      {
        localObject = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, localSchemeRegistry), (HttpParams)localObject);
        ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        return localObject;
        localSchemeRegistry.register(new Scheme("https", new b(a.class.getSimpleName()), 443));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    l1 = System.currentTimeMillis();
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    str = paramString2 + System.currentTimeMillis() + ".tmp";
    File localFile = new File(str);
    try
    {
      URL localURL = new URL(paramString1);
      int m = a(localURL, localFile, localNetworkInfo, 2);
      if (m == 0) {}
      return false;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      try
      {
        localFile.renameTo(new File(paramString2));
        PatchReporter.reportPatchDownload(paramString1, paramString2, str, m, 0, System.currentTimeMillis() - l1);
        if (m == 0) {
          bool = true;
        }
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        PatchReporter.reportPatchDownload(paramString1, paramString2, str, 5002, 0, System.currentTimeMillis() - l1);
      }
      localMalformedURLException = localMalformedURLException;
      localMalformedURLException.printStackTrace();
      PatchReporter.reportPatchDownload(paramString1, paramString2, str, 5001, 0, 0L);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.a
 * JD-Core Version:    0.7.0.1
 */