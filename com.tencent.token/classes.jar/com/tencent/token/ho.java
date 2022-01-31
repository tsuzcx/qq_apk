package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.ak;
import okhttp3.ap;
import okhttp3.at;
import okhttp3.au;
import okhttp3.av;
import okhttp3.ax;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.g;
import okio.h;
import okio.i;
import okio.l;
import okio.o;
import okio.x;
import okio.z;

public final class ho
  implements hd
{
  final ak a;
  final g b;
  final i c;
  final h d;
  int e = 0;
  private long f = 262144L;
  
  public ho(ak paramak, g paramg, i parami, h paramh)
  {
    this.a = paramak;
    this.b = paramg;
    this.c = parami;
    this.d = paramh;
  }
  
  private String f()
  {
    String str = this.c.e(this.f);
    this.f -= str.length();
    return str;
  }
  
  public au a(boolean paramBoolean)
  {
    if ((this.e != 1) && (this.e != 3)) {
      throw new IllegalStateException("state: " + this.e);
    }
    Object localObject;
    try
    {
      hm localhm = hm.a(f());
      localObject = new au().a(localhm.a).a(localhm.b).a(localhm.c).a(c());
      if ((paramBoolean) && (localhm.b == 100)) {
        return null;
      }
      if (localhm.b == 100)
      {
        this.e = 3;
        return localObject;
      }
    }
    catch (EOFException localEOFException)
    {
      localObject = new IOException("unexpected end of stream on " + this.b);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
    this.e = 4;
    return localObject;
  }
  
  public av a(at paramat)
  {
    this.b.c.f(this.b.b);
    String str = paramat.a("Content-Type");
    if (!hg.b(paramat)) {
      return new hj(str, 0L, o.a(b(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramat.a("Transfer-Encoding"))) {
      return new hj(str, -1L, o.a(a(paramat.a().a())));
    }
    long l = hg.a(paramat);
    if (l != -1L) {
      return new hj(str, l, o.a(b(l)));
    }
    return new hj(str, -1L, o.a(e()));
  }
  
  public x a(long paramLong)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new ht(this, paramLong);
  }
  
  public x a(ap paramap, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramap.a("Transfer-Encoding"))) {
      return d();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public okio.y a(af paramaf)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new hs(this, paramaf);
  }
  
  public void a()
  {
    this.d.flush();
  }
  
  public void a(ad paramad, String paramString)
  {
    if (this.e != 0) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.d.b(paramString).b("\r\n");
    int i = 0;
    int j = paramad.a();
    while (i < j)
    {
      this.d.b(paramad.a(i)).b(": ").b(paramad.b(i)).b("\r\n");
      i += 1;
    }
    this.d.b("\r\n");
    this.e = 1;
  }
  
  public void a(ap paramap)
  {
    String str = hk.a(paramap, this.b.c().a().b().type());
    a(paramap.c(), str);
  }
  
  void a(l paraml)
  {
    z localz = paraml.a();
    paraml.a(z.c);
    localz.f();
    localz.e_();
  }
  
  public okio.y b(long paramLong)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new hu(this, paramLong);
  }
  
  public void b()
  {
    this.d.flush();
  }
  
  public ad c()
  {
    ae localae = new ae();
    for (;;)
    {
      String str = f();
      if (str.length() == 0) {
        break;
      }
      gl.a.a(localae, str);
    }
    return localae.a();
  }
  
  public x d()
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new hr(this);
  }
  
  public okio.y e()
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    if (this.b == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.e = 5;
    this.b.e();
    return new hv(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ho
 * JD-Core Version:    0.7.0.1
 */