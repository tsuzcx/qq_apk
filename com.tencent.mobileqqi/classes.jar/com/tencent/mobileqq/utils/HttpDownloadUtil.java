package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
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
import org.apache.http.conn.ssl.SSLSocketFactory;
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
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      }
      for (;;)
      {
        localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
        jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
        jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
        jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread.start();
        jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
        jdField_b_of_type_JavaLangString = null;
        jdField_a_of_type_Boolean = false;
        jdField_b_of_type_Boolean = false;
        return;
        ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
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
  
  /* Error */
  private static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: new 225	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore 27
    //   13: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   16: lstore 12
    //   18: new 4	java/lang/Object
    //   21: dup
    //   22: invokespecial 214	java/lang/Object:<init>	()V
    //   25: astore 28
    //   27: aload_1
    //   28: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   31: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   34: astore 17
    //   36: aload 17
    //   38: ifnull +145 -> 183
    //   41: aload 17
    //   43: invokevirtual 241	java/io/File:exists	()Z
    //   46: ifne +137 -> 183
    //   49: aload 17
    //   51: invokevirtual 244	java/io/File:mkdirs	()Z
    //   54: ifne +129 -> 183
    //   57: aload_3
    //   58: ifnull +15 -> 73
    //   61: aload_3
    //   62: aload 27
    //   64: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   67: iconst_4
    //   68: invokeinterface 252 3 0
    //   73: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +32 -> 108
    //   79: ldc 15
    //   81: iconst_2
    //   82: new 254	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 257
    //   92: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iconst_4
    //   109: istore 6
    //   111: iload 6
    //   113: ireturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 268	java/net/MalformedURLException:printStackTrace	()V
    //   119: aload_1
    //   120: aload_0
    //   121: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   124: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   127: iconst_5
    //   128: ireturn
    //   129: astore_0
    //   130: aload_3
    //   131: ifnull +15 -> 146
    //   134: aload_3
    //   135: aload 27
    //   137: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   140: iconst_4
    //   141: invokeinterface 252 3 0
    //   146: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +32 -> 181
    //   152: ldc 15
    //   154: iconst_2
    //   155: new 254	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 257
    //   165: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   172: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iconst_4
    //   182: ireturn
    //   183: aconst_null
    //   184: astore 19
    //   186: aload_1
    //   187: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   190: astore 17
    //   192: new 278	org/apache/http/client/methods/HttpGet
    //   195: dup
    //   196: aload 17
    //   198: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   201: astore 26
    //   203: new 72	org/apache/http/params/BasicHttpParams
    //   206: dup
    //   207: invokespecial 75	org/apache/http/params/BasicHttpParams:<init>	()V
    //   210: astore 29
    //   212: aload 29
    //   214: ldc_w 281
    //   217: ldc_w 282
    //   220: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokeinterface 293 3 0
    //   228: pop
    //   229: aload 29
    //   231: ldc_w 295
    //   234: ldc_w 282
    //   237: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokeinterface 293 3 0
    //   245: pop
    //   246: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   249: astore 17
    //   251: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   254: istore 5
    //   256: iconst_0
    //   257: istore 4
    //   259: aload_2
    //   260: ifnull +96 -> 356
    //   263: aload_2
    //   264: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   267: astore 18
    //   269: aload_2
    //   270: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   273: ifeq +51 -> 324
    //   276: aload 18
    //   278: ifnull +14 -> 292
    //   281: aload 18
    //   283: ldc_w 316
    //   286: invokevirtual 320	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   289: ifeq +35 -> 324
    //   292: aload 17
    //   294: ifnull +30 -> 324
    //   297: iload 5
    //   299: ifle +25 -> 324
    //   302: aload 29
    //   304: ldc_w 322
    //   307: new 324	org/apache/http/HttpHost
    //   310: dup
    //   311: aload 17
    //   313: iload 5
    //   315: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   318: invokeinterface 293 3 0
    //   323: pop
    //   324: aload_2
    //   325: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   328: ifeq +574 -> 902
    //   331: sipush 2048
    //   334: istore 4
    //   336: aload 29
    //   338: ldc_w 328
    //   341: iload 4
    //   343: invokeinterface 332 3 0
    //   348: pop
    //   349: aload 26
    //   351: aload 29
    //   353: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   356: new 234	java/io/File
    //   359: dup
    //   360: aload_1
    //   361: invokevirtual 338	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   364: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore 30
    //   369: aload 30
    //   371: invokevirtual 241	java/io/File:exists	()Z
    //   374: ifeq +9 -> 383
    //   377: aload 30
    //   379: invokevirtual 342	java/io/File:delete	()Z
    //   382: pop
    //   383: aconst_null
    //   384: astore 17
    //   386: iconst_m1
    //   387: istore 9
    //   389: iconst_5
    //   390: istore 10
    //   392: iload 9
    //   394: ifne +38 -> 432
    //   397: aload 29
    //   399: ldc_w 322
    //   402: new 324	org/apache/http/HttpHost
    //   405: dup
    //   406: aload 27
    //   408: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   411: aload 27
    //   413: invokevirtual 348	java/net/URL:getPort	()I
    //   416: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   419: invokeinterface 293 3 0
    //   424: pop
    //   425: aload 26
    //   427: aload 29
    //   429: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   432: aload 19
    //   434: astore 24
    //   436: aload 17
    //   438: astore 20
    //   440: iload 4
    //   442: istore 6
    //   444: aload 19
    //   446: astore 23
    //   448: aload 17
    //   450: astore 21
    //   452: iload 4
    //   454: istore 8
    //   456: aload 19
    //   458: astore 25
    //   460: aload 17
    //   462: astore 22
    //   464: iload 10
    //   466: istore 7
    //   468: getstatic 149	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   471: new 324	org/apache/http/HttpHost
    //   474: dup
    //   475: aload 27
    //   477: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   480: invokespecial 349	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   483: aload 26
    //   485: invokevirtual 353	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   488: astore 18
    //   490: aload 19
    //   492: astore 24
    //   494: aload 17
    //   496: astore 20
    //   498: iload 4
    //   500: istore 6
    //   502: aload 19
    //   504: astore 23
    //   506: aload 17
    //   508: astore 21
    //   510: iload 4
    //   512: istore 8
    //   514: aload 19
    //   516: astore 25
    //   518: aload 17
    //   520: astore 22
    //   522: iload 10
    //   524: istore 7
    //   526: aload 18
    //   528: invokeinterface 359 1 0
    //   533: astore 31
    //   535: aload 19
    //   537: astore 24
    //   539: aload 17
    //   541: astore 20
    //   543: iload 4
    //   545: istore 6
    //   547: aload 19
    //   549: astore 23
    //   551: aload 17
    //   553: astore 21
    //   555: iload 4
    //   557: istore 8
    //   559: aload 19
    //   561: astore 25
    //   563: aload 17
    //   565: astore 22
    //   567: iload 10
    //   569: istore 7
    //   571: aload 18
    //   573: invokeinterface 363 1 0
    //   578: pop
    //   579: aload 19
    //   581: astore 24
    //   583: aload 17
    //   585: astore 20
    //   587: iload 4
    //   589: istore 6
    //   591: aload 19
    //   593: astore 23
    //   595: aload 17
    //   597: astore 21
    //   599: iload 4
    //   601: istore 8
    //   603: aload 19
    //   605: astore 25
    //   607: aload 17
    //   609: astore 22
    //   611: iload 10
    //   613: istore 7
    //   615: aload 31
    //   617: invokeinterface 368 1 0
    //   622: istore 5
    //   624: aload_3
    //   625: ifnull +52 -> 677
    //   628: aload 19
    //   630: astore 24
    //   632: aload 17
    //   634: astore 20
    //   636: iload 4
    //   638: istore 6
    //   640: aload 19
    //   642: astore 23
    //   644: aload 17
    //   646: astore 21
    //   648: iload 4
    //   650: istore 8
    //   652: aload 19
    //   654: astore 25
    //   656: aload 17
    //   658: astore 22
    //   660: iload 10
    //   662: istore 7
    //   664: aload_3
    //   665: aload 27
    //   667: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   670: iload 5
    //   672: invokeinterface 370 3 0
    //   677: aload 19
    //   679: astore 24
    //   681: aload 17
    //   683: astore 20
    //   685: iload 4
    //   687: istore 6
    //   689: aload 19
    //   691: astore 23
    //   693: aload 17
    //   695: astore 21
    //   697: iload 4
    //   699: istore 8
    //   701: aload 19
    //   703: astore 25
    //   705: aload 17
    //   707: astore 22
    //   709: iload 10
    //   711: istore 7
    //   713: aload 18
    //   715: invokeinterface 374 1 0
    //   720: astore 17
    //   722: sipush 200
    //   725: iload 5
    //   727: if_icmpne +1433 -> 2160
    //   730: aload 19
    //   732: astore 24
    //   734: aload 17
    //   736: astore 20
    //   738: iload 4
    //   740: istore 6
    //   742: aload 19
    //   744: astore 23
    //   746: aload 17
    //   748: astore 21
    //   750: iload 4
    //   752: istore 8
    //   754: aload 19
    //   756: astore 25
    //   758: aload 17
    //   760: astore 22
    //   762: iload 10
    //   764: istore 7
    //   766: aload 17
    //   768: invokeinterface 379 1 0
    //   773: lstore 14
    //   775: aconst_null
    //   776: astore 20
    //   778: iconst_0
    //   779: istore 5
    //   781: new 381	java/io/FileOutputStream
    //   784: dup
    //   785: aload 30
    //   787: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   790: astore 18
    //   792: aload 17
    //   794: invokeinterface 388 1 0
    //   799: astore 19
    //   801: aload 19
    //   803: astore 20
    //   805: iload 4
    //   807: ifne +1888 -> 2695
    //   810: sipush 2048
    //   813: istore 4
    //   815: iload 4
    //   817: newarray byte
    //   819: astore 19
    //   821: iload 5
    //   823: i2l
    //   824: lload 14
    //   826: lcmp
    //   827: ifge +83 -> 910
    //   830: aload 20
    //   832: aload 19
    //   834: invokevirtual 394	java/io/InputStream:read	([B)I
    //   837: istore 6
    //   839: aload 18
    //   841: aload 19
    //   843: iconst_0
    //   844: iload 6
    //   846: invokevirtual 400	java/io/OutputStream:write	([BII)V
    //   849: iload 5
    //   851: iload 6
    //   853: iadd
    //   854: istore 5
    //   856: aload_3
    //   857: ifnull +1835 -> 2692
    //   860: aload_3
    //   861: aload 27
    //   863: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   866: lload 14
    //   868: iload 5
    //   870: i2l
    //   871: invokeinterface 403 6 0
    //   876: goto -55 -> 821
    //   879: astore 18
    //   881: new 278	org/apache/http/client/methods/HttpGet
    //   884: dup
    //   885: aload 17
    //   887: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   890: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   893: astore 26
    //   895: goto -692 -> 203
    //   898: astore_0
    //   899: bipush 13
    //   901: ireturn
    //   902: sipush 4096
    //   905: istore 4
    //   907: goto -571 -> 336
    //   910: iload 5
    //   912: i2l
    //   913: lload 14
    //   915: lcmp
    //   916: ifne +655 -> 1571
    //   919: iconst_0
    //   920: istore 10
    //   922: iconst_0
    //   923: istore 11
    //   925: iconst_0
    //   926: istore 8
    //   928: iload 8
    //   930: istore 5
    //   932: iload 10
    //   934: istore 6
    //   936: iload 11
    //   938: istore 7
    //   940: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq +44 -> 987
    //   946: iload 10
    //   948: istore 6
    //   950: iload 11
    //   952: istore 7
    //   954: ldc 15
    //   956: iconst_2
    //   957: new 254	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   964: ldc_w 408
    //   967: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_1
    //   971: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   974: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   983: iload 8
    //   985: istore 5
    //   987: iload 5
    //   989: istore 6
    //   991: iload 5
    //   993: istore 7
    //   995: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   998: ifeq +53 -> 1051
    //   1001: iload 5
    //   1003: istore 6
    //   1005: iload 5
    //   1007: istore 7
    //   1009: ldc_w 410
    //   1012: iconst_2
    //   1013: new 254	java/lang/StringBuilder
    //   1016: dup
    //   1017: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1020: ldc_w 412
    //   1023: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1029: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: ldc_w 417
    //   1035: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_1
    //   1039: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1042: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: aload_1
    //   1052: ifnull +107 -> 1159
    //   1055: iload 5
    //   1057: istore 6
    //   1059: iload 5
    //   1061: istore 7
    //   1063: aload_1
    //   1064: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   1067: tableswitch	default:+1631 -> 2698, 10001:+664->1731
    //   1085: iconst_2
    //   1086: istore 6
    //   1088: iload 5
    //   1090: istore 7
    //   1092: aload_2
    //   1093: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1096: ifeq +1001 -> 2097
    //   1099: iload 5
    //   1101: istore 6
    //   1103: iload 5
    //   1105: istore 7
    //   1107: iconst_3
    //   1108: anewarray 270	java/lang/String
    //   1111: astore 19
    //   1113: aload 19
    //   1115: iconst_0
    //   1116: ldc_w 421
    //   1119: aastore
    //   1120: aload 19
    //   1122: iconst_1
    //   1123: ldc_w 423
    //   1126: aastore
    //   1127: aload 19
    //   1129: iconst_2
    //   1130: ldc_w 425
    //   1133: aastore
    //   1134: aload 19
    //   1136: ifnull +23 -> 1159
    //   1139: iload 5
    //   1141: istore 6
    //   1143: iload 5
    //   1145: istore 7
    //   1147: aload_0
    //   1148: aload_0
    //   1149: invokevirtual 428	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1152: aload 19
    //   1154: lload 14
    //   1156: invokevirtual 431	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1159: iload 5
    //   1161: istore 6
    //   1163: iload 5
    //   1165: istore 7
    //   1167: aload 30
    //   1169: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1172: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   1175: pop
    //   1176: iload 5
    //   1178: istore 6
    //   1180: iload 5
    //   1182: istore 7
    //   1184: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +66 -> 1253
    //   1190: iload 5
    //   1192: istore 6
    //   1194: iload 5
    //   1196: istore 7
    //   1198: ldc 15
    //   1200: iconst_2
    //   1201: new 254	java/lang/StringBuilder
    //   1204: dup
    //   1205: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1208: ldc_w 437
    //   1211: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1217: lload 12
    //   1219: lsub
    //   1220: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: ldc_w 439
    //   1226: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: lload 14
    //   1231: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1234: ldc_w 441
    //   1237: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload_1
    //   1241: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1244: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1253: aload 20
    //   1255: ifnull +1434 -> 2689
    //   1258: iload 5
    //   1260: istore 7
    //   1262: iload 4
    //   1264: istore 6
    //   1266: aload 18
    //   1268: astore 21
    //   1270: iload 4
    //   1272: istore 8
    //   1274: aload 18
    //   1276: astore 22
    //   1278: aload 18
    //   1280: astore 23
    //   1282: aload 20
    //   1284: invokevirtual 446	java/io/InputStream:close	()V
    //   1287: iload 5
    //   1289: ifne +92 -> 1381
    //   1292: aload 18
    //   1294: astore 24
    //   1296: aload 17
    //   1298: astore 20
    //   1300: iload 4
    //   1302: istore 6
    //   1304: aload 18
    //   1306: astore 23
    //   1308: aload 17
    //   1310: astore 21
    //   1312: iload 4
    //   1314: istore 8
    //   1316: aload 18
    //   1318: astore 25
    //   1320: aload 17
    //   1322: astore 22
    //   1324: iload 5
    //   1326: istore 7
    //   1328: aload_1
    //   1329: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1332: ifnull +49 -> 1381
    //   1335: aload 18
    //   1337: astore 24
    //   1339: aload 17
    //   1341: astore 20
    //   1343: iload 4
    //   1345: istore 6
    //   1347: aload 18
    //   1349: astore 23
    //   1351: aload 17
    //   1353: astore 21
    //   1355: iload 4
    //   1357: istore 8
    //   1359: aload 18
    //   1361: astore 25
    //   1363: aload 17
    //   1365: astore 22
    //   1367: iload 5
    //   1369: istore 7
    //   1371: aload 30
    //   1373: aload_1
    //   1374: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1377: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1380: pop
    //   1381: aload_3
    //   1382: ifnull +52 -> 1434
    //   1385: aload 18
    //   1387: astore 24
    //   1389: aload 17
    //   1391: astore 20
    //   1393: iload 4
    //   1395: istore 6
    //   1397: aload 18
    //   1399: astore 23
    //   1401: aload 17
    //   1403: astore 21
    //   1405: iload 4
    //   1407: istore 8
    //   1409: aload 18
    //   1411: astore 25
    //   1413: aload 17
    //   1415: astore 22
    //   1417: iload 5
    //   1419: istore 7
    //   1421: aload_3
    //   1422: aload 27
    //   1424: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1427: iload 5
    //   1429: invokeinterface 252 3 0
    //   1434: aload 17
    //   1436: ifnull +10 -> 1446
    //   1439: aload 17
    //   1441: invokeinterface 453 1 0
    //   1446: aload 18
    //   1448: ifnull +1227 -> 2675
    //   1451: aload 18
    //   1453: invokevirtual 454	java/io/OutputStream:close	()V
    //   1456: aload 18
    //   1458: astore 20
    //   1460: aload 17
    //   1462: astore 19
    //   1464: iload 9
    //   1466: iconst_1
    //   1467: iadd
    //   1468: istore 9
    //   1470: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1473: ifeq +43 -> 1516
    //   1476: ldc 15
    //   1478: iconst_2
    //   1479: new 254	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1486: ldc_w 456
    //   1489: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: iload 5
    //   1494: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1497: ldc_w 461
    //   1500: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: aload_1
    //   1504: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1507: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1513: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1516: iload 9
    //   1518: iconst_2
    //   1519: if_icmpge +22 -> 1541
    //   1522: iload 5
    //   1524: ifeq +17 -> 1541
    //   1527: aload 28
    //   1529: monitorenter
    //   1530: aload 28
    //   1532: ldc2_w 462
    //   1535: invokevirtual 467	java/lang/Object:wait	(J)V
    //   1538: aload 28
    //   1540: monitorexit
    //   1541: iload 5
    //   1543: istore 6
    //   1545: iload 5
    //   1547: ifeq -1436 -> 111
    //   1550: iload 5
    //   1552: istore 6
    //   1554: iload 9
    //   1556: iconst_2
    //   1557: if_icmpge -1446 -> 111
    //   1560: aload 19
    //   1562: astore 17
    //   1564: aload 20
    //   1566: astore 19
    //   1568: goto -1179 -> 389
    //   1571: bipush 8
    //   1573: istore 8
    //   1575: iload 8
    //   1577: istore 6
    //   1579: iload 8
    //   1581: istore 7
    //   1583: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1586: ifeq +62 -> 1648
    //   1589: iload 8
    //   1591: istore 6
    //   1593: iload 8
    //   1595: istore 7
    //   1597: ldc 15
    //   1599: iconst_2
    //   1600: new 254	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1607: ldc_w 469
    //   1610: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: iload 5
    //   1615: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1618: ldc_w 471
    //   1621: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: lload 14
    //   1626: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1629: ldc_w 473
    //   1632: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: aload_1
    //   1636: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1639: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1648: iload 8
    //   1650: istore 5
    //   1652: iload 8
    //   1654: istore 6
    //   1656: iload 8
    //   1658: istore 7
    //   1660: aload 30
    //   1662: invokevirtual 241	java/io/File:exists	()Z
    //   1665: ifeq -678 -> 987
    //   1668: iload 8
    //   1670: istore 6
    //   1672: iload 8
    //   1674: istore 7
    //   1676: aload 30
    //   1678: invokevirtual 342	java/io/File:delete	()Z
    //   1681: pop
    //   1682: iload 8
    //   1684: istore 5
    //   1686: goto -699 -> 987
    //   1689: astore 19
    //   1691: iload 6
    //   1693: istore 5
    //   1695: aload 19
    //   1697: instanceof 475
    //   1700: ifne +15 -> 1715
    //   1703: aload 19
    //   1705: instanceof 477
    //   1708: istore 16
    //   1710: iload 16
    //   1712: ifeq +423 -> 2135
    //   1715: iconst_3
    //   1716: istore 5
    //   1718: aload 20
    //   1720: ifnull +966 -> 2686
    //   1723: aload 20
    //   1725: invokevirtual 446	java/io/InputStream:close	()V
    //   1728: goto -441 -> 1287
    //   1731: iload 5
    //   1733: istore 6
    //   1735: iload 5
    //   1737: istore 7
    //   1739: aload_2
    //   1740: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1743: ifeq +316 -> 2059
    //   1746: iload 5
    //   1748: istore 6
    //   1750: iload 5
    //   1752: istore 7
    //   1754: iconst_3
    //   1755: anewarray 270	java/lang/String
    //   1758: astore 19
    //   1760: aload 19
    //   1762: iconst_0
    //   1763: ldc_w 479
    //   1766: aastore
    //   1767: aload 19
    //   1769: iconst_1
    //   1770: ldc_w 423
    //   1773: aastore
    //   1774: aload 19
    //   1776: iconst_2
    //   1777: ldc_w 425
    //   1780: aastore
    //   1781: goto -647 -> 1134
    //   1784: astore 19
    //   1786: iload 7
    //   1788: istore 5
    //   1790: aload 20
    //   1792: ifnull +32 -> 1824
    //   1795: iload 5
    //   1797: istore 7
    //   1799: iload 4
    //   1801: istore 6
    //   1803: aload 18
    //   1805: astore 21
    //   1807: iload 4
    //   1809: istore 8
    //   1811: aload 18
    //   1813: astore 22
    //   1815: aload 18
    //   1817: astore 23
    //   1819: aload 20
    //   1821: invokevirtual 446	java/io/InputStream:close	()V
    //   1824: iload 5
    //   1826: istore 7
    //   1828: iload 4
    //   1830: istore 6
    //   1832: aload 18
    //   1834: astore 21
    //   1836: iload 4
    //   1838: istore 8
    //   1840: aload 18
    //   1842: astore 22
    //   1844: aload 18
    //   1846: astore 23
    //   1848: aload 19
    //   1850: athrow
    //   1851: astore 19
    //   1853: aload 21
    //   1855: astore 18
    //   1857: iload 7
    //   1859: istore 5
    //   1861: aload 17
    //   1863: astore 21
    //   1865: aload 18
    //   1867: astore 20
    //   1869: aload 19
    //   1871: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1874: aload 17
    //   1876: astore 21
    //   1878: aload 18
    //   1880: astore 20
    //   1882: aload 19
    //   1884: instanceof 482
    //   1887: ifeq +340 -> 2227
    //   1890: bipush 10
    //   1892: istore 7
    //   1894: aload 17
    //   1896: astore 21
    //   1898: aload 18
    //   1900: astore 20
    //   1902: ldc 15
    //   1904: iconst_2
    //   1905: new 254	java/lang/StringBuilder
    //   1908: dup
    //   1909: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1912: ldc_w 484
    //   1915: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: iload 7
    //   1920: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1923: ldc_w 486
    //   1926: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_1
    //   1930: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1933: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: ldc_w 488
    //   1939: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: aload 19
    //   1944: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1947: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: aload_3
    //   1957: ifnull +24 -> 1981
    //   1960: aload 17
    //   1962: astore 21
    //   1964: aload 18
    //   1966: astore 20
    //   1968: aload_3
    //   1969: aload 27
    //   1971: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1974: iload 7
    //   1976: invokeinterface 252 3 0
    //   1981: aload 17
    //   1983: ifnull +10 -> 1993
    //   1986: aload 17
    //   1988: invokeinterface 453 1 0
    //   1993: aload 17
    //   1995: astore 19
    //   1997: iload 6
    //   1999: istore 4
    //   2001: aload 18
    //   2003: astore 20
    //   2005: iload 7
    //   2007: istore 5
    //   2009: aload 18
    //   2011: ifnull -547 -> 1464
    //   2014: aload 18
    //   2016: invokevirtual 454	java/io/OutputStream:close	()V
    //   2019: aload 17
    //   2021: astore 19
    //   2023: iload 6
    //   2025: istore 4
    //   2027: aload 18
    //   2029: astore 20
    //   2031: iload 7
    //   2033: istore 5
    //   2035: goto -571 -> 1464
    //   2038: astore 19
    //   2040: aload 17
    //   2042: astore 19
    //   2044: iload 6
    //   2046: istore 4
    //   2048: aload 18
    //   2050: astore 20
    //   2052: iload 7
    //   2054: istore 5
    //   2056: goto -592 -> 1464
    //   2059: iload 5
    //   2061: istore 6
    //   2063: iload 5
    //   2065: istore 7
    //   2067: iconst_3
    //   2068: anewarray 270	java/lang/String
    //   2071: astore 19
    //   2073: aload 19
    //   2075: iconst_0
    //   2076: ldc_w 496
    //   2079: aastore
    //   2080: aload 19
    //   2082: iconst_1
    //   2083: ldc_w 498
    //   2086: aastore
    //   2087: aload 19
    //   2089: iconst_2
    //   2090: ldc_w 425
    //   2093: aastore
    //   2094: goto -960 -> 1134
    //   2097: iload 5
    //   2099: istore 6
    //   2101: iload 5
    //   2103: istore 7
    //   2105: iconst_3
    //   2106: anewarray 270	java/lang/String
    //   2109: astore 19
    //   2111: aload 19
    //   2113: iconst_0
    //   2114: ldc_w 500
    //   2117: aastore
    //   2118: aload 19
    //   2120: iconst_1
    //   2121: ldc_w 498
    //   2124: aastore
    //   2125: aload 19
    //   2127: iconst_2
    //   2128: ldc_w 425
    //   2131: aastore
    //   2132: goto -998 -> 1134
    //   2135: aload 19
    //   2137: instanceof 502
    //   2140: istore 16
    //   2142: iload 16
    //   2144: ifeq +10 -> 2154
    //   2147: bipush 11
    //   2149: istore 5
    //   2151: goto -433 -> 1718
    //   2154: iconst_4
    //   2155: istore 5
    //   2157: goto -439 -> 1718
    //   2160: aload_3
    //   2161: ifnull +36 -> 2197
    //   2164: aload 19
    //   2166: astore 24
    //   2168: aload 17
    //   2170: astore 20
    //   2172: iload 4
    //   2174: istore 6
    //   2176: aload 19
    //   2178: astore 23
    //   2180: aload 17
    //   2182: astore 21
    //   2184: aload_3
    //   2185: aload 27
    //   2187: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2190: iload 5
    //   2192: invokeinterface 252 3 0
    //   2197: aload 19
    //   2199: astore 18
    //   2201: goto -767 -> 1434
    //   2204: astore 19
    //   2206: aload 19
    //   2208: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2211: goto -765 -> 1446
    //   2214: astore 19
    //   2216: aload 17
    //   2218: astore 19
    //   2220: aload 18
    //   2222: astore 20
    //   2224: goto -760 -> 1464
    //   2227: aload 17
    //   2229: astore 21
    //   2231: aload 18
    //   2233: astore 20
    //   2235: aload 19
    //   2237: instanceof 475
    //   2240: ifne +461 -> 2701
    //   2243: aload 17
    //   2245: astore 21
    //   2247: aload 18
    //   2249: astore 20
    //   2251: aload 19
    //   2253: instanceof 477
    //   2256: ifeq +6 -> 2262
    //   2259: goto +442 -> 2701
    //   2262: aload 17
    //   2264: astore 21
    //   2266: aload 18
    //   2268: astore 20
    //   2270: aload 19
    //   2272: instanceof 502
    //   2275: ifeq +24 -> 2299
    //   2278: aload 17
    //   2280: astore 21
    //   2282: aload 18
    //   2284: astore 20
    //   2286: aload_1
    //   2287: bipush 11
    //   2289: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2292: iload 5
    //   2294: istore 7
    //   2296: goto -402 -> 1894
    //   2299: iconst_4
    //   2300: istore 7
    //   2302: goto -408 -> 1894
    //   2305: astore 19
    //   2307: aload 19
    //   2309: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2312: goto -319 -> 1993
    //   2315: astore 19
    //   2317: iload 8
    //   2319: istore 6
    //   2321: aload 22
    //   2323: astore 18
    //   2325: aload 17
    //   2327: astore 21
    //   2329: aload 18
    //   2331: astore 20
    //   2333: aload 19
    //   2335: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   2338: iconst_5
    //   2339: istore 7
    //   2341: aload_3
    //   2342: ifnull +23 -> 2365
    //   2345: aload 17
    //   2347: astore 21
    //   2349: aload 18
    //   2351: astore 20
    //   2353: aload_3
    //   2354: aload 27
    //   2356: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2359: iconst_5
    //   2360: invokeinterface 252 3 0
    //   2365: aload 17
    //   2367: ifnull +10 -> 2377
    //   2370: aload 17
    //   2372: invokeinterface 453 1 0
    //   2377: aload 17
    //   2379: astore 19
    //   2381: iload 6
    //   2383: istore 4
    //   2385: aload 18
    //   2387: astore 20
    //   2389: iload 7
    //   2391: istore 5
    //   2393: aload 18
    //   2395: ifnull -931 -> 1464
    //   2398: aload 18
    //   2400: invokevirtual 454	java/io/OutputStream:close	()V
    //   2403: aload 17
    //   2405: astore 19
    //   2407: iload 6
    //   2409: istore 4
    //   2411: aload 18
    //   2413: astore 20
    //   2415: iload 7
    //   2417: istore 5
    //   2419: goto -955 -> 1464
    //   2422: astore 19
    //   2424: aload 17
    //   2426: astore 19
    //   2428: iload 6
    //   2430: istore 4
    //   2432: aload 18
    //   2434: astore 20
    //   2436: iload 7
    //   2438: istore 5
    //   2440: goto -976 -> 1464
    //   2443: astore 19
    //   2445: aload 19
    //   2447: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2450: goto -73 -> 2377
    //   2453: astore_0
    //   2454: aload 23
    //   2456: astore_1
    //   2457: aload 17
    //   2459: ifnull +10 -> 2469
    //   2462: aload 17
    //   2464: invokeinterface 453 1 0
    //   2469: aload_1
    //   2470: ifnull +7 -> 2477
    //   2473: aload_1
    //   2474: invokevirtual 454	java/io/OutputStream:close	()V
    //   2477: aload_0
    //   2478: athrow
    //   2479: astore_2
    //   2480: aload_2
    //   2481: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2484: goto -15 -> 2469
    //   2487: astore_0
    //   2488: aload 28
    //   2490: monitorexit
    //   2491: aload_0
    //   2492: athrow
    //   2493: astore_1
    //   2494: goto -17 -> 2477
    //   2497: astore 17
    //   2499: goto -961 -> 1538
    //   2502: astore_0
    //   2503: aload 18
    //   2505: astore_1
    //   2506: goto -49 -> 2457
    //   2509: astore_0
    //   2510: aload 24
    //   2512: astore_1
    //   2513: aload 20
    //   2515: astore 17
    //   2517: goto -60 -> 2457
    //   2520: astore_0
    //   2521: aload 21
    //   2523: astore 17
    //   2525: aload 20
    //   2527: astore_1
    //   2528: goto -71 -> 2457
    //   2531: astore 19
    //   2533: iload 4
    //   2535: istore 6
    //   2537: goto -212 -> 2325
    //   2540: astore 19
    //   2542: aload 23
    //   2544: astore 18
    //   2546: aload 21
    //   2548: astore 17
    //   2550: goto -225 -> 2325
    //   2553: astore 19
    //   2555: iload 4
    //   2557: istore 6
    //   2559: goto -698 -> 1861
    //   2562: astore 19
    //   2564: iload 8
    //   2566: istore 6
    //   2568: aload 25
    //   2570: astore 18
    //   2572: aload 22
    //   2574: astore 17
    //   2576: iload 7
    //   2578: istore 5
    //   2580: goto -719 -> 1861
    //   2583: astore 20
    //   2585: aload 19
    //   2587: astore 18
    //   2589: aload 20
    //   2591: astore 19
    //   2593: iload 4
    //   2595: istore 6
    //   2597: goto -736 -> 1861
    //   2600: astore 19
    //   2602: iconst_5
    //   2603: istore 5
    //   2605: goto -815 -> 1790
    //   2608: astore 19
    //   2610: goto -820 -> 1790
    //   2613: astore 21
    //   2615: aconst_null
    //   2616: astore 20
    //   2618: aload 19
    //   2620: astore 18
    //   2622: iconst_5
    //   2623: istore 5
    //   2625: aload 21
    //   2627: astore 19
    //   2629: goto -839 -> 1790
    //   2632: astore 19
    //   2634: aconst_null
    //   2635: astore 20
    //   2637: iconst_5
    //   2638: istore 5
    //   2640: goto -850 -> 1790
    //   2643: astore 19
    //   2645: iconst_5
    //   2646: istore 5
    //   2648: goto -953 -> 1695
    //   2651: astore 21
    //   2653: aload 19
    //   2655: astore 18
    //   2657: iconst_5
    //   2658: istore 5
    //   2660: aload 21
    //   2662: astore 19
    //   2664: goto -969 -> 1695
    //   2667: astore 19
    //   2669: iconst_5
    //   2670: istore 5
    //   2672: goto -977 -> 1695
    //   2675: aload 17
    //   2677: astore 19
    //   2679: aload 18
    //   2681: astore 20
    //   2683: goto -1219 -> 1464
    //   2686: goto -1399 -> 1287
    //   2689: goto -1402 -> 1287
    //   2692: goto -1871 -> 821
    //   2695: goto -1880 -> 815
    //   2698: goto -1614 -> 1084
    //   2701: iconst_2
    //   2702: istore 7
    //   2704: goto -810 -> 1894
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2707	0	paramAppInterface	AppInterface
    //   0	2707	1	paramDownloadInfo	DownloadInfo
    //   0	2707	2	paramNetworkInfo	NetworkInfo
    //   0	2707	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   257	2337	4	i1	int
    //   254	2417	5	i2	int
    //   109	2487	6	i3	int
    //   466	2237	7	i4	int
    //   454	2111	8	i5	int
    //   387	1171	9	i6	int
    //   390	557	10	i7	int
    //   923	28	11	i8	int
    //   16	1202	12	l1	long
    //   773	852	14	l2	long
    //   1708	435	16	bool	boolean
    //   34	2429	17	localObject1	Object
    //   2497	1	17	localInterruptedException	java.lang.InterruptedException
    //   2515	161	17	localObject2	Object
    //   267	573	18	localObject3	Object
    //   879	966	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1855	825	18	localObject4	Object
    //   184	1383	19	localObject5	Object
    //   1689	15	19	localIOException1	java.io.IOException
    //   1758	17	19	arrayOfString	String[]
    //   1784	65	19	localObject6	Object
    //   1851	92	19	localIOException2	java.io.IOException
    //   1995	27	19	localObject7	Object
    //   2038	1	19	localIOException3	java.io.IOException
    //   2042	156	19	localObject8	Object
    //   2204	3	19	localIOException4	java.io.IOException
    //   2214	1	19	localIOException5	java.io.IOException
    //   2218	53	19	localObject9	Object
    //   2305	3	19	localIOException6	java.io.IOException
    //   2315	19	19	localException1	Exception
    //   2379	27	19	localObject10	Object
    //   2422	1	19	localIOException7	java.io.IOException
    //   2426	1	19	localObject11	Object
    //   2443	3	19	localIOException8	java.io.IOException
    //   2531	1	19	localException2	Exception
    //   2540	1	19	localException3	Exception
    //   2553	1	19	localIOException9	java.io.IOException
    //   2562	24	19	localIOException10	java.io.IOException
    //   2591	1	19	localObject12	Object
    //   2600	1	19	localObject13	Object
    //   2608	11	19	localObject14	Object
    //   2627	1	19	localObject15	Object
    //   2632	1	19	localObject16	Object
    //   2643	11	19	localIOException11	java.io.IOException
    //   2662	1	19	localObject17	Object
    //   2667	1	19	localIOException12	java.io.IOException
    //   2677	1	19	localObject18	Object
    //   438	2088	20	localObject19	Object
    //   2583	7	20	localIOException13	java.io.IOException
    //   2616	66	20	localObject20	Object
    //   450	2097	21	localObject21	Object
    //   2613	13	21	localObject22	Object
    //   2651	10	21	localIOException14	java.io.IOException
    //   462	2111	22	localObject23	Object
    //   446	2097	23	localObject24	Object
    //   434	2077	24	localObject25	Object
    //   458	2111	25	localObject26	Object
    //   201	693	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   11	2344	27	localURL	URL
    //   25	2464	28	localObject27	Object
    //   210	218	29	localBasicHttpParams	BasicHttpParams
    //   367	1310	30	localFile	File
    //   533	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   0	13	114	java/net/MalformedURLException
    //   27	36	129	java/lang/Exception
    //   41	57	129	java/lang/Exception
    //   61	73	129	java/lang/Exception
    //   73	108	129	java/lang/Exception
    //   192	203	879	java/lang/IllegalArgumentException
    //   881	895	898	java/lang/IllegalArgumentException
    //   940	946	1689	java/io/IOException
    //   954	983	1689	java/io/IOException
    //   995	1001	1689	java/io/IOException
    //   1009	1051	1689	java/io/IOException
    //   1063	1084	1689	java/io/IOException
    //   1092	1099	1689	java/io/IOException
    //   1107	1113	1689	java/io/IOException
    //   1147	1159	1689	java/io/IOException
    //   1167	1176	1689	java/io/IOException
    //   1184	1190	1689	java/io/IOException
    //   1198	1253	1689	java/io/IOException
    //   1583	1589	1689	java/io/IOException
    //   1597	1648	1689	java/io/IOException
    //   1660	1668	1689	java/io/IOException
    //   1676	1682	1689	java/io/IOException
    //   1739	1746	1689	java/io/IOException
    //   1754	1760	1689	java/io/IOException
    //   2067	2073	1689	java/io/IOException
    //   2105	2111	1689	java/io/IOException
    //   940	946	1784	finally
    //   954	983	1784	finally
    //   995	1001	1784	finally
    //   1009	1051	1784	finally
    //   1063	1084	1784	finally
    //   1092	1099	1784	finally
    //   1107	1113	1784	finally
    //   1147	1159	1784	finally
    //   1167	1176	1784	finally
    //   1184	1190	1784	finally
    //   1198	1253	1784	finally
    //   1583	1589	1784	finally
    //   1597	1648	1784	finally
    //   1660	1668	1784	finally
    //   1676	1682	1784	finally
    //   1739	1746	1784	finally
    //   1754	1760	1784	finally
    //   2067	2073	1784	finally
    //   2105	2111	1784	finally
    //   1282	1287	1851	java/io/IOException
    //   1819	1824	1851	java/io/IOException
    //   1848	1851	1851	java/io/IOException
    //   2014	2019	2038	java/io/IOException
    //   1439	1446	2204	java/io/IOException
    //   1451	1456	2214	java/io/IOException
    //   1986	1993	2305	java/io/IOException
    //   1282	1287	2315	java/lang/Exception
    //   1819	1824	2315	java/lang/Exception
    //   1848	1851	2315	java/lang/Exception
    //   2398	2403	2422	java/io/IOException
    //   2370	2377	2443	java/io/IOException
    //   1282	1287	2453	finally
    //   1819	1824	2453	finally
    //   1848	1851	2453	finally
    //   2462	2469	2479	java/io/IOException
    //   1530	1538	2487	finally
    //   1538	1541	2487	finally
    //   2488	2491	2487	finally
    //   2473	2477	2493	java/io/IOException
    //   1530	1538	2497	java/lang/InterruptedException
    //   1723	1728	2502	finally
    //   468	490	2509	finally
    //   526	535	2509	finally
    //   571	579	2509	finally
    //   615	624	2509	finally
    //   664	677	2509	finally
    //   713	722	2509	finally
    //   766	775	2509	finally
    //   1328	1335	2509	finally
    //   1371	1381	2509	finally
    //   1421	1434	2509	finally
    //   2184	2197	2509	finally
    //   1869	1874	2520	finally
    //   1882	1890	2520	finally
    //   1902	1956	2520	finally
    //   1968	1981	2520	finally
    //   2235	2243	2520	finally
    //   2251	2259	2520	finally
    //   2270	2278	2520	finally
    //   2286	2292	2520	finally
    //   2333	2338	2520	finally
    //   2353	2365	2520	finally
    //   1723	1728	2531	java/lang/Exception
    //   468	490	2540	java/lang/Exception
    //   526	535	2540	java/lang/Exception
    //   571	579	2540	java/lang/Exception
    //   615	624	2540	java/lang/Exception
    //   664	677	2540	java/lang/Exception
    //   713	722	2540	java/lang/Exception
    //   766	775	2540	java/lang/Exception
    //   1328	1335	2540	java/lang/Exception
    //   1371	1381	2540	java/lang/Exception
    //   1421	1434	2540	java/lang/Exception
    //   2184	2197	2540	java/lang/Exception
    //   1723	1728	2553	java/io/IOException
    //   468	490	2562	java/io/IOException
    //   526	535	2562	java/io/IOException
    //   571	579	2562	java/io/IOException
    //   615	624	2562	java/io/IOException
    //   664	677	2562	java/io/IOException
    //   713	722	2562	java/io/IOException
    //   766	775	2562	java/io/IOException
    //   1328	1335	2562	java/io/IOException
    //   1371	1381	2562	java/io/IOException
    //   1421	1434	2562	java/io/IOException
    //   2184	2197	2583	java/io/IOException
    //   815	821	2600	finally
    //   830	849	2600	finally
    //   860	876	2600	finally
    //   1695	1710	2608	finally
    //   2135	2142	2608	finally
    //   781	792	2613	finally
    //   792	801	2632	finally
    //   815	821	2643	java/io/IOException
    //   830	849	2643	java/io/IOException
    //   860	876	2643	java/io/IOException
    //   781	792	2651	java/io/IOException
    //   792	801	2667	java/io/IOException
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
    //   0: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 15
    //   8: iconst_2
    //   9: ldc_w 519
    //   12: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: getstatic 184	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   18: invokevirtual 510	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   21: astore 34
    //   23: aload 34
    //   25: ifnonnull +25 -> 50
    //   28: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +12 -> 43
    //   34: ldc 15
    //   36: iconst_2
    //   37: ldc_w 521
    //   40: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: bipush 9
    //   45: istore 6
    //   47: iload 6
    //   49: ireturn
    //   50: new 225	java/net/URL
    //   53: dup
    //   54: aload_1
    //   55: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: astore 32
    //   63: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   66: lstore 17
    //   68: new 4	java/lang/Object
    //   71: dup
    //   72: invokespecial 214	java/lang/Object:<init>	()V
    //   75: astore 33
    //   77: aload_1
    //   78: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   81: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   84: astore 22
    //   86: aload 22
    //   88: ifnull +141 -> 229
    //   91: aload 22
    //   93: invokevirtual 241	java/io/File:exists	()Z
    //   96: ifne +133 -> 229
    //   99: aload 22
    //   101: invokevirtual 244	java/io/File:mkdirs	()Z
    //   104: ifne +125 -> 229
    //   107: aload_2
    //   108: ifnull +15 -> 123
    //   111: aload_2
    //   112: aload 32
    //   114: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   117: iconst_4
    //   118: invokeinterface 252 3 0
    //   123: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +32 -> 158
    //   129: ldc 15
    //   131: iconst_2
    //   132: new 254	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 523
    //   142: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iconst_4
    //   159: ireturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 268	java/net/MalformedURLException:printStackTrace	()V
    //   165: aload_1
    //   166: aload_0
    //   167: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   173: iconst_5
    //   174: ireturn
    //   175: astore_0
    //   176: aload_2
    //   177: ifnull +15 -> 192
    //   180: aload_2
    //   181: aload 32
    //   183: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   186: iconst_4
    //   187: invokeinterface 252 3 0
    //   192: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +32 -> 227
    //   198: ldc 15
    //   200: iconst_2
    //   201: new 254	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 523
    //   211: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   218: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_4
    //   228: ireturn
    //   229: aconst_null
    //   230: astore 24
    //   232: aload_1
    //   233: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   236: astore 22
    //   238: new 278	org/apache/http/client/methods/HttpGet
    //   241: dup
    //   242: aload 22
    //   244: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   247: astore 31
    //   249: new 72	org/apache/http/params/BasicHttpParams
    //   252: dup
    //   253: invokespecial 75	org/apache/http/params/BasicHttpParams:<init>	()V
    //   256: astore 35
    //   258: aload 35
    //   260: ldc_w 281
    //   263: ldc_w 282
    //   266: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: invokeinterface 293 3 0
    //   274: pop
    //   275: aload 35
    //   277: ldc_w 295
    //   280: ldc_w 282
    //   283: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: invokeinterface 293 3 0
    //   291: pop
    //   292: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   295: astore 22
    //   297: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   300: istore 7
    //   302: iconst_0
    //   303: istore 6
    //   305: aload 34
    //   307: ifnull +99 -> 406
    //   310: aload 34
    //   312: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   315: astore 23
    //   317: aload 34
    //   319: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   322: ifeq +51 -> 373
    //   325: aload 23
    //   327: ifnull +14 -> 341
    //   330: aload 23
    //   332: ldc_w 316
    //   335: invokevirtual 320	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   338: ifeq +35 -> 373
    //   341: aload 22
    //   343: ifnull +30 -> 373
    //   346: iload 7
    //   348: ifle +25 -> 373
    //   351: aload 35
    //   353: ldc_w 322
    //   356: new 324	org/apache/http/HttpHost
    //   359: dup
    //   360: aload 22
    //   362: iload 7
    //   364: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   367: invokeinterface 293 3 0
    //   372: pop
    //   373: aload 34
    //   375: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   378: ifeq +718 -> 1096
    //   381: sipush 2048
    //   384: istore 6
    //   386: aload 35
    //   388: ldc_w 328
    //   391: iload 6
    //   393: invokeinterface 332 3 0
    //   398: pop
    //   399: aload 31
    //   401: aload 35
    //   403: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   406: new 234	java/io/File
    //   409: dup
    //   410: aload_1
    //   411: invokevirtual 338	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   414: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore 36
    //   419: aload 36
    //   421: invokevirtual 241	java/io/File:exists	()Z
    //   424: ifeq +9 -> 433
    //   427: aload 36
    //   429: invokevirtual 342	java/io/File:delete	()Z
    //   432: pop
    //   433: aconst_null
    //   434: astore 22
    //   436: iconst_m1
    //   437: istore 13
    //   439: iconst_5
    //   440: istore 11
    //   442: iload 13
    //   444: ifne +38 -> 482
    //   447: aload 35
    //   449: ldc_w 322
    //   452: new 324	org/apache/http/HttpHost
    //   455: dup
    //   456: aload 32
    //   458: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   461: aload 32
    //   463: invokevirtual 348	java/net/URL:getPort	()I
    //   466: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   469: invokeinterface 293 3 0
    //   474: pop
    //   475: aload 31
    //   477: aload 35
    //   479: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   482: aload 24
    //   484: astore 28
    //   486: aload 22
    //   488: astore 25
    //   490: iload 6
    //   492: istore 9
    //   494: aload 24
    //   496: astore 29
    //   498: aload 22
    //   500: astore 26
    //   502: iload 6
    //   504: istore 10
    //   506: aload 24
    //   508: astore 30
    //   510: aload 22
    //   512: astore 27
    //   514: iload 11
    //   516: istore 8
    //   518: aload 32
    //   520: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   523: astore 23
    //   525: aload 24
    //   527: astore 28
    //   529: aload 22
    //   531: astore 25
    //   533: iload 6
    //   535: istore 9
    //   537: aload 24
    //   539: astore 29
    //   541: aload 22
    //   543: astore 26
    //   545: iload 6
    //   547: istore 10
    //   549: aload 24
    //   551: astore 30
    //   553: aload 22
    //   555: astore 27
    //   557: iload 11
    //   559: istore 8
    //   561: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +66 -> 630
    //   567: aload 24
    //   569: astore 28
    //   571: aload 22
    //   573: astore 25
    //   575: iload 6
    //   577: istore 9
    //   579: aload 24
    //   581: astore 29
    //   583: aload 22
    //   585: astore 26
    //   587: iload 6
    //   589: istore 10
    //   591: aload 24
    //   593: astore 30
    //   595: aload 22
    //   597: astore 27
    //   599: iload 11
    //   601: istore 8
    //   603: ldc 15
    //   605: iconst_2
    //   606: new 254	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 525
    //   616: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 23
    //   621: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 24
    //   632: astore 28
    //   634: aload 22
    //   636: astore 25
    //   638: iload 6
    //   640: istore 9
    //   642: aload 24
    //   644: astore 29
    //   646: aload 22
    //   648: astore 26
    //   650: iload 6
    //   652: istore 10
    //   654: aload 24
    //   656: astore 30
    //   658: aload 22
    //   660: astore 27
    //   662: iload 11
    //   664: istore 8
    //   666: getstatic 149	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   669: new 324	org/apache/http/HttpHost
    //   672: dup
    //   673: aload 23
    //   675: invokespecial 349	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   678: aload 31
    //   680: invokevirtual 353	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   683: astore 23
    //   685: aload 24
    //   687: astore 28
    //   689: aload 22
    //   691: astore 25
    //   693: iload 6
    //   695: istore 9
    //   697: aload 24
    //   699: astore 29
    //   701: aload 22
    //   703: astore 26
    //   705: iload 6
    //   707: istore 10
    //   709: aload 24
    //   711: astore 30
    //   713: aload 22
    //   715: astore 27
    //   717: iload 11
    //   719: istore 8
    //   721: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +48 -> 772
    //   727: aload 24
    //   729: astore 28
    //   731: aload 22
    //   733: astore 25
    //   735: iload 6
    //   737: istore 9
    //   739: aload 24
    //   741: astore 29
    //   743: aload 22
    //   745: astore 26
    //   747: iload 6
    //   749: istore 10
    //   751: aload 24
    //   753: astore 30
    //   755: aload 22
    //   757: astore 27
    //   759: iload 11
    //   761: istore 8
    //   763: ldc 15
    //   765: iconst_2
    //   766: ldc_w 527
    //   769: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload 24
    //   774: astore 28
    //   776: aload 22
    //   778: astore 25
    //   780: iload 6
    //   782: istore 9
    //   784: aload 24
    //   786: astore 29
    //   788: aload 22
    //   790: astore 26
    //   792: iload 6
    //   794: istore 10
    //   796: aload 24
    //   798: astore 30
    //   800: aload 22
    //   802: astore 27
    //   804: iload 11
    //   806: istore 8
    //   808: aload 23
    //   810: invokeinterface 359 1 0
    //   815: invokeinterface 368 1 0
    //   820: istore 7
    //   822: aload_2
    //   823: ifnull +52 -> 875
    //   826: aload 24
    //   828: astore 28
    //   830: aload 22
    //   832: astore 25
    //   834: iload 6
    //   836: istore 9
    //   838: aload 24
    //   840: astore 29
    //   842: aload 22
    //   844: astore 26
    //   846: iload 6
    //   848: istore 10
    //   850: aload 24
    //   852: astore 30
    //   854: aload 22
    //   856: astore 27
    //   858: iload 11
    //   860: istore 8
    //   862: aload_2
    //   863: aload 32
    //   865: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   868: iload 7
    //   870: invokeinterface 370 3 0
    //   875: aload 24
    //   877: astore 28
    //   879: aload 22
    //   881: astore 25
    //   883: iload 6
    //   885: istore 9
    //   887: aload 24
    //   889: astore 29
    //   891: aload 22
    //   893: astore 26
    //   895: iload 6
    //   897: istore 10
    //   899: aload 24
    //   901: astore 30
    //   903: aload 22
    //   905: astore 27
    //   907: iload 11
    //   909: istore 8
    //   911: aload 23
    //   913: invokeinterface 374 1 0
    //   918: astore 22
    //   920: sipush 200
    //   923: iload 7
    //   925: if_icmpne +1796 -> 2721
    //   928: aload 24
    //   930: astore 28
    //   932: aload 22
    //   934: astore 25
    //   936: iload 6
    //   938: istore 9
    //   940: aload 24
    //   942: astore 29
    //   944: aload 22
    //   946: astore 26
    //   948: iload 6
    //   950: istore 10
    //   952: aload 24
    //   954: astore 30
    //   956: aload 22
    //   958: astore 27
    //   960: iload 11
    //   962: istore 8
    //   964: aload 22
    //   966: invokeinterface 379 1 0
    //   971: lstore 19
    //   973: aconst_null
    //   974: astore 25
    //   976: iconst_0
    //   977: istore 7
    //   979: new 381	java/io/FileOutputStream
    //   982: dup
    //   983: aload 36
    //   985: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   988: astore 23
    //   990: aload 22
    //   992: invokeinterface 388 1 0
    //   997: astore 24
    //   999: iload 6
    //   1001: ifne +2357 -> 3358
    //   1004: sipush 2048
    //   1007: istore 6
    //   1009: iload 6
    //   1011: newarray byte
    //   1013: astore 25
    //   1015: iload 7
    //   1017: i2l
    //   1018: lload 19
    //   1020: lcmp
    //   1021: ifge +83 -> 1104
    //   1024: aload 24
    //   1026: aload 25
    //   1028: invokevirtual 394	java/io/InputStream:read	([B)I
    //   1031: istore 8
    //   1033: aload 23
    //   1035: aload 25
    //   1037: iconst_0
    //   1038: iload 8
    //   1040: invokevirtual 400	java/io/OutputStream:write	([BII)V
    //   1043: iload 7
    //   1045: iload 8
    //   1047: iadd
    //   1048: istore 7
    //   1050: aload_2
    //   1051: ifnull +2304 -> 3355
    //   1054: aload_2
    //   1055: aload 32
    //   1057: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1060: lload 19
    //   1062: iload 7
    //   1064: i2l
    //   1065: invokeinterface 403 6 0
    //   1070: goto -55 -> 1015
    //   1073: astore 23
    //   1075: new 278	org/apache/http/client/methods/HttpGet
    //   1078: dup
    //   1079: aload 22
    //   1081: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1084: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1087: astore 31
    //   1089: goto -840 -> 249
    //   1092: astore_0
    //   1093: bipush 13
    //   1095: ireturn
    //   1096: sipush 4096
    //   1099: istore 6
    //   1101: goto -715 -> 386
    //   1104: iload 7
    //   1106: i2l
    //   1107: lload 19
    //   1109: lcmp
    //   1110: ifne +895 -> 2005
    //   1113: iconst_0
    //   1114: istore 14
    //   1116: iconst_0
    //   1117: istore 15
    //   1119: iconst_0
    //   1120: istore 16
    //   1122: iconst_0
    //   1123: istore 11
    //   1125: iload 11
    //   1127: istore 7
    //   1129: iload 14
    //   1131: istore 9
    //   1133: iload 15
    //   1135: istore 10
    //   1137: iload 16
    //   1139: istore 8
    //   1141: aload 24
    //   1143: astore 27
    //   1145: iload 6
    //   1147: istore 12
    //   1149: aload 23
    //   1151: astore 26
    //   1153: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1156: ifeq +60 -> 1216
    //   1159: iload 14
    //   1161: istore 9
    //   1163: iload 15
    //   1165: istore 10
    //   1167: iload 16
    //   1169: istore 8
    //   1171: aload 24
    //   1173: astore 27
    //   1175: iload 6
    //   1177: istore 12
    //   1179: aload 23
    //   1181: astore 26
    //   1183: ldc 15
    //   1185: iconst_2
    //   1186: new 254	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1193: ldc_w 529
    //   1196: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload_1
    //   1200: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1203: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1212: iload 11
    //   1214: istore 7
    //   1216: iload 7
    //   1218: istore 9
    //   1220: iload 7
    //   1222: istore 10
    //   1224: iload 7
    //   1226: istore 8
    //   1228: aload 24
    //   1230: astore 27
    //   1232: iload 6
    //   1234: istore 12
    //   1236: aload 23
    //   1238: astore 26
    //   1240: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1243: ifeq +69 -> 1312
    //   1246: iload 7
    //   1248: istore 9
    //   1250: iload 7
    //   1252: istore 10
    //   1254: iload 7
    //   1256: istore 8
    //   1258: aload 24
    //   1260: astore 27
    //   1262: iload 6
    //   1264: istore 12
    //   1266: aload 23
    //   1268: astore 26
    //   1270: ldc_w 410
    //   1273: iconst_2
    //   1274: new 254	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1281: ldc_w 531
    //   1284: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1290: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1293: ldc_w 533
    //   1296: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: aload_1
    //   1300: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1303: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: iload 7
    //   1314: istore 9
    //   1316: iload 7
    //   1318: istore 10
    //   1320: iload 7
    //   1322: istore 8
    //   1324: aload 24
    //   1326: astore 27
    //   1328: iload 6
    //   1330: istore 12
    //   1332: aload 23
    //   1334: astore 26
    //   1336: aload 4
    //   1338: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1341: ifne +158 -> 1499
    //   1344: iload 7
    //   1346: istore 9
    //   1348: iload 7
    //   1350: istore 10
    //   1352: iload 7
    //   1354: istore 8
    //   1356: aload 24
    //   1358: astore 27
    //   1360: iload 6
    //   1362: istore 12
    //   1364: aload 23
    //   1366: astore 26
    //   1368: aload 5
    //   1370: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1373: ifne +126 -> 1499
    //   1376: iload 7
    //   1378: istore 9
    //   1380: iload 7
    //   1382: istore 10
    //   1384: iload 7
    //   1386: istore 8
    //   1388: aload 24
    //   1390: astore 27
    //   1392: iload 6
    //   1394: istore 12
    //   1396: aload 23
    //   1398: astore 26
    //   1400: aload 34
    //   1402: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1405: ifeq +837 -> 2242
    //   1408: iload 7
    //   1410: istore 9
    //   1412: iload 7
    //   1414: istore 10
    //   1416: iload 7
    //   1418: istore 8
    //   1420: aload 24
    //   1422: astore 27
    //   1424: iload 6
    //   1426: istore 12
    //   1428: aload 23
    //   1430: astore 26
    //   1432: iconst_3
    //   1433: anewarray 270	java/lang/String
    //   1436: astore 25
    //   1438: aload 25
    //   1440: iconst_0
    //   1441: aload 4
    //   1443: aastore
    //   1444: aload 25
    //   1446: iconst_1
    //   1447: ldc_w 423
    //   1450: aastore
    //   1451: aload 25
    //   1453: iconst_2
    //   1454: ldc_w 425
    //   1457: aastore
    //   1458: aload 25
    //   1460: ifnull +39 -> 1499
    //   1463: iload 7
    //   1465: istore 9
    //   1467: iload 7
    //   1469: istore 10
    //   1471: iload 7
    //   1473: istore 8
    //   1475: aload 24
    //   1477: astore 27
    //   1479: iload 6
    //   1481: istore 12
    //   1483: aload 23
    //   1485: astore 26
    //   1487: aload_0
    //   1488: aload_0
    //   1489: invokevirtual 428	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1492: aload 25
    //   1494: lload 19
    //   1496: invokevirtual 431	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1499: iload 7
    //   1501: istore 9
    //   1503: iload 7
    //   1505: istore 10
    //   1507: iload 7
    //   1509: istore 8
    //   1511: aload 24
    //   1513: astore 27
    //   1515: iload 6
    //   1517: istore 12
    //   1519: aload 23
    //   1521: astore 26
    //   1523: aload 36
    //   1525: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1528: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   1531: pop
    //   1532: iload 7
    //   1534: istore 9
    //   1536: iload 7
    //   1538: istore 10
    //   1540: iload 7
    //   1542: istore 8
    //   1544: aload 24
    //   1546: astore 27
    //   1548: iload 6
    //   1550: istore 12
    //   1552: aload 23
    //   1554: astore 26
    //   1556: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1559: ifeq +82 -> 1641
    //   1562: iload 7
    //   1564: istore 9
    //   1566: iload 7
    //   1568: istore 10
    //   1570: iload 7
    //   1572: istore 8
    //   1574: aload 24
    //   1576: astore 27
    //   1578: iload 6
    //   1580: istore 12
    //   1582: aload 23
    //   1584: astore 26
    //   1586: ldc 15
    //   1588: iconst_2
    //   1589: new 254	java/lang/StringBuilder
    //   1592: dup
    //   1593: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1596: ldc_w 437
    //   1599: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1605: lload 17
    //   1607: lsub
    //   1608: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1611: ldc_w 439
    //   1614: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: lload 19
    //   1619: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1622: ldc_w 441
    //   1625: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: aload_1
    //   1629: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1632: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1638: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1641: aload 24
    //   1643: ifnull +1709 -> 3352
    //   1646: iload 7
    //   1648: istore 10
    //   1650: iload 6
    //   1652: istore 9
    //   1654: aload 23
    //   1656: astore 28
    //   1658: iload 6
    //   1660: istore 8
    //   1662: aload 23
    //   1664: astore 26
    //   1666: aload 23
    //   1668: astore 27
    //   1670: aload 24
    //   1672: invokevirtual 446	java/io/InputStream:close	()V
    //   1675: iload 7
    //   1677: ifne +92 -> 1769
    //   1680: aload 23
    //   1682: astore 28
    //   1684: aload 22
    //   1686: astore 25
    //   1688: iload 6
    //   1690: istore 9
    //   1692: aload 23
    //   1694: astore 29
    //   1696: aload 22
    //   1698: astore 26
    //   1700: iload 6
    //   1702: istore 10
    //   1704: aload 23
    //   1706: astore 30
    //   1708: aload 22
    //   1710: astore 27
    //   1712: iload 7
    //   1714: istore 8
    //   1716: aload_1
    //   1717: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1720: ifnull +49 -> 1769
    //   1723: aload 23
    //   1725: astore 28
    //   1727: aload 22
    //   1729: astore 25
    //   1731: iload 6
    //   1733: istore 9
    //   1735: aload 23
    //   1737: astore 29
    //   1739: aload 22
    //   1741: astore 26
    //   1743: iload 6
    //   1745: istore 10
    //   1747: aload 23
    //   1749: astore 30
    //   1751: aload 22
    //   1753: astore 27
    //   1755: iload 7
    //   1757: istore 8
    //   1759: aload 36
    //   1761: aload_1
    //   1762: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1765: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1768: pop
    //   1769: aload_2
    //   1770: ifnull +52 -> 1822
    //   1773: aload 23
    //   1775: astore 28
    //   1777: aload 22
    //   1779: astore 25
    //   1781: iload 6
    //   1783: istore 9
    //   1785: aload 23
    //   1787: astore 29
    //   1789: aload 22
    //   1791: astore 26
    //   1793: iload 6
    //   1795: istore 10
    //   1797: aload 23
    //   1799: astore 30
    //   1801: aload 22
    //   1803: astore 27
    //   1805: iload 7
    //   1807: istore 8
    //   1809: aload_2
    //   1810: aload 32
    //   1812: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1815: iload 7
    //   1817: invokeinterface 252 3 0
    //   1822: aload 22
    //   1824: ifnull +10 -> 1834
    //   1827: aload 22
    //   1829: invokeinterface 453 1 0
    //   1834: aload 23
    //   1836: ifnull +1491 -> 3327
    //   1839: aload 23
    //   1841: invokevirtual 454	java/io/OutputStream:close	()V
    //   1844: iload 7
    //   1846: istore 8
    //   1848: aload 23
    //   1850: astore 25
    //   1852: iload 6
    //   1854: istore 7
    //   1856: aload 22
    //   1858: astore 24
    //   1860: iload 13
    //   1862: iconst_1
    //   1863: iadd
    //   1864: istore 13
    //   1866: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1869: ifeq +43 -> 1912
    //   1872: ldc 15
    //   1874: iconst_2
    //   1875: new 254	java/lang/StringBuilder
    //   1878: dup
    //   1879: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1882: ldc_w 456
    //   1885: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: iload 8
    //   1890: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1893: ldc_w 461
    //   1896: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: aload_1
    //   1900: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1903: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1909: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1912: iload 13
    //   1914: iconst_2
    //   1915: if_icmpge +22 -> 1937
    //   1918: iload 8
    //   1920: ifeq +17 -> 1937
    //   1923: aload 33
    //   1925: monitorenter
    //   1926: aload 33
    //   1928: ldc2_w 462
    //   1931: invokevirtual 467	java/lang/Object:wait	(J)V
    //   1934: aload 33
    //   1936: monitorexit
    //   1937: iload 8
    //   1939: ifeq +9 -> 1948
    //   1942: iload 13
    //   1944: iconst_2
    //   1945: if_icmplt +1367 -> 3312
    //   1948: iload 8
    //   1950: istore 6
    //   1952: iload 8
    //   1954: ifne -1907 -> 47
    //   1957: iload 8
    //   1959: istore 6
    //   1961: aload_3
    //   1962: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1965: ifne -1918 -> 47
    //   1968: bipush 18
    //   1970: istore 7
    //   1972: aload_1
    //   1973: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1976: invokevirtual 542	java/io/File:getPath	()Ljava/lang/String;
    //   1979: aload_3
    //   1980: invokestatic 547	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1983: iload 7
    //   1985: istore 6
    //   1987: iload 7
    //   1989: bipush 18
    //   1991: if_icmpne -1944 -> 47
    //   1994: aload_1
    //   1995: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1998: invokevirtual 342	java/io/File:delete	()Z
    //   2001: pop
    //   2002: iload 7
    //   2004: ireturn
    //   2005: bipush 8
    //   2007: istore 11
    //   2009: iload 11
    //   2011: istore 9
    //   2013: iload 11
    //   2015: istore 10
    //   2017: iload 11
    //   2019: istore 8
    //   2021: aload 24
    //   2023: astore 27
    //   2025: iload 6
    //   2027: istore 12
    //   2029: aload 23
    //   2031: astore 26
    //   2033: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2036: ifeq +78 -> 2114
    //   2039: iload 11
    //   2041: istore 9
    //   2043: iload 11
    //   2045: istore 10
    //   2047: iload 11
    //   2049: istore 8
    //   2051: aload 24
    //   2053: astore 27
    //   2055: iload 6
    //   2057: istore 12
    //   2059: aload 23
    //   2061: astore 26
    //   2063: ldc 15
    //   2065: iconst_2
    //   2066: new 254	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2073: ldc_w 549
    //   2076: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2079: iload 7
    //   2081: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2084: ldc_w 551
    //   2087: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: lload 19
    //   2092: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2095: ldc_w 553
    //   2098: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: aload_1
    //   2102: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2105: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2111: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2114: iload 11
    //   2116: istore 7
    //   2118: iload 11
    //   2120: istore 9
    //   2122: iload 11
    //   2124: istore 10
    //   2126: iload 11
    //   2128: istore 8
    //   2130: aload 24
    //   2132: astore 27
    //   2134: iload 6
    //   2136: istore 12
    //   2138: aload 23
    //   2140: astore 26
    //   2142: aload 36
    //   2144: invokevirtual 241	java/io/File:exists	()Z
    //   2147: ifeq -931 -> 1216
    //   2150: iload 11
    //   2152: istore 9
    //   2154: iload 11
    //   2156: istore 10
    //   2158: iload 11
    //   2160: istore 8
    //   2162: aload 24
    //   2164: astore 27
    //   2166: iload 6
    //   2168: istore 12
    //   2170: aload 23
    //   2172: astore 26
    //   2174: aload 36
    //   2176: invokevirtual 342	java/io/File:delete	()Z
    //   2179: pop
    //   2180: iload 11
    //   2182: istore 7
    //   2184: goto -968 -> 1216
    //   2187: astore 26
    //   2189: iload 9
    //   2191: istore 7
    //   2193: aload 24
    //   2195: astore 25
    //   2197: aload 26
    //   2199: astore 24
    //   2201: aload 24
    //   2203: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2206: aload 24
    //   2208: instanceof 475
    //   2211: ifne +15 -> 2226
    //   2214: aload 24
    //   2216: instanceof 477
    //   2219: istore 21
    //   2221: iload 21
    //   2223: ifeq +173 -> 2396
    //   2226: iconst_3
    //   2227: istore 7
    //   2229: aload 25
    //   2231: ifnull +1118 -> 3349
    //   2234: aload 25
    //   2236: invokevirtual 446	java/io/InputStream:close	()V
    //   2239: goto -564 -> 1675
    //   2242: iload 7
    //   2244: istore 9
    //   2246: iload 7
    //   2248: istore 10
    //   2250: iload 7
    //   2252: istore 8
    //   2254: aload 24
    //   2256: astore 27
    //   2258: iload 6
    //   2260: istore 12
    //   2262: aload 23
    //   2264: astore 26
    //   2266: iconst_3
    //   2267: anewarray 270	java/lang/String
    //   2270: astore 25
    //   2272: aload 25
    //   2274: iconst_0
    //   2275: aload 5
    //   2277: aastore
    //   2278: aload 25
    //   2280: iconst_1
    //   2281: ldc_w 498
    //   2284: aastore
    //   2285: aload 25
    //   2287: iconst_2
    //   2288: ldc_w 425
    //   2291: aastore
    //   2292: goto -834 -> 1458
    //   2295: astore 25
    //   2297: iload 10
    //   2299: istore 7
    //   2301: iload 7
    //   2303: istore 8
    //   2305: aload 24
    //   2307: astore 27
    //   2309: iload 6
    //   2311: istore 12
    //   2313: aload 23
    //   2315: astore 26
    //   2317: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2320: ifeq +48 -> 2368
    //   2323: iload 7
    //   2325: istore 8
    //   2327: aload 24
    //   2329: astore 27
    //   2331: iload 6
    //   2333: istore 12
    //   2335: aload 23
    //   2337: astore 26
    //   2339: ldc 15
    //   2341: iconst_2
    //   2342: new 254	java/lang/StringBuilder
    //   2345: dup
    //   2346: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2349: ldc_w 555
    //   2352: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: aload 32
    //   2357: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2360: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2363: aload 25
    //   2365: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2368: iconst_5
    //   2369: istore 7
    //   2371: aload 24
    //   2373: ifnull +973 -> 3346
    //   2376: iload 6
    //   2378: istore 8
    //   2380: aload 23
    //   2382: astore 26
    //   2384: aload 23
    //   2386: astore 27
    //   2388: aload 24
    //   2390: invokevirtual 446	java/io/InputStream:close	()V
    //   2393: goto -718 -> 1675
    //   2396: aload 24
    //   2398: instanceof 502
    //   2401: istore 21
    //   2403: iload 21
    //   2405: ifeq +10 -> 2415
    //   2408: bipush 11
    //   2410: istore 7
    //   2412: goto -183 -> 2229
    //   2415: iconst_4
    //   2416: istore 7
    //   2418: goto -189 -> 2229
    //   2421: astore 26
    //   2423: iconst_5
    //   2424: istore 7
    //   2426: aload 24
    //   2428: astore 25
    //   2430: aload 26
    //   2432: astore 24
    //   2434: aload 25
    //   2436: ifnull +32 -> 2468
    //   2439: iload 7
    //   2441: istore 10
    //   2443: iload 6
    //   2445: istore 9
    //   2447: aload 23
    //   2449: astore 28
    //   2451: iload 6
    //   2453: istore 8
    //   2455: aload 23
    //   2457: astore 26
    //   2459: aload 23
    //   2461: astore 27
    //   2463: aload 25
    //   2465: invokevirtual 446	java/io/InputStream:close	()V
    //   2468: iload 7
    //   2470: istore 10
    //   2472: iload 6
    //   2474: istore 9
    //   2476: aload 23
    //   2478: astore 28
    //   2480: iload 6
    //   2482: istore 8
    //   2484: aload 23
    //   2486: astore 26
    //   2488: aload 23
    //   2490: astore 27
    //   2492: aload 24
    //   2494: athrow
    //   2495: astore 24
    //   2497: aload 28
    //   2499: astore 23
    //   2501: iload 10
    //   2503: istore 7
    //   2505: iload 9
    //   2507: istore 6
    //   2509: aload 22
    //   2511: astore 26
    //   2513: aload 23
    //   2515: astore 25
    //   2517: aload 24
    //   2519: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2522: aload 22
    //   2524: astore 26
    //   2526: aload 23
    //   2528: astore 25
    //   2530: aload 24
    //   2532: instanceof 482
    //   2535: ifeq +261 -> 2796
    //   2538: bipush 10
    //   2540: istore 9
    //   2542: aload 22
    //   2544: astore 26
    //   2546: aload 23
    //   2548: astore 25
    //   2550: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2553: ifeq +65 -> 2618
    //   2556: aload 22
    //   2558: astore 26
    //   2560: aload 23
    //   2562: astore 25
    //   2564: ldc 15
    //   2566: iconst_2
    //   2567: new 254	java/lang/StringBuilder
    //   2570: dup
    //   2571: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2574: ldc_w 484
    //   2577: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: iload 9
    //   2582: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2585: ldc_w 486
    //   2588: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: aload_1
    //   2592: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2595: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2598: ldc_w 488
    //   2601: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2604: aload 24
    //   2606: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2609: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2615: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2618: aload_2
    //   2619: ifnull +24 -> 2643
    //   2622: aload 22
    //   2624: astore 26
    //   2626: aload 23
    //   2628: astore 25
    //   2630: aload_2
    //   2631: aload 32
    //   2633: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2636: iload 9
    //   2638: invokeinterface 252 3 0
    //   2643: aload 22
    //   2645: ifnull +10 -> 2655
    //   2648: aload 22
    //   2650: invokeinterface 453 1 0
    //   2655: aload 22
    //   2657: astore 24
    //   2659: iload 6
    //   2661: istore 7
    //   2663: aload 23
    //   2665: astore 25
    //   2667: iload 9
    //   2669: istore 8
    //   2671: aload 23
    //   2673: ifnull -813 -> 1860
    //   2676: aload 23
    //   2678: invokevirtual 454	java/io/OutputStream:close	()V
    //   2681: aload 22
    //   2683: astore 24
    //   2685: iload 6
    //   2687: istore 7
    //   2689: aload 23
    //   2691: astore 25
    //   2693: iload 9
    //   2695: istore 8
    //   2697: goto -837 -> 1860
    //   2700: astore 24
    //   2702: aload 22
    //   2704: astore 24
    //   2706: iload 6
    //   2708: istore 7
    //   2710: aload 23
    //   2712: astore 25
    //   2714: iload 9
    //   2716: istore 8
    //   2718: goto -858 -> 1860
    //   2721: aload_2
    //   2722: ifnull +36 -> 2758
    //   2725: aload 24
    //   2727: astore 28
    //   2729: aload 22
    //   2731: astore 25
    //   2733: iload 6
    //   2735: istore 9
    //   2737: aload 24
    //   2739: astore 29
    //   2741: aload 22
    //   2743: astore 26
    //   2745: aload_2
    //   2746: aload 32
    //   2748: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2751: iload 7
    //   2753: invokeinterface 252 3 0
    //   2758: aload 24
    //   2760: astore 23
    //   2762: goto -940 -> 1822
    //   2765: astore 24
    //   2767: aload 24
    //   2769: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2772: goto -938 -> 1834
    //   2775: astore 24
    //   2777: iload 7
    //   2779: istore 8
    //   2781: aload 22
    //   2783: astore 24
    //   2785: iload 6
    //   2787: istore 7
    //   2789: aload 23
    //   2791: astore 25
    //   2793: goto -933 -> 1860
    //   2796: aload 22
    //   2798: astore 26
    //   2800: aload 23
    //   2802: astore 25
    //   2804: aload 24
    //   2806: instanceof 475
    //   2809: ifne +552 -> 3361
    //   2812: aload 22
    //   2814: astore 26
    //   2816: aload 23
    //   2818: astore 25
    //   2820: aload 24
    //   2822: instanceof 477
    //   2825: ifeq +6 -> 2831
    //   2828: goto +533 -> 3361
    //   2831: aload 22
    //   2833: astore 26
    //   2835: aload 23
    //   2837: astore 25
    //   2839: aload 24
    //   2841: instanceof 502
    //   2844: ifeq +24 -> 2868
    //   2847: aload 22
    //   2849: astore 26
    //   2851: aload 23
    //   2853: astore 25
    //   2855: aload_1
    //   2856: bipush 11
    //   2858: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2861: iload 7
    //   2863: istore 9
    //   2865: goto -323 -> 2542
    //   2868: iconst_4
    //   2869: istore 9
    //   2871: goto -329 -> 2542
    //   2874: astore 24
    //   2876: aload 24
    //   2878: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2881: goto -226 -> 2655
    //   2884: astore 24
    //   2886: iload 8
    //   2888: istore 6
    //   2890: aload 26
    //   2892: astore 23
    //   2894: aload 22
    //   2896: astore 26
    //   2898: aload 23
    //   2900: astore 25
    //   2902: aload 24
    //   2904: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   2907: iconst_5
    //   2908: istore 9
    //   2910: aload_2
    //   2911: ifnull +23 -> 2934
    //   2914: aload 22
    //   2916: astore 26
    //   2918: aload 23
    //   2920: astore 25
    //   2922: aload_2
    //   2923: aload 32
    //   2925: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2928: iconst_5
    //   2929: invokeinterface 252 3 0
    //   2934: aload 22
    //   2936: ifnull +10 -> 2946
    //   2939: aload 22
    //   2941: invokeinterface 453 1 0
    //   2946: aload 22
    //   2948: astore 24
    //   2950: iload 6
    //   2952: istore 7
    //   2954: aload 23
    //   2956: astore 25
    //   2958: iload 9
    //   2960: istore 8
    //   2962: aload 23
    //   2964: ifnull -1104 -> 1860
    //   2967: aload 23
    //   2969: invokevirtual 454	java/io/OutputStream:close	()V
    //   2972: aload 22
    //   2974: astore 24
    //   2976: iload 6
    //   2978: istore 7
    //   2980: aload 23
    //   2982: astore 25
    //   2984: iload 9
    //   2986: istore 8
    //   2988: goto -1128 -> 1860
    //   2991: astore 24
    //   2993: aload 22
    //   2995: astore 24
    //   2997: iload 6
    //   2999: istore 7
    //   3001: aload 23
    //   3003: astore 25
    //   3005: iload 9
    //   3007: istore 8
    //   3009: goto -1149 -> 1860
    //   3012: astore 24
    //   3014: aload 24
    //   3016: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   3019: goto -73 -> 2946
    //   3022: astore_0
    //   3023: aload 27
    //   3025: astore_1
    //   3026: aload 22
    //   3028: ifnull +10 -> 3038
    //   3031: aload 22
    //   3033: invokeinterface 453 1 0
    //   3038: aload_1
    //   3039: ifnull +7 -> 3046
    //   3042: aload_1
    //   3043: invokevirtual 454	java/io/OutputStream:close	()V
    //   3046: aload_0
    //   3047: athrow
    //   3048: astore_2
    //   3049: aload_2
    //   3050: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   3053: goto -15 -> 3038
    //   3056: astore_0
    //   3057: aload 33
    //   3059: monitorexit
    //   3060: aload_0
    //   3061: athrow
    //   3062: astore_0
    //   3063: aload_0
    //   3064: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   3067: bipush 17
    //   3069: istore 7
    //   3071: goto -1088 -> 1983
    //   3074: astore_1
    //   3075: goto -29 -> 3046
    //   3078: astore 22
    //   3080: goto -1146 -> 1934
    //   3083: astore_0
    //   3084: aload 23
    //   3086: astore_1
    //   3087: goto -61 -> 3026
    //   3090: astore_0
    //   3091: aload 28
    //   3093: astore_1
    //   3094: aload 25
    //   3096: astore 22
    //   3098: goto -72 -> 3026
    //   3101: astore_0
    //   3102: aload 26
    //   3104: astore 22
    //   3106: aload 25
    //   3108: astore_1
    //   3109: goto -83 -> 3026
    //   3112: astore 24
    //   3114: goto -220 -> 2894
    //   3117: astore 24
    //   3119: iload 9
    //   3121: istore 6
    //   3123: aload 29
    //   3125: astore 23
    //   3127: aload 26
    //   3129: astore 22
    //   3131: goto -237 -> 2894
    //   3134: astore 24
    //   3136: goto -627 -> 2509
    //   3139: astore 24
    //   3141: goto -632 -> 2509
    //   3144: astore 24
    //   3146: iload 10
    //   3148: istore 6
    //   3150: aload 30
    //   3152: astore 23
    //   3154: aload 27
    //   3156: astore 22
    //   3158: iload 8
    //   3160: istore 7
    //   3162: goto -653 -> 2509
    //   3165: astore 25
    //   3167: aload 24
    //   3169: astore 23
    //   3171: aload 25
    //   3173: astore 24
    //   3175: goto -666 -> 2509
    //   3178: astore 24
    //   3180: iload 8
    //   3182: istore 7
    //   3184: aload 27
    //   3186: astore 25
    //   3188: iload 12
    //   3190: istore 6
    //   3192: aload 26
    //   3194: astore 23
    //   3196: goto -762 -> 2434
    //   3199: astore 24
    //   3201: goto -767 -> 2434
    //   3204: astore 26
    //   3206: aconst_null
    //   3207: astore 25
    //   3209: aload 24
    //   3211: astore 23
    //   3213: iconst_5
    //   3214: istore 7
    //   3216: aload 26
    //   3218: astore 24
    //   3220: goto -786 -> 2434
    //   3223: astore 24
    //   3225: aconst_null
    //   3226: astore 25
    //   3228: iconst_5
    //   3229: istore 7
    //   3231: goto -797 -> 2434
    //   3234: astore 25
    //   3236: iconst_5
    //   3237: istore 7
    //   3239: goto -938 -> 2301
    //   3242: astore 25
    //   3244: aconst_null
    //   3245: astore 26
    //   3247: aload 24
    //   3249: astore 23
    //   3251: iconst_5
    //   3252: istore 7
    //   3254: aload 26
    //   3256: astore 24
    //   3258: goto -957 -> 2301
    //   3261: astore 25
    //   3263: aconst_null
    //   3264: astore 24
    //   3266: iconst_5
    //   3267: istore 7
    //   3269: goto -968 -> 2301
    //   3272: astore 26
    //   3274: aload 24
    //   3276: astore 25
    //   3278: iconst_5
    //   3279: istore 7
    //   3281: aload 26
    //   3283: astore 24
    //   3285: goto -1084 -> 2201
    //   3288: astore 26
    //   3290: aload 24
    //   3292: astore 23
    //   3294: iconst_5
    //   3295: istore 7
    //   3297: aload 26
    //   3299: astore 24
    //   3301: goto -1100 -> 2201
    //   3304: astore 24
    //   3306: iconst_5
    //   3307: istore 7
    //   3309: goto -1108 -> 2201
    //   3312: aload 24
    //   3314: astore 22
    //   3316: aload 25
    //   3318: astore 24
    //   3320: iload 7
    //   3322: istore 6
    //   3324: goto -2885 -> 439
    //   3327: iload 7
    //   3329: istore 8
    //   3331: aload 22
    //   3333: astore 24
    //   3335: iload 6
    //   3337: istore 7
    //   3339: aload 23
    //   3341: astore 25
    //   3343: goto -1483 -> 1860
    //   3346: goto -1671 -> 1675
    //   3349: goto -1674 -> 1675
    //   3352: goto -1677 -> 1675
    //   3355: goto -2340 -> 1015
    //   3358: goto -2349 -> 1009
    //   3361: iconst_2
    //   3362: istore 9
    //   3364: goto -822 -> 2542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3367	0	paramAppInterface	AppInterface
    //   0	3367	1	paramDownloadInfo	DownloadInfo
    //   0	3367	2	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   0	3367	3	paramString1	String
    //   0	3367	4	paramString2	String
    //   0	3367	5	paramString3	String
    //   45	3291	6	i1	int
    //   300	3038	7	i2	int
    //   516	2814	8	i3	int
    //   492	2871	9	i4	int
    //   504	2643	10	i5	int
    //   440	1741	11	i6	int
    //   1147	2042	12	i7	int
    //   437	1509	13	i8	int
    //   1114	46	14	i9	int
    //   1117	47	15	i10	int
    //   1120	48	16	i11	int
    //   66	1540	17	l1	long
    //   971	1120	19	l2	long
    //   2219	185	21	bool	boolean
    //   84	2948	22	localObject1	Object
    //   3078	1	22	localInterruptedException	java.lang.InterruptedException
    //   3096	236	22	localObject2	Object
    //   315	719	23	localObject3	Object
    //   1073	1416	23	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   2499	841	23	localObject4	Object
    //   230	2263	24	localObject5	Object
    //   2495	110	24	localIOException1	java.io.IOException
    //   2657	27	24	localObject6	Object
    //   2700	1	24	localIOException2	java.io.IOException
    //   2704	55	24	localObject7	Object
    //   2765	3	24	localIOException3	java.io.IOException
    //   2775	1	24	localIOException4	java.io.IOException
    //   2783	57	24	localObject8	Object
    //   2874	3	24	localIOException5	java.io.IOException
    //   2884	19	24	localException1	Exception
    //   2948	27	24	localObject9	Object
    //   2991	1	24	localIOException6	java.io.IOException
    //   2995	1	24	localObject10	Object
    //   3012	3	24	localIOException7	java.io.IOException
    //   3112	1	24	localException2	Exception
    //   3117	1	24	localException3	Exception
    //   3134	1	24	localIOException8	java.io.IOException
    //   3139	1	24	localIOException9	java.io.IOException
    //   3144	24	24	localIOException10	java.io.IOException
    //   3173	1	24	localObject11	Object
    //   3178	1	24	localObject12	Object
    //   3199	11	24	localObject13	Object
    //   3218	1	24	localObject14	Object
    //   3223	25	24	localObject15	Object
    //   3256	44	24	localObject16	Object
    //   3304	9	24	localIOException11	java.io.IOException
    //   3318	16	24	localObject17	Object
    //   488	1798	25	localObject18	Object
    //   2295	69	25	localThrowable1	java.lang.Throwable
    //   2428	679	25	localObject19	Object
    //   3165	7	25	localIOException12	java.io.IOException
    //   3186	41	25	localObject20	Object
    //   3234	1	25	localThrowable2	java.lang.Throwable
    //   3242	1	25	localThrowable3	java.lang.Throwable
    //   3261	1	25	localThrowable4	java.lang.Throwable
    //   3276	66	25	localObject21	Object
    //   500	1673	26	localObject22	Object
    //   2187	11	26	localIOException13	java.io.IOException
    //   2264	119	26	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   2421	10	26	localObject23	Object
    //   2457	736	26	localObject24	Object
    //   3204	13	26	localObject25	Object
    //   3245	10	26	localObject26	Object
    //   3272	10	26	localIOException14	java.io.IOException
    //   3288	10	26	localIOException15	java.io.IOException
    //   512	2673	27	localObject27	Object
    //   484	2608	28	localObject28	Object
    //   496	2628	29	localObject29	Object
    //   508	2643	30	localObject30	Object
    //   247	841	31	localHttpGet	org.apache.http.client.methods.HttpGet
    //   61	2863	32	localURL	URL
    //   75	2983	33	localObject31	Object
    //   21	1380	34	localNetworkInfo	NetworkInfo
    //   256	222	35	localBasicHttpParams	BasicHttpParams
    //   417	1758	36	localFile	File
    // Exception table:
    //   from	to	target	type
    //   50	63	160	java/net/MalformedURLException
    //   77	86	175	java/lang/Exception
    //   91	107	175	java/lang/Exception
    //   111	123	175	java/lang/Exception
    //   123	158	175	java/lang/Exception
    //   238	249	1073	java/lang/IllegalArgumentException
    //   1075	1089	1092	java/lang/IllegalArgumentException
    //   1153	1159	2187	java/io/IOException
    //   1183	1212	2187	java/io/IOException
    //   1240	1246	2187	java/io/IOException
    //   1270	1312	2187	java/io/IOException
    //   1336	1344	2187	java/io/IOException
    //   1368	1376	2187	java/io/IOException
    //   1400	1408	2187	java/io/IOException
    //   1432	1438	2187	java/io/IOException
    //   1487	1499	2187	java/io/IOException
    //   1523	1532	2187	java/io/IOException
    //   1556	1562	2187	java/io/IOException
    //   1586	1641	2187	java/io/IOException
    //   2033	2039	2187	java/io/IOException
    //   2063	2114	2187	java/io/IOException
    //   2142	2150	2187	java/io/IOException
    //   2174	2180	2187	java/io/IOException
    //   2266	2272	2187	java/io/IOException
    //   1153	1159	2295	java/lang/Throwable
    //   1183	1212	2295	java/lang/Throwable
    //   1240	1246	2295	java/lang/Throwable
    //   1270	1312	2295	java/lang/Throwable
    //   1336	1344	2295	java/lang/Throwable
    //   1368	1376	2295	java/lang/Throwable
    //   1400	1408	2295	java/lang/Throwable
    //   1432	1438	2295	java/lang/Throwable
    //   1487	1499	2295	java/lang/Throwable
    //   1523	1532	2295	java/lang/Throwable
    //   1556	1562	2295	java/lang/Throwable
    //   1586	1641	2295	java/lang/Throwable
    //   2033	2039	2295	java/lang/Throwable
    //   2063	2114	2295	java/lang/Throwable
    //   2142	2150	2295	java/lang/Throwable
    //   2174	2180	2295	java/lang/Throwable
    //   2266	2272	2295	java/lang/Throwable
    //   1009	1015	2421	finally
    //   1024	1043	2421	finally
    //   1054	1070	2421	finally
    //   1670	1675	2495	java/io/IOException
    //   2463	2468	2495	java/io/IOException
    //   2492	2495	2495	java/io/IOException
    //   2676	2681	2700	java/io/IOException
    //   1827	1834	2765	java/io/IOException
    //   1839	1844	2775	java/io/IOException
    //   2648	2655	2874	java/io/IOException
    //   1670	1675	2884	java/lang/Exception
    //   2388	2393	2884	java/lang/Exception
    //   2463	2468	2884	java/lang/Exception
    //   2492	2495	2884	java/lang/Exception
    //   2967	2972	2991	java/io/IOException
    //   2939	2946	3012	java/io/IOException
    //   1670	1675	3022	finally
    //   2388	2393	3022	finally
    //   2463	2468	3022	finally
    //   2492	2495	3022	finally
    //   3031	3038	3048	java/io/IOException
    //   1926	1934	3056	finally
    //   1934	1937	3056	finally
    //   3057	3060	3056	finally
    //   1972	1983	3062	java/io/IOException
    //   3042	3046	3074	java/io/IOException
    //   1926	1934	3078	java/lang/InterruptedException
    //   2234	2239	3083	finally
    //   518	525	3090	finally
    //   561	567	3090	finally
    //   603	630	3090	finally
    //   666	685	3090	finally
    //   721	727	3090	finally
    //   763	772	3090	finally
    //   808	822	3090	finally
    //   862	875	3090	finally
    //   911	920	3090	finally
    //   964	973	3090	finally
    //   1716	1723	3090	finally
    //   1759	1769	3090	finally
    //   1809	1822	3090	finally
    //   2745	2758	3090	finally
    //   2517	2522	3101	finally
    //   2530	2538	3101	finally
    //   2550	2556	3101	finally
    //   2564	2618	3101	finally
    //   2630	2643	3101	finally
    //   2804	2812	3101	finally
    //   2820	2828	3101	finally
    //   2839	2847	3101	finally
    //   2855	2861	3101	finally
    //   2902	2907	3101	finally
    //   2922	2934	3101	finally
    //   2234	2239	3112	java/lang/Exception
    //   518	525	3117	java/lang/Exception
    //   561	567	3117	java/lang/Exception
    //   603	630	3117	java/lang/Exception
    //   666	685	3117	java/lang/Exception
    //   721	727	3117	java/lang/Exception
    //   763	772	3117	java/lang/Exception
    //   808	822	3117	java/lang/Exception
    //   862	875	3117	java/lang/Exception
    //   911	920	3117	java/lang/Exception
    //   964	973	3117	java/lang/Exception
    //   1716	1723	3117	java/lang/Exception
    //   1759	1769	3117	java/lang/Exception
    //   1809	1822	3117	java/lang/Exception
    //   2745	2758	3117	java/lang/Exception
    //   2234	2239	3134	java/io/IOException
    //   2388	2393	3139	java/io/IOException
    //   518	525	3144	java/io/IOException
    //   561	567	3144	java/io/IOException
    //   603	630	3144	java/io/IOException
    //   666	685	3144	java/io/IOException
    //   721	727	3144	java/io/IOException
    //   763	772	3144	java/io/IOException
    //   808	822	3144	java/io/IOException
    //   862	875	3144	java/io/IOException
    //   911	920	3144	java/io/IOException
    //   964	973	3144	java/io/IOException
    //   1716	1723	3144	java/io/IOException
    //   1759	1769	3144	java/io/IOException
    //   1809	1822	3144	java/io/IOException
    //   2745	2758	3165	java/io/IOException
    //   1153	1159	3178	finally
    //   1183	1212	3178	finally
    //   1240	1246	3178	finally
    //   1270	1312	3178	finally
    //   1336	1344	3178	finally
    //   1368	1376	3178	finally
    //   1400	1408	3178	finally
    //   1432	1438	3178	finally
    //   1487	1499	3178	finally
    //   1523	1532	3178	finally
    //   1556	1562	3178	finally
    //   1586	1641	3178	finally
    //   2033	2039	3178	finally
    //   2063	2114	3178	finally
    //   2142	2150	3178	finally
    //   2174	2180	3178	finally
    //   2266	2272	3178	finally
    //   2317	2323	3178	finally
    //   2339	2368	3178	finally
    //   2201	2221	3199	finally
    //   2396	2403	3199	finally
    //   979	990	3204	finally
    //   990	999	3223	finally
    //   1009	1015	3234	java/lang/Throwable
    //   1024	1043	3234	java/lang/Throwable
    //   1054	1070	3234	java/lang/Throwable
    //   979	990	3242	java/lang/Throwable
    //   990	999	3261	java/lang/Throwable
    //   1009	1015	3272	java/io/IOException
    //   1024	1043	3272	java/io/IOException
    //   1054	1070	3272	java/io/IOException
    //   979	990	3288	java/io/IOException
    //   990	999	3304	java/io/IOException
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    // Byte code:
    //   0: new 227	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_1
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 564	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 8
    //   12: getstatic 184	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   15: invokevirtual 510	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +34 -> 56
    //   25: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 15
    //   33: iconst_2
    //   34: ldc_w 566
    //   37: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 8
    //   42: iconst_1
    //   43: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   46: aload_2
    //   47: aload 8
    //   49: invokeinterface 571 2 0
    //   54: iconst_1
    //   55: ireturn
    //   56: new 225	java/net/URL
    //   59: dup
    //   60: aload 8
    //   62: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: pop
    //   69: new 4	java/lang/Object
    //   72: dup
    //   73: invokespecial 214	java/lang/Object:<init>	()V
    //   76: astore 9
    //   78: aload 8
    //   80: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   83: astore 6
    //   85: new 278	org/apache/http/client/methods/HttpGet
    //   88: dup
    //   89: aload 6
    //   91: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
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
    //   109: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 575	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: aload 7
    //   121: getstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne +12 -> 139
    //   130: iconst_0
    //   131: putstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   134: aload 7
    //   136: putstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   142: astore 11
    //   144: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   147: istore_3
    //   148: aload 10
    //   150: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   153: ifeq +414 -> 567
    //   156: aload 11
    //   158: ifnull +409 -> 567
    //   161: iload_3
    //   162: ifle +405 -> 567
    //   165: getstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   168: ifne +399 -> 567
    //   171: aload_1
    //   172: ifnull +381 -> 553
    //   175: aload 7
    //   177: getstatic 581	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +25 -> 208
    //   186: aload 7
    //   188: getstatic 583	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   191: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +14 -> 208
    //   197: aload 7
    //   199: getstatic 585	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   202: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +309 -> 514
    //   208: aload 6
    //   210: aload 11
    //   212: iload_3
    //   213: invokestatic 588	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   216: astore_1
    //   217: aload_1
    //   218: astore_0
    //   219: aload_0
    //   220: astore_1
    //   221: aload_0
    //   222: ldc_w 590
    //   225: ldc_w 592
    //   228: invokevirtual 597	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: astore_1
    //   233: aload_0
    //   234: sipush 30000
    //   237: invokevirtual 601	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   240: aload_0
    //   241: astore_1
    //   242: aload_0
    //   243: sipush 30000
    //   246: invokevirtual 604	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   249: aload_0
    //   250: astore_1
    //   251: aload_0
    //   252: iconst_1
    //   253: invokevirtual 608	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: invokevirtual 611	java/net/HttpURLConnection:connect	()V
    //   262: aload_0
    //   263: astore_1
    //   264: aload 8
    //   266: aload_0
    //   267: invokevirtual 614	java/net/HttpURLConnection:getResponseCode	()I
    //   270: putfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   273: aload_0
    //   274: astore_1
    //   275: aload 8
    //   277: aload_0
    //   278: invokevirtual 618	java/net/HttpURLConnection:getContentLength	()I
    //   281: putfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   284: aload_0
    //   285: astore_1
    //   286: aload 8
    //   288: aload_0
    //   289: invokevirtual 623	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   292: putfield 624	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   295: aload_0
    //   296: astore_1
    //   297: aload 8
    //   299: aload_0
    //   300: invokevirtual 627	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   303: putfield 629	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   306: aload_0
    //   307: astore_1
    //   308: aload 8
    //   310: iconst_0
    //   311: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   314: iconst_0
    //   315: istore_3
    //   316: aload_0
    //   317: astore_1
    //   318: iload_3
    //   319: istore 4
    //   321: aload_0
    //   322: ifnull +12 -> 334
    //   325: aload_0
    //   326: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   329: iload_3
    //   330: istore 4
    //   332: aload_0
    //   333: astore_1
    //   334: iload 5
    //   336: iconst_1
    //   337: iadd
    //   338: istore 5
    //   340: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +44 -> 387
    //   346: ldc 15
    //   348: iconst_2
    //   349: new 254	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 634
    //   359: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload 4
    //   364: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 461
    //   370: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 8
    //   375: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   378: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload 5
    //   389: iconst_2
    //   390: if_icmpge +22 -> 412
    //   393: iload 4
    //   395: ifeq +17 -> 412
    //   398: aload 9
    //   400: monitorenter
    //   401: aload 9
    //   403: ldc2_w 635
    //   406: invokevirtual 467	java/lang/Object:wait	(J)V
    //   409: aload 9
    //   411: monitorexit
    //   412: iload 4
    //   414: ifeq +9 -> 423
    //   417: iload 5
    //   419: iconst_2
    //   420: if_icmplt +475 -> 895
    //   423: aload 8
    //   425: iload 4
    //   427: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   430: aload_2
    //   431: aload 8
    //   433: invokeinterface 571 2 0
    //   438: iload 4
    //   440: ireturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 268	java/net/MalformedURLException:printStackTrace	()V
    //   446: aload 8
    //   448: aload_0
    //   449: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   452: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   455: aload 8
    //   457: iconst_5
    //   458: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   461: aload_2
    //   462: aload 8
    //   464: invokeinterface 571 2 0
    //   469: iconst_5
    //   470: ireturn
    //   471: astore_0
    //   472: new 278	org/apache/http/client/methods/HttpGet
    //   475: dup
    //   476: aload 6
    //   478: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   484: pop
    //   485: aload 6
    //   487: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   490: astore 6
    //   492: goto -397 -> 95
    //   495: astore_0
    //   496: aload 8
    //   498: bipush 13
    //   500: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   503: aload_2
    //   504: aload 8
    //   506: invokeinterface 571 2 0
    //   511: bipush 13
    //   513: ireturn
    //   514: aload 7
    //   516: getstatic 637	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +17 -> 539
    //   525: aload 6
    //   527: aload 11
    //   529: iload_3
    //   530: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   533: astore_1
    //   534: aload_1
    //   535: astore_0
    //   536: goto -317 -> 219
    //   539: aload 6
    //   541: aload 11
    //   543: iload_3
    //   544: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   547: astore_1
    //   548: aload_1
    //   549: astore_0
    //   550: goto -331 -> 219
    //   553: aload 6
    //   555: aload 11
    //   557: iload_3
    //   558: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   561: astore_1
    //   562: aload_1
    //   563: astore_0
    //   564: goto -345 -> 219
    //   567: new 225	java/net/URL
    //   570: dup
    //   571: aload 6
    //   573: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   576: invokevirtual 643	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   579: checkcast 594	java/net/HttpURLConnection
    //   582: astore_1
    //   583: aload_1
    //   584: astore_0
    //   585: goto -366 -> 219
    //   588: astore 7
    //   590: aload_0
    //   591: astore_1
    //   592: aload 7
    //   594: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   597: aload_0
    //   598: astore_1
    //   599: aload 7
    //   601: instanceof 482
    //   604: ifeq +91 -> 695
    //   607: bipush 10
    //   609: istore_3
    //   610: aload_0
    //   611: astore_1
    //   612: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +59 -> 674
    //   618: aload_0
    //   619: astore_1
    //   620: ldc 15
    //   622: iconst_2
    //   623: new 254	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 645
    //   633: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_3
    //   637: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 486
    //   643: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 8
    //   648: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   651: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 647
    //   657: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 7
    //   662: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   665: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: astore_1
    //   676: iload_3
    //   677: istore 4
    //   679: aload_0
    //   680: ifnull -346 -> 334
    //   683: aload_0
    //   684: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   687: aload_0
    //   688: astore_1
    //   689: iload_3
    //   690: istore 4
    //   692: goto -358 -> 334
    //   695: aload_0
    //   696: astore_1
    //   697: aload 7
    //   699: instanceof 475
    //   702: ifne +198 -> 900
    //   705: aload_0
    //   706: astore_1
    //   707: aload 7
    //   709: instanceof 477
    //   712: ifeq +6 -> 718
    //   715: goto +185 -> 900
    //   718: aload_0
    //   719: astore_1
    //   720: aload 7
    //   722: instanceof 502
    //   725: ifeq +17 -> 742
    //   728: aload_0
    //   729: astore_1
    //   730: aload 8
    //   732: bipush 11
    //   734: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   737: iconst_5
    //   738: istore_3
    //   739: goto -129 -> 610
    //   742: aload_0
    //   743: astore_1
    //   744: aload 7
    //   746: instanceof 217
    //   749: ifeq +156 -> 905
    //   752: bipush 13
    //   754: istore_3
    //   755: goto -145 -> 610
    //   758: aload_0
    //   759: astore_1
    //   760: aload 7
    //   762: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   765: iconst_5
    //   766: istore_3
    //   767: aload_0
    //   768: astore_1
    //   769: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +59 -> 831
    //   775: aload_0
    //   776: astore_1
    //   777: ldc 15
    //   779: iconst_2
    //   780: new 254	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 645
    //   790: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: iconst_5
    //   794: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 486
    //   800: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 8
    //   805: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   808: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 488
    //   814: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 7
    //   819: invokevirtual 648	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload_0
    //   832: astore_1
    //   833: iload_3
    //   834: istore 4
    //   836: aload_0
    //   837: ifnull -503 -> 334
    //   840: aload_0
    //   841: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
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
    //   862: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
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
    //   910	1	7	localException	Exception
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
    //   0: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 214	java/lang/Object:<init>	()V
    //   12: astore 24
    //   14: aload_2
    //   15: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +15 -> 35
    //   23: aload_0
    //   24: invokevirtual 241	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: invokevirtual 244	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aconst_null
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   41: astore 19
    //   43: new 278	org/apache/http/client/methods/HttpGet
    //   46: dup
    //   47: aload 19
    //   49: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   52: astore 23
    //   54: new 72	org/apache/http/params/BasicHttpParams
    //   57: dup
    //   58: invokespecial 75	org/apache/http/params/BasicHttpParams:<init>	()V
    //   61: astore 25
    //   63: sipush 20000
    //   66: istore 5
    //   68: ldc_w 282
    //   71: istore 4
    //   73: aload_3
    //   74: ifnull +105 -> 179
    //   77: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   80: astore 19
    //   82: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   85: istore 4
    //   87: aload_3
    //   88: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   91: astore 20
    //   93: aload_3
    //   94: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   97: ifeq +51 -> 148
    //   100: aload 20
    //   102: ifnull +14 -> 116
    //   105: aload 20
    //   107: ldc_w 316
    //   110: invokevirtual 320	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   113: ifeq +35 -> 148
    //   116: aload 19
    //   118: ifnull +30 -> 148
    //   121: iload 4
    //   123: ifle +25 -> 148
    //   126: aload 25
    //   128: ldc_w 322
    //   131: new 324	org/apache/http/HttpHost
    //   134: dup
    //   135: aload 19
    //   137: iload 4
    //   139: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   142: invokeinterface 293 3 0
    //   147: pop
    //   148: aload_3
    //   149: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   152: ifeq +753 -> 905
    //   155: sipush 20000
    //   158: istore 5
    //   160: ldc_w 282
    //   163: istore 4
    //   165: aload 25
    //   167: ldc_w 328
    //   170: sipush 2048
    //   173: invokeinterface 332 3 0
    //   178: pop
    //   179: aload 25
    //   181: ldc_w 281
    //   184: iload 5
    //   186: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokeinterface 293 3 0
    //   194: pop
    //   195: aload 25
    //   197: ldc_w 295
    //   200: iload 4
    //   202: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: invokeinterface 293 3 0
    //   210: pop
    //   211: aload 23
    //   213: aload 25
    //   215: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   218: aload_2
    //   219: invokevirtual 241	java/io/File:exists	()Z
    //   222: ifeq +8 -> 230
    //   225: aload_2
    //   226: invokevirtual 342	java/io/File:delete	()Z
    //   229: pop
    //   230: aconst_null
    //   231: astore 19
    //   233: iconst_m1
    //   234: istore 10
    //   236: aload_0
    //   237: astore_3
    //   238: aload 19
    //   240: astore_0
    //   241: iload 10
    //   243: ifne +36 -> 279
    //   246: aload 25
    //   248: ldc_w 322
    //   251: new 324	org/apache/http/HttpHost
    //   254: dup
    //   255: aload_1
    //   256: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   259: aload_1
    //   260: invokevirtual 348	java/net/URL:getPort	()I
    //   263: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   266: invokeinterface 293 3 0
    //   271: pop
    //   272: aload 23
    //   274: aload 25
    //   276: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   279: iconst_5
    //   280: istore 4
    //   282: aload_0
    //   283: astore 20
    //   285: aload_0
    //   286: astore 21
    //   288: aload_0
    //   289: astore 22
    //   291: aload_0
    //   292: astore 19
    //   294: getstatic 149	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   297: new 324	org/apache/http/HttpHost
    //   300: dup
    //   301: aload_1
    //   302: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   305: invokespecial 349	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   308: aload 23
    //   310: invokevirtual 353	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   313: astore 26
    //   315: aload_0
    //   316: astore 20
    //   318: aload_0
    //   319: astore 21
    //   321: aload_0
    //   322: astore 22
    //   324: aload_0
    //   325: astore 19
    //   327: aload 26
    //   329: invokeinterface 359 1 0
    //   334: invokeinterface 368 1 0
    //   339: istore 5
    //   341: aload_0
    //   342: astore 20
    //   344: aload_0
    //   345: astore 21
    //   347: aload_0
    //   348: astore 22
    //   350: aload_0
    //   351: astore 19
    //   353: aload 26
    //   355: invokeinterface 374 1 0
    //   360: astore_0
    //   361: sipush 200
    //   364: iload 5
    //   366: if_icmpne +618 -> 984
    //   369: aload_0
    //   370: astore 20
    //   372: aload_0
    //   373: astore 21
    //   375: aload_0
    //   376: astore 22
    //   378: aload_0
    //   379: astore 19
    //   381: aload_0
    //   382: invokeinterface 379 1 0
    //   387: lstore 17
    //   389: lconst_0
    //   390: lstore 13
    //   392: aload_0
    //   393: astore 20
    //   395: aload_0
    //   396: astore 21
    //   398: aload_0
    //   399: astore 22
    //   401: new 381	java/io/FileOutputStream
    //   404: dup
    //   405: aload_2
    //   406: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   409: astore 19
    //   411: lload 13
    //   413: lstore 11
    //   415: aload 19
    //   417: astore 20
    //   419: aload 19
    //   421: astore 21
    //   423: aload 19
    //   425: astore 22
    //   427: aload_0
    //   428: aload 19
    //   430: invokeinterface 656 2 0
    //   435: lload 13
    //   437: lstore 11
    //   439: aload 19
    //   441: astore 20
    //   443: aload 19
    //   445: astore 21
    //   447: aload 19
    //   449: astore 22
    //   451: aload_2
    //   452: invokevirtual 659	java/io/File:length	()J
    //   455: lstore 13
    //   457: lload 13
    //   459: lstore 11
    //   461: aload 19
    //   463: astore 20
    //   465: aload 19
    //   467: astore 21
    //   469: aload 19
    //   471: astore 22
    //   473: aload_2
    //   474: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   477: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   480: pop
    //   481: lload 13
    //   483: lstore 11
    //   485: aload 19
    //   487: astore 20
    //   489: aload 19
    //   491: astore 21
    //   493: aload 19
    //   495: astore 22
    //   497: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +71 -> 571
    //   503: lload 13
    //   505: lstore 11
    //   507: aload 19
    //   509: astore 20
    //   511: aload 19
    //   513: astore 21
    //   515: aload 19
    //   517: astore 22
    //   519: ldc 15
    //   521: iconst_2
    //   522: new 254	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 437
    //   532: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   538: lload 15
    //   540: lsub
    //   541: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   544: ldc_w 661
    //   547: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: lload 13
    //   552: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: ldc_w 441
    //   558: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_1
    //   562: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iconst_0
    //   572: istore 4
    //   574: aload 19
    //   576: astore_3
    //   577: lload 13
    //   579: lstore 11
    //   581: iload 4
    //   583: istore 5
    //   585: lload 17
    //   587: lconst_0
    //   588: lcmp
    //   589: ifle +159 -> 748
    //   592: iload 4
    //   594: istore 5
    //   596: lload 11
    //   598: lload 17
    //   600: lcmp
    //   601: ifge +147 -> 748
    //   604: iload 4
    //   606: istore 6
    //   608: iload 4
    //   610: istore 7
    //   612: iload 4
    //   614: istore 8
    //   616: iload 4
    //   618: istore 9
    //   620: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +69 -> 692
    //   626: iload 4
    //   628: istore 6
    //   630: iload 4
    //   632: istore 7
    //   634: iload 4
    //   636: istore 8
    //   638: iload 4
    //   640: istore 9
    //   642: ldc 15
    //   644: iconst_2
    //   645: new 254	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 663
    //   655: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: lload 17
    //   660: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: ldc_w 665
    //   666: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_2
    //   670: invokevirtual 659	java/io/File:length	()J
    //   673: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   676: ldc_w 461
    //   679: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_1
    //   683: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: bipush 8
    //   694: istore 4
    //   696: iload 4
    //   698: istore 5
    //   700: iload 4
    //   702: istore 6
    //   704: iload 4
    //   706: istore 7
    //   708: iload 4
    //   710: istore 8
    //   712: iload 4
    //   714: istore 9
    //   716: aload_2
    //   717: invokevirtual 241	java/io/File:exists	()Z
    //   720: ifeq +28 -> 748
    //   723: iload 4
    //   725: istore 6
    //   727: iload 4
    //   729: istore 7
    //   731: iload 4
    //   733: istore 8
    //   735: iload 4
    //   737: istore 9
    //   739: aload_2
    //   740: invokevirtual 342	java/io/File:delete	()Z
    //   743: pop
    //   744: iload 4
    //   746: istore 5
    //   748: iload 5
    //   750: istore 4
    //   752: aload_0
    //   753: ifnull +9 -> 762
    //   756: aload_0
    //   757: invokeinterface 453 1 0
    //   762: aload_3
    //   763: ifnull +7 -> 770
    //   766: aload_3
    //   767: invokevirtual 454	java/io/OutputStream:close	()V
    //   770: iload 4
    //   772: ifeq +923 -> 1695
    //   775: aload_2
    //   776: ifnull +15 -> 791
    //   779: aload_2
    //   780: invokevirtual 241	java/io/File:exists	()Z
    //   783: ifeq +8 -> 791
    //   786: aload_2
    //   787: invokevirtual 342	java/io/File:delete	()Z
    //   790: pop
    //   791: iload 10
    //   793: iconst_1
    //   794: iadd
    //   795: istore 10
    //   797: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq +40 -> 840
    //   803: ldc 15
    //   805: iconst_2
    //   806: new 254	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   813: ldc_w 456
    //   816: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: iload 4
    //   821: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: ldc_w 461
    //   827: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload_1
    //   831: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: iload 4
    //   842: ifeq +23 -> 865
    //   845: iload 10
    //   847: iconst_2
    //   848: if_icmpge +17 -> 865
    //   851: aload 24
    //   853: monitorenter
    //   854: aload 24
    //   856: ldc2_w 666
    //   859: invokevirtual 467	java/lang/Object:wait	(J)V
    //   862: aload 24
    //   864: monitorexit
    //   865: iload 4
    //   867: ifeq +9 -> 876
    //   870: iload 10
    //   872: iconst_2
    //   873: if_icmplt +819 -> 1692
    //   876: iload 4
    //   878: ireturn
    //   879: astore_0
    //   880: iconst_4
    //   881: ireturn
    //   882: astore 20
    //   884: new 278	org/apache/http/client/methods/HttpGet
    //   887: dup
    //   888: aload 19
    //   890: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   893: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   896: astore 23
    //   898: goto -844 -> 54
    //   901: astore_0
    //   902: bipush 13
    //   904: ireturn
    //   905: sipush 10000
    //   908: istore 5
    //   910: sipush 30000
    //   913: istore 4
    //   915: aload 25
    //   917: ldc_w 328
    //   920: sipush 4096
    //   923: invokeinterface 332 3 0
    //   928: pop
    //   929: goto -750 -> 179
    //   932: astore 20
    //   934: aload 19
    //   936: astore_3
    //   937: aload 20
    //   939: astore 19
    //   941: aload_3
    //   942: astore 20
    //   944: aload_3
    //   945: astore 21
    //   947: aload_3
    //   948: astore 22
    //   950: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq +25 -> 978
    //   956: aload_3
    //   957: astore 20
    //   959: aload_3
    //   960: astore 21
    //   962: aload_3
    //   963: astore 22
    //   965: ldc 15
    //   967: iconst_2
    //   968: aload 19
    //   970: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   973: aload 19
    //   975: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   978: iconst_4
    //   979: istore 4
    //   981: goto -400 -> 581
    //   984: iload 5
    //   986: istore 4
    //   988: goto -236 -> 752
    //   991: astore 19
    //   993: aload 19
    //   995: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   998: goto -236 -> 762
    //   1001: astore 19
    //   1003: goto -212 -> 791
    //   1006: astore 20
    //   1008: iconst_5
    //   1009: istore 4
    //   1011: aload_0
    //   1012: astore 19
    //   1014: aload 20
    //   1016: astore_0
    //   1017: aload_3
    //   1018: astore 20
    //   1020: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1023: ifeq +30 -> 1053
    //   1026: ldc 15
    //   1028: iconst_2
    //   1029: new 254	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 669
    //   1039: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: aload_1
    //   1043: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: aload_0
    //   1050: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1053: iconst_1
    //   1054: istore 5
    //   1056: aload 19
    //   1058: ifnull +10 -> 1068
    //   1061: aload 19
    //   1063: invokeinterface 453 1 0
    //   1068: aload 20
    //   1070: ifnull +8 -> 1078
    //   1073: aload 20
    //   1075: invokevirtual 454	java/io/OutputStream:close	()V
    //   1078: aload 19
    //   1080: astore_0
    //   1081: aload 20
    //   1083: astore_3
    //   1084: iload 5
    //   1086: istore 4
    //   1088: aload_2
    //   1089: ifnull -298 -> 791
    //   1092: aload 19
    //   1094: astore_0
    //   1095: aload 20
    //   1097: astore_3
    //   1098: iload 5
    //   1100: istore 4
    //   1102: aload_2
    //   1103: invokevirtual 241	java/io/File:exists	()Z
    //   1106: ifeq -315 -> 791
    //   1109: aload_2
    //   1110: invokevirtual 342	java/io/File:delete	()Z
    //   1113: pop
    //   1114: aload 19
    //   1116: astore_0
    //   1117: aload 20
    //   1119: astore_3
    //   1120: iload 5
    //   1122: istore 4
    //   1124: goto -333 -> 791
    //   1127: astore_0
    //   1128: aload 19
    //   1130: astore_0
    //   1131: aload 20
    //   1133: astore_3
    //   1134: iload 5
    //   1136: istore 4
    //   1138: goto -347 -> 791
    //   1141: astore_0
    //   1142: aload_0
    //   1143: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1146: goto -78 -> 1068
    //   1149: astore 21
    //   1151: iload 4
    //   1153: istore 5
    //   1155: aload_0
    //   1156: astore 19
    //   1158: aload 19
    //   1160: astore_0
    //   1161: aload 20
    //   1163: astore_3
    //   1164: iload 5
    //   1166: istore 4
    //   1168: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1171: ifeq +41 -> 1212
    //   1174: aload 19
    //   1176: astore_0
    //   1177: aload 20
    //   1179: astore_3
    //   1180: iload 5
    //   1182: istore 4
    //   1184: ldc 15
    //   1186: iconst_2
    //   1187: new 254	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 555
    //   1197: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload_1
    //   1201: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: aload 21
    //   1209: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1212: iconst_5
    //   1213: istore 5
    //   1215: aload 19
    //   1217: ifnull +10 -> 1227
    //   1220: aload 19
    //   1222: invokeinterface 453 1 0
    //   1227: aload 20
    //   1229: ifnull +8 -> 1237
    //   1232: aload 20
    //   1234: invokevirtual 454	java/io/OutputStream:close	()V
    //   1237: aload 19
    //   1239: astore_0
    //   1240: aload 20
    //   1242: astore_3
    //   1243: iload 5
    //   1245: istore 4
    //   1247: aload_2
    //   1248: ifnull -457 -> 791
    //   1251: aload 19
    //   1253: astore_0
    //   1254: aload 20
    //   1256: astore_3
    //   1257: iload 5
    //   1259: istore 4
    //   1261: aload_2
    //   1262: invokevirtual 241	java/io/File:exists	()Z
    //   1265: ifeq -474 -> 791
    //   1268: aload_2
    //   1269: invokevirtual 342	java/io/File:delete	()Z
    //   1272: pop
    //   1273: aload 19
    //   1275: astore_0
    //   1276: aload 20
    //   1278: astore_3
    //   1279: iload 5
    //   1281: istore 4
    //   1283: goto -492 -> 791
    //   1286: astore_0
    //   1287: aload 19
    //   1289: astore_0
    //   1290: aload 20
    //   1292: astore_3
    //   1293: iload 5
    //   1295: istore 4
    //   1297: goto -506 -> 791
    //   1300: astore_0
    //   1301: aload_0
    //   1302: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1305: goto -78 -> 1227
    //   1308: astore_3
    //   1309: aload 21
    //   1311: astore 20
    //   1313: iload 4
    //   1315: istore 5
    //   1317: aload_3
    //   1318: astore 21
    //   1320: aload_0
    //   1321: astore 19
    //   1323: aload 19
    //   1325: astore_0
    //   1326: aload 20
    //   1328: astore_3
    //   1329: iload 5
    //   1331: istore 4
    //   1333: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1336: ifeq +41 -> 1377
    //   1339: aload 19
    //   1341: astore_0
    //   1342: aload 20
    //   1344: astore_3
    //   1345: iload 5
    //   1347: istore 4
    //   1349: ldc 15
    //   1351: iconst_2
    //   1352: new 254	java/lang/StringBuilder
    //   1355: dup
    //   1356: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1359: ldc_w 555
    //   1362: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: aload_1
    //   1366: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1369: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1372: aload 21
    //   1374: invokestatic 560	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1377: iconst_5
    //   1378: istore 5
    //   1380: aload 19
    //   1382: ifnull +10 -> 1392
    //   1385: aload 19
    //   1387: invokeinterface 453 1 0
    //   1392: aload 20
    //   1394: ifnull +8 -> 1402
    //   1397: aload 20
    //   1399: invokevirtual 454	java/io/OutputStream:close	()V
    //   1402: aload 19
    //   1404: astore_0
    //   1405: aload 20
    //   1407: astore_3
    //   1408: iload 5
    //   1410: istore 4
    //   1412: aload_2
    //   1413: ifnull -622 -> 791
    //   1416: aload 19
    //   1418: astore_0
    //   1419: aload 20
    //   1421: astore_3
    //   1422: iload 5
    //   1424: istore 4
    //   1426: aload_2
    //   1427: invokevirtual 241	java/io/File:exists	()Z
    //   1430: ifeq -639 -> 791
    //   1433: aload_2
    //   1434: invokevirtual 342	java/io/File:delete	()Z
    //   1437: pop
    //   1438: aload 19
    //   1440: astore_0
    //   1441: aload 20
    //   1443: astore_3
    //   1444: iload 5
    //   1446: istore 4
    //   1448: goto -657 -> 791
    //   1451: astore_0
    //   1452: aload 19
    //   1454: astore_0
    //   1455: aload 20
    //   1457: astore_3
    //   1458: iload 5
    //   1460: istore 4
    //   1462: goto -671 -> 791
    //   1465: astore_0
    //   1466: aload_0
    //   1467: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1470: goto -78 -> 1392
    //   1473: astore_1
    //   1474: aload 22
    //   1476: astore_3
    //   1477: aload_0
    //   1478: ifnull +9 -> 1487
    //   1481: aload_0
    //   1482: invokeinterface 453 1 0
    //   1487: aload_3
    //   1488: ifnull +7 -> 1495
    //   1491: aload_3
    //   1492: invokevirtual 454	java/io/OutputStream:close	()V
    //   1495: iload 4
    //   1497: ifeq +19 -> 1516
    //   1500: aload_2
    //   1501: ifnull +15 -> 1516
    //   1504: aload_2
    //   1505: invokevirtual 241	java/io/File:exists	()Z
    //   1508: ifeq +8 -> 1516
    //   1511: aload_2
    //   1512: invokevirtual 342	java/io/File:delete	()Z
    //   1515: pop
    //   1516: aload_1
    //   1517: athrow
    //   1518: astore_0
    //   1519: aload_0
    //   1520: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1523: goto -36 -> 1487
    //   1526: astore_0
    //   1527: aload 24
    //   1529: monitorexit
    //   1530: aload_0
    //   1531: athrow
    //   1532: astore 19
    //   1534: goto -764 -> 770
    //   1537: astore_0
    //   1538: goto -460 -> 1078
    //   1541: astore_0
    //   1542: goto -305 -> 1237
    //   1545: astore_0
    //   1546: goto -144 -> 1402
    //   1549: astore_0
    //   1550: goto -55 -> 1495
    //   1553: astore 19
    //   1555: goto -693 -> 862
    //   1558: astore_0
    //   1559: goto -43 -> 1516
    //   1562: astore_1
    //   1563: iload 6
    //   1565: istore 4
    //   1567: goto -90 -> 1477
    //   1570: astore_1
    //   1571: aload 20
    //   1573: astore_3
    //   1574: aload 19
    //   1576: astore_0
    //   1577: goto -100 -> 1477
    //   1580: astore_1
    //   1581: goto -104 -> 1477
    //   1584: astore_1
    //   1585: aload 20
    //   1587: astore_0
    //   1588: goto -111 -> 1477
    //   1591: astore 21
    //   1593: iload 7
    //   1595: istore 5
    //   1597: aload_0
    //   1598: astore 19
    //   1600: aload_3
    //   1601: astore 20
    //   1603: goto -280 -> 1323
    //   1606: astore_0
    //   1607: aload 21
    //   1609: astore 19
    //   1611: aload_3
    //   1612: astore 20
    //   1614: aload_0
    //   1615: astore 21
    //   1617: iload 4
    //   1619: istore 5
    //   1621: goto -298 -> 1323
    //   1624: astore 21
    //   1626: iload 8
    //   1628: istore 5
    //   1630: aload_0
    //   1631: astore 19
    //   1633: aload_3
    //   1634: astore 20
    //   1636: goto -478 -> 1158
    //   1639: astore 21
    //   1641: aload 22
    //   1643: astore 19
    //   1645: aload_3
    //   1646: astore 20
    //   1648: iload 4
    //   1650: istore 5
    //   1652: goto -494 -> 1158
    //   1655: astore 21
    //   1657: iload 9
    //   1659: istore 4
    //   1661: aload_0
    //   1662: astore 19
    //   1664: aload_3
    //   1665: astore 20
    //   1667: aload 21
    //   1669: astore_0
    //   1670: goto -650 -> 1020
    //   1673: astore_0
    //   1674: iconst_5
    //   1675: istore 4
    //   1677: aload_3
    //   1678: astore 20
    //   1680: goto -660 -> 1020
    //   1683: astore 19
    //   1685: lload 13
    //   1687: lstore 11
    //   1689: goto -748 -> 941
    //   1692: goto -1451 -> 241
    //   1695: goto -904 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1698	0	paramAppInterface	AppInterface
    //   0	1698	1	paramURL	URL
    //   0	1698	2	paramFile	File
    //   0	1698	3	paramNetworkInfo	NetworkInfo
    //   71	1605	4	i1	int
    //   66	1585	5	i2	int
    //   606	958	6	i3	int
    //   610	984	7	i4	int
    //   614	1013	8	i5	int
    //   618	1040	9	i6	int
    //   234	640	10	i7	int
    //   413	1275	11	l1	long
    //   390	1296	13	l2	long
    //   3	536	15	l3	long
    //   387	272	17	l4	long
    //   41	933	19	localObject1	Object
    //   991	3	19	localIOException1	java.io.IOException
    //   1001	1	19	localException1	Exception
    //   1012	441	19	localAppInterface1	AppInterface
    //   1532	1	19	localIOException2	java.io.IOException
    //   1553	22	19	localInterruptedException	java.lang.InterruptedException
    //   1598	65	19	localObject2	Object
    //   1683	1	19	localIOException3	java.io.IOException
    //   91	419	20	localObject3	Object
    //   882	1	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   932	6	20	localIOException4	java.io.IOException
    //   942	16	20	localNetworkInfo1	NetworkInfo
    //   1006	9	20	localIOException5	java.io.IOException
    //   1018	661	20	localObject4	Object
    //   286	675	21	localObject5	Object
    //   1149	161	21	localException2	Exception
    //   1318	55	21	localNetworkInfo2	NetworkInfo
    //   1591	17	21	localThrowable	java.lang.Throwable
    //   1615	1	21	localAppInterface2	AppInterface
    //   1624	1	21	localException3	Exception
    //   1639	1	21	localException4	Exception
    //   1655	13	21	localIOException6	java.io.IOException
    //   289	1353	22	localObject6	Object
    //   52	845	23	localHttpGet	org.apache.http.client.methods.HttpGet
    //   12	1516	24	localObject7	Object
    //   61	855	25	localBasicHttpParams	BasicHttpParams
    //   313	41	26	localHttpResponse	org.apache.http.HttpResponse
    // Exception table:
    //   from	to	target	type
    //   14	19	879	java/lang/Exception
    //   23	35	879	java/lang/Exception
    //   43	54	882	java/lang/IllegalArgumentException
    //   884	898	901	java/lang/IllegalArgumentException
    //   427	435	932	java/io/IOException
    //   451	457	932	java/io/IOException
    //   473	481	932	java/io/IOException
    //   497	503	932	java/io/IOException
    //   519	571	932	java/io/IOException
    //   756	762	991	java/io/IOException
    //   779	791	1001	java/lang/Exception
    //   950	956	1006	java/io/IOException
    //   965	978	1006	java/io/IOException
    //   1102	1114	1127	java/lang/Exception
    //   1061	1068	1141	java/io/IOException
    //   427	435	1149	java/lang/Exception
    //   451	457	1149	java/lang/Exception
    //   473	481	1149	java/lang/Exception
    //   497	503	1149	java/lang/Exception
    //   519	571	1149	java/lang/Exception
    //   950	956	1149	java/lang/Exception
    //   965	978	1149	java/lang/Exception
    //   1261	1273	1286	java/lang/Exception
    //   1220	1227	1300	java/io/IOException
    //   427	435	1308	java/lang/Throwable
    //   451	457	1308	java/lang/Throwable
    //   473	481	1308	java/lang/Throwable
    //   497	503	1308	java/lang/Throwable
    //   519	571	1308	java/lang/Throwable
    //   950	956	1308	java/lang/Throwable
    //   965	978	1308	java/lang/Throwable
    //   1426	1438	1451	java/lang/Exception
    //   1385	1392	1465	java/io/IOException
    //   427	435	1473	finally
    //   451	457	1473	finally
    //   473	481	1473	finally
    //   497	503	1473	finally
    //   519	571	1473	finally
    //   950	956	1473	finally
    //   965	978	1473	finally
    //   1481	1487	1518	java/io/IOException
    //   854	862	1526	finally
    //   862	865	1526	finally
    //   1527	1530	1526	finally
    //   766	770	1532	java/io/IOException
    //   1073	1078	1537	java/io/IOException
    //   1232	1237	1541	java/io/IOException
    //   1397	1402	1545	java/io/IOException
    //   1491	1495	1549	java/io/IOException
    //   854	862	1553	java/lang/InterruptedException
    //   1504	1516	1558	java/lang/Exception
    //   620	626	1562	finally
    //   642	692	1562	finally
    //   716	723	1562	finally
    //   739	744	1562	finally
    //   1020	1053	1570	finally
    //   1168	1174	1580	finally
    //   1184	1212	1580	finally
    //   1333	1339	1580	finally
    //   1349	1377	1580	finally
    //   294	315	1584	finally
    //   327	341	1584	finally
    //   353	361	1584	finally
    //   381	389	1584	finally
    //   401	411	1584	finally
    //   620	626	1591	java/lang/Throwable
    //   642	692	1591	java/lang/Throwable
    //   716	723	1591	java/lang/Throwable
    //   739	744	1591	java/lang/Throwable
    //   294	315	1606	java/lang/Throwable
    //   327	341	1606	java/lang/Throwable
    //   353	361	1606	java/lang/Throwable
    //   381	389	1606	java/lang/Throwable
    //   401	411	1606	java/lang/Throwable
    //   620	626	1624	java/lang/Exception
    //   642	692	1624	java/lang/Exception
    //   716	723	1624	java/lang/Exception
    //   739	744	1624	java/lang/Exception
    //   294	315	1639	java/lang/Exception
    //   327	341	1639	java/lang/Exception
    //   353	361	1639	java/lang/Exception
    //   381	389	1639	java/lang/Exception
    //   401	411	1639	java/lang/Exception
    //   620	626	1655	java/io/IOException
    //   642	692	1655	java/io/IOException
    //   716	723	1655	java/io/IOException
    //   739	744	1655	java/io/IOException
    //   294	315	1673	java/io/IOException
    //   327	341	1673	java/io/IOException
    //   353	361	1673	java/io/IOException
    //   381	389	1673	java/io/IOException
    //   401	411	1683	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  /* Error */
  public static void a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener, com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler paramProgressHandler)
  {
    // Byte code:
    //   0: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_1
    //   6: iconst_5
    //   7: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   10: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +42 -> 55
    //   16: new 254	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 688
    //   26: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: astore 13
    //   31: aload_1
    //   32: ifnonnull +145 -> 177
    //   35: iconst_1
    //   36: istore 9
    //   38: ldc_w 690
    //   41: iconst_2
    //   42: aload 13
    //   44: iload 9
    //   46: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   59: iconst_1
    //   60: if_icmpeq +213 -> 273
    //   63: aload_1
    //   64: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   67: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   70: astore 13
    //   72: aload 13
    //   74: ifnull +199 -> 273
    //   77: aload 13
    //   79: invokevirtual 241	java/io/File:exists	()Z
    //   82: ifne +191 -> 273
    //   85: aload 13
    //   87: invokevirtual 244	java/io/File:mkdirs	()Z
    //   90: istore 9
    //   92: aload 13
    //   94: invokevirtual 696	java/io/File:isDirectory	()Z
    //   97: ifne +176 -> 273
    //   100: aload_1
    //   101: bipush 12
    //   103: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   106: aload_2
    //   107: ifnull +15 -> 122
    //   110: aload_2
    //   111: aload_1
    //   112: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   115: bipush 12
    //   117: invokeinterface 252 3 0
    //   122: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +45 -> 170
    //   128: ldc_w 690
    //   131: iconst_4
    //   132: new 254	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 698
    //   142: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload 9
    //   147: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   150: ldc_w 700
    //   153: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 13
    //   158: invokevirtual 703	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 13
    //   172: iconst_0
    //   173: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   176: return
    //   177: iconst_0
    //   178: istore 9
    //   180: goto -142 -> 38
    //   183: astore_0
    //   184: aload_1
    //   185: aload_0
    //   186: invokevirtual 710	java/lang/Exception:toString	()Ljava/lang/String;
    //   189: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   192: aload_1
    //   193: bipush 12
    //   195: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   198: aload_2
    //   199: ifnull +15 -> 214
    //   202: aload_2
    //   203: aload_1
    //   204: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   207: bipush 12
    //   209: invokeinterface 252 3 0
    //   214: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +33 -> 250
    //   220: ldc_w 690
    //   223: iconst_4
    //   224: new 254	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 712
    //   234: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: getfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   241: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_1
    //   251: ifnull -75 -> 176
    //   254: aload_1
    //   255: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   258: ifnull -82 -> 176
    //   261: aload_1
    //   262: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   265: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   268: iconst_0
    //   269: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   272: return
    //   273: new 4	java/lang/Object
    //   276: dup
    //   277: invokespecial 214	java/lang/Object:<init>	()V
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
    //   299: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   302: aload_1
    //   303: invokevirtual 714	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   306: aload_1
    //   307: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   310: iconst_1
    //   311: if_icmpeq +4066 -> 4377
    //   314: aload_1
    //   315: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   318: ifnull +4059 -> 4377
    //   321: new 234	java/io/File
    //   324: dup
    //   325: aload_1
    //   326: invokevirtual 338	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   329: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   332: astore 16
    //   334: aload 16
    //   336: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   339: astore 17
    //   341: aload 17
    //   343: invokevirtual 241	java/io/File:exists	()Z
    //   346: ifne +9 -> 355
    //   349: aload 17
    //   351: invokevirtual 244	java/io/File:mkdirs	()Z
    //   354: pop
    //   355: aload 16
    //   357: invokevirtual 241	java/io/File:exists	()Z
    //   360: ifeq +9 -> 369
    //   363: aload 16
    //   365: invokevirtual 342	java/io/File:delete	()Z
    //   368: pop
    //   369: aload 16
    //   371: invokevirtual 717	java/io/File:createNewFile	()Z
    //   374: pop
    //   375: getstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   378: ifne +18 -> 396
    //   381: aload_3
    //   382: ifnull +14 -> 396
    //   385: aload_3
    //   386: invokevirtual 721	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	()Z
    //   389: ifne +7 -> 396
    //   392: aload_1
    //   393: invokestatic 722	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   396: aload_1
    //   397: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   400: astore 22
    //   402: getstatic 184	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   405: invokevirtual 510	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   408: astore 21
    //   410: aload 21
    //   412: ifnonnull +75 -> 487
    //   415: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +13 -> 431
    //   421: ldc_w 690
    //   424: iconst_2
    //   425: ldc_w 724
    //   428: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: bipush 9
    //   434: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   437: aload 14
    //   439: ifnull +8 -> 447
    //   442: aload 14
    //   444: invokevirtual 454	java/io/OutputStream:close	()V
    //   447: aload 13
    //   449: ifnull +8 -> 457
    //   452: aload 13
    //   454: invokevirtual 446	java/io/InputStream:close	()V
    //   457: aload 15
    //   459: ifnull +8 -> 467
    //   462: aload 15
    //   464: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   467: aload 16
    //   469: ifnull -293 -> 176
    //   472: aload 16
    //   474: invokevirtual 342	java/io/File:delete	()Z
    //   477: pop
    //   478: return
    //   479: astore_0
    //   480: aload_0
    //   481: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   484: goto -17 -> 467
    //   487: aconst_null
    //   488: astore 17
    //   490: aload 21
    //   492: ifnull +10 -> 502
    //   495: aload 21
    //   497: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   500: astore 17
    //   502: aload 17
    //   504: invokestatic 575	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   507: astore 19
    //   509: aload 19
    //   511: getstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifne +12 -> 529
    //   520: iconst_0
    //   521: putstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   524: aload 19
    //   526: putstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   529: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   532: astore 20
    //   534: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   537: istore 4
    //   539: aload 21
    //   541: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   544: ifeq +1154 -> 1698
    //   547: aload 20
    //   549: ifnull +1149 -> 1698
    //   552: iload 4
    //   554: ifle +1144 -> 1698
    //   557: getstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   560: ifne +1138 -> 1698
    //   563: aload 17
    //   565: ifnull +1115 -> 1680
    //   568: aload 19
    //   570: getstatic 581	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   573: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   576: ifne +25 -> 601
    //   579: aload 19
    //   581: getstatic 583	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   584: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: ifne +14 -> 601
    //   590: aload 19
    //   592: getstatic 585	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   595: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +1035 -> 1633
    //   601: aload 22
    //   603: aload 20
    //   605: iload 4
    //   607: invokestatic 588	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   610: astore 17
    //   612: aload 17
    //   614: astore 15
    //   616: iconst_1
    //   617: istore 9
    //   619: aload 13
    //   621: astore 18
    //   623: aload 14
    //   625: astore 17
    //   627: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +107 -> 737
    //   633: aload 13
    //   635: astore 18
    //   637: aload 14
    //   639: astore 17
    //   641: ldc_w 690
    //   644: iconst_2
    //   645: new 254	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 726
    //   655: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: getstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   661: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   664: ldc_w 728
    //   667: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: getstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   673: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   676: ldc_w 730
    //   679: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: iload 9
    //   684: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: ldc_w 732
    //   690: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload 19
    //   695: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 734
    //   701: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 20
    //   706: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 736
    //   712: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: iload 4
    //   717: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: ldc_w 738
    //   723: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload 22
    //   728: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: aload 13
    //   739: astore 18
    //   741: aload 14
    //   743: astore 17
    //   745: aload_1
    //   746: getfield 739	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   749: ifeq +38 -> 787
    //   752: aload 13
    //   754: astore 18
    //   756: aload 14
    //   758: astore 17
    //   760: aload_1
    //   761: getfield 740	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   764: ifnull +23 -> 787
    //   767: aload 13
    //   769: astore 18
    //   771: aload 14
    //   773: astore 17
    //   775: aload 15
    //   777: ldc_w 742
    //   780: aload_1
    //   781: getfield 740	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   784: invokevirtual 745	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload 13
    //   789: astore 18
    //   791: aload 14
    //   793: astore 17
    //   795: aload 15
    //   797: ldc_w 590
    //   800: ldc_w 592
    //   803: invokevirtual 597	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload 13
    //   808: astore 18
    //   810: aload 14
    //   812: astore 17
    //   814: aload 15
    //   816: sipush 30000
    //   819: invokevirtual 601	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   822: aload 13
    //   824: astore 18
    //   826: aload 14
    //   828: astore 17
    //   830: aload 15
    //   832: sipush 30000
    //   835: invokevirtual 604	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   838: aload 13
    //   840: astore 18
    //   842: aload 14
    //   844: astore 17
    //   846: aload_1
    //   847: getfield 746	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   850: ifeq +111 -> 961
    //   853: aload 13
    //   855: astore 18
    //   857: aload 14
    //   859: astore 17
    //   861: aload_0
    //   862: invokevirtual 750	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   865: aload 22
    //   867: ldc_w 752
    //   870: invokeinterface 757 3 0
    //   875: astore 19
    //   877: aload 13
    //   879: astore 18
    //   881: aload 14
    //   883: astore 17
    //   885: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq +39 -> 927
    //   891: aload 13
    //   893: astore 18
    //   895: aload 14
    //   897: astore 17
    //   899: ldc_w 690
    //   902: iconst_2
    //   903: new 254	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   910: ldc_w 759
    //   913: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload 19
    //   918: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload 13
    //   929: astore 18
    //   931: aload 14
    //   933: astore 17
    //   935: aload 15
    //   937: ldc_w 761
    //   940: invokevirtual 764	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   943: aload 13
    //   945: astore 18
    //   947: aload 14
    //   949: astore 17
    //   951: aload 15
    //   953: ldc_w 766
    //   956: aload 19
    //   958: invokevirtual 745	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: aload 13
    //   963: astore 18
    //   965: aload 14
    //   967: astore 17
    //   969: aload 15
    //   971: iconst_1
    //   972: invokevirtual 608	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   975: aload 13
    //   977: astore 18
    //   979: aload 14
    //   981: astore 17
    //   983: aload_1
    //   984: iconst_5
    //   985: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   988: aload 13
    //   990: astore 18
    //   992: aload 14
    //   994: astore 17
    //   996: aload 15
    //   998: invokevirtual 611	java/net/HttpURLConnection:connect	()V
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
    //   1020: invokevirtual 614	java/net/HttpURLConnection:getResponseCode	()I
    //   1023: putfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
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
    //   1045: invokevirtual 618	java/net/HttpURLConnection:getContentLength	()I
    //   1048: putfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
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
    //   1070: invokevirtual 623	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1073: putfield 624	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
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
    //   1095: invokevirtual 627	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1098: putfield 629	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1101: aload 13
    //   1103: astore 18
    //   1105: aload 14
    //   1107: astore 17
    //   1109: aload 13
    //   1111: astore 20
    //   1113: aload 14
    //   1115: astore 19
    //   1117: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq +79 -> 1199
    //   1123: aload 13
    //   1125: astore 18
    //   1127: aload 14
    //   1129: astore 17
    //   1131: aload 13
    //   1133: astore 20
    //   1135: aload 14
    //   1137: astore 19
    //   1139: ldc_w 690
    //   1142: iconst_2
    //   1143: new 254	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 768
    //   1153: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: aload_1
    //   1157: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1160: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1163: ldc_w 471
    //   1166: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: aload_1
    //   1170: getfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   1173: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1176: ldc_w 770
    //   1179: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload 22
    //   1184: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc_w 772
    //   1190: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1221: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1224: aload_1
    //   1225: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1228: invokeinterface 370 3 0
    //   1233: aload 13
    //   1235: astore 18
    //   1237: aload 14
    //   1239: astore 17
    //   1241: aload 13
    //   1243: astore 20
    //   1245: aload 14
    //   1247: astore 19
    //   1249: aload_1
    //   1250: getfield 624	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1253: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1256: invokevirtual 775	java/lang/String:toLowerCase	()Ljava/lang/String;
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
    //   1278: getfield 746	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
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
    //   1304: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1307: if_icmpne +418 -> 1725
    //   1310: aload 13
    //   1312: astore 18
    //   1314: aload 14
    //   1316: astore 17
    //   1318: aload 13
    //   1320: astore 20
    //   1322: aload 14
    //   1324: astore 19
    //   1326: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq +29 -> 1358
    //   1332: aload 13
    //   1334: astore 18
    //   1336: aload 14
    //   1338: astore 17
    //   1340: aload 13
    //   1342: astore 20
    //   1344: aload 14
    //   1346: astore 19
    //   1348: ldc_w 690
    //   1351: iconst_2
    //   1352: ldc_w 777
    //   1355: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1377: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1380: aload 14
    //   1382: ifnull +8 -> 1390
    //   1385: aload 14
    //   1387: invokevirtual 454	java/io/OutputStream:close	()V
    //   1390: aload 13
    //   1392: ifnull +8 -> 1400
    //   1395: aload 13
    //   1397: invokevirtual 446	java/io/InputStream:close	()V
    //   1400: aload 15
    //   1402: ifnull +8 -> 1410
    //   1405: aload 15
    //   1407: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   1410: aload 16
    //   1412: ifnull +2986 -> 4398
    //   1415: aload 16
    //   1417: invokevirtual 342	java/io/File:delete	()Z
    //   1420: pop
    //   1421: aload 14
    //   1423: astore 19
    //   1425: aload 13
    //   1427: astore 18
    //   1429: aload 15
    //   1431: astore 17
    //   1433: aload_1
    //   1434: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1437: ifeq +51 -> 1488
    //   1440: aload_1
    //   1441: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1444: bipush 15
    //   1446: if_icmpne +2699 -> 4145
    //   1449: iconst_1
    //   1450: putstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   1453: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1456: ifeq +32 -> 1488
    //   1459: ldc_w 690
    //   1462: iconst_2
    //   1463: new 254	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 779
    //   1473: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: getstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   1479: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: iload 5
    //   1490: iconst_1
    //   1491: iadd
    //   1492: istore 5
    //   1494: aload_1
    //   1495: iload 5
    //   1497: iconst_2
    //   1498: invokestatic 782	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;II)Z
    //   1501: istore 9
    //   1503: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1506: ifeq +68 -> 1574
    //   1509: ldc_w 690
    //   1512: iconst_2
    //   1513: new 254	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1520: ldc_w 784
    //   1523: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload_1
    //   1527: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1530: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: ldc_w 786
    //   1536: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: iload 5
    //   1541: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1544: ldc_w 788
    //   1547: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: iload 9
    //   1552: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1555: ldc_w 461
    //   1558: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: aload_1
    //   1562: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1565: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1571: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1574: iload 9
    //   1576: ifeq +33 -> 1609
    //   1579: aload_1
    //   1580: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1583: iconst_2
    //   1584: if_icmpeq +25 -> 1609
    //   1587: aload_1
    //   1588: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1591: iconst_3
    //   1592: if_icmpeq +17 -> 1609
    //   1595: aload 23
    //   1597: monitorenter
    //   1598: aload 23
    //   1600: ldc2_w 462
    //   1603: invokevirtual 467	java/lang/Object:wait	(J)V
    //   1606: aload 23
    //   1608: monitorexit
    //   1609: iload 9
    //   1611: ifne +2772 -> 4383
    //   1614: aload_2
    //   1615: ifnull -1439 -> 176
    //   1618: aload_2
    //   1619: aload_1
    //   1620: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1623: aload_1
    //   1624: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1627: invokeinterface 252 3 0
    //   1632: return
    //   1633: aload 19
    //   1635: getstatic 637	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1638: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1641: ifeq +21 -> 1662
    //   1644: aload 22
    //   1646: aload 20
    //   1648: iload 4
    //   1650: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1653: astore 17
    //   1655: aload 17
    //   1657: astore 15
    //   1659: goto -1043 -> 616
    //   1662: aload 22
    //   1664: aload 20
    //   1666: iload 4
    //   1668: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1671: astore 17
    //   1673: aload 17
    //   1675: astore 15
    //   1677: goto -1061 -> 616
    //   1680: aload 22
    //   1682: aload 20
    //   1684: iload 4
    //   1686: invokestatic 639	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1689: astore 17
    //   1691: aload 17
    //   1693: astore 15
    //   1695: goto -1079 -> 616
    //   1698: new 225	java/net/URL
    //   1701: dup
    //   1702: aload 22
    //   1704: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1707: invokevirtual 643	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1710: checkcast 594	java/net/HttpURLConnection
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
    //   1745: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
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
    //   1769: ldc_w 790
    //   1772: invokevirtual 793	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1796: ldc_w 795
    //   1799: invokevirtual 793	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1824: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   1851: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1854: ifeq +2014 -> 3868
    //   1857: aload 13
    //   1859: astore 18
    //   1861: aload 14
    //   1863: astore 17
    //   1865: aload 13
    //   1867: astore 20
    //   1869: aload 14
    //   1871: astore 19
    //   1873: ldc_w 690
    //   1876: iconst_2
    //   1877: new 254	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1884: ldc_w 797
    //   1887: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: aload 24
    //   1892: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1921: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1924: istore 4
    //   1926: sipush 200
    //   1929: iload 4
    //   1931: if_icmpne +1849 -> 3780
    //   1934: aload 13
    //   1936: astore 18
    //   1938: aload 14
    //   1940: astore 17
    //   1942: aload_1
    //   1943: getfield 746	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   1946: ifeq +108 -> 2054
    //   1949: aload 13
    //   1951: astore 18
    //   1953: aload 14
    //   1955: astore 17
    //   1957: aload 15
    //   1959: ldc_w 799
    //   1962: invokevirtual 802	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1965: astore 19
    //   1967: aload 13
    //   1969: astore 18
    //   1971: aload 14
    //   1973: astore 17
    //   1975: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1978: ifeq +42 -> 2020
    //   1981: aload 13
    //   1983: astore 18
    //   1985: aload 14
    //   1987: astore 17
    //   1989: ldc_w 690
    //   1992: iconst_2
    //   1993: new 254	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2000: ldc_w 804
    //   2003: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: aload 15
    //   2008: invokevirtual 807	java/net/HttpURLConnection:getLastModified	()J
    //   2011: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2014: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2017: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2020: aload 13
    //   2022: astore 18
    //   2024: aload 14
    //   2026: astore 17
    //   2028: aload_0
    //   2029: invokevirtual 750	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   2032: invokeinterface 811 1 0
    //   2037: aload_1
    //   2038: getfield 813	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2041: aload 19
    //   2043: invokeinterface 819 3 0
    //   2048: invokeinterface 822 1 0
    //   2053: pop
    //   2054: aload 13
    //   2056: astore 18
    //   2058: aload 14
    //   2060: astore 17
    //   2062: aload_1
    //   2063: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2066: bipush 7
    //   2068: if_icmpeq +19 -> 2087
    //   2071: aload 13
    //   2073: astore 18
    //   2075: aload 14
    //   2077: astore 17
    //   2079: aload_1
    //   2080: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2083: iconst_1
    //   2084: if_icmpne +120 -> 2204
    //   2087: aload 13
    //   2089: astore 18
    //   2091: aload 14
    //   2093: astore 17
    //   2095: new 824	java/io/ByteArrayOutputStream
    //   2098: dup
    //   2099: invokespecial 825	java/io/ByteArrayOutputStream:<init>	()V
    //   2102: astore 19
    //   2104: aload 19
    //   2106: astore 14
    //   2108: aload 13
    //   2110: astore 18
    //   2112: aload 14
    //   2114: astore 19
    //   2116: aload 15
    //   2118: invokevirtual 828	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2121: astore 17
    //   2123: sipush 2048
    //   2126: newarray byte
    //   2128: astore 13
    //   2130: iconst_0
    //   2131: istore 4
    //   2133: aload 17
    //   2135: aload 13
    //   2137: invokevirtual 394	java/io/InputStream:read	([B)I
    //   2140: istore 6
    //   2142: iload 6
    //   2144: ifle +390 -> 2534
    //   2147: aload_3
    //   2148: ifnull +14 -> 2162
    //   2151: aload_3
    //   2152: ifnull +382 -> 2534
    //   2155: aload_3
    //   2156: invokevirtual 830	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()Z
    //   2159: ifeq +375 -> 2534
    //   2162: aload 14
    //   2164: aload 13
    //   2166: iconst_0
    //   2167: iload 6
    //   2169: invokevirtual 400	java/io/OutputStream:write	([BII)V
    //   2172: iload 4
    //   2174: iload 6
    //   2176: iadd
    //   2177: istore 4
    //   2179: aload_2
    //   2180: ifnull +2233 -> 4413
    //   2183: aload_2
    //   2184: aload_1
    //   2185: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2188: aload_1
    //   2189: getfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2192: i2l
    //   2193: iload 4
    //   2195: i2l
    //   2196: invokeinterface 403 6 0
    //   2201: goto -68 -> 2133
    //   2204: aload 13
    //   2206: astore 18
    //   2208: aload 14
    //   2210: astore 17
    //   2212: new 381	java/io/FileOutputStream
    //   2215: dup
    //   2216: aload 16
    //   2218: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   2246: invokevirtual 831	java/lang/Throwable:printStackTrace	()V
    //   2249: aload 17
    //   2251: astore 18
    //   2253: aload 14
    //   2255: astore 19
    //   2257: aload_1
    //   2258: aload 20
    //   2260: invokevirtual 832	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2263: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   2266: aload 17
    //   2268: astore 18
    //   2270: aload 14
    //   2272: astore 19
    //   2274: aload 20
    //   2276: instanceof 475
    //   2279: ifne +19 -> 2298
    //   2282: aload 17
    //   2284: astore 18
    //   2286: aload 14
    //   2288: astore 19
    //   2290: aload 20
    //   2292: instanceof 477
    //   2295: ifeq +857 -> 3152
    //   2298: aload 17
    //   2300: astore 18
    //   2302: aload 14
    //   2304: astore 19
    //   2306: aload_1
    //   2307: iconst_3
    //   2308: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2311: aload 17
    //   2313: astore 18
    //   2315: aload 14
    //   2317: astore 19
    //   2319: aload_1
    //   2320: getfield 739	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2323: ifeq +1446 -> 3769
    //   2326: aload 17
    //   2328: astore 18
    //   2330: aload 14
    //   2332: astore 19
    //   2334: invokestatic 837	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   2337: iconst_5
    //   2338: aload_1
    //   2339: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2342: invokevirtual 840	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
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
    //   2378: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   2409: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
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
    //   2440: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
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
    //   2473: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
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
    //   2512: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2515: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
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
    //   2539: invokevirtual 830	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()Z
    //   2542: ifne +296 -> 2838
    //   2545: aload_1
    //   2546: bipush 6
    //   2548: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2551: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2554: ifeq +33 -> 2587
    //   2557: ldc_w 690
    //   2560: iconst_2
    //   2561: new 254	java/lang/StringBuilder
    //   2564: dup
    //   2565: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2568: ldc_w 842
    //   2571: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: aload_1
    //   2575: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2578: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2584: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2587: aload_1
    //   2588: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2591: ifne +23 -> 2614
    //   2594: aload 14
    //   2596: instanceof 824
    //   2599: ifeq +15 -> 2614
    //   2602: aload_1
    //   2603: aload 14
    //   2605: checkcast 824	java/io/ByteArrayOutputStream
    //   2608: invokevirtual 846	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2611: putfield 849	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_ArrayOfByte	[B
    //   2614: aload_1
    //   2615: ifnull +134 -> 2749
    //   2618: aload_1
    //   2619: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2622: tableswitch	default:+1794 -> 4416, 1:+316->2938, 2:+316->2938, 3:+316->2938, 4:+316->2938, 5:+74->2696, 6:+316->2938, 7:+316->2938, 8:+316->2938, 9:+74->2696, 10:+432->3054, 11:+74->2696, 12:+432->3054, 13:+432->3054, 14:+432->3054, 15:+432->3054
    //   2697: iload 184
    //   2699: aconst_null
    //   2700: astore 153
    //   2702: aconst_null
    //   2703: if_acmpeq +1725 -> 4428
    //   2706: aconst_null
    //   2707: dconst_0
    //   2708: astore 13
    //   2710: aload 13
    //   2712: iconst_0
    //   2713: ldc_w 421
    //   2716: aastore
    //   2717: aload 13
    //   2719: iconst_1
    //   2720: ldc_w 423
    //   2723: aastore
    //   2724: aload 13
    //   2726: iconst_2
    //   2727: ldc_w 425
    //   2730: aastore
    //   2731: aload 13
    //   2733: ifnull +16 -> 2749
    //   2736: aload_0
    //   2737: aload_0
    //   2738: invokevirtual 428	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   2741: aload 13
    //   2743: iload 4
    //   2745: i2l
    //   2746: invokevirtual 431	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   2749: aload_1
    //   2750: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   2753: iconst_1
    //   2754: if_icmpeq +17 -> 2771
    //   2757: aload 16
    //   2759: ifnull +12 -> 2771
    //   2762: aload 16
    //   2764: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   2767: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   2770: pop
    //   2771: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2774: ifeq +1645 -> 4419
    //   2777: ldc_w 690
    //   2780: iconst_2
    //   2781: new 254	java/lang/StringBuilder
    //   2784: dup
    //   2785: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2788: ldc_w 851
    //   2791: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   2797: lload 7
    //   2799: lsub
    //   2800: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2803: ldc_w 439
    //   2806: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: aload_1
    //   2810: getfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2813: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2816: ldc_w 441
    //   2819: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2822: aload_1
    //   2823: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2826: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2829: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2832: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2835: goto +1584 -> 4419
    //   2838: aload_1
    //   2839: new 254	java/lang/StringBuilder
    //   2842: dup
    //   2843: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2846: iload 4
    //   2848: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2851: ldc_w 853
    //   2854: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2857: aload_1
    //   2858: getfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2861: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2864: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2867: putfield 855	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   2870: aload_1
    //   2871: iconst_0
    //   2872: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2875: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2878: ifeq -291 -> 2587
    //   2881: ldc_w 690
    //   2884: iconst_2
    //   2885: new 254	java/lang/StringBuilder
    //   2888: dup
    //   2889: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2892: ldc_w 857
    //   2895: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2898: iload 4
    //   2900: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2903: ldc_w 471
    //   2906: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2909: aload_1
    //   2910: getfield 620	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   2913: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2916: ldc_w 473
    //   2919: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2922: aload_1
    //   2923: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2926: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2932: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2935: goto -348 -> 2587
    //   2938: aload 21
    //   2940: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   2943: ifeq +81 -> 3024
    //   2946: iconst_3
    //   2947: anewarray 270	java/lang/String
    //   2950: astore 13
    //   2952: aload 13
    //   2954: iconst_0
    //   2955: ldc_w 859
    //   2958: aastore
    //   2959: aload 13
    //   2961: iconst_1
    //   2962: ldc_w 423
    //   2965: aastore
    //   2966: aload 13
    //   2968: iconst_2
    //   2969: ldc_w 425
    //   2972: aastore
    //   2973: goto -242 -> 2731
    //   2976: astore_0
    //   2977: aload 17
    //   2979: astore 13
    //   2981: aload 14
    //   2983: ifnull +8 -> 2991
    //   2986: aload 14
    //   2988: invokevirtual 454	java/io/OutputStream:close	()V
    //   2991: aload 13
    //   2993: ifnull +8 -> 3001
    //   2996: aload 13
    //   2998: invokevirtual 446	java/io/InputStream:close	()V
    //   3001: aload 15
    //   3003: ifnull +8 -> 3011
    //   3006: aload 15
    //   3008: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   3011: aload 16
    //   3013: ifnull +9 -> 3022
    //   3016: aload 16
    //   3018: invokevirtual 342	java/io/File:delete	()Z
    //   3021: pop
    //   3022: aload_0
    //   3023: athrow
    //   3024: iconst_3
    //   3025: anewarray 270	java/lang/String
    //   3028: astore 13
    //   3030: aload 13
    //   3032: iconst_0
    //   3033: ldc_w 861
    //   3036: aastore
    //   3037: aload 13
    //   3039: iconst_1
    //   3040: ldc_w 498
    //   3043: aastore
    //   3044: aload 13
    //   3046: iconst_2
    //   3047: ldc_w 425
    //   3050: aastore
    //   3051: goto -320 -> 2731
    //   3054: aload 21
    //   3056: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   3059: ifeq +33 -> 3092
    //   3062: iconst_3
    //   3063: anewarray 270	java/lang/String
    //   3066: astore 13
    //   3068: aload 13
    //   3070: iconst_0
    //   3071: ldc_w 863
    //   3074: aastore
    //   3075: aload 13
    //   3077: iconst_1
    //   3078: ldc_w 423
    //   3081: aastore
    //   3082: aload 13
    //   3084: iconst_2
    //   3085: ldc_w 425
    //   3088: aastore
    //   3089: goto -358 -> 2731
    //   3092: iconst_3
    //   3093: anewarray 270	java/lang/String
    //   3096: astore 13
    //   3098: aload 13
    //   3100: iconst_0
    //   3101: ldc_w 865
    //   3104: aastore
    //   3105: aload 13
    //   3107: iconst_1
    //   3108: ldc_w 498
    //   3111: aastore
    //   3112: aload 13
    //   3114: iconst_2
    //   3115: ldc_w 425
    //   3118: aastore
    //   3119: goto -388 -> 2731
    //   3122: iconst_3
    //   3123: anewarray 270	java/lang/String
    //   3126: astore 13
    //   3128: aload 13
    //   3130: iconst_0
    //   3131: ldc_w 500
    //   3134: aastore
    //   3135: aload 13
    //   3137: iconst_1
    //   3138: ldc_w 498
    //   3141: aastore
    //   3142: aload 13
    //   3144: iconst_2
    //   3145: ldc_w 425
    //   3148: aastore
    //   3149: goto -418 -> 2731
    //   3152: aload 17
    //   3154: astore 18
    //   3156: aload 14
    //   3158: astore 19
    //   3160: aload 20
    //   3162: instanceof 867
    //   3165: ifeq +28 -> 3193
    //   3168: aload 17
    //   3170: astore 18
    //   3172: aload 14
    //   3174: astore 19
    //   3176: aload_1
    //   3177: bipush 14
    //   3179: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   3203: instanceof 502
    //   3206: ifeq +28 -> 3234
    //   3209: aload 17
    //   3211: astore 18
    //   3213: aload 14
    //   3215: astore 19
    //   3217: aload_1
    //   3218: bipush 11
    //   3220: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   3244: instanceof 869
    //   3247: ifeq +509 -> 3756
    //   3250: aload 17
    //   3252: astore 18
    //   3254: aload 14
    //   3256: astore 19
    //   3258: aload_1
    //   3259: bipush 12
    //   3261: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3264: aload 17
    //   3266: astore 18
    //   3268: aload 14
    //   3270: astore 19
    //   3272: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3275: ifeq +42 -> 3317
    //   3278: aload 17
    //   3280: astore 18
    //   3282: aload 14
    //   3284: astore 19
    //   3286: ldc_w 690
    //   3289: iconst_4
    //   3290: new 254	java/lang/StringBuilder
    //   3293: dup
    //   3294: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   3297: ldc_w 871
    //   3300: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: aload 20
    //   3305: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3308: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3317: aload 16
    //   3319: ifnull +59 -> 3378
    //   3322: aload 17
    //   3324: astore 18
    //   3326: aload 14
    //   3328: astore 19
    //   3330: aload 16
    //   3332: iconst_1
    //   3333: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   3336: aload 17
    //   3338: astore 18
    //   3340: aload 14
    //   3342: astore 19
    //   3344: aload_1
    //   3345: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3348: ifnull +365 -> 3713
    //   3351: aload 17
    //   3353: astore 18
    //   3355: aload 14
    //   3357: astore 19
    //   3359: aload_1
    //   3360: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3363: iconst_1
    //   3364: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   3367: aload 14
    //   3369: astore 13
    //   3371: aload 17
    //   3373: astore 14
    //   3375: goto -1022 -> 2353
    //   3378: aload 17
    //   3380: astore 18
    //   3382: aload 14
    //   3384: astore 19
    //   3386: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3389: ifeq -53 -> 3336
    //   3392: aload 17
    //   3394: astore 18
    //   3396: aload 14
    //   3398: astore 19
    //   3400: ldc_w 690
    //   3403: iconst_4
    //   3404: ldc_w 873
    //   3407: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   3444: invokevirtual 831	java/lang/Throwable:printStackTrace	()V
    //   3447: aload_1
    //   3448: getfield 739	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3451: ifeq +14 -> 3465
    //   3454: invokestatic 837	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3457: iconst_5
    //   3458: aload_1
    //   3459: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3462: invokevirtual 840	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3465: aload_1
    //   3466: aload 17
    //   3468: invokevirtual 832	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3471: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:e	Ljava/lang/String;
    //   3474: iconst_0
    //   3475: istore 12
    //   3477: aload 17
    //   3479: instanceof 217
    //   3482: ifeq +407 -> 3889
    //   3485: aload_1
    //   3486: bipush 13
    //   3488: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3491: iload 12
    //   3493: istore 11
    //   3495: iload 10
    //   3497: ifne +85 -> 3582
    //   3500: iload 11
    //   3502: ifeq +80 -> 3582
    //   3505: iload 9
    //   3507: ifeq +613 -> 4120
    //   3510: iconst_1
    //   3511: putstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   3514: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3517: ifeq +65 -> 3582
    //   3520: ldc_w 690
    //   3523: iconst_2
    //   3524: new 254	java/lang/StringBuilder
    //   3527: dup
    //   3528: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   3531: ldc_w 875
    //   3534: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3537: getstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   3540: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3543: ldc_w 877
    //   3546: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3549: iload 10
    //   3551: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3554: ldc_w 879
    //   3557: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: iload 11
    //   3562: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3565: ldc_w 730
    //   3568: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: iload 9
    //   3573: invokevirtual 693	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3576: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3579: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3582: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3585: ifeq +60 -> 3645
    //   3588: ldc_w 690
    //   3591: iconst_2
    //   3592: new 254	java/lang/StringBuilder
    //   3595: dup
    //   3596: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   3599: ldc_w 881
    //   3602: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3605: aload_1
    //   3606: getfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3609: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3612: ldc_w 486
    //   3615: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: aload_1
    //   3619: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3622: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: ldc_w 488
    //   3628: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: aload 17
    //   3633: invokevirtual 832	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3636: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3639: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3642: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3645: aload 15
    //   3647: ifnull +8 -> 3655
    //   3650: aload 15
    //   3652: invokevirtual 454	java/io/OutputStream:close	()V
    //   3655: aload 14
    //   3657: ifnull +8 -> 3665
    //   3660: aload 14
    //   3662: invokevirtual 446	java/io/InputStream:close	()V
    //   3665: aload 13
    //   3667: ifnull +8 -> 3675
    //   3670: aload 13
    //   3672: invokevirtual 632	java/net/HttpURLConnection:disconnect	()V
    //   3675: aload 13
    //   3677: astore 17
    //   3679: aload 14
    //   3681: astore 18
    //   3683: aload 15
    //   3685: astore 19
    //   3687: aload 16
    //   3689: ifnull -2256 -> 1433
    //   3692: aload 16
    //   3694: invokevirtual 342	java/io/File:delete	()Z
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
    //   3721: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3724: ifeq +45 -> 3769
    //   3727: aload 17
    //   3729: astore 18
    //   3731: aload 14
    //   3733: astore 19
    //   3735: ldc_w 690
    //   3738: iconst_4
    //   3739: ldc_w 883
    //   3742: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   3766: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   3799: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
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
    //   3827: getfield 739	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3830: ifeq +38 -> 3868
    //   3833: aload 13
    //   3835: astore 18
    //   3837: aload 14
    //   3839: astore 17
    //   3841: aload 13
    //   3843: astore 20
    //   3845: aload 14
    //   3847: astore 19
    //   3849: invokestatic 837	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3852: iconst_5
    //   3853: aload_1
    //   3854: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3857: invokevirtual 840	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
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
    //   3883: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   3886: goto -2476 -> 1410
    //   3889: aload 17
    //   3891: instanceof 482
    //   3894: ifeq +16 -> 3910
    //   3897: aload_1
    //   3898: bipush 10
    //   3900: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3903: iload 12
    //   3905: istore 11
    //   3907: goto -412 -> 3495
    //   3910: aload 17
    //   3912: instanceof 867
    //   3915: ifeq +16 -> 3931
    //   3918: aload_1
    //   3919: bipush 14
    //   3921: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3924: iload 12
    //   3926: istore 11
    //   3928: goto -433 -> 3495
    //   3931: aload 17
    //   3933: instanceof 475
    //   3936: ifne +11 -> 3947
    //   3939: aload 17
    //   3941: instanceof 477
    //   3944: ifeq +14 -> 3958
    //   3947: aload_1
    //   3948: iconst_2
    //   3949: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3952: iconst_1
    //   3953: istore 11
    //   3955: goto -460 -> 3495
    //   3958: aload 17
    //   3960: instanceof 502
    //   3963: ifeq +15 -> 3978
    //   3966: aload_1
    //   3967: bipush 11
    //   3969: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3972: iconst_1
    //   3973: istore 11
    //   3975: goto -480 -> 3495
    //   3978: aload 17
    //   3980: instanceof 869
    //   3983: ifeq +125 -> 4108
    //   3986: aload_1
    //   3987: bipush 12
    //   3989: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   3992: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3995: ifeq +34 -> 4029
    //   3998: ldc_w 690
    //   4001: iconst_4
    //   4002: new 254	java/lang/StringBuilder
    //   4005: dup
    //   4006: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   4009: ldc_w 885
    //   4012: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: aload 17
    //   4017: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4020: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4023: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4026: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4029: aload 16
    //   4031: ifnull +31 -> 4062
    //   4034: aload 16
    //   4036: iconst_1
    //   4037: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   4040: aload_1
    //   4041: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4044: ifnull +37 -> 4081
    //   4047: aload_1
    //   4048: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4051: iconst_1
    //   4052: invokestatic 709	com/tencent/mobileqq/emosm/EmosmUtils:printLocalFileSystemFail	(Ljava/io/File;Z)V
    //   4055: iload 12
    //   4057: istore 11
    //   4059: goto -564 -> 3495
    //   4062: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4065: ifeq -25 -> 4040
    //   4068: ldc_w 690
    //   4071: iconst_4
    //   4072: ldc_w 873
    //   4075: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4078: goto -38 -> 4040
    //   4081: iload 12
    //   4083: istore 11
    //   4085: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4088: ifeq -593 -> 3495
    //   4091: ldc_w 690
    //   4094: iconst_4
    //   4095: ldc_w 883
    //   4098: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4101: iload 12
    //   4103: istore 11
    //   4105: goto -610 -> 3495
    //   4108: aload_1
    //   4109: iconst_4
    //   4110: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   4113: iload 12
    //   4115: istore 11
    //   4117: goto -622 -> 3495
    //   4120: iconst_0
    //   4121: putstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   4124: goto -610 -> 3514
    //   4127: astore 17
    //   4129: aload 17
    //   4131: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   4134: goto -459 -> 3675
    //   4137: astore_1
    //   4138: aload_1
    //   4139: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   4142: goto -1131 -> 3011
    //   4145: aload_1
    //   4146: getfield 739	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   4149: ifeq +10 -> 4159
    //   4152: iconst_1
    //   4153: putstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
    //   4156: goto -2703 -> 1453
    //   4159: iconst_0
    //   4160: putstatic 190	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_Boolean	Z
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
    //   3879	137	17	localException1	Exception
    //   4127	68	17	localException2	Exception
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