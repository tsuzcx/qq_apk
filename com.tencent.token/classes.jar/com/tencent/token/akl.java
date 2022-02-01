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
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

final class akl
  extends akq
{
  private final Class<?> a;
  private final akp<Socket> b;
  private final akp<Socket> d;
  private final akp<Socket> e;
  private final akp<Socket> f;
  private final c g = c.a();
  
  private akl(Class<?> paramClass, akp<Socket> paramakp1, akp<Socket> paramakp2, akp<Socket> paramakp3, akp<Socket> paramakp4)
  {
    this.a = paramClass;
    this.b = paramakp1;
    this.d = paramakp2;
    this.e = paramakp3;
    this.f = paramakp4;
  }
  
  public static akq a()
  {
    for (;;)
    {
      try
      {
        localObject = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          Object localObject = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
          akp localakp3 = new akp(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
          akp localakp4 = new akp(null, "setHostname", new Class[] { String.class });
          if (!d()) {
            break label125;
          }
          localakp1 = new akp([B.class, "getAlpnSelectedProtocol", new Class[0]);
          localakp2 = new akp(null, "setAlpnProtocols", new Class[] { [B.class });
          localObject = new akl((Class)localObject, localakp3, localakp4, localakp1, localakp2);
          return localObject;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          return null;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        continue;
      }
      label125:
      akp localakp1 = null;
      akp localakp2 = localakp1;
    }
  }
  
  private boolean a(String paramString, Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label38:
      break label38;
    }
    return b(paramString, paramClass, paramObject);
  }
  
  private boolean b(String paramString, Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramClass)
    {
      label29:
      break label29;
    }
    return super.b(paramString);
  }
  
  private static boolean d()
  {
    if (Security.getProvider("GMSCore_OpenSSL") != null) {
      return true;
    }
    try
    {
      Class.forName("android.net.Network");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label18:
      break label18;
    }
    return false;
  }
  
  public final akt a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new a(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      return localObject;
    }
    catch (Exception localException)
    {
      label65:
      break label65;
    }
    return super.a(paramX509TrustManager);
  }
  
  public final Object a(String paramString)
  {
    return this.g.a(paramString);
  }
  
  @Nullable
  public final String a(SSLSocket paramSSLSocket)
  {
    akp localakp = this.e;
    if (localakp == null) {
      return null;
    }
    if (!localakp.a(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])this.e.b(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {
      return new String(paramSSLSocket, aiw.e);
    }
    return null;
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i = 5;
    if (paramInt != 5) {
      i = 3;
    }
    Object localObject = paramString;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('\n');
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramInt = 0;
    int k = ((String)localObject).length();
    if (paramInt < k)
    {
      int j = ((String)localObject).indexOf('\n', paramInt);
      if (j == -1) {
        j = k;
      }
      for (;;)
      {
        int m = Math.min(j, paramInt + 4000);
        Log.println(i, "OkHttp", ((String)localObject).substring(paramInt, m));
        if (m >= j)
        {
          paramInt = m + 1;
          break;
        }
        paramInt = m;
      }
    }
  }
  
  public final void a(String paramString, Object paramObject)
  {
    if (!this.g.a(paramObject)) {
      a(5, paramString, null);
    }
  }
  
  public final void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
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
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
    catch (AssertionError paramSocket)
    {
      if (aiw.a(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<aim> paramList)
  {
    if (paramString != null)
    {
      this.b.a(paramSSLSocket, new Object[] { Boolean.TRUE });
      this.d.a(paramSSLSocket, new Object[] { paramString });
    }
    paramString = this.f;
    if ((paramString != null) && (paramString.a(paramSSLSocket)))
    {
      paramString = new aky();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        aim localaim = (aim)paramList.get(i);
        if (localaim != aim.a)
        {
          paramString.b(localaim.toString().length());
          paramString.a(localaim.toString());
        }
        i += 1;
      }
      paramString = paramString.o();
      this.f.b(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public final akv b(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new b(paramX509TrustManager, (Method)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label38:
      break label38;
    }
    return super.b(paramX509TrustManager);
  }
  
  public final SSLContext b()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 22)) {}
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
  
  public final boolean b(String paramString)
  {
    try
    {
      try
      {
        Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
        boolean bool = a(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        return bool;
      }
      catch (InvocationTargetException paramString) {}catch (IllegalArgumentException paramString) {}catch (IllegalAccessException paramString) {}
      throw aiw.a("unable to determine cleartext support", paramString);
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      label52:
      break label52;
    }
    return super.b(paramString);
  }
  
  static final class a
    extends akt
  {
    private final Object a;
    private final Method b;
    
    a(Object paramObject, Method paramMethod)
    {
      this.a = paramObject;
      this.b = paramMethod;
    }
    
    public final List<Certificate> a(List<Certificate> paramList, String paramString)
    {
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.b.invoke(this.a, new Object[] { paramList, "RSA", paramString });
        return paramList;
      }
      catch (IllegalAccessException paramList)
      {
        throw new AssertionError(paramList);
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        throw paramString;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      return paramObject instanceof a;
    }
    
    public final int hashCode()
    {
      return 0;
    }
  }
  
  static final class b
    implements akv
  {
    private final X509TrustManager a;
    private final Method b;
    
    b(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.b = paramMethod;
      this.a = paramX509TrustManager;
    }
    
    public final X509Certificate a(X509Certificate paramX509Certificate)
    {
      try
      {
        paramX509Certificate = (TrustAnchor)this.b.invoke(this.a, new Object[] { paramX509Certificate });
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.getTrustedCert();
          return paramX509Certificate;
        }
        return null;
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        throw aiw.a("unable to get issues and signature", paramX509Certificate);
      }
      catch (InvocationTargetException paramX509Certificate) {}
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
    }
    
    public final int hashCode()
    {
      return this.a.hashCode() + this.b.hashCode() * 31;
    }
  }
  
  static final class c
  {
    private final Method a;
    private final Method b;
    private final Method c;
    
    private c(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
    
    static c a()
    {
      Object localObject2 = null;
      try
      {
        localObject1 = Class.forName("dalvik.system.CloseGuard");
        Method localMethod = ((Class)localObject1).getMethod("get", new Class[0]);
        localObject3 = ((Class)localObject1).getMethod("open", new Class[] { String.class });
        localObject1 = ((Class)localObject1).getMethod("warnIfOpen", new Class[0]);
        localObject2 = localMethod;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        label51:
        break label51;
      }
      localObject1 = null;
      localObject3 = localObject1;
      return new c(localObject2, (Method)localObject3, (Method)localObject1);
    }
    
    final Object a(String paramString)
    {
      Object localObject = this.a;
      if (localObject != null) {}
      try
      {
        localObject = ((Method)localObject).invoke(null, new Object[0]);
        this.b.invoke(localObject, new Object[] { paramString });
        return localObject;
      }
      catch (Exception paramString) {}
      return null;
      return null;
    }
    
    final boolean a(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != null) {}
      try
      {
        this.c.invoke(paramObject, new Object[0]);
        bool = true;
        return bool;
      }
      catch (Exception paramObject) {}
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akl
 * JD-Core Version:    0.7.0.1
 */