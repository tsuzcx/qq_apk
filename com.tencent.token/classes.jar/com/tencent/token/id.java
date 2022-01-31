package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class id
  extends ih
{
  final Method a;
  final Method b;
  
  id(Method paramMethod1, Method paramMethod2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
  }
  
  public static id a()
  {
    try
    {
      id localid = new id(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localid;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
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
        if (!bool) {}
      }
      else
      {
        paramSSLSocket = null;
      }
      return paramSSLSocket;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw gn.a("unable to get selected protocols", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label36:
      break label36;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList)
  {
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = a(paramList);
      this.a.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw gn.a("unable to set ssl parameters", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label48:
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.id
 * JD-Core Version:    0.7.0.1
 */