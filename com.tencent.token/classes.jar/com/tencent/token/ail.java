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

public class ail
  implements Cloneable
{
  static final List<aim> a = aiw.a(new aim[] { aim.d, aim.b });
  static final List<aia> b = aiw.a(new aia[] { aia.b, aia.d });
  final int A;
  final int B;
  public final int C;
  final aid c;
  @Nullable
  public final Proxy d;
  public final List<aim> e;
  public final List<aia> f;
  final List<aij> g;
  final List<aij> h;
  final aif.a i;
  public final ProxySelector j;
  public final aic k;
  @Nullable
  final aht l;
  @Nullable
  final ajb m;
  public final SocketFactory n;
  @Nullable
  public final SSLSocketFactory o;
  @Nullable
  final akt p;
  public final HostnameVerifier q;
  public final ahx r;
  public final ahs s;
  final ahs t;
  public final ahz u;
  public final aie v;
  public final boolean w;
  public final boolean x;
  public final boolean y;
  final int z;
  
  static
  {
    aiu.a = new aiu()
    {
      public final int a(aiq.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public final aje a(ahz paramAnonymousahz, ahr paramAnonymousahr, aji paramAnonymousaji, ais paramAnonymousais)
      {
        if ((!ahz.g) && (!Thread.holdsLock(paramAnonymousahz))) {
          throw new AssertionError();
        }
        paramAnonymousahz = paramAnonymousahz.d.iterator();
        while (paramAnonymousahz.hasNext())
        {
          aje localaje = (aje)paramAnonymousahz.next();
          if (localaje.a(paramAnonymousahr, paramAnonymousais))
          {
            paramAnonymousaji.a(localaje, true);
            return localaje;
          }
        }
        return null;
      }
      
      public final ajf a(ahz paramAnonymousahz)
      {
        return paramAnonymousahz.e;
      }
      
      public final Socket a(ahz paramAnonymousahz, ahr paramAnonymousahr, aji paramAnonymousaji)
      {
        if ((!ahz.g) && (!Thread.holdsLock(paramAnonymousahz))) {
          throw new AssertionError();
        }
        Object localObject = paramAnonymousahz.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramAnonymousahz = (aje)((Iterator)localObject).next();
          if ((paramAnonymousahz.a(paramAnonymousahr, null)) && (paramAnonymousahz.a()) && (paramAnonymousahz != paramAnonymousaji.b()))
          {
            if ((!aji.h) && (!Thread.holdsLock(paramAnonymousaji.c))) {
              throw new AssertionError();
            }
            if ((paramAnonymousaji.g == null) && (paramAnonymousaji.f.j.size() == 1))
            {
              paramAnonymousahr = (Reference)paramAnonymousaji.f.j.get(0);
              localObject = paramAnonymousaji.a(true, false, false);
              paramAnonymousaji.f = paramAnonymousahz;
              paramAnonymousahz.j.add(paramAnonymousahr);
              return localObject;
            }
            throw new IllegalStateException();
          }
        }
        return null;
      }
      
      public final void a(aia paramAnonymousaia, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (paramAnonymousaia.g != null) {
          arrayOfString1 = aiw.a(ahy.a, paramAnonymousSSLSocket.getEnabledCipherSuites(), paramAnonymousaia.g);
        } else {
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
        }
        String[] arrayOfString2;
        if (paramAnonymousaia.h != null) {
          arrayOfString2 = aiw.a(aiw.h, paramAnonymousSSLSocket.getEnabledProtocols(), paramAnonymousaia.h);
        } else {
          arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols();
        }
        String[] arrayOfString4 = paramAnonymousSSLSocket.getSupportedCipherSuites();
        int i = aiw.a(ahy.a, arrayOfString4, "TLS_FALLBACK_SCSV");
        String[] arrayOfString3 = arrayOfString1;
        if (paramAnonymousBoolean)
        {
          arrayOfString3 = arrayOfString1;
          if (i != -1) {
            arrayOfString3 = aiw.a(arrayOfString1, arrayOfString4[i]);
          }
        }
        paramAnonymousaia = new aia.a(paramAnonymousaia).a(arrayOfString3).b(arrayOfString2).b();
        if (paramAnonymousaia.h != null) {
          paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousaia.h);
        }
        if (paramAnonymousaia.g != null) {
          paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousaia.g);
        }
      }
      
      public final void a(aih.a paramAnonymousa, String paramAnonymousString)
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
      
      public final void a(aih.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.a(paramAnonymousString1, paramAnonymousString2);
      }
      
      public final boolean a(ahr paramAnonymousahr1, ahr paramAnonymousahr2)
      {
        return paramAnonymousahr1.a(paramAnonymousahr2);
      }
      
      public final boolean a(ahz paramAnonymousahz, aje paramAnonymousaje)
      {
        if ((!ahz.g) && (!Thread.holdsLock(paramAnonymousahz))) {
          throw new AssertionError();
        }
        if ((!paramAnonymousaje.g) && (paramAnonymousahz.b != 0))
        {
          paramAnonymousahz.notifyAll();
          return false;
        }
        paramAnonymousahz.d.remove(paramAnonymousaje);
        return true;
      }
      
      public final void b(ahz paramAnonymousahz, aje paramAnonymousaje)
      {
        if ((!ahz.g) && (!Thread.holdsLock(paramAnonymousahz))) {
          throw new AssertionError();
        }
        if (!paramAnonymousahz.f)
        {
          paramAnonymousahz.f = true;
          ahz.a.execute(paramAnonymousahz.c);
        }
        paramAnonymousahz.d.add(paramAnonymousaje);
      }
    };
  }
  
  public ail()
  {
    this(new a());
  }
  
  public ail(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = aiw.a(parama.e);
    this.h = aiw.a(parama.f);
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
      localObject2 = (aia)((Iterator)localObject1).next();
      if ((i1 == 0) && (!((aia)localObject2).e)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    if ((parama.m == null) && (i1 != 0))
    {
      localObject1 = aiw.a();
      this.o = a((X509TrustManager)localObject1);
      this.p = akq.c().a((X509TrustManager)localObject1);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      akq.c().a(this.o);
    }
    this.q = parama.o;
    localObject1 = parama.p;
    Object localObject2 = this.p;
    if (!aiw.a(((ahx)localObject1).c, localObject2)) {
      localObject1 = new ahx(((ahx)localObject1).b, (akt)localObject2);
    }
    this.r = ((ahx)localObject1);
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
      SSLContext localSSLContext = akq.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw aiw.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public static final class a
  {
    int A = 0;
    aid a = new aid();
    @Nullable
    Proxy b;
    List<aim> c = ail.a;
    List<aia> d = ail.b;
    final List<aij> e = new ArrayList();
    final List<aij> f = new ArrayList();
    aif.a g = aif.a(aif.a);
    ProxySelector h = ProxySelector.getDefault();
    aic i = aic.a;
    @Nullable
    aht j;
    @Nullable
    ajb k;
    SocketFactory l = SocketFactory.getDefault();
    @Nullable
    SSLSocketFactory m;
    @Nullable
    akt n;
    HostnameVerifier o = aku.a;
    ahx p = ahx.a;
    ahs q = ahs.a;
    ahs r = ahs.a;
    ahz s = new ahz();
    aie t = aie.a;
    boolean u = true;
    boolean v = true;
    boolean w = true;
    public int x = 10000;
    public int y = 10000;
    public int z = 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ail
 * JD-Core Version:    0.7.0.1
 */