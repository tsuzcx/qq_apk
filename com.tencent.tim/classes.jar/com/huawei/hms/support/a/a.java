package com.huawei.hms.support.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class a
{
  public static Class<?> a(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramType).getRawType();
    }
    if ((paramType instanceof TypeVariable))
    {
      paramType = (TypeVariable)paramType;
      if (paramType.getBounds().length == 0) {
        return Object.class;
      }
      return a(paramType.getBounds()[0]);
    }
    throw new IllegalArgumentException("not supported: " + paramType.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.a.a
 * JD-Core Version:    0.7.0.1
 */