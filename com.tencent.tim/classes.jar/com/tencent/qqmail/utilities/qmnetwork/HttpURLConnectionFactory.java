package com.tencent.qqmail.utilities.qmnetwork;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.qmnetwork.ssl.SSLStrategyFactory;
import com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;

public class HttpURLConnectionFactory
{
  private static final String TAG = "OkHttpConnectionFactory";
  private static OkHttpClient commonOkHttpClient;
  private static SafeSSLStrategy safeSSLStrategy = new SafeSSLStrategy();
  public static boolean useOkHttp = false;
  
  public static HttpURLConnection open(@NonNull URL paramURL, QMProxy paramQMProxy)
    throws IOException
  {
    Log.i("OkHttpConnectionFactory", "Use okhttp " + useOkHttp);
    return openDefaultHttpURLConnection(paramURL, paramQMProxy);
  }
  
  private static HttpURLConnection openDefaultHttpURLConnection(@NonNull URL paramURL, QMProxy paramQMProxy)
    throws IOException
  {
    if (paramQMProxy != null)
    {
      paramURL = (HttpURLConnection)paramURL.openConnection(new Proxy(paramQMProxy.transferHttpProxyType(), new InetSocketAddress(paramQMProxy.getProxyHost(), paramQMProxy.getProxyPort())));
      if (paramQMProxy.isAuthentication())
      {
        paramQMProxy = paramQMProxy.getProxyUserName() + ":" + paramQMProxy.getProxyPassword();
        paramQMProxy = StringExtention.base64Encode(paramQMProxy.getBytes(), paramQMProxy.length());
        paramURL.setRequestProperty("Proxy-Authorization", "Basic " + paramQMProxy);
      }
    }
    for (;;)
    {
      if ((VersionUtils.hasLolipop()) && ((paramURL instanceof HttpsURLConnection)))
      {
        paramQMProxy = SSLStrategyFactory.getSSLStrategy();
        ((HttpsURLConnection)paramURL).setSSLSocketFactory(paramQMProxy);
        ((HttpsURLConnection)paramURL).setHostnameVerifier(paramQMProxy);
      }
      return paramURL;
      paramURL = (HttpURLConnection)paramURL.openConnection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.HttpURLConnectionFactory
 * JD-Core Version:    0.7.0.1
 */