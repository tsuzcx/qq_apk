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

public final class fy
  implements fo
{
  final v a;
  final f b;
  final e c;
  final d d;
  int e = 0;
  private long f = 262144L;
  
  public fy(v paramv, f paramf, e parame, d paramd)
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
    if (!fq.b(paramz)) {
      return new ft(str, 0L, k.a(b(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramz.a("Transfer-Encoding"))) {
      return new ft(str, -1L, k.a(a(paramz.a().a())));
    }
    long l = fq.a(paramz);
    if (l != -1L) {
      return new ft(str, l, k.a(b(l)));
    }
    return new ft(str, -1L, k.a(e()));
  }
  
  public z.a a(boolean paramBoolean)
  {
    int i = this.e;
    Object localObject1;
    if ((i != 1) && (i != 3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("state: ");
      ((StringBuilder)localObject1).append(this.e);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = fw.a(f());
      localObject2 = new z.a().a(((fw)localObject1).a).a(((fw)localObject1).b).a(((fw)localObject1).c).a(c());
      if ((paramBoolean) && (((fw)localObject1).b == 100)) {
        return null;
      }
      if (((fw)localObject1).b == 100)
      {
        this.e = 3;
        return localObject2;
      }
      this.e = 4;
      return localObject2;
    }
    catch (EOFException localEOFException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unexpected end of stream on ");
      ((StringBuilder)localObject2).append(this.b);
      localObject2 = new IOException(((StringBuilder)localObject2).toString());
      ((IOException)localObject2).initCause(localEOFException);
      throw ((Throwable)localObject2);
    }
  }
  
  public okio.p a(long paramLong)
  {
    if (this.e == 1)
    {
      this.e = 2;
      return new d(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
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
    if (this.e == 4)
    {
      this.e = 5;
      return new c(params);
    }
    params = new StringBuilder();
    params.append("state: ");
    params.append(this.e);
    throw new IllegalStateException(params.toString());
  }
  
  public void a()
  {
    this.d.flush();
  }
  
  public void a(okhttp3.r paramr, String paramString)
  {
    if (this.e == 0)
    {
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
      return;
    }
    paramr = new StringBuilder();
    paramr.append("state: ");
    paramr.append(this.e);
    throw new IllegalStateException(paramr.toString());
  }
  
  public void a(x paramx)
  {
    String str = fu.a(paramx, this.b.c().a().b().type());
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
    if (this.e == 4)
    {
      this.e = 5;
      return new e(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
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
      fd.a.a(locala, str);
    }
    return locala.a();
  }
  
  public okio.p d()
  {
    if (this.e == 1)
    {
      this.e = 2;
      return new b();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public q e()
  {
    if (this.e == 4)
    {
      localObject = this.b;
      if (localObject != null)
      {
        this.e = 5;
        ((f)localObject).e();
        return new f();
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state: ");
    ((StringBuilder)localObject).append(this.e);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private abstract class a
    implements q
  {
    protected final h a = new h(fy.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(okio.c paramc, long paramLong)
    {
      try
      {
        paramLong = fy.this.c.a(paramc, paramLong);
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
      if (fy.this.e == 6) {
        return;
      }
      if (fy.this.e == 5)
      {
        fy.this.a(this.a);
        fy localfy = fy.this;
        localfy.e = 6;
        if (localfy.b != null) {
          fy.this.b.a(paramBoolean ^ true, fy.this, this.c, paramIOException);
        }
        return;
      }
      paramIOException = new StringBuilder();
      paramIOException.append("state: ");
      paramIOException.append(fy.this.e);
      throw new IllegalStateException(paramIOException.toString());
    }
  }
  
  private final class b
    implements okio.p
  {
    private final h b = new h(fy.this.d.a());
    private boolean c;
    
    b() {}
    
    public okio.r a()
    {
      return this.b;
    }
    
    public void a_(okio.c paramc, long paramLong)
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        fy.this.d.k(paramLong);
        fy.this.d.b("\r\n");
        fy.this.d.a_(paramc, paramLong);
        fy.this.d.b("\r\n");
        return;
      }
      throw new IllegalStateException("closed");
    }
    
    public void close()
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        this.c = true;
        fy.this.d.b("0\r\n\r\n");
        fy.this.a(this.b);
        fy.this.e = 3;
        return;
      }
      finally {}
    }
    
    public void flush()
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        fy.this.d.flush();
        return;
      }
      finally {}
    }
  }
  
  private class c
    extends fy.a
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
        fy.this.c.p();
      }
      try
      {
        this.g = fy.this.c.m();
        String str = fy.this.c.p().trim();
        if (this.g >= 0L) {
          if (!str.isEmpty())
          {
            boolean bool = str.startsWith(";");
            if (!bool) {}
          }
          else
          {
            if (this.g == 0L)
            {
              this.h = false;
              fq.a(fy.this.a.g(), this.f, fy.this.c());
              a(true, null);
            }
            return;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("expected chunk size and optional extensions but was \"");
        localStringBuilder.append(this.g);
        localStringBuilder.append(str);
        localStringBuilder.append("\"");
        throw new ProtocolException(localStringBuilder.toString());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (!this.h) {
            return -1L;
          }
          long l = this.g;
          if ((l == 0L) || (l == -1L))
          {
            b();
            if (!this.h) {
              return -1L;
            }
          }
          paramLong = super.a(paramc, Math.min(paramLong, this.g));
          if (paramLong != -1L)
          {
            this.g -= paramLong;
            return paramLong;
          }
          paramc = new ProtocolException("unexpected end of stream");
          a(false, paramc);
          throw paramc;
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.h) && (!ff.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
  }
  
  private final class d
    implements okio.p
  {
    private final h b = new h(fy.this.d.a());
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
      if (!this.c)
      {
        ff.a(paramc.b(), 0L, paramLong);
        if (paramLong <= this.d)
        {
          fy.this.d.a_(paramc, paramLong);
          this.d -= paramLong;
          return;
        }
        paramc = new StringBuilder();
        paramc.append("expected ");
        paramc.append(this.d);
        paramc.append(" bytes but received ");
        paramc.append(paramLong);
        throw new ProtocolException(paramc.toString());
      }
      throw new IllegalStateException("closed");
    }
    
    public void close()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d <= 0L)
      {
        fy.this.a(this.b);
        fy.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush()
    {
      if (this.c) {
        return;
      }
      fy.this.d.flush();
    }
  }
  
  private class e
    extends fy.a
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
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          long l = this.f;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.a(paramc, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true, null);
            }
            return paramLong;
          }
          paramc = new ProtocolException("unexpected end of stream");
          a(false, paramc);
          throw paramc;
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.f != 0L) && (!ff.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
  }
  
  private class f
    extends fy.a
  {
    private boolean f;
    
    f()
    {
      super(null);
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
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
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
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
 * Qualified Name:     com.tencent.token.fy
 * JD-Core Version:    0.7.0.1
 */