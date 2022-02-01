package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class amk
  extends amn
{
  final Method a;
  final Method b;
  
  private amk(Method paramMethod1, Method paramMethod2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
  }
  
  public static amk a()
  {
    try
    {
      amk localamk = new amk(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localamk;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label37:
      break label37;
    }
    return null;
  }
  
  @Nullable
  public final String a(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (String)this.b.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null)
      {
        boolean bool = paramSSLSocket.equals("");
        if (!bool) {
          return paramSSLSocket;
        }
      }
      return null;
    }
    catch (InvocationTargetException paramSSLSocket) {}catch (IllegalAccessException paramSSLSocket) {}
    throw akt.a("unable to get selected protocols", paramSSLSocket);
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<akj> paramList)
  {
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = a(paramList);
      this.a.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (InvocationTargetException paramSSLSocket) {}catch (IllegalAccessException paramSSLSocket) {}
    throw akt.a("unable to set ssl parameters", paramSSLSocket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amk
 * JD-Core Version:    0.7.0.1
 */