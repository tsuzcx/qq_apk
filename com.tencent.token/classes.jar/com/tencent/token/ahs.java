package com.tencent.token;

import com.tencent.turingfd.sdk.qps.break;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

public final class ahs
  implements acj<T>
{
  public ahs(Type paramType) {}
  
  public final T a()
  {
    Object localObject = this.a;
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
      if ((localObject instanceof Class)) {
        return EnumSet.noneOf((Class)localObject);
      }
      localObject = new StringBuilder("Invalid EnumSet type: ");
      ((StringBuilder)localObject).append(this.a.toString());
      throw new break(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder("Invalid EnumSet type: ");
    ((StringBuilder)localObject).append(this.a.toString());
    throw new break(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahs
 * JD-Core Version:    0.7.0.1
 */