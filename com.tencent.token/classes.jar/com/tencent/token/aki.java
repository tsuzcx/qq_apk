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

public class aki
  implements Cloneable
{
  static final List<akj> a = akt.a(new akj[] { akj.d, akj.b });
  static final List<ajx> b = akt.a(new ajx[] { ajx.b, ajx.d });
  final int A;
  final int B;
  public final int C;
  final aka c;
  @Nullable
  public final Proxy d;
  public final List<akj> e;
  public final List<ajx> f;
  final List<akg> g;
  final List<akg> h;
  final akc.a i;
  public final ProxySelector j;
  public final ajz k;
  @Nullable
  final ajq l;
  @Nullable
  final aky m;
  public final SocketFactory n;
  @Nullable
  public final SSLSocketFactory o;
  @Nullable
  final amq p;
  public final HostnameVerifier q;
  public final aju r;
  public final ajp s;
  final ajp t;
  public final ajw u;
  public final akb v;
  public final boolean w;
  public final boolean x;
  public final boolean y;
  final int z;
  
  static
  {
    akr.a = new akr()
    {
      public final int a(akn.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public final alb a(ajw paramAnonymousajw, ajo paramAnonymousajo, alf paramAnonymousalf, akp paramAnonymousakp)
      {
        if ((!ajw.g) && (!Thread.holdsLock(paramAnonymousajw))) {
          throw new AssertionError();
        }
        paramAnonymousajw = paramAnonymousajw.d.iterator();
        while (paramAnonymousajw.hasNext())
        {
          alb localalb = (alb)paramAnonymousajw.next();
          if (localalb.a(paramAnonymousajo, paramAnonymousakp))
          {
            paramAnonymousalf.a(localalb, true);
            return localalb;
          }
        }
        return null;
      }
      
      public final alc a(ajw paramAnonymousajw)
      {
        return paramAnonymousajw.e;
      }
      
      public final Socket a(ajw paramAnonymousajw, ajo paramAnonymousajo, alf paramAnonymousalf)
      {
        if ((!ajw.g) && (!Thread.holdsLock(paramAnonymousajw))) {
          throw new AssertionError();
        }
        Object localObject = paramAnonymousajw.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramAnonymousajw = (alb)((Iterator)localObject).next();
          if ((paramAnonymousajw.a(paramAnonymousajo, null)) && (paramAnonymousajw.a()) && (paramAnonymousajw != paramAnonymousalf.b()))
          {
            if ((!alf.h) && (!Thread.holdsLock(paramAnonymousalf.c))) {
              throw new AssertionError();
            }
            if ((paramAnonymousalf.g == null) && (paramAnonymousalf.f.j.size() == 1))
            {
              paramAnonymousajo = (Reference)paramAnonymousalf.f.j.get(0);
              localObject = paramAnonymousalf.a(true, false, false);
              paramAnonymousalf.f = paramAnonymousajw;
              paramAnonymousajw.j.add(paramAnonymousajo);
              return localObject;
            }
            throw new IllegalStateException();
          }
        }
        return null;
      }
      
      public final void a(ajx paramAnonymousajx, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (paramAnonymousajx.g != null) {
          arrayOfString1 = akt.a(ajv.a, paramAnonymousSSLSocket.getEnabledCipherSuites(), paramAnonymousajx.g);
        } else {
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
        }
        String[] arrayOfString2;
        if (paramAnonymousajx.h != null) {
          arrayOfString2 = akt.a(akt.h, paramAnonymousSSLSocket.getEnabledProtocols(), paramAnonymousajx.h);
        } else {
          arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols();
        }
        String[] arrayOfString4 = paramAnonymousSSLSocket.getSupportedCipherSuites();
        int i = akt.a(ajv.a, arrayOfString4, "TLS_FALLBACK_SCSV");
        String[] arrayOfString3 = arrayOfString1;
        if (paramAnonymousBoolean)
        {
          arrayOfString3 = arrayOfString1;
          if (i != -1) {
            arrayOfString3 = akt.a(arrayOfString1, arrayOfString4[i]);
          }
        }
        paramAnonymousajx = new ajx.a(paramAnonymousajx).a(arrayOfString3).b(arrayOfString2).b();
        if (paramAnonymousajx.h != null) {
          paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousajx.h);
        }
        if (paramAnonymousajx.g != null) {
          paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousajx.g);
        }
      }
      
      public final void a(ake.a paramAnonymousa, String paramAnonymousString)
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
      
      public final void a(ake.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.a(paramAnonymousString1, paramAnonymousString2);
      }
      
      public final boolean a(ajo paramAnonymousajo1, ajo paramAnonymousajo2)
      {
        return paramAnonymousajo1.a(paramAnonymousajo2);
      }
      
      public final boolean a(ajw paramAnonymousajw, alb paramAnonymousalb)
      {
        if ((!ajw.g) && (!Thread.holdsLock(paramAnonymousajw))) {
          throw new AssertionError();
        }
        if ((!paramAnonymousalb.g) && (paramAnonymousajw.b != 0))
        {
          paramAnonymousajw.notifyAll();
          return false;
        }
        paramAnonymousajw.d.remove(paramAnonymousalb);
        return true;
      }
      
      public final void b(ajw paramAnonymousajw, alb paramAnonymousalb)
      {
        if ((!ajw.g) && (!Thread.holdsLock(paramAnonymousajw))) {
          throw new AssertionError();
        }
        if (!paramAnonymousajw.f)
        {
          paramAnonymousajw.f = true;
          ajw.a.execute(paramAnonymousajw.c);
        }
        paramAnonymousajw.d.add(paramAnonymousalb);
      }
    };
  }
  
  public aki()
  {
    this(new a());
  }
  
  public aki(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = akt.a(parama.e);
    this.h = akt.a(parama.f);
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
      localObject2 = (ajx)((Iterator)localObject1).next();
      if ((i1 == 0) && (!((ajx)localObject2).e)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    if ((parama.m == null) && (i1 != 0))
    {
      localObject1 = akt.a();
      this.o = a((X509TrustManager)localObject1);
      this.p = amn.c().a((X509TrustManager)localObject1);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      amn.c().a(this.o);
    }
    this.q = parama.o;
    localObject1 = parama.p;
    Object localObject2 = this.p;
    if (!akt.a(((aju)localObject1).c, localObject2)) {
      localObject1 = new aju(((aju)localObject1).b, (amq)localObject2);
    }
    this.r = ((aju)localObject1);
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
      SSLContext localSSLContext = amn.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw akt.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public static final class a
  {
    int A = 0;
    aka a = new aka();
    @Nullable
    Proxy b;
    List<akj> c = aki.a;
    List<ajx> d = aki.b;
    final List<akg> e = new ArrayList();
    final List<akg> f = new ArrayList();
    akc.a g = akc.a(akc.a);
    ProxySelector h = ProxySelector.getDefault();
    ajz i = ajz.a;
    @Nullable
    ajq j;
    @Nullable
    aky k;
    SocketFactory l = SocketFactory.getDefault();
    @Nullable
    SSLSocketFactory m;
    @Nullable
    amq n;
    HostnameVerifier o = amr.a;
    aju p = aju.a;
    ajp q = ajp.a;
    ajp r = ajp.a;
    ajw s = new ajw();
    akb t = akb.a;
    boolean u = true;
    boolean v = true;
    boolean w = true;
    public int x = 10000;
    public int y = 10000;
    public int z = 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aki
 * JD-Core Version:    0.7.0.1
 */