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

public class alg
  implements Cloneable
{
  static final List<alh> a = alr.a(new alh[] { alh.d, alh.b });
  static final List<akv> b = alr.a(new akv[] { akv.b, akv.d });
  final int A;
  final int B;
  public final int C;
  final aky c;
  @Nullable
  public final Proxy d;
  public final List<alh> e;
  public final List<akv> f;
  final List<ale> g;
  final List<ale> h;
  final ala.a i;
  public final ProxySelector j;
  public final akx k;
  @Nullable
  final ako l;
  @Nullable
  final alw m;
  public final SocketFactory n;
  @Nullable
  public final SSLSocketFactory o;
  @Nullable
  final ano p;
  public final HostnameVerifier q;
  public final aks r;
  public final akn s;
  final akn t;
  public final aku u;
  public final akz v;
  public final boolean w;
  public final boolean x;
  public final boolean y;
  final int z;
  
  static
  {
    alp.a = new alp()
    {
      public final int a(all.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public final alz a(aku paramAnonymousaku, akm paramAnonymousakm, amd paramAnonymousamd, aln paramAnonymousaln)
      {
        if ((!aku.g) && (!Thread.holdsLock(paramAnonymousaku))) {
          throw new AssertionError();
        }
        paramAnonymousaku = paramAnonymousaku.d.iterator();
        while (paramAnonymousaku.hasNext())
        {
          alz localalz = (alz)paramAnonymousaku.next();
          if (localalz.a(paramAnonymousakm, paramAnonymousaln))
          {
            paramAnonymousamd.a(localalz, true);
            return localalz;
          }
        }
        return null;
      }
      
      public final ama a(aku paramAnonymousaku)
      {
        return paramAnonymousaku.e;
      }
      
      public final Socket a(aku paramAnonymousaku, akm paramAnonymousakm, amd paramAnonymousamd)
      {
        if ((!aku.g) && (!Thread.holdsLock(paramAnonymousaku))) {
          throw new AssertionError();
        }
        Object localObject = paramAnonymousaku.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramAnonymousaku = (alz)((Iterator)localObject).next();
          if ((paramAnonymousaku.a(paramAnonymousakm, null)) && (paramAnonymousaku.a()) && (paramAnonymousaku != paramAnonymousamd.b()))
          {
            if ((!amd.h) && (!Thread.holdsLock(paramAnonymousamd.c))) {
              throw new AssertionError();
            }
            if ((paramAnonymousamd.g == null) && (paramAnonymousamd.f.j.size() == 1))
            {
              paramAnonymousakm = (Reference)paramAnonymousamd.f.j.get(0);
              localObject = paramAnonymousamd.a(true, false, false);
              paramAnonymousamd.f = paramAnonymousaku;
              paramAnonymousaku.j.add(paramAnonymousakm);
              return localObject;
            }
            throw new IllegalStateException();
          }
        }
        return null;
      }
      
      public final void a(akv paramAnonymousakv, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (paramAnonymousakv.g != null) {
          arrayOfString1 = alr.a(akt.a, paramAnonymousSSLSocket.getEnabledCipherSuites(), paramAnonymousakv.g);
        } else {
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
        }
        String[] arrayOfString2;
        if (paramAnonymousakv.h != null) {
          arrayOfString2 = alr.a(alr.h, paramAnonymousSSLSocket.getEnabledProtocols(), paramAnonymousakv.h);
        } else {
          arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols();
        }
        String[] arrayOfString4 = paramAnonymousSSLSocket.getSupportedCipherSuites();
        int i = alr.a(akt.a, arrayOfString4, "TLS_FALLBACK_SCSV");
        String[] arrayOfString3 = arrayOfString1;
        if (paramAnonymousBoolean)
        {
          arrayOfString3 = arrayOfString1;
          if (i != -1) {
            arrayOfString3 = alr.a(arrayOfString1, arrayOfString4[i]);
          }
        }
        paramAnonymousakv = new akv.a(paramAnonymousakv).a(arrayOfString3).b(arrayOfString2).b();
        if (paramAnonymousakv.h != null) {
          paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousakv.h);
        }
        if (paramAnonymousakv.g != null) {
          paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousakv.g);
        }
      }
      
      public final void a(alc.a paramAnonymousa, String paramAnonymousString)
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
      
      public final void a(alc.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.a(paramAnonymousString1, paramAnonymousString2);
      }
      
      public final boolean a(akm paramAnonymousakm1, akm paramAnonymousakm2)
      {
        return paramAnonymousakm1.a(paramAnonymousakm2);
      }
      
      public final boolean a(aku paramAnonymousaku, alz paramAnonymousalz)
      {
        if ((!aku.g) && (!Thread.holdsLock(paramAnonymousaku))) {
          throw new AssertionError();
        }
        if ((!paramAnonymousalz.g) && (paramAnonymousaku.b != 0))
        {
          paramAnonymousaku.notifyAll();
          return false;
        }
        paramAnonymousaku.d.remove(paramAnonymousalz);
        return true;
      }
      
      public final void b(aku paramAnonymousaku, alz paramAnonymousalz)
      {
        if ((!aku.g) && (!Thread.holdsLock(paramAnonymousaku))) {
          throw new AssertionError();
        }
        if (!paramAnonymousaku.f)
        {
          paramAnonymousaku.f = true;
          aku.a.execute(paramAnonymousaku.c);
        }
        paramAnonymousaku.d.add(paramAnonymousalz);
      }
    };
  }
  
  public alg()
  {
    this(new a());
  }
  
  public alg(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = alr.a(parama.e);
    this.h = alr.a(parama.f);
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
      localObject2 = (akv)((Iterator)localObject1).next();
      if ((i1 == 0) && (!((akv)localObject2).e)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    if ((parama.m == null) && (i1 != 0))
    {
      localObject1 = alr.a();
      this.o = a((X509TrustManager)localObject1);
      this.p = anl.c().a((X509TrustManager)localObject1);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      anl.c().a(this.o);
    }
    this.q = parama.o;
    localObject1 = parama.p;
    Object localObject2 = this.p;
    if (!alr.a(((aks)localObject1).c, localObject2)) {
      localObject1 = new aks(((aks)localObject1).b, (ano)localObject2);
    }
    this.r = ((aks)localObject1);
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
      SSLContext localSSLContext = anl.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw alr.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public static final class a
  {
    int A = 0;
    aky a = new aky();
    @Nullable
    Proxy b;
    List<alh> c = alg.a;
    List<akv> d = alg.b;
    final List<ale> e = new ArrayList();
    final List<ale> f = new ArrayList();
    ala.a g = ala.a(ala.a);
    ProxySelector h = ProxySelector.getDefault();
    akx i = akx.a;
    @Nullable
    ako j;
    @Nullable
    alw k;
    SocketFactory l = SocketFactory.getDefault();
    @Nullable
    SSLSocketFactory m;
    @Nullable
    ano n;
    HostnameVerifier o = anp.a;
    aks p = aks.a;
    akn q = akn.a;
    akn r = akn.a;
    aku s = new aku();
    akz t = akz.a;
    boolean u = true;
    boolean v = true;
    boolean w = true;
    public int x = 10000;
    public int y = 10000;
    public int z = 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alg
 * JD-Core Version:    0.7.0.1
 */