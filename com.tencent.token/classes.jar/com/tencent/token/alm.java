package com.tencent.token;

import java.util.List;

public final class alm
  implements akg.a
{
  public final alf a;
  final ali b;
  final alb c;
  public final akl d;
  final ajs e;
  final akc f;
  private final List<akg> g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public alm(List<akg> paramList, alf paramalf, ali paramali, alb paramalb, int paramInt1, akl paramakl, ajs paramajs, akc paramakc, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramList;
    this.c = paramalb;
    this.a = paramalf;
    this.b = paramali;
    this.h = paramInt1;
    this.d = paramakl;
    this.e = paramajs;
    this.f = paramakc;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public final akl a()
  {
    return this.d;
  }
  
  public final akn a(akl paramakl)
  {
    return a(paramakl, this.a, this.b, this.c);
  }
  
  public final akn a(akl paramakl, alf paramalf, ali paramali, alb paramalb)
  {
    if (this.h < this.g.size())
    {
      this.l += 1;
      if ((this.b != null) && (!this.c.a(paramakl.a)))
      {
        paramakl = new StringBuilder("network interceptor ");
        paramakl.append(this.g.get(this.h - 1));
        paramakl.append(" must retain the same host and port");
        throw new IllegalStateException(paramakl.toString());
      }
      if ((this.b != null) && (this.l > 1))
      {
        paramakl = new StringBuilder("network interceptor ");
        paramakl.append(this.g.get(this.h - 1));
        paramakl.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramakl.toString());
      }
      paramalf = new alm(this.g, paramalf, paramali, paramalb, this.h + 1, paramakl, this.e, this.f, this.i, this.j, this.k);
      paramakl = (akg)this.g.get(this.h);
      paramalb = paramakl.a(paramalf);
      if ((paramali != null) && (this.h + 1 < this.g.size()) && (paramalf.l != 1))
      {
        paramalf = new StringBuilder("network interceptor ");
        paramalf.append(paramakl);
        paramalf.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramalf.toString());
      }
      if (paramalb != null)
      {
        if (paramalb.g != null) {
          return paramalb;
        }
        paramalf = new StringBuilder("interceptor ");
        paramalf.append(paramakl);
        paramalf.append(" returned a response with no body");
        throw new IllegalStateException(paramalf.toString());
      }
      paramalf = new StringBuilder("interceptor ");
      paramalf.append(paramakl);
      paramalf.append(" returned null");
      throw new NullPointerException(paramalf.toString());
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
 * Qualified Name:     com.tencent.token.alm
 * JD-Core Version:    0.7.0.1
 */