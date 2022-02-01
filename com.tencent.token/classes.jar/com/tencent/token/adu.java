package com.tencent.token;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class adu<T>
  extends ahh<T>
{
  public final ahx a;
  public final ahh<T> b;
  public final Type c;
  
  public adu(ahx paramahx, ahh<T> paramahh, Type paramType)
  {
    this.a = paramahx;
    this.b = paramahh;
    this.c = paramType;
  }
  
  public final void a(aep paramaep, T paramT)
  {
    ahh localahh = this.b;
    Object localObject2 = this.c;
    Object localObject1 = localObject2;
    if (paramT != null) {
      if ((localObject2 != Object.class) && (!(localObject2 instanceof TypeVariable)))
      {
        localObject1 = localObject2;
        if (!(localObject2 instanceof Class)) {}
      }
      else
      {
        localObject1 = paramT.getClass();
      }
    }
    if (localObject1 != this.c)
    {
      localahh = this.a.a(new aek((Type)localObject1));
      if ((localahh instanceof adj.a))
      {
        localObject2 = this.b;
        localObject1 = localObject2;
        if (!(localObject2 instanceof adj.a)) {}
      }
      else
      {
        localObject1 = localahh;
      }
    }
    else
    {
      localObject1 = localahh;
    }
    ((ahh)localObject1).a(paramaep, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adu
 * JD-Core Version:    0.7.0.1
 */