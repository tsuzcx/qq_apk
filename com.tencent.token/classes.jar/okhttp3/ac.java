package okhttp3;

import com.tencent.token.gn;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class ac
{
  private final TlsVersion a;
  private final l b;
  private final List c;
  private final List d;
  
  private ac(TlsVersion paramTlsVersion, l paraml, List paramList1, List paramList2)
  {
    this.a = paramTlsVersion;
    this.b = paraml;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static ac a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    if ("SSL_NULL_WITH_NULL_NULL".equals(localObject)) {
      throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    }
    l locall = l.a((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    if ("NONE".equals(localObject)) {
      throw new IOException("tlsVersion == NONE");
    }
    TlsVersion localTlsVersion = TlsVersion.a((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = gn.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label147;
        }
        paramSSLSession = gn.a(paramSSLSession);
        return new ac(localTlsVersion, locall, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label147:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public l a()
  {
    return this.b;
  }
  
  public List b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ac)) {}
    do
    {
      return false;
      paramObject = (ac)paramObject;
    } while ((!this.a.equals(paramObject.a)) || (!this.b.equals(paramObject.b)) || (!this.c.equals(paramObject.c)) || (!this.d.equals(paramObject.d)));
    return true;
  }
  
  public int hashCode()
  {
    return (((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ac
 * JD-Core Version:    0.7.0.1
 */