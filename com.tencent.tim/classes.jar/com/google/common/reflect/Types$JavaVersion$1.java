package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

 enum Types$JavaVersion$1
{
  Types$JavaVersion$1()
  {
    super(str, i, null);
  }
  
  GenericArrayType newArrayType(Type paramType)
  {
    return new Types.GenericArrayTypeImpl(paramType);
  }
  
  Type usedInGenericType(Type paramType)
  {
    Preconditions.checkNotNull(paramType);
    Object localObject = paramType;
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      localObject = paramType;
      if (localClass.isArray()) {
        localObject = new Types.GenericArrayTypeImpl(localClass.getComponentType());
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.JavaVersion.1
 * JD-Core Version:    0.7.0.1
 */