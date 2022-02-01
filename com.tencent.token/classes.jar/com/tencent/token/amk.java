package com.tencent.token;

import java.util.List;

public final class amk
  implements ale.a
{
  public final amd a;
  final amg b;
  final alz c;
  public final alj d;
  final akq e;
  final ala f;
  private final List<ale> g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public amk(List<ale> paramList, amd paramamd, amg paramamg, alz paramalz, int paramInt1, alj paramalj, akq paramakq, ala paramala, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramList;
    this.c = paramalz;
    this.a = paramamd;
    this.b = paramamg;
    this.h = paramInt1;
    this.d = paramalj;
    this.e = paramakq;
    this.f = paramala;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public final alj a()
  {
    return this.d;
  }
  
  public final all a(alj paramalj)
  {
    return a(paramalj, this.a, this.b, this.c);
  }
  
  public final all a(alj paramalj, amd paramamd, amg paramamg, alz paramalz)
  {
    if (this.h < this.g.size())
    {
      this.l += 1;
      if ((this.b != null) && (!this.c.a(paramalj.a)))
      {
        paramalj = new StringBuilder("network interceptor ");
        paramalj.append(this.g.get(this.h - 1));
        paramalj.append(" must retain the same host and port");
        throw new IllegalStateException(paramalj.toString());
      }
      if ((this.b != null) && (this.l > 1))
      {
        paramalj = new StringBuilder("network interceptor ");
        paramalj.append(this.g.get(this.h - 1));
        paramalj.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramalj.toString());
      }
      paramamd = new amk(this.g, paramamd, paramamg, paramalz, this.h + 1, paramalj, this.e, this.f, this.i, this.j, this.k);
      paramalj = (ale)this.g.get(this.h);
      paramalz = paramalj.a(paramamd);
      if ((paramamg != null) && (this.h + 1 < this.g.size()) && (paramamd.l != 1))
      {
        paramamd = new StringBuilder("network interceptor ");
        paramamd.append(paramalj);
        paramamd.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramamd.toString());
      }
      if (paramalz != null)
      {
        if (paramalz.g != null) {
          return paramalz;
        }
        paramamd = new StringBuilder("interceptor ");
        paramamd.append(paramalj);
        paramamd.append(" returned a response with no body");
        throw new IllegalStateException(paramamd.toString());
      }
      paramamd = new StringBuilder("interceptor ");
      paramamd.append(paramalj);
      paramamd.append(" returned null");
      throw new NullPointerException(paramamd.toString());
    }
    throw new AssertionError();
  }
  
  public final int b()
  {
    return this.i;
  }
  
  public final int c()
  {
    return this.j;
  }
  
  public final int d()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amk
 * JD-Core Version:    0.7.0.1
 */