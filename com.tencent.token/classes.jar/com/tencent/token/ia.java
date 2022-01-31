package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class ia
  implements in
{
  private final X509TrustManager a;
  private final Method b;
  
  ia(X509TrustManager paramX509TrustManager, Method paramMethod)
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
      throw gn.a("unable to get issues and signature", paramX509Certificate);
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
      if (!(paramObject instanceof ia)) {
        return false;
      }
      paramObject = (ia)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.b.hashCode() * 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ia
 * JD-Core Version:    0.7.0.1
 */