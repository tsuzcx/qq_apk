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
import okhttp3.v;
import okio.c;

public class gc
{
  private static final gc a = ;
  private static final Logger b = Logger.getLogger(v.class.getName());
  
  private static gc a()
  {
    Object localObject = fx.a();
    if (localObject != null) {
      return localObject;
    }
    if (d())
    {
      localObject = fy.a();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = fz.a();
    if (localObject != null) {
      return localObject;
    }
    localObject = ga.a();
    if (localObject != null) {
      return localObject;
    }
    return new gc();
  }
  
  public static List<String> a(List<Protocol> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol != Protocol.HTTP_1_0) {
        localArrayList.add(localProtocol.toString());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static byte[] b(List<Protocol> paramList)
  {
    c localc = new c();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol != Protocol.HTTP_1_0)
      {
        localc.b(localProtocol.toString().length());
        localc.a(localProtocol.toString());
      }
      i += 1;
    }
    return localc.q();
  }
  
  public static gc c()
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
  
  public gf a(X509TrustManager paramX509TrustManager)
  {
    return new gd(b(paramX509TrustManager));
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
    Level localLevel;
    if (paramInt == 5) {
      localLevel = Level.WARNING;
    } else {
      localLevel = Level.INFO;
    }
    b.log(localLevel, paramString, paramThrowable);
  }
  
  public void a(String paramString, Object paramObject)
  {
    Object localObject = paramString;
    if (paramObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
      localObject = ((StringBuilder)localObject).toString();
    }
    a(5, (String)localObject, (Throwable)paramObject);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void a(SSLSocketFactory paramSSLSocketFactory) {}
  
  public gh b(X509TrustManager paramX509TrustManager)
  {
    return new ge(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public SSLContext b()
  {
    if ("1.7".equals(System.getProperty("java.specification.version"))) {}
    for (;;)
    {
      try
      {
        localSSLContext = SSLContext.getInstance("TLSv1.2");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        SSLContext localSSLContext;
        continue;
      }
      try
      {
        localSSLContext = SSLContext.getInstance("TLS");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
      }
    }
  }
  
  public void b(SSLSocket paramSSLSocket) {}
  
  public boolean b(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gc
 * JD-Core Version:    0.7.0.1
 */