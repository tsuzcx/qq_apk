package com.tencent.token;

import java.util.List;

public final class ajp
  implements aij.a
{
  public final aji a;
  final ajl b;
  final aje c;
  public final aio d;
  final ahv e;
  final aif f;
  private final List<aij> g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public ajp(List<aij> paramList, aji paramaji, ajl paramajl, aje paramaje, int paramInt1, aio paramaio, ahv paramahv, aif paramaif, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramList;
    this.c = paramaje;
    this.a = paramaji;
    this.b = paramajl;
    this.h = paramInt1;
    this.d = paramaio;
    this.e = paramahv;
    this.f = paramaif;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public final aio a()
  {
    return this.d;
  }
  
  public final aiq a(aio paramaio)
  {
    return a(paramaio, this.a, this.b, this.c);
  }
  
  public final aiq a(aio paramaio, aji paramaji, ajl paramajl, aje paramaje)
  {
    if (this.h < this.g.size())
    {
      this.l += 1;
      if ((this.b != null) && (!this.c.a(paramaio.a)))
      {
        paramaio = new StringBuilder("network interceptor ");
        paramaio.append(this.g.get(this.h - 1));
        paramaio.append(" must retain the same host and port");
        throw new IllegalStateException(paramaio.toString());
      }
      if ((this.b != null) && (this.l > 1))
      {
        paramaio = new StringBuilder("network interceptor ");
        paramaio.append(this.g.get(this.h - 1));
        paramaio.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramaio.toString());
      }
      paramaji = new ajp(this.g, paramaji, paramajl, paramaje, this.h + 1, paramaio, this.e, this.f, this.i, this.j, this.k);
      paramaio = (aij)this.g.get(this.h);
      paramaje = paramaio.a(paramaji);
      if ((paramajl != null) && (this.h + 1 < this.g.size()) && (paramaji.l != 1))
      {
        paramaji = new StringBuilder("network interceptor ");
        paramaji.append(paramaio);
        paramaji.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramaji.toString());
      }
      if (paramaje != null)
      {
        if (paramaje.g != null) {
          return paramaje;
        }
        paramaji = new StringBuilder("interceptor ");
        paramaji.append(paramaio);
        paramaji.append(" returned a response with no body");
        throw new IllegalStateException(paramaji.toString());
      }
      paramaji = new StringBuilder("interceptor ");
      paramaji.append(paramaio);
      paramaji.append(" returned null");
      throw new NullPointerException(paramaji.toString());
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
 * Qualified Name:     com.tencent.token.ajp
 * JD-Core Version:    0.7.0.1
 */