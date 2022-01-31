package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import fdh;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale"})
public class HttpBaseUtil
{
  protected static final int a = 15000;
  public static final String a;
  protected static boolean a = false;
  protected static final int b = 30000;
  protected static final String b = "\r\n";
  protected static final int c = 1;
  protected static final String c = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  
  static
  {
    jdField_a_of_type_JavaLangString = HttpBaseUtil.class.getName();
    jdField_a_of_type_Boolean = true;
  }
  
  protected static int a()
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (CommonDataAdapter.a().a() != null)
      {
        int j = Proxy.getPort(CommonDataAdapter.a().a());
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    String str;
    do
    {
      return i;
      return Proxy.getDefaultPort();
      str = System.getProperty("http.proxyPort");
    } while (a(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1;
  }
  
  protected static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  protected static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, null);
  }
  
  public static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle, HttpContext paramHttpContext)
  {
    Object localObject;
    if (CommonDataAdapter.a().a() != null)
    {
      localObject = (ConnectivityManager)CommonDataAdapter.a().a().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
          throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
        }
      }
    }
    for (;;)
    {
      HttpClient localHttpClient;
      int j;
      try
      {
        str1 = paramBundle.getString("needhttpcache");
        paramBundle.remove("needhttpcache");
        localObject = paramBundle.getString("appid_for_getting_config");
        paramBundle.remove("appid_for_getting_config");
        localHttpClient = a((String)localObject, paramString1);
        localObject = null;
        i = paramString1.length();
        if (paramString2.equals("GET"))
        {
          paramBundle = a(paramBundle);
          j = paramBundle.length();
          if (paramString1.indexOf("?") == -1)
          {
            paramString2 = paramString1 + "?";
            paramString2 = paramString2 + paramBundle;
            paramBundle = paramString1 + paramBundle;
            paramString1 = new HttpGet(paramString2);
            paramString1.addHeader("Accept-Encoding", "gzip");
            paramString1.addHeader("Content-Type", "application/x-www-form-urlencoded");
            if (str1 == null) {
              break label766;
            }
            paramString1.addHeader("If-None-Match", HttpCacheService.a().a(paramBundle));
            paramString1.addHeader("If-Modified-Since", "\"" + HttpCacheService.a().a(paramBundle) + "\"");
            LogUtility.c(jdField_a_of_type_JavaLangString, "add header. If-None-Match:" + HttpCacheService.a().a(paramBundle) + "; If-Modified-Since:" + HttpCacheService.a().a(paramBundle));
            break label766;
            if (paramHttpContext != null) {
              break label742;
            }
            paramString1 = localHttpClient.execute(paramString1);
            return new HttpBaseUtil.HttpResponseBean(paramString1, i);
          }
          if ((paramString1.endsWith("&")) || (TextUtils.isEmpty(paramBundle))) {
            break label761;
          }
          paramString2 = paramString1 + "&";
          continue;
        }
        if (!paramString2.equals("POST")) {
          break label755;
        }
        localObject = new HttpPost(paramString1);
        ((HttpPost)localObject).addHeader("Accept-Encoding", "gzip");
        ((HttpPost)localObject).addHeader("Content-Type", "application/x-www-form-urlencoded");
        boolean bool = paramBundle.getBoolean("doAuthorize", false);
        paramBundle.remove("doAuthorize");
        if (!bool) {
          continue;
        }
        localArrayList = new ArrayList();
        localIterator = paramBundle.keySet().iterator();
      }
      catch (MalformedURLException paramString1)
      {
        Iterator localIterator;
        String str2;
        throw new MalformedURLException(paramString1.getMessage());
        if (!(paramBundle.get(str2) instanceof String[])) {
          continue;
        }
        String[] arrayOfString = (String[])paramBundle.get(str2);
        int k = arrayOfString.length;
        paramString1 = null;
        j = 0;
        if (j >= k) {
          continue;
        }
        String str1 = arrayOfString[j];
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        paramString1 = str1;
        break label776;
        paramString1 = paramString1 + "," + str1;
        break label776;
        localArrayList.add(new BasicNameValuePair(str2, paramString1));
        continue;
      }
      catch (IOException paramString1)
      {
        ArrayList localArrayList;
        throw paramString1;
        if (paramBundle.containsKey("method")) {
          continue;
        }
        localArrayList.add(new BasicNameValuePair("method", paramString2));
        ((HttpPost)localObject).setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        break label785;
        ((HttpPost)localObject).setEntity(new ByteArrayEntity(a(paramBundle).getBytes()));
      }
      catch (Exception paramString1)
      {
        throw new Exception(paramString1);
      }
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if ((paramBundle.get(str2) instanceof String))
        {
          localArrayList.add(new BasicNameValuePair(str2, (String)paramBundle.get(str2)));
          continue;
        }
      }
      label742:
      paramString1 = localHttpClient.execute(paramString1, paramHttpContext);
      continue;
      label755:
      paramString1 = (String)localObject;
      continue;
      label761:
      paramString2 = paramString1;
      continue;
      label766:
      int i = j + i;
      continue;
      label776:
      j += 1;
      continue;
      label785:
      paramString1 = (String)localObject;
    }
  }
  
  protected static HttpBaseUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return null;
    }
    if (paramContext.getType() == 0)
    {
      paramContext = a();
      int i = a();
      if ((!a(paramContext)) && (i >= 0)) {
        return new HttpBaseUtil.NetworkProxy(paramContext, i);
      }
    }
    return null;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static HttpBaseUtil.Statistic a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
        }
      }
    }
    Object localObject1 = new Bundle(paramBundle);
    String str1 = ((Bundle)localObject1).getString("mineType");
    ((Bundle)localObject1).remove("mineType");
    String str2 = ((Bundle)localObject1).getString("filename");
    ((Bundle)localObject1).remove("filename");
    paramBundle = a();
    int i;
    if (paramString2.toUpperCase().equals("GET"))
    {
      paramString2 = MsfSdkUtils.insertMtype("yingyongbao", a((Bundle)localObject1));
      LogUtility.e(jdField_a_of_type_JavaLangString, "openPicUploadUrl:" + paramString2);
      i = paramString2.length();
      if (paramString1.indexOf("?") == -1)
      {
        paramContext = paramString1 + "?";
        paramContext = new HttpGet(paramContext + paramString2);
        paramContext.addHeader("Accept-Encoding", "gzip");
        i = 0 + i;
      }
    }
    for (;;)
    {
      paramContext = paramBundle.execute(paramContext);
      int j = paramContext.getStatusLine().getStatusCode();
      if (j == 200)
      {
        return new HttpBaseUtil.Statistic(a(paramContext), i, 1);
        paramContext = paramString1 + "&";
        break;
        if (!paramString2.toUpperCase().equals("POST")) {
          break label731;
        }
        paramContext = new HttpPost(paramString1);
        paramContext.addHeader("Accept-Encoding", "gzip");
        paramString1 = new Bundle();
        Object localObject2 = ((Bundle)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str3 = (String)((Iterator)localObject2).next();
          Object localObject3 = ((Bundle)localObject1).get(str3);
          if ((localObject3 instanceof byte[])) {
            paramString1.putByteArray(str3, (byte[])localObject3);
          }
        }
        if (!((Bundle)localObject1).containsKey("method")) {
          ((Bundle)localObject1).putString("method", paramString2);
        }
        paramContext.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        paramContext.setHeader("Connection", "Keep-Alive");
        paramString2 = new ByteArrayOutputStream();
        paramString2.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
        paramString2.write(MsfSdkUtils.insertMtype("yingyongbao", a((Bundle)localObject1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")).getBytes());
        if (!paramString1.isEmpty())
        {
          int k = paramString1.size();
          localObject1 = paramString1.keySet().iterator();
          i = -1;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            j = i + 1;
            paramString2.write(("Content-Disposition: form-data; name=\"" + (String)localObject2 + "\"; filename=\"" + str2 + "\"" + "\r\n").getBytes());
            paramString2.write(("Content-Type: " + str1 + "\r\n" + "\r\n").getBytes());
            localObject2 = paramString1.getByteArray((String)localObject2);
            if (localObject2 != null) {
              paramString2.write((byte[])localObject2);
            }
            i = j;
            if (j < k - 1)
            {
              paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
              i = j;
            }
          }
        }
        paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n".getBytes());
        paramString1 = paramString2.toByteArray();
        i = paramString1.length + 0;
        paramString2.close();
        paramContext.setEntity(new ByteArrayEntity(paramString1));
        continue;
      }
      throw new HttpBaseUtil.HttpStatusException("http status code error:" + j);
      label731:
      paramContext = null;
      i = 0;
    }
  }
  
  public static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, 0);
  }
  
  protected static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    String str1 = paramBundle.getString("needhttpcache");
    String str2 = MsfSdkUtils.insertMtype("yingyongbao", paramString1);
    paramString1 = a(str2, paramString2, paramBundle);
    paramBundle.remove("needhttpcache");
    HttpResponse localHttpResponse = paramString1.jdField_a_of_type_OrgApacheHttpHttpResponse;
    int i = paramString1.jdField_a_of_type_Int;
    int j = localHttpResponse.getStatusLine().getStatusCode();
    paramString1 = null;
    long l = 0L;
    if (localHttpResponse.containsHeader("Etag")) {
      paramString1 = localHttpResponse.getFirstHeader("Etag").getValue();
    }
    Object localObject;
    if (localHttpResponse.containsHeader("Last-Modified")) {
      localObject = localHttpResponse.getFirstHeader("Last-Modified");
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(((Header)localObject).getValue());
        localObject = null;
        if ("GET".equals(paramString2))
        {
          localObject = a(str2, paramBundle);
          LogUtility.c(jdField_a_of_type_JavaLangString, "url2=" + (String)localObject);
        }
        if (j == 200)
        {
          paramBundle = a(localHttpResponse);
          if ((str1 == null) || (!"GET".equals(paramString2))) {
            break label438;
          }
          HttpCacheService.a().a((String)localObject, paramString1, l, paramBundle);
          paramInt = 1;
          paramString1 = paramBundle;
          return new HttpBaseUtil.Statistic(paramString1, i, paramInt);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, " Parse Last-Modified to Long Exception: " + localNumberFormatException.getMessage());
        l = 0L;
        continue;
        if ((j == 304) && (paramString1 != null))
        {
          paramString1 = HttpCacheService.a().b(localNumberFormatException);
          if ((paramString1 == null) || ("".equals(paramString1)))
          {
            LogUtility.e(jdField_a_of_type_JavaLangString, "Get response from cache error. remove cache and retry. retryCount=" + paramInt);
            if (localNumberFormatException != null) {
              HttpCacheService.a().a(localNumberFormatException);
            }
            paramBundle.putString("needhttpcache", "nothing");
            if (paramInt < 1) {
              a(str2, paramString2, paramBundle, paramInt);
            }
          }
          paramInt = 0;
          continue;
        }
        LogUtility.e(jdField_a_of_type_JavaLangString, "request" + str2 + "http server return error, statuscode:" + j);
        throw new HttpBaseUtil.HttpStatusException("http status code error:" + j);
      }
      label438:
      paramInt = 1;
      paramString1 = paramBundle;
    }
  }
  
  protected static String a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (CommonDataAdapter.a().a() != null)
      {
        String str2 = Proxy.getHost(CommonDataAdapter.a().a());
        String str1 = str2;
        if (a(str2)) {
          str1 = Proxy.getDefaultHost();
        }
        return str1;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
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
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label117:
            if (j >= localObject1.length) {
              break label178;
            }
            if (j != 0) {
              break label157;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label117;
            localStringBuilder.append("&");
            break;
            label157:
            localStringBuilder.append(",").append(URLEncoder.encode(localObject1[j]));
          }
        }
        else
        {
          label178:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=").append(URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  protected static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String))
      {
        localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n" + (String)localObject);
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return str;
  }
  
  protected static String a(String paramString, Bundle paramBundle)
  {
    String str = a(paramBundle);
    if (paramString.indexOf("?") == -1) {
      paramBundle = paramString + "?";
    }
    for (;;)
    {
      return paramBundle + str;
      paramBundle = paramString;
      if (!paramString.endsWith("&"))
      {
        paramBundle = paramString;
        if (!TextUtils.isEmpty(str)) {
          paramBundle = paramString + "&";
        }
      }
    }
  }
  
  /* Error */
  @SuppressLint({"DefaultLocale"})
  public static String a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 493
    //   9: astore 8
    //   11: aload_0
    //   12: invokeinterface 566 1 0
    //   17: astore 5
    //   19: aload_0
    //   20: ldc_w 568
    //   23: invokeinterface 462 2 0
    //   28: ifeq +47 -> 75
    //   31: aload_0
    //   32: ldc_w 568
    //   35: invokeinterface 466 2 0
    //   40: invokeinterface 471 1 0
    //   45: invokestatic 478	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   48: lstore_3
    //   49: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: new 171	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 570
    //   62: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_3
    //   66: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 222	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 5
    //   77: invokeinterface 576 1 0
    //   82: astore 5
    //   84: aload_0
    //   85: ldc_w 578
    //   88: invokeinterface 466 2 0
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull +72 -> 169
    //   100: aload 6
    //   102: invokeinterface 471 1 0
    //   107: invokevirtual 581	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   110: ldc 186
    //   112: invokevirtual 169	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   115: iconst_m1
    //   116: if_icmple +53 -> 169
    //   119: new 583	java/util/zip/GZIPInputStream
    //   122: dup
    //   123: aload 5
    //   125: invokespecial 584	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore 6
    //   130: aload 6
    //   132: invokestatic 586	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   135: astore 7
    //   137: aload 7
    //   139: astore_0
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 589	java/io/InputStream:close	()V
    //   150: aload_0
    //   151: astore 5
    //   153: aload 6
    //   155: ifnull +11 -> 166
    //   158: aload 6
    //   160: invokevirtual 589	java/io/InputStream:close	()V
    //   163: aload_0
    //   164: astore 5
    //   166: aload 5
    //   168: areturn
    //   169: aload 5
    //   171: invokestatic 586	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   174: astore 6
    //   176: aload 6
    //   178: astore_0
    //   179: aconst_null
    //   180: astore 6
    //   182: goto -42 -> 140
    //   185: astore 5
    //   187: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: ldc_w 591
    //   193: aload 5
    //   195: invokestatic 594	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_0
    //   199: areturn
    //   200: astore 7
    //   202: aconst_null
    //   203: astore 5
    //   205: aload 9
    //   207: astore 6
    //   209: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   212: new 171	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 596
    //   222: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 7
    //   227: invokevirtual 597	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload 7
    //   238: invokestatic 594	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: invokeinterface 601 1 0
    //   247: astore_0
    //   248: aload_0
    //   249: arraylength
    //   250: istore_2
    //   251: iconst_0
    //   252: istore_1
    //   253: iload_1
    //   254: iload_2
    //   255: if_icmpge +63 -> 318
    //   258: aload_0
    //   259: iload_1
    //   260: aaload
    //   261: astore 7
    //   263: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   266: new 171	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 603
    //   276: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 7
    //   281: invokeinterface 604 1 0
    //   286: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 606
    //   292: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 7
    //   297: invokeinterface 471 1 0
    //   302: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 367	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: iload_1
    //   312: iconst_1
    //   313: iadd
    //   314: istore_1
    //   315: goto -62 -> 253
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 589	java/io/InputStream:close	()V
    //   328: aload 8
    //   330: astore 5
    //   332: aload 6
    //   334: ifnull -168 -> 166
    //   337: aload 6
    //   339: invokevirtual 589	java/io/InputStream:close	()V
    //   342: ldc_w 493
    //   345: areturn
    //   346: astore_0
    //   347: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: ldc_w 591
    //   353: aload_0
    //   354: invokestatic 594	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: ldc_w 493
    //   360: areturn
    //   361: astore_0
    //   362: aconst_null
    //   363: astore 5
    //   365: aload 7
    //   367: astore 6
    //   369: aload 5
    //   371: ifnull +8 -> 379
    //   374: aload 5
    //   376: invokevirtual 589	java/io/InputStream:close	()V
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 589	java/io/InputStream:close	()V
    //   389: aload_0
    //   390: athrow
    //   391: astore 5
    //   393: getstatic 31	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: ldc_w 591
    //   399: aload 5
    //   401: invokestatic 594	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: goto -15 -> 389
    //   407: astore_0
    //   408: aload 7
    //   410: astore 6
    //   412: goto -43 -> 369
    //   415: astore_0
    //   416: goto -47 -> 369
    //   419: astore_0
    //   420: goto -51 -> 369
    //   423: astore 7
    //   425: aload 9
    //   427: astore 6
    //   429: goto -220 -> 209
    //   432: astore 7
    //   434: goto -225 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramHttpResponse	HttpResponse
    //   252	63	1	i	int
    //   250	6	2	j	int
    //   48	18	3	l	long
    //   17	153	5	localObject1	Object
    //   185	9	5	localException1	Exception
    //   203	172	5	str1	String
    //   391	9	5	localException2	Exception
    //   93	335	6	localObject2	Object
    //   1	137	7	str2	String
    //   200	37	7	localException3	Exception
    //   261	148	7	localObject3	Object
    //   423	1	7	localException4	Exception
    //   432	1	7	localException5	Exception
    //   9	320	8	str3	String
    //   4	422	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   145	150	185	java/lang/Exception
    //   158	163	185	java/lang/Exception
    //   19	75	200	java/lang/Exception
    //   75	84	200	java/lang/Exception
    //   323	328	346	java/lang/Exception
    //   337	342	346	java/lang/Exception
    //   19	75	361	finally
    //   75	84	361	finally
    //   374	379	391	java/lang/Exception
    //   384	389	391	java/lang/Exception
    //   84	95	407	finally
    //   100	130	407	finally
    //   169	176	407	finally
    //   130	137	415	finally
    //   209	251	419	finally
    //   263	311	419	finally
    //   84	95	423	java/lang/Exception
    //   100	130	423	java/lang/Exception
    //   169	176	423	java/lang/Exception
    //   130	137	432	java/lang/Exception
  }
  
  protected static HttpClient a()
  {
    try
    {
      Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject).load(null, null);
      localObject = new fdh((KeyStore)localObject);
      ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
      ConnManagerParams.setTimeout(localBasicHttpParams, 10000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
      localObject = new DefaultHttpClient(localBasicHttpParams);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new DefaultHttpClient();
  }
  
  public static HttpClient a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        int j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_HttpConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        int i = j;
        if (j == 0) {
          i = 15000;
        }
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
        j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_SocketConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        i = j;
        if (j == 0) {
          i = 30000;
        }
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, i);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        paramString1 = new SchemeRegistry();
        paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        paramString1.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString1), localBasicHttpParams);
        paramString2 = a(CommonDataAdapter.a().a());
        if (paramString2 != null)
        {
          paramString2 = new HttpHost(paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_a_of_type_Int);
          paramString1.getParams().setParameter("http.route.default-proxy", paramString2);
        }
        return paramString1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static JSONObject a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return new JSONObject(str);
  }
  
  protected static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (paramString != null)
    {
      paramJSONObject = paramString.split("&");
      int j = paramJSONObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramString = paramJSONObject[i].split("=");
          if (paramString.length == 2) {}
          try
          {
            localJSONObject.put(URLDecoder.decode(paramString[0]), URLDecoder.decode(paramString[1]));
            i += 1;
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
    }
    return localJSONObject;
  }
  
  protected static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.base.http.HttpBaseUtil
 * JD-Core Version:    0.7.0.1
 */