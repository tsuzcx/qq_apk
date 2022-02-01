package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class UnSafeSSLStrategy$1
  implements X509TrustManager
{
  UnSafeSSLStrategy$1(UnSafeSSLStrategy paramUnSafeSSLStrategy) {}
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if ((SSLStrategyFactory.getSSLStrategy() instanceof SafeSSLStrategy)) {
      throw new CertificateException();
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if ((SSLStrategyFactory.getSSLStrategy() instanceof SafeSSLStrategy)) {
      throw new CertificateException();
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.UnSafeSSLStrategy.1
 * JD-Core Version:    0.7.0.1
 */