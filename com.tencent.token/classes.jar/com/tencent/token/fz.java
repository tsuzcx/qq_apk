package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

final class fz
  extends gc
{
  final Method a;
  final Method b;
  
  fz(Method paramMethod1, Method paramMethod2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
  }
  
  public static fz a()
  {
    try
    {
      fz localfz = new fz(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localfz;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label37:
      break label37;
    }
    return null;
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
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
    throw fc.a("unable to get selected protocols", paramSSLSocket);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
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
    throw fc.a("unable to set ssl parameters", paramSSLSocket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fz
 * JD-Core Version:    0.7.0.1
 */