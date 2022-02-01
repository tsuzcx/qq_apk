package com.tencent.mobileqq.mini.utils;

import alkz;
import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpUtil
{
  public static final String HTTP_BODY = "http_body";
  private static final int HTTP_CONNECTIONTIMEOUT = 15000;
  private static final int HTTP_SOTIMEOUT = 15000;
  public static final String HTTP_STATUS = "http_status";
  private Context mContext;
  
  private HttpUtil() {}
  
  public HttpUtil(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void addHttpBody(Bundle paramBundle, HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getEntity();
    String str = paramBundle.getString("Content-Encoding");
    if ((str != null) && (str.indexOf("gzip") >= 0))
    {
      paramBundle.putByteArray("http_body", readHttpBody(paramHttpResponse, true));
      return;
    }
    paramBundle.putByteArray("http_body", readHttpBody(paramHttpResponse, false));
  }
  
  private void addHttpHeader(Bundle paramBundle, HttpResponse paramHttpResponse)
  {
    Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
    int j = paramHttpResponse.getAllHeaders().length;
    int i = 0;
    while (i < j)
    {
      paramBundle.putString(arrayOfHeader[i].getName(), arrayOfHeader[i].getValue());
      i += 1;
    }
    if (arrayOfHeader != null) {}
  }
  
  private HttpClient createHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 15000);
    HttpClientParams.setRedirecting(localBasicHttpParams, true);
    try
    {
      Object localObject = new SchemeRegistry();
      ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localObject = new DefaultHttpClient(new SingleClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject), localBasicHttpParams);
      return localObject;
    }
    catch (Exception localException) {}
    return new DefaultHttpClient(localBasicHttpParams);
  }
  
  private HttpHost detectProxy()
  {
    boolean bool2 = false;
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    for (;;)
    {
      try
      {
        if (this.mContext == null) {
          break label101;
        }
        WifiManager localWifiManager = (WifiManager)this.mContext.getSystemService("wifi");
        if (localWifiManager == null) {
          break label101;
        }
        bool1 = localWifiManager.isWifiEnabled();
        if (bool1)
        {
          int j;
          return null;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = alkz.a(localWifiManager).getIpAddress();
          if (j != 0) {
            break label98;
          }
          bool1 = false;
          if ((bool1) || (str == null)) {
            break label96;
          }
          return new HttpHost(str, i);
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool1 = bool2;
        continue;
      }
      label96:
      label98:
      continue;
      label101:
      boolean bool1 = false;
    }
  }
  
  /* Error */
  private Bundle doHttp(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 13
    //   20: aconst_null
    //   21: astore 14
    //   23: aconst_null
    //   24: astore 15
    //   26: aconst_null
    //   27: astore 6
    //   29: new 37	android/os/Bundle
    //   32: dup
    //   33: invokespecial 182	android/os/Bundle:<init>	()V
    //   36: astore 16
    //   38: aload_0
    //   39: invokespecial 184	com/tencent/mobileqq/mini/utils/HttpUtil:createHttpClient	()Lorg/apache/http/client/HttpClient;
    //   42: astore 5
    //   44: aload 6
    //   46: astore 7
    //   48: aload 12
    //   50: astore 8
    //   52: aload 13
    //   54: astore_3
    //   55: aload 5
    //   57: astore 4
    //   59: aload 14
    //   61: astore 9
    //   63: aload 15
    //   65: astore 10
    //   67: aload_0
    //   68: invokespecial 186	com/tencent/mobileqq/mini/utils/HttpUtil:detectProxy	()Lorg/apache/http/HttpHost;
    //   71: astore 17
    //   73: aload 17
    //   75: ifnull +1016 -> 1091
    //   78: aload 6
    //   80: astore 7
    //   82: aload 12
    //   84: astore 8
    //   86: aload 13
    //   88: astore_3
    //   89: aload 5
    //   91: astore 4
    //   93: aload 14
    //   95: astore 9
    //   97: aload 15
    //   99: astore 10
    //   101: aload 5
    //   103: invokeinterface 192 1 0
    //   108: ldc 194
    //   110: aload 17
    //   112: invokeinterface 200 3 0
    //   117: pop
    //   118: goto +973 -> 1091
    //   121: aload 6
    //   123: astore 7
    //   125: aload 12
    //   127: astore 8
    //   129: aload 13
    //   131: astore_3
    //   132: aload 5
    //   134: astore 4
    //   136: aload 14
    //   138: astore 9
    //   140: aload 15
    //   142: astore 10
    //   144: new 202	org/apache/http/client/methods/HttpGet
    //   147: dup
    //   148: aload_2
    //   149: invokespecial 205	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   152: astore 11
    //   154: aload 6
    //   156: astore 7
    //   158: aload 12
    //   160: astore 8
    //   162: aload 13
    //   164: astore_3
    //   165: aload 5
    //   167: astore 4
    //   169: aload 14
    //   171: astore 9
    //   173: aload 15
    //   175: astore 10
    //   177: aload 11
    //   179: ldc 207
    //   181: ldc 209
    //   183: invokeinterface 214 3 0
    //   188: aload 17
    //   190: ifnull +79 -> 269
    //   193: aload 6
    //   195: astore 7
    //   197: aload 12
    //   199: astore 8
    //   201: aload 13
    //   203: astore_3
    //   204: aload 5
    //   206: astore 4
    //   208: aload 14
    //   210: astore 9
    //   212: aload 15
    //   214: astore 10
    //   216: aload 11
    //   218: ldc 216
    //   220: aload 11
    //   222: invokeinterface 220 1 0
    //   227: invokevirtual 225	java/net/URI:getHost	()Ljava/lang/String;
    //   230: invokeinterface 228 3 0
    //   235: aload 6
    //   237: astore 7
    //   239: aload 12
    //   241: astore 8
    //   243: aload 13
    //   245: astore_3
    //   246: aload 5
    //   248: astore 4
    //   250: aload 14
    //   252: astore 9
    //   254: aload 15
    //   256: astore 10
    //   258: aload 11
    //   260: ldc 230
    //   262: ldc 232
    //   264: invokeinterface 228 3 0
    //   269: aload 6
    //   271: astore 7
    //   273: aload 12
    //   275: astore 8
    //   277: aload 13
    //   279: astore_3
    //   280: aload 5
    //   282: astore 4
    //   284: aload 14
    //   286: astore 9
    //   288: aload 15
    //   290: astore 10
    //   292: aload 5
    //   294: aload 11
    //   296: invokeinterface 236 2 0
    //   301: astore 6
    //   303: aload 6
    //   305: astore 7
    //   307: aload 6
    //   309: astore 8
    //   311: aload 6
    //   313: astore_3
    //   314: aload 5
    //   316: astore 4
    //   318: aload 6
    //   320: astore 9
    //   322: aload 6
    //   324: astore 10
    //   326: aload 6
    //   328: invokeinterface 240 1 0
    //   333: invokeinterface 245 1 0
    //   338: istore_1
    //   339: aload 6
    //   341: astore 7
    //   343: aload 6
    //   345: astore 8
    //   347: aload 6
    //   349: astore_3
    //   350: aload 5
    //   352: astore 4
    //   354: aload 6
    //   356: astore 9
    //   358: aload 6
    //   360: astore 10
    //   362: aload 16
    //   364: ldc 15
    //   366: iload_1
    //   367: invokevirtual 248	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   370: iload_1
    //   371: sipush 200
    //   374: if_icmpeq +211 -> 585
    //   377: iload_1
    //   378: sipush 206
    //   381: if_icmpeq +204 -> 585
    //   384: aload 6
    //   386: astore 7
    //   388: aload 6
    //   390: astore 8
    //   392: aload 6
    //   394: astore_3
    //   395: aload 5
    //   397: astore 4
    //   399: aload 6
    //   401: astore 9
    //   403: aload 6
    //   405: astore 10
    //   407: aload 11
    //   409: invokeinterface 251 1 0
    //   414: aload 5
    //   416: ifnull +15 -> 431
    //   419: aload 5
    //   421: invokeinterface 255 1 0
    //   426: invokeinterface 260 1 0
    //   431: aload 6
    //   433: ifnull +3 -> 436
    //   436: aload 16
    //   438: areturn
    //   439: aload 6
    //   441: astore 7
    //   443: aload 12
    //   445: astore 8
    //   447: aload 13
    //   449: astore_3
    //   450: aload 5
    //   452: astore 4
    //   454: aload 14
    //   456: astore 9
    //   458: aload 15
    //   460: astore 10
    //   462: new 202	org/apache/http/client/methods/HttpGet
    //   465: dup
    //   466: aload_2
    //   467: invokespecial 205	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   470: astore 11
    //   472: goto -318 -> 154
    //   475: astore_2
    //   476: aload 7
    //   478: astore_3
    //   479: aload 5
    //   481: astore 4
    //   483: aload_2
    //   484: invokevirtual 263	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   487: aload 5
    //   489: ifnull +15 -> 504
    //   492: aload 5
    //   494: invokeinterface 255 1 0
    //   499: invokeinterface 260 1 0
    //   504: aload 7
    //   506: ifnull -70 -> 436
    //   509: aload 16
    //   511: areturn
    //   512: aload 6
    //   514: astore 7
    //   516: aload 12
    //   518: astore 8
    //   520: aload 13
    //   522: astore_3
    //   523: aload 5
    //   525: astore 4
    //   527: aload 14
    //   529: astore 9
    //   531: aload 15
    //   533: astore 10
    //   535: new 265	org/apache/http/client/methods/HttpPost
    //   538: dup
    //   539: aload_2
    //   540: invokespecial 266	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   543: astore 11
    //   545: goto -391 -> 154
    //   548: astore_2
    //   549: aload 8
    //   551: astore_3
    //   552: aload 5
    //   554: astore 4
    //   556: aload_2
    //   557: invokevirtual 267	java/net/SocketTimeoutException:printStackTrace	()V
    //   560: aload 5
    //   562: ifnull +15 -> 577
    //   565: aload 5
    //   567: invokeinterface 255 1 0
    //   572: invokeinterface 260 1 0
    //   577: aload 8
    //   579: ifnull -143 -> 436
    //   582: aload 16
    //   584: areturn
    //   585: aload 6
    //   587: astore 7
    //   589: aload 6
    //   591: astore 8
    //   593: aload 6
    //   595: astore_3
    //   596: aload 5
    //   598: astore 4
    //   600: aload 6
    //   602: astore 9
    //   604: aload 6
    //   606: astore 10
    //   608: aload 6
    //   610: ldc_w 269
    //   613: invokeinterface 273 2 0
    //   618: astore 12
    //   620: aload 6
    //   622: astore_2
    //   623: aload 12
    //   625: ifnull +259 -> 884
    //   628: aload 6
    //   630: astore 7
    //   632: aload 6
    //   634: astore 8
    //   636: aload 6
    //   638: astore_2
    //   639: aload 6
    //   641: astore_3
    //   642: aload 5
    //   644: astore 4
    //   646: aload 6
    //   648: astore 9
    //   650: aload 6
    //   652: astore 10
    //   654: aload 12
    //   656: invokeinterface 71 1 0
    //   661: ifnull +223 -> 884
    //   664: aload 6
    //   666: astore 7
    //   668: aload 6
    //   670: astore 8
    //   672: aload 6
    //   674: astore_2
    //   675: aload 6
    //   677: astore_3
    //   678: aload 5
    //   680: astore 4
    //   682: aload 6
    //   684: astore 9
    //   686: aload 6
    //   688: astore 10
    //   690: aload 12
    //   692: invokeinterface 71 1 0
    //   697: ldc_w 275
    //   700: invokevirtual 49	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   703: ifle +181 -> 884
    //   706: aload 6
    //   708: astore 7
    //   710: aload 6
    //   712: astore 8
    //   714: aload 6
    //   716: astore_3
    //   717: aload 5
    //   719: astore 4
    //   721: aload 6
    //   723: astore 9
    //   725: aload 6
    //   727: astore 10
    //   729: ldc_w 277
    //   732: ldc_w 279
    //   735: invokestatic 285	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   738: pop
    //   739: aload 6
    //   741: astore 7
    //   743: aload 6
    //   745: astore 8
    //   747: aload 6
    //   749: astore_3
    //   750: aload 5
    //   752: astore 4
    //   754: aload 6
    //   756: astore 9
    //   758: aload 6
    //   760: astore 10
    //   762: aload 5
    //   764: aload 11
    //   766: invokeinterface 236 2 0
    //   771: astore 6
    //   773: aload 6
    //   775: astore 7
    //   777: aload 6
    //   779: astore 8
    //   781: aload 6
    //   783: astore_3
    //   784: aload 5
    //   786: astore 4
    //   788: aload 6
    //   790: astore 9
    //   792: aload 6
    //   794: astore 10
    //   796: aload 6
    //   798: invokeinterface 240 1 0
    //   803: invokeinterface 245 1 0
    //   808: istore_1
    //   809: aload 6
    //   811: astore_2
    //   812: iload_1
    //   813: sipush 200
    //   816: if_icmpeq +68 -> 884
    //   819: aload 6
    //   821: astore_2
    //   822: iload_1
    //   823: sipush 206
    //   826: if_icmpeq +58 -> 884
    //   829: aload 6
    //   831: astore 7
    //   833: aload 6
    //   835: astore 8
    //   837: aload 6
    //   839: astore_3
    //   840: aload 5
    //   842: astore 4
    //   844: aload 6
    //   846: astore 9
    //   848: aload 6
    //   850: astore 10
    //   852: aload 11
    //   854: invokeinterface 251 1 0
    //   859: aload 5
    //   861: ifnull +15 -> 876
    //   864: aload 5
    //   866: invokeinterface 255 1 0
    //   871: invokeinterface 260 1 0
    //   876: aload 6
    //   878: ifnull -442 -> 436
    //   881: aload 16
    //   883: areturn
    //   884: aload_2
    //   885: astore 7
    //   887: aload_2
    //   888: astore 8
    //   890: aload_2
    //   891: astore_3
    //   892: aload 5
    //   894: astore 4
    //   896: aload_2
    //   897: astore 9
    //   899: aload_2
    //   900: astore 10
    //   902: aload_0
    //   903: aload 16
    //   905: aload_2
    //   906: invokespecial 287	com/tencent/mobileqq/mini/utils/HttpUtil:addHttpHeader	(Landroid/os/Bundle;Lorg/apache/http/HttpResponse;)V
    //   909: aload_2
    //   910: astore 7
    //   912: aload_2
    //   913: astore 8
    //   915: aload_2
    //   916: astore_3
    //   917: aload 5
    //   919: astore 4
    //   921: aload_2
    //   922: astore 9
    //   924: aload_2
    //   925: astore 10
    //   927: aload_0
    //   928: aload 16
    //   930: aload_2
    //   931: invokespecial 289	com/tencent/mobileqq/mini/utils/HttpUtil:addHttpBody	(Landroid/os/Bundle;Lorg/apache/http/HttpResponse;)V
    //   934: aload 5
    //   936: ifnull +15 -> 951
    //   939: aload 5
    //   941: invokeinterface 255 1 0
    //   946: invokeinterface 260 1 0
    //   951: aload_2
    //   952: ifnull -516 -> 436
    //   955: aload 16
    //   957: areturn
    //   958: astore_2
    //   959: aconst_null
    //   960: astore 5
    //   962: aload 10
    //   964: astore_3
    //   965: aload 5
    //   967: astore 4
    //   969: aload_2
    //   970: invokevirtual 290	java/net/SocketException:printStackTrace	()V
    //   973: aload 5
    //   975: ifnull +15 -> 990
    //   978: aload 5
    //   980: invokeinterface 255 1 0
    //   985: invokeinterface 260 1 0
    //   990: aload 10
    //   992: ifnull -556 -> 436
    //   995: aload 16
    //   997: areturn
    //   998: astore_2
    //   999: aconst_null
    //   1000: astore 5
    //   1002: aload 9
    //   1004: astore_3
    //   1005: aload 5
    //   1007: astore 4
    //   1009: aload_2
    //   1010: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   1013: aload 5
    //   1015: ifnull +15 -> 1030
    //   1018: aload 5
    //   1020: invokeinterface 255 1 0
    //   1025: invokeinterface 260 1 0
    //   1030: aload 9
    //   1032: ifnull -596 -> 436
    //   1035: aload 16
    //   1037: areturn
    //   1038: astore_2
    //   1039: aconst_null
    //   1040: astore 4
    //   1042: aload 4
    //   1044: ifnull +15 -> 1059
    //   1047: aload 4
    //   1049: invokeinterface 255 1 0
    //   1054: invokeinterface 260 1 0
    //   1059: aload_3
    //   1060: ifnull +3 -> 1063
    //   1063: aload_2
    //   1064: athrow
    //   1065: astore_2
    //   1066: goto -24 -> 1042
    //   1069: astore_2
    //   1070: goto -68 -> 1002
    //   1073: astore_2
    //   1074: goto -112 -> 962
    //   1077: astore_2
    //   1078: aconst_null
    //   1079: astore 5
    //   1081: goto -532 -> 549
    //   1084: astore_2
    //   1085: aconst_null
    //   1086: astore 5
    //   1088: goto -612 -> 476
    //   1091: iload_1
    //   1092: tableswitch	default:+24 -> 1116, 0:+-653->439, 1:+-580->512
    //   1117: <illegal opcode>
    //   1118: iload_3
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	HttpUtil
    //   0	1119	1	paramInt	int
    //   0	1119	2	paramString	String
    //   16	1044	3	localObject1	Object
    //   57	991	4	localHttpClient1	HttpClient
    //   42	1045	5	localHttpClient2	HttpClient
    //   27	850	6	localHttpResponse	HttpResponse
    //   1	910	7	localObject2	Object
    //   7	907	8	localObject3	Object
    //   13	1018	9	localObject4	Object
    //   10	981	10	localObject5	Object
    //   152	701	11	localObject6	Object
    //   4	687	12	localHeader	Header
    //   18	503	13	localObject7	Object
    //   21	507	14	localObject8	Object
    //   24	508	15	localObject9	Object
    //   36	1000	16	localBundle	Bundle
    //   71	118	17	localHttpHost	HttpHost
    // Exception table:
    //   from	to	target	type
    //   67	73	475	org/apache/http/client/ClientProtocolException
    //   101	118	475	org/apache/http/client/ClientProtocolException
    //   144	154	475	org/apache/http/client/ClientProtocolException
    //   177	188	475	org/apache/http/client/ClientProtocolException
    //   216	235	475	org/apache/http/client/ClientProtocolException
    //   258	269	475	org/apache/http/client/ClientProtocolException
    //   292	303	475	org/apache/http/client/ClientProtocolException
    //   326	339	475	org/apache/http/client/ClientProtocolException
    //   362	370	475	org/apache/http/client/ClientProtocolException
    //   407	414	475	org/apache/http/client/ClientProtocolException
    //   462	472	475	org/apache/http/client/ClientProtocolException
    //   535	545	475	org/apache/http/client/ClientProtocolException
    //   608	620	475	org/apache/http/client/ClientProtocolException
    //   654	664	475	org/apache/http/client/ClientProtocolException
    //   690	706	475	org/apache/http/client/ClientProtocolException
    //   729	739	475	org/apache/http/client/ClientProtocolException
    //   762	773	475	org/apache/http/client/ClientProtocolException
    //   796	809	475	org/apache/http/client/ClientProtocolException
    //   852	859	475	org/apache/http/client/ClientProtocolException
    //   902	909	475	org/apache/http/client/ClientProtocolException
    //   927	934	475	org/apache/http/client/ClientProtocolException
    //   67	73	548	java/net/SocketTimeoutException
    //   101	118	548	java/net/SocketTimeoutException
    //   144	154	548	java/net/SocketTimeoutException
    //   177	188	548	java/net/SocketTimeoutException
    //   216	235	548	java/net/SocketTimeoutException
    //   258	269	548	java/net/SocketTimeoutException
    //   292	303	548	java/net/SocketTimeoutException
    //   326	339	548	java/net/SocketTimeoutException
    //   362	370	548	java/net/SocketTimeoutException
    //   407	414	548	java/net/SocketTimeoutException
    //   462	472	548	java/net/SocketTimeoutException
    //   535	545	548	java/net/SocketTimeoutException
    //   608	620	548	java/net/SocketTimeoutException
    //   654	664	548	java/net/SocketTimeoutException
    //   690	706	548	java/net/SocketTimeoutException
    //   729	739	548	java/net/SocketTimeoutException
    //   762	773	548	java/net/SocketTimeoutException
    //   796	809	548	java/net/SocketTimeoutException
    //   852	859	548	java/net/SocketTimeoutException
    //   902	909	548	java/net/SocketTimeoutException
    //   927	934	548	java/net/SocketTimeoutException
    //   38	44	958	java/net/SocketException
    //   38	44	998	java/io/IOException
    //   38	44	1038	finally
    //   67	73	1065	finally
    //   101	118	1065	finally
    //   144	154	1065	finally
    //   177	188	1065	finally
    //   216	235	1065	finally
    //   258	269	1065	finally
    //   292	303	1065	finally
    //   326	339	1065	finally
    //   362	370	1065	finally
    //   407	414	1065	finally
    //   462	472	1065	finally
    //   483	487	1065	finally
    //   535	545	1065	finally
    //   556	560	1065	finally
    //   608	620	1065	finally
    //   654	664	1065	finally
    //   690	706	1065	finally
    //   729	739	1065	finally
    //   762	773	1065	finally
    //   796	809	1065	finally
    //   852	859	1065	finally
    //   902	909	1065	finally
    //   927	934	1065	finally
    //   969	973	1065	finally
    //   1009	1013	1065	finally
    //   67	73	1069	java/io/IOException
    //   101	118	1069	java/io/IOException
    //   144	154	1069	java/io/IOException
    //   177	188	1069	java/io/IOException
    //   216	235	1069	java/io/IOException
    //   258	269	1069	java/io/IOException
    //   292	303	1069	java/io/IOException
    //   326	339	1069	java/io/IOException
    //   362	370	1069	java/io/IOException
    //   407	414	1069	java/io/IOException
    //   462	472	1069	java/io/IOException
    //   535	545	1069	java/io/IOException
    //   608	620	1069	java/io/IOException
    //   654	664	1069	java/io/IOException
    //   690	706	1069	java/io/IOException
    //   729	739	1069	java/io/IOException
    //   762	773	1069	java/io/IOException
    //   796	809	1069	java/io/IOException
    //   852	859	1069	java/io/IOException
    //   902	909	1069	java/io/IOException
    //   927	934	1069	java/io/IOException
    //   67	73	1073	java/net/SocketException
    //   101	118	1073	java/net/SocketException
    //   144	154	1073	java/net/SocketException
    //   177	188	1073	java/net/SocketException
    //   216	235	1073	java/net/SocketException
    //   258	269	1073	java/net/SocketException
    //   292	303	1073	java/net/SocketException
    //   326	339	1073	java/net/SocketException
    //   362	370	1073	java/net/SocketException
    //   407	414	1073	java/net/SocketException
    //   462	472	1073	java/net/SocketException
    //   535	545	1073	java/net/SocketException
    //   608	620	1073	java/net/SocketException
    //   654	664	1073	java/net/SocketException
    //   690	706	1073	java/net/SocketException
    //   729	739	1073	java/net/SocketException
    //   762	773	1073	java/net/SocketException
    //   796	809	1073	java/net/SocketException
    //   852	859	1073	java/net/SocketException
    //   902	909	1073	java/net/SocketException
    //   927	934	1073	java/net/SocketException
    //   38	44	1077	java/net/SocketTimeoutException
    //   38	44	1084	org/apache/http/client/ClientProtocolException
  }
  
  private byte[] readHttpBody(HttpEntity paramHttpEntity, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramBoolean) {}
    try
    {
      paramHttpEntity = new GZIPInputStream(paramHttpEntity.getContent());
    }
    catch (IllegalStateException paramHttpEntity)
    {
      paramHttpEntity.printStackTrace();
      paramHttpEntity = null;
    }
    catch (IOException paramHttpEntity)
    {
      paramHttpEntity.printStackTrace();
      paramHttpEntity = null;
    }
    paramHttpEntity = paramHttpEntity.getContent();
    break label149;
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[1024];
      try
      {
        for (;;)
        {
          int i = paramHttpEntity.read(arrayOfByte1);
          if (i <= 0) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte1, 0, i);
        }
        byte[] arrayOfByte2;
        if (paramHttpEntity != null) {}
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        if (paramHttpEntity != null) {}
        try
        {
          paramHttpEntity.close();
          paramHttpEntity = arrayOfByte2;
          if (localByteArrayOutputStream == null) {
            return paramHttpEntity;
          }
          localByteArrayOutputStream.close();
          return arrayOfByte2;
        }
        catch (IOException paramHttpEntity)
        {
          paramHttpEntity = paramHttpEntity;
          paramHttpEntity.printStackTrace();
          return arrayOfByte2;
        }
        finally {}
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    label149:
    paramHttpEntity = null;
    return paramHttpEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.HttpUtil
 * JD-Core Version:    0.7.0.1
 */