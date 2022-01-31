package com.qzone.utils.http;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.AssertUtil;
import com.qzone.utils.NetworkUtil;
import com.qzone.utils.NetworkUtil.NetworkProxy;
import com.qzone.utils.http.base.QZoneHttpClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpUtil
{
  private static final int CONNECTION_TIMEOUT = 20000;
  private static final ClientOptions DEFAULT_CLIENT_OPTIONS = new ClientOptions();
  private static final int SO_TIMEOUT = 45000;
  
  public static boolean containsProxy(HttpRequest paramHttpRequest)
  {
    if (paramHttpRequest != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      paramHttpRequest = paramHttpRequest.getParams().getParameter("http.route.default-proxy");
      if ((paramHttpRequest == null) || (!(paramHttpRequest instanceof HttpHost))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static HttpClient createHttpClient()
  {
    return createHttpClient(null);
  }
  
  public static HttpClient createHttpClient(ClientOptions paramClientOptions)
  {
    Object localObject = paramClientOptions;
    if (paramClientOptions == null) {
      localObject = DEFAULT_CLIENT_OPTIONS;
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 45000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    if (DownloaderFactory.getDownloadConfig() != null) {
      HttpProtocolParams.setUserAgent(localBasicHttpParams, DownloaderFactory.getDownloadConfig().getUserAgent());
    }
    for (;;)
    {
      paramClientOptions = new SchemeRegistry();
      try
      {
        paramClientOptions.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        paramClientOptions.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        if (((ClientOptions)localObject).multiConnection)
        {
          paramClientOptions = new PoolingClientConnectionManager(paramClientOptions, ((ClientOptions)localObject).timeToLive, ((ClientOptions)localObject).timeToLiveUnit);
          if (((ClientOptions)localObject).maxConnectionPerRoute > 0) {
            paramClientOptions.setDefaultMaxPerRoute(((ClientOptions)localObject).maxConnectionPerRoute);
          }
          if (((ClientOptions)localObject).maxConnection > 0) {
            paramClientOptions.setMaxTotal(((ClientOptions)localObject).maxConnection);
          }
          localObject = new QZoneHttpClient(paramClientOptions, localBasicHttpParams);
          ((DefaultHttpClient)localObject).setRoutePlanner(new DefaultHttpRoutePlanner(paramClientOptions.getSchemeRegistry()));
          return localObject;
          HttpProtocolParams.setUserAgent(localBasicHttpParams, "android-qzone");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QDLog.e("downloader", "", localThrowable);
          continue;
          paramClientOptions = new ThreadSafeClientConnManager(localBasicHttpParams, paramClientOptions);
        }
      }
    }
  }
  
  public static HttpContext createHttpContext()
  {
    return new BasicHttpContext();
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString)
    throws MalformedURLException
  {
    return createHttpGet(paramContext, paramString, null);
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString, RequestOptions paramRequestOptions)
    throws MalformedURLException
  {
    String str = prepareRefer(paramString);
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new HttpGet((String)localObject);
    ((HttpGet)localObject).addHeader("x-online-host", paramString);
    ((HttpGet)localObject).addHeader("Host", paramString);
    if (DownloaderFactory.getDownloadConfig() != null) {
      ((HttpGet)localObject).addHeader("Q-UA", DownloaderFactory.getDownloadConfig().getQUA());
    }
    if (!TextUtils.isEmpty(str)) {
      ((HttpGet)localObject).addHeader("Referer", str);
    }
    prepareRequest(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws MalformedURLException
  {
    String str = prepareRefer(paramString1);
    paramString1 = prepareUrl(paramString1);
    paramString2 = prepareUrl(paramString2);
    paramString1 = prepareHost(paramString1);
    paramString2 = new HttpGet(paramString2);
    paramString2.addHeader("x-online-host", paramString1);
    paramString2.addHeader("Host", paramString1);
    if (DownloaderFactory.getDownloadConfig() != null) {
      paramString2.addHeader("Q-UA", DownloaderFactory.getDownloadConfig().getQUA());
    }
    if (!TextUtils.isEmpty(str)) {
      paramString2.addHeader("Referer", str);
    }
    prepareRequest(paramContext, paramString2, paramRequestOptions);
    return paramString2;
  }
  
  public static HttpGet createHttpGet(Context paramContext, String paramString1, String paramString2, String paramString3, RequestOptions paramRequestOptions)
    throws MalformedURLException
  {
    paramString1 = prepareUrl(paramString1);
    paramString2 = prepareUrl(paramString2);
    paramString1 = prepareHost(paramString1);
    paramString2 = new HttpGet(paramString2);
    paramString2.addHeader("x-online-host", paramString1);
    paramString2.addHeader("Host", paramString1);
    if (DownloaderFactory.getDownloadConfig() != null) {
      paramString2.addHeader("Q-UA", DownloaderFactory.getDownloadConfig().getQUA());
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.addHeader("Referer", paramString3);
    }
    prepareRequest(paramContext, paramString2, paramRequestOptions);
    return paramString2;
  }
  
  public static HttpPost createHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
    throws MalformedURLException
  {
    return createHttpPost(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpPost createHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, RequestOptions paramRequestOptions)
    throws MalformedURLException
  {
    Object localObject = prepareUrl(paramString);
    paramString = prepareHost((String)localObject);
    localObject = new HttpPost((String)localObject);
    ((HttpPost)localObject).addHeader("Host", paramString);
    ((HttpPost)localObject).addHeader("x-online-host", paramString);
    if (DownloaderFactory.getDownloadConfig() != null) {
      ((HttpPost)localObject).addHeader("Q-UA", DownloaderFactory.getDownloadConfig().getQUA());
    }
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
    }
    ((HttpPost)localObject).setEntity(paramHttpEntity);
    prepareRequest(paramContext, (HttpRequest)localObject, paramRequestOptions);
    return localObject;
  }
  
  public static HttpResponse executeHttpGet(Context paramContext, String paramString, RequestOptions paramRequestOptions)
    throws ClientProtocolException, IOException
  {
    return createHttpClient().execute(createHttpGet(paramContext, paramString, paramRequestOptions));
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
    throws ClientProtocolException, IOException
  {
    return executeHttpPost(paramContext, paramString, paramHttpEntity, null);
  }
  
  public static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity, RequestOptions paramRequestOptions)
    throws ClientProtocolException, IOException
  {
    return createHttpClient().execute(createHttpPost(paramContext, paramString, paramHttpEntity, paramRequestOptions));
  }
  
  private static String prepareHost(String paramString)
    throws MalformedURLException
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      return new URL(paramString).getAuthority();
    }
  }
  
  public static String prepareRefer(String paramString)
  {
    if (paramString != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      i = paramString.indexOf("&rf=");
      if (i >= 0) {
        break;
      }
      return "";
    }
    int j = paramString.indexOf("&", "&rf=".length() + i);
    if (j > "&rf=".length() + i) {}
    for (paramString = paramString.substring("&rf=".length() + i, j);; paramString = paramString.substring("&rf=".length() + i)) {
      return paramString;
    }
  }
  
  private static void prepareRequest(Context paramContext, HttpRequest paramHttpRequest, RequestOptions paramRequestOptions)
  {
    boolean bool1;
    if (paramRequestOptions != null)
    {
      bool1 = paramRequestOptions.allowProxy;
      if (paramRequestOptions == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool2 = paramRequestOptions.apnProxy;; bool2 = false)
    {
      if ((bool1) && (NetworkUtil.isViaMobile(paramContext)))
      {
        paramContext = NetworkUtil.getProxy(paramContext, bool2);
        if (paramContext != null)
        {
          paramRequestOptions = new HttpHost(paramContext.host, paramContext.port);
          paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramRequestOptions);
          QDLog.d("downloader", "use proxy[host:" + paramContext.host + ",port:" + paramContext.port + "]");
        }
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  private static String prepareUrl(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      String str = paramString.trim().replace(" ", "");
      int i = str.indexOf('#');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      return paramString;
    }
  }
  
  public static void setKeepAliveEnabled(HttpRequest paramHttpRequest, boolean paramBoolean)
  {
    if (paramHttpRequest != null) {
      if (!paramBoolean) {
        break label23;
      }
    }
    label23:
    for (String str = "Keep-Alive";; str = "Close")
    {
      paramHttpRequest.setHeader("Connection", str);
      return;
    }
  }
  
  public static final class ClientOptions
  {
    public int maxConnection = -1;
    public int maxConnectionPerRoute = -1;
    public boolean multiConnection = false;
    public long timeToLive = -1L;
    public TimeUnit timeToLiveUnit = TimeUnit.SECONDS;
  }
  
  public static final class RequestOptions
  {
    static final boolean DEFAULT_ALLOW_PROXY = true;
    static final boolean DEFAULT_APN_PROXY = false;
    public boolean allowProxy = true;
    public boolean apnProxy = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.HttpUtil
 * JD-Core Version:    0.7.0.1
 */