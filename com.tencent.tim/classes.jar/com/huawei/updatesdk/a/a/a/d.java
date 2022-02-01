package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class d
  extends SSLSocketFactory
{
  private static volatile d a = null;
  private SSLContext b = null;
  
  private d(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException
  {
    paramContext = new e(paramContext);
    this.b.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  public static d a(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    paramString = this.b.getSocketFactory().createSocket(paramString, paramInt);
    if ((paramString instanceof SSLSocket)) {
      c.b((SSLSocket)paramString);
    }
    return paramString;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    paramSocket = this.b.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket)) {
      c.b((SSLSocket)paramSocket);
    }
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */