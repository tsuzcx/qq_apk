package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
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
    //   123: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
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
  public static int a(AppInterface paramAppInterface, String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    // Byte code:
    //   0: new 185	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_1
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 485	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
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
    //   34: ldc_w 487
    //   37: invokestatic 461	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 8
    //   42: iconst_1
    //   43: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   46: aload_2
    //   47: aload 8
    //   49: invokeinterface 492 2 0
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
    //   114: invokestatic 496	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: aload 7
    //   121: getstatic 164	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   177: getstatic 502	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +25 -> 208
    //   186: aload 7
    //   188: getstatic 504	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   191: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +14 -> 208
    //   197: aload 7
    //   199: getstatic 506	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   202: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +309 -> 514
    //   208: aload 6
    //   210: aload 11
    //   212: iload_3
    //   213: invokestatic 509	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   216: astore_1
    //   217: aload_1
    //   218: astore_0
    //   219: aload_0
    //   220: astore_1
    //   221: aload_0
    //   222: ldc_w 511
    //   225: ldc_w 513
    //   228: invokevirtual 519	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: astore_1
    //   233: aload_0
    //   234: sipush 30000
    //   237: invokevirtual 523	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   240: aload_0
    //   241: astore_1
    //   242: aload_0
    //   243: sipush 30000
    //   246: invokevirtual 526	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   249: aload_0
    //   250: astore_1
    //   251: aload_0
    //   252: iconst_1
    //   253: invokevirtual 530	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: invokevirtual 533	java/net/HttpURLConnection:connect	()V
    //   262: aload_0
    //   263: astore_1
    //   264: aload 8
    //   266: aload_0
    //   267: invokevirtual 536	java/net/HttpURLConnection:getResponseCode	()I
    //   270: putfield 538	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   273: aload_0
    //   274: astore_1
    //   275: aload 8
    //   277: aload_0
    //   278: invokevirtual 540	java/net/HttpURLConnection:getContentLength	()I
    //   281: putfield 542	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   284: aload_0
    //   285: astore_1
    //   286: aload 8
    //   288: aload_0
    //   289: invokevirtual 545	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   292: putfield 546	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   295: aload_0
    //   296: astore_1
    //   297: aload 8
    //   299: aload_0
    //   300: invokevirtual 549	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   303: putfield 551	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
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
    //   326: invokevirtual 554	java/net/HttpURLConnection:disconnect	()V
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
    //   356: ldc_w 556
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
    //   403: ldc2_w 557
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
    //   433: invokeinterface 492 2 0
    //   438: iload 4
    //   440: ireturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 235	java/net/MalformedURLException:printStackTrace	()V
    //   446: aload 8
    //   448: aload_0
    //   449: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   452: putfield 243	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload 8
    //   457: iconst_5
    //   458: putfield 471	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   461: aload_2
    //   462: aload 8
    //   464: invokeinterface 492 2 0
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
    //   506: invokeinterface 492 2 0
    //   511: bipush 13
    //   513: ireturn
    //   514: aload 7
    //   516: getstatic 559	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokevirtual 500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +17 -> 539
    //   525: aload 6
    //   527: aload 11
    //   529: iload_3
    //   530: invokestatic 561	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   533: astore_1
    //   534: aload_1
    //   535: astore_0
    //   536: goto -317 -> 219
    //   539: aload 6
    //   541: aload 11
    //   543: iload_3
    //   544: invokestatic 561	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   547: astore_1
    //   548: aload_1
    //   549: astore_0
    //   550: goto -331 -> 219
    //   553: aload 6
    //   555: aload 11
    //   557: iload_3
    //   558: invokestatic 561	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   561: astore_1
    //   562: aload_1
    //   563: astore_0
    //   564: goto -345 -> 219
    //   567: new 183	java/net/URL
    //   570: dup
    //   571: aload 6
    //   573: invokespecial 189	java/net/URL:<init>	(Ljava/lang/String;)V
    //   576: invokevirtual 565	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   579: checkcast 515	java/net/HttpURLConnection
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
    //   630: ldc_w 567
    //   633: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_3
    //   637: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 453
    //   643: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 8
    //   648: getfield 186	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   651: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 569
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
    //   684: invokevirtual 554	java/net/HttpURLConnection:disconnect	()V
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
    //   787: ldc_w 567
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
    //   819: invokevirtual 570	java/lang/Exception:getMessage	()Ljava/lang/String;
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
    //   841: invokevirtual 554	java/net/HttpURLConnection:disconnect	()V
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
    //   862: invokevirtual 554	java/net/HttpURLConnection:disconnect	()V
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
    //   427: invokeinterface 580 2 0
    //   432: lload 13
    //   434: lstore 11
    //   436: aload 19
    //   438: astore 20
    //   440: aload 19
    //   442: astore 21
    //   444: aload 19
    //   446: astore 22
    //   448: aload_2
    //   449: invokevirtual 583	java/io/File:length	()J
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
    //   541: ldc_w 585
    //   544: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: lload 13
    //   549: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: ldc_w 408
    //   555: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_1
    //   559: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   649: ldc_w 590
    //   652: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: lload 17
    //   657: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   660: ldc_w 592
    //   663: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_2
    //   667: invokevirtual 583	java/io/File:length	()J
    //   670: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   673: ldc_w 428
    //   676: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_1
    //   680: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   828: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   853: ldc2_w 593
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
    //   972: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   1033: ldc_w 599
    //   1036: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_1
    //   1040: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: aload_0
    //   1047: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   1191: ldc_w 601
    //   1194: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload_1
    //   1198: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: aload 21
    //   1206: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   1356: ldc_w 601
    //   1359: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: aload_1
    //   1363: invokevirtual 588	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: aload 21
    //   1371: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label245:
    do
    {
      do
      {
        int i1;
        int i2;
        String str1;
        do
        {
          return;
          i1 = "http://".length();
          i2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.indexOf("/", i1);
          str1 = paramDownloadInfo.jdField_a_of_type_JavaLangString.substring(i1, i2);
        } while ((i2 <= i1) && (TextUtils.isEmpty(str1)));
        if ("imgcache.qq.com".equalsIgnoreCase(str1)) {
          i1 = 12;
        }
        for (;;)
        {
          String str2 = FMTSrvAddrProvider.a().a(i1);
          if ((str2 == null) || (str2.length() <= 0)) {
            break label300;
          }
          str2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.replaceFirst("http://[^/\\s]*/", str2);
          paramDownloadInfo.jdField_d_of_type_JavaLangString = str1;
          paramDownloadInfo.jdField_b_of_type_JavaLangString = str2;
          paramDownloadInfo.jdField_a_of_type_Boolean = true;
          paramDownloadInfo.jdField_d_of_type_Int = i1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.jdField_a_of_type_Boolean + " url[" + paramDownloadInfo.jdField_a_of_type_JavaLangString + "] resetIP[" + str2 + "] host[" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "]");
          return;
          if ("imgcache.gtimg.cn".equalsIgnoreCase(str1))
          {
            i1 = 13;
          }
          else
          {
            if (!"i.gtimg.cn".equalsIgnoreCase(str1)) {
              break label245;
            }
            i1 = 14;
          }
        }
        paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
        paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramDownloadInfo.jdField_a_of_type_Boolean);
      return;
      paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    label300:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */