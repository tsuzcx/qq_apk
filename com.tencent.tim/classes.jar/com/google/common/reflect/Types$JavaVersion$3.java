package com.google.common.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

 enum Types$JavaVersion$3
{
  Types$JavaVersion$3()
  {
    super(str, i, null);
  }
  
  Type newArrayType(Type paramType)
  {
    return JAVA7.newArrayType(paramType);
  }
  
  String typeName(Type paramType)
  {
    try
    {
      paramType = (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(paramType, new Object[0]);
      return paramType;
    }
    catch (NoSuchMethodException paramType)
    {
      throw new AssertionError("Type.getTypeName should be available in Java 8");
    }
    catch (InvocationTargetException paramType)
    {
      throw new RuntimeException(paramType);
    }
    catch (IllegalAccessException paramType)
    {
      throw new RuntimeException(paramType);
    }
  }
  
  Type usedInGenericType(Type paramType)
  {
    return JAVA7.usedInGenericType(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.JavaVersion.3
 * JD-Core Version:    0.7.0.1
 */