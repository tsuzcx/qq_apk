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
import okhttp3.Protocol;

class fw
  extends gb
{
  private final Class<?> a;
  private final ga<Socket> b;
  private final ga<Socket> c;
  private final ga<Socket> d;
  private final ga<Socket> e;
  private final c f = c.a();
  
  fw(Class<?> paramClass, ga<Socket> paramga1, ga<Socket> paramga2, ga<Socket> paramga3, ga<Socket> paramga4)
  {
    this.a = paramClass;
    this.b = paramga1;
    this.c = paramga2;
    this.d = paramga3;
    this.e = paramga4;
  }
  
  public static gb a()
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
          ga localga3 = new ga(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
          ga localga4 = new ga(null, "setHostname", new Class[] { String.class });
          if (!e()) {
            break label117;
          }
          localga1 = new ga([B.class, "getAlpnSelectedProtocol", new Class[0]);
          localga2 = new ga(null, "setAlpnProtocols", new Class[] { [B.class });
          return new fw(localClass1, localga3, localga4, localga1, localga2);
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
      ga localga2 = null;
      ga localga1 = null;
    }
  }
  
  private boolean a(String paramString, Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return b(paramString, paramClass, paramObject);
  }
  
  private boolean b(String paramString, Class<?> paramClass, Object paramObject)
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
  
  public gf a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new a(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
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
    for (paramSSLSocket = new String(paramSSLSocket, fb.e);; paramSSLSocket = null) {
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
      if (fb.a(paramSocket)) {
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
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
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
  
  public gh b(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new b(paramX509TrustManager, (Method)localObject);
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
      throw fb.a("unable to determine cleartext support", paramString);
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
  
  static final class a
    extends gf
  {
    private final Object a;
    private final Method b;
    
    a(Object paramObject, Method paramMethod)
    {
      this.a = paramObject;
      this.b = paramMethod;
    }
    
    public List<Certificate> a(List<Certificate> paramList, String paramString)
    {
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.b.invoke(this.a, new Object[] { paramList, "RSA", paramString });
        return paramList;
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        throw paramString;
      }
      catch (IllegalAccessException paramList)
      {
        throw new AssertionError(paramList);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return paramObject instanceof a;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  static final class b
    implements gh
  {
    private final X509TrustManager a;
    private final Method b;
    
    b(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.b = paramMethod;
      this.a = paramX509TrustManager;
    }
    
    public X509Certificate a(X509Certificate paramX509Certificate)
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
        throw fb.a("unable to get issues and signature", paramX509Certificate);
      }
      catch (InvocationTargetException paramX509Certificate) {}
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() + this.b.hashCode() * 31;
    }
  }
  
  static final class c
  {
    private final Method a;
    private final Method b;
    private final Method c;
    
    c(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
    
    static c a()
    {
      Object localObject1 = null;
      try
      {
        Object localObject3 = Class.forName("dalvik.system.CloseGuard");
        localMethod2 = ((Class)localObject3).getMethod("get", new Class[0]);
        localMethod1 = ((Class)localObject3).getMethod("open", new Class[] { String.class });
        localObject3 = ((Class)localObject3).getMethod("warnIfOpen", new Class[0]);
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Method localMethod1;
          Object localObject2 = null;
          Method localMethod2 = null;
        }
      }
      return new c(localMethod2, localMethod1, localObject1);
    }
    
    Object a(String paramString)
    {
      if (this.a != null) {
        try
        {
          Object localObject = this.a.invoke(null, new Object[0]);
          this.b.invoke(localObject, new Object[] { paramString });
          return localObject;
        }
        catch (Exception paramString) {}
      }
      return null;
    }
    
    boolean a(Object paramObject)
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
 * Qualified Name:     com.tencent.token.fw
 * JD-Core Version:    0.7.0.1
 */