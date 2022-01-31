package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bnv;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil
{
  public static final int a = 15000;
  public static final String a;
  private static boolean a = false;
  public static final int b = 30000;
  public static final String b = "GET";
  public static final String c = "POST";
  public static final String d = "http://cgi.connect.qq.com/qqconnectopen/upload_share_image";
  public static final String e = "1";
  private static final String f = "http://openmobile.qq.com/api/url_change";
  private static final String g = "http://openmobile.qq.com/api/shortUrl";
  
  static
  {
    jdField_a_of_type_JavaLangString = HttpUtil.class.getSimpleName();
    jdField_a_of_type_Boolean = false;
  }
  
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (b(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  public static HttpUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (NetworkUtil.a((NetworkInfo)localObject))
    {
      localObject = a(paramContext);
      int i = a(paramContext);
      if ((!b((String)localObject)) && (i >= 0)) {
        return new HttpUtil.NetworkProxy((String)localObject, i, null);
      }
    }
    return null;
  }
  
  private static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
  {
    Object localObject2 = paramHttpResponse.getEntity();
    Object localObject1 = null;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localObject2 = ((HttpEntity)localObject2).getContent();
      localObject1 = localObject2;
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject1 = localObject2;
      Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
      paramHttpResponse = (HttpResponse)localObject2;
      if (localHeader != null)
      {
        paramHttpResponse = (HttpResponse)localObject2;
        localObject1 = localObject2;
        if (localHeader.getValue().toLowerCase().contains("gzip"))
        {
          localObject1 = localObject2;
          paramHttpResponse = new GZIPInputStream((InputStream)localObject2);
        }
      }
      localObject1 = paramHttpResponse;
      localObject2 = new byte[512];
      for (;;)
      {
        localObject1 = paramHttpResponse;
        int i = paramHttpResponse.read((byte[])localObject2);
        if (i == -1) {
          break;
        }
        localObject1 = paramHttpResponse;
        localByteArrayOutputStream.write((byte[])localObject2, 0, i);
      }
      if (paramHttpResponse == null) {
        break label132;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
    }
    paramHttpResponse.close();
    label132:
    return localByteArrayOutputStream;
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (b(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  protected static final String a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    localBundle.putString("Referer", "http://openmobile.qq.com/");
    paramString1 = new Bundle();
    paramString1.putString("type", String.valueOf(paramInt));
    paramString1.putString("value", paramJSONArray.toString());
    try
    {
      paramContext = a(paramContext, "http://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      QLog.d("zivonchen", 4, paramContext.getMessage());
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.w))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label186;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label186:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label131:
            if (j >= localObject1.length) {
              break label206;
            }
            if (j != 0) {
              break label172;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label131;
            localStringBuilder.append("&");
            break;
            label172:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label206:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  /* Error */
  public static final String a(String paramString1, String paramString2, String paramString3, Map paramMap1, Map paramMap2, Map paramMap3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 9
    //   31: new 358	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 359	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 363	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 365	java/net/HttpURLConnection
    //   45: astore 7
    //   47: aload 7
    //   49: sipush 5000
    //   52: invokevirtual 369	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   55: aload 7
    //   57: sipush 30000
    //   60: invokevirtual 372	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   63: aload 7
    //   65: iconst_1
    //   66: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   69: aload 7
    //   71: iconst_1
    //   72: invokevirtual 379	java/net/HttpURLConnection:setDoInput	(Z)V
    //   75: aload 7
    //   77: iconst_0
    //   78: invokevirtual 382	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   81: aload 7
    //   83: ldc 17
    //   85: invokevirtual 385	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   88: aload 7
    //   90: ldc_w 387
    //   93: ldc_w 389
    //   96: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 7
    //   101: ldc_w 394
    //   104: new 183	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 396
    //   111: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: ldc_w 399
    //   117: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 402	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   123: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 399
    //   129: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 407	android/os/Build:DEVICE	Ljava/lang/String;
    //   135: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 399
    //   141: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 410	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   147: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 399
    //   153: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 412
    //   159: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 7
    //   170: ldc_w 414
    //   173: new 183	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 416
    //   183: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 418
    //   189: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 5
    //   200: astore 8
    //   202: aload 5
    //   204: ifnonnull +12 -> 216
    //   207: new 420	java/util/HashMap
    //   210: dup
    //   211: invokespecial 421	java/util/HashMap:<init>	()V
    //   214: astore 8
    //   216: aload 8
    //   218: ldc 181
    //   220: new 183	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   227: ldc 186
    //   229: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 192
    //   238: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokeinterface 427 3 0
    //   253: pop
    //   254: aload 8
    //   256: invokeinterface 430 1 0
    //   261: invokeinterface 293 1 0
    //   266: astore_1
    //   267: aload_1
    //   268: invokeinterface 299 1 0
    //   273: ifeq +87 -> 360
    //   276: aload_1
    //   277: invokeinterface 303 1 0
    //   282: checkcast 432	java/util/Map$Entry
    //   285: astore_2
    //   286: aload 7
    //   288: aload_2
    //   289: invokeinterface 435 1 0
    //   294: checkcast 138	java/lang/String
    //   297: aload_2
    //   298: invokeinterface 437 1 0
    //   303: checkcast 138	java/lang/String
    //   306: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: goto -42 -> 267
    //   312: astore_1
    //   313: aload 7
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_2
    //   319: astore 8
    //   321: ldc_w 439
    //   324: iconst_2
    //   325: new 183	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 441
    //   335: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_0
    //   339: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 227	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload_1
    //   349: astore_0
    //   350: aload_2
    //   351: ifnull -328 -> 23
    //   354: aload_2
    //   355: invokevirtual 444	java/net/HttpURLConnection:disconnect	()V
    //   358: aload_1
    //   359: areturn
    //   360: new 446	java/io/DataOutputStream
    //   363: dup
    //   364: aload 7
    //   366: invokevirtual 450	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   369: invokespecial 453	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   372: astore_2
    //   373: aload_3
    //   374: ifnull +164 -> 538
    //   377: new 455	java/lang/StringBuffer
    //   380: dup
    //   381: invokespecial 456	java/lang/StringBuffer:<init>	()V
    //   384: astore_1
    //   385: aload_3
    //   386: invokeinterface 430 1 0
    //   391: invokeinterface 293 1 0
    //   396: astore_3
    //   397: aload_3
    //   398: invokeinterface 299 1 0
    //   403: ifeq +124 -> 527
    //   406: aload_3
    //   407: invokeinterface 303 1 0
    //   412: checkcast 432	java/util/Map$Entry
    //   415: astore 8
    //   417: aload 8
    //   419: invokeinterface 435 1 0
    //   424: checkcast 138	java/lang/String
    //   427: astore 5
    //   429: aload 8
    //   431: invokeinterface 437 1 0
    //   436: checkcast 138	java/lang/String
    //   439: astore 8
    //   441: aload 8
    //   443: ifnull -46 -> 397
    //   446: aload_1
    //   447: ldc_w 458
    //   450: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   453: ldc_w 463
    //   456: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   459: ldc_w 418
    //   462: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   465: ldc_w 458
    //   468: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   471: pop
    //   472: aload_1
    //   473: new 183	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 465
    //   483: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 5
    //   488: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 467
    //   494: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   503: pop
    //   504: aload_1
    //   505: aload 8
    //   507: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   510: pop
    //   511: goto -114 -> 397
    //   514: astore_0
    //   515: aload 7
    //   517: ifnull +8 -> 525
    //   520: aload 7
    //   522: invokevirtual 444	java/net/HttpURLConnection:disconnect	()V
    //   525: aload_0
    //   526: athrow
    //   527: aload_2
    //   528: aload_1
    //   529: invokevirtual 468	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   532: invokevirtual 472	java/lang/String:getBytes	()[B
    //   535: invokevirtual 477	java/io/OutputStream:write	([B)V
    //   538: aload 4
    //   540: ifnull +294 -> 834
    //   543: aload 4
    //   545: invokeinterface 430 1 0
    //   550: invokeinterface 293 1 0
    //   555: astore_3
    //   556: aload_3
    //   557: invokeinterface 299 1 0
    //   562: ifeq +272 -> 834
    //   565: aload_3
    //   566: invokeinterface 303 1 0
    //   571: checkcast 432	java/util/Map$Entry
    //   574: astore_1
    //   575: aload_1
    //   576: invokeinterface 435 1 0
    //   581: checkcast 138	java/lang/String
    //   584: astore 4
    //   586: aload_1
    //   587: invokeinterface 437 1 0
    //   592: checkcast 138	java/lang/String
    //   595: astore_1
    //   596: aload_1
    //   597: ifnull -41 -> 556
    //   600: new 479	java/io/File
    //   603: dup
    //   604: aload_1
    //   605: invokespecial 480	java/io/File:<init>	(Ljava/lang/String;)V
    //   608: astore 5
    //   610: aload 5
    //   612: invokevirtual 483	java/io/File:getName	()Ljava/lang/String;
    //   615: astore 8
    //   617: aload 8
    //   619: ldc_w 485
    //   622: invokevirtual 488	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   625: ifeq +3 -> 628
    //   628: ldc_w 490
    //   631: astore_1
    //   632: ldc_w 490
    //   635: ifnull +341 -> 976
    //   638: ldc_w 490
    //   641: ldc_w 283
    //   644: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +6 -> 653
    //   650: goto +326 -> 976
    //   653: new 455	java/lang/StringBuffer
    //   656: dup
    //   657: invokespecial 456	java/lang/StringBuffer:<init>	()V
    //   660: astore 9
    //   662: aload 9
    //   664: ldc_w 458
    //   667: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   670: ldc_w 463
    //   673: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   676: ldc_w 418
    //   679: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   682: ldc_w 458
    //   685: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   688: pop
    //   689: aload 9
    //   691: new 183	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 465
    //   701: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 4
    //   706: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 492
    //   712: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 8
    //   717: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: ldc_w 494
    //   723: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   732: pop
    //   733: aload 9
    //   735: new 183	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   742: ldc_w 496
    //   745: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_1
    //   749: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 498
    //   755: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: aload_2
    //   766: aload 9
    //   768: invokevirtual 468	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   771: invokevirtual 472	java/lang/String:getBytes	()[B
    //   774: invokevirtual 477	java/io/OutputStream:write	([B)V
    //   777: new 500	java/io/DataInputStream
    //   780: dup
    //   781: new 502	java/io/FileInputStream
    //   784: dup
    //   785: aload 5
    //   787: invokespecial 505	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   790: invokespecial 506	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   793: astore_1
    //   794: sipush 1024
    //   797: newarray byte
    //   799: astore 4
    //   801: aload_1
    //   802: aload 4
    //   804: invokevirtual 507	java/io/DataInputStream:read	([B)I
    //   807: istore 6
    //   809: iload 6
    //   811: iconst_m1
    //   812: if_icmpeq +15 -> 827
    //   815: aload_2
    //   816: aload 4
    //   818: iconst_0
    //   819: iload 6
    //   821: invokevirtual 508	java/io/OutputStream:write	([BII)V
    //   824: goto -23 -> 801
    //   827: aload_1
    //   828: invokevirtual 509	java/io/DataInputStream:close	()V
    //   831: goto -275 -> 556
    //   834: aload_2
    //   835: new 183	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 511
    //   845: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: ldc_w 418
    //   851: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 513
    //   857: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokevirtual 472	java/lang/String:getBytes	()[B
    //   866: invokevirtual 477	java/io/OutputStream:write	([B)V
    //   869: aload_2
    //   870: invokevirtual 516	java/io/OutputStream:flush	()V
    //   873: aload_2
    //   874: invokevirtual 517	java/io/OutputStream:close	()V
    //   877: new 455	java/lang/StringBuffer
    //   880: dup
    //   881: invokespecial 456	java/lang/StringBuffer:<init>	()V
    //   884: astore_1
    //   885: new 519	java/io/BufferedReader
    //   888: dup
    //   889: new 521	java/io/InputStreamReader
    //   892: dup
    //   893: aload 7
    //   895: invokevirtual 524	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   898: invokespecial 525	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   901: invokespecial 528	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   904: astore_2
    //   905: aload_2
    //   906: invokevirtual 531	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   909: astore_3
    //   910: aload_3
    //   911: ifnull +18 -> 929
    //   914: aload_1
    //   915: aload_3
    //   916: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   919: ldc_w 533
    //   922: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   925: pop
    //   926: goto -21 -> 905
    //   929: aload_1
    //   930: invokevirtual 468	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   933: astore_1
    //   934: aload_2
    //   935: invokevirtual 534	java/io/BufferedReader:close	()V
    //   938: aload 7
    //   940: ifnull +34 -> 974
    //   943: aload 7
    //   945: invokevirtual 444	java/net/HttpURLConnection:disconnect	()V
    //   948: aload_1
    //   949: areturn
    //   950: astore_0
    //   951: aload 8
    //   953: astore 7
    //   955: goto -440 -> 515
    //   958: astore_1
    //   959: aconst_null
    //   960: astore_1
    //   961: aload 9
    //   963: astore_2
    //   964: goto -646 -> 318
    //   967: astore_2
    //   968: aload 7
    //   970: astore_2
    //   971: goto -653 -> 318
    //   974: aload_1
    //   975: areturn
    //   976: ldc_w 536
    //   979: astore_1
    //   980: goto -327 -> 653
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	983	0	paramString1	String
    //   0	983	1	paramString2	String
    //   0	983	2	paramString3	String
    //   0	983	3	paramMap1	Map
    //   0	983	4	paramMap2	Map
    //   0	983	5	paramMap3	Map
    //   807	13	6	i	int
    //   45	924	7	localObject1	Object
    //   26	926	8	localObject2	Object
    //   29	933	9	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   47	198	312	java/lang/Exception
    //   207	216	312	java/lang/Exception
    //   216	267	312	java/lang/Exception
    //   267	309	312	java/lang/Exception
    //   360	373	312	java/lang/Exception
    //   377	397	312	java/lang/Exception
    //   397	441	312	java/lang/Exception
    //   446	511	312	java/lang/Exception
    //   527	538	312	java/lang/Exception
    //   543	556	312	java/lang/Exception
    //   556	596	312	java/lang/Exception
    //   600	628	312	java/lang/Exception
    //   638	650	312	java/lang/Exception
    //   653	801	312	java/lang/Exception
    //   801	809	312	java/lang/Exception
    //   815	824	312	java/lang/Exception
    //   827	831	312	java/lang/Exception
    //   834	905	312	java/lang/Exception
    //   905	910	312	java/lang/Exception
    //   914	926	312	java/lang/Exception
    //   929	934	312	java/lang/Exception
    //   47	198	514	finally
    //   207	216	514	finally
    //   216	267	514	finally
    //   267	309	514	finally
    //   360	373	514	finally
    //   377	397	514	finally
    //   397	441	514	finally
    //   446	511	514	finally
    //   527	538	514	finally
    //   543	556	514	finally
    //   556	596	514	finally
    //   600	628	514	finally
    //   638	650	514	finally
    //   653	801	514	finally
    //   801	809	514	finally
    //   815	824	514	finally
    //   827	831	514	finally
    //   834	905	514	finally
    //   905	910	514	finally
    //   914	926	514	finally
    //   929	934	514	finally
    //   934	938	514	finally
    //   31	47	950	finally
    //   321	348	950	finally
    //   31	47	958	java/lang/Exception
    //   934	938	967	java/lang/Exception
  }
  
  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str3);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (i != 0)
      {
        localStringBuilder.append(str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str1 != null) {
          localStringBuilder.append("&" + str3 + "=" + URLEncoder.encode(str1, "utf-8"));
        } else {
          localStringBuilder.append("&" + str3 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(HttpResponse paramHttpResponse)
  {
    return new String(a(paramHttpResponse).toByteArray());
  }
  
  public static final HashMap a(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    for (;;)
    {
      return paramContext;
      HashMap localHashMap = new HashMap(paramHashMap);
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localJSONArray.put(str2);
          localArrayList.add(str1);
        }
      }
      paramContext = a(paramContext, paramString1, paramString2, paramInt, localJSONArray);
      if (paramContext != null) {}
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext.getInt("retcode") == 0)
        {
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return localHashMap;
          }
          paramString2 = paramContext.getJSONArray("list");
          if (paramString2 == null) {
            return localHashMap;
          }
          if (paramString2.length() == localArrayList.size())
          {
            paramString1 = new HashMap();
            paramInt = 0;
            for (;;)
            {
              paramContext = paramString1;
              if (paramInt >= paramString2.length()) {
                break;
              }
              paramString1.put(localArrayList.get(paramInt), paramString2.getString(paramInt));
              paramInt += 1;
            }
          }
          QLog.e("sdk_share", 4, "!!!!urlArray.length() != srcKeyArray.size()");
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          QLog.d("sdk_share", 4, paramContext.getMessage());
        }
      }
    }
    return localHashMap;
  }
  
  public static final HashMap a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      String str2 = (String)paramHashMap.get(str1);
      if (!TextUtils.isEmpty(str2))
      {
        ((JSONArray)localObject1).put(str2);
        localArrayList.add(str1);
      }
    }
    paramHashMap = new Bundle();
    paramHashMap.putString("Referer", "http://openmobile.qq.com/");
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("value", ((JSONArray)localObject1).toString());
    localObject1 = null;
    try
    {
      paramHashMap = a(BaseApplication.getContext(), "http://openmobile.qq.com/api/shortUrl", "POST", (Bundle)localObject2, paramHashMap);
      if (TextUtils.isEmpty(paramHashMap)) {
        return localHashMap;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        paramHashMap = (HashMap)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localIOException.getMessage());
          paramHashMap = (HashMap)localObject1;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramHashMap = (HashMap)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError.getMessage());
          paramHashMap = (HashMap)localObject1;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramHashMap = new JSONObject(paramHashMap);
        i = paramHashMap.getInt("retcode");
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label430;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error retcode:" + i);
          break label430;
        }
        paramHashMap = paramHashMap.getJSONObject("result");
        if (paramHashMap == null)
        {
          if (!QLog.isColorLevel()) {
            break label432;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result");
          break label432;
        }
        paramHashMap = paramHashMap.getJSONArray("list");
        if (paramHashMap == null)
        {
          if (!QLog.isColorLevel()) {
            break label434;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result");
          break label434;
        }
        if (paramHashMap.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramHashMap.length())
          {
            localObject1 = paramHashMap.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label436;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label436;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shortenUrl parse response error");
        continue;
      }
      return localHashMap;
      label430:
      return localHashMap;
      label432:
      return localHashMap;
      label434:
      return localHashMap;
      label436:
      i += 1;
    }
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      QRUtils.a(paramContext, QRUtils.w);
    }
    if (paramContext == null) {}
    HttpClient localHttpClient;
    do
    {
      return null;
      localHttpClient = a(paramContext);
    } while (localHttpClient == null);
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replaceAll(" ", "");
    if ("GET".equals(paramString3))
    {
      paramString3 = a(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label234;
          }
          paramContext = "&";
        }
      }
    }
    for (;;)
    {
      paramContext = paramContext + paramString3;
      try
      {
        paramContext = new HttpGet(paramContext);
        paramContext.addHeader("Accept-Encoding", "gzip");
        if (paramBundle2 != null)
        {
          paramString1 = paramBundle2.keySet().iterator();
          for (;;)
          {
            if (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label234:
                paramContext = "?";
                break;
              }
            }
          }
        }
        for (;;)
        {
          paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
          try
          {
            paramContext = localHttpClient.execute(paramContext);
            return paramContext;
            paramContext = new HttpPost(paramString1);
            paramContext.addHeader("Accept-Encoding", "gzip");
            paramString1 = a(paramBundle1);
            paramContext.setHeader("Content-Type", "application/x-www-form-urlencoded");
            paramString1 = paramString1.getBytes();
            if (paramBundle2 != null)
            {
              paramString3 = paramBundle2.keySet().iterator();
              while (paramString3.hasNext())
              {
                paramBundle1 = (String)paramString3.next();
                Object localObject = paramBundle2.get(paramBundle1);
                if ((localObject instanceof String)) {
                  paramContext.addHeader(paramBundle1, (String)localObject);
                }
              }
            }
            paramContext.setEntity(new ByteArrayEntity(paramString1));
          }
          catch (IOException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QRHttpUtil", 2, "openRequest fail IOException");
              }
              paramContext = null;
            }
          }
          catch (OutOfMemoryError paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
              }
              paramContext = null;
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QRHttpUtil", 2, "openRequest fail Exception");
              }
              paramContext = null;
            }
          }
        }
        return null;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static HttpClient a(Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject1).load(null, null);
        localObject1 = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject1);
        ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        Object localObject2 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 15000);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 30000);
        HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject2, "UTF-8");
        HttpProtocolParams.setUserAgent((HttpParams)localObject2, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject1, 443));
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject2, localSchemeRegistry), (HttpParams)localObject2);
        localObject2 = a(paramContext);
        paramContext = (Context)localObject1;
        if (localObject2 == null) {
          break;
        }
        paramContext = new HttpHost(((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_JavaLangString, ((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_Int);
        ((HttpClient)localObject1).getParams().setParameter("http.route.default-proxy", paramContext);
        return localObject1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.w))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label198;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label198:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  public static HttpClient b(Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject1).load(null, null);
        localObject1 = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject1);
        ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SSLSocketFactory)localObject1).setHostnameVerifier(new bnv());
        Object localObject2 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 15000);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 30000);
        HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject2, "UTF-8");
        HttpProtocolParams.setUserAgent((HttpParams)localObject2, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject1, 443));
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject2, localSchemeRegistry), (HttpParams)localObject2);
        localObject2 = a(paramContext);
        paramContext = (Context)localObject1;
        if (localObject2 == null) {
          break;
        }
        paramContext = new HttpHost(((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_JavaLangString, ((HttpUtil.NetworkProxy)localObject2).jdField_a_of_type_Int);
        ((HttpClient)localObject1).getParams().setParameter("http.route.default-proxy", paramContext);
        return localObject1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
    }
    localObject = Pattern.compile("</?\\w+>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll(" ");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */