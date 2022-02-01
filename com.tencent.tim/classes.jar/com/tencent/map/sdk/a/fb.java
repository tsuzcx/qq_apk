package com.tencent.map.sdk.a;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class fb<T>
  extends ee<T>
{
  private final dn a;
  private final ee<T> b;
  private final Type c;
  
  fb(dn paramdn, ee<T> paramee, Type paramType)
  {
    this.a = paramdn;
    this.b = paramee;
    this.c = paramType;
  }
  
  public final T a(fe paramfe)
    throws IOException
  {
    return this.b.a(paramfe);
  }
  
  public final void a(fg paramfg, T paramT)
    throws IOException
  {
    ee localee = this.b;
    Type localType = this.c;
    Object localObject = localType;
    if (paramT != null) {
      if ((localType != Object.class) && (!(localType instanceof TypeVariable)))
      {
        localObject = localType;
        if (!(localType instanceof Class)) {}
      }
      else
      {
        localObject = paramT.getClass();
      }
    }
    if (localObject != this.c)
    {
      localee = this.a.a(fd.a((Type)localObject));
      localObject = localee;
      if ((localee instanceof ey.a))
      {
        localObject = localee;
        if ((this.b instanceof ey.a)) {}
      }
    }
    for (localObject = this.b;; localObject = localee)
    {
      ((ee)localObject).a(paramfg, paramT);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fb
 * JD-Core Version:    0.7.0.1
 */