package com.tencent.token;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class akn
  implements Closeable
{
  public final akl a;
  final akj b;
  public final int c;
  final String d;
  @Nullable
  public final akd e;
  public final ake f;
  @Nullable
  public final ako g;
  @Nullable
  final akn h;
  @Nullable
  final akn i;
  @Nullable
  public final akn j;
  public final long k;
  public final long l;
  private volatile ajr m;
  
  akn(a parama)
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
  
  public final a a()
  {
    return new a(this);
  }
  
  @Nullable
  public final String a(String paramString)
  {
    paramString = this.f.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public final ajr b()
  {
    ajr localajr = this.m;
    if (localajr != null) {
      return localajr;
    }
    localajr = ajr.a(this.f);
    this.m = localajr;
    return localajr;
  }
  
  public final void close()
  {
    ako localako = this.g;
    if (localako != null)
    {
      localako.close();
      return;
    }
    throw new IllegalStateException("response is not eligible for a body and must not be closed");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response{protocol=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public akl a;
    public akj b;
    public int c = -1;
    public String d;
    @Nullable
    public akd e;
    ake.a f;
    public ako g;
    akn h;
    akn i;
    public akn j;
    public long k;
    public long l;
    
    public a()
    {
      this.f = new ake.a();
    }
    
    a(akn paramakn)
    {
      this.a = paramakn.a;
      this.b = paramakn.b;
      this.c = paramakn.c;
      this.d = paramakn.d;
      this.e = paramakn.e;
      this.f = paramakn.f.a();
      this.g = paramakn.g;
      this.h = paramakn.h;
      this.i = paramakn.i;
      this.j = paramakn.j;
      this.k = paramakn.k;
      this.l = paramakn.l;
    }
    
    private static void a(String paramString, akn paramakn)
    {
      if (paramakn.g == null)
      {
        if (paramakn.h == null)
        {
          if (paramakn.i == null)
          {
            if (paramakn.j == null) {
              return;
            }
            paramakn = new StringBuilder();
            paramakn.append(paramString);
            paramakn.append(".priorResponse != null");
            throw new IllegalArgumentException(paramakn.toString());
          }
          paramakn = new StringBuilder();
          paramakn.append(paramString);
          paramakn.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramakn.toString());
        }
        paramakn = new StringBuilder();
        paramakn.append(paramString);
        paramakn.append(".networkResponse != null");
        throw new IllegalArgumentException(paramakn.toString());
      }
      paramakn = new StringBuilder();
      paramakn.append(paramString);
      paramakn.append(".body != null");
      throw new IllegalArgumentException(paramakn.toString());
    }
    
    public final a a(ake paramake)
    {
      this.f = paramake.a();
      return this;
    }
    
    public final a a(@Nullable akn paramakn)
    {
      if (paramakn != null) {
        a("networkResponse", paramakn);
      }
      this.h = paramakn;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      ake.a locala = this.f;
      ake.a.c(paramString1, paramString2);
      locala.a(paramString1, paramString2);
      return this;
    }
    
    public final akn a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new akn(this);
            }
            throw new IllegalStateException("message == null");
          }
          StringBuilder localStringBuilder = new StringBuilder("code < 0: ");
          localStringBuilder.append(this.c);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        throw new IllegalStateException("protocol == null");
      }
      throw new IllegalStateException("request == null");
    }
    
    public final a b(@Nullable akn paramakn)
    {
      if (paramakn != null) {
        a("cacheResponse", paramakn);
      }
      this.i = paramakn;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akn
 * JD-Core Version:    0.7.0.1
 */