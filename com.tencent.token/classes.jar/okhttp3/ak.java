package okhttp3;

import com.tencent.token.gn;
import com.tencent.token.gz;
import com.tencent.token.ih;
import com.tencent.token.il;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ak
  implements Cloneable
{
  static final List a = gn.a(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
  static final List b = gn.a(new q[] { q.b, q.d });
  final int A;
  final int B;
  final int C;
  final v c;
  @Nullable
  final Proxy d;
  final List e;
  final List f;
  final List g;
  final List h;
  final ab i;
  final ProxySelector j;
  final t k;
  @Nullable
  final d l;
  @Nullable
  final gz m;
  final SocketFactory n;
  @Nullable
  final SSLSocketFactory o;
  @Nullable
  final il p;
  final HostnameVerifier q;
  final i r;
  final b s;
  final b t;
  final o u;
  final w v;
  final boolean w;
  final boolean x;
  final boolean y;
  final int z;
  
  static
  {
    com.tencent.token.gl.a = new al();
  }
  
  public ak()
  {
    this(new am());
  }
  
  ak(am paramam)
  {
    this.c = paramam.a;
    this.d = paramam.b;
    this.e = paramam.c;
    this.f = paramam.d;
    this.g = gn.a(paramam.e);
    this.h = gn.a(paramam.f);
    this.i = paramam.g;
    this.j = paramam.h;
    this.k = paramam.i;
    this.l = paramam.j;
    this.m = paramam.k;
    this.n = paramam.l;
    Object localObject = this.f.iterator();
    int i1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      q localq = (q)((Iterator)localObject).next();
      if ((i1 != 0) || (localq.a())) {}
      for (i1 = 1;; i1 = 0) {
        break;
      }
    }
    if ((paramam.m != null) || (i1 == 0)) {
      this.o = paramam.m;
    }
    for (this.p = paramam.n;; this.p = il.a((X509TrustManager)localObject))
    {
      if (this.o != null) {
        ih.c().a(this.o);
      }
      this.q = paramam.o;
      this.r = paramam.p.a(this.p);
      this.s = paramam.q;
      this.t = paramam.r;
      this.u = paramam.s;
      this.v = paramam.t;
      this.w = paramam.u;
      this.x = paramam.v;
      this.y = paramam.w;
      this.z = paramam.x;
      this.A = paramam.y;
      this.B = paramam.z;
      this.C = paramam.A;
      if (!this.g.contains(null)) {
        break;
      }
      throw new IllegalStateException("Null interceptor: " + this.g);
      localObject = gn.a();
      this.o = a((X509TrustManager)localObject);
    }
    if (this.h.contains(null)) {
      throw new IllegalStateException("Null network interceptor: " + this.h);
    }
  }
  
  private static SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = ih.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw gn.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public int a()
  {
    return this.z;
  }
  
  public g a(ap paramap)
  {
    return an.a(this, paramap, false);
  }
  
  public int b()
  {
    return this.A;
  }
  
  public int c()
  {
    return this.B;
  }
  
  public int d()
  {
    return this.C;
  }
  
  public Proxy e()
  {
    return this.d;
  }
  
  public ProxySelector f()
  {
    return this.j;
  }
  
  public t g()
  {
    return this.k;
  }
  
  gz h()
  {
    if (this.l != null) {
      return this.l.a;
    }
    return this.m;
  }
  
  public w i()
  {
    return this.v;
  }
  
  public SocketFactory j()
  {
    return this.n;
  }
  
  public SSLSocketFactory k()
  {
    return this.o;
  }
  
  public HostnameVerifier l()
  {
    return this.q;
  }
  
  public i m()
  {
    return this.r;
  }
  
  public b n()
  {
    return this.t;
  }
  
  public b o()
  {
    return this.s;
  }
  
  public o p()
  {
    return this.u;
  }
  
  public boolean q()
  {
    return this.w;
  }
  
  public boolean r()
  {
    return this.x;
  }
  
  public boolean s()
  {
    return this.y;
  }
  
  public v t()
  {
    return this.c;
  }
  
  public List u()
  {
    return this.e;
  }
  
  public List v()
  {
    return this.f;
  }
  
  public List w()
  {
    return this.g;
  }
  
  public List x()
  {
    return this.h;
  }
  
  public ab y()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ak
 * JD-Core Version:    0.7.0.1
 */