package com.tencent.analysis.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class a
{
  private static DefaultHttpClient a;
  
  public static String a(HttpResponse paramHttpResponse)
  {
    try
    {
      paramHttpResponse = EntityUtils.toString(paramHttpResponse.getEntity(), "utf-8");
      return paramHttpResponse;
    }
    catch (IOException paramHttpResponse)
    {
      paramHttpResponse = paramHttpResponse.toString();
      if (com.tencent.analysis.b.c) {
        Log.i("HttpHelper", paramHttpResponse);
      }
    }
    catch (ParseException paramHttpResponse)
    {
      for (;;)
      {
        paramHttpResponse = paramHttpResponse.toString();
        if (!com.tencent.analysis.b.c) {
          break;
        }
      }
    }
    return "";
  }
  
  public static HttpResponse a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("data", paramString2));
    paramString2 = a();
    paramString1 = new HttpPost(paramString1);
    paramString1.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
    paramString1.setHeader("prismClient", "prismClient");
    return paramString2.execute(paramString1);
  }
  
  private static HttpClient a()
  {
    if (a == null)
    {
      Object localObject1;
      int i;
      Object localObject3;
      int j;
      label185:
      try
      {
        if (a == null)
        {
          localObject1 = new BasicHttpParams();
          i = 0;
          HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject1, false);
          HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, 5000);
          HttpConnectionParams.setSoTimeout((HttpParams)localObject1, 15000);
          HttpConnectionParams.setSocketBufferSize((HttpParams)localObject1, 8192);
          localObject3 = new SchemeRegistry();
          HttpProtocolParams.setUserAgent((HttpParams)localObject1, "prismClient");
          ((SchemeRegistry)localObject3).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
          a = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject1, (SchemeRegistry)localObject3), (HttpParams)localObject1);
          localObject1 = com.tencent.analysis.a.a;
          if (localObject1 == null) {}
        }
      }
      finally {}
    }
    try
    {
      localObject1 = Proxy.getDefaultHost();
      j = Proxy.getDefaultPort();
      localObject3 = ((ConnectivityManager)com.tencent.analysis.a.a.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject3 != null) {
        i = ((NetworkInfo)localObject3).getType();
      }
      if ((i == 0) && (localObject1 != null) && (j != -1))
      {
        localObject1 = new HttpHost((String)localObject1, j);
        a.getParams().setParameter("http.route.default-proxy", localObject1);
      }
    }
    catch (Exception localException)
    {
      break label185;
    }
    a.setHttpRequestRetryHandler(new b());
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.b.a
 * JD-Core Version:    0.7.0.1
 */