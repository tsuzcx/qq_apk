package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class z
  implements Closeable
{
  final x a;
  final Protocol b;
  final int c;
  final String d;
  @Nullable
  final q e;
  final r f;
  @Nullable
  final aa g;
  @Nullable
  final z h;
  @Nullable
  final z i;
  @Nullable
  final z j;
  final long k;
  final long l;
  private volatile d m;
  
  z(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f.a();
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    this.l = parama.l;
  }
  
  @Nullable
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  @Nullable
  public String a(String paramString1, @Nullable String paramString2)
  {
    paramString1 = this.f.a(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public x a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public q c()
  {
    return this.e;
  }
  
  public void close()
  {
    aa localaa = this.g;
    if (localaa != null)
    {
      localaa.close();
      return;
    }
    throw new IllegalStateException("response is not eligible for a body and must not be closed");
  }
  
  public r d()
  {
    return this.f;
  }
  
  @Nullable
  public aa e()
  {
    return this.g;
  }
  
  public a f()
  {
    return new a(this);
  }
  
  @Nullable
  public z g()
  {
    return this.j;
  }
  
  public d h()
  {
    d locald = this.m;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.f);
    this.m = locald;
    return locald;
  }
  
  public long i()
  {
    return this.k;
  }
  
  public long j()
  {
    return this.l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{protocol=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a.a());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    x a;
    Protocol b;
    int c = -1;
    String d;
    @Nullable
    q e;
    r.a f;
    aa g;
    z h;
    z i;
    z j;
    long k;
    long l;
    
    public a()
    {
      this.f = new r.a();
    }
    
    a(z paramz)
    {
      this.a = paramz.a;
      this.b = paramz.b;
      this.c = paramz.c;
      this.d = paramz.d;
      this.e = paramz.e;
      this.f = paramz.f.b();
      this.g = paramz.g;
      this.h = paramz.h;
      this.i = paramz.i;
      this.j = paramz.j;
      this.k = paramz.k;
      this.l = paramz.l;
    }
    
    private void a(String paramString, z paramz)
    {
      if (paramz.g == null)
      {
        if (paramz.h == null)
        {
          if (paramz.i == null)
          {
            if (paramz.j == null) {
              return;
            }
            paramz = new StringBuilder();
            paramz.append(paramString);
            paramz.append(".priorResponse != null");
            throw new IllegalArgumentException(paramz.toString());
          }
          paramz = new StringBuilder();
          paramz.append(paramString);
          paramz.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramz.toString());
        }
        paramz = new StringBuilder();
        paramz.append(paramString);
        paramz.append(".networkResponse != null");
        throw new IllegalArgumentException(paramz.toString());
      }
      paramz = new StringBuilder();
      paramz.append(paramString);
      paramz.append(".body != null");
      throw new IllegalArgumentException(paramz.toString());
    }
    
    private void d(z paramz)
    {
      if (paramz.g == null) {
        return;
      }
      throw new IllegalArgumentException("priorResponse.body != null");
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.k = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public a a(Protocol paramProtocol)
    {
      this.b = paramProtocol;
      return this;
    }
    
    public a a(@Nullable aa paramaa)
    {
      this.g = paramaa;
      return this;
    }
    
    public a a(@Nullable q paramq)
    {
      this.e = paramq;
      return this;
    }
    
    public a a(r paramr)
    {
      this.f = paramr.b();
      return this;
    }
    
    public a a(x paramx)
    {
      this.a = paramx;
      return this;
    }
    
    public a a(@Nullable z paramz)
    {
      if (paramz != null) {
        a("networkResponse", paramz);
      }
      this.h = paramz;
      return this;
    }
    
    public z a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new z(this);
            }
            throw new IllegalStateException("message == null");
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("code < 0: ");
          localStringBuilder.append(this.c);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        throw new IllegalStateException("protocol == null");
      }
      throw new IllegalStateException("request == null");
    }
    
    public a b(long paramLong)
    {
      this.l = paramLong;
      return this;
    }
    
    public a b(@Nullable z paramz)
    {
      if (paramz != null) {
        a("cacheResponse", paramz);
      }
      this.i = paramz;
      return this;
    }
    
    public a c(@Nullable z paramz)
    {
      if (paramz != null) {
        d(paramz);
      }
      this.j = paramz;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.z
 * JD-Core Version:    0.7.0.1
 */