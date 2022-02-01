package com.tencent.token;

import java.util.List;

public final class ajq
  implements aik.a
{
  public final ajj a;
  final ajm b;
  final ajf c;
  public final aip d;
  final ahw e;
  final aig f;
  private final List<aik> g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public ajq(List<aik> paramList, ajj paramajj, ajm paramajm, ajf paramajf, int paramInt1, aip paramaip, ahw paramahw, aig paramaig, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramList;
    this.c = paramajf;
    this.a = paramajj;
    this.b = paramajm;
    this.h = paramInt1;
    this.d = paramaip;
    this.e = paramahw;
    this.f = paramaig;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public final aip a()
  {
    return this.d;
  }
  
  public final air a(aip paramaip)
  {
    return a(paramaip, this.a, this.b, this.c);
  }
  
  public final air a(aip paramaip, ajj paramajj, ajm paramajm, ajf paramajf)
  {
    if (this.h < this.g.size())
    {
      this.l += 1;
      if ((this.b != null) && (!this.c.a(paramaip.a)))
      {
        paramaip = new StringBuilder("network interceptor ");
        paramaip.append(this.g.get(this.h - 1));
        paramaip.append(" must retain the same host and port");
        throw new IllegalStateException(paramaip.toString());
      }
      if ((this.b != null) && (this.l > 1))
      {
        paramaip = new StringBuilder("network interceptor ");
        paramaip.append(this.g.get(this.h - 1));
        paramaip.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramaip.toString());
      }
      paramajj = new ajq(this.g, paramajj, paramajm, paramajf, this.h + 1, paramaip, this.e, this.f, this.i, this.j, this.k);
      paramaip = (aik)this.g.get(this.h);
      paramajf = paramaip.a(paramajj);
      if ((paramajm != null) && (this.h + 1 < this.g.size()) && (paramajj.l != 1))
      {
        paramajj = new StringBuilder("network interceptor ");
        paramajj.append(paramaip);
        paramajj.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramajj.toString());
      }
      if (paramajf != null)
      {
        if (paramajf.g != null) {
          return paramajf;
        }
        paramajj = new StringBuilder("interceptor ");
        paramajj.append(paramaip);
        paramajj.append(" returned a response with no body");
        throw new IllegalStateException(paramajj.toString());
      }
      paramajj = new StringBuilder("interceptor ");
      paramajj.append(paramaip);
      paramajj.append(" returned null");
      throw new NullPointerException(paramajj.toString());
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
 * Qualified Name:     com.tencent.token.ajq
 * JD-Core Version:    0.7.0.1
 */