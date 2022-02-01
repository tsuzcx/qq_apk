package com.tencent.component.network.utils.http.base;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

class SniSSLSocketFactory$1
  implements X509HostnameVerifier
{
  SniSSLSocketFactory$1(SniSSLSocketFactory paramSniSSLSocketFactory) {}
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {}
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {}
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SniSSLSocketFactory.1
 * JD-Core Version:    0.7.0.1
 */