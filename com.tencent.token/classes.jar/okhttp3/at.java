package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class at
  implements Closeable
{
  final ap a;
  final Protocol b;
  final int c;
  final String d;
  @Nullable
  final ac e;
  final ad f;
  @Nullable
  final av g;
  @Nullable
  final at h;
  @Nullable
  final at i;
  @Nullable
  final at j;
  final long k;
  final long l;
  private volatile e m;
  
  at(au paramau)
  {
    this.a = paramau.a;
    this.b = paramau.b;
    this.c = paramau.c;
    this.d = paramau.d;
    this.e = paramau.e;
    this.f = paramau.f.a();
    this.g = paramau.g;
    this.h = paramau.h;
    this.i = paramau.i;
    this.j = paramau.j;
    this.k = paramau.k;
    this.l = paramau.l;
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
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public ap a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public ac c()
  {
    return this.e;
  }
  
  public void close()
  {
    if (this.g == null) {
      throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }
    this.g.close();
  }
  
  public ad d()
  {
    return this.f;
  }
  
  @Nullable
  public av e()
  {
    return this.g;
  }
  
  public au f()
  {
    return new au(this);
  }
  
  @Nullable
  public at g()
  {
    return this.j;
  }
  
  public e h()
  {
    e locale = this.m;
    if (locale != null) {
      return locale;
    }
    locale = e.a(this.f);
    this.m = locale;
    return locale;
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
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.at
 * JD-Core Version:    0.7.0.1
 */