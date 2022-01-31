package com.tencent.mobileqq.international.activity;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class AcceptAllHttpsClient$MyX509TrustManager
  implements X509TrustManager
{
  X509TrustManager a;
  
  AcceptAllHttpsClient$MyX509TrustManager()
  {
    Object localObject = KeyStore.getInstance("JKS");
    ((KeyStore)localObject).load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
    localTrustManagerFactory.init((KeyStore)localObject);
    localObject = localTrustManagerFactory.getTrustManagers();
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i] instanceof X509TrustManager))
      {
        this.a = ((X509TrustManager)localObject[i]);
        return;
      }
      i += 1;
    }
    throw new Exception("Couldn't initialize");
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramArrayOfX509Certificate)
    {
      throw paramArrayOfX509Certificate;
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramArrayOfX509Certificate)
    {
      throw paramArrayOfX509Certificate;
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.activity.AcceptAllHttpsClient.MyX509TrustManager
 * JD-Core Version:    0.7.0.1
 */