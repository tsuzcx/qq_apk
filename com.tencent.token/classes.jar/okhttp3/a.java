package okhttp3;

import com.tencent.token.ff;
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
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    this.a = locala.a(str).d(paramString).a(paramInt).c();
    if (paramo != null)
    {
      this.b = paramo;
      if (paramSocketFactory != null)
      {
        this.c = paramSocketFactory;
        if (paramb != null)
        {
          this.d = paramb;
          if (paramList != null)
          {
            this.e = ff.a(paramList);
            if (paramList1 != null)
            {
              this.f = ff.a(paramList1);
              if (paramProxySelector != null)
              {
                this.g = paramProxySelector;
                this.h = paramProxy;
                this.i = paramSSLSocketFactory;
                this.j = paramHostnameVerifier;
                this.k = paramg;
                return;
              }
              throw new NullPointerException("proxySelector == null");
            }
            throw new NullPointerException("connectionSpecs == null");
          }
          throw new NullPointerException("protocols == null");
        }
        throw new NullPointerException("proxyAuthenticator == null");
      }
      throw new NullPointerException("socketFactory == null");
    }
    throw new NullPointerException("dns == null");
  }
  
  public s a()
  {
    return this.a;
  }
  
  boolean a(a parama)
  {
    return (this.b.equals(parama.b)) && (this.d.equals(parama.d)) && (this.e.equals(parama.e)) && (this.f.equals(parama.f)) && (this.g.equals(parama.g)) && (ff.a(this.h, parama.h)) && (ff.a(this.i, parama.i)) && (ff.a(this.j, parama.j)) && (ff.a(this.k, parama.k)) && (a().g() == parama.a().g());
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
    if ((paramObject instanceof a))
    {
      s locals = this.a;
      paramObject = (a)paramObject;
      if ((locals.equals(paramObject.a)) && (a(paramObject))) {
        return true;
      }
    }
    return false;
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
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    Object localObject = this.h;
    int i2 = 0;
    int m;
    if (localObject != null) {
      m = ((Proxy)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = this.i;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.j;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.k;
    if (localObject != null) {
      i2 = ((g)localObject).hashCode();
    }
    return (((((((((527 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Address{");
    localStringBuilder.append(this.a.f());
    localStringBuilder.append(":");
    localStringBuilder.append(this.a.g());
    if (this.h != null)
    {
      localStringBuilder.append(", proxy=");
      localStringBuilder.append(this.h);
    }
    else
    {
      localStringBuilder.append(", proxySelector=");
      localStringBuilder.append(this.g);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.a
 * JD-Core Version:    0.7.0.1
 */