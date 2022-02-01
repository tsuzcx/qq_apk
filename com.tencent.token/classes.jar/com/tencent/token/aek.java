package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;
import java.lang.reflect.Type;

public class aek<T>
{
  public final Class<? super T> a;
  public final Type b;
  public final int c;
  
  public aek()
  {
    Type localType = getClass().getGenericSuperclass();
    if (!(localType instanceof Class))
    {
      localType = switch.a(((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0]);
      this.b = localType;
      this.a = switch.b(localType);
      this.c = localType.hashCode();
      return;
    }
    throw new RuntimeException("Missing type parameter.");
  }
  
  public aek(Type paramType)
  {
    paramType = switch.a((Type)ahr.a(paramType));
    this.b = paramType;
    this.a = switch.b(paramType);
    this.c = paramType.hashCode();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof aek)) && (switch.a(this.b, ((aek)paramObject).b));
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return switch.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aek
 * JD-Core Version:    0.7.0.1
 */