package com.tencent.open.base.http;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpBaseUtil$MyX509TrustManager
  implements X509TrustManager
{
  X509TrustManager a;
  
  public HttpBaseUtil$MyX509TrustManager()
  {
    try
    {
      Object localObject1 = KeyStore.getInstance("JKS");
      if (localObject1 != null)
      {
        ((KeyStore)localObject1).load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
        localTrustManagerFactory.init((KeyStore)localObject1);
        localObject1 = localTrustManagerFactory.getTrustManagers();
        i = 0;
        if (i >= localObject1.length) {
          break label114;
        }
        if (!(localObject1[i] instanceof X509TrustManager)) {
          break label107;
        }
        this.a = ((X509TrustManager)localObject1[i]);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Object localObject2 = null;
        continue;
        localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        ((TrustManagerFactory)localObject2).init((KeyStore)null);
        localObject2 = ((TrustManagerFactory)localObject2).getTrustManagers();
        continue;
        label107:
        i += 1;
      }
      label114:
      throw new Exception("Couldn't initialize");
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramArrayOfX509Certificate) {}
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.base.http.HttpBaseUtil.MyX509TrustManager
 * JD-Core Version:    0.7.0.1
 */