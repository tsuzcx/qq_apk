package com.tencent.token;

import java.util.List;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.ap;
import okhttp3.at;
import okhttp3.internal.connection.c;
import okhttp3.n;
import okhttp3.y;

public final class hi
  implements ai
{
  private final List a;
  private final okhttp3.internal.connection.g b;
  private final hd c;
  private final c d;
  private final int e;
  private final ap f;
  private final okhttp3.g g;
  private final y h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public hi(List paramList, okhttp3.internal.connection.g paramg, hd paramhd, c paramc, int paramInt1, ap paramap, okhttp3.g paramg1, y paramy, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramList;
    this.d = paramc;
    this.b = paramg;
    this.c = paramhd;
    this.e = paramInt1;
    this.f = paramap;
    this.g = paramg1;
    this.h = paramy;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public ap a()
  {
    return this.f;
  }
  
  public at a(ap paramap)
  {
    return a(paramap, this.b, this.c, this.d);
  }
  
  public at a(ap paramap, okhttp3.internal.connection.g paramg, hd paramhd, c paramc)
  {
    if (this.e >= this.a.size()) {
      throw new AssertionError();
    }
    this.l += 1;
    if ((this.c != null) && (!this.d.a(paramap.a()))) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
    }
    if ((this.c != null) && (this.l > 1)) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
    }
    paramap = new hi(this.a, paramg, paramhd, paramc, this.e + 1, paramap, this.g, this.h, this.i, this.j, this.k);
    paramg = (ah)this.a.get(this.e);
    paramc = paramg.a(paramap);
    if ((paramhd != null) && (this.e + 1 < this.a.size()) && (paramap.l != 1)) {
      throw new IllegalStateException("network interceptor " + paramg + " must call proceed() exactly once");
    }
    if (paramc == null) {
      throw new NullPointerException("interceptor " + paramg + " returned null");
    }
    if (paramc.e() == null) {
      throw new IllegalStateException("interceptor " + paramg + " returned a response with no body");
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
  
  public n e()
  {
    return this.d;
  }
  
  public okhttp3.internal.connection.g f()
  {
    return this.b;
  }
  
  public hd g()
  {
    return this.c;
  }
  
  public okhttp3.g h()
  {
    return this.g;
  }
  
  public y i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hi
 * JD-Core Version:    0.7.0.1
 */