package com.tencent.mobileqq.international.activity;

import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class AcceptAllHttpsClient$CustomSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");
  
  public AcceptAllHttpsClient$CustomSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    try
    {
      paramKeyStore = new AcceptAllHttpsClient.MyX509TrustManager();
      this.a.init(null, new TrustManager[] { paramKeyStore }, null);
      return;
    }
    catch (Exception paramKeyStore)
    {
      for (;;)
      {
        paramKeyStore = null;
      }
    }
  }
  
  public X509Certificate[] a()
  {
    return null;
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.activity.AcceptAllHttpsClient.CustomSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */