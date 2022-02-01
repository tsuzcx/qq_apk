package com.tencent.moai.mailsdk.net;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.auth.x500.X500Principal;

public class SocketFetcher
{
  public static final int SOCKET_CONNECT_TIMEOUT = 15000;
  public static final int SOCKET_READ_TIMEOUT = 120000;
  private static final String TAG = "SocketFactory";
  
  private static void checkServerIdentity(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    try
    {
      Certificate[] arrayOfCertificate = paramSSLSocket.getSession().getPeerCertificates();
      if ((arrayOfCertificate != null) && (arrayOfCertificate.length > 0) && ((arrayOfCertificate[0] instanceof X509Certificate)))
      {
        boolean bool = matchCert(paramString, (X509Certificate)arrayOfCertificate[0]);
        if (bool) {
          return;
        }
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      paramSSLSocket.close();
      throw new IOException("Can't verify identity of server: " + paramString, localSSLPeerUnverifiedException);
    }
    paramSSLSocket.close();
    throw new IOException("Can't verify identity of server: " + paramString);
  }
  
  private static void configSSL(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    try
    {
      paramSSLSocket.startHandshake();
      return;
    }
    catch (SSLException localSSLException)
    {
      Log.getStackTraceString(localSSLException);
      int i = 0;
      paramSSLSocket = localSSLException;
      for (;;)
      {
        Throwable localThrowable = paramSSLSocket.getCause();
        if (localThrowable == null) {
          break;
        }
        int j = i;
        if ("QMCertificateException".equals(localThrowable.getMessage())) {
          j = 1;
        }
        i = j;
        paramSSLSocket = localThrowable;
        if (localThrowable.getCause() == null)
        {
          i = j;
          paramSSLSocket = localThrowable;
          if (j == 0)
          {
            Logger.osslog(new Object[] { "ssl_exception", paramString, localThrowable.getMessage() });
            i = j;
            paramSSLSocket = localThrowable;
          }
        }
      }
      throw localSSLException;
    }
  }
  
  public static Socket createSocket(String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, String paramString4)
    throws IOException
  {
    if (paramBoolean)
    {
      if (paramInt2 == 587) {}
      try
      {
        return getSocket(paramString1, paramInt2, paramString2, paramInt3, paramString3, paramString4);
      }
      catch (SSLException localSSLException)
      {
        SSLSocket localSSLSocket;
        Logger.log(6, "SocketFactory", "ssl exception:" + Log.getStackTraceString(localSSLException));
      }
      localSSLSocket = getSSLSocket(paramString1, paramInt2, paramString2, paramInt3, paramString3, paramString4);
      return localSSLSocket;
    }
    return getSocket(paramString1, paramInt1, paramString2, paramInt3, paramString3, paramString4);
  }
  
  public static Socket getSSLSocket(Socket paramSocket)
    throws IOException
  {
    String str = paramSocket.getInetAddress().getHostAddress();
    int i = paramSocket.getPort();
    Logger.log(4, "SocketFactory", "Create SSL Socket with Socket host:" + str + " port:" + i);
    try
    {
      SSLSocketFactory localSSLSocketFactory = MailSSLUtil.getDelegateSSLSocketFactory();
      paramSocket = (SSLSocket)localSSLSocketFactory.createSocket(paramSocket, str, i, true);
      configSSL(str, paramSocket);
      return paramSocket;
    }
    catch (GeneralSecurityException paramSocket)
    {
      Logger.log(6, "SocketFactory", Log.getStackTraceString(paramSocket));
      throw new IOException("Create MailSSLSocketFactory error", paramSocket);
    }
  }
  
  public static SSLSocket getSSLSocket(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
    throws IOException
  {
    Logger.log(4, "SocketFactory", "Create SSL Socket, host: " + paramString1 + ", port: " + paramInt1);
    for (;;)
    {
      SSLSocketFactory localSSLSocketFactory;
      try
      {
        localSSLSocketFactory = MailSSLUtil.getDelegateSSLSocketFactory();
        if ((!TextUtils.isEmpty(paramString2)) && (paramInt2 != -1))
        {
          paramString2 = (SSLSocket)localSSLSocketFactory.createSocket(new Socks5ProxySocketFactory(paramString2, paramInt2, paramString3, paramString4).createSocket(paramString1, paramInt1), paramString2, paramInt2, true);
          configSSL(paramString1, paramString2);
          paramString2.setSoTimeout(120000);
          return paramString2;
        }
      }
      catch (GeneralSecurityException paramString1)
      {
        Logger.log(6, "SocketFactory", Log.getStackTraceString(paramString1));
        throw new IOException("Create MailSSLSocketFactory error", paramString1);
      }
      paramString2 = (SSLSocket)localSSLSocketFactory.createSocket(paramString1, paramInt1);
    }
  }
  
  public static Socket getSocket(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
    throws IOException
  {
    Logger.log(4, "SocketFactory", "Create Socket host: " + paramString1 + ", port: " + paramInt1);
    SocketFactory localSocketFactory = SocketFactory.getDefault();
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt2 != -1)) {}
    for (paramString1 = new Socks5ProxySocketFactory(paramString2, paramInt2, paramString3, paramString4).createSocket(paramString1, paramInt1);; paramString1 = paramString2)
    {
      paramString1.setSoTimeout(120000);
      return paramString1;
      paramString2 = localSocketFactory.createSocket();
      paramString2.connect(new InetSocketAddress(paramString1, paramInt1), 15000);
    }
  }
  
  private static boolean matchCert(String paramString, X509Certificate paramX509Certificate)
  {
    try
    {
      Object localObject3 = Class.forName("sun.security.util.HostnameChecker");
      Object localObject1 = ((Class)localObject3).getMethod("getInstance", new Class[] { Byte.TYPE }).invoke(new Object(), new Object[] { Byte.valueOf(2) });
      localObject3 = ((Class)localObject3).getMethod("match", new Class[] { String.class, X509Certificate.class });
      for (;;)
      {
        try
        {
          ((Method)localObject3).invoke(localObject1, new Object[] { paramString, paramX509Certificate });
          return true;
        }
        catch (InvocationTargetException paramString)
        {
          return false;
        }
        try
        {
          Object localObject2 = paramX509Certificate.getSubjectAlternativeNames();
          if (localObject2 != null)
          {
            localObject2 = ((Collection)localObject2).iterator();
            for (int i = 0;; i = 1)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label184;
              }
              localObject3 = (List)((Iterator)localObject2).next();
              if (((Integer)((List)localObject3).get(0)).intValue() != 2) {
                break label233;
              }
              boolean bool = matchServer(paramString, (String)((List)localObject3).get(1));
              if (bool) {
                break;
              }
            }
            if (i != 0) {
              return false;
            }
          }
        }
        catch (CertificateParsingException localCertificateParsingException)
        {
          paramX509Certificate = Pattern.compile("CN=([^,]*)").matcher(paramX509Certificate.getSubjectX500Principal().getName());
        }
      }
    }
    catch (Exception localException) {}
    label184:
    label233:
    while ((!paramX509Certificate.find()) || (!matchServer(paramString, paramX509Certificate.group(1).trim()))) {
      return false;
    }
  }
  
  private static boolean matchServer(String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramString2.startsWith("*."))
    {
      paramString2 = paramString2.substring(2);
      if (paramString2.length() == 0) {}
      int i;
      do
      {
        return false;
        i = paramString1.length() - paramString2.length();
      } while (i < 1);
      if ((paramString1.charAt(i - 1) == '.') && (paramString1.regionMatches(true, i, paramString2, 0, paramString2.length()))) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.SocketFetcher
 * JD-Core Version:    0.7.0.1
 */