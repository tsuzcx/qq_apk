package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class SafeSSLStrategy$1
  implements X509TrustManager
{
  SafeSSLStrategy$1(SafeSSLStrategy paramSafeSSLStrategy, X509TrustManager paramX509TrustManager) {}
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    try
    {
      this.val$origTrustmanager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramString)
    {
      SafeSSLStrategy.access$000(this.this$0, paramArrayOfX509Certificate);
      SafeSSLStrategy.access$200(this.this$0, SafeSSLStrategy.access$100(this.this$0, paramArrayOfX509Certificate), paramString);
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    try
    {
      this.val$origTrustmanager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramString)
    {
      SafeSSLStrategy.access$000(this.this$0, paramArrayOfX509Certificate);
      SafeSSLStrategy.access$200(this.this$0, SafeSSLStrategy.access$100(this.this$0, paramArrayOfX509Certificate), paramString);
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.val$origTrustmanager.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.1
 * JD-Core Version:    0.7.0.1
 */