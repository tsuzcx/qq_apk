package okhttp3;

import com.tencent.token.fc;
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
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    if ("SSL_NULL_WITH_NULL_NULL".equals(localObject)) {
      throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    }
    h localh = h.a((String)localObject);
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
        localObject = fc.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label147;
        }
        paramSSLSession = fc.a(paramSSLSession);
        return new q(localTlsVersion, localh, (List)localObject, paramSSLSession);
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
    if (!(paramObject instanceof q)) {}
    do
    {
      return false;
      paramObject = (q)paramObject;
    } while ((!this.a.equals(paramObject.a)) || (!this.b.equals(paramObject.b)) || (!this.c.equals(paramObject.c)) || (!this.d.equals(paramObject.d)));
    return true;
  }
  
  public int hashCode()
  {
    return (((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.q
 * JD-Core Version:    0.7.0.1
 */