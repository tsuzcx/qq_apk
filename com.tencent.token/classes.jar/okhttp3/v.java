package okhttp3;

import com.tencent.token.fd;
import com.tencent.token.ff;
import com.tencent.token.fl;
import com.tencent.token.gf;
import com.tencent.token.gi;
import com.tencent.token.gj;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;

public class v
  implements Cloneable
{
  static final List<Protocol> a = ff.a(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
  static final List<k> b = ff.a(new k[] { k.b, k.d });
  final int A;
  final int B;
  final int C;
  final n c;
  @Nullable
  final Proxy d;
  final List<Protocol> e;
  final List<k> f;
  final List<t> g;
  final List<t> h;
  final p.a i;
  final ProxySelector j;
  final m k;
  @Nullable
  final c l;
  @Nullable
  final fl m;
  final SocketFactory n;
  @Nullable
  final SSLSocketFactory o;
  @Nullable
  final gi p;
  final HostnameVerifier q;
  final g r;
  final b s;
  final b t;
  final j u;
  final o v;
  final boolean w;
  final boolean x;
  final boolean y;
  final int z;
  
  static
  {
    fd.a = new fd()
    {
      public int a(z.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public Socket a(j paramAnonymousj, a paramAnonymousa, f paramAnonymousf)
      {
        return paramAnonymousj.a(paramAnonymousa, paramAnonymousf);
      }
      
      public okhttp3.internal.connection.c a(j paramAnonymousj, a paramAnonymousa, f paramAnonymousf, ab paramAnonymousab)
      {
        return paramAnonymousj.a(paramAnonymousa, paramAnonymousf, paramAnonymousab);
      }
      
      public d a(j paramAnonymousj)
      {
        return paramAnonymousj.a;
      }
      
      public void a(k paramAnonymousk, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        paramAnonymousk.a(paramAnonymousSSLSocket, paramAnonymousBoolean);
      }
      
      public void a(r.a paramAnonymousa, String paramAnonymousString)
      {
        paramAnonymousa.a(paramAnonymousString);
      }
      
      public void a(r.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.b(paramAnonymousString1, paramAnonymousString2);
      }
      
      public boolean a(a paramAnonymousa1, a paramAnonymousa2)
      {
        return paramAnonymousa1.a(paramAnonymousa2);
      }
      
      public boolean a(j paramAnonymousj, okhttp3.internal.connection.c paramAnonymousc)
      {
        return paramAnonymousj.b(paramAnonymousc);
      }
      
      public void b(j paramAnonymousj, okhttp3.internal.connection.c paramAnonymousc)
      {
        paramAnonymousj.a(paramAnonymousc);
      }
    };
  }
  
  public v()
  {
    this(new a());
  }
  
  v(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = ff.a(parama.e);
    this.h = ff.a(parama.f);
    this.i = parama.g;
    this.j = parama.h;
    this.k = parama.i;
    this.l = parama.j;
    this.m = parama.k;
    this.n = parama.l;
    Object localObject = this.f.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      k localk = (k)((Iterator)localObject).next();
      if ((i1 == 0) && (!localk.a())) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    if ((parama.m == null) && (i1 != 0))
    {
      localObject = ff.a();
      this.o = a((X509TrustManager)localObject);
      this.p = gi.a((X509TrustManager)localObject);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      gf.c().a(this.o);
    }
    this.q = parama.o;
    this.r = parama.p.a(this.p);
    this.s = parama.q;
    this.t = parama.r;
    this.u = parama.s;
    this.v = parama.t;
    this.w = parama.u;
    this.x = parama.v;
    this.y = parama.w;
    this.z = parama.x;
    this.A = parama.y;
    this.B = parama.z;
    this.C = parama.A;
    if (!this.g.contains(null))
    {
      if (!this.h.contains(null)) {
        return;
      }
      parama = new StringBuilder();
      parama.append("Null network interceptor: ");
      parama.append(this.h);
      throw new IllegalStateException(parama.toString());
    }
    parama = new StringBuilder();
    parama.append("Null interceptor: ");
    parama.append(this.g);
    throw new IllegalStateException(parama.toString());
  }
  
  private static SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = gf.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw ff.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public int a()
  {
    return this.z;
  }
  
  public e a(x paramx)
  {
    return w.a(this, paramx, false);
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
  
  public m g()
  {
    return this.k;
  }
  
  fl h()
  {
    c localc = this.l;
    if (localc != null) {
      return localc.a;
    }
    return this.m;
  }
  
  public o i()
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
  
  public g m()
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
  
  public j p()
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
  
  public n t()
  {
    return this.c;
  }
  
  public List<Protocol> u()
  {
    return this.e;
  }
  
  public List<k> v()
  {
    return this.f;
  }
  
  public List<t> w()
  {
    return this.g;
  }
  
  public List<t> x()
  {
    return this.h;
  }
  
  public p.a y()
  {
    return this.i;
  }
  
  public static final class a
  {
    int A = 0;
    n a = new n();
    @Nullable
    Proxy b;
    List<Protocol> c = v.a;
    List<k> d = v.b;
    final List<t> e = new ArrayList();
    final List<t> f = new ArrayList();
    p.a g = p.a(p.a);
    ProxySelector h = ProxySelector.getDefault();
    m i = m.a;
    @Nullable
    c j;
    @Nullable
    fl k;
    SocketFactory l = SocketFactory.getDefault();
    @Nullable
    SSLSocketFactory m;
    @Nullable
    gi n;
    HostnameVerifier o = gj.a;
    g p = g.a;
    b q = b.a;
    b r = b.a;
    j s = new j();
    o t = o.a;
    boolean u = true;
    boolean v = true;
    boolean w = true;
    int x = 10000;
    int y = 10000;
    int z = 10000;
    
    public a a(long paramLong, TimeUnit paramTimeUnit)
    {
      this.x = ff.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public v a()
    {
      return new v(this);
    }
    
    public a b(long paramLong, TimeUnit paramTimeUnit)
    {
      this.y = ff.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a c(long paramLong, TimeUnit paramTimeUnit)
    {
      this.z = ff.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.v
 * JD-Core Version:    0.7.0.1
 */