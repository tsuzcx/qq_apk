package com.tencent.token;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.ak;
import okio.f;

public class ih
{
  private static final ih a = ;
  private static final Logger b = Logger.getLogger(ak.class.getName());
  
  private static ih a()
  {
    Object localObject1 = hy.a();
    if (localObject1 != null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!d()) {
            break;
          }
          localObject2 = ic.a();
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = id.a();
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = ie.a();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return new ih();
  }
  
  public static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localProtocol.toString());
      }
    }
    return localArrayList;
  }
  
  static byte[] b(List paramList)
  {
    f localf = new f();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localf.b(localProtocol.toString().length());
        localf.a(localProtocol.toString());
      }
    }
    return localf.q();
  }
  
  public static ih c()
  {
    return a;
  }
  
  public static boolean d()
  {
    if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
      return true;
    }
    return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
  }
  
  public il a(X509TrustManager paramX509TrustManager)
  {
    return new ij(b(paramX509TrustManager));
  }
  
  public Object a(String paramString)
  {
    if (b.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 5) {}
    for (Level localLevel = Level.WARNING;; localLevel = Level.INFO)
    {
      b.log(localLevel, paramString, paramThrowable);
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramObject == null) {
      str = paramString + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    }
    a(5, str, (Throwable)paramObject);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList) {}
  
  public void a(SSLSocketFactory paramSSLSocketFactory) {}
  
  public in b(X509TrustManager paramX509TrustManager)
  {
    return new ik(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public SSLContext b()
  {
    if ("1.7".equals(System.getProperty("java.specification.version"))) {
      try
      {
        SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.2");
        return localSSLContext1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
    }
    try
    {
      SSLContext localSSLContext2 = SSLContext.getInstance("TLS");
      return localSSLContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException2);
    }
  }
  
  public void b(SSLSocket paramSSLSocket) {}
  
  public boolean b(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ih
 * JD-Core Version:    0.7.0.1
 */