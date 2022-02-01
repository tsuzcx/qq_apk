package com.tencent.tpns.baseapi.core.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class a
{
  private static a a = null;
  private Context b = null;
  
  private a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramContext.getApplicationContext() != null) {
        this.b = paramContext.getApplicationContext();
      }
    }
    else {
      return;
    }
    this.b = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = new URL(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      Logger.e("HttpRequest", "getHostName Exception :", paramString);
    }
    return "";
  }
  
  /* Error */
  public String a(String paramString1, String paramString2, String paramString3, HttpRequestCallback paramHttpRequestCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 39
    //   2: astore 8
    //   4: aload_3
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_3
    //   13: invokevirtual 73	java/lang/String:length	()I
    //   16: istore 6
    //   18: ldc 50
    //   20: new 75	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   27: ldc 78
    //   29: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 84
    //   38: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload 6
    //   43: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 89
    //   48: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_3
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 96	com/tencent/tpns/baseapi/base/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc 39
    //   63: astore 10
    //   65: aload 10
    //   67: astore 9
    //   69: new 98	org/json/JSONObject
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore 11
    //   79: aload 10
    //   81: astore 9
    //   83: aload 11
    //   85: ldc 101
    //   87: ldc 39
    //   89: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 10
    //   94: aload 10
    //   96: astore 9
    //   98: aload 11
    //   100: ldc 107
    //   102: ldc 39
    //   104: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 11
    //   109: aload 11
    //   111: astore 9
    //   113: aload 10
    //   115: astore 11
    //   117: ldc 50
    //   119: new 75	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   126: ldc 109
    //   128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 111
    //   137: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_2
    //   141: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 96	com/tencent/tpns/baseapi/base/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: new 41	java/net/URL
    //   153: dup
    //   154: aload_1
    //   155: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 114	java/net/URL:getProtocol	()Ljava/lang/String;
    //   163: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   166: ldc 119
    //   168: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +530 -> 701
    //   174: aload_1
    //   175: invokevirtual 127	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   178: checkcast 129	javax/net/ssl/HttpsURLConnection
    //   181: astore_1
    //   182: aload_1
    //   183: ldc 131
    //   185: aload_2
    //   186: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_1
    //   190: checkcast 129	javax/net/ssl/HttpsURLConnection
    //   193: new 138	com/tencent/tpns/baseapi/core/net/a$1
    //   196: dup
    //   197: aload_0
    //   198: aload_2
    //   199: invokespecial 141	com/tencent/tpns/baseapi/core/net/a$1:<init>	(Lcom/tencent/tpns/baseapi/core/net/a;Ljava/lang/String;)V
    //   202: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   205: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   208: bipush 20
    //   210: if_icmpge +1015 -> 1225
    //   213: aload_1
    //   214: checkcast 129	javax/net/ssl/HttpsURLConnection
    //   217: new 153	com/tencent/tpns/baseapi/core/net/TlsCompatSocketFactory
    //   220: dup
    //   221: aload_1
    //   222: checkcast 129	javax/net/ssl/HttpsURLConnection
    //   225: invokevirtual 157	javax/net/ssl/HttpsURLConnection:getSSLSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   228: invokespecial 160	com/tencent/tpns/baseapi/core/net/TlsCompatSocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   231: invokevirtual 163	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   234: aload_1
    //   235: astore 10
    //   237: aload 10
    //   239: sipush 15000
    //   242: invokevirtual 167	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   245: aload 10
    //   247: iconst_1
    //   248: invokevirtual 171	java/net/HttpURLConnection:setDoInput	(Z)V
    //   251: aload 10
    //   253: iconst_1
    //   254: invokevirtual 174	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   257: aload 10
    //   259: iconst_0
    //   260: invokevirtual 177	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   263: aload 10
    //   265: ldc 179
    //   267: invokevirtual 182	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   270: aload 10
    //   272: ldc 184
    //   274: ldc 186
    //   276: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 10
    //   281: sipush 15000
    //   284: invokevirtual 189	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   287: aload 11
    //   289: ifnull +20 -> 309
    //   292: aload 11
    //   294: invokevirtual 73	java/lang/String:length	()I
    //   297: ifle +12 -> 309
    //   300: aload 10
    //   302: ldc 191
    //   304: aload 11
    //   306: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 9
    //   311: ifnull +20 -> 331
    //   314: aload 9
    //   316: invokevirtual 73	java/lang/String:length	()I
    //   319: ifle +12 -> 331
    //   322: aload 10
    //   324: ldc 193
    //   326: aload 9
    //   328: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: iload 5
    //   333: ifeq +132 -> 465
    //   336: aload 11
    //   338: aload_0
    //   339: getfield 19	com/tencent/tpns/baseapi/core/net/a:b	Landroid/content/Context;
    //   342: invokestatic 199	com/tencent/tpns/baseapi/XGApiConfig:getAccessKey	(Landroid/content/Context;)Ljava/lang/String;
    //   345: aload_3
    //   346: ldc 201
    //   348: invokevirtual 205	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   351: invokestatic 211	com/tencent/tpns/baseapi/base/util/HttpHelper:getSignAuthHeader	(Ljava/lang/String;Ljava/lang/String;[B)Ljava/util/Map;
    //   354: astore_1
    //   355: aload_1
    //   356: ifnull +109 -> 465
    //   359: aload_1
    //   360: invokeinterface 217 1 0
    //   365: invokeinterface 223 1 0
    //   370: astore_1
    //   371: aload_1
    //   372: invokeinterface 229 1 0
    //   377: ifeq +88 -> 465
    //   380: aload_1
    //   381: invokeinterface 233 1 0
    //   386: checkcast 235	java/util/Map$Entry
    //   389: astore 9
    //   391: aload 9
    //   393: invokeinterface 238 1 0
    //   398: checkcast 69	java/lang/String
    //   401: astore_2
    //   402: aload 9
    //   404: invokeinterface 241 1 0
    //   409: checkcast 69	java/lang/String
    //   412: astore 9
    //   414: aload_2
    //   415: invokestatic 247	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   418: ifne -47 -> 371
    //   421: aload 9
    //   423: ifnull -52 -> 371
    //   426: aload 10
    //   428: aload_2
    //   429: aload 9
    //   431: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: goto -63 -> 371
    //   437: astore_1
    //   438: ldc 50
    //   440: new 75	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   447: ldc 249
    //   449: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_1
    //   453: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   456: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 253	com/tencent/tpns/baseapi/base/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_3
    //   466: ldc 201
    //   468: invokevirtual 205	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   471: astore_1
    //   472: new 255	java/io/DataOutputStream
    //   475: dup
    //   476: aload 10
    //   478: invokevirtual 259	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   481: invokespecial 262	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   484: astore 11
    //   486: aload 11
    //   488: aload_1
    //   489: invokevirtual 266	java/io/DataOutputStream:write	([B)V
    //   492: aload 11
    //   494: invokevirtual 269	java/io/DataOutputStream:flush	()V
    //   497: aload 10
    //   499: invokevirtual 272	java/net/HttpURLConnection:getResponseCode	()I
    //   502: istore 6
    //   504: aload 10
    //   506: invokevirtual 275	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   509: astore 12
    //   511: aload 10
    //   513: invokevirtual 278	java/net/HttpURLConnection:getContentLength	()I
    //   516: istore 7
    //   518: ldc 50
    //   520: new 75	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   527: ldc_w 280
    //   530: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: iload 6
    //   535: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 282
    //   541: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 12
    //   546: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 284
    //   552: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 7
    //   557: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 96	com/tencent/tpns/baseapi/base/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: iload 6
    //   568: sipush 200
    //   571: if_icmpne +343 -> 914
    //   574: new 286	java/io/BufferedReader
    //   577: dup
    //   578: new 288	java/io/InputStreamReader
    //   581: dup
    //   582: aload 10
    //   584: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   587: ldc 201
    //   589: invokespecial 295	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   592: invokespecial 298	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   595: astore 12
    //   597: ldc 39
    //   599: astore_1
    //   600: aload_1
    //   601: astore_2
    //   602: aload_1
    //   603: astore_3
    //   604: aload_1
    //   605: astore 8
    //   607: aload_1
    //   608: astore 9
    //   610: aload 12
    //   612: invokevirtual 301	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   615: astore 13
    //   617: aload 13
    //   619: ifnull +102 -> 721
    //   622: aload_1
    //   623: astore_2
    //   624: aload_1
    //   625: astore_3
    //   626: aload_1
    //   627: astore 8
    //   629: aload_1
    //   630: astore 9
    //   632: new 75	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   639: aload_1
    //   640: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: aload 13
    //   645: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: astore_1
    //   652: goto -52 -> 600
    //   655: astore 10
    //   657: ldc 50
    //   659: new 75	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   666: ldc_w 303
    //   669: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 10
    //   674: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   677: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 305	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: ldc 39
    //   688: astore 10
    //   690: aload 9
    //   692: astore 11
    //   694: aload 10
    //   696: astore 9
    //   698: goto -581 -> 117
    //   701: aload_1
    //   702: invokevirtual 127	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   705: checkcast 133	java/net/HttpURLConnection
    //   708: astore 10
    //   710: aload 10
    //   712: ldc 131
    //   714: aload_2
    //   715: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: goto -481 -> 237
    //   721: aload_1
    //   722: astore_2
    //   723: aload_1
    //   724: astore_3
    //   725: aload_1
    //   726: astore 8
    //   728: aload_1
    //   729: astore 9
    //   731: ldc 50
    //   733: new 75	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   740: ldc_w 307
    //   743: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload_1
    //   747: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 96	com/tencent/tpns/baseapi/base/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload 4
    //   758: ifnull +21 -> 779
    //   761: aload_1
    //   762: astore_2
    //   763: aload_1
    //   764: astore_3
    //   765: aload_1
    //   766: astore 8
    //   768: aload_1
    //   769: astore 9
    //   771: aload 4
    //   773: aload_1
    //   774: invokeinterface 312 2 0
    //   779: aload_1
    //   780: astore_2
    //   781: aload_1
    //   782: astore_3
    //   783: aload_1
    //   784: astore 8
    //   786: aload_1
    //   787: astore 9
    //   789: aload 12
    //   791: invokevirtual 315	java/io/BufferedReader:close	()V
    //   794: aload_1
    //   795: astore_2
    //   796: aload_1
    //   797: astore_3
    //   798: aload_1
    //   799: astore 8
    //   801: aload_1
    //   802: astore 9
    //   804: aload 11
    //   806: invokevirtual 316	java/io/DataOutputStream:close	()V
    //   809: aload_1
    //   810: astore_2
    //   811: aload_1
    //   812: astore_3
    //   813: aload_1
    //   814: astore 8
    //   816: aload_1
    //   817: astore 9
    //   819: aload 10
    //   821: invokevirtual 319	java/net/HttpURLConnection:disconnect	()V
    //   824: aconst_null
    //   825: astore_2
    //   826: iconst_0
    //   827: istore 6
    //   829: aload_1
    //   830: astore_3
    //   831: aload_2
    //   832: ifnull -822 -> 10
    //   835: ldc 50
    //   837: new 75	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 321
    //   847: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_2
    //   851: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   854: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: aload_2
    //   861: invokestatic 58	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   864: aload_1
    //   865: astore_3
    //   866: aload 4
    //   868: ifnull -858 -> 10
    //   871: aload 4
    //   873: iload 6
    //   875: new 75	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   882: ldc_w 323
    //   885: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload_2
    //   889: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokeinterface 330 3 0
    //   900: aload_1
    //   901: areturn
    //   902: astore_2
    //   903: ldc 50
    //   905: ldc_w 332
    //   908: aload_2
    //   909: invokestatic 58	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   912: aload_1
    //   913: areturn
    //   914: ldc 50
    //   916: new 75	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 334
    //   926: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: iload 6
    //   931: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   934: ldc_w 336
    //   937: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload 12
    //   942: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokestatic 305	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   951: new 286	java/io/BufferedReader
    //   954: dup
    //   955: new 288	java/io/InputStreamReader
    //   958: dup
    //   959: aload 10
    //   961: invokevirtual 339	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   964: ldc 201
    //   966: invokespecial 295	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   969: invokespecial 298	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   972: astore 13
    //   974: ldc 39
    //   976: astore_1
    //   977: aload_1
    //   978: astore_2
    //   979: aload_1
    //   980: astore_3
    //   981: aload_1
    //   982: astore 8
    //   984: aload_1
    //   985: astore 9
    //   987: aload 13
    //   989: invokevirtual 301	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   992: astore 14
    //   994: aload 14
    //   996: ifnull +36 -> 1032
    //   999: aload_1
    //   1000: astore_2
    //   1001: aload_1
    //   1002: astore_3
    //   1003: aload_1
    //   1004: astore 8
    //   1006: aload_1
    //   1007: astore 9
    //   1009: new 75	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1016: aload_1
    //   1017: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 14
    //   1022: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: astore_1
    //   1029: goto -52 -> 977
    //   1032: aload_1
    //   1033: astore_2
    //   1034: aload_1
    //   1035: astore_3
    //   1036: aload_1
    //   1037: astore 8
    //   1039: aload_1
    //   1040: astore 9
    //   1042: ldc 50
    //   1044: new 75	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1051: ldc_w 341
    //   1054: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload_1
    //   1058: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 305	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1067: aload 4
    //   1069: ifnull +55 -> 1124
    //   1072: aload_1
    //   1073: astore_2
    //   1074: aload_1
    //   1075: astore_3
    //   1076: aload_1
    //   1077: astore 8
    //   1079: aload_1
    //   1080: astore 9
    //   1082: aload 4
    //   1084: sipush -510
    //   1087: new 75	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1094: ldc_w 343
    //   1097: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: iload 6
    //   1102: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1105: ldc_w 345
    //   1108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 12
    //   1113: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokeinterface 330 3 0
    //   1124: aload_1
    //   1125: astore_2
    //   1126: aload_1
    //   1127: astore_3
    //   1128: aload_1
    //   1129: astore 8
    //   1131: aload_1
    //   1132: astore 9
    //   1134: aload 13
    //   1136: invokevirtual 315	java/io/BufferedReader:close	()V
    //   1139: goto -345 -> 794
    //   1142: astore_1
    //   1143: aload_1
    //   1144: astore_3
    //   1145: aload_2
    //   1146: astore_1
    //   1147: sipush -506
    //   1150: istore 6
    //   1152: aload_3
    //   1153: astore_2
    //   1154: goto -325 -> 829
    //   1157: astore_1
    //   1158: sipush -512
    //   1161: istore 6
    //   1163: aload_1
    //   1164: astore_2
    //   1165: aload 8
    //   1167: astore_1
    //   1168: goto -339 -> 829
    //   1171: astore_1
    //   1172: sipush -513
    //   1175: istore 6
    //   1177: aload_1
    //   1178: astore_2
    //   1179: aload 8
    //   1181: astore_1
    //   1182: goto -353 -> 829
    //   1185: astore_1
    //   1186: sipush -511
    //   1189: istore 6
    //   1191: aload_1
    //   1192: astore_2
    //   1193: aload 8
    //   1195: astore_1
    //   1196: goto -367 -> 829
    //   1199: astore_1
    //   1200: aload_3
    //   1201: astore 8
    //   1203: goto -17 -> 1186
    //   1206: astore_1
    //   1207: goto -35 -> 1172
    //   1210: astore_1
    //   1211: aload 9
    //   1213: astore 8
    //   1215: goto -57 -> 1158
    //   1218: astore_1
    //   1219: ldc 39
    //   1221: astore_2
    //   1222: goto -79 -> 1143
    //   1225: aload_1
    //   1226: astore 10
    //   1228: goto -991 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1231	0	this	a
    //   0	1231	1	paramString1	String
    //   0	1231	2	paramString2	String
    //   0	1231	3	paramString3	String
    //   0	1231	4	paramHttpRequestCallback	HttpRequestCallback
    //   0	1231	5	paramBoolean	boolean
    //   16	1174	6	i	int
    //   516	40	7	j	int
    //   2	1212	8	localObject1	Object
    //   67	1145	9	localObject2	Object
    //   63	520	10	str1	String
    //   655	18	10	localThrowable	java.lang.Throwable
    //   688	539	10	localObject3	Object
    //   77	728	11	localObject4	Object
    //   509	603	12	localObject5	Object
    //   615	520	13	localObject6	Object
    //   992	29	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   336	355	437	java/lang/Throwable
    //   359	371	437	java/lang/Throwable
    //   371	421	437	java/lang/Throwable
    //   426	434	437	java/lang/Throwable
    //   69	79	655	java/lang/Throwable
    //   83	94	655	java/lang/Throwable
    //   98	109	655	java/lang/Throwable
    //   871	900	902	java/lang/Throwable
    //   610	617	1142	java/net/UnknownHostException
    //   632	652	1142	java/net/UnknownHostException
    //   731	756	1142	java/net/UnknownHostException
    //   771	779	1142	java/net/UnknownHostException
    //   789	794	1142	java/net/UnknownHostException
    //   804	809	1142	java/net/UnknownHostException
    //   819	824	1142	java/net/UnknownHostException
    //   987	994	1142	java/net/UnknownHostException
    //   1009	1029	1142	java/net/UnknownHostException
    //   1042	1067	1142	java/net/UnknownHostException
    //   1082	1124	1142	java/net/UnknownHostException
    //   1134	1139	1142	java/net/UnknownHostException
    //   12	61	1157	java/net/SocketTimeoutException
    //   69	79	1157	java/net/SocketTimeoutException
    //   83	94	1157	java/net/SocketTimeoutException
    //   98	109	1157	java/net/SocketTimeoutException
    //   117	234	1157	java/net/SocketTimeoutException
    //   237	287	1157	java/net/SocketTimeoutException
    //   292	309	1157	java/net/SocketTimeoutException
    //   314	331	1157	java/net/SocketTimeoutException
    //   336	355	1157	java/net/SocketTimeoutException
    //   359	371	1157	java/net/SocketTimeoutException
    //   371	421	1157	java/net/SocketTimeoutException
    //   426	434	1157	java/net/SocketTimeoutException
    //   438	465	1157	java/net/SocketTimeoutException
    //   465	566	1157	java/net/SocketTimeoutException
    //   574	597	1157	java/net/SocketTimeoutException
    //   657	686	1157	java/net/SocketTimeoutException
    //   701	718	1157	java/net/SocketTimeoutException
    //   914	974	1157	java/net/SocketTimeoutException
    //   12	61	1171	java/net/ConnectException
    //   69	79	1171	java/net/ConnectException
    //   83	94	1171	java/net/ConnectException
    //   98	109	1171	java/net/ConnectException
    //   117	234	1171	java/net/ConnectException
    //   237	287	1171	java/net/ConnectException
    //   292	309	1171	java/net/ConnectException
    //   314	331	1171	java/net/ConnectException
    //   336	355	1171	java/net/ConnectException
    //   359	371	1171	java/net/ConnectException
    //   371	421	1171	java/net/ConnectException
    //   426	434	1171	java/net/ConnectException
    //   438	465	1171	java/net/ConnectException
    //   465	566	1171	java/net/ConnectException
    //   574	597	1171	java/net/ConnectException
    //   657	686	1171	java/net/ConnectException
    //   701	718	1171	java/net/ConnectException
    //   914	974	1171	java/net/ConnectException
    //   12	61	1185	java/lang/Throwable
    //   117	234	1185	java/lang/Throwable
    //   237	287	1185	java/lang/Throwable
    //   292	309	1185	java/lang/Throwable
    //   314	331	1185	java/lang/Throwable
    //   438	465	1185	java/lang/Throwable
    //   465	566	1185	java/lang/Throwable
    //   574	597	1185	java/lang/Throwable
    //   657	686	1185	java/lang/Throwable
    //   701	718	1185	java/lang/Throwable
    //   914	974	1185	java/lang/Throwable
    //   610	617	1199	java/lang/Throwable
    //   632	652	1199	java/lang/Throwable
    //   731	756	1199	java/lang/Throwable
    //   771	779	1199	java/lang/Throwable
    //   789	794	1199	java/lang/Throwable
    //   804	809	1199	java/lang/Throwable
    //   819	824	1199	java/lang/Throwable
    //   987	994	1199	java/lang/Throwable
    //   1009	1029	1199	java/lang/Throwable
    //   1042	1067	1199	java/lang/Throwable
    //   1082	1124	1199	java/lang/Throwable
    //   1134	1139	1199	java/lang/Throwable
    //   610	617	1206	java/net/ConnectException
    //   632	652	1206	java/net/ConnectException
    //   731	756	1206	java/net/ConnectException
    //   771	779	1206	java/net/ConnectException
    //   789	794	1206	java/net/ConnectException
    //   804	809	1206	java/net/ConnectException
    //   819	824	1206	java/net/ConnectException
    //   987	994	1206	java/net/ConnectException
    //   1009	1029	1206	java/net/ConnectException
    //   1042	1067	1206	java/net/ConnectException
    //   1082	1124	1206	java/net/ConnectException
    //   1134	1139	1206	java/net/ConnectException
    //   610	617	1210	java/net/SocketTimeoutException
    //   632	652	1210	java/net/SocketTimeoutException
    //   731	756	1210	java/net/SocketTimeoutException
    //   771	779	1210	java/net/SocketTimeoutException
    //   789	794	1210	java/net/SocketTimeoutException
    //   804	809	1210	java/net/SocketTimeoutException
    //   819	824	1210	java/net/SocketTimeoutException
    //   987	994	1210	java/net/SocketTimeoutException
    //   1009	1029	1210	java/net/SocketTimeoutException
    //   1042	1067	1210	java/net/SocketTimeoutException
    //   1082	1124	1210	java/net/SocketTimeoutException
    //   1134	1139	1210	java/net/SocketTimeoutException
    //   12	61	1218	java/net/UnknownHostException
    //   69	79	1218	java/net/UnknownHostException
    //   83	94	1218	java/net/UnknownHostException
    //   98	109	1218	java/net/UnknownHostException
    //   117	234	1218	java/net/UnknownHostException
    //   237	287	1218	java/net/UnknownHostException
    //   292	309	1218	java/net/UnknownHostException
    //   314	331	1218	java/net/UnknownHostException
    //   336	355	1218	java/net/UnknownHostException
    //   359	371	1218	java/net/UnknownHostException
    //   371	421	1218	java/net/UnknownHostException
    //   426	434	1218	java/net/UnknownHostException
    //   438	465	1218	java/net/UnknownHostException
    //   465	566	1218	java/net/UnknownHostException
    //   574	597	1218	java/net/UnknownHostException
    //   657	686	1218	java/net/UnknownHostException
    //   701	718	1218	java/net/UnknownHostException
    //   914	974	1218	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.net.a
 * JD-Core Version:    0.7.0.1
 */