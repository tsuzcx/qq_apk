package com.squareup.okhttp.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class AndroidTrustRootIndex
  implements TrustRootIndex
{
  private final Method findByIssuerAndSignatureMethod;
  private final X509TrustManager trustManager;
  
  public AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
  {
    this.findByIssuerAndSignatureMethod = paramMethod;
    this.trustManager = paramX509TrustManager;
  }
  
  public static TrustRootIndex get(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Method localMethod = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      localMethod.setAccessible(true);
      paramX509TrustManager = new AndroidTrustRootIndex(paramX509TrustManager, localMethod);
      return paramX509TrustManager;
    }
    catch (NoSuchMethodException paramX509TrustManager) {}
    return null;
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = (TrustAnchor)this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate });
      if (paramX509Certificate != null)
      {
        paramX509Certificate = paramX509Certificate.getTrustedCert();
        return paramX509Certificate;
      }
      return null;
    }
    catch (IllegalAccessException paramX509Certificate)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException paramX509Certificate) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.tls.AndroidTrustRootIndex
 * JD-Core Version:    0.7.0.1
 */