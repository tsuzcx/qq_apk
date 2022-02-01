package com.tencent.token;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class akd
{
  public final ajv a;
  public final List<Certificate> b;
  private final akq c;
  private final List<Certificate> d;
  
  private akd(akq paramakq, ajv paramajv, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.c = paramakq;
    this.a = paramajv;
    this.b = paramList1;
    this.d = paramList2;
  }
  
  public static akd a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    ajv localajv;
    akq localakq;
    if (localObject != null) {
      if (!"SSL_NULL_WITH_NULL_NULL".equals(localObject))
      {
        localajv = ajv.a((String)localObject);
        localObject = paramSSLSession.getProtocol();
        if (localObject != null) {
          if (!"NONE".equals(localObject)) {
            localakq = akq.a((String)localObject);
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
      localObject = akt.a((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = akt.a(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new akd(localakq, localajv, (List)localObject, paramSSLSession);
    throw new IOException("tlsVersion == NONE");
    throw new IllegalStateException("tlsVersion == null");
    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof akd)) {
      return false;
    }
    paramObject = (akd)paramObject;
    return (this.c.equals(paramObject.c)) && (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.d.equals(paramObject.d));
  }
  
  public final int hashCode()
  {
    return (((this.c.hashCode() + 527) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akd
 * JD-Core Version:    0.7.0.1
 */