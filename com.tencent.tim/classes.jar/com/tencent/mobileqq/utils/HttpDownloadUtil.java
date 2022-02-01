package com.tencent.mobileqq.utils;

import afka;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import aokl;
import aolf;
import aomi;
import aoog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.Header;
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
  public static String PROTOCOL_HTTPS;
  static IdleConnectionMonitorThread a;
  private static boolean bJO;
  private static String bqw;
  public static final DefaultHttpClient c;
  static long lastUseTime = ;
  
  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!aolf.azW())) {
          continue;
        }
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
        continue;
      }
      localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
      c = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
      c.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
      a = new IdleConnectionMonitorThread((ClientConnectionManager)localObject);
      a.setName("IdleConnectionMonitorThread");
      a.start();
      PROTOCOL_HTTPS = "https://";
      return;
      ((SchemeRegistry)localObject).register(new Scheme("https", new aoog(HttpDownloadUtil.class.getSimpleName()), 443));
    }
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, afka paramafka, NetworkInfo paramNetworkInfo, b paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +23 -> 24
    //   4: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 164
    //   12: iconst_2
    //   13: ldc 183
    //   15: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_5
    //   19: istore 6
    //   21: iload 6
    //   23: ireturn
    //   24: new 189	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   32: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 27
    //   37: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   40: lstore 12
    //   42: new 4	java/lang/Object
    //   45: dup
    //   46: invokespecial 172	java/lang/Object:<init>	()V
    //   49: astore 28
    //   51: aload_1
    //   52: getfield 199	afka:file	Ljava/io/File;
    //   55: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   58: astore 17
    //   60: aload 17
    //   62: ifnull +139 -> 201
    //   65: aload 17
    //   67: invokevirtual 208	java/io/File:exists	()Z
    //   70: ifne +131 -> 201
    //   73: aload 17
    //   75: invokevirtual 211	java/io/File:mkdirs	()Z
    //   78: ifne +123 -> 201
    //   81: aload_3
    //   82: ifnull +15 -> 97
    //   85: aload_3
    //   86: aload 27
    //   88: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   91: iconst_4
    //   92: invokeinterface 218 3 0
    //   97: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +31 -> 131
    //   103: ldc 164
    //   105: iconst_2
    //   106: new 220	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   113: ldc 223
    //   115: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   122: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iconst_4
    //   132: ireturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 231	java/net/MalformedURLException:printStackTrace	()V
    //   138: aload_1
    //   139: aload_0
    //   140: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   143: putfield 240	afka:errorDetail	Ljava/lang/String;
    //   146: iconst_5
    //   147: ireturn
    //   148: astore_0
    //   149: aload_3
    //   150: ifnull +15 -> 165
    //   153: aload_3
    //   154: aload 27
    //   156: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   159: iconst_4
    //   160: invokeinterface 218 3 0
    //   165: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +31 -> 199
    //   171: ldc 164
    //   173: iconst_2
    //   174: new 220	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   181: ldc 223
    //   183: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   190: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_4
    //   200: ireturn
    //   201: aconst_null
    //   202: astore 19
    //   204: aload_1
    //   205: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   208: astore 17
    //   210: new 242	org/apache/http/client/methods/HttpGet
    //   213: dup
    //   214: aload 17
    //   216: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   219: astore 26
    //   221: new 39	org/apache/http/params/BasicHttpParams
    //   224: dup
    //   225: invokespecial 42	org/apache/http/params/BasicHttpParams:<init>	()V
    //   228: astore 29
    //   230: aload 29
    //   232: ldc 245
    //   234: ldc 246
    //   236: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: invokeinterface 257 3 0
    //   244: pop
    //   245: aload 29
    //   247: ldc_w 259
    //   250: ldc 246
    //   252: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: invokeinterface 257 3 0
    //   260: pop
    //   261: invokestatic 264	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   264: astore 17
    //   266: invokestatic 268	android/net/Proxy:getDefaultPort	()I
    //   269: istore 5
    //   271: iconst_0
    //   272: istore 4
    //   274: aload_2
    //   275: ifnull +96 -> 371
    //   278: aload_2
    //   279: invokevirtual 273	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   282: astore 18
    //   284: aload_2
    //   285: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   288: ifeq +51 -> 339
    //   291: aload 18
    //   293: ifnull +14 -> 307
    //   296: aload 18
    //   298: ldc_w 281
    //   301: invokevirtual 285	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   304: ifeq +35 -> 339
    //   307: aload 17
    //   309: ifnull +30 -> 339
    //   312: iload 5
    //   314: ifle +25 -> 339
    //   317: aload 29
    //   319: ldc_w 287
    //   322: new 289	org/apache/http/HttpHost
    //   325: dup
    //   326: aload 17
    //   328: iload 5
    //   330: invokespecial 291	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   333: invokeinterface 257 3 0
    //   338: pop
    //   339: aload_2
    //   340: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   343: ifeq +574 -> 917
    //   346: sipush 2048
    //   349: istore 4
    //   351: aload 29
    //   353: ldc_w 293
    //   356: iload 4
    //   358: invokeinterface 297 3 0
    //   363: pop
    //   364: aload 26
    //   366: aload 29
    //   368: invokevirtual 301	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   371: new 201	java/io/File
    //   374: dup
    //   375: aload_1
    //   376: invokevirtual 304	afka:uu	()Ljava/lang/String;
    //   379: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   382: astore 30
    //   384: aload 30
    //   386: invokevirtual 208	java/io/File:exists	()Z
    //   389: ifeq +9 -> 398
    //   392: aload 30
    //   394: invokevirtual 308	java/io/File:delete	()Z
    //   397: pop
    //   398: aconst_null
    //   399: astore 17
    //   401: iconst_m1
    //   402: istore 9
    //   404: iconst_5
    //   405: istore 10
    //   407: iload 9
    //   409: ifne +38 -> 447
    //   412: aload 29
    //   414: ldc_w 287
    //   417: new 289	org/apache/http/HttpHost
    //   420: dup
    //   421: aload 27
    //   423: invokevirtual 311	java/net/URL:getHost	()Ljava/lang/String;
    //   426: aload 27
    //   428: invokevirtual 314	java/net/URL:getPort	()I
    //   431: invokespecial 291	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   434: invokeinterface 257 3 0
    //   439: pop
    //   440: aload 26
    //   442: aload 29
    //   444: invokevirtual 301	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   447: aload 19
    //   449: astore 24
    //   451: aload 17
    //   453: astore 20
    //   455: iload 4
    //   457: istore 6
    //   459: aload 19
    //   461: astore 23
    //   463: aload 17
    //   465: astore 21
    //   467: iload 4
    //   469: istore 8
    //   471: aload 19
    //   473: astore 25
    //   475: aload 17
    //   477: astore 22
    //   479: iload 10
    //   481: istore 7
    //   483: getstatic 123	com/tencent/mobileqq/utils/HttpDownloadUtil:c	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   486: new 289	org/apache/http/HttpHost
    //   489: dup
    //   490: aload 27
    //   492: invokevirtual 311	java/net/URL:getHost	()Ljava/lang/String;
    //   495: invokespecial 315	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   498: aload 26
    //   500: invokevirtual 319	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   503: astore 18
    //   505: aload 19
    //   507: astore 24
    //   509: aload 17
    //   511: astore 20
    //   513: iload 4
    //   515: istore 6
    //   517: aload 19
    //   519: astore 23
    //   521: aload 17
    //   523: astore 21
    //   525: iload 4
    //   527: istore 8
    //   529: aload 19
    //   531: astore 25
    //   533: aload 17
    //   535: astore 22
    //   537: iload 10
    //   539: istore 7
    //   541: aload 18
    //   543: invokeinterface 325 1 0
    //   548: astore 31
    //   550: aload 19
    //   552: astore 24
    //   554: aload 17
    //   556: astore 20
    //   558: iload 4
    //   560: istore 6
    //   562: aload 19
    //   564: astore 23
    //   566: aload 17
    //   568: astore 21
    //   570: iload 4
    //   572: istore 8
    //   574: aload 19
    //   576: astore 25
    //   578: aload 17
    //   580: astore 22
    //   582: iload 10
    //   584: istore 7
    //   586: aload 18
    //   588: invokeinterface 329 1 0
    //   593: pop
    //   594: aload 19
    //   596: astore 24
    //   598: aload 17
    //   600: astore 20
    //   602: iload 4
    //   604: istore 6
    //   606: aload 19
    //   608: astore 23
    //   610: aload 17
    //   612: astore 21
    //   614: iload 4
    //   616: istore 8
    //   618: aload 19
    //   620: astore 25
    //   622: aload 17
    //   624: astore 22
    //   626: iload 10
    //   628: istore 7
    //   630: aload 31
    //   632: invokeinterface 334 1 0
    //   637: istore 5
    //   639: aload_3
    //   640: ifnull +52 -> 692
    //   643: aload 19
    //   645: astore 24
    //   647: aload 17
    //   649: astore 20
    //   651: iload 4
    //   653: istore 6
    //   655: aload 19
    //   657: astore 23
    //   659: aload 17
    //   661: astore 21
    //   663: iload 4
    //   665: istore 8
    //   667: aload 19
    //   669: astore 25
    //   671: aload 17
    //   673: astore 22
    //   675: iload 10
    //   677: istore 7
    //   679: aload_3
    //   680: aload 27
    //   682: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   685: iload 5
    //   687: invokeinterface 337 3 0
    //   692: aload 19
    //   694: astore 24
    //   696: aload 17
    //   698: astore 20
    //   700: iload 4
    //   702: istore 6
    //   704: aload 19
    //   706: astore 23
    //   708: aload 17
    //   710: astore 21
    //   712: iload 4
    //   714: istore 8
    //   716: aload 19
    //   718: astore 25
    //   720: aload 17
    //   722: astore 22
    //   724: iload 10
    //   726: istore 7
    //   728: aload 18
    //   730: invokeinterface 341 1 0
    //   735: astore 17
    //   737: sipush 200
    //   740: iload 5
    //   742: if_icmpne +1434 -> 2176
    //   745: aload 19
    //   747: astore 24
    //   749: aload 17
    //   751: astore 20
    //   753: iload 4
    //   755: istore 6
    //   757: aload 19
    //   759: astore 23
    //   761: aload 17
    //   763: astore 21
    //   765: iload 4
    //   767: istore 8
    //   769: aload 19
    //   771: astore 25
    //   773: aload 17
    //   775: astore 22
    //   777: iload 10
    //   779: istore 7
    //   781: aload 17
    //   783: invokeinterface 346 1 0
    //   788: lstore 14
    //   790: aconst_null
    //   791: astore 20
    //   793: iconst_0
    //   794: istore 5
    //   796: new 348	java/io/FileOutputStream
    //   799: dup
    //   800: aload 30
    //   802: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   805: astore 18
    //   807: aload 17
    //   809: invokeinterface 355 1 0
    //   814: astore 19
    //   816: aload 19
    //   818: astore 20
    //   820: iload 4
    //   822: ifne +1889 -> 2711
    //   825: sipush 2048
    //   828: istore 4
    //   830: iload 4
    //   832: newarray byte
    //   834: astore 19
    //   836: iload 5
    //   838: i2l
    //   839: lload 14
    //   841: lcmp
    //   842: ifge +83 -> 925
    //   845: aload 20
    //   847: aload 19
    //   849: invokevirtual 361	java/io/InputStream:read	([B)I
    //   852: istore 6
    //   854: aload 18
    //   856: aload 19
    //   858: iconst_0
    //   859: iload 6
    //   861: invokevirtual 367	java/io/OutputStream:write	([BII)V
    //   864: iload 5
    //   866: iload 6
    //   868: iadd
    //   869: istore 5
    //   871: aload_3
    //   872: ifnull +1836 -> 2708
    //   875: aload_3
    //   876: aload 27
    //   878: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   881: lload 14
    //   883: iload 5
    //   885: i2l
    //   886: invokeinterface 371 6 0
    //   891: goto -55 -> 836
    //   894: astore 18
    //   896: new 242	org/apache/http/client/methods/HttpGet
    //   899: dup
    //   900: aload 17
    //   902: invokestatic 375	com/tencent/mobileqq/utils/HttpDownloadUtil:pA	(Ljava/lang/String;)Ljava/lang/String;
    //   905: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   908: astore 26
    //   910: goto -689 -> 221
    //   913: astore_0
    //   914: bipush 13
    //   916: ireturn
    //   917: sipush 4096
    //   920: istore 4
    //   922: goto -571 -> 351
    //   925: iload 5
    //   927: i2l
    //   928: lload 14
    //   930: lcmp
    //   931: ifne +656 -> 1587
    //   934: iconst_0
    //   935: istore 10
    //   937: iconst_0
    //   938: istore 11
    //   940: iconst_0
    //   941: istore 8
    //   943: iload 8
    //   945: istore 5
    //   947: iload 10
    //   949: istore 6
    //   951: iload 11
    //   953: istore 7
    //   955: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq +44 -> 1002
    //   961: iload 10
    //   963: istore 6
    //   965: iload 11
    //   967: istore 7
    //   969: ldc 164
    //   971: iconst_2
    //   972: new 220	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   979: ldc_w 377
    //   982: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload_1
    //   986: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   989: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: iload 8
    //   1000: istore 5
    //   1002: iload 5
    //   1004: istore 6
    //   1006: iload 5
    //   1008: istore 7
    //   1010: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1013: ifeq +53 -> 1066
    //   1016: iload 5
    //   1018: istore 6
    //   1020: iload 5
    //   1022: istore 7
    //   1024: ldc_w 379
    //   1027: iconst_2
    //   1028: new 220	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 381
    //   1038: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   1044: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: ldc_w 386
    //   1050: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_1
    //   1054: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1057: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: aload_1
    //   1067: ifnull +108 -> 1175
    //   1070: iload 5
    //   1072: istore 6
    //   1074: iload 5
    //   1076: istore 7
    //   1078: aload_1
    //   1079: getfield 389	afka:action	I
    //   1082: tableswitch	default:+1632 -> 2714, 10001:+665->1747
    //   1101: iconst_2
    //   1102: istore 6
    //   1104: iload 5
    //   1106: istore 7
    //   1108: aload_2
    //   1109: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1112: ifeq +1001 -> 2113
    //   1115: iload 5
    //   1117: istore 6
    //   1119: iload 5
    //   1121: istore 7
    //   1123: iconst_3
    //   1124: anewarray 233	java/lang/String
    //   1127: astore 19
    //   1129: aload 19
    //   1131: iconst_0
    //   1132: ldc_w 391
    //   1135: aastore
    //   1136: aload 19
    //   1138: iconst_1
    //   1139: ldc_w 393
    //   1142: aastore
    //   1143: aload 19
    //   1145: iconst_2
    //   1146: ldc_w 395
    //   1149: aastore
    //   1150: aload 19
    //   1152: ifnull +23 -> 1175
    //   1155: iload 5
    //   1157: istore 6
    //   1159: iload 5
    //   1161: istore 7
    //   1163: aload_0
    //   1164: aload_0
    //   1165: invokevirtual 400	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1168: aload 19
    //   1170: lload 14
    //   1172: invokevirtual 404	com/tencent/common/app/AppInterface:sendAppDataIncerment	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1175: iload 5
    //   1177: istore 6
    //   1179: iload 5
    //   1181: istore 7
    //   1183: aload 30
    //   1185: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   1188: invokevirtual 408	java/io/File:setLastModified	(J)Z
    //   1191: pop
    //   1192: iload 5
    //   1194: istore 6
    //   1196: iload 5
    //   1198: istore 7
    //   1200: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1203: ifeq +66 -> 1269
    //   1206: iload 5
    //   1208: istore 6
    //   1210: iload 5
    //   1212: istore 7
    //   1214: ldc 164
    //   1216: iconst_2
    //   1217: new 220	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1224: ldc_w 410
    //   1227: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   1233: lload 12
    //   1235: lsub
    //   1236: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1239: ldc_w 412
    //   1242: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: lload 14
    //   1247: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 414
    //   1253: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload_1
    //   1257: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1260: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1266: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1269: aload 20
    //   1271: ifnull +1434 -> 2705
    //   1274: iload 5
    //   1276: istore 7
    //   1278: iload 4
    //   1280: istore 6
    //   1282: aload 18
    //   1284: astore 21
    //   1286: iload 4
    //   1288: istore 8
    //   1290: aload 18
    //   1292: astore 22
    //   1294: aload 18
    //   1296: astore 23
    //   1298: aload 20
    //   1300: invokevirtual 420	java/io/InputStream:close	()V
    //   1303: iload 5
    //   1305: ifne +92 -> 1397
    //   1308: aload 18
    //   1310: astore 24
    //   1312: aload 17
    //   1314: astore 20
    //   1316: iload 4
    //   1318: istore 6
    //   1320: aload 18
    //   1322: astore 23
    //   1324: aload 17
    //   1326: astore 21
    //   1328: iload 4
    //   1330: istore 8
    //   1332: aload 18
    //   1334: astore 25
    //   1336: aload 17
    //   1338: astore 22
    //   1340: iload 5
    //   1342: istore 7
    //   1344: aload_1
    //   1345: getfield 199	afka:file	Ljava/io/File;
    //   1348: ifnull +49 -> 1397
    //   1351: aload 18
    //   1353: astore 24
    //   1355: aload 17
    //   1357: astore 20
    //   1359: iload 4
    //   1361: istore 6
    //   1363: aload 18
    //   1365: astore 23
    //   1367: aload 17
    //   1369: astore 21
    //   1371: iload 4
    //   1373: istore 8
    //   1375: aload 18
    //   1377: astore 25
    //   1379: aload 17
    //   1381: astore 22
    //   1383: iload 5
    //   1385: istore 7
    //   1387: aload 30
    //   1389: aload_1
    //   1390: getfield 199	afka:file	Ljava/io/File;
    //   1393: invokevirtual 424	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1396: pop
    //   1397: aload_3
    //   1398: ifnull +52 -> 1450
    //   1401: aload 18
    //   1403: astore 24
    //   1405: aload 17
    //   1407: astore 20
    //   1409: iload 4
    //   1411: istore 6
    //   1413: aload 18
    //   1415: astore 23
    //   1417: aload 17
    //   1419: astore 21
    //   1421: iload 4
    //   1423: istore 8
    //   1425: aload 18
    //   1427: astore 25
    //   1429: aload 17
    //   1431: astore 22
    //   1433: iload 5
    //   1435: istore 7
    //   1437: aload_3
    //   1438: aload 27
    //   1440: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   1443: iload 5
    //   1445: invokeinterface 218 3 0
    //   1450: aload 17
    //   1452: ifnull +10 -> 1462
    //   1455: aload 17
    //   1457: invokeinterface 427 1 0
    //   1462: aload 18
    //   1464: ifnull +1227 -> 2691
    //   1467: aload 18
    //   1469: invokevirtual 428	java/io/OutputStream:close	()V
    //   1472: aload 18
    //   1474: astore 20
    //   1476: aload 17
    //   1478: astore 19
    //   1480: iload 9
    //   1482: iconst_1
    //   1483: iadd
    //   1484: istore 9
    //   1486: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: ifeq +43 -> 1532
    //   1492: ldc 164
    //   1494: iconst_2
    //   1495: new 220	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1502: ldc_w 430
    //   1505: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: iload 5
    //   1510: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1513: ldc_w 435
    //   1516: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload_1
    //   1520: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1523: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1532: iload 9
    //   1534: iconst_2
    //   1535: if_icmpge +22 -> 1557
    //   1538: iload 5
    //   1540: ifeq +17 -> 1557
    //   1543: aload 28
    //   1545: monitorenter
    //   1546: aload 28
    //   1548: ldc2_w 436
    //   1551: invokevirtual 441	java/lang/Object:wait	(J)V
    //   1554: aload 28
    //   1556: monitorexit
    //   1557: iload 5
    //   1559: istore 6
    //   1561: iload 5
    //   1563: ifeq -1542 -> 21
    //   1566: iload 5
    //   1568: istore 6
    //   1570: iload 9
    //   1572: iconst_2
    //   1573: if_icmpge -1552 -> 21
    //   1576: aload 19
    //   1578: astore 17
    //   1580: aload 20
    //   1582: astore 19
    //   1584: goto -1180 -> 404
    //   1587: bipush 8
    //   1589: istore 8
    //   1591: iload 8
    //   1593: istore 6
    //   1595: iload 8
    //   1597: istore 7
    //   1599: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1602: ifeq +62 -> 1664
    //   1605: iload 8
    //   1607: istore 6
    //   1609: iload 8
    //   1611: istore 7
    //   1613: ldc 164
    //   1615: iconst_2
    //   1616: new 220	java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1623: ldc_w 443
    //   1626: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: iload 5
    //   1631: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1634: ldc_w 445
    //   1637: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: lload 14
    //   1642: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: ldc_w 447
    //   1648: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload_1
    //   1652: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1655: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1664: iload 8
    //   1666: istore 5
    //   1668: iload 8
    //   1670: istore 6
    //   1672: iload 8
    //   1674: istore 7
    //   1676: aload 30
    //   1678: invokevirtual 208	java/io/File:exists	()Z
    //   1681: ifeq -679 -> 1002
    //   1684: iload 8
    //   1686: istore 6
    //   1688: iload 8
    //   1690: istore 7
    //   1692: aload 30
    //   1694: invokevirtual 308	java/io/File:delete	()Z
    //   1697: pop
    //   1698: iload 8
    //   1700: istore 5
    //   1702: goto -700 -> 1002
    //   1705: astore 19
    //   1707: iload 6
    //   1709: istore 5
    //   1711: aload 19
    //   1713: instanceof 449
    //   1716: ifne +15 -> 1731
    //   1719: aload 19
    //   1721: instanceof 451
    //   1724: istore 16
    //   1726: iload 16
    //   1728: ifeq +423 -> 2151
    //   1731: iconst_3
    //   1732: istore 5
    //   1734: aload 20
    //   1736: ifnull +966 -> 2702
    //   1739: aload 20
    //   1741: invokevirtual 420	java/io/InputStream:close	()V
    //   1744: goto -441 -> 1303
    //   1747: iload 5
    //   1749: istore 6
    //   1751: iload 5
    //   1753: istore 7
    //   1755: aload_2
    //   1756: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   1759: ifeq +316 -> 2075
    //   1762: iload 5
    //   1764: istore 6
    //   1766: iload 5
    //   1768: istore 7
    //   1770: iconst_3
    //   1771: anewarray 233	java/lang/String
    //   1774: astore 19
    //   1776: aload 19
    //   1778: iconst_0
    //   1779: ldc_w 453
    //   1782: aastore
    //   1783: aload 19
    //   1785: iconst_1
    //   1786: ldc_w 393
    //   1789: aastore
    //   1790: aload 19
    //   1792: iconst_2
    //   1793: ldc_w 395
    //   1796: aastore
    //   1797: goto -647 -> 1150
    //   1800: astore 19
    //   1802: iload 7
    //   1804: istore 5
    //   1806: aload 20
    //   1808: ifnull +32 -> 1840
    //   1811: iload 5
    //   1813: istore 7
    //   1815: iload 4
    //   1817: istore 6
    //   1819: aload 18
    //   1821: astore 21
    //   1823: iload 4
    //   1825: istore 8
    //   1827: aload 18
    //   1829: astore 22
    //   1831: aload 18
    //   1833: astore 23
    //   1835: aload 20
    //   1837: invokevirtual 420	java/io/InputStream:close	()V
    //   1840: iload 5
    //   1842: istore 7
    //   1844: iload 4
    //   1846: istore 6
    //   1848: aload 18
    //   1850: astore 21
    //   1852: iload 4
    //   1854: istore 8
    //   1856: aload 18
    //   1858: astore 22
    //   1860: aload 18
    //   1862: astore 23
    //   1864: aload 19
    //   1866: athrow
    //   1867: astore 19
    //   1869: aload 21
    //   1871: astore 18
    //   1873: iload 7
    //   1875: istore 5
    //   1877: aload 17
    //   1879: astore 21
    //   1881: aload 18
    //   1883: astore 20
    //   1885: aload 19
    //   1887: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   1890: aload 17
    //   1892: astore 21
    //   1894: aload 18
    //   1896: astore 20
    //   1898: aload 19
    //   1900: instanceof 456
    //   1903: ifeq +340 -> 2243
    //   1906: bipush 10
    //   1908: istore 7
    //   1910: aload 17
    //   1912: astore 21
    //   1914: aload 18
    //   1916: astore 20
    //   1918: ldc 164
    //   1920: iconst_2
    //   1921: new 220	java/lang/StringBuilder
    //   1924: dup
    //   1925: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1928: ldc_w 458
    //   1931: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: iload 7
    //   1936: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1939: ldc_w 460
    //   1942: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: aload_1
    //   1946: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1949: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: ldc_w 462
    //   1955: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload 19
    //   1960: invokevirtual 465	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1963: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_3
    //   1973: ifnull +24 -> 1997
    //   1976: aload 17
    //   1978: astore 21
    //   1980: aload 18
    //   1982: astore 20
    //   1984: aload_3
    //   1985: aload 27
    //   1987: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   1990: iload 7
    //   1992: invokeinterface 218 3 0
    //   1997: aload 17
    //   1999: ifnull +10 -> 2009
    //   2002: aload 17
    //   2004: invokeinterface 427 1 0
    //   2009: aload 17
    //   2011: astore 19
    //   2013: iload 6
    //   2015: istore 4
    //   2017: aload 18
    //   2019: astore 20
    //   2021: iload 7
    //   2023: istore 5
    //   2025: aload 18
    //   2027: ifnull -547 -> 1480
    //   2030: aload 18
    //   2032: invokevirtual 428	java/io/OutputStream:close	()V
    //   2035: aload 17
    //   2037: astore 19
    //   2039: iload 6
    //   2041: istore 4
    //   2043: aload 18
    //   2045: astore 20
    //   2047: iload 7
    //   2049: istore 5
    //   2051: goto -571 -> 1480
    //   2054: astore 19
    //   2056: aload 17
    //   2058: astore 19
    //   2060: iload 6
    //   2062: istore 4
    //   2064: aload 18
    //   2066: astore 20
    //   2068: iload 7
    //   2070: istore 5
    //   2072: goto -592 -> 1480
    //   2075: iload 5
    //   2077: istore 6
    //   2079: iload 5
    //   2081: istore 7
    //   2083: iconst_3
    //   2084: anewarray 233	java/lang/String
    //   2087: astore 19
    //   2089: aload 19
    //   2091: iconst_0
    //   2092: ldc_w 470
    //   2095: aastore
    //   2096: aload 19
    //   2098: iconst_1
    //   2099: ldc_w 472
    //   2102: aastore
    //   2103: aload 19
    //   2105: iconst_2
    //   2106: ldc_w 395
    //   2109: aastore
    //   2110: goto -960 -> 1150
    //   2113: iload 5
    //   2115: istore 6
    //   2117: iload 5
    //   2119: istore 7
    //   2121: iconst_3
    //   2122: anewarray 233	java/lang/String
    //   2125: astore 19
    //   2127: aload 19
    //   2129: iconst_0
    //   2130: ldc_w 474
    //   2133: aastore
    //   2134: aload 19
    //   2136: iconst_1
    //   2137: ldc_w 472
    //   2140: aastore
    //   2141: aload 19
    //   2143: iconst_2
    //   2144: ldc_w 395
    //   2147: aastore
    //   2148: goto -998 -> 1150
    //   2151: aload 19
    //   2153: instanceof 476
    //   2156: istore 16
    //   2158: iload 16
    //   2160: ifeq +10 -> 2170
    //   2163: bipush 11
    //   2165: istore 5
    //   2167: goto -433 -> 1734
    //   2170: iconst_4
    //   2171: istore 5
    //   2173: goto -439 -> 1734
    //   2176: aload_3
    //   2177: ifnull +36 -> 2213
    //   2180: aload 19
    //   2182: astore 24
    //   2184: aload 17
    //   2186: astore 20
    //   2188: iload 4
    //   2190: istore 6
    //   2192: aload 19
    //   2194: astore 23
    //   2196: aload 17
    //   2198: astore 21
    //   2200: aload_3
    //   2201: aload 27
    //   2203: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   2206: iload 5
    //   2208: invokeinterface 218 3 0
    //   2213: aload 19
    //   2215: astore 18
    //   2217: goto -767 -> 1450
    //   2220: astore 19
    //   2222: aload 19
    //   2224: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   2227: goto -765 -> 1462
    //   2230: astore 19
    //   2232: aload 17
    //   2234: astore 19
    //   2236: aload 18
    //   2238: astore 20
    //   2240: goto -760 -> 1480
    //   2243: aload 17
    //   2245: astore 21
    //   2247: aload 18
    //   2249: astore 20
    //   2251: aload 19
    //   2253: instanceof 449
    //   2256: ifne +461 -> 2717
    //   2259: aload 17
    //   2261: astore 21
    //   2263: aload 18
    //   2265: astore 20
    //   2267: aload 19
    //   2269: instanceof 451
    //   2272: ifeq +6 -> 2278
    //   2275: goto +442 -> 2717
    //   2278: aload 17
    //   2280: astore 21
    //   2282: aload 18
    //   2284: astore 20
    //   2286: aload 19
    //   2288: instanceof 476
    //   2291: ifeq +24 -> 2315
    //   2294: aload 17
    //   2296: astore 21
    //   2298: aload 18
    //   2300: astore 20
    //   2302: aload_1
    //   2303: bipush 11
    //   2305: putfield 479	afka:resultCode	I
    //   2308: iload 5
    //   2310: istore 7
    //   2312: goto -402 -> 1910
    //   2315: iconst_4
    //   2316: istore 7
    //   2318: goto -408 -> 1910
    //   2321: astore 19
    //   2323: aload 19
    //   2325: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   2328: goto -319 -> 2009
    //   2331: astore 19
    //   2333: iload 8
    //   2335: istore 6
    //   2337: aload 22
    //   2339: astore 18
    //   2341: aload 17
    //   2343: astore 21
    //   2345: aload 18
    //   2347: astore 20
    //   2349: aload 19
    //   2351: invokevirtual 480	java/lang/Exception:printStackTrace	()V
    //   2354: iconst_5
    //   2355: istore 7
    //   2357: aload_3
    //   2358: ifnull +23 -> 2381
    //   2361: aload 17
    //   2363: astore 21
    //   2365: aload 18
    //   2367: astore 20
    //   2369: aload_3
    //   2370: aload 27
    //   2372: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   2375: iconst_5
    //   2376: invokeinterface 218 3 0
    //   2381: aload 17
    //   2383: ifnull +10 -> 2393
    //   2386: aload 17
    //   2388: invokeinterface 427 1 0
    //   2393: aload 17
    //   2395: astore 19
    //   2397: iload 6
    //   2399: istore 4
    //   2401: aload 18
    //   2403: astore 20
    //   2405: iload 7
    //   2407: istore 5
    //   2409: aload 18
    //   2411: ifnull -931 -> 1480
    //   2414: aload 18
    //   2416: invokevirtual 428	java/io/OutputStream:close	()V
    //   2419: aload 17
    //   2421: astore 19
    //   2423: iload 6
    //   2425: istore 4
    //   2427: aload 18
    //   2429: astore 20
    //   2431: iload 7
    //   2433: istore 5
    //   2435: goto -955 -> 1480
    //   2438: astore 19
    //   2440: aload 17
    //   2442: astore 19
    //   2444: iload 6
    //   2446: istore 4
    //   2448: aload 18
    //   2450: astore 20
    //   2452: iload 7
    //   2454: istore 5
    //   2456: goto -976 -> 1480
    //   2459: astore 19
    //   2461: aload 19
    //   2463: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   2466: goto -73 -> 2393
    //   2469: astore_0
    //   2470: aload 23
    //   2472: astore_1
    //   2473: aload 17
    //   2475: ifnull +10 -> 2485
    //   2478: aload 17
    //   2480: invokeinterface 427 1 0
    //   2485: aload_1
    //   2486: ifnull +7 -> 2493
    //   2489: aload_1
    //   2490: invokevirtual 428	java/io/OutputStream:close	()V
    //   2493: aload_0
    //   2494: athrow
    //   2495: astore_2
    //   2496: aload_2
    //   2497: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   2500: goto -15 -> 2485
    //   2503: astore_0
    //   2504: aload 28
    //   2506: monitorexit
    //   2507: aload_0
    //   2508: athrow
    //   2509: astore_1
    //   2510: goto -17 -> 2493
    //   2513: astore 17
    //   2515: goto -961 -> 1554
    //   2518: astore_0
    //   2519: aload 18
    //   2521: astore_1
    //   2522: goto -49 -> 2473
    //   2525: astore_0
    //   2526: aload 24
    //   2528: astore_1
    //   2529: aload 20
    //   2531: astore 17
    //   2533: goto -60 -> 2473
    //   2536: astore_0
    //   2537: aload 21
    //   2539: astore 17
    //   2541: aload 20
    //   2543: astore_1
    //   2544: goto -71 -> 2473
    //   2547: astore 19
    //   2549: iload 4
    //   2551: istore 6
    //   2553: goto -212 -> 2341
    //   2556: astore 19
    //   2558: aload 23
    //   2560: astore 18
    //   2562: aload 21
    //   2564: astore 17
    //   2566: goto -225 -> 2341
    //   2569: astore 19
    //   2571: iload 4
    //   2573: istore 6
    //   2575: goto -698 -> 1877
    //   2578: astore 19
    //   2580: iload 8
    //   2582: istore 6
    //   2584: aload 25
    //   2586: astore 18
    //   2588: aload 22
    //   2590: astore 17
    //   2592: iload 7
    //   2594: istore 5
    //   2596: goto -719 -> 1877
    //   2599: astore 20
    //   2601: aload 19
    //   2603: astore 18
    //   2605: aload 20
    //   2607: astore 19
    //   2609: iload 4
    //   2611: istore 6
    //   2613: goto -736 -> 1877
    //   2616: astore 19
    //   2618: iconst_5
    //   2619: istore 5
    //   2621: goto -815 -> 1806
    //   2624: astore 19
    //   2626: goto -820 -> 1806
    //   2629: astore 21
    //   2631: aconst_null
    //   2632: astore 20
    //   2634: aload 19
    //   2636: astore 18
    //   2638: iconst_5
    //   2639: istore 5
    //   2641: aload 21
    //   2643: astore 19
    //   2645: goto -839 -> 1806
    //   2648: astore 19
    //   2650: aconst_null
    //   2651: astore 20
    //   2653: iconst_5
    //   2654: istore 5
    //   2656: goto -850 -> 1806
    //   2659: astore 19
    //   2661: iconst_5
    //   2662: istore 5
    //   2664: goto -953 -> 1711
    //   2667: astore 21
    //   2669: aload 19
    //   2671: astore 18
    //   2673: iconst_5
    //   2674: istore 5
    //   2676: aload 21
    //   2678: astore 19
    //   2680: goto -969 -> 1711
    //   2683: astore 19
    //   2685: iconst_5
    //   2686: istore 5
    //   2688: goto -977 -> 1711
    //   2691: aload 17
    //   2693: astore 19
    //   2695: aload 18
    //   2697: astore 20
    //   2699: goto -1219 -> 1480
    //   2702: goto -1399 -> 1303
    //   2705: goto -1402 -> 1303
    //   2708: goto -1872 -> 836
    //   2711: goto -1881 -> 830
    //   2714: goto -1614 -> 1100
    //   2717: iconst_2
    //   2718: istore 7
    //   2720: goto -810 -> 1910
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2723	0	paramAppInterface	AppInterface
    //   0	2723	1	paramafka	afka
    //   0	2723	2	paramNetworkInfo	NetworkInfo
    //   0	2723	3	paramb	b
    //   272	2338	4	i	int
    //   269	2418	5	j	int
    //   19	2593	6	k	int
    //   481	2238	7	m	int
    //   469	2112	8	n	int
    //   402	1172	9	i1	int
    //   405	557	10	i2	int
    //   938	28	11	i3	int
    //   40	1194	12	l1	long
    //   788	853	14	l2	long
    //   1724	435	16	bool	boolean
    //   58	2421	17	localObject1	Object
    //   2513	1	17	localInterruptedException	java.lang.InterruptedException
    //   2531	161	17	localObject2	Object
    //   282	573	18	localObject3	Object
    //   894	967	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1871	825	18	localObject4	Object
    //   202	1381	19	localObject5	Object
    //   1705	15	19	localIOException1	java.io.IOException
    //   1774	17	19	arrayOfString	String[]
    //   1800	65	19	localObject6	Object
    //   1867	92	19	localIOException2	java.io.IOException
    //   2011	27	19	localObject7	Object
    //   2054	1	19	localIOException3	java.io.IOException
    //   2058	156	19	localObject8	Object
    //   2220	3	19	localIOException4	java.io.IOException
    //   2230	1	19	localIOException5	java.io.IOException
    //   2234	53	19	localObject9	Object
    //   2321	3	19	localIOException6	java.io.IOException
    //   2331	19	19	localException1	Exception
    //   2395	27	19	localObject10	Object
    //   2438	1	19	localIOException7	java.io.IOException
    //   2442	1	19	localObject11	Object
    //   2459	3	19	localIOException8	java.io.IOException
    //   2547	1	19	localException2	Exception
    //   2556	1	19	localException3	Exception
    //   2569	1	19	localIOException9	java.io.IOException
    //   2578	24	19	localIOException10	java.io.IOException
    //   2607	1	19	localObject12	Object
    //   2616	1	19	localObject13	Object
    //   2624	11	19	localObject14	Object
    //   2643	1	19	localObject15	Object
    //   2648	1	19	localObject16	Object
    //   2659	11	19	localIOException11	java.io.IOException
    //   2678	1	19	localObject17	Object
    //   2683	1	19	localIOException12	java.io.IOException
    //   2693	1	19	localObject18	Object
    //   453	2089	20	localObject19	Object
    //   2599	7	20	localIOException13	java.io.IOException
    //   2632	66	20	localObject20	Object
    //   465	2098	21	localObject21	Object
    //   2629	13	21	localObject22	Object
    //   2667	10	21	localIOException14	java.io.IOException
    //   477	2112	22	localObject23	Object
    //   461	2098	23	localObject24	Object
    //   449	2078	24	localObject25	Object
    //   473	2112	25	localObject26	Object
    //   219	690	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   35	2336	27	localURL	URL
    //   49	2456	28	localObject27	Object
    //   228	215	29	localBasicHttpParams	BasicHttpParams
    //   382	1311	30	localFile	File
    //   548	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   24	37	133	java/net/MalformedURLException
    //   51	60	148	java/lang/Exception
    //   65	81	148	java/lang/Exception
    //   85	97	148	java/lang/Exception
    //   97	131	148	java/lang/Exception
    //   210	221	894	java/lang/IllegalArgumentException
    //   896	910	913	java/lang/IllegalArgumentException
    //   955	961	1705	java/io/IOException
    //   969	998	1705	java/io/IOException
    //   1010	1016	1705	java/io/IOException
    //   1024	1066	1705	java/io/IOException
    //   1078	1100	1705	java/io/IOException
    //   1108	1115	1705	java/io/IOException
    //   1123	1129	1705	java/io/IOException
    //   1163	1175	1705	java/io/IOException
    //   1183	1192	1705	java/io/IOException
    //   1200	1206	1705	java/io/IOException
    //   1214	1269	1705	java/io/IOException
    //   1599	1605	1705	java/io/IOException
    //   1613	1664	1705	java/io/IOException
    //   1676	1684	1705	java/io/IOException
    //   1692	1698	1705	java/io/IOException
    //   1755	1762	1705	java/io/IOException
    //   1770	1776	1705	java/io/IOException
    //   2083	2089	1705	java/io/IOException
    //   2121	2127	1705	java/io/IOException
    //   955	961	1800	finally
    //   969	998	1800	finally
    //   1010	1016	1800	finally
    //   1024	1066	1800	finally
    //   1078	1100	1800	finally
    //   1108	1115	1800	finally
    //   1123	1129	1800	finally
    //   1163	1175	1800	finally
    //   1183	1192	1800	finally
    //   1200	1206	1800	finally
    //   1214	1269	1800	finally
    //   1599	1605	1800	finally
    //   1613	1664	1800	finally
    //   1676	1684	1800	finally
    //   1692	1698	1800	finally
    //   1755	1762	1800	finally
    //   1770	1776	1800	finally
    //   2083	2089	1800	finally
    //   2121	2127	1800	finally
    //   1298	1303	1867	java/io/IOException
    //   1835	1840	1867	java/io/IOException
    //   1864	1867	1867	java/io/IOException
    //   2030	2035	2054	java/io/IOException
    //   1455	1462	2220	java/io/IOException
    //   1467	1472	2230	java/io/IOException
    //   2002	2009	2321	java/io/IOException
    //   1298	1303	2331	java/lang/Exception
    //   1835	1840	2331	java/lang/Exception
    //   1864	1867	2331	java/lang/Exception
    //   2414	2419	2438	java/io/IOException
    //   2386	2393	2459	java/io/IOException
    //   1298	1303	2469	finally
    //   1835	1840	2469	finally
    //   1864	1867	2469	finally
    //   2478	2485	2495	java/io/IOException
    //   1546	1554	2503	finally
    //   1554	1557	2503	finally
    //   2504	2507	2503	finally
    //   2489	2493	2509	java/io/IOException
    //   1546	1554	2513	java/lang/InterruptedException
    //   1739	1744	2518	finally
    //   483	505	2525	finally
    //   541	550	2525	finally
    //   586	594	2525	finally
    //   630	639	2525	finally
    //   679	692	2525	finally
    //   728	737	2525	finally
    //   781	790	2525	finally
    //   1344	1351	2525	finally
    //   1387	1397	2525	finally
    //   1437	1450	2525	finally
    //   2200	2213	2525	finally
    //   1885	1890	2536	finally
    //   1898	1906	2536	finally
    //   1918	1972	2536	finally
    //   1984	1997	2536	finally
    //   2251	2259	2536	finally
    //   2267	2275	2536	finally
    //   2286	2294	2536	finally
    //   2302	2308	2536	finally
    //   2349	2354	2536	finally
    //   2369	2381	2536	finally
    //   1739	1744	2547	java/lang/Exception
    //   483	505	2556	java/lang/Exception
    //   541	550	2556	java/lang/Exception
    //   586	594	2556	java/lang/Exception
    //   630	639	2556	java/lang/Exception
    //   679	692	2556	java/lang/Exception
    //   728	737	2556	java/lang/Exception
    //   781	790	2556	java/lang/Exception
    //   1344	1351	2556	java/lang/Exception
    //   1387	1397	2556	java/lang/Exception
    //   1437	1450	2556	java/lang/Exception
    //   2200	2213	2556	java/lang/Exception
    //   1739	1744	2569	java/io/IOException
    //   483	505	2578	java/io/IOException
    //   541	550	2578	java/io/IOException
    //   586	594	2578	java/io/IOException
    //   630	639	2578	java/io/IOException
    //   679	692	2578	java/io/IOException
    //   728	737	2578	java/io/IOException
    //   781	790	2578	java/io/IOException
    //   1344	1351	2578	java/io/IOException
    //   1387	1397	2578	java/io/IOException
    //   1437	1450	2578	java/io/IOException
    //   2200	2213	2599	java/io/IOException
    //   830	836	2616	finally
    //   845	864	2616	finally
    //   875	891	2616	finally
    //   1711	1726	2624	finally
    //   2151	2158	2624	finally
    //   796	807	2629	finally
    //   807	816	2648	finally
    //   830	836	2659	java/io/IOException
    //   845	864	2659	java/io/IOException
    //   875	891	2659	java/io/IOException
    //   796	807	2667	java/io/IOException
    //   807	816	2683	java/io/IOException
  }
  
  public static int a(AppInterface paramAppInterface, afka paramafka, b paramb)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramafka, localNetworkInfo, paramb);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile, 2);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
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
      return a(paramAppInterface, paramString, paramFile, localNetworkInfo, paramInt);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 172	java/lang/Object:<init>	()V
    //   12: astore 29
    //   14: iload 4
    //   16: istore 6
    //   18: iload 4
    //   20: ifge +6 -> 26
    //   23: iconst_2
    //   24: istore 6
    //   26: aload_2
    //   27: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +15 -> 47
    //   35: aload_0
    //   36: invokevirtual 208	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 211	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   53: astore 19
    //   55: new 242	org/apache/http/client/methods/HttpGet
    //   58: dup
    //   59: aload 19
    //   61: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   64: astore 27
    //   66: new 39	org/apache/http/params/BasicHttpParams
    //   69: dup
    //   70: invokespecial 42	org/apache/http/params/BasicHttpParams:<init>	()V
    //   73: astore 30
    //   75: sipush 20000
    //   78: istore 5
    //   80: ldc 246
    //   82: istore 4
    //   84: aload_3
    //   85: ifnull +104 -> 189
    //   88: invokestatic 264	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   91: astore 19
    //   93: invokestatic 268	android/net/Proxy:getDefaultPort	()I
    //   96: istore 4
    //   98: aload_3
    //   99: invokevirtual 273	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   102: astore 20
    //   104: aload_3
    //   105: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   108: ifeq +51 -> 159
    //   111: aload 20
    //   113: ifnull +14 -> 127
    //   116: aload 20
    //   118: ldc_w 281
    //   121: invokevirtual 285	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +35 -> 159
    //   127: aload 19
    //   129: ifnull +30 -> 159
    //   132: iload 4
    //   134: ifle +25 -> 159
    //   137: aload 30
    //   139: ldc_w 287
    //   142: new 289	org/apache/http/HttpHost
    //   145: dup
    //   146: aload 19
    //   148: iload 4
    //   150: invokespecial 291	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   153: invokeinterface 257 3 0
    //   158: pop
    //   159: aload_3
    //   160: invokestatic 279	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   163: ifeq +897 -> 1060
    //   166: sipush 20000
    //   169: istore 5
    //   171: ldc 246
    //   173: istore 4
    //   175: aload 30
    //   177: ldc_w 293
    //   180: sipush 2048
    //   183: invokeinterface 297 3 0
    //   188: pop
    //   189: aload 30
    //   191: ldc 245
    //   193: iload 5
    //   195: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokeinterface 257 3 0
    //   203: pop
    //   204: aload 30
    //   206: ldc_w 259
    //   209: iload 4
    //   211: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 257 3 0
    //   219: pop
    //   220: aload 27
    //   222: aload 30
    //   224: invokevirtual 301	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   227: aload_2
    //   228: ifnull +15 -> 243
    //   231: aload_2
    //   232: invokevirtual 208	java/io/File:exists	()Z
    //   235: ifeq +8 -> 243
    //   238: aload_2
    //   239: invokevirtual 308	java/io/File:delete	()Z
    //   242: pop
    //   243: aconst_null
    //   244: astore 19
    //   246: iconst_m1
    //   247: istore 7
    //   249: aload_0
    //   250: astore_3
    //   251: aload 19
    //   253: astore_0
    //   254: iload 7
    //   256: ifne +36 -> 292
    //   259: aload 30
    //   261: ldc_w 287
    //   264: new 289	org/apache/http/HttpHost
    //   267: dup
    //   268: aload_1
    //   269: invokevirtual 311	java/net/URL:getHost	()Ljava/lang/String;
    //   272: aload_1
    //   273: invokevirtual 314	java/net/URL:getPort	()I
    //   276: invokespecial 291	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   279: invokeinterface 257 3 0
    //   284: pop
    //   285: aload 27
    //   287: aload 30
    //   289: invokevirtual 301	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   292: iconst_5
    //   293: istore 4
    //   295: aload_0
    //   296: astore 20
    //   298: aload_3
    //   299: astore 23
    //   301: aload_0
    //   302: astore 24
    //   304: aload_3
    //   305: astore 21
    //   307: aload_0
    //   308: astore 25
    //   310: aload_3
    //   311: astore 22
    //   313: aload_0
    //   314: astore 19
    //   316: aload_3
    //   317: astore 26
    //   319: getstatic 123	com/tencent/mobileqq/utils/HttpDownloadUtil:c	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   322: new 289	org/apache/http/HttpHost
    //   325: dup
    //   326: aload_1
    //   327: invokevirtual 311	java/net/URL:getHost	()Ljava/lang/String;
    //   330: invokespecial 315	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   333: aload 27
    //   335: invokevirtual 319	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   338: astore 28
    //   340: aload_0
    //   341: astore 20
    //   343: aload_3
    //   344: astore 23
    //   346: aload_0
    //   347: astore 24
    //   349: aload_3
    //   350: astore 21
    //   352: aload_0
    //   353: astore 25
    //   355: aload_3
    //   356: astore 22
    //   358: aload_0
    //   359: astore 19
    //   361: aload_3
    //   362: astore 26
    //   364: aload 28
    //   366: invokeinterface 325 1 0
    //   371: invokeinterface 334 1 0
    //   376: istore 5
    //   378: aload_0
    //   379: astore 20
    //   381: aload_3
    //   382: astore 23
    //   384: aload_0
    //   385: astore 24
    //   387: aload_3
    //   388: astore 21
    //   390: aload_0
    //   391: astore 25
    //   393: aload_3
    //   394: astore 22
    //   396: aload_0
    //   397: astore 19
    //   399: aload_3
    //   400: astore 26
    //   402: aload 28
    //   404: invokeinterface 341 1 0
    //   409: astore_0
    //   410: sipush 200
    //   413: iload 5
    //   415: if_icmpne +822 -> 1237
    //   418: aload_0
    //   419: astore 20
    //   421: aload_3
    //   422: astore 23
    //   424: aload_0
    //   425: astore 24
    //   427: aload_3
    //   428: astore 21
    //   430: aload_0
    //   431: astore 25
    //   433: aload_3
    //   434: astore 22
    //   436: aload_0
    //   437: astore 19
    //   439: aload_3
    //   440: astore 26
    //   442: aload_0
    //   443: invokeinterface 346 1 0
    //   448: lstore 16
    //   450: lconst_0
    //   451: lstore 8
    //   453: aload_0
    //   454: astore 20
    //   456: aload_3
    //   457: astore 23
    //   459: aload_0
    //   460: astore 24
    //   462: aload_3
    //   463: astore 21
    //   465: aload_0
    //   466: astore 25
    //   468: aload_3
    //   469: astore 22
    //   471: new 504	java/io/BufferedOutputStream
    //   474: dup
    //   475: new 348	java/io/FileOutputStream
    //   478: dup
    //   479: aload_2
    //   480: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   483: invokespecial 507	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   486: astore 19
    //   488: lload 8
    //   490: lstore 10
    //   492: lload 8
    //   494: lstore 12
    //   496: aload 19
    //   498: astore 21
    //   500: aload 19
    //   502: astore 22
    //   504: aload 19
    //   506: astore 20
    //   508: aload_0
    //   509: aload 19
    //   511: invokeinterface 510 2 0
    //   516: lload 8
    //   518: lstore 10
    //   520: lload 8
    //   522: lstore 12
    //   524: aload 19
    //   526: astore 21
    //   528: aload 19
    //   530: astore 22
    //   532: aload 19
    //   534: astore 20
    //   536: aload 19
    //   538: invokevirtual 513	java/io/OutputStream:flush	()V
    //   541: lload 8
    //   543: lstore 10
    //   545: lload 8
    //   547: lstore 12
    //   549: aload 19
    //   551: astore 21
    //   553: aload 19
    //   555: astore 22
    //   557: aload 19
    //   559: astore 20
    //   561: aload_2
    //   562: invokevirtual 516	java/io/File:length	()J
    //   565: lstore 8
    //   567: lload 8
    //   569: lstore 10
    //   571: lload 8
    //   573: lstore 12
    //   575: aload 19
    //   577: astore 21
    //   579: aload 19
    //   581: astore 22
    //   583: aload 19
    //   585: astore 20
    //   587: aload_2
    //   588: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   591: invokevirtual 408	java/io/File:setLastModified	(J)Z
    //   594: pop
    //   595: lload 8
    //   597: lstore 10
    //   599: lload 8
    //   601: lstore 12
    //   603: aload 19
    //   605: astore 21
    //   607: aload 19
    //   609: astore 22
    //   611: aload 19
    //   613: astore 20
    //   615: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +75 -> 693
    //   621: lload 8
    //   623: lstore 10
    //   625: lload 8
    //   627: lstore 12
    //   629: aload 19
    //   631: astore 21
    //   633: aload 19
    //   635: astore 22
    //   637: aload 19
    //   639: astore 20
    //   641: ldc 164
    //   643: iconst_2
    //   644: new 220	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 410
    //   654: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: invokestatic 35	java/lang/System:currentTimeMillis	()J
    //   660: lload 14
    //   662: lsub
    //   663: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   666: ldc_w 518
    //   669: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: lload 8
    //   674: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   677: ldc_w 414
    //   680: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_1
    //   684: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: aload 19
    //   695: astore_3
    //   696: iconst_0
    //   697: istore 4
    //   699: iload 4
    //   701: istore 5
    //   703: lload 16
    //   705: lconst_0
    //   706: lcmp
    //   707: ifle +75 -> 782
    //   710: iload 4
    //   712: istore 5
    //   714: lload 8
    //   716: lload 16
    //   718: lcmp
    //   719: ifge +63 -> 782
    //   722: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +53 -> 778
    //   728: ldc 164
    //   730: iconst_2
    //   731: new 220	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 523
    //   741: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: lload 16
    //   746: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   749: ldc_w 525
    //   752: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_2
    //   756: invokevirtual 516	java/io/File:length	()J
    //   759: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   762: ldc_w 435
    //   765: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_1
    //   769: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: bipush 8
    //   780: istore 5
    //   782: aload_0
    //   783: ifnull +9 -> 792
    //   786: aload_0
    //   787: invokeinterface 427 1 0
    //   792: aload_3
    //   793: ifnull +7 -> 800
    //   796: aload_3
    //   797: invokevirtual 428	java/io/OutputStream:close	()V
    //   800: iload 5
    //   802: ifeq +1409 -> 2211
    //   805: aload_2
    //   806: ifnull +68 -> 874
    //   809: aload_2
    //   810: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   813: astore 19
    //   815: aload 19
    //   817: ifnull +17 -> 834
    //   820: aload 19
    //   822: invokevirtual 208	java/io/File:exists	()Z
    //   825: ifne +9 -> 834
    //   828: aload 19
    //   830: invokevirtual 211	java/io/File:mkdirs	()Z
    //   833: pop
    //   834: aload_2
    //   835: invokevirtual 208	java/io/File:exists	()Z
    //   838: ifeq +36 -> 874
    //   841: aload_2
    //   842: invokevirtual 308	java/io/File:delete	()Z
    //   845: istore 18
    //   847: ldc 164
    //   849: iconst_1
    //   850: new 220	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   857: ldc_w 527
    //   860: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: iload 18
    //   865: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   868: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: iload 7
    //   876: iconst_1
    //   877: iadd
    //   878: istore 7
    //   880: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq +40 -> 923
    //   886: ldc 164
    //   888: iconst_2
    //   889: new 220	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   896: ldc_w 430
    //   899: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: iload 5
    //   904: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: ldc_w 435
    //   910: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload_1
    //   914: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: iload 5
    //   925: ifeq +51 -> 976
    //   928: ldc 164
    //   930: iconst_1
    //   931: new 220	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 430
    //   941: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: iload 5
    //   946: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: ldc_w 435
    //   952: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_1
    //   956: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   959: ldc_w 532
    //   962: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: iload 7
    //   967: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: iload 5
    //   978: ifeq +23 -> 1001
    //   981: iload 7
    //   983: iconst_2
    //   984: if_icmpge +17 -> 1001
    //   987: aload 29
    //   989: monitorenter
    //   990: aload 29
    //   992: ldc2_w 533
    //   995: invokevirtual 441	java/lang/Object:wait	(J)V
    //   998: aload 29
    //   1000: monitorexit
    //   1001: iload 5
    //   1003: ifeq +10 -> 1013
    //   1006: iload 7
    //   1008: iload 6
    //   1010: if_icmplt +1198 -> 2208
    //   1013: iload 5
    //   1015: ireturn
    //   1016: astore_0
    //   1017: ldc 164
    //   1019: iconst_1
    //   1020: ldc_w 536
    //   1023: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1026: iconst_4
    //   1027: ireturn
    //   1028: astore 20
    //   1030: new 242	org/apache/http/client/methods/HttpGet
    //   1033: dup
    //   1034: aload 19
    //   1036: invokestatic 375	com/tencent/mobileqq/utils/HttpDownloadUtil:pA	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1042: astore 27
    //   1044: goto -978 -> 66
    //   1047: astore_0
    //   1048: ldc 164
    //   1050: iconst_1
    //   1051: ldc_w 538
    //   1054: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: bipush 13
    //   1059: ireturn
    //   1060: sipush 10000
    //   1063: istore 5
    //   1065: sipush 30000
    //   1068: istore 4
    //   1070: aload 30
    //   1072: ldc_w 293
    //   1075: sipush 4096
    //   1078: invokeinterface 297 3 0
    //   1083: pop
    //   1084: goto -895 -> 189
    //   1087: astore_3
    //   1088: lload 10
    //   1090: lstore 8
    //   1092: aload 19
    //   1094: astore_3
    //   1095: aload_3
    //   1096: astore 21
    //   1098: aload_3
    //   1099: astore 22
    //   1101: aload_3
    //   1102: astore 20
    //   1104: ldc 164
    //   1106: iconst_1
    //   1107: new 220	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1114: ldc_w 540
    //   1117: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: aload_2
    //   1121: invokevirtual 208	java/io/File:exists	()Z
    //   1124: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1127: ldc_w 542
    //   1130: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: aload_2
    //   1134: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   1137: invokevirtual 208	java/io/File:exists	()Z
    //   1140: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: iconst_5
    //   1150: istore 4
    //   1152: goto -453 -> 699
    //   1155: astore 28
    //   1157: aload 19
    //   1159: astore_3
    //   1160: lload 12
    //   1162: lstore 8
    //   1164: aload_0
    //   1165: astore 20
    //   1167: aload_3
    //   1168: astore 23
    //   1170: aload_0
    //   1171: astore 24
    //   1173: aload_3
    //   1174: astore 21
    //   1176: aload_0
    //   1177: astore 25
    //   1179: aload_3
    //   1180: astore 22
    //   1182: aload_0
    //   1183: astore 19
    //   1185: aload_3
    //   1186: astore 26
    //   1188: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1191: ifeq +40 -> 1231
    //   1194: aload_0
    //   1195: astore 20
    //   1197: aload_3
    //   1198: astore 23
    //   1200: aload_0
    //   1201: astore 24
    //   1203: aload_3
    //   1204: astore 21
    //   1206: aload_0
    //   1207: astore 25
    //   1209: aload_3
    //   1210: astore 22
    //   1212: aload_0
    //   1213: astore 19
    //   1215: aload_3
    //   1216: astore 26
    //   1218: ldc 164
    //   1220: iconst_2
    //   1221: aload 28
    //   1223: invokevirtual 465	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1226: aload 28
    //   1228: invokestatic 544	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1231: iconst_4
    //   1232: istore 4
    //   1234: goto -535 -> 699
    //   1237: goto -455 -> 782
    //   1240: astore 19
    //   1242: aload 19
    //   1244: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   1247: goto -455 -> 792
    //   1250: astore 19
    //   1252: goto -378 -> 874
    //   1255: astore 20
    //   1257: iconst_5
    //   1258: istore 4
    //   1260: aload_0
    //   1261: astore 19
    //   1263: aload 20
    //   1265: astore_0
    //   1266: aload_3
    //   1267: astore 20
    //   1269: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +30 -> 1302
    //   1275: ldc 164
    //   1277: iconst_2
    //   1278: new 220	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 546
    //   1288: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: aload_1
    //   1292: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1295: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: aload_0
    //   1299: invokestatic 544	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1302: aload_0
    //   1303: instanceof 456
    //   1306: istore 18
    //   1308: iload 18
    //   1310: ifeq +156 -> 1466
    //   1313: bipush 10
    //   1315: istore 4
    //   1317: aload 19
    //   1319: ifnull +10 -> 1329
    //   1322: aload 19
    //   1324: invokeinterface 427 1 0
    //   1329: aload 20
    //   1331: ifnull +8 -> 1339
    //   1334: aload 20
    //   1336: invokevirtual 428	java/io/OutputStream:close	()V
    //   1339: aload 19
    //   1341: astore_0
    //   1342: aload 20
    //   1344: astore_3
    //   1345: iload 4
    //   1347: istore 5
    //   1349: iload 4
    //   1351: ifeq -477 -> 874
    //   1354: aload 19
    //   1356: astore_0
    //   1357: aload 20
    //   1359: astore_3
    //   1360: iload 4
    //   1362: istore 5
    //   1364: aload_2
    //   1365: ifnull -491 -> 874
    //   1368: aload_2
    //   1369: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   1372: astore_0
    //   1373: aload_0
    //   1374: ifnull +15 -> 1389
    //   1377: aload_0
    //   1378: invokevirtual 208	java/io/File:exists	()Z
    //   1381: ifne +8 -> 1389
    //   1384: aload_0
    //   1385: invokevirtual 211	java/io/File:mkdirs	()Z
    //   1388: pop
    //   1389: aload 19
    //   1391: astore_0
    //   1392: aload 20
    //   1394: astore_3
    //   1395: iload 4
    //   1397: istore 5
    //   1399: aload_2
    //   1400: invokevirtual 208	java/io/File:exists	()Z
    //   1403: ifeq -529 -> 874
    //   1406: aload_2
    //   1407: invokevirtual 308	java/io/File:delete	()Z
    //   1410: istore 18
    //   1412: ldc 164
    //   1414: iconst_1
    //   1415: new 220	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1422: ldc_w 527
    //   1425: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: iload 18
    //   1430: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1439: aload 19
    //   1441: astore_0
    //   1442: aload 20
    //   1444: astore_3
    //   1445: iload 4
    //   1447: istore 5
    //   1449: goto -575 -> 874
    //   1452: astore_0
    //   1453: aload 19
    //   1455: astore_0
    //   1456: aload 20
    //   1458: astore_3
    //   1459: iload 4
    //   1461: istore 5
    //   1463: goto -589 -> 874
    //   1466: aload_0
    //   1467: instanceof 449
    //   1470: ifne +744 -> 2214
    //   1473: aload_0
    //   1474: instanceof 451
    //   1477: ifeq +6 -> 1483
    //   1480: goto +734 -> 2214
    //   1483: aload_0
    //   1484: instanceof 476
    //   1487: istore 18
    //   1489: iload 18
    //   1491: ifeq +10 -> 1501
    //   1494: bipush 11
    //   1496: istore 4
    //   1498: goto -181 -> 1317
    //   1501: iconst_4
    //   1502: istore 4
    //   1504: goto -187 -> 1317
    //   1507: astore_0
    //   1508: aload_0
    //   1509: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   1512: goto -183 -> 1329
    //   1515: astore_3
    //   1516: aload 21
    //   1518: astore 20
    //   1520: iload 4
    //   1522: istore 5
    //   1524: aload_3
    //   1525: astore 21
    //   1527: aload_0
    //   1528: astore 19
    //   1530: aload 19
    //   1532: astore_0
    //   1533: aload 20
    //   1535: astore_3
    //   1536: iload 5
    //   1538: istore 4
    //   1540: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1543: ifeq +41 -> 1584
    //   1546: aload 19
    //   1548: astore_0
    //   1549: aload 20
    //   1551: astore_3
    //   1552: iload 5
    //   1554: istore 4
    //   1556: ldc 164
    //   1558: iconst_2
    //   1559: new 220	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1566: ldc_w 548
    //   1569: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: aload_1
    //   1573: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: aload 21
    //   1581: invokestatic 544	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1584: iconst_5
    //   1585: istore 4
    //   1587: aload 19
    //   1589: ifnull +10 -> 1599
    //   1592: aload 19
    //   1594: invokeinterface 427 1 0
    //   1599: aload 20
    //   1601: ifnull +8 -> 1609
    //   1604: aload 20
    //   1606: invokevirtual 428	java/io/OutputStream:close	()V
    //   1609: aload 19
    //   1611: astore_0
    //   1612: aload 20
    //   1614: astore_3
    //   1615: iload 4
    //   1617: istore 5
    //   1619: aload_2
    //   1620: ifnull -746 -> 874
    //   1623: aload_2
    //   1624: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   1627: astore_0
    //   1628: aload_0
    //   1629: ifnull +15 -> 1644
    //   1632: aload_0
    //   1633: invokevirtual 208	java/io/File:exists	()Z
    //   1636: ifne +8 -> 1644
    //   1639: aload_0
    //   1640: invokevirtual 211	java/io/File:mkdirs	()Z
    //   1643: pop
    //   1644: aload 19
    //   1646: astore_0
    //   1647: aload 20
    //   1649: astore_3
    //   1650: iload 4
    //   1652: istore 5
    //   1654: aload_2
    //   1655: invokevirtual 208	java/io/File:exists	()Z
    //   1658: ifeq -784 -> 874
    //   1661: aload_2
    //   1662: invokevirtual 308	java/io/File:delete	()Z
    //   1665: istore 18
    //   1667: ldc 164
    //   1669: iconst_1
    //   1670: new 220	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1677: ldc_w 527
    //   1680: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: iload 18
    //   1685: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1694: aload 19
    //   1696: astore_0
    //   1697: aload 20
    //   1699: astore_3
    //   1700: iload 4
    //   1702: istore 5
    //   1704: goto -830 -> 874
    //   1707: astore_0
    //   1708: aload 19
    //   1710: astore_0
    //   1711: aload 20
    //   1713: astore_3
    //   1714: iload 4
    //   1716: istore 5
    //   1718: goto -844 -> 874
    //   1721: astore_0
    //   1722: aload_0
    //   1723: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   1726: goto -127 -> 1599
    //   1729: astore 21
    //   1731: aload 22
    //   1733: astore 20
    //   1735: iload 4
    //   1737: istore 5
    //   1739: aload_0
    //   1740: astore 19
    //   1742: aload 19
    //   1744: astore_0
    //   1745: aload 20
    //   1747: astore_3
    //   1748: iload 5
    //   1750: istore 4
    //   1752: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1755: ifeq +41 -> 1796
    //   1758: aload 19
    //   1760: astore_0
    //   1761: aload 20
    //   1763: astore_3
    //   1764: iload 5
    //   1766: istore 4
    //   1768: ldc 164
    //   1770: iconst_2
    //   1771: new 220	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1778: ldc_w 548
    //   1781: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload_1
    //   1785: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: aload 21
    //   1793: invokestatic 544	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1796: iconst_5
    //   1797: istore 4
    //   1799: aload 19
    //   1801: ifnull +10 -> 1811
    //   1804: aload 19
    //   1806: invokeinterface 427 1 0
    //   1811: aload 20
    //   1813: ifnull +8 -> 1821
    //   1816: aload 20
    //   1818: invokevirtual 428	java/io/OutputStream:close	()V
    //   1821: aload 19
    //   1823: astore_0
    //   1824: aload 20
    //   1826: astore_3
    //   1827: iload 4
    //   1829: istore 5
    //   1831: aload_2
    //   1832: ifnull -958 -> 874
    //   1835: aload_2
    //   1836: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   1839: astore_0
    //   1840: aload_0
    //   1841: ifnull +15 -> 1856
    //   1844: aload_0
    //   1845: invokevirtual 208	java/io/File:exists	()Z
    //   1848: ifne +8 -> 1856
    //   1851: aload_0
    //   1852: invokevirtual 211	java/io/File:mkdirs	()Z
    //   1855: pop
    //   1856: aload 19
    //   1858: astore_0
    //   1859: aload 20
    //   1861: astore_3
    //   1862: iload 4
    //   1864: istore 5
    //   1866: aload_2
    //   1867: invokevirtual 208	java/io/File:exists	()Z
    //   1870: ifeq -996 -> 874
    //   1873: aload_2
    //   1874: invokevirtual 308	java/io/File:delete	()Z
    //   1877: istore 18
    //   1879: ldc 164
    //   1881: iconst_1
    //   1882: new 220	java/lang/StringBuilder
    //   1885: dup
    //   1886: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1889: ldc_w 527
    //   1892: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: iload 18
    //   1897: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1900: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1903: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1906: aload 19
    //   1908: astore_0
    //   1909: aload 20
    //   1911: astore_3
    //   1912: iload 4
    //   1914: istore 5
    //   1916: goto -1042 -> 874
    //   1919: astore_0
    //   1920: aload 19
    //   1922: astore_0
    //   1923: aload 20
    //   1925: astore_3
    //   1926: iload 4
    //   1928: istore 5
    //   1930: goto -1056 -> 874
    //   1933: astore_0
    //   1934: aload_0
    //   1935: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   1938: goto -127 -> 1811
    //   1941: astore_1
    //   1942: aload 20
    //   1944: astore_3
    //   1945: aload_0
    //   1946: ifnull +9 -> 1955
    //   1949: aload_0
    //   1950: invokeinterface 427 1 0
    //   1955: aload_3
    //   1956: ifnull +7 -> 1963
    //   1959: aload_3
    //   1960: invokevirtual 428	java/io/OutputStream:close	()V
    //   1963: iload 4
    //   1965: ifeq +68 -> 2033
    //   1968: aload_2
    //   1969: ifnull +64 -> 2033
    //   1972: aload_2
    //   1973: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   1976: astore_0
    //   1977: aload_0
    //   1978: ifnull +15 -> 1993
    //   1981: aload_0
    //   1982: invokevirtual 208	java/io/File:exists	()Z
    //   1985: ifne +8 -> 1993
    //   1988: aload_0
    //   1989: invokevirtual 211	java/io/File:mkdirs	()Z
    //   1992: pop
    //   1993: aload_2
    //   1994: invokevirtual 208	java/io/File:exists	()Z
    //   1997: ifeq +36 -> 2033
    //   2000: aload_2
    //   2001: invokevirtual 308	java/io/File:delete	()Z
    //   2004: istore 18
    //   2006: ldc 164
    //   2008: iconst_1
    //   2009: new 220	java/lang/StringBuilder
    //   2012: dup
    //   2013: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   2016: ldc_w 527
    //   2019: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: iload 18
    //   2024: invokevirtual 530	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2027: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2030: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2033: aload_1
    //   2034: athrow
    //   2035: astore_0
    //   2036: aload_0
    //   2037: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   2040: goto -85 -> 1955
    //   2043: astore_0
    //   2044: aload 29
    //   2046: monitorexit
    //   2047: aload_0
    //   2048: athrow
    //   2049: astore 19
    //   2051: goto -1251 -> 800
    //   2054: astore_0
    //   2055: goto -716 -> 1339
    //   2058: astore_0
    //   2059: goto -450 -> 1609
    //   2062: astore_0
    //   2063: goto -242 -> 1821
    //   2066: astore_0
    //   2067: goto -104 -> 1963
    //   2070: astore 19
    //   2072: goto -1074 -> 998
    //   2075: astore_0
    //   2076: goto -43 -> 2033
    //   2079: astore_1
    //   2080: aload 23
    //   2082: astore_3
    //   2083: aload 20
    //   2085: astore_0
    //   2086: goto -141 -> 1945
    //   2089: astore_1
    //   2090: goto -145 -> 1945
    //   2093: astore_1
    //   2094: aload 19
    //   2096: astore_0
    //   2097: aload 20
    //   2099: astore_3
    //   2100: goto -155 -> 1945
    //   2103: astore_1
    //   2104: goto -159 -> 1945
    //   2107: astore_0
    //   2108: aload 24
    //   2110: astore 19
    //   2112: aload 21
    //   2114: astore 20
    //   2116: aload_0
    //   2117: astore 21
    //   2119: iload 4
    //   2121: istore 5
    //   2123: goto -381 -> 1742
    //   2126: astore 21
    //   2128: aload_0
    //   2129: astore 19
    //   2131: aload_3
    //   2132: astore 20
    //   2134: iload 4
    //   2136: istore 5
    //   2138: goto -396 -> 1742
    //   2141: astore 21
    //   2143: aload 25
    //   2145: astore 19
    //   2147: aload 22
    //   2149: astore 20
    //   2151: iload 4
    //   2153: istore 5
    //   2155: goto -625 -> 1530
    //   2158: astore 21
    //   2160: aload_0
    //   2161: astore 19
    //   2163: aload_3
    //   2164: astore 20
    //   2166: iload 4
    //   2168: istore 5
    //   2170: goto -640 -> 1530
    //   2173: astore_0
    //   2174: iconst_5
    //   2175: istore 4
    //   2177: aload 26
    //   2179: astore 20
    //   2181: goto -912 -> 1269
    //   2184: astore 21
    //   2186: aload_0
    //   2187: astore 19
    //   2189: aload_3
    //   2190: astore 20
    //   2192: aload 21
    //   2194: astore_0
    //   2195: goto -926 -> 1269
    //   2198: astore 28
    //   2200: goto -1036 -> 1164
    //   2203: astore 19
    //   2205: goto -1110 -> 1095
    //   2208: goto -1954 -> 254
    //   2211: goto -1337 -> 874
    //   2214: iconst_2
    //   2215: istore 4
    //   2217: goto -900 -> 1317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2220	0	paramAppInterface	AppInterface
    //   0	2220	1	paramURL	URL
    //   0	2220	2	paramFile	File
    //   0	2220	3	paramNetworkInfo	NetworkInfo
    //   0	2220	4	paramInt	int
    //   78	2091	5	i	int
    //   16	995	6	j	int
    //   247	764	7	k	int
    //   451	712	8	l1	long
    //   490	599	10	l2	long
    //   494	667	12	l3	long
    //   3	658	14	l4	long
    //   448	297	16	l5	long
    //   845	1178	18	bool	boolean
    //   53	1161	19	localObject1	Object
    //   1240	3	19	localIOException1	java.io.IOException
    //   1250	1	19	localException1	Exception
    //   1261	660	19	localAppInterface1	AppInterface
    //   2049	1	19	localIOException2	java.io.IOException
    //   2070	25	19	localInterruptedException	java.lang.InterruptedException
    //   2110	78	19	localObject2	Object
    //   2203	1	19	localFileNotFoundException	java.io.FileNotFoundException
    //   102	538	20	localObject3	Object
    //   1028	1	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1102	94	20	localObject4	Object
    //   1255	9	20	localIOException3	java.io.IOException
    //   1267	924	20	localObject5	Object
    //   305	1275	21	localObject6	Object
    //   1729	384	21	localThrowable1	java.lang.Throwable
    //   2117	1	21	localAppInterface2	AppInterface
    //   2126	1	21	localThrowable2	java.lang.Throwable
    //   2141	1	21	localException2	Exception
    //   2158	1	21	localException3	Exception
    //   2184	9	21	localIOException4	java.io.IOException
    //   311	1837	22	localObject7	Object
    //   299	1782	23	localNetworkInfo1	NetworkInfo
    //   302	1807	24	localAppInterface3	AppInterface
    //   308	1836	25	localAppInterface4	AppInterface
    //   317	1861	26	localNetworkInfo2	NetworkInfo
    //   64	979	27	localHttpGet	org.apache.http.client.methods.HttpGet
    //   338	65	28	localHttpResponse	org.apache.http.HttpResponse
    //   1155	72	28	localIOException5	java.io.IOException
    //   2198	1	28	localIOException6	java.io.IOException
    //   12	2033	29	localObject8	Object
    //   73	998	30	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   26	31	1016	java/lang/Exception
    //   35	47	1016	java/lang/Exception
    //   55	66	1028	java/lang/IllegalArgumentException
    //   1030	1044	1047	java/lang/IllegalArgumentException
    //   508	516	1087	java/io/FileNotFoundException
    //   536	541	1087	java/io/FileNotFoundException
    //   561	567	1087	java/io/FileNotFoundException
    //   587	595	1087	java/io/FileNotFoundException
    //   615	621	1087	java/io/FileNotFoundException
    //   641	693	1087	java/io/FileNotFoundException
    //   508	516	1155	java/io/IOException
    //   536	541	1155	java/io/IOException
    //   561	567	1155	java/io/IOException
    //   587	595	1155	java/io/IOException
    //   615	621	1155	java/io/IOException
    //   641	693	1155	java/io/IOException
    //   786	792	1240	java/io/IOException
    //   809	815	1250	java/lang/Exception
    //   820	834	1250	java/lang/Exception
    //   834	874	1250	java/lang/Exception
    //   1104	1149	1255	java/io/IOException
    //   1368	1373	1452	java/lang/Exception
    //   1377	1389	1452	java/lang/Exception
    //   1399	1439	1452	java/lang/Exception
    //   1322	1329	1507	java/io/IOException
    //   508	516	1515	java/lang/Exception
    //   536	541	1515	java/lang/Exception
    //   561	567	1515	java/lang/Exception
    //   587	595	1515	java/lang/Exception
    //   615	621	1515	java/lang/Exception
    //   641	693	1515	java/lang/Exception
    //   1104	1149	1515	java/lang/Exception
    //   1623	1628	1707	java/lang/Exception
    //   1632	1644	1707	java/lang/Exception
    //   1654	1694	1707	java/lang/Exception
    //   1592	1599	1721	java/io/IOException
    //   508	516	1729	java/lang/Throwable
    //   536	541	1729	java/lang/Throwable
    //   561	567	1729	java/lang/Throwable
    //   587	595	1729	java/lang/Throwable
    //   615	621	1729	java/lang/Throwable
    //   641	693	1729	java/lang/Throwable
    //   1104	1149	1729	java/lang/Throwable
    //   1835	1840	1919	java/lang/Exception
    //   1844	1856	1919	java/lang/Exception
    //   1866	1906	1919	java/lang/Exception
    //   1804	1811	1933	java/io/IOException
    //   508	516	1941	finally
    //   536	541	1941	finally
    //   561	567	1941	finally
    //   587	595	1941	finally
    //   615	621	1941	finally
    //   641	693	1941	finally
    //   1104	1149	1941	finally
    //   1949	1955	2035	java/io/IOException
    //   990	998	2043	finally
    //   998	1001	2043	finally
    //   2044	2047	2043	finally
    //   796	800	2049	java/io/IOException
    //   1334	1339	2054	java/io/IOException
    //   1604	1609	2058	java/io/IOException
    //   1816	1821	2062	java/io/IOException
    //   1959	1963	2066	java/io/IOException
    //   990	998	2070	java/lang/InterruptedException
    //   1972	1977	2075	java/lang/Exception
    //   1981	1993	2075	java/lang/Exception
    //   1993	2033	2075	java/lang/Exception
    //   319	340	2079	finally
    //   364	378	2079	finally
    //   402	410	2079	finally
    //   442	450	2079	finally
    //   471	488	2079	finally
    //   1188	1194	2079	finally
    //   1218	1231	2079	finally
    //   722	778	2089	finally
    //   1269	1302	2093	finally
    //   1302	1308	2093	finally
    //   1466	1480	2093	finally
    //   1483	1489	2093	finally
    //   1540	1546	2103	finally
    //   1556	1584	2103	finally
    //   1752	1758	2103	finally
    //   1768	1796	2103	finally
    //   319	340	2107	java/lang/Throwable
    //   364	378	2107	java/lang/Throwable
    //   402	410	2107	java/lang/Throwable
    //   442	450	2107	java/lang/Throwable
    //   471	488	2107	java/lang/Throwable
    //   1188	1194	2107	java/lang/Throwable
    //   1218	1231	2107	java/lang/Throwable
    //   722	778	2126	java/lang/Throwable
    //   319	340	2141	java/lang/Exception
    //   364	378	2141	java/lang/Exception
    //   402	410	2141	java/lang/Exception
    //   442	450	2141	java/lang/Exception
    //   471	488	2141	java/lang/Exception
    //   1188	1194	2141	java/lang/Exception
    //   1218	1231	2141	java/lang/Exception
    //   722	778	2158	java/lang/Exception
    //   319	340	2173	java/io/IOException
    //   364	378	2173	java/io/IOException
    //   402	410	2173	java/io/IOException
    //   442	450	2173	java/io/IOException
    //   1188	1194	2173	java/io/IOException
    //   1218	1231	2173	java/io/IOException
    //   722	778	2184	java/io/IOException
    //   471	488	2198	java/io/IOException
    //   471	488	2203	java/io/FileNotFoundException
  }
  
  public static afka a(String paramString, a parama)
  {
    return a(paramString, parama, null, 2, true);
  }
  
  public static afka a(String paramString, a parama, List<Header> paramList, int paramInt, boolean paramBoolean)
  {
    int i = aomi.a().getNetType();
    return a(paramString, parama, paramList, paramInt, paramBoolean, 0, c.jC(i), c.jB(i));
  }
  
  public static afka a(String paramString, a parama, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return a(paramString, parama, paramList, paramInt1, paramBoolean, 0, paramInt2, paramInt3);
  }
  
  /* Error */
  private static afka a(String paramString, a parama, List<Header> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 191	afka
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 577	afka:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 20
    //   12: iload 5
    //   14: iconst_3
    //   15: if_icmplt +30 -> 45
    //   18: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 164
    //   26: iconst_2
    //   27: ldc_w 579
    //   30: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload 20
    //   35: bipush 20
    //   37: putfield 479	afka:resultCode	I
    //   40: aload 20
    //   42: astore_0
    //   43: aload_0
    //   44: areturn
    //   45: new 189	java/net/URL
    //   48: dup
    //   49: aload 20
    //   51: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   54: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: pop
    //   58: aload 20
    //   60: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   63: astore 18
    //   65: new 242	org/apache/http/client/methods/HttpGet
    //   68: dup
    //   69: aload 18
    //   71: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   74: pop
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 172	java/lang/Object:<init>	()V
    //   82: astore 21
    //   84: aconst_null
    //   85: astore 14
    //   87: iconst_0
    //   88: istore 9
    //   90: ldc2_w 436
    //   93: lstore 11
    //   95: invokestatic 487	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   98: astore 22
    //   100: aload 22
    //   102: ifnonnull +196 -> 298
    //   105: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +12 -> 120
    //   111: ldc 164
    //   113: iconst_2
    //   114: ldc_w 581
    //   117: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: iconst_1
    //   123: putfield 479	afka:resultCode	I
    //   126: iload 9
    //   128: iconst_1
    //   129: iadd
    //   130: istore 8
    //   132: iload 8
    //   134: iload_3
    //   135: if_icmplt +133 -> 268
    //   138: aload_1
    //   139: ifnull +12 -> 151
    //   142: aload_1
    //   143: aload 20
    //   145: invokeinterface 584 2 0
    //   150: pop
    //   151: aload 20
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 164
    //   163: iconst_2
    //   164: aload_0
    //   165: invokevirtual 585	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   168: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 20
    //   173: aload_0
    //   174: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: putfield 240	afka:errorDetail	Ljava/lang/String;
    //   180: aload 20
    //   182: bipush 13
    //   184: putfield 479	afka:resultCode	I
    //   187: aload_1
    //   188: ifnull +12 -> 200
    //   191: aload_1
    //   192: aload 20
    //   194: invokeinterface 584 2 0
    //   199: pop
    //   200: aload 20
    //   202: areturn
    //   203: astore 14
    //   205: new 242	org/apache/http/client/methods/HttpGet
    //   208: dup
    //   209: aload 18
    //   211: invokestatic 375	com/tencent/mobileqq/utils/HttpDownloadUtil:pA	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokespecial 243	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: aload 18
    //   220: invokestatic 375	com/tencent/mobileqq/utils/HttpDownloadUtil:pA	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 18
    //   225: goto -150 -> 75
    //   228: astore_0
    //   229: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +13 -> 245
    //   235: ldc 164
    //   237: iconst_2
    //   238: aload_0
    //   239: invokevirtual 586	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   242: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 20
    //   247: bipush 13
    //   249: putfield 479	afka:resultCode	I
    //   252: aload_1
    //   253: ifnull +12 -> 265
    //   256: aload_1
    //   257: aload 20
    //   259: invokeinterface 584 2 0
    //   264: pop
    //   265: aload 20
    //   267: areturn
    //   268: aload 21
    //   270: monitorenter
    //   271: aload 21
    //   273: lload 11
    //   275: invokevirtual 441	java/lang/Object:wait	(J)V
    //   278: lload 11
    //   280: ldc2_w 587
    //   283: lmul
    //   284: lstore 11
    //   286: aload 21
    //   288: monitorexit
    //   289: goto +2073 -> 2362
    //   292: astore_0
    //   293: aload 21
    //   295: monitorexit
    //   296: aload_0
    //   297: athrow
    //   298: aconst_null
    //   299: astore 19
    //   301: iconst_m1
    //   302: istore 8
    //   304: aload 22
    //   306: ifnull +41 -> 347
    //   309: aload 14
    //   311: astore 17
    //   313: aload 14
    //   315: astore 16
    //   317: aload 14
    //   319: astore 15
    //   321: aload 22
    //   323: invokevirtual 273	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   326: astore 19
    //   328: aload 14
    //   330: astore 17
    //   332: aload 14
    //   334: astore 16
    //   336: aload 14
    //   338: astore 15
    //   340: aload 22
    //   342: invokevirtual 591	android/net/NetworkInfo:getType	()I
    //   345: istore 8
    //   347: aload 14
    //   349: astore 17
    //   351: aload 14
    //   353: astore 16
    //   355: aload 14
    //   357: astore 15
    //   359: invokestatic 264	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   362: astore 22
    //   364: aload 14
    //   366: astore 17
    //   368: aload 14
    //   370: astore 16
    //   372: aload 14
    //   374: astore 15
    //   376: invokestatic 268	android/net/Proxy:getDefaultPort	()I
    //   379: istore 10
    //   381: aload 14
    //   383: astore 17
    //   385: aload 14
    //   387: astore 16
    //   389: aload 14
    //   391: astore 15
    //   393: aload 19
    //   395: invokestatic 596	aqoj:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 19
    //   400: aload 14
    //   402: astore 17
    //   404: aload 14
    //   406: astore 16
    //   408: aload 14
    //   410: astore 15
    //   412: aload 19
    //   414: getstatic 598	com/tencent/mobileqq/utils/HttpDownloadUtil:bqw	Ljava/lang/String;
    //   417: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifne +65 -> 485
    //   423: aload 14
    //   425: astore 17
    //   427: aload 14
    //   429: astore 16
    //   431: aload 14
    //   433: astore 15
    //   435: aload 19
    //   437: putstatic 598	com/tencent/mobileqq/utils/HttpDownloadUtil:bqw	Ljava/lang/String;
    //   440: iload 8
    //   442: iconst_1
    //   443: if_icmpeq +26 -> 469
    //   446: aload 14
    //   448: astore 17
    //   450: aload 14
    //   452: astore 16
    //   454: aload 14
    //   456: astore 15
    //   458: aload 19
    //   460: getstatic 605	aqoj:APN_TYPE_CMWAP	Ljava/lang/String;
    //   463: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +558 -> 1024
    //   469: aload 14
    //   471: astore 17
    //   473: aload 14
    //   475: astore 16
    //   477: aload 14
    //   479: astore 15
    //   481: iconst_0
    //   482: putstatic 607	com/tencent/mobileqq/utils/HttpDownloadUtil:bJO	Z
    //   485: iload 8
    //   487: iconst_1
    //   488: if_icmpne +65 -> 553
    //   491: aload 14
    //   493: astore 17
    //   495: aload 14
    //   497: astore 16
    //   499: aload 14
    //   501: astore 15
    //   503: ldc_w 609
    //   506: aload 22
    //   508: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   511: ifne +26 -> 537
    //   514: aload 14
    //   516: astore 17
    //   518: aload 14
    //   520: astore 16
    //   522: aload 14
    //   524: astore 15
    //   526: ldc_w 611
    //   529: aload 22
    //   531: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +19 -> 553
    //   537: aload 14
    //   539: astore 17
    //   541: aload 14
    //   543: astore 16
    //   545: aload 14
    //   547: astore 15
    //   549: iconst_1
    //   550: putstatic 607	com/tencent/mobileqq/utils/HttpDownloadUtil:bJO	Z
    //   553: aload 14
    //   555: astore 17
    //   557: aload 14
    //   559: astore 16
    //   561: aload 14
    //   563: astore 15
    //   565: getstatic 607	com/tencent/mobileqq/utils/HttpDownloadUtil:bJO	Z
    //   568: ifne +704 -> 1272
    //   571: aload 22
    //   573: ifnull +699 -> 1272
    //   576: iload 10
    //   578: ifle +694 -> 1272
    //   581: aload 14
    //   583: astore 17
    //   585: aload 14
    //   587: astore 16
    //   589: aload 14
    //   591: astore 15
    //   593: aload 19
    //   595: getstatic 605	aqoj:APN_TYPE_CMWAP	Ljava/lang/String;
    //   598: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +49 -> 650
    //   604: aload 14
    //   606: astore 17
    //   608: aload 14
    //   610: astore 16
    //   612: aload 14
    //   614: astore 15
    //   616: aload 19
    //   618: getstatic 614	aqoj:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   621: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +26 -> 650
    //   627: aload 14
    //   629: astore 17
    //   631: aload 14
    //   633: astore 16
    //   635: aload 14
    //   637: astore 15
    //   639: aload 19
    //   641: getstatic 617	aqoj:APN_TYPE_3GWAP	Ljava/lang/String;
    //   644: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +550 -> 1197
    //   650: aload 14
    //   652: astore 17
    //   654: aload 14
    //   656: astore 16
    //   658: aload 14
    //   660: astore 15
    //   662: aload 18
    //   664: aload 22
    //   666: iload 10
    //   668: invokestatic 621	aqoj:getConnectionWithXOnlineHost	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   671: astore 14
    //   673: aload 14
    //   675: astore 17
    //   677: aload 14
    //   679: astore 16
    //   681: aload 14
    //   683: astore 15
    //   685: aload 20
    //   687: aload 14
    //   689: putfield 624	afka:e	Ljava/net/HttpURLConnection;
    //   692: aload_2
    //   693: ifnull +614 -> 1307
    //   696: aload 14
    //   698: astore 17
    //   700: aload 14
    //   702: astore 16
    //   704: aload 14
    //   706: astore 15
    //   708: aload_2
    //   709: invokeinterface 629 1 0
    //   714: ifne +593 -> 1307
    //   717: aload 14
    //   719: astore 17
    //   721: aload 14
    //   723: astore 16
    //   725: aload 14
    //   727: astore 15
    //   729: aload_2
    //   730: invokeinterface 633 1 0
    //   735: astore 19
    //   737: aload 14
    //   739: astore 17
    //   741: aload 14
    //   743: astore 16
    //   745: aload 14
    //   747: astore 15
    //   749: aload 19
    //   751: invokeinterface 638 1 0
    //   756: ifeq +551 -> 1307
    //   759: aload 14
    //   761: astore 17
    //   763: aload 14
    //   765: astore 16
    //   767: aload 14
    //   769: astore 15
    //   771: aload 19
    //   773: invokeinterface 642 1 0
    //   778: checkcast 644	org/apache/http/Header
    //   781: astore 22
    //   783: aload 14
    //   785: astore 17
    //   787: aload 14
    //   789: astore 16
    //   791: aload 14
    //   793: astore 15
    //   795: aload 14
    //   797: aload 22
    //   799: invokeinterface 647 1 0
    //   804: aload 22
    //   806: invokeinterface 650 1 0
    //   811: invokevirtual 656	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -77 -> 737
    //   817: astore 16
    //   819: aload 17
    //   821: astore 14
    //   823: aload 14
    //   825: astore 15
    //   827: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq +12 -> 842
    //   833: aload 14
    //   835: astore 15
    //   837: aload 16
    //   839: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   842: iconst_5
    //   843: istore 8
    //   845: aload 14
    //   847: astore 15
    //   849: aload 16
    //   851: instanceof 456
    //   854: ifeq +1357 -> 2211
    //   857: bipush 10
    //   859: istore 8
    //   861: iload_3
    //   862: istore 9
    //   864: aload 14
    //   866: astore 15
    //   868: aload 20
    //   870: iload 8
    //   872: putfield 479	afka:resultCode	I
    //   875: aload 14
    //   877: astore 15
    //   879: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +76 -> 958
    //   885: aload 14
    //   887: astore 15
    //   889: ldc 164
    //   891: iconst_2
    //   892: new 220	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   899: ldc_w 658
    //   902: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: iload 8
    //   907: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: ldc_w 660
    //   913: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload 20
    //   918: getfield 663	afka:cRn	I
    //   921: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc_w 460
    //   927: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 20
    //   932: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   935: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 665
    //   941: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 16
    //   946: invokevirtual 666	java/io/IOException:toString	()Ljava/lang/String;
    //   949: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 14
    //   960: astore 15
    //   962: iload 9
    //   964: istore 8
    //   966: aload 14
    //   968: ifnull +16 -> 984
    //   971: aload 14
    //   973: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   976: iload 9
    //   978: istore 8
    //   980: aload 14
    //   982: astore 15
    //   984: iload 8
    //   986: iconst_1
    //   987: iadd
    //   988: istore 8
    //   990: iload 8
    //   992: iload_3
    //   993: if_icmpge +1309 -> 2302
    //   996: aload 21
    //   998: monitorenter
    //   999: aload 21
    //   1001: lload 11
    //   1003: invokevirtual 441	java/lang/Object:wait	(J)V
    //   1006: lload 11
    //   1008: ldc2_w 587
    //   1011: lmul
    //   1012: lstore 11
    //   1014: aload 21
    //   1016: monitorexit
    //   1017: aload 15
    //   1019: astore 14
    //   1021: goto +1341 -> 2362
    //   1024: aload 14
    //   1026: astore 17
    //   1028: aload 14
    //   1030: astore 16
    //   1032: aload 14
    //   1034: astore 15
    //   1036: iconst_1
    //   1037: putstatic 607	com/tencent/mobileqq/utils/HttpDownloadUtil:bJO	Z
    //   1040: goto -555 -> 485
    //   1043: astore 15
    //   1045: aload 16
    //   1047: astore 14
    //   1049: aload 15
    //   1051: astore 16
    //   1053: aload 14
    //   1055: astore 15
    //   1057: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +12 -> 1072
    //   1063: aload 14
    //   1065: astore 15
    //   1067: aload 16
    //   1069: invokevirtual 480	java/lang/Exception:printStackTrace	()V
    //   1072: aload 14
    //   1074: astore 15
    //   1076: aload 20
    //   1078: iconst_5
    //   1079: putfield 479	afka:resultCode	I
    //   1082: aload 14
    //   1084: astore 15
    //   1086: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +79 -> 1168
    //   1092: aload 14
    //   1094: astore 15
    //   1096: ldc 164
    //   1098: iconst_2
    //   1099: new 220	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 658
    //   1109: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 20
    //   1114: getfield 479	afka:resultCode	I
    //   1117: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 671
    //   1123: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 20
    //   1128: getfield 663	afka:cRn	I
    //   1131: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 460
    //   1137: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload 20
    //   1142: getfield 194	afka:reqUrl	Ljava/lang/String;
    //   1145: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 462
    //   1151: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 16
    //   1156: invokevirtual 672	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: aload 14
    //   1170: astore 15
    //   1172: iload 9
    //   1174: istore 8
    //   1176: aload 14
    //   1178: ifnull -194 -> 984
    //   1181: aload 14
    //   1183: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   1186: aload 14
    //   1188: astore 15
    //   1190: iload 9
    //   1192: istore 8
    //   1194: goto -210 -> 984
    //   1197: aload 14
    //   1199: astore 17
    //   1201: aload 14
    //   1203: astore 16
    //   1205: aload 14
    //   1207: astore 15
    //   1209: aload 19
    //   1211: getstatic 675	aqoj:APN_TYPE_CTWAP	Ljava/lang/String;
    //   1214: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1217: ifeq +29 -> 1246
    //   1220: aload 14
    //   1222: astore 17
    //   1224: aload 14
    //   1226: astore 16
    //   1228: aload 14
    //   1230: astore 15
    //   1232: aload 18
    //   1234: aload 22
    //   1236: iload 10
    //   1238: invokestatic 678	aqoj:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1241: astore 14
    //   1243: goto -570 -> 673
    //   1246: aload 14
    //   1248: astore 17
    //   1250: aload 14
    //   1252: astore 16
    //   1254: aload 14
    //   1256: astore 15
    //   1258: aload 18
    //   1260: aload 22
    //   1262: iload 10
    //   1264: invokestatic 678	aqoj:getConnectionWithDefaultProxy	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1267: astore 14
    //   1269: goto -596 -> 673
    //   1272: aload 14
    //   1274: astore 17
    //   1276: aload 14
    //   1278: astore 16
    //   1280: aload 14
    //   1282: astore 15
    //   1284: new 189	java/net/URL
    //   1287: dup
    //   1288: aload 18
    //   1290: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1293: getstatic 684	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1296: invokevirtual 688	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1299: checkcast 652	java/net/HttpURLConnection
    //   1302: astore 14
    //   1304: goto -631 -> 673
    //   1307: aload 14
    //   1309: astore 17
    //   1311: aload 14
    //   1313: astore 16
    //   1315: aload 14
    //   1317: astore 15
    //   1319: aload 14
    //   1321: ldc_w 690
    //   1324: ldc_w 692
    //   1327: invokevirtual 695	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 14
    //   1332: astore 17
    //   1334: aload 14
    //   1336: astore 16
    //   1338: aload 14
    //   1340: astore 15
    //   1342: aload 14
    //   1344: iload 6
    //   1346: invokevirtual 699	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1349: aload 14
    //   1351: astore 17
    //   1353: aload 14
    //   1355: astore 16
    //   1357: aload 14
    //   1359: astore 15
    //   1361: aload 14
    //   1363: iload 7
    //   1365: invokevirtual 702	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1368: aload 14
    //   1370: astore 17
    //   1372: aload 14
    //   1374: astore 16
    //   1376: aload 14
    //   1378: astore 15
    //   1380: aload 14
    //   1382: iconst_0
    //   1383: invokevirtual 706	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1386: aload 14
    //   1388: astore 17
    //   1390: aload 14
    //   1392: astore 16
    //   1394: aload 14
    //   1396: astore 15
    //   1398: aload 14
    //   1400: invokevirtual 709	java/net/HttpURLConnection:connect	()V
    //   1403: aload 14
    //   1405: astore 17
    //   1407: aload 14
    //   1409: astore 16
    //   1411: aload 14
    //   1413: astore 15
    //   1415: aload 20
    //   1417: aload 14
    //   1419: invokevirtual 712	java/net/HttpURLConnection:getResponseCode	()I
    //   1422: putfield 663	afka:cRn	I
    //   1425: aload 14
    //   1427: astore 17
    //   1429: aload 14
    //   1431: astore 16
    //   1433: aload 14
    //   1435: astore 15
    //   1437: aload 20
    //   1439: aload 14
    //   1441: invokevirtual 714	java/net/HttpURLConnection:getContentLength	()I
    //   1444: putfield 717	afka:cRp	I
    //   1447: aload 14
    //   1449: astore 17
    //   1451: aload 14
    //   1453: astore 16
    //   1455: aload 14
    //   1457: astore 15
    //   1459: aload 20
    //   1461: aload 14
    //   1463: invokevirtual 720	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1466: putfield 723	afka:bDD	Ljava/lang/String;
    //   1469: aload 14
    //   1471: astore 17
    //   1473: aload 14
    //   1475: astore 16
    //   1477: aload 14
    //   1479: astore 15
    //   1481: aload 20
    //   1483: aload 14
    //   1485: invokevirtual 726	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1488: putfield 729	afka:bDE	Ljava/lang/String;
    //   1491: aload 14
    //   1493: astore 17
    //   1495: aload 14
    //   1497: astore 16
    //   1499: aload 14
    //   1501: astore 15
    //   1503: aload 14
    //   1505: aload 20
    //   1507: invokestatic 732	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/net/HttpURLConnection;Lafka;)V
    //   1510: aload 14
    //   1512: astore 17
    //   1514: aload 14
    //   1516: astore 16
    //   1518: aload 14
    //   1520: astore 15
    //   1522: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +83 -> 1608
    //   1528: aload 14
    //   1530: astore 17
    //   1532: aload 14
    //   1534: astore 16
    //   1536: aload 14
    //   1538: astore 15
    //   1540: ldc 164
    //   1542: iconst_2
    //   1543: new 220	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 734
    //   1553: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload_0
    //   1557: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 736
    //   1563: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 20
    //   1568: getfield 663	afka:cRn	I
    //   1571: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: ldc_w 738
    //   1577: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: aload 20
    //   1582: getfield 717	afka:cRp	I
    //   1585: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1588: ldc_w 740
    //   1591: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 20
    //   1596: getfield 723	afka:bDD	Ljava/lang/String;
    //   1599: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1608: iload 4
    //   1610: ifeq +59 -> 1669
    //   1613: aload 14
    //   1615: astore 17
    //   1617: aload 14
    //   1619: astore 16
    //   1621: aload 14
    //   1623: astore 15
    //   1625: aload 20
    //   1627: iconst_0
    //   1628: putfield 479	afka:resultCode	I
    //   1631: aload_1
    //   1632: ifnull +24 -> 1656
    //   1635: aload 14
    //   1637: astore 17
    //   1639: aload 14
    //   1641: astore 16
    //   1643: aload 14
    //   1645: astore 15
    //   1647: aload_1
    //   1648: aload 20
    //   1650: invokeinterface 584 2 0
    //   1655: pop
    //   1656: aload 14
    //   1658: ifnull +8 -> 1666
    //   1661: aload 14
    //   1663: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   1666: aload 20
    //   1668: areturn
    //   1669: aload 14
    //   1671: astore 17
    //   1673: aload 14
    //   1675: astore 16
    //   1677: aload 14
    //   1679: astore 15
    //   1681: aload 20
    //   1683: getfield 663	afka:cRn	I
    //   1686: sipush 200
    //   1689: if_icmpne +157 -> 1846
    //   1692: aload_1
    //   1693: ifnull +122 -> 1815
    //   1696: aload 14
    //   1698: astore 17
    //   1700: aload 14
    //   1702: astore 16
    //   1704: aload 14
    //   1706: astore 15
    //   1708: aload 20
    //   1710: iconst_0
    //   1711: putfield 479	afka:resultCode	I
    //   1714: aload 14
    //   1716: astore 17
    //   1718: aload 14
    //   1720: astore 16
    //   1722: aload 14
    //   1724: astore 15
    //   1726: aload_1
    //   1727: aload 20
    //   1729: invokeinterface 584 2 0
    //   1734: ifeq +34 -> 1768
    //   1737: aload 14
    //   1739: astore 17
    //   1741: aload 14
    //   1743: astore 16
    //   1745: aload 14
    //   1747: astore 15
    //   1749: aload 20
    //   1751: iconst_0
    //   1752: putfield 479	afka:resultCode	I
    //   1755: aload 14
    //   1757: ifnull +8 -> 1765
    //   1760: aload 14
    //   1762: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   1765: aload 20
    //   1767: areturn
    //   1768: aload 14
    //   1770: astore 17
    //   1772: aload 14
    //   1774: astore 16
    //   1776: aload 14
    //   1778: astore 15
    //   1780: aload 20
    //   1782: iconst_4
    //   1783: putfield 479	afka:resultCode	I
    //   1786: aload 14
    //   1788: astore 15
    //   1790: iload 9
    //   1792: istore 8
    //   1794: aload 14
    //   1796: ifnull -812 -> 984
    //   1799: aload 14
    //   1801: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   1804: aload 14
    //   1806: astore 15
    //   1808: iload 9
    //   1810: istore 8
    //   1812: goto -828 -> 984
    //   1815: aload 14
    //   1817: astore 17
    //   1819: aload 14
    //   1821: astore 16
    //   1823: aload 14
    //   1825: astore 15
    //   1827: aload 20
    //   1829: iconst_0
    //   1830: putfield 479	afka:resultCode	I
    //   1833: aload 14
    //   1835: ifnull +8 -> 1843
    //   1838: aload 14
    //   1840: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   1843: aload 20
    //   1845: areturn
    //   1846: aload 14
    //   1848: astore 17
    //   1850: aload 14
    //   1852: astore 16
    //   1854: aload 14
    //   1856: astore 15
    //   1858: aload 20
    //   1860: getfield 663	afka:cRn	I
    //   1863: sipush 302
    //   1866: if_icmpeq +26 -> 1892
    //   1869: aload 14
    //   1871: astore 17
    //   1873: aload 14
    //   1875: astore 16
    //   1877: aload 14
    //   1879: astore 15
    //   1881: aload 20
    //   1883: getfield 663	afka:cRn	I
    //   1886: sipush 301
    //   1889: if_icmpne +284 -> 2173
    //   1892: aload 14
    //   1894: astore 17
    //   1896: aload 14
    //   1898: astore 16
    //   1900: aload 14
    //   1902: astore 15
    //   1904: aload 14
    //   1906: ldc_w 742
    //   1909: invokevirtual 745	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1912: astore 19
    //   1914: aload 14
    //   1916: astore 17
    //   1918: aload 14
    //   1920: astore 16
    //   1922: aload 14
    //   1924: astore 15
    //   1926: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1929: ifeq +42 -> 1971
    //   1932: aload 14
    //   1934: astore 17
    //   1936: aload 14
    //   1938: astore 16
    //   1940: aload 14
    //   1942: astore 15
    //   1944: ldc 164
    //   1946: iconst_2
    //   1947: new 220	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1954: ldc_w 747
    //   1957: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: aload 19
    //   1962: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: invokestatic 468	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1971: aload 14
    //   1973: astore 17
    //   1975: aload 14
    //   1977: astore 16
    //   1979: aload 14
    //   1981: astore 15
    //   1983: aload 19
    //   1985: invokestatic 752	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifeq +35 -> 2023
    //   1991: aload 14
    //   1993: astore 17
    //   1995: aload 14
    //   1997: astore 16
    //   1999: aload 14
    //   2001: astore 15
    //   2003: aload 20
    //   2005: bipush 20
    //   2007: putfield 479	afka:resultCode	I
    //   2010: aload 14
    //   2012: ifnull +8 -> 2020
    //   2015: aload 14
    //   2017: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   2020: aload 20
    //   2022: areturn
    //   2023: aload 14
    //   2025: astore 17
    //   2027: aload 14
    //   2029: astore 16
    //   2031: aload 14
    //   2033: astore 15
    //   2035: aload 14
    //   2037: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   2040: aload_2
    //   2041: ifnull +88 -> 2129
    //   2044: aload_2
    //   2045: invokeinterface 755 1 0
    //   2050: istore 10
    //   2052: iconst_0
    //   2053: istore 8
    //   2055: iload 8
    //   2057: iload 10
    //   2059: if_icmpge +41 -> 2100
    //   2062: aload_2
    //   2063: iload 8
    //   2065: invokeinterface 759 2 0
    //   2070: checkcast 644	org/apache/http/Header
    //   2073: astore 14
    //   2075: aload 14
    //   2077: invokeinterface 647 1 0
    //   2082: ldc_w 761
    //   2085: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2088: ifeq +76 -> 2164
    //   2091: aload_2
    //   2092: aload 14
    //   2094: invokeinterface 764 2 0
    //   2099: pop
    //   2100: aload_2
    //   2101: new 766	org/apache/http/message/BasicHeader
    //   2104: dup
    //   2105: ldc_w 761
    //   2108: new 189	java/net/URL
    //   2111: dup
    //   2112: aload 19
    //   2114: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2117: invokevirtual 311	java/net/URL:getHost	()Ljava/lang/String;
    //   2120: invokespecial 768	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2123: invokeinterface 771 2 0
    //   2128: pop
    //   2129: aload 19
    //   2131: aload_1
    //   2132: aload_2
    //   2133: iload_3
    //   2134: iload 4
    //   2136: iload 5
    //   2138: iconst_1
    //   2139: iadd
    //   2140: iload 6
    //   2142: iload 7
    //   2144: invokestatic 570	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$a;Ljava/util/List;IZIII)Lafka;
    //   2147: astore 14
    //   2149: aload 14
    //   2151: astore_0
    //   2152: iconst_0
    //   2153: ifeq -2110 -> 43
    //   2156: new 773	java/lang/NullPointerException
    //   2159: dup
    //   2160: invokespecial 774	java/lang/NullPointerException:<init>	()V
    //   2163: athrow
    //   2164: iload 8
    //   2166: iconst_1
    //   2167: iadd
    //   2168: istore 8
    //   2170: goto -115 -> 2055
    //   2173: aload 14
    //   2175: astore 17
    //   2177: aload 14
    //   2179: astore 16
    //   2181: aload 14
    //   2183: astore 15
    //   2185: aload 20
    //   2187: aload 20
    //   2189: getfield 663	afka:cRn	I
    //   2192: putfield 479	afka:resultCode	I
    //   2195: goto -409 -> 1786
    //   2198: astore_0
    //   2199: aload 15
    //   2201: ifnull +8 -> 2209
    //   2204: aload 15
    //   2206: invokevirtual 669	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload_0
    //   2210: athrow
    //   2211: aload 14
    //   2213: astore 15
    //   2215: aload 16
    //   2217: instanceof 449
    //   2220: ifne +151 -> 2371
    //   2223: aload 14
    //   2225: astore 15
    //   2227: aload 16
    //   2229: instanceof 451
    //   2232: ifeq +6 -> 2238
    //   2235: goto +136 -> 2371
    //   2238: aload 14
    //   2240: astore 15
    //   2242: aload 16
    //   2244: instanceof 476
    //   2247: ifeq +17 -> 2264
    //   2250: aload 14
    //   2252: astore 15
    //   2254: aload 20
    //   2256: bipush 11
    //   2258: putfield 479	afka:resultCode	I
    //   2261: goto -1397 -> 864
    //   2264: aload 14
    //   2266: astore 15
    //   2268: aload 16
    //   2270: instanceof 175
    //   2273: istore 13
    //   2275: iload 13
    //   2277: ifeq +13 -> 2290
    //   2280: bipush 13
    //   2282: istore 8
    //   2284: iload_3
    //   2285: istore 9
    //   2287: goto -1423 -> 864
    //   2290: iconst_4
    //   2291: istore 8
    //   2293: goto -1429 -> 864
    //   2296: astore_0
    //   2297: aload 21
    //   2299: monitorexit
    //   2300: aload_0
    //   2301: athrow
    //   2302: aload_1
    //   2303: ifnull +12 -> 2315
    //   2306: aload_1
    //   2307: aload 20
    //   2309: invokeinterface 584 2 0
    //   2314: pop
    //   2315: aload 15
    //   2317: astore 14
    //   2319: goto +43 -> 2362
    //   2322: astore 15
    //   2324: goto -2038 -> 286
    //   2327: astore 14
    //   2329: goto -1315 -> 1014
    //   2332: astore_0
    //   2333: aconst_null
    //   2334: astore 15
    //   2336: goto -137 -> 2199
    //   2339: astore 16
    //   2341: aconst_null
    //   2342: astore 14
    //   2344: goto -1291 -> 1053
    //   2347: astore 16
    //   2349: aconst_null
    //   2350: astore 14
    //   2352: goto -1529 -> 823
    //   2355: iload 8
    //   2357: istore 9
    //   2359: goto -2264 -> 95
    //   2362: iload 8
    //   2364: iload_3
    //   2365: if_icmplt -10 -> 2355
    //   2368: aload 20
    //   2370: areturn
    //   2371: iconst_2
    //   2372: istore 8
    //   2374: goto -1510 -> 864
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2377	0	paramString	String
    //   0	2377	1	parama	a
    //   0	2377	2	paramList	List<Header>
    //   0	2377	3	paramInt1	int
    //   0	2377	4	paramBoolean	boolean
    //   0	2377	5	paramInt2	int
    //   0	2377	6	paramInt3	int
    //   0	2377	7	paramInt4	int
    //   130	2243	8	i	int
    //   88	2270	9	j	int
    //   379	1681	10	k	int
    //   93	920	11	l	long
    //   2273	3	13	bool	boolean
    //   85	1	14	localObject1	Object
    //   203	456	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   671	1647	14	localObject2	Object
    //   2327	1	14	localInterruptedException1	java.lang.InterruptedException
    //   2342	9	14	localObject3	Object
    //   319	716	15	localObject4	Object
    //   1043	7	15	localException1	Exception
    //   1055	1261	15	localObject5	Object
    //   2322	1	15	localInterruptedException2	java.lang.InterruptedException
    //   2334	1	15	localObject6	Object
    //   315	475	16	localObject7	Object
    //   817	128	16	localIOException1	java.io.IOException
    //   1030	1239	16	localObject8	Object
    //   2339	1	16	localException2	Exception
    //   2347	1	16	localIOException2	java.io.IOException
    //   311	1865	17	localObject9	Object
    //   63	1226	18	str	String
    //   299	1831	19	localObject10	Object
    //   10	2359	20	localafka	afka
    //   82	2216	21	localObject11	Object
    //   98	1163	22	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   45	58	154	java/net/MalformedURLException
    //   65	75	203	java/lang/IllegalArgumentException
    //   205	225	228	java/lang/IllegalArgumentException
    //   271	278	292	finally
    //   286	289	292	finally
    //   293	296	292	finally
    //   321	328	817	java/io/IOException
    //   340	347	817	java/io/IOException
    //   359	364	817	java/io/IOException
    //   376	381	817	java/io/IOException
    //   393	400	817	java/io/IOException
    //   412	423	817	java/io/IOException
    //   435	440	817	java/io/IOException
    //   458	469	817	java/io/IOException
    //   481	485	817	java/io/IOException
    //   503	514	817	java/io/IOException
    //   526	537	817	java/io/IOException
    //   549	553	817	java/io/IOException
    //   565	571	817	java/io/IOException
    //   593	604	817	java/io/IOException
    //   616	627	817	java/io/IOException
    //   639	650	817	java/io/IOException
    //   662	673	817	java/io/IOException
    //   685	692	817	java/io/IOException
    //   708	717	817	java/io/IOException
    //   729	737	817	java/io/IOException
    //   749	759	817	java/io/IOException
    //   771	783	817	java/io/IOException
    //   795	814	817	java/io/IOException
    //   1036	1040	817	java/io/IOException
    //   1209	1220	817	java/io/IOException
    //   1232	1243	817	java/io/IOException
    //   1258	1269	817	java/io/IOException
    //   1284	1304	817	java/io/IOException
    //   1319	1330	817	java/io/IOException
    //   1342	1349	817	java/io/IOException
    //   1361	1368	817	java/io/IOException
    //   1380	1386	817	java/io/IOException
    //   1398	1403	817	java/io/IOException
    //   1415	1425	817	java/io/IOException
    //   1437	1447	817	java/io/IOException
    //   1459	1469	817	java/io/IOException
    //   1481	1491	817	java/io/IOException
    //   1503	1510	817	java/io/IOException
    //   1522	1528	817	java/io/IOException
    //   1540	1608	817	java/io/IOException
    //   1625	1631	817	java/io/IOException
    //   1647	1656	817	java/io/IOException
    //   1681	1692	817	java/io/IOException
    //   1708	1714	817	java/io/IOException
    //   1726	1737	817	java/io/IOException
    //   1749	1755	817	java/io/IOException
    //   1780	1786	817	java/io/IOException
    //   1827	1833	817	java/io/IOException
    //   1858	1869	817	java/io/IOException
    //   1881	1892	817	java/io/IOException
    //   1904	1914	817	java/io/IOException
    //   1926	1932	817	java/io/IOException
    //   1944	1971	817	java/io/IOException
    //   1983	1991	817	java/io/IOException
    //   2003	2010	817	java/io/IOException
    //   2035	2040	817	java/io/IOException
    //   2185	2195	817	java/io/IOException
    //   321	328	1043	java/lang/Exception
    //   340	347	1043	java/lang/Exception
    //   359	364	1043	java/lang/Exception
    //   376	381	1043	java/lang/Exception
    //   393	400	1043	java/lang/Exception
    //   412	423	1043	java/lang/Exception
    //   435	440	1043	java/lang/Exception
    //   458	469	1043	java/lang/Exception
    //   481	485	1043	java/lang/Exception
    //   503	514	1043	java/lang/Exception
    //   526	537	1043	java/lang/Exception
    //   549	553	1043	java/lang/Exception
    //   565	571	1043	java/lang/Exception
    //   593	604	1043	java/lang/Exception
    //   616	627	1043	java/lang/Exception
    //   639	650	1043	java/lang/Exception
    //   662	673	1043	java/lang/Exception
    //   685	692	1043	java/lang/Exception
    //   708	717	1043	java/lang/Exception
    //   729	737	1043	java/lang/Exception
    //   749	759	1043	java/lang/Exception
    //   771	783	1043	java/lang/Exception
    //   795	814	1043	java/lang/Exception
    //   1036	1040	1043	java/lang/Exception
    //   1209	1220	1043	java/lang/Exception
    //   1232	1243	1043	java/lang/Exception
    //   1258	1269	1043	java/lang/Exception
    //   1284	1304	1043	java/lang/Exception
    //   1319	1330	1043	java/lang/Exception
    //   1342	1349	1043	java/lang/Exception
    //   1361	1368	1043	java/lang/Exception
    //   1380	1386	1043	java/lang/Exception
    //   1398	1403	1043	java/lang/Exception
    //   1415	1425	1043	java/lang/Exception
    //   1437	1447	1043	java/lang/Exception
    //   1459	1469	1043	java/lang/Exception
    //   1481	1491	1043	java/lang/Exception
    //   1503	1510	1043	java/lang/Exception
    //   1522	1528	1043	java/lang/Exception
    //   1540	1608	1043	java/lang/Exception
    //   1625	1631	1043	java/lang/Exception
    //   1647	1656	1043	java/lang/Exception
    //   1681	1692	1043	java/lang/Exception
    //   1708	1714	1043	java/lang/Exception
    //   1726	1737	1043	java/lang/Exception
    //   1749	1755	1043	java/lang/Exception
    //   1780	1786	1043	java/lang/Exception
    //   1827	1833	1043	java/lang/Exception
    //   1858	1869	1043	java/lang/Exception
    //   1881	1892	1043	java/lang/Exception
    //   1904	1914	1043	java/lang/Exception
    //   1926	1932	1043	java/lang/Exception
    //   1944	1971	1043	java/lang/Exception
    //   1983	1991	1043	java/lang/Exception
    //   2003	2010	1043	java/lang/Exception
    //   2035	2040	1043	java/lang/Exception
    //   2185	2195	1043	java/lang/Exception
    //   321	328	2198	finally
    //   340	347	2198	finally
    //   359	364	2198	finally
    //   376	381	2198	finally
    //   393	400	2198	finally
    //   412	423	2198	finally
    //   435	440	2198	finally
    //   458	469	2198	finally
    //   481	485	2198	finally
    //   503	514	2198	finally
    //   526	537	2198	finally
    //   549	553	2198	finally
    //   565	571	2198	finally
    //   593	604	2198	finally
    //   616	627	2198	finally
    //   639	650	2198	finally
    //   662	673	2198	finally
    //   685	692	2198	finally
    //   708	717	2198	finally
    //   729	737	2198	finally
    //   749	759	2198	finally
    //   771	783	2198	finally
    //   795	814	2198	finally
    //   827	833	2198	finally
    //   837	842	2198	finally
    //   849	857	2198	finally
    //   868	875	2198	finally
    //   879	885	2198	finally
    //   889	958	2198	finally
    //   1036	1040	2198	finally
    //   1057	1063	2198	finally
    //   1067	1072	2198	finally
    //   1076	1082	2198	finally
    //   1086	1092	2198	finally
    //   1096	1168	2198	finally
    //   1209	1220	2198	finally
    //   1232	1243	2198	finally
    //   1258	1269	2198	finally
    //   1284	1304	2198	finally
    //   1319	1330	2198	finally
    //   1342	1349	2198	finally
    //   1361	1368	2198	finally
    //   1380	1386	2198	finally
    //   1398	1403	2198	finally
    //   1415	1425	2198	finally
    //   1437	1447	2198	finally
    //   1459	1469	2198	finally
    //   1481	1491	2198	finally
    //   1503	1510	2198	finally
    //   1522	1528	2198	finally
    //   1540	1608	2198	finally
    //   1625	1631	2198	finally
    //   1647	1656	2198	finally
    //   1681	1692	2198	finally
    //   1708	1714	2198	finally
    //   1726	1737	2198	finally
    //   1749	1755	2198	finally
    //   1780	1786	2198	finally
    //   1827	1833	2198	finally
    //   1858	1869	2198	finally
    //   1881	1892	2198	finally
    //   1904	1914	2198	finally
    //   1926	1932	2198	finally
    //   1944	1971	2198	finally
    //   1983	1991	2198	finally
    //   2003	2010	2198	finally
    //   2035	2040	2198	finally
    //   2185	2195	2198	finally
    //   2215	2223	2198	finally
    //   2227	2235	2198	finally
    //   2242	2250	2198	finally
    //   2254	2261	2198	finally
    //   2268	2275	2198	finally
    //   999	1006	2296	finally
    //   1014	1017	2296	finally
    //   2297	2300	2296	finally
    //   271	278	2322	java/lang/InterruptedException
    //   999	1006	2327	java/lang/InterruptedException
    //   2044	2052	2332	finally
    //   2062	2100	2332	finally
    //   2100	2129	2332	finally
    //   2129	2149	2332	finally
    //   2044	2052	2339	java/lang/Exception
    //   2062	2100	2339	java/lang/Exception
    //   2100	2129	2339	java/lang/Exception
    //   2129	2149	2339	java/lang/Exception
    //   2044	2052	2347	java/io/IOException
    //   2062	2100	2347	java/io/IOException
    //   2100	2129	2347	java/io/IOException
    //   2129	2149	2347	java/io/IOException
  }
  
  public static void a(afka paramafka)
  {
    if ((paramafka == null) || (paramafka.bDA == null) || (paramafka.bDA.length() == 0)) {}
    label33:
    int i;
    int j;
    String str2;
    do
    {
      return;
      if (!paramafka.isHttps) {
        break;
      }
      localObject = PROTOCOL_HTTPS;
      i = ((String)localObject).length();
      j = paramafka.bDA.indexOf("/", i);
      str2 = paramafka.bDA.substring(i, j);
    } while ((j <= i) && (TextUtils.isEmpty(str2)));
    label88:
    String str1;
    if ("imgcache.qq.com".equalsIgnoreCase(str2))
    {
      i = 12;
      str1 = (String)localObject + "[^/\\s]*/";
      String str3 = aokl.a().fD(i);
      if ((str3 == null) || (str3.length() <= 0)) {
        break label413;
      }
      str1 = paramafka.bDA.replaceFirst(str1, str3);
      if ((!paramafka.isHttps) || (TextUtils.isEmpty(str1)) || (!str1.startsWith("http://"))) {
        break label474;
      }
    }
    label413:
    label474:
    for (Object localObject = (String)localObject + str1.substring("http://".length());; localObject = str1)
    {
      paramafka.host = str2;
      paramafka.reqUrl = ((String)localObject);
      paramafka.bYr = true;
      paramafka.cRo = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramafka.bYr + " url[" + paramafka.bDA + "] resetIP[" + (String)localObject + "] host[" + paramafka.host + "]");
      return;
      localObject = "http://";
      break label33;
      if ("imgcache.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 13;
        break label88;
      }
      if ("i.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 14;
        break label88;
      }
      if ("cmshow.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 17;
        break label88;
      }
      paramafka.host = null;
      paramafka.reqUrl = paramafka.bDA;
      paramafka.bYr = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramafka.bYr);
      return;
      paramafka.host = null;
      paramafka.reqUrl = paramafka.bDA;
      paramafka.bYr = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramafka.reqUrl + "]");
      return;
    }
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, afka paramafka)
  {
    if ((paramHttpURLConnection == null) || (paramafka == null)) {}
    do
    {
      return;
      if (paramHttpURLConnection.getHeaderField("X-FailNo") != null) {
        paramafka.bDF = paramHttpURLConnection.getHeaderField("X-FailNo");
      }
    } while (paramHttpURLConnection.getHeaderField("X-ErrNo") == null);
    paramafka.bDG = paramHttpURLConnection.getHeaderField("X-ErrNo");
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return a(paramAppInterface, paramURL, paramFile, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
  }
  
  public static String pA(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static class IdleConnectionMonitorThread
    extends Thread
  {
    private final ClientConnectionManager a;
    private volatile boolean shutdown;
    
    public IdleConnectionMonitorThread(ClientConnectionManager paramClientConnectionManager)
    {
      this.a = paramClientConnectionManager;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:shutdown	Z
      //   4: ifne +81 -> 85
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: ldc2_w 27
      //   13: invokevirtual 34	java/lang/Object:wait	(J)V
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_0
      //   19: getfield 18	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:a	Lorg/apache/http/conn/ClientConnectionManager;
      //   22: invokeinterface 39 1 0
      //   27: aload_0
      //   28: getfield 18	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:a	Lorg/apache/http/conn/ClientConnectionManager;
      //   31: ldc2_w 40
      //   34: getstatic 47	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
      //   37: invokeinterface 51 4 0
      //   42: invokestatic 57	java/lang/System:currentTimeMillis	()J
      //   45: getstatic 61	com/tencent/mobileqq/utils/HttpDownloadUtil:lastUseTime	J
      //   48: lsub
      //   49: ldc2_w 62
      //   52: lcmp
      //   53: ifle -53 -> 0
      //   56: aload_0
      //   57: invokevirtual 65	com/tencent/mobileqq/utils/HttpDownloadUtil$IdleConnectionMonitorThread:shutdown	()V
      //   60: goto -60 -> 0
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: ldc 67
      //   71: iconst_1
      //   72: ldc 69
      //   74: aload_1
      //   75: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   78: goto -36 -> 42
      //   81: astore_1
      //   82: goto -66 -> 16
      //   85: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	IdleConnectionMonitorThread
      //   63	4	1	localObject	Object
      //   68	7	1	localThrowable	java.lang.Throwable
      //   81	1	1	localInterruptedException	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   9	16	63	finally
      //   16	18	63	finally
      //   64	66	63	finally
      //   18	42	68	java/lang/Throwable
      //   9	16	81	java/lang/InterruptedException
    }
    
    public void shutdown()
    {
      this.shutdown = true;
      try
      {
        notifyAll();
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(afka paramafka);
  }
  
  public static abstract interface b
  {
    public abstract void cm(String paramString, int paramInt);
    
    public abstract void cn(String paramString, int paramInt);
    
    public abstract void h(String paramString, long paramLong1, long paramLong2);
  }
  
  public static class c
  {
    public static int dQf = 40000;
    public static int dQg = 30000;
    public static int dQh = 20000;
    public static int dQi = 20000;
    public static int dQj = 15000;
    public static int dQk = 10000;
    public static int dQl;
    
    public static int jB(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return dQf;
      case 1: 
      case 4: 
      case 5: 
        return dQh;
      }
      return dQg;
    }
    
    public static int jC(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return dQi + dQl;
      case 1: 
      case 4: 
      case 5: 
        return dQk + dQl;
      }
      return dQj + dQl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */