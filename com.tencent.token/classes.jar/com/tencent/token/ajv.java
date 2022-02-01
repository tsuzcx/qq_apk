package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class ajv
  implements ajl
{
  final ail a;
  final aji b;
  final ala c;
  final akz d;
  int e = 0;
  private long f = 262144L;
  
  public ajv(ail paramail, aji paramaji, ala paramala, akz paramakz)
  {
    this.a = paramail;
    this.b = paramaji;
    this.c = paramala;
    this.d = paramakz;
  }
  
  static void a(ale paramale)
  {
    alp localalp1 = paramale.a;
    alp localalp2 = alp.c;
    if (localalp2 != null)
    {
      paramale.a = localalp2;
      localalp1.f_();
      localalp1.d();
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
  
  public final aiq.a a(boolean paramBoolean)
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
      localObject1 = ajt.a(d());
      localObject2 = new aiq.a();
      ((aiq.a)localObject2).b = ((ajt)localObject1).a;
      ((aiq.a)localObject2).c = ((ajt)localObject1).b;
      ((aiq.a)localObject2).d = ((ajt)localObject1).c;
      localObject2 = ((aiq.a)localObject2).a(c());
      if ((paramBoolean) && (((ajt)localObject1).b == 100)) {
        return null;
      }
      if (((ajt)localObject1).b == 100)
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
  
  public final air a(aiq paramaiq)
  {
    String str = paramaiq.a("Content-Type");
    if (!ajn.b(paramaiq)) {
      return new ajq(str, 0L, alh.a(a(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramaiq.a("Transfer-Encoding")))
    {
      paramaiq = paramaiq.a.a;
      if (this.e == 4)
      {
        this.e = 5;
        return new ajq(str, -1L, alh.a(new c(paramaiq)));
      }
      paramaiq = new StringBuilder("state: ");
      paramaiq.append(this.e);
      throw new IllegalStateException(paramaiq.toString());
    }
    long l = ajn.a(paramaiq);
    if (l != -1L) {
      return new ajq(str, l, alh.a(a(l)));
    }
    if (this.e == 4)
    {
      paramaiq = this.b;
      if (paramaiq != null)
      {
        this.e = 5;
        paramaiq.d();
        return new ajq(str, -1L, alh.a(new f()));
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    paramaiq = new StringBuilder("state: ");
    paramaiq.append(this.e);
    throw new IllegalStateException(paramaiq.toString());
  }
  
  public final aln a(aio paramaio, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramaio.a("Transfer-Encoding")))
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new b();
      }
      paramaio = new StringBuilder("state: ");
      paramaio.append(this.e);
      throw new IllegalStateException(paramaio.toString());
    }
    if (paramLong != -1L)
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new d(paramLong);
      }
      paramaio = new StringBuilder("state: ");
      paramaio.append(this.e);
      throw new IllegalStateException(paramaio.toString());
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public final alo a(long paramLong)
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
  
  public final void a(aih paramaih, String paramString)
  {
    if (this.e == 0)
    {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = paramaih.a.length / 2;
      while (i < j)
      {
        this.d.b(paramaih.a(i)).b(": ").b(paramaih.b(i)).b("\r\n");
        i += 1;
      }
      this.d.b("\r\n");
      this.e = 1;
      return;
    }
    paramaih = new StringBuilder("state: ");
    paramaih.append(this.e);
    throw new IllegalStateException(paramaih.toString());
  }
  
  public final void a(aio paramaio)
  {
    Object localObject = this.b.b().a.b.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaio.b);
    localStringBuilder.append(' ');
    int i;
    if ((!paramaio.a.b()) && (localObject == Proxy.Type.HTTP)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localStringBuilder.append(paramaio.a);
    } else {
      localStringBuilder.append(ajr.a(paramaio.a));
    }
    localStringBuilder.append(" HTTP/1.1");
    localObject = localStringBuilder.toString();
    a(paramaio.c, (String)localObject);
  }
  
  public final void b()
  {
    this.d.flush();
  }
  
  public final aih c()
  {
    aih.a locala = new aih.a();
    for (;;)
    {
      String str = d();
      if (str.length() == 0) {
        break;
      }
      aiu.a.a(locala, str);
    }
    return locala.a();
  }
  
  abstract class a
    implements alo
  {
    protected final ale a = new ale(ajv.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(aky paramaky, long paramLong)
    {
      try
      {
        paramLong = ajv.this.c.a(paramaky, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramaky)
      {
        a(false);
        throw paramaky;
      }
    }
    
    public final alp a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (ajv.this.e == 6) {
        return;
      }
      if (ajv.this.e == 5)
      {
        ajv.a(this.a);
        localObject = ajv.this;
        ((ajv)localObject).e = 6;
        if (((ajv)localObject).b != null) {
          ajv.this.b.a(paramBoolean ^ true, ajv.this);
        }
        return;
      }
      Object localObject = new StringBuilder("state: ");
      ((StringBuilder)localObject).append(ajv.this.e);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  final class b
    implements aln
  {
    private final ale b = new ale(ajv.this.d.a());
    private boolean c;
    
    b() {}
    
    public final alp a()
    {
      return this.b;
    }
    
    public final void a_(aky paramaky, long paramLong)
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        ajv.this.d.j(paramLong);
        ajv.this.d.b("\r\n");
        ajv.this.d.a_(paramaky, paramLong);
        ajv.this.d.b("\r\n");
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
        ajv.this.d.b("0\r\n\r\n");
        ajv.a(this.b);
        ajv.this.e = 3;
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
        ajv.this.d.flush();
        return;
      }
      finally {}
    }
  }
  
  final class c
    extends ajv.a
  {
    private final aii f;
    private long g = -1L;
    private boolean h = true;
    
    c(aii paramaii)
    {
      super((byte)0);
      this.f = paramaii;
    }
    
    public final long a(aky paramaky, long paramLong)
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
              ajv.this.c.n();
            }
          }
          try
          {
            this.g = ajv.this.c.k();
            String str = ajv.this.c.n().trim();
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
                  ajn.a(ajv.this.a.k, this.f, ajv.this.c());
                  a(true);
                }
                if (!this.h) {
                  return -1L;
                }
                paramLong = super.a(paramaky, Math.min(paramLong, this.g));
                if (paramLong != -1L)
                {
                  this.g -= paramLong;
                  return paramLong;
                }
                paramaky = new ProtocolException("unexpected end of stream");
                a(false);
                throw paramaky;
              }
            }
            paramaky = new StringBuilder("expected chunk size and optional extensions but was \"");
            paramaky.append(this.g);
            paramaky.append(str);
            paramaky.append("\"");
            throw new ProtocolException(paramaky.toString());
          }
          catch (NumberFormatException paramaky)
          {
            throw new ProtocolException(paramaky.getMessage());
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
      if ((this.h) && (!aiw.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class d
    implements aln
  {
    private final ale b = new ale(ajv.this.d.a());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public final alp a()
    {
      return this.b;
    }
    
    public final void a_(aky paramaky, long paramLong)
    {
      if (!this.c)
      {
        aiw.a(paramaky.b, paramLong);
        if (paramLong <= this.d)
        {
          ajv.this.d.a_(paramaky, paramLong);
          this.d -= paramLong;
          return;
        }
        paramaky = new StringBuilder("expected ");
        paramaky.append(this.d);
        paramaky.append(" bytes but received ");
        paramaky.append(paramLong);
        throw new ProtocolException(paramaky.toString());
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
        ajv.a(this.b);
        ajv.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public final void flush()
    {
      if (this.c) {
        return;
      }
      ajv.this.d.flush();
    }
  }
  
  final class e
    extends ajv.a
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
    
    public final long a(aky paramaky, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          long l = this.f;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.a(paramaky, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true);
            }
            return paramLong;
          }
          paramaky = new ProtocolException("unexpected end of stream");
          a(false);
          throw paramaky;
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
      if ((this.f != 0L) && (!aiw.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class f
    extends ajv.a
  {
    private boolean f;
    
    f()
    {
      super((byte)0);
    }
    
    public final long a(aky paramaky, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f) {
            return -1L;
          }
          paramLong = super.a(paramaky, paramLong);
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
 * Qualified Name:     com.tencent.token.ajv
 * JD-Core Version:    0.7.0.1
 */