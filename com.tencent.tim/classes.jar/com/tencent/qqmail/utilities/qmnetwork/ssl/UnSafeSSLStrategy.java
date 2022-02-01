package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class UnSafeSSLStrategy
  extends SSLStraetgy
{
  SSLSocketFactory getWrappedFactory()
  {
    try
    {
      Object localObject = new UnSafeSSLStrategy.1(this);
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localObject }, localSecureRandom);
      localObject = localSSLContext.getSocketFactory();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.UnSafeSSLStrategy
 * JD-Core Version:    0.7.0.1
 */