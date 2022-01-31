package com.tencent.token;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class ie
  extends ih
{
  private final Method a;
  private final Method b;
  private final Method c;
  private final Class d;
  private final Class e;
  
  ie(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class paramClass1, Class paramClass2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
    this.d = paramClass1;
    this.e = paramClass2;
  }
  
  public static ih a()
  {
    try
    {
      Object localObject = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Class localClass1 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
      Class localClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
      Class localClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
      localObject = new ie(((Class)localObject).getMethod("put", new Class[] { SSLSocket.class, localClass1 }), ((Class)localObject).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject).getMethod("remove", new Class[] { SSLSocket.class }), localClass2, localClass3);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label140:
      break label140;
    }
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (if)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.a) && (paramSSLSocket.b == null))
      {
        ih.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (paramSSLSocket.a) {
        paramSSLSocket = null;
      } else {
        paramSSLSocket = paramSSLSocket.b;
      }
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw gn.a("unable to get selected protocol", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label70:
      break label70;
    }
    return paramSSLSocket;
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList)
  {
    Object localObject = a(paramList);
    try
    {
      paramString = ih.class.getClassLoader();
      paramList = this.d;
      Class localClass = this.e;
      localObject = new if((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw gn.a("unable to set alpn", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label77:
      break label77;
    }
  }
  
  public void b(SSLSocket paramSSLSocket)
  {
    try
    {
      this.c.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw gn.a("unable to remove alpn", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label19:
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ie
 * JD-Core Version:    0.7.0.1
 */