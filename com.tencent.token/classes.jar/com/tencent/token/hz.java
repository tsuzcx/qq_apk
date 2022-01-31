package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

final class hz
  extends il
{
  private final Object a;
  private final Method b;
  
  hz(Object paramObject, Method paramMethod)
  {
    this.a = paramObject;
    this.b = paramMethod;
  }
  
  public List a(List paramList, String paramString)
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
    return paramObject instanceof hz;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hz
 * JD-Core Version:    0.7.0.1
 */