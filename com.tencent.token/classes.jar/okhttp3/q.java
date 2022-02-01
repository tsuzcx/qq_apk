package okhttp3;

import com.tencent.token.ff;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class q
{
  private final TlsVersion a;
  private final h b;
  private final List<Certificate> c;
  private final List<Certificate> d;
  
  private q(TlsVersion paramTlsVersion, h paramh, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramTlsVersion;
    this.b = paramh;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static q a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    h localh;
    TlsVersion localTlsVersion;
    if (localObject != null) {
      if (!"SSL_NULL_WITH_NULL_NULL".equals(localObject))
      {
        localh = h.a((String)localObject);
        localObject = paramSSLSession.getProtocol();
        if (localObject != null) {
          if (!"NONE".equals(localObject)) {
            localTlsVersion = TlsVersion.a((String)localObject);
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
      localObject = ff.a((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = ff.a(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new q(localTlsVersion, localh, (List)localObject, paramSSLSession);
    throw new IOException("tlsVersion == NONE");
    throw new IllegalStateException("tlsVersion == null");
    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public h a()
  {
    return this.b;
  }
  
  public List<Certificate> b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof q;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (q)paramObject;
    bool1 = bool2;
    if (this.a.equals(paramObject.a))
    {
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.c.equals(paramObject.c))
        {
          bool1 = bool2;
          if (this.d.equals(paramObject.d)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.q
 * JD-Core Version:    0.7.0.1
 */