package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class TypeCapture<T>
{
  final Type capture()
  {
    Type localType = getClass().getGenericSuperclass();
    Preconditions.checkArgument(localType instanceof ParameterizedType, "%s isn't parameterized", localType);
    return ((ParameterizedType)localType).getActualTypeArguments()[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeCapture
 * JD-Core Version:    0.7.0.1
 */