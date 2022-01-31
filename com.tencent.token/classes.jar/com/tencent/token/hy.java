package com.tencent.token;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class hy
  extends ih
{
  private final Class a;
  private final ig b;
  private final ig c;
  private final ig d;
  private final ig e;
  private final ib f = ib.a();
  
  hy(Class paramClass, ig paramig1, ig paramig2, ig paramig3, ig paramig4)
  {
    this.a = paramClass;
    this.b = paramig1;
    this.c = paramig2;
    this.d = paramig3;
    this.e = paramig4;
  }
  
  public static ih a()
  {
    for (;;)
    {
      try
      {
        localClass1 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          Class localClass1;
          ig localig3 = new ig(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
          ig localig4 = new ig(null, "setHostname", new Class[] { String.class });
          if (!e()) {
            break label117;
          }
          localig1 = new ig([B.class, "getAlpnSelectedProtocol", new Class[0]);
          localig2 = new ig(null, "setAlpnProtocols", new Class[] { [B.class });
          return new hy(localClass1, localig3, localig4, localig1, localig2);
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          Class localClass2;
          return null;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        localClass2 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        continue;
      }
      label117:
      ig localig2 = null;
      ig localig1 = null;
    }
  }
  
  private boolean a(String paramString, Class paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return b(paramString, paramClass, paramObject);
  }
  
  private boolean b(String paramString, Class paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramClass) {}
    return super.b(paramString);
  }
  
  private static boolean e()
  {
    if (Security.getProvider("GMSCore_OpenSSL") != null) {
      return true;
    }
    try
    {
      Class.forName("android.net.Network");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public il a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new hz(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      return localObject;
    }
    catch (Exception localException) {}
    return super.a(paramX509TrustManager);
  }
  
  public Object a(String paramString)
  {
    return this.f.a(paramString);
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    if (this.d == null) {}
    while (!this.d.a(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])this.d.d(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {}
    for (paramSSLSocket = new String(paramSSLSocket, gn.e);; paramSSLSocket = null) {
      return paramSSLSocket;
    }
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i;
    String str;
    int k;
    label52:
    int j;
    if (paramInt == 5)
    {
      i = 5;
      str = paramString;
      if (paramThrowable != null) {
        str = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      }
      paramInt = 0;
      k = str.length();
      if (paramInt >= k) {
        break label130;
      }
      j = str.indexOf('\n', paramInt);
      if (j == -1) {
        break label123;
      }
    }
    for (;;)
    {
      int m = Math.min(j, paramInt + 4000);
      Log.println(i, "OkHttp", str.substring(paramInt, m));
      if (m >= j)
      {
        paramInt = m + 1;
        break label52;
        i = 3;
        break;
        label123:
        j = k;
        continue;
        label130:
        return;
      }
      paramInt = m;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (!this.f.a(paramObject)) {
      a(5, paramString, null);
    }
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (gn.a(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
      throw paramSocket;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList)
  {
    if (paramString != null)
    {
      this.b.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.c.b(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.e != null) && (this.e.a(paramSSLSocket)))
    {
      paramString = b(paramList);
      this.e.d(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public in b(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new ia(paramX509TrustManager, (Method)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return super.b(paramX509TrustManager);
  }
  
  public SSLContext b()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 22)) {
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
  
  public boolean b(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      boolean bool = a(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.b(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw gn.a("unable to determine cleartext support", paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      break label43;
    }
    catch (InvocationTargetException paramString)
    {
      break label43;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label36:
      label43:
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hy
 * JD-Core Version:    0.7.0.1
 */