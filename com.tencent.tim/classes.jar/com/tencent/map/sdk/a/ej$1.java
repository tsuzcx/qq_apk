package com.tencent.map.sdk.a;

import java.io.IOException;

final class ej$1
  extends ee<T>
{
  private ee<T> f;
  
  ej$1(ej paramej, boolean paramBoolean1, boolean paramBoolean2, dn paramdn, fd paramfd) {}
  
  private ee<T> a()
  {
    ee localee = this.f;
    if (localee != null) {
      return localee;
    }
    localee = this.c.a(this.e, this.d);
    this.f = localee;
    return localee;
  }
  
  public final T a(fe paramfe)
    throws IOException
  {
    if (this.a)
    {
      paramfe.o();
      return null;
    }
    return a().a(paramfe);
  }
  
  public final void a(fg paramfg, T paramT)
    throws IOException
  {
    if (this.b)
    {
      paramfg.e();
      return;
    }
    a().a(paramfg, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ej.1
 * JD-Core Version:    0.7.0.1
 */