package com.google.common.reflect;

import com.google.common.base.Function;
import java.lang.reflect.Type;

final class Types$1
  implements Function<Type, String>
{
  public String apply(Type paramType)
  {
    return Types.JavaVersion.CURRENT.typeName(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.1
 * JD-Core Version:    0.7.0.1
 */