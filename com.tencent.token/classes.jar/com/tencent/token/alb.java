package com.tencent.token;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class alb
{
  public final akt a;
  public final List<Certificate> b;
  private final alo c;
  private final List<Certificate> d;
  
  private alb(alo paramalo, akt paramakt, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.c = paramalo;
    this.a = paramakt;
    this.b = paramList1;
    this.d = paramList2;
  }
  
  public static alb a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    akt localakt;
    alo localalo;
    if (localObject != null) {
      if (!"SSL_NULL_WITH_NULL_NULL".equals(localObject))
      {
        localakt = akt.a((String)localObject);
        localObject = paramSSLSession.getProtocol();
        if (localObject != null) {
          if (!"NONE".equals(localObject)) {
            localalo = alo.a((String)localObject);
          }
        }
      }
    }
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      label60:
      break label60;
    }
    localObject = null;
    if (localObject != null) {
      localObject = alr.a((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = alr.a(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new alb(localalo, localakt, (List)localObject, paramSSLSession);
    throw new IOException("tlsVersion == NONE");
    throw new IllegalStateException("tlsVersion == null");
    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof alb)) {
      return false;
    }
    paramObject = (alb)paramObject;
    return (this.c.equals(paramObject.c)) && (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.d.equals(paramObject.d));
  }
  
  public final int hashCode()
  {
    return (((this.c.hashCode() + 527) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alb
 * JD-Core Version:    0.7.0.1
 */