package com.tencent.token;

import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class aim
  implements Cloneable
{
  static final List<ain> a = aix.a(new ain[] { ain.d, ain.b });
  static final List<aib> b = aix.a(new aib[] { aib.b, aib.d });
  final int A;
  final int B;
  public final int C;
  final aie c;
  @Nullable
  public final Proxy d;
  public final List<ain> e;
  public final List<aib> f;
  final List<aik> g;
  final List<aik> h;
  final aig.a i;
  public final ProxySelector j;
  public final aid k;
  @Nullable
  final ahu l;
  @Nullable
  final ajc m;
  public final SocketFactory n;
  @Nullable
  public final SSLSocketFactory o;
  @Nullable
  final aku p;
  public final HostnameVerifier q;
  public final ahy r;
  public final aht s;
  final aht t;
  public final aia u;
  public final aif v;
  public final boolean w;
  public final boolean x;
  public final boolean y;
  final int z;
  
  static
  {
    aiv.a = new aiv()
    {
      public final int a(air.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public final ajf a(aia paramAnonymousaia, ahs paramAnonymousahs, ajj paramAnonymousajj, ait paramAnonymousait)
      {
        if ((!aia.g) && (!Thread.holdsLock(paramAnonymousaia))) {
          throw new AssertionError();
        }
        paramAnonymousaia = paramAnonymousaia.d.iterator();
        while (paramAnonymousaia.hasNext())
        {
          ajf localajf = (ajf)paramAnonymousaia.next();
          if (localajf.a(paramAnonymousahs, paramAnonymousait))
          {
            paramAnonymousajj.a(localajf, true);
            return localajf;
          }
        }
        return null;
      }
      
      public final ajg a(aia paramAnonymousaia)
      {
        return paramAnonymousaia.e;
      }
      
      public final Socket a(aia paramAnonymousaia, ahs paramAnonymousahs, ajj paramAnonymousajj)
      {
        if ((!aia.g) && (!Thread.holdsLock(paramAnonymousaia))) {
          throw new AssertionError();
        }
        Object localObject = paramAnonymousaia.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramAnonymousaia = (ajf)((Iterator)localObject).next();
          if ((paramAnonymousaia.a(paramAnonymousahs, null)) && (paramAnonymousaia.a()) && (paramAnonymousaia != paramAnonymousajj.b()))
          {
            if ((!ajj.h) && (!Thread.holdsLock(paramAnonymousajj.c))) {
              throw new AssertionError();
            }
            if ((paramAnonymousajj.g == null) && (paramAnonymousajj.f.j.size() == 1))
            {
              paramAnonymousahs = (Reference)paramAnonymousajj.f.j.get(0);
              localObject = paramAnonymousajj.a(true, false, false);
              paramAnonymousajj.f = paramAnonymousaia;
              paramAnonymousaia.j.add(paramAnonymousahs);
              return localObject;
            }
            throw new IllegalStateException();
          }
        }
        return null;
      }
      
      public final void a(aib paramAnonymousaib, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (paramAnonymousaib.g != null) {
          arrayOfString1 = aix.a(ahz.a, paramAnonymousSSLSocket.getEnabledCipherSuites(), paramAnonymousaib.g);
        } else {
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
        }
        String[] arrayOfString2;
        if (paramAnonymousaib.h != null) {
          arrayOfString2 = aix.a(aix.h, paramAnonymousSSLSocket.getEnabledProtocols(), paramAnonymousaib.h);
        } else {
          arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols();
        }
        String[] arrayOfString4 = paramAnonymousSSLSocket.getSupportedCipherSuites();
        int i = aix.a(ahz.a, arrayOfString4, "TLS_FALLBACK_SCSV");
        String[] arrayOfString3 = arrayOfString1;
        if (paramAnonymousBoolean)
        {
          arrayOfString3 = arrayOfString1;
          if (i != -1) {
            arrayOfString3 = aix.a(arrayOfString1, arrayOfString4[i]);
          }
        }
        paramAnonymousaib = new aib.a(paramAnonymousaib).a(arrayOfString3).b(arrayOfString2).b();
        if (paramAnonymousaib.h != null) {
          paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousaib.h);
        }
        if (paramAnonymousaib.g != null) {
          paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousaib.g);
        }
      }
      
      public final void a(aii.a paramAnonymousa, String paramAnonymousString)
      {
        int i = paramAnonymousString.indexOf(":", 1);
        if (i != -1)
        {
          paramAnonymousa.a(paramAnonymousString.substring(0, i), paramAnonymousString.substring(i + 1));
          return;
        }
        if (paramAnonymousString.startsWith(":"))
        {
          paramAnonymousa.a("", paramAnonymousString.substring(1));
          return;
        }
        paramAnonymousa.a("", paramAnonymousString);
      }
      
      public final void a(aii.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.a(paramAnonymousString1, paramAnonymousString2);
      }
      
      public final boolean a(ahs paramAnonymousahs1, ahs paramAnonymousahs2)
      {
        return paramAnonymousahs1.a(paramAnonymousahs2);
      }
      
      public final boolean a(aia paramAnonymousaia, ajf paramAnonymousajf)
      {
        if ((!aia.g) && (!Thread.holdsLock(paramAnonymousaia))) {
          throw new AssertionError();
        }
        if ((!paramAnonymousajf.g) && (paramAnonymousaia.b != 0))
        {
          paramAnonymousaia.notifyAll();
          return false;
        }
        paramAnonymousaia.d.remove(paramAnonymousajf);
        return true;
      }
      
      public final void b(aia paramAnonymousaia, ajf paramAnonymousajf)
      {
        if ((!aia.g) && (!Thread.holdsLock(paramAnonymousaia))) {
          throw new AssertionError();
        }
        if (!paramAnonymousaia.f)
        {
          paramAnonymousaia.f = true;
          aia.a.execute(paramAnonymousaia.c);
        }
        paramAnonymousaia.d.add(paramAnonymousajf);
      }
    };
  }
  
  public aim()
  {
    this(new a());
  }
  
  public aim(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = aix.a(parama.e);
    this.h = aix.a(parama.f);
    this.i = parama.g;
    this.j = parama.h;
    this.k = parama.i;
    this.l = parama.j;
    this.m = parama.k;
    this.n = parama.l;
    Object localObject1 = this.f.iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aib)((Iterator)localObject1).next();
      if ((i1 == 0) && (!((aib)localObject2).e)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    if ((parama.m == null) && (i1 != 0))
    {
      localObject1 = aix.a();
      this.o = a((X509TrustManager)localObject1);
      this.p = akr.c().a((X509TrustManager)localObject1);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      akr.c().a(this.o);
    }
    this.q = parama.o;
    localObject1 = parama.p;
    Object localObject2 = this.p;
    if (!aix.a(((ahy)localObject1).c, localObject2)) {
      localObject1 = new ahy(((ahy)localObject1).b, (aku)localObject2);
    }
    this.r = ((ahy)localObject1);
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
      parama = new StringBuilder("Null network interceptor: ");
      parama.append(this.h);
      throw new IllegalStateException(parama.toString());
    }
    parama = new StringBuilder("Null interceptor: ");
    parama.append(this.g);
    throw new IllegalStateException(parama.toString());
  }
  
  private static SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = akr.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw aix.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public static final class a
  {
    int A = 0;
    aie a = new aie();
    @Nullable
    Proxy b;
    List<ain> c = aim.a;
    List<aib> d = aim.b;
    final List<aik> e = new ArrayList();
    final List<aik> f = new ArrayList();
    aig.a g = aig.a(aig.a);
    ProxySelector h = ProxySelector.getDefault();
    aid i = aid.a;
    @Nullable
    ahu j;
    @Nullable
    ajc k;
    SocketFactory l = SocketFactory.getDefault();
    @Nullable
    SSLSocketFactory m;
    @Nullable
    aku n;
    HostnameVerifier o = akv.a;
    ahy p = ahy.a;
    aht q = aht.a;
    aht r = aht.a;
    aia s = new aia();
    aif t = aif.a;
    boolean u = true;
    boolean v = true;
    boolean w = true;
    public int x = 10000;
    public int y = 10000;
    public int z = 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aim
 * JD-Core Version:    0.7.0.1
 */