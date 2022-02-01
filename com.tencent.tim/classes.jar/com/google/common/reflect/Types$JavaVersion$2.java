package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;

 enum Types$JavaVersion$2
{
  Types$JavaVersion$2()
  {
    super(str, i, null);
  }
  
  Type newArrayType(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return Types.getArrayClass((Class)paramType);
    }
    return new Types.GenericArrayTypeImpl(paramType);
  }
  
  Type usedInGenericType(Type paramType)
  {
    return (Type)Preconditions.checkNotNull(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.JavaVersion.2
 * JD-Core Version:    0.7.0.1
 */