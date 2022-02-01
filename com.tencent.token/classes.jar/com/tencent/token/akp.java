package com.tencent.token;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

final class akp
  extends akr
{
  private final Method a;
  private final Method b;
  private final Method d;
  private final Class<?> e;
  private final Class<?> f;
  
  private akp(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.d = paramMethod3;
    this.e = paramClass1;
    this.f = paramClass2;
  }
  
  public static akr a()
  {
    try
    {
      Object localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject2).append("$Provider");
      localObject2 = Class.forName(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject3).append("$ClientProvider");
      localObject3 = Class.forName(((StringBuilder)localObject3).toString());
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject4).append("$ServerProvider");
      localObject4 = Class.forName(((StringBuilder)localObject4).toString());
      localObject1 = new akp(((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localObject2 }), ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class }), (Class)localObject3, (Class)localObject4);
      return localObject1;
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      label157:
      break label157;
    }
    return null;
  }
  
  @Nullable
  public final String a(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (a)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.a) && (paramSSLSocket.b == null))
      {
        akr.c.a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (paramSSLSocket.a) {
        return null;
      }
      paramSSLSocket = paramSSLSocket.b;
      return paramSSLSocket;
    }
    catch (IllegalAccessException paramSSLSocket) {}catch (InvocationTargetException paramSSLSocket) {}
    throw aix.a("unable to get selected protocol", paramSSLSocket);
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<ain> paramList)
  {
    Object localObject = a(paramList);
    try
    {
      paramString = akr.class.getClassLoader();
      paramList = this.e;
      Class localClass = this.f;
      localObject = new a((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket) {}catch (InvocationTargetException paramSSLSocket) {}
    throw aix.a("unable to set alpn", paramSSLSocket);
  }
  
  public final void b(SSLSocket paramSSLSocket)
  {
    try
    {
      this.d.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (InvocationTargetException paramSSLSocket) {}catch (IllegalAccessException paramSSLSocket) {}
    throw aix.a("unable to remove alpn", paramSSLSocket);
  }
  
  static final class a
    implements InvocationHandler
  {
    boolean a;
    String b;
    private final List<String> c;
    
    a(List<String> paramList)
    {
      this.c = paramList;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = aix.b;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.TRUE;
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
 * Qualified Name:     com.tencent.token.akp
 * JD-Core Version:    0.7.0.1
 */