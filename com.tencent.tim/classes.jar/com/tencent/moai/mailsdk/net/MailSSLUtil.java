package com.tencent.moai.mailsdk.net;

import java.security.GeneralSecurityException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class MailSSLUtil
{
  private static HostnameVerifier delegateHostnameVerifier = null;
  private static SSLSocketFactory delegateSSLSocketFactory = null;
  
  public static HostnameVerifier getDelegateHostnameVerifier()
  {
    return delegateHostnameVerifier;
  }
  
  public static SSLSocketFactory getDelegateSSLSocketFactory()
    throws GeneralSecurityException
  {
    if (delegateSSLSocketFactory != null) {
      return delegateSSLSocketFactory;
    }
    return new MailSSLSocketFactory();
  }
  
  public static void setDelegateSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    delegateSSLSocketFactory = paramSSLSocketFactory;
  }
  
  public static void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    delegateHostnameVerifier = paramHostnameVerifier;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.MailSSLUtil
 * JD-Core Version:    0.7.0.1
 */