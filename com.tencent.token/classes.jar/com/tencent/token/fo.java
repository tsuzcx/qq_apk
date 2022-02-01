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

public final class fo
  implements t.a
{
  private final List<t> a;
  private final f b;
  private final fk c;
  private final c d;
  private final int e;
  private final x f;
  private final e g;
  private final p h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public fo(List<t> paramList, f paramf, fk paramfk, c paramc, int paramInt1, x paramx, e parame, p paramp, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramList;
    this.d = paramc;
    this.b = paramf;
    this.c = paramfk;
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
  
  public z a(x paramx, f paramf, fk paramfk, c paramc)
  {
    if (this.e >= this.a.size()) {
      throw new AssertionError();
    }
    this.l += 1;
    if ((this.c != null) && (!this.d.a(paramx.a()))) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
    }
    if ((this.c != null) && (this.l > 1)) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
    }
    paramx = new fo(this.a, paramf, paramfk, paramc, this.e + 1, paramx, this.g, this.h, this.i, this.j, this.k);
    paramf = (t)this.a.get(this.e);
    paramc = paramf.a(paramx);
    if ((paramfk != null) && (this.e + 1 < this.a.size()) && (paramx.l != 1)) {
      throw new IllegalStateException("network interceptor " + paramf + " must call proceed() exactly once");
    }
    if (paramc == null) {
      throw new NullPointerException("interceptor " + paramf + " returned null");
    }
    if (paramc.e() == null) {
      throw new IllegalStateException("interceptor " + paramf + " returned a response with no body");
    }
    return paramc;
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
  
  public fk g()
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
 * Qualified Name:     com.tencent.token.fo
 * JD-Core Version:    0.7.0.1
 */