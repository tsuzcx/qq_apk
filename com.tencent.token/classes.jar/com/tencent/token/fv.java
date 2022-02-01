package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.internal.connection.f;
import okhttp3.r.a;
import okhttp3.s;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;
import okio.d;
import okio.e;
import okio.h;
import okio.k;
import okio.q;

public final class fv
  implements fl
{
  final v a;
  final f b;
  final e c;
  final d d;
  int e = 0;
  private long f = 262144L;
  
  public fv(v paramv, f paramf, e parame, d paramd)
  {
    this.a = paramv;
    this.b = paramf;
    this.c = parame;
    this.d = paramd;
  }
  
  private String f()
  {
    String str = this.c.e(this.f);
    this.f -= str.length();
    return str;
  }
  
  public aa a(z paramz)
  {
    this.b.c.f(this.b.b);
    String str = paramz.a("Content-Type");
    if (!fn.b(paramz)) {
      return new fq(str, 0L, k.a(b(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramz.a("Transfer-Encoding"))) {
      return new fq(str, -1L, k.a(a(paramz.a().a())));
    }
    long l = fn.a(paramz);
    if (l != -1L) {
      return new fq(str, l, k.a(b(l)));
    }
    return new fq(str, -1L, k.a(e()));
  }
  
  public z.a a(boolean paramBoolean)
  {
    if ((this.e != 1) && (this.e != 3)) {
      throw new IllegalStateException("state: " + this.e);
    }
    Object localObject;
    try
    {
      ft localft = ft.a(f());
      localObject = new z.a().a(localft.a).a(localft.b).a(localft.c).a(c());
      if ((paramBoolean) && (localft.b == 100)) {
        return null;
      }
      if (localft.b == 100)
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
  
  public okio.p a(long paramLong)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new d(paramLong);
  }
  
  public okio.p a(x paramx, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramx.a("Transfer-Encoding"))) {
      return d();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public q a(s params)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new c(params);
  }
  
  public void a()
  {
    this.d.flush();
  }
  
  public void a(okhttp3.r paramr, String paramString)
  {
    if (this.e != 0) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.d.b(paramString).b("\r\n");
    int i = 0;
    int j = paramr.a();
    while (i < j)
    {
      this.d.b(paramr.a(i)).b(": ").b(paramr.b(i)).b("\r\n");
      i += 1;
    }
    this.d.b("\r\n");
    this.e = 1;
  }
  
  public void a(x paramx)
  {
    String str = fr.a(paramx, this.b.c().a().b().type());
    a(paramx.c(), str);
  }
  
  void a(h paramh)
  {
    okio.r localr = paramh.a();
    paramh.a(okio.r.c);
    localr.f();
    localr.e_();
  }
  
  public q b(long paramLong)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new e(paramLong);
  }
  
  public void b()
  {
    this.d.flush();
  }
  
  public okhttp3.r c()
  {
    r.a locala = new r.a();
    for (;;)
    {
      String str = f();
      if (str.length() == 0) {
        break;
      }
      fa.a.a(locala, str);
    }
    return locala.a();
  }
  
  public okio.p d()
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new b();
  }
  
  public q e()
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    if (this.b == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.e = 5;
    this.b.e();
    return new f();
  }
  
  private abstract class a
    implements q
  {
    protected final h a = new h(fv.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(okio.c paramc, long paramLong)
    {
      try
      {
        paramLong = fv.this.c.a(paramc, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramc)
      {
        a(false, paramc);
        throw paramc;
      }
    }
    
    public okio.r a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean, IOException paramIOException)
    {
      if (fv.this.e == 6) {}
      do
      {
        return;
        if (fv.this.e != 5) {
          throw new IllegalStateException("state: " + fv.this.e);
        }
        fv.this.a(this.a);
        fv.this.e = 6;
      } while (fv.this.b == null);
      f localf = fv.this.b;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localf.a(paramBoolean, fv.this, this.c, paramIOException);
        return;
      }
    }
  }
  
  private final class b
    implements okio.p
  {
    private final h b = new h(fv.this.d.a());
    private boolean c;
    
    b() {}
    
    public okio.r a()
    {
      return this.b;
    }
    
    public void a_(okio.c paramc, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      fv.this.d.k(paramLong);
      fv.this.d.b("\r\n");
      fv.this.d.a_(paramc, paramLong);
      fv.this.d.b("\r\n");
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 42	com/tencent/token/fv$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 42	com/tencent/token/fv$b:c	Z
      //   19: aload_0
      //   20: getfield 18	com/tencent/token/fv$b:a	Lcom/tencent/token/fv;
      //   23: getfield 27	com/tencent/token/fv:d	Lokio/d;
      //   26: ldc 63
      //   28: invokeinterface 58 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 18	com/tencent/token/fv$b:a	Lcom/tencent/token/fv;
      //   38: aload_0
      //   39: getfield 37	com/tencent/token/fv$b:b	Lokio/h;
      //   42: invokevirtual 66	com/tencent/token/fv:a	(Lokio/h;)V
      //   45: aload_0
      //   46: getfield 18	com/tencent/token/fv$b:a	Lcom/tencent/token/fv;
      //   49: iconst_3
      //   50: putfield 70	com/tencent/token/fv:e	I
      //   53: goto -42 -> 11
      //   56: astore_2
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	b
      //   6	2	1	bool	boolean
      //   56	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	56	finally
      //   14	53	56	finally
    }
    
    /* Error */
    public void flush()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 42	com/tencent/token/fv$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 18	com/tencent/token/fv$b:a	Lcom/tencent/token/fv;
      //   18: getfield 27	com/tencent/token/fv:d	Lokio/d;
      //   21: invokeinterface 73 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	b
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
  }
  
  private class c
    extends fv.a
  {
    private final s f;
    private long g = -1L;
    private boolean h = true;
    
    c(s params)
    {
      super(null);
      this.f = params;
    }
    
    private void b()
    {
      if (this.g != -1L) {
        fv.this.c.p();
      }
      try
      {
        this.g = fv.this.c.m();
        String str = fv.this.c.p().trim();
        if ((this.g < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.g == 0L)
      {
        this.h = false;
        fn.a(fv.this.a.g(), this.f, fv.this.c());
        a(true, null);
      }
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (!this.h) {}
      do
      {
        return -1L;
        if ((this.g != 0L) && (this.g != -1L)) {
          break;
        }
        b();
      } while (!this.h);
      paramLong = super.a(paramc, Math.min(paramLong, this.g));
      if (paramLong == -1L)
      {
        paramc = new ProtocolException("unexpected end of stream");
        a(false, paramc);
        throw paramc;
      }
      this.g -= paramLong;
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.h) && (!fc.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
  }
  
  private final class d
    implements okio.p
  {
    private final h b = new h(fv.this.d.a());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public okio.r a()
    {
      return this.b;
    }
    
    public void a_(okio.c paramc, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      fc.a(paramc.b(), 0L, paramLong);
      if (paramLong > this.d) {
        throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
      }
      fv.this.d.a_(paramc, paramLong);
      this.d -= paramLong;
    }
    
    public void close()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      fv.this.a(this.b);
      fv.this.e = 3;
    }
    
    public void flush()
    {
      if (this.c) {
        return;
      }
      fv.this.d.flush();
    }
  }
  
  private class e
    extends fv.a
  {
    private long f;
    
    e(long paramLong)
    {
      super(null);
      this.f = paramLong;
      if (this.f == 0L) {
        a(true, null);
      }
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.f == 0L) {
        return -1L;
      }
      paramLong = super.a(paramc, Math.min(this.f, paramLong));
      if (paramLong == -1L)
      {
        paramc = new ProtocolException("unexpected end of stream");
        a(false, paramc);
        throw paramc;
      }
      this.f -= paramLong;
      if (this.f == 0L) {
        a(true, null);
      }
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.f != 0L) && (!fc.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
  }
  
  private class f
    extends fv.a
  {
    private boolean f;
    
    f()
    {
      super(null);
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.f) {
        return -1L;
      }
      paramLong = super.a(paramc, paramLong);
      if (paramLong == -1L)
      {
        this.f = true;
        a(true, null);
        return -1L;
      }
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if (!this.f) {
        a(false, null);
      }
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fv
 * JD-Core Version:    0.7.0.1
 */