package com.tencent.token;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class all
  implements Closeable
{
  public final alj a;
  final alh b;
  public final int c;
  final String d;
  @Nullable
  public final alb e;
  public final alc f;
  @Nullable
  public final alm g;
  @Nullable
  final all h;
  @Nullable
  final all i;
  @Nullable
  public final all j;
  public final long k;
  public final long l;
  private volatile akp m;
  
  all(a parama)
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
  
  public final akp b()
  {
    akp localakp = this.m;
    if (localakp != null) {
      return localakp;
    }
    localakp = akp.a(this.f);
    this.m = localakp;
    return localakp;
  }
  
  public final void close()
  {
    alm localalm = this.g;
    if (localalm != null)
    {
      localalm.close();
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
    public alj a;
    public alh b;
    public int c = -1;
    public String d;
    @Nullable
    public alb e;
    alc.a f;
    public alm g;
    all h;
    all i;
    public all j;
    public long k;
    public long l;
    
    public a()
    {
      this.f = new alc.a();
    }
    
    a(all paramall)
    {
      this.a = paramall.a;
      this.b = paramall.b;
      this.c = paramall.c;
      this.d = paramall.d;
      this.e = paramall.e;
      this.f = paramall.f.a();
      this.g = paramall.g;
      this.h = paramall.h;
      this.i = paramall.i;
      this.j = paramall.j;
      this.k = paramall.k;
      this.l = paramall.l;
    }
    
    private static void a(String paramString, all paramall)
    {
      if (paramall.g == null)
      {
        if (paramall.h == null)
        {
          if (paramall.i == null)
          {
            if (paramall.j == null) {
              return;
            }
            paramall = new StringBuilder();
            paramall.append(paramString);
            paramall.append(".priorResponse != null");
            throw new IllegalArgumentException(paramall.toString());
          }
          paramall = new StringBuilder();
          paramall.append(paramString);
          paramall.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramall.toString());
        }
        paramall = new StringBuilder();
        paramall.append(paramString);
        paramall.append(".networkResponse != null");
        throw new IllegalArgumentException(paramall.toString());
      }
      paramall = new StringBuilder();
      paramall.append(paramString);
      paramall.append(".body != null");
      throw new IllegalArgumentException(paramall.toString());
    }
    
    public final a a(alc paramalc)
    {
      this.f = paramalc.a();
      return this;
    }
    
    public final a a(@Nullable all paramall)
    {
      if (paramall != null) {
        a("networkResponse", paramall);
      }
      this.h = paramall;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      alc.a locala = this.f;
      alc.a.c(paramString1, paramString2);
      locala.a(paramString1, paramString2);
      return this;
    }
    
    public final all a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new all(this);
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
    
    public final a b(@Nullable all paramall)
    {
      if (paramall != null) {
        a("cacheResponse", paramall);
      }
      this.i = paramall;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.all
 * JD-Core Version:    0.7.0.1
 */