package com.tencent.token;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class aiq
  implements Closeable
{
  public final aio a;
  final aim b;
  public final int c;
  final String d;
  @Nullable
  public final aig e;
  public final aih f;
  @Nullable
  public final air g;
  @Nullable
  final aiq h;
  @Nullable
  final aiq i;
  @Nullable
  public final aiq j;
  public final long k;
  public final long l;
  private volatile ahu m;
  
  aiq(a parama)
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
  
  public final ahu b()
  {
    ahu localahu = this.m;
    if (localahu != null) {
      return localahu;
    }
    localahu = ahu.a(this.f);
    this.m = localahu;
    return localahu;
  }
  
  public final void close()
  {
    air localair = this.g;
    if (localair != null)
    {
      localair.close();
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
    public aio a;
    public aim b;
    public int c = -1;
    public String d;
    @Nullable
    public aig e;
    aih.a f;
    public air g;
    aiq h;
    aiq i;
    public aiq j;
    public long k;
    public long l;
    
    public a()
    {
      this.f = new aih.a();
    }
    
    a(aiq paramaiq)
    {
      this.a = paramaiq.a;
      this.b = paramaiq.b;
      this.c = paramaiq.c;
      this.d = paramaiq.d;
      this.e = paramaiq.e;
      this.f = paramaiq.f.a();
      this.g = paramaiq.g;
      this.h = paramaiq.h;
      this.i = paramaiq.i;
      this.j = paramaiq.j;
      this.k = paramaiq.k;
      this.l = paramaiq.l;
    }
    
    private static void a(String paramString, aiq paramaiq)
    {
      if (paramaiq.g == null)
      {
        if (paramaiq.h == null)
        {
          if (paramaiq.i == null)
          {
            if (paramaiq.j == null) {
              return;
            }
            paramaiq = new StringBuilder();
            paramaiq.append(paramString);
            paramaiq.append(".priorResponse != null");
            throw new IllegalArgumentException(paramaiq.toString());
          }
          paramaiq = new StringBuilder();
          paramaiq.append(paramString);
          paramaiq.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramaiq.toString());
        }
        paramaiq = new StringBuilder();
        paramaiq.append(paramString);
        paramaiq.append(".networkResponse != null");
        throw new IllegalArgumentException(paramaiq.toString());
      }
      paramaiq = new StringBuilder();
      paramaiq.append(paramString);
      paramaiq.append(".body != null");
      throw new IllegalArgumentException(paramaiq.toString());
    }
    
    public final a a(aih paramaih)
    {
      this.f = paramaih.a();
      return this;
    }
    
    public final a a(@Nullable aiq paramaiq)
    {
      if (paramaiq != null) {
        a("networkResponse", paramaiq);
      }
      this.h = paramaiq;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      aih.a locala = this.f;
      aih.a.c(paramString1, paramString2);
      locala.a(paramString1, paramString2);
      return this;
    }
    
    public final aiq a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new aiq(this);
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
    
    public final a b(@Nullable aiq paramaiq)
    {
      if (paramaiq != null) {
        a("cacheResponse", paramaiq);
      }
      this.i = paramaiq;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiq
 * JD-Core Version:    0.7.0.1
 */