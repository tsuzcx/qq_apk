package com.tencent.token;

import java.util.List;
import okhttp3.e;
import okhttp3.i;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.p;
import okhttp3.t;
import okhttp3.t.a;
import okhttp3.x;
import okhttp3.z;

public final class fp
  implements t.a
{
  private final List<t> a;
  private final f b;
  private final fl c;
  private final c d;
  private final int e;
  private final x f;
  private final e g;
  private final p h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public fp(List<t> paramList, f paramf, fl paramfl, c paramc, int paramInt1, x paramx, e parame, p paramp, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramList;
    this.d = paramc;
    this.b = paramf;
    this.c = paramfl;
    this.e = paramInt1;
    this.f = paramx;
    this.g = parame;
    this.h = paramp;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public x a()
  {
    return this.f;
  }
  
  public z a(x paramx)
  {
    return a(paramx, this.b, this.c, this.d);
  }
  
  public z a(x paramx, f paramf, fl paramfl, c paramc)
  {
    if (this.e < this.a.size())
    {
      this.l += 1;
      if ((this.c != null) && (!this.d.a(paramx.a())))
      {
        paramx = new StringBuilder();
        paramx.append("network interceptor ");
        paramx.append(this.a.get(this.e - 1));
        paramx.append(" must retain the same host and port");
        throw new IllegalStateException(paramx.toString());
      }
      if ((this.c != null) && (this.l > 1))
      {
        paramx = new StringBuilder();
        paramx.append("network interceptor ");
        paramx.append(this.a.get(this.e - 1));
        paramx.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramx.toString());
      }
      paramf = new fp(this.a, paramf, paramfl, paramc, this.e + 1, paramx, this.g, this.h, this.i, this.j, this.k);
      paramx = (t)this.a.get(this.e);
      paramc = paramx.a(paramf);
      if ((paramfl != null) && (this.e + 1 < this.a.size()) && (paramf.l != 1))
      {
        paramf = new StringBuilder();
        paramf.append("network interceptor ");
        paramf.append(paramx);
        paramf.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramf.toString());
      }
      if (paramc != null)
      {
        if (paramc.e() != null) {
          return paramc;
        }
        paramf = new StringBuilder();
        paramf.append("interceptor ");
        paramf.append(paramx);
        paramf.append(" returned a response with no body");
        throw new IllegalStateException(paramf.toString());
      }
      paramf = new StringBuilder();
      paramf.append("interceptor ");
      paramf.append(paramx);
      paramf.append(" returned null");
      throw new NullPointerException(paramf.toString());
    }
    throw new AssertionError();
  }
  
  public int b()
  {
    return this.i;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public i e()
  {
    return this.d;
  }
  
  public f f()
  {
    return this.b;
  }
  
  public fl g()
  {
    return this.c;
  }
  
  public e h()
  {
    return this.g;
  }
  
  public p i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fp
 * JD-Core Version:    0.7.0.1
 */