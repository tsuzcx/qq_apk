package com.tencent.tmassistantbase.network;

import com.tencent.tmassistantbase.util.ab;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLSocketFactory;

class f
  implements Runnable
{
  f(PostHttpRequest paramPostHttpRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new URL(PostHttpRequest.REQUEST_SERVER_URL);
      ab.c("PostHttpRequest", ">sendRequest serverUrl=" + localObject1);
      localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
      Object localObject2 = d.a();
      if (localObject2 != null)
      {
        ((HttpsURLConnection)localObject1).setSSLSocketFactory(((SSLContext)localObject2).getSocketFactory());
        ((HttpsURLConnection)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      }
      ((HttpsURLConnection)localObject1).setRequestMethod("POST");
      ((HttpsURLConnection)localObject1).setDoOutput(true);
      ((HttpsURLConnection)localObject1).setDoInput(true);
      ((HttpsURLConnection)localObject1).setUseCaches(false);
      ((HttpsURLConnection)localObject1).addRequestProperty("User-Agent", "AssistantDownloader");
      ((HttpsURLConnection)localObject1).addRequestProperty("Content-Type", "application/octet-stream");
      ((HttpsURLConnection)localObject1).setConnectTimeout(30000);
      ((HttpsURLConnection)localObject1).setReadTimeout(30000);
      ab.c("PostHttpRequest", ">sendRequest begin getOutputStream");
      localObject2 = ((HttpsURLConnection)localObject1).getOutputStream();
      ((OutputStream)localObject2).write(this.a);
      ((OutputStream)localObject2).flush();
      ab.c("PostHttpRequest", ">sendRequest outputStream flush.");
      i = ((HttpsURLConnection)localObject1).getResponseCode();
      ab.c("PostHttpRequest", ">sendRequest rspCode:" + i);
      if (i == 200)
      {
        localObject1 = ((HttpsURLConnection)localObject1).getInputStream();
        if (localObject1 != null)
        {
          localObject1 = c.a((InputStream)localObject1);
          if ((localObject1 != null) && (localObject1.length > 4))
          {
            ab.c("PostHttpRequest", ">sendRequest data length:" + localObject1.length);
            this.b.onFinished(this.a, (byte[])localObject1, 0);
            return;
          }
          ab.e("PostHttpRequest", ">sendRequest data:" + localObject1);
          return;
        }
      }
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      ab.c("PostHttpRequest", "connect failed ConnectTimeoutException:", localConnectTimeoutException);
      this.b.onFinished(this.a, null, 601);
      return;
      this.b.onFinished(this.a, null, 604);
      ab.e("PostHttpRequest", ">sendRequest entity == null");
      return;
    }
    catch (ConnectException localConnectException)
    {
      int i;
      ab.c("PostHttpRequest", "connect failed ConnectException:", localConnectException);
      this.b.onFinished(this.a, null, 1);
      return;
      ab.e("PostHttpRequest", ">sendRequest StatusCode not ok:" + i);
      this.b.onFinished(this.a, null, i);
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      ab.c("PostHttpRequest", "connect failed SocketTimeoutException:", localSocketTimeoutException);
      this.b.onFinished(this.a, null, 602);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.c("PostHttpRequest", "connect failed Throwable:", localThrowable);
      this.b.onFinished(this.a, null, 604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.f
 * JD-Core Version:    0.7.0.1
 */