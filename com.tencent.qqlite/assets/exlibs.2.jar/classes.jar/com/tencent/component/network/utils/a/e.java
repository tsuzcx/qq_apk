package com.tencent.component.network.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.c;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.NetworkProxy;
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
import org.apache.http.client.methods.HttpUriRequest;
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

public final class e
{
  private static final a a = new a();
  
  public static String a(String paramString)
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
    if (j > "&rf=".length() + i) {
      return paramString.substring("&rf=".length() + i, j);
    }
    return paramString.substring("&rf=".length() + i);
  }
  
  public static HttpResponse a(Context paramContext, String paramString, HttpEntity paramHttpEntity)
    throws ClientProtocolException, IOException
  {
    HttpClient localHttpClient = a(null);
    Object localObject = b(paramString);
    if (localObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      paramString = new URL((String)localObject).getAuthority();
      localObject = new HttpPost((String)localObject);
      ((HttpPost)localObject).addHeader("Host", paramString);
      ((HttpPost)localObject).addHeader("x-online-host", paramString);
      paramString = com.tencent.component.network.module.base.a.e();
      if (!TextUtils.isEmpty(paramString)) {
        ((HttpPost)localObject).addHeader("Q-UA", paramString);
      }
      if ((paramHttpEntity instanceof ByteArrayEntity)) {
        ((HttpPost)localObject).addHeader("Content-Type", "application/octet-stream");
      }
      ((HttpPost)localObject).setEntity(paramHttpEntity);
      a(paramContext, (HttpRequest)localObject, null);
      return localHttpClient.execute((HttpUriRequest)localObject);
    }
  }
  
  public static HttpClient a(a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = a;
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 45000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, com.tencent.component.network.module.base.a.d());
    parama = new SchemeRegistry();
    try
    {
      parama.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      parama.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      if (((a)localObject).a)
      {
        g localg = new g(parama, ((a)localObject).b, ((a)localObject).c);
        if (((a)localObject).e > 0) {
          localg.b(((a)localObject).e);
        }
        parama = localg;
        if (((a)localObject).d > 0)
        {
          localg.a(((a)localObject).d);
          parama = localg;
        }
        localObject = new com.tencent.component.network.utils.a.a.a(parama, localBasicHttpParams);
        ((DefaultHttpClient)localObject).setRoutePlanner(new DefaultHttpRoutePlanner(parama.getSchemeRegistry()));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Const.d("downloader", "", localThrowable);
        continue;
        parama = new ThreadSafeClientConnManager(localBasicHttpParams, parama);
      }
    }
  }
  
  public static HttpGet a(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb)
    throws MalformedURLException
  {
    paramString1 = a(paramString1);
    paramString3 = new HttpGet(b(paramString3));
    paramString3.addHeader("x-online-host", paramString2);
    paramString3.addHeader("Host", paramString2);
    paramString2 = com.tencent.component.network.module.base.a.e();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.addHeader("Q-UA", paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      paramString3.addHeader("Referer", paramString1);
    }
    a(paramContext, paramString3, paramb);
    return paramString3;
  }
  
  public static HttpContext a()
  {
    return new BasicHttpContext();
  }
  
  private static void a(Context paramContext, HttpRequest paramHttpRequest, b paramb)
  {
    boolean bool1;
    if (paramb != null)
    {
      bool1 = paramb.a;
      if (paramb == null) {
        break label123;
      }
    }
    label123:
    for (boolean bool2 = paramb.b;; bool2 = false)
    {
      if ((bool1) && (NetworkUtils.isMobileConnected(paramContext)))
      {
        paramContext = NetworkUtils.getProxy(paramContext, bool2);
        if (paramContext != null)
        {
          paramb = new HttpHost(paramContext.host, paramContext.port);
          paramHttpRequest.getParams().setParameter("http.route.default-proxy", paramb);
          Const.b("downloader", "use proxy[host:" + paramContext.host + ",port:" + paramContext.port + "]");
        }
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public static void a(HttpRequest paramHttpRequest, boolean paramBoolean)
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
  
  public static boolean a(HttpRequest paramHttpRequest)
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
  
  private static String b(String paramString)
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
  
  public static HttpGet b(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb)
    throws MalformedURLException
  {
    paramString2 = new HttpGet(b(paramString2));
    paramString2.addHeader("x-online-host", paramString1);
    paramString2.addHeader("Host", paramString1);
    paramString1 = com.tencent.component.network.module.base.a.e();
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2.addHeader("Q-UA", paramString1);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.addHeader("Referer", paramString3);
    }
    a(paramContext, paramString2, paramb);
    return paramString2;
  }
  
  public static final class a
  {
    public boolean a = false;
    public long b = -1L;
    public TimeUnit c = TimeUnit.SECONDS;
    public int d = -1;
    public int e = -1;
    
    public a() {}
    
    public a(byte paramByte)
    {
      this.a = true;
      if (this.a)
      {
        this.d = c.a;
        this.e = c.a;
        this.b = 120L;
        this.c = c.b;
      }
    }
  }
  
  public static final class b
  {
    public boolean a = true;
    public boolean b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.e
 * JD-Core Version:    0.7.0.1
 */