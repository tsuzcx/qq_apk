package com.tencent.token;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class ahs
{
  public final aij a;
  public final aif b;
  public final SocketFactory c;
  final aht d;
  public final List<ain> e;
  public final List<aib> f;
  public final ProxySelector g;
  @Nullable
  public final Proxy h;
  @Nullable
  public final SSLSocketFactory i;
  @Nullable
  public final HostnameVerifier j;
  @Nullable
  public final ahy k;
  
  public ahs(String paramString, int paramInt, aif paramaif, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable ahy paramahy, aht paramaht, @Nullable Proxy paramProxy, List<ain> paramList, List<aib> paramList1, ProxySelector paramProxySelector)
  {
    aij.a locala = new aij.a();
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
      str = aij.a.a(paramString, 0, paramString.length());
      if (str != null)
      {
        locala.d = str;
        if ((paramInt > 0) && (paramInt <= 65535))
        {
          locala.e = paramInt;
          this.a = locala.b();
          if (paramaif != null)
          {
            this.b = paramaif;
            if (paramSocketFactory != null)
            {
              this.c = paramSocketFactory;
              if (paramaht != null)
              {
                this.d = paramaht;
                if (paramList != null)
                {
                  this.e = aix.a(paramList);
                  if (paramList1 != null)
                  {
                    this.f = aix.a(paramList1);
                    if (paramProxySelector != null)
                    {
                      this.g = paramProxySelector;
                      this.h = paramProxy;
                      this.i = paramSSLSocketFactory;
                      this.j = paramHostnameVerifier;
                      this.k = paramahy;
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
  
  final boolean a(ahs paramahs)
  {
    return (this.b.equals(paramahs.b)) && (this.d.equals(paramahs.d)) && (this.e.equals(paramahs.e)) && (this.f.equals(paramahs.f)) && (this.g.equals(paramahs.g)) && (aix.a(this.h, paramahs.h)) && (aix.a(this.i, paramahs.i)) && (aix.a(this.j, paramahs.j)) && (aix.a(this.k, paramahs.k)) && (this.a.c == paramahs.a.c);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ahs))
    {
      aij localaij = this.a;
      paramObject = (ahs)paramObject;
      if ((localaij.equals(paramObject.a)) && (a(paramObject))) {
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
      i2 = ((ahy)localObject).hashCode();
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
 * Qualified Name:     com.tencent.token.ahs
 * JD-Core Version:    0.7.0.1
 */