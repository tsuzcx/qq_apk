package com.tencent.token;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class aig
{
  public final ahy a;
  public final List<Certificate> b;
  private final ait c;
  private final List<Certificate> d;
  
  private aig(ait paramait, ahy paramahy, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.c = paramait;
    this.a = paramahy;
    this.b = paramList1;
    this.d = paramList2;
  }
  
  public static aig a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    ahy localahy;
    ait localait;
    if (localObject != null) {
      if (!"SSL_NULL_WITH_NULL_NULL".equals(localObject))
      {
        localahy = ahy.a((String)localObject);
        localObject = paramSSLSession.getProtocol();
        if (localObject != null) {
          if (!"NONE".equals(localObject)) {
            localait = ait.a((String)localObject);
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
      localObject = aiw.a((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = aiw.a(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new aig(localait, localahy, (List)localObject, paramSSLSession);
    throw new IOException("tlsVersion == NONE");
    throw new IllegalStateException("tlsVersion == null");
    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof aig)) {
      return false;
    }
    paramObject = (aig)paramObject;
    return (this.c.equals(paramObject.c)) && (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.d.equals(paramObject.d));
  }
  
  public final int hashCode()
  {
    return (((this.c.hashCode() + 527) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aig
 * JD-Core Version:    0.7.0.1
 */