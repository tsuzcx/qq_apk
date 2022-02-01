package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address
{
  @Nullable
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  @Nullable
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  @Nullable
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, @Nullable Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
      if (paramDns != null) {
        break;
      }
      throw new NullPointerException("dns == null");
    }
    this.dns = paramDns;
    if (paramSocketFactory == null) {
      throw new NullPointerException("socketFactory == null");
    }
    this.socketFactory = paramSocketFactory;
    if (paramAuthenticator == null) {
      throw new NullPointerException("proxyAuthenticator == null");
    }
    this.proxyAuthenticator = paramAuthenticator;
    if (paramList == null) {
      throw new NullPointerException("protocols == null");
    }
    this.protocols = Util.immutableList(paramList);
    if (paramList1 == null) {
      throw new NullPointerException("connectionSpecs == null");
    }
    this.connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null) {
      throw new NullPointerException("proxySelector == null");
    }
    this.proxySelector = paramProxySelector;
    this.proxy = paramProxy;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
  }
  
  @Nullable
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Address)) && (this.url.equals(((Address)paramObject).url)) && (equalsNonHost((Address)paramObject));
  }
  
  boolean equalsNonHost(Address paramAddress)
  {
    return (this.dns.equals(paramAddress.dns)) && (this.proxyAuthenticator.equals(paramAddress.proxyAuthenticator)) && (this.protocols.equals(paramAddress.protocols)) && (this.connectionSpecs.equals(paramAddress.connectionSpecs)) && (this.proxySelector.equals(paramAddress.proxySelector)) && (Util.equal(this.proxy, paramAddress.proxy)) && (Util.equal(this.sslSocketFactory, paramAddress.sslSocketFactory)) && (Util.equal(this.hostnameVerifier, paramAddress.hostnameVerifier)) && (Util.equal(this.certificatePinner, paramAddress.certificatePinner)) && (url().port() == paramAddress.url().port());
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.url.hashCode();
    int i1 = this.dns.hashCode();
    int i2 = this.proxyAuthenticator.hashCode();
    int i3 = this.protocols.hashCode();
    int i4 = this.connectionSpecs.hashCode();
    int i5 = this.proxySelector.hashCode();
    int i;
    int j;
    if (this.proxy != null)
    {
      i = this.proxy.hashCode();
      if (this.sslSocketFactory == null) {
        break label185;
      }
      j = this.sslSocketFactory.hashCode();
      label91:
      if (this.hostnameVerifier == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int k = this.hostnameVerifier.hashCode();; k = 0)
    {
      if (this.certificatePinner != null) {
        m = this.certificatePinner.hashCode();
      }
      return (k + (j + (i + ((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label91;
    }
  }
  
  @Nullable
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  @Nullable
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  @Nullable
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Address{").append(this.url.host()).append(":").append(this.url.port());
    if (this.proxy != null) {
      localStringBuilder.append(", proxy=").append(this.proxy);
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(", proxySelector=").append(this.proxySelector);
    }
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Address
 * JD-Core Version:    0.7.0.1
 */