package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpDownloadUtil
{
  public static final int a = 2;
  static long jdField_a_of_type_Long = ;
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  static HttpDownloadUtil.IdleConnectionMonitorThread jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread;
  public static final String a = "HttpDownloadUtil";
  public static final DefaultHttpClient a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  @Deprecated
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  public static final int o = 12;
  public static final int p = 13;
  public static final int q = 14;
  public static final int r = 15;
  public static final int s = 16;
  public static final int t = 17;
  public static final int u = 18;
  public static final int v = 19;
  
  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
    jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
    jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
    jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
    jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread.start();
    jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    jdField_b_of_type_JavaLangString = null;
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: new 183	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore 27
    //   13: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   16: lstore 12
    //   18: new 4	java/lang/Object
    //   21: dup
    //   22: invokespecial 170	java/lang/Object:<init>	()V
    //   25: astore 28
    //   27: aload_1
    //   28: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   31: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   34: astore 17
    //   36: aload 17
    //   38: ifnull +143 -> 181
    //   41: aload 17
    //   43: invokevirtual 202	java/io/File:exists	()Z
    //   46: ifne +135 -> 181
    //   49: aload 17
    //   51: invokevirtual 205	java/io/File:mkdirs	()Z
    //   54: ifne +127 -> 181
    //   57: aload_3
    //   58: ifnull +15 -> 73
    //   61: aload_3
    //   62: aload 27
    //   64: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   67: iconst_4
    //   68: invokeinterface 214 3 0
    //   73: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +31 -> 107
    //   79: ldc 15
    //   81: iconst_2
    //   82: new 221	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   89: ldc 224
    //   91: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: iconst_4
    //   108: istore 6
    //   110: iload 6
    //   112: ireturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 235	java/net/MalformedURLException:printStackTrace	()V
    //   118: aload_1
    //   119: aload_0
    //   120: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   123: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   126: iconst_5
    //   127: ireturn
    //   128: astore_0
    //   129: aload_3
    //   130: ifnull +15 -> 145
    //   133: aload_3
    //   134: aload 27
    //   136: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   139: iconst_4
    //   140: invokeinterface 214 3 0
    //   145: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +31 -> 179
    //   151: ldc 15
    //   153: iconst_2
    //   154: new 221	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   161: ldc 224
    //   163: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: iconst_4
    //   180: ireturn
    //   181: aconst_null
    //   182: astore 19
    //   184: aload_1
    //   185: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: astore 17
    //   190: new 245	org/apache/http/client/methods/HttpGet
    //   193: dup
    //   194: aload 17
    //   196: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   199: astore 26
    //   201: new 70	org/apache/http/params/BasicHttpParams
    //   204: dup
    //   205: invokespecial 73	org/apache/http/params/BasicHttpParams:<init>	()V
    //   208: astore 29
    //   210: aload 29
    //   212: ldc 248
    //   214: ldc 249
    //   216: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: invokeinterface 260 3 0
    //   224: pop
    //   225: aload 29
    //   227: ldc_w 262
    //   230: ldc 249
    //   232: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 260 3 0
    //   240: pop
    //   241: invokestatic 267	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   244: astore 17
    //   246: invokestatic 271	android/net/Proxy:getDefaultPort	()I
    //   249: istore 5
    //   251: iconst_0
    //   252: istore 4
    //   254: aload_2
    //   255: ifnull +96 -> 351
    //   258: aload_2
    //   259: invokevirtual 276	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   262: astore 18
    //   264: aload_2
    //   265: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   268: ifeq +51 -> 319
    //   271: aload 18
    //   273: ifnull +14 -> 287
    //   276: aload 18
    //   278: ldc_w 283
    //   281: invokevirtual 287	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   284: ifeq +35 -> 319
    //   287: aload 17
    //   289: ifnull +30 -> 319
    //   292: iload 5
    //   294: ifle +25 -> 319
    //   297: aload 29
    //   299: ldc_w 289
    //   302: new 291	org/apache/http/HttpHost
    //   305: dup
    //   306: aload 17
    //   308: iload 5
    //   310: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   313: invokeinterface 260 3 0
    //   318: pop
    //   319: aload_2
    //   320: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   323: ifeq +574 -> 897
    //   326: sipush 2048
    //   329: istore 4
    //   331: aload 29
    //   333: ldc_w 295
    //   336: iload 4
    //   338: invokeinterface 299 3 0
    //   343: pop
    //   344: aload 26
    //   346: aload 29
    //   348: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   351: new 194	java/io/File
    //   354: dup
    //   355: aload_1
    //   356: invokevirtual 305	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   359: invokespecial 306	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 30
    //   364: aload 30
    //   366: invokevirtual 202	java/io/File:exists	()Z
    //   369: ifeq +9 -> 378
    //   372: aload 30
    //   374: invokevirtual 309	java/io/File:delete	()Z
    //   377: pop
    //   378: aconst_null
    //   379: astore 17
    //   381: iconst_m1
    //   382: istore 9
    //   384: iconst_5
    //   385: istore 10
    //   387: iload 9
    //   389: ifne +38 -> 427
    //   392: aload 29
    //   394: ldc_w 289
    //   397: new 291	org/apache/http/HttpHost
    //   400: dup
    //   401: aload 27
    //   403: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   406: aload 27
    //   408: invokevirtual 315	java/net/URL:getPort	()I
    //   411: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   414: invokeinterface 260 3 0
    //   419: pop
    //   420: aload 26
    //   422: aload 29
    //   424: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   427: aload 19
    //   429: astore 24
    //   431: aload 17
    //   433: astore 20
    //   435: iload 4
    //   437: istore 6
    //   439: aload 19
    //   441: astore 23
    //   443: aload 17
    //   445: astore 21
    //   447: iload 4
    //   449: istore 8
    //   451: aload 19
    //   453: astore 25
    //   455: aload 17
    //   457: astore 22
    //   459: iload 10
    //   461: istore 7
    //   463: getstatic 127	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   466: new 291	org/apache/http/HttpHost
    //   469: dup
    //   470: aload 27
    //   472: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   475: invokespecial 316	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   478: aload 26
    //   480: invokevirtual 320	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   483: astore 18
    //   485: aload 19
    //   487: astore 24
    //   489: aload 17
    //   491: astore 20
    //   493: iload 4
    //   495: istore 6
    //   497: aload 19
    //   499: astore 23
    //   501: aload 17
    //   503: astore 21
    //   505: iload 4
    //   507: istore 8
    //   509: aload 19
    //   511: astore 25
    //   513: aload 17
    //   515: astore 22
    //   517: iload 10
    //   519: istore 7
    //   521: aload 18
    //   523: invokeinterface 326 1 0
    //   528: astore 31
    //   530: aload 19
    //   532: astore 24
    //   534: aload 17
    //   536: astore 20
    //   538: iload 4
    //   540: istore 6
    //   542: aload 19
    //   544: astore 23
    //   546: aload 17
    //   548: astore 21
    //   550: iload 4
    //   552: istore 8
    //   554: aload 19
    //   556: astore 25
    //   558: aload 17
    //   560: astore 22
    //   562: iload 10
    //   564: istore 7
    //   566: aload 18
    //   568: invokeinterface 330 1 0
    //   573: pop
    //   574: aload 19
    //   576: astore 24
    //   578: aload 17
    //   580: astore 20
    //   582: iload 4
    //   584: istore 6
    //   586: aload 19
    //   588: astore 23
    //   590: aload 17
    //   592: astore 21
    //   594: iload 4
    //   596: istore 8
    //   598: aload 19
    //   600: astore 25
    //   602: aload 17
    //   604: astore 22
    //   606: iload 10
    //   608: istore 7
    //   610: aload 31
    //   612: invokeinterface 335 1 0
    //   617: istore 5
    //   619: aload_3
    //   620: ifnull +52 -> 672
    //   623: aload 19
    //   625: astore 24
    //   627: aload 17
    //   629: astore 20
    //   631: iload 4
    //   633: istore 6
    //   635: aload 19
    //   637: astore 23
    //   639: aload 17
    //   641: astore 21
    //   643: iload 4
    //   645: istore 8
    //   647: aload 19
    //   649: astore 25
    //   651: aload 17
    //   653: astore 22
    //   655: iload 10
    //   657: istore 7
    //   659: aload_3
    //   660: aload 27
    //   662: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   665: iload 5
    //   667: invokeinterface 337 3 0
    //   672: aload 19
    //   674: astore 24
    //   676: aload 17
    //   678: astore 20
    //   680: iload 4
    //   682: istore 6
    //   684: aload 19
    //   686: astore 23
    //   688: aload 17
    //   690: astore 21
    //   692: iload 4
    //   694: istore 8
    //   696: aload 19
    //   698: astore 25
    //   700: aload 17
    //   702: astore 22
    //   704: iload 10
    //   706: istore 7
    //   708: aload 18
    //   710: invokeinterface 341 1 0
    //   715: astore 17
    //   717: sipush 200
    //   720: iload 5
    //   722: if_icmpne +1434 -> 2156
    //   725: aload 19
    //   727: astore 24
    //   729: aload 17
    //   731: astore 20
    //   733: iload 4
    //   735: istore 6
    //   737: aload 19
    //   739: astore 23
    //   741: aload 17
    //   743: astore 21
    //   745: iload 4
    //   747: istore 8
    //   749: aload 19
    //   751: astore 25
    //   753: aload 17
    //   755: astore 22
    //   757: iload 10
    //   759: istore 7
    //   761: aload 17
    //   763: invokeinterface 346 1 0
    //   768: lstore 14
    //   770: aconst_null
    //   771: astore 20
    //   773: iconst_0
    //   774: istore 5
    //   776: new 348	java/io/FileOutputStream
    //   779: dup
    //   780: aload 30
    //   782: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   785: astore 18
    //   787: aload 17
    //   789: invokeinterface 355 1 0
    //   794: astore 19
    //   796: aload 19
    //   798: astore 20
    //   800: iload 4
    //   802: ifne +1889 -> 2691
    //   805: sipush 2048
    //   808: istore 4
    //   810: iload 4
    //   812: newarray byte
    //   814: astore 19
    //   816: iload 5
    //   818: i2l
    //   819: lload 14
    //   821: lcmp
    //   822: ifge +83 -> 905
    //   825: aload 20
    //   827: aload 19
    //   829: invokevirtual 361	java/io/InputStream:read	([B)I
    //   832: istore 6
    //   834: aload 18
    //   836: aload 19
    //   838: iconst_0
    //   839: iload 6
    //   841: invokevirtual 367	java/io/OutputStream:write	([BII)V
    //   844: iload 5
    //   846: iload 6
    //   848: iadd
    //   849: istore 5
    //   851: aload_3
    //   852: ifnull +1836 -> 2688
    //   855: aload_3
    //   856: aload 27
    //   858: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   861: lload 14
    //   863: iload 5
    //   865: i2l
    //   866: invokeinterface 370 6 0
    //   871: goto -55 -> 816
    //   874: astore 18
    //   876: new 245	org/apache/http/client/methods/HttpGet
    //   879: dup
    //   880: aload 17
    //   882: invokestatic 373	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   885: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   888: astore 26
    //   890: goto -689 -> 201
    //   893: astore_0
    //   894: bipush 13
    //   896: ireturn
    //   897: sipush 4096
    //   900: istore 4
    //   902: goto -571 -> 331
    //   905: iload 5
    //   907: i2l
    //   908: lload 14
    //   910: lcmp
    //   911: ifne +656 -> 1567
    //   914: iconst_0
    //   915: istore 10
    //   917: iconst_0
    //   918: istore 11
    //   920: iconst_0
    //   921: istore 8
    //   923: iload 8
    //   925: istore 5
    //   927: iload 10
    //   929: istore 6
    //   931: iload 11
    //   933: istore 7
    //   935: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   938: ifeq +44 -> 982
    //   941: iload 10
    //   943: istore 6
    //   945: iload 11
    //   947: istore 7
    //   949: ldc 15
    //   951: iconst_2
    //   952: new 221	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   959: ldc_w 375
    //   962: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload_1
    //   966: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   969: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: iload 8
    //   980: istore 5
    //   982: iload 5
    //   984: istore 6
    //   986: iload 5
    //   988: istore 7
    //   990: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   993: ifeq +53 -> 1046
    //   996: iload 5
    //   998: istore 6
    //   1000: iload 5
    //   1002: istore 7
    //   1004: ldc_w 377
    //   1007: iconst_2
    //   1008: new 221	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1015: ldc_w 379
    //   1018: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1024: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1027: ldc_w 384
    //   1030: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: aload_1
    //   1034: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1037: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1046: aload_1
    //   1047: ifnull +108 -> 1155
    //   1050: iload 5
    //   1052: istore 6
    //   1054: iload 5
    //   1056: istore 7
    //   1058: aload_1
    //   1059: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   1062: tableswitch	default:+1632 -> 2694, 10001:+665->1727
    //   1081: iconst_2
    //   1082: istore 6
    //   1084: iload 5
    //   1086: istore 7
    //   1088: aload_2
    //   1089: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1092: ifeq +1001 -> 2093
    //   1095: iload 5
    //   1097: istore 6
    //   1099: iload 5
    //   1101: istore 7
    //   1103: iconst_3
    //   1104: anewarray 237	java/lang/String
    //   1107: astore 19
    //   1109: aload 19
    //   1111: iconst_0
    //   1112: ldc_w 388
    //   1115: aastore
    //   1116: aload 19
    //   1118: iconst_1
    //   1119: ldc_w 390
    //   1122: aastore
    //   1123: aload 19
    //   1125: iconst_2
    //   1126: ldc_w 392
    //   1129: aastore
    //   1130: aload 19
    //   1132: ifnull +23 -> 1155
    //   1135: iload 5
    //   1137: istore 6
    //   1139: iload 5
    //   1141: istore 7
    //   1143: aload_0
    //   1144: aload_0
    //   1145: invokevirtual 395	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1148: aload 19
    //   1150: lload 14
    //   1152: invokevirtual 398	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1155: iload 5
    //   1157: istore 6
    //   1159: iload 5
    //   1161: istore 7
    //   1163: aload 30
    //   1165: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1168: invokevirtual 402	java/io/File:setLastModified	(J)Z
    //   1171: pop
    //   1172: iload 5
    //   1174: istore 6
    //   1176: iload 5
    //   1178: istore 7
    //   1180: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1183: ifeq +66 -> 1249
    //   1186: iload 5
    //   1188: istore 6
    //   1190: iload 5
    //   1192: istore 7
    //   1194: ldc 15
    //   1196: iconst_2
    //   1197: new 221	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 404
    //   1207: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1213: lload 12
    //   1215: lsub
    //   1216: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1219: ldc_w 406
    //   1222: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: lload 14
    //   1227: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1230: ldc_w 408
    //   1233: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: aload_1
    //   1237: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1240: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokestatic 410	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1249: aload 20
    //   1251: ifnull +1434 -> 2685
    //   1254: iload 5
    //   1256: istore 7
    //   1258: iload 4
    //   1260: istore 6
    //   1262: aload 18
    //   1264: astore 21
    //   1266: iload 4
    //   1268: istore 8
    //   1270: aload 18
    //   1272: astore 22
    //   1274: aload 18
    //   1276: astore 23
    //   1278: aload 20
    //   1280: invokevirtual 413	java/io/InputStream:close	()V
    //   1283: iload 5
    //   1285: ifne +92 -> 1377
    //   1288: aload 18
    //   1290: astore 24
    //   1292: aload 17
    //   1294: astore 20
    //   1296: iload 4
    //   1298: istore 6
    //   1300: aload 18
    //   1302: astore 23
    //   1304: aload 17
    //   1306: astore 21
    //   1308: iload 4
    //   1310: istore 8
    //   1312: aload 18
    //   1314: astore 25
    //   1316: aload 17
    //   1318: astore 22
    //   1320: iload 5
    //   1322: istore 7
    //   1324: aload_1
    //   1325: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1328: ifnull +49 -> 1377
    //   1331: aload 18
    //   1333: astore 24
    //   1335: aload 17
    //   1337: astore 20
    //   1339: iload 4
    //   1341: istore 6
    //   1343: aload 18
    //   1345: astore 23
    //   1347: aload 17
    //   1349: astore 21
    //   1351: iload 4
    //   1353: istore 8
    //   1355: aload 18
    //   1357: astore 25
    //   1359: aload 17
    //   1361: astore 22
    //   1363: iload 5
    //   1365: istore 7
    //   1367: aload 30
    //   1369: aload_1
    //   1370: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1373: invokevirtual 417	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1376: pop
    //   1377: aload_3
    //   1378: ifnull +52 -> 1430
    //   1381: aload 18
    //   1383: astore 24
    //   1385: aload 17
    //   1387: astore 20
    //   1389: iload 4
    //   1391: istore 6
    //   1393: aload 18
    //   1395: astore 23
    //   1397: aload 17
    //   1399: astore 21
    //   1401: iload 4
    //   1403: istore 8
    //   1405: aload 18
    //   1407: astore 25
    //   1409: aload 17
    //   1411: astore 22
    //   1413: iload 5
    //   1415: istore 7
    //   1417: aload_3
    //   1418: aload 27
    //   1420: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   1423: iload 5
    //   1425: invokeinterface 214 3 0
    //   1430: aload 17
    //   1432: ifnull +10 -> 1442
    //   1435: aload 17
    //   1437: invokeinterface 420 1 0
    //   1442: aload 18
    //   1444: ifnull +1227 -> 2671
    //   1447: aload 18
    //   1449: invokevirtual 421	java/io/OutputStream:close	()V
    //   1452: aload 18
    //   1454: astore 20
    //   1456: aload 17
    //   1458: astore 19
    //   1460: iload 9
    //   1462: iconst_1
    //   1463: iadd
    //   1464: istore 9
    //   1466: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1469: ifeq +43 -> 1512
    //   1472: ldc 15
    //   1474: iconst_2
    //   1475: new 221	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1482: ldc_w 423
    //   1485: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: iload 5
    //   1490: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1493: ldc_w 428
    //   1496: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: aload_1
    //   1500: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1503: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1512: iload 9
    //   1514: iconst_2
    //   1515: if_icmpge +22 -> 1537
    //   1518: iload 5
    //   1520: ifeq +17 -> 1537
    //   1523: aload 28
    //   1525: monitorenter
    //   1526: aload 28
    //   1528: ldc2_w 429
    //   1531: invokevirtual 434	java/lang/Object:wait	(J)V
    //   1534: aload 28
    //   1536: monitorexit
    //   1537: iload 5
    //   1539: istore 6
    //   1541: iload 5
    //   1543: ifeq -1433 -> 110
    //   1546: iload 5
    //   1548: istore 6
    //   1550: iload 9
    //   1552: iconst_2
    //   1553: if_icmpge -1443 -> 110
    //   1556: aload 19
    //   1558: astore 17
    //   1560: aload 20
    //   1562: astore 19
    //   1564: goto -1180 -> 384
    //   1567: bipush 8
    //   1569: istore 8
    //   1571: iload 8
    //   1573: istore 6
    //   1575: iload 8
    //   1577: istore 7
    //   1579: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1582: ifeq +62 -> 1644
    //   1585: iload 8
    //   1587: istore 6
    //   1589: iload 8
    //   1591: istore 7
    //   1593: ldc 15
    //   1595: iconst_2
    //   1596: new 221	java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1603: ldc_w 436
    //   1606: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: iload 5
    //   1611: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1614: ldc_w 438
    //   1617: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: lload 14
    //   1622: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1625: ldc_w 440
    //   1628: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: aload_1
    //   1632: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1635: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1644: iload 8
    //   1646: istore 5
    //   1648: iload 8
    //   1650: istore 6
    //   1652: iload 8
    //   1654: istore 7
    //   1656: aload 30
    //   1658: invokevirtual 202	java/io/File:exists	()Z
    //   1661: ifeq -679 -> 982
    //   1664: iload 8
    //   1666: istore 6
    //   1668: iload 8
    //   1670: istore 7
    //   1672: aload 30
    //   1674: invokevirtual 309	java/io/File:delete	()Z
    //   1677: pop
    //   1678: iload 8
    //   1680: istore 5
    //   1682: goto -700 -> 982
    //   1685: astore 19
    //   1687: iload 6
    //   1689: istore 5
    //   1691: aload 19
    //   1693: instanceof 442
    //   1696: ifne +15 -> 1711
    //   1699: aload 19
    //   1701: instanceof 444
    //   1704: istore 16
    //   1706: iload 16
    //   1708: ifeq +423 -> 2131
    //   1711: iconst_3
    //   1712: istore 5
    //   1714: aload 20
    //   1716: ifnull +966 -> 2682
    //   1719: aload 20
    //   1721: invokevirtual 413	java/io/InputStream:close	()V
    //   1724: goto -441 -> 1283
    //   1727: iload 5
    //   1729: istore 6
    //   1731: iload 5
    //   1733: istore 7
    //   1735: aload_2
    //   1736: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1739: ifeq +316 -> 2055
    //   1742: iload 5
    //   1744: istore 6
    //   1746: iload 5
    //   1748: istore 7
    //   1750: iconst_3
    //   1751: anewarray 237	java/lang/String
    //   1754: astore 19
    //   1756: aload 19
    //   1758: iconst_0
    //   1759: ldc_w 446
    //   1762: aastore
    //   1763: aload 19
    //   1765: iconst_1
    //   1766: ldc_w 390
    //   1769: aastore
    //   1770: aload 19
    //   1772: iconst_2
    //   1773: ldc_w 392
    //   1776: aastore
    //   1777: goto -647 -> 1130
    //   1780: astore 19
    //   1782: iload 7
    //   1784: istore 5
    //   1786: aload 20
    //   1788: ifnull +32 -> 1820
    //   1791: iload 5
    //   1793: istore 7
    //   1795: iload 4
    //   1797: istore 6
    //   1799: aload 18
    //   1801: astore 21
    //   1803: iload 4
    //   1805: istore 8
    //   1807: aload 18
    //   1809: astore 22
    //   1811: aload 18
    //   1813: astore 23
    //   1815: aload 20
    //   1817: invokevirtual 413	java/io/InputStream:close	()V
    //   1820: iload 5
    //   1822: istore 7
    //   1824: iload 4
    //   1826: istore 6
    //   1828: aload 18
    //   1830: astore 21
    //   1832: iload 4
    //   1834: istore 8
    //   1836: aload 18
    //   1838: astore 22
    //   1840: aload 18
    //   1842: astore 23
    //   1844: aload 19
    //   1846: athrow
    //   1847: astore 19
    //   1849: aload 21
    //   1851: astore 18
    //   1853: iload 7
    //   1855: istore 5
    //   1857: aload 17
    //   1859: astore 21
    //   1861: aload 18
    //   1863: astore 20
    //   1865: aload 19
    //   1867: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   1870: aload 17
    //   1872: astore 21
    //   1874: aload 18
    //   1876: astore 20
    //   1878: aload 19
    //   1880: instanceof 449
    //   1883: ifeq +340 -> 2223
    //   1886: bipush 10
    //   1888: istore 7
    //   1890: aload 17
    //   1892: astore 21
    //   1894: aload 18
    //   1896: astore 20
    //   1898: ldc 15
    //   1900: iconst_2
    //   1901: new 221	java/lang/StringBuilder
    //   1904: dup
    //   1905: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1908: ldc_w 451
    //   1911: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: iload 7
    //   1916: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1919: ldc_w 453
    //   1922: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: aload_1
    //   1926: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1929: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: ldc_w 455
    //   1935: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: aload 19
    //   1940: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1943: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1949: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1952: aload_3
    //   1953: ifnull +24 -> 1977
    //   1956: aload 17
    //   1958: astore 21
    //   1960: aload 18
    //   1962: astore 20
    //   1964: aload_3
    //   1965: aload 27
    //   1967: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   1970: iload 7
    //   1972: invokeinterface 214 3 0
    //   1977: aload 17
    //   1979: ifnull +10 -> 1989
    //   1982: aload 17
    //   1984: invokeinterface 420 1 0
    //   1989: aload 17
    //   1991: astore 19
    //   1993: iload 6
    //   1995: istore 4
    //   1997: aload 18
    //   1999: astore 20
    //   2001: iload 7
    //   2003: istore 5
    //   2005: aload 18
    //   2007: ifnull -547 -> 1460
    //   2010: aload 18
    //   2012: invokevirtual 421	java/io/OutputStream:close	()V
    //   2015: aload 17
    //   2017: astore 19
    //   2019: iload 6
    //   2021: istore 4
    //   2023: aload 18
    //   2025: astore 20
    //   2027: iload 7
    //   2029: istore 5
    //   2031: goto -571 -> 1460
    //   2034: astore 19
    //   2036: aload 17
    //   2038: astore 19
    //   2040: iload 6
    //   2042: istore 4
    //   2044: aload 18
    //   2046: astore 20
    //   2048: iload 7
    //   2050: istore 5
    //   2052: goto -592 -> 1460
    //   2055: iload 5
    //   2057: istore 6
    //   2059: iload 5
    //   2061: istore 7
    //   2063: iconst_3
    //   2064: anewarray 237	java/lang/String
    //   2067: astore 19
    //   2069: aload 19
    //   2071: iconst_0
    //   2072: ldc_w 463
    //   2075: aastore
    //   2076: aload 19
    //   2078: iconst_1
    //   2079: ldc_w 465
    //   2082: aastore
    //   2083: aload 19
    //   2085: iconst_2
    //   2086: ldc_w 392
    //   2089: aastore
    //   2090: goto -960 -> 1130
    //   2093: iload 5
    //   2095: istore 6
    //   2097: iload 5
    //   2099: istore 7
    //   2101: iconst_3
    //   2102: anewarray 237	java/lang/String
    //   2105: astore 19
    //   2107: aload 19
    //   2109: iconst_0
    //   2110: ldc_w 467
    //   2113: aastore
    //   2114: aload 19
    //   2116: iconst_1
    //   2117: ldc_w 465
    //   2120: aastore
    //   2121: aload 19
    //   2123: iconst_2
    //   2124: ldc_w 392
    //   2127: aastore
    //   2128: goto -998 -> 1130
    //   2131: aload 19
    //   2133: instanceof 469
    //   2136: istore 16
    //   2138: iload 16
    //   2140: ifeq +10 -> 2150
    //   2143: bipush 11
    //   2145: istore 5
    //   2147: goto -433 -> 1714
    //   2150: iconst_4
    //   2151: istore 5
    //   2153: goto -439 -> 1714
    //   2156: aload_3
    //   2157: ifnull +36 -> 2193
    //   2160: aload 19
    //   2162: astore 24
    //   2164: aload 17
    //   2166: astore 20
    //   2168: iload 4
    //   2170: istore 6
    //   2172: aload 19
    //   2174: astore 23
    //   2176: aload 17
    //   2178: astore 21
    //   2180: aload_3
    //   2181: aload 27
    //   2183: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   2186: iload 5
    //   2188: invokeinterface 214 3 0
    //   2193: aload 19
    //   2195: astore 18
    //   2197: goto -767 -> 1430
    //   2200: astore 19
    //   2202: aload 19
    //   2204: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2207: goto -765 -> 1442
    //   2210: astore 19
    //   2212: aload 17
    //   2214: astore 19
    //   2216: aload 18
    //   2218: astore 20
    //   2220: goto -760 -> 1460
    //   2223: aload 17
    //   2225: astore 21
    //   2227: aload 18
    //   2229: astore 20
    //   2231: aload 19
    //   2233: instanceof 442
    //   2236: ifne +461 -> 2697
    //   2239: aload 17
    //   2241: astore 21
    //   2243: aload 18
    //   2245: astore 20
    //   2247: aload 19
    //   2249: instanceof 444
    //   2252: ifeq +6 -> 2258
    //   2255: goto +442 -> 2697
    //   2258: aload 17
    //   2260: astore 21
    //   2262: aload 18
    //   2264: astore 20
    //   2266: aload 19
    //   2268: instanceof 469
    //   2271: ifeq +24 -> 2295
    //   2274: aload 17
    //   2276: astore 21
    //   2278: aload 18
    //   2280: astore 20
    //   2282: aload_1
    //   2283: bipush 11
    //   2285: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2288: iload 5
    //   2290: istore 7
    //   2292: goto -402 -> 1890
    //   2295: iconst_4
    //   2296: istore 7
    //   2298: goto -408 -> 1890
    //   2301: astore 19
    //   2303: aload 19
    //   2305: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2308: goto -319 -> 1989
    //   2311: astore 19
    //   2313: iload 8
    //   2315: istore 6
    //   2317: aload 22
    //   2319: astore 18
    //   2321: aload 17
    //   2323: astore 21
    //   2325: aload 18
    //   2327: astore 20
    //   2329: aload 19
    //   2331: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   2334: iconst_5
    //   2335: istore 7
    //   2337: aload_3
    //   2338: ifnull +23 -> 2361
    //   2341: aload 17
    //   2343: astore 21
    //   2345: aload 18
    //   2347: astore 20
    //   2349: aload_3
    //   2350: aload 27
    //   2352: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   2355: iconst_5
    //   2356: invokeinterface 214 3 0
    //   2361: aload 17
    //   2363: ifnull +10 -> 2373
    //   2366: aload 17
    //   2368: invokeinterface 420 1 0
    //   2373: aload 17
    //   2375: astore 19
    //   2377: iload 6
    //   2379: istore 4
    //   2381: aload 18
    //   2383: astore 20
    //   2385: iload 7
    //   2387: istore 5
    //   2389: aload 18
    //   2391: ifnull -931 -> 1460
    //   2394: aload 18
    //   2396: invokevirtual 421	java/io/OutputStream:close	()V
    //   2399: aload 17
    //   2401: astore 19
    //   2403: iload 6
    //   2405: istore 4
    //   2407: aload 18
    //   2409: astore 20
    //   2411: iload 7
    //   2413: istore 5
    //   2415: goto -955 -> 1460
    //   2418: astore 19
    //   2420: aload 17
    //   2422: astore 19
    //   2424: iload 6
    //   2426: istore 4
    //   2428: aload 18
    //   2430: astore 20
    //   2432: iload 7
    //   2434: istore 5
    //   2436: goto -976 -> 1460
    //   2439: astore 19
    //   2441: aload 19
    //   2443: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2446: goto -73 -> 2373
    //   2449: astore_0
    //   2450: aload 23
    //   2452: astore_1
    //   2453: aload 17
    //   2455: ifnull +10 -> 2465
    //   2458: aload 17
    //   2460: invokeinterface 420 1 0
    //   2465: aload_1
    //   2466: ifnull +7 -> 2473
    //   2469: aload_1
    //   2470: invokevirtual 421	java/io/OutputStream:close	()V
    //   2473: aload_0
    //   2474: athrow
    //   2475: astore_2
    //   2476: aload_2
    //   2477: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2480: goto -15 -> 2465
    //   2483: astore_0
    //   2484: aload 28
    //   2486: monitorexit
    //   2487: aload_0
    //   2488: athrow
    //   2489: astore_1
    //   2490: goto -17 -> 2473
    //   2493: astore 17
    //   2495: goto -961 -> 1534
    //   2498: astore_0
    //   2499: aload 18
    //   2501: astore_1
    //   2502: goto -49 -> 2453
    //   2505: astore_0
    //   2506: aload 24
    //   2508: astore_1
    //   2509: aload 20
    //   2511: astore 17
    //   2513: goto -60 -> 2453
    //   2516: astore_0
    //   2517: aload 21
    //   2519: astore 17
    //   2521: aload 20
    //   2523: astore_1
    //   2524: goto -71 -> 2453
    //   2527: astore 19
    //   2529: iload 4
    //   2531: istore 6
    //   2533: goto -212 -> 2321
    //   2536: astore 19
    //   2538: aload 23
    //   2540: astore 18
    //   2542: aload 21
    //   2544: astore 17
    //   2546: goto -225 -> 2321
    //   2549: astore 19
    //   2551: iload 4
    //   2553: istore 6
    //   2555: goto -698 -> 1857
    //   2558: astore 19
    //   2560: iload 8
    //   2562: istore 6
    //   2564: aload 25
    //   2566: astore 18
    //   2568: aload 22
    //   2570: astore 17
    //   2572: iload 7
    //   2574: istore 5
    //   2576: goto -719 -> 1857
    //   2579: astore 20
    //   2581: aload 19
    //   2583: astore 18
    //   2585: aload 20
    //   2587: astore 19
    //   2589: iload 4
    //   2591: istore 6
    //   2593: goto -736 -> 1857
    //   2596: astore 19
    //   2598: iconst_5
    //   2599: istore 5
    //   2601: goto -815 -> 1786
    //   2604: astore 19
    //   2606: goto -820 -> 1786
    //   2609: astore 21
    //   2611: aconst_null
    //   2612: astore 20
    //   2614: aload 19
    //   2616: astore 18
    //   2618: iconst_5
    //   2619: istore 5
    //   2621: aload 21
    //   2623: astore 19
    //   2625: goto -839 -> 1786
    //   2628: astore 19
    //   2630: aconst_null
    //   2631: astore 20
    //   2633: iconst_5
    //   2634: istore 5
    //   2636: goto -850 -> 1786
    //   2639: astore 19
    //   2641: iconst_5
    //   2642: istore 5
    //   2644: goto -953 -> 1691
    //   2647: astore 21
    //   2649: aload 19
    //   2651: astore 18
    //   2653: iconst_5
    //   2654: istore 5
    //   2656: aload 21
    //   2658: astore 19
    //   2660: goto -969 -> 1691
    //   2663: astore 19
    //   2665: iconst_5
    //   2666: istore 5
    //   2668: goto -977 -> 1691
    //   2671: aload 17
    //   2673: astore 19
    //   2675: aload 18
    //   2677: astore 20
    //   2679: goto -1219 -> 1460
    //   2682: goto -1399 -> 1283
    //   2685: goto -1402 -> 1283
    //   2688: goto -1872 -> 816
    //   2691: goto -1881 -> 810
    //   2694: goto -1614 -> 1080
    //   2697: iconst_2
    //   2698: istore 7
    //   2700: goto -810 -> 1890
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2703	0	paramAppInterface	AppInterface
    //   0	2703	1	paramDownloadInfo	DownloadInfo
    //   0	2703	2	paramNetworkInfo	NetworkInfo
    //   0	2703	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   252	2338	4	i1	int
    //   249	2418	5	i2	int
    //   108	2484	6	i3	int
    //   461	2238	7	i4	int
    //   449	2112	8	i5	int
    //   382	1172	9	i6	int
    //   385	557	10	i7	int
    //   918	28	11	i8	int
    //   16	1198	12	l1	long
    //   768	853	14	l2	long
    //   1704	435	16	bool	boolean
    //   34	2425	17	localObject1	Object
    //   2493	1	17	localInterruptedException	java.lang.InterruptedException
    //   2511	161	17	localObject2	Object
    //   262	573	18	localObject3	Object
    //   874	967	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1851	825	18	localObject4	Object
    //   182	1381	19	localObject5	Object
    //   1685	15	19	localIOException1	java.io.IOException
    //   1754	17	19	arrayOfString	String[]
    //   1780	65	19	localObject6	Object
    //   1847	92	19	localIOException2	java.io.IOException
    //   1991	27	19	localObject7	Object
    //   2034	1	19	localIOException3	java.io.IOException
    //   2038	156	19	localObject8	Object
    //   2200	3	19	localIOException4	java.io.IOException
    //   2210	1	19	localIOException5	java.io.IOException
    //   2214	53	19	localObject9	Object
    //   2301	3	19	localIOException6	java.io.IOException
    //   2311	19	19	localException1	java.lang.Exception
    //   2375	27	19	localObject10	Object
    //   2418	1	19	localIOException7	java.io.IOException
    //   2422	1	19	localObject11	Object
    //   2439	3	19	localIOException8	java.io.IOException
    //   2527	1	19	localException2	java.lang.Exception
    //   2536	1	19	localException3	java.lang.Exception
    //   2549	1	19	localIOException9	java.io.IOException
    //   2558	24	19	localIOException10	java.io.IOException
    //   2587	1	19	localObject12	Object
    //   2596	1	19	localObject13	Object
    //   2604	11	19	localObject14	Object
    //   2623	1	19	localObject15	Object
    //   2628	1	19	localObject16	Object
    //   2639	11	19	localIOException11	java.io.IOException
    //   2658	1	19	localObject17	Object
    //   2663	1	19	localIOException12	java.io.IOException
    //   2673	1	19	localObject18	Object
    //   433	2089	20	localObject19	Object
    //   2579	7	20	localIOException13	java.io.IOException
    //   2612	66	20	localObject20	Object
    //   445	2098	21	localObject21	Object
    //   2609	13	21	localObject22	Object
    //   2647	10	21	localIOException14	java.io.IOException
    //   457	2112	22	localObject23	Object
    //   441	2098	23	localObject24	Object
    //   429	2078	24	localObject25	Object
    //   453	2112	25	localObject26	Object
    //   199	690	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   11	2340	27	localURL	URL
    //   25	2460	28	localObject27	Object
    //   208	215	29	localBasicHttpParams	BasicHttpParams
    //   362	1311	30	localFile	File
    //   528	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   0	13	113	java/net/MalformedURLException
    //   27	36	128	java/lang/Exception
    //   41	57	128	java/lang/Exception
    //   61	73	128	java/lang/Exception
    //   73	107	128	java/lang/Exception
    //   190	201	874	java/lang/IllegalArgumentException
    //   876	890	893	java/lang/IllegalArgumentException
    //   935	941	1685	java/io/IOException
    //   949	978	1685	java/io/IOException
    //   990	996	1685	java/io/IOException
    //   1004	1046	1685	java/io/IOException
    //   1058	1080	1685	java/io/IOException
    //   1088	1095	1685	java/io/IOException
    //   1103	1109	1685	java/io/IOException
    //   1143	1155	1685	java/io/IOException
    //   1163	1172	1685	java/io/IOException
    //   1180	1186	1685	java/io/IOException
    //   1194	1249	1685	java/io/IOException
    //   1579	1585	1685	java/io/IOException
    //   1593	1644	1685	java/io/IOException
    //   1656	1664	1685	java/io/IOException
    //   1672	1678	1685	java/io/IOException
    //   1735	1742	1685	java/io/IOException
    //   1750	1756	1685	java/io/IOException
    //   2063	2069	1685	java/io/IOException
    //   2101	2107	1685	java/io/IOException
    //   935	941	1780	finally
    //   949	978	1780	finally
    //   990	996	1780	finally
    //   1004	1046	1780	finally
    //   1058	1080	1780	finally
    //   1088	1095	1780	finally
    //   1103	1109	1780	finally
    //   1143	1155	1780	finally
    //   1163	1172	1780	finally
    //   1180	1186	1780	finally
    //   1194	1249	1780	finally
    //   1579	1585	1780	finally
    //   1593	1644	1780	finally
    //   1656	1664	1780	finally
    //   1672	1678	1780	finally
    //   1735	1742	1780	finally
    //   1750	1756	1780	finally
    //   2063	2069	1780	finally
    //   2101	2107	1780	finally
    //   1278	1283	1847	java/io/IOException
    //   1815	1820	1847	java/io/IOException
    //   1844	1847	1847	java/io/IOException
    //   2010	2015	2034	java/io/IOException
    //   1435	1442	2200	java/io/IOException
    //   1447	1452	2210	java/io/IOException
    //   1982	1989	2301	java/io/IOException
    //   1278	1283	2311	java/lang/Exception
    //   1815	1820	2311	java/lang/Exception
    //   1844	1847	2311	java/lang/Exception
    //   2394	2399	2418	java/io/IOException
    //   2366	2373	2439	java/io/IOException
    //   1278	1283	2449	finally
    //   1815	1820	2449	finally
    //   1844	1847	2449	finally
    //   2458	2465	2475	java/io/IOException
    //   1526	1534	2483	finally
    //   1534	1537	2483	finally
    //   2484	2487	2483	finally
    //   2469	2473	2489	java/io/IOException
    //   1526	1534	2493	java/lang/InterruptedException
    //   1719	1724	2498	finally
    //   463	485	2505	finally
    //   521	530	2505	finally
    //   566	574	2505	finally
    //   610	619	2505	finally
    //   659	672	2505	finally
    //   708	717	2505	finally
    //   761	770	2505	finally
    //   1324	1331	2505	finally
    //   1367	1377	2505	finally
    //   1417	1430	2505	finally
    //   2180	2193	2505	finally
    //   1865	1870	2516	finally
    //   1878	1886	2516	finally
    //   1898	1952	2516	finally
    //   1964	1977	2516	finally
    //   2231	2239	2516	finally
    //   2247	2255	2516	finally
    //   2266	2274	2516	finally
    //   2282	2288	2516	finally
    //   2329	2334	2516	finally
    //   2349	2361	2516	finally
    //   1719	1724	2527	java/lang/Exception
    //   463	485	2536	java/lang/Exception
    //   521	530	2536	java/lang/Exception
    //   566	574	2536	java/lang/Exception
    //   610	619	2536	java/lang/Exception
    //   659	672	2536	java/lang/Exception
    //   708	717	2536	java/lang/Exception
    //   761	770	2536	java/lang/Exception
    //   1324	1331	2536	java/lang/Exception
    //   1367	1377	2536	java/lang/Exception
    //   1417	1430	2536	java/lang/Exception
    //   2180	2193	2536	java/lang/Exception
    //   1719	1724	2549	java/io/IOException
    //   463	485	2558	java/io/IOException
    //   521	530	2558	java/io/IOException
    //   566	574	2558	java/io/IOException
    //   610	619	2558	java/io/IOException
    //   659	672	2558	java/io/IOException
    //   708	717	2558	java/io/IOException
    //   761	770	2558	java/io/IOException
    //   1324	1331	2558	java/io/IOException
    //   1367	1377	2558	java/io/IOException
    //   1417	1430	2558	java/io/IOException
    //   2180	2193	2579	java/io/IOException
    //   810	816	2596	finally
    //   825	844	2596	finally
    //   855	871	2596	finally
    //   1691	1706	2604	finally
    //   2131	2138	2604	finally
    //   776	787	2609	finally
    //   787	796	2628	finally
    //   810	816	2639	java/io/IOException
    //   825	844	2639	java/io/IOException
    //   855	871	2639	java/io/IOException
    //   776	787	2647	java/io/IOException
    //   787	796	2663	java/io/IOException
  }
  
  public static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    NetworkInfo localNetworkInfo = jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramDownloadInfo, localNetworkInfo, paramHttpDownloadListener);
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 15
    //   8: iconst_2
    //   9: ldc_w 486
    //   12: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: getstatic 162	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   18: invokevirtual 477	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore 34
    //   23: aload 34
    //   25: ifnonnull +25 -> 50
    //   28: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +12 -> 43
    //   34: ldc 15
    //   36: iconst_2
    //   37: ldc_w 488
    //   40: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: bipush 9
    //   45: istore 6
    //   47: iload 6
    //   49: ireturn
    //   50: new 183	java/net/URL
    //   53: dup
    //   54: aload_1
    //   55: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: astore 32
    //   63: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   66: lstore 17
    //   68: new 4	java/lang/Object
    //   71: dup
    //   72: invokespecial 170	java/lang/Object:<init>	()V
    //   75: astore 33
    //   77: aload_1
    //   78: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   81: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   84: astore 22
    //   86: aload 22
    //   88: ifnull +141 -> 229
    //   91: aload 22
    //   93: invokevirtual 202	java/io/File:exists	()Z
    //   96: ifne +133 -> 229
    //   99: aload 22
    //   101: invokevirtual 205	java/io/File:mkdirs	()Z
    //   104: ifne +125 -> 229
    //   107: aload_2
    //   108: ifnull +15 -> 123
    //   111: aload_2
    //   112: aload 32
    //   114: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   117: iconst_4
    //   118: invokeinterface 214 3 0
    //   123: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +32 -> 158
    //   129: ldc 15
    //   131: iconst_2
    //   132: new 221	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 490
    //   142: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iconst_4
    //   159: ireturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 235	java/net/MalformedURLException:printStackTrace	()V
    //   165: aload_1
    //   166: aload_0
    //   167: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   173: iconst_5
    //   174: ireturn
    //   175: astore_0
    //   176: aload_2
    //   177: ifnull +15 -> 192
    //   180: aload_2
    //   181: aload 32
    //   183: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   186: iconst_4
    //   187: invokeinterface 214 3 0
    //   192: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +32 -> 227
    //   198: ldc 15
    //   200: iconst_2
    //   201: new 221	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 490
    //   211: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   218: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_4
    //   228: ireturn
    //   229: aconst_null
    //   230: astore 24
    //   232: aload_1
    //   233: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   236: astore 22
    //   238: new 245	org/apache/http/client/methods/HttpGet
    //   241: dup
    //   242: aload 22
    //   244: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   247: astore 31
    //   249: new 70	org/apache/http/params/BasicHttpParams
    //   252: dup
    //   253: invokespecial 73	org/apache/http/params/BasicHttpParams:<init>	()V
    //   256: astore 35
    //   258: aload 35
    //   260: ldc 248
    //   262: ldc 249
    //   264: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokeinterface 260 3 0
    //   272: pop
    //   273: aload 35
    //   275: ldc_w 262
    //   278: ldc 249
    //   280: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: invokeinterface 260 3 0
    //   288: pop
    //   289: invokestatic 267	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   292: astore 22
    //   294: invokestatic 271	android/net/Proxy:getDefaultPort	()I
    //   297: istore 7
    //   299: iconst_0
    //   300: istore 6
    //   302: aload 34
    //   304: ifnull +99 -> 403
    //   307: aload 34
    //   309: invokevirtual 276	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   312: astore 23
    //   314: aload 34
    //   316: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   319: ifeq +51 -> 370
    //   322: aload 23
    //   324: ifnull +14 -> 338
    //   327: aload 23
    //   329: ldc_w 283
    //   332: invokevirtual 287	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   335: ifeq +35 -> 370
    //   338: aload 22
    //   340: ifnull +30 -> 370
    //   343: iload 7
    //   345: ifle +25 -> 370
    //   348: aload 35
    //   350: ldc_w 289
    //   353: new 291	org/apache/http/HttpHost
    //   356: dup
    //   357: aload 22
    //   359: iload 7
    //   361: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   364: invokeinterface 260 3 0
    //   369: pop
    //   370: aload 34
    //   372: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   375: ifeq +718 -> 1093
    //   378: sipush 2048
    //   381: istore 6
    //   383: aload 35
    //   385: ldc_w 295
    //   388: iload 6
    //   390: invokeinterface 299 3 0
    //   395: pop
    //   396: aload 31
    //   398: aload 35
    //   400: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   403: new 194	java/io/File
    //   406: dup
    //   407: aload_1
    //   408: invokevirtual 305	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   411: invokespecial 306	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: astore 36
    //   416: aload 36
    //   418: invokevirtual 202	java/io/File:exists	()Z
    //   421: ifeq +9 -> 430
    //   424: aload 36
    //   426: invokevirtual 309	java/io/File:delete	()Z
    //   429: pop
    //   430: aconst_null
    //   431: astore 22
    //   433: iconst_m1
    //   434: istore 13
    //   436: iconst_5
    //   437: istore 11
    //   439: iload 13
    //   441: ifne +38 -> 479
    //   444: aload 35
    //   446: ldc_w 289
    //   449: new 291	org/apache/http/HttpHost
    //   452: dup
    //   453: aload 32
    //   455: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   458: aload 32
    //   460: invokevirtual 315	java/net/URL:getPort	()I
    //   463: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   466: invokeinterface 260 3 0
    //   471: pop
    //   472: aload 31
    //   474: aload 35
    //   476: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   479: aload 24
    //   481: astore 28
    //   483: aload 22
    //   485: astore 25
    //   487: iload 6
    //   489: istore 9
    //   491: aload 24
    //   493: astore 29
    //   495: aload 22
    //   497: astore 26
    //   499: iload 6
    //   501: istore 10
    //   503: aload 24
    //   505: astore 30
    //   507: aload 22
    //   509: astore 27
    //   511: iload 11
    //   513: istore 8
    //   515: aload 32
    //   517: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   520: astore 23
    //   522: aload 24
    //   524: astore 28
    //   526: aload 22
    //   528: astore 25
    //   530: iload 6
    //   532: istore 9
    //   534: aload 24
    //   536: astore 29
    //   538: aload 22
    //   540: astore 26
    //   542: iload 6
    //   544: istore 10
    //   546: aload 24
    //   548: astore 30
    //   550: aload 22
    //   552: astore 27
    //   554: iload 11
    //   556: istore 8
    //   558: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq +66 -> 627
    //   564: aload 24
    //   566: astore 28
    //   568: aload 22
    //   570: astore 25
    //   572: iload 6
    //   574: istore 9
    //   576: aload 24
    //   578: astore 29
    //   580: aload 22
    //   582: astore 26
    //   584: iload 6
    //   586: istore 10
    //   588: aload 24
    //   590: astore 30
    //   592: aload 22
    //   594: astore 27
    //   596: iload 11
    //   598: istore 8
    //   600: ldc 15
    //   602: iconst_2
    //   603: new 221	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 492
    //   613: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 23
    //   618: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload 24
    //   629: astore 28
    //   631: aload 22
    //   633: astore 25
    //   635: iload 6
    //   637: istore 9
    //   639: aload 24
    //   641: astore 29
    //   643: aload 22
    //   645: astore 26
    //   647: iload 6
    //   649: istore 10
    //   651: aload 24
    //   653: astore 30
    //   655: aload 22
    //   657: astore 27
    //   659: iload 11
    //   661: istore 8
    //   663: getstatic 127	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   666: new 291	org/apache/http/HttpHost
    //   669: dup
    //   670: aload 23
    //   672: invokespecial 316	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   675: aload 31
    //   677: invokevirtual 320	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   680: astore 23
    //   682: aload 24
    //   684: astore 28
    //   686: aload 22
    //   688: astore 25
    //   690: iload 6
    //   692: istore 9
    //   694: aload 24
    //   696: astore 29
    //   698: aload 22
    //   700: astore 26
    //   702: iload 6
    //   704: istore 10
    //   706: aload 24
    //   708: astore 30
    //   710: aload 22
    //   712: astore 27
    //   714: iload 11
    //   716: istore 8
    //   718: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +48 -> 769
    //   724: aload 24
    //   726: astore 28
    //   728: aload 22
    //   730: astore 25
    //   732: iload 6
    //   734: istore 9
    //   736: aload 24
    //   738: astore 29
    //   740: aload 22
    //   742: astore 26
    //   744: iload 6
    //   746: istore 10
    //   748: aload 24
    //   750: astore 30
    //   752: aload 22
    //   754: astore 27
    //   756: iload 11
    //   758: istore 8
    //   760: ldc 15
    //   762: iconst_2
    //   763: ldc_w 494
    //   766: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aload 24
    //   771: astore 28
    //   773: aload 22
    //   775: astore 25
    //   777: iload 6
    //   779: istore 9
    //   781: aload 24
    //   783: astore 29
    //   785: aload 22
    //   787: astore 26
    //   789: iload 6
    //   791: istore 10
    //   793: aload 24
    //   795: astore 30
    //   797: aload 22
    //   799: astore 27
    //   801: iload 11
    //   803: istore 8
    //   805: aload 23
    //   807: invokeinterface 326 1 0
    //   812: invokeinterface 335 1 0
    //   817: istore 7
    //   819: aload_2
    //   820: ifnull +52 -> 872
    //   823: aload 24
    //   825: astore 28
    //   827: aload 22
    //   829: astore 25
    //   831: iload 6
    //   833: istore 9
    //   835: aload 24
    //   837: astore 29
    //   839: aload 22
    //   841: astore 26
    //   843: iload 6
    //   845: istore 10
    //   847: aload 24
    //   849: astore 30
    //   851: aload 22
    //   853: astore 27
    //   855: iload 11
    //   857: istore 8
    //   859: aload_2
    //   860: aload 32
    //   862: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   865: iload 7
    //   867: invokeinterface 337 3 0
    //   872: aload 24
    //   874: astore 28
    //   876: aload 22
    //   878: astore 25
    //   880: iload 6
    //   882: istore 9
    //   884: aload 24
    //   886: astore 29
    //   888: aload 22
    //   890: astore 26
    //   892: iload 6
    //   894: istore 10
    //   896: aload 24
    //   898: astore 30
    //   900: aload 22
    //   902: astore 27
    //   904: iload 11
    //   906: istore 8
    //   908: aload 23
    //   910: invokeinterface 341 1 0
    //   915: astore 22
    //   917: sipush 200
    //   920: iload 7
    //   922: if_icmpne +1796 -> 2718
    //   925: aload 24
    //   927: astore 28
    //   929: aload 22
    //   931: astore 25
    //   933: iload 6
    //   935: istore 9
    //   937: aload 24
    //   939: astore 29
    //   941: aload 22
    //   943: astore 26
    //   945: iload 6
    //   947: istore 10
    //   949: aload 24
    //   951: astore 30
    //   953: aload 22
    //   955: astore 27
    //   957: iload 11
    //   959: istore 8
    //   961: aload 22
    //   963: invokeinterface 346 1 0
    //   968: lstore 19
    //   970: aconst_null
    //   971: astore 25
    //   973: iconst_0
    //   974: istore 7
    //   976: new 348	java/io/FileOutputStream
    //   979: dup
    //   980: aload 36
    //   982: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   985: astore 23
    //   987: aload 22
    //   989: invokeinterface 355 1 0
    //   994: astore 24
    //   996: iload 6
    //   998: ifne +2357 -> 3355
    //   1001: sipush 2048
    //   1004: istore 6
    //   1006: iload 6
    //   1008: newarray byte
    //   1010: astore 25
    //   1012: iload 7
    //   1014: i2l
    //   1015: lload 19
    //   1017: lcmp
    //   1018: ifge +83 -> 1101
    //   1021: aload 24
    //   1023: aload 25
    //   1025: invokevirtual 361	java/io/InputStream:read	([B)I
    //   1028: istore 8
    //   1030: aload 23
    //   1032: aload 25
    //   1034: iconst_0
    //   1035: iload 8
    //   1037: invokevirtual 367	java/io/OutputStream:write	([BII)V
    //   1040: iload 7
    //   1042: iload 8
    //   1044: iadd
    //   1045: istore 7
    //   1047: aload_2
    //   1048: ifnull +2304 -> 3352
    //   1051: aload_2
    //   1052: aload 32
    //   1054: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   1057: lload 19
    //   1059: iload 7
    //   1061: i2l
    //   1062: invokeinterface 370 6 0
    //   1067: goto -55 -> 1012
    //   1070: astore 23
    //   1072: new 245	org/apache/http/client/methods/HttpGet
    //   1075: dup
    //   1076: aload 22
    //   1078: invokestatic 373	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1084: astore 31
    //   1086: goto -837 -> 249
    //   1089: astore_0
    //   1090: bipush 13
    //   1092: ireturn
    //   1093: sipush 4096
    //   1096: istore 6
    //   1098: goto -715 -> 383
    //   1101: iload 7
    //   1103: i2l
    //   1104: lload 19
    //   1106: lcmp
    //   1107: ifne +895 -> 2002
    //   1110: iconst_0
    //   1111: istore 14
    //   1113: iconst_0
    //   1114: istore 15
    //   1116: iconst_0
    //   1117: istore 16
    //   1119: iconst_0
    //   1120: istore 11
    //   1122: iload 11
    //   1124: istore 7
    //   1126: iload 14
    //   1128: istore 9
    //   1130: iload 15
    //   1132: istore 10
    //   1134: iload 16
    //   1136: istore 8
    //   1138: aload 24
    //   1140: astore 27
    //   1142: iload 6
    //   1144: istore 12
    //   1146: aload 23
    //   1148: astore 26
    //   1150: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1153: ifeq +60 -> 1213
    //   1156: iload 14
    //   1158: istore 9
    //   1160: iload 15
    //   1162: istore 10
    //   1164: iload 16
    //   1166: istore 8
    //   1168: aload 24
    //   1170: astore 27
    //   1172: iload 6
    //   1174: istore 12
    //   1176: aload 23
    //   1178: astore 26
    //   1180: ldc 15
    //   1182: iconst_2
    //   1183: new 221	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1190: ldc_w 496
    //   1193: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_1
    //   1197: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1200: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1209: iload 11
    //   1211: istore 7
    //   1213: iload 7
    //   1215: istore 9
    //   1217: iload 7
    //   1219: istore 10
    //   1221: iload 7
    //   1223: istore 8
    //   1225: aload 24
    //   1227: astore 27
    //   1229: iload 6
    //   1231: istore 12
    //   1233: aload 23
    //   1235: astore 26
    //   1237: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1240: ifeq +69 -> 1309
    //   1243: iload 7
    //   1245: istore 9
    //   1247: iload 7
    //   1249: istore 10
    //   1251: iload 7
    //   1253: istore 8
    //   1255: aload 24
    //   1257: astore 27
    //   1259: iload 6
    //   1261: istore 12
    //   1263: aload 23
    //   1265: astore 26
    //   1267: ldc_w 377
    //   1270: iconst_2
    //   1271: new 221	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1278: ldc_w 498
    //   1281: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1287: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1290: ldc_w 500
    //   1293: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_1
    //   1297: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1300: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1309: iload 7
    //   1311: istore 9
    //   1313: iload 7
    //   1315: istore 10
    //   1317: iload 7
    //   1319: istore 8
    //   1321: aload 24
    //   1323: astore 27
    //   1325: iload 6
    //   1327: istore 12
    //   1329: aload 23
    //   1331: astore 26
    //   1333: aload 4
    //   1335: invokestatic 506	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1338: ifne +158 -> 1496
    //   1341: iload 7
    //   1343: istore 9
    //   1345: iload 7
    //   1347: istore 10
    //   1349: iload 7
    //   1351: istore 8
    //   1353: aload 24
    //   1355: astore 27
    //   1357: iload 6
    //   1359: istore 12
    //   1361: aload 23
    //   1363: astore 26
    //   1365: aload 5
    //   1367: invokestatic 506	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1370: ifne +126 -> 1496
    //   1373: iload 7
    //   1375: istore 9
    //   1377: iload 7
    //   1379: istore 10
    //   1381: iload 7
    //   1383: istore 8
    //   1385: aload 24
    //   1387: astore 27
    //   1389: iload 6
    //   1391: istore 12
    //   1393: aload 23
    //   1395: astore 26
    //   1397: aload 34
    //   1399: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1402: ifeq +837 -> 2239
    //   1405: iload 7
    //   1407: istore 9
    //   1409: iload 7
    //   1411: istore 10
    //   1413: iload 7
    //   1415: istore 8
    //   1417: aload 24
    //   1419: astore 27
    //   1421: iload 6
    //   1423: istore 12
    //   1425: aload 23
    //   1427: astore 26
    //   1429: iconst_3
    //   1430: anewarray 237	java/lang/String
    //   1433: astore 25
    //   1435: aload 25
    //   1437: iconst_0
    //   1438: aload 4
    //   1440: aastore
    //   1441: aload 25
    //   1443: iconst_1
    //   1444: ldc_w 390
    //   1447: aastore
    //   1448: aload 25
    //   1450: iconst_2
    //   1451: ldc_w 392
    //   1454: aastore
    //   1455: aload 25
    //   1457: ifnull +39 -> 1496
    //   1460: iload 7
    //   1462: istore 9
    //   1464: iload 7
    //   1466: istore 10
    //   1468: iload 7
    //   1470: istore 8
    //   1472: aload 24
    //   1474: astore 27
    //   1476: iload 6
    //   1478: istore 12
    //   1480: aload 23
    //   1482: astore 26
    //   1484: aload_0
    //   1485: aload_0
    //   1486: invokevirtual 395	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1489: aload 25
    //   1491: lload 19
    //   1493: invokevirtual 398	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1496: iload 7
    //   1498: istore 9
    //   1500: iload 7
    //   1502: istore 10
    //   1504: iload 7
    //   1506: istore 8
    //   1508: aload 24
    //   1510: astore 27
    //   1512: iload 6
    //   1514: istore 12
    //   1516: aload 23
    //   1518: astore 26
    //   1520: aload 36
    //   1522: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1525: invokevirtual 402	java/io/File:setLastModified	(J)Z
    //   1528: pop
    //   1529: iload 7
    //   1531: istore 9
    //   1533: iload 7
    //   1535: istore 10
    //   1537: iload 7
    //   1539: istore 8
    //   1541: aload 24
    //   1543: astore 27
    //   1545: iload 6
    //   1547: istore 12
    //   1549: aload 23
    //   1551: astore 26
    //   1553: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +82 -> 1638
    //   1559: iload 7
    //   1561: istore 9
    //   1563: iload 7
    //   1565: istore 10
    //   1567: iload 7
    //   1569: istore 8
    //   1571: aload 24
    //   1573: astore 27
    //   1575: iload 6
    //   1577: istore 12
    //   1579: aload 23
    //   1581: astore 26
    //   1583: ldc 15
    //   1585: iconst_2
    //   1586: new 221	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1593: ldc_w 404
    //   1596: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1602: lload 17
    //   1604: lsub
    //   1605: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1608: ldc_w 406
    //   1611: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: lload 19
    //   1616: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1619: ldc_w 408
    //   1622: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: aload_1
    //   1626: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1629: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: invokestatic 410	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1638: aload 24
    //   1640: ifnull +1709 -> 3349
    //   1643: iload 7
    //   1645: istore 10
    //   1647: iload 6
    //   1649: istore 9
    //   1651: aload 23
    //   1653: astore 28
    //   1655: iload 6
    //   1657: istore 8
    //   1659: aload 23
    //   1661: astore 26
    //   1663: aload 23
    //   1665: astore 27
    //   1667: aload 24
    //   1669: invokevirtual 413	java/io/InputStream:close	()V
    //   1672: iload 7
    //   1674: ifne +92 -> 1766
    //   1677: aload 23
    //   1679: astore 28
    //   1681: aload 22
    //   1683: astore 25
    //   1685: iload 6
    //   1687: istore 9
    //   1689: aload 23
    //   1691: astore 29
    //   1693: aload 22
    //   1695: astore 26
    //   1697: iload 6
    //   1699: istore 10
    //   1701: aload 23
    //   1703: astore 30
    //   1705: aload 22
    //   1707: astore 27
    //   1709: iload 7
    //   1711: istore 8
    //   1713: aload_1
    //   1714: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1717: ifnull +49 -> 1766
    //   1720: aload 23
    //   1722: astore 28
    //   1724: aload 22
    //   1726: astore 25
    //   1728: iload 6
    //   1730: istore 9
    //   1732: aload 23
    //   1734: astore 29
    //   1736: aload 22
    //   1738: astore 26
    //   1740: iload 6
    //   1742: istore 10
    //   1744: aload 23
    //   1746: astore 30
    //   1748: aload 22
    //   1750: astore 27
    //   1752: iload 7
    //   1754: istore 8
    //   1756: aload 36
    //   1758: aload_1
    //   1759: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1762: invokevirtual 417	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1765: pop
    //   1766: aload_2
    //   1767: ifnull +52 -> 1819
    //   1770: aload 23
    //   1772: astore 28
    //   1774: aload 22
    //   1776: astore 25
    //   1778: iload 6
    //   1780: istore 9
    //   1782: aload 23
    //   1784: astore 29
    //   1786: aload 22
    //   1788: astore 26
    //   1790: iload 6
    //   1792: istore 10
    //   1794: aload 23
    //   1796: astore 30
    //   1798: aload 22
    //   1800: astore 27
    //   1802: iload 7
    //   1804: istore 8
    //   1806: aload_2
    //   1807: aload 32
    //   1809: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   1812: iload 7
    //   1814: invokeinterface 214 3 0
    //   1819: aload 22
    //   1821: ifnull +10 -> 1831
    //   1824: aload 22
    //   1826: invokeinterface 420 1 0
    //   1831: aload 23
    //   1833: ifnull +1491 -> 3324
    //   1836: aload 23
    //   1838: invokevirtual 421	java/io/OutputStream:close	()V
    //   1841: iload 7
    //   1843: istore 8
    //   1845: aload 23
    //   1847: astore 25
    //   1849: iload 6
    //   1851: istore 7
    //   1853: aload 22
    //   1855: astore 24
    //   1857: iload 13
    //   1859: iconst_1
    //   1860: iadd
    //   1861: istore 13
    //   1863: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1866: ifeq +43 -> 1909
    //   1869: ldc 15
    //   1871: iconst_2
    //   1872: new 221	java/lang/StringBuilder
    //   1875: dup
    //   1876: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1879: ldc_w 423
    //   1882: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: iload 8
    //   1887: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1890: ldc_w 428
    //   1893: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: aload_1
    //   1897: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1900: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1906: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1909: iload 13
    //   1911: iconst_2
    //   1912: if_icmpge +22 -> 1934
    //   1915: iload 8
    //   1917: ifeq +17 -> 1934
    //   1920: aload 33
    //   1922: monitorenter
    //   1923: aload 33
    //   1925: ldc2_w 429
    //   1928: invokevirtual 434	java/lang/Object:wait	(J)V
    //   1931: aload 33
    //   1933: monitorexit
    //   1934: iload 8
    //   1936: ifeq +9 -> 1945
    //   1939: iload 13
    //   1941: iconst_2
    //   1942: if_icmplt +1367 -> 3309
    //   1945: iload 8
    //   1947: istore 6
    //   1949: iload 8
    //   1951: ifne -1904 -> 47
    //   1954: iload 8
    //   1956: istore 6
    //   1958: aload_3
    //   1959: invokestatic 506	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1962: ifne -1915 -> 47
    //   1965: bipush 18
    //   1967: istore 7
    //   1969: aload_1
    //   1970: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1973: invokevirtual 509	java/io/File:getPath	()Ljava/lang/String;
    //   1976: aload_3
    //   1977: invokestatic 514	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: iload 7
    //   1982: istore 6
    //   1984: iload 7
    //   1986: bipush 18
    //   1988: if_icmpne -1941 -> 47
    //   1991: aload_1
    //   1992: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1995: invokevirtual 309	java/io/File:delete	()Z
    //   1998: pop
    //   1999: iload 7
    //   2001: ireturn
    //   2002: bipush 8
    //   2004: istore 11
    //   2006: iload 11
    //   2008: istore 9
    //   2010: iload 11
    //   2012: istore 10
    //   2014: iload 11
    //   2016: istore 8
    //   2018: aload 24
    //   2020: astore 27
    //   2022: iload 6
    //   2024: istore 12
    //   2026: aload 23
    //   2028: astore 26
    //   2030: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2033: ifeq +78 -> 2111
    //   2036: iload 11
    //   2038: istore 9
    //   2040: iload 11
    //   2042: istore 10
    //   2044: iload 11
    //   2046: istore 8
    //   2048: aload 24
    //   2050: astore 27
    //   2052: iload 6
    //   2054: istore 12
    //   2056: aload 23
    //   2058: astore 26
    //   2060: ldc 15
    //   2062: iconst_2
    //   2063: new 221	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2070: ldc_w 516
    //   2073: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: iload 7
    //   2078: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2081: ldc_w 518
    //   2084: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: lload 19
    //   2089: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2092: ldc_w 520
    //   2095: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: aload_1
    //   2099: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2102: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2108: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2111: iload 11
    //   2113: istore 7
    //   2115: iload 11
    //   2117: istore 9
    //   2119: iload 11
    //   2121: istore 10
    //   2123: iload 11
    //   2125: istore 8
    //   2127: aload 24
    //   2129: astore 27
    //   2131: iload 6
    //   2133: istore 12
    //   2135: aload 23
    //   2137: astore 26
    //   2139: aload 36
    //   2141: invokevirtual 202	java/io/File:exists	()Z
    //   2144: ifeq -931 -> 1213
    //   2147: iload 11
    //   2149: istore 9
    //   2151: iload 11
    //   2153: istore 10
    //   2155: iload 11
    //   2157: istore 8
    //   2159: aload 24
    //   2161: astore 27
    //   2163: iload 6
    //   2165: istore 12
    //   2167: aload 23
    //   2169: astore 26
    //   2171: aload 36
    //   2173: invokevirtual 309	java/io/File:delete	()Z
    //   2176: pop
    //   2177: iload 11
    //   2179: istore 7
    //   2181: goto -968 -> 1213
    //   2184: astore 26
    //   2186: iload 9
    //   2188: istore 7
    //   2190: aload 24
    //   2192: astore 25
    //   2194: aload 26
    //   2196: astore 24
    //   2198: aload 24
    //   2200: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2203: aload 24
    //   2205: instanceof 442
    //   2208: ifne +15 -> 2223
    //   2211: aload 24
    //   2213: instanceof 444
    //   2216: istore 21
    //   2218: iload 21
    //   2220: ifeq +173 -> 2393
    //   2223: iconst_3
    //   2224: istore 7
    //   2226: aload 25
    //   2228: ifnull +1118 -> 3346
    //   2231: aload 25
    //   2233: invokevirtual 413	java/io/InputStream:close	()V
    //   2236: goto -564 -> 1672
    //   2239: iload 7
    //   2241: istore 9
    //   2243: iload 7
    //   2245: istore 10
    //   2247: iload 7
    //   2249: istore 8
    //   2251: aload 24
    //   2253: astore 27
    //   2255: iload 6
    //   2257: istore 12
    //   2259: aload 23
    //   2261: astore 26
    //   2263: iconst_3
    //   2264: anewarray 237	java/lang/String
    //   2267: astore 25
    //   2269: aload 25
    //   2271: iconst_0
    //   2272: aload 5
    //   2274: aastore
    //   2275: aload 25
    //   2277: iconst_1
    //   2278: ldc_w 465
    //   2281: aastore
    //   2282: aload 25
    //   2284: iconst_2
    //   2285: ldc_w 392
    //   2288: aastore
    //   2289: goto -834 -> 1455
    //   2292: astore 25
    //   2294: iload 10
    //   2296: istore 7
    //   2298: iload 7
    //   2300: istore 8
    //   2302: aload 24
    //   2304: astore 27
    //   2306: iload 6
    //   2308: istore 12
    //   2310: aload 23
    //   2312: astore 26
    //   2314: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2317: ifeq +48 -> 2365
    //   2320: iload 7
    //   2322: istore 8
    //   2324: aload 24
    //   2326: astore 27
    //   2328: iload 6
    //   2330: istore 12
    //   2332: aload 23
    //   2334: astore 26
    //   2336: ldc 15
    //   2338: iconst_2
    //   2339: new 221	java/lang/StringBuilder
    //   2342: dup
    //   2343: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2346: ldc_w 522
    //   2349: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: aload 32
    //   2354: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2357: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2360: aload 25
    //   2362: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2365: iconst_5
    //   2366: istore 7
    //   2368: aload 24
    //   2370: ifnull +973 -> 3343
    //   2373: iload 6
    //   2375: istore 8
    //   2377: aload 23
    //   2379: astore 26
    //   2381: aload 23
    //   2383: astore 27
    //   2385: aload 24
    //   2387: invokevirtual 413	java/io/InputStream:close	()V
    //   2390: goto -718 -> 1672
    //   2393: aload 24
    //   2395: instanceof 469
    //   2398: istore 21
    //   2400: iload 21
    //   2402: ifeq +10 -> 2412
    //   2405: bipush 11
    //   2407: istore 7
    //   2409: goto -183 -> 2226
    //   2412: iconst_4
    //   2413: istore 7
    //   2415: goto -189 -> 2226
    //   2418: astore 26
    //   2420: iconst_5
    //   2421: istore 7
    //   2423: aload 24
    //   2425: astore 25
    //   2427: aload 26
    //   2429: astore 24
    //   2431: aload 25
    //   2433: ifnull +32 -> 2465
    //   2436: iload 7
    //   2438: istore 10
    //   2440: iload 6
    //   2442: istore 9
    //   2444: aload 23
    //   2446: astore 28
    //   2448: iload 6
    //   2450: istore 8
    //   2452: aload 23
    //   2454: astore 26
    //   2456: aload 23
    //   2458: astore 27
    //   2460: aload 25
    //   2462: invokevirtual 413	java/io/InputStream:close	()V
    //   2465: iload 7
    //   2467: istore 10
    //   2469: iload 6
    //   2471: istore 9
    //   2473: aload 23
    //   2475: astore 28
    //   2477: iload 6
    //   2479: istore 8
    //   2481: aload 23
    //   2483: astore 26
    //   2485: aload 23
    //   2487: astore 27
    //   2489: aload 24
    //   2491: athrow
    //   2492: astore 24
    //   2494: aload 28
    //   2496: astore 23
    //   2498: iload 10
    //   2500: istore 7
    //   2502: iload 9
    //   2504: istore 6
    //   2506: aload 22
    //   2508: astore 26
    //   2510: aload 23
    //   2512: astore 25
    //   2514: aload 24
    //   2516: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2519: aload 22
    //   2521: astore 26
    //   2523: aload 23
    //   2525: astore 25
    //   2527: aload 24
    //   2529: instanceof 449
    //   2532: ifeq +261 -> 2793
    //   2535: bipush 10
    //   2537: istore 9
    //   2539: aload 22
    //   2541: astore 26
    //   2543: aload 23
    //   2545: astore 25
    //   2547: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2550: ifeq +65 -> 2615
    //   2553: aload 22
    //   2555: astore 26
    //   2557: aload 23
    //   2559: astore 25
    //   2561: ldc 15
    //   2563: iconst_2
    //   2564: new 221	java/lang/StringBuilder
    //   2567: dup
    //   2568: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2571: ldc_w 451
    //   2574: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: iload 9
    //   2579: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2582: ldc_w 453
    //   2585: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: aload_1
    //   2589: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2592: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2595: ldc_w 455
    //   2598: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: aload 24
    //   2603: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2606: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2612: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2615: aload_2
    //   2616: ifnull +24 -> 2640
    //   2619: aload 22
    //   2621: astore 26
    //   2623: aload 23
    //   2625: astore 25
    //   2627: aload_2
    //   2628: aload 32
    //   2630: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   2633: iload 9
    //   2635: invokeinterface 214 3 0
    //   2640: aload 22
    //   2642: ifnull +10 -> 2652
    //   2645: aload 22
    //   2647: invokeinterface 420 1 0
    //   2652: aload 22
    //   2654: astore 24
    //   2656: iload 6
    //   2658: istore 7
    //   2660: aload 23
    //   2662: astore 25
    //   2664: iload 9
    //   2666: istore 8
    //   2668: aload 23
    //   2670: ifnull -813 -> 1857
    //   2673: aload 23
    //   2675: invokevirtual 421	java/io/OutputStream:close	()V
    //   2678: aload 22
    //   2680: astore 24
    //   2682: iload 6
    //   2684: istore 7
    //   2686: aload 23
    //   2688: astore 25
    //   2690: iload 9
    //   2692: istore 8
    //   2694: goto -837 -> 1857
    //   2697: astore 24
    //   2699: aload 22
    //   2701: astore 24
    //   2703: iload 6
    //   2705: istore 7
    //   2707: aload 23
    //   2709: astore 25
    //   2711: iload 9
    //   2713: istore 8
    //   2715: goto -858 -> 1857
    //   2718: aload_2
    //   2719: ifnull +36 -> 2755
    //   2722: aload 24
    //   2724: astore 28
    //   2726: aload 22
    //   2728: astore 25
    //   2730: iload 6
    //   2732: istore 9
    //   2734: aload 24
    //   2736: astore 29
    //   2738: aload 22
    //   2740: astore 26
    //   2742: aload_2
    //   2743: aload 32
    //   2745: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   2748: iload 7
    //   2750: invokeinterface 214 3 0
    //   2755: aload 24
    //   2757: astore 23
    //   2759: goto -940 -> 1819
    //   2762: astore 24
    //   2764: aload 24
    //   2766: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2769: goto -938 -> 1831
    //   2772: astore 24
    //   2774: iload 7
    //   2776: istore 8
    //   2778: aload 22
    //   2780: astore 24
    //   2782: iload 6
    //   2784: istore 7
    //   2786: aload 23
    //   2788: astore 25
    //   2790: goto -933 -> 1857
    //   2793: aload 22
    //   2795: astore 26
    //   2797: aload 23
    //   2799: astore 25
    //   2801: aload 24
    //   2803: instanceof 442
    //   2806: ifne +552 -> 3358
    //   2809: aload 22
    //   2811: astore 26
    //   2813: aload 23
    //   2815: astore 25
    //   2817: aload 24
    //   2819: instanceof 444
    //   2822: ifeq +6 -> 2828
    //   2825: goto +533 -> 3358
    //   2828: aload 22
    //   2830: astore 26
    //   2832: aload 23
    //   2834: astore 25
    //   2836: aload 24
    //   2838: instanceof 469
    //   2841: ifeq +24 -> 2865
    //   2844: aload 22
    //   2846: astore 26
    //   2848: aload 23
    //   2850: astore 25
    //   2852: aload_1
    //   2853: bipush 11
    //   2855: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2858: iload 7
    //   2860: istore 9
    //   2862: goto -323 -> 2539
    //   2865: iconst_4
    //   2866: istore 9
    //   2868: goto -329 -> 2539
    //   2871: astore 24
    //   2873: aload 24
    //   2875: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   2878: goto -226 -> 2652
    //   2881: astore 24
    //   2883: iload 8
    //   2885: istore 6
    //   2887: aload 26
    //   2889: astore 23
    //   2891: aload 22
    //   2893: astore 26
    //   2895: aload 23
    //   2897: astore 25
    //   2899: aload 24
    //   2901: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   2904: iconst_5
    //   2905: istore 9
    //   2907: aload_2
    //   2908: ifnull +23 -> 2931
    //   2911: aload 22
    //   2913: astore 26
    //   2915: aload 23
    //   2917: astore 25
    //   2919: aload_2
    //   2920: aload 32
    //   2922: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   2925: iconst_5
    //   2926: invokeinterface 214 3 0
    //   2931: aload 22
    //   2933: ifnull +10 -> 2943
    //   2936: aload 22
    //   2938: invokeinterface 420 1 0
    //   2943: aload 22
    //   2945: astore 24
    //   2947: iload 6
    //   2949: istore 7
    //   2951: aload 23
    //   2953: astore 25
    //   2955: iload 9
    //   2957: istore 8
    //   2959: aload 23
    //   2961: ifnull -1104 -> 1857
    //   2964: aload 23
    //   2966: invokevirtual 421	java/io/OutputStream:close	()V
    //   2969: aload 22
    //   2971: astore 24
    //   2973: iload 6
    //   2975: istore 7
    //   2977: aload 23
    //   2979: astore 25
    //   2981: iload 9
    //   2983: istore 8
    //   2985: goto -1128 -> 1857
    //   2988: astore 24
    //   2990: aload 22
    //   2992: astore 24
    //   2994: iload 6
    //   2996: istore 7
    //   2998: aload 23
    //   3000: astore 25
    //   3002: iload 9
    //   3004: istore 8
    //   3006: goto -1149 -> 1857
    //   3009: astore 24
    //   3011: aload 24
    //   3013: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   3016: goto -73 -> 2943
    //   3019: astore_0
    //   3020: aload 27
    //   3022: astore_1
    //   3023: aload 22
    //   3025: ifnull +10 -> 3035
    //   3028: aload 22
    //   3030: invokeinterface 420 1 0
    //   3035: aload_1
    //   3036: ifnull +7 -> 3043
    //   3039: aload_1
    //   3040: invokevirtual 421	java/io/OutputStream:close	()V
    //   3043: aload_0
    //   3044: athrow
    //   3045: astore_2
    //   3046: aload_2
    //   3047: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   3050: goto -15 -> 3035
    //   3053: astore_0
    //   3054: aload 33
    //   3056: monitorexit
    //   3057: aload_0
    //   3058: athrow
    //   3059: astore_0
    //   3060: aload_0
    //   3061: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   3064: bipush 17
    //   3066: istore 7
    //   3068: goto -1088 -> 1980
    //   3071: astore_1
    //   3072: goto -29 -> 3043
    //   3075: astore 22
    //   3077: goto -1146 -> 1931
    //   3080: astore_0
    //   3081: aload 23
    //   3083: astore_1
    //   3084: goto -61 -> 3023
    //   3087: astore_0
    //   3088: aload 28
    //   3090: astore_1
    //   3091: aload 25
    //   3093: astore 22
    //   3095: goto -72 -> 3023
    //   3098: astore_0
    //   3099: aload 26
    //   3101: astore 22
    //   3103: aload 25
    //   3105: astore_1
    //   3106: goto -83 -> 3023
    //   3109: astore 24
    //   3111: goto -220 -> 2891
    //   3114: astore 24
    //   3116: iload 9
    //   3118: istore 6
    //   3120: aload 29
    //   3122: astore 23
    //   3124: aload 26
    //   3126: astore 22
    //   3128: goto -237 -> 2891
    //   3131: astore 24
    //   3133: goto -627 -> 2506
    //   3136: astore 24
    //   3138: goto -632 -> 2506
    //   3141: astore 24
    //   3143: iload 10
    //   3145: istore 6
    //   3147: aload 30
    //   3149: astore 23
    //   3151: aload 27
    //   3153: astore 22
    //   3155: iload 8
    //   3157: istore 7
    //   3159: goto -653 -> 2506
    //   3162: astore 25
    //   3164: aload 24
    //   3166: astore 23
    //   3168: aload 25
    //   3170: astore 24
    //   3172: goto -666 -> 2506
    //   3175: astore 24
    //   3177: iload 8
    //   3179: istore 7
    //   3181: aload 27
    //   3183: astore 25
    //   3185: iload 12
    //   3187: istore 6
    //   3189: aload 26
    //   3191: astore 23
    //   3193: goto -762 -> 2431
    //   3196: astore 24
    //   3198: goto -767 -> 2431
    //   3201: astore 26
    //   3203: aconst_null
    //   3204: astore 25
    //   3206: aload 24
    //   3208: astore 23
    //   3210: iconst_5
    //   3211: istore 7
    //   3213: aload 26
    //   3215: astore 24
    //   3217: goto -786 -> 2431
    //   3220: astore 24
    //   3222: aconst_null
    //   3223: astore 25
    //   3225: iconst_5
    //   3226: istore 7
    //   3228: goto -797 -> 2431
    //   3231: astore 25
    //   3233: iconst_5
    //   3234: istore 7
    //   3236: goto -938 -> 2298
    //   3239: astore 25
    //   3241: aconst_null
    //   3242: astore 26
    //   3244: aload 24
    //   3246: astore 23
    //   3248: iconst_5
    //   3249: istore 7
    //   3251: aload 26
    //   3253: astore 24
    //   3255: goto -957 -> 2298
    //   3258: astore 25
    //   3260: aconst_null
    //   3261: astore 24
    //   3263: iconst_5
    //   3264: istore 7
    //   3266: goto -968 -> 2298
    //   3269: astore 26
    //   3271: aload 24
    //   3273: astore 25
    //   3275: iconst_5
    //   3276: istore 7
    //   3278: aload 26
    //   3280: astore 24
    //   3282: goto -1084 -> 2198
    //   3285: astore 26
    //   3287: aload 24
    //   3289: astore 23
    //   3291: iconst_5
    //   3292: istore 7
    //   3294: aload 26
    //   3296: astore 24
    //   3298: goto -1100 -> 2198
    //   3301: astore 24
    //   3303: iconst_5
    //   3304: istore 7
    //   3306: goto -1108 -> 2198
    //   3309: aload 24
    //   3311: astore 22
    //   3313: aload 25
    //   3315: astore 24
    //   3317: iload 7
    //   3319: istore 6
    //   3321: goto -2885 -> 436
    //   3324: iload 7
    //   3326: istore 8
    //   3328: aload 22
    //   3330: astore 24
    //   3332: iload 6
    //   3334: istore 7
    //   3336: aload 23
    //   3338: astore 25
    //   3340: goto -1483 -> 1857
    //   3343: goto -1671 -> 1672
    //   3346: goto -1674 -> 1672
    //   3349: goto -1677 -> 1672
    //   3352: goto -2340 -> 1012
    //   3355: goto -2349 -> 1006
    //   3358: iconst_2
    //   3359: istore 9
    //   3361: goto -822 -> 2539
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3364	0	paramAppInterface	AppInterface
    //   0	3364	1	paramDownloadInfo	DownloadInfo
    //   0	3364	2	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   0	3364	3	paramString1	String
    //   0	3364	4	paramString2	String
    //   0	3364	5	paramString3	String
    //   45	3288	6	i1	int
    //   297	3038	7	i2	int
    //   513	2814	8	i3	int
    //   489	2871	9	i4	int
    //   501	2643	10	i5	int
    //   437	1741	11	i6	int
    //   1144	2042	12	i7	int
    //   434	1509	13	i8	int
    //   1111	46	14	i9	int
    //   1114	47	15	i10	int
    //   1117	48	16	i11	int
    //   66	1537	17	l1	long
    //   968	1120	19	l2	long
    //   2216	185	21	bool	boolean
    //   84	2945	22	localObject1	Object
    //   3075	1	22	localInterruptedException	java.lang.InterruptedException
    //   3093	236	22	localObject2	Object
    //   312	719	23	localObject3	Object
    //   1070	1416	23	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   2496	841	23	localObject4	Object
    //   230	2260	24	localObject5	Object
    //   2492	110	24	localIOException1	java.io.IOException
    //   2654	27	24	localObject6	Object
    //   2697	1	24	localIOException2	java.io.IOException
    //   2701	55	24	localObject7	Object
    //   2762	3	24	localIOException3	java.io.IOException
    //   2772	1	24	localIOException4	java.io.IOException
    //   2780	57	24	localObject8	Object
    //   2871	3	24	localIOException5	java.io.IOException
    //   2881	19	24	localException1	java.lang.Exception
    //   2945	27	24	localObject9	Object
    //   2988	1	24	localIOException6	java.io.IOException
    //   2992	1	24	localObject10	Object
    //   3009	3	24	localIOException7	java.io.IOException
    //   3109	1	24	localException2	java.lang.Exception
    //   3114	1	24	localException3	java.lang.Exception
    //   3131	1	24	localIOException8	java.io.IOException
    //   3136	1	24	localIOException9	java.io.IOException
    //   3141	24	24	localIOException10	java.io.IOException
    //   3170	1	24	localObject11	Object
    //   3175	1	24	localObject12	Object
    //   3196	11	24	localObject13	Object
    //   3215	1	24	localObject14	Object
    //   3220	25	24	localObject15	Object
    //   3253	44	24	localObject16	Object
    //   3301	9	24	localIOException11	java.io.IOException
    //   3315	16	24	localObject17	Object
    //   485	1798	25	localObject18	Object
    //   2292	69	25	localThrowable1	java.lang.Throwable
    //   2425	679	25	localObject19	Object
    //   3162	7	25	localIOException12	java.io.IOException
    //   3183	41	25	localObject20	Object
    //   3231	1	25	localThrowable2	java.lang.Throwable
    //   3239	1	25	localThrowable3	java.lang.Throwable
    //   3258	1	25	localThrowable4	java.lang.Throwable
    //   3273	66	25	localObject21	Object
    //   497	1673	26	localObject22	Object
    //   2184	11	26	localIOException13	java.io.IOException
    //   2261	119	26	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   2418	10	26	localObject23	Object
    //   2454	736	26	localObject24	Object
    //   3201	13	26	localObject25	Object
    //   3242	10	26	localObject26	Object
    //   3269	10	26	localIOException14	java.io.IOException
    //   3285	10	26	localIOException15	java.io.IOException
    //   509	2673	27	localObject27	Object
    //   481	2608	28	localObject28	Object
    //   493	2628	29	localObject29	Object
    //   505	2643	30	localObject30	Object
    //   247	838	31	localHttpGet	org.apache.http.client.methods.HttpGet
    //   61	2860	32	localURL	URL
    //   75	2980	33	localObject31	Object
    //   21	1377	34	localNetworkInfo	NetworkInfo
    //   256	219	35	localBasicHttpParams	BasicHttpParams
    //   414	1758	36	localFile	File
    // Exception table:
    //   from	to	target	type
    //   50	63	160	java/net/MalformedURLException
    //   77	86	175	java/lang/Exception
    //   91	107	175	java/lang/Exception
    //   111	123	175	java/lang/Exception
    //   123	158	175	java/lang/Exception
    //   238	249	1070	java/lang/IllegalArgumentException
    //   1072	1086	1089	java/lang/IllegalArgumentException
    //   1150	1156	2184	java/io/IOException
    //   1180	1209	2184	java/io/IOException
    //   1237	1243	2184	java/io/IOException
    //   1267	1309	2184	java/io/IOException
    //   1333	1341	2184	java/io/IOException
    //   1365	1373	2184	java/io/IOException
    //   1397	1405	2184	java/io/IOException
    //   1429	1435	2184	java/io/IOException
    //   1484	1496	2184	java/io/IOException
    //   1520	1529	2184	java/io/IOException
    //   1553	1559	2184	java/io/IOException
    //   1583	1638	2184	java/io/IOException
    //   2030	2036	2184	java/io/IOException
    //   2060	2111	2184	java/io/IOException
    //   2139	2147	2184	java/io/IOException
    //   2171	2177	2184	java/io/IOException
    //   2263	2269	2184	java/io/IOException
    //   1150	1156	2292	java/lang/Throwable
    //   1180	1209	2292	java/lang/Throwable
    //   1237	1243	2292	java/lang/Throwable
    //   1267	1309	2292	java/lang/Throwable
    //   1333	1341	2292	java/lang/Throwable
    //   1365	1373	2292	java/lang/Throwable
    //   1397	1405	2292	java/lang/Throwable
    //   1429	1435	2292	java/lang/Throwable
    //   1484	1496	2292	java/lang/Throwable
    //   1520	1529	2292	java/lang/Throwable
    //   1553	1559	2292	java/lang/Throwable
    //   1583	1638	2292	java/lang/Throwable
    //   2030	2036	2292	java/lang/Throwable
    //   2060	2111	2292	java/lang/Throwable
    //   2139	2147	2292	java/lang/Throwable
    //   2171	2177	2292	java/lang/Throwable
    //   2263	2269	2292	java/lang/Throwable
    //   1006	1012	2418	finally
    //   1021	1040	2418	finally
    //   1051	1067	2418	finally
    //   1667	1672	2492	java/io/IOException
    //   2460	2465	2492	java/io/IOException
    //   2489	2492	2492	java/io/IOException
    //   2673	2678	2697	java/io/IOException
    //   1824	1831	2762	java/io/IOException
    //   1836	1841	2772	java/io/IOException
    //   2645	2652	2871	java/io/IOException
    //   1667	1672	2881	java/lang/Exception
    //   2385	2390	2881	java/lang/Exception
    //   2460	2465	2881	java/lang/Exception
    //   2489	2492	2881	java/lang/Exception
    //   2964	2969	2988	java/io/IOException
    //   2936	2943	3009	java/io/IOException
    //   1667	1672	3019	finally
    //   2385	2390	3019	finally
    //   2460	2465	3019	finally
    //   2489	2492	3019	finally
    //   3028	3035	3045	java/io/IOException
    //   1923	1931	3053	finally
    //   1931	1934	3053	finally
    //   3054	3057	3053	finally
    //   1969	1980	3059	java/io/IOException
    //   3039	3043	3071	java/io/IOException
    //   1923	1931	3075	java/lang/InterruptedException
    //   2231	2236	3080	finally
    //   515	522	3087	finally
    //   558	564	3087	finally
    //   600	627	3087	finally
    //   663	682	3087	finally
    //   718	724	3087	finally
    //   760	769	3087	finally
    //   805	819	3087	finally
    //   859	872	3087	finally
    //   908	917	3087	finally
    //   961	970	3087	finally
    //   1713	1720	3087	finally
    //   1756	1766	3087	finally
    //   1806	1819	3087	finally
    //   2742	2755	3087	finally
    //   2514	2519	3098	finally
    //   2527	2535	3098	finally
    //   2547	2553	3098	finally
    //   2561	2615	3098	finally
    //   2627	2640	3098	finally
    //   2801	2809	3098	finally
    //   2817	2825	3098	finally
    //   2836	2844	3098	finally
    //   2852	2858	3098	finally
    //   2899	2904	3098	finally
    //   2919	2931	3098	finally
    //   2231	2236	3109	java/lang/Exception
    //   515	522	3114	java/lang/Exception
    //   558	564	3114	java/lang/Exception
    //   600	627	3114	java/lang/Exception
    //   663	682	3114	java/lang/Exception
    //   718	724	3114	java/lang/Exception
    //   760	769	3114	java/lang/Exception
    //   805	819	3114	java/lang/Exception
    //   859	872	3114	java/lang/Exception
    //   908	917	3114	java/lang/Exception
    //   961	970	3114	java/lang/Exception
    //   1713	1720	3114	java/lang/Exception
    //   1756	1766	3114	java/lang/Exception
    //   1806	1819	3114	java/lang/Exception
    //   2742	2755	3114	java/lang/Exception
    //   2231	2236	3131	java/io/IOException
    //   2385	2390	3136	java/io/IOException
    //   515	522	3141	java/io/IOException
    //   558	564	3141	java/io/IOException
    //   600	627	3141	java/io/IOException
    //   663	682	3141	java/io/IOException
    //   718	724	3141	java/io/IOException
    //   760	769	3141	java/io/IOException
    //   805	819	3141	java/io/IOException
    //   859	872	3141	java/io/IOException
    //   908	917	3141	java/io/IOException
    //   961	970	3141	java/io/IOException
    //   1713	1720	3141	java/io/IOException
    //   1756	1766	3141	java/io/IOException
    //   1806	1819	3141	java/io/IOException
    //   2742	2755	3162	java/io/IOException
    //   1150	1156	3175	finally
    //   1180	1209	3175	finally
    //   1237	1243	3175	finally
    //   1267	1309	3175	finally
    //   1333	1341	3175	finally
    //   1365	1373	3175	finally
    //   1397	1405	3175	finally
    //   1429	1435	3175	finally
    //   1484	1496	3175	finally
    //   1520	1529	3175	finally
    //   1553	1559	3175	finally
    //   1583	1638	3175	finally
    //   2030	2036	3175	finally
    //   2060	2111	3175	finally
    //   2139	2147	3175	finally
    //   2171	2177	3175	finally
    //   2263	2269	3175	finally
    //   2314	2320	3175	finally
    //   2336	2365	3175	finally
    //   2198	2218	3196	finally
    //   2393	2400	3196	finally
    //   976	987	3201	finally
    //   987	996	3220	finally
    //   1006	1012	3231	java/lang/Throwable
    //   1021	1040	3231	java/lang/Throwable
    //   1051	1067	3231	java/lang/Throwable
    //   976	987	3239	java/lang/Throwable
    //   987	996	3258	java/lang/Throwable
    //   1006	1012	3269	java/io/IOException
    //   1021	1040	3269	java/io/IOException
    //   1051	1067	3269	java/io/IOException
    //   976	987	3285	java/io/IOException
    //   987	996	3301	java/io/IOException
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    // Byte code:
    //   0: new 185	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_1
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 532	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 8
    //   12: getstatic 162	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   15: invokevirtual 477	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +34 -> 56
    //   25: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 15
    //   33: iconst_2
    //   34: ldc_w 534
    //   37: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 8
    //   42: iconst_1
    //   43: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   46: aload_2
    //   47: aload 8
    //   49: invokeinterface 539 2 0
    //   54: iconst_1
    //   55: ireturn
    //   56: new 183	java/net/URL
    //   59: dup
    //   60: aload 8
    //   62: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: pop
    //   69: new 4	java/lang/Object
    //   72: dup
    //   73: invokespecial 170	java/lang/Object:<init>	()V
    //   76: astore 9
    //   78: aload 8
    //   80: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   83: astore 6
    //   85: new 245	org/apache/http/client/methods/HttpGet
    //   88: dup
    //   89: aload 6
    //   91: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   94: pop
    //   95: aconst_null
    //   96: astore_0
    //   97: iconst_m1
    //   98: istore 5
    //   100: aconst_null
    //   101: astore_1
    //   102: aload 10
    //   104: ifnull +9 -> 113
    //   107: aload 10
    //   109: invokevirtual 276	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 543	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: aload 7
    //   121: getstatic 164	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne +12 -> 139
    //   130: iconst_0
    //   131: putstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   134: aload 7
    //   136: putstatic 164	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 267	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   142: astore 11
    //   144: invokestatic 271	android/net/Proxy:getDefaultPort	()I
    //   147: istore_3
    //   148: aload 10
    //   150: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   153: ifeq +414 -> 567
    //   156: aload 11
    //   158: ifnull +409 -> 567
    //   161: iload_3
    //   162: ifle +405 -> 567
    //   165: getstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   168: ifne +399 -> 567
    //   171: aload_1
    //   172: ifnull +381 -> 553
    //   175: aload 7
    //   177: getstatic 549	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +25 -> 208
    //   186: aload 7
    //   188: getstatic 551	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   191: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +14 -> 208
    //   197: aload 7
    //   199: getstatic 553	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   202: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +309 -> 514
    //   208: aload 6
    //   210: aload 11
    //   212: iload_3
    //   213: invokestatic 556	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   216: astore_1
    //   217: aload_1
    //   218: astore_0
    //   219: aload_0
    //   220: astore_1
    //   221: aload_0
    //   222: ldc_w 558
    //   225: ldc_w 560
    //   228: invokevirtual 565	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: astore_1
    //   233: aload_0
    //   234: sipush 30000
    //   237: invokevirtual 569	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   240: aload_0
    //   241: astore_1
    //   242: aload_0
    //   243: sipush 30000
    //   246: invokevirtual 572	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   249: aload_0
    //   250: astore_1
    //   251: aload_0
    //   252: iconst_1
    //   253: invokevirtual 576	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: invokevirtual 579	java/net/HttpURLConnection:connect	()V
    //   262: aload_0
    //   263: astore_1
    //   264: aload 8
    //   266: aload_0
    //   267: invokevirtual 582	java/net/HttpURLConnection:getResponseCode	()I
    //   270: putfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   273: aload_0
    //   274: astore_1
    //   275: aload 8
    //   277: aload_0
    //   278: invokevirtual 586	java/net/HttpURLConnection:getContentLength	()I
    //   281: putfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   284: aload_0
    //   285: astore_1
    //   286: aload 8
    //   288: aload_0
    //   289: invokevirtual 591	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   292: putfield 592	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   295: aload_0
    //   296: astore_1
    //   297: aload 8
    //   299: aload_0
    //   300: invokevirtual 595	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   303: putfield 597	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   306: aload_0
    //   307: astore_1
    //   308: aload 8
    //   310: iconst_0
    //   311: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   314: iconst_0
    //   315: istore_3
    //   316: aload_0
    //   317: astore_1
    //   318: iload_3
    //   319: istore 4
    //   321: aload_0
    //   322: ifnull +12 -> 334
    //   325: aload_0
    //   326: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   329: iload_3
    //   330: istore 4
    //   332: aload_0
    //   333: astore_1
    //   334: iload 5
    //   336: iconst_1
    //   337: iadd
    //   338: istore 5
    //   340: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +44 -> 387
    //   346: ldc 15
    //   348: iconst_2
    //   349: new 221	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 602
    //   359: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload 4
    //   364: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 428
    //   370: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 8
    //   375: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   378: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload 5
    //   389: iconst_2
    //   390: if_icmpge +22 -> 412
    //   393: iload 4
    //   395: ifeq +17 -> 412
    //   398: aload 9
    //   400: monitorenter
    //   401: aload 9
    //   403: ldc2_w 603
    //   406: invokevirtual 434	java/lang/Object:wait	(J)V
    //   409: aload 9
    //   411: monitorexit
    //   412: iload 4
    //   414: ifeq +9 -> 423
    //   417: iload 5
    //   419: iconst_2
    //   420: if_icmplt +475 -> 895
    //   423: aload 8
    //   425: iload 4
    //   427: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   430: aload_2
    //   431: aload 8
    //   433: invokeinterface 539 2 0
    //   438: iload 4
    //   440: ireturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 235	java/net/MalformedURLException:printStackTrace	()V
    //   446: aload 8
    //   448: aload_0
    //   449: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   452: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   455: aload 8
    //   457: iconst_5
    //   458: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   461: aload_2
    //   462: aload 8
    //   464: invokeinterface 539 2 0
    //   469: iconst_5
    //   470: ireturn
    //   471: astore_0
    //   472: new 245	org/apache/http/client/methods/HttpGet
    //   475: dup
    //   476: aload 6
    //   478: invokestatic 373	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   484: pop
    //   485: aload 6
    //   487: invokestatic 373	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   490: astore 6
    //   492: goto -397 -> 95
    //   495: astore_0
    //   496: aload 8
    //   498: bipush 13
    //   500: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   503: aload_2
    //   504: aload 8
    //   506: invokeinterface 539 2 0
    //   511: bipush 13
    //   513: ireturn
    //   514: aload 7
    //   516: getstatic 605	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +17 -> 539
    //   525: aload 6
    //   527: aload 11
    //   529: iload_3
    //   530: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   533: astore_1
    //   534: aload_1
    //   535: astore_0
    //   536: goto -317 -> 219
    //   539: aload 6
    //   541: aload 11
    //   543: iload_3
    //   544: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   547: astore_1
    //   548: aload_1
    //   549: astore_0
    //   550: goto -331 -> 219
    //   553: aload 6
    //   555: aload 11
    //   557: iload_3
    //   558: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   561: astore_1
    //   562: aload_1
    //   563: astore_0
    //   564: goto -345 -> 219
    //   567: new 183	java/net/URL
    //   570: dup
    //   571: aload 6
    //   573: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   576: invokevirtual 611	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   579: checkcast 562	java/net/HttpURLConnection
    //   582: astore_1
    //   583: aload_1
    //   584: astore_0
    //   585: goto -366 -> 219
    //   588: astore 7
    //   590: aload_0
    //   591: astore_1
    //   592: aload 7
    //   594: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   597: aload_0
    //   598: astore_1
    //   599: aload 7
    //   601: instanceof 449
    //   604: ifeq +91 -> 695
    //   607: bipush 10
    //   609: istore_3
    //   610: aload_0
    //   611: astore_1
    //   612: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +59 -> 674
    //   618: aload_0
    //   619: astore_1
    //   620: ldc 15
    //   622: iconst_2
    //   623: new 221	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 613
    //   633: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_3
    //   637: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 453
    //   643: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 8
    //   648: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   651: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 615
    //   657: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 7
    //   662: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   665: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: astore_1
    //   676: iload_3
    //   677: istore 4
    //   679: aload_0
    //   680: ifnull -346 -> 334
    //   683: aload_0
    //   684: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   687: aload_0
    //   688: astore_1
    //   689: iload_3
    //   690: istore 4
    //   692: goto -358 -> 334
    //   695: aload_0
    //   696: astore_1
    //   697: aload 7
    //   699: instanceof 442
    //   702: ifne +198 -> 900
    //   705: aload_0
    //   706: astore_1
    //   707: aload 7
    //   709: instanceof 444
    //   712: ifeq +6 -> 718
    //   715: goto +185 -> 900
    //   718: aload_0
    //   719: astore_1
    //   720: aload 7
    //   722: instanceof 469
    //   725: ifeq +17 -> 742
    //   728: aload_0
    //   729: astore_1
    //   730: aload 8
    //   732: bipush 11
    //   734: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   737: iconst_5
    //   738: istore_3
    //   739: goto -129 -> 610
    //   742: aload_0
    //   743: astore_1
    //   744: aload 7
    //   746: instanceof 173
    //   749: ifeq +156 -> 905
    //   752: bipush 13
    //   754: istore_3
    //   755: goto -145 -> 610
    //   758: aload_0
    //   759: astore_1
    //   760: aload 7
    //   762: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   765: iconst_5
    //   766: istore_3
    //   767: aload_0
    //   768: astore_1
    //   769: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +59 -> 831
    //   775: aload_0
    //   776: astore_1
    //   777: ldc 15
    //   779: iconst_2
    //   780: new 221	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 613
    //   790: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: iconst_5
    //   794: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 453
    //   800: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 8
    //   805: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   808: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 455
    //   814: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 7
    //   819: invokevirtual 616	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload_0
    //   832: astore_1
    //   833: iload_3
    //   834: istore 4
    //   836: aload_0
    //   837: ifnull -503 -> 334
    //   840: aload_0
    //   841: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   844: aload_0
    //   845: astore_1
    //   846: iload_3
    //   847: istore 4
    //   849: goto -515 -> 334
    //   852: astore_0
    //   853: aload_1
    //   854: astore_2
    //   855: aload_0
    //   856: astore_1
    //   857: aload_2
    //   858: ifnull +7 -> 865
    //   861: aload_2
    //   862: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   865: aload_1
    //   866: athrow
    //   867: astore_0
    //   868: aload 9
    //   870: monitorexit
    //   871: aload_0
    //   872: athrow
    //   873: astore_0
    //   874: goto -465 -> 409
    //   877: astore_1
    //   878: aload_0
    //   879: astore_2
    //   880: goto -23 -> 857
    //   883: astore_1
    //   884: aload_1
    //   885: astore 7
    //   887: goto -129 -> 758
    //   890: astore 7
    //   892: goto -302 -> 590
    //   895: aload_1
    //   896: astore_0
    //   897: goto -797 -> 100
    //   900: iconst_2
    //   901: istore_3
    //   902: goto -292 -> 610
    //   905: iconst_4
    //   906: istore_3
    //   907: goto -297 -> 610
    //   910: astore 7
    //   912: goto -154 -> 758
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	paramAppInterface	AppInterface
    //   0	915	1	paramString	String
    //   0	915	2	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   147	760	3	i1	int
    //   319	529	4	i2	int
    //   98	323	5	i3	int
    //   83	489	6	str1	String
    //   117	398	7	str2	String
    //   588	230	7	localIOException1	java.io.IOException
    //   885	1	7	str3	String
    //   890	1	7	localIOException2	java.io.IOException
    //   910	1	7	localException	java.lang.Exception
    //   10	794	8	localDownloadInfo	DownloadInfo
    //   76	793	9	localObject	Object
    //   18	131	10	localNetworkInfo	NetworkInfo
    //   142	414	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   56	69	441	java/net/MalformedURLException
    //   85	95	471	java/lang/IllegalArgumentException
    //   472	492	495	java/lang/IllegalArgumentException
    //   221	231	588	java/io/IOException
    //   233	240	588	java/io/IOException
    //   242	249	588	java/io/IOException
    //   251	256	588	java/io/IOException
    //   258	262	588	java/io/IOException
    //   264	273	588	java/io/IOException
    //   275	284	588	java/io/IOException
    //   286	295	588	java/io/IOException
    //   297	306	588	java/io/IOException
    //   308	314	588	java/io/IOException
    //   221	231	852	finally
    //   233	240	852	finally
    //   242	249	852	finally
    //   251	256	852	finally
    //   258	262	852	finally
    //   264	273	852	finally
    //   275	284	852	finally
    //   286	295	852	finally
    //   297	306	852	finally
    //   308	314	852	finally
    //   592	597	852	finally
    //   599	607	852	finally
    //   612	618	852	finally
    //   620	674	852	finally
    //   697	705	852	finally
    //   707	715	852	finally
    //   720	728	852	finally
    //   730	737	852	finally
    //   744	752	852	finally
    //   760	765	852	finally
    //   769	775	852	finally
    //   777	831	852	finally
    //   401	409	867	finally
    //   409	412	867	finally
    //   868	871	867	finally
    //   401	409	873	java/lang/InterruptedException
    //   107	113	877	finally
    //   113	139	877	finally
    //   139	156	877	finally
    //   165	171	877	finally
    //   175	208	877	finally
    //   208	217	877	finally
    //   514	534	877	finally
    //   539	548	877	finally
    //   553	562	877	finally
    //   567	583	877	finally
    //   107	113	883	java/lang/Exception
    //   113	139	883	java/lang/Exception
    //   139	156	883	java/lang/Exception
    //   165	171	883	java/lang/Exception
    //   175	208	883	java/lang/Exception
    //   208	217	883	java/lang/Exception
    //   514	534	883	java/lang/Exception
    //   539	548	883	java/lang/Exception
    //   553	562	883	java/lang/Exception
    //   567	583	883	java/lang/Exception
    //   107	113	890	java/io/IOException
    //   113	139	890	java/io/IOException
    //   139	156	890	java/io/IOException
    //   165	171	890	java/io/IOException
    //   175	208	890	java/io/IOException
    //   208	217	890	java/io/IOException
    //   514	534	890	java/io/IOException
    //   539	548	890	java/io/IOException
    //   553	562	890	java/io/IOException
    //   567	583	890	java/io/IOException
    //   221	231	910	java/lang/Exception
    //   233	240	910	java/lang/Exception
    //   242	249	910	java/lang/Exception
    //   251	256	910	java/lang/Exception
    //   258	262	910	java/lang/Exception
    //   264	273	910	java/lang/Exception
    //   275	284	910	java/lang/Exception
    //   286	295	910	java/lang/Exception
    //   297	306	910	java/lang/Exception
    //   308	314	910	java/lang/Exception
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    NetworkInfo localNetworkInfo = jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 1;
    }
    try
    {
      paramString = new URL(paramString);
      return a(paramAppInterface, paramString, paramFile, localNetworkInfo);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    // Byte code:
    //   0: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 170	java/lang/Object:<init>	()V
    //   12: astore 24
    //   14: aload_2
    //   15: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +15 -> 35
    //   23: aload_0
    //   24: invokevirtual 202	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: invokevirtual 205	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aconst_null
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 209	java/net/URL:toString	()Ljava/lang/String;
    //   41: astore 19
    //   43: new 245	org/apache/http/client/methods/HttpGet
    //   46: dup
    //   47: aload 19
    //   49: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   52: astore 23
    //   54: new 70	org/apache/http/params/BasicHttpParams
    //   57: dup
    //   58: invokespecial 73	org/apache/http/params/BasicHttpParams:<init>	()V
    //   61: astore 25
    //   63: sipush 20000
    //   66: istore 5
    //   68: ldc 249
    //   70: istore 4
    //   72: aload_3
    //   73: ifnull +104 -> 177
    //   76: invokestatic 267	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   79: astore 19
    //   81: invokestatic 271	android/net/Proxy:getDefaultPort	()I
    //   84: istore 4
    //   86: aload_3
    //   87: invokevirtual 276	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   90: astore 20
    //   92: aload_3
    //   93: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   96: ifeq +51 -> 147
    //   99: aload 20
    //   101: ifnull +14 -> 115
    //   104: aload 20
    //   106: ldc_w 283
    //   109: invokevirtual 287	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   112: ifeq +35 -> 147
    //   115: aload 19
    //   117: ifnull +30 -> 147
    //   120: iload 4
    //   122: ifle +25 -> 147
    //   125: aload 25
    //   127: ldc_w 289
    //   130: new 291	org/apache/http/HttpHost
    //   133: dup
    //   134: aload 19
    //   136: iload 4
    //   138: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   141: invokeinterface 260 3 0
    //   146: pop
    //   147: aload_3
    //   148: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   151: ifeq +751 -> 902
    //   154: sipush 20000
    //   157: istore 5
    //   159: ldc 249
    //   161: istore 4
    //   163: aload 25
    //   165: ldc_w 295
    //   168: sipush 2048
    //   171: invokeinterface 299 3 0
    //   176: pop
    //   177: aload 25
    //   179: ldc 248
    //   181: iload 5
    //   183: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: invokeinterface 260 3 0
    //   191: pop
    //   192: aload 25
    //   194: ldc_w 262
    //   197: iload 4
    //   199: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokeinterface 260 3 0
    //   207: pop
    //   208: aload 23
    //   210: aload 25
    //   212: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   215: aload_2
    //   216: invokevirtual 202	java/io/File:exists	()Z
    //   219: ifeq +8 -> 227
    //   222: aload_2
    //   223: invokevirtual 309	java/io/File:delete	()Z
    //   226: pop
    //   227: aconst_null
    //   228: astore 19
    //   230: iconst_m1
    //   231: istore 10
    //   233: aload_0
    //   234: astore_3
    //   235: aload 19
    //   237: astore_0
    //   238: iload 10
    //   240: ifne +36 -> 276
    //   243: aload 25
    //   245: ldc_w 289
    //   248: new 291	org/apache/http/HttpHost
    //   251: dup
    //   252: aload_1
    //   253: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   256: aload_1
    //   257: invokevirtual 315	java/net/URL:getPort	()I
    //   260: invokespecial 293	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   263: invokeinterface 260 3 0
    //   268: pop
    //   269: aload 23
    //   271: aload 25
    //   273: invokevirtual 303	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   276: iconst_5
    //   277: istore 4
    //   279: aload_0
    //   280: astore 20
    //   282: aload_0
    //   283: astore 21
    //   285: aload_0
    //   286: astore 22
    //   288: aload_0
    //   289: astore 19
    //   291: getstatic 127	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   294: new 291	org/apache/http/HttpHost
    //   297: dup
    //   298: aload_1
    //   299: invokevirtual 312	java/net/URL:getHost	()Ljava/lang/String;
    //   302: invokespecial 316	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   305: aload 23
    //   307: invokevirtual 320	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   310: astore 26
    //   312: aload_0
    //   313: astore 20
    //   315: aload_0
    //   316: astore 21
    //   318: aload_0
    //   319: astore 22
    //   321: aload_0
    //   322: astore 19
    //   324: aload 26
    //   326: invokeinterface 326 1 0
    //   331: invokeinterface 335 1 0
    //   336: istore 5
    //   338: aload_0
    //   339: astore 20
    //   341: aload_0
    //   342: astore 21
    //   344: aload_0
    //   345: astore 22
    //   347: aload_0
    //   348: astore 19
    //   350: aload 26
    //   352: invokeinterface 341 1 0
    //   357: astore_0
    //   358: sipush 200
    //   361: iload 5
    //   363: if_icmpne +618 -> 981
    //   366: aload_0
    //   367: astore 20
    //   369: aload_0
    //   370: astore 21
    //   372: aload_0
    //   373: astore 22
    //   375: aload_0
    //   376: astore 19
    //   378: aload_0
    //   379: invokeinterface 346 1 0
    //   384: lstore 17
    //   386: lconst_0
    //   387: lstore 13
    //   389: aload_0
    //   390: astore 20
    //   392: aload_0
    //   393: astore 21
    //   395: aload_0
    //   396: astore 22
    //   398: new 348	java/io/FileOutputStream
    //   401: dup
    //   402: aload_2
    //   403: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   406: astore 19
    //   408: lload 13
    //   410: lstore 11
    //   412: aload 19
    //   414: astore 20
    //   416: aload 19
    //   418: astore 21
    //   420: aload 19
    //   422: astore 22
    //   424: aload_0
    //   425: aload 19
    //   427: invokeinterface 624 2 0
    //   432: lload 13
    //   434: lstore 11
    //   436: aload 19
    //   438: astore 20
    //   440: aload 19
    //   442: astore 21
    //   444: aload 19
    //   446: astore 22
    //   448: aload_2
    //   449: invokevirtual 627	java/io/File:length	()J
    //   452: lstore 13
    //   454: lload 13
    //   456: lstore 11
    //   458: aload 19
    //   460: astore 20
    //   462: aload 19
    //   464: astore 21
    //   466: aload 19
    //   468: astore 22
    //   470: aload_2
    //   471: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   474: invokevirtual 402	java/io/File:setLastModified	(J)Z
    //   477: pop
    //   478: lload 13
    //   480: lstore 11
    //   482: aload 19
    //   484: astore 20
    //   486: aload 19
    //   488: astore 21
    //   490: aload 19
    //   492: astore 22
    //   494: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +71 -> 568
    //   500: lload 13
    //   502: lstore 11
    //   504: aload 19
    //   506: astore 20
    //   508: aload 19
    //   510: astore 21
    //   512: aload 19
    //   514: astore 22
    //   516: ldc 15
    //   518: iconst_2
    //   519: new 221	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 404
    //   529: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   535: lload 15
    //   537: lsub
    //   538: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: ldc_w 629
    //   544: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: lload 13
    //   549: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: ldc_w 408
    //   555: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_1
    //   559: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 410	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: iconst_0
    //   569: istore 4
    //   571: aload 19
    //   573: astore_3
    //   574: lload 13
    //   576: lstore 11
    //   578: iload 4
    //   580: istore 5
    //   582: lload 17
    //   584: lconst_0
    //   585: lcmp
    //   586: ifle +159 -> 745
    //   589: iload 4
    //   591: istore 5
    //   593: lload 11
    //   595: lload 17
    //   597: lcmp
    //   598: ifge +147 -> 745
    //   601: iload 4
    //   603: istore 6
    //   605: iload 4
    //   607: istore 7
    //   609: iload 4
    //   611: istore 8
    //   613: iload 4
    //   615: istore 9
    //   617: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   620: ifeq +69 -> 689
    //   623: iload 4
    //   625: istore 6
    //   627: iload 4
    //   629: istore 7
    //   631: iload 4
    //   633: istore 8
    //   635: iload 4
    //   637: istore 9
    //   639: ldc 15
    //   641: iconst_2
    //   642: new 221	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 631
    //   652: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: lload 17
    //   657: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   660: ldc_w 633
    //   663: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_2
    //   667: invokevirtual 627	java/io/File:length	()J
    //   670: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   673: ldc_w 428
    //   676: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_1
    //   680: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: bipush 8
    //   691: istore 4
    //   693: iload 4
    //   695: istore 5
    //   697: iload 4
    //   699: istore 6
    //   701: iload 4
    //   703: istore 7
    //   705: iload 4
    //   707: istore 8
    //   709: iload 4
    //   711: istore 9
    //   713: aload_2
    //   714: invokevirtual 202	java/io/File:exists	()Z
    //   717: ifeq +28 -> 745
    //   720: iload 4
    //   722: istore 6
    //   724: iload 4
    //   726: istore 7
    //   728: iload 4
    //   730: istore 8
    //   732: iload 4
    //   734: istore 9
    //   736: aload_2
    //   737: invokevirtual 309	java/io/File:delete	()Z
    //   740: pop
    //   741: iload 4
    //   743: istore 5
    //   745: iload 5
    //   747: istore 4
    //   749: aload_0
    //   750: ifnull +9 -> 759
    //   753: aload_0
    //   754: invokeinterface 420 1 0
    //   759: aload_3
    //   760: ifnull +7 -> 767
    //   763: aload_3
    //   764: invokevirtual 421	java/io/OutputStream:close	()V
    //   767: iload 4
    //   769: ifeq +923 -> 1692
    //   772: aload_2
    //   773: ifnull +15 -> 788
    //   776: aload_2
    //   777: invokevirtual 202	java/io/File:exists	()Z
    //   780: ifeq +8 -> 788
    //   783: aload_2
    //   784: invokevirtual 309	java/io/File:delete	()Z
    //   787: pop
    //   788: iload 10
    //   790: iconst_1
    //   791: iadd
    //   792: istore 10
    //   794: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq +40 -> 837
    //   800: ldc 15
    //   802: iconst_2
    //   803: new 221	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   810: ldc_w 423
    //   813: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: iload 4
    //   818: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   821: ldc_w 428
    //   824: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload_1
    //   828: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: iload 4
    //   839: ifeq +23 -> 862
    //   842: iload 10
    //   844: iconst_2
    //   845: if_icmpge +17 -> 862
    //   848: aload 24
    //   850: monitorenter
    //   851: aload 24
    //   853: ldc2_w 634
    //   856: invokevirtual 434	java/lang/Object:wait	(J)V
    //   859: aload 24
    //   861: monitorexit
    //   862: iload 4
    //   864: ifeq +9 -> 873
    //   867: iload 10
    //   869: iconst_2
    //   870: if_icmplt +819 -> 1689
    //   873: iload 4
    //   875: ireturn
    //   876: astore_0
    //   877: iconst_4
    //   878: ireturn
    //   879: astore 20
    //   881: new 245	org/apache/http/client/methods/HttpGet
    //   884: dup
    //   885: aload 19
    //   887: invokestatic 373	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   890: invokespecial 246	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   893: astore 23
    //   895: goto -841 -> 54
    //   898: astore_0
    //   899: bipush 13
    //   901: ireturn
    //   902: sipush 10000
    //   905: istore 5
    //   907: sipush 30000
    //   910: istore 4
    //   912: aload 25
    //   914: ldc_w 295
    //   917: sipush 4096
    //   920: invokeinterface 299 3 0
    //   925: pop
    //   926: goto -749 -> 177
    //   929: astore 20
    //   931: aload 19
    //   933: astore_3
    //   934: aload 20
    //   936: astore 19
    //   938: aload_3
    //   939: astore 20
    //   941: aload_3
    //   942: astore 21
    //   944: aload_3
    //   945: astore 22
    //   947: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   950: ifeq +25 -> 975
    //   953: aload_3
    //   954: astore 20
    //   956: aload_3
    //   957: astore 21
    //   959: aload_3
    //   960: astore 22
    //   962: ldc 15
    //   964: iconst_2
    //   965: aload 19
    //   967: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   970: aload 19
    //   972: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   975: iconst_4
    //   976: istore 4
    //   978: goto -400 -> 578
    //   981: iload 5
    //   983: istore 4
    //   985: goto -236 -> 749
    //   988: astore 19
    //   990: aload 19
    //   992: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   995: goto -236 -> 759
    //   998: astore 19
    //   1000: goto -212 -> 788
    //   1003: astore 20
    //   1005: iconst_5
    //   1006: istore 4
    //   1008: aload_0
    //   1009: astore 19
    //   1011: aload 20
    //   1013: astore_0
    //   1014: aload_3
    //   1015: astore 20
    //   1017: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq +30 -> 1050
    //   1023: ldc 15
    //   1025: iconst_2
    //   1026: new 221	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1033: ldc_w 637
    //   1036: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_1
    //   1040: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: aload_0
    //   1047: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1050: iconst_1
    //   1051: istore 5
    //   1053: aload 19
    //   1055: ifnull +10 -> 1065
    //   1058: aload 19
    //   1060: invokeinterface 420 1 0
    //   1065: aload 20
    //   1067: ifnull +8 -> 1075
    //   1070: aload 20
    //   1072: invokevirtual 421	java/io/OutputStream:close	()V
    //   1075: aload 19
    //   1077: astore_0
    //   1078: aload 20
    //   1080: astore_3
    //   1081: iload 5
    //   1083: istore 4
    //   1085: aload_2
    //   1086: ifnull -298 -> 788
    //   1089: aload 19
    //   1091: astore_0
    //   1092: aload 20
    //   1094: astore_3
    //   1095: iload 5
    //   1097: istore 4
    //   1099: aload_2
    //   1100: invokevirtual 202	java/io/File:exists	()Z
    //   1103: ifeq -315 -> 788
    //   1106: aload_2
    //   1107: invokevirtual 309	java/io/File:delete	()Z
    //   1110: pop
    //   1111: aload 19
    //   1113: astore_0
    //   1114: aload 20
    //   1116: astore_3
    //   1117: iload 5
    //   1119: istore 4
    //   1121: goto -333 -> 788
    //   1124: astore_0
    //   1125: aload 19
    //   1127: astore_0
    //   1128: aload 20
    //   1130: astore_3
    //   1131: iload 5
    //   1133: istore 4
    //   1135: goto -347 -> 788
    //   1138: astore_0
    //   1139: aload_0
    //   1140: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   1143: goto -78 -> 1065
    //   1146: astore 21
    //   1148: iload 4
    //   1150: istore 5
    //   1152: aload_0
    //   1153: astore 19
    //   1155: aload 19
    //   1157: astore_0
    //   1158: aload 20
    //   1160: astore_3
    //   1161: iload 5
    //   1163: istore 4
    //   1165: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +41 -> 1209
    //   1171: aload 19
    //   1173: astore_0
    //   1174: aload 20
    //   1176: astore_3
    //   1177: iload 5
    //   1179: istore 4
    //   1181: ldc 15
    //   1183: iconst_2
    //   1184: new 221	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1191: ldc_w 522
    //   1194: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload_1
    //   1198: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: aload 21
    //   1206: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1209: iconst_5
    //   1210: istore 5
    //   1212: aload 19
    //   1214: ifnull +10 -> 1224
    //   1217: aload 19
    //   1219: invokeinterface 420 1 0
    //   1224: aload 20
    //   1226: ifnull +8 -> 1234
    //   1229: aload 20
    //   1231: invokevirtual 421	java/io/OutputStream:close	()V
    //   1234: aload 19
    //   1236: astore_0
    //   1237: aload 20
    //   1239: astore_3
    //   1240: iload 5
    //   1242: istore 4
    //   1244: aload_2
    //   1245: ifnull -457 -> 788
    //   1248: aload 19
    //   1250: astore_0
    //   1251: aload 20
    //   1253: astore_3
    //   1254: iload 5
    //   1256: istore 4
    //   1258: aload_2
    //   1259: invokevirtual 202	java/io/File:exists	()Z
    //   1262: ifeq -474 -> 788
    //   1265: aload_2
    //   1266: invokevirtual 309	java/io/File:delete	()Z
    //   1269: pop
    //   1270: aload 19
    //   1272: astore_0
    //   1273: aload 20
    //   1275: astore_3
    //   1276: iload 5
    //   1278: istore 4
    //   1280: goto -492 -> 788
    //   1283: astore_0
    //   1284: aload 19
    //   1286: astore_0
    //   1287: aload 20
    //   1289: astore_3
    //   1290: iload 5
    //   1292: istore 4
    //   1294: goto -506 -> 788
    //   1297: astore_0
    //   1298: aload_0
    //   1299: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   1302: goto -78 -> 1224
    //   1305: astore_3
    //   1306: aload 21
    //   1308: astore 20
    //   1310: iload 4
    //   1312: istore 5
    //   1314: aload_3
    //   1315: astore 21
    //   1317: aload_0
    //   1318: astore 19
    //   1320: aload 19
    //   1322: astore_0
    //   1323: aload 20
    //   1325: astore_3
    //   1326: iload 5
    //   1328: istore 4
    //   1330: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1333: ifeq +41 -> 1374
    //   1336: aload 19
    //   1338: astore_0
    //   1339: aload 20
    //   1341: astore_3
    //   1342: iload 5
    //   1344: istore 4
    //   1346: ldc 15
    //   1348: iconst_2
    //   1349: new 221	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1356: ldc_w 522
    //   1359: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: aload_1
    //   1363: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: aload 21
    //   1371: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1374: iconst_5
    //   1375: istore 5
    //   1377: aload 19
    //   1379: ifnull +10 -> 1389
    //   1382: aload 19
    //   1384: invokeinterface 420 1 0
    //   1389: aload 20
    //   1391: ifnull +8 -> 1399
    //   1394: aload 20
    //   1396: invokevirtual 421	java/io/OutputStream:close	()V
    //   1399: aload 19
    //   1401: astore_0
    //   1402: aload 20
    //   1404: astore_3
    //   1405: iload 5
    //   1407: istore 4
    //   1409: aload_2
    //   1410: ifnull -622 -> 788
    //   1413: aload 19
    //   1415: astore_0
    //   1416: aload 20
    //   1418: astore_3
    //   1419: iload 5
    //   1421: istore 4
    //   1423: aload_2
    //   1424: invokevirtual 202	java/io/File:exists	()Z
    //   1427: ifeq -639 -> 788
    //   1430: aload_2
    //   1431: invokevirtual 309	java/io/File:delete	()Z
    //   1434: pop
    //   1435: aload 19
    //   1437: astore_0
    //   1438: aload 20
    //   1440: astore_3
    //   1441: iload 5
    //   1443: istore 4
    //   1445: goto -657 -> 788
    //   1448: astore_0
    //   1449: aload 19
    //   1451: astore_0
    //   1452: aload 20
    //   1454: astore_3
    //   1455: iload 5
    //   1457: istore 4
    //   1459: goto -671 -> 788
    //   1462: astore_0
    //   1463: aload_0
    //   1464: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   1467: goto -78 -> 1389
    //   1470: astore_1
    //   1471: aload 22
    //   1473: astore_3
    //   1474: aload_0
    //   1475: ifnull +9 -> 1484
    //   1478: aload_0
    //   1479: invokeinterface 420 1 0
    //   1484: aload_3
    //   1485: ifnull +7 -> 1492
    //   1488: aload_3
    //   1489: invokevirtual 421	java/io/OutputStream:close	()V
    //   1492: iload 4
    //   1494: ifeq +19 -> 1513
    //   1497: aload_2
    //   1498: ifnull +15 -> 1513
    //   1501: aload_2
    //   1502: invokevirtual 202	java/io/File:exists	()Z
    //   1505: ifeq +8 -> 1513
    //   1508: aload_2
    //   1509: invokevirtual 309	java/io/File:delete	()Z
    //   1512: pop
    //   1513: aload_1
    //   1514: athrow
    //   1515: astore_0
    //   1516: aload_0
    //   1517: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   1520: goto -36 -> 1484
    //   1523: astore_0
    //   1524: aload 24
    //   1526: monitorexit
    //   1527: aload_0
    //   1528: athrow
    //   1529: astore 19
    //   1531: goto -764 -> 767
    //   1534: astore_0
    //   1535: goto -460 -> 1075
    //   1538: astore_0
    //   1539: goto -305 -> 1234
    //   1542: astore_0
    //   1543: goto -144 -> 1399
    //   1546: astore_0
    //   1547: goto -55 -> 1492
    //   1550: astore 19
    //   1552: goto -693 -> 859
    //   1555: astore_0
    //   1556: goto -43 -> 1513
    //   1559: astore_1
    //   1560: iload 6
    //   1562: istore 4
    //   1564: goto -90 -> 1474
    //   1567: astore_1
    //   1568: aload 20
    //   1570: astore_3
    //   1571: aload 19
    //   1573: astore_0
    //   1574: goto -100 -> 1474
    //   1577: astore_1
    //   1578: goto -104 -> 1474
    //   1581: astore_1
    //   1582: aload 20
    //   1584: astore_0
    //   1585: goto -111 -> 1474
    //   1588: astore 21
    //   1590: iload 7
    //   1592: istore 5
    //   1594: aload_0
    //   1595: astore 19
    //   1597: aload_3
    //   1598: astore 20
    //   1600: goto -280 -> 1320
    //   1603: astore_0
    //   1604: aload 21
    //   1606: astore 19
    //   1608: aload_3
    //   1609: astore 20
    //   1611: aload_0
    //   1612: astore 21
    //   1614: iload 4
    //   1616: istore 5
    //   1618: goto -298 -> 1320
    //   1621: astore 21
    //   1623: iload 8
    //   1625: istore 5
    //   1627: aload_0
    //   1628: astore 19
    //   1630: aload_3
    //   1631: astore 20
    //   1633: goto -478 -> 1155
    //   1636: astore 21
    //   1638: aload 22
    //   1640: astore 19
    //   1642: aload_3
    //   1643: astore 20
    //   1645: iload 4
    //   1647: istore 5
    //   1649: goto -494 -> 1155
    //   1652: astore 21
    //   1654: iload 9
    //   1656: istore 4
    //   1658: aload_0
    //   1659: astore 19
    //   1661: aload_3
    //   1662: astore 20
    //   1664: aload 21
    //   1666: astore_0
    //   1667: goto -650 -> 1017
    //   1670: astore_0
    //   1671: iconst_5
    //   1672: istore 4
    //   1674: aload_3
    //   1675: astore 20
    //   1677: goto -660 -> 1017
    //   1680: astore 19
    //   1682: lload 13
    //   1684: lstore 11
    //   1686: goto -748 -> 938
    //   1689: goto -1451 -> 238
    //   1692: goto -904 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1695	0	paramAppInterface	AppInterface
    //   0	1695	1	paramURL	URL
    //   0	1695	2	paramFile	File
    //   0	1695	3	paramNetworkInfo	NetworkInfo
    //   70	1603	4	i1	int
    //   66	1582	5	i2	int
    //   603	958	6	i3	int
    //   607	984	7	i4	int
    //   611	1013	8	i5	int
    //   615	1040	9	i6	int
    //   231	640	10	i7	int
    //   410	1275	11	l1	long
    //   387	1296	13	l2	long
    //   3	533	15	l3	long
    //   384	272	17	l4	long
    //   41	930	19	localObject1	Object
    //   988	3	19	localIOException1	java.io.IOException
    //   998	1	19	localException1	java.lang.Exception
    //   1009	441	19	localAppInterface1	AppInterface
    //   1529	1	19	localIOException2	java.io.IOException
    //   1550	22	19	localInterruptedException	java.lang.InterruptedException
    //   1595	65	19	localObject2	Object
    //   1680	1	19	localIOException3	java.io.IOException
    //   90	417	20	localObject3	Object
    //   879	1	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   929	6	20	localIOException4	java.io.IOException
    //   939	16	20	localNetworkInfo1	NetworkInfo
    //   1003	9	20	localIOException5	java.io.IOException
    //   1015	661	20	localObject4	Object
    //   283	675	21	localObject5	Object
    //   1146	161	21	localException2	java.lang.Exception
    //   1315	55	21	localNetworkInfo2	NetworkInfo
    //   1588	17	21	localThrowable	java.lang.Throwable
    //   1612	1	21	localAppInterface2	AppInterface
    //   1621	1	21	localException3	java.lang.Exception
    //   1636	1	21	localException4	java.lang.Exception
    //   1652	13	21	localIOException6	java.io.IOException
    //   286	1353	22	localObject6	Object
    //   52	842	23	localHttpGet	org.apache.http.client.methods.HttpGet
    //   12	1513	24	localObject7	Object
    //   61	852	25	localBasicHttpParams	BasicHttpParams
    //   310	41	26	localHttpResponse	org.apache.http.HttpResponse
    // Exception table:
    //   from	to	target	type
    //   14	19	876	java/lang/Exception
    //   23	35	876	java/lang/Exception
    //   43	54	879	java/lang/IllegalArgumentException
    //   881	895	898	java/lang/IllegalArgumentException
    //   424	432	929	java/io/IOException
    //   448	454	929	java/io/IOException
    //   470	478	929	java/io/IOException
    //   494	500	929	java/io/IOException
    //   516	568	929	java/io/IOException
    //   753	759	988	java/io/IOException
    //   776	788	998	java/lang/Exception
    //   947	953	1003	java/io/IOException
    //   962	975	1003	java/io/IOException
    //   1099	1111	1124	java/lang/Exception
    //   1058	1065	1138	java/io/IOException
    //   424	432	1146	java/lang/Exception
    //   448	454	1146	java/lang/Exception
    //   470	478	1146	java/lang/Exception
    //   494	500	1146	java/lang/Exception
    //   516	568	1146	java/lang/Exception
    //   947	953	1146	java/lang/Exception
    //   962	975	1146	java/lang/Exception
    //   1258	1270	1283	java/lang/Exception
    //   1217	1224	1297	java/io/IOException
    //   424	432	1305	java/lang/Throwable
    //   448	454	1305	java/lang/Throwable
    //   470	478	1305	java/lang/Throwable
    //   494	500	1305	java/lang/Throwable
    //   516	568	1305	java/lang/Throwable
    //   947	953	1305	java/lang/Throwable
    //   962	975	1305	java/lang/Throwable
    //   1423	1435	1448	java/lang/Exception
    //   1382	1389	1462	java/io/IOException
    //   424	432	1470	finally
    //   448	454	1470	finally
    //   470	478	1470	finally
    //   494	500	1470	finally
    //   516	568	1470	finally
    //   947	953	1470	finally
    //   962	975	1470	finally
    //   1478	1484	1515	java/io/IOException
    //   851	859	1523	finally
    //   859	862	1523	finally
    //   1524	1527	1523	finally
    //   763	767	1529	java/io/IOException
    //   1070	1075	1534	java/io/IOException
    //   1229	1234	1538	java/io/IOException
    //   1394	1399	1542	java/io/IOException
    //   1488	1492	1546	java/io/IOException
    //   851	859	1550	java/lang/InterruptedException
    //   1501	1513	1555	java/lang/Exception
    //   617	623	1559	finally
    //   639	689	1559	finally
    //   713	720	1559	finally
    //   736	741	1559	finally
    //   1017	1050	1567	finally
    //   1165	1171	1577	finally
    //   1181	1209	1577	finally
    //   1330	1336	1577	finally
    //   1346	1374	1577	finally
    //   291	312	1581	finally
    //   324	338	1581	finally
    //   350	358	1581	finally
    //   378	386	1581	finally
    //   398	408	1581	finally
    //   617	623	1588	java/lang/Throwable
    //   639	689	1588	java/lang/Throwable
    //   713	720	1588	java/lang/Throwable
    //   736	741	1588	java/lang/Throwable
    //   291	312	1603	java/lang/Throwable
    //   324	338	1603	java/lang/Throwable
    //   350	358	1603	java/lang/Throwable
    //   378	386	1603	java/lang/Throwable
    //   398	408	1603	java/lang/Throwable
    //   617	623	1621	java/lang/Exception
    //   639	689	1621	java/lang/Exception
    //   713	720	1621	java/lang/Exception
    //   736	741	1621	java/lang/Exception
    //   291	312	1636	java/lang/Exception
    //   324	338	1636	java/lang/Exception
    //   350	358	1636	java/lang/Exception
    //   378	386	1636	java/lang/Exception
    //   398	408	1636	java/lang/Exception
    //   617	623	1652	java/io/IOException
    //   639	689	1652	java/io/IOException
    //   713	720	1652	java/io/IOException
    //   736	741	1652	java/io/IOException
    //   291	312	1670	java/io/IOException
    //   324	338	1670	java/io/IOException
    //   350	358	1670	java/io/IOException
    //   378	386	1670	java/io/IOException
    //   398	408	1680	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  /* Error */
  public static void a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener, com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler paramProgressHandler)
  {
    // Byte code:
    //   0: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_1
    //   6: iconst_5
    //   7: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   10: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +42 -> 55
    //   16: new 221	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 656
    //   26: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: astore 13
    //   31: aload_1
    //   32: ifnonnull +145 -> 177
    //   35: iconst_1
    //   36: istore 9
    //   38: ldc_w 658
    //   41: iconst_2
    //   42: aload 13
    //   44: iload 9
    //   46: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   59: iconst_1
    //   60: if_icmpeq +213 -> 273
    //   63: aload_1
    //   64: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   67: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   70: astore 13
    //   72: aload 13
    //   74: ifnull +199 -> 273
    //   77: aload 13
    //   79: invokevirtual 202	java/io/File:exists	()Z
    //   82: ifne +191 -> 273
    //   85: aload 13
    //   87: invokevirtual 205	java/io/File:mkdirs	()Z
    //   90: istore 9
    //   92: aload 13
    //   94: invokevirtual 664	java/io/File:isDirectory	()Z
    //   97: ifne +176 -> 273
    //   100: aload_1
    //   101: bipush 12
    //   103: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   106: aload_2
    //   107: ifnull +15 -> 122
    //   110: aload_2
    //   111: aload_1
    //   112: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   115: bipush 12
    //   117: invokeinterface 214 3 0
    //   122: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +45 -> 170
    //   128: ldc_w 658
    //   131: iconst_4
    //   132: new 221	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 666
    //   142: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload 9
    //   147: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   150: ldc_w 668
    //   153: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 13
    //   158: invokevirtual 671	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 13
    //   172: iconst_0
    //   173: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   176: return
    //   177: iconst_0
    //   178: istore 9
    //   180: goto -142 -> 38
    //   183: astore_0
    //   184: aload_1
    //   185: aload_0
    //   186: invokevirtual 678	java/lang/Exception:toString	()Ljava/lang/String;
    //   189: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   192: aload_1
    //   193: bipush 12
    //   195: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   198: aload_2
    //   199: ifnull +15 -> 214
    //   202: aload_2
    //   203: aload_1
    //   204: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   207: bipush 12
    //   209: invokeinterface 214 3 0
    //   214: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +33 -> 250
    //   220: ldc_w 658
    //   223: iconst_4
    //   224: new 221	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 680
    //   234: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: getfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   241: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_1
    //   251: ifnull -75 -> 176
    //   254: aload_1
    //   255: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   258: ifnull -82 -> 176
    //   261: aload_1
    //   262: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   265: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   268: iconst_0
    //   269: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   272: return
    //   273: new 4	java/lang/Object
    //   276: dup
    //   277: invokespecial 170	java/lang/Object:<init>	()V
    //   280: astore 23
    //   282: iconst_0
    //   283: istore 5
    //   285: aconst_null
    //   286: astore 14
    //   288: aconst_null
    //   289: astore 13
    //   291: aconst_null
    //   292: astore 15
    //   294: iconst_0
    //   295: istore 10
    //   297: aload_1
    //   298: iconst_5
    //   299: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   302: aload_1
    //   303: invokevirtual 682	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   306: aload_1
    //   307: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   310: iconst_1
    //   311: if_icmpeq +4066 -> 4377
    //   314: aload_1
    //   315: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   318: ifnull +4059 -> 4377
    //   321: new 194	java/io/File
    //   324: dup
    //   325: aload_1
    //   326: invokevirtual 305	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   329: invokespecial 306	java/io/File:<init>	(Ljava/lang/String;)V
    //   332: astore 16
    //   334: aload 16
    //   336: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   339: astore 17
    //   341: aload 17
    //   343: invokevirtual 202	java/io/File:exists	()Z
    //   346: ifne +9 -> 355
    //   349: aload 17
    //   351: invokevirtual 205	java/io/File:mkdirs	()Z
    //   354: pop
    //   355: aload 16
    //   357: invokevirtual 202	java/io/File:exists	()Z
    //   360: ifeq +9 -> 369
    //   363: aload 16
    //   365: invokevirtual 309	java/io/File:delete	()Z
    //   368: pop
    //   369: aload 16
    //   371: invokevirtual 685	java/io/File:createNewFile	()Z
    //   374: pop
    //   375: getstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   378: ifne +18 -> 396
    //   381: aload_3
    //   382: ifnull +14 -> 396
    //   385: aload_3
    //   386: invokevirtual 689	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	()Z
    //   389: ifne +7 -> 396
    //   392: aload_1
    //   393: invokestatic 690	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   396: aload_1
    //   397: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   400: astore 22
    //   402: getstatic 162	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   405: invokevirtual 477	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   408: astore 21
    //   410: aload 21
    //   412: ifnonnull +75 -> 487
    //   415: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +13 -> 431
    //   421: ldc_w 658
    //   424: iconst_2
    //   425: ldc_w 692
    //   428: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: bipush 9
    //   434: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   437: aload 14
    //   439: ifnull +8 -> 447
    //   442: aload 14
    //   444: invokevirtual 421	java/io/OutputStream:close	()V
    //   447: aload 13
    //   449: ifnull +8 -> 457
    //   452: aload 13
    //   454: invokevirtual 413	java/io/InputStream:close	()V
    //   457: aload 15
    //   459: ifnull +8 -> 467
    //   462: aload 15
    //   464: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   467: aload 16
    //   469: ifnull -293 -> 176
    //   472: aload 16
    //   474: invokevirtual 309	java/io/File:delete	()Z
    //   477: pop
    //   478: return
    //   479: astore_0
    //   480: aload_0
    //   481: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   484: goto -17 -> 467
    //   487: aconst_null
    //   488: astore 17
    //   490: aload 21
    //   492: ifnull +10 -> 502
    //   495: aload 21
    //   497: invokevirtual 276	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   500: astore 17
    //   502: aload 17
    //   504: invokestatic 543	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   507: astore 19
    //   509: aload 19
    //   511: getstatic 164	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifne +12 -> 529
    //   520: iconst_0
    //   521: putstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   524: aload 19
    //   526: putstatic 164	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   529: invokestatic 267	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   532: astore 20
    //   534: invokestatic 271	android/net/Proxy:getDefaultPort	()I
    //   537: istore 4
    //   539: aload 21
    //   541: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   544: ifeq +1154 -> 1698
    //   547: aload 20
    //   549: ifnull +1149 -> 1698
    //   552: iload 4
    //   554: ifle +1144 -> 1698
    //   557: getstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   560: ifne +1138 -> 1698
    //   563: aload 17
    //   565: ifnull +1115 -> 1680
    //   568: aload 19
    //   570: getstatic 549	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   573: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   576: ifne +25 -> 601
    //   579: aload 19
    //   581: getstatic 551	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   584: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: ifne +14 -> 601
    //   590: aload 19
    //   592: getstatic 553	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   595: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +1035 -> 1633
    //   601: aload 22
    //   603: aload 20
    //   605: iload 4
    //   607: invokestatic 556	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   610: astore 17
    //   612: aload 17
    //   614: astore 15
    //   616: iconst_1
    //   617: istore 9
    //   619: aload 13
    //   621: astore 18
    //   623: aload 14
    //   625: astore 17
    //   627: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +107 -> 737
    //   633: aload 13
    //   635: astore 18
    //   637: aload 14
    //   639: astore 17
    //   641: ldc_w 658
    //   644: iconst_2
    //   645: new 221	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 694
    //   655: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: getstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   661: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   664: ldc_w 696
    //   667: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: getstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   673: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   676: ldc_w 698
    //   679: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: iload 9
    //   684: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: ldc_w 700
    //   690: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload 19
    //   695: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 702
    //   701: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 20
    //   706: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 704
    //   712: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: iload 4
    //   717: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: ldc_w 706
    //   723: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload 22
    //   728: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: aload 13
    //   739: astore 18
    //   741: aload 14
    //   743: astore 17
    //   745: aload_1
    //   746: getfield 707	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   749: ifeq +38 -> 787
    //   752: aload 13
    //   754: astore 18
    //   756: aload 14
    //   758: astore 17
    //   760: aload_1
    //   761: getfield 708	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   764: ifnull +23 -> 787
    //   767: aload 13
    //   769: astore 18
    //   771: aload 14
    //   773: astore 17
    //   775: aload 15
    //   777: ldc_w 710
    //   780: aload_1
    //   781: getfield 708	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   784: invokevirtual 713	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload 13
    //   789: astore 18
    //   791: aload 14
    //   793: astore 17
    //   795: aload 15
    //   797: ldc_w 558
    //   800: ldc_w 560
    //   803: invokevirtual 565	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload 13
    //   808: astore 18
    //   810: aload 14
    //   812: astore 17
    //   814: aload 15
    //   816: sipush 30000
    //   819: invokevirtual 569	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   822: aload 13
    //   824: astore 18
    //   826: aload 14
    //   828: astore 17
    //   830: aload 15
    //   832: sipush 30000
    //   835: invokevirtual 572	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   838: aload 13
    //   840: astore 18
    //   842: aload 14
    //   844: astore 17
    //   846: aload_1
    //   847: getfield 714	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   850: ifeq +111 -> 961
    //   853: aload 13
    //   855: astore 18
    //   857: aload 14
    //   859: astore 17
    //   861: aload_0
    //   862: invokevirtual 718	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   865: aload 22
    //   867: ldc_w 720
    //   870: invokeinterface 725 3 0
    //   875: astore 19
    //   877: aload 13
    //   879: astore 18
    //   881: aload 14
    //   883: astore 17
    //   885: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq +39 -> 927
    //   891: aload 13
    //   893: astore 18
    //   895: aload 14
    //   897: astore 17
    //   899: ldc_w 658
    //   902: iconst_2
    //   903: new 221	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   910: ldc_w 727
    //   913: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload 19
    //   918: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload 13
    //   929: astore 18
    //   931: aload 14
    //   933: astore 17
    //   935: aload 15
    //   937: ldc_w 729
    //   940: invokevirtual 732	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   943: aload 13
    //   945: astore 18
    //   947: aload 14
    //   949: astore 17
    //   951: aload 15
    //   953: ldc_w 734
    //   956: aload 19
    //   958: invokevirtual 713	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: aload 13
    //   963: astore 18
    //   965: aload 14
    //   967: astore 17
    //   969: aload 15
    //   971: iconst_1
    //   972: invokevirtual 576	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   975: aload 13
    //   977: astore 18
    //   979: aload 14
    //   981: astore 17
    //   983: aload_1
    //   984: iconst_5
    //   985: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   988: aload 13
    //   990: astore 18
    //   992: aload 14
    //   994: astore 17
    //   996: aload 15
    //   998: invokevirtual 579	java/net/HttpURLConnection:connect	()V
    //   1001: aload 13
    //   1003: astore 18
    //   1005: aload 14
    //   1007: astore 17
    //   1009: aload 13
    //   1011: astore 20
    //   1013: aload 14
    //   1015: astore 19
    //   1017: aload_1
    //   1018: aload 15
    //   1020: invokevirtual 582	java/net/HttpURLConnection:getResponseCode	()I
    //   1023: putfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1026: aload 13
    //   1028: astore 18
    //   1030: aload 14
    //   1032: astore 17
    //   1034: aload 13
    //   1036: astore 20
    //   1038: aload 14
    //   1040: astore 19
    //   1042: aload_1
    //   1043: aload 15
    //   1045: invokevirtual 586	java/net/HttpURLConnection:getContentLength	()I
    //   1048: putfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   1051: aload 13
    //   1053: astore 18
    //   1055: aload 14
    //   1057: astore 17
    //   1059: aload 13
    //   1061: astore 20
    //   1063: aload 14
    //   1065: astore 19
    //   1067: aload_1
    //   1068: aload 15
    //   1070: invokevirtual 591	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1073: putfield 592	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1076: aload 13
    //   1078: astore 18
    //   1080: aload 14
    //   1082: astore 17
    //   1084: aload 13
    //   1086: astore 20
    //   1088: aload 14
    //   1090: astore 19
    //   1092: aload_1
    //   1093: aload 15
    //   1095: invokevirtual 595	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1098: putfield 597	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1101: aload 13
    //   1103: astore 18
    //   1105: aload 14
    //   1107: astore 17
    //   1109: aload 13
    //   1111: astore 20
    //   1113: aload 14
    //   1115: astore 19
    //   1117: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq +79 -> 1199
    //   1123: aload 13
    //   1125: astore 18
    //   1127: aload 14
    //   1129: astore 17
    //   1131: aload 13
    //   1133: astore 20
    //   1135: aload 14
    //   1137: astore 19
    //   1139: ldc_w 658
    //   1142: iconst_2
    //   1143: new 221	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 736
    //   1153: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: aload_1
    //   1157: getfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1160: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1163: ldc_w 438
    //   1166: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: aload_1
    //   1170: getfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   1173: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1176: ldc_w 738
    //   1179: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload 22
    //   1184: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc_w 740
    //   1190: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1199: aload_2
    //   1200: ifnull +33 -> 1233
    //   1203: aload 13
    //   1205: astore 18
    //   1207: aload 14
    //   1209: astore 17
    //   1211: aload 13
    //   1213: astore 20
    //   1215: aload 14
    //   1217: astore 19
    //   1219: aload_2
    //   1220: aload_1
    //   1221: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1224: aload_1
    //   1225: getfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1228: invokeinterface 337 3 0
    //   1233: aload 13
    //   1235: astore 18
    //   1237: aload 14
    //   1239: astore 17
    //   1241: aload 13
    //   1243: astore 20
    //   1245: aload 14
    //   1247: astore 19
    //   1249: aload_1
    //   1250: getfield 592	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1253: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1256: invokevirtual 743	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1259: astore 24
    //   1261: aload 13
    //   1263: astore 18
    //   1265: aload 14
    //   1267: astore 17
    //   1269: aload 13
    //   1271: astore 20
    //   1273: aload 14
    //   1275: astore 19
    //   1277: aload_1
    //   1278: getfield 714	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   1281: ifeq +444 -> 1725
    //   1284: aload 13
    //   1286: astore 18
    //   1288: aload 14
    //   1290: astore 17
    //   1292: aload 13
    //   1294: astore 20
    //   1296: aload 14
    //   1298: astore 19
    //   1300: sipush 304
    //   1303: aload_1
    //   1304: getfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1307: if_icmpne +418 -> 1725
    //   1310: aload 13
    //   1312: astore 18
    //   1314: aload 14
    //   1316: astore 17
    //   1318: aload 13
    //   1320: astore 20
    //   1322: aload 14
    //   1324: astore 19
    //   1326: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq +29 -> 1358
    //   1332: aload 13
    //   1334: astore 18
    //   1336: aload 14
    //   1338: astore 17
    //   1340: aload 13
    //   1342: astore 20
    //   1344: aload 14
    //   1346: astore 19
    //   1348: ldc_w 658
    //   1351: iconst_2
    //   1352: ldc_w 745
    //   1355: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1358: aload 13
    //   1360: astore 18
    //   1362: aload 14
    //   1364: astore 17
    //   1366: aload 13
    //   1368: astore 20
    //   1370: aload 14
    //   1372: astore 19
    //   1374: aload_1
    //   1375: bipush 16
    //   1377: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1380: aload 14
    //   1382: ifnull +8 -> 1390
    //   1385: aload 14
    //   1387: invokevirtual 421	java/io/OutputStream:close	()V
    //   1390: aload 13
    //   1392: ifnull +8 -> 1400
    //   1395: aload 13
    //   1397: invokevirtual 413	java/io/InputStream:close	()V
    //   1400: aload 15
    //   1402: ifnull +8 -> 1410
    //   1405: aload 15
    //   1407: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   1410: aload 16
    //   1412: ifnull +2986 -> 4398
    //   1415: aload 16
    //   1417: invokevirtual 309	java/io/File:delete	()Z
    //   1420: pop
    //   1421: aload 14
    //   1423: astore 19
    //   1425: aload 13
    //   1427: astore 18
    //   1429: aload 15
    //   1431: astore 17
    //   1433: aload_1
    //   1434: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1437: ifeq +51 -> 1488
    //   1440: aload_1
    //   1441: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1444: bipush 15
    //   1446: if_icmpne +2699 -> 4145
    //   1449: iconst_1
    //   1450: putstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   1453: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1456: ifeq +32 -> 1488
    //   1459: ldc_w 658
    //   1462: iconst_2
    //   1463: new 221	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 747
    //   1473: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: getstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   1479: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: iload 5
    //   1490: iconst_1
    //   1491: iadd
    //   1492: istore 5
    //   1494: aload_1
    //   1495: iload 5
    //   1497: iconst_2
    //   1498: invokestatic 750	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;II)Z
    //   1501: istore 9
    //   1503: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1506: ifeq +68 -> 1574
    //   1509: ldc_w 658
    //   1512: iconst_2
    //   1513: new 221	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1520: ldc_w 752
    //   1523: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload_1
    //   1527: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1530: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: ldc_w 754
    //   1536: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: iload 5
    //   1541: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1544: ldc_w 756
    //   1547: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: iload 9
    //   1552: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1555: ldc_w 428
    //   1558: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: aload_1
    //   1562: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1565: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1571: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1574: iload 9
    //   1576: ifeq +33 -> 1609
    //   1579: aload_1
    //   1580: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1583: iconst_2
    //   1584: if_icmpeq +25 -> 1609
    //   1587: aload_1
    //   1588: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1591: iconst_3
    //   1592: if_icmpeq +17 -> 1609
    //   1595: aload 23
    //   1597: monitorenter
    //   1598: aload 23
    //   1600: ldc2_w 429
    //   1603: invokevirtual 434	java/lang/Object:wait	(J)V
    //   1606: aload 23
    //   1608: monitorexit
    //   1609: iload 9
    //   1611: ifne +2772 -> 4383
    //   1614: aload_2
    //   1615: ifnull -1439 -> 176
    //   1618: aload_2
    //   1619: aload_1
    //   1620: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1623: aload_1
    //   1624: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1627: invokeinterface 214 3 0
    //   1632: return
    //   1633: aload 19
    //   1635: getstatic 605	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1638: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1641: ifeq +21 -> 1662
    //   1644: aload 22
    //   1646: aload 20
    //   1648: iload 4
    //   1650: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1653: astore 17
    //   1655: aload 17
    //   1657: astore 15
    //   1659: goto -1043 -> 616
    //   1662: aload 22
    //   1664: aload 20
    //   1666: iload 4
    //   1668: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1671: astore 17
    //   1673: aload 17
    //   1675: astore 15
    //   1677: goto -1061 -> 616
    //   1680: aload 22
    //   1682: aload 20
    //   1684: iload 4
    //   1686: invokestatic 607	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1689: astore 17
    //   1691: aload 17
    //   1693: astore 15
    //   1695: goto -1079 -> 616
    //   1698: new 183	java/net/URL
    //   1701: dup
    //   1702: aload 22
    //   1704: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1707: invokevirtual 611	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1710: checkcast 562	java/net/HttpURLConnection
    //   1713: astore 17
    //   1715: iconst_0
    //   1716: istore 9
    //   1718: aload 17
    //   1720: astore 15
    //   1722: goto -1103 -> 619
    //   1725: aload 13
    //   1727: astore 18
    //   1729: aload 14
    //   1731: astore 17
    //   1733: aload 13
    //   1735: astore 20
    //   1737: aload 14
    //   1739: astore 19
    //   1741: sipush 200
    //   1744: aload_1
    //   1745: getfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1748: if_icmpne +156 -> 1904
    //   1751: aload 13
    //   1753: astore 18
    //   1755: aload 14
    //   1757: astore 17
    //   1759: aload 13
    //   1761: astore 20
    //   1763: aload 14
    //   1765: astore 19
    //   1767: aload 24
    //   1769: ldc_w 758
    //   1772: invokevirtual 761	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1775: ifne +30 -> 1805
    //   1778: aload 13
    //   1780: astore 18
    //   1782: aload 14
    //   1784: astore 17
    //   1786: aload 13
    //   1788: astore 20
    //   1790: aload 14
    //   1792: astore 19
    //   1794: aload 24
    //   1796: ldc_w 763
    //   1799: invokevirtual 761	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1802: ifeq +102 -> 1904
    //   1805: aload 13
    //   1807: astore 18
    //   1809: aload 14
    //   1811: astore 17
    //   1813: aload 13
    //   1815: astore 20
    //   1817: aload 14
    //   1819: astore 19
    //   1821: aload_1
    //   1822: bipush 15
    //   1824: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1827: aload 13
    //   1829: astore 22
    //   1831: aload 14
    //   1833: astore 21
    //   1835: aload 13
    //   1837: astore 18
    //   1839: aload 14
    //   1841: astore 17
    //   1843: aload 13
    //   1845: astore 20
    //   1847: aload 14
    //   1849: astore 19
    //   1851: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1854: ifeq +2014 -> 3868
    //   1857: aload 13
    //   1859: astore 18
    //   1861: aload 14
    //   1863: astore 17
    //   1865: aload 13
    //   1867: astore 20
    //   1869: aload 14
    //   1871: astore 19
    //   1873: ldc_w 658
    //   1876: iconst_2
    //   1877: new 221	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1884: ldc_w 765
    //   1887: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: aload 24
    //   1892: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1901: goto -521 -> 1380
    //   1904: aload 13
    //   1906: astore 18
    //   1908: aload 14
    //   1910: astore 17
    //   1912: aload 13
    //   1914: astore 20
    //   1916: aload 14
    //   1918: astore 19
    //   1920: aload_1
    //   1921: getfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1924: istore 4
    //   1926: sipush 200
    //   1929: iload 4
    //   1931: if_icmpne +1849 -> 3780
    //   1934: aload 13
    //   1936: astore 18
    //   1938: aload 14
    //   1940: astore 17
    //   1942: aload_1
    //   1943: getfield 714	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   1946: ifeq +108 -> 2054
    //   1949: aload 13
    //   1951: astore 18
    //   1953: aload 14
    //   1955: astore 17
    //   1957: aload 15
    //   1959: ldc_w 767
    //   1962: invokevirtual 770	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1965: astore 19
    //   1967: aload 13
    //   1969: astore 18
    //   1971: aload 14
    //   1973: astore 17
    //   1975: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1978: ifeq +42 -> 2020
    //   1981: aload 13
    //   1983: astore 18
    //   1985: aload 14
    //   1987: astore 17
    //   1989: ldc_w 658
    //   1992: iconst_2
    //   1993: new 221	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2000: ldc_w 772
    //   2003: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: aload 15
    //   2008: invokevirtual 775	java/net/HttpURLConnection:getLastModified	()J
    //   2011: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2014: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2017: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2020: aload 13
    //   2022: astore 18
    //   2024: aload 14
    //   2026: astore 17
    //   2028: aload_0
    //   2029: invokevirtual 718	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   2032: invokeinterface 779 1 0
    //   2037: aload_1
    //   2038: getfield 781	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2041: aload 19
    //   2043: invokeinterface 787 3 0
    //   2048: invokeinterface 790 1 0
    //   2053: pop
    //   2054: aload 13
    //   2056: astore 18
    //   2058: aload 14
    //   2060: astore 17
    //   2062: aload_1
    //   2063: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2066: bipush 7
    //   2068: if_icmpeq +19 -> 2087
    //   2071: aload 13
    //   2073: astore 18
    //   2075: aload 14
    //   2077: astore 17
    //   2079: aload_1
    //   2080: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2083: iconst_1
    //   2084: if_icmpne +120 -> 2204
    //   2087: aload 13
    //   2089: astore 18
    //   2091: aload 14
    //   2093: astore 17
    //   2095: new 792	java/io/ByteArrayOutputStream
    //   2098: dup
    //   2099: invokespecial 793	java/io/ByteArrayOutputStream:<init>	()V
    //   2102: astore 19
    //   2104: aload 19
    //   2106: astore 14
    //   2108: aload 13
    //   2110: astore 18
    //   2112: aload 14
    //   2114: astore 19
    //   2116: aload 15
    //   2118: invokevirtual 796	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2121: astore 17
    //   2123: sipush 2048
    //   2126: newarray byte
    //   2128: astore 13
    //   2130: iconst_0
    //   2131: istore 4
    //   2133: aload 17
    //   2135: aload 13
    //   2137: invokevirtual 361	java/io/InputStream:read	([B)I
    //   2140: istore 6
    //   2142: iload 6
    //   2144: ifle +390 -> 2534
    //   2147: aload_3
    //   2148: ifnull +14 -> 2162
    //   2151: aload_3
    //   2152: ifnull +382 -> 2534
    //   2155: aload_3
    //   2156: invokevirtual 798	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()Z
    //   2159: ifeq +375 -> 2534
    //   2162: aload 14
    //   2164: aload 13
    //   2166: iconst_0
    //   2167: iload 6
    //   2169: invokevirtual 367	java/io/OutputStream:write	([BII)V
    //   2172: iload 4
    //   2174: iload 6
    //   2176: iadd
    //   2177: istore 4
    //   2179: aload_2
    //   2180: ifnull +2233 -> 4413
    //   2183: aload_2
    //   2184: aload_1
    //   2185: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2188: aload_1
    //   2189: getfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2192: i2l
    //   2193: iload 4
    //   2195: i2l
    //   2196: invokeinterface 370 6 0
    //   2201: goto -68 -> 2133
    //   2204: aload 13
    //   2206: astore 18
    //   2208: aload 14
    //   2210: astore 17
    //   2212: new 348	java/io/FileOutputStream
    //   2215: dup
    //   2216: aload 16
    //   2218: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   2221: astore 19
    //   2223: aload 19
    //   2225: astore 14
    //   2227: goto -119 -> 2108
    //   2230: astore 20
    //   2232: aload 13
    //   2234: astore 17
    //   2236: aload 17
    //   2238: astore 18
    //   2240: aload 14
    //   2242: astore 19
    //   2244: aload 20
    //   2246: invokevirtual 799	java/lang/Throwable:printStackTrace	()V
    //   2249: aload 17
    //   2251: astore 18
    //   2253: aload 14
    //   2255: astore 19
    //   2257: aload_1
    //   2258: aload 20
    //   2260: invokevirtual 800	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2263: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   2266: aload 17
    //   2268: astore 18
    //   2270: aload 14
    //   2272: astore 19
    //   2274: aload 20
    //   2276: instanceof 442
    //   2279: ifne +19 -> 2298
    //   2282: aload 17
    //   2284: astore 18
    //   2286: aload 14
    //   2288: astore 19
    //   2290: aload 20
    //   2292: instanceof 444
    //   2295: ifeq +857 -> 3152
    //   2298: aload 17
    //   2300: astore 18
    //   2302: aload 14
    //   2304: astore 19
    //   2306: aload_1
    //   2307: iconst_3
    //   2308: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2311: aload 17
    //   2313: astore 18
    //   2315: aload 14
    //   2317: astore 19
    //   2319: aload_1
    //   2320: getfield 707	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2323: ifeq +1446 -> 3769
    //   2326: aload 17
    //   2328: astore 18
    //   2330: aload 14
    //   2332: astore 19
    //   2334: invokestatic 805	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   2337: iconst_5
    //   2338: aload_1
    //   2339: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2342: invokevirtual 808	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   2345: aload 14
    //   2347: astore 13
    //   2349: aload 17
    //   2351: astore 14
    //   2353: aload 14
    //   2355: astore 22
    //   2357: aload 13
    //   2359: astore 21
    //   2361: aload 14
    //   2363: astore 18
    //   2365: aload 13
    //   2367: astore 17
    //   2369: aload 14
    //   2371: astore 20
    //   2373: aload 13
    //   2375: astore 19
    //   2377: aload_1
    //   2378: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2381: ifne +1487 -> 3868
    //   2384: aload 14
    //   2386: astore 22
    //   2388: aload 13
    //   2390: astore 21
    //   2392: aload 14
    //   2394: astore 18
    //   2396: aload 13
    //   2398: astore 17
    //   2400: aload 14
    //   2402: astore 20
    //   2404: aload 13
    //   2406: astore 19
    //   2408: aload_1
    //   2409: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2412: ifnull +1456 -> 3868
    //   2415: aload 14
    //   2417: astore 22
    //   2419: aload 13
    //   2421: astore 21
    //   2423: aload 14
    //   2425: astore 18
    //   2427: aload 13
    //   2429: astore 17
    //   2431: aload 14
    //   2433: astore 20
    //   2435: aload 13
    //   2437: astore 19
    //   2439: aload_1
    //   2440: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2443: bipush 7
    //   2445: if_icmpeq +1423 -> 3868
    //   2448: aload 14
    //   2450: astore 22
    //   2452: aload 13
    //   2454: astore 21
    //   2456: aload 14
    //   2458: astore 18
    //   2460: aload 13
    //   2462: astore 17
    //   2464: aload 14
    //   2466: astore 20
    //   2468: aload 13
    //   2470: astore 19
    //   2472: aload_1
    //   2473: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2476: iconst_1
    //   2477: if_icmpeq +1391 -> 3868
    //   2480: aload 14
    //   2482: astore 22
    //   2484: aload 13
    //   2486: astore 21
    //   2488: aload 16
    //   2490: ifnull +1378 -> 3868
    //   2493: aload 14
    //   2495: astore 18
    //   2497: aload 13
    //   2499: astore 17
    //   2501: aload 14
    //   2503: astore 20
    //   2505: aload 13
    //   2507: astore 19
    //   2509: aload 16
    //   2511: aload_1
    //   2512: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2515: invokevirtual 417	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2518: pop
    //   2519: aload 13
    //   2521: astore 17
    //   2523: aload 14
    //   2525: astore 13
    //   2527: aload 17
    //   2529: astore 14
    //   2531: goto -1151 -> 1380
    //   2534: aload_3
    //   2535: ifnull +303 -> 2838
    //   2538: aload_3
    //   2539: invokevirtual 798	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()Z
    //   2542: ifne +296 -> 2838
    //   2545: aload_1
    //   2546: bipush 6
    //   2548: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2551: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2554: ifeq +33 -> 2587
    //   2557: ldc_w 658
    //   2560: iconst_2
    //   2561: new 221	java/lang/StringBuilder
    //   2564: dup
    //   2565: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2568: ldc_w 810
    //   2571: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: aload_1
    //   2575: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2578: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2584: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2587: aload_1
    //   2588: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2591: ifne +23 -> 2614
    //   2594: aload 14
    //   2596: instanceof 792
    //   2599: ifeq +15 -> 2614
    //   2602: aload_1
    //   2603: aload 14
    //   2605: checkcast 792	java/io/ByteArrayOutputStream
    //   2608: invokevirtual 814	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2611: putfield 817	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_ArrayOfByte	[B
    //   2614: aload_1
    //   2615: ifnull +134 -> 2749
    //   2618: aload_1
    //   2619: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2622: tableswitch	default:+1794 -> 4416, 1:+316->2938, 2:+316->2938, 3:+316->2938, 4:+316->2938, 5:+74->2696, 6:+316->2938, 7:+316->2938, 8:+316->2938, 9:+74->2696, 10:+432->3054, 11:+74->2696, 12:+432->3054, 13:+432->3054, 14:+432->3054, 15:+432->3054
    //   2697: iload 184
    //   2699: aconst_null
    //   2700: aload 153
    //   2702: aconst_null
    //   2703: if_acmpeq +1725 -> 4428
    //   2706: nop
    //   2707: <illegal opcode>
    //   2708: astore 13
    //   2710: aload 13
    //   2712: iconst_0
    //   2713: ldc_w 388
    //   2716: aastore
    //   2717: aload 13
    //   2719: iconst_1
    //   2720: ldc_w 390
    //   2723: aastore
    //   2724: aload 13
    //   2726: iconst_2
    //   2727: ldc_w 392
    //   2730: aastore
    //   2731: aload 13
    //   2733: ifnull +16 -> 2749
    //   2736: aload_0
    //   2737: aload_0
    //   2738: invokevirtual 395	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   2741: aload 13
    //   2743: iload 4
    //   2745: i2l
    //   2746: invokevirtual 398	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   2749: aload_1
    //   2750: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2753: iconst_1
    //   2754: if_icmpeq +17 -> 2771
    //   2757: aload 16
    //   2759: ifnull +12 -> 2771
    //   2762: aload 16
    //   2764: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   2767: invokevirtual 402	java/io/File:setLastModified	(J)Z
    //   2770: pop
    //   2771: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2774: ifeq +1645 -> 4419
    //   2777: ldc_w 658
    //   2780: iconst_2
    //   2781: new 221	java/lang/StringBuilder
    //   2784: dup
    //   2785: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2788: ldc_w 819
    //   2791: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   2797: lload 7
    //   2799: lsub
    //   2800: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2803: ldc_w 406
    //   2806: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: aload_1
    //   2810: getfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2813: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2816: ldc_w 408
    //   2819: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2822: aload_1
    //   2823: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2826: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2829: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2832: invokestatic 410	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2835: goto +1584 -> 4419
    //   2838: aload_1
    //   2839: new 221	java/lang/StringBuilder
    //   2842: dup
    //   2843: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2846: iload 4
    //   2848: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2851: ldc_w 821
    //   2854: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2857: aload_1
    //   2858: getfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2861: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2864: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2867: putfield 823	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   2870: aload_1
    //   2871: iconst_0
    //   2872: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2875: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2878: ifeq -291 -> 2587
    //   2881: ldc_w 658
    //   2884: iconst_2
    //   2885: new 221	java/lang/StringBuilder
    //   2888: dup
    //   2889: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2892: ldc_w 825
    //   2895: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2898: iload 4
    //   2900: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2903: ldc_w 438
    //   2906: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2909: aload_1
    //   2910: getfield 588	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2913: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2916: ldc_w 440
    //   2919: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2922: aload_1
    //   2923: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2926: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2932: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2935: goto -348 -> 2587
    //   2938: aload 21
    //   2940: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   2943: ifeq +81 -> 3024
    //   2946: iconst_3
    //   2947: anewarray 237	java/lang/String
    //   2950: astore 13
    //   2952: aload 13
    //   2954: iconst_0
    //   2955: ldc_w 827
    //   2958: aastore
    //   2959: aload 13
    //   2961: iconst_1
    //   2962: ldc_w 390
    //   2965: aastore
    //   2966: aload 13
    //   2968: iconst_2
    //   2969: ldc_w 392
    //   2972: aastore
    //   2973: goto -242 -> 2731
    //   2976: astore_0
    //   2977: aload 17
    //   2979: astore 13
    //   2981: aload 14
    //   2983: ifnull +8 -> 2991
    //   2986: aload 14
    //   2988: invokevirtual 421	java/io/OutputStream:close	()V
    //   2991: aload 13
    //   2993: ifnull +8 -> 3001
    //   2996: aload 13
    //   2998: invokevirtual 413	java/io/InputStream:close	()V
    //   3001: aload 15
    //   3003: ifnull +8 -> 3011
    //   3006: aload 15
    //   3008: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   3011: aload 16
    //   3013: ifnull +9 -> 3022
    //   3016: aload 16
    //   3018: invokevirtual 309	java/io/File:delete	()Z
    //   3021: pop
    //   3022: aload_0
    //   3023: athrow
    //   3024: iconst_3
    //   3025: anewarray 237	java/lang/String
    //   3028: astore 13
    //   3030: aload 13
    //   3032: iconst_0
    //   3033: ldc_w 829
    //   3036: aastore
    //   3037: aload 13
    //   3039: iconst_1
    //   3040: ldc_w 465
    //   3043: aastore
    //   3044: aload 13
    //   3046: iconst_2
    //   3047: ldc_w 392
    //   3050: aastore
    //   3051: goto -320 -> 2731
    //   3054: aload 21
    //   3056: invokestatic 281	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   3059: ifeq +33 -> 3092
    //   3062: iconst_3
    //   3063: anewarray 237	java/lang/String
    //   3066: astore 13
    //   3068: aload 13
    //   3070: iconst_0
    //   3071: ldc_w 831
    //   3074: aastore
    //   3075: aload 13
    //   3077: iconst_1
    //   3078: ldc_w 390
    //   3081: aastore
    //   3082: aload 13
    //   3084: iconst_2
    //   3085: ldc_w 392
    //   3088: aastore
    //   3089: goto -358 -> 2731
    //   3092: iconst_3
    //   3093: anewarray 237	java/lang/String
    //   3096: astore 13
    //   3098: aload 13
    //   3100: iconst_0
    //   3101: ldc_w 833
    //   3104: aastore
    //   3105: aload 13
    //   3107: iconst_1
    //   3108: ldc_w 465
    //   3111: aastore
    //   3112: aload 13
    //   3114: iconst_2
    //   3115: ldc_w 392
    //   3118: aastore
    //   3119: goto -388 -> 2731
    //   3122: iconst_3
    //   3123: anewarray 237	java/lang/String
    //   3126: astore 13
    //   3128: aload 13
    //   3130: iconst_0
    //   3131: ldc_w 467
    //   3134: aastore
    //   3135: aload 13
    //   3137: iconst_1
    //   3138: ldc_w 465
    //   3141: aastore
    //   3142: aload 13
    //   3144: iconst_2
    //   3145: ldc_w 392
    //   3148: aastore
    //   3149: goto -418 -> 2731
    //   3152: aload 17
    //   3154: astore 18
    //   3156: aload 14
    //   3158: astore 19
    //   3160: aload 20
    //   3162: instanceof 835
    //   3165: ifeq +28 -> 3193
    //   3168: aload 17
    //   3170: astore 18
    //   3172: aload 14
    //   3174: astore 19
    //   3176: aload_1
    //   3177: bipush 14
    //   3179: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3182: aload 14
    //   3184: astore 13
    //   3186: aload 17
    //   3188: astore 14
    //   3190: goto -837 -> 2353
    //   3193: aload 17
    //   3195: astore 18
    //   3197: aload 14
    //   3199: astore 19
    //   3201: aload 20
    //   3203: instanceof 469
    //   3206: ifeq +28 -> 3234
    //   3209: aload 17
    //   3211: astore 18
    //   3213: aload 14
    //   3215: astore 19
    //   3217: aload_1
    //   3218: bipush 11
    //   3220: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3223: aload 14
    //   3225: astore 13
    //   3227: aload 17
    //   3229: astore 14
    //   3231: goto -878 -> 2353
    //   3234: aload 17
    //   3236: astore 18
    //   3238: aload 14
    //   3240: astore 19
    //   3242: aload 20
    //   3244: instanceof 837
    //   3247: ifeq +509 -> 3756
    //   3250: aload 17
    //   3252: astore 18
    //   3254: aload 14
    //   3256: astore 19
    //   3258: aload_1
    //   3259: bipush 12
    //   3261: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3264: aload 17
    //   3266: astore 18
    //   3268: aload 14
    //   3270: astore 19
    //   3272: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3275: ifeq +42 -> 3317
    //   3278: aload 17
    //   3280: astore 18
    //   3282: aload 14
    //   3284: astore 19
    //   3286: ldc_w 658
    //   3289: iconst_4
    //   3290: new 221	java/lang/StringBuilder
    //   3293: dup
    //   3294: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   3297: ldc_w 839
    //   3300: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: aload 20
    //   3305: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3308: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3317: aload 16
    //   3319: ifnull +59 -> 3378
    //   3322: aload 17
    //   3324: astore 18
    //   3326: aload 14
    //   3328: astore 19
    //   3330: aload 16
    //   3332: iconst_1
    //   3333: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   3336: aload 17
    //   3338: astore 18
    //   3340: aload 14
    //   3342: astore 19
    //   3344: aload_1
    //   3345: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3348: ifnull +365 -> 3713
    //   3351: aload 17
    //   3353: astore 18
    //   3355: aload 14
    //   3357: astore 19
    //   3359: aload_1
    //   3360: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3363: iconst_1
    //   3364: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   3367: aload 14
    //   3369: astore 13
    //   3371: aload 17
    //   3373: astore 14
    //   3375: goto -1022 -> 2353
    //   3378: aload 17
    //   3380: astore 18
    //   3382: aload 14
    //   3384: astore 19
    //   3386: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3389: ifeq -53 -> 3336
    //   3392: aload 17
    //   3394: astore 18
    //   3396: aload 14
    //   3398: astore 19
    //   3400: ldc_w 658
    //   3403: iconst_4
    //   3404: ldc_w 841
    //   3407: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3410: goto -74 -> 3336
    //   3413: astore 13
    //   3415: aload 17
    //   3417: astore 18
    //   3419: aload 15
    //   3421: astore 19
    //   3423: iconst_1
    //   3424: istore 10
    //   3426: aload 13
    //   3428: astore 17
    //   3430: aload 14
    //   3432: astore 15
    //   3434: aload 18
    //   3436: astore 14
    //   3438: aload 19
    //   3440: astore 13
    //   3442: aload 17
    //   3444: invokevirtual 799	java/lang/Throwable:printStackTrace	()V
    //   3447: aload_1
    //   3448: getfield 707	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3451: ifeq +14 -> 3465
    //   3454: invokestatic 805	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3457: iconst_5
    //   3458: aload_1
    //   3459: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3462: invokevirtual 808	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3465: aload_1
    //   3466: aload 17
    //   3468: invokevirtual 800	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3471: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   3474: iconst_0
    //   3475: istore 12
    //   3477: aload 17
    //   3479: instanceof 173
    //   3482: ifeq +407 -> 3889
    //   3485: aload_1
    //   3486: bipush 13
    //   3488: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3491: iload 12
    //   3493: istore 11
    //   3495: iload 10
    //   3497: ifne +85 -> 3582
    //   3500: iload 11
    //   3502: ifeq +80 -> 3582
    //   3505: iload 9
    //   3507: ifeq +613 -> 4120
    //   3510: iconst_1
    //   3511: putstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   3514: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3517: ifeq +65 -> 3582
    //   3520: ldc_w 658
    //   3523: iconst_2
    //   3524: new 221	java/lang/StringBuilder
    //   3527: dup
    //   3528: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   3531: ldc_w 843
    //   3534: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3537: getstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   3540: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3543: ldc_w 845
    //   3546: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3549: iload 10
    //   3551: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3554: ldc_w 847
    //   3557: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: iload 11
    //   3562: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3565: ldc_w 698
    //   3568: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: iload 9
    //   3573: invokevirtual 661	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3576: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3579: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3582: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3585: ifeq +60 -> 3645
    //   3588: ldc_w 658
    //   3591: iconst_2
    //   3592: new 221	java/lang/StringBuilder
    //   3595: dup
    //   3596: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   3599: ldc_w 849
    //   3602: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3605: aload_1
    //   3606: getfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3609: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3612: ldc_w 453
    //   3615: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: aload_1
    //   3619: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3622: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: ldc_w 455
    //   3628: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: aload 17
    //   3633: invokevirtual 800	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3636: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3639: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3642: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3645: aload 15
    //   3647: ifnull +8 -> 3655
    //   3650: aload 15
    //   3652: invokevirtual 421	java/io/OutputStream:close	()V
    //   3655: aload 14
    //   3657: ifnull +8 -> 3665
    //   3660: aload 14
    //   3662: invokevirtual 413	java/io/InputStream:close	()V
    //   3665: aload 13
    //   3667: ifnull +8 -> 3675
    //   3670: aload 13
    //   3672: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   3675: aload 13
    //   3677: astore 17
    //   3679: aload 14
    //   3681: astore 18
    //   3683: aload 15
    //   3685: astore 19
    //   3687: aload 16
    //   3689: ifnull -2256 -> 1433
    //   3692: aload 16
    //   3694: invokevirtual 309	java/io/File:delete	()Z
    //   3697: pop
    //   3698: aload 13
    //   3700: astore 17
    //   3702: aload 14
    //   3704: astore 18
    //   3706: aload 15
    //   3708: astore 19
    //   3710: goto -2277 -> 1433
    //   3713: aload 17
    //   3715: astore 18
    //   3717: aload 14
    //   3719: astore 19
    //   3721: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3724: ifeq +45 -> 3769
    //   3727: aload 17
    //   3729: astore 18
    //   3731: aload 14
    //   3733: astore 19
    //   3735: ldc_w 658
    //   3738: iconst_4
    //   3739: ldc_w 851
    //   3742: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3745: aload 14
    //   3747: astore 13
    //   3749: aload 17
    //   3751: astore 14
    //   3753: goto -1400 -> 2353
    //   3756: aload 17
    //   3758: astore 18
    //   3760: aload 14
    //   3762: astore 19
    //   3764: aload_1
    //   3765: iconst_4
    //   3766: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3769: aload 14
    //   3771: astore 13
    //   3773: aload 17
    //   3775: astore 14
    //   3777: goto -1424 -> 2353
    //   3780: aload 13
    //   3782: astore 18
    //   3784: aload 14
    //   3786: astore 17
    //   3788: aload 13
    //   3790: astore 20
    //   3792: aload 14
    //   3794: astore 19
    //   3796: aload_1
    //   3797: bipush 14
    //   3799: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3802: aload 13
    //   3804: astore 22
    //   3806: aload 14
    //   3808: astore 21
    //   3810: aload 13
    //   3812: astore 18
    //   3814: aload 14
    //   3816: astore 17
    //   3818: aload 13
    //   3820: astore 20
    //   3822: aload 14
    //   3824: astore 19
    //   3826: aload_1
    //   3827: getfield 707	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3830: ifeq +38 -> 3868
    //   3833: aload 13
    //   3835: astore 18
    //   3837: aload 14
    //   3839: astore 17
    //   3841: aload 13
    //   3843: astore 20
    //   3845: aload 14
    //   3847: astore 19
    //   3849: invokestatic 805	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3852: iconst_5
    //   3853: aload_1
    //   3854: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3857: invokevirtual 808	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3860: aload 14
    //   3862: astore 21
    //   3864: aload 13
    //   3866: astore 22
    //   3868: aload 22
    //   3870: astore 13
    //   3872: aload 21
    //   3874: astore 14
    //   3876: goto -2496 -> 1380
    //   3879: astore 17
    //   3881: aload 17
    //   3883: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   3886: goto -2476 -> 1410
    //   3889: aload 17
    //   3891: instanceof 449
    //   3894: ifeq +16 -> 3910
    //   3897: aload_1
    //   3898: bipush 10
    //   3900: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3903: iload 12
    //   3905: istore 11
    //   3907: goto -412 -> 3495
    //   3910: aload 17
    //   3912: instanceof 835
    //   3915: ifeq +16 -> 3931
    //   3918: aload_1
    //   3919: bipush 14
    //   3921: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3924: iload 12
    //   3926: istore 11
    //   3928: goto -433 -> 3495
    //   3931: aload 17
    //   3933: instanceof 442
    //   3936: ifne +11 -> 3947
    //   3939: aload 17
    //   3941: instanceof 444
    //   3944: ifeq +14 -> 3958
    //   3947: aload_1
    //   3948: iconst_2
    //   3949: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3952: iconst_1
    //   3953: istore 11
    //   3955: goto -460 -> 3495
    //   3958: aload 17
    //   3960: instanceof 469
    //   3963: ifeq +15 -> 3978
    //   3966: aload_1
    //   3967: bipush 11
    //   3969: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3972: iconst_1
    //   3973: istore 11
    //   3975: goto -480 -> 3495
    //   3978: aload 17
    //   3980: instanceof 837
    //   3983: ifeq +125 -> 4108
    //   3986: aload_1
    //   3987: bipush 12
    //   3989: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3992: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3995: ifeq +34 -> 4029
    //   3998: ldc_w 658
    //   4001: iconst_4
    //   4002: new 221	java/lang/StringBuilder
    //   4005: dup
    //   4006: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   4009: ldc_w 853
    //   4012: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: aload 17
    //   4017: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4020: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4023: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4026: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4029: aload 16
    //   4031: ifnull +31 -> 4062
    //   4034: aload 16
    //   4036: iconst_1
    //   4037: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   4040: aload_1
    //   4041: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4044: ifnull +37 -> 4081
    //   4047: aload_1
    //   4048: getfield 192	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4051: iconst_1
    //   4052: invokestatic 677	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   4055: iload 12
    //   4057: istore 11
    //   4059: goto -564 -> 3495
    //   4062: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4065: ifeq -25 -> 4040
    //   4068: ldc_w 658
    //   4071: iconst_4
    //   4072: ldc_w 841
    //   4075: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4078: goto -38 -> 4040
    //   4081: iload 12
    //   4083: istore 11
    //   4085: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4088: ifeq -593 -> 3495
    //   4091: ldc_w 658
    //   4094: iconst_4
    //   4095: ldc_w 851
    //   4098: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4101: iload 12
    //   4103: istore 11
    //   4105: goto -610 -> 3495
    //   4108: aload_1
    //   4109: iconst_4
    //   4110: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   4113: iload 12
    //   4115: istore 11
    //   4117: goto -622 -> 3495
    //   4120: iconst_0
    //   4121: putstatic 166	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   4124: goto -610 -> 3514
    //   4127: astore 17
    //   4129: aload 17
    //   4131: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   4134: goto -459 -> 3675
    //   4137: astore_1
    //   4138: aload_1
    //   4139: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   4142: goto -1131 -> 3011
    //   4145: aload_1
    //   4146: getfield 707	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   4149: ifeq +10 -> 4159
    //   4152: iconst_1
    //   4153: putstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   4156: goto -2703 -> 1453
    //   4159: iconst_0
    //   4160: putstatic 168	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   4163: goto -2710 -> 1453
    //   4166: astore_0
    //   4167: aload 23
    //   4169: monitorexit
    //   4170: aload_0
    //   4171: athrow
    //   4172: astore 13
    //   4174: goto -2568 -> 1606
    //   4177: astore_0
    //   4178: aload 19
    //   4180: astore 14
    //   4182: aload 18
    //   4184: astore 13
    //   4186: goto -1205 -> 2981
    //   4189: astore_0
    //   4190: aload 18
    //   4192: astore 13
    //   4194: aload 17
    //   4196: astore 14
    //   4198: goto -1217 -> 2981
    //   4201: astore_0
    //   4202: aconst_null
    //   4203: astore 16
    //   4205: goto -1224 -> 2981
    //   4208: astore_0
    //   4209: goto -1228 -> 2981
    //   4212: astore_0
    //   4213: goto -1232 -> 2981
    //   4216: astore 17
    //   4218: aload 20
    //   4220: astore 14
    //   4222: iconst_1
    //   4223: istore 10
    //   4225: aload 15
    //   4227: astore 13
    //   4229: aload 19
    //   4231: astore 15
    //   4233: goto -791 -> 3442
    //   4236: astore 18
    //   4238: aconst_null
    //   4239: astore 19
    //   4241: iconst_0
    //   4242: istore 9
    //   4244: aload 13
    //   4246: astore 16
    //   4248: aload 14
    //   4250: astore 17
    //   4252: aload 15
    //   4254: astore 13
    //   4256: aload 16
    //   4258: astore 14
    //   4260: aload 17
    //   4262: astore 15
    //   4264: aload 18
    //   4266: astore 17
    //   4268: aload 19
    //   4270: astore 16
    //   4272: goto -830 -> 3442
    //   4275: astore 19
    //   4277: iconst_0
    //   4278: istore 9
    //   4280: aload 13
    //   4282: astore 17
    //   4284: aload 14
    //   4286: astore 18
    //   4288: aload 15
    //   4290: astore 13
    //   4292: aload 17
    //   4294: astore 14
    //   4296: aload 18
    //   4298: astore 15
    //   4300: aload 19
    //   4302: astore 17
    //   4304: goto -862 -> 3442
    //   4307: astore 19
    //   4309: iconst_0
    //   4310: istore 9
    //   4312: aload 13
    //   4314: astore 17
    //   4316: aload 14
    //   4318: astore 18
    //   4320: aload 15
    //   4322: astore 13
    //   4324: aload 17
    //   4326: astore 14
    //   4328: aload 18
    //   4330: astore 15
    //   4332: aload 19
    //   4334: astore 17
    //   4336: goto -894 -> 3442
    //   4339: astore 19
    //   4341: aload 13
    //   4343: astore 17
    //   4345: aload 14
    //   4347: astore 18
    //   4349: aload 15
    //   4351: astore 13
    //   4353: aload 17
    //   4355: astore 14
    //   4357: aload 18
    //   4359: astore 15
    //   4361: aload 19
    //   4363: astore 17
    //   4365: goto -923 -> 3442
    //   4368: astore 20
    //   4370: aload 13
    //   4372: astore 17
    //   4374: goto -2138 -> 2236
    //   4377: aconst_null
    //   4378: astore 16
    //   4380: goto -4005 -> 375
    //   4383: aload 19
    //   4385: astore 14
    //   4387: aload 18
    //   4389: astore 13
    //   4391: aload 17
    //   4393: astore 15
    //   4395: goto -4101 -> 294
    //   4398: aload 15
    //   4400: astore 17
    //   4402: aload 13
    //   4404: astore 18
    //   4406: aload 14
    //   4408: astore 19
    //   4410: goto -2977 -> 1433
    //   4413: goto -2280 -> 2133
    //   4416: goto -1720 -> 2696
    //   4419: aload 14
    //   4421: astore 13
    //   4423: aload 17
    //   4425: astore 14
    //   4427: goto -2074 -> 2353
    //   4430: astore 20
    //   4432: goto -2196 -> 2236
    //   4435: astore_0
    //   4436: aload 13
    //   4438: astore_1
    //   4439: aload 14
    //   4441: astore 13
    //   4443: aload 15
    //   4445: astore 14
    //   4447: aload_1
    //   4448: astore 15
    //   4450: goto -1469 -> 2981
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4453	0	paramAppInterface	AppInterface
    //   0	4453	1	paramDownloadInfo	DownloadInfo
    //   0	4453	2	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   0	4453	3	paramProgressHandler	com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler
    //   537	2362	4	i1	int
    //   283	1257	5	i2	int
    //   2140	37	6	i3	int
    //   3	2795	7	l1	long
    //   36	4275	9	bool1	boolean
    //   295	3929	10	bool2	boolean
    //   3493	623	11	bool3	boolean
    //   3475	639	12	bool4	boolean
    //   29	3341	13	localObject1	Object
    //   3413	14	13	localThrowable1	java.lang.Throwable
    //   3440	431	13	localObject2	Object
    //   4172	1	13	localInterruptedException	java.lang.InterruptedException
    //   4184	258	13	localObject3	Object
    //   286	4160	14	localObject4	Object
    //   292	4157	15	localObject5	Object
    //   332	4047	16	localObject6	Object
    //   339	3501	17	localObject7	Object
    //   3879	137	17	localException1	java.lang.Exception
    //   4127	68	17	localException2	java.lang.Exception
    //   4216	1	17	localThrowable2	java.lang.Throwable
    //   4250	174	17	localObject8	Object
    //   621	3570	18	localObject9	Object
    //   4236	29	18	localThrowable3	java.lang.Throwable
    //   4286	119	18	localObject10	Object
    //   507	3762	19	localObject11	Object
    //   4275	26	19	localThrowable4	java.lang.Throwable
    //   4307	26	19	localThrowable5	java.lang.Throwable
    //   4339	45	19	localThrowable6	java.lang.Throwable
    //   4408	1	19	localObject12	Object
    //   532	1383	20	localObject13	Object
    //   2230	61	20	localThrowable7	java.lang.Throwable
    //   2371	1848	20	localObject14	Object
    //   4368	1	20	localThrowable8	java.lang.Throwable
    //   4430	1	20	localThrowable9	java.lang.Throwable
    //   408	3465	21	localObject15	Object
    //   400	3469	22	localObject16	Object
    //   280	3888	23	localObject17	Object
    //   1259	632	24	str	String
    // Exception table:
    //   from	to	target	type
    //   55	72	183	java/lang/Exception
    //   77	106	183	java/lang/Exception
    //   110	122	183	java/lang/Exception
    //   122	170	183	java/lang/Exception
    //   170	176	183	java/lang/Exception
    //   442	447	479	java/lang/Exception
    //   452	457	479	java/lang/Exception
    //   462	467	479	java/lang/Exception
    //   1942	1949	2230	java/lang/Throwable
    //   1957	1967	2230	java/lang/Throwable
    //   1975	1981	2230	java/lang/Throwable
    //   1989	2020	2230	java/lang/Throwable
    //   2028	2054	2230	java/lang/Throwable
    //   2062	2071	2230	java/lang/Throwable
    //   2079	2087	2230	java/lang/Throwable
    //   2095	2104	2230	java/lang/Throwable
    //   2212	2223	2230	java/lang/Throwable
    //   2123	2130	2976	finally
    //   2133	2142	2976	finally
    //   2155	2162	2976	finally
    //   2162	2172	2976	finally
    //   2183	2201	2976	finally
    //   2538	2587	2976	finally
    //   2587	2614	2976	finally
    //   2618	2696	2976	finally
    //   2696	2710	2976	finally
    //   2736	2749	2976	finally
    //   2749	2757	2976	finally
    //   2762	2771	2976	finally
    //   2771	2835	2976	finally
    //   2838	2935	2976	finally
    //   2938	2952	2976	finally
    //   3024	3030	2976	finally
    //   3054	3068	2976	finally
    //   3092	3098	2976	finally
    //   3122	3128	2976	finally
    //   2244	2249	3413	java/lang/Throwable
    //   2257	2266	3413	java/lang/Throwable
    //   2274	2282	3413	java/lang/Throwable
    //   2290	2298	3413	java/lang/Throwable
    //   2306	2311	3413	java/lang/Throwable
    //   2319	2326	3413	java/lang/Throwable
    //   2334	2345	3413	java/lang/Throwable
    //   3160	3168	3413	java/lang/Throwable
    //   3176	3182	3413	java/lang/Throwable
    //   3201	3209	3413	java/lang/Throwable
    //   3217	3223	3413	java/lang/Throwable
    //   3242	3250	3413	java/lang/Throwable
    //   3258	3264	3413	java/lang/Throwable
    //   3272	3278	3413	java/lang/Throwable
    //   3286	3317	3413	java/lang/Throwable
    //   3330	3336	3413	java/lang/Throwable
    //   3344	3351	3413	java/lang/Throwable
    //   3359	3367	3413	java/lang/Throwable
    //   3386	3392	3413	java/lang/Throwable
    //   3400	3410	3413	java/lang/Throwable
    //   3721	3727	3413	java/lang/Throwable
    //   3735	3745	3413	java/lang/Throwable
    //   3764	3769	3413	java/lang/Throwable
    //   1385	1390	3879	java/lang/Exception
    //   1395	1400	3879	java/lang/Exception
    //   1405	1410	3879	java/lang/Exception
    //   3650	3655	4127	java/lang/Exception
    //   3660	3665	4127	java/lang/Exception
    //   3670	3675	4127	java/lang/Exception
    //   2986	2991	4137	java/lang/Exception
    //   2996	3001	4137	java/lang/Exception
    //   3006	3011	4137	java/lang/Exception
    //   1598	1606	4166	finally
    //   1606	1609	4166	finally
    //   4167	4170	4166	finally
    //   1598	1606	4172	java/lang/InterruptedException
    //   2116	2123	4177	finally
    //   2244	2249	4177	finally
    //   2257	2266	4177	finally
    //   2274	2282	4177	finally
    //   2290	2298	4177	finally
    //   2306	2311	4177	finally
    //   2319	2326	4177	finally
    //   2334	2345	4177	finally
    //   3160	3168	4177	finally
    //   3176	3182	4177	finally
    //   3201	3209	4177	finally
    //   3217	3223	4177	finally
    //   3242	3250	4177	finally
    //   3258	3264	4177	finally
    //   3272	3278	4177	finally
    //   3286	3317	4177	finally
    //   3330	3336	4177	finally
    //   3344	3351	4177	finally
    //   3359	3367	4177	finally
    //   3386	3392	4177	finally
    //   3400	3410	4177	finally
    //   3721	3727	4177	finally
    //   3735	3745	4177	finally
    //   3764	3769	4177	finally
    //   627	633	4189	finally
    //   641	737	4189	finally
    //   745	752	4189	finally
    //   760	767	4189	finally
    //   775	787	4189	finally
    //   795	806	4189	finally
    //   814	822	4189	finally
    //   830	838	4189	finally
    //   846	853	4189	finally
    //   861	877	4189	finally
    //   885	891	4189	finally
    //   899	927	4189	finally
    //   935	943	4189	finally
    //   951	961	4189	finally
    //   969	975	4189	finally
    //   983	988	4189	finally
    //   996	1001	4189	finally
    //   1017	1026	4189	finally
    //   1042	1051	4189	finally
    //   1067	1076	4189	finally
    //   1092	1101	4189	finally
    //   1117	1123	4189	finally
    //   1139	1199	4189	finally
    //   1219	1233	4189	finally
    //   1249	1261	4189	finally
    //   1277	1284	4189	finally
    //   1300	1310	4189	finally
    //   1326	1332	4189	finally
    //   1348	1358	4189	finally
    //   1374	1380	4189	finally
    //   1741	1751	4189	finally
    //   1767	1778	4189	finally
    //   1794	1805	4189	finally
    //   1821	1827	4189	finally
    //   1851	1857	4189	finally
    //   1873	1901	4189	finally
    //   1920	1926	4189	finally
    //   1942	1949	4189	finally
    //   1957	1967	4189	finally
    //   1975	1981	4189	finally
    //   1989	2020	4189	finally
    //   2028	2054	4189	finally
    //   2062	2071	4189	finally
    //   2079	2087	4189	finally
    //   2095	2104	4189	finally
    //   2212	2223	4189	finally
    //   2377	2384	4189	finally
    //   2408	2415	4189	finally
    //   2439	2448	4189	finally
    //   2472	2480	4189	finally
    //   2509	2519	4189	finally
    //   3796	3802	4189	finally
    //   3826	3833	4189	finally
    //   3849	3860	4189	finally
    //   306	334	4201	finally
    //   334	355	4208	finally
    //   355	369	4208	finally
    //   369	375	4208	finally
    //   375	381	4212	finally
    //   385	396	4212	finally
    //   396	410	4212	finally
    //   415	431	4212	finally
    //   431	437	4212	finally
    //   495	502	4212	finally
    //   502	529	4212	finally
    //   529	547	4212	finally
    //   557	563	4212	finally
    //   568	601	4212	finally
    //   601	612	4212	finally
    //   1633	1655	4212	finally
    //   1662	1673	4212	finally
    //   1680	1691	4212	finally
    //   1698	1715	4212	finally
    //   1017	1026	4216	java/lang/Throwable
    //   1042	1051	4216	java/lang/Throwable
    //   1067	1076	4216	java/lang/Throwable
    //   1092	1101	4216	java/lang/Throwable
    //   1117	1123	4216	java/lang/Throwable
    //   1139	1199	4216	java/lang/Throwable
    //   1219	1233	4216	java/lang/Throwable
    //   1249	1261	4216	java/lang/Throwable
    //   1277	1284	4216	java/lang/Throwable
    //   1300	1310	4216	java/lang/Throwable
    //   1326	1332	4216	java/lang/Throwable
    //   1348	1358	4216	java/lang/Throwable
    //   1374	1380	4216	java/lang/Throwable
    //   1741	1751	4216	java/lang/Throwable
    //   1767	1778	4216	java/lang/Throwable
    //   1794	1805	4216	java/lang/Throwable
    //   1821	1827	4216	java/lang/Throwable
    //   1851	1857	4216	java/lang/Throwable
    //   1873	1901	4216	java/lang/Throwable
    //   1920	1926	4216	java/lang/Throwable
    //   2377	2384	4216	java/lang/Throwable
    //   2408	2415	4216	java/lang/Throwable
    //   2439	2448	4216	java/lang/Throwable
    //   2472	2480	4216	java/lang/Throwable
    //   2509	2519	4216	java/lang/Throwable
    //   3796	3802	4216	java/lang/Throwable
    //   3826	3833	4216	java/lang/Throwable
    //   3849	3860	4216	java/lang/Throwable
    //   306	334	4236	java/lang/Throwable
    //   334	355	4275	java/lang/Throwable
    //   355	369	4275	java/lang/Throwable
    //   369	375	4275	java/lang/Throwable
    //   375	381	4307	java/lang/Throwable
    //   385	396	4307	java/lang/Throwable
    //   396	410	4307	java/lang/Throwable
    //   415	431	4307	java/lang/Throwable
    //   431	437	4307	java/lang/Throwable
    //   495	502	4307	java/lang/Throwable
    //   502	529	4307	java/lang/Throwable
    //   529	547	4307	java/lang/Throwable
    //   557	563	4307	java/lang/Throwable
    //   568	601	4307	java/lang/Throwable
    //   601	612	4307	java/lang/Throwable
    //   1633	1655	4307	java/lang/Throwable
    //   1662	1673	4307	java/lang/Throwable
    //   1680	1691	4307	java/lang/Throwable
    //   1698	1715	4307	java/lang/Throwable
    //   627	633	4339	java/lang/Throwable
    //   641	737	4339	java/lang/Throwable
    //   745	752	4339	java/lang/Throwable
    //   760	767	4339	java/lang/Throwable
    //   775	787	4339	java/lang/Throwable
    //   795	806	4339	java/lang/Throwable
    //   814	822	4339	java/lang/Throwable
    //   830	838	4339	java/lang/Throwable
    //   846	853	4339	java/lang/Throwable
    //   861	877	4339	java/lang/Throwable
    //   885	891	4339	java/lang/Throwable
    //   899	927	4339	java/lang/Throwable
    //   935	943	4339	java/lang/Throwable
    //   951	961	4339	java/lang/Throwable
    //   969	975	4339	java/lang/Throwable
    //   983	988	4339	java/lang/Throwable
    //   996	1001	4339	java/lang/Throwable
    //   2116	2123	4368	java/lang/Throwable
    //   2123	2130	4430	java/lang/Throwable
    //   2133	2142	4430	java/lang/Throwable
    //   2155	2162	4430	java/lang/Throwable
    //   2162	2172	4430	java/lang/Throwable
    //   2183	2201	4430	java/lang/Throwable
    //   2538	2587	4430	java/lang/Throwable
    //   2587	2614	4430	java/lang/Throwable
    //   2618	2696	4430	java/lang/Throwable
    //   2696	2710	4430	java/lang/Throwable
    //   2736	2749	4430	java/lang/Throwable
    //   2749	2757	4430	java/lang/Throwable
    //   2762	2771	4430	java/lang/Throwable
    //   2771	2835	4430	java/lang/Throwable
    //   2838	2935	4430	java/lang/Throwable
    //   2938	2952	4430	java/lang/Throwable
    //   3024	3030	4430	java/lang/Throwable
    //   3054	3068	4430	java/lang/Throwable
    //   3092	3098	4430	java/lang/Throwable
    //   3122	3128	4430	java/lang/Throwable
    //   3442	3465	4435	finally
    //   3465	3474	4435	finally
    //   3477	3491	4435	finally
    //   3510	3514	4435	finally
    //   3514	3582	4435	finally
    //   3582	3645	4435	finally
    //   3889	3903	4435	finally
    //   3910	3924	4435	finally
    //   3931	3947	4435	finally
    //   3947	3952	4435	finally
    //   3958	3972	4435	finally
    //   3978	4029	4435	finally
    //   4034	4040	4435	finally
    //   4040	4055	4435	finally
    //   4062	4078	4435	finally
    //   4085	4101	4435	finally
    //   4108	4113	4435	finally
    //   4120	4124	4435	finally
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString.length() == 0)) {}
    do
    {
      String str;
      do
      {
        return;
        str = FMTSrvAddrProvider.a().a(5);
        if ((str == null) || (str.length() <= 0)) {
          break;
        }
        str = paramDownloadInfo.jdField_a_of_type_JavaLangString.replaceFirst("http://[^/\\s]*/", str);
        int i1 = "http://".length();
        int i2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.indexOf("/", i1);
        if (i2 > i1)
        {
          paramDownloadInfo.jdField_d_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString.substring(i1, i2);
          paramDownloadInfo.jdField_b_of_type_JavaLangString = str;
          paramDownloadInfo.jdField_a_of_type_Boolean = true;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.jdField_a_of_type_Boolean + " url[" + paramDownloadInfo.jdField_a_of_type_JavaLangString + "] resetIP[" + str + "] host[" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "]");
      return;
      paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramDownloadInfo.jdField_b_of_type_JavaLangString + "]");
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return a(paramAppInterface, paramURL, paramFile, jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo()) == 0;
  }
  
  private static boolean a(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2)
  {
    if (paramDownloadInfo == null) {
      if (paramInt1 > paramInt2) {}
    }
    while ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramInt1 <= paramInt2) && (paramDownloadInfo.jdField_b_of_type_Int != 16) && (paramDownloadInfo.jdField_b_of_type_Int != 6) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */