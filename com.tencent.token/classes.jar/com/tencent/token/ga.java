package com.tencent.token;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

class ga
  extends gc
{
  private final Method a;
  private final Method b;
  private final Method c;
  private final Class<?> d;
  private final Class<?> e;
  
  ga(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
    this.d = paramClass1;
    this.e = paramClass2;
  }
  
  public static gc a()
  {
    try
    {
      Object localObject = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Class localClass1 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
      Class localClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
      Class localClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
      localObject = new ga(((Class)localObject).getMethod("put", new Class[] { SSLSocket.class, localClass1 }), ((Class)localObject).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject).getMethod("remove", new Class[] { SSLSocket.class }), localClass2, localClass3);
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
      paramSSLSocket = (a)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.a) && (paramSSLSocket.b == null))
      {
        gc.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
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
      throw fc.a("unable to get selected protocol", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label70:
      break label70;
    }
    return paramSSLSocket;
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Object localObject = a(paramList);
    try
    {
      paramString = gc.class.getClassLoader();
      paramList = this.d;
      Class localClass = this.e;
      localObject = new a((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw fc.a("unable to set alpn", paramSSLSocket);
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
      throw fc.a("unable to remove alpn", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label19:
      break label19;
    }
  }
  
  private static class a
    implements InvocationHandler
  {
    boolean a;
    String b;
    private final List<String> c;
    
    a(List<String> paramList)
    {
      this.c = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = fc.b;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.a = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.c;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = paramObject.size();
        int i = 0;
        while (i < j)
        {
          if (this.c.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.b = paramObject;
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.c.get(0);
        this.b = paramObject;
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.b = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ga
 * JD-Core Version:    0.7.0.1
 */