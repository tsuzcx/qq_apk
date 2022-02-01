package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class als
  implements ali
{
  final aki a;
  final alf b;
  final amx c;
  final amw d;
  int e = 0;
  private long f = 262144L;
  
  public als(aki paramaki, alf paramalf, amx paramamx, amw paramamw)
  {
    this.a = paramaki;
    this.b = paramalf;
    this.c = paramamx;
    this.d = paramamw;
  }
  
  static void a(anb paramanb)
  {
    anm localanm1 = paramanb.a;
    anm localanm2 = anm.c;
    if (localanm2 != null)
    {
      paramanb.a = localanm2;
      localanm1.g_();
      localanm1.d();
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
  
  public final akn.a a(boolean paramBoolean)
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
      localObject1 = alq.a(d());
      localObject2 = new akn.a();
      ((akn.a)localObject2).b = ((alq)localObject1).a;
      ((akn.a)localObject2).c = ((alq)localObject1).b;
      ((akn.a)localObject2).d = ((alq)localObject1).c;
      localObject2 = ((akn.a)localObject2).a(c());
      if ((paramBoolean) && (((alq)localObject1).b == 100)) {
        return null;
      }
      if (((alq)localObject1).b == 100)
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
  
  public final ako a(akn paramakn)
  {
    String str = paramakn.a("Content-Type");
    if (!alk.b(paramakn)) {
      return new aln(str, 0L, ane.a(a(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramakn.a("Transfer-Encoding")))
    {
      paramakn = paramakn.a.a;
      if (this.e == 4)
      {
        this.e = 5;
        return new aln(str, -1L, ane.a(new c(paramakn)));
      }
      paramakn = new StringBuilder("state: ");
      paramakn.append(this.e);
      throw new IllegalStateException(paramakn.toString());
    }
    long l = alk.a(paramakn);
    if (l != -1L) {
      return new aln(str, l, ane.a(a(l)));
    }
    if (this.e == 4)
    {
      paramakn = this.b;
      if (paramakn != null)
      {
        this.e = 5;
        paramakn.d();
        return new aln(str, -1L, ane.a(new f()));
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    paramakn = new StringBuilder("state: ");
    paramakn.append(this.e);
    throw new IllegalStateException(paramakn.toString());
  }
  
  public final ank a(akl paramakl, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramakl.a("Transfer-Encoding")))
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new b();
      }
      paramakl = new StringBuilder("state: ");
      paramakl.append(this.e);
      throw new IllegalStateException(paramakl.toString());
    }
    if (paramLong != -1L)
    {
      if (this.e == 1)
      {
        this.e = 2;
        return new d(paramLong);
      }
      paramakl = new StringBuilder("state: ");
      paramakl.append(this.e);
      throw new IllegalStateException(paramakl.toString());
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public final anl a(long paramLong)
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
  
  public final void a(ake paramake, String paramString)
  {
    if (this.e == 0)
    {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = paramake.a.length / 2;
      while (i < j)
      {
        this.d.b(paramake.a(i)).b(": ").b(paramake.b(i)).b("\r\n");
        i += 1;
      }
      this.d.b("\r\n");
      this.e = 1;
      return;
    }
    paramake = new StringBuilder("state: ");
    paramake.append(this.e);
    throw new IllegalStateException(paramake.toString());
  }
  
  public final void a(akl paramakl)
  {
    Object localObject = this.b.b().a.b.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramakl.b);
    localStringBuilder.append(' ');
    int i;
    if ((!paramakl.a.b()) && (localObject == Proxy.Type.HTTP)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localStringBuilder.append(paramakl.a);
    } else {
      localStringBuilder.append(alo.a(paramakl.a));
    }
    localStringBuilder.append(" HTTP/1.1");
    localObject = localStringBuilder.toString();
    a(paramakl.c, (String)localObject);
  }
  
  public final void b()
  {
    this.d.flush();
  }
  
  public final ake c()
  {
    ake.a locala = new ake.a();
    for (;;)
    {
      String str = d();
      if (str.length() == 0) {
        break;
      }
      akr.a.a(locala, str);
    }
    return locala.a();
  }
  
  abstract class a
    implements anl
  {
    protected final anb a = new anb(als.this.c.a());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    public long a(amv paramamv, long paramLong)
    {
      try
      {
        paramLong = als.this.c.a(paramamv, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramamv)
      {
        a(false);
        throw paramamv;
      }
    }
    
    public final anm a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (als.this.e == 6) {
        return;
      }
      if (als.this.e == 5)
      {
        als.a(this.a);
        localObject = als.this;
        ((als)localObject).e = 6;
        if (((als)localObject).b != null) {
          als.this.b.a(paramBoolean ^ true, als.this);
        }
        return;
      }
      Object localObject = new StringBuilder("state: ");
      ((StringBuilder)localObject).append(als.this.e);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  final class b
    implements ank
  {
    private final anb b = new anb(als.this.d.a());
    private boolean c;
    
    b() {}
    
    public final anm a()
    {
      return this.b;
    }
    
    public final void a_(amv paramamv, long paramLong)
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        als.this.d.j(paramLong);
        als.this.d.b("\r\n");
        als.this.d.a_(paramamv, paramLong);
        als.this.d.b("\r\n");
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
        als.this.d.b("0\r\n\r\n");
        als.a(this.b);
        als.this.e = 3;
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
        als.this.d.flush();
        return;
      }
      finally {}
    }
  }
  
  final class c
    extends als.a
  {
    private final akf f;
    private long g = -1L;
    private boolean h = true;
    
    c(akf paramakf)
    {
      super((byte)0);
      this.f = paramakf;
    }
    
    public final long a(amv paramamv, long paramLong)
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
              als.this.c.n();
            }
          }
          try
          {
            this.g = als.this.c.k();
            String str = als.this.c.n().trim();
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
                  alk.a(als.this.a.k, this.f, als.this.c());
                  a(true);
                }
                if (!this.h) {
                  return -1L;
                }
                paramLong = super.a(paramamv, Math.min(paramLong, this.g));
                if (paramLong != -1L)
                {
                  this.g -= paramLong;
                  return paramLong;
                }
                paramamv = new ProtocolException("unexpected end of stream");
                a(false);
                throw paramamv;
              }
            }
            paramamv = new StringBuilder("expected chunk size and optional extensions but was \"");
            paramamv.append(this.g);
            paramamv.append(str);
            paramamv.append("\"");
            throw new ProtocolException(paramamv.toString());
          }
          catch (NumberFormatException paramamv)
          {
            throw new ProtocolException(paramamv.getMessage());
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
      if ((this.h) && (!akt.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class d
    implements ank
  {
    private final anb b = new anb(als.this.d.a());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public final anm a()
    {
      return this.b;
    }
    
    public final void a_(amv paramamv, long paramLong)
    {
      if (!this.c)
      {
        akt.a(paramamv.b, paramLong);
        if (paramLong <= this.d)
        {
          als.this.d.a_(paramamv, paramLong);
          this.d -= paramLong;
          return;
        }
        paramamv = new StringBuilder("expected ");
        paramamv.append(this.d);
        paramamv.append(" bytes but received ");
        paramamv.append(paramLong);
        throw new ProtocolException(paramamv.toString());
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
        als.a(this.b);
        als.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public final void flush()
    {
      if (this.c) {
        return;
      }
      als.this.d.flush();
    }
  }
  
  final class e
    extends als.a
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
    
    public final long a(amv paramamv, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          long l = this.f;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.a(paramamv, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true);
            }
            return paramLong;
          }
          paramamv = new ProtocolException("unexpected end of stream");
          a(false);
          throw paramamv;
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
      if ((this.f != 0L) && (!akt.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class f
    extends als.a
  {
    private boolean f;
    
    f()
    {
      super((byte)0);
    }
    
    public final long a(amv paramamv, long paramLong)
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f) {
            return -1L;
          }
          paramLong = super.a(paramamv, paramLong);
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
 * Qualified Name:     com.tencent.token.als
 * JD-Core Version:    0.7.0.1
 */