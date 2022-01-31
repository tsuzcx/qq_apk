package okhttp3;

import javax.annotation.Nullable;

public class au
{
  ap a;
  Protocol b;
  int c = -1;
  String d;
  @Nullable
  ac e;
  ae f;
  av g;
  at h;
  at i;
  at j;
  long k;
  long l;
  
  public au()
  {
    this.f = new ae();
  }
  
  au(at paramat)
  {
    this.a = paramat.a;
    this.b = paramat.b;
    this.c = paramat.c;
    this.d = paramat.d;
    this.e = paramat.e;
    this.f = paramat.f.b();
    this.g = paramat.g;
    this.h = paramat.h;
    this.i = paramat.i;
    this.j = paramat.j;
    this.k = paramat.k;
    this.l = paramat.l;
  }
  
  private void a(String paramString, at paramat)
  {
    if (paramat.g != null) {
      throw new IllegalArgumentException(paramString + ".body != null");
    }
    if (paramat.h != null) {
      throw new IllegalArgumentException(paramString + ".networkResponse != null");
    }
    if (paramat.i != null) {
      throw new IllegalArgumentException(paramString + ".cacheResponse != null");
    }
    if (paramat.j != null) {
      throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }
  }
  
  private void d(at paramat)
  {
    if (paramat.g != null) {
      throw new IllegalArgumentException("priorResponse.body != null");
    }
  }
  
  public at a()
  {
    if (this.a == null) {
      throw new IllegalStateException("request == null");
    }
    if (this.b == null) {
      throw new IllegalStateException("protocol == null");
    }
    if (this.c < 0) {
      throw new IllegalStateException("code < 0: " + this.c);
    }
    if (this.d == null) {
      throw new IllegalStateException("message == null");
    }
    return new at(this);
  }
  
  public au a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public au a(long paramLong)
  {
    this.k = paramLong;
    return this;
  }
  
  public au a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public au a(String paramString1, String paramString2)
  {
    this.f.a(paramString1, paramString2);
    return this;
  }
  
  public au a(Protocol paramProtocol)
  {
    this.b = paramProtocol;
    return this;
  }
  
  public au a(@Nullable ac paramac)
  {
    this.e = paramac;
    return this;
  }
  
  public au a(ad paramad)
  {
    this.f = paramad.b();
    return this;
  }
  
  public au a(ap paramap)
  {
    this.a = paramap;
    return this;
  }
  
  public au a(@Nullable at paramat)
  {
    if (paramat != null) {
      a("networkResponse", paramat);
    }
    this.h = paramat;
    return this;
  }
  
  public au a(@Nullable av paramav)
  {
    this.g = paramav;
    return this;
  }
  
  public au b(long paramLong)
  {
    this.l = paramLong;
    return this;
  }
  
  public au b(@Nullable at paramat)
  {
    if (paramat != null) {
      a("cacheResponse", paramat);
    }
    this.i = paramat;
    return this;
  }
  
  public au c(@Nullable at paramat)
  {
    if (paramat != null) {
      d(paramat);
    }
    this.j = paramat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.au
 * JD-Core Version:    0.7.0.1
 */