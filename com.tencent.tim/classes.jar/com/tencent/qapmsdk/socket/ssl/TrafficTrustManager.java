package com.tencent.qapmsdk.socket.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;

public abstract class TrafficTrustManager
  implements Cloneable, X509TrustManager
{
  private String trafficTrustHost;
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    throw new UnsupportedOperationException("Not in client mode?");
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    checkServerTrusted(paramArrayOfX509Certificate, paramString, this.trafficTrustHost);
  }
  
  public abstract void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
    throws CertificateException;
  
  public String getHost()
  {
    return this.trafficTrustHost;
  }
  
  public abstract void onHandshakeFailed(String paramString, SSLException paramSSLException);
  
  final void onHandshakeFailed(SSLException paramSSLException)
  {
    onHandshakeFailed(this.trafficTrustHost, paramSSLException);
  }
  
  public void setHost(String paramString)
  {
    this.trafficTrustHost = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficTrustManager
 * JD-Core Version:    0.7.0.1
 */