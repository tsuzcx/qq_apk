package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class QAPMInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMInstrumentation";
  
  @QAPMWrapReturn(className="java/net/URL", methodDesc="()Ljava/net/URLConnection;", methodName="openConnection")
  public static URLConnection openConnection(URLConnection paramURLConnection)
  {
    if (paramURLConnection == null) {}
    for (;;)
    {
      return paramURLConnection;
      try
      {
        if (TraceUtil.getCanMonitorHttp())
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentation", "URLConnection openConnection gather  begin !!" });
          if ((paramURLConnection instanceof HttpsURLConnection)) {
            return new QAPMHttpsURLConnectionExtension((HttpsURLConnection)paramURLConnection);
          }
          if ((paramURLConnection instanceof HttpURLConnection))
          {
            QAPMHttpURLConnectionExtension localQAPMHttpURLConnectionExtension = new QAPMHttpURLConnectionExtension((HttpURLConnection)paramURLConnection);
            return localQAPMHttpURLConnectionExtension;
          }
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentation", "QAPMInstrumentation openConnection() has an error : ", localException.toString() });
      }
    }
    return paramURLConnection;
  }
  
  @QAPMWrapReturn(className="java.net.URL", methodDesc="(Ljava/net/Proxy;)Ljava/net/URLConnection;", methodName="openConnection")
  public static URLConnection openConnectionWithProxy(URLConnection paramURLConnection)
  {
    if (paramURLConnection == null) {}
    for (;;)
    {
      return paramURLConnection;
      try
      {
        if (TraceUtil.getCanMonitorHttp())
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentation", "URLConnection openConnectionWithProxy gather  begin !!" });
          if ((paramURLConnection instanceof HttpsURLConnection)) {
            return new QAPMHttpsURLConnectionExtension((HttpsURLConnection)paramURLConnection);
          }
          if ((paramURLConnection instanceof HttpURLConnection))
          {
            QAPMHttpURLConnectionExtension localQAPMHttpURLConnectionExtension = new QAPMHttpURLConnectionExtension((HttpURLConnection)paramURLConnection);
            return localQAPMHttpURLConnectionExtension;
          }
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentation", "QAPMInstrumentation openConnectionWithProxy() has an error : ", localException.toString() });
      }
    }
    return paramURLConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMInstrumentation
 * JD-Core Version:    0.7.0.1
 */