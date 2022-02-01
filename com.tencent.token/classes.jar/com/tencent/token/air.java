package com.tencent.token;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class air
  implements Closeable
{
  public final aip a;
  final ain b;
  public final int c;
  final String d;
  @Nullable
  public final aih e;
  public final aii f;
  @Nullable
  public final ais g;
  @Nullable
  final air h;
  @Nullable
  final air i;
  @Nullable
  public final air j;
  public final long k;
  public final long l;
  private volatile ahv m;
  
  air(a parama)
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
  
  public final ahv b()
  {
    ahv localahv = this.m;
    if (localahv != null) {
      return localahv;
    }
    localahv = ahv.a(this.f);
    this.m = localahv;
    return localahv;
  }
  
  public final void close()
  {
    ais localais = this.g;
    if (localais != null)
    {
      localais.close();
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
    public aip a;
    public ain b;
    public int c = -1;
    public String d;
    @Nullable
    public aih e;
    aii.a f;
    public ais g;
    air h;
    air i;
    public air j;
    public long k;
    public long l;
    
    public a()
    {
      this.f = new aii.a();
    }
    
    a(air paramair)
    {
      this.a = paramair.a;
      this.b = paramair.b;
      this.c = paramair.c;
      this.d = paramair.d;
      this.e = paramair.e;
      this.f = paramair.f.a();
      this.g = paramair.g;
      this.h = paramair.h;
      this.i = paramair.i;
      this.j = paramair.j;
      this.k = paramair.k;
      this.l = paramair.l;
    }
    
    private static void a(String paramString, air paramair)
    {
      if (paramair.g == null)
      {
        if (paramair.h == null)
        {
          if (paramair.i == null)
          {
            if (paramair.j == null) {
              return;
            }
            paramair = new StringBuilder();
            paramair.append(paramString);
            paramair.append(".priorResponse != null");
            throw new IllegalArgumentException(paramair.toString());
          }
          paramair = new StringBuilder();
          paramair.append(paramString);
          paramair.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramair.toString());
        }
        paramair = new StringBuilder();
        paramair.append(paramString);
        paramair.append(".networkResponse != null");
        throw new IllegalArgumentException(paramair.toString());
      }
      paramair = new StringBuilder();
      paramair.append(paramString);
      paramair.append(".body != null");
      throw new IllegalArgumentException(paramair.toString());
    }
    
    public final a a(aii paramaii)
    {
      this.f = paramaii.a();
      return this;
    }
    
    public final a a(@Nullable air paramair)
    {
      if (paramair != null) {
        a("networkResponse", paramair);
      }
      this.h = paramair;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      aii.a locala = this.f;
      aii.a.c(paramString1, paramString2);
      locala.a(paramString1, paramString2);
      return this;
    }
    
    public final air a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new air(this);
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
    
    public final a b(@Nullable air paramair)
    {
      if (paramair != null) {
        a("cacheResponse", paramair);
      }
      this.i = paramair;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.air
 * JD-Core Version:    0.7.0.1
 */