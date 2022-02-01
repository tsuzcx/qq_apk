package com.tencent.token;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class ahr
{
  public final aii a;
  public final aie b;
  public final SocketFactory c;
  final ahs d;
  public final List<aim> e;
  public final List<aia> f;
  public final ProxySelector g;
  @Nullable
  public final Proxy h;
  @Nullable
  public final SSLSocketFactory i;
  @Nullable
  public final HostnameVerifier j;
  @Nullable
  public final ahx k;
  
  public ahr(String paramString, int paramInt, aie paramaie, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable ahx paramahx, ahs paramahs, @Nullable Proxy paramProxy, List<aim> paramList, List<aia> paramList1, ProxySelector paramProxySelector)
  {
    aii.a locala = new aii.a();
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    if (str.equalsIgnoreCase("http"))
    {
      locala.a = "http";
    }
    else
    {
      if (!str.equalsIgnoreCase("https")) {
        break label317;
      }
      locala.a = "https";
    }
    if (paramString != null)
    {
      str = aii.a.a(paramString, 0, paramString.length());
      if (str != null)
      {
        locala.d = str;
        if ((paramInt > 0) && (paramInt <= 65535))
        {
          locala.e = paramInt;
          this.a = locala.b();
          if (paramaie != null)
          {
            this.b = paramaie;
            if (paramSocketFactory != null)
            {
              this.c = paramSocketFactory;
              if (paramahs != null)
              {
                this.d = paramahs;
                if (paramList != null)
                {
                  this.e = aiw.a(paramList);
                  if (paramList1 != null)
                  {
                    this.f = aiw.a(paramList1);
                    if (paramProxySelector != null)
                    {
                      this.g = paramProxySelector;
                      this.h = paramProxy;
                      this.i = paramSSLSocketFactory;
                      this.j = paramHostnameVerifier;
                      this.k = paramahx;
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
        throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(paramInt)));
      }
      throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(paramString)));
    }
    throw new NullPointerException("host == null");
    label317:
    throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
  }
  
  final boolean a(ahr paramahr)
  {
    return (this.b.equals(paramahr.b)) && (this.d.equals(paramahr.d)) && (this.e.equals(paramahr.e)) && (this.f.equals(paramahr.f)) && (this.g.equals(paramahr.g)) && (aiw.a(this.h, paramahr.h)) && (aiw.a(this.i, paramahr.i)) && (aiw.a(this.j, paramahr.j)) && (aiw.a(this.k, paramahr.k)) && (this.a.c == paramahr.a.c);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ahr))
    {
      aii localaii = this.a;
      paramObject = (ahr)paramObject;
      if ((localaii.equals(paramObject.a)) && (a(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
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
      i2 = ((ahx)localObject).hashCode();
    }
    return (((((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Address{");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.a.c);
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
 * Qualified Name:     com.tencent.token.ahr
 * JD-Core Version:    0.7.0.1
 */