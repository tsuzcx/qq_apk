package com.tencent.tpns.baseapi.core.net;

import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TlsCompatSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "TlsCompatSocketFactory";
  private static final String[] TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20 = { "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" };
  final SSLSocketFactory target;
  
  public TlsCompatSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.target = paramSSLSocketFactory;
  }
  
  private Socket supportTLS(Socket paramSocket)
  {
    if (((paramSocket instanceof SSLSocket)) && (Build.VERSION.SDK_INT < 20)) {
      ((SSLSocket)paramSocket).setEnabledProtocols(TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20);
    }
    return paramSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return supportTLS(this.target.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return supportTLS(this.target.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return supportTLS(this.target.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return supportTLS(this.target.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return supportTLS(this.target.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.target.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.target.getSupportedCipherSuites();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory
 * JD-Core Version:    0.7.0.1
 */