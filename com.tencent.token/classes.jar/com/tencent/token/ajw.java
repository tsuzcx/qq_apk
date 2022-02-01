package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class ajw
  implements ajm
{
  final aim a;
  final ajj b;
  final alb c;
  final ala d;
  int e = 0;
  private long f = 262144L;
  
  public ajw(aim paramaim, ajj paramajj, alb paramalb, ala paramala)
  {
    this.a = paramaim;
    this.b = paramajj;
    this.c = paramalb;
    this.d = paramala;
  }
  
  static void a(alf paramalf)
  {
    alq localalq1 = paramalf.a;
    alq localalq2 = alq.c;
    if (localalq2 != null)
    {
      paramalf.a = localalq2;
      localalq1.f_();
      localalq1.d();
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
  
  public final air.a a(boolean paramBoolean)
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
      localObject1 = aju.a(d());
      localObject2 = new air.a();
      ((air.a)localObject2).b = ((aju)localObject1).a;
      ((air.a)localObject2).c = ((aju)localObject1).b;
      ((air.a)localObject2).d = ((aju)localObject1).c;
      localObject2 = ((air.a)localObject2).a(c());
      if ((paramBoolean) && (((aju)localObject1).b == 100)) {
        return null;
      }
      if (((aju)localObject1).b == 100)
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
  
  public final ais a(air paramair)
  {
    String str = paramair.a("Content-Type");
    if (!ajo.b(paramair)) {
      return new ajr(str, 0L, ali.a(a(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramair.a("Transfer-Encoding")))
    {
      paramair = paramair.a.a;
      if (this.e == 4)
      {
        this.e = 5;
        return new ajr(str, -1L, ali.a(new c(paramair)));
      }
      paramair = new StringBuilder("state: ");
      paramair.append(this.e);
      throw new IllegalStateException(paramair.toString());
    }
    long l = ajo.a(paramair);
    if (l != -1L) {
      return new ajr(str, l, ali.a(a(l)));
    }
    if (this.e == 4)
    {
      paramair = this.b;
      if (paramair != null)
      {
        this.e = 5;
        paramair.d();
        return new ajr(str, -1L, ali.a(new f()));
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    paramair = new StringBuilder("state: ");
    paramair.append(this.e);
    throw new IllegalStateException(paramair.toString());
  }
  
  public final alo a(aip paramaip, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramaip.a("Transfer-Encoding")))
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new b();
      }
      paramaip = new StringBuilder("state: ");
      paramaip.append(this.e);
      throw new IllegalStateException(paramaip.toString());
    }
    if (paramLong != -1L)
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new d(paramLong);
      }
      paramaip = new StringBuilder("state: ");
      paramaip.append(this.e);
      throw new IllegalStateException(paramaip.toString());
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public final alp a(long paramLong)
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
  
  public final void a(aii paramaii, String paramString)
  {
    if (this.e == 0)
    {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = paramaii.a.length / 2;
      while (i < j)
      {
        this.d.b(paramaii.a(i)).b(": ").b(paramaii.b(i)).b("\r\n");
        i += 1;
      }
      this.d.b("\r\n");
      this.e = 1;
      return;
    }
    paramaii = new StringBuilder("state: ");
    paramaii.append(this.e);
    throw new IllegalStateException(paramaii.toString());
  }
  
  public final void a(aip paramaip)
  {
    Object localObject = this.b.b().a.b.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaip.b);
    localStringBuilder.append(' ');
    int i;
    if ((!paramaip.a.b()) && (localObject == Proxy.Type.HTTP)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localStringBuilder.append(paramaip.a);
    } else {
      localStringBuilder.append(ajs.a(paramaip.a));
    }
    localStringBuilder.append(" HTTP/1.1");
    localObject = localStringBuilder.toString();
    a(paramaip.c, (String)localObject);
  }
  
  public final void b()
  {
    this.d.flush();
  }
  
  public final aii c()
  {
    aii.a locala = new aii.a();
    for (;;)
    {
      String str = d();
      if (str.length() == 0) {
        break;
      }
      aiv.a.a(locala, str);
    }
    return locala.a();
  }
  
  abstract class a
    implements alp
  {
    protected final alf a = new alf(ajw.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(akz paramakz, long paramLong)
    {
      try
      {
        paramLong = ajw.this.c.a(paramakz, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramakz)
      {
        a(false);
        throw paramakz;
      }
    }
    
    public final alq a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (ajw.this.e == 6) {
        return;
      }
      if (ajw.this.e == 5)
      {
        ajw.a(this.a);
        localObject = ajw.this;
        ((ajw)localObject).e = 6;
        if (((ajw)localObject).b != null) {
          ajw.this.b.a(paramBoolean ^ true, ajw.this);
        }
        return;
      }
      Object localObject = new StringBuilder("state: ");
      ((StringBuilder)localObject).append(ajw.this.e);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  final class b
    implements alo
  {
    private final alf b = new alf(ajw.this.d.a());
    private boolean c;
    
    b() {}
    
    public final alq a()
    {
      return this.b;
    }
    
    public final void a_(akz paramakz, long paramLong)
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        ajw.this.d.j(paramLong);
        ajw.this.d.b("\r\n");
        ajw.this.d.a_(paramakz, paramLong);
        ajw.this.d.b("\r\n");
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
        ajw.this.d.b("0\r\n\r\n");
        ajw.a(this.b);
        ajw.this.e = 3;
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
        ajw.this.d.flush();
        return;
      }
      finally {}
    }
  }
  
  final class c
    extends ajw.a
  {
    private final aij f;
    private long g = -1L;
    private boolean h = true;
    
    c(aij paramaij)
    {
      super((byte)0);
      this.f = paramaij;
    }
    
    public final long a(akz paramakz, long paramLong)
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
              ajw.this.c.n();
            }
          }
          try
          {
            this.g = ajw.this.c.k();
            String str = ajw.this.c.n().trim();
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
                  ajo.a(ajw.this.a.k, this.f, ajw.this.c());
                  a(true);
                }
                if (!this.h) {
                  return -1L;
                }
                paramLong = super.a(paramakz, Math.min(paramLong, this.g));
                if (paramLong != -1L)
                {
                  this.g -= paramLong;
                  return paramLong;
                }
                paramakz = new ProtocolException("unexpected end of stream");
                a(false);
                throw paramakz;
              }
            }
            paramakz = new StringBuilder("expected chunk size and optional extensions but was \"");
            paramakz.append(this.g);
            paramakz.append(str);
            paramakz.append("\"");
            throw new ProtocolException(paramakz.toString());
          }
          catch (NumberFormatException paramakz)
          {
            throw new ProtocolException(paramakz.getMessage());
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
      if ((this.h) && (!aix.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class d
    implements alo
  {
    private final alf b = new alf(ajw.this.d.a());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public final alq a()
    {
      return this.b;
    }
    
    public final void a_(akz paramakz, long paramLong)
    {
      if (!this.c)
      {
        aix.a(paramakz.b, paramLong);
        if (paramLong <= this.d)
        {
          ajw.this.d.a_(paramakz, paramLong);
          this.d -= paramLong;
          return;
        }
        paramakz = new StringBuilder("expected ");
        paramakz.append(this.d);
        paramakz.append(" bytes but received ");
        paramakz.append(paramLong);
        throw new ProtocolException(paramakz.toString());
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
        ajw.a(this.b);
        ajw.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public final void flush()
    {
      if (this.c) {
        return;
      }
      ajw.this.d.flush();
    }
  }
  
  final class e
    extends ajw.a
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
    
    public final long a(akz paramakz, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          long l = this.f;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.a(paramakz, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true);
            }
            return paramLong;
          }
          paramakz = new ProtocolException("unexpected end of stream");
          a(false);
          throw paramakz;
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
      if ((this.f != 0L) && (!aix.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class f
    extends ajw.a
  {
    private boolean f;
    
    f()
    {
      super((byte)0);
    }
    
    public final long a(akz paramakz, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f) {
            return -1L;
          }
          paramLong = super.a(paramakz, paramLong);
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
 * Qualified Name:     com.tencent.token.ajw
 * JD-Core Version:    0.7.0.1
 */