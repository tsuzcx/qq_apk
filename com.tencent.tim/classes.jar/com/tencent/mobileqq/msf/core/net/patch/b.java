package com.tencent.mobileqq.msf.core.net.patch;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

public class b
  implements LayeredSocketFactory
{
  static final HostnameVerifier a = new StrictHostnameVerifier();
  private static final String c = "SNISocketFactory";
  SSLCertificateSocketFactory b = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(0, null);
  private String d;
  
  public b(String paramString)
  {
    this.d = paramString;
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException
  {
    paramSocket.connect(new InetSocketAddress(paramString, paramInt1));
    return paramSocket;
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.i("SNISocketFactory", 2, "createSocket " + paramSocket.toString() + " host:" + paramString + " port:" + paramInt + " autoClose:" + paramBoolean);
    }
    paramSocket = (SSLSocket)this.b.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "Setting SNI hostname");
      }
      this.b.setHostname(paramSocket, paramString);
    }
    for (;;)
    {
      SSLSession localSSLSession = paramSocket.getSession();
      if (a.verify(paramString, localSSLSession)) {
        break;
      }
      throw new SSLPeerUnverifiedException("Cannot verify hostname: " + paramString);
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "No documented SNI support on Android <4.2, trying with reflection");
      }
      try
      {
        paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "SNI not useable");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SNISocketFactory", 2, "Established " + localException.getProtocol() + " connection with " + localException.getPeerHost() + " using " + localException.getCipherSuite());
    }
    return paramSocket;
  }
  
  public boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    if ((paramSocket instanceof SSLSocket)) {
      return ((SSLSocket)paramSocket).isConnected();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.b
 * JD-Core Version:    0.7.0.1
 */