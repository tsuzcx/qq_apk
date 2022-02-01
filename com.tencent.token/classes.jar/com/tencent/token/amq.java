package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class amq
  implements amg
{
  final alg a;
  final amd b;
  final anv c;
  final anu d;
  int e = 0;
  private long f = 262144L;
  
  public amq(alg paramalg, amd paramamd, anv paramanv, anu paramanu)
  {
    this.a = paramalg;
    this.b = paramamd;
    this.c = paramanv;
    this.d = paramanu;
  }
  
  static void a(anz paramanz)
  {
    aok localaok1 = paramanz.a;
    aok localaok2 = aok.c;
    if (localaok2 != null)
    {
      paramanz.a = localaok2;
      localaok1.g_();
      localaok1.d();
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  private String d()
  {
    String str = this.c.d(this.f);
    this.f -= str.length();
    return str;
  }
  
  public final all.a a(boolean paramBoolean)
  {
    int i = this.e;
    Object localObject1;
    if ((i != 1) && (i != 3))
    {
      localObject1 = new StringBuilder("state: ");
      ((StringBuilder)localObject1).append(this.e);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = amo.a(d());
      localObject2 = new all.a();
      ((all.a)localObject2).b = ((amo)localObject1).a;
      ((all.a)localObject2).c = ((amo)localObject1).b;
      ((all.a)localObject2).d = ((amo)localObject1).c;
      localObject2 = ((all.a)localObject2).a(c());
      if ((paramBoolean) && (((amo)localObject1).b == 100)) {
        return null;
      }
      if (((amo)localObject1).b == 100)
      {
        this.e = 3;
        return localObject2;
      }
      this.e = 4;
      return localObject2;
    }
    catch (EOFException localEOFException)
    {
      Object localObject2 = new StringBuilder("unexpected end of stream on ");
      ((StringBuilder)localObject2).append(this.b);
      localObject2 = new IOException(((StringBuilder)localObject2).toString());
      ((IOException)localObject2).initCause(localEOFException);
      throw ((Throwable)localObject2);
    }
  }
  
  public final alm a(all paramall)
  {
    String str = paramall.a("Content-Type");
    if (!ami.b(paramall)) {
      return new aml(str, 0L, aoc.a(a(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramall.a("Transfer-Encoding")))
    {
      paramall = paramall.a.a;
      if (this.e == 4)
      {
        this.e = 5;
        return new aml(str, -1L, aoc.a(new c(paramall)));
      }
      paramall = new StringBuilder("state: ");
      paramall.append(this.e);
      throw new IllegalStateException(paramall.toString());
    }
    long l = ami.a(paramall);
    if (l != -1L) {
      return new aml(str, l, aoc.a(a(l)));
    }
    if (this.e == 4)
    {
      paramall = this.b;
      if (paramall != null)
      {
        this.e = 5;
        paramall.d();
        return new aml(str, -1L, aoc.a(new f()));
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    paramall = new StringBuilder("state: ");
    paramall.append(this.e);
    throw new IllegalStateException(paramall.toString());
  }
  
  public final aoi a(alj paramalj, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramalj.a("Transfer-Encoding")))
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new b();
      }
      paramalj = new StringBuilder("state: ");
      paramalj.append(this.e);
      throw new IllegalStateException(paramalj.toString());
    }
    if (paramLong != -1L)
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new d(paramLong);
      }
      paramalj = new StringBuilder("state: ");
      paramalj.append(this.e);
      throw new IllegalStateException(paramalj.toString());
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public final aoj a(long paramLong)
  {
    if (this.e == 4)
    {
      this.e = 5;
      return new e(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final void a()
  {
    this.d.flush();
  }
  
  public final void a(alc paramalc, String paramString)
  {
    if (this.e == 0)
    {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = paramalc.a.length / 2;
      while (i < j)
      {
        this.d.b(paramalc.a(i)).b(": ").b(paramalc.b(i)).b("\r\n");
        i += 1;
      }
      this.d.b("\r\n");
      this.e = 1;
      return;
    }
    paramalc = new StringBuilder("state: ");
    paramalc.append(this.e);
    throw new IllegalStateException(paramalc.toString());
  }
  
  public final void a(alj paramalj)
  {
    Object localObject = this.b.b().a.b.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramalj.b);
    localStringBuilder.append(' ');
    int i;
    if ((!paramalj.a.b()) && (localObject == Proxy.Type.HTTP)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localStringBuilder.append(paramalj.a);
    } else {
      localStringBuilder.append(amm.a(paramalj.a));
    }
    localStringBuilder.append(" HTTP/1.1");
    localObject = localStringBuilder.toString();
    a(paramalj.c, (String)localObject);
  }
  
  public final void b()
  {
    this.d.flush();
  }
  
  public final alc c()
  {
    alc.a locala = new alc.a();
    for (;;)
    {
      String str = d();
      if (str.length() == 0) {
        break;
      }
      alp.a.a(locala, str);
    }
    return locala.a();
  }
  
  abstract class a
    implements aoj
  {
    protected final anz a = new anz(amq.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(ant paramant, long paramLong)
    {
      try
      {
        paramLong = amq.this.c.a(paramant, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramant)
      {
        a(false);
        throw paramant;
      }
    }
    
    public final aok a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (amq.this.e == 6) {
        return;
      }
      if (amq.this.e == 5)
      {
        amq.a(this.a);
        localObject = amq.this;
        ((amq)localObject).e = 6;
        if (((amq)localObject).b != null) {
          amq.this.b.a(paramBoolean ^ true, amq.this);
        }
        return;
      }
      Object localObject = new StringBuilder("state: ");
      ((StringBuilder)localObject).append(amq.this.e);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  final class b
    implements aoi
  {
    private final anz b = new anz(amq.this.d.a());
    private boolean c;
    
    b() {}
    
    public final aok a()
    {
      return this.b;
    }
    
    public final void a_(ant paramant, long paramLong)
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        amq.this.d.j(paramLong);
        amq.this.d.b("\r\n");
        amq.this.d.a_(paramant, paramLong);
        amq.this.d.b("\r\n");
        return;
      }
      throw new IllegalStateException("closed");
    }
    
    public final void close()
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        this.c = true;
        amq.this.d.b("0\r\n\r\n");
        amq.a(this.b);
        amq.this.e = 3;
        return;
      }
      finally {}
    }
    
    public final void flush()
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        amq.this.d.flush();
        return;
      }
      finally {}
    }
  }
  
  final class c
    extends amq.a
  {
    private final ald f;
    private long g = -1L;
    private boolean h = true;
    
    c(ald paramald)
    {
      super((byte)0);
      this.f = paramald;
    }
    
    public final long a(ant paramant, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (!this.h) {
            return -1L;
          }
          long l = this.g;
          if ((l == 0L) || (l == -1L)) {
            if (this.g != -1L) {
              amq.this.c.n();
            }
          }
          try
          {
            this.g = amq.this.c.k();
            String str = amq.this.c.n().trim();
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
                  ami.a(amq.this.a.k, this.f, amq.this.c());
                  a(true);
                }
                if (!this.h) {
                  return -1L;
                }
                paramLong = super.a(paramant, Math.min(paramLong, this.g));
                if (paramLong != -1L)
                {
                  this.g -= paramLong;
                  return paramLong;
                }
                paramant = new ProtocolException("unexpected end of stream");
                a(false);
                throw paramant;
              }
            }
            paramant = new StringBuilder("expected chunk size and optional extensions but was \"");
            paramant.append(this.g);
            paramant.append(str);
            paramant.append("\"");
            throw new ProtocolException(paramant.toString());
          }
          catch (NumberFormatException paramant)
          {
            throw new ProtocolException(paramant.getMessage());
          }
        }
        throw new IllegalStateException("closed");
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    
    public final void close()
    {
      if (this.b) {
        return;
      }
      if ((this.h) && (!alr.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class d
    implements aoi
  {
    private final anz b = new anz(amq.this.d.a());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public final aok a()
    {
      return this.b;
    }
    
    public final void a_(ant paramant, long paramLong)
    {
      if (!this.c)
      {
        alr.a(paramant.b, paramLong);
        if (paramLong <= this.d)
        {
          amq.this.d.a_(paramant, paramLong);
          this.d -= paramLong;
          return;
        }
        paramant = new StringBuilder("expected ");
        paramant.append(this.d);
        paramant.append(" bytes but received ");
        paramant.append(paramLong);
        throw new ProtocolException(paramant.toString());
      }
      throw new IllegalStateException("closed");
    }
    
    public final void close()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d <= 0L)
      {
        amq.a(this.b);
        amq.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public final void flush()
    {
      if (this.c) {
        return;
      }
      amq.this.d.flush();
    }
  }
  
  final class e
    extends amq.a
  {
    private long f;
    
    e(long paramLong)
    {
      super((byte)0);
      this.f = paramLong;
      if (this.f == 0L) {
        a(true);
      }
    }
    
    public final long a(ant paramant, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          long l = this.f;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.a(paramant, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true);
            }
            return paramLong;
          }
          paramant = new ProtocolException("unexpected end of stream");
          a(false);
          throw paramant;
        }
        throw new IllegalStateException("closed");
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    
    public final void close()
    {
      if (this.b) {
        return;
      }
      if ((this.f != 0L) && (!alr.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class f
    extends amq.a
  {
    private boolean f;
    
    f()
    {
      super((byte)0);
    }
    
    public final long a(ant paramant, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f) {
            return -1L;
          }
          paramLong = super.a(paramant, paramLong);
          if (paramLong == -1L)
          {
            this.f = true;
            a(true);
            return -1L;
          }
          return paramLong;
        }
        throw new IllegalStateException("closed");
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    
    public final void close()
    {
      if (this.b) {
        return;
      }
      if (!this.f) {
        a(false);
      }
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amq
 * JD-Core Version:    0.7.0.1
 */