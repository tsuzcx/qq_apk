package com.tencent.mobileqq.transfile;

import android.view.animation.AnimationUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

public class HttpDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 4096;
  private static DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  
  static
  {
    a = a();
  }
  
  private static DefaultHttpClient a()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
      localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      return new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    HttpGet localHttpGet;
    try
    {
      localHttpGet = new HttpGet(paramDownloadParams.url.toURI());
      if (paramDownloadParams.cookies != null)
      {
        localObject = a.getCookieSpecs().getCookieSpec("best-match").formatCookies(paramDownloadParams.cookies.getCookies()).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHttpGet.addHeader((Header)((Iterator)localObject).next());
        }
      }
      if (paramDownloadParams.headers == null) {
        break label172;
      }
    }
    catch (URISyntaxException paramOutputStream)
    {
      throw new IllegalArgumentException("illegal uri: " + paramDownloadParams.url.toString());
    }
    int i;
    if (paramDownloadParams.headers.length > 0)
    {
      localObject = paramDownloadParams.headers;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        localHttpGet.addHeader(localObject[i]);
        i += 1;
      }
    }
    try
    {
      label172:
      localObject = a.execute(localHttpGet);
      i = ((HttpResponse)localObject).getStatusLine().getStatusCode();
      if (i != 200) {
        throw new IOException(paramDownloadParams.url + " response error! response code: " + i + " . reason: " + ((HttpResponse)localObject).getStatusLine().getReasonPhrase());
      }
    }
    finally
    {
      localHttpGet.abort();
    }
    Object localObject = ((HttpResponse)localObject).getEntity();
    a(((HttpEntity)localObject).getContent(), ((HttpEntity)localObject).getContentLength(), paramOutputStream, paramURLDrawableHandler);
    localHttpGet.abort();
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader
 * JD-Core Version:    0.7.0.1
 */