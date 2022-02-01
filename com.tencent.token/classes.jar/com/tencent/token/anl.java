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

public class anl
{
  private static final Logger a = Logger.getLogger(alg.class.getName());
  static final anl c;
  
  static
  {
    Object localObject = ang.a();
    if (localObject == null)
    {
      boolean bool;
      if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
        bool = true;
      } else {
        bool = "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
      }
      if (bool)
      {
        localObject = anh.a();
        if (localObject != null) {}
      }
      else
      {
        localObject = ani.a();
        if (localObject == null)
        {
          localObject = anj.a();
          if (localObject == null) {
            localObject = new anl();
          }
        }
      }
    }
    c = (anl)localObject;
  }
  
  public static List<String> a(List<alh> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      alh localalh = (alh)paramList.get(i);
      if (localalh != alh.a) {
        localArrayList.add(localalh.toString());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static anl c()
  {
    return c;
  }
  
  public ano a(X509TrustManager paramX509TrustManager)
  {
    return new anm(b(paramX509TrustManager));
  }
  
  public Object a(String paramString)
  {
    if (a.isLoggable(Level.FINE)) {
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
    a.log(localLevel, paramString, paramThrowable);
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
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<alh> paramList) {}
  
  public void a(SSLSocketFactory paramSSLSocketFactory) {}
  
  public anq b(X509TrustManager paramX509TrustManager)
  {
    return new ann(paramX509TrustManager.getAcceptedIssuers());
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
 * Qualified Name:     com.tencent.token.anl
 * JD-Core Version:    0.7.0.1
 */