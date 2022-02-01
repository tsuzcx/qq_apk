package okhttp3;

import com.tencent.token.fc;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final s a;
  final o b;
  final SocketFactory c;
  final b d;
  final List<Protocol> e;
  final List<k> f;
  final ProxySelector g;
  @Nullable
  final Proxy h;
  @Nullable
  final SSLSocketFactory i;
  @Nullable
  final HostnameVerifier j;
  @Nullable
  final g k;
  
  public a(String paramString, int paramInt, o paramo, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable g paramg, b paramb, @Nullable Proxy paramProxy, List<Protocol> paramList, List<k> paramList1, ProxySelector paramProxySelector)
  {
    s.a locala = new s.a();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.a = locala.a(str).d(paramString).a(paramInt).c();
      if (paramo != null) {
        break;
      }
      throw new NullPointerException("dns == null");
    }
    this.b = paramo;
    if (paramSocketFactory == null) {
      throw new NullPointerException("socketFactory == null");
    }
    this.c = paramSocketFactory;
    if (paramb == null) {
      throw new NullPointerException("proxyAuthenticator == null");
    }
    this.d = paramb;
    if (paramList == null) {
      throw new NullPointerException("protocols == null");
    }
    this.e = fc.a(paramList);
    if (paramList1 == null) {
      throw new NullPointerException("connectionSpecs == null");
    }
    this.f = fc.a(paramList1);
    if (paramProxySelector == null) {
      throw new NullPointerException("proxySelector == null");
    }
    this.g = paramProxySelector;
    this.h = paramProxy;
    this.i = paramSSLSocketFactory;
    this.j = paramHostnameVerifier;
    this.k = paramg;
  }
  
  public s a()
  {
    return this.a;
  }
  
  boolean a(a parama)
  {
    return (this.b.equals(parama.b)) && (this.d.equals(parama.d)) && (this.e.equals(parama.e)) && (this.f.equals(parama.f)) && (this.g.equals(parama.g)) && (fc.a(this.h, parama.h)) && (fc.a(this.i, parama.i)) && (fc.a(this.j, parama.j)) && (fc.a(this.k, parama.k)) && (a().g() == parama.a().g());
  }
  
  public o b()
  {
    return this.b;
  }
  
  public SocketFactory c()
  {
    return this.c;
  }
  
  public b d()
  {
    return this.d;
  }
  
  public List<Protocol> e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof a)) && (this.a.equals(((a)paramObject).a)) && (a((a)paramObject));
  }
  
  public List<k> f()
  {
    return this.f;
  }
  
  public ProxySelector g()
  {
    return this.g;
  }
  
  @Nullable
  public Proxy h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    int m;
    int n;
    if (this.h != null)
    {
      m = this.h.hashCode();
      if (this.i == null) {
        break label185;
      }
      n = this.i.hashCode();
      label91:
      if (this.j == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int i1 = this.j.hashCode();; i1 = 0)
    {
      if (this.k != null) {
        i2 = this.k.hashCode();
      }
      return (i1 + (n + (m + ((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i2;
      m = 0;
      break;
      n = 0;
      break label91;
    }
  }
  
  @Nullable
  public SSLSocketFactory i()
  {
    return this.i;
  }
  
  @Nullable
  public HostnameVerifier j()
  {
    return this.j;
  }
  
  @Nullable
  public g k()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Address{").append(this.a.f()).append(":").append(this.a.g());
    if (this.h != null) {
      localStringBuilder.append(", proxy=").append(this.h);
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(", proxySelector=").append(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.a
 * JD-Core Version:    0.7.0.1
 */